package com.tencent.qqnt.kernelgpro.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class FirstViewDirectMsgNotifyInfo {
    public String CmtId;
    public int DirectMsgSwitch;
    public ArrayList<Integer> FeedAtTypes;
    public int FeedCommentsSwitch;
    public String FeedId;
    public int FeedType;
    public long FeedsChannelId;
    public long FeedsEventIsValid;
    public byte[] FeedsEventLastId;
    public long FeedsEventLastTime;
    public long FeedsEventNnreadNum;
    public long FeedsGuildId;
    public boolean FeedsNeedNofity;
    public int GuildFaceSeq;
    public String GuildName;
    public String JumpSchema;
    public String ReplyId;
    public MsgAbstract msgAbstract;
    public boolean needPushNotify;

    public FirstViewDirectMsgNotifyInfo() {
        this.msgAbstract = new MsgAbstract();
        this.FeedsEventLastId = new byte[0];
        this.FeedAtTypes = new ArrayList<>();
        this.FeedId = "";
        this.CmtId = "";
        this.ReplyId = "";
        this.JumpSchema = "";
        this.GuildName = "";
    }

    public String getCmtId() {
        return this.CmtId;
    }

    public int getDirectMsgSwitch() {
        return this.DirectMsgSwitch;
    }

    public ArrayList<Integer> getFeedAtTypes() {
        return this.FeedAtTypes;
    }

    public int getFeedCommentsSwitch() {
        return this.FeedCommentsSwitch;
    }

    public String getFeedId() {
        return this.FeedId;
    }

    public int getFeedType() {
        return this.FeedType;
    }

    public long getFeedsChannelId() {
        return this.FeedsChannelId;
    }

    public long getFeedsEventIsValid() {
        return this.FeedsEventIsValid;
    }

    public byte[] getFeedsEventLastId() {
        return this.FeedsEventLastId;
    }

    public long getFeedsEventLastTime() {
        return this.FeedsEventLastTime;
    }

    public long getFeedsEventNnreadNum() {
        return this.FeedsEventNnreadNum;
    }

    public long getFeedsGuildId() {
        return this.FeedsGuildId;
    }

    public boolean getFeedsNeedNofity() {
        return this.FeedsNeedNofity;
    }

    public int getGuildFaceSeq() {
        return this.GuildFaceSeq;
    }

    public String getGuildName() {
        return this.GuildName;
    }

    public String getJumpSchema() {
        return this.JumpSchema;
    }

    public MsgAbstract getMsgAbstract() {
        return this.msgAbstract;
    }

    public boolean getNeedPushNotify() {
        return this.needPushNotify;
    }

    public String getReplyId() {
        return this.ReplyId;
    }

    public String toString() {
        return "FirstViewDirectMsgNotifyInfo{DirectMsgSwitch=" + this.DirectMsgSwitch + ",FeedsEventIsValid=" + this.FeedsEventIsValid + ",FeedsEventNnreadNum=" + this.FeedsEventNnreadNum + ",msgAbstract=" + this.msgAbstract + ",FeedsEventLastTime=" + this.FeedsEventLastTime + ",FeedsEventLastId=" + this.FeedsEventLastId + ",FeedsNeedNofity=" + this.FeedsNeedNofity + ",FeedsGuildId=" + this.FeedsGuildId + ",FeedsChannelId=" + this.FeedsChannelId + ",FeedCommentsSwitch=" + this.FeedCommentsSwitch + ",FeedAtTypes=" + this.FeedAtTypes + ",FeedId=" + this.FeedId + ",CmtId=" + this.CmtId + ",ReplyId=" + this.ReplyId + ",JumpSchema=" + this.JumpSchema + ",needPushNotify=" + this.needPushNotify + ",FeedType=" + this.FeedType + ",GuildName=" + this.GuildName + ",GuildFaceSeq=" + this.GuildFaceSeq + ",}";
    }

    public FirstViewDirectMsgNotifyInfo(int i3, long j3, long j16, MsgAbstract msgAbstract, long j17, byte[] bArr, boolean z16, long j18, long j19, int i16, ArrayList<Integer> arrayList, String str, String str2, String str3, String str4) {
        this.msgAbstract = new MsgAbstract();
        this.FeedsEventLastId = new byte[0];
        new ArrayList();
        this.GuildName = "";
        this.DirectMsgSwitch = i3;
        this.FeedsEventIsValid = j3;
        this.FeedsEventNnreadNum = j16;
        this.msgAbstract = msgAbstract;
        this.FeedsEventLastTime = j17;
        this.FeedsEventLastId = bArr;
        this.FeedsNeedNofity = z16;
        this.FeedsGuildId = j18;
        this.FeedsChannelId = j19;
        this.FeedCommentsSwitch = i16;
        this.FeedAtTypes = arrayList;
        this.FeedId = str;
        this.CmtId = str2;
        this.ReplyId = str3;
        this.JumpSchema = str4;
    }
}
