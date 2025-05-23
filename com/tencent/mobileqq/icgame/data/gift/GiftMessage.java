package com.tencent.mobileqq.icgame.data.gift;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class GiftMessage implements Parcelable {
    public static final Parcelable.Creator<GiftMessage> CREATOR = new Parcelable.Creator<GiftMessage>() { // from class: com.tencent.mobileqq.icgame.data.gift.GiftMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GiftMessage createFromParcel(Parcel parcel) {
            return new GiftMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GiftMessage[] newArray(int i3) {
            return new GiftMessage[i3];
        }
    };
    public int allComboCnt;
    public long batchSendCnt;
    public boolean comboOver;
    public long comboSeq;
    public int effectLevel;
    public int giftID;
    public String giftName;
    public int giftNum;
    public long giftPrice;
    public int giftType;
    public String liveExtMsg;
    public int materialID;
    public long receiver;
    public String receiverHead;
    public String receiverNick;
    public long sender;
    public String senderHead;
    public String senderNick;

    public GiftMessage() {
        this.senderNick = "";
        this.giftName = "";
        this.receiverNick = "";
        this.receiverHead = "";
        this.comboSeq = 0L;
        this.allComboCnt = 0;
        this.receiver = 0L;
        this.comboOver = false;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getSceneId() {
        try {
            return new JSONObject(this.liveExtMsg).getInt("scene_id");
        } catch (Exception e16) {
            QLog.e("GiftMessage", 1, "parse parseSceneId error, msg:" + e16.getMessage());
            return 0;
        }
    }

    public String toString() {
        return "GiftMessage{giftType=" + this.giftType + ", giftID=" + this.giftID + ", giftNum=" + this.giftNum + ", sender=" + LogUtil.getSafePrintUin(this.sender + "") + ", senderNick='" + this.senderNick + "', materialID=" + this.materialID + ", effectLevel=" + this.effectLevel + ", giftName='" + this.giftName + "', senderHead='" + this.senderHead + "', receiverNick='" + this.receiverNick + "', receiverHead='" + this.receiverHead + "', comboSeq=" + this.comboSeq + ", allComboCnt=" + this.allComboCnt + ", receiver=" + LogUtil.getSafePrintUin(this.receiver + "") + ", comboOver=" + this.comboOver + ", liveExtMsg=" + this.liveExtMsg + ", giftPrice=" + this.giftPrice + ", batchSendCnt=" + this.batchSendCnt + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.giftType);
        parcel.writeInt(this.giftID);
        parcel.writeInt(this.giftNum);
        parcel.writeLong(this.sender);
        parcel.writeString(this.senderNick);
        parcel.writeInt(this.materialID);
        parcel.writeInt(this.effectLevel);
        parcel.writeString(this.giftName);
        parcel.writeString(this.senderHead);
        parcel.writeString(this.receiverNick);
        parcel.writeString(this.receiverHead);
        parcel.writeLong(this.comboSeq);
        parcel.writeInt(this.allComboCnt);
        parcel.writeLong(this.receiver);
        parcel.writeByte(this.comboOver ? (byte) 1 : (byte) 0);
        parcel.writeString(this.liveExtMsg);
        parcel.writeLong(this.giftPrice);
        parcel.writeLong(this.batchSendCnt);
    }

    protected GiftMessage(Parcel parcel) {
        this.senderNick = "";
        this.giftName = "";
        this.receiverNick = "";
        this.receiverHead = "";
        this.comboSeq = 0L;
        this.allComboCnt = 0;
        this.receiver = 0L;
        this.comboOver = false;
        this.giftType = parcel.readInt();
        this.giftID = parcel.readInt();
        this.giftNum = parcel.readInt();
        this.sender = parcel.readLong();
        this.senderNick = parcel.readString();
        this.materialID = parcel.readInt();
        this.effectLevel = parcel.readInt();
        this.giftName = parcel.readString();
        this.senderHead = parcel.readString();
        this.receiverNick = parcel.readString();
        this.receiverHead = parcel.readString();
        this.comboSeq = parcel.readLong();
        this.allComboCnt = parcel.readInt();
        this.receiver = parcel.readLong();
        this.comboOver = parcel.readByte() != 0;
        this.liveExtMsg = parcel.readString();
        this.giftPrice = parcel.readLong();
        this.batchSendCnt = parcel.readLong();
    }
}
