package com.tencent.mobileqq.managers;

import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statustitle.api.IBaseStatusTitleBarApi;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static b f243704e;

    /* renamed from: a, reason: collision with root package name */
    private int f243705a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f243706b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f243707c;

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f243708d;

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f243705a = 1;
        this.f243706b = false;
        this.f243707c = false;
        this.f243708d = false;
        if (NetConnInfoCenter.socketConnState == 4) {
            this.f243705a = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoadingStateManager", 2, "LoadingStateManager init loadingstate = " + this.f243705a);
        }
    }

    public static b b() {
        if (f243704e == null) {
            f243704e = new b();
        }
        return f243704e;
    }

    private void d(FromServiceMsg fromServiceMsg, QQAppInterface qQAppInterface) {
        if (fromServiceMsg == null || fromServiceMsg.getAttribute(BaseConstants.Attribute_TAG_SOCKET_ADDRESS) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoadingStateManager", 2, "handleIsNotIllegalNetWorkNotify mShowIllegalNetworkBar=" + this.f243706b + " mShowErrorNetworkBar=" + this.f243707c);
        }
        MqqHandler handler = qQAppInterface.getHandler(Conversation.class);
        if (handler != null) {
            handler.obtainMessage(Conversation.MSG_ON_RECEIVE_RESPONSE, (Runnable) null).sendToTarget();
        }
        if (!this.f243706b && !this.f243707c) {
            return;
        }
        if (this.f243707c) {
            if (handler != null) {
                handler.obtainMessage(10002, (Runnable) null).sendToTarget();
            }
            ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(5, null);
            return;
        }
        if (!f()) {
            k(0, "handleIsNotIllegalNetWorkNotify");
        }
        if (QLog.isColorLevel()) {
            QLog.d("LoadingStateManager", 2, "notifyIsNotIllegalNetWork");
        }
        if (handler != null) {
            handler.obtainMessage(Conversation.MSG_ILLEGALNETWORK_CLOSE, (Runnable) null).sendToTarget();
        }
        ((IBaseStatusTitleBarApi) QRoute.api(IBaseStatusTitleBarApi.class)).notifyNetWorkState(7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void h(FromServiceMsg fromServiceMsg, QQAppInterface qQAppInterface) {
        d(fromServiceMsg, qQAppInterface);
        this.f243708d = false;
    }

    public int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        return this.f243705a;
    }

    public boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        if (this.f243705a == 4) {
            return true;
        }
        return false;
    }

    public boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        if (this.f243705a == 3) {
            return true;
        }
        return false;
    }

    public boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.f243706b;
    }

    public void i(final FromServiceMsg fromServiceMsg, final QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) fromServiceMsg, (Object) qQAppInterface);
        } else {
            if (this.f243708d) {
                return;
            }
            this.f243708d = true;
            ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.mobileqq.managers.a
                @Override // java.lang.Runnable
                public final void run() {
                    b.this.h(fromServiceMsg, qQAppInterface);
                }
            }, 16, null, false, 1000L);
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            f243704e = null;
        }
    }

    public void k(int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("LoadingStateManager", 2, "setLoadingState state = " + this.f243705a + "->" + i3 + " reason= " + str);
        }
        this.f243705a = i3;
    }

    public void l(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.f243707c = z16;
        }
    }

    public void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
        } else {
            this.f243706b = z16;
        }
    }

    public boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        int i3 = this.f243705a;
        if (i3 == 1 || i3 == 2) {
            return true;
        }
        return false;
    }
}
