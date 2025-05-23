package com.tencent.mobileqq.msfcore;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MSFRequestAdapter {
    static IPatchRedirector $redirector_;
    byte[] mA2;
    String mCmd;
    byte[] mD2;
    byte[] mD2key;
    byte[] mData;
    int mOptions;
    int mPacketType;
    int mPriority;
    int mResendNum;
    byte[] mSecDeviceToken;
    byte[] mSecExtra;
    byte[] mSecSign;
    int mSeq;
    int mTimeout;
    String mTraceInfo;
    HashMap<String, byte[]> mTransInfo;
    String mUid;
    String mUin;
    int mUinType;

    public MSFRequestAdapter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mUin = "";
        this.mUid = "";
        this.mCmd = "";
        this.mTraceInfo = "";
        this.mData = new byte[0];
        this.mA2 = new byte[0];
        this.mD2 = new byte[0];
        this.mD2key = new byte[0];
        this.mTransInfo = new HashMap<>();
        this.mSecSign = new byte[0];
        this.mSecDeviceToken = new byte[0];
        this.mSecExtra = new byte[0];
    }

    @NonNull
    public byte[] getA2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.mA2;
    }

    @NonNull
    public String getCmd() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mCmd;
    }

    @NonNull
    public byte[] getD2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (byte[]) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.mD2;
    }

    @NonNull
    public byte[] getD2key() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (byte[]) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return this.mD2key;
    }

    @NonNull
    public byte[] getData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (byte[]) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.mData;
    }

    public int getOptions() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.mOptions;
    }

    public int getPacketType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this)).intValue();
        }
        return this.mPacketType;
    }

    public int getPriority() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.mPriority;
    }

    public int getResendNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        return this.mResendNum;
    }

    @NonNull
    public byte[] getSecDeviceToken() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (byte[]) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mSecDeviceToken;
    }

    @NonNull
    public byte[] getSecExtra() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return (byte[]) iPatchRedirector.redirect((short) 21, (Object) this);
        }
        return this.mSecExtra;
    }

    @NonNull
    public byte[] getSecSign() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (byte[]) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return this.mSecSign;
    }

    public int getSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.mSeq;
    }

    public int getTimeout() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mTimeout;
    }

    @NonNull
    public String getTraceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.mTraceInfo;
    }

    @NonNull
    public HashMap<String, byte[]> getTransInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (HashMap) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        return this.mTransInfo;
    }

    @NonNull
    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.mUid;
    }

    @NonNull
    public String getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
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

    @NonNull
    public void setA2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) bArr);
        } else {
            this.mA2 = bArr;
        }
    }

    @NonNull
    public void setCmd(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, (Object) str);
        } else {
            this.mCmd = str;
        }
    }

    @NonNull
    public void setD2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, (Object) bArr);
        } else {
            this.mD2 = bArr;
        }
    }

    @NonNull
    public void setD2key(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            iPatchRedirector.redirect((short) 36, (Object) this, (Object) bArr);
        } else {
            this.mD2key = bArr;
        }
    }

    @NonNull
    public void setData(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) bArr);
        } else {
            this.mData = bArr;
        }
    }

    public void setOptions(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, i3);
        } else {
            this.mOptions = i3;
        }
    }

    public void setPacketType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.mPacketType = i3;
        }
    }

    public void setPriority(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, i3);
        } else {
            this.mPriority = i3;
        }
    }

    public void setResendNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
        } else {
            this.mResendNum = i3;
        }
    }

    @NonNull
    public void setSecDeviceToken(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) bArr);
        } else {
            this.mSecDeviceToken = bArr;
        }
    }

    @NonNull
    public void setSecExtra(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this, (Object) bArr);
        } else {
            this.mSecExtra = bArr;
        }
    }

    @NonNull
    public void setSecSign(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            iPatchRedirector.redirect((short) 38, (Object) this, (Object) bArr);
        } else {
            this.mSecSign = bArr;
        }
    }

    public void setSeq(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
        } else {
            this.mSeq = i3;
        }
    }

    public void setTimeout(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, i3);
        } else {
            this.mTimeout = i3;
        }
    }

    @NonNull
    public void setTraceInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this, (Object) str);
        } else {
            this.mTraceInfo = str;
        }
    }

    @NonNull
    public void setTransInfo(HashMap<String, byte[]> hashMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, (Object) hashMap);
        } else {
            this.mTransInfo = hashMap;
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.mUinType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 41)) {
            return (String) iPatchRedirector.redirect((short) 41, (Object) this);
        }
        return "MSFRequestAdapter{mSeq=" + this.mSeq + ",mTimeout=" + this.mTimeout + ",mResendNum=" + this.mResendNum + ",mOptions=" + this.mOptions + ",mUinType=" + this.mUinType + ",mPacketType=" + this.mPacketType + ",mPriority=" + this.mPriority + ",mUin=" + this.mUin + ",mUid=" + this.mUid + ",mCmd=" + this.mCmd + ",mTraceInfo=" + this.mTraceInfo + ",mData=" + this.mData + ",mA2=" + this.mA2 + ",mD2=" + this.mD2 + ",mD2key=" + this.mD2key + ",mTransInfo=" + this.mTransInfo + ",mSecSign=" + this.mSecSign + ",mSecDeviceToken=" + this.mSecDeviceToken + ",mSecExtra=" + this.mSecExtra + ",}";
    }

    public MSFRequestAdapter(int i3, int i16, int i17, int i18, int i19, int i26, int i27, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull String str4, @NonNull byte[] bArr, @NonNull byte[] bArr2, @NonNull byte[] bArr3, @NonNull byte[] bArr4, @NonNull HashMap<String, byte[]> hashMap, @NonNull byte[] bArr5, @NonNull byte[] bArr6, @NonNull byte[] bArr7) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), Integer.valueOf(i19), Integer.valueOf(i26), Integer.valueOf(i27), str, str2, str3, str4, bArr, bArr2, bArr3, bArr4, hashMap, bArr5, bArr6, bArr7);
            return;
        }
        this.mUin = "";
        this.mUid = "";
        this.mCmd = "";
        this.mTraceInfo = "";
        this.mData = new byte[0];
        this.mA2 = new byte[0];
        this.mD2 = new byte[0];
        this.mD2key = new byte[0];
        new HashMap();
        this.mSeq = i3;
        this.mTimeout = i16;
        this.mResendNum = i17;
        this.mOptions = i18;
        this.mUinType = i19;
        this.mPacketType = i26;
        this.mPriority = i27;
        this.mUin = str;
        this.mUid = str2;
        this.mCmd = str3;
        this.mTraceInfo = str4;
        this.mData = bArr;
        this.mA2 = bArr2;
        this.mD2 = bArr3;
        this.mD2key = bArr4;
        this.mTransInfo = hashMap;
        this.mSecSign = bArr5;
        this.mSecDeviceToken = bArr6;
        this.mSecExtra = bArr7;
    }
}
