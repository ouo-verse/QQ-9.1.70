package com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.draft.FeedEditorDraftUseCase;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.feature.FeedEditorGlobalUIState;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent;
import com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.e;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.k;
import com.tencent.mvi.mvvm.BaseVM;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildFeedDraft;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import yl1.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\u0016\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0002\b\u00030\u0019\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0003J\b\u0010\t\u001a\u00020\u0005H\u0003J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\"\u0010\u0013\u001a\u00020\u00052\u0010\u0010\u0010\u001a\f\u0012\u0004\u0012\u00020\u000e0\rj\u0002`\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R$\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b\u0012\u0002\b\u00030\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001a\u0010!\u001a\u00020\u000b8\u0014X\u0094D\u00a2\u0006\f\n\u0004\b\u0004\u0010\u001f\u001a\u0004\b\u001c\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/FeedEditorDraftUseCaseVMDelegate;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/vmdelegate/a;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mvi/base/route/k;", "i", "", "j", "g", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "", "getSubscribeEventRNames", "Lcom/tencent/base/api/runtime/a;", "Lzl1/a;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/utils/FeedEditorContext;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "e", "Lcom/tencent/mvi/base/route/MsgIntent;", "event", "E", "I", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/mvi/mvvm/BaseVM;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalIntent;", "Lcom/tencent/mobileqq/guild/feed/nativepublish/feature/FeedEditorGlobalUIState;", h.F, "Lcom/tencent/mvi/mvvm/BaseVM;", "vm", "Ljava/lang/String;", "()Ljava/lang/String;", "logTag", "Lcom/tencent/mobileqq/guild/feed/nativepublish/draft/FeedEditorDraftUseCase;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/nativepublish/draft/FeedEditorDraftUseCase;", "usecase", "<init>", "(Lcom/tencent/mvi/mvvm/BaseVM;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedEditorDraftUseCaseVMDelegate extends a implements LifecycleObserver {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final BaseVM<FeedEditorGlobalIntent, FeedEditorGlobalUIState, ?> vm;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FeedEditorDraftUseCase usecase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FeedEditorDraftUseCaseVMDelegate(@NotNull BaseVM<FeedEditorGlobalIntent, FeedEditorGlobalUIState, ?> vm5) {
        super(null, 1, null);
        Intrinsics.checkNotNullParameter(vm5, "vm");
        this.vm = vm5;
        this.logTag = "FeedEditor.DraftUseCase";
    }

    private final void g() {
        Logger logger = Logger.f235387a;
        String logTag = getLogTag();
        if (QLog.isColorLevel()) {
            logger.d().d(logTag, 1, "[callUseCaseToSaveDraft], taskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(c()));
        }
        FeedEditorDraftUseCase feedEditorDraftUseCase = this.usecase;
        if (feedEditorDraftUseCase != null) {
            feedEditorDraftUseCase.j();
        }
        final zl1.a h16 = c().h();
        if (h16 != null && !h16.q().getIsTriggerPost() && h16.getConfiguration().getIsDisableDraft()) {
            n.h("ReportNotSaveDraft", 1000L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseVMDelegate$callUseCaseToSaveDraft$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    String str;
                    String h17 = zl1.a.this.h();
                    zl1.a h18 = this.c().h();
                    Intrinsics.checkNotNullExpressionValue(h18, "context.baseParam");
                    Long f16 = zl1.b.f(h18);
                    if (f16 == null || (str = f16.toString()) == null) {
                        str = "";
                    }
                    com.tencent.mobileqq.guild.feed.nativepublish.draft.a.c(h17, true, str, this.c().h().getFeedId());
                }
            });
        }
    }

    private final k i() {
        Result result;
        boolean z16;
        if (c().h().getConfiguration().getIsDisableDraft()) {
            return new com.tencent.input.base.utils.a();
        }
        FeedEditorDraftUseCase feedEditorDraftUseCase = this.usecase;
        Object obj = null;
        if (feedEditorDraftUseCase != null) {
            result = Result.m475boximpl(feedEditorDraftUseCase.d());
        } else {
            result = null;
        }
        if (result != null && Result.m483isSuccessimpl(result.getValue())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Object value = result.getValue();
            if (!Result.m482isFailureimpl(value)) {
                obj = value;
            }
            return new e.QueryLastDraftResult(true, (GProGuildFeedDraft) obj);
        }
        FeedEditorDraftUseCase feedEditorDraftUseCase2 = this.usecase;
        if (feedEditorDraftUseCase2 != null) {
            feedEditorDraftUseCase2.e(this.vm.vmScope());
        }
        return new e.QueryLastDraftResult(false, null);
    }

    private final void j() {
        QLog.d(getLogTag(), 1, "[handleOnTriggerPublish], taskId=" + com.tencent.mobileqq.guild.feed.nativepublish.utils.a.a(c()));
        FeedEditorDraftUseCase feedEditorDraftUseCase = this.usecase;
        if (feedEditorDraftUseCase != null) {
            feedEditorDraftUseCase.i();
            feedEditorDraftUseCase.c();
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    private final void onPause() {
        QLog.i(getLogTag(), 1, "[handlePauseEvent]. isPublishing: " + b.a(this).getIsTriggerPost());
        FeedEditorDraftUseCase feedEditorDraftUseCase = this.usecase;
        if (feedEditorDraftUseCase != null) {
            feedEditorDraftUseCase.i();
        }
        if (b.a(this).getIsTriggerPost()) {
            return;
        }
        g();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    private final void onResume() {
        QLog.i(getLogTag(), 1, "[handleOnResumeEvent]. isPublishing: " + b.a(this).getIsTriggerPost());
        FeedEditorDraftUseCase feedEditorDraftUseCase = this.usecase;
        if (feedEditorDraftUseCase != null) {
            feedEditorDraftUseCase.h(this.vm.vmScope());
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    public void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, FeedEditorContentMsgIntent.OnTriggerPublishEvent.f221796d)) {
            j();
        } else if (Intrinsics.areEqual(event, FeedEditorDraftUseCaseMsgIntent.TriggerSaveDraftMsgIntent.f222398d)) {
            g();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mobileqq.guild.feed.util.bf
    @NotNull
    public k I(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (Intrinsics.areEqual(event, FeedEditorDraftUseCaseMsgIntent.QueryLastDraftMsgIntent.f222392d)) {
            return i();
        }
        return new com.tencent.input.base.utils.a();
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    /* renamed from: e */
    public void b(@NotNull com.tencent.base.api.runtime.a<zl1.a> context, boolean reuse) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.b(context, reuse);
        if (!context.h().getConfiguration().getIsDisableDraft()) {
            this.usecase = new FeedEditorDraftUseCase(getLogTag(), context);
            context.d().getLifecycle().addObserver(this);
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    public Set<String> getSubscribeEventNames() {
        HashSet hashSet = new HashSet();
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.content.FeedEditorContentMsgIntent.OnTriggerPublishEvent");
        hashSet.add("com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.FeedEditorDraftUseCaseMsgIntent.TriggerSaveDraftMsgIntent");
        return hashSet;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.mvi.base.route.g
    @NotNull
    public Set<String> getSubscribeEventRNames() {
        Set<String> mutableSetOf;
        String b16 = com.tencent.mvi.base.route.c.b(FeedEditorDraftUseCaseMsgIntent.QueryLastDraftMsgIntent.class);
        Intrinsics.checkNotNullExpressionValue(b16, "get(java)");
        mutableSetOf = SetsKt__SetsKt.mutableSetOf(b16);
        return mutableSetOf;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    protected String getLogTag() {
        return this.logTag;
    }

    @Override // com.tencent.mobileqq.guild.feed.nativepublish.vmdelegate.a, com.tencent.input.base.mvicompat.f
    public void onDestroy() {
        super.onDestroy();
        c().d().getLifecycle().removeObserver(this);
    }
}
