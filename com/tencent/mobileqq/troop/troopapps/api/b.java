package com.tencent.mobileqq.troop.troopapps.api;

import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xe83.oidb_0xe83$RspBody;
import tencent.im.oidb.inner.cmd0xca05.cmd0xca05$Result;

/* compiled from: P */
/* loaded from: classes19.dex */
public class b implements BusinessObserver {
    static IPatchRedirector $redirector_;
    public static final int C;

    /* renamed from: d, reason: collision with root package name */
    private static int f299362d;

    /* renamed from: e, reason: collision with root package name */
    public static final int f299363e;

    /* renamed from: f, reason: collision with root package name */
    public static final int f299364f;

    /* renamed from: h, reason: collision with root package name */
    public static final int f299365h;

    /* renamed from: i, reason: collision with root package name */
    public static final int f299366i;

    /* renamed from: m, reason: collision with root package name */
    public static final int f299367m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29086);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        int i3 = 0 + 1;
        f299363e = 0;
        int i16 = i3 + 1;
        f299364f = i3;
        int i17 = i16 + 1;
        f299365h = i16;
        int i18 = i17 + 1;
        f299366i = i17;
        int i19 = i18 + 1;
        f299367m = i18;
        f299362d = i19 + 1;
        C = i19;
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void g(int i3, boolean z16, Object obj) {
        if (i3 != f299366i) {
            return;
        }
        Object[] objArr = (Object[]) obj;
        c((oidb_0xe83$RspBody) objArr[0], ((Integer) objArr[1]).intValue());
    }

    private void h(int i3, boolean z16, Object obj) {
        if (i3 != C) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                b(z16, ((Long) objArr[0]).longValue(), objArr[1], ((Integer) objArr[2]).intValue());
                return;
            } else {
                b(false, 0L, null, -1);
                return;
            }
        }
        b(false, 0L, null, -1);
    }

    private void i(int i3, boolean z16, Object obj) {
        if (i3 != f299367m) {
            return;
        }
        if (obj != null && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length == 3) {
                d(z16, objArr[0], objArr[1], ((Integer) objArr[2]).intValue());
                return;
            } else {
                d(false, null, null, -1);
                return;
            }
        }
        d(false, null, null, -1);
    }

    private void j(int i3, boolean z16, Object obj) {
        if (i3 == f299365h && (obj instanceof Object[])) {
            Object[] objArr = (Object[]) obj;
            a(Boolean.valueOf(z16), (ArrayList) objArr[0], (List) objArr[1]);
        }
    }

    private void k(int i3, boolean z16, Object obj) {
        if (i3 != f299363e) {
            return;
        }
        e(Boolean.valueOf(z16));
    }

    private void l(int i3, boolean z16, Object obj) {
        if (i3 != f299364f) {
            return;
        }
        f(Boolean.valueOf(z16));
    }

    protected void a(Boolean bool, ArrayList<Integer> arrayList, List<cmd0xca05$Result> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, bool, arrayList, list);
        }
    }

    protected void b(boolean z16, long j3, Object obj, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Boolean.valueOf(z16), Long.valueOf(j3), obj, Integer.valueOf(i3));
        }
    }

    protected void c(oidb_0xe83$RspBody oidb_0xe83_rspbody, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) oidb_0xe83_rspbody, i3);
        }
    }

    public void d(boolean z16, Object obj, Object obj2, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Boolean.valueOf(z16), obj, obj2, Integer.valueOf(i3));
        }
    }

    protected void e(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bool);
        }
    }

    protected void f(Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) bool);
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Boolean.valueOf(z16), obj);
            return;
        }
        j(i3, z16, obj);
        g(i3, z16, obj);
        k(i3, z16, obj);
        l(i3, z16, obj);
        i(i3, z16, obj);
        h(i3, z16, obj);
    }
}
