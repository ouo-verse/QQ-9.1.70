package com.tenpay.sdk.net.gateway;

import android.app.Dialog;
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
@DebugMetadata(c = "com.tenpay.sdk.net.gateway.GatewayCallbackInterceptor$onCallbackSuccess$1", f = "GatewayCallbackInterceptor.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes27.dex */
public final class GatewayCallbackInterceptor$onCallbackSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $rspByteArray;
    int label;
    final /* synthetic */ GatewayCallbackInterceptor this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayCallbackInterceptor$onCallbackSuccess$1(GatewayCallbackInterceptor gatewayCallbackInterceptor, byte[] bArr, Continuation<? super GatewayCallbackInterceptor$onCallbackSuccess$1> continuation) {
        super(2, continuation);
        this.this$0 = gatewayCallbackInterceptor;
        this.$rspByteArray = bArr;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GatewayCallbackInterceptor$onCallbackSuccess$1(this.this$0, this.$rspByteArray, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Dialog dialog;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            dialog = this.this$0.loadingDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.this$0.getCallback().onSuccess(this.$rspByteArray);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GatewayCallbackInterceptor$onCallbackSuccess$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
