package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeRecommendMiniAppViewHolder$4$1", f = "LimitedTimeRecommendMiniAppViewHolder.kt", i = {}, l = {207}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class LimitedTimeRecommendMiniAppViewHolder$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ LimitedTimeRecommendMiniAppViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LimitedTimeRecommendMiniAppViewHolder$4$1(LimitedTimeRecommendMiniAppViewHolder limitedTimeRecommendMiniAppViewHolder, Continuation<? super LimitedTimeRecommendMiniAppViewHolder$4$1> continuation) {
        super(2, continuation);
        this.this$0 = limitedTimeRecommendMiniAppViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LimitedTimeRecommendMiniAppViewHolder$4$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MiniAppExpDesktopViewModel mMiniAppExpDesktopViewModel;
        SharedFlow<MiniAppExpDesktopEffect> effect;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            mMiniAppExpDesktopViewModel = this.this$0.getMMiniAppExpDesktopViewModel();
            if (mMiniAppExpDesktopViewModel != null && (effect = mMiniAppExpDesktopViewModel.getEffect()) != null) {
                final LimitedTimeRecommendMiniAppViewHolder limitedTimeRecommendMiniAppViewHolder = this.this$0;
                FlowCollector<MiniAppExpDesktopEffect> flowCollector = new FlowCollector<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.LimitedTimeRecommendMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(MiniAppExpDesktopEffect miniAppExpDesktopEffect, Continuation<? super Unit> continuation) {
                        RecyclerView recyclerView;
                        Map<String, String> mutableMapOf;
                        MiniAppExpDesktopEffect miniAppExpDesktopEffect2 = miniAppExpDesktopEffect;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("LimitedTimeRecommendMiniAppViewHolder", 1, "effect=" + miniAppExpDesktopEffect2);
                        }
                        try {
                            if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.DesktopOpenChanged) {
                                if (((MiniAppExpDesktopEffect.DesktopOpenChanged) miniAppExpDesktopEffect2).isDesktopOpen()) {
                                    MiniExpValidExpoReportHelper mExpoReportHelper = LimitedTimeRecommendMiniAppViewHolder.this.getMExpoReportHelper();
                                    if (mExpoReportHelper != null) {
                                        recyclerView = LimitedTimeRecommendMiniAppViewHolder.this.mLimitedTimeRecommendModuleInnerRv;
                                        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", LimitedTimeRecommendMiniAppViewHolder.this.mLimitedTimeRecommendGroupAppInfo.getVia().get(0)), TuplesKt.to("module", MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECOMMEND_MODULE), TuplesKt.to("page_id", MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN));
                                        mExpoReportHelper.reportMiniAppExpoEvent(recyclerView, mutableMapOf);
                                    }
                                } else {
                                    MiniExpValidExpoReportHelper mExpoReportHelper2 = LimitedTimeRecommendMiniAppViewHolder.this.getMExpoReportHelper();
                                    if (mExpoReportHelper2 != null) {
                                        mExpoReportHelper2.stopValidExpoReport(true);
                                    }
                                }
                            }
                        } catch (Throwable th5) {
                            QLog.e("LimitedTimeRecommendMiniAppViewHolder", 1, "handle mMiniAppExpDesktopViewModel?.effect, effect=" + miniAppExpDesktopEffect2 + ", exception!", th5);
                        }
                        return Unit.INSTANCE;
                    }
                };
                this.label = 1;
                if (effect.collect(flowCollector, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LimitedTimeRecommendMiniAppViewHolder$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
