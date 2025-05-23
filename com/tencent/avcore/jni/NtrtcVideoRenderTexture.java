package com.tencent.avcore.jni;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.avcore.jni.render.IGLRenderTexture;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.GlStringParser;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes3.dex */
public class NtrtcVideoRenderTexture implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "TextureJni";
    private final Handler mEventHandler;
    private long mNativeContext;
    private GlStringParser mStringParser;
    private final IGLRenderTexture mTexture;

    public NtrtcVideoRenderTexture(IGLRenderTexture iGLRenderTexture) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iGLRenderTexture);
            return;
        }
        this.mStringParser = null;
        this.mNativeContext = 0L;
        this.mTexture = iGLRenderTexture;
        Looper myLooper = Looper.myLooper();
        myLooper = myLooper == null ? Looper.getMainLooper() : myLooper;
        if (myLooper != null) {
            this.mEventHandler = new Handler(myLooper, this);
        } else {
            this.mEventHandler = null;
        }
    }

    private void notifyUpdateUI(int i3, int i16, Object obj) {
        IGLRenderTexture iGLRenderTexture = this.mTexture;
        if (iGLRenderTexture != null) {
            iGLRenderTexture.markForPerf(i3);
        }
        Handler handler = this.mEventHandler;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(i3, 0, 0, obj);
            if (i16 == 0) {
                this.mEventHandler.sendMessage(obtainMessage);
                return;
            } else {
                this.mEventHandler.sendMessageDelayed(obtainMessage, i16);
                return;
            }
        }
        if (AVCoreLog.isColorLevel()) {
            AVCoreLog.i(TAG, "notifyUpdateUI, event handler is null.");
        }
    }

    private static void onNativeNotify(Object obj, int i3, Object obj2) {
        NtrtcVideoRenderTexture ntrtcVideoRenderTexture;
        if (obj != null && (ntrtcVideoRenderTexture = (NtrtcVideoRenderTexture) ((WeakReference) obj).get()) != null) {
            if (i3 == 0) {
                ntrtcVideoRenderTexture.notifyUpdateUI(0, 0, obj2);
                return;
            }
            if (i3 == 2) {
                ntrtcVideoRenderTexture.notifyUpdateUI(2, 0, obj2);
            } else if (i3 == 1) {
                ntrtcVideoRenderTexture.notifyUpdateUI(1, 0, obj2);
            } else if (i3 == 3) {
                ntrtcVideoRenderTexture.notifyUpdateUI(3, 0, obj2);
            }
        }
    }

    public native boolean canRender();

    public native void flush(boolean z16);

    public native int getCameraFrameDes();

    public native int getCaptureFrameHeight();

    public native byte[] getCaptureFrameTexture();

    public native int getCaptureFrameWidth();

    public native byte[] getFaceFeature();

    public native int getImgAngle();

    public native int getImgHeight();

    public native int getImgWidth();

    public long getNativeContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.mNativeContext;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        IGLRenderTexture iGLRenderTexture = this.mTexture;
        if (iGLRenderTexture != null) {
            iGLRenderTexture.nativeFrameDataUpdate();
        }
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 == 3 && this.mTexture != null) {
                        if (this.mStringParser == null) {
                            this.mStringParser = new GlStringParser('=', ';');
                        }
                        this.mStringParser.unflatten((String) message.obj);
                        this.mTexture.onRenderInfoNotify(this.mStringParser.getInt("width"), this.mStringParser.getInt("height"), this.mStringParser.getInt("angle"), this.mStringParser.getInt(BasicAnimation.KeyPath.ROTATION, -1));
                    }
                } else {
                    IGLRenderTexture iGLRenderTexture2 = this.mTexture;
                    if (iGLRenderTexture2 != null) {
                        iGLRenderTexture2.onRenderReset();
                    }
                }
            } else {
                IGLRenderTexture iGLRenderTexture3 = this.mTexture;
                if (iGLRenderTexture3 != null) {
                    iGLRenderTexture3.onRenderFlush();
                }
            }
        } else {
            IGLRenderTexture iGLRenderTexture4 = this.mTexture;
            if (iGLRenderTexture4 != null) {
                iGLRenderTexture4.onRenderFrame();
            }
        }
        return true;
    }

    public native void init(int i3, Object obj, long j3);

    public native void onPause();

    public native void onResume();

    public native void uninit();

    public native boolean updateCurFrame();

    public native int uploadContent(int[] iArr);
}
