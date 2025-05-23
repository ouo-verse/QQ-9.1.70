package com.tencent.mobileqq.troop.homework.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import tencent.im.troop.homework$ReqSend1V1Msg;
import tencent.im.troop.homework$RspSend1V1Msg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a implements BusinessObserver {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static int f297332d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f297333e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f297334f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f297335h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f297336i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f297337m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28584);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        int i3 = 0 + 1;
        f297333e = 0;
        int i16 = i3 + 1;
        f297334f = i3;
        int i17 = i16 + 1;
        f297335h = i16;
        int i18 = i17 + 1;
        f297336i = i17;
        f297332d = i18 + 1;
        f297337m = i18;
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void f(int i3, boolean z16, Object obj) {
        if (i3 != f297333e) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        d(z16, (String) objArr[0], (String) objArr[1], ((Integer) objArr[2]).intValue(), (String) objArr[3], (String) objArr[4]);
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f297334f) {
            return;
        }
        int i16 = 0;
        long j3 = -1;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                j3 = ((Long) objArr[0]).longValue();
            }
            if (objArr.length > 1) {
                i16 = ((Integer) objArr[1]).intValue();
            }
        }
        a(z16, j3, i16);
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 != f297337m) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        b(z16, (homework$RspSend1V1Msg) objArr[0], (homework$ReqSend1V1Msg) objArr[1]);
    }

    private void i(int i3, boolean z16, Object obj) {
        com.tencent.mobileqq.troop.homework.a aVar;
        if (i3 != f297335h) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                aVar = (com.tencent.mobileqq.troop.homework.a) objArr[0];
                c(z16, aVar);
            }
        }
        aVar = null;
        c(z16, aVar);
    }

    private void j(int i3, boolean z16, Object obj) {
        int i16;
        if (i3 != f297336i) {
            return;
        }
        if (obj != null && (obj instanceof Integer)) {
            i16 = ((Integer) obj).intValue();
        } else {
            i16 = 0;
        }
        e(z16, i16);
    }

    public void a(boolean z16, long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3));
        }
    }

    protected void b(boolean z16, homework$RspSend1V1Msg homework_rspsend1v1msg, homework$ReqSend1V1Msg homework_reqsend1v1msg) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), homework_rspsend1v1msg, homework_reqsend1v1msg);
        }
    }

    public void c(boolean z16, com.tencent.mobileqq.troop.homework.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), aVar);
        }
    }

    public void d(boolean z16, String str, String str2, int i3, String str3, String str4) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), str, str2, Integer.valueOf(i3), str3, str4);
        }
    }

    public void e(boolean z16, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), Integer.valueOf(i3));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        g(i3, z16, obj);
        f(i3, z16, obj);
        i(i3, z16, obj);
        j(i3, z16, obj);
        h(i3, z16, obj);
    }
}
