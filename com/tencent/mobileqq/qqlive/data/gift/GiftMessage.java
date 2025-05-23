package com.tencent.mobileqq.qqlive.data.gift;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import mqq.util.LogUtil;
import mt3.e;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes17.dex */
public class GiftMessage implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<GiftMessage> CREATOR;
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(56677);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            CREATOR = new Parcelable.Creator<GiftMessage>() { // from class: com.tencent.mobileqq.qqlive.data.gift.GiftMessage.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GiftMessage createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new GiftMessage(parcel) : (GiftMessage) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public GiftMessage[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new GiftMessage[i3] : (GiftMessage[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public GiftMessage() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.senderNick = "";
        this.giftName = "";
        this.receiverNick = "";
        this.receiverHead = "";
        this.comboSeq = 0L;
        this.allComboCnt = 0;
        this.receiver = 0L;
        this.comboOver = false;
    }

    public static GiftMessage from(e eVar) {
        GiftMessage giftMessage = new GiftMessage();
        giftMessage.giftID = eVar.f417551b;
        giftMessage.giftNum = eVar.f417553d;
        giftMessage.giftType = eVar.f417550a;
        giftMessage.materialID = eVar.f417556g;
        giftMessage.sender = eVar.f417554e;
        giftMessage.senderNick = eVar.f417555f;
        giftMessage.effectLevel = eVar.f417557h;
        giftMessage.giftName = eVar.f417552c;
        giftMessage.senderHead = eVar.f417558i;
        giftMessage.receiverNick = eVar.f417559j;
        giftMessage.receiverHead = eVar.f417560k;
        giftMessage.comboSeq = eVar.f417561l;
        giftMessage.allComboCnt = eVar.f417562m;
        giftMessage.comboOver = eVar.f417563n;
        giftMessage.liveExtMsg = eVar.f417564o;
        giftMessage.receiver = eVar.f417565p;
        giftMessage.giftPrice = eVar.f417566q;
        giftMessage.batchSendCnt = eVar.f417567r;
        return giftMessage;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return 0;
    }

    public int getSceneId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        try {
            return new JSONObject(this.liveExtMsg).getInt("scene_id");
        } catch (Exception e16) {
            QLog.e("GiftMessage", 1, "parse parseSceneId error, msg:" + e16.getMessage());
            return 0;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return "GiftMessage{giftType=" + this.giftType + ", giftID=" + this.giftID + ", giftNum=" + this.giftNum + ", sender=" + LogUtil.getSafePrintUin(this.sender + "") + ", senderNick='" + this.senderNick + "', materialID=" + this.materialID + ", effectLevel=" + this.effectLevel + ", giftName='" + this.giftName + "', senderHead='" + this.senderHead + "', receiverNick='" + this.receiverNick + "', receiverHead='" + this.receiverHead + "', comboSeq=" + this.comboSeq + ", allComboCnt=" + this.allComboCnt + ", receiver=" + LogUtil.getSafePrintUin(this.receiver + "") + ", comboOver=" + this.comboOver + ", liveExtMsg=" + this.liveExtMsg + ", giftPrice=" + this.giftPrice + ", batchSendCnt=" + this.batchSendCnt + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
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
