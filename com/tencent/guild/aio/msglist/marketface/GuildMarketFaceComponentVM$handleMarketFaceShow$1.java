package com.tencent.guild.aio.msglist.marketface;

import com.tencent.guild.aio.msglist.marketface.a;
import com.tencent.guild.api.marketface.IMarketFaceApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarketFaceElement;
import com.tencent.qqnt.msg.api.c;
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
@DebugMetadata(c = "com.tencent.guild.aio.msglist.marketface.GuildMarketFaceComponentVM$handleMarketFaceShow$1", f = "GuildMarketFaceComponentVM.kt", i = {}, l = {55, 57}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMarketFaceComponentVM$handleMarketFaceShow$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MarketFaceElement $data;
    final /* synthetic */ a.C1204a $intent;
    int label;
    final /* synthetic */ GuildMarketFaceComponentVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMarketFaceComponentVM$handleMarketFaceShow$1(MarketFaceElement marketFaceElement, GuildMarketFaceComponentVM guildMarketFaceComponentVM, a.C1204a c1204a, Continuation<? super GuildMarketFaceComponentVM$handleMarketFaceShow$1> continuation) {
        super(2, continuation);
        this.$data = marketFaceElement;
        this.this$0 = guildMarketFaceComponentVM;
        this.$intent = c1204a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMarketFaceComponentVM$handleMarketFaceShow$1(this.$data, this.this$0, this.$intent, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 == 2) {
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        } else {
            ResultKt.throwOnFailure(obj);
            QLog.i("GuildMarketFaceComponentVM", 1, "vmScope ThreadName=" + Thread.currentThread().getName());
            IMarketFaceApi iMarketFaceApi = (IMarketFaceApi) QRoute.api(IMarketFaceApi.class);
            MarketFaceElement marketFaceElement = this.$data;
            this.label = 1;
            obj = iMarketFaceApi.fetchMarketFaceInfoSuspend(marketFaceElement, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        c cVar = (c) obj;
        if (cVar.d()) {
            GuildMarketFaceComponentVM guildMarketFaceComponentVM = this.this$0;
            mr0.a aVar = (mr0.a) cVar.a();
            IntentData data = this.$intent.getData();
            this.label = 2;
            if (guildMarketFaceComponentVM.n(aVar, data, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            QLog.i("GuildMarketFaceComponentVM", 1, "fetchMarketFaceInfoSuspend fail msg=" + cVar.b());
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMarketFaceComponentVM$handleMarketFaceShow$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
