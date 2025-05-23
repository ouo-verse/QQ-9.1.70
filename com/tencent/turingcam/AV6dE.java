package com.tencent.turingcam;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes27.dex */
public class AV6dE {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static HashMap<String, byte[]> f381723c;

    /* renamed from: a, reason: collision with root package name */
    public OF1Jz f381724a;

    /* renamed from: b, reason: collision with root package name */
    public HashMap<String, byte[]> f381725b;

    public AV6dE() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f381724a = new OF1Jz();
        this.f381725b = new HashMap<>();
        new HashMap();
        OF1Jz oF1Jz = this.f381724a;
        oF1Jz.f381963a = (short) 3;
        oF1Jz.f381966d = 3;
    }

    public <T> void a(String str, T t16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) t16);
            return;
        }
        if (!str.startsWith(".") && t16 != null && !(t16 instanceof Set)) {
            Xjpd8 xjpd8 = new Xjpd8(128);
            xjpd8.f382097b = "UTF-8";
            xjpd8.a(t16, 0);
            this.f381725b.put(str, vzMV2.a(xjpd8.f382096a));
            return;
        }
        throw new IllegalArgumentException("wup put err");
    }

    public byte[] a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (byte[]) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        OF1Jz oF1Jz = this.f381724a;
        if (oF1Jz.f381967e == null) {
            oF1Jz.f381967e = "";
        }
        if (oF1Jz.f381968f == null) {
            oF1Jz.f381968f = "";
        }
        Xjpd8 xjpd8 = new Xjpd8(0);
        xjpd8.f382097b = "UTF-8";
        xjpd8.a((Map) this.f381725b, 0);
        this.f381724a.f381969g = vzMV2.a(xjpd8.f382096a);
        Xjpd8 xjpd82 = new Xjpd8(0);
        xjpd82.f382097b = "UTF-8";
        this.f381724a.a(xjpd82);
        byte[] a16 = vzMV2.a(xjpd82.f382096a);
        int length = a16.length + 4;
        ByteBuffer allocate = ByteBuffer.allocate(length);
        allocate.putInt(length).put(a16).flip();
        return allocate.array();
    }
}
