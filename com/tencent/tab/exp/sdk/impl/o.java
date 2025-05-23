package com.tencent.tab.exp.sdk.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.tab.exp.sdk.impl.p;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    private final ConcurrentHashMap<p, m> f374152a;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final o f374153a = new o();
    }

    public static o c() {
        return b.f374153a;
    }

    @Nullable
    public synchronized m a(@NonNull q qVar, @NonNull TabExpDependInjector tabExpDependInjector) {
        if (qVar == null || tabExpDependInjector == null) {
            return null;
        }
        String f16 = qVar.f();
        if (TextUtils.isEmpty(f16)) {
            return null;
        }
        String d16 = x.d(qVar.n(), "EmptySceneId");
        m b16 = b(f16, d16);
        if (b16 != null) {
            return b16;
        }
        m mVar = new m(qVar, tabExpDependInjector);
        this.f374152a.put(new p.b().c(f16).e(d16).d(), mVar);
        return mVar;
    }

    @Nullable
    public m b(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = "EmptySceneId";
        }
        return this.f374152a.get(new p.b().c(str).e(str2).d());
    }

    o() {
        this.f374152a = new ConcurrentHashMap<>();
    }
}
