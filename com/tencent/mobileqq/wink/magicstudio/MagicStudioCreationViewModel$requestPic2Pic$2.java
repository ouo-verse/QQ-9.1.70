package com.tencent.mobileqq.wink.magicstudio;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.CombineFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgInfo;
import com.tencent.qqlive.tvkplayer.qqliveasset.player.message.TVKQQLiveAssetPlayerMsg;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestPic2Pic$2", f = "MagicStudioCreationViewModel.kt", i = {0, 1, 2, 3, 4}, l = {516, TVKQQLiveAssetPlayerMsg.PLAYER_INFO_CGI_RESPONSE, 534, 547, PlayerResources.ViewId.PLAYER_DURATION, PlayerResources.ViewId.CURRUNT_TIME, 1147, com.tencent.luggage.wxa.c3.f.CTRL_INDEX}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "$this$launch", "firstAigcFlow", "firstAigcFlow"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$requestPic2Pic$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $imagePath;
    final /* synthetic */ boolean $isFromCamera;
    final /* synthetic */ MagicStudioPicStyle $magicStudioPicStyle;
    final /* synthetic */ MagicStudioUploadImgInfo $regenerateUploadImageInfo;
    final /* synthetic */ int $requestAigcCount;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/tencent/mobileqq/wink/magicstudio/model/a;", "", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestPic2Pic$2$2", f = "MagicStudioCreationViewModel.kt", i = {0}, l = {PlayerResources.ViewId.GET_MORE_TOGGLE_AREA, PlayerResources.ViewId.GET_MORE_JUMP_AREA}, m = "invokeSuspend", n = {"$this$catch"}, s = {"L$0"})
    /* renamed from: com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$requestPic2Pic$2$2, reason: invalid class name */
    /* loaded from: classes21.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements Function3<FlowCollector<? super CombineFlowInfo>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        /* synthetic */ Object L$1;
        int label;
        final /* synthetic */ MagicStudioCreationViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super AnonymousClass2> continuation) {
            super(3, continuation);
            this.this$0 = magicStudioCreationViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended;
            FlowCollector flowCollector;
            MutableSharedFlow mutableSharedFlow;
            Map emptyMap;
            coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i3 = this.label;
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 == 2) {
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                flowCollector = (FlowCollector) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                ResultKt.throwOnFailure(obj);
                flowCollector = (FlowCollector) this.L$0;
                Throwable th5 = (Throwable) this.L$1;
                w53.b.h("MagicStudioCreationViewModel", "requestPic2Pic catch make fail ", th5);
                mutableSharedFlow = this.this$0._event;
                MagicStudioCreationViewModel.b.MakeFail makeFail = new MagicStudioCreationViewModel.b.MakeFail(th5);
                this.L$0 = flowCollector;
                this.label = 1;
                if (mutableSharedFlow.emit(makeFail, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            MagicStudioDataSource.m0(MagicStudioDataSource.f323652a, 0L, null, 3, null);
            MetaMaterial metaMaterial = new MetaMaterial();
            emptyMap = MapsKt__MapsKt.emptyMap();
            CombineFlowInfo combineFlowInfo = new CombineFlowInfo(metaMaterial, new GenerateInfo(emptyMap, "", false, null, null, null, null, 0, 0, 508, null), 1);
            this.L$0 = null;
            this.label = 2;
            if (flowCollector.emit(combineFlowInfo, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function3
        @Nullable
        public final Object invoke(@NotNull FlowCollector<? super CombineFlowInfo> flowCollector, @NotNull Throwable th5, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0, continuation);
            anonymousClass2.L$0 = flowCollector;
            anonymousClass2.L$1 = th5;
            return anonymousClass2.invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$requestPic2Pic$2(MagicStudioCreationViewModel magicStudioCreationViewModel, MagicStudioUploadImgInfo magicStudioUploadImgInfo, String str, MagicStudioPicStyle magicStudioPicStyle, boolean z16, int i3, Continuation<? super MagicStudioCreationViewModel$requestPic2Pic$2> continuation) {
        super(2, continuation);
        this.this$0 = magicStudioCreationViewModel;
        this.$regenerateUploadImageInfo = magicStudioUploadImgInfo;
        this.$imagePath = str;
        this.$magicStudioPicStyle = magicStudioPicStyle;
        this.$isFromCamera = z16;
        this.$requestAigcCount = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MagicStudioCreationViewModel$requestPic2Pic$2 magicStudioCreationViewModel$requestPic2Pic$2 = new MagicStudioCreationViewModel$requestPic2Pic$2(this.this$0, this.$regenerateUploadImageInfo, this.$imagePath, this.$magicStudioPicStyle, this.$isFromCamera, this.$requestAigcCount, continuation);
        magicStudioCreationViewModel$requestPic2Pic$2.L$0 = obj;
        return magicStudioCreationViewModel$requestPic2Pic$2;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:3:0x0010. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x01f9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x01d7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x01c4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x01a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0158 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:10:0x0021, B:11:0x0026, B:22:0x0036, B:28:0x0040, B:35:0x0050, B:37:0x00ed, B:38:0x00f8, B:41:0x015b, B:48:0x0158, B:50:0x005b, B:52:0x00a8, B:53:0x00aa, B:56:0x00cc, B:58:0x00d4, B:59:0x00da, B:65:0x008c, B:67:0x0095), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:10:0x0021, B:11:0x0026, B:22:0x0036, B:28:0x0040, B:35:0x0050, B:37:0x00ed, B:38:0x00f8, B:41:0x015b, B:48:0x0158, B:50:0x005b, B:52:0x00a8, B:53:0x00aa, B:56:0x00cc, B:58:0x00d4, B:59:0x00da, B:65:0x008c, B:67:0x0095), top: B:2:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0095 A[Catch: Exception -> 0x002e, TryCatch #0 {Exception -> 0x002e, blocks: (B:10:0x0021, B:11:0x0026, B:22:0x0036, B:28:0x0040, B:35:0x0050, B:37:0x00ed, B:38:0x00f8, B:41:0x015b, B:48:0x0158, B:50:0x005b, B:52:0x00a8, B:53:0x00aa, B:56:0x00cc, B:58:0x00d4, B:59:0x00da, B:65:0x008c, B:67:0x0095), top: B:2:0x0010 }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Continuation continuation;
        MutableSharedFlow mutableSharedFlow;
        CoroutineScope coroutineScope;
        MutableSharedFlow mutableSharedFlow2;
        MagicStudioUploadImgInfo magicStudioUploadImgInfo;
        Object j3;
        MagicStudioDataManager I2;
        MagicStudioCreationViewModel magicStudioCreationViewModel;
        int i3;
        int i16;
        Object C2;
        CoroutineScope coroutineScope2;
        MagicStudioCreationViewModel magicStudioCreationViewModel2;
        int i17;
        com.tencent.mobileqq.wink.magicstudio.model.f curStyle;
        MutableSharedFlow MutableSharedFlow$default;
        MagicStudioDataManager I22;
        MagicStudioDataManager I23;
        int i18;
        boolean z16;
        Object p26;
        MutableSharedFlow mutableSharedFlow3;
        DefaultConstructorMarker defaultConstructorMarker;
        MutableSharedFlow mutableSharedFlow4;
        MagicStudioCreationViewModel.b.ProgressUpdate progressUpdate;
        MutableSharedFlow mutableSharedFlow5;
        MetaMaterial metaMaterial;
        int i19;
        Object w26;
        Flow cancellable;
        MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        try {
        } catch (Exception e16) {
            e = e16;
            continuation = null;
        }
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
                mutableSharedFlow2 = this.this$0._event;
                MagicStudioCreationViewModel.b.ProgressUpdate progressUpdate2 = new MagicStudioCreationViewModel.b.ProgressUpdate(0, this.this$0.getIsRegenerate());
                this.L$0 = coroutineScope;
                this.label = 1;
                if (mutableSharedFlow2.emit(progressUpdate2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                this.this$0.z2();
                magicStudioUploadImgInfo = this.$regenerateUploadImageInfo;
                if (magicStudioUploadImgInfo == null) {
                    MagicStudioCreationViewModel magicStudioCreationViewModel3 = this.this$0;
                    String str = this.$imagePath;
                    MagicStudioPicStyle magicStudioPicStyle = this.$magicStudioPicStyle;
                    boolean z17 = this.$isFromCamera;
                    this.L$0 = coroutineScope;
                    this.label = 2;
                    j3 = magicStudioCreationViewModel3.j3(str, magicStudioPicStyle, z17, this);
                    if (j3 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    magicStudioUploadImgInfo = (MagicStudioUploadImgInfo) j3;
                }
                MagicStudioCreationViewModel.f323611i0 = magicStudioUploadImgInfo;
                MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle = new MagicStudioUploadImgAndStyle();
                magicStudioUploadImgAndStyle.setCurrentImg(magicStudioUploadImgInfo);
                magicStudioUploadImgAndStyle.setSafeId(magicStudioUploadImgInfo.getSafeId());
                I2 = this.this$0.I2();
                I2.n(magicStudioUploadImgAndStyle);
                magicStudioCreationViewModel = this.this$0;
                i3 = this.$requestAigcCount;
                if (i3 > 0) {
                    magicStudioCreationViewModel.aigcCount = i3;
                    i17 = this.this$0.aigcCount;
                    w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic getAigcCount " + i17);
                    MagicStudioCreationViewModel magicStudioCreationViewModel4 = this.this$0;
                    com.tencent.mobileqq.wink.magicstudio.model.f fVar = new com.tencent.mobileqq.wink.magicstudio.model.f(this.$magicStudioPicStyle.getStyleId(), null, null, null, null, null, null, null, this.$magicStudioPicStyle.getStyleId(), false, false, null, 3838, null);
                    fVar.w(this.$magicStudioPicStyle.getStyleModeIdList());
                    magicStudioCreationViewModel4.t3(fVar);
                    curStyle = this.this$0.getCurStyle();
                    if (curStyle != null) {
                    }
                    MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
                    MagicStudioCreationViewModel magicStudioCreationViewModel5 = this.this$0;
                    com.tencent.mobileqq.wink.magicstudio.model.f curStyle2 = magicStudioCreationViewModel5.getCurStyle();
                    Intrinsics.checkNotNull(curStyle2);
                    I22 = this.this$0.I2();
                    String uploadUrl = I22.b().getUploadUrl();
                    I23 = this.this$0.I2();
                    String safeId = I23.b().getSafeId();
                    i18 = this.this$0.aigcCount;
                    this.L$0 = MutableSharedFlow$default;
                    this.L$1 = null;
                    this.label = 4;
                    CoroutineScope coroutineScope3 = coroutineScope;
                    continuation = null;
                    z16 = false;
                    p26 = magicStudioCreationViewModel5.p2(coroutineScope3, "", curStyle2, uploadUrl, safeId, MutableSharedFlow$default, i18, true, this);
                    if (p26 == coroutine_suspended) {
                    }
                } else {
                    List<Pair<String, Integer>> styleModeIdList = this.$magicStudioPicStyle.getStyleModeIdList();
                    if (styleModeIdList != null) {
                        i16 = styleModeIdList.size();
                    } else {
                        i16 = 0;
                    }
                    this.L$0 = coroutineScope;
                    this.L$1 = magicStudioCreationViewModel;
                    this.label = 3;
                    C2 = magicStudioCreationViewModel.C2(i16, this);
                    if (C2 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    coroutineScope2 = coroutineScope;
                    magicStudioCreationViewModel2 = magicStudioCreationViewModel;
                    i3 = ((Number) C2).intValue();
                    CoroutineScope coroutineScope4 = coroutineScope2;
                    magicStudioCreationViewModel = magicStudioCreationViewModel2;
                    coroutineScope = coroutineScope4;
                    magicStudioCreationViewModel.aigcCount = i3;
                    i17 = this.this$0.aigcCount;
                    w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic getAigcCount " + i17);
                    MagicStudioCreationViewModel magicStudioCreationViewModel42 = this.this$0;
                    com.tencent.mobileqq.wink.magicstudio.model.f fVar2 = new com.tencent.mobileqq.wink.magicstudio.model.f(this.$magicStudioPicStyle.getStyleId(), null, null, null, null, null, null, null, this.$magicStudioPicStyle.getStyleId(), false, false, null, 3838, null);
                    fVar2.w(this.$magicStudioPicStyle.getStyleModeIdList());
                    magicStudioCreationViewModel42.t3(fVar2);
                    curStyle = this.this$0.getCurStyle();
                    if (curStyle != null) {
                        curStyle.t(true);
                    }
                    MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
                    MagicStudioCreationViewModel magicStudioCreationViewModel52 = this.this$0;
                    com.tencent.mobileqq.wink.magicstudio.model.f curStyle22 = magicStudioCreationViewModel52.getCurStyle();
                    Intrinsics.checkNotNull(curStyle22);
                    I22 = this.this$0.I2();
                    String uploadUrl2 = I22.b().getUploadUrl();
                    I23 = this.this$0.I2();
                    String safeId2 = I23.b().getSafeId();
                    i18 = this.this$0.aigcCount;
                    this.L$0 = MutableSharedFlow$default;
                    this.L$1 = null;
                    this.label = 4;
                    CoroutineScope coroutineScope32 = coroutineScope;
                    continuation = null;
                    z16 = false;
                    try {
                        p26 = magicStudioCreationViewModel52.p2(coroutineScope32, "", curStyle22, uploadUrl2, safeId2, MutableSharedFlow$default, i18, true, this);
                    } catch (Exception e17) {
                        e = e17;
                        w53.b.h("MagicStudioCreationViewModel", "make fail", e);
                        MagicStudioDataSource.f323652a.o0(e);
                        mutableSharedFlow = this.this$0._event;
                        MagicStudioCreationViewModel.b.MakeFail makeFail = new MagicStudioCreationViewModel.b.MakeFail(e);
                        this.L$0 = continuation;
                        this.L$1 = continuation;
                        this.label = 8;
                        if (mutableSharedFlow.emit(makeFail, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.INSTANCE;
                    }
                    if (p26 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableSharedFlow3 = MutableSharedFlow$default;
                    defaultConstructorMarker = continuation;
                    mutableSharedFlow4 = this.this$0._event;
                    progressUpdate = new MagicStudioCreationViewModel.b.ProgressUpdate(20, z16, 2, defaultConstructorMarker);
                    this.L$0 = mutableSharedFlow3;
                    this.label = 5;
                    if (mutableSharedFlow4.emit(progressUpdate, this) != coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    mutableSharedFlow5 = mutableSharedFlow3;
                    metaMaterial = defaultConstructorMarker;
                    MagicStudioCreationViewModel magicStudioCreationViewModel6 = this.this$0;
                    i19 = magicStudioCreationViewModel6.aigcCount;
                    this.L$0 = metaMaterial;
                    this.label = 6;
                    w26 = magicStudioCreationViewModel6.w2(mutableSharedFlow5, metaMaterial, i19, this);
                    continuation = metaMaterial;
                    if (w26 == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    cancellable = FlowKt.cancellable(FlowKt.m2026catch((Flow) w26, new AnonymousClass2(this.this$0, continuation)));
                    magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 = new MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1(this.this$0);
                    this.label = 7;
                    if (cancellable.collect(magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return Unit.INSTANCE;
                }
            case 1:
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                this.this$0.z2();
                magicStudioUploadImgInfo = this.$regenerateUploadImageInfo;
                if (magicStudioUploadImgInfo == null) {
                }
                MagicStudioCreationViewModel.f323611i0 = magicStudioUploadImgInfo;
                MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle2 = new MagicStudioUploadImgAndStyle();
                magicStudioUploadImgAndStyle2.setCurrentImg(magicStudioUploadImgInfo);
                magicStudioUploadImgAndStyle2.setSafeId(magicStudioUploadImgInfo.getSafeId());
                I2 = this.this$0.I2();
                I2.n(magicStudioUploadImgAndStyle2);
                magicStudioCreationViewModel = this.this$0;
                i3 = this.$requestAigcCount;
                if (i3 > 0) {
                }
                break;
            case 2:
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                j3 = obj;
                magicStudioUploadImgInfo = (MagicStudioUploadImgInfo) j3;
                MagicStudioCreationViewModel.f323611i0 = magicStudioUploadImgInfo;
                MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle22 = new MagicStudioUploadImgAndStyle();
                magicStudioUploadImgAndStyle22.setCurrentImg(magicStudioUploadImgInfo);
                magicStudioUploadImgAndStyle22.setSafeId(magicStudioUploadImgInfo.getSafeId());
                I2 = this.this$0.I2();
                I2.n(magicStudioUploadImgAndStyle22);
                magicStudioCreationViewModel = this.this$0;
                i3 = this.$requestAigcCount;
                if (i3 > 0) {
                }
                break;
            case 3:
                magicStudioCreationViewModel2 = (MagicStudioCreationViewModel) this.L$1;
                coroutineScope2 = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
                C2 = obj;
                i3 = ((Number) C2).intValue();
                CoroutineScope coroutineScope42 = coroutineScope2;
                magicStudioCreationViewModel = magicStudioCreationViewModel2;
                coroutineScope = coroutineScope42;
                magicStudioCreationViewModel.aigcCount = i3;
                i17 = this.this$0.aigcCount;
                w53.b.f("MagicStudioCreationViewModel", "requestPic2Pic getAigcCount " + i17);
                MagicStudioCreationViewModel magicStudioCreationViewModel422 = this.this$0;
                com.tencent.mobileqq.wink.magicstudio.model.f fVar22 = new com.tencent.mobileqq.wink.magicstudio.model.f(this.$magicStudioPicStyle.getStyleId(), null, null, null, null, null, null, null, this.$magicStudioPicStyle.getStyleId(), false, false, null, 3838, null);
                fVar22.w(this.$magicStudioPicStyle.getStyleModeIdList());
                magicStudioCreationViewModel422.t3(fVar22);
                curStyle = this.this$0.getCurStyle();
                if (curStyle != null) {
                }
                MutableSharedFlow$default = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
                MagicStudioCreationViewModel magicStudioCreationViewModel522 = this.this$0;
                com.tencent.mobileqq.wink.magicstudio.model.f curStyle222 = magicStudioCreationViewModel522.getCurStyle();
                Intrinsics.checkNotNull(curStyle222);
                I22 = this.this$0.I2();
                String uploadUrl22 = I22.b().getUploadUrl();
                I23 = this.this$0.I2();
                String safeId22 = I23.b().getSafeId();
                i18 = this.this$0.aigcCount;
                this.L$0 = MutableSharedFlow$default;
                this.L$1 = null;
                this.label = 4;
                CoroutineScope coroutineScope322 = coroutineScope;
                continuation = null;
                z16 = false;
                p26 = magicStudioCreationViewModel522.p2(coroutineScope322, "", curStyle222, uploadUrl22, safeId22, MutableSharedFlow$default, i18, true, this);
                if (p26 == coroutine_suspended) {
                }
                break;
            case 4:
                MutableSharedFlow mutableSharedFlow6 = (MutableSharedFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
                mutableSharedFlow3 = mutableSharedFlow6;
                defaultConstructorMarker = 0;
                z16 = false;
                mutableSharedFlow4 = this.this$0._event;
                progressUpdate = new MagicStudioCreationViewModel.b.ProgressUpdate(20, z16, 2, defaultConstructorMarker);
                this.L$0 = mutableSharedFlow3;
                this.label = 5;
                if (mutableSharedFlow4.emit(progressUpdate, this) != coroutine_suspended) {
                }
                break;
            case 5:
                mutableSharedFlow5 = (MutableSharedFlow) this.L$0;
                ResultKt.throwOnFailure(obj);
                metaMaterial = 0;
                MagicStudioCreationViewModel magicStudioCreationViewModel62 = this.this$0;
                i19 = magicStudioCreationViewModel62.aigcCount;
                this.L$0 = metaMaterial;
                this.label = 6;
                w26 = magicStudioCreationViewModel62.w2(mutableSharedFlow5, metaMaterial, i19, this);
                continuation = metaMaterial;
                if (w26 == coroutine_suspended) {
                }
                cancellable = FlowKt.cancellable(FlowKt.m2026catch((Flow) w26, new AnonymousClass2(this.this$0, continuation)));
                magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 = new MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1(this.this$0);
                this.label = 7;
                if (cancellable.collect(magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 6:
                ResultKt.throwOnFailure(obj);
                w26 = obj;
                continuation = null;
                cancellable = FlowKt.cancellable(FlowKt.m2026catch((Flow) w26, new AnonymousClass2(this.this$0, continuation)));
                magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1 = new MagicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1(this.this$0);
                this.label = 7;
                if (cancellable.collect(magicStudioCreationViewModel$requestPic2Pic$2$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                }
                return Unit.INSTANCE;
            case 7:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            case 8:
                ResultKt.throwOnFailure(obj);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioCreationViewModel$requestPic2Pic$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
