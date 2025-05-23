package com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder;

import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopEffect;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopIntent;
import com.tencent.mobileqq.mini.entry.expDesktop.mvi.MiniAppExpDesktopViewModel;
import com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost;
import com.tencent.mobileqq.mini.entry.expDesktop.utils.MiniExpValidExpoReportHelper;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final class PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<MiniAppExpDesktopEffect> {
    final /* synthetic */ PersonalMiniAppViewHolder this$0;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1", f = "PersonalMiniAppViewHolder.kt", i = {0, 0, 1, 1}, l = {146, 159}, m = "emit", n = {"this", QQWinkConstants.TAB_EFFECT, "this", QQWinkConstants.TAB_EFFECT}, s = {"L$0", "L$1", "L$0", "L$1"})
    /* renamed from: com.tencent.mobileqq.mini.entry.expDesktop.part.adapter.viewHolder.PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
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
            return PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1(PersonalMiniAppViewHolder personalMiniAppViewHolder) {
        this.this$0 = personalMiniAppViewHolder;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:1|(2:3|(4:5|6|7|(1:(1:(5:11|12|13|14|15)(2:17|18))(5:19|20|21|14|15))(8:22|(2:24|(3:26|14|15))|27|(1:29)|30|(2:32|(2:34|(2:36|(1:38)(2:39|21))))(2:40|(2:42|(2:48|(2:50|(1:52)(2:53|13))))(2:54|(2:56|(4:58|(1:60)(1:64)|61|(1:63))(2:65|(1:67)))))|14|15)))|70|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x004e, code lost:
    
        r11 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01f7, code lost:
    
        com.tencent.qphone.base.util.QLog.e("PersonalMiniAppViewHolder", 1, "handle mMiniAppExpDesktopViewModel?.effect, effect=" + r10 + ", exception!", r11);
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0027  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(MiniAppExpDesktopEffect miniAppExpDesktopEffect, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        MiniAppExpDesktopEffect miniAppExpDesktopEffect2;
        IPartHost iPartHost;
        String str;
        RecyclerView recyclerView;
        Map<String, String> mutableMapOf;
        int findIndexFromMineRv;
        MiniAppExpDesktopViewModel mMiniAppExpDesktopViewModel;
        PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1 personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1;
        int findIndexFromMineRv2;
        MiniAppExpDesktopViewModel mMiniAppExpDesktopViewModel2;
        PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1 personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$12;
        IPartHost iPartHost2;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i16 = anonymousClass1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        miniAppExpDesktopEffect2 = (MiniAppExpDesktopEffect) anonymousClass1.L$1;
                        personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$12 = (PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$12.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_ADD_APPLET);
                        return Unit.INSTANCE;
                    }
                    if (i3 == 2) {
                        miniAppExpDesktopEffect2 = (MiniAppExpDesktopEffect) anonymousClass1.L$1;
                        personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1 = (PersonalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_DELETE_APPLET);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                miniAppExpDesktopEffect2 = miniAppExpDesktopEffect;
                iPartHost = this.this$0.mPortHost;
                if (iPartHost instanceof MiniAppExpDesktopPartHost) {
                    iPartHost2 = this.this$0.mPortHost;
                    Intrinsics.checkNotNull(iPartHost2, "null cannot be cast to non-null type com.tencent.mobileqq.mini.entry.expDesktop.part.MiniAppExpDesktopPartHost");
                    if (((MiniAppExpDesktopPartHost) iPartHost2).isSubPageVisible()) {
                        QLog.i("PersonalMiniAppViewHolder", 1, "desktop sub page is open!");
                        return Unit.INSTANCE;
                    }
                }
                if (QLog.isDevelopLevel()) {
                    QLog.i("PersonalMiniAppViewHolder", 1, "effect=" + miniAppExpDesktopEffect2);
                }
                if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) {
                    if (this.this$0.mModuleType == 1) {
                        findIndexFromMineRv2 = this.this$0.findIndexFromMineRv(((MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) miniAppExpDesktopEffect2).getFromMiniAppInfo(), this.this$0.mPersonalGroupAppInfo.getGroupAppInfo());
                        if (findIndexFromMineRv2 != -1) {
                            mMiniAppExpDesktopViewModel2 = this.this$0.getMMiniAppExpDesktopViewModel();
                            Intrinsics.checkNotNull(mMiniAppExpDesktopViewModel2);
                            MiniAppExpDesktopIntent.InsertMyMiniApp insertMyMiniApp = new MiniAppExpDesktopIntent.InsertMyMiniApp(((MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) miniAppExpDesktopEffect2).getFromMiniAppInfo(), 0);
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = miniAppExpDesktopEffect2;
                            anonymousClass1.label = 1;
                            if (mMiniAppExpDesktopViewModel2.sendUserIntent(insertMyMiniApp, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$12 = this;
                            personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$12.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropAdd) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_ADD_APPLET);
                        }
                    }
                } else if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) {
                    if (((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getReceiveViewId() == R.id.rcw && ((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getStartDragViewId() == R.id.rh7 && this.this$0.mModuleType == ((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getFromMiniAppInfo().mModuleType) {
                        findIndexFromMineRv = this.this$0.findIndexFromMineRv(((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getFromMiniAppInfo(), this.this$0.mPersonalGroupAppInfo.getGroupAppInfo());
                        if (findIndexFromMineRv != -1) {
                            mMiniAppExpDesktopViewModel = this.this$0.getMMiniAppExpDesktopViewModel();
                            Intrinsics.checkNotNull(mMiniAppExpDesktopViewModel);
                            MiniAppExpDesktopIntent.DeleteDesktopMiniApp deleteDesktopMiniApp = new MiniAppExpDesktopIntent.DeleteDesktopMiniApp(((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getFromMiniAppInfo(), this.this$0.mModuleType);
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = miniAppExpDesktopEffect2;
                            anonymousClass1.label = 2;
                            if (mMiniAppExpDesktopViewModel.sendUserIntent(deleteDesktopMiniApp, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1 = this;
                            personalMiniAppViewHolder$4$1$invokeSuspend$$inlined$collect$1.this$0.miniAppOperateReport(((MiniAppExpDesktopEffect.OnBottomPartDragDropDelete) miniAppExpDesktopEffect2).getFromMiniAppInfo(), MiniAppDesktopDtReportHelper.MINI_APP_EM_DELETE_APPLET);
                        }
                    }
                } else if (miniAppExpDesktopEffect2 instanceof MiniAppExpDesktopEffect.DesktopOpenChanged) {
                    if (((MiniAppExpDesktopEffect.DesktopOpenChanged) miniAppExpDesktopEffect2).isDesktopOpen()) {
                        if (this.this$0.mModuleType == 1) {
                            str = MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_RECENTLY_USE_MODULE;
                        } else {
                            str = MiniAppDesktopDtReportHelper.MINI_APP_EM_APPLET_PERSONAL_MODULE;
                        }
                        MiniExpValidExpoReportHelper mExpoReportHelper = this.this$0.getMExpoReportHelper();
                        if (mExpoReportHelper != null) {
                            recyclerView = this.this$0.mPersonalModuleInnerRv;
                            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("via", this.this$0.mPersonalGroupAppInfo.getVia().get(0)), TuplesKt.to(MiniExpValidExpoReportHelper.ReportKeyConst.REPORT_KEY_NOT_POSITION_HOST_SCENE, this.this$0.mPersonalGroupAppInfo.getHostScene().get(0)), TuplesKt.to("module", str), TuplesKt.to("page_id", MiniAppDesktopDtReportHelper.MINI_APP_PG_APPLET_HOME_DROP_DOWN));
                            mExpoReportHelper.reportMiniAppExpoEvent(recyclerView, mutableMapOf);
                        }
                    } else {
                        MiniExpValidExpoReportHelper mExpoReportHelper2 = this.this$0.getMExpoReportHelper();
                        if (mExpoReportHelper2 != null) {
                            mExpoReportHelper2.stopValidExpoReport(true);
                        }
                    }
                }
                return Unit.INSTANCE;
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
    }
}
