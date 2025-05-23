package com.tencent.halley.common.b.a;

import com.tencent.halley.common.a.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public boolean f113299a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f113300b;

    /* renamed from: c, reason: collision with root package name */
    public String f113301c;

    /* renamed from: d, reason: collision with root package name */
    URL f113302d;

    /* renamed from: e, reason: collision with root package name */
    String f113303e;

    /* renamed from: f, reason: collision with root package name */
    int f113304f;

    /* renamed from: g, reason: collision with root package name */
    private int f113305g;

    public b(URL url, String str) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) url, (Object) str);
            return;
        }
        if (h.a("direct_access_use_schedule", 0, 1, 1) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f113299a = z16;
        this.f113300b = h.a("direct_https_use_sche", 0, 1, 1) == 1;
        this.f113301c = "";
        this.f113305g = h.a("direct_access_domain_try_times", 1, 8, 2);
        this.f113302d = url;
        this.f113303e = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        r7 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        if (r7 >= r6.f113305g) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0058, code lost:
    
        r5.add(r0);
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0062, code lost:
    
        if (com.tencent.halley.common.a.c.k() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0064, code lost:
    
        r1 = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006c, code lost:
    
        r0.f113194a = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0068, code lost:
    
        if (r6.f113299a != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x006b, code lost:
    
        r1 = 4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<com.tencent.halley.common.a.a> a(boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        boolean z18 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), Boolean.valueOf(z17));
        }
        com.tencent.halley.common.a.a aVar = new com.tencent.halley.common.a.a(this.f113302d.getHost());
        aVar.f113198e = (byte) 3;
        try {
            ArrayList arrayList = new ArrayList();
            if (!z16) {
                arrayList.add(aVar);
                aVar.f113194a = 1;
                return arrayList;
            }
            if (!com.tencent.halley.common.a.c.k() && this.f113299a && (!z17 || this.f113300b)) {
                z18 = false;
            }
            com.tencent.halley.common.a.c.b a16 = com.tencent.halley.common.b.a.a(this.f113302d.getHost());
            List<com.tencent.halley.common.a.a> list = a16.f113261c;
            this.f113304f = a16.f113262d;
            this.f113301c = a16.f113260b;
            return list;
        } catch (Exception unused) {
            ArrayList arrayList2 = new ArrayList();
            for (int i16 = 0; i16 < this.f113305g; i16++) {
                arrayList2.add(aVar);
            }
            aVar.f113194a = 8;
            return arrayList2;
        }
    }
}
