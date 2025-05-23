package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.mini.entry.expDesktop.bean.ExpDesktopRankSubTabAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.report.MiniProgramReporter;
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
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder$4$1", f = "RankMiniAppViewHolder.kt", i = {}, l = {422}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class RankMiniAppViewHolder$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ RankMiniAppViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankMiniAppViewHolder$4$1(RankMiniAppViewHolder rankMiniAppViewHolder, Continuation<? super RankMiniAppViewHolder$4$1> continuation) {
        super(2, continuation);
        this.this$0 = rankMiniAppViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RankMiniAppViewHolder$4$1(this.this$0, continuation);
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
                final RankMiniAppViewHolder rankMiniAppViewHolder = this.this$0;
                FlowCollector<MiniAppExpDesktopEffect> flowCollector = new FlowCollector<MiniAppExpDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.RankMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(MiniAppExpDesktopEffect miniAppExpDesktopEffect, Continuation<? super Unit> continuation) {
                        RecyclerView recyclerView;
                        String notPositionHostSceneStr;
                        Map<String, String> mutableMapOf;
                        RecyclerView recyclerView2;
                        String notPositionHostSceneStr2;
                        Map<String, String> mutableMapOf2;
                        MiniAppExpDesktopEffect miniAppExpDesktopEffect2 = miniAppExpDesktopEffect;
                        if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.OuterRvPartOnScrollStateChanged) {
                            if (((MiniAppExpDesktopEffect.OuterRvPartOnScrollStateChanged) miniAppExpDesktopEffect2).getNewState() == 0) {
                                MiniExpValidExpoReportHelper mExpoReportHelper = RankMiniAppViewHolder.this.getMExpoReportHelper();
                                recyclerView2 = RankMiniAppViewHolder.this.mRankInnerRv;
                                notPositionHostSceneStr2 = RankMiniAppViewHolder.this.getNotPositionHostSceneStr();
                                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", RankMiniAppViewHolder.this.getRankModuleVia()), TuplesKt.to("module", MiniAppDesktopDtReportHelper.MINI_APP_EM_PRIMARY_TAB), TuplesKt.to("page_id", MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN), TuplesKt.to(MiniExpValidExpoReportHelper.ReportKeyConst.REPORT_KEY_NOT_POSITION_HOST_SCENE, notPositionHostSceneStr2), TuplesKt.to(MiniExpValidExpoReportHelper.ReportKeyConst.REPORT_KEY_TAB_TITLE, ((ExpDesktopRankSubTabAppInfo) RankMiniAppViewHolder.this.mRankModuleDataInfo.get(RankMiniAppViewHolder.this.mCurrentTabIndex)).getMTitle()));
                                mExpoReportHelper.reportMiniAppExpoEvent(recyclerView2, mutableMapOf2);
                                MiniProgramReporter.getInstance().flush();
                            }
                        } else if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.DesktopOpenChanged) {
                            if (((MiniAppExpDesktopEffect.DesktopOpenChanged) miniAppExpDesktopEffect2).isDesktopOpen()) {
                                MiniExpValidExpoReportHelper mExpoReportHelper2 = RankMiniAppViewHolder.this.getMExpoReportHelper();
                                recyclerView = RankMiniAppViewHolder.this.mRankInnerRv;
                                notPositionHostSceneStr = RankMiniAppViewHolder.this.getNotPositionHostSceneStr();
                                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", RankMiniAppViewHolder.this.getRankModuleVia()), TuplesKt.to("module", MiniAppDesktopDtReportHelper.MINI_APP_EM_PRIMARY_TAB), TuplesKt.to("page_id", MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN), TuplesKt.to("host_scene", notPositionHostSceneStr), TuplesKt.to(MiniExpValidExpoReportHelper.ReportKeyConst.REPORT_KEY_TAB_TITLE, ((ExpDesktopRankSubTabAppInfo) RankMiniAppViewHolder.this.mRankModuleDataInfo.get(RankMiniAppViewHolder.this.mCurrentTabIndex)).getMTitle()));
                                mExpoReportHelper2.reportMiniAppExpoEvent(recyclerView, mutableMapOf);
                            } else {
                                RankMiniAppViewHolder.this.getMExpoReportHelper().stopValidExpoReport(true);
                            }
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
        return ((RankMiniAppViewHolder$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
