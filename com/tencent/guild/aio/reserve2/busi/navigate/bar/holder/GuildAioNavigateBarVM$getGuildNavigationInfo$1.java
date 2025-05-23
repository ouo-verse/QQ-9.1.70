package com.tencent.guild.aio.reserve2.busi.navigate.bar.holder;

import com.tencent.aio.msgservice.j;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"Lcom/tencent/aio/msgservice/j;", "Ler0/a;", "it", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarVM$getGuildNavigationInfo$1", f = "GuildAioNavigateBarVM.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildAioNavigateBarVM$getGuildNavigationInfo$1 extends SuspendLambda implements Function2<j<er0.a>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GuildAioNavigateBarVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarVM$getGuildNavigationInfo$1$1", f = "GuildAioNavigateBarVM.kt", i = {}, l = {178}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.guild.aio.reserve2.busi.navigate.bar.holder.GuildAioNavigateBarVM$getGuildNavigationInfo$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ GuildAioNavigateBarVM this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GuildAioNavigateBarVM guildAioNavigateBarVM, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = guildAioNavigateBarVM;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
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
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            this.this$0.x("afterTimeOut");
            return Unit.INSTANCE;
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAioNavigateBarVM$getGuildNavigationInfo$1(GuildAioNavigateBarVM guildAioNavigateBarVM, Continuation<? super GuildAioNavigateBarVM$getGuildNavigationInfo$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAioNavigateBarVM;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        GuildAioNavigateBarVM$getGuildNavigationInfo$1 guildAioNavigateBarVM$getGuildNavigationInfo$1 = new GuildAioNavigateBarVM$getGuildNavigationInfo$1(this.this$0, continuation);
        guildAioNavigateBarVM$getGuildNavigationInfo$1.L$0 = obj;
        return guildAioNavigateBarVM$getGuildNavigationInfo$1;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull j<er0.a> jVar, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAioNavigateBarVM$getGuildNavigationInfo$1) create(jVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        boolean z16;
        boolean z17;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            j jVar = (j) this.L$0;
            z16 = this.this$0.isFirstPageMsgFin;
            QLog.i("GuildAioNavigateBarVM", 1, "getGuildNavigationInfo, isFirstPageMsgFin = " + z16);
            z17 = this.this$0.isFirstPageMsgFin;
            if (!z17) {
                this.this$0.pendingRsp = jVar;
                BuildersKt__Builders_commonKt.launch$default(this.this$0.vmScope(), Dispatchers.getMain(), null, new AnonymousClass1(this.this$0, null), 2, null);
            } else {
                this.this$0.w(jVar);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
