package com.tencent.mobileqq.aio.notification.background;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.AIOMsgListEvent;
import com.tencent.mobileqq.aio.event.ThemeEvent;
import com.tencent.mobileqq.aio.lateinit.aioreserve1.AIOReserve1CreateModelIntent;
import com.tencent.mobileqq.aio.msglist.z;
import com.tencent.mobileqq.aio.notification.AIONotificationExtEvent;
import com.tencent.mobileqq.aio.notification.base.AIONotificationEvent;
import com.tencent.mobileqq.aio.reserve1.navigation.NavigationMsgIntent;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.aio.reserve2.notification.a;
import com.tencent.mobileqq.aio.utils.AIOUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 \u00182\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u0019B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u0005H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/background/f;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState;", "Lcom/tencent/mvi/base/route/a;", "", "l", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "call", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "e", "I", "blurViewHeight", "<init>", "()V", "f", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class f extends com.tencent.qqnt.aio.baseVM.a<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState> implements com.tencent.mvi.base.route.a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int blurViewHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/background/f$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.background.f$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52833);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l() {
        k k3 = ((com.tencent.aio.api.runtime.a) getMContext()).e().k(AIOMsgListEvent.BottomBlurEvent.f188279d);
        Intrinsics.checkNotNull(k3, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msglist.MsgListResult.GetBlurRecyclerView");
        updateUI(new AIONotificationUIState.UpdateBlurViewUIState(((z.b) k3).b(), AIOUtil.f194084a.b((com.tencent.aio.api.runtime.a) getMContext())));
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) i3);
            return;
        }
        Intrinsics.checkNotNullParameter(i3, "i");
        if (i3 instanceof AIONotificationEvent.UpdateContainerSizeEvent) {
            AIONotificationEvent.UpdateContainerSizeEvent updateContainerSizeEvent = (AIONotificationEvent.UpdateContainerSizeEvent) i3;
            updateUI(new AIONotificationUIState.UpdateContainerSizeUIState(updateContainerSizeEvent.b(), updateContainerSizeEvent.a()));
        } else if (i3 instanceof AIONotificationExtEvent.GetNotificationHeightEvent) {
            ((AIONotificationExtEvent.GetNotificationHeightEvent) i3).b(this.blurViewHeight);
        } else if (i3 instanceof ThemeEvent.PostThemeChanged) {
            updateUI(AIONotificationUIState.OnThemeChangeUIState.f193494d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.aio.reserve2.notification.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C7353a) {
            l();
            return;
        }
        if (intent instanceof a.c) {
            j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
            if (e16 != null) {
                e16.h(new AIOReserve1CreateModelIntent("aio_navigation", new NavigationMsgIntent.UpdateNavigationTranslationY(((a.c) intent).a())));
                return;
            }
            return;
        }
        if (intent instanceof a.b) {
            this.blurViewHeight = ((a.b) intent).a();
        }
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        j e16 = context.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        String a16 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateContainerSizeEvent.class));
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(a16, this, d16);
        j e17 = context.e();
        String a17 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationExtEvent.GetNotificationHeightEvent.class));
        LifecycleOwner d17 = context.d();
        Intrinsics.checkNotNullExpressionValue(d17, "context.lifecycleOwner");
        e17.c(a17, this, d17);
        j e18 = context.e();
        String a18 = jVar.a(Reflection.getOrCreateKotlinClass(ThemeEvent.PostThemeChanged.class));
        LifecycleOwner d18 = context.d();
        Intrinsics.checkNotNullExpressionValue(d18, "context.lifecycleOwner");
        e18.c(a18, this, d18);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        super.onDestroy();
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateContainerSizeEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationExtEvent.GetNotificationHeightEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(ThemeEvent.PostThemeChanged.class)), this);
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return a.C9235a.a(this);
    }
}
