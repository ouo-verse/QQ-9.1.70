package com.tencent.mobileqq.wink.magicstudio;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.CombineFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.JumpInfo;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 implements FlowCollector<CombineFlowInfo> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ MagicStudioCreationViewModel f323622d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f323623e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f323624f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ com.tencent.mobileqq.wink.magicstudio.model.f f323625h;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1", f = "MagicStudioCreationViewModel.kt", i = {0}, l = {138, 146}, m = "emit", n = {"this"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1$1, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
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
            return MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1.this.emit(null, this);
        }
    }

    public MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1(MagicStudioCreationViewModel magicStudioCreationViewModel, String str, String str2, com.tencent.mobileqq.wink.magicstudio.model.f fVar) {
        this.f323622d = magicStudioCreationViewModel;
        this.f323623e = str;
        this.f323624f = str2;
        this.f323625h = fVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002a  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object emit(CombineFlowInfo combineFlowInfo, @NotNull Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object coroutine_suspended;
        int i3;
        MagicStudioDataManager I2;
        ArrayList arrayListOf;
        MagicStudioDataManager I22;
        MutableSharedFlow mutableSharedFlow;
        MutableSharedFlow mutableSharedFlow2;
        MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1;
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
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                        } else {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    } else {
                        magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 = (MagicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1) anonymousClass1.L$0;
                        ResultKt.throwOnFailure(obj);
                        MagicStudioCreationViewModel.s2(magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1.f323622d, false, 1, null);
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    CombineFlowInfo combineFlowInfo2 = combineFlowInfo;
                    w53.b.f("MagicStudioCreationViewModel", "prepareEditorData : GotoEditor = " + combineFlowInfo2);
                    if (combineFlowInfo2.getGenerateInfo().e().isEmpty()) {
                        w53.b.f("MagicStudioCreationViewModel", "prepareEditorData : has error stop");
                        mutableSharedFlow2 = this.f323622d._event;
                        MagicStudioCreationViewModel.b.MakeFail makeFail = new MagicStudioCreationViewModel.b.MakeFail(new Exception());
                        anonymousClass1.L$0 = this;
                        anonymousClass1.label = 1;
                        if (mutableSharedFlow2.emit(makeFail, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1 = this;
                        MagicStudioCreationViewModel.s2(magicStudioCreationViewModel$requestText2Pic$1$invokeSuspend$$inlined$collect$1.f323622d, false, 1, null);
                    } else {
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestoneEnd(IPrefRecorder.MILESTONE_MAGIC_GALLERY_PARALLEL_MAX_TIME);
                        ((IPrefRecorder) QRoute.api(IPrefRecorder.class)).milestone(IPrefRecorder.MILESTONE_MAGIC_GALLERY_FIRST_FRAME);
                        String str = this.f323623e;
                        MetaMaterial material = combineFlowInfo2.getMaterial();
                        String str2 = this.f323624f;
                        I2 = this.f323622d.I2();
                        MagicStudioUploadImgInfo b16 = I2.b();
                        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(combineFlowInfo2.getGenerateInfo());
                        I22 = this.f323622d.I2();
                        JumpInfo jumpInfo = new JumpInfo(str, material, str2, b16, arrayListOf, I22.l(), combineFlowInfo2.getCount(), this.f323625h.getIsCollectionStyle(), null, 256, null);
                        MagicStudioDataSource.f323652a.k0(jumpInfo);
                        mutableSharedFlow = this.f323622d._event;
                        MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect = new MagicStudioCreationViewModel.b.GotoMultiSelect(jumpInfo, false, 2, null);
                        anonymousClass1.label = 2;
                        if (mutableSharedFlow.emit(gotoMultiSelect, anonymousClass1) == coroutine_suspended) {
                            return coroutine_suspended;
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
        return Unit.INSTANCE;
    }
}
