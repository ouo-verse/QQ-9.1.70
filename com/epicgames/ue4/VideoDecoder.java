package com.epicgames.ue4;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.ark.EGLContextHolder;
import com.tencent.filter.GLSLRender;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.AbstractMap;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class VideoDecoder {
    private byte[] PPS;
    private byte[] SPS;
    private boolean SupportsImageExternal;
    private boolean SwizzlePixels;
    private boolean VulkanRenderer;
    private volatile boolean WaitOnBitmapRender;
    private int FrameWidth = 0;
    private int FrameHeight = 0;
    private BitmapRenderer mBitmapRenderer = null;
    private OESTextureRenderer mOESTextureRenderer = null;
    private MediaCodec mVideoCodec = null;
    private MediaCodec mAudioCodec = null;
    private Surface mVideoCodecSurface = null;
    private boolean isEOS = false;
    private boolean bIsInitialized = false;
    private volatile boolean NewFrameAvailable = true;
    LinkedList<Map.Entry<Double, Double>> frameTimeDurationList = new LinkedList<>();

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class FrameUpdateInfo {
        public Buffer Buffer;
        public double Duration;
        public boolean FrameReady;
        public boolean RegionChanged;
        public double Timestamp;
        public float UOffset;
        public float UScale;
        public float VOffset;
        public float VScale;

        public FrameUpdateInfo() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class OESTextureRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private Surface mSurface;
        private SurfaceTexture mSurfaceTexture;
        private int mTextureID;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private boolean mFrameAvailable = false;
        private float[] mTransformMatrix = new float[16];
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private float mUScale = 1.0f;
        private float mVScale = -1.0f;
        private float mUOffset = 0.0f;
        private float mVOffset = 1.0f;

        public OESTextureRenderer(int i3) {
            this.mSurfaceTexture = null;
            this.mSurface = null;
            this.mTextureID = i3;
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
        }

        private FrameUpdateInfo getFrameUpdateInfo() {
            FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
            frameUpdateInfo.FrameReady = false;
            frameUpdateInfo.RegionChanged = false;
            frameUpdateInfo.UScale = this.mUScale;
            frameUpdateInfo.UOffset = this.mUOffset;
            frameUpdateInfo.VScale = -this.mVScale;
            frameUpdateInfo.VOffset = 1.0f - this.mVOffset;
            if (!this.mFrameAvailable) {
                return frameUpdateInfo;
            }
            this.mFrameAvailable = false;
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture == null) {
                return frameUpdateInfo;
            }
            frameUpdateInfo.FrameReady = true;
            surfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float f16 = this.mUScale;
            float[] fArr = this.mTransformMatrix;
            float f17 = fArr[0];
            if (f16 != f17 || this.mVScale != fArr[5] || this.mUOffset != fArr[12] || this.mVOffset != fArr[13]) {
                this.mUScale = f17;
                float f18 = fArr[5];
                this.mVScale = f18;
                float f19 = fArr[12];
                this.mUOffset = f19;
                float f26 = fArr[13];
                this.mVOffset = f26;
                frameUpdateInfo.RegionChanged = true;
                frameUpdateInfo.UScale = f17;
                frameUpdateInfo.UOffset = f19;
                frameUpdateInfo.VScale = -f18;
                frameUpdateInfo.VOffset = 1.0f - f26;
            }
            VideoDecoder videoDecoder = VideoDecoder.this;
            Map.Entry<Double, Double> frameTimeDuration = videoDecoder.getFrameTimeDuration(videoDecoder.getFrameTimestamp());
            frameUpdateInfo.Timestamp = frameTimeDuration.getKey().doubleValue();
            frameUpdateInfo.Duration = frameTimeDuration.getValue().doubleValue();
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, 0);
            return frameUpdateInfo;
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            if (this.mSurfaceTexture != null) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
        }

        public boolean resolutionChanged() {
            boolean z16;
            synchronized (this) {
                z16 = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z16;
        }

        public void setSize(int i3, int i16) {
            synchronized (this) {
                if (i3 != this.mTextureWidth || i16 != this.mTextureHeight) {
                    this.mTextureWidth = i3;
                    this.mTextureHeight = i16;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateVideoFrame() {
            FrameUpdateInfo frameUpdateInfo;
            synchronized (this) {
                frameUpdateInfo = getFrameUpdateInfo();
            }
            return frameUpdateInfo;
        }
    }

    public VideoDecoder(boolean z16, boolean z17, boolean z18) {
        this.SwizzlePixels = true;
        this.VulkanRenderer = false;
        this.SupportsImageExternal = false;
        this.WaitOnBitmapRender = false;
        this.SwizzlePixels = z16;
        this.VulkanRenderer = z17;
        this.SupportsImageExternal = z18;
        this.WaitOnBitmapRender = false;
    }

    private boolean CreateBitmapRenderer() {
        releaseBitmapRenderer();
        BitmapRenderer bitmapRenderer = new BitmapRenderer(this.SwizzlePixels, this.VulkanRenderer);
        this.mBitmapRenderer = bitmapRenderer;
        if (!bitmapRenderer.isValid()) {
            this.mBitmapRenderer = null;
            return false;
        }
        this.mBitmapRenderer.setSize(this.FrameWidth, this.FrameHeight);
        this.mVideoCodecSurface = this.mBitmapRenderer.getSurface();
        CreateCodec();
        return true;
    }

    private boolean CreateCodec() {
        try {
            this.mVideoCodec = MediaCodec.createDecoderByType("video/avc");
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", this.FrameWidth, this.FrameHeight);
            createVideoFormat.setByteBuffer("csd-0", getSPSPPSHeader());
            createVideoFormat.setInteger("max-input-size", this.FrameWidth * this.FrameHeight);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("frame-rate", 30);
            createVideoFormat.setInteger("capture-rate", 30);
            this.isEOS = false;
            this.mVideoCodec.configure(createVideoFormat, this.mVideoCodecSurface, (MediaCrypto) null, 0);
            this.mVideoCodec.start();
            this.bIsInitialized = true;
            return true;
        } catch (Exception e16) {
            UE4.Log.warn("Android Video Decoder: CreateCodec failed!");
            e16.printStackTrace();
            return false;
        }
    }

    private boolean CreateOESTextureRenderer(int i3) {
        releaseOESTextureRenderer();
        OESTextureRenderer oESTextureRenderer = new OESTextureRenderer(i3);
        this.mOESTextureRenderer = oESTextureRenderer;
        if (!oESTextureRenderer.isValid()) {
            this.mOESTextureRenderer = null;
            return false;
        }
        this.mOESTextureRenderer.setSize(this.FrameWidth, this.FrameHeight);
        this.mVideoCodecSurface = this.mOESTextureRenderer.getSurface();
        CreateCodec();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public double getFrameTimestamp() {
        SurfaceTexture surfaceTexture;
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            surfaceTexture = oESTextureRenderer.getSurfaceTexture();
        } else {
            surfaceTexture = null;
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            surfaceTexture = bitmapRenderer.getSurfaceTexture();
        }
        if (surfaceTexture != null) {
            return surfaceTexture.getTimestamp() / 1000;
        }
        return -1.0d;
    }

    private ByteBuffer getSPSPPSHeader() {
        byte[] bArr = {0, 0, 0, 1};
        ByteBuffer allocate = ByteBuffer.allocate(this.SPS.length + this.PPS.length + 8);
        allocate.put(bArr);
        allocate.put(this.SPS);
        allocate.put(bArr);
        allocate.put(this.PPS);
        return allocate;
    }

    @SuppressLint({"NewApi"})
    public boolean DecodeVideo(byte[] bArr, double d16, double d17) {
        boolean z16;
        if (this.mVideoCodec != null) {
            try {
                synchronized (this) {
                    int dequeueInputBuffer = this.mVideoCodec.dequeueInputBuffer(-1L);
                    if (dequeueInputBuffer >= 0) {
                        int length = bArr.length;
                        ByteBuffer inputBuffer = this.mVideoCodec.getInputBuffer(dequeueInputBuffer);
                        inputBuffer.clear();
                        inputBuffer.put(bArr);
                        inputBuffer.clear();
                        this.mVideoCodec.queueInputBuffer(dequeueInputBuffer, 0, length, (long) d16, 0);
                    }
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    int dequeueOutputBuffer = this.mVideoCodec.dequeueOutputBuffer(bufferInfo, -1L);
                    if (dequeueOutputBuffer != -3) {
                        if (dequeueOutputBuffer != -2) {
                            if (dequeueOutputBuffer != -1) {
                                addFrameTimeDuration(d16, d17);
                                if (bufferInfo.size != 0 && (bufferInfo.flags & 2) != 2) {
                                    z16 = true;
                                } else {
                                    z16 = false;
                                }
                                this.mVideoCodec.releaseOutputBuffer(dequeueOutputBuffer, z16);
                            } else {
                                UE4.Log.debug("Android Video Decoder: dequeueOutputBuffer timed out!");
                            }
                        } else {
                            UE4.Log.debug("Android Video Decoder: New format" + this.mVideoCodec.getOutputFormat());
                        }
                    } else {
                        UE4.Log.debug("Android Video Decoder: INFO_OUTPUT_BUFFERS_CHANGED");
                    }
                    if ((bufferInfo.flags & 4) != 0) {
                        UE4.Log.warn("OutputBuffer BUFFER_FLAG_END_OF_STREAM");
                    }
                }
                return true;
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    void addFrameTimeDuration(double d16, double d17) {
        synchronized (this) {
            this.frameTimeDurationList.add(new AbstractMap.SimpleEntry(Double.valueOf(d16), Double.valueOf(d17)));
        }
    }

    public boolean didResolutionChange() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.resolutionChanged();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.resolutionChanged();
        }
        return false;
    }

    public int getExternalTextureId() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            return oESTextureRenderer.getExternalTextureId();
        }
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            return bitmapRenderer.getExternalTextureId();
        }
        return -1;
    }

    Map.Entry<Double, Double> getFrameTimeDuration(double d16) {
        Map.Entry simpleEntry = new AbstractMap.SimpleEntry(Double.valueOf(d16), Double.valueOf(100.0d));
        synchronized (this) {
            ListIterator<Map.Entry<Double, Double>> listIterator = this.frameTimeDurationList.listIterator();
            while (listIterator.hasNext()) {
                Map.Entry next = listIterator.next();
                double abs = Math.abs(((Double) simpleEntry.getKey()).doubleValue() - d16);
                if (d16 > 0.0d && ((Double) next.getKey()).doubleValue() != d16) {
                    if (abs != 0.0d && abs > Math.abs(d16 - ((Double) next.getKey()).doubleValue())) {
                        simpleEntry = next;
                    }
                }
                simpleEntry = next;
            }
        }
        this.frameTimeDurationList.remove(simpleEntry);
        return simpleEntry;
    }

    public FrameUpdateInfo getVideoLastFrame(int i3) {
        initBitmapRenderer();
        if (this.mBitmapRenderer != null) {
            this.WaitOnBitmapRender = true;
            FrameUpdateInfo updateFrameData = this.mBitmapRenderer.updateFrameData(i3);
            this.WaitOnBitmapRender = false;
            return updateFrameData;
        }
        return null;
    }

    public FrameUpdateInfo getVideoLastFrameData() {
        initBitmapRenderer();
        if (this.mBitmapRenderer != null) {
            this.WaitOnBitmapRender = true;
            FrameUpdateInfo updateFrameData = this.mBitmapRenderer.updateFrameData();
            this.WaitOnBitmapRender = false;
            return updateFrameData;
        }
        return null;
    }

    public void initBitmapRenderer() {
        if (this.mBitmapRenderer == null && !CreateBitmapRenderer()) {
            UE4.Log.warn("initBitmapRenderer failed to alloc mBitmapRenderer ");
            release();
        }
    }

    public boolean isCodecReady() {
        return this.bIsInitialized;
    }

    public native void nativeClearCachedAttributeState(int i3, int i16);

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0012, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0015, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0018, code lost:
    
        resetCodec();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001b, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0002, code lost:
    
        if (r1.mOESTextureRenderer != null) goto L4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0006, code lost:
    
        if (r1.WaitOnBitmapRender == false) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
    
        releaseOESTextureRenderer();
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        if (r1.mBitmapRenderer == null) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void release() {
    }

    void releaseBitmapRenderer() {
        BitmapRenderer bitmapRenderer = this.mBitmapRenderer;
        if (bitmapRenderer != null) {
            bitmapRenderer.release();
            this.mBitmapRenderer = null;
        }
    }

    void releaseOESTextureRenderer() {
        OESTextureRenderer oESTextureRenderer = this.mOESTextureRenderer;
        if (oESTextureRenderer != null) {
            oESTextureRenderer.release();
            this.mOESTextureRenderer = null;
        }
    }

    public void resetCodec() {
        synchronized (this) {
            MediaCodec mediaCodec = this.mVideoCodec;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    this.mVideoCodec.release();
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    public boolean updateConfig(int i3, int i16, byte[] bArr, byte[] bArr2) {
        this.bIsInitialized = false;
        this.FrameWidth = i3;
        this.FrameHeight = i16;
        this.SPS = bArr;
        this.PPS = bArr2;
        if (this.mVideoCodec == null) {
            return true;
        }
        resetCodec();
        return CreateCodec();
    }

    public FrameUpdateInfo updateVideoFrame(int i3) {
        if (this.mOESTextureRenderer == null && !CreateOESTextureRenderer(i3)) {
            UE4.Log.warn("updateVideoFrame failed to alloc mOESTextureRenderer ");
            release();
            return null;
        }
        this.WaitOnBitmapRender = true;
        FrameUpdateInfo updateVideoFrame = this.mOESTextureRenderer.updateVideoFrame();
        this.WaitOnBitmapRender = false;
        return updateVideoFrame;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class BitmapRenderer implements SurfaceTexture.OnFrameAvailableListener {
        private static final int FLOAT_SIZE_BYTES = 4;
        private static final int TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        private static final int TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 16;
        private static final int TRIANGLE_VERTICES_DATA_UV_OFFSET = 2;
        private int mBlitBuffer;
        private EGLDisplay mEglDisplay;
        private int mPositionAttrib;
        private int mProgram;
        private EGLContext mSavedContext;
        private EGLDisplay mSavedDisplay;
        private EGLSurface mSavedSurfaceDraw;
        private EGLSurface mSavedSurfaceRead;
        private boolean mSwizzlePixels;
        private int mTexCoordsAttrib;
        private int mTextureUniform;
        private FloatBuffer mTriangleVertices;
        private boolean mUseOwnContext;
        private boolean mVulkanRenderer;
        private Buffer mFrameData = null;
        private SurfaceTexture mSurfaceTexture = null;
        private int mTextureWidth = -1;
        private int mTextureHeight = -1;
        private Surface mSurface = null;
        private boolean mFrameAvailable = false;
        private int mTextureID = -1;
        private int mFBO = -1;
        private int mBlitVertexShaderID = -1;
        private int mBlitFragmentShaderID = -1;
        private float[] mTransformMatrix = new float[16];
        private boolean mTriangleVerticesDirty = true;
        private boolean mTextureSizeChanged = true;
        private int GL_TEXTURE_EXTERNAL_OES = 36197;
        private boolean mCreatedEGLDisplay = false;
        private float[] mTriangleVerticesData = {-1.0f, -1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f};
        private final String mBlitVextexShader = "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n";
        private final String mBlitFragmentShaderBGRA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
        private final String mBlitFragmentShaderRGBA = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
        private EGLSurface mEglSurface = EGL14.EGL_NO_SURFACE;
        private EGLContext mEglContext = EGL14.EGL_NO_CONTEXT;

        public BitmapRenderer(boolean z16, boolean z17) {
            this.mUseOwnContext = true;
            this.mSwizzlePixels = z16;
            this.mVulkanRenderer = z17;
            this.mUseOwnContext = true;
            if (z17) {
                this.mSwizzlePixels = true;
                UE4.Log.debug("BitmapRenderer: mSwizzlePixels");
            } else {
                String glGetString = GLES20.glGetString(7937);
                UE4.Log.debug("BitmapRenderer 2" + glGetString);
                if (glGetString.contains("Adreno (TM) ") && Integer.parseInt(glGetString.substring(12)) < 400) {
                    UE4.Log.debug("VideoDecoder: disabled shared GL context on " + glGetString);
                    this.mUseOwnContext = false;
                }
            }
            if (this.mUseOwnContext) {
                UE4.Log.debug("BitmapRenderer 3");
                initContext();
                UE4.Log.debug("BitmapRenderer 4");
                saveContext();
                UE4.Log.debug("BitmapRenderer 5");
                makeCurrent();
                UE4.Log.debug("BitmapRenderer 6");
                initSurfaceTexture();
                UE4.Log.debug("BitmapRenderer 7");
                restoreContext();
            } else {
                UE4.Log.debug("BitmapRenderer 8");
                initSurfaceTexture();
            }
            UE4.Log.debug("BitmapRenderer 9");
        }

        private void UpdateVertexData() {
            if (this.mTriangleVerticesDirty && this.mBlitBuffer > 0) {
                this.mTriangleVertices.position(0);
                this.mTriangleVertices.put(this.mTriangleVerticesData).position(0);
                int[] iArr = new int[1];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i3 = iArr[0];
                GLES20.glBindBuffer(34962, this.mBlitBuffer);
                GLES20.glBufferData(34962, this.mTriangleVerticesData.length * 4, this.mTriangleVertices, 35044);
                GLES20.glBindBuffer(34962, i3);
                this.mTriangleVerticesDirty = false;
            }
        }

        private boolean copyFrameTexture(int i3, Buffer buffer) {
            int i16;
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            int i17;
            boolean z27;
            int i18;
            int i19;
            int i26;
            int i27;
            int i28;
            int i29;
            int i36;
            int i37;
            char c16;
            if (!this.mFrameAvailable) {
                return false;
            }
            this.mFrameAvailable = false;
            if (this.mSurfaceTexture == null) {
                return false;
            }
            int[] iArr = new int[1];
            int[] iArr2 = new int[4];
            if (this.mUseOwnContext) {
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10241, iArr, 0);
                int i38 = iArr[0];
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10240, iArr, 0);
                int i39 = iArr[0];
                saveContext();
                makeCurrent();
                i16 = i39;
                i19 = 0;
                z27 = false;
                z26 = false;
                z19 = false;
                z18 = false;
                z17 = false;
                z16 = false;
                i17 = i38;
                i18 = 0;
            } else {
                GLES20.glGetError();
                boolean glIsEnabled = GLES20.glIsEnabled(3042);
                boolean glIsEnabled2 = GLES20.glIsEnabled(2884);
                boolean glIsEnabled3 = GLES20.glIsEnabled(3089);
                boolean glIsEnabled4 = GLES20.glIsEnabled(2960);
                boolean glIsEnabled5 = GLES20.glIsEnabled(2929);
                boolean glIsEnabled6 = GLES20.glIsEnabled(3024);
                GLES20.glGetIntegerv(36006, iArr, 0);
                int i46 = iArr[0];
                GLES20.glGetIntegerv(34964, iArr, 0);
                int i47 = iArr[0];
                GLES20.glGetIntegerv(2978, iArr2, 0);
                GLES20.glActiveTexture(33984);
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10241, iArr, 0);
                int i48 = iArr[0];
                GLES20.glGetTexParameteriv(GLSLRender.GL_TEXTURE_2D, 10240, iArr, 0);
                int i49 = iArr[0];
                glVerify("save state");
                i16 = i49;
                z16 = glIsEnabled6;
                z17 = glIsEnabled5;
                z18 = glIsEnabled4;
                z19 = glIsEnabled3;
                z26 = glIsEnabled2;
                i17 = i48;
                z27 = glIsEnabled;
                i18 = i47;
                i19 = i46;
            }
            this.mSurfaceTexture.updateTexImage();
            this.mSurfaceTexture.getTransformMatrix(this.mTransformMatrix);
            float[] fArr = this.mTransformMatrix;
            float f16 = fArr[12];
            float f17 = f16 + fArr[0];
            float f18 = fArr[13];
            float f19 = f18 + fArr[5];
            float[] fArr2 = this.mTriangleVerticesData;
            if (fArr2[2] != f16 || fArr2[6] != f17 || fArr2[11] != f18 || fArr2[3] != f19) {
                fArr2[10] = f16;
                fArr2[2] = f16;
                fArr2[14] = f17;
                fArr2[6] = f17;
                fArr2[15] = f18;
                fArr2[11] = f18;
                fArr2[7] = f19;
                fArr2[3] = f19;
                this.mTriangleVerticesDirty = true;
            }
            if (buffer != null) {
                buffer.position(0);
            }
            if (!this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
                glVerify("reset state");
            }
            GLES20.glViewport(0, 0, this.mTextureWidth, this.mTextureHeight);
            glVerify("set viewport");
            if (buffer != null) {
                GLES20.glGenTextures(1, iArr, 0);
                i26 = iArr[0];
            } else {
                i26 = i3;
            }
            GLES20.glBindTexture(GLSLRender.GL_TEXTURE_2D, i26);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10241, 9728);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10240, 9728);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10242, 33071);
            GLES20.glTexParameteri(GLSLRender.GL_TEXTURE_2D, 10243, 33071);
            if (buffer != null) {
                GLES20.glTexImage2D(GLSLRender.GL_TEXTURE_2D, 0, 6408, this.mTextureWidth, this.mTextureHeight, 0, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, null);
            }
            glVerify("set-up FBO texture");
            GLES20.glBindFramebuffer(36160, this.mFBO);
            glVerify("glBindFramebuffer");
            GLES20.glFramebufferTexture2D(36160, 36064, GLSLRender.GL_TEXTURE_2D, i26, 0);
            int glCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
            if (glCheckFramebufferStatus != 36053) {
                UE4.Log.warn("Failed to complete framebuffer attachment (" + glCheckFramebufferStatus + ")");
            }
            GLES20.glUseProgram(this.mProgram);
            UpdateVertexData();
            GLES20.glBindBuffer(34962, this.mBlitBuffer);
            GLES20.glEnableVertexAttribArray(this.mPositionAttrib);
            GLES20.glVertexAttribPointer(this.mPositionAttrib, 2, 5126, false, 16, 0);
            GLES20.glEnableVertexAttribArray(this.mTexCoordsAttrib);
            GLES20.glVertexAttribPointer(this.mTexCoordsAttrib, 2, 5126, false, 16, 8);
            glVerify("setup movie texture read");
            GLES20.glClearColor(1.0f, 1.0f, 1.0f, 0.0f);
            GLES20.glClear(16384);
            GLES20.glUniform1i(this.mTextureUniform, 0);
            GLES20.glActiveTexture(33984);
            GLES20.glBindTexture(this.GL_TEXTURE_EXTERNAL_OES, this.mTextureID);
            GLES20.glDrawArrays(5, 0, 4);
            GLES20.glFlush();
            if (buffer != null) {
                int i56 = this.mTextureWidth;
                int i57 = this.mTextureHeight;
                i27 = i18;
                i28 = i16;
                i37 = GLSLRender.GL_TEXTURE_2D;
                i29 = i17;
                i36 = i26;
                GLES20.glReadPixels(0, 0, i56, i57, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, buffer);
            } else {
                i27 = i18;
                i28 = i16;
                i29 = i17;
                i36 = i26;
                i37 = GLSLRender.GL_TEXTURE_2D;
            }
            glVerify("draw & read movie texture");
            if (this.mUseOwnContext) {
                GLES20.glFramebufferTexture2D(36160, 36064, i37, 0, 0);
                if (buffer != null && i36 > 0) {
                    iArr[0] = i36;
                    GLES20.glDeleteTextures(1, iArr, 0);
                }
                restoreContext();
                GLES20.glTexParameteri(i37, 10241, i29);
                GLES20.glTexParameteri(i37, 10240, i28);
                return true;
            }
            int i58 = i29;
            GLES20.glBindFramebuffer(36160, i19);
            if (buffer != null && i36 > 0) {
                iArr[0] = i36;
                c16 = 1;
                GLES20.glDeleteTextures(1, iArr, 0);
            } else {
                c16 = 1;
            }
            GLES20.glBindBuffer(34962, i27);
            GLES20.glViewport(iArr2[0], iArr2[c16], iArr2[2], iArr2[3]);
            if (z27) {
                GLES20.glEnable(3042);
            }
            if (z26) {
                GLES20.glEnable(2884);
            }
            if (z19) {
                GLES20.glEnable(3089);
            }
            if (z18) {
                GLES20.glEnable(2960);
            }
            if (z17) {
                GLES20.glEnable(2929);
            }
            if (z16) {
                GLES20.glEnable(3024);
            }
            GLES20.glTexParameteri(i37, 10241, i58);
            GLES20.glTexParameteri(i37, 10240, i28);
            GLES20.glDisableVertexAttribArray(this.mPositionAttrib);
            GLES20.glDisableVertexAttribArray(this.mTexCoordsAttrib);
            VideoDecoder.this.nativeClearCachedAttributeState(this.mPositionAttrib, this.mTexCoordsAttrib);
            return true;
        }

        private int createShader(int i3, String str) {
            int glCreateShader = GLES20.glCreateShader(i3);
            if (glCreateShader != 0) {
                GLES20.glShaderSource(glCreateShader, str);
                GLES20.glCompileShader(glCreateShader);
                int[] iArr = new int[1];
                GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
                if (iArr[0] == 0) {
                    UE4.Log.error("Could not compile shader " + i3 + ":");
                    UE4.Log.error(GLES20.glGetShaderInfoLog(glCreateShader));
                    GLES20.glDeleteShader(glCreateShader);
                    return 0;
                }
                return glCreateShader;
            }
            return glCreateShader;
        }

        private void glVerify(String str) {
            int glGetError = GLES20.glGetError();
            if (glGetError == 0) {
                return;
            }
            showGlError(str, glGetError);
            throw new RuntimeException(str + ": glGetError " + glGetError);
        }

        private void glWarn(String str) {
            while (true) {
                int glGetError = GLES20.glGetError();
                if (glGetError != 0) {
                    showGlError(str, glGetError);
                } else {
                    return;
                }
            }
        }

        private void initContext() {
            this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
            EGLContext eGLContext = EGL14.EGL_NO_CONTEXT;
            int[] iArr = {0};
            int[] iArr2 = {0};
            if (!this.mVulkanRenderer) {
                this.mEglDisplay = EGL14.eglGetCurrentDisplay();
                eGLContext = EGL14.eglGetCurrentContext();
                if (EGL14.eglQueryContext(this.mEglDisplay, eGLContext, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr, 0) && EGL14.eglQueryContext(this.mEglDisplay, eGLContext, 12539, iArr2, 0)) {
                    UE4.Log.debug("VideoDecoder: Existing GL context is version " + iArr[0] + "." + iArr2[0]);
                } else if (EGL14.eglQueryContext(this.mEglDisplay, eGLContext, EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, iArr, 0)) {
                    UE4.Log.debug("VideoDecoder: Existing GL context is version " + iArr[0]);
                } else {
                    UE4.Log.debug("VideoDecoder: Existing GL context version not detected");
                }
            } else {
                EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
                this.mEglDisplay = eglGetDisplay;
                if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
                    UE4.Log.error("unable to get EGL14 display");
                    return;
                }
                int[] iArr3 = new int[2];
                if (!EGL14.eglInitialize(eglGetDisplay, iArr3, 0, iArr3, 1)) {
                    this.mEglDisplay = null;
                    UE4.Log.error("unable to initialize EGL14 display");
                    return;
                }
                this.mCreatedEGLDisplay = true;
            }
            EGLConfig[] eGLConfigArr = new EGLConfig[1];
            EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
            int[] iArr4 = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
            int[] iArr5 = {EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 3, 12539, 1, 12344};
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLConfig eGLConfig = eGLConfigArr[0];
            if (iArr[0] == 3) {
                iArr4 = iArr5;
            }
            this.mEglContext = EGL14.eglCreateContext(eGLDisplay, eGLConfig, eGLContext, iArr4, 0);
            if (EGL14.eglQueryString(this.mEglDisplay, 12373).contains("EGL_KHR_surfaceless_context")) {
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            } else {
                this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{12344}, 0);
            }
        }

        private void initSurfaceTexture() {
            String str;
            int[] iArr = new int[1];
            GLES20.glGenTextures(1, iArr, 0);
            int i3 = iArr[0];
            this.mTextureID = i3;
            if (i3 <= 0) {
                UE4.Log.error("mTextureID <= 0");
                release();
                return;
            }
            SurfaceTexture surfaceTexture = new SurfaceTexture(this.mTextureID);
            this.mSurfaceTexture = surfaceTexture;
            surfaceTexture.setOnFrameAvailableListener(this);
            this.mSurface = new Surface(this.mSurfaceTexture);
            int[] iArr2 = new int[1];
            GLES20.glGenFramebuffers(1, iArr2, 0);
            int i16 = iArr2[0];
            this.mFBO = i16;
            if (i16 <= 0) {
                UE4.Log.error("mFBO <= 0");
                release();
                return;
            }
            int createShader = createShader(35633, "attribute vec2 Position;\nattribute vec2 TexCoords;\nvarying vec2 TexCoord;\nvoid main() {\n\tTexCoord = TexCoords;\n\tgl_Position = vec4(Position, 0.0, 1.0);\n}\n");
            this.mBlitVertexShaderID = createShader;
            if (createShader == 0) {
                UE4.Log.error("mBlitVertexShaderID == 0");
                release();
                return;
            }
            if (this.mSwizzlePixels) {
                str = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).bgra;\n}\n";
            } else {
                str = "#extension GL_OES_EGL_image_external : require\nuniform samplerExternalOES VideoTexture;\nvarying highp vec2 TexCoord;\nvoid main()\n{\n\tgl_FragColor = texture2D(VideoTexture, TexCoord).rgba;\n}\n";
            }
            int createShader2 = createShader(35632, str);
            if (createShader2 == 0) {
                UE4.Log.error("mBlitFragmentShaderID == 0");
                release();
                return;
            }
            int glCreateProgram = GLES20.glCreateProgram();
            this.mProgram = glCreateProgram;
            if (glCreateProgram <= 0) {
                UE4.Log.error("mProgram <= 0");
                release();
                return;
            }
            GLES20.glAttachShader(glCreateProgram, this.mBlitVertexShaderID);
            GLES20.glAttachShader(this.mProgram, createShader2);
            GLES20.glLinkProgram(this.mProgram);
            int[] iArr3 = new int[1];
            GLES20.glGetProgramiv(this.mProgram, 35714, iArr3, 0);
            if (iArr3[0] != 1) {
                UE4.Log.error("Could not link program: ");
                UE4.Log.error(GLES20.glGetProgramInfoLog(this.mProgram));
                GLES20.glDeleteProgram(this.mProgram);
                this.mProgram = 0;
                release();
                return;
            }
            this.mPositionAttrib = GLES20.glGetAttribLocation(this.mProgram, "Position");
            this.mTexCoordsAttrib = GLES20.glGetAttribLocation(this.mProgram, "TexCoords");
            this.mTextureUniform = GLES20.glGetUniformLocation(this.mProgram, "VideoTexture");
            GLES20.glGenBuffers(1, iArr2, 0);
            int i17 = iArr2[0];
            this.mBlitBuffer = i17;
            if (i17 <= 0) {
                UE4.Log.error("mBlitBuffer <= 0");
                release();
                return;
            }
            this.mTriangleVertices = ByteBuffer.allocateDirect(this.mTriangleVerticesData.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.mTriangleVerticesDirty = true;
            if (this.mUseOwnContext) {
                GLES20.glDisable(3042);
                GLES20.glDisable(2884);
                GLES20.glDisable(3089);
                GLES20.glDisable(2960);
                GLES20.glDisable(2929);
                GLES20.glDisable(3024);
                GLES20.glColorMask(true, true, true, true);
            }
        }

        private void makeCurrent() {
            EGLDisplay eGLDisplay = this.mEglDisplay;
            EGLSurface eGLSurface = this.mEglSurface;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, this.mEglContext);
        }

        private void restoreContext() {
            EGL14.eglMakeCurrent(this.mSavedDisplay, this.mSavedSurfaceDraw, this.mSavedSurfaceRead, this.mSavedContext);
        }

        private void saveContext() {
            this.mSavedDisplay = EGL14.eglGetCurrentDisplay();
            this.mSavedContext = EGL14.eglGetCurrentContext();
            this.mSavedSurfaceDraw = EGL14.eglGetCurrentSurface(12377);
            this.mSavedSurfaceRead = EGL14.eglGetCurrentSurface(12378);
        }

        private void showGlError(String str, int i3) {
            switch (i3) {
                case 1280:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_ENUM");
                    return;
                case 1281:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_VALUE");
                    return;
                case 1282:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_OPERATION");
                    return;
                case 1285:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_OUT_OF_MEMORY");
                    return;
                case 1286:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_INVALID_FRAMEBUFFER_OPERATION");
                    return;
                case 36054:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT");
                    return;
                case 36057:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_INCOMPLETE_DIMENSIONS");
                    return;
                case 36061:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError GL_FRAMEBUFFER_UNSUPPORTED");
                    return;
                default:
                    UE4.Log.error("MediaPlayer$BitmapRenderer: " + str + ": glGetError " + i3);
                    return;
            }
        }

        public int getExternalTextureId() {
            return this.mTextureID;
        }

        public Surface getSurface() {
            return this.mSurface;
        }

        public SurfaceTexture getSurfaceTexture() {
            return this.mSurfaceTexture;
        }

        public boolean isValid() {
            if (this.mSurfaceTexture != null) {
                return true;
            }
            return false;
        }

        @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
        public void onFrameAvailable(SurfaceTexture surfaceTexture) {
            synchronized (this) {
                this.mFrameAvailable = true;
            }
        }

        public void release() {
            Surface surface = this.mSurface;
            if (surface != null) {
                surface.release();
                this.mSurface = null;
            }
            SurfaceTexture surfaceTexture = this.mSurfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.release();
                this.mSurfaceTexture = null;
            }
            int[] iArr = new int[1];
            int i3 = this.mBlitBuffer;
            if (i3 > 0) {
                iArr[0] = i3;
                GLES20.glDeleteBuffers(1, iArr, 0);
                this.mBlitBuffer = -1;
            }
            int i16 = this.mProgram;
            if (i16 > 0) {
                GLES20.glDeleteProgram(i16);
                this.mProgram = -1;
            }
            int i17 = this.mBlitVertexShaderID;
            if (i17 > 0) {
                GLES20.glDeleteShader(i17);
                this.mBlitVertexShaderID = -1;
            }
            int i18 = this.mBlitFragmentShaderID;
            if (i18 > 0) {
                GLES20.glDeleteShader(i18);
                this.mBlitFragmentShaderID = -1;
            }
            int i19 = this.mFBO;
            if (i19 > 0) {
                iArr[0] = i19;
                GLES20.glDeleteFramebuffers(1, iArr, 0);
                this.mFBO = -1;
            }
            int i26 = this.mTextureID;
            if (i26 > 0) {
                iArr[0] = i26;
                GLES20.glDeleteTextures(1, iArr, 0);
                this.mTextureID = -1;
            }
            EGLSurface eGLSurface = this.mEglSurface;
            if (eGLSurface != EGL14.EGL_NO_SURFACE) {
                EGL14.eglDestroySurface(this.mEglDisplay, eGLSurface);
                this.mEglSurface = EGL14.EGL_NO_SURFACE;
            }
            EGLContext eGLContext = this.mEglContext;
            if (eGLContext != EGL14.EGL_NO_CONTEXT) {
                EGL14.eglDestroyContext(this.mEglDisplay, eGLContext);
                this.mEglContext = EGL14.EGL_NO_CONTEXT;
            }
            if (this.mCreatedEGLDisplay) {
                EGL14.eglTerminate(this.mEglDisplay);
                this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
                this.mCreatedEGLDisplay = false;
            }
        }

        public boolean resolutionChanged() {
            boolean z16;
            synchronized (this) {
                z16 = this.mTextureSizeChanged;
                this.mTextureSizeChanged = false;
            }
            return z16;
        }

        public void setSize(int i3, int i16) {
            synchronized (this) {
                if (i3 != this.mTextureWidth || i16 != this.mTextureHeight) {
                    this.mTextureWidth = i3;
                    this.mTextureHeight = i16;
                    this.mFrameData = null;
                    this.mTextureSizeChanged = true;
                }
            }
        }

        public FrameUpdateInfo updateFrameData() {
            int i3;
            int i16;
            synchronized (this) {
                if (this.mFrameData == null && (i3 = this.mTextureWidth) > 0 && (i16 = this.mTextureHeight) > 0) {
                    this.mFrameData = ByteBuffer.allocateDirect(i3 * i16 * 4);
                }
                if (!copyFrameTexture(0, this.mFrameData)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
                frameUpdateInfo.Buffer = this.mFrameData;
                VideoDecoder videoDecoder = VideoDecoder.this;
                Map.Entry<Double, Double> frameTimeDuration = videoDecoder.getFrameTimeDuration(videoDecoder.getFrameTimestamp());
                frameUpdateInfo.Timestamp = frameTimeDuration.getKey().doubleValue();
                frameUpdateInfo.Duration = frameTimeDuration.getValue().doubleValue();
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }

        public FrameUpdateInfo updateFrameData(int i3) {
            synchronized (this) {
                if (!copyFrameTexture(i3, null)) {
                    return null;
                }
                FrameUpdateInfo frameUpdateInfo = new FrameUpdateInfo();
                frameUpdateInfo.Buffer = null;
                VideoDecoder videoDecoder = VideoDecoder.this;
                Map.Entry<Double, Double> frameTimeDuration = videoDecoder.getFrameTimeDuration(videoDecoder.getFrameTimestamp());
                frameUpdateInfo.Timestamp = frameTimeDuration.getKey().doubleValue();
                frameUpdateInfo.Duration = frameTimeDuration.getValue().doubleValue();
                frameUpdateInfo.FrameReady = true;
                frameUpdateInfo.RegionChanged = false;
                return frameUpdateInfo;
            }
        }
    }
}
