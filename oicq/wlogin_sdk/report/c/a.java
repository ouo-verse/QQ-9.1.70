package oicq.wlogin_sdk.report.c;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f422855a;

    /* renamed from: b, reason: collision with root package name */
    public String f422856b;

    /* renamed from: c, reason: collision with root package name */
    public String f422857c;

    /* renamed from: f, reason: collision with root package name */
    public String f422860f;

    /* renamed from: d, reason: collision with root package name */
    public boolean f422858d = false;

    /* renamed from: e, reason: collision with root package name */
    public boolean f422859e = false;

    /* renamed from: g, reason: collision with root package name */
    public final HashMap<String, String> f422861g = new HashMap<>();

    public a(String str, String str2, String str3) {
        this.f422855a = str;
        this.f422856b = str2;
        this.f422857c = str3;
    }

    public a a(String str) {
        this.f422860f = str;
        return this;
    }

    public a a(String str, String str2) {
        this.f422861g.put(str, str2);
        return this;
    }
}
