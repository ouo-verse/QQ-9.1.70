package com.tencent.luggage.wxa.h6;

import android.content.Context;
import android.text.TextPaint;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class l implements m {

    /* renamed from: a, reason: collision with root package name */
    public static final l f126905a = new l();

    /* renamed from: b, reason: collision with root package name */
    public static m f126906b;

    /* renamed from: c, reason: collision with root package name */
    public static final Lazy f126907c;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public static final class a extends Lambda implements Function0 {

        /* renamed from: a, reason: collision with root package name */
        public static final a f126908a = new a();

        public a() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final n invoke() {
            return new n();
        }
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) a.f126908a);
        f126907c = lazy;
    }

    public final void a(m mVar) {
        f126906b = mVar;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public int b(Context context) {
        return f().b(context);
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean c() {
        return f().c();
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean d() {
        return f().d();
    }

    public final n e() {
        return (n) f126907c.getValue();
    }

    public final m f() {
        m mVar = f126906b;
        if (mVar == null) {
            return e();
        }
        return mVar;
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public int a(int i3) {
        return f().a(i3);
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean b() {
        return f().b();
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean c(Context context) {
        if (context == null) {
            return false;
        }
        return f().c(context);
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean a(String str) {
        return f().a(str);
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public int a(Context context) {
        if (context == null) {
            return 0;
        }
        return f().a(context);
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public boolean a() {
        return f().a();
    }

    @Override // com.tencent.luggage.wxa.h6.m
    public void a(TextPaint textPaint) {
        f().a(textPaint);
    }
}
