package com.tencent.guildmedia.aio.msglist.item.excellent;

import com.tencent.guild.api.channel.IGuildChannelApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.qqnt.msg.api.c;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.tencent.guildmedia.aio.msglist.item.excellent.GuildMediaAnnounceContentComponentVM$getMsgBySeq$1", f = "GuildMediaAnnounceContentComponentVM.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildMediaAnnounceContentComponentVM$getMsgBySeq$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $seq;
    int label;
    final /* synthetic */ GuildMediaAnnounceContentComponentVM this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildMediaAnnounceContentComponentVM$getMsgBySeq$1(GuildMediaAnnounceContentComponentVM guildMediaAnnounceContentComponentVM, long j3, Continuation<? super GuildMediaAnnounceContentComponentVM$getMsgBySeq$1> continuation) {
        super(2, continuation);
        this.this$0 = guildMediaAnnounceContentComponentVM;
        this.$seq = j3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildMediaAnnounceContentComponentVM$getMsgBySeq$1(this.this$0, this.$seq, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended;
        Contact A;
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
            A = this.this$0.A();
            IGuildChannelApi iGuildChannelApi = (IGuildChannelApi) QRoute.api(IGuildChannelApi.class);
            String str = A.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "contact.peerUid");
            String str2 = A.guildId;
            Intrinsics.checkNotNullExpressionValue(str2, "contact.guildId");
            boolean isSelfGuest = iGuildChannelApi.isSelfGuest(str, str2);
            IMsgService iMsgService = (IMsgService) QRoute.api(IMsgService.class);
            long j3 = this.$seq;
            this.label = 1;
            obj = iMsgService.getMsgsBySeqsSuspend(A, j3, isSelfGuest, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        c cVar = (c) obj;
        if (cVar.d() && (!((Collection) cVar.a()).isEmpty())) {
            GuildMediaAnnounceContentComponentVM guildMediaAnnounceContentComponentVM = this.this$0;
            Object obj2 = ((ArrayList) cVar.a()).get(0);
            Intrinsics.checkNotNullExpressionValue(obj2, "msgList.data[0]");
            guildMediaAnnounceContentComponentVM.updateUI(new LiveAnnounceGetRealMsgSuccess((MsgRecord) obj2));
        }
        return Unit.INSTANCE;
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildMediaAnnounceContentComponentVM$getMsgBySeq$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
