package com.tencent.jalpha.videoplayer.render;

import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.view.Surface;
import com.tencent.jalpha.common.Logger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseRender {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "VideoPlayer|BaseRender";
    private static float mSquareSize;
    protected ShortBuffer mDrawListBuffer;
    protected short[] mDrawOrder;
    protected int mRenderType;
    protected float[] mSquareCoords;
    protected float[] mTextureCoords;
    protected FloatBuffer mTextureCoordsBuffer;
    protected float[] mTextureTransform;
    protected FloatBuffer mVertexBuffer;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9456);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            mSquareSize = 1.0f;
        }
    }

    public BaseRender(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        float f16 = mSquareSize;
        this.mSquareCoords = new float[]{-f16, f16, -f16, -f16, f16, -f16, f16, f16};
        this.mDrawOrder = new short[]{0, 1, 2, 2, 3, 0};
        this.mTextureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        this.mTextureTransform = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.mRenderType = i3;
    }

    public void checkGlError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
            return;
        }
        while (true) {
            int glGetError = GLES20.glGetError();
            if (glGetError != 0) {
                Logger.e(TAG, str + ": glError " + GLUtils.getEGLErrorString(glGetError));
            } else {
                return;
            }
        }
    }

    public abstract void destroy();

    public abstract void draw(byte[] bArr, int i3, int i16);

    public int getRenderType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        if (this.mRenderType == -1) {
            Logger.v(TAG, "mRenderType  Error, need initDecodeType ");
        }
        return this.mRenderType;
    }

    public abstract Surface getSurface();

    public abstract SurfaceTexture getVideoTexture();

    public void setRoteTexture() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        float f16 = mSquareSize;
        float[] fArr = {f16, -f16, -f16, -f16, -f16, f16, f16, f16};
        this.mSquareCoords = fArr;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(fArr.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mVertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.mSquareCoords);
        this.mVertexBuffer.position(0);
    }

    public abstract void setup();

    public void setupTextureCoordsBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        Logger.v(TAG, "setupTexture");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mTextureCoords.length * 4);
        allocateDirect.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect.asFloatBuffer();
        this.mTextureCoordsBuffer = asFloatBuffer;
        asFloatBuffer.put(this.mTextureCoords);
        this.mTextureCoordsBuffer.position(0);
    }

    public void setupVertexBuffer() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Logger.v(TAG, "setupVertexBuffer");
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(this.mDrawOrder.length * 2);
        allocateDirect.order(ByteOrder.nativeOrder());
        ShortBuffer asShortBuffer = allocateDirect.asShortBuffer();
        this.mDrawListBuffer = asShortBuffer;
        asShortBuffer.put(this.mDrawOrder);
        this.mDrawListBuffer.position(0);
        ByteBuffer allocateDirect2 = ByteBuffer.allocateDirect(this.mSquareCoords.length * 4);
        allocateDirect2.order(ByteOrder.nativeOrder());
        FloatBuffer asFloatBuffer = allocateDirect2.asFloatBuffer();
        this.mVertexBuffer = asFloatBuffer;
        asFloatBuffer.put(this.mSquareCoords);
        this.mVertexBuffer.position(0);
    }

    public abstract void updateSize(int i3, int i16, int i17, int i18);

    public BaseRender() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        float f16 = mSquareSize;
        this.mSquareCoords = new float[]{-f16, f16, -f16, -f16, f16, -f16, f16, f16};
        this.mDrawOrder = new short[]{0, 1, 2, 2, 3, 0};
        this.mTextureCoords = new float[]{0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f};
        this.mTextureTransform = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f};
        this.mRenderType = -1;
    }
}
