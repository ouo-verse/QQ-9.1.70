package com.tencent.biz.qqcircle.immersive.model.barrage;

import androidx.annotation.NonNull;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b implements a {

    /* renamed from: b, reason: collision with root package name */
    private static volatile a f87248b;

    /* renamed from: a, reason: collision with root package name */
    private final u50.a f87249a = new u50.a();

    b() {
    }

    public static a b() {
        if (f87248b == null) {
            synchronized (b.class) {
                if (f87248b == null) {
                    f87248b = new b();
                }
            }
        }
        return f87248b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(@NonNull t50.a aVar) {
        throw null;
    }

    @Override // com.tencent.biz.qqcircle.immersive.model.barrage.a
    public void release() {
        u50.a aVar = this.f87249a;
        if (aVar == null) {
            return;
        }
        aVar.c();
    }
}
