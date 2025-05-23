package com.tencent.mobileqq.troop.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.essence.data.TroopCardEssenceMsg;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class f implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int C;

    /* renamed from: d, reason: collision with root package name */
    private static int f298013d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f298014e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f298015f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f298016h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f298017i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f298018m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        int i3 = 0 + 1;
        f298014e = 0;
        int i16 = i3 + 1;
        f298015f = i3;
        int i17 = i16 + 1;
        f298016h = i16;
        int i18 = i17 + 1;
        f298017i = i17;
        int i19 = i18 + 1;
        f298018m = i18;
        f298013d = i19 + 1;
        C = i19;
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f298015f) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                a(z16, ((Long) objArr[0]).longValue(), objArr[1], objArr[2], ((Integer) objArr[3]).intValue());
                return;
            } else {
                a(false, 0L, null, null, -1);
                return;
            }
        }
        a(false, 0L, null, null, -1);
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 == C && (obj instanceof Long)) {
            b(((Long) obj).longValue());
        }
    }

    private void i(int i3, boolean z16, Object obj) {
        String str;
        int i16;
        List<TroopCardEssenceMsg> list;
        if (i3 != f298016h) {
            return;
        }
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                int i17 = 0;
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
                String str2 = str;
                Object obj3 = objArr[1];
                if (obj3 instanceof Integer) {
                    i16 = ((Integer) obj3).intValue();
                } else {
                    i16 = 0;
                }
                ArrayList arrayList = new ArrayList();
                Object obj4 = objArr[2];
                if (obj4 instanceof List) {
                    list = (List) obj4;
                } else {
                    list = arrayList;
                }
                Object obj5 = objArr[3];
                if (obj5 instanceof Integer) {
                    i17 = ((Integer) obj5).intValue();
                }
                d(z16, str2, i16, list, i17);
                return;
            }
            d(false, null, 0, null, 0);
            return;
        }
        d(false, null, 0, null, 0);
    }

    private void j(int i3, boolean z16, Object obj) {
        if (i3 != f298014e) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 4) {
                e(z16, objArr[0], objArr[1], ((Integer) objArr[2]).intValue(), ((Integer) objArr[3]).intValue());
                return;
            } else {
                e(false, null, null, -1, 0);
                return;
            }
        }
        e(false, null, null, -1, 0);
    }

    private void k(int i3, boolean z16, Object obj) {
        if (i3 != f298017i) {
            return;
        }
        String str = null;
        boolean z17 = false;
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                }
                Object obj3 = objArr[1];
                if (obj3 instanceof Boolean) {
                    z17 = ((Boolean) obj3).booleanValue();
                }
                f(z16, str, z17);
                return;
            }
            return;
        }
        f(z16, null, false);
    }

    private void l(int i3, boolean z16, Object obj) {
        if (i3 != f298018m) {
            return;
        }
        String str = null;
        boolean z17 = false;
        if (obj != null) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 2) {
                Object obj2 = objArr[0];
                if (obj2 instanceof String) {
                    str = (String) obj2;
                }
                Object obj3 = objArr[1];
                if (obj3 instanceof Boolean) {
                    z17 = ((Boolean) obj3).booleanValue();
                }
                c(z16, str, z17);
                return;
            }
            return;
        }
        c(z16, null, false);
    }

    protected void a(boolean z16, long j3, Object obj, Object obj2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Long.valueOf(j3), obj, obj2, Integer.valueOf(i3));
        }
    }

    protected void b(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
        }
    }

    protected void c(boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
    }

    protected void d(boolean z16, String str, int i3, List<TroopCardEssenceMsg> list, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Boolean.valueOf(z16), str, Integer.valueOf(i3), list, Integer.valueOf(i16));
        }
    }

    protected void e(boolean z16, Object obj, Object obj2, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(z16), obj, obj2, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    protected void f(boolean z16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), str, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        j(i3, z16, obj);
        g(i3, z16, obj);
        i(i3, z16, obj);
        k(i3, z16, obj);
        h(i3, z16, obj);
        l(i3, z16, obj);
    }
}
