package com.tencent.mobileqq.wink.schema;

import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.wink.editor.model.WinkUserInfo;
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

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/tencent/mobileqq/wink/editor/model/c;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.wink.schema.WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1", f = "WinkSchemaPreCheck.kt", i = {}, l = {PlayerResources.ViewId.EXTENDED_VIEW_IV_USER_PORTRAIT}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes21.dex */
final class WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super WinkUserInfo>, Object> {
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1(Continuation<? super WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1(continuation);
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
            this.label = 1;
            obj = winkSchemaPreCheck.u(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return obj;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super WinkUserInfo> continuation) {
        return ((WinkSchemaPreCheck$preCheckUserInfo$2$userInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
