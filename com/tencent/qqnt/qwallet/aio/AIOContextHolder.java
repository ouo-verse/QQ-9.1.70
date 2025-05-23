package com.tencent.qqnt.qwallet.aio;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.qwallet.aio.hb.CommandHbGrabber;
import com.tencent.qqnt.qwallet.db.QWalletDBManager;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0018\u0010\u000e\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u000f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\r\u001a\u00020\fJ\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R4\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00152\u000e\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00158\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/qwallet/aio/AIOContextHolder;", "Landroidx/lifecycle/LifecycleEventObserver;", "", "d", "Lcom/tencent/aio/api/runtime/a;", "context", "a", "Lcom/tencent/mvi/base/route/MsgIntent;", "msg", "c", "", "type", "Lcom/tencent/mvi/base/route/a;", "action", "b", "e", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "onStateChanged", "Ljava/lang/ref/WeakReference;", "<set-?>", "Ljava/lang/ref/WeakReference;", "getContextRef", "()Ljava/lang/ref/WeakReference;", "contextRef", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AIOContextHolder implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final AIOContextHolder f361707d = new AIOContextHolder();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static WeakReference<com.tencent.aio.api.runtime.a> contextRef = new WeakReference<>(null);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes25.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361709a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f361709a = iArr;
        }
    }

    AIOContextHolder() {
    }

    private final void d() {
        LifecycleOwner d16;
        Lifecycle lifecycle;
        QLog.d("AIOContextViewModel", 2, "unregisterContext: ");
        com.tencent.aio.api.runtime.a aVar = contextRef.get();
        if (aVar != null && (d16 = aVar.d()) != null && (lifecycle = d16.getLifecycle()) != null) {
            lifecycle.removeObserver(this);
        }
        contextRef.clear();
    }

    public final void a(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        QLog.d("AIOContextViewModel", 2, "registerContext: context " + context);
        contextRef = new WeakReference<>(context);
        context.d().getLifecycle().addObserver(this);
    }

    public final void b(@Nullable String type, @NotNull com.tencent.mvi.base.route.a action) {
        j e16;
        Intrinsics.checkNotNullParameter(action, "action");
        com.tencent.aio.api.runtime.a aVar = contextRef.get();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.d(type, action);
        }
    }

    public final void c(@NotNull MsgIntent msg2) {
        Unit unit;
        j e16;
        Intrinsics.checkNotNullParameter(msg2, "msg");
        com.tencent.aio.api.runtime.a aVar = contextRef.get();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.h(msg2);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.w("AIOContextViewModel", 1, "sendEvent: AIOContext is NULL, msgIntent " + msg2);
        }
    }

    public final void e(@Nullable String type, @NotNull com.tencent.mvi.base.route.a action) {
        j e16;
        Intrinsics.checkNotNullParameter(action, "action");
        com.tencent.aio.api.runtime.a aVar = contextRef.get();
        if (aVar != null && (e16 = aVar.e()) != null) {
            e16.b(type, action);
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.d("AIOContextViewModel", 4, "onStateChanged: source " + source + ", event " + event);
        int i3 = a.f361709a[event.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    d();
                    QWalletDBManager.f361825a.m();
                    return;
                }
                return;
            }
            com.tencent.aio.api.runtime.a aVar = contextRef.get();
            if (aVar != null) {
                CommandHbGrabber.f361741a.q(aVar);
                return;
            }
            return;
        }
        com.tencent.aio.api.runtime.a aVar2 = contextRef.get();
        if (aVar2 != null) {
            CommandHbGrabber.f361741a.l(aVar2);
        }
    }
}
