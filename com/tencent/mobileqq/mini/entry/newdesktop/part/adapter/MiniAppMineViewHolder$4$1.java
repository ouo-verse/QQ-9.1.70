package com.tencent.mobileqq.mini.entry.newdesktop.part.adapter;

import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopIntent;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDeskTopViewModel;
import com.tencent.mobileqq.mini.entry.newdesktop.mvi.MiniAppDesktopEffect;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder$4$1", f = "MiniAppMineAdapter.kt", i = {}, l = {879}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class MiniAppMineViewHolder$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MiniAppMineViewHolder this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniAppMineViewHolder$4$1(MiniAppMineViewHolder miniAppMineViewHolder, Continuation<? super MiniAppMineViewHolder$4$1> continuation) {
        super(2, continuation);
        this.this$0 = miniAppMineViewHolder;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniAppMineViewHolder$4$1(this.this$0, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        SharedFlow<MiniAppDesktopEffect> effect;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            MiniAppDeskTopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
            if (mMiniAppDesktopViewModel != null && (effect = mMiniAppDesktopViewModel.getEffect()) != null) {
                final MiniAppMineViewHolder miniAppMineViewHolder = this.this$0;
                FlowCollector<MiniAppDesktopEffect> flowCollector = new FlowCollector<MiniAppDesktopEffect>() { // from class: com.tencent.mobileqq.mini.entry.newdesktop.part.adapter.MiniAppMineViewHolder$4$1$invokeSuspend$$inlined$collect$1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public Object emit(MiniAppDesktopEffect miniAppDesktopEffect, Continuation<? super Unit> continuation) {
                        RecyclerView recyclerView;
                        int findIndexFromMineRv;
                        Object coroutine_suspended2;
                        RelativeLayout relativeLayout;
                        TextView textView;
                        MiniAppDesktopEffect miniAppDesktopEffect2 = miniAppDesktopEffect;
                        if (QLog.isDevelopLevel()) {
                            QLog.i("MiniAppDesktopPart.MiniAppMineViewHolder", 1, "effect=" + miniAppDesktopEffect2);
                        }
                        if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OnDragEntered) {
                            relativeLayout = MiniAppMineViewHolder.this.mMiniEmptyGuideRl;
                            if (relativeLayout != null) {
                                relativeLayout.setBackgroundResource(R.drawable.jy7);
                            }
                            textView = MiniAppMineViewHolder.this.mMiniEmptyGuideTv;
                            if (textView != null) {
                                textView.setText(HardCodeUtil.qqStr(R.string.f172190o71));
                            }
                        } else if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OnBottomPartDragDropDelete) {
                            MiniAppDesktopEffect.OnBottomPartDragDropDelete onBottomPartDragDropDelete = (MiniAppDesktopEffect.OnBottomPartDragDropDelete) miniAppDesktopEffect2;
                            if (onBottomPartDragDropDelete.getReceiveViewId() == R.id.rcw && onBottomPartDragDropDelete.getStartDragViewId() == R.id.rgh) {
                                findIndexFromMineRv = MiniAppMineViewHolder.this.findIndexFromMineRv(onBottomPartDragDropDelete.getFromMiniAppInfo(), MiniAppMineViewHolder.this.mMineRvDataList);
                                if (findIndexFromMineRv != -1) {
                                    MiniAppDeskTopViewModel mMiniAppDesktopViewModel2 = MiniAppMineViewHolder.this.getMMiniAppDesktopViewModel();
                                    Intrinsics.checkNotNull(mMiniAppDesktopViewModel2);
                                    Object sendUserIntent = mMiniAppDesktopViewModel2.sendUserIntent(new MiniAppDeskTopIntent.DeleteDesktopMiniApp(onBottomPartDragDropDelete.getFromMiniAppInfo(), 3), continuation);
                                    coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (sendUserIntent == coroutine_suspended2) {
                                        return sendUserIntent;
                                    }
                                }
                            }
                        } else if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OuterRvPartOnScrollStateChanged) {
                            if (((MiniAppDesktopEffect.OuterRvPartOnScrollStateChanged) miniAppDesktopEffect2).getNewState() == 0) {
                                recyclerView = MiniAppMineViewHolder.this.mMiniAppInnerMineRv;
                                if (recyclerView != null) {
                                    MiniAppMineViewHolder.this.doExpoReportAfterScroll();
                                }
                            }
                        } else if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OuterRvPartOnPause) {
                            MiniAppMineViewHolder.this.getMExpoReportHelper().stopValidExpoReport(true);
                        } else if (miniAppDesktopEffect2 instanceof MiniAppDesktopEffect.OuterRvPartOnResume) {
                            MiniAppMineViewHolder.this.doExpoReportAfterScroll();
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
        return ((MiniAppMineViewHolder$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
