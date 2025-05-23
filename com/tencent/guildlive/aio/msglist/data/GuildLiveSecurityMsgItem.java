package com.tencent.guildlive.aio.msglist.data;

import com.tencent.aio.data.msglist.a;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/guildlive/aio/msglist/data/GuildLiveSecurityMsgItem;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "targetMsgRecord", "Lcom/tencent/aio/data/msglist/a;", "cloneNewInstanceWithMsgRecord", "cloneNewInstance", "", "getMsgId", "getMsgSeq", "", "getViewType", "target", "", "isSameContent", "isSameItem", "isSelf", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;)V", "aio-guild-live_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildLiveSecurityMsgItem extends GuildMsgItem {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildLiveSecurityMsgItem(@NotNull MsgRecord msgRecord) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    @NotNull
    public a cloneNewInstance() {
        return new GuildLiveSecurityMsgItem(getMsgRecord());
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem
    @NotNull
    public a cloneNewInstanceWithMsgRecord(@NotNull MsgRecord targetMsgRecord) {
        Intrinsics.checkNotNullParameter(targetMsgRecord, "targetMsgRecord");
        return new GuildLiveSecurityMsgItem(targetMsgRecord);
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public long getMsgId() {
        return getMsgRecord().msgId;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public long getMsgSeq() {
        return getMsgRecord().msgSeq;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        return com.tencent.mobileqq.guild.message.a.f230108a.b();
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameContent(@NotNull a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return target instanceof GuildLiveSecurityMsgItem;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameItem(@NotNull a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        return target instanceof GuildLiveSecurityMsgItem;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSelf() {
        return false;
    }
}
