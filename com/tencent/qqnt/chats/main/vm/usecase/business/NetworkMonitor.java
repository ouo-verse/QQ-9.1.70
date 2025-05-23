package com.tencent.qqnt.chats.main.vm.usecase.business;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.Lifecycle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.main.vm.usecase.lifecycle.a;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u00009\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001\u0018\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R$\u0010\u0012\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/business/NetworkMonitor;", "Lcom/tencent/qqnt/chats/main/vm/usecase/lifecycle/a;", "Landroid/content/Context;", "context", "", "d", "e", "f", "Lcom/tencent/qqnt/chats/main/vm/usecase/lifecycle/a$a;", "params", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "a", "Landroid/view/View;", "Landroid/view/View;", "b", "()Landroid/view/View;", "setTipView", "(Landroid/view/View;)V", "tipView", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isShowing", "com/tencent/qqnt/chats/main/vm/usecase/business/NetworkMonitor$c", "Lcom/tencent/qqnt/chats/main/vm/usecase/business/NetworkMonitor$c;", "networkCallback", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NetworkMonitor implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View tipView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AtomicBoolean isShowing;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private c networkCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/business/NetworkMonitor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.usecase.business.NetworkMonitor$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes24.dex */
    public /* synthetic */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355460a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46268);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[Lifecycle.State.values().length];
            try {
                iArr[Lifecycle.State.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.State.DESTROYED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.State.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f355460a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/chats/main/vm/usecase/business/NetworkMonitor$c", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "", "onAvailable", "onLost", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class c extends ConnectivityManager.NetworkCallback {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) NetworkMonitor.this);
            }
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onAvailable(@NotNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) network);
                return;
            }
            Intrinsics.checkNotNullParameter(network, "network");
            super.onAvailable(network);
            QLog.d(com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.TAG, 1, "onAvailable: " + NetworkMonitor.this.c());
            if (!NetworkMonitor.this.c().get()) {
                return;
            }
            View b16 = NetworkMonitor.this.b();
            if (b16 != null) {
                com.tencent.qqnt.chats.c.f354431a.b(new a.C9590a(b16, 1, false, false, 8, null));
            }
            NetworkMonitor.this.c().set(false);
        }

        @Override // android.net.ConnectivityManager.NetworkCallback
        public void onLost(@NotNull Network network) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) network);
                return;
            }
            Intrinsics.checkNotNullParameter(network, "network");
            super.onLost(network);
            QLog.d(com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.TAG, 1, "onLost: " + NetworkMonitor.this.c());
            if (NetworkMonitor.this.c().get()) {
                return;
            }
            View b16 = NetworkMonitor.this.b();
            if (b16 != null) {
                com.tencent.qqnt.chats.c.f354431a.b(new a.C9590a(b16, 1, true, false, 8, null));
            }
            NetworkMonitor.this.c().set(true);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46270);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public NetworkMonitor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.isShowing = new AtomicBoolean(false);
            this.networkCallback = new c();
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.lifecycle.a
    @Nullable
    public com.tencent.qqnt.chats.main.vm.usecase.result.a a(@NotNull a.C9599a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.result.a) iPatchRedirector.redirect((short) 8, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        int i3 = b.f355460a[params.b().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    f(params.a());
                    return null;
                }
                return null;
            }
            e(params.a());
            QLog.d(com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.TAG, 1, "stopListen");
            return null;
        }
        d(params.a());
        QLog.d(com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.TAG, 1, "startListen");
        return null;
    }

    @Nullable
    public final View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.tipView;
    }

    @NotNull
    public final AtomicBoolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AtomicBoolean) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.isShowing;
    }

    public final void d(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (this.tipView == null) {
            this.tipView = LayoutInflater.from(context).inflate(R.layout.f169108hs3, (ViewGroup) null, false);
        }
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.registerDefaultNetworkCallback(this.networkCallback);
        }
    }

    public final void e(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        if (Build.VERSION.SDK_INT >= 24) {
            connectivityManager.unregisterNetworkCallback(this.networkCallback);
        }
        View view = this.tipView;
        if (view != null) {
            com.tencent.qqnt.chats.c.f354431a.b(new a.C9590a(view, 1, false, false, 8, null));
            this.isShowing.set(false);
        }
        this.tipView = null;
    }

    @RequiresApi(23)
    public final void f(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Object systemService = context.getSystemService("connectivity");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.net.ConnectivityManager");
        Network activeNetwork = ((ConnectivityManager) systemService).getActiveNetwork();
        QLog.d(com.tencent.qmethod.pandoraex.monitor.NetworkMonitor.TAG, 1, "updateNetwork: " + activeNetwork);
        if (activeNetwork == null) {
            if (this.isShowing.compareAndSet(false, true)) {
                com.tencent.qqnt.chats.c cVar = com.tencent.qqnt.chats.c.f354431a;
                View view = this.tipView;
                Intrinsics.checkNotNull(view);
                cVar.b(new a.C9590a(view, 1, true, false, 8, null));
                return;
            }
            return;
        }
        if (this.isShowing.compareAndSet(true, false)) {
            com.tencent.qqnt.chats.c cVar2 = com.tencent.qqnt.chats.c.f354431a;
            View view2 = this.tipView;
            Intrinsics.checkNotNull(view2);
            cVar2.b(new a.C9590a(view2, 1, false, false, 8, null));
        }
    }
}
