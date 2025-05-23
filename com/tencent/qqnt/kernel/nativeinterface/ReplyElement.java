package com.tencent.qqnt.kernel.nativeinterface;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class ReplyElement implements IKernelModel, Serializable {
    public String anonymousNickName;
    public Integer originalMsgState;
    public long replayMsgId;
    public Long replayMsgRootCommentCnt;
    public Long replayMsgRootMsgId;
    public Long replayMsgRootSeq;
    public Long replayMsgSeq;
    public Long replyMsgClientSeq;
    public int replyMsgRevokeType;
    public Long replyMsgTime;
    public Long senderUid;
    public String senderUidStr;
    long serialVersionUID;
    public boolean sourceMsgExpired;
    public Long sourceMsgIdInRecords;
    public boolean sourceMsgIsIncPic;
    public String sourceMsgText;
    public ArrayList<ReplyAbsElement> sourceMsgTextElems;

    public ReplyElement() {
        this.serialVersionUID = 1L;
        this.sourceMsgTextElems = new ArrayList<>();
    }

    public String getAnonymousNickName() {
        return this.anonymousNickName;
    }

    public Integer getOriginalMsgState() {
        return this.originalMsgState;
    }

    public long getReplayMsgId() {
        return this.replayMsgId;
    }

    public Long getReplayMsgRootCommentCnt() {
        return this.replayMsgRootCommentCnt;
    }

    public Long getReplayMsgRootMsgId() {
        return this.replayMsgRootMsgId;
    }

    public Long getReplayMsgRootSeq() {
        return this.replayMsgRootSeq;
    }

    public Long getReplayMsgSeq() {
        return this.replayMsgSeq;
    }

    public Long getReplyMsgClientSeq() {
        return this.replyMsgClientSeq;
    }

    public int getReplyMsgRevokeType() {
        return this.replyMsgRevokeType;
    }

    public Long getReplyMsgTime() {
        return this.replyMsgTime;
    }

    public Long getSenderUid() {
        return this.senderUid;
    }

    public String getSenderUidStr() {
        return this.senderUidStr;
    }

    public boolean getSourceMsgExpired() {
        return this.sourceMsgExpired;
    }

    public Long getSourceMsgIdInRecords() {
        return this.sourceMsgIdInRecords;
    }

    public boolean getSourceMsgIsIncPic() {
        return this.sourceMsgIsIncPic;
    }

    public String getSourceMsgText() {
        return this.sourceMsgText;
    }

    public ArrayList<ReplyAbsElement> getSourceMsgTextElems() {
        return this.sourceMsgTextElems;
    }

    public void setAnonymousNickName(String str) {
        this.anonymousNickName = str;
    }

    public void setOriginalMsgState(Integer num) {
        this.originalMsgState = num;
    }

    public void setReplayMsgId(long j3) {
        this.replayMsgId = j3;
    }

    public void setReplayMsgRootCommentCnt(Long l3) {
        this.replayMsgRootCommentCnt = l3;
    }

    public void setReplayMsgRootMsgId(Long l3) {
        this.replayMsgRootMsgId = l3;
    }

    public void setReplayMsgRootSeq(Long l3) {
        this.replayMsgRootSeq = l3;
    }

    public void setReplayMsgSeq(Long l3) {
        this.replayMsgSeq = l3;
    }

    public void setReplyMsgClientSeq(Long l3) {
        this.replyMsgClientSeq = l3;
    }

    public void setReplyMsgRevokeType(int i3) {
        this.replyMsgRevokeType = i3;
    }

    public void setReplyMsgTime(Long l3) {
        this.replyMsgTime = l3;
    }

    public void setSenderUid(Long l3) {
        this.senderUid = l3;
    }

    public void setSenderUidStr(String str) {
        this.senderUidStr = str;
    }

    public void setSourceMsgExpired(boolean z16) {
        this.sourceMsgExpired = z16;
    }

    public void setSourceMsgIdInRecords(Long l3) {
        this.sourceMsgIdInRecords = l3;
    }

    public void setSourceMsgIsIncPic(boolean z16) {
        this.sourceMsgIsIncPic = z16;
    }

    public void setSourceMsgText(String str) {
        this.sourceMsgText = str;
    }

    public void setSourceMsgTextElems(ArrayList<ReplyAbsElement> arrayList) {
        this.sourceMsgTextElems = arrayList;
    }

    public String toString() {
        return "ReplyElement{replayMsgId=" + this.replayMsgId + ",replayMsgSeq=" + this.replayMsgSeq + ",replayMsgRootSeq=" + this.replayMsgRootSeq + ",replayMsgRootMsgId=" + this.replayMsgRootMsgId + ",replayMsgRootCommentCnt=" + this.replayMsgRootCommentCnt + ",sourceMsgIdInRecords=" + this.sourceMsgIdInRecords + ",sourceMsgText=" + this.sourceMsgText + ",sourceMsgTextElems=" + this.sourceMsgTextElems + ",senderUid=" + this.senderUid + ",senderUidStr=" + this.senderUidStr + ",replyMsgClientSeq=" + this.replyMsgClientSeq + ",replyMsgTime=" + this.replyMsgTime + ",replyMsgRevokeType=" + this.replyMsgRevokeType + ",sourceMsgIsIncPic=" + this.sourceMsgIsIncPic + ",sourceMsgExpired=" + this.sourceMsgExpired + ",anonymousNickName=" + this.anonymousNickName + ",originalMsgState=" + this.originalMsgState + ",}";
    }

    public ReplyElement(long j3, Long l3, Long l16, Long l17, Long l18, Long l19, String str, ArrayList<ReplyAbsElement> arrayList, Long l26, String str2, Long l27, Long l28, int i3, boolean z16, boolean z17, String str3, Integer num) {
        this.serialVersionUID = 1L;
        new ArrayList();
        this.replayMsgId = j3;
        this.replayMsgSeq = l3;
        this.replayMsgRootSeq = l16;
        this.replayMsgRootMsgId = l17;
        this.replayMsgRootCommentCnt = l18;
        this.sourceMsgIdInRecords = l19;
        this.sourceMsgText = str;
        this.sourceMsgTextElems = arrayList;
        this.senderUid = l26;
        this.senderUidStr = str2;
        this.replyMsgClientSeq = l27;
        this.replyMsgTime = l28;
        this.replyMsgRevokeType = i3;
        this.sourceMsgIsIncPic = z16;
        this.sourceMsgExpired = z17;
        this.anonymousNickName = str3;
        this.originalMsgState = num;
    }
}
