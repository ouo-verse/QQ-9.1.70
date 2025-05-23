package com.tencent.mobileqq.troop.api.observer;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int C;
    public static final int D;
    public static final int E;
    public static final int F;
    public static final int G;
    public static final int H;

    /* renamed from: d, reason: collision with root package name */
    private static int f294306d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f294307e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f294308f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f294309h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f294310i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f294311m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42029);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        int i3 = 0 + 1;
        f294307e = 0;
        int i16 = i3 + 1;
        f294308f = i3;
        int i17 = i16 + 1;
        f294309h = i16;
        int i18 = i17 + 1;
        f294310i = i17;
        int i19 = i18 + 1;
        f294311m = i18;
        int i26 = i19 + 1;
        C = i19;
        int i27 = i26 + 1;
        D = i26;
        int i28 = i27 + 1;
        E = i27;
        int i29 = i28 + 1;
        F = i28;
        int i36 = i29 + 1;
        G = i29;
        f294306d = i36 + 1;
        H = i36;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void n(int i3, boolean z16, Object obj) {
        if (i3 == G && obj != null && (obj instanceof String)) {
            b((String) obj);
        }
    }

    private void o(int i3, boolean z16, Object obj) {
        if (i3 != f294311m) {
            return;
        }
        if (obj instanceof String) {
            c((String) obj);
        } else {
            c(null);
        }
    }

    private void p(int i3, boolean z16, Object obj) {
        if (i3 == C && (obj instanceof Object[])) {
            a((String) ((Object[]) obj)[0]);
        }
    }

    private void q(int i3, boolean z16, Object obj) {
        if (i3 != F) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            d(z16, ((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), ((Integer) objArr[2]).intValue(), (ArrayList) objArr[3], ((Integer) objArr[4]).intValue());
        } else {
            d(false, -1, 0, 0, null, 0);
        }
    }

    private void r(int i3, boolean z16, Object obj) {
        if (i3 == E && obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 5) {
                f(z16, ((Integer) objArr[0]).intValue(), (String) objArr[1], (String) objArr[2], (String) objArr[3], ((Integer) objArr[4]).intValue());
            } else if (objArr.length == 2) {
                g(z16, (String) objArr[0], ((Integer) objArr[1]).intValue());
            }
        }
    }

    private void s(int i3, boolean z16, Object obj) {
        if (i3 != H) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        h(z16, ((Long) objArr[0]).longValue(), ((Integer) objArr[1]).intValue(), (TroopInfo) objArr[2]);
    }

    private void t(int i3, boolean z16, Object obj) {
        if (i3 != f294310i) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        i(z16, ((Long) objArr[0]).longValue(), (TroopInfo) objArr[1]);
    }

    private void u(int i3, boolean z16, Object obj) {
        if (i3 != f294309h) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        e(z16, ((Long) objArr[0]).longValue(), (String) objArr[1], (String) objArr[2], ((Integer) objArr[3]).intValue(), (String) objArr[4]);
    }

    private void v(int i3, boolean z16, Object obj) {
        if (i3 == D && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            int i16 = 0;
            if (objArr.length >= 1) {
                i16 = ((Integer) objArr[0]).intValue();
            }
            int i17 = i16;
            if (z16 && objArr.length >= 4) {
                j(z16, i17, (String) objArr[1], (String) objArr[2], (Boolean) objArr[3]);
            } else {
                j(z16, i17, null, null, Boolean.TRUE);
            }
        }
    }

    private void w(int i3, boolean z16, Object obj) {
        int byteValue;
        if (i3 != f294307e) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        Object obj2 = objArr[1];
        if (obj2 instanceof Integer) {
            byteValue = ((Integer) obj2).intValue();
        } else {
            byteValue = ((Byte) obj2).byteValue();
        }
        if (z16) {
            l(((Integer) objArr[0]).intValue(), byteValue, (String) objArr[2]);
        } else {
            k(((Integer) objArr[0]).intValue(), byteValue);
        }
    }

    private void x(int i3, boolean z16, Object obj) {
        TroopInfo troopInfo;
        if (i3 != f294308f) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        byte byteValue = ((Byte) objArr[0]).byteValue();
        Object obj2 = objArr[1];
        if (obj2 != null) {
            troopInfo = (TroopInfo) obj2;
        } else {
            troopInfo = null;
        }
        m(true, byteValue, troopInfo, ((Boolean) objArr[2]).booleanValue());
    }

    protected void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
    }

    protected void b(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        }
    }

    protected void c(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
    }

    protected void d(boolean z16, int i3, int i16, int i17, ArrayList<String> arrayList, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Boolean.valueOf(z16), Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), arrayList, Integer.valueOf(i18));
        }
    }

    protected void e(boolean z16, long j3, String str, String str2, int i3, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Boolean.valueOf(z16), Long.valueOf(j3), str, str2, Integer.valueOf(i3), str3);
        }
    }

    protected void f(boolean z16, int i3, String str, String str2, String str3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, str3, Integer.valueOf(i16));
        }
    }

    protected void g(boolean z16, String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, Boolean.valueOf(z16), str, Integer.valueOf(i3));
        }
    }

    protected void h(boolean z16, long j3, int i3, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3), Integer.valueOf(i3), troopInfo);
        }
    }

    protected void i(boolean z16, long j3, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), Long.valueOf(j3), troopInfo);
        }
    }

    protected void j(boolean z16, int i3, String str, String str2, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Boolean.valueOf(z16), Integer.valueOf(i3), str, str2, bool);
        }
    }

    protected void k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void l(int i3, int i16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str);
        }
    }

    protected void m(boolean z16, byte b16, TroopInfo troopInfo, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Boolean.valueOf(z16), Byte.valueOf(b16), troopInfo, Boolean.valueOf(z17));
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        w(i3, z16, obj);
        x(i3, z16, obj);
        o(i3, z16, obj);
        u(i3, z16, obj);
        s(i3, z16, obj);
        t(i3, z16, obj);
        p(i3, z16, obj);
        v(i3, z16, obj);
        r(i3, z16, obj);
        q(i3, z16, obj);
        n(i3, z16, obj);
    }
}
