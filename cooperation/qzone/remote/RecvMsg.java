package cooperation.qzone.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class RecvMsg implements Parcelable, Cloneable {
    public static final Parcelable.Creator<RecvMsg> CREATOR = new Parcelable.Creator<RecvMsg>() { // from class: cooperation.qzone.remote.RecvMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecvMsg createFromParcel(Parcel parcel) {
            return new RecvMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecvMsg[] newArray(int i3) {
            return new RecvMsg[i3];
        }
    };
    public static final String SSOSEQ_KEY = "_ssoSeqKey";
    private static final String tag = "RecvMsg";
    public Bundle extraData;
    public int reqSeq;
    public int resultCode;
    public String serviceCmd;
    public String tmpFileName;

    public RecvMsg() {
        this.extraData = new Bundle();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getBusinessFailMsg() {
        if (this.extraData.containsKey("error")) {
            return this.extraData.getString("error");
        }
        return null;
    }

    public int getMsgResultCode() {
        return this.resultCode;
    }

    public int getRequestId() {
        return this.reqSeq;
    }

    public int getRequestSsoSeq() {
        return this.extraData.getInt(SSOSEQ_KEY, -1);
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getServiceCmd() {
        return this.serviceCmd;
    }

    public byte[] getWupBuffer() {
        if (this.extraData.containsKey(ServiceConst.EXTRA_WUP)) {
            return (byte[]) this.extraData.get(ServiceConst.EXTRA_WUP);
        }
        return null;
    }

    public boolean isSuccess() {
        if (this.resultCode == 1000) {
            return true;
        }
        return false;
    }

    public void putWupBuffer(byte[] bArr) {
        this.extraData.putByteArray(ServiceConst.EXTRA_WUP, bArr);
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.reqSeq = parcel.readInt();
            this.resultCode = parcel.readInt();
            this.serviceCmd = parcel.readString();
            this.tmpFileName = parcel.readString();
            this.extraData.clear();
            this.extraData.putAll(parcel.readBundle(getClass().getClassLoader()));
        } catch (RuntimeException e16) {
            QLog.w(tag, 1, "readFromParcel RuntimeException", e16);
            throw e16;
        }
    }

    public void setBusinessFail() {
        this.resultCode = 1001;
    }

    public void setMsgFail() {
        this.resultCode = 1001;
    }

    public void setMsgResult(int i3) {
        this.resultCode = i3;
    }

    public void setMsgSuccess() {
        this.resultCode = 1000;
    }

    public void setRequestId(int i3) {
        this.reqSeq = i3;
    }

    public void setRequestSsoSeq(int i3) {
        this.extraData.putInt(SSOSEQ_KEY, i3);
    }

    public void setServiceCmd(String str) {
        this.serviceCmd = str;
    }

    public String toString() {
        return "RecvMsg ssoseq:" + getRequestSsoSeq() + " resultCode:" + this.resultCode + " serviceCmd:" + this.serviceCmd + " appSeq:" + this.reqSeq;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeInt(this.reqSeq);
            parcel.writeInt(this.resultCode);
            parcel.writeString(this.serviceCmd);
            parcel.writeString(this.tmpFileName);
            parcel.writeBundle(this.extraData);
        } catch (RuntimeException e16) {
            QLog.w(tag, 1, "writeToParcel RuntimeException", e16);
            throw e16;
        }
    }

    public void setBusinessFail(String str) {
        this.resultCode = 1001;
        this.extraData.putString("error", str);
    }

    public RecvMsg(String str) {
        this(-1, str);
    }

    public RecvMsg(int i3, String str) {
        this.extraData = new Bundle();
        this.resultCode = 1001;
        this.reqSeq = i3;
        this.serviceCmd = str;
    }

    public void setBusinessFail(int i3, String str) {
        this.resultCode = i3;
        this.extraData.putString("error", str);
    }

    public RecvMsg(Parcel parcel) {
        this.extraData = new Bundle();
        readFromParcel(parcel);
    }
}
