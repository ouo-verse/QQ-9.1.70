package com.tencent.mobileqq.wink.magicstudio;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.CombineFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioButtonInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 implements FlowCollector<CombineFlowInfo> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MagicStudioCreationViewModel f323621d;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1", f = "MagicStudioCreationViewModel.kt", i = {0, 0, 1, 1, 2, 2}, l = {145, 150, 152, 155}, m = "emit", n = {"this", "jump", "this", "jump", "this", "jump"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1"})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1(MagicStudioCreationViewModel magicStudioCreationViewModel) {
        this.f323621d = magicStudioCreationViewModel;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0189 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0158 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0140 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(CombineFlowInfo combineFlowInfo, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        JumpInfo jumpInfo;
        MagicStudioDataManager I2;
        ArrayList arrayListOf;
        MagicStudioDataManager I22;
        MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1;
        MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12;
        MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$13;
        JumpInfo jumpInfo2;
        MutableSharedFlow mutableSharedFlow;
        MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i16 = anonymousClass1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i16 - Integer.MIN_VALUE;
                Object obj = anonymousClass1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = anonymousClass1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 != 3) {
                                if (i3 == 4) {
                                    ResultKt.throwOnFailure(obj);
                                    return Unit.INSTANCE;
                                }
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            jumpInfo = (JumpInfo) anonymousClass1.L$2;
                            jumpInfo2 = (JumpInfo) anonymousClass1.L$1;
                            magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 = (MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                            ResultKt.throwOnFailure(obj);
                            jumpInfo.h((MagicStudioButtonInfo) obj);
                            jumpInfo = jumpInfo2;
                            w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic GotoMultiSelect");
                            mutableSharedFlow = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1.f323621d._event;
                            gotoMultiSelect = new MagicStudioCreationViewModel.b.GotoMultiSelect(jumpInfo, magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1.f323621d.getIsRegenerate());
                            anonymousClass1.L$0 = null;
                            anonymousClass1.L$1 = null;
                            anonymousClass1.L$2 = null;
                            anonymousClass1.label = 4;
                            if (mutableSharedFlow.emit(gotoMultiSelect, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.INSTANCE;
                        }
                        jumpInfo = (JumpInfo) anonymousClass1.L$1;
                        magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$13 = (MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic request ButtonInfo");
                        MagicStudioDataSource magicStudioDataSource = MagicStudioDataSource.f323652a;
                        anonymousClass1.L$0 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$13;
                        anonymousClass1.L$1 = jumpInfo;
                        anonymousClass1.L$2 = jumpInfo;
                        anonymousClass1.label = 3;
                        obj = magicStudioDataSource.J(1, anonymousClass1);
                        if (obj != coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$13;
                        jumpInfo2 = jumpInfo;
                        jumpInfo.h((MagicStudioButtonInfo) obj);
                        jumpInfo = jumpInfo2;
                        w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic GotoMultiSelect");
                        mutableSharedFlow = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1.f323621d._event;
                        gotoMultiSelect = new MagicStudioCreationViewModel.b.GotoMultiSelect(jumpInfo, magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1.f323621d.getIsRegenerate());
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.label = 4;
                        if (mutableSharedFlow.emit(gotoMultiSelect, anonymousClass1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                    jumpInfo = (JumpInfo) anonymousClass1.L$1;
                    magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12 = (MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception unused) {
                        w53.b.c("MagicStudioCreationViewModel", "requestPic2Pic delay 200ms ");
                        w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic delay 200ms ");
                        anonymousClass1.L$0 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12;
                        anonymousClass1.L$1 = jumpInfo;
                        anonymousClass1.label = 2;
                        if (DelayKt.delay(200L, anonymousClass1) != coroutine_suspended) {
                        }
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CombineFlowInfo combineFlowInfo2 = combineFlowInfo;
                    w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic : GotoMultiSelect = " + combineFlowInfo2);
                    ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_PARALLEL_MAX_TIME);
                    ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MAGIC_GALLERY_FIRST_FRAME);
                    MetaMaterial material = combineFlowInfo2.getMaterial();
                    I2 = this.f323621d.I2();
                    MagicStudioUploadImgInfo b16 = I2.b();
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(combineFlowInfo2.getGenerateInfo());
                    I22 = this.f323621d.I2();
                    boolean l3 = I22.l();
                    int count = combineFlowInfo2.getCount();
                    com.tencent.mobileqq.wink.magicstudio.model.f curStyle = this.f323621d.getCurStyle();
                    Intrinsics.checkNotNull(curStyle);
                    jumpInfo = new JumpInfo("", material, "", b16, arrayListOf, l3, count, curStyle.getIsCollectionStyle(), null, 256, null);
                    MagicStudioDataSource magicStudioDataSource2 = MagicStudioDataSource.f323652a;
                    magicStudioDataSource2.k0(jumpInfo);
                    JumpInfo Q = magicStudioDataSource2.Q();
                    Intrinsics.checkNotNull(Q);
                    Q.getImgInfo().w(magicStudioDataSource2.Y(combineFlowInfo2.getGenerateInfo().getAigcImgPath()));
                    if (this.f323621d.getIsRegenerate()) {
                        w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic doAction AigcFinish ");
                        try {
                            anonymousClass1.L$0 = this;
                            anonymousClass1.L$1 = jumpInfo;
                            anonymousClass1.label = 1;
                            if (magicStudioDataSource2.w(1, anonymousClass1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12 = this;
                        } catch (Exception unused2) {
                            magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12 = this;
                            w53.b.c("MagicStudioCreationViewModel", "requestPic2Pic delay 200ms ");
                            w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic delay 200ms ");
                            anonymousClass1.L$0 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12;
                            anonymousClass1.L$1 = jumpInfo;
                            anonymousClass1.label = 2;
                            if (DelayKt.delay(200L, anonymousClass1) != coroutine_suspended) {
                            }
                        }
                    } else {
                        magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 = this;
                        w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic GotoMultiSelect");
                        mutableSharedFlow = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1.f323621d._event;
                        gotoMultiSelect = new MagicStudioCreationViewModel.b.GotoMultiSelect(jumpInfo, magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1.f323621d.getIsRegenerate());
                        anonymousClass1.L$0 = null;
                        anonymousClass1.L$1 = null;
                        anonymousClass1.L$2 = null;
                        anonymousClass1.label = 4;
                        if (mutableSharedFlow.emit(gotoMultiSelect, anonymousClass1) == coroutine_suspended) {
                        }
                        return Unit.INSTANCE;
                    }
                }
                w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic delay 200ms ");
                anonymousClass1.L$0 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12;
                anonymousClass1.L$1 = jumpInfo;
                anonymousClass1.label = 2;
                if (DelayKt.delay(200L, anonymousClass1) != coroutine_suspended) {
                    return coroutine_suspended;
                }
                magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$13 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12;
                w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic request ButtonInfo");
                MagicStudioDataSource magicStudioDataSource3 = MagicStudioDataSource.f323652a;
                anonymousClass1.L$0 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$13;
                anonymousClass1.L$1 = jumpInfo;
                anonymousClass1.L$2 = jumpInfo;
                anonymousClass1.label = 3;
                obj = magicStudioDataSource3.J(1, anonymousClass1);
                if (obj != coroutine_suspended) {
                }
            }
        }
        anonymousClass1 = new AnonymousClass1(continuation);
        Object obj2 = anonymousClass1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = anonymousClass1.label;
        if (i3 == 0) {
        }
        w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic delay 200ms ");
        anonymousClass1.L$0 = magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$12;
        anonymousClass1.L$1 = jumpInfo;
        anonymousClass1.label = 2;
        if (DelayKt.delay(200L, anonymousClass1) != coroutine_suspended) {
        }
    }
}
