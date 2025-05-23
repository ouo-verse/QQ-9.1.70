package com.tencent.guild.aio.util.ui;

import com.tencent.guild.aio.util.ui.e;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.RichDownLoadReq;
import com.tencent.qqnt.kernel.nativeinterface.RichMediaElementGetReq;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016R\u0017\u0010\u0012\u001a\u00020\u000e8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/guild/aio/util/ui/b;", "Lcom/tencent/guild/aio/util/ui/e;", "", "getSeq", "", "getMsgId", "b", "getMsgSeq", "a", "getChatType", "", "getSenderUin", "getPeerUin", "getGuildID", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "getMsgRecord", "()Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "I", "seq", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;I)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b implements e {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MsgRecord msgRecord;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int seq;

    public b(@NotNull MsgRecord msgRecord, int i3) {
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        this.msgRecord = msgRecord;
        this.seq = i3;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    public long a() {
        return this.msgRecord.msgTime;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    public long b() {
        return this.msgRecord.msgRandom;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    @NotNull
    public RichMediaElementGetReq c(int i3, int i16, @NotNull MsgElement msgElement) {
        return e.a.b(this, i3, i16, msgElement);
    }

    @Override // com.tencent.guild.aio.util.ui.e
    @NotNull
    public RichDownLoadReq d(int i3, int i16, @NotNull MsgElement msgElement) {
        return e.a.a(this, i3, i16, msgElement);
    }

    @Override // com.tencent.guild.aio.util.ui.e
    public int getChatType() {
        return this.msgRecord.chatType;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    @NotNull
    public String getGuildID() {
        String str = this.msgRecord.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.guildId");
        return str;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    public long getMsgId() {
        return this.msgRecord.msgId;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    public long getMsgSeq() {
        return this.msgRecord.msgSeq;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    @NotNull
    public String getPeerUin() {
        String str = this.msgRecord.peerUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
        return str;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    @NotNull
    public String getSenderUin() {
        String str = this.msgRecord.senderUid;
        Intrinsics.checkNotNullExpressionValue(str, "msgRecord.senderUid");
        return str;
    }

    @Override // com.tencent.guild.aio.util.ui.e
    public int getSeq() {
        return this.seq;
    }

    public /* synthetic */ b(MsgRecord msgRecord, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(msgRecord, (i16 & 2) != 0 ? GuildChatPicDownloader.f112420a.r().getAndIncrement() : i3);
    }
}
