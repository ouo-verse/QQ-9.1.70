package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class SearchMsgItem {
    public String fieldText;
    public int fieldType;
    public ArrayList<SearchHitInfo> hitsInfo;
    public ArrayList<MsgAbstract> msgAbstract;
    public long msgId;
    public MsgRecord msgRecord;
    public long msgSeq;
    public long msgTime;
    public int prefixLen;
    public String senderCard;
    public ArrayList<SearchHitInfo> senderCardHits;
    public String senderNick;
    public ArrayList<SearchHitInfo> senderNickHits;
    public String senderRemark;
    public ArrayList<SearchHitInfo> senderRemarkHits;
    public String senderUid;
    public long senderUin;

    public SearchMsgItem() {
        this.senderUid = "";
        this.senderNick = "";
        this.senderNickHits = new ArrayList<>();
        this.senderRemark = "";
        this.senderRemarkHits = new ArrayList<>();
        this.senderCard = "";
        this.senderCardHits = new ArrayList<>();
        this.fieldText = "";
        this.hitsInfo = new ArrayList<>();
        this.msgAbstract = new ArrayList<>();
    }

    public String getFieldText() {
        return this.fieldText;
    }

    public int getFieldType() {
        return this.fieldType;
    }

    public ArrayList<SearchHitInfo> getHitsInfo() {
        return this.hitsInfo;
    }

    public ArrayList<MsgAbstract> getMsgAbstract() {
        return this.msgAbstract;
    }

    public long getMsgId() {
        return this.msgId;
    }

    public MsgRecord getMsgRecord() {
        return this.msgRecord;
    }

    public long getMsgSeq() {
        return this.msgSeq;
    }

    public long getMsgTime() {
        return this.msgTime;
    }

    public int getPrefixLen() {
        return this.prefixLen;
    }

    public String getSenderCard() {
        return this.senderCard;
    }

    public ArrayList<SearchHitInfo> getSenderCardHits() {
        return this.senderCardHits;
    }

    public String getSenderNick() {
        return this.senderNick;
    }

    public ArrayList<SearchHitInfo> getSenderNickHits() {
        return this.senderNickHits;
    }

    public String getSenderRemark() {
        return this.senderRemark;
    }

    public ArrayList<SearchHitInfo> getSenderRemarkHits() {
        return this.senderRemarkHits;
    }

    public String getSenderUid() {
        return this.senderUid;
    }

    public long getSenderUin() {
        return this.senderUin;
    }

    public String toString() {
        return "SearchMsgItem{msgId=" + this.msgId + ",msgSeq=" + this.msgSeq + ",msgTime=" + this.msgTime + ",senderUid=" + this.senderUid + ",senderUin=" + this.senderUin + ",senderNick=" + this.senderNick + ",senderNickHits=" + this.senderNickHits + ",senderRemark=" + this.senderRemark + ",senderRemarkHits=" + this.senderRemarkHits + ",senderCard=" + this.senderCard + ",senderCardHits=" + this.senderCardHits + ",fieldType=" + this.fieldType + ",fieldText=" + this.fieldText + ",prefixLen=" + this.prefixLen + ",hitsInfo=" + this.hitsInfo + ",msgAbstract=" + this.msgAbstract + ",msgRecord=" + this.msgRecord + ",}";
    }

    public SearchMsgItem(long j3, long j16, long j17, String str, long j18, String str2, ArrayList<SearchHitInfo> arrayList, String str3, ArrayList<SearchHitInfo> arrayList2, String str4, ArrayList<SearchHitInfo> arrayList3, int i3, String str5, int i16, ArrayList<SearchHitInfo> arrayList4, ArrayList<MsgAbstract> arrayList5, MsgRecord msgRecord) {
        this.senderUid = "";
        this.senderNick = "";
        this.senderNickHits = new ArrayList<>();
        this.senderRemark = "";
        this.senderRemarkHits = new ArrayList<>();
        this.senderCard = "";
        this.senderCardHits = new ArrayList<>();
        this.fieldText = "";
        this.hitsInfo = new ArrayList<>();
        new ArrayList();
        this.msgId = j3;
        this.msgSeq = j16;
        this.msgTime = j17;
        this.senderUid = str;
        this.senderUin = j18;
        this.senderNick = str2;
        this.senderNickHits = arrayList;
        this.senderRemark = str3;
        this.senderRemarkHits = arrayList2;
        this.senderCard = str4;
        this.senderCardHits = arrayList3;
        this.fieldType = i3;
        this.fieldText = str5;
        this.prefixLen = i16;
        this.hitsInfo = arrayList4;
        this.msgAbstract = arrayList5;
        this.msgRecord = msgRecord;
    }
}
