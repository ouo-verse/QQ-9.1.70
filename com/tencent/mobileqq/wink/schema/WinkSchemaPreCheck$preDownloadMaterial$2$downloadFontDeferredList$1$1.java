package com.tencent.mobileqq.wink.schema;

import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import java.util.HashMap;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1", f = "WinkSchemaPreCheck.kt", i = {}, l = {455}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    final /* synthetic */ MetaMaterial $material;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1(MetaMaterial metaMaterial, HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1> continuation) {
        super(2, continuation);
        this.$material = metaMaterial;
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1(this.$material, this.$costCollector, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WinkSchemaPreCheck winkSchemaPreCheck = WinkSchemaPreCheck.f326271a;
            MetaMaterial metaMaterial = this.$material;
            HashMap<String, Object> hashMap = this.$costCollector;
            this.label = 1;
            obj = winkSchemaPreCheck.q(metaMaterial, hashMap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkSchemaPreCheck$preDownloadMaterial$2$downloadFontDeferredList$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
