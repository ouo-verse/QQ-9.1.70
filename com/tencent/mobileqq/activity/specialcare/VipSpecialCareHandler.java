package com.tencent.mobileqq.activity.specialcare;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.cn;
import com.tencent.mobileqq.emosm.web.IPCConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes10.dex */
public class VipSpecialCareHandler extends cn implements IPCConstants {
    static IPatchRedirector $redirector_;
    private final int C;

    /* renamed from: d, reason: collision with root package name */
    private Bundle f186552d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f186553e;

    /* renamed from: f, reason: collision with root package name */
    private volatile int f186554f;

    /* renamed from: h, reason: collision with root package name */
    private HandlerThread f186555h;

    /* renamed from: i, reason: collision with root package name */
    private Handler f186556i;

    /* renamed from: m, reason: collision with root package name */
    private final int f186557m;

    public VipSpecialCareHandler() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f186552d = null;
        this.f186553e = null;
        this.f186554f = 0;
        this.f186555h = null;
        this.f186556i = null;
        this.f186557m = 1;
        this.C = 90000;
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler.1
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.activity.specialcare.VipSpecialCareHandler$1$a */
            /* loaded from: classes10.dex */
            class a extends Handler {
                static IPatchRedirector $redirector_;

                a(Looper looper) {
                    super(looper);
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) looper);
                    }
                }

                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                    } else if (message.what == 1) {
                        VipSpecialCareHandler.this.j("-->request timeout");
                        VipSpecialCareHandler.this.k(-2);
                    }
                }
            }

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) VipSpecialCareHandler.this);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                VipSpecialCareHandler.this.f186555h = ThreadManagerV2.newFreeHandlerThread("special-timer", 0);
                VipSpecialCareHandler.this.f186555h.start();
                Looper looper = VipSpecialCareHandler.this.f186555h.getLooper();
                if (looper == null) {
                    return;
                }
                VipSpecialCareHandler.this.f186556i = new a(looper);
            }
        }, 8, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("VipSpecialCareHandler", 2, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k(int i3) {
        int i16 = this.f186554f - 1;
        this.f186554f = i16;
        if (i16 != 0) {
            j("-->warning:special care set,uncorrect state,seq=" + this.f186554f);
            this.f186554f = 0;
        }
        try {
            Bundle bundle = this.f186553e;
            if (i3 == 0) {
                i3 = 0;
            }
            bundle.putInt("error", i3);
            this.f186552d.putBundle("response", this.f186553e);
            i(this.f186552d);
        } catch (NullPointerException e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.app.cn
    public void a(Object obj) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, obj);
            return;
        }
        if (obj != null) {
            i3 = ((Integer) obj).intValue();
            if (i3 == 10010) {
                j("-->error:set quota limit");
            } else {
                j("-->error:" + i3);
            }
        } else {
            i3 = -1;
        }
        Handler handler = this.f186556i;
        if (handler != null) {
            handler.removeMessages(1);
        }
        k(i3);
    }

    @Override // com.tencent.mobileqq.app.cn
    public void b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, obj);
            return;
        }
        if (obj != null) {
            int intValue = ((Integer) obj).intValue();
            if (intValue != 2) {
                if (intValue != 3) {
                    if (intValue == 4) {
                        j("-->method_type_delete_sound");
                    }
                } else {
                    j("-->method_type_set_sound");
                }
            } else {
                j("-->method_type_open_switch");
            }
        }
        Handler handler = this.f186556i;
        if (handler != null) {
            handler.removeMessages(1);
        }
        k(0);
    }

    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Handler handler = this.f186556i;
        if (handler != null) {
            handler.removeMessages(1);
        }
        HandlerThread handlerThread = this.f186555h;
        if (handlerThread != null) {
            handlerThread.quitSafely();
        }
    }

    public void i(Bundle bundle) {
        throw null;
    }

    public void l(QQAppInterface qQAppInterface, String str, Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, qQAppInterface, str, bundle, bundle2);
            return;
        }
        if (this.f186554f != 0) {
            j("-->current request is ongoing,can't do request yet");
            bundle2.putInt("error", -1);
            bundle.putBundle("response", bundle2);
            i(bundle);
            return;
        }
        this.f186554f++;
        j("-->do request,seq=" + this.f186554f);
        try {
            m(bundle, bundle2);
            if ("sepcial_care_delete_ring".equals(str) || "special_care_set_ring".equals(str)) {
                Bundle bundle3 = bundle.getBundle(Const.BUNDLE_KEY_REQUEST);
                int i3 = bundle3.getInt("id", 1);
                String string = bundle3.getString("uin");
                if (string == null) {
                    string = "";
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(string);
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(String.valueOf(i3));
                Handler handler = this.f186556i;
                if (handler != null) {
                    handler.sendEmptyMessageDelayed(1, 90000L);
                }
                if ("special_care_set_ring".equals(str)) {
                    if (i3 == 1) {
                        e.s(arrayList, 2, arrayList2, qQAppInterface);
                    } else {
                        e.s(arrayList, 3, arrayList2, qQAppInterface);
                    }
                    qQAppInterface.getApp().getSharedPreferences("com.tencent.mobileqq_preferences", 4).edit().putBoolean("specialcare_already_set" + string, true).commit();
                    return;
                }
                e.s(arrayList, 4, arrayList2, qQAppInterface);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
            this.f186554f = 0;
        }
    }

    public final void m(Bundle bundle, Bundle bundle2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) bundle, (Object) bundle2);
        } else {
            this.f186552d = bundle;
            this.f186553e = bundle2;
        }
    }
}
