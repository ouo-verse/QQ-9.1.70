package com.tencent.ads.monitor;

import android.text.TextUtils;
import com.tencent.ads.utility.Utils;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes37.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f61673a = "tencent_ads_reportevent";

    /* renamed from: b, reason: collision with root package name */
    private String f61674b;

    /* renamed from: c, reason: collision with root package name */
    private int f61675c;

    /* renamed from: d, reason: collision with root package name */
    private Map f61676d;

    /* renamed from: e, reason: collision with root package name */
    private String f61677e;

    /* renamed from: f, reason: collision with root package name */
    private String f61678f;

    /* renamed from: g, reason: collision with root package name */
    private String f61679g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f61680h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f61681i;

    public static e e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String[] split = str.split(f61673a);
        if (split.length < 3) {
            return null;
        }
        e eVar = new e();
        if (Utils.isNumeric(split[0])) {
            eVar.f61675c = Integer.parseInt(split[0]);
        }
        eVar.f61674b = split[1];
        eVar.f61680h = "true".equals(split[2]);
        if (split.length > 3) {
            eVar.f61677e = split[3];
        }
        return eVar;
    }

    public final String a() {
        return this.f61674b;
    }

    public final int b() {
        return this.f61675c;
    }

    public final Map c() {
        return this.f61676d;
    }

    public final String d() {
        return this.f61677e;
    }

    public final String f() {
        return this.f61679g;
    }

    public final void g() {
        this.f61675c++;
    }

    public final boolean h() {
        return this.f61680h;
    }

    public final String j() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.f61675c);
        sb5.append(f61673a);
        sb5.append(this.f61674b);
        sb5.append(f61673a);
        sb5.append(this.f61680h);
        sb5.append(f61673a);
        if (!TextUtils.isEmpty(this.f61677e)) {
            sb5.append(this.f61677e);
        }
        return sb5.toString();
    }

    public final boolean k() {
        return this.f61681i;
    }

    private void a(int i3) {
        this.f61675c = i3;
    }

    public final void b(String str) {
        this.f61677e = str;
    }

    public final void c(String str) {
        this.f61678f = str;
    }

    public final void d(String str) {
        this.f61679g = str;
    }

    public final String e() {
        return this.f61678f;
    }

    public final void i() {
        this.f61680h = true;
    }

    public final void l() {
        this.f61681i = true;
    }

    public final void a(String str) {
        this.f61674b = str;
    }

    public final void a(Map map) {
        this.f61676d = map;
    }
}
