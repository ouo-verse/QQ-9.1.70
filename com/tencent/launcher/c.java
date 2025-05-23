package com.tencent.launcher;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mvi.base.route.VMMessenger;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.runtime.strategy.IStrategyFetcher;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0005\bB\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\t"}, d2 = {"Lcom/tencent/launcher/c;", "", "Lcom/tencent/launcher/d;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Lcom/tencent/launcher/a;", "a", "<init>", "()V", "b", "input-base_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class c {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J*\u0010\b\u001a\u00020\u0007\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016J%\u0010\t\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\t\u0010\nJ\u001c\u0010\f\u001a\u00020\u000b\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016R(\u0010\u000f\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/launcher/c$a;", "Lcom/tencent/mvi/runtime/strategy/b;", "T", "Ljava/lang/Class;", "clazz", "Lcom/tencent/mvi/runtime/strategy/IStrategyFetcher;", "fetcher", "", "c", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "", "a", "", "Ljava/util/Map;", "servicePool", "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements com.tencent.mvi.runtime.strategy.b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Map<Class<?>, IStrategyFetcher<?>> servicePool;

        public a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            } else {
                this.servicePool = new LinkedHashMap();
            }
        }

        @Override // com.tencent.mvi.runtime.strategy.b
        public <T> boolean a(@NotNull Class<T> clazz) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) clazz)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return this.servicePool.containsKey(clazz);
        }

        @Override // com.tencent.mvi.runtime.strategy.b
        @Nullable
        public <T> T b(@NotNull Class<T> clazz) {
            IStrategyFetcher<?> iStrategyFetcher;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            IStrategyFetcher<?> iStrategyFetcher2 = this.servicePool.get(clazz);
            if (iStrategyFetcher2 instanceof IStrategyFetcher) {
                iStrategyFetcher = iStrategyFetcher2;
            } else {
                iStrategyFetcher = null;
            }
            if (iStrategyFetcher == null) {
                return null;
            }
            return (T) iStrategyFetcher.b();
        }

        @Override // com.tencent.mvi.runtime.strategy.b
        public <T> void c(@NotNull Class<T> clazz, @NotNull IStrategyFetcher<T> fetcher) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz, (Object) fetcher);
                return;
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            this.servicePool.put(clazz, fetcher);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\"\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J#\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/launcher/c$b;", "Lml3/b;", "T", "Ljava/lang/Class;", "clazz", "Lml3/a;", "a", "b", "(Ljava/lang/Class;)Ljava/lang/Object;", "<init>", "()V", "input-base_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class b implements ml3.b {
        static IPatchRedirector $redirector_;

        /* JADX INFO: Add missing generic type declarations: [T] */
        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\b\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"com/tencent/launcher/c$b$a", "Lml3/a;", "callback", "", "a", "(Ljava/lang/Object;)V", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "b", "(Ljava/lang/Object;Landroidx/lifecycle/LifecycleOwner;)V", "", "c", "(Ljava/lang/Object;)Z", "input-base_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes7.dex */
        public static final class a<T> implements ml3.a<T> {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            @Override // ml3.a
            public void a(T callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) callback);
                }
            }

            @Override // ml3.a
            public void b(T callback, @NotNull LifecycleOwner lifecycleOwner) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback, (Object) lifecycleOwner);
                } else {
                    Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
                }
            }

            @Override // ml3.a
            public boolean c(T callback) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) callback)).booleanValue();
                }
                return false;
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // ml3.b
        @NotNull
        public <T> ml3.a<T> a(@NotNull Class<T> clazz) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ml3.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) clazz);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            return new a();
        }

        @Override // ml3.b
        public <T> T b(@NotNull Class<T> clazz) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (T) iPatchRedirector.redirect((short) 3, (Object) this, (Object) clazz);
            }
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            throw new RuntimeException("not yet implement");
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final com.tencent.launcher.a a(@NotNull d launchParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.launcher.a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) launchParam);
        }
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        com.tencent.base.runtime.a aVar = new com.tencent.base.runtime.a();
        aVar.r(launchParam.d());
        aVar.p(launchParam.b());
        aVar.t(launchParam.e());
        aVar.u(new VMMessenger(false, null, 2, null));
        ml3.b c16 = launchParam.c();
        if (c16 == null) {
            c16 = new b();
        }
        aVar.q(c16);
        com.tencent.base.runtime.launcher.b bVar = com.tencent.base.runtime.launcher.b.f77570a;
        FragmentActivity requireActivity = launchParam.d().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "launchParam.fragment.requireActivity()");
        aVar.s(new com.tencent.base.runtime.launcher.c(bVar, requireActivity));
        BaseVB<?, ?, ? super com.tencent.mvi.api.runtime.b> g16 = launchParam.g();
        Context requireContext = aVar.k().requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "baseContext.mFragment.requireContext()");
        ViewGroup f16 = launchParam.f();
        com.tencent.mvi.runtime.strategy.b h16 = launchParam.h();
        if (h16 == null) {
            h16 = new a();
        }
        View buildViewTree = g16.buildViewTree(requireContext, f16, h16);
        if (launchParam.a()) {
            launchParam.f().addView(buildViewTree);
        }
        launchParam.g().buildVM(aVar);
        return new com.tencent.launcher.b(aVar);
    }
}
