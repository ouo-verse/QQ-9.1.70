package com.tencent.qq.effect.alphavideo.videoplayer.render;

import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qq.effect.utils.LogUtil;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class BaseRender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoPlayer|BaseRender";
    protected static float squareSize;
    protected ShortBuffer drawListBuffer;
    protected short[] drawOrder;
    protected float mLastCropValue;
    protected int mRenderType;
    protected boolean mReverseHorizonal;
    protected float[] squareCoords;
    protected float[] squareCoords_horizonal_reverse;
    protected float[] squareCoords_vertical_horizonal_reverse;
    protected float[] squareCoords_vertical_reverse;
    protected float[] textureCoords;
    protected FloatBuffer textureCoordsBuffer;
    protected float[] textureTransform;
    protected FloatBuffer vertexBuffer;
    protected FloatBuffer vertexBuffer_horizonal_reverse;
    protected FloatBuffer vertexBuffer_horizonal_vertical_reverse;
    protected FloatBuffer vertexBuffer_vertical_reverse;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9699);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            squareSize = 1.0f;
        }
    }

    public BaseRender(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.mLastCropValue = 0.0f;
        float f16 = squareSize;
        this.squareCoords = new float[]{-f16, f16, -f16, -f16, f16, -f16, f16, f16};
        this.squareCoords_horizonal_reverse = new float[]{f16, f16, f16, -f16, -f16, -f16, -f16, f16};
        this.squareCoords_vertical_reverse = new float[]{-f16, -f16, -f16, f16, f16, f16, f16, -f16};
        this.squareCoords_vertical_horizonal_reverse = new float[]{f16, -f16, f16, f16, -f16, f16, -f16, -f16};
        this.drawOrder = new short[]{0, 1, 2, 0, 2, 3};
        this.textureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f, 0.0f, 1.0f};
        this.textureTransform = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.mReverseHorizonal = false;
        this.mRenderType = i3;
    }

    public void checkGlError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                LogUtil.e(TAG, str + ": glError " + GLUtils.getEGLErrorString(glGetError));
            } else {
                return;
            }
        }
    }

    public abstract void destroy();

    public abstract void draw(byte[] bArr, int i3, int i16, boolean z16);

    public abstract void drawFBO(byte[] bArr, int i3, int i16, boolean z16);

    public int getRenderType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.mRenderType == -1) {
            LogUtil.v(TAG, "mRenderType  Error, need initDecodeType ");
        }
        return this.mRenderType;
    }

    public void setCropValue(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Float.valueOf(f16));
            return;
        }
        LogUtil.v(TAG, "setCropValue aCropValue=" + f16);
        if (this.mLastCropValue != f16) {
            this.mLastCropValue = f16;
            if (f16 > 0.0f) {
                float f17 = 1.0f - f16;
                this.textureCoords = new float[]{0.0f, f17, 0.0f, 1.0f, 0.0f, f16, 0.0f, 1.0f, 0.5f, f16, 0.0f, 1.0f, 0.5f, f17, 0.0f, 1.0f};
            } else {
                float f18 = f16 / 2.0f;
                float f19 = 0.0f - f18;
                float f26 = f18 + 0.5f;
                this.textureCoords = new float[]{f19, 1.0f, 0.0f, 1.0f, f19, 0.0f, 0.0f, 1.0f, f26, 0.0f, 0.0f, 1.0f, f26, 1.0f, 0.0f, 1.0f};
            }
            ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
            allocateDirect.order(ByteOrder.nativeOrder());
            FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
            this.textureCoordsBuffer = asFloatBuffer;
            asFloatBuffer.put(this.textureCoords);
            this.textureCoordsBuffer.position(0);
        }
    }

    public void setRoteTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        float f16 = squareSize;
        float[] fArr = {f16, -f16, -f16, -f16, -f16, f16, f16, f16};
        this.squareCoords = fArr;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.vertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.squareCoords);
        this.vertexBuffer.position(0);
    }

    public abstract void setup();

    public void setupTextureCoordsBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        LogUtil.v(TAG, "setupTexture");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.textureCoords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.textureCoordsBuffer = asFloatBuffer;
        asFloatBuffer.put(this.textureCoords);
        this.textureCoordsBuffer.position(0);
    }

    public void setupVertexBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        LogUtil.v(TAG, "setupVertexBuffer");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.drawOrder.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.drawListBuffer = asShortBuffer;
        asShortBuffer.put(this.drawOrder);
        this.drawListBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.squareCoords.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.vertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.squareCoords);
        this.vertexBuffer.position(0);
        ByteBuffer allocateDirect3 = ByteBuffer.allocateDirect(this.squareCoords_horizonal_reverse.length * 4);
        allocateDirect3.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer2 = allocateDirect3.asFloatBuffer();
        this.vertexBuffer_horizonal_reverse = asFloatBuffer2;
        asFloatBuffer2.put(this.squareCoords_horizonal_reverse);
        this.vertexBuffer_horizonal_reverse.position(0);
        ByteBuffer allocateDirect4 = ByteBuffer.allocateDirect(this.squareCoords_vertical_reverse.length * 4);
        allocateDirect4.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer3 = allocateDirect4.asFloatBuffer();
        this.vertexBuffer_vertical_reverse = asFloatBuffer3;
        asFloatBuffer3.put(this.squareCoords_vertical_reverse);
        this.vertexBuffer_vertical_reverse.position(0);
        ByteBuffer allocateDirect5 = ByteBuffer.allocateDirect(this.squareCoords_vertical_horizonal_reverse.length * 4);
        allocateDirect5.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer4 = allocateDirect5.asFloatBuffer();
        this.vertexBuffer_horizonal_vertical_reverse = asFloatBuffer4;
        asFloatBuffer4.put(this.squareCoords_vertical_horizonal_reverse);
        this.vertexBuffer_horizonal_vertical_reverse.position(0);
    }

    public BaseRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mLastCropValue = 0.0f;
        float f16 = squareSize;
        this.squareCoords = new float[]{-f16, f16, -f16, -f16, f16, -f16, f16, f16};
        this.squareCoords_horizonal_reverse = new float[]{f16, f16, f16, -f16, -f16, -f16, -f16, f16};
        this.squareCoords_vertical_reverse = new float[]{-f16, -f16, -f16, f16, f16, f16, f16, -f16};
        this.squareCoords_vertical_horizonal_reverse = new float[]{f16, -f16, f16, f16, -f16, f16, -f16, -f16};
        this.drawOrder = new short[]{0, 1, 2, 0, 2, 3};
        this.textureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.5f, 0.0f, 0.0f, 1.0f, 0.5f, 1.0f, 0.0f, 1.0f};
        this.textureTransform = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.mRenderType = -1;
        this.mReverseHorizonal = false;
    }
}
