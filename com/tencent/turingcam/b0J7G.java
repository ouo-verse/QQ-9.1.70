package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class b0J7G extends UMDtK {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name */
    public static Map<Integer, byte[]> f382141i;

    /* renamed from: j, reason: collision with root package name */
    public static tfWT8 f382142j;

    /* renamed from: k, reason: collision with root package name */
    public static WOMZP f382143k;

    /* renamed from: l, reason: collision with root package name */
    public static DdNBW f382144l;

    /* renamed from: m, reason: collision with root package name */
    public static Map<Integer, String> f382145m;

    /* renamed from: n, reason: collision with root package name */
    public static Map<Integer, String> f382146n;

    /* renamed from: a, reason: collision with root package name */
    public long f382147a;

    /* renamed from: b, reason: collision with root package name */
    public Map<Integer, byte[]> f382148b;

    /* renamed from: c, reason: collision with root package name */
    public int f382149c;

    /* renamed from: d, reason: collision with root package name */
    public tfWT8 f382150d;

    /* renamed from: e, reason: collision with root package name */
    public WOMZP f382151e;

    /* renamed from: f, reason: collision with root package name */
    public DdNBW f382152f;

    /* renamed from: g, reason: collision with root package name */
    public Map<Integer, String> f382153g;

    /* renamed from: h, reason: collision with root package name */
    public Map<Integer, String> f382154h;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21580);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382141i = new HashMap();
        ((HashMap) f382141i).put(0, new byte[]{0});
        f382142j = new tfWT8();
        f382143k = new WOMZP();
        f382144l = new DdNBW();
        f382145m = new HashMap();
        ((HashMap) f382145m).put(0, "");
        f382146n = new HashMap();
        ((HashMap) f382146n).put(0, "");
    }

    public b0J7G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382147a = 0L;
        this.f382148b = null;
        this.f382149c = 0;
        this.f382150d = null;
        this.f382151e = null;
        this.f382152f = null;
        this.f382153g = null;
        this.f382154h = null;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382147a, 0);
        xjpd8.a((Map) this.f382148b, 1);
        xjpd8.a(this.f382149c, 2);
        xjpd8.a((UMDtK) this.f382150d, 3);
        xjpd8.a((UMDtK) this.f382151e, 4);
        DdNBW ddNBW = this.f382152f;
        if (ddNBW != null) {
            xjpd8.a((UMDtK) ddNBW, 5);
        }
        Map<Integer, String> map = this.f382153g;
        if (map != null) {
            xjpd8.a((Map) map, 6);
        }
        Map<Integer, String> map2 = this.f382154h;
        if (map2 != null) {
            xjpd8.a((Map) map2, 7);
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382147a = yunKQ.a(this.f382147a, 0, true);
        this.f382148b = (Map) yunKQ.a((YunKQ) f382141i, 1, true);
        this.f382149c = yunKQ.a(this.f382149c, 2, true);
        this.f382150d = (tfWT8) yunKQ.a((UMDtK) f382142j, 3, true);
        this.f382151e = (WOMZP) yunKQ.a((UMDtK) f382143k, 4, true);
        this.f382152f = (DdNBW) yunKQ.a((UMDtK) f382144l, 5, false);
        this.f382153g = (Map) yunKQ.a((YunKQ) f382145m, 6, false);
        this.f382154h = (Map) yunKQ.a((YunKQ) f382146n, 7, false);
    }
}
