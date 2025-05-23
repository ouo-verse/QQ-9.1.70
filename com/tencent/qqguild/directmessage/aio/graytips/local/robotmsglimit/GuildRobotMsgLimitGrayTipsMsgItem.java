package com.tencent.qqguild.directmessage.aio.graytips.local.robotmsglimit;

import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\u0006\u0010\u0014\u001a\u00020\r\u0012\u0006\u0010\u0017\u001a\u00020\r\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u000f\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\"\u0010\u0017\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006%"}, d2 = {"Lcom/tencent/qqguild/directmessage/aio/graytips/local/robotmsglimit/GuildRobotMsgLimitGrayTipsMsgItem;", "Lcom/tencent/guild/api/data/msglist/GuildMsgItem;", "Lcom/tencent/aio/data/msglist/a;", "cloneNewInstance", "", "getViewType", "", "isSelf", "target", "isSameContent", "isSameItem", "", "getMsgId", "", "guildId", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "robotTid", "getRobotTid", "setRobotTid", "robotName", "getRobotName", "setRobotName", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/api/runtime/a;", "getAioContext", "()Lcom/tencent/aio/api/runtime/a;", "setAioContext", "(Lcom/tencent/aio/api/runtime/a;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/aio/api/runtime/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public final class GuildRobotMsgLimitGrayTipsMsgItem extends GuildMsgItem {

    @NotNull
    private com.tencent.aio.api.runtime.a aioContext;

    @NotNull
    private String guildId;

    @NotNull
    private String robotName;

    @NotNull
    private String robotTid;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRobotMsgLimitGrayTipsMsgItem(@NotNull MsgRecord msgRecord, @NotNull String guildId, @NotNull String robotTid, @NotNull String robotName, @NotNull com.tencent.aio.api.runtime.a aioContext) {
        super(msgRecord);
        Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(robotTid, "robotTid");
        Intrinsics.checkNotNullParameter(robotName, "robotName");
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        this.guildId = guildId;
        this.robotTid = robotTid;
        this.robotName = robotName;
        this.aioContext = aioContext;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    @NotNull
    public com.tencent.aio.data.msglist.a cloneNewInstance() {
        return new GuildRobotMsgLimitGrayTipsMsgItem(getMsgRecord(), this.guildId, this.robotTid, this.robotName, this.aioContext);
    }

    @NotNull
    public final com.tencent.aio.api.runtime.a getAioContext() {
        return this.aioContext;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public long getMsgId() {
        return getMsgRecord().msgId;
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
        return 54;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameContent(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof GuildRobotMsgLimitGrayTipsMsgItem)) {
            return false;
        }
        GuildRobotMsgLimitGrayTipsMsgItem guildRobotMsgLimitGrayTipsMsgItem = (GuildRobotMsgLimitGrayTipsMsgItem) target;
        if (!Intrinsics.areEqual(this.guildId, guildRobotMsgLimitGrayTipsMsgItem.guildId) || !Intrinsics.areEqual(this.robotTid, guildRobotMsgLimitGrayTipsMsgItem.robotTid)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSameItem(@NotNull com.tencent.aio.data.msglist.a target) {
        Intrinsics.checkNotNullParameter(target, "target");
        if (target instanceof GuildRobotMsgLimitGrayTipsMsgItem) {
            return Intrinsics.areEqual(this.guildId, ((GuildRobotMsgLimitGrayTipsMsgItem) target).guildId);
        }
        return false;
    }

    @Override // com.tencent.guild.api.data.msglist.GuildMsgItem, com.tencent.aio.data.msglist.a
    public boolean isSelf() {
        return false;
    }

    public final void setAioContext(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<set-?>");
        this.aioContext = aVar;
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
