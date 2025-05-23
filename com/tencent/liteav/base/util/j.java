package com.tencent.liteav.base.util;

import com.tencent.liteav.base.ContextUtils;
import java.util.concurrent.Callable;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class j implements Callable {

    /* renamed from: a, reason: collision with root package name */
    private static final j f119025a = new j();

    j() {
    }

    public static Callable a() {
        return f119025a;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        Boolean valueOf;
        valueOf = Boolean.valueOf(i.a(ContextUtils.getApplicationContext()));
        return valueOf;
    }
}
