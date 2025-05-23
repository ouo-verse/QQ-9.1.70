package com.tencent.mobileqq.livedata;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.utils.bg;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00032\b\u0012\u0004\u0012\u00028\u00000\u0004B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ \u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0016J\u0018\u0010\u0010\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\rH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0016R\u0016\u0010\u001f\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u001eR(\u0010#\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0000\u0012\u00028\u00000\r\u0012\u0004\u0012\u00020\u00040 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010$\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/livedata/f;", "T", "Landroidx/lifecycle/LiveData;", "Lfx3/a;", "", "", h.F, "value", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroidx/lifecycle/Observer;", "observer", "observe", "observeForever", "removeObserver", "a", "hasObservers", "hasActiveObservers", "d", "Ljava/lang/Object;", "curPendingData", "e", "Z", "isPendingData", "f", "updateDataLock", "Landroid/os/Handler;", "Landroid/os/Handler;", "uiHandler", "Ljava/util/concurrent/ConcurrentHashMap;", "i", "Ljava/util/concurrent/ConcurrentHashMap;", "observerMap", "mapCommonValue", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f<T> extends LiveData<T> implements fx3.a<T> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private volatile T curPendingData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isPendingData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object updateDataLock;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Handler uiHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConcurrentHashMap<Observer<? super T>, Object> observerMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Object mapCommonValue;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.updateDataLock = new Object();
        this.uiHandler = new Handler(Looper.getMainLooper());
        this.observerMap = new ConcurrentHashMap<>();
        this.mapCommonValue = new Object();
    }

    private final boolean h() {
        return Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(f this$0, LifecycleOwner owner, Observer observer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(owner, "$owner");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        super.observe(owner, observer);
        this$0.observerMap.put(observer, this$0.mapCommonValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(f this$0, Observer observer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        super.observeForever(observer);
        this$0.observerMap.put(observer, this$0.mapCommonValue);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Iterator<Map.Entry<Observer<? super T>, Object>> it = this$0.observerMap.entrySet().iterator();
        while (it.hasNext()) {
            super.removeObserver(it.next().getKey());
        }
        this$0.observerMap.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(f this$0, Observer observer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(observer, "$observer");
        super.removeObserver(observer);
        this$0.observerMap.remove(observer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(f this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        synchronized (this$0.updateDataLock) {
            this$0.setValue(this$0.curPendingData);
            this$0.isPendingData = false;
            Unit unit = Unit.INSTANCE;
        }
    }

    @Override // fx3.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.livedata.e
                @Override // java.lang.Runnable
                public final void run() {
                    f.k(f.this);
                }
            });
        }
    }

    @Override // androidx.lifecycle.LiveData
    public boolean hasActiveObservers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return super.hasActiveObservers();
    }

    @Override // androidx.lifecycle.LiveData
    public boolean hasObservers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return super.hasObservers();
    }

    public void m(T value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) value);
            return;
        }
        if (h()) {
            this.curPendingData = value;
            this.uiHandler.removeCallbacksAndMessages(null);
            super.setValue(value);
        } else {
            synchronized (this.updateDataLock) {
                this.curPendingData = value;
                if (this.isPendingData) {
                    return;
                }
                this.uiHandler.post(new Runnable() { // from class: com.tencent.mobileqq.livedata.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        f.n(f.this);
                    }
                });
            }
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void observe(@NotNull final LifecycleOwner owner, @NotNull final Observer<? super T> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) owner, (Object) observer);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.livedata.c
            @Override // java.lang.Runnable
            public final void run() {
                f.i(f.this, owner, observer);
            }
        });
    }

    @Override // androidx.lifecycle.LiveData
    public void observeForever(@NotNull final Observer<? super T> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.livedata.b
                @Override // java.lang.Runnable
                public final void run() {
                    f.j(f.this, observer);
                }
            });
        }
    }

    @Override // androidx.lifecycle.LiveData
    public void removeObserver(@NotNull final Observer<? super T> observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            bg.k(new Runnable() { // from class: com.tencent.mobileqq.livedata.a
                @Override // java.lang.Runnable
                public final void run() {
                    f.l(f.this, observer);
                }
            });
        }
    }
}
