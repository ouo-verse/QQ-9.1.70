package com.tencent.mobileqq.servlet.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public long f286487a;

    /* renamed from: b, reason: collision with root package name */
    public Map<String, String> f286488b;

    /* renamed from: c, reason: collision with root package name */
    public long f286489c;

    /* renamed from: d, reason: collision with root package name */
    public int f286490d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f286491e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f286492f;

    /* renamed from: g, reason: collision with root package name */
    public String f286493g;

    /* renamed from: h, reason: collision with root package name */
    public byte[] f286494h;

    public a(long j3, Map<String, String> map, long j16, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), map, Long.valueOf(j16), str);
            return;
        }
        this.f286490d = 0;
        this.f286491e = false;
        this.f286492f = false;
        this.f286494h = null;
        this.f286487a = j3;
        this.f286488b = map;
        this.f286489c = j16;
        this.f286493g = str;
    }

    public a(long j3, Map<String, String> map, long j16, String str, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), map, Long.valueOf(j16), str, bArr);
            return;
        }
        this.f286490d = 0;
        this.f286491e = false;
        this.f286492f = false;
        this.f286487a = j3;
        this.f286488b = map;
        this.f286489c = j16;
        this.f286493g = str;
        this.f286494h = bArr;
    }
}
