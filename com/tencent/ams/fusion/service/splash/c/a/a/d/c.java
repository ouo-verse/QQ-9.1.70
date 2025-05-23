package com.tencent.ams.fusion.service.splash.c.a.a.d;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.ams.fusion.a.i;
import com.tencent.ams.fusion.a.j;
import com.tencent.ams.fusion.service.splash.model.SplashOrder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends com.tencent.ams.fusion.service.splash.c.a.a.d.a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private SplashOrder f70455d;

    /* renamed from: e, reason: collision with root package name */
    private long f70456e;

    /* renamed from: f, reason: collision with root package name */
    private int f70457f;

    /* renamed from: g, reason: collision with root package name */
    private SplashOrder f70458g;

    /* renamed from: h, reason: collision with root package name */
    private List<SplashOrder> f70459h;

    /* renamed from: i, reason: collision with root package name */
    private List<com.tencent.ams.fusion.service.splash.c.a.a.c.a.a> f70460i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f70461j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements Comparator<SplashOrder> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f70462d;

        a(String str) {
            this.f70462d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) c.this, (Object) str);
            }
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SplashOrder splashOrder, SplashOrder splashOrder2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) splashOrder, (Object) splashOrder2)).intValue();
            }
            if (splashOrder == null && splashOrder2 == null) {
                return 0;
            }
            if (splashOrder != null && splashOrder2 != null) {
                return Integer.compare(splashOrder2.G(this.f70462d), splashOrder.G(this.f70462d));
            }
            if (splashOrder == null) {
                return 1;
            }
            return -1;
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f70459h = new ArrayList();
        this.f70460i = new ArrayList();
        this.f70461j = false;
    }

    private boolean A(SplashOrder splashOrder, String str) {
        if (splashOrder == null) {
            com.tencent.ams.fusion.a.f.a("isOrderInPlayTime, order == null");
            return false;
        }
        if (com.tencent.ams.fusion.service.splash.a.a.d().B()) {
            return true;
        }
        List<Pair<Integer, Integer>> F = splashOrder.F(str);
        if (j.b(F)) {
            com.tencent.ams.fusion.a.f.a("isOrderInPlayTime, effectTimeArrayList is empty.");
            return true;
        }
        boolean z16 = true;
        for (Pair<Integer, Integer> pair : F) {
            com.tencent.ams.fusion.a.f.a("isOrderInPlayTime, timeRange: " + pair);
            if (pair != null) {
                int intValue = ((Integer) pair.first).intValue();
                int intValue2 = ((Integer) pair.second).intValue();
                if (intValue < 0) {
                    intValue = 0;
                }
                if (intValue2 > 1440) {
                    intValue2 = 1440;
                }
                if (intValue < intValue2) {
                    com.tencent.ams.fusion.a.f.a("isOrderInPlayTime, start: " + intValue + ", end: " + intValue2 + ", current: " + this.f70456e);
                    long j3 = this.f70456e;
                    if (j3 <= intValue2 && j3 >= intValue) {
                        return true;
                    }
                } else {
                    com.tencent.ams.fusion.a.f.a("isOrderInPlayTime, start should < end, start: " + intValue + ", end: " + intValue2);
                }
                z16 = false;
            }
        }
        return z16;
    }

    private boolean B(SplashOrder splashOrder) {
        if (splashOrder == null) {
            com.tencent.ams.fusion.a.f.g("isValidEffectOrder order null");
            return false;
        }
        if (splashOrder.az() != 1) {
            return false;
        }
        if (splashOrder.bk()) {
            if (this.f70458g == null) {
                com.tencent.ams.fusion.a.f.g("isValidEffectOrder order isEmpty");
                this.f70458g = splashOrder;
            }
            return false;
        }
        if ((!this.f70461j && com.tencent.ams.fusion.service.splash.a.a.d().C()) || splashOrder.aA()) {
            return true;
        }
        com.tencent.ams.fusion.a.f.g("isValidEffectOrder order src not ready");
        return false;
    }

    private boolean C(SplashOrder splashOrder) {
        pt.b s16 = s();
        if (splashOrder == null || s16 == null || s16.a() == null) {
            return false;
        }
        ot.c a16 = s16.a();
        if (splashOrder.bh() == 1 && a16.a() && a16.g()) {
            return false;
        }
        return true;
    }

    private boolean D(SplashOrder splashOrder) {
        if (splashOrder == null) {
            return true;
        }
        int bd5 = splashOrder.bd();
        int a16 = i.a(splashOrder);
        if (bd5 == Integer.MIN_VALUE || a16 < bd5) {
            return false;
        }
        com.tencent.ams.fusion.a.f.a("oid: " + splashOrder.bn() + " hasReachLimit!");
        return true;
    }

    private long E() {
        Calendar.getInstance().setTimeInMillis(System.currentTimeMillis());
        return (r0.get(11) * 60) + r0.get(12);
    }

    private boolean F(SplashOrder splashOrder) {
        if (j.b(this.f70459h)) {
            return false;
        }
        for (SplashOrder splashOrder2 : this.f70459h) {
            if (splashOrder2 != null && splashOrder != null && TextUtils.equals(splashOrder2.bn(), splashOrder.bn())) {
                return true;
            }
        }
        return false;
    }

    private void t(com.tencent.ams.fusion.service.splash.c.a.a.c.a.a aVar) {
        if (aVar == null) {
            return;
        }
        this.f70460i.add(aVar);
    }

    private void u(List<SplashOrder> list, int i3, int i16, int i17, String str) {
        ArrayList arrayList = new ArrayList();
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = i17 % i16;
            SplashOrder splashOrder = list.get(i19);
            if (x(splashOrder, str)) {
                arrayList.add(splashOrder);
            }
            i17 = i19 + 1;
        }
        com.tencent.ams.fusion.a.f.a("selectCPMOrderWithPriority, brandOrderListNeedToSort count: " + arrayList.size());
        if (j.b(arrayList)) {
            this.f70457f |= 64;
            com.tencent.ams.fusion.a.f.g("selectCPMOrderWithPriority, brandOrderListNeedToSort is null return");
            return;
        }
        Collections.sort(arrayList, new a(str));
        int min = Math.min(i3, arrayList.size());
        for (int i26 = 0; i26 < min; i26++) {
            SplashOrder splashOrder2 = (SplashOrder) arrayList.get(i26);
            if (splashOrder2 != null && !F(splashOrder2)) {
                com.tencent.ams.fusion.a.f.a("selectCPMOrderWithPriority, success: " + splashOrder2.f() + " priority :" + splashOrder2.G(str));
                this.f70459h.add(splashOrder2);
                w(303, 305);
            }
            if (this.f70459h.size() >= i3) {
                break;
            }
        }
        if (this.f70459h.size() == 0) {
            this.f70457f |= 64;
        }
    }

    private void v(ot.c cVar, List<SplashOrder> list, int i3, boolean z16) {
        int i16;
        if (!j.b(list) && z16) {
            int f16 = cVar.f();
            int size = list.size();
            for (int i17 = 0; i17 < size; i17++) {
                int i18 = f16 % size;
                SplashOrder splashOrder = list.get(i18);
                if (B(splashOrder)) {
                    com.tencent.ams.fusion.a.f.i("isValidEffectOrder" + splashOrder.f());
                    this.f70459h.add(splashOrder);
                    w(303, 305);
                }
                f16 = i18 + 1;
                if (this.f70459h.size() >= i3) {
                    break;
                }
            }
            this.f70457f |= 128;
            return;
        }
        int i19 = this.f70457f;
        if (z16) {
            i16 = 1024;
        } else {
            i16 = 16;
        }
        this.f70457f = i19 | i16;
    }

    private void w(int... iArr) {
        com.tencent.ams.fusion.service.splash.c.a.a.c.a.a[] aVarArr;
        if (iArr != null) {
            aVarArr = new com.tencent.ams.fusion.service.splash.c.a.a.c.a.a[iArr.length];
            for (int i3 = 0; i3 < iArr.length; i3++) {
                com.tencent.ams.fusion.service.splash.c.a.a.c.a.a aVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.a.a();
                aVar.b(iArr[i3]);
                aVarArr[i3] = aVar;
            }
        } else {
            aVarArr = null;
        }
        if (!j.d(aVarArr)) {
            Collections.addAll(this.f70460i, aVarArr);
        }
    }

    private boolean x(SplashOrder splashOrder, String str) {
        if (splashOrder == null || splashOrder.az() != 0) {
            return false;
        }
        if (splashOrder.bk()) {
            if (this.f70458g == null) {
                this.f70458g = splashOrder;
            }
            return false;
        }
        if (splashOrder.bf() != 0) {
            com.tencent.ams.fusion.a.f.g("offlineCpmOrderCanPlay, order not cpm ");
            return false;
        }
        if (!C(splashOrder)) {
            com.tencent.ams.fusion.a.f.g("offlineCpmOrderCanPlay, hot mode, oneshot disabled");
            return false;
        }
        if (splashOrder.bp()) {
            com.tencent.ams.fusion.a.f.g("offlineCpmOrderCanPlay, no network and isOfflineStop() = true.");
            return false;
        }
        if (!A(splashOrder, str)) {
            com.tencent.ams.fusion.a.f.g("offlineCpmOrderCanPlay, no network and order not in play time.");
            return false;
        }
        if (D(splashOrder)) {
            com.tencent.ams.fusion.a.f.g("offlineCpmOrderCanPlay, no network and order reach limit.");
            return false;
        }
        if ((this.f70461j || !com.tencent.ams.fusion.service.splash.a.a.d().C()) && !splashOrder.aA()) {
            com.tencent.ams.fusion.a.f.g("offlineCpmOrderCanPlay, resource is not ready");
            l(6, 1);
            return false;
        }
        if (!splashOrder.aw()) {
            return true;
        }
        com.tencent.ams.fusion.a.f.g("offlineCpmOrderCanPlay, isLowPriority");
        this.f70455d = splashOrder;
        return false;
    }

    private void y(List<SplashOrder> list, int i3, int i16, int i17, String str) {
        for (int i18 = 0; i18 < i16; i18++) {
            int i19 = i17 % i16;
            SplashOrder splashOrder = list.get(i19);
            if (x(splashOrder, str) && !F(splashOrder)) {
                com.tencent.ams.fusion.a.f.i("offlineCpmOrderCanPlay, success: " + splashOrder.f());
                this.f70459h.add(splashOrder);
                w(303, 305);
            }
            i17 = i19 + 1;
            if (this.f70459h.size() >= i3) {
                break;
            }
        }
        if (this.f70459h.size() == 0) {
            this.f70457f |= 64;
        }
    }

    private boolean z(SplashOrder splashOrder) {
        if (splashOrder == null) {
            l(301, e());
        } else if (splashOrder.bf() == 1 && splashOrder.az() == 0) {
            if ((this.f70461j || !com.tencent.ams.fusion.service.splash.a.a.d().C()) && !splashOrder.aA()) {
                com.tencent.ams.fusion.a.f.g("selectCPDOrder fail src not ready");
                return false;
            }
            if (splashOrder.aw()) {
                this.f70455d = splashOrder;
            } else if (!F(splashOrder)) {
                com.tencent.ams.fusion.a.f.i("selectCPDOrder success");
                this.f70459h.add(splashOrder);
                w(303, 305);
                return true;
            }
        }
        return false;
    }

    @Override // pt.a
    public int d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 4;
    }

    @Override // pt.a
    public int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 16;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0155  */
    @Override // com.tencent.ams.fusion.service.splash.c.a.a.d.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected ot.d r() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ot.d) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        pt.b s16 = s();
        boolean z16 = true;
        if (s16 == null) {
            com.tencent.ams.fusion.a.f.g("LocalSelectOrderTask selectOrderTaskRequest == null");
            return a(1);
        }
        ot.c a16 = s16.a();
        if (a16 == null) {
            com.tencent.ams.fusion.a.f.g("LocalSelectOrderTask selectOrderRequest == null");
            return a(1);
        }
        rt.a b16 = s16.b();
        if (b16 == null) {
            com.tencent.ams.fusion.a.f.g("LocalSelectOrderTask preloadInfo == null");
            return a(2);
        }
        List<SplashOrder> d16 = b16.d();
        List<SplashOrder> e16 = b16.e();
        this.f70461j = a16.s();
        int p16 = a16.p();
        if (p16 <= 0) {
            i3 = 1;
        } else {
            i3 = p16;
        }
        if (!j.b(d16)) {
            int e17 = a16.e();
            int size = d16.size();
            int i16 = e17 % size;
            if (z(d16.get(i16))) {
                com.tencent.ams.fusion.a.f.a("FusionAd, selectCPDOrder success break");
            } else {
                com.tencent.ams.fusion.service.splash.c.a.a.c.a.a aVar = new com.tencent.ams.fusion.service.splash.c.a.a.c.a.a();
                aVar.b(300);
                aVar.d(4);
                t(aVar);
                if (this.f70459h.size() < i3) {
                    this.f70456e = E();
                    boolean u16 = a16.u();
                    String k3 = a16.k();
                    com.tencent.ams.fusion.a.f.i("FusionAd, selectCPMOrder isHitCPMPriorityExp :" + u16);
                    try {
                        if (u16) {
                            u(d16, i3, size, i16, k3);
                        } else {
                            y(d16, i3, size, i16, k3);
                        }
                    } catch (Throwable th5) {
                        com.tencent.ams.fusion.a.f.d("FusionAd, cpm select failed :", th5);
                    }
                }
            }
            if (!j.b(this.f70459h)) {
                com.tencent.ams.fusion.a.f.g("local select fail no order can pick!");
                l(302, e());
                int i17 = this.f70457f | 256;
                this.f70457f = i17;
                return a(i17);
            }
            return j(this.f70459h, this.f70460i);
        }
        this.f70457f |= 8;
        if (this.f70459h.size() < i3) {
            if (com.tencent.ams.fusion.service.splash.a.a.d().m() != 1) {
                z16 = false;
            }
            v(a16, e16, i3, z16);
            if (this.f70459h.size() < i3) {
                SplashOrder splashOrder = this.f70455d;
                if (splashOrder != null) {
                    this.f70459h.add(splashOrder);
                    w(303, 305);
                } else {
                    this.f70457f |= 32;
                }
                if (this.f70459h.size() < i3) {
                    SplashOrder splashOrder2 = this.f70458g;
                    if (splashOrder2 != null) {
                        this.f70459h.add(splashOrder2);
                        w(303, 304);
                    }
                    this.f70459h.size();
                }
            }
        }
        if (!j.b(this.f70459h)) {
        }
    }
}
