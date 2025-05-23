package com.tencent.luggage.wxa.un;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a extends Lifecycle {

    /* renamed from: d, reason: collision with root package name */
    public static final C6808a f142831d = new C6808a(null);

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f142832a;

    /* renamed from: b, reason: collision with root package name */
    public Lifecycle.State f142833b;

    /* renamed from: c, reason: collision with root package name */
    public ConcurrentHashMap f142834c;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.un.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static final class C6808a {
        public C6808a() {
        }

        public /* synthetic */ C6808a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public a(LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.f142832a = owner;
        this.f142833b = Lifecycle.State.INITIALIZED;
        this.f142834c = new ConcurrentHashMap();
    }

    public final ConcurrentHashMap a() {
        return this.f142834c;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void addObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ConcurrentHashMap concurrentHashMap = this.f142834c;
        if (concurrentHashMap != null) {
        }
    }

    @Override // androidx.lifecycle.Lifecycle
    public Lifecycle.State getCurrentState() {
        return this.f142833b;
    }

    @Override // androidx.lifecycle.Lifecycle
    public void removeObserver(LifecycleObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        ConcurrentHashMap concurrentHashMap = this.f142834c;
        if (concurrentHashMap != null) {
        }
    }
}
