package com.qwallet.localphone;

import com.qwallet.localphone.QWalletLocalPhoneModule;
import com.tencent.mobileqq.turingfd.c;
import com.tencent.turingfd.sdk.xq.PhoneResp;
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

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lcom/qwallet/localphone/QWalletLocalPhoneModule$a;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.qwallet.localphone.QWalletLocalPhoneModule$getPhoneToken$2", f = "QWalletLocalPhoneModule.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes3.dex */
final class QWalletLocalPhoneModule$getPhoneToken$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super QWalletLocalPhoneModule.a<String>>, Object> {
    final /* synthetic */ String $sessionId;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWalletLocalPhoneModule$getPhoneToken$2(String str, Continuation<? super QWalletLocalPhoneModule$getPhoneToken$2> continuation) {
        super(2, continuation);
        this.$sessionId = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new QWalletLocalPhoneModule$getPhoneToken$2(this.$sessionId, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            PhoneResp b16 = c.a().b(false, this.$sessionId);
            long errorCode = b16.getErrorCode();
            if (errorCode != 0) {
                return new QWalletLocalPhoneModule.a((int) errorCode, null, "getPhoneToken failed in turingSDK!");
            }
            return new QWalletLocalPhoneModule.a(0, b16.getPhoneToken(), null);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super QWalletLocalPhoneModule.a<String>> continuation) {
        return ((QWalletLocalPhoneModule$getPhoneToken$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
