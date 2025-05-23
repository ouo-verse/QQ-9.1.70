package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SkEpO extends UMDtK implements Cloneable {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name */
    public static Map<String, String> f382027h;

    /* renamed from: i, reason: collision with root package name */
    public static Map<Integer, Integer> f382028i;

    /* renamed from: j, reason: collision with root package name */
    public static Map<String, String> f382029j;

    /* renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ boolean f382030k;

    /* renamed from: a, reason: collision with root package name */
    public long f382031a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f382032b;

    /* renamed from: c, reason: collision with root package name */
    public long f382033c;

    /* renamed from: d, reason: collision with root package name */
    public Map<String, String> f382034d;

    /* renamed from: e, reason: collision with root package name */
    public Map<Integer, Integer> f382035e;

    /* renamed from: f, reason: collision with root package name */
    public long f382036f;

    /* renamed from: g, reason: collision with root package name */
    public Map<String, String> f382037g;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21519);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f382030k = true;
        HashMap hashMap = new HashMap();
        f382027h = hashMap;
        hashMap.put("", "");
        f382028i = new HashMap();
        f382028i.put(0, 0);
        HashMap hashMap2 = new HashMap();
        f382029j = hashMap2;
        hashMap2.put("", "");
    }

    public SkEpO() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f382031a = 0L;
        this.f382032b = true;
        this.f382033c = 0L;
        this.f382034d = null;
        this.f382035e = null;
        this.f382036f = 0L;
        this.f382037g = null;
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(Xjpd8 xjpd8) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) xjpd8);
            return;
        }
        xjpd8.a(this.f382031a, 0);
        xjpd8.a(this.f382032b ? (byte) 1 : (byte) 0, 1);
        xjpd8.a(this.f382033c, 2);
        xjpd8.a((Map) this.f382034d, 3);
        xjpd8.a((Map) this.f382035e, 4);
        xjpd8.a(this.f382036f, 5);
        Map<String, String> map = this.f382037g;
        if (map != null) {
            xjpd8.a((Map) map, 6);
        }
    }

    public Object clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return iPatchRedirector.redirect((short) 5, (Object) this);
        }
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f382030k) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public boolean equals(Object obj) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        SkEpO skEpO = (SkEpO) obj;
        if (!vzMV2.a(this.f382031a, skEpO.f382031a)) {
            return false;
        }
        if (this.f382032b == skEpO.f382032b) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !vzMV2.a(this.f382033c, skEpO.f382033c) || !this.f382034d.equals(skEpO.f382034d) || !this.f382035e.equals(skEpO.f382035e) || !vzMV2.a(this.f382036f, skEpO.f382036f) || !this.f382037g.equals(skEpO.f382037g)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        try {
            throw new Exception("");
        } catch (Exception e16) {
            e16.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.turingcam.UMDtK
    public void a(YunKQ yunKQ) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) yunKQ);
            return;
        }
        this.f382031a = yunKQ.a(this.f382031a, 0, true);
        this.f382032b = yunKQ.a(this.f382032b, 1, true);
        this.f382033c = yunKQ.a(this.f382033c, 2, true);
        this.f382034d = (Map) yunKQ.a((YunKQ) f382027h, 3, true);
        this.f382035e = (Map) yunKQ.a((YunKQ) f382028i, 4, true);
        this.f382036f = yunKQ.a(this.f382036f, 5, true);
        this.f382037g = (Map) yunKQ.a((YunKQ) f382029j, 6, false);
    }
}
