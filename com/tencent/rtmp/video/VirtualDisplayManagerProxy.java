package com.tencent.rtmp.video;

import android.app.Activity;
import android.media.projection.MediaProjection;
import android.view.Surface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.rtmp.video.a.f;
import com.tencent.rtmp.video.a.i;
import com.tencent.rtmp.video.a.j;
import java.lang.ref.WeakReference;

/* loaded from: classes25.dex */
public class VirtualDisplayManagerProxy {
    static IPatchRedirector $redirector_;
    private static volatile VirtualDisplayManagerProxy sInstance;
    private f mVirtualDisplayManager;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(14989);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            sInstance = null;
        }
    }

    VirtualDisplayManagerProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mVirtualDisplayManager = new f();
        }
    }

    public static VirtualDisplayManagerProxy getInstance() {
        if (sInstance == null) {
            synchronized (VirtualDisplayManagerProxy.class) {
                if (sInstance == null) {
                    sInstance = new VirtualDisplayManagerProxy();
                }
            }
        }
        return sInstance;
    }

    public void registerRequestPermissionActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
        } else {
            this.mVirtualDisplayManager.a(activity);
        }
    }

    public void signalSessionRequestFinish(MediaProjection mediaProjection) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) mediaProjection);
        } else {
            this.mVirtualDisplayManager.a(mediaProjection);
        }
    }

    public void startVirtualDisplaySync(Surface surface, int i3, int i16, MediaProjection mediaProjection, VirtualDisplayListener virtualDisplayListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, surface, Integer.valueOf(i3), Integer.valueOf(i16), mediaProjection, virtualDisplayListener);
            return;
        }
        f fVar = this.mVirtualDisplayManager;
        BaseBridge.printLog("VirtualDisplayManager", "startVirtualDisplaySync, surface:" + surface + ", width:" + i3 + ", height:" + i16 + ", mediaProjection: " + mediaProjection + ", listener:" + virtualDisplayListener + ". version:12.3.0.41603");
        fVar.f368834c.b(i.a(fVar, surface, i3, i16, mediaProjection, virtualDisplayListener));
    }

    public void stopVirtualDisplaySync(Surface surface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) surface);
            return;
        }
        f fVar = this.mVirtualDisplayManager;
        BaseBridge.printLog("VirtualDisplayManager", "stopVirtualDisplaySync, surface:".concat(String.valueOf(surface)));
        fVar.f368834c.b(j.a(fVar, surface));
    }

    public void unRegisterRequestPermissionActivity(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) activity);
            return;
        }
        f fVar = this.mVirtualDisplayManager;
        BaseBridge.printLog("VirtualDisplayManager", "UnRegister request permission activity:".concat(String.valueOf(activity)));
        WeakReference<Activity> weakReference = fVar.f368832a;
        if (weakReference != null && weakReference.get() == activity) {
            fVar.f368832a = null;
        }
    }
}
