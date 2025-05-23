package com.tencent.aio.part.root.mvx.vb;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.aio.api.help.d;
import com.tencent.aio.base.mvvm.a;
import com.tencent.aio.part.fitwindow.vb.FitSystemWindowVB;
import com.tencent.aio.part.root.mvx.intent.a;
import com.tencent.aio.part.root.mvx.vm.RootAIOVM;
import com.tencent.aio.pref.annotation.HookMethodTrace;
import com.tencent.aio.runtime.AIOContextImpl;
import com.tencent.aio.widget.FitSystemWindowsRelativeLayout;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReport;
import com.tencent.mvi.base.mvi.MviUIState;
import com.tencent.mvi.mvvm.BaseVB;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.runtime.strategy.b;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001<B\u000f\u0012\u0006\u00108\u001a\u00020$\u00a2\u0006\u0004\b9\u0010:J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0017J$\u0010\u000f\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\fH\u0017J \u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0017J*\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0017J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\bH\u0016J,\u0010!\u001a\u001e\u0012\u001a\u0012\u0018\u0012\u0006\b\u0001\u0012\u00020 \u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0004\u0012\u00020\f0\u001f0\u001e2\u0006\u0010\u001d\u001a\u00020\u0006H\u0016J\u0016\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\"H\u0016J\u000e\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020$J\u000e\u0010)\u001a\u00020\n2\u0006\u0010(\u001a\u00020'J\b\u0010*\u001a\u00020\nH\u0016R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001b\u00105\u001a\u0002018BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b2\u0010-\u001a\u0004\b3\u00104R\u0014\u00108\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/aio/part/root/mvx/vb/RootAIOVB;", "Lcom/tencent/aio/base/mvvm/a;", "Lcom/tencent/aio/part/root/mvx/intent/a;", "Lcom/tencent/mvi/base/mvi/MviUIState;", "Lcom/tencent/mvi/api/help/a;", "createViewParams", "Landroid/view/View;", "d1", "Lcom/tencent/mvi/api/help/b;", "params", "", "resumeVB", "Lcom/tencent/aio/api/runtime/a;", "context", "Lcom/tencent/mvi/mvvm/BaseVM;", "c1", "Landroid/content/Context;", "outContext", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/tencent/mvi/runtime/strategy/b;", "strategyService", "buildViewTree", "Lcom/tencent/mvi/api/runtime/a;", QAdVrReport.ElementID.AD_POSTER, "preBuildViewTree", "onCreateView", "reuseParam", "onReuseView", "hostView", "", "Lcom/tencent/mvi/mvvm/BaseVB;", "Lol3/b;", "initializeChildVB", "Lcom/tencent/aio/base/mvvm/b;", "e1", "", "fitSystemWindows", "i1", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, "h1", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aio/part/fitwindow/vb/FitSystemWindowVB;", "d", "Lkotlin/Lazy;", "g1", "()Lcom/tencent/aio/part/fitwindow/vb/FitSystemWindowVB;", "fitSystemWindowVB", "Ljava/lang/Runnable;", "e", "f1", "()Ljava/lang/Runnable;", "delayLoadRunnable", "f", "Z", "useDispatcher", "<init>", "(Z)V", h.F, "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class RootAIOVB extends a<com.tencent.aio.part.root.mvx.intent.a, MviUIState> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy fitSystemWindowVB;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Lazy delayLoadRunnable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean useDispatcher;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/aio/part/root/mvx/vb/RootAIOVB$a;", "", "", "DELAY_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.aio.part.root.mvx.vb.RootAIOVB$a, reason: from kotlin metadata */
    /* loaded from: classes3.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45529);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RootAIOVB(boolean z16) {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
            return;
        }
        this.useDispatcher = z16;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<FitSystemWindowVB>() { // from class: com.tencent.aio.part.root.mvx.vb.RootAIOVB$fitSystemWindowVB$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) RootAIOVB.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final FitSystemWindowVB invoke() {
                boolean z17;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    return (FitSystemWindowVB) iPatchRedirector2.redirect((short) 1, (Object) this);
                }
                z17 = RootAIOVB.this.useDispatcher;
                return new FitSystemWindowVB(z17);
            }
        });
        this.fitSystemWindowVB = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, (Function0) new Function0<Runnable>() { // from class: com.tencent.aio.part.root.mvx.vb.RootAIOVB$delayLoadRunnable$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) RootAIOVB.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Runnable invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 1)) ? new Runnable() { // from class: com.tencent.aio.part.root.mvx.vb.RootAIOVB$delayLoadRunnable$2.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                            iPatchRedirector3.redirect((short) 2, (Object) this, (Object) RootAIOVB$delayLoadRunnable$2.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        IPatchRedirector iPatchRedirector3 = $redirector_;
                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                            iPatchRedirector3.redirect((short) 1, (Object) this);
                        } else {
                            RootAIOVB.this.sendIntent(a.C0634a.f69477d);
                        }
                    }
                } : (Runnable) iPatchRedirector2.redirect((short) 1, (Object) this);
            }
        });
        this.delayLoadRunnable = lazy2;
    }

    private final View d1(final com.tencent.mvi.api.help.a createViewParams) {
        final Context a16 = createViewParams.a();
        FrameLayout frameLayout = new FrameLayout(createViewParams, a16) { // from class: com.tencent.aio.part.root.mvx.vb.RootAIOVB$createVBView$1
            static IPatchRedirector $redirector_;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ com.tencent.mvi.api.help.a f69483e;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(a16);
                this.f69483e = createViewParams;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, this, RootAIOVB.this, createViewParams, a16);
                }
            }

            @Override // android.view.ViewGroup, android.view.View
            protected void onAttachedToWindow() {
                AIOContextImpl a17;
                com.tencent.aio.runtime.dispatcher.a q16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                    return;
                }
                super.onAttachedToWindow();
                com.tencent.aio.base.log.a.f69187b.d("RootAIOVB", "onAttachedToWindow " + RootAIOVB.this.getMAIOContext$sdk_debug());
                com.tencent.aio.api.runtime.a mAIOContext$sdk_debug = RootAIOVB.this.getMAIOContext$sdk_debug();
                if (mAIOContext$sdk_debug != null && (a17 = com.tencent.aio.runtime.a.a(mAIOContext$sdk_debug)) != null && (q16 = a17.q()) != null) {
                    q16.a(4);
                }
            }
        };
        frameLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        return frameLayout;
    }

    private final Runnable f1() {
        return (Runnable) this.delayLoadRunnable.getValue();
    }

    private final FitSystemWindowVB g1() {
        return (FitSystemWindowVB) this.fitSystemWindowVB.getValue();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @HookMethodTrace(tag = "RootAIOVB#buildViewTree")
    @NotNull
    public View buildViewTree(@NotNull Context outContext, @NotNull ViewGroup viewGroup, @NotNull b strategyService) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, outContext, viewGroup, strategyService);
        }
        Intrinsics.checkNotNullParameter(outContext, "outContext");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        return super.buildViewTree(outContext, viewGroup, strategyService);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @HookMethodTrace(tag = "RootAIOVB#buildVM")
    @Nullable
    /* renamed from: c1, reason: merged with bridge method [inline-methods] */
    public BaseVM<com.tencent.aio.part.root.mvx.intent.a, MviUIState, com.tencent.aio.api.runtime.a> buildVM(@NotNull com.tencent.aio.api.runtime.a context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BaseVM) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        return super.buildVM(context);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @Nullable
    /* renamed from: e1, reason: merged with bridge method [inline-methods] */
    public com.tencent.aio.base.mvvm.b<com.tencent.aio.part.root.mvx.intent.a, MviUIState> createVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (com.tencent.aio.base.mvvm.b) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return new RootAIOVM((d) getMStrategyService().b(d.class));
    }

    public final void h1(@NotNull Rect rect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) rect);
            return;
        }
        Intrinsics.checkNotNullParameter(rect, "rect");
        com.tencent.aio.base.log.a.f69187b.d("RootAIOVB", "resetFitsSystemWindow " + rect);
        View safetyGetHostView = g1().safetyGetHostView();
        if (!(safetyGetHostView instanceof FitSystemWindowsRelativeLayout)) {
            safetyGetHostView = null;
        }
        FitSystemWindowsRelativeLayout fitSystemWindowsRelativeLayout = (FitSystemWindowsRelativeLayout) safetyGetHostView;
        if (fitSystemWindowsRelativeLayout != null) {
            fitSystemWindowsRelativeLayout.fitSystemWindows(rect);
        }
    }

    public final void i1(boolean fitSystemWindows) {
        View hostView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, fitSystemWindows);
            return;
        }
        FitSystemWindowVB g16 = g1();
        if (g16 != null && (hostView = g16.getHostView()) != null) {
            hostView.setFitsSystemWindows(fitSystemWindows);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @NotNull
    public List<BaseVB<? extends ol3.b, ? extends MviUIState, com.tencent.aio.api.runtime.a>> initializeChildVB(@NotNull View hostView) {
        com.tencent.aio.base.mvvm.a<? extends ol3.b, ? extends MviUIState> a16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this, (Object) hostView);
        }
        Intrinsics.checkNotNullParameter(hostView, "hostView");
        ArrayList arrayList = new ArrayList();
        com.tencent.aio.api.factory.a aVar = (com.tencent.aio.api.factory.a) getMStrategyService().b(com.tencent.aio.api.factory.a.class);
        if (aVar != null && (a16 = aVar.a()) != null) {
            arrayList.add(a16);
        }
        arrayList.add(g1());
        return arrayList;
    }

    @Override // com.tencent.mvi.mvvm.b
    @NotNull
    public View onCreateView(@NotNull com.tencent.mvi.api.help.a createViewParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (View) iPatchRedirector.redirect((short) 5, (Object) this, (Object) createViewParams);
        }
        Intrinsics.checkNotNullParameter(createViewParams, "createViewParams");
        View d16 = d1(createViewParams);
        com.tencent.aio.base.log.a.f69187b.d("RootAIOVB", "onCreateView");
        if (!isPreload()) {
            d16.postDelayed(f1(), 2000L);
        }
        return d16;
    }

    @Override // com.tencent.mvi.mvvm.BaseVB, com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        super.onDestroy();
        View safetyGetHostView = safetyGetHostView();
        if (safetyGetHostView != null) {
            safetyGetHostView.removeCallbacks(f1());
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    public void onReuseView(@NotNull com.tencent.mvi.api.help.b reuseParam) {
        View safetyGetHostView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) reuseParam);
            return;
        }
        Intrinsics.checkNotNullParameter(reuseParam, "reuseParam");
        super.onReuseView(reuseParam);
        com.tencent.aio.base.log.a.f69187b.d("RootAIOVB", "onReuseView");
        if (!isPreload() && (safetyGetHostView = safetyGetHostView()) != null) {
            safetyGetHostView.postDelayed(f1(), 2000L);
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @HookMethodTrace(tag = "RootAIOVB#preBuildViewTree")
    @NotNull
    public View preBuildViewTree(@NotNull Context outContext, @NotNull ViewGroup viewGroup, @NotNull b strategyService, @Nullable com.tencent.mvi.api.runtime.a poster) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, this, outContext, viewGroup, strategyService, poster);
        }
        Intrinsics.checkNotNullParameter(outContext, "outContext");
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        Intrinsics.checkNotNullParameter(strategyService, "strategyService");
        return super.preBuildViewTree(outContext, viewGroup, strategyService, poster);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVB
    @HookMethodTrace(tag = "RootAIOVB#resumeVB")
    public void resumeVB(@NotNull com.tencent.mvi.api.help.b params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) params);
        } else {
            Intrinsics.checkNotNullParameter(params, "params");
            super.resumeVB(params);
        }
    }
}
