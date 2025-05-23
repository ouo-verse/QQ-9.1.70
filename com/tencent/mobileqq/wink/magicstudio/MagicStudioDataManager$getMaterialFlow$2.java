package com.tencent.mobileqq.wink.magicstudio;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/flow/FlowCollector;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.magicstudio.MagicStudioDataManager$getMaterialFlow$2", f = "MagicStudioDataManager.kt", i = {}, l = {40, 42}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class MagicStudioDataManager$getMaterialFlow$2 extends SuspendLambda implements Function2<FlowCollector<? super MetaMaterial>, Continuation<? super Unit>, Object> {
    final /* synthetic */ MetaMaterial $template;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MagicStudioDataManager$getMaterialFlow$2(MetaMaterial metaMaterial, Continuation<? super MagicStudioDataManager$getMaterialFlow$2> continuation) {
        super(2, continuation);
        this.$template = metaMaterial;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MagicStudioDataManager$getMaterialFlow$2 magicStudioDataManager$getMaterialFlow$2 = new MagicStudioDataManager$getMaterialFlow$2(this.$template, continuation);
        magicStudioDataManager$getMaterialFlow$2.L$0 = obj;
        return magicStudioDataManager$getMaterialFlow$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        String str;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1 && i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            MetaMaterial metaMaterial = this.$template;
            if (metaMaterial != null) {
                str = metaMaterial.f30533id;
            } else {
                str = null;
            }
            w53.b.f("MagicStudioCreationViewModel", "prepareEditorData : downloadMaterial = " + str);
            if (this.$template == null) {
                w53.b.f("MagicStudioCreationViewModel", "prepareEditorData : downloadMaterial template = null");
                MetaMaterial metaMaterial2 = new MetaMaterial();
                this.label = 1;
                if (flowCollector.emit(metaMaterial2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                MetaMaterial metaMaterial3 = new MetaMaterial();
                this.label = 2;
                if (flowCollector.emit(metaMaterial3, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super MetaMaterial> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((MagicStudioDataManager$getMaterialFlow$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
