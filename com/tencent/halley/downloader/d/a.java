package com.tencent.halley.downloader.d;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public final List<String> f113718a;

    /* renamed from: b, reason: collision with root package name */
    public final List<String> f113719b;

    /* renamed from: c, reason: collision with root package name */
    public long f113720c;

    /* renamed from: d, reason: collision with root package name */
    public long f113721d;

    /* renamed from: e, reason: collision with root package name */
    private final List<String> f113722e;

    public a(List<String> list, List<String> list2, List<String> list3) {
        this(list, list2, list3, (byte) 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, this, list, list2, list3);
    }

    public final String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return "IpSet{v4Ips=" + Arrays.toString(this.f113718a.toArray()) + ", v6Ips=" + Arrays.toString(this.f113719b.toArray()) + ", ips=" + Arrays.toString(this.f113722e.toArray()) + ", v4Ttl =" + this.f113720c + ", v6Ttl =" + this.f113721d + '}';
    }

    a(List<String> list, List<String> list2, List<String> list3, byte b16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, list, list2, list3, Byte.valueOf(b16));
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f113718a = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.f113719b = arrayList2;
        ArrayList arrayList3 = new ArrayList();
        this.f113722e = arrayList3;
        arrayList.addAll(list);
        arrayList2.addAll(list2);
        arrayList3.addAll(list3);
        this.f113720c = 60L;
        this.f113721d = 60L;
    }
}
