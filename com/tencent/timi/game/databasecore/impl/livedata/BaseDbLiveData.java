package com.tencent.timi.game.databasecore.impl.livedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import sg4.c;

/* compiled from: P */
/* loaded from: classes26.dex */
public abstract class BaseDbLiveData<TableModel, ObserverType> extends LiveData<LoadDataWrapper<ObserverType>> implements LifecycleEventObserver, c<ObserverType> {

    /* renamed from: d, reason: collision with root package name */
    private AtomicInteger f376787d = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name */
    private AtomicBoolean f376788e = new AtomicBoolean(false);

    /* renamed from: f, reason: collision with root package name */
    private sg4.a f376789f = new sg4.a();

    /* renamed from: h, reason: collision with root package name */
    private List<Observer<? super LoadDataWrapper<ObserverType>>> f376790h = new ArrayList();

    /* renamed from: i, reason: collision with root package name */
    private sg4.b f376791i = new a();

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements sg4.b<TableModel> {
        a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes26.dex */
    static /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f376793a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            f376793a = iArr;
            try {
                iArr[Lifecycle.Event.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f376793a[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private void c() {
        if (!this.f376788e.get()) {
            f(this.f376791i);
            this.f376788e.set(true);
        }
    }

    private void d() {
        if (this.f376788e.get()) {
            h(this.f376791i);
            this.f376788e.set(false);
        }
    }

    @Override // androidx.lifecycle.LiveData
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public void postValue(LoadDataWrapper<ObserverType> loadDataWrapper) {
        super.postValue(loadDataWrapper);
    }

    protected abstract void f(sg4.b<TableModel> bVar);

    @Override // androidx.lifecycle.LiveData
    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public void setValue(LoadDataWrapper<ObserverType> loadDataWrapper) {
        super.setValue(loadDataWrapper);
    }

    @Override // androidx.lifecycle.LiveData
    @Nullable
    public /* bridge */ /* synthetic */ LoadDataWrapper getValue() {
        return (LoadDataWrapper) super.getValue();
    }

    protected abstract void h(sg4.b<TableModel> bVar);

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
        this.f376787d.incrementAndGet();
        this.f376790h.add(observer);
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
        int i3 = b.f376793a[event.ordinal()];
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
        if (this.f376790h.remove(observer)) {
            this.f376787d.decrementAndGet();
        }
    }
}
