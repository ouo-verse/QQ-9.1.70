package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import com.heytap.msp.push.HeytapPushManager;
import com.heytap.msp.push.callback.ICallBackResultService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d extends ThirdPushProcessorImpl {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements ICallBackResultService {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
            }
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetNotificationStatus(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == 0 && i16 == 0) {
                z16 = true;
            }
            if (z16) {
                QLog.d("OPUSH", 1, "onGetNotificationStatus OK");
                return;
            }
            QLog.e("OPUSH", 1, "onGetNotificationStatus error code:" + i3 + ",status=" + i16);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onGetPushStatus(int i3, int i16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = false;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16));
                return;
            }
            if (i3 == 0 && i16 == 0) {
                z16 = true;
            }
            if (z16) {
                QLog.d("OPUSH", 1, "onGetPushStatus OK");
                return;
            }
            QLog.e("OPUSH", 1, "onGetPushStatus error code:" + i3 + ",status=" + i16);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onRegister(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
                return;
            }
            if (i3 == 0) {
                d.this.a(str);
            }
            QLog.i("OPUSH", 1, "onRegister code:" + i3 + ",msg=" + str);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onSetPushTime(int i3, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) str);
                return;
            }
            QLog.d("OPUSH", 1, "onSetPushTime code:" + i3 + ",result=" + str);
        }

        @Override // com.heytap.msp.push.callback.ICallBackResultService
        public void onUnRegister(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, i3);
                return;
            }
            if (i3 == 0) {
                QLog.d("OPUSH", 1, "onUnRegister succeed");
                return;
            }
            QLog.e("OPUSH", 1, "onUnRegister error code = " + i3);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        try {
            HeytapPushManager.init(BaseApplication.getContext(), true);
        } catch (Exception e16) {
            QLog.e("OPUSH", 1, "init error! ", e16);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void b(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
        } else {
            super.b(context);
        }
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl, com.tencent.mobileqq.pushnotice.proxy.c
    public void d() {
        BaseApplication context;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            context = BaseApplication.getContext();
        } catch (Exception e16) {
            QLog.e("OPUSH", 1, "registerPush error! ", e16);
        }
        if (!l()) {
            return;
        }
        HeytapPushManager.register(context, "b5808b3d9wGkWsoW4C4sO40wo", "7BCae2b64B939196D86210a12B024508", new a());
        j();
    }

    @Override // com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl
    public boolean l() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        try {
            z16 = HeytapPushManager.isSupportPush();
            try {
                QLog.i("OPUSH", 1, "isSupport=" + z16);
            } catch (Exception e16) {
                e = e16;
                QLog.e("OPUSH", 1, "isSupport error! ", e);
                return z16;
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        return z16;
    }
}
