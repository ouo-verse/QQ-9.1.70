package com.tencent.liteav.videobase.frame;

import android.graphics.Bitmap;
import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.base.util.k;
import com.tencent.liteav.videobase.base.GLConstants;
import com.tencent.liteav.videobase.utils.ConsumerChainTimestamp;
import com.tencent.liteav.videobase.utils.OpenGlUtils;
import com.tencent.liteav.videobase.utils.ProducerChainTimestamp;
import java.nio.ByteBuffer;
import java.util.Collection;

@JNINamespace("liteav::video")
/* loaded from: classes7.dex */
public class PixelFrame extends i {
    protected ByteBuffer mBuffer;
    private GLConstants.ColorRange mColorRange;
    private GLConstants.ColorSpace mColorSpace;
    protected ConsumerChainTimestamp mConsumerChainTimestamp;
    protected byte[] mData;
    protected Object mGLContext;
    protected int mHeight;
    private boolean mIsMirrorHorizontal;
    private boolean mIsMirrorVertical;
    private float[] mMatrix;
    protected FrameMetaData mMetaData;
    protected GLConstants.a mPixelBufferType;
    protected GLConstants.PixelFormatType mPixelFormatType;
    protected ProducerChainTimestamp mProducerChainTimestamp;
    private k mRotation;
    protected int mTextureId;
    private long mTimestamp;
    protected int mWidth;

    public PixelFrame() {
        super(null);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
    }

    public static PixelFrame createFromBitmap(Bitmap bitmap) {
        try {
            int width = (bitmap.getWidth() / 2) * 2;
            int height = (bitmap.getHeight() / 2) * 2;
            if (width != 0 && height != 0 && (bitmap.getWidth() % 2 != 0 || bitmap.getHeight() % 2 != 0)) {
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, width, height);
            }
            ByteBuffer b16 = com.tencent.liteav.videobase.utils.d.b(bitmap.getWidth() * 4 * bitmap.getHeight());
            if (b16 == null) {
                return null;
            }
            bitmap.copyPixelsToBuffer(b16);
            b16.position(0);
            PixelFrame pixelFrame = new PixelFrame();
            pixelFrame.setBuffer(b16);
            pixelFrame.setWidth(bitmap.getWidth());
            pixelFrame.setHeight(bitmap.getHeight());
            pixelFrame.setPixelBufferType(GLConstants.a.BYTE_BUFFER);
            pixelFrame.setPixelFormatType(GLConstants.PixelFormatType.RGBA);
            return pixelFrame;
        } catch (Throwable th5) {
            LiteavLog.e("PixelFrame", "create pixel frame from bitmap fail", th5);
            return null;
        }
    }

    private int getColorRangeValue() {
        return this.mColorRange.getValue();
    }

    private int getColorSpaceValue() {
        return this.mColorSpace.getValue();
    }

    private int getPixelBufferTypeValue() {
        return this.mPixelBufferType.mValue;
    }

    private int getPixelFormatTypeValue() {
        return this.mPixelFormatType.getValue();
    }

    private int getRotationValue() {
        return this.mRotation.mValue;
    }

    public static void releasePixelFrames(Collection<PixelFrame> collection) {
        if (collection == null) {
            return;
        }
        for (PixelFrame pixelFrame : collection) {
            if (pixelFrame != null) {
                pixelFrame.release();
            }
        }
        collection.clear();
    }

    public void copy(PixelFrame pixelFrame) {
        this.mTimestamp = pixelFrame.mTimestamp;
        this.mWidth = pixelFrame.mWidth;
        this.mHeight = pixelFrame.mHeight;
        this.mPixelBufferType = pixelFrame.mPixelBufferType;
        this.mPixelFormatType = pixelFrame.mPixelFormatType;
        this.mRotation = pixelFrame.mRotation;
        this.mIsMirrorHorizontal = pixelFrame.mIsMirrorHorizontal;
        this.mIsMirrorVertical = pixelFrame.mIsMirrorVertical;
        if (pixelFrame.mMatrix != null) {
            this.mMatrix = new float[16];
            float[] matrix = pixelFrame.getMatrix();
            float[] fArr = this.mMatrix;
            System.arraycopy(matrix, 0, fArr, 0, fArr.length);
        }
        this.mMatrix = pixelFrame.mMatrix;
        this.mData = pixelFrame.mData;
        this.mBuffer = pixelFrame.mBuffer;
        this.mTextureId = pixelFrame.mTextureId;
        this.mGLContext = pixelFrame.mGLContext;
        this.mMetaData = pixelFrame.mMetaData;
        this.mConsumerChainTimestamp = pixelFrame.mConsumerChainTimestamp;
        this.mProducerChainTimestamp = pixelFrame.mProducerChainTimestamp;
        this.mColorSpace = pixelFrame.mColorSpace;
        this.mColorRange = pixelFrame.mColorRange;
    }

    public ByteBuffer getBuffer() {
        return this.mBuffer;
    }

    public GLConstants.ColorRange getColorRange() {
        return this.mColorRange;
    }

    public GLConstants.ColorSpace getColorSpace() {
        return this.mColorSpace;
    }

    public ConsumerChainTimestamp getConsumerChainTimestamp() {
        if (this.mConsumerChainTimestamp == null) {
            this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        }
        return this.mConsumerChainTimestamp;
    }

    public byte[] getData() {
        return this.mData;
    }

    public Object getGLContext() {
        return this.mGLContext;
    }

    public long getGLContextNativeHandle() {
        return OpenGlUtils.getGLContextNativeHandle(this.mGLContext);
    }

    public int getHeight() {
        return this.mHeight;
    }

    public float[] getMatrix() {
        return this.mMatrix;
    }

    public FrameMetaData getMetaData() {
        return this.mMetaData;
    }

    public GLConstants.a getPixelBufferType() {
        return this.mPixelBufferType;
    }

    public GLConstants.PixelFormatType getPixelFormatType() {
        return this.mPixelFormatType;
    }

    public ProducerChainTimestamp getProducerChainTimestamp() {
        if (this.mProducerChainTimestamp == null) {
            this.mProducerChainTimestamp = new ProducerChainTimestamp();
        }
        return this.mProducerChainTimestamp;
    }

    public k getRotation() {
        return this.mRotation;
    }

    public int getTextureId() {
        return this.mTextureId;
    }

    public long getTimestamp() {
        return this.mTimestamp;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean hasTransformParams() {
        if (this.mRotation == k.NORMAL && !this.mIsMirrorHorizontal && !this.mIsMirrorVertical && this.mMatrix == null) {
            return false;
        }
        return true;
    }

    public boolean isFrameDataValid() {
        GLConstants.a aVar = this.mPixelBufferType;
        if (aVar != GLConstants.a.TEXTURE_2D || this.mTextureId != -1) {
            if (aVar != GLConstants.a.BYTE_BUFFER || this.mBuffer != null) {
                if (aVar == GLConstants.a.BYTE_ARRAY && this.mData == null) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public boolean isMirrorHorizontal() {
        return this.mIsMirrorHorizontal;
    }

    public boolean isMirrorVertical() {
        return this.mIsMirrorVertical;
    }

    public void postRotate(k kVar) {
        if (kVar == k.ROTATION_90 || kVar == k.ROTATION_270) {
            swapWidthHeight();
        }
        setRotation(k.a((this.mRotation.mValue + kVar.mValue) % 360));
    }

    @Override // com.tencent.liteav.videobase.frame.i
    public void release() {
        super.release();
    }

    protected void reset() {
        this.mTimestamp = 0L;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mMetaData = null;
        this.mProducerChainTimestamp = null;
        this.mConsumerChainTimestamp = null;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
    }

    @Override // com.tencent.liteav.videobase.frame.i
    public int retain() {
        return super.retain();
    }

    public void setBuffer(ByteBuffer byteBuffer) {
        this.mBuffer = byteBuffer;
    }

    public void setColorRange(GLConstants.ColorRange colorRange) {
        this.mColorRange = colorRange;
    }

    public void setColorSpace(GLConstants.ColorSpace colorSpace) {
        this.mColorSpace = colorSpace;
    }

    public void setConsumerChainTimestamp(ConsumerChainTimestamp consumerChainTimestamp) {
        this.mConsumerChainTimestamp = consumerChainTimestamp;
    }

    public void setData(byte[] bArr) {
        this.mData = bArr;
    }

    public void setGLContext(Object obj) {
        this.mGLContext = obj;
    }

    public void setHeight(int i3) {
        this.mHeight = i3;
    }

    public void setMatrix(float[] fArr) {
        this.mMatrix = fArr;
    }

    public void setMetaData(FrameMetaData frameMetaData) {
        this.mMetaData = frameMetaData;
    }

    public void setMirrorHorizontal(boolean z16) {
        this.mIsMirrorHorizontal = z16;
    }

    public void setMirrorVertical(boolean z16) {
        this.mIsMirrorVertical = z16;
    }

    public void setPixelBufferType(GLConstants.a aVar) {
        this.mPixelBufferType = aVar;
    }

    public void setPixelFormatType(GLConstants.PixelFormatType pixelFormatType) {
        this.mPixelFormatType = pixelFormatType;
    }

    public void setProducerChainTimestamp(ProducerChainTimestamp producerChainTimestamp) {
        this.mProducerChainTimestamp = producerChainTimestamp;
    }

    public void setRotation(k kVar) {
        this.mRotation = kVar;
    }

    public void setTextureId(int i3) {
        this.mTextureId = i3;
    }

    public void setTimestamp(long j3) {
        this.mTimestamp = j3;
    }

    public void setWidth(int i3) {
        this.mWidth = i3;
    }

    public void swapWidthHeight() {
        int i3 = this.mWidth;
        this.mWidth = this.mHeight;
        this.mHeight = i3;
    }

    public PixelFrame(PixelFrame pixelFrame) {
        super(null);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        copy(pixelFrame);
    }

    public PixelFrame(int i3, int i16, int i17, int i18, int i19) {
        this(null, i3, i16, i17, GLConstants.a.a(i18), GLConstants.PixelFormatType.a(i19));
    }

    public PixelFrame(g<PixelFrame> gVar, int i3, int i16, GLConstants.a aVar, GLConstants.PixelFormatType pixelFormatType) {
        this(gVar, i3, i16, pixelFormatType == GLConstants.PixelFormatType.RGBA ? i3 * i16 * 4 : ((i3 * i16) * 3) / 2, aVar, pixelFormatType);
    }

    public PixelFrame(g<PixelFrame> gVar, int i3, int i16, int i17, GLConstants.a aVar, GLConstants.PixelFormatType pixelFormatType) {
        super(gVar);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
        this.mWidth = i3;
        this.mHeight = i16;
        this.mPixelFormatType = pixelFormatType;
        this.mPixelBufferType = aVar;
        if (aVar == GLConstants.a.BYTE_ARRAY) {
            this.mData = com.tencent.liteav.videobase.utils.d.a(i17);
        } else {
            this.mBuffer = com.tencent.liteav.videobase.utils.d.b(i17);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public PixelFrame(g<? extends PixelFrame> gVar) {
        super(gVar);
        this.mTimestamp = 0L;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mColorRange = GLConstants.ColorRange.UNKNOWN;
        this.mColorSpace = GLConstants.ColorSpace.UNKNOWN;
        this.mRotation = k.NORMAL;
        this.mIsMirrorHorizontal = false;
        this.mIsMirrorVertical = false;
        this.mMatrix = null;
        this.mData = null;
        this.mBuffer = null;
        this.mTextureId = -1;
        this.mGLContext = null;
        this.mProducerChainTimestamp = new ProducerChainTimestamp();
        this.mConsumerChainTimestamp = new ConsumerChainTimestamp();
    }
}
