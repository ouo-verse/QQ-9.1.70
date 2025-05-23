package com.tencent.qqnt.inner.observer;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qqnt.inner.TroopLifecycleCallback;
import com.tencent.qqnt.troop.ab;
import com.tencent.qqnt.troop.f;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0001\rB\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\r\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fR!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00128BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001f\u00a8\u0006$"}, d2 = {"Lcom/tencent/qqnt/inner/observer/TroopInfoChangedDispatcher;", "Lcom/tencent/qqnt/troop/f;", "Landroid/os/Handler$Callback;", "", "e", "Landroid/os/Message;", "msg", "", "handleMessage", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/qqnt/troop/ab;", "observer", "a", "b", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "troopInfo", h.F, "Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "d", "Lkotlin/Lazy;", "g", "()Lcom/tencent/qqnt/inner/TroopLifecycleCallback;", "observers", "", "Ljava/util/Set;", "dispatchingTroopInfo", "f", "Z", "isWaitingDispatching", "Landroid/os/Handler;", "Landroid/os/Handler;", "handler", "<init>", "()V", "i", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopInfoChangedDispatcher implements f, Handler.Callback {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy observers;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Set<TroopInfo> dispatchingTroopInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isWaitingDispatching;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Handler handler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/qqnt/inner/observer/TroopInfoChangedDispatcher$a;", "", "", "DEFAULT_DISPATCH_DELAY_TIME", "J", "", "MSG_DISPATCH", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.inner.observer.TroopInfoChangedDispatcher$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62339);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopInfoChangedDispatcher() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(TroopInfoChangedDispatcher$observers$2.INSTANCE);
            this.observers = lazy;
            this.dispatchingTroopInfo = new LinkedHashSet();
            this.handler = new Handler(Looper.getMainLooper(), this);
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    private final void e() {
        final ArrayList arrayList = new ArrayList(this.dispatchingTroopInfo);
        this.dispatchingTroopInfo.clear();
        bg.f302144a.j(new Runnable() { // from class: com.tencent.qqnt.inner.observer.b
            @Override // java.lang.Runnable
            public final void run() {
                TroopInfoChangedDispatcher.f(TroopInfoChangedDispatcher.this, arrayList);
            }
        });
        this.isWaitingDispatching = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TroopInfoChangedDispatcher this$0, final ArrayList troopInfoList) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopInfoList, "$troopInfoList");
        this$0.g().c(new Function1<ab, Unit>(troopInfoList) { // from class: com.tencent.qqnt.inner.observer.TroopInfoChangedDispatcher$dispatch$1$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ ArrayList<TroopInfo> $troopInfoList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$troopInfoList = troopInfoList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopInfoList);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ab abVar) {
                invoke2(abVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ab observer) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) observer);
                    return;
                }
                Intrinsics.checkNotNullParameter(observer, "observer");
                for (TroopInfo it : this.$troopInfoList) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    observer.a(it);
                }
            }
        });
    }

    private final TroopLifecycleCallback<ab> g() {
        return (TroopLifecycleCallback) this.observers.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(TroopInfoChangedDispatcher this$0, TroopInfo troopInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(troopInfo, "$troopInfo");
        this$0.dispatchingTroopInfo.add(troopInfo);
        if (!this$0.isWaitingDispatching) {
            this$0.isWaitingDispatching = true;
            this$0.handler.sendEmptyMessageDelayed(1, 500L);
        }
    }

    @Override // com.tencent.qqnt.troop.f
    public void a(@Nullable LifecycleOwner lifecycleOwner, @NotNull ab observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) lifecycleOwner, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            g().h(lifecycleOwner, observer);
        }
    }

    @Override // com.tencent.qqnt.troop.f
    public void b(@NotNull ab observer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) observer);
        } else {
            Intrinsics.checkNotNullParameter(observer, "observer");
            g().g(observer);
        }
    }

    public final void h(@NotNull final TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
            this.handler.post(new Runnable() { // from class: com.tencent.qqnt.inner.observer.c
                @Override // java.lang.Runnable
                public final void run() {
                    TroopInfoChangedDispatcher.i(TroopInfoChangedDispatcher.this, troopInfo);
                }
            });
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@NotNull Message msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) msg2)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2.what == 1) {
            e();
        }
        return true;
    }
}
