package com.tencent.guild.aio.title;

import com.tencent.guild.aio.title.GuildAioTitleUnreadMsgCntUIState;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.chats.api.IChatsUtil;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guild.aio.title.GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1", f = "GuildAioTitleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $listType;
    final /* synthetic */ int $unreadCnt;
    int label;
    final /* synthetic */ GuildAioTitleViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "com.tencent.guild.aio.title.GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1$1", f = "GuildAioTitleViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.tencent.guild.aio.title.GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1$1, reason: invalid class name */
    /* loaded from: classes6.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ int $listType;
        int label;
        final /* synthetic */ GuildAioTitleViewModel this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(int i3, GuildAioTitleViewModel guildAioTitleViewModel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$listType = i3;
            this.this$0 = guildAioTitleViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(this.$listType, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.this$0.updateUI(new GuildAioTitleUnreadMsgCntUIState.a().b(((IChatsUtil) QRoute.api(IChatsUtil.class)).getUnreadCountByListType(this.$listType)).getState());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        @Override // kotlin.jvm.functions.Function2
        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1(GuildAioTitleViewModel guildAioTitleViewModel, int i3, int i16, Continuation<? super GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1> continuation) {
        super(2, continuation);
        this.this$0 = guildAioTitleViewModel;
        this.$listType = i3;
        this.$unreadCnt = i16;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1(this.this$0, this.$listType, this.$unreadCnt, continuation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (((com.tencent.aio.api.runtime.a) this.this$0.getMContext()).g().l().getInt("key_from_chat_listtype", 1) != this.$listType) {
                return Unit.INSTANCE;
            }
            if (this.$unreadCnt >= 0) {
                this.this$0.updateUI(new GuildAioTitleUnreadMsgCntUIState.a().b(this.$unreadCnt).getState());
            } else {
                CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.b.f261780e);
                if (f16 != null) {
                    CorountineFunKt.e(f16, "GuildAioTitleViewModel_updateUnreadCnt", null, null, null, new AnonymousClass1(this.$listType, this.this$0, null), 14, null);
                }
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildAioTitleViewModel$unreadMsgCntObs$1$refreshUnread$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
