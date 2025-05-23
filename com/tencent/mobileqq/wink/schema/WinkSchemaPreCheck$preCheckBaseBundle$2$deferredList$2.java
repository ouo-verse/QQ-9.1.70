package com.tencent.mobileqq.wink.schema;

import com.tencent.aelight.camera.download.api.AEResInfo;
import com.tencent.view.FilterEnum;
import java.util.HashMap;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$2", f = "WinkSchemaPreCheck.kt", i = {}, l = {FilterEnum.MIC_PTU_ZIRAN}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
public final class WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ HashMap<String, Object> $costCollector;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$2(HashMap<String, Object> hashMap, Continuation<? super WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$2> continuation) {
        super(2, continuation);
        this.$costCollector = hashMap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$2(this.$costCollector, continuation);
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
            String str = AEResInfo.LIGHT_RES_FILAMENT.agentType;
            Intrinsics.checkNotNullExpressionValue(str, "LIGHT_RES_FILAMENT.agentType");
            HashMap<String, Object> hashMap = this.$costCollector;
            this.label = 1;
            obj = winkSchemaPreCheck.p(str, hashMap, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Boolean> continuation) {
        return ((WinkSchemaPreCheck$preCheckBaseBundle$2$deferredList$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
