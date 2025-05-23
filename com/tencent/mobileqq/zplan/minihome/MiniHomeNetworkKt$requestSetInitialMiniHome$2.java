package com.tencent.mobileqq.zplan.minihome;

import com.google.protobuf.nano.MessageNano;
import com.tencent.mobileqq.zplan.utils.SknNetworkUtilKt;
import com.tencent.mobileqq.zplan.utils.ZPlanRequestReq;
import com.tencent.mobileqq.zplan.utils.at;
import com.tencent.mobileqq.zplan.utils.av;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.zplan.minihome.MiniHomeNetworkKt$requestSetInitialMiniHome$2", f = "MiniHomeNetwork.kt", i = {0}, l = {287}, m = "invokeSuspend", n = {"rsp$iv"}, s = {"L$0"})
/* loaded from: classes34.dex */
public final class MiniHomeNetworkKt$requestSetInitialMiniHome$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $hash;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeNetworkKt$requestSetInitialMiniHome$2(String str, Continuation<? super MiniHomeNetworkKt$requestSetInitialMiniHome$2> continuation) {
        super(2, continuation);
        this.$hash = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MiniHomeNetworkKt$requestSetInitialMiniHome$2(this.$hash, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        MessageNano messageNano;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        boolean z16 = true;
        try {
            if (i3 == 0) {
                ResultKt.throwOnFailure(obj);
                at atVar = at.f335791a;
                o55.c cVar = new o55.c();
                o55.d dVar = new o55.d();
                cVar.f422153a = this.$hash;
                Unit unit = Unit.INSTANCE;
                ZPlanRequestReq zPlanRequestReq = new ZPlanRequestReq("trpc.zplan.mini_home_guide_page.Creator.SsoSetInitialMinihome", SknNetworkUtilKt.i(cVar));
                this.L$0 = dVar;
                this.label = 1;
                obj = atVar.a(zPlanRequestReq, this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
                messageNano = dVar;
            } else if (i3 == 1) {
                messageNano = (MessageNano) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Object data = ((av) obj).getData();
            if (data != null) {
                SknNetworkUtilKt.c((byte[]) data, messageNano);
            }
        } catch (CancellationException e16) {
            throw e16;
        } catch (Throwable unused) {
            z16 = false;
        }
        return Boxing.boxBoolean(z16);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((MiniHomeNetworkKt$requestSetInitialMiniHome$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
