package com.tencent.videocut.utils;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a,\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u001a$\u0010\b\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u001a8\u0010\f\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\n0\t\u00a8\u0006\r"}, d2 = {"T", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "", "a", "b", "Lkotlin/Function1;", "", "filter", "c", "lib_utils_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public final class LiveDataExtKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00018\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/videocut/utils/LiveDataExtKt$a", "Landroidx/lifecycle/Observer;", "t", "", "onChanged", "(Ljava/lang/Object;)V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes27.dex */
    public static final class a<T> implements Observer<T> {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LiveData f384222d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f384223e;

        a(LiveData<T> liveData, Observer observer) {
            this.f384222d = liveData;
            this.f384223e = observer;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) liveData, (Object) observer);
            }
        }

        @Override // androidx.lifecycle.Observer
        public void onChanged(@Nullable T t16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
            } else {
                this.f384223e.onChanged(t16);
                this.f384222d.removeObserver(this);
            }
        }
    }

    public static final <T> void a(@NotNull LiveData<T> observeOnce, @NotNull LifecycleOwner lifecycleOwner, @NotNull Observer<T> observer) {
        Intrinsics.checkNotNullParameter(observeOnce, "$this$observeOnce");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        observeOnce.observe(lifecycleOwner, new a(observeOnce, observer));
    }

    public static final <T> void b(@NotNull LiveData<T> observeOnce, @NotNull Observer<T> observer) {
        Intrinsics.checkNotNullParameter(observeOnce, "$this$observeOnce");
        Intrinsics.checkNotNullParameter(observer, "observer");
        c(observeOnce, observer, LiveDataExtKt$observeOnce$2.INSTANCE);
    }

    public static final <T> void c(@NotNull final LiveData<T> observeOnce, @NotNull final Observer<T> observer, @NotNull final Function1<? super T, Boolean> filter) {
        Intrinsics.checkNotNullParameter(observeOnce, "$this$observeOnce");
        Intrinsics.checkNotNullParameter(observer, "observer");
        Intrinsics.checkNotNullParameter(filter, "filter");
        com.tencent.videocut.utils.thread.c.f384289c.e(new Runnable(observer, filter) { // from class: com.tencent.videocut.utils.LiveDataExtKt$observeOnce$3
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ Observer f384225e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ Function1 f384226f;

            /* JADX INFO: Add missing generic type declarations: [T] */
            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"com/tencent/videocut/utils/LiveDataExtKt$observeOnce$3$a", "Landroidx/lifecycle/Observer;", "t", "", "onChanged", "(Ljava/lang/Object;)V", "lib_utils_release"}, k = 1, mv = {1, 4, 2})
            /* loaded from: classes27.dex */
            public static final class a<T> implements Observer<T> {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) LiveDataExtKt$observeOnce$3.this);
                    }
                }

                @Override // androidx.lifecycle.Observer
                public void onChanged(T t16) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) t16);
                        return;
                    }
                    LiveDataExtKt$observeOnce$3.this.f384225e.onChanged(t16);
                    if (((Boolean) LiveDataExtKt$observeOnce$3.this.f384226f.invoke(t16)).booleanValue()) {
                        LiveData.this.removeObserver(this);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f384225e = observer;
                this.f384226f = filter;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, LiveData.this, observer, filter);
                }
            }

            @Override // java.lang.Runnable
            public final void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                } else {
                    LiveData.this.observeForever(new a());
                }
            }
        });
    }
}
