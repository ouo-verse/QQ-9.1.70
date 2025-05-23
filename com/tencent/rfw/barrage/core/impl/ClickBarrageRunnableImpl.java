package com.tencent.rfw.barrage.core.impl;

import com.tencent.rfw.barrage.core.d;
import com.tencent.rfw.barrage.data.a;
import java.lang.ref.WeakReference;
import vz3.h;

/* compiled from: P */
/* loaded from: classes25.dex */
public class ClickBarrageRunnableImpl implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private final WeakReference<d> f365056d;

    /* renamed from: e, reason: collision with root package name */
    private final WeakReference<a> f365057e;

    /* renamed from: f, reason: collision with root package name */
    private h f365058f;

    public ClickBarrageRunnableImpl(d dVar, h hVar, a aVar) {
        this.f365056d = new WeakReference<>(dVar);
        this.f365057e = new WeakReference<>(aVar);
        this.f365058f = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        d dVar = this.f365056d.get();
        if (dVar == null) {
            return;
        }
        dVar.g0(this.f365058f, this.f365057e.get());
    }
}
