package com.tencent.oskplayer.miscellaneous;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.support.annotation.NonNull;
import android.view.Surface;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.ark.EGLContextHolder;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.oskplayer.support.OskSupport;
import com.tencent.oskplayer.support.log.ILogger;
import com.tencent.oskplayer.support.log.Logger;
import com.tencent.oskplayer.support.util.OskFile;
import com.tencent.qfsmonet.gles.MonetEGL14Define$EGLQueryAttribute;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@TargetApi(17)
/* loaded from: classes22.dex */
public class HardwareDecodeProbe implements SurfaceTexture.OnFrameAvailableListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String TAG = "HardwareDecodeProbe";
    private EGLContext mEglContext;
    private EGLDisplay mEglDisplay;
    private EGLSurface mEglSurface;
    private int mMaxSavedFrame;
    private MediaCodec mMediaDecoder;
    private MediaExtractor mMediaExtractor;
    private MediaFormat mMediaFormat;
    private ByteBuffer mPixelBuf;
    private HwProbeCallback mProbeCallback;
    private TextureRenderer mRenderer;
    private String mSavedDir;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private int mVideoHeight;
    private int mVideoWidth;
    private Object mFrameSyncObject = new Object();
    private volatile boolean mFrameAvailable = false;
    private int mSaveWidth = 512;
    private int mSaveHeight = 1024;
    private Set<Integer> mSavedFrameSet = new HashSet();
    private long mDecodeFrameAvgCost = TTL.MAX_VALUE;

    /* loaded from: classes22.dex */
    public interface HwProbeCallback {
        void onHwProbeOneFrame(int i3);
    }

    private int awaitNewImage() {
        synchronized (this.mFrameSyncObject) {
            if (!this.mFrameAvailable) {
                try {
                    this.mFrameSyncObject.wait(2500L);
                    if (!this.mFrameAvailable) {
                        Logger.g().e(TAG, "[awaitNewImage] frame not available");
                        return 10021;
                    }
                } catch (Exception e16) {
                    Logger.g().e(TAG, "[awaitNewImage] frame not available, exception occured, " + e16.toString());
                    return 10021;
                }
            }
            this.mFrameAvailable = false;
            this.mSurfaceTexture.updateTexImage();
            return 0;
        }
    }

    private boolean checkEglError(String str) {
        int eglGetError = EGL14.eglGetError();
        if (12288 != eglGetError) {
            Logger.g().e(TAG, "[checkEglError] " + str + ", " + Integer.toHexString(eglGetError));
            return true;
        }
        return false;
    }

    private int doExtract(Set<Integer> set) {
        boolean z16;
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j3 = 0;
        int i3 = 1;
        boolean z17 = false;
        boolean z18 = false;
        while (true) {
            if (z17) {
                break;
            }
            if (i3 > this.mMaxSavedFrame) {
                Logger.g().d(TAG, "[doExtract] reach max save frame, decodeCount=" + i3 + ", mMaxSavedFrame=" + this.mMaxSavedFrame);
                break;
            }
            if (!z18) {
                try {
                    int dequeueInputBuffer = this.mMediaDecoder.dequeueInputBuffer(10000L);
                    ILogger g16 = Logger.g();
                    String str = TAG;
                    g16.d(str, "[doExtract] input index=" + dequeueInputBuffer);
                    if (dequeueInputBuffer >= 0) {
                        int readSampleData = this.mMediaExtractor.readSampleData(getInputBuffer(dequeueInputBuffer), 0);
                        if (readSampleData < 0) {
                            this.mMediaDecoder.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
                            Logger.g().d(str, "[doExtract] queue input EOS");
                            z18 = true;
                        } else {
                            this.mMediaDecoder.queueInputBuffer(dequeueInputBuffer, 0, readSampleData, this.mMediaExtractor.getSampleTime(), 0);
                            this.mMediaExtractor.advance();
                        }
                    } else {
                        Logger.g().d(str, "[doExtract] input buffer not available");
                    }
                } catch (Exception e16) {
                    Logger.g().e(TAG, "[doExtract] dequeueInputBuffer error" + e16.toString());
                    return 10026;
                }
            }
            if (!z17) {
                long currentTimeMillis = System.currentTimeMillis();
                try {
                    int dequeueOutputBuffer = this.mMediaDecoder.dequeueOutputBuffer(bufferInfo, 10000L);
                    ILogger g17 = Logger.g();
                    String str2 = TAG;
                    g17.d(str2, "[doExtract] output index=" + dequeueOutputBuffer + ", buffer size=" + bufferInfo.size);
                    if (dequeueOutputBuffer >= 0) {
                        if ((bufferInfo.flags & 4) != 0) {
                            Logger.g().d(str2, "[doExtract] output EOS");
                            z17 = true;
                        }
                        if (bufferInfo.size != 0) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        this.mMediaDecoder.releaseOutputBuffer(dequeueOutputBuffer, z16);
                        if (z16) {
                            j3 += System.currentTimeMillis() - currentTimeMillis;
                            awaitNewImage();
                            this.mRenderer.drawFrame(this.mSurfaceTexture, true);
                            if (set.contains(Integer.valueOf(i3))) {
                                saveFrame(i3);
                            }
                            i3++;
                            HwProbeCallback hwProbeCallback = this.mProbeCallback;
                            if (hwProbeCallback != null) {
                                hwProbeCallback.onHwProbeOneFrame(i3);
                            }
                        }
                    }
                } catch (Exception e17) {
                    Logger.g().e(TAG, "[doExtract] dequeueOutputBuffer error" + e17.toString());
                    return 10025;
                }
            }
        }
        int i16 = i3 - 1;
        if (i16 > 0) {
            this.mDecodeFrameAvgCost = j3 / i16;
            Logger.g().d(TAG, "[doExtract] decode frame avgCost=" + this.mDecodeFrameAvgCost);
        }
        return 0;
    }

    private int eglSetup() {
        EGLSurface eGLSurface;
        this.mEglDisplay = EGL14.eglGetDisplay(0);
        if (!checkEglError("eglGetDisplay")) {
            EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
            EGLDisplay eGLDisplay2 = this.mEglDisplay;
            if (eGLDisplay != eGLDisplay2) {
                int[] iArr = new int[2];
                boolean eglInitialize = EGL14.eglInitialize(eGLDisplay2, iArr, 0, iArr, 0);
                if (!checkEglError("eglInitialize") && eglInitialize) {
                    ILogger g16 = Logger.g();
                    String str = TAG;
                    g16.d(str, "[eglSetup] major version=" + iArr[0] + ", minor version=" + iArr[1]);
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    int[] iArr2 = new int[1];
                    boolean eglChooseConfig = EGL14.eglChooseConfig(this.mEglDisplay, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12339, 1, 12344}, 0, eGLConfigArr, 0, 1, iArr2, 0);
                    if (!checkEglError("eglChooseConfig") && eglChooseConfig) {
                        Logger.g().d(str, "[eglSetup] numConfigs=" + iArr2[0]);
                        this.mEglContext = EGL14.eglCreateContext(this.mEglDisplay, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{EGLContextHolder.EGL_CONTEXT_CLIENT_VERSION, 2, 12344}, 0);
                        if (!checkEglError("eglCreateContext") && this.mEglContext != null) {
                            this.mEglSurface = EGL14.eglCreatePbufferSurface(this.mEglDisplay, eGLConfigArr[0], new int[]{MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_WIDTH, this.mSaveWidth, MonetEGL14Define$EGLQueryAttribute.ATTRIBUTE_HEIGHT, this.mSaveHeight, 12344}, 0);
                            if (!checkEglError("eglCreatePbufferSurface") && (eGLSurface = this.mEglSurface) != null) {
                                boolean eglMakeCurrent = EGL14.eglMakeCurrent(this.mEglDisplay, eGLSurface, eGLSurface, this.mEglContext);
                                if (!checkEglError("eglMakeCurrent") && eglMakeCurrent) {
                                    Logger.g().d(str, "[eglSetup] setup success");
                                    return 0;
                                }
                                Logger.g().e(str, "[eglSetup] eglMakeCurrent failed");
                                return 10008;
                            }
                            Logger.g().e(str, "[eglSetup] eglCreatePbufferSurface failed");
                            return 10007;
                        }
                        Logger.g().e(str, "[eglSetup] eglCreateContext failed");
                        return 10006;
                    }
                    Logger.g().e(str, "[eglSetup] eglChooseConfig failed");
                    return 10005;
                }
                Logger.g().e(TAG, "[eglSetup] eglInitialize failed");
                return 10004;
            }
        }
        Logger.g().e(TAG, "[eglSetup] eglGetDisplay failed");
        return 10003;
    }

    private ByteBuffer getInputBuffer(int i3) {
        return this.mMediaDecoder.getInputBuffer(i3);
    }

    private int getVideoFormat(String str) {
        MediaFormat mediaFormat;
        try {
            MediaExtractor mediaExtractor = new MediaExtractor();
            this.mMediaExtractor = mediaExtractor;
            mediaExtractor.setDataSource(str);
            IjkMediaPlayer.loadLibrariesOnce(OskSupport.getLibLoader());
            if (!IjkMediaPlayer.sIsLibLoadSuccess) {
                Logger.g().e(TAG, "[getVideoFormat] get MediaFormat failed, lib load=" + IjkMediaPlayer.sIsLibLoadSuccess);
                return 10028;
            }
            MediaFormatProxy hEVCVideoFormat = IjkMediaPlayer.getHEVCVideoFormat(str);
            if (hEVCVideoFormat != null && (mediaFormat = hEVCVideoFormat.videoFormat) != null) {
                this.mMediaFormat = mediaFormat;
                Logger.g().d(TAG, "[getVideoFormat] video track=" + hEVCVideoFormat.videoTrack);
                this.mMediaExtractor.selectTrack(hEVCVideoFormat.videoTrack);
                return 0;
            }
            Logger.g().e(TAG, "[getVideoFormat] get MediaFormat failed");
            return 10028;
        } catch (Exception e16) {
            Logger.g().e(TAG, "[getVideoFormat] exception, " + e16.toString());
            return 10002;
        }
    }

    private int mediaDecoderSetup(String str) {
        try {
            int videoFormat = getVideoFormat(str);
            if (videoFormat != 0) {
                return videoFormat;
            }
            this.mVideoWidth = this.mMediaFormat.getInteger("width");
            this.mVideoHeight = this.mMediaFormat.getInteger("height");
            ILogger g16 = Logger.g();
            String str2 = TAG;
            g16.d(str2, "[mediaDecoderSetup] video size=" + this.mVideoWidth + HippyTKDListViewAdapter.X + this.mVideoHeight);
            this.mSaveWidth = this.mVideoWidth;
            this.mSaveHeight = this.mVideoHeight;
            MediaCodec createDecoderByType = MediaCodec.createDecoderByType(this.mMediaFormat.getString("mime"));
            this.mMediaDecoder = createDecoderByType;
            MediaCodecInfo codecInfo = createDecoderByType.getCodecInfo();
            Logger.g().e(str2, "codec name=" + codecInfo.getName() + "\n");
            Logger.g().d(str2, "[mediaDecoderSetup] setup success");
            return 0;
        } catch (Exception e16) {
            Logger.g().e(TAG, "[mediaDecoderSetup] setup failed, " + e16.toString());
            return 10010;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00e5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object[]] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v12 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int saveFrame(int i3) {
        Throwable th5;
        BufferedOutputStream bufferedOutputStream;
        Exception e16;
        ILogger g16;
        String str;
        StringBuilder sb5;
        String str2 = this.mSavedDir;
        Locale locale = Locale.getDefault();
        ?? r46 = {Integer.valueOf(i3)};
        File file = new File(str2, String.format(locale, "hw-%d.jpg", r46));
        long currentTimeMillis = System.currentTimeMillis();
        this.mPixelBuf.rewind();
        GLES20.glReadPixels(0, 0, this.mSaveWidth, this.mSaveHeight, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.mPixelBuf);
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            } catch (Exception e17) {
                bufferedOutputStream = null;
                e16 = e17;
            } catch (Throwable th6) {
                r46 = 0;
                th5 = th6;
                if (r46 != 0) {
                }
                throw th5;
            }
            try {
                Bitmap createBitmap = Bitmap.createBitmap(this.mSaveWidth, this.mSaveHeight, Bitmap.Config.ARGB_8888);
                this.mPixelBuf.rewind();
                createBitmap.copyPixelsFromBuffer(this.mPixelBuf);
                createBitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                createBitmap.recycle();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                Logger.g().d(TAG, "[saveFrame] frame save cost=" + currentTimeMillis2 + ",frame=" + file.getAbsolutePath());
                try {
                    bufferedOutputStream.close();
                    r46 = bufferedOutputStream;
                } catch (Exception e18) {
                    e = e18;
                    g16 = Logger.g();
                    str = TAG;
                    sb5 = new StringBuilder();
                    sb5.append("[saveFrame] bos close exception, ");
                    sb5.append(e);
                    g16.w(str, sb5.toString());
                    return 0;
                }
            } catch (Exception e19) {
                e16 = e19;
                Logger.g().w(TAG, "[saveFrame] save frame exception, " + e16);
                r46 = bufferedOutputStream;
                if (bufferedOutputStream != null) {
                    try {
                        bufferedOutputStream.close();
                        r46 = bufferedOutputStream;
                    } catch (Exception e26) {
                        e = e26;
                        g16 = Logger.g();
                        str = TAG;
                        sb5 = new StringBuilder();
                        sb5.append("[saveFrame] bos close exception, ");
                        sb5.append(e);
                        g16.w(str, sb5.toString());
                        return 0;
                    }
                }
                return 0;
            }
            return 0;
        } catch (Throwable th7) {
            th5 = th7;
            if (r46 != 0) {
                try {
                    r46.close();
                } catch (Exception e27) {
                    Logger.g().w(TAG, "[saveFrame] bos close exception, " + e27);
                }
            }
            throw th5;
        }
    }

    private int surfaceSetup() {
        TextureRenderer textureRenderer = new TextureRenderer();
        this.mRenderer = textureRenderer;
        int createTexture = textureRenderer.createTexture();
        if (createTexture != 0) {
            Logger.g().e(TAG, "[surfaceSetup] surfaceSetup failed, " + createTexture);
            return createTexture;
        }
        this.mSurfaceTexture = new SurfaceTexture(this.mRenderer.getTextureId());
        this.mSurface = new Surface(this.mSurfaceTexture);
        this.mSurfaceTexture.setOnFrameAvailableListener(this);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mSaveWidth * this.mSaveHeight * 4);
        this.mPixelBuf = allocateDirect;
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        Logger.g().d(TAG, "[surfaceSetup] surfaceSetup success");
        return 0;
    }

    public long getDecodeFrameAvgCost() {
        return this.mDecodeFrameAvgCost;
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        synchronized (this.mFrameSyncObject) {
            if (this.mFrameAvailable) {
                Logger.g().e(TAG, "[onFrameAvailable] mFrameAvailable already set, frame could be dropped");
                this.mFrameAvailable = false;
                this.mFrameSyncObject.notifyAll();
            }
            this.mFrameAvailable = true;
            this.mFrameSyncObject.notifyAll();
        }
    }

    public int probe(@NonNull String str, @NonNull String str2, Set<Integer> set) {
        int i3;
        if (OskFile.isLocalFile(str) && !new File(str).canRead()) {
            Logger.g().e(TAG, "[decode] file cannot read, " + str);
            return 10002;
        }
        File file = new File(str2);
        if (!file.exists() && !file.mkdirs()) {
            return 10023;
        }
        this.mSavedDir = str2;
        int mediaDecoderSetup = mediaDecoderSetup(str);
        if (mediaDecoderSetup != 0) {
            return mediaDecoderSetup;
        }
        int eglSetup = eglSetup();
        if (eglSetup != 0) {
            return eglSetup;
        }
        int surfaceSetup = surfaceSetup();
        if (surfaceSetup != 0) {
            return surfaceSetup;
        }
        for (Integer num : set) {
            this.mMaxSavedFrame = Math.max(this.mMaxSavedFrame, num.intValue());
            this.mSavedFrameSet.add(num);
        }
        try {
            this.mMediaDecoder.configure(this.mMediaFormat, this.mSurface, (MediaCrypto) null, 0);
            this.mMediaDecoder.start();
            try {
                i3 = doExtract(this.mSavedFrameSet);
            } catch (Exception e16) {
                Logger.g().e(TAG, "[probe] doExtract error, " + e16.toString());
                i3 = 10027;
            }
            release();
            return i3;
        } catch (Exception e17) {
            Logger.g().e(TAG, "MediaCodec configure failed, " + e17.toString());
            release();
            return 10024;
        }
    }

    public void release() {
        EGLDisplay eGLDisplay = this.mEglDisplay;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGL14.eglDestroySurface(eGLDisplay, this.mEglSurface);
            EGL14.eglDestroyContext(this.mEglDisplay, this.mEglContext);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.mEglDisplay);
        }
        this.mEglDisplay = EGL14.EGL_NO_DISPLAY;
        this.mEglContext = EGL14.EGL_NO_CONTEXT;
        this.mEglSurface = EGL14.EGL_NO_SURFACE;
        this.mSurface.release();
        MediaCodec mediaCodec = this.mMediaDecoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mMediaDecoder.release();
        }
        MediaExtractor mediaExtractor = this.mMediaExtractor;
        if (mediaExtractor != null) {
            mediaExtractor.release();
        }
    }

    public void setProbeCallback(HwProbeCallback hwProbeCallback) {
        this.mProbeCallback = hwProbeCallback;
    }
}
