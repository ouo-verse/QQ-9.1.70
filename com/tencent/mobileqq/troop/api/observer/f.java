package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.api.handler.ITroopPushHandler;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int C;

    /* renamed from: d, reason: collision with root package name */
    private static int f294317d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f294318e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f294319f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f294320h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f294321i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f294322m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42129);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        int i3 = 0 + 1;
        f294318e = 0;
        int i16 = i3 + 1;
        f294319f = i3;
        int i17 = i16 + 1;
        f294320h = i16;
        int i18 = i17 + 1;
        f294321i = i17;
        int i19 = i18 + 1;
        f294322m = i18;
        f294317d = i19 + 1;
        C = i19;
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void f(int i3, boolean z16, Object obj) {
        if (i3 == f294318e && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            b((String) objArr[0], ((Integer) objArr[1]).intValue(), (ITroopPushHandler.PushType) objArr[2]);
        }
    }

    private void g(int i3, Object obj) {
        if (i3 == f294322m && (obj instanceof String)) {
            a((String) obj);
        }
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 == f294319f && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof Long) {
                        c(z16, (String) obj2, ((Long) obj3).longValue());
                    }
                }
            }
        }
    }

    private void i(int i3, boolean z16, Object obj) {
        if (i3 == f294321i && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof Integer) {
                        d(z16, (String) obj2, ((Integer) obj3).intValue());
                    }
                }
            }
        }
    }

    private void j(int i3, Object obj) {
        if (i3 == C && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    Object obj3 = objArr[1];
                    if (obj3 instanceof Boolean) {
                        e((String) obj2, ((Boolean) obj3).booleanValue());
                    }
                }
            }
        }
    }

    protected void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, int i3, ITroopPushHandler.PushType pushType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), pushType);
        }
    }

    protected void c(boolean z16, String str, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Long.valueOf(j3));
        }
    }

    protected void d(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    protected void e(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        f(i3, z16, obj);
        i(i3, z16, obj);
        h(i3, z16, obj);
        g(i3, obj);
        j(i3, obj);
    }
}
