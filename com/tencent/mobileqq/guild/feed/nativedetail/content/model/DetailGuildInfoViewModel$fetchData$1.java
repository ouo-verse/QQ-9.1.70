package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
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
@DebugMetadata(c = "com.tencent.mobileqq.guild.feed.nativedetail.content.model.DetailGuildInfoViewModel$fetchData$1", f = "DetailGuildInfoViewModel.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes13.dex */
public final class DetailGuildInfoViewModel$fetchData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LoadDataArgs $loadDataArgs;
    Object L$0;
    int label;
    final /* synthetic */ DetailGuildInfoViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DetailGuildInfoViewModel$fetchData$1(DetailGuildInfoViewModel detailGuildInfoViewModel, LoadDataArgs loadDataArgs, Continuation<? super DetailGuildInfoViewModel$fetchData$1> continuation) {
        super(2, continuation);
        this.this$0 = detailGuildInfoViewModel;
        this.$loadDataArgs = loadDataArgs;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DetailGuildInfoViewModel$fetchData$1(this.this$0, this.$loadDataArgs, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Object j26;
        DetailGuildInfoViewModel detailGuildInfoViewModel;
        boolean z16;
        boolean z17;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 != 0) {
            if (i3 == 1) {
                detailGuildInfoViewModel = (DetailGuildInfoViewModel) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            DetailGuildInfoViewModel detailGuildInfoViewModel2 = this.this$0;
            String guildId = this.$loadDataArgs.getGuildId();
            this.L$0 = detailGuildInfoViewModel2;
            this.label = 1;
            j26 = detailGuildInfoViewModel2.j2(guildId, this);
            if (j26 == coroutine_suspended) {
                return coroutine_suspended;
            }
            detailGuildInfoViewModel = detailGuildInfoViewModel2;
            obj = j26;
        }
        detailGuildInfoViewModel.guildInfo = (IGProGuildInfo) obj;
        if (this.this$0.guildInfo != null) {
            this.this$0.loadDataFinish = true;
            z16 = this.this$0.loadFeedMainFinish;
            if (z16) {
                z17 = this.this$0.loadFeedMainSuccess;
                if (!z17) {
                    this.this$0.l2("load finish");
                    return Unit.INSTANCE;
                }
            }
            com.tencent.xaction.log.b.a(this.this$0.getTAG(), 1, "can not show, finish");
            return Unit.INSTANCE;
        }
        com.tencent.xaction.log.b.a(this.this$0.getTAG(), 1, "getGuildInfo error, guildInfo is null");
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DetailGuildInfoViewModel$fetchData$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
