package com.tencent.mobileqq.wink.editor.sticker.sticker;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.performance.WinkEditPerformanceViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.editor.sticker.sticker.WinkApplyStickerMaterialTask$Companion$onApplyMaterialLocal$1", f = "WinkApplyStickerMaterialTask.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkApplyStickerMaterialTask$Companion$onApplyMaterialLocal$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MetaMaterial $material;
    final /* synthetic */ WinkEditPerformanceViewModel $winkEditPerformanceViewModel;
    final /* synthetic */ WinkEditorFragment $winkEditorFragment;
    final /* synthetic */ dr $winkTavCut;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkApplyStickerMaterialTask$Companion$onApplyMaterialLocal$1(dr drVar, WinkEditorFragment winkEditorFragment, MetaMaterial metaMaterial, WinkEditPerformanceViewModel winkEditPerformanceViewModel, Continuation<? super WinkApplyStickerMaterialTask$Companion$onApplyMaterialLocal$1> continuation) {
        super(2, continuation);
        this.$winkTavCut = drVar;
        this.$winkEditorFragment = winkEditorFragment;
        this.$material = metaMaterial;
        this.$winkEditPerformanceViewModel = winkEditPerformanceViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkApplyStickerMaterialTask$Companion$onApplyMaterialLocal$1(this.$winkTavCut, this.$winkEditorFragment, this.$material, this.$winkEditPerformanceViewModel, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            WinkApplyStickerMaterialTaskKt.f(this.$winkTavCut, this.$winkEditorFragment, this.$material, this.$winkEditPerformanceViewModel);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((WinkApplyStickerMaterialTask$Companion$onApplyMaterialLocal$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
