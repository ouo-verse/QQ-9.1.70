package com.tencent.mobileqq.qqguildsdk.data.genc;

import com.tencent.qqnt.kernelgpro.nativeinterface.GProQQMsgListGuild;

/* loaded from: classes17.dex */
public class GGProQQMsgListGuild implements IGProQQMsgListGuild {
    public final GProQQMsgListGuild mInfo;

    public GGProQQMsgListGuild(GProQQMsgListGuild gProQQMsgListGuild) {
        this.mInfo = gProQQMsgListGuild;
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild
    public long getAvatarSeq() {
        return this.mInfo.getAvatarSeq();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild
    public long getGuildId() {
        return this.mInfo.getGuildId();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild
    public String getGuildName() {
        return this.mInfo.getGuildName();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild
    public long getTopTimestamp() {
        return this.mInfo.getTopTimestamp();
    }

    @Override // com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild
    public String toString() {
        return this.mInfo.toString();
    }
}
