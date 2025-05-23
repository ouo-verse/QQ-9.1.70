package com.tencent.mobileqq.guild.feed.nativepublish.feature;

import am1.a;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.input.base.mvicompat.ex.VMMessengerProtocolSupport;
import com.tencent.input.base.mvicompat.ex.a;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.g;
import com.tencent.mobileqq.guild.feed.nativepublish.FeedEditorConfiguration;
import com.tencent.mobileqq.guild.feed.nativepublish.edittext.GuildFeedEditTextMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.movement.SimplifiedFeedEditorGlobalController;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.msgintent.SimplifiedFeedEditorGlobalMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.root.msgintent.FeedEditorRootMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorAtUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.c;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.mvi.mvvm.framework.FrameworkVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.InputMethodUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00012\u00020\u00052\u00020\u00062\u00020\u0007B\u000f\u0012\u0006\u00100\u001a\u00020-\u00a2\u0006\u0004\b?\u0010@J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000e\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000fH\u0002J\u0010\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0011H\u0002J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0015H\u0002J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u0004H\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010\r\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\n2\u0006\u0010%\u001a\u00020\u0002H\u0016J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010\r\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020\n2\u0006\u0010\r\u001a\u00020(H\u0016J\b\u0010,\u001a\u00020\nH\u0016R\u0014\u00100\u001a\u00020-8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0014\u00103\u001a\u00020\u001b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010>\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=\u00a8\u0006A"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalVM;", "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalUIState;", "Lcom/tencent/mvi/api/runtime/b;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/tencent/input/base/mvicompat/ex/a;", "Lcom/tencent/mobileqq/guild/feed/util/framework/emitter/b;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent$b;", "envelope", "", "l", "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$ShowInputMethod;", "event", "r", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$ChangeDisplayMode;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativepublish/root/msgintent/FeedEditorRootMsgIntent$TriggerCloseEditorAnyway;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$OverwriteCloseIntent;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/msgintent/SimplifiedFeedEditorGlobalMsgIntent$HideAllPanelAndKeyboard;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/feed/nativepublish/edittext/GuildFeedEditTextMsgIntent$OnKeyPreIme;", "p", "u", "", "", "J2", "context", "onCreate", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "onStateChanged", "", "onBackEvent", "intent", "o", "f0", "Lcom/tencent/mvi/base/route/MsgIntent;", "Lcom/tencent/mvi/base/route/k;", "I", "E", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;", "d", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;", "globalScope", "e", "Ljava/lang/String;", "logTag", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "f", "Lcom/tencent/input/base/mvicompat/ex/VMMessengerProtocolSupport;", "tempMessageRegistry", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", h.F, "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/movement/SimplifiedFeedEditorGlobalController;", "globalController", "i", "Z", "hasResumedEver", "<init>", "(Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/f;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorGlobalVM extends BaseVM<FeedEditorGlobalIntent, FeedEditorGlobalUIState, com.tencent.mvi.api.runtime.b> implements LifecycleEventObserver, com.tencent.input.base.mvicompat.ex.a, com.tencent.mobileqq.guild.feed.util.framework.emitter.b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final f globalScope;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final VMMessengerProtocolSupport tempMessageRegistry;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SimplifiedFeedEditorGlobalController globalController;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean hasResumedEver;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes13.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f221976a;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f221976a = iArr;
        }
    }

    public FeedEditorGlobalVM(@NotNull f globalScope) {
        Intrinsics.checkNotNullParameter(globalScope, "globalScope");
        this.globalScope = globalScope;
        this.logTag = "FeedEditor.GlobalVM";
        this.tempMessageRegistry = new VMMessengerProtocolSupport(this);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.tencent.mvi.api.runtime.b] */
    private final void l(FeedEditorGlobalIntent.b envelope) {
        MsgIntent msgIntent = envelope.getMsgIntent();
        if (msgIntent != null) {
            envelope.c();
            getMContext().e().h(msgIntent);
        }
    }

    private final void m(SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode event) {
        if (event.getCom.tencent.hippy.qq.api.OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN java.lang.String()) {
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this.globalController;
            if (simplifiedFeedEditorGlobalController != null) {
                simplifiedFeedEditorGlobalController.s();
                return;
            }
            return;
        }
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = this.globalController;
        if (simplifiedFeedEditorGlobalController2 != null) {
            simplifiedFeedEditorGlobalController2.o();
        }
    }

    private final void n(SimplifiedFeedEditorGlobalMsgIntent.HideAllPanelAndKeyboard event) {
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this.globalController;
        if (simplifiedFeedEditorGlobalController != null) {
            SimplifiedFeedEditorGlobalController.y(simplifiedFeedEditorGlobalController, event.getSource(), "", 0, 4, null);
        }
    }

    private final void p(GuildFeedEditTextMsgIntent.OnKeyPreIme event) {
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController;
        com.tencent.mobileqq.guild.feed.nativedetail.bottom.input.framework.animation.e v3;
        if (event.getKeyEvent().getKeyCode() == 4 && (simplifiedFeedEditorGlobalController = this.globalController) != null && (v3 = simplifiedFeedEditorGlobalController.v()) != null && g.b(v3) == 8 && g.c(v3)) {
            boolean z16 = true;
            event.c(true);
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = this.globalController;
            if (simplifiedFeedEditorGlobalController2 == null || !simplifiedFeedEditorGlobalController2.getIsHalfScreen()) {
                z16 = false;
            }
            if (z16) {
                s(new FeedEditorRootMsgIntent.TriggerCloseEditorAnyway(0));
                return;
            }
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController3 = this.globalController;
            if (simplifiedFeedEditorGlobalController3 != null) {
                SimplifiedFeedEditorGlobalController.y(simplifiedFeedEditorGlobalController3, "on back event pre ime", "", 0, 4, null);
            }
        }
    }

    private final void q(SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent event) {
        QLog.d(FrameworkVM.TAG, 1, "[handleOverwriteCloseIntent]: source=" + event.getSource() + ", closeIntent=" + event.getCloseIntent());
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this.globalController;
        if (simplifiedFeedEditorGlobalController != null) {
            simplifiedFeedEditorGlobalController.H(event.getCloseIntent(), event.getAutoStash());
        }
    }

    private final void r(FeedEditorRootMsgIntent.ShowInputMethod event) {
        if (event.getIsForceCheckRequired()) {
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this.globalController;
            if (simplifiedFeedEditorGlobalController != null) {
                simplifiedFeedEditorGlobalController.T();
                return;
            }
            return;
        }
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = this.globalController;
        if (simplifiedFeedEditorGlobalController2 != null) {
            a.C0049a.a(simplifiedFeedEditorGlobalController2, 0L, 1, null);
        }
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [com.tencent.mvi.api.runtime.b] */
    /* JADX WARN: Type inference failed for: r4v4, types: [com.tencent.mvi.api.runtime.b] */
    private final void s(FeedEditorRootMsgIntent.TriggerCloseEditorAnyway event) {
        j e16;
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this.globalController;
        if (simplifiedFeedEditorGlobalController == null) {
            return;
        }
        if (simplifiedFeedEditorGlobalController.getIsHalfScreen()) {
            event.getSource();
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = this.globalController;
            if (simplifiedFeedEditorGlobalController2 != null) {
                simplifiedFeedEditorGlobalController2.x(String.valueOf(event.getSource()), "trigger_close_editor_actively", 0);
            }
        } else {
            InputMethodUtil.hide(getMContext().c().requireActivity());
            simplifiedFeedEditorGlobalController.I();
        }
        ?? safetyContext = getSafetyContext();
        if (safetyContext != 0 && (e16 = safetyContext.e()) != null) {
            e16.h(FeedEditorDraftUseCaseMsgIntent.TriggerSaveDraftMsgIntent.f222398d);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(FeedEditorGlobalVM this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this$0.globalController;
        if (simplifiedFeedEditorGlobalController != null) {
            a.C0049a.a(simplifiedFeedEditorGlobalController, 0L, 1, null);
        }
    }

    private final void u() {
        SimplifiedFeedEditorGlobalController globalController = this.globalScope.getGlobalController();
        this.globalController = globalController;
        if (globalController == null) {
            QLog.w(this.logTag, 1, "[peekGlobalController]: controller not found");
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SimplifiedFeedEditorGlobalMsgIntent.HideAllPanelAndKeyboard) {
            n((SimplifiedFeedEditorGlobalMsgIntent.HideAllPanelAndKeyboard) event);
            return;
        }
        if (event instanceof SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent) {
            q((SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent) event);
            return;
        }
        if (event instanceof FeedEditorRootMsgIntent.TriggerCloseEditorAnyway) {
            s((FeedEditorRootMsgIntent.TriggerCloseEditorAnyway) event);
            return;
        }
        if (event instanceof SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode) {
            m((SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode) event);
            return;
        }
        if (event instanceof SimplifiedFeedEditorGlobalMsgIntent.RestoreCloseIntent) {
            SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this.globalController;
            if (simplifiedFeedEditorGlobalController != null) {
                simplifiedFeedEditorGlobalController.K();
                return;
            }
            return;
        }
        if (event instanceof GuildFeedEditTextMsgIntent.OnKeyPreIme) {
            p((GuildFeedEditTextMsgIntent.OnKeyPreIme) event);
        } else if (event instanceof FeedEditorRootMsgIntent.ShowInputMethod) {
            r((FeedEditorRootMsgIntent.ShowInputMethod) event);
        }
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof FeedEditorAtUseCaseMsgIntent.GetAnchorView) {
            return new c.a(this.globalScope.getBottomAnchorView());
        }
        return a.C5857a.d(this, event);
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> J2() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(SimplifiedFeedEditorGlobalMsgIntent.OverwriteCloseIntent.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        String b17 = com.tencent.mvi.base.route.c.b(SimplifiedFeedEditorGlobalMsgIntent.HideAllPanelAndKeyboard.class);
        Intrinsics.checkNotNullExpressionValue(b17, "get(java)");
        String b18 = com.tencent.mvi.base.route.c.b(FeedEditorRootMsgIntent.TriggerCloseEditorAnyway.class);
        Intrinsics.checkNotNullExpressionValue(b18, "get(java)");
        String b19 = com.tencent.mvi.base.route.c.b(SimplifiedFeedEditorGlobalMsgIntent.ChangeDisplayMode.class);
        Intrinsics.checkNotNullExpressionValue(b19, "get(java)");
        String b26 = com.tencent.mvi.base.route.c.b(SimplifiedFeedEditorGlobalMsgIntent.RestoreCloseIntent.class);
        Intrinsics.checkNotNullExpressionValue(b26, "get(java)");
        String b27 = com.tencent.mvi.base.route.c.b(GuildFeedEditTextMsgIntent.OnKeyPreIme.class);
        Intrinsics.checkNotNullExpressionValue(b27, "get(java)");
        String b28 = com.tencent.mvi.base.route.c.b(FeedEditorRootMsgIntent.ShowInputMethod.class);
        Intrinsics.checkNotNullExpressionValue(b28, "get(java)");
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{b16, b17, b18, b19, b26, b27, b28});
        return listOf;
    }

    @Override // com.tencent.input.base.mvicompat.ex.a
    @NotNull
    public List<String> f0() {
        List<String> listOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedEditorAtUseCaseMsgIntent.GetAnchorView.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(b16);
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.tencent.mvi.api.runtime.b] */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull FeedEditorGlobalIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof MsgIntent) {
            getMContext().e().h((MsgIntent) intent);
        } else if (intent instanceof FeedEditorGlobalIntent.b) {
            l((FeedEditorGlobalIntent.b) intent);
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mvi.api.runtime.b] */
    @Override // com.tencent.mobileqq.guild.feed.util.framework.emitter.b
    public boolean onBackEvent() {
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController = this.globalController;
        if (simplifiedFeedEditorGlobalController == null) {
            return false;
        }
        if (simplifiedFeedEditorGlobalController.v().getState() == 0) {
            getMContext().e().h(new FeedEditorRootMsgIntent.TriggerCloseEditorAnyway(2));
            return true;
        }
        SimplifiedFeedEditorGlobalController.y(simplifiedFeedEditorGlobalController, FrameworkVM.TAG, "close_intent_once_collapsed", 0, 4, null);
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.tencent.mvi.api.runtime.b] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.tencent.mvi.api.runtime.b] */
    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.tempMessageRegistry;
        j e16 = getMContext().e();
        Intrinsics.checkNotNullExpressionValue(e16, "mContext.messenger");
        vMMessengerProtocolSupport.e(e16);
        getMContext().d().getLifecycle().removeObserver(this);
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        String str;
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        int i3 = a.f221976a[event.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController2 = this.globalController;
                String str2 = null;
                if (simplifiedFeedEditorGlobalController2 != null) {
                    str = simplifiedFeedEditorGlobalController2.getCloseIntent();
                } else {
                    str = null;
                }
                SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController3 = this.globalController;
                if (simplifiedFeedEditorGlobalController3 != null) {
                    str2 = simplifiedFeedEditorGlobalController3.getDefaultCloseIntentOnCollapsed();
                }
                if (Intrinsics.areEqual(str, str2) && (simplifiedFeedEditorGlobalController = this.globalController) != null) {
                    simplifiedFeedEditorGlobalController.H("", true);
                    return;
                }
                return;
            }
            return;
        }
        SimplifiedFeedEditorGlobalController simplifiedFeedEditorGlobalController4 = this.globalController;
        if (simplifiedFeedEditorGlobalController4 != null) {
            simplifiedFeedEditorGlobalController4.K();
        }
        if (this.hasResumedEver) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.feature.e
                @Override // java.lang.Runnable
                public final void run() {
                    FeedEditorGlobalVM.t(FeedEditorGlobalVM.this);
                }
            }, 200L);
        }
        this.hasResumedEver = true;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.mvi.api.runtime.b context) {
        FeedEditorConfiguration configuration;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate((FeedEditorGlobalVM) context);
        VMMessengerProtocolSupport vMMessengerProtocolSupport = this.tempMessageRegistry;
        j e16 = context.e();
        Intrinsics.checkNotNullExpressionValue(e16, "context.messenger");
        vMMessengerProtocolSupport.d(e16);
        u();
        context.d().getLifecycle().addObserver(this);
        context.b().a(com.tencent.mobileqq.guild.feed.util.framework.emitter.b.class).a(this);
        if (context instanceof com.tencent.base.api.runtime.a) {
            Object h16 = ((com.tencent.base.api.runtime.a) context).h();
            if (!(h16 instanceof zl1.a)) {
                h16 = null;
            }
            zl1.a aVar = (zl1.a) h16;
            boolean z16 = false;
            if (aVar != null && (configuration = aVar.getConfiguration()) != null && configuration.getIsSupportTitleBar()) {
                z16 = true;
            }
            if (z16) {
                updateUI(new FeedEditorGlobalUIState.WhiteSheetGuideLineAlignState(true));
            }
        }
    }
}
