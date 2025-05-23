package com.tencent.mobileqq.aio.notification;

import androidx.lifecycle.LifecycleOwner;
import com.tencent.aio.api.runtime.recycler.AIOCacheMarket;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.aio.event.TitleTabEvent;
import com.tencent.mobileqq.aio.input.fullscreen.FullScreenMsgIntent;
import com.tencent.mobileqq.aio.notification.base.AIONotificationEvent;
import com.tencent.mobileqq.aio.notification.base.AIONotificationUIUtils;
import com.tencent.mobileqq.aio.reserve2.notification.AIONotificationUIState;
import com.tencent.mobileqq.aio.title.AIOTitleContainerMsgIntent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0002H\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0011H\u0016J\u0006\u0010\u0013\u001a\u00020\u0007R\u0016\u0010\u0016\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R&\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0017j\b\u0012\u0004\u0012\u00020\u0005`\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/aio/notification/AIONotificationVM;", "Lcom/tencent/qqnt/aio/baseVM/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/a;", "Lcom/tencent/mobileqq/aio/reserve2/notification/AIONotificationUIState;", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mobileqq/aio/notification/base/AIONotificationEvent;", "msg", "", "p", "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", "intent", "o", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/base/route/MsgIntent;", "call", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "e", "Z", "hadInited", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "lazyEventList", "<init>", "()V", h.F, "a", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
@AIOCacheMarket(level = 1)
/* loaded from: classes11.dex */
public final class AIONotificationVM extends com.tencent.qqnt.aio.baseVM.a<com.tencent.mobileqq.aio.reserve2.notification.a, AIONotificationUIState> implements com.tencent.mvi.base.route.a {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile boolean hadInited;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private ArrayList<AIONotificationEvent> lazyEventList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/aio/notification/AIONotificationVM$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.aio.notification.AIONotificationVM$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52805);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public AIONotificationVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.lazyEventList = new ArrayList<>();
        }
    }

    private final void p(final AIONotificationEvent msg2) {
        if (this.hadInited) {
            return;
        }
        AIONotificationUIUtils.f192828a.L(new Function0<Unit>(msg2) { // from class: com.tencent.mobileqq.aio.notification.AIONotificationVM$onGetNotificationEvent$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ AIONotificationEvent $msg;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$msg = msg2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AIONotificationVM.this, (Object) msg2);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                ArrayList arrayList;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                z16 = AIONotificationVM.this.hadInited;
                if (z16) {
                    return;
                }
                arrayList = AIONotificationVM.this.lazyEventList;
                arrayList.add(this.$msg);
                AIONotificationVM.this.updateUI(AIONotificationUIState.LazyInitVB.f193493d);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void r(AIONotificationVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.hadInited = true;
        Iterator<AIONotificationEvent> it = this$0.lazyEventList.iterator();
        while (it.hasNext()) {
            AIONotificationEvent event = it.next();
            j e16 = ((com.tencent.aio.api.runtime.a) this$0.getMContext()).e();
            Intrinsics.checkNotNullExpressionValue(event, "event");
            e16.h(event);
        }
        this$0.lazyEventList.clear();
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVM", 2, "onLazyInitDone: ");
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public void call(@NotNull MsgIntent msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) msg2);
            return;
        }
        Intrinsics.checkNotNullParameter(msg2, "msg");
        if (msg2 instanceof TitleTabEvent.OnFeedTabSelected) {
            updateUI(AIONotificationUIState.FadeHideNotification.f193490d);
            return;
        }
        if (msg2 instanceof TitleTabEvent.OnMsgTabSelected) {
            updateUI(AIONotificationUIState.FadeShowNotification.f193491d);
            return;
        }
        if (msg2 instanceof AIONotificationEvent.AddNotificationEvent) {
            p((AIONotificationEvent) msg2);
            return;
        }
        if (msg2 instanceof AIONotificationEvent.UpdateNotificationEvent) {
            p((AIONotificationEvent) msg2);
            return;
        }
        if (msg2 instanceof AIONotificationEvent.RemoveNotificationEvent) {
            p((AIONotificationEvent) msg2);
        } else if (msg2 instanceof FullScreenMsgIntent.OnFullScreenModeChanged) {
            updateUI(new AIONotificationUIState.UpdateVisibilityUIState(!((FullScreenMsgIntent.OnFullScreenModeChanged) msg2).a()));
        } else if (msg2 instanceof AIOTitleContainerMsgIntent.NotifyTitleHeight) {
            updateUI(new AIONotificationUIState.UpdateTitleHeight(((AIOTitleContainerMsgIntent.NotifyTitleHeight) msg2).a()));
        }
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull com.tencent.mobileqq.aio.reserve2.notification.a intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        } else {
            Intrinsics.checkNotNullParameter(intent, "intent");
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
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVM", 2, "onCreate: ");
        }
        j e16 = context.e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        String a16 = jVar.a(Reflection.getOrCreateKotlinClass(TitleTabEvent.OnFeedTabSelected.class));
        LifecycleOwner d16 = context.d();
        Intrinsics.checkNotNullExpressionValue(d16, "context.lifecycleOwner");
        e16.c(a16, this, d16);
        j e17 = context.e();
        String a17 = jVar.a(Reflection.getOrCreateKotlinClass(TitleTabEvent.OnMsgTabSelected.class));
        LifecycleOwner d17 = context.d();
        Intrinsics.checkNotNullExpressionValue(d17, "context.lifecycleOwner");
        e17.c(a17, this, d17);
        j e18 = context.e();
        String a18 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.AddNotificationEvent.class));
        LifecycleOwner d18 = context.d();
        Intrinsics.checkNotNullExpressionValue(d18, "context.lifecycleOwner");
        e18.c(a18, this, d18);
        j e19 = context.e();
        String a19 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.RemoveNotificationEvent.class));
        LifecycleOwner d19 = context.d();
        Intrinsics.checkNotNullExpressionValue(d19, "context.lifecycleOwner");
        e19.c(a19, this, d19);
        j e26 = context.e();
        String a26 = jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateNotificationEvent.class));
        LifecycleOwner d26 = context.d();
        Intrinsics.checkNotNullExpressionValue(d26, "context.lifecycleOwner");
        e26.c(a26, this, d26);
        j e27 = context.e();
        String a27 = jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class));
        LifecycleOwner d27 = context.d();
        Intrinsics.checkNotNullExpressionValue(d27, "context.lifecycleOwner");
        e27.c(a27, this, d27);
        j e28 = context.e();
        String a28 = jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleContainerMsgIntent.NotifyTitleHeight.class));
        LifecycleOwner d28 = context.d();
        Intrinsics.checkNotNullExpressionValue(d28, "context.lifecycleOwner");
        e28.c(a28, this, d28);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.qqnt.aio.baseVM.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        super.onDestroy();
        j e16 = ((com.tencent.aio.api.runtime.a) getMContext()).e();
        com.tencent.qqnt.aio.utils.j jVar = com.tencent.qqnt.aio.utils.j.f352301a;
        e16.b(jVar.a(Reflection.getOrCreateKotlinClass(TitleTabEvent.OnFeedTabSelected.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(TitleTabEvent.OnMsgTabSelected.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.AddNotificationEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.RemoveNotificationEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIONotificationEvent.UpdateNotificationEvent.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(FullScreenMsgIntent.OnFullScreenModeChanged.class)), this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(jVar.a(Reflection.getOrCreateKotlinClass(AIOTitleContainerMsgIntent.NotifyTitleHeight.class)), this);
        if (QLog.isColorLevel()) {
            QLog.d("AIONotificationVM", 2, "onDestroy: ");
        }
    }

    public final void q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.aio.notification.b
                @Override // java.lang.Runnable
                public final void run() {
                    AIONotificationVM.r(AIONotificationVM.this);
                }
            });
        }
    }

    @Override // com.tencent.mvi.base.route.a
    public boolean sticky() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return a.C9235a.a(this);
    }
}
