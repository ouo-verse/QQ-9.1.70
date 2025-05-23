package cooperation.qzone.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.remote.IActionListener;

/* compiled from: P */
/* loaded from: classes28.dex */
public class SendMsg implements Parcelable {
    public static final Parcelable.Creator<SendMsg> CREATOR = new Parcelable.Creator<SendMsg>() { // from class: cooperation.qzone.remote.SendMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SendMsg createFromParcel(Parcel parcel) {
            return new SendMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SendMsg[] newArray(int i3) {
            return new SendMsg[i3];
        }
    };
    private static final String tag = "SendMsg";
    public IActionListener actionListener;
    int requestId;
    public String serviceCmd;
    public final Bundle extraData = new Bundle();
    long timeout = -1;
    long sendTime = -1;

    public SendMsg(String str) {
        this.serviceCmd = str;
    }

    private void readFromParcel(Parcel parcel) {
        try {
            this.requestId = parcel.readInt();
            this.serviceCmd = parcel.readString();
            this.timeout = parcel.readLong();
            this.extraData.clear();
            this.extraData.putAll(parcel.readBundle(getClass().getClassLoader()));
            this.actionListener = IActionListener.Stub.asInterface(parcel.readStrongBinder());
        } catch (RuntimeException e16) {
            QLog.w(tag, 1, "readFromParcel RuntimeException", e16);
            throw e16;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public IActionListener getActionListener() {
        return this.actionListener;
    }

    public Bundle getExtraData() {
        return this.extraData;
    }

    public int getRequestId() {
        return this.requestId;
    }

    public long getSendTime() {
        return this.sendTime;
    }

    public String getServiceCmd() {
        return this.serviceCmd;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public byte[] getWupBuffer() {
        return this.extraData.getByteArray(ServiceConst.EXTRA_WUP);
    }

    public boolean isNeedCallback() {
        return this.extraData.getBoolean(ServiceConst.EXTRA_NEEDCALLBACK, true);
    }

    public void putWupBuffer(byte[] bArr) {
        this.extraData.putByteArray(ServiceConst.EXTRA_WUP, bArr);
    }

    public void setNeedCallback(boolean z16) {
        this.extraData.putBoolean(ServiceConst.EXTRA_NEEDCALLBACK, z16);
    }

    public void setRequestId(int i3) {
        this.requestId = i3;
    }

    public void setSendTime(long j3) {
        this.sendTime = j3;
    }

    public void setTimeout(long j3) {
        this.timeout = j3;
    }

    public String toString() {
        return "SendMsg appSeq:" + this.requestId + " serviceCmd:" + this.serviceCmd + " timeout:" + this.timeout;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeInt(this.requestId);
            parcel.writeString(this.serviceCmd);
            parcel.writeLong(this.timeout);
            parcel.writeBundle(this.extraData);
            parcel.writeStrongInterface(this.actionListener);
        } catch (RuntimeException e16) {
            QLog.w(tag, 1, "writeToParcel RuntimeException", e16);
            throw e16;
        }
    }

    public SendMsg(Parcel parcel) {
        readFromParcel(parcel);
    }
}
