package com.tencent.mobileqq.mini.entry.expDesktop.part;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopAppInfo;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopIntent;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1 implements FlowCollector<MiniAppExpDesktopEffect> {
    final /* synthetic */ MiniAppExpDesktopSubLayoutPart this$0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1", f = "MiniAppExpDesktopSubLayoutPart.kt", i = {0, 0, 1, 1}, l = {143, 161}, m = "emit", n = {"this", QQWinkConstants.TAB_EFFECT, "this", QQWinkConstants.TAB_EFFECT}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: classes33.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1(MiniAppExpDesktopSubLayoutPart miniAppExpDesktopSubLayoutPart) {
        this.this$0 = miniAppExpDesktopSubLayoutPart;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(MiniAppExpDesktopEffect miniAppExpDesktopEffect, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        MiniAppExpDesktopEffect miniAppExpDesktopEffect2;
        List list;
        int findIndexFromMineRv;
        int i16;
        MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1 miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1;
        List list2;
        int findIndexFromMineRv2;
        MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1 miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$12;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i17 = anonymousClass1.label;
            if ((i17 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i17 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    miniAppExpDesktopEffect2 = miniAppExpDesktopEffect;
                    QLog.i(this.this$0.getTAG(), 1, "mSubLayoutRv, effect:" + miniAppExpDesktopEffect2);
                    if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) {
                        if (this.this$0.isSubPageVisible()) {
                            MiniAppExpDesktopSubLayoutPart miniAppExpDesktopSubLayoutPart = this.this$0;
                            MiniAppExpDesktopEffect.OnBottomPartDragDropAdd onBottomPartDragDropAdd = (MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) miniAppExpDesktopEffect2;
                            DesktopAppInfo fromMiniAppInfo = onBottomPartDragDropAdd.getFromMiniAppInfo();
                            list2 = this.this$0.mSubPageDataList;
                            findIndexFromMineRv2 = miniAppExpDesktopSubLayoutPart.findIndexFromMineRv(fromMiniAppInfo, list2);
                            if (findIndexFromMineRv2 != -1) {
                                MiniAppExpDesktopViewModel mMiniAppDesktopViewModel = this.this$0.getMMiniAppDesktopViewModel();
                                MiniAppExpDesktopIntent.InsertMyMiniApp insertMyMiniApp = new MiniAppExpDesktopIntent.InsertMyMiniApp(onBottomPartDragDropAdd.getFromMiniAppInfo(), 0);
                                anonymousClass1.L$0 = this;
                                anonymousClass1.L$1 = miniAppExpDesktopEffect2;
                                anonymousClass1.label = 1;
                                if (mMiniAppDesktopViewModel.sendUserIntent(insertMyMiniApp, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$12 = this;
                                miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$12.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_ADD_APPLET);
                            }
                        }
                    } else if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) {
                        MiniAppExpDesktopEffect.OnBottomPartDragDropDelete onBottomPartDragDropDelete = (MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2;
                        if (onBottomPartDragDropDelete.getReceiveViewId() == R.id.rcw && onBottomPartDragDropDelete.getStartDragViewId() == R.id.rht && this.this$0.isSubPageVisible()) {
                            MiniAppExpDesktopSubLayoutPart miniAppExpDesktopSubLayoutPart2 = this.this$0;
                            DesktopAppInfo fromMiniAppInfo2 = onBottomPartDragDropDelete.getFromMiniAppInfo();
                            list = this.this$0.mSubPageDataList;
                            findIndexFromMineRv = miniAppExpDesktopSubLayoutPart2.findIndexFromMineRv(fromMiniAppInfo2, list);
                            if (findIndexFromMineRv != -1) {
                                MiniAppExpDesktopSubLayoutPart miniAppExpDesktopSubLayoutPart3 = this.this$0;
                                String str = onBottomPartDragDropDelete.getFromMiniAppInfo().mMiniAppInfo.appId;
                                Intrinsics.checkNotNullExpressionValue(str, "effect.fromMiniAppInfo.mMiniAppInfo.appId");
                                miniAppExpDesktopSubLayoutPart3.mCurrentDeleteAppId = str;
                                MiniAppExpDesktopViewModel mMiniAppDesktopViewModel2 = this.this$0.getMMiniAppDesktopViewModel();
                                DesktopAppInfo fromMiniAppInfo3 = onBottomPartDragDropDelete.getFromMiniAppInfo();
                                i16 = this.this$0.mModuleType;
                                MiniAppExpDesktopIntent.DeleteDesktopMiniApp deleteDesktopMiniApp = new MiniAppExpDesktopIntent.DeleteDesktopMiniApp(fromMiniAppInfo3, i16);
                                anonymousClass1.L$0 = this;
                                anonymousClass1.L$1 = miniAppExpDesktopEffect2;
                                anonymousClass1.label = 2;
                                if (mMiniAppDesktopViewModel2.sendUserIntent(deleteDesktopMiniApp, anonymousClass1) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1 = this;
                                miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_DELETE_APPLET);
                            }
                        }
                    } else if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.SetSubLayoutDesktopDataList) {
                        this.this$0.openSubPage((MiniAppExpDesktopEffect.SetSubLayoutDesktopDataList) miniAppExpDesktopEffect2);
                    }
                } else if (i3 == 1) {
                    miniAppExpDesktopEffect2 = (MiniAppExpDesktopEffect) anonymousClass1.L$1;
                    miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$12 = (MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$12.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_ADD_APPLET);
                } else if (i3 == 2) {
                    miniAppExpDesktopEffect2 = (MiniAppExpDesktopEffect) anonymousClass1.L$1;
                    miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1 = (MiniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                    ResultKt.throwOnFailure(obj);
                    miniAppExpDesktopSubLayoutPart$initSubPageView$5$invokeSuspend$$inlined$collect$1.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_DELETE_APPLET);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 != 0) {
        }
        return Unit.INSTANCE;
    }
}
