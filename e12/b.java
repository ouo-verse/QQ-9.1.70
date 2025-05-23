package e12;

import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* compiled from: P */
/* loaded from: classes14.dex */
public class b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a<R> implements Observer<R> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f395345d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f395346e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f395347f;

        a(MediatorLiveData mediatorLiveData, h hVar, LiveData liveData) {
            this.f395345d = mediatorLiveData;
            this.f395346e = hVar;
            this.f395347f = liveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(R r16) {
            Object value;
            MediatorLiveData mediatorLiveData = this.f395345d;
            h hVar = this.f395346e;
            LiveData liveData = this.f395347f;
            if (liveData == null) {
                value = null;
            } else {
                value = liveData.getValue();
            }
            mediatorLiveData.setValue(hVar.a(r16, value));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [S] */
    /* compiled from: P */
    /* renamed from: e12.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public class C10212b<S> implements Observer<S> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f395348d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ h f395349e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f395350f;

        C10212b(MediatorLiveData mediatorLiveData, h hVar, LiveData liveData) {
            this.f395348d = mediatorLiveData;
            this.f395349e = hVar;
            this.f395350f = liveData;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(S s16) {
            Object value;
            MediatorLiveData mediatorLiveData = this.f395348d;
            h hVar = this.f395349e;
            LiveData liveData = this.f395350f;
            if (liveData == null) {
                value = null;
            } else {
                value = liveData.getValue();
            }
            mediatorLiveData.setValue(hVar.a(value, s16));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R, S] */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    class c<R, S> implements h<R, S, Pair<R, S>> {
        c() {
        }

        @Override // e12.b.h
        @Nullable
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Pair<R, S> a(@Nullable R r16, @Nullable S s16) {
            return new Pair<>(r16, s16);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    class d<R> implements Observer<R> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f395351d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f395352e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f395353f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ LiveData f395354h;

        d(MediatorLiveData mediatorLiveData, g gVar, LiveData liveData, LiveData liveData2) {
            this.f395351d = mediatorLiveData;
            this.f395352e = gVar;
            this.f395353f = liveData;
            this.f395354h = liveData2;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(R r16) {
            Object value;
            MediatorLiveData mediatorLiveData = this.f395351d;
            g gVar = this.f395352e;
            LiveData liveData = this.f395353f;
            Object obj = null;
            if (liveData == null) {
                value = null;
            } else {
                value = liveData.getValue();
            }
            LiveData liveData2 = this.f395354h;
            if (liveData2 != null) {
                obj = liveData2.getValue();
            }
            mediatorLiveData.setValue(gVar.a(r16, value, obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [S] */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    class e<S> implements Observer<S> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f395355d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f395356e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f395357f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ LiveData f395358h;

        e(MediatorLiveData mediatorLiveData, g gVar, LiveData liveData, LiveData liveData2) {
            this.f395355d = mediatorLiveData;
            this.f395356e = gVar;
            this.f395357f = liveData;
            this.f395358h = liveData2;
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(S s16) {
            Object value;
            MediatorLiveData mediatorLiveData = this.f395355d;
            g gVar = this.f395356e;
            LiveData liveData = this.f395357f;
            Object obj = null;
            if (liveData == null) {
                value = null;
            } else {
                value = liveData.getValue();
            }
            LiveData liveData2 = this.f395358h;
            if (liveData2 != null) {
                obj = liveData2.getValue();
            }
            mediatorLiveData.setValue(gVar.a(value, s16, obj));
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    class f<T> implements Observer<T> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ MediatorLiveData f395359d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ g f395360e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ LiveData f395361f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ LiveData f395362h;

        f(MediatorLiveData mediatorLiveData, g gVar, LiveData liveData, LiveData liveData2) {
            this.f395359d = mediatorLiveData;
            this.f395360e = gVar;
            this.f395361f = liveData;
            this.f395362h = liveData2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public void onChanged(T t16) {
            Object value;
            MediatorLiveData mediatorLiveData = this.f395359d;
            g gVar = this.f395360e;
            LiveData liveData = this.f395361f;
            Object obj = null;
            if (liveData == null) {
                value = null;
            } else {
                value = liveData.getValue();
            }
            LiveData liveData2 = this.f395362h;
            if (liveData2 != null) {
                obj = liveData2.getValue();
            }
            mediatorLiveData.setValue(gVar.a(value, obj, t16));
        }
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface g<R, S, T, U> {
        @Nullable
        U a(@Nullable R r16, @Nullable S s16, @Nullable T t16);
    }

    /* compiled from: P */
    /* loaded from: classes14.dex */
    public interface h<R, S, T> {
        @Nullable
        T a(@Nullable R r16, @Nullable S s16);
    }

    public static <R, S> LiveData<Pair<R, S>> a(LiveData<R> liveData, LiveData<S> liveData2) {
        return b(liveData, liveData2, new c());
    }

    public static <R, S, T> LiveData<T> b(LiveData<R> liveData, LiveData<S> liveData2, h<R, S, T> hVar) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        if (liveData != null) {
            mediatorLiveData.addSource(liveData, new a(mediatorLiveData, hVar, liveData2));
        }
        if (liveData2 != null) {
            mediatorLiveData.addSource(liveData2, new C10212b(mediatorLiveData, hVar, liveData));
        }
        return mediatorLiveData;
    }

    public static <R, S, T, U> LiveData<U> c(@Nullable LiveData<R> liveData, @Nullable LiveData<S> liveData2, @Nullable LiveData<T> liveData3, g<R, S, T, U> gVar) {
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        if (liveData != null) {
            mediatorLiveData.addSource(liveData, new d(mediatorLiveData, gVar, liveData2, liveData3));
        }
        if (liveData2 != null) {
            mediatorLiveData.addSource(liveData2, new e(mediatorLiveData, gVar, liveData, liveData3));
        }
        if (liveData3 != null) {
            mediatorLiveData.addSource(liveData3, new f(mediatorLiveData, gVar, liveData, liveData2));
        }
        return mediatorLiveData;
    }
}
