package com.tencent.libra.download.lightquic;

import com.tencent.gamecenter.wadl.sdk.downloader.DownloaderConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
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
/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "com.tencent.libra.download.lightquic.RFWLightQuicSession$startRequest$1", f = "RFWLightQuicSession.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes7.dex */
public final class RFWLightQuicSession$startRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $rangeStart;
    int label;
    final /* synthetic */ RFWLightQuicSession this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RFWLightQuicSession$startRequest$1(RFWLightQuicSession rFWLightQuicSession, long j3, Continuation continuation) {
        super(2, continuation);
        this.this$0 = rFWLightQuicSession;
        this.$rangeStart = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> completion) {
        Intrinsics.checkNotNullParameter(completion, "completion");
        return new RFWLightQuicSession$startRequest$1(this.this$0, this.$rangeStart, completion);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RFWLightQuicSession$startRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        a aVar;
        String str;
        Map<String, String> mapOf;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            RFWLightQuicSession rFWLightQuicSession = this.this$0;
            aVar = rFWLightQuicSession.lightQuic;
            str = this.this$0.url;
            LightQuicRequestCallback requestCallback = this.this$0.getRequestCallback();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("accept", "*/*"), TuplesKt.to(DownloaderConstant.KEY_RANGE, "bytes=" + this.$rangeStart + '-'));
            rFWLightQuicSession.quicRequest = aVar.a(str, requestCallback, mapOf);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
