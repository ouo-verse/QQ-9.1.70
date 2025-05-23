package com.bumptech.glide.load.engine;

import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes.dex */
final class n {

    /* renamed from: a, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, EngineJob<?>> f31738a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    private final Map<com.bumptech.glide.load.c, EngineJob<?>> f31739b = new HashMap();

    private Map<com.bumptech.glide.load.c, EngineJob<?>> b(boolean z16) {
        if (z16) {
            return this.f31739b;
        }
        return this.f31738a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EngineJob<?> a(com.bumptech.glide.load.c cVar, boolean z16) {
        return b(z16).get(cVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(com.bumptech.glide.load.c cVar, EngineJob<?> engineJob) {
        b(engineJob.p()).put(cVar, engineJob);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(com.bumptech.glide.load.c cVar, EngineJob<?> engineJob) {
        Map<com.bumptech.glide.load.c, EngineJob<?>> b16 = b(engineJob.p());
        if (engineJob.equals(b16.get(cVar))) {
            b16.remove(cVar);
        }
    }
}
