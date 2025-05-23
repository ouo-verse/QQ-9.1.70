package com.tencent.mobileqq.aio.utils;

import com.tencent.qqnt.kernel.nativeinterface.AnonymousExtInfo;
import com.tencent.qqnt.kernel.nativeinterface.FoldingInfo;
import com.tencent.qqnt.kernel.nativeinterface.GuildMedal;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a\u0012\u0010\u0003\u001a\u00020\u0000*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "", "newSendStatus", "a", "aio_api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class ak {
    @NotNull
    public static final MsgRecord a(@NotNull MsgRecord msgRecord, int i3) {
        Intrinsics.checkNotNullParameter(msgRecord, "<this>");
        GuildMedal guildMedal = new GuildMedal();
        guildMedal.startTime = 0L;
        guildMedal.endTime = 0L;
        guildMedal.url = "";
        guildMedal.desc = "";
        Unit unit = Unit.INSTANCE;
        return new MsgRecord(msgRecord.msgId, msgRecord.msgRandom, msgRecord.msgSeq, msgRecord.cntSeq, msgRecord.chatType, msgRecord.msgType, msgRecord.subMsgType, msgRecord.sendType, msgRecord.senderUid, msgRecord.peerUid, msgRecord.channelId, msgRecord.guildId, msgRecord.guildCode, msgRecord.fromUid, msgRecord.fromAppid, msgRecord.msgTime, msgRecord.msgMeta, i3, msgRecord.sendRemarkName, msgRecord.sendMemberName, msgRecord.sendNickName, msgRecord.guildName, msgRecord.channelName, msgRecord.elements, msgRecord.records, msgRecord.emojiLikesList, msgRecord.commentCnt, msgRecord.directMsgFlag, msgRecord.directMsgMembers, msgRecord.peerName, msgRecord.freqLimitInfo, msgRecord.editable, msgRecord.avatarMeta, msgRecord.avatarPendant, msgRecord.feedId, msgRecord.roleId, msgRecord.timeStamp, msgRecord.clientIdentityInfo, msgRecord.isImportMsg, msgRecord.atType, msgRecord.roleType, msgRecord.fromChannelRoleInfo, msgRecord.fromGuildRoleInfo, msgRecord.levelRoleInfo, msgRecord.recallTime, msgRecord.isOnlineMsg, msgRecord.generalFlags, 0L, 0, new FoldingInfo(), msgRecord.multiTransInfo, msgRecord.senderUin, msgRecord.peerUin, new HashMap(), new AnonymousExtInfo(), 0, 0, new byte[0], guildMedal, 0, new byte[0]);
    }
}
