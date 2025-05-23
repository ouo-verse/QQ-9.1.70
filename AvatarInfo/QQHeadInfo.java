package AvatarInfo;

import android.os.Parcel;
import android.os.Parcelable;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.avatarinfo.MultiHeadUrl;

/* compiled from: P */
/* loaded from: classes.dex */
public final class QQHeadInfo extends JceStruct implements Cloneable, Parcelable {
    public static final Parcelable.Creator<QQHeadInfo> CREATOR = new a();
    public byte apngFaceFlag;
    public byte cHeadType;
    public String downLoadUrl;
    public byte dstUsrType;
    public byte dwFaceFlgas;
    public long dwTimestamp;
    public byte dynamicZplanFaceFlag;
    public boolean enableZplanOutbound;
    public byte headLevel;
    public String headVerify;
    public int idType;
    public int originUsrType;
    public String phoneNum;
    public int sizeType;
    public byte staticZplanFaceFlag;
    public short systemHeadID;
    public long uin;
    public String zplanFaceBgUrl;
    public int zplanFaceClipPercent;

    /* compiled from: P */
    /* loaded from: classes.dex */
    class a implements Parcelable.Creator<QQHeadInfo> {
        a() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public QQHeadInfo createFromParcel(Parcel parcel) {
            QQHeadInfo qQHeadInfo = new QQHeadInfo();
            qQHeadInfo.readFromParcel(parcel);
            return qQHeadInfo;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public QQHeadInfo[] newArray(int i3) {
            return new QQHeadInfo[i3];
        }
    }

    public QQHeadInfo() {
        this.uin = 0L;
        this.dwTimestamp = 0L;
        this.cHeadType = (byte) 0;
        this.dstUsrType = (byte) 0;
        this.dwFaceFlgas = (byte) 0;
        this.downLoadUrl = "";
        this.systemHeadID = (short) 0;
        this.phoneNum = "";
        this.headVerify = "";
        this.apngFaceFlag = (byte) 0;
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.headLevel = (byte) 0;
        this.originUsrType = 0;
        this.sizeType = 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.qq.taf.jce.JceStruct
    public void readFrom(JceInputStream jceInputStream) {
        this.uin = jceInputStream.read(this.uin, 0, true);
        this.dwTimestamp = jceInputStream.read(this.dwTimestamp, 1, true);
        this.cHeadType = jceInputStream.read(this.cHeadType, 2, true);
        this.dstUsrType = jceInputStream.read(this.dstUsrType, 3, true);
        this.dwFaceFlgas = jceInputStream.read(this.dwFaceFlgas, 4, true);
        this.downLoadUrl = jceInputStream.readString(5, true);
        this.systemHeadID = jceInputStream.read(this.systemHeadID, 6, false);
        this.phoneNum = jceInputStream.readString(7, false);
    }

    public void readFromParcel(Parcel parcel) {
        this.uin = parcel.readLong();
        this.dwTimestamp = parcel.readLong();
        this.cHeadType = parcel.readByte();
        this.dstUsrType = parcel.readByte();
        this.dwFaceFlgas = parcel.readByte();
        this.downLoadUrl = parcel.readString();
        this.systemHeadID = (short) parcel.readInt();
        this.phoneNum = parcel.readString();
        this.headLevel = parcel.readByte();
        this.idType = parcel.readInt();
        this.originUsrType = parcel.readInt();
    }

    @Override // com.qq.taf.jce.JceStruct
    public String toString() {
        StringBuilder sb5 = new StringBuilder(100);
        sb5.append("uin=");
        sb5.append(this.uin);
        sb5.append(",dwTimestamp=");
        sb5.append(this.dwTimestamp);
        sb5.append(",cHeadType=");
        sb5.append((int) this.cHeadType);
        sb5.append(",dstUsrType=");
        sb5.append((int) this.dstUsrType);
        sb5.append(",dwFaceFlgas=");
        sb5.append((int) this.dwFaceFlgas);
        sb5.append(",systemHeadID=");
        sb5.append((int) this.systemHeadID);
        sb5.append(",phoneNum=");
        sb5.append(this.phoneNum);
        sb5.append(",headLevel=");
        sb5.append((int) this.headLevel);
        sb5.append(",idType=");
        sb5.append(this.idType);
        sb5.append(",originUsrType=");
        sb5.append(this.originUsrType);
        sb5.append(",sizeType=");
        sb5.append(this.sizeType);
        sb5.append(",staticZplanFaceFlag=");
        sb5.append((int) this.staticZplanFaceFlag);
        sb5.append(",dynamicZplanFaceFlag=");
        sb5.append((int) this.dynamicZplanFaceFlag);
        sb5.append(",downLoadUrl=");
        sb5.append(this.downLoadUrl);
        sb5.append(",apngFaceFlag=");
        sb5.append((int) this.apngFaceFlag);
        return sb5.toString();
    }

    @Override // com.qq.taf.jce.JceStruct
    public void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.uin, 0);
        jceOutputStream.write(this.dwTimestamp, 1);
        jceOutputStream.write(this.cHeadType, 2);
        jceOutputStream.write(this.dstUsrType, 3);
        jceOutputStream.write(this.dwFaceFlgas, 4);
        jceOutputStream.write(this.downLoadUrl, 5);
        jceOutputStream.write(this.systemHeadID, 6);
        String str = this.phoneNum;
        if (str != null) {
            jceOutputStream.write(str, 7);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.uin);
        parcel.writeLong(this.dwTimestamp);
        parcel.writeByte(this.cHeadType);
        parcel.writeByte(this.dstUsrType);
        parcel.writeByte(this.dwFaceFlgas);
        parcel.writeString(this.downLoadUrl);
        parcel.writeInt(this.systemHeadID);
        parcel.writeString(this.phoneNum);
        parcel.writeByte(this.headLevel);
        parcel.writeInt(this.idType);
        parcel.writeInt(this.originUsrType);
    }

    public QQHeadInfo(long j3, long j16, byte b16, byte b17, byte b18, String str, short s16, String str2) {
        this.headVerify = "";
        this.apngFaceFlag = (byte) 0;
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.headLevel = (byte) 0;
        this.originUsrType = 0;
        this.sizeType = 0;
        this.uin = j3;
        this.dwTimestamp = j16;
        this.cHeadType = b16;
        this.dstUsrType = b17;
        this.dwFaceFlgas = b18;
        this.downLoadUrl = str;
        this.systemHeadID = s16;
        this.phoneNum = str2;
    }

    public QQHeadInfo(MultiHeadUrl.RspHeadInfo rspHeadInfo) {
        this.uin = 0L;
        this.dwTimestamp = 0L;
        this.cHeadType = (byte) 0;
        this.dstUsrType = (byte) 0;
        this.dwFaceFlgas = (byte) 0;
        this.downLoadUrl = "";
        this.systemHeadID = (short) 0;
        this.phoneNum = "";
        this.headVerify = "";
        this.apngFaceFlag = (byte) 0;
        this.staticZplanFaceFlag = (byte) 0;
        this.dynamicZplanFaceFlag = (byte) 0;
        this.zplanFaceBgUrl = "";
        this.zplanFaceClipPercent = 25;
        this.enableZplanOutbound = false;
        this.headLevel = (byte) 0;
        this.originUsrType = 0;
        this.sizeType = 0;
        this.dwTimestamp = rspHeadInfo.timestamp.get();
        this.cHeadType = (byte) rspHeadInfo.faceType.get();
        this.dstUsrType = (byte) 32;
        this.dwFaceFlgas = (byte) rspHeadInfo.faceFlag.get();
        this.downLoadUrl = rspHeadInfo.url.get();
        this.systemHeadID = (short) rspHeadInfo.sysid.get();
        this.originUsrType = rspHeadInfo.usrType.get();
        if (this.dstUsrType == 32) {
            this.headLevel = (byte) 1;
        }
    }
}
