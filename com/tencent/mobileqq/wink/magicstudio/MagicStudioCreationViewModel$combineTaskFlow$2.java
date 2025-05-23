package com.tencent.mobileqq.wink.magicstudio;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.CombineFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateFlowInfo;
import com.tencent.mobileqq.wink.magicstudio.model.GenerateInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.MutableSharedFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u008a@"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/model/b;", "generateFlowInfo", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "Lcom/tencent/mobileqq/wink/magicstudio/model/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel$combineTaskFlow$2", f = "MagicStudioCreationViewModel.kt", i = {0, 0}, l = {MiniReportManager.EventId.SDK_EMBEDDED_UPDATE_RESULT}, m = "invokeSuspend", n = {"generateFlowInfo", WadlProxyConsts.KEY_MATERIAL}, s = {"L$0", "L$1"})
/* loaded from: classes21.dex */
public final class MagicStudioCreationViewModel$combineTaskFlow$2 extends SuspendLambda implements Function3<GenerateFlowInfo, MetaMaterial, Continuation<? super CombineFlowInfo>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;
    final /* synthetic */ MagicStudioCreationViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioCreationViewModel$combineTaskFlow$2(MagicStudioCreationViewModel magicStudioCreationViewModel, Continuation<? super MagicStudioCreationViewModel$combineTaskFlow$2> continuation) {
        super(3, continuation);
        this.this$0 = magicStudioCreationViewModel;
    }

    @Override // kotlin.jvm.functions.Function3
    @Nullable
    public final Object invoke(@NotNull GenerateFlowInfo generateFlowInfo, @NotNull MetaMaterial metaMaterial, @Nullable Continuation<? super CombineFlowInfo> continuation) {
        MagicStudioCreationViewModel$combineTaskFlow$2 magicStudioCreationViewModel$combineTaskFlow$2 = new MagicStudioCreationViewModel$combineTaskFlow$2(this.this$0, continuation);
        magicStudioCreationViewModel$combineTaskFlow$2.L$0 = generateFlowInfo;
        magicStudioCreationViewModel$combineTaskFlow$2.L$1 = metaMaterial;
        return magicStudioCreationViewModel$combineTaskFlow$2.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        GenerateFlowInfo generateFlowInfo;
        MutableSharedFlow mutableSharedFlow;
        MetaMaterial metaMaterial;
        Map emptyMap;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                metaMaterial = (MetaMaterial) this.L$1;
                generateFlowInfo = (GenerateFlowInfo) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            generateFlowInfo = (GenerateFlowInfo) this.L$0;
            MetaMaterial metaMaterial2 = (MetaMaterial) this.L$1;
            mutableSharedFlow = this.this$0._event;
            MagicStudioCreationViewModel.b.ProgressUpdate progressUpdate = new MagicStudioCreationViewModel.b.ProgressUpdate(80, false, 2, null);
            this.L$0 = generateFlowInfo;
            this.L$1 = metaMaterial2;
            this.label = 1;
            if (mutableSharedFlow.emit(progressUpdate, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            metaMaterial = metaMaterial2;
        }
        if (generateFlowInfo.getThrowable() != null) {
            MetaMaterial metaMaterial3 = new MetaMaterial();
            emptyMap = MapsKt__MapsKt.emptyMap();
            return new CombineFlowInfo(metaMaterial3, new GenerateInfo(emptyMap, "", false, null, null, null, null, 0, 0, 508, null), 1);
        }
        GenerateInfo generateInfo = generateFlowInfo.getGenerateInfo();
        if (generateInfo != null) {
            return new CombineFlowInfo(metaMaterial, generateInfo, generateFlowInfo.getCount());
        }
        throw new Exception("empty generateInfo");
    }
}
