package com.tencent.qphone.base.remote;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.tencent.mobileqq.msf.sdk.MsfCommand;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes22.dex */
public class FromServiceMsg implements Parcelable, Cloneable {
    public static final Parcelable.Creator<FromServiceMsg> CREATOR = new Parcelable.Creator<FromServiceMsg>() { // from class: com.tencent.qphone.base.remote.FromServiceMsg.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FromServiceMsg createFromParcel(Parcel parcel) {
            return new FromServiceMsg(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FromServiceMsg[] newArray(int i3) {
            return new FromServiceMsg[i3];
        }
    };
    private static final String tag = "FromServiceMsg";
    private static final String version = "version";
    private int appId;
    private int appSeq;
    public HashMap<String, Object> attributes;
    private String errorMsg;

    @Deprecated
    public Bundle extraData;
    private int flag;
    private byte fromVersion;
    private boolean isColorLevel;
    private int mSsoEnc;
    private MsfCommand msfCommand;
    private byte[] msgCookie;
    private int resultCode;
    private String serviceCmd;
    private int ssoSeq;
    private final HashMap<String, byte[]> transInfo;
    private byte[] trpcRspErrorMsg;
    private int trpcRspFuncRetCode;
    private int trpcRspRetCode;
    private String uin;
    private int uinType;
    private byte[] wupBuffer;

    public FromServiceMsg() {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        this.uinType = 0;
        Bundle bundle = new Bundle();
        this.extraData = bundle;
        try {
            bundle.putByte("version", this.fromVersion);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public synchronized Object addAttribute(String str, Object obj) {
        return this.attributes.put(str, obj);
    }

    public synchronized Object addTransInfo(String str, byte[] bArr) {
        return this.transInfo.put(str, bArr);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getAppId() {
        return this.appId;
    }

    public int getAppSeq() {
        return this.appSeq;
    }

    public Object getAttribute(String str) {
        return this.attributes.get(str);
    }

    public HashMap<String, Object> getAttributes() {
        return this.attributes;
    }

    public int getBusinessFailCode(int i3) {
        int i16 = this.resultCode;
        return i16 == -1 ? i3 : i16;
    }

    public String getBusinessFailMsg() {
        return this.errorMsg;
    }

    public int getFlag() {
        return this.flag;
    }

    public byte getFromVersion() {
        return this.fromVersion;
    }

    public MsfCommand getMsfCommand() {
        return this.msfCommand;
    }

    public byte[] getMsgCookie() {
        return this.msgCookie;
    }

    public int getRequestSsoSeq() {
        return this.ssoSeq;
    }

    public int getResultCode() {
        return this.resultCode;
    }

    public String getServiceCmd() {
        return this.serviceCmd;
    }

    public String getShortStringForLog() {
        int length;
        try {
            String str = this.serviceCmd;
            if (str == null) {
                length = 4;
            } else {
                length = str.length();
            }
            StringBuilder sb5 = new StringBuilder(length + 87 + 7 + 10 + 8 + 10 + 10);
            sb5.append(tag);
            sb5.append(" msName:");
            sb5.append(this.msfCommand);
            sb5.append(" ssoSeq:");
            sb5.append(getRequestSsoSeq());
            sb5.append(" serviceCmd:");
            sb5.append(this.serviceCmd);
            sb5.append(" appSeq:");
            sb5.append(this.appSeq);
            sb5.append(" failCode:");
            sb5.append(this.resultCode);
            return sb5.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "fsm getString error";
        }
    }

    public int getSsoEnc() {
        return this.mSsoEnc;
    }

    public String getStringForLog() {
        int length;
        try {
            int length2 = this.msfCommand.toString().length() + 22 + 8 + 10 + 10 + 10 + 10 + this.errorMsg.length() + 5 + 10 + 12;
            String str = this.serviceCmd;
            if (str == null) {
                length = 4;
            } else {
                length = str.length();
            }
            StringBuilder sb5 = new StringBuilder(length2 + length + 7 + 10 + 8 + 10 + 10);
            sb5.append(tag);
            sb5.append(" msName:");
            sb5.append(this.msfCommand);
            sb5.append(" ssoSeq:");
            sb5.append(getRequestSsoSeq());
            sb5.append(" failCode:");
            sb5.append(this.resultCode);
            sb5.append(" errorMsg:");
            sb5.append(this.errorMsg);
            sb5.append(" uin:");
            sb5.append(MsfSdkUtils.getShortUin(this.uin));
            sb5.append(" serviceCmd:");
            sb5.append(this.serviceCmd);
            sb5.append(" appId:");
            sb5.append(this.appId);
            sb5.append(" appSeq:");
            sb5.append(this.appSeq);
            return sb5.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "fsm getString error";
        }
    }

    public HashMap<String, byte[]> getTransInfo() {
        return this.transInfo;
    }

    public byte[] getTransInfoEntry(String str) {
        return this.transInfo.get(str);
    }

    public byte[] getTrpcRspErrorMsg() {
        return this.trpcRspErrorMsg;
    }

    public int getTrpcRspFuncRetCode() {
        return this.trpcRspFuncRetCode;
    }

    public int getTrpcRspRetCode() {
        return this.trpcRspRetCode;
    }

    public String getUin() {
        return this.uin;
    }

    public int getUinType() {
        return this.uinType;
    }

    public byte[] getWupBuffer() {
        return this.wupBuffer;
    }

    public boolean isColorLevel() {
        return this.isColorLevel;
    }

    public boolean isSuccess() {
        if (this.resultCode == 1000) {
            return true;
        }
        return false;
    }

    public void putWupBuffer(byte[] bArr) {
        this.wupBuffer = bArr;
    }

    public void readFromParcel(Parcel parcel) {
        try {
            this.appId = parcel.readInt();
            this.appSeq = parcel.readInt();
            this.resultCode = parcel.readInt();
            this.uin = parcel.readString();
            this.serviceCmd = parcel.readString();
            this.extraData.clear();
            this.extraData = parcel.readBundle();
            this.attributes.clear();
            parcel.readMap(this.attributes, getClass().getClassLoader());
            if (this.extraData.getByte("version") > 0) {
                this.msfCommand = (MsfCommand) parcel.readSerializable();
                this.ssoSeq = parcel.readInt();
                this.errorMsg = parcel.readString();
                byte[] bArr = new byte[parcel.readInt()];
                this.wupBuffer = bArr;
                parcel.readByteArray(bArr);
                byte[] bArr2 = new byte[parcel.readInt()];
                this.msgCookie = bArr2;
                parcel.readByteArray(bArr2);
                this.flag = parcel.readInt();
                this.trpcRspRetCode = parcel.readInt();
                this.trpcRspFuncRetCode = parcel.readInt();
                byte[] bArr3 = new byte[parcel.readInt()];
                this.trpcRspErrorMsg = bArr3;
                parcel.readByteArray(bArr3);
                this.transInfo.clear();
                parcel.readMap(this.transInfo, FromServiceMsg.class.getClassLoader());
            }
        } catch (RuntimeException e16) {
            Log.d(tag, "readFromParcel RuntimeException", e16);
            throw e16;
        }
    }

    public void setAppId(int i3) {
        this.appId = i3;
    }

    public void setAppSeq(int i3) {
        this.appSeq = i3;
    }

    public void setBusinessFail(int i3) {
        this.resultCode = i3;
    }

    public void setFlag(int i3) {
        this.flag = i3;
    }

    public void setFromVersion(byte b16) {
        this.fromVersion = b16;
    }

    public void setIsColorLevel(boolean z16) {
        this.isColorLevel = z16;
    }

    public void setMsfCommand(MsfCommand msfCommand) {
        this.msfCommand = msfCommand;
    }

    public void setMsgCookie(byte[] bArr) {
        this.msgCookie = bArr;
    }

    public void setMsgFail() {
        this.resultCode = 1001;
    }

    public void setMsgSuccess() {
        this.resultCode = 1000;
    }

    public void setRequestSsoSeq(int i3) {
        this.ssoSeq = i3;
    }

    public void setServiceCmd(String str) {
        this.serviceCmd = str;
    }

    public void setTrpcRspErrorMsg(byte[] bArr) {
        this.trpcRspErrorMsg = bArr;
    }

    public void setTrpcRspFuncRetCode(int i3) {
        this.trpcRspFuncRetCode = i3;
    }

    public void setTrpcRspRetCode(int i3) {
        this.trpcRspRetCode = i3;
    }

    public void setUin(String str) {
        this.uin = str;
    }

    public void setUinType(int i3) {
        this.uinType = i3;
    }

    public String toString() {
        int length;
        try {
            int length2 = this.msfCommand.toString().length() + 22 + 8 + 10 + 10 + 10 + 10 + this.errorMsg.length() + 5 + 10 + 12;
            String str = this.serviceCmd;
            if (str == null) {
                length = 4;
            } else {
                length = str.length();
            }
            StringBuilder sb5 = new StringBuilder(length2 + length + 7 + 10 + 8 + 10 + 10);
            sb5.append(tag);
            sb5.append(" msName:");
            sb5.append(this.msfCommand);
            sb5.append(" ssoSeq:");
            sb5.append(getRequestSsoSeq());
            sb5.append(" failCode:");
            sb5.append(this.resultCode);
            sb5.append(" errorMsg:");
            sb5.append(this.errorMsg);
            sb5.append(" uin:");
            sb5.append(this.uin);
            sb5.append(" serviceCmd:");
            sb5.append(this.serviceCmd);
            sb5.append(" appId:");
            sb5.append(this.appId);
            sb5.append(" appSeq:");
            sb5.append(this.appSeq);
            return sb5.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "fsm toString error";
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeInt(this.appId);
            parcel.writeInt(this.appSeq);
            parcel.writeInt(this.resultCode);
            parcel.writeString(this.uin);
            parcel.writeString(this.serviceCmd);
            parcel.writeBundle(this.extraData);
            parcel.writeMap(this.attributes);
            if (this.fromVersion > 0) {
                parcel.writeSerializable(this.msfCommand);
                parcel.writeInt(this.ssoSeq);
                parcel.writeString(this.errorMsg);
                parcel.writeInt(this.wupBuffer.length);
                parcel.writeByteArray(this.wupBuffer);
                parcel.writeInt(this.msgCookie.length);
                parcel.writeByteArray(this.msgCookie);
                parcel.writeInt(this.flag);
                parcel.writeInt(this.trpcRspRetCode);
                parcel.writeInt(this.trpcRspFuncRetCode);
                parcel.writeInt(this.trpcRspErrorMsg.length);
                parcel.writeByteArray(this.trpcRspErrorMsg);
                parcel.writeMap(this.transInfo);
            }
        } catch (RuntimeException e16) {
            Log.d(tag, "writeToParcel RuntimeException", e16);
            throw e16;
        }
    }

    public <T> T getAttribute(String str, T t16) {
        return !this.attributes.containsKey(str) ? t16 : (T) this.attributes.get(str);
    }

    public int getBusinessFailCode() {
        return this.resultCode;
    }

    public void setBusinessFail(int i3, String str) {
        this.resultCode = i3;
        this.errorMsg = str;
    }

    public void setBusinessFail(int i3, int i16, String str) {
        this.resultCode = i16;
        this.errorMsg = str;
    }

    public FromServiceMsg(String str, String str2) {
        this(-1, -1, str, str2);
        try {
            this.extraData.putByte("version", this.fromVersion);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public FromServiceMsg(int i3, int i16, String str, String str2) {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        this.uinType = 0;
        Bundle bundle = new Bundle();
        this.extraData = bundle;
        this.resultCode = 1001;
        this.appId = i3;
        this.appSeq = i16;
        this.uin = str;
        this.serviceCmd = str2;
        try {
            bundle.putByte("version", this.fromVersion);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public FromServiceMsg(int i3, int i16, String str, String str2, byte[] bArr) {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        this.uinType = 0;
        Bundle bundle = new Bundle();
        this.extraData = bundle;
        this.resultCode = 1001;
        this.appId = i3;
        this.appSeq = i16;
        this.uin = str;
        this.serviceCmd = str2;
        this.msgCookie = bArr;
        try {
            bundle.putByte("version", this.fromVersion);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public FromServiceMsg(Parcel parcel) {
        this.errorMsg = "";
        this.mSsoEnc = 0;
        this.ssoSeq = -1;
        this.appSeq = -1;
        this.wupBuffer = new byte[0];
        this.attributes = new HashMap<>(32);
        this.fromVersion = (byte) 1;
        this.msfCommand = MsfCommand.unknown;
        this.msgCookie = new byte[0];
        this.trpcRspErrorMsg = new byte[0];
        this.transInfo = new HashMap<>();
        this.isColorLevel = false;
        this.uinType = 0;
        this.extraData = new Bundle();
        readFromParcel(parcel);
    }
}
