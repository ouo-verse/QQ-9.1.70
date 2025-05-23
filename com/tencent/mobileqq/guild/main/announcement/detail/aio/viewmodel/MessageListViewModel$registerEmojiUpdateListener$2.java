package com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.guild.main.announcement.detail.Param;
import com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qqnt.kernel.nativeinterface.MsgEmojiLikes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@"}, d2 = {"", "Lcom/tencent/aio/data/msglist/a;", TabPreloadItem.TAB_NAME_MESSAGE, "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.mobileqq.guild.main.announcement.detail.aio.viewmodel.MessageListViewModel$registerEmojiUpdateListener$2", f = "MessageListViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes14.dex */
public final class MessageListViewModel$registerEmojiUpdateListener$2 extends SuspendLambda implements Function2<List<? extends com.tencent.aio.data.msglist.a>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MessageListViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MessageListViewModel$registerEmojiUpdateListener$2(MessageListViewModel messageListViewModel, Continuation<? super MessageListViewModel$registerEmojiUpdateListener$2> continuation) {
        super(2, continuation);
        this.this$0 = messageListViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        MessageListViewModel$registerEmojiUpdateListener$2 messageListViewModel$registerEmojiUpdateListener$2 = new MessageListViewModel$registerEmojiUpdateListener$2(this.this$0, continuation);
        messageListViewModel$registerEmojiUpdateListener$2.L$0 = obj;
        return messageListViewModel$registerEmojiUpdateListener$2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0065, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5, r9.getChannelId()) != false) goto L20;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(@NotNull Object obj) {
        Object orNull;
        List list;
        boolean b16;
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            List list2 = (List) this.L$0;
            MessageListViewModel messageListViewModel = this.this$0;
            ArrayList arrayList = new ArrayList();
            Iterator it = list2.iterator();
            while (true) {
                boolean z16 = true;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                com.tencent.aio.data.msglist.a aVar = (com.tencent.aio.data.msglist.a) next;
                Intrinsics.checkNotNull(aVar, "null cannot be cast to non-null type com.tencent.guild.api.data.msglist.GuildMsgItem");
                GuildMsgItem guildMsgItem = (GuildMsgItem) aVar;
                long msgSeq = guildMsgItem.getMsgSeq();
                Param param = messageListViewModel.param;
                Param param2 = null;
                if (param == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("param");
                    param = null;
                }
                if (msgSeq == param.getMessageSeq()) {
                    String str = guildMsgItem.getMsgRecord().channelId;
                    Param param3 = messageListViewModel.param;
                    if (param3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("param");
                    } else {
                        param2 = param3;
                    }
                }
                z16 = false;
                if (z16) {
                    arrayList.add(next);
                }
            }
            orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
            com.tencent.aio.data.msglist.a aVar2 = (com.tencent.aio.data.msglist.a) orNull;
            if (aVar2 == null) {
                return Unit.INSTANCE;
            }
            if (aVar2 instanceof GuildMsgItem) {
                MessageListViewModel.Companion companion = MessageListViewModel.INSTANCE;
                GuildMsgItem guildMsgItem2 = (GuildMsgItem) aVar2;
                ArrayList<MsgEmojiLikes> arrayList2 = guildMsgItem2.getMsgRecord().emojiLikesList;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "message.msgRecord.emojiLikesList");
                list = this.this$0.emojiLikesList;
                b16 = companion.b(arrayList2, list);
                if (!b16) {
                    Logger.f235387a.d().i("Guild.ann.MessageListViewModel", 1, "emojiLikesList changed, will fetch announcement");
                    this.this$0.emojiLikesList = new ArrayList(guildMsgItem2.getMsgRecord().emojiLikesList);
                    this.this$0.p();
                }
                return Unit.INSTANCE;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull List<? extends com.tencent.aio.data.msglist.a> list, @Nullable Continuation<? super Unit> continuation) {
        return ((MessageListViewModel$registerEmojiUpdateListener$2) create(list, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
