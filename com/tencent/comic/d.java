package com.tencent.comic;

import android.util.SparseArray;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes32.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    AppRuntime f99281a;

    /* renamed from: f, reason: collision with root package name */
    private boolean f99286f = false;

    /* renamed from: b, reason: collision with root package name */
    private SparseArray<Object> f99282b = new SparseArray<>();

    /* renamed from: c, reason: collision with root package name */
    public AtomicReference<Object> f99283c = new AtomicReference<>(null);

    /* renamed from: d, reason: collision with root package name */
    public AtomicReference<com.tencent.comic.api.plugin.c> f99284d = new AtomicReference<>(null);

    /* renamed from: e, reason: collision with root package name */
    public AtomicInteger f99285e = new AtomicInteger(-1);

    public d(AppRuntime appRuntime) {
        this.f99281a = appRuntime;
    }

    public void a() {
        this.f99281a = null;
        this.f99282b.clear();
    }
}
