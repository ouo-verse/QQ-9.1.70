package com.tencent.mobileqq.aio.notification.list;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.panelcontainer.PanelContainerMsgIntent;
import com.tencent.input.base.panelcontainer.keyboard.KeyboardMsgIntent;
import com.tencent.mobileqq.aio.notification.base.AIONotificationEvent;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00142\u00020\u00012\u00020\u0002:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0003H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016R\u0016\u0010\u0011\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/j;", "Lcom/tencent/mobileqq/aio/notification/base/c;", "Lcom/tencent/aio/api/runtime/emitter/a;", "", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "Lcom/tencent/mvi/base/route/MsgIntent;", "msg", "call", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackEvent", "D", "Z", "isNotificationListExpanding", "<init>", "()V", "E", "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class j extends com.tencent.mobileqq.aio.notification.base.c implements com.tencent.aio.api.runtime.emitter.a {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean isNotificationListExpanding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/list/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.list.j$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54420);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void p() {
        this.isNotificationListExpanding = false;
        updateUI(AIONotificationUIState.CloseListUIState.f193488d);
    }

    @Override // com.tencent.mobileqq.aio.notification.base.c, com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof AIONotificationEvent.ExpandListEvent) {
            this.isNotificationListExpanding = true;
            updateUI(AIONotificationUIState.ExpandListUIState.f193489d);
            return;
        }
        if (msg2 instanceof AIONotificationEvent.CloseListEvent) {
            p();
            return;
        }
        if (msg2 instanceof AIONotificationEvent.UpdateContainerSizeEvent) {
            AIONotificationEvent.UpdateContainerSizeEvent updateContainerSizeEvent = (AIONotificationEvent.UpdateContainerSizeEvent) msg2;
            updateUI(new AIONotificationUIState.UpdateContainerSizeUIState(updateContainerSizeEvent.b(), updateContainerSizeEvent.a()));
            return;
        }
        if (msg2 instanceof AIONotificationEvent.UpdateRecyclerViewHeightEvent) {
            AIONotificationEvent.UpdateRecyclerViewHeightEvent updateRecyclerViewHeightEvent = (AIONotificationEvent.UpdateRecyclerViewHeightEvent) msg2;
            updateUI(new AIONotificationUIState.UpdateRecyclerViewHeightUIState(updateRecyclerViewHeightEvent.a(), updateRecyclerViewHeightEvent.b()));
        } else if (msg2 instanceof KeyboardMsgIntent.OnKeyboardStateChanged) {
            updateUI(new AIONotificationUIState.KeyboardOrPanelUIState(((KeyboardMsgIntent.OnKeyboardStateChanged) msg2).b()));
        } else if (msg2 instanceof PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) {
            updateUI(new AIONotificationUIState.KeyboardOrPanelUIState(((PanelContainerMsgIntent.OnPanelStateChangedMsgIntent) msg2).b()));
        } else {
            super.call(msg2);
        }
    }

    @Override // com.tencent.aio.api.runtime.emitter.a
    public boolean onBackEvent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        if (this.isNotificationListExpanding) {
            p();
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.aio.notification.base.c, com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, context, Boolean.valueOf(reuse));
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
        com.tencent.mvi.base.route.j e16 = context.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        String a16 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.ExpandListEvent.class));
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(a16, this, d16);
        com.tencent.mvi.base.route.j e17 = context.e();
        String a17 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.CloseListEvent.class));
        LifecycleOwner d17 = context.d();
        Intrinsics.checkNotNullExpressionValue(d17, "context.lifecycleOwner");
        e17.c(a17, this, d17);
        ml3.a a18 = context.b().a(com.tencent.aio.api.runtime.emitter.a.class);
        LifecycleOwner d18 = context.d();
        Intrinsics.checkNotNullExpressionValue(d18, "context.lifecycleOwner");
        a18.b(this, d18);
        com.tencent.mvi.base.route.j e18 = context.e();
        String a19 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateContainerSizeEvent.class));
        LifecycleOwner d19 = context.d();
        Intrinsics.checkNotNullExpressionValue(d19, "context.lifecycleOwner");
        e18.c(a19, this, d19);
        com.tencent.mvi.base.route.j e19 = context.e();
        String a26 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateRecyclerViewHeightEvent.class));
        LifecycleOwner d26 = context.d();
        Intrinsics.checkNotNullExpressionValue(d26, "context.lifecycleOwner");
        e19.c(a26, this, d26);
        com.tencent.mvi.base.route.j e26 = context.e();
        String a27 = jVar.a(Reflection.getOrCreateKotlinClass(KeyboardMsgIntent.OnKeyboardStateChanged.class));
        LifecycleOwner d27 = context.d();
        Intrinsics.checkNotNullExpressionValue(d27, "context.lifecycleOwner");
        e26.c(a27, this, d27);
        com.tencent.mvi.base.route.j e27 = context.e();
        String a28 = jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class));
        LifecycleOwner d28 = context.d();
        Intrinsics.checkNotNullExpressionValue(d28, "context.lifecycleOwner");
        e27.c(a28, this, d28);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.aio.notification.base.c, com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        com.tencent.mvi.base.route.j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.ExpandListEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.CloseListEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateContainerSizeEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).b().a(com.tencent.aio.api.runtime.emitter.a.class).c(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateRecyclerViewHeightEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(KeyboardMsgIntent.OnKeyboardStateChanged.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(PanelContainerMsgIntent.OnPanelStateChangedMsgIntent.class)), this);
        super.onDestroy();
    }
}
