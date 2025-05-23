package com.tencent.guild.aio.msglist.welcome;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u000e\u0012\u0006\u0010\u0018\u001a\u00020\u000e\u0012\u0006\u0010\u001b\u001a\u00020\u000e\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u000bH\u0016R\"\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0010\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\"\u0010\u0018\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\"\u0010\u001b\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\"\u0010\u001f\u001a\u00020\u001e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/guild/aio/msglist/welcome/GuildDirectRobotWelcomeMsgItem;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/aio/data/msglist/a;", "cloneNewInstance", "", "getViewType", "", "isSelf", "target", "isSameContent", "isSameItem", "", "getMsgSeq", "getMsgId", "", "channelId", "Ljava/lang/String;", "getChannelId", "()Ljava/lang/String;", "setChannelId", "(Ljava/lang/String;)V", "guildId", "getGuildId", "setGuildId", "robotName", "getRobotName", "setRobotName", "robotTid", "getRobotTid", "setRobotTid", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/api/runtime/a;", "getAioContext", "()Lcom/tencent/aio/api/runtime/a;", "setAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/aio/api/runtime/a;)V", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildDirectRobotWelcomeMsgItem extends GuildMsgItem {

    @NotNull
    private com.tencent.aio.api.runtime.a aioContext;

    @NotNull
    private String channelId;

    @NotNull
    private String guildId;

    @NotNull
    private String robotName;

    @NotNull
    private String robotTid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDirectRobotWelcomeMsgItem(@NotNull MsgRecord msgRecord, @NotNull String channelId, @NotNull String guildId, @NotNull String robotName, @NotNull String robotTid, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(robotTid, "robotTid");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.channelId = channelId;
        this.guildId = guildId;
        this.robotName = robotName;
        this.robotTid = robotTid;
        this.aioContext = aioContext;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    @NotNull
    public com.tencent.aio.data.msglist.a cloneNewInstance() {
        return new GuildDirectRobotWelcomeMsgItem(getMsgRecord(), this.channelId, this.guildId, this.robotName, this.robotTid, this.aioContext);
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a getAioContext() {
        return this.aioContext;
    }

    @NotNull
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public long getMsgId() {
        return getMsgRecord().msgId;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public long getMsgSeq() {
        return 0L;
    }

    @NotNull
    public final String getRobotName() {
        return this.robotName;
    }

    @NotNull
    public final String getRobotTid() {
        return this.robotTid;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public int getViewType() {
        return 71;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameContent(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof GuildDirectRobotWelcomeMsgItem)) {
            return false;
        }
        GuildDirectRobotWelcomeMsgItem guildDirectRobotWelcomeMsgItem = (GuildDirectRobotWelcomeMsgItem) target;
        if (!Intrinsics.areEqual(this.guildId, guildDirectRobotWelcomeMsgItem.guildId) || !Intrinsics.areEqual(this.channelId, guildDirectRobotWelcomeMsgItem.channelId) || !Intrinsics.areEqual(this.robotTid, guildDirectRobotWelcomeMsgItem.robotTid)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameItem(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof GuildDirectRobotWelcomeMsgItem)) {
            return false;
        }
        GuildDirectRobotWelcomeMsgItem guildDirectRobotWelcomeMsgItem = (GuildDirectRobotWelcomeMsgItem) target;
        if (!Intrinsics.areEqual(this.guildId, guildDirectRobotWelcomeMsgItem.guildId) || !Intrinsics.areEqual(this.channelId, guildDirectRobotWelcomeMsgItem.channelId)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSelf() {
        return false;
    }

    public final void setAioContext(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.aioContext = aVar;
    }

    public final void setChannelId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.channelId = str;
    }

    public final void setGuildId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.guildId = str;
    }

    public final void setRobotName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.robotName = str;
    }

    public final void setRobotTid(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.robotTid = str;
    }
}
