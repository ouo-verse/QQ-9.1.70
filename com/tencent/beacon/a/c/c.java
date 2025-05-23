package com.tencent.beacon.a.c;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.beacon.module.BeaconModule;
import com.tencent.beacon.module.ModuleName;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static volatile c f77641a;

    /* renamed from: b, reason: collision with root package name */
    private Context f77642b;

    /* renamed from: c, reason: collision with root package name */
    private byte f77643c;

    /* renamed from: d, reason: collision with root package name */
    private String f77644d;

    /* renamed from: f, reason: collision with root package name */
    private String f77646f;

    /* renamed from: g, reason: collision with root package name */
    private long f77647g;

    /* renamed from: e, reason: collision with root package name */
    private String f77645e = "";

    /* renamed from: h, reason: collision with root package name */
    private String f77648h = "";

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, String> f77649i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private String f77650j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f77651k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f77652l = "";

    /* renamed from: m, reason: collision with root package name */
    private boolean f77653m = true;

    public c() {
        this.f77643c = (byte) -1;
        this.f77644d = "";
        this.f77646f = "";
        this.f77643c = (byte) 1;
        this.f77644d = "beacon";
        this.f77646f = "unknown";
    }

    public static c c() {
        if (f77641a == null) {
            synchronized (c.class) {
                if (f77641a == null) {
                    f77641a = new c();
                }
            }
        }
        return f77641a;
    }

    public synchronized String a() {
        return this.f77646f;
    }

    public void b(String str) {
        this.f77646f = str;
    }

    public String d() {
        return this.f77652l;
    }

    @NonNull
    public String e() {
        return this.f77648h;
    }

    public String f() {
        return this.f77651k;
    }

    public synchronized byte g() {
        return this.f77643c;
    }

    public synchronized String h() {
        return this.f77644d;
    }

    public String i() {
        return "4.2.84.3-qqvideo6";
    }

    public synchronized long j() {
        return this.f77647g;
    }

    public String k() {
        return this.f77650j;
    }

    public synchronized void a(long j3) {
        this.f77647g = j3;
    }

    public synchronized Context b() {
        return this.f77642b;
    }

    public void d(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f77651k = str;
    }

    public synchronized void a(Context context) {
        if (this.f77642b == null) {
            Context applicationContext = context.getApplicationContext();
            this.f77642b = applicationContext;
            if (applicationContext == null) {
                this.f77642b = context;
            }
        }
    }

    public String a(String str) {
        String str2 = this.f77649i.get(str);
        return str2 == null ? "" : str2;
    }

    public void a(String str, String str2) {
        this.f77649i.put(str, str2);
    }

    public void c(String str) {
        this.f77648h = str;
    }

    public BeaconModule a(ModuleName moduleName) {
        return BeaconModule.f78053a.get(moduleName);
    }

    public void a(boolean z16) {
        this.f77653m = z16;
    }
}
