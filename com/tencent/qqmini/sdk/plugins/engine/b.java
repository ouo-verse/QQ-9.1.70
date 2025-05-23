package com.tencent.qqmini.sdk.plugins.engine;

import androidx.annotation.NonNull;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes23.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    @NonNull
    public final Method f348298a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f348299b;

    public b(Method method, boolean z16) {
        this.f348298a = method;
        this.f348299b = z16;
    }

    @NonNull
    public String toString() {
        return "MethodItem{method=" + this.f348298a + ", isSync=" + this.f348299b + '}';
    }
}
