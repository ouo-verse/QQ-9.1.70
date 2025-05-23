package com.tencent.guild.aio.msglist.file;

import com.tencent.guild.api.data.msglist.b;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
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
@DebugMetadata(c = "com.tencent.guild.aio.msglist.file.GuildFileViewer$updateBindState$1", f = "GuildFileView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
public final class GuildFileViewer$updateBindState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $msg;
    final /* synthetic */ Object $payload;
    int label;
    final /* synthetic */ GuildFileViewer this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildFileViewer$updateBindState$1(String str, GuildFileViewer guildFileViewer, Object obj, Continuation<? super GuildFileViewer$updateBindState$1> continuation) {
        super(2, continuation);
        this.$msg = str;
        this.this$0 = guildFileViewer;
        this.$payload = obj;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new GuildFileViewer$updateBindState$1(this.$msg, this.this$0, this.$payload, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            String str = this.$msg;
            b.GuildMsgItemStatusPayload guildMsgItemStatusPayload = null;
            FileTransNotifyInfo fileTransNotifyInfo = null;
            if (Intrinsics.areEqual(str, "rich_media_state")) {
                GuildFileViewer guildFileViewer = this.this$0;
                Object obj2 = this.$payload;
                if (obj2 instanceof FileTransNotifyInfo) {
                    fileTransNotifyInfo = (FileTransNotifyInfo) obj2;
                }
                guildFileViewer.r(fileTransNotifyInfo);
            } else if (Intrinsics.areEqual(str, "msg_send_status_state")) {
                GuildFileViewer guildFileViewer2 = this.this$0;
                Object obj3 = this.$payload;
                if (obj3 instanceof b.GuildMsgItemStatusPayload) {
                    guildMsgItemStatusPayload = (b.GuildMsgItemStatusPayload) obj3;
                }
                guildFileViewer2.o(guildMsgItemStatusPayload);
            }
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((GuildFileViewer$updateBindState$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
