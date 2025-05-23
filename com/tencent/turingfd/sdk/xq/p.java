package com.tencent.turingfd.sdk.xq;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class p {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static HashMap<String, byte[]> f383409d;

    /* renamed from: a, reason: collision with root package name */
    public Foxnut f383410a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, byte[]> f383411b;

    /* renamed from: c, reason: collision with root package name */
    public HashMap<String, Object> f383412c;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f383410a = new Foxnut();
        this.f383411b = new HashMap<>();
        this.f383412c = new HashMap<>();
        Foxnut foxnut = this.f383410a;
        foxnut.f382770a = (short) 3;
        foxnut.f382773d = 3;
    }

    public <T> void a(String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) t16);
            return;
        }
        if (!str.startsWith(".") && t16 != null && !(t16 instanceof Set)) {
            Solar solar = new Solar(128);
            solar.f383075b = "UTF-8";
            solar.a(t16, 0);
            this.f383411b.put(str, Triangulum.a(solar.f383074a));
            return;
        }
        throw new IllegalArgumentException("wup put err");
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        Foxnut foxnut = this.f383410a;
        if (foxnut.f382774e == null) {
            foxnut.f382774e = "";
        }
        if (foxnut.f382775f == null) {
            foxnut.f382775f = "";
        }
        Solar solar = new Solar(0);
        solar.f383075b = "UTF-8";
        solar.a((Map) this.f383411b, 0);
        this.f383410a.f382776g = Triangulum.a(solar.f383074a);
        Solar solar2 = new Solar(0);
        solar2.f383075b = "UTF-8";
        this.f383410a.a(solar2);
        byte[] a16 = Triangulum.a(solar2.f383074a);
        int length = a16.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a16).flip();
        return allocate.array();
    }
}
