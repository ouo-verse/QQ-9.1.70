package com.tencent.icgame.game.databasecore.impl.livedata;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class BaseDbLiveData<TableModel, ObserverType> extends LiveData<LoadDataWrapper<ObserverType>> implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f115007d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f115008e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private pu0.a f115009f = new pu0.a();

    /* renamed from: h, reason: collision with root package name */
    private List<Observer<? super LoadDataWrapper<ObserverType>>> f115010h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private pu0.b f115011i = new a();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements pu0.b<TableModel> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f115013a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f115013a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f115013a[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void c() {
        if (!this.f115008e.get()) {
            f(this.f115011i);
            this.f115008e.set(true);
        }
    }

    private void d() {
        if (this.f115008e.get()) {
            h(this.f115011i);
            this.f115008e.set(false);
        }
    }

    @Override // androidx.lifecycle.LiveData
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void postValue(LoadDataWrapper<ObserverType> loadDataWrapper) {
        super.postValue(loadDataWrapper);
    }

    protected abstract void f(pu0.b<TableModel> bVar);

    @Override // androidx.lifecycle.LiveData
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void setValue(LoadDataWrapper<ObserverType> loadDataWrapper) {
        super.setValue(loadDataWrapper);
    }

    protected abstract void h(pu0.b<TableModel> bVar);

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.LiveData
    public void observe(@NonNull LifecycleOwner lifecycleOwner, @NonNull Observer<? super LoadDataWrapper<ObserverType>> observer) {
        lifecycleOwner.getLifecycle().addObserver(this);
        super.observe(lifecycleOwner, observer);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.LiveData
    public void observeForever(@NonNull Observer<? super LoadDataWrapper<ObserverType>> observer) {
        super.observeForever(observer);
        this.f115007d.incrementAndGet();
        this.f115010h.add(observer);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onActive() {
        super.onActive();
        c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.LiveData
    public void onInactive() {
        super.onInactive();
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
        int i3 = b.f115013a[event.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                d();
                return;
            }
            return;
        }
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NonNull Observer<? super LoadDataWrapper<ObserverType>> observer) {
        super.removeObserver(observer);
        if (this.f115010h.remove(observer)) {
            this.f115007d.decrementAndGet();
        }
    }
}
