package com.tencent.mobileqq.msf.core.auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.commonsdk.util.HexUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class NTAccountSigInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<NTAccountSigInfo> CREATOR;

    /* renamed from: a2, reason: collision with root package name */
    private byte[] f247349a2;

    /* renamed from: d2, reason: collision with root package name */
    private byte[] f247350d2;
    private byte[] d2key;
    private String uid;
    private long uin;
    private int uinType;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements Parcelable.Creator<NTAccountSigInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NTAccountSigInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new NTAccountSigInfo(parcel) : (NTAccountSigInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public NTAccountSigInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new NTAccountSigInfo[i3] : (NTAccountSigInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15678);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            CREATOR = new a();
        }
    }

    public NTAccountSigInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Integer) iPatchRedirector.redirect((short) 17, (Object) this)).intValue();
        }
        return 0;
    }

    public byte[] getA2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (byte[]) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.f247349a2;
    }

    public byte[] getD2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (byte[]) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.f247350d2;
    }

    public byte[] getD2key() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (byte[]) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.d2key;
    }

    public String getUid() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.uid;
    }

    public long getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.uin;
    }

    public int getUinType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.uinType;
    }

    public void setA2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) bArr);
        } else {
            this.f247349a2 = bArr;
        }
    }

    public void setD2(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) bArr);
        } else {
            this.f247350d2 = bArr;
        }
    }

    public void setD2key(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bArr);
        } else {
            this.d2key = bArr;
        }
    }

    public void setUid(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.uid = str;
        }
    }

    public void setUin(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.uin = j3;
        }
    }

    public void setUinType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.uinType = i3;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "NTAccountSigInfo{uin=" + this.uin + ", uinType='" + this.uinType + "', uid='" + this.uid + "', a2=" + HexUtil.bytes2HexStr(this.f247349a2) + ", d2=" + HexUtil.bytes2HexStr(this.f247350d2) + ", d2key=" + HexUtil.bytes2HexStr(this.d2key) + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeLong(this.uin);
        parcel.writeInt(this.uinType);
        parcel.writeString(this.uid);
        parcel.writeByteArray(this.f247349a2);
        parcel.writeByteArray(this.f247350d2);
        parcel.writeByteArray(this.d2key);
    }

    public NTAccountSigInfo(long j3, int i3, String str, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), Integer.valueOf(i3), str, bArr, bArr2, bArr3);
            return;
        }
        this.uin = j3;
        this.uinType = i3;
        this.uid = str;
        this.f247349a2 = bArr;
        this.f247350d2 = bArr2;
        this.d2key = bArr3;
    }

    protected NTAccountSigInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.uin = parcel.readLong();
        this.uinType = parcel.readInt();
        this.uid = parcel.readString();
        this.f247349a2 = parcel.createByteArray();
        this.f247350d2 = parcel.createByteArray();
        this.d2key = parcel.createByteArray();
    }
}
