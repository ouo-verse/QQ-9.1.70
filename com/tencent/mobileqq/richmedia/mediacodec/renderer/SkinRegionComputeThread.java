package com.tencent.mobileqq.richmedia.mediacodec.renderer;

import android.opengl.EGLContext;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.github.henryye.nativeiv.bitmap.NativeBitmapStruct;
import com.tencent.mobileqq.shortvideo.eglwraper.EglCore;
import com.tencent.mobileqq.shortvideo.eglwraper.EglSurfaceBase;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.device.DeviceInstance;
import com.tencent.ttpic.openapi.filter.GPUBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;
import com.tracking.skinRegionSdk.SkinRegionManager;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SkinRegionComputeThread implements Handler.Callback {
    public static final int SKIN_THREAD_COMPUTE = 2;
    public static final int SKIN_THREAD_INIT = 1;
    public static final int SKIN_THREAD_RELEASE = 3;
    private static final String TAG = "SkinRegionComputeThread";
    private GPUBaseFilter baseFilter;
    private int inputTexHeight;
    private int inputTexWidth;
    private int mComputeHeight;
    private int mComputeWidth;
    private EglCore mEglCore;
    private EglSurfaceBase mEglSurfaceBase;
    private HandlerThread mGlThreadMsg;
    private Handler mHandler;
    private int mMaskHeight;
    private int mMaskWidth;
    private RenderBuffer mRenderBuffer;
    private int mSurfaceHeight;
    private int mSurfaceWidth;
    private Object mTextureLock;
    private byte[] maskData;
    private ByteBuffer pixelBuffer;
    private boolean hasInitSize = false;
    private boolean hasInitContext = false;
    private boolean mComputeStart = false;
    private int computeCount = 0;
    private int computeInterval = 2;

    public SkinRegionComputeThread() {
        SkinRegionManager.newInstance().init();
        createMsgThread();
    }

    private void createEglSurfceBase(int i3, int i16) {
        EglSurfaceBase eglSurfaceBase = new EglSurfaceBase(this.mEglCore);
        this.mEglSurfaceBase = eglSurfaceBase;
        eglSurfaceBase.createOffscreenSurface(i3, i16);
        this.mEglSurfaceBase.makeCurrent();
    }

    private void createMsgThread() {
        if (this.mGlThreadMsg == null) {
            BaseHandlerThread baseHandlerThread = new BaseHandlerThread("skinCompute");
            this.mGlThreadMsg = baseHandlerThread;
            baseHandlerThread.start();
            this.mHandler = new Handler(this.mGlThreadMsg.getLooper(), this);
        }
    }

    private Handler getMsgHandler() {
        Handler handler;
        if (this.mGlThreadMsg != null && (handler = this.mHandler) != null) {
            return handler;
        }
        return null;
    }

    private void initGlContext(int i3, int i16, EGLContext eGLContext) {
        if (this.hasInitContext && i3 == this.mSurfaceWidth && i16 == this.mSurfaceHeight) {
            return;
        }
        if (DeviceInstance.getSDKVersion() >= 17) {
            this.mEglCore = new EglCore(eGLContext, 1);
        }
        createEglSurfceBase(i3, i16);
    }

    private void releaseGLContext() {
        RenderBuffer renderBuffer = this.mRenderBuffer;
        if (renderBuffer != null) {
            renderBuffer.destroy();
            this.mRenderBuffer = null;
        }
        EglSurfaceBase eglSurfaceBase = this.mEglSurfaceBase;
        if (eglSurfaceBase != null) {
            eglSurfaceBase.releaseEglSurface();
            this.mEglSurfaceBase = null;
        }
        EglCore eglCore = this.mEglCore;
        if (eglCore != null) {
            eglCore.release();
            this.mEglCore = null;
        }
        this.hasInitContext = false;
    }

    private void skinRegionComputeAsnyc(int i3, float[] fArr) {
        if (fArr.length != 4) {
            return;
        }
        this.mRenderBuffer.bind();
        synchronized (this.mTextureLock) {
            this.baseFilter.drawTexture(i3, null, null);
        }
        this.pixelBuffer.position(0);
        GLES20.glReadPixels(0, 0, this.inputTexWidth, this.inputTexHeight, 6408, NativeBitmapStruct.GLType.GL_UNSIGNED_BYTE, this.pixelBuffer);
        this.mRenderBuffer.unbind();
        this.pixelBuffer.position(0);
        byte[] array = this.pixelBuffer.array();
        int i16 = this.mMaskWidth * this.mMaskHeight;
        byte[] bArr = new byte[i16];
        SkinRegionManager.newInstance().skinRegionCompute(array, this.inputTexWidth, this.inputTexHeight, bArr, fArr[0], fArr[1], fArr[2], fArr[3]);
        synchronized (this) {
            byte[] bArr2 = this.maskData;
            if (bArr2 != null && i16 == bArr2.length) {
                System.arraycopy(bArr, 0, bArr2, 0, i16);
            }
        }
        this.mComputeStart = true;
    }

    public boolean copyMaskData(byte[] bArr) {
        byte[] bArr2 = this.maskData;
        if (bArr2.length <= 0 || bArr.length != bArr2.length || !this.mComputeStart) {
            return false;
        }
        synchronized (this) {
            byte[] bArr3 = this.maskData;
            System.arraycopy(bArr3, 0, bArr, 0, bArr3.length);
        }
        return true;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    releaseGLContext();
                    releaseMsgThread();
                    this.mComputeStart = false;
                    this.hasInitContext = false;
                }
            } else {
                skinRegionComputeAsnyc(message.arg1, (float[]) message.obj);
            }
        } else {
            initGlContext(message.arg1, message.arg2, (EGLContext) message.obj);
            this.hasInitContext = true;
        }
        return true;
    }

    public void init(int i3, int i16, EGLContext eGLContext, Object obj) {
        this.mSurfaceWidth = i3;
        this.mSurfaceHeight = i16;
        this.hasInitSize = true;
        int i17 = this.mComputeWidth;
        this.inputTexWidth = i17;
        int i18 = this.mComputeHeight;
        this.inputTexHeight = i18;
        ByteBuffer allocate = ByteBuffer.allocate(i17 * i18 * 4);
        this.pixelBuffer = allocate;
        allocate.order(ByteOrder.nativeOrder());
        this.pixelBuffer.position(0);
        this.mRenderBuffer = new RenderBuffer(false, this.inputTexWidth, this.inputTexHeight, 33984);
        GPUBaseFilter gPUBaseFilter = new GPUBaseFilter();
        this.baseFilter = gPUBaseFilter;
        gPUBaseFilter.init();
        this.baseFilter.onOutputSizeChanged(this.inputTexWidth, this.inputTexHeight);
        this.mTextureLock = obj;
        Handler msgHandler = getMsgHandler();
        if (msgHandler != null) {
            Message obtain = Message.obtain(msgHandler);
            obtain.what = 1;
            obtain.arg1 = i3;
            obtain.arg2 = i16;
            obtain.obj = eGLContext;
            msgHandler.sendMessage(obtain);
        }
    }

    public void initRegionCompute(int i3, int i16, int i17, int i18, boolean z16) {
        this.mComputeWidth = i3;
        this.mComputeHeight = i16;
        this.mMaskWidth = i17;
        this.mMaskHeight = i18;
        SkinRegionManager.newInstance().skinRegionInit(i3, i16, i17, i18, z16);
        this.maskData = new byte[this.mMaskHeight * this.mMaskWidth];
    }

    public void onDestroy() {
        Handler msgHandler = getMsgHandler();
        if (msgHandler != null) {
            Message obtain = Message.obtain(msgHandler);
            obtain.what = 3;
            msgHandler.sendMessage(obtain);
        }
    }

    public void releaseMsgThread() {
        if (this.mGlThreadMsg != null) {
            this.mHandler.removeCallbacksAndMessages(null);
            this.mGlThreadMsg.quit();
            this.mGlThreadMsg = null;
            this.mHandler = null;
        }
    }

    public void skinRegionCompute(int i3, float[] fArr) {
        if (this.computeCount % this.computeInterval == 0) {
            this.computeCount = 0;
            Handler msgHandler = getMsgHandler();
            if (msgHandler != null) {
                Message obtain = Message.obtain(msgHandler);
                obtain.what = 2;
                obtain.arg1 = i3;
                obtain.obj = fArr;
                msgHandler.sendMessage(obtain);
            }
        }
        this.computeCount++;
    }
}
