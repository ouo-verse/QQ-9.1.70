package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFResponseAdapter {
    static IPatchRedirector $redirector_;
    String mCmd;
    int mFailReason;
    boolean mHasReserveFields;
    boolean mIsBadNetwork;
    boolean mIsRecvFromMainConn;
    boolean mIsSecSigCmd;
    boolean mIsUinDyed;
    byte[] mRecvData;
    long mRecvTime;
    int mRecvWay;
    int mSecSignFlag;
    long mSendTime;
    int mSeq;
    String mSsoErrTips;
    int mSsoRet;
    int mState;
    HashMap<String, byte[]> mTransInfo;
    byte[] mTrpcErrMsg;
    int mTrpcFuncRetCode;
    int mTrpcRetcode;
    String mUid;
    String mUin;
    int mUinType;
    long mWriteSocketTime;

    public MSFResponseAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mUin = "";
        this.mUid = "";
        this.mCmd = "";
        this.mRecvData = new byte[0];
        this.mTrpcErrMsg = new byte[0];
        this.mTransInfo = new HashMap<>();
        this.mSsoErrTips = "";
    }

    @NonNull
    public String getCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mCmd;
    }

    public int getFailReason() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return this.mFailReason;
    }

    public boolean getHasReserveFields() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.mHasReserveFields;
    }

    public boolean getIsBadNetwork() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mIsBadNetwork;
    }

    public boolean getIsRecvFromMainConn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Boolean) iPatchRedirector.redirect((short) 26, (Object) this)).booleanValue();
        }
        return this.mIsRecvFromMainConn;
    }

    public boolean getIsSecSigCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.mIsSecSigCmd;
    }

    public boolean getIsUinDyed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.mIsUinDyed;
    }

    @NonNull
    public byte[] getRecvData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mRecvData;
    }

    public long getRecvTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Long) iPatchRedirector.redirect((short) 12, (Object) this)).longValue();
        }
        return this.mRecvTime;
    }

    public int getRecvWay() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this)).intValue();
        }
        return this.mRecvWay;
    }

    public int getSecSignFlag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Integer) iPatchRedirector.redirect((short) 20, (Object) this)).intValue();
        }
        return this.mSecSignFlag;
    }

    public long getSendTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.mSendTime;
    }

    public int getSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mSeq;
    }

    @NonNull
    public String getSsoErrTips() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (String) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mSsoErrTips;
    }

    public int getSsoRet() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.mSsoRet;
    }

    public int getState() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mState;
    }

    @NonNull
    public HashMap<String, byte[]> getTransInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (HashMap) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mTransInfo;
    }

    @NonNull
    public byte[] getTrpcErrMsg() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (byte[]) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mTrpcErrMsg;
    }

    public int getTrpcFuncRetCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mTrpcFuncRetCode;
    }

    public int getTrpcRetcode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        return this.mTrpcRetcode;
    }

    @NonNull
    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mUid;
    }

    @NonNull
    public String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mUin;
    }

    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.mUinType;
    }

    public long getWriteSocketTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.mWriteSocketTime;
    }

    @NonNull
    public void setCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        } else {
            this.mCmd = str;
        }
    }

    public void setFailReason(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            iPatchRedirector.redirect((short) 42, (Object) this, i3);
        } else {
            this.mFailReason = i3;
        }
    }

    public void setHasReserveFields(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            iPatchRedirector.redirect((short) 46, (Object) this, z16);
        } else {
            this.mHasReserveFields = z16;
        }
    }

    public void setIsBadNetwork(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, z16);
        } else {
            this.mIsBadNetwork = z16;
        }
    }

    public void setIsRecvFromMainConn(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 50)) {
            iPatchRedirector.redirect((short) 50, (Object) this, z16);
        } else {
            this.mIsRecvFromMainConn = z16;
        }
    }

    public void setIsSecSigCmd(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, z16);
        } else {
            this.mIsSecSigCmd = z16;
        }
    }

    public void setIsUinDyed(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            iPatchRedirector.redirect((short) 49, (Object) this, z16);
        } else {
            this.mIsUinDyed = z16;
        }
    }

    @NonNull
    public void setRecvData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bArr);
        } else {
            this.mRecvData = bArr;
        }
    }

    public void setRecvTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, j3);
        } else {
            this.mRecvTime = j3;
        }
    }

    public void setRecvWay(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, i3);
        } else {
            this.mRecvWay = i3;
        }
    }

    public void setSecSignFlag(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            iPatchRedirector.redirect((short) 44, (Object) this, i3);
        } else {
            this.mSecSignFlag = i3;
        }
    }

    public void setSendTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, j3);
        } else {
            this.mSendTime = j3;
        }
    }

    public void setSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else {
            this.mSeq = i3;
        }
    }

    @NonNull
    public void setSsoErrTips(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            iPatchRedirector.redirect((short) 48, (Object) this, (Object) str);
        } else {
            this.mSsoErrTips = str;
        }
    }

    public void setSsoRet(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 47)) {
            iPatchRedirector.redirect((short) 47, (Object) this, i3);
        } else {
            this.mSsoRet = i3;
        }
    }

    public void setState(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.mState = i3;
        }
    }

    @NonNull
    public void setTransInfo(HashMap<String, byte[]> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, (Object) hashMap);
        } else {
            this.mTransInfo = hashMap;
        }
    }

    @NonNull
    public void setTrpcErrMsg(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            iPatchRedirector.redirect((short) 41, (Object) this, (Object) bArr);
        } else {
            this.mTrpcErrMsg = bArr;
        }
    }

    public void setTrpcFuncRetCode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, i3);
        } else {
            this.mTrpcFuncRetCode = i3;
        }
    }

    public void setTrpcRetcode(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, i3);
        } else {
            this.mTrpcRetcode = i3;
        }
    }

    @NonNull
    public void setUid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) str);
        } else {
            this.mUid = str;
        }
    }

    @NonNull
    public void setUin(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, (Object) str);
        } else {
            this.mUin = str;
        }
    }

    public void setUinType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, i3);
        } else {
            this.mUinType = i3;
        }
    }

    public void setWriteSocketTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, j3);
        } else {
            this.mWriteSocketTime = j3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (String) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        return "MSFResponseAdapter{mState=" + this.mState + ",mSeq=" + this.mSeq + ",mUin=" + this.mUin + ",mUid=" + this.mUid + ",mUinType=" + this.mUinType + ",mCmd=" + this.mCmd + ",mRecvData=" + this.mRecvData + ",mSendTime=" + this.mSendTime + ",mWriteSocketTime=" + this.mWriteSocketTime + ",mRecvTime=" + this.mRecvTime + ",mRecvWay=" + this.mRecvWay + ",mIsBadNetwork=" + this.mIsBadNetwork + ",mTrpcRetcode=" + this.mTrpcRetcode + ",mTrpcFuncRetCode=" + this.mTrpcFuncRetCode + ",mTrpcErrMsg=" + this.mTrpcErrMsg + ",mFailReason=" + this.mFailReason + ",mTransInfo=" + this.mTransInfo + ",mSecSignFlag=" + this.mSecSignFlag + ",mIsSecSigCmd=" + this.mIsSecSigCmd + ",mHasReserveFields=" + this.mHasReserveFields + ",mSsoRet=" + this.mSsoRet + ",mSsoErrTips=" + this.mSsoErrTips + ",mIsUinDyed=" + this.mIsUinDyed + ",mIsRecvFromMainConn=" + this.mIsRecvFromMainConn + ",}";
    }

    public MSFResponseAdapter(int i3, int i16, @NonNull String str, @NonNull String str2, int i17, @NonNull String str3, @NonNull byte[] bArr, long j3, long j16, long j17, int i18, boolean z16, int i19, int i26, @NonNull byte[] bArr2, int i27, @NonNull HashMap<String, byte[]> hashMap, int i28, boolean z17, boolean z18, int i29, @NonNull String str4, boolean z19, boolean z26) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, Integer.valueOf(i17), str3, bArr, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Integer.valueOf(i18), Boolean.valueOf(z16), Integer.valueOf(i19), Integer.valueOf(i26), bArr2, Integer.valueOf(i27), hashMap, Integer.valueOf(i28), Boolean.valueOf(z17), Boolean.valueOf(z18), Integer.valueOf(i29), str4, Boolean.valueOf(z19), Boolean.valueOf(z26));
            return;
        }
        this.mUin = "";
        this.mUid = "";
        this.mCmd = "";
        this.mRecvData = new byte[0];
        this.mTrpcErrMsg = new byte[0];
        new HashMap();
        this.mState = i3;
        this.mSeq = i16;
        this.mUin = str;
        this.mUid = str2;
        this.mUinType = i17;
        this.mCmd = str3;
        this.mRecvData = bArr;
        this.mSendTime = j3;
        this.mWriteSocketTime = j16;
        this.mRecvTime = j17;
        this.mRecvWay = i18;
        this.mIsBadNetwork = z16;
        this.mTrpcRetcode = i19;
        this.mTrpcFuncRetCode = i26;
        this.mTrpcErrMsg = bArr2;
        this.mFailReason = i27;
        this.mTransInfo = hashMap;
        this.mSecSignFlag = i28;
        this.mIsSecSigCmd = z17;
        this.mHasReserveFields = z18;
        this.mSsoRet = i29;
        this.mSsoErrTips = str4;
        this.mIsUinDyed = z19;
        this.mIsRecvFromMainConn = z26;
    }
}
