package com.tencent.luggage.wxa.s7;

import android.os.Process;
import com.tencent.luggage.wxa.tn.z;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final d f140103a;

    /* renamed from: b, reason: collision with root package name */
    public final String f140104b;

    /* renamed from: c, reason: collision with root package name */
    public String f140105c;

    /* renamed from: d, reason: collision with root package name */
    public long f140106d;

    /* renamed from: e, reason: collision with root package name */
    public String f140107e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f140108f;

    /* renamed from: g, reason: collision with root package name */
    public String f140109g;

    /* renamed from: h, reason: collision with root package name */
    public String f140110h;

    /* renamed from: i, reason: collision with root package name */
    public String f140111i;

    /* renamed from: j, reason: collision with root package name */
    public int f140112j;

    /* renamed from: k, reason: collision with root package name */
    public String f140113k;

    /* renamed from: l, reason: collision with root package name */
    public long f140114l;

    /* renamed from: m, reason: collision with root package name */
    public int f140115m;

    public c(d type, String stack) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(stack, "stack");
        this.f140103a = type;
        this.f140104b = stack;
        String format = new SimpleDateFormat("yyyy-MM-dd-HH:mm:ss", Locale.ENGLISH).format(new Date());
        Intrinsics.checkNotNullExpressionValue(format, "SimpleDateFormat(\"yyyy-M\u2026e.ENGLISH).format(Date())");
        this.f140105c = format;
        this.f140106d = System.currentTimeMillis();
        this.f140107e = "4.0.0";
        this.f140108f = true;
        this.f140109g = "2025-04-27 19:07:38";
        this.f140110h = "ff21ec7a35922aa90e584b2bb63d1a39c25df3b8";
        String i3 = z.i();
        Intrinsics.checkNotNullExpressionValue(i3, "getProcessName()");
        this.f140111i = i3;
        this.f140112j = Process.myPid();
        String name = Thread.currentThread().getName();
        Intrinsics.checkNotNullExpressionValue(name, "currentThread().name");
        this.f140113k = name;
        this.f140114l = Thread.currentThread().getId();
    }

    public final String a() {
        return this.f140104b;
    }

    public final long b() {
        return this.f140106d;
    }

    public String toString() {
        return "|type='" + this.f140103a.name() + "',\n|time='" + this.f140105c + "',\n|timestamp='" + this.f140106d + "',\n|sdk_version='" + this.f140107e + "',\n|is_released=" + this.f140108f + ",\n|build_time='" + this.f140109g + "',\n|rev='" + this.f140110h + "',\n|process='" + this.f140111i + '(' + this.f140112j + ")',\n|thread='" + this.f140113k + '(' + this.f140114l + ")',\n|signal=" + this.f140115m + ",\n|stack='" + this.f140104b + '\'';
    }

    public final void a(int i3) {
        this.f140115m = i3;
    }
}
