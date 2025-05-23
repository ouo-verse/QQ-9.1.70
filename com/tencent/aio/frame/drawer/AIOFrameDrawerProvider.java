package com.tencent.aio.frame.drawer;

import android.content.Context;
import android.view.View;
import bt.a;
import bt.b;
import com.tencent.aio.api.frame.IAIOFramesProvider;
import com.tencent.aio.api.runtime.emitter.a;
import com.tencent.aio.frame.api.c;
import com.tencent.aio.frame.api.d;
import com.tencent.aio.frame.api.e;
import com.tencent.aio.frame.service.DrawerFrameBackEventDispatcher;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001+BG\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00126\u0010'\u001a2\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0 \u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u001a\u0010\u000f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u000e\u0012\u0004\u0012\u00020\u00030\rH\u0016J \u0010\u0014\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016R\u0016\u0010\u0017\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eRD\u0010'\u001a2\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b($\u0012\u0013\u0012\u00110!\u00a2\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u000b0 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/aio/frame/drawer/AIOFrameDrawerProvider;", "Lcom/tencent/aio/api/frame/IAIOFramesProvider;", "Lcom/tencent/aio/frame/drawer/DrawerFrameViewGroup;", "Lcom/tencent/aio/frame/api/e;", "Lcom/tencent/aio/api/runtime/emitter/a;", "Landroid/content/Context;", "context", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "onBackEvent", "containerView", "", "l", "Lkotlin/Pair;", "Ljava/lang/Class;", "d", "Landroid/view/View;", "chatFrame", "Lcom/tencent/aio/api/frame/a;", "framesConfig", DomainData.DOMAIN_NAME, "f", "Lcom/tencent/aio/frame/api/e;", "controller", "Lcom/tencent/aio/frame/service/DrawerFrameBackEventDispatcher;", h.F, "Lcom/tencent/aio/frame/service/DrawerFrameBackEventDispatcher;", "backDispatcher", "Lcom/tencent/aio/frame/api/c;", "i", "Lcom/tencent/aio/frame/api/c;", "drawerFrameProvider", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "newScrollX", "oldScrollX", "Lkotlin/jvm/functions/Function2;", "scrollWatch", "<init>", "(Lcom/tencent/aio/frame/api/c;Lkotlin/jvm/functions/Function2;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public final class AIOFrameDrawerProvider extends IAIOFramesProvider<DrawerFrameViewGroup, e> implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a C;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private e controller;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final DrawerFrameBackEventDispatcher backDispatcher;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final c drawerFrameProvider;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final Function2<Integer, Integer, Unit> scrollWatch;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/frame/drawer/AIOFrameDrawerProvider$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "core-frame-ktx_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007\u00b8\u0006\b"}, d2 = {"com/tencent/aio/frame/drawer/AIOFrameDrawerProvider$onCreateFrameContainerView$1$2$1", "Lcom/tencent/aio/frame/api/d;", "", "scrollX", "oldScrollX", "", "b", "core-frame-ktx_debug", "com/tencent/aio/frame/drawer/AIOFrameDrawerProvider$$special$$inlined$also$lambda$1"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b implements d {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIOFrameDrawerProvider.this);
            }
        }

        @Override // com.tencent.aio.frame.api.d
        public void b(int scrollX, int oldScrollX) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(scrollX), Integer.valueOf(oldScrollX));
            } else {
                AIOFrameDrawerProvider.this.scrollWatch.invoke(Integer.valueOf(scrollX), Integer.valueOf(oldScrollX));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(AppConstants.RichMediaErrorCode.ERROR_MSG_TIMEOUT);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            C = new a(null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AIOFrameDrawerProvider(@NotNull c drawerFrameProvider, @NotNull Function2<? super Integer, ? super Integer, Unit> scrollWatch) {
        Intrinsics.checkNotNullParameter(drawerFrameProvider, "drawerFrameProvider");
        Intrinsics.checkNotNullParameter(scrollWatch, "scrollWatch");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) drawerFrameProvider, (Object) scrollWatch);
            return;
        }
        this.drawerFrameProvider = drawerFrameProvider;
        this.scrollWatch = scrollWatch;
        this.backDispatcher = new DrawerFrameBackEventDispatcher();
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    @NotNull
    public Pair<Class<e>, e> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Pair) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        e eVar = this.controller;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
        }
        return TuplesKt.to(e.class, eVar);
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull DrawerFrameViewGroup containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        containerView.f();
        this.drawerFrameProvider.d(containerView);
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    @NotNull
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public DrawerFrameViewGroup g(@NotNull Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            return (DrawerFrameViewGroup) iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        DrawerFrameViewGroup drawerFrameViewGroup = new DrawerFrameViewGroup(context, null, 0, 6, null);
        AIOFrameDrawerController aIOFrameDrawerController = new AIOFrameDrawerController(new WeakReference(drawerFrameViewGroup), new Function1<a.InterfaceC0149a, Unit>() { // from class: com.tencent.aio.frame.drawer.AIOFrameDrawerProvider$onCreateFrameContainerView$$inlined$also$lambda$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AIOFrameDrawerProvider.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(a.InterfaceC0149a interfaceC0149a) {
                invoke2(interfaceC0149a);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull a.InterfaceC0149a it) {
                c cVar;
                c cVar2;
                Object obj;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                cVar = AIOFrameDrawerProvider.this.drawerFrameProvider;
                if (b.a(cVar)) {
                    obj = AIOFrameDrawerProvider.this.drawerFrameProvider;
                    if (obj == null) {
                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.aio.frame.params.IDrawerDeliveryApi");
                    }
                    ((bt.a) obj).a(it);
                    return;
                }
                StringBuilder sb5 = new StringBuilder();
                cVar2 = AIOFrameDrawerProvider.this.drawerFrameProvider;
                sb5.append(cVar2);
                sb5.append(" must implement  IDrawerDeliveryApi !!");
                throw new IllegalStateException(sb5.toString().toString());
            }
        });
        aIOFrameDrawerController.a(new b());
        Unit unit = Unit.INSTANCE;
        this.controller = aIOFrameDrawerController;
        return drawerFrameViewGroup;
    }

    @Override // com.tencent.aio.api.frame.IAIOFramesProvider
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void h(@NotNull DrawerFrameViewGroup containerView, @NotNull View chatFrame, @NotNull com.tencent.aio.api.frame.a framesConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, containerView, chatFrame, framesConfig);
            return;
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        Intrinsics.checkNotNullParameter(chatFrame, "chatFrame");
        Intrinsics.checkNotNullParameter(framesConfig, "framesConfig");
        c cVar = this.drawerFrameProvider;
        framesConfig.e(new com.tencent.aio.frame.service.a(framesConfig.b(), this.backDispatcher));
        Unit unit = Unit.INSTANCE;
        Context b16 = b();
        e eVar = this.controller;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("controller");
        }
        cVar.c(framesConfig, b16, eVar);
        new DrawerFrameManager(framesConfig).c(this.drawerFrameProvider, chatFrame, containerView);
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        e eVar = this.controller;
        if (eVar != null) {
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("controller");
            }
            if (eVar.i()) {
                if (this.backDispatcher.onBackEvent()) {
                    return true;
                }
                e eVar2 = this.controller;
                if (eVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("controller");
                }
                e.g(eVar2, 0, 1, null);
                return true;
            }
        }
        return a.C0623a.a(this);
    }
}
