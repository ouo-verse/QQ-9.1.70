package com.tencent.freesia;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ControlInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ControlInfo> CREATOR;
    public final String mConfigNologinSnapshot;
    public final long mConfigSeq;
    public final byte[] mCookies;
    public final String mEnv;
    public final byte[] mIncCookies;
    public final byte[] mIncNologinCookies;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12418);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            CREATOR = new Parcelable.Creator<ControlInfo>() { // from class: com.tencent.freesia.ControlInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ControlInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ControlInfo(parcel) : (ControlInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ControlInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new ControlInfo[i3] : (ControlInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public ControlInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        if (parcel.readByte() == 0) {
            this.mCookies = null;
        } else {
            this.mCookies = parcel.createByteArray();
        }
        this.mEnv = parcel.readString();
        this.mConfigSeq = parcel.readLong();
        this.mConfigNologinSnapshot = parcel.readString();
        if (parcel.readByte() == 0) {
            this.mIncCookies = null;
        } else {
            this.mIncCookies = parcel.createByteArray();
        }
        if (parcel.readByte() == 0) {
            this.mIncNologinCookies = null;
        } else {
            this.mIncNologinCookies = parcel.createByteArray();
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return 0;
    }

    @NonNull
    public String getConfigNologinSnapshot() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.mConfigNologinSnapshot;
    }

    public long getConfigSeq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.mConfigSeq;
    }

    @Nullable
    public byte[] getCookies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (byte[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mCookies;
    }

    @NonNull
    public String getEnv() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.mEnv;
    }

    @Nullable
    public byte[] getIncCookies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (byte[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mIncCookies;
    }

    @Nullable
    public byte[] getIncNologinCookies() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.mIncNologinCookies;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return "ControlInfo{mCookies=" + this.mCookies + ",mEnv=" + this.mEnv + ",mConfigSeq=" + this.mConfigSeq + ",mConfigNologinSnapshot=" + this.mConfigNologinSnapshot + ",mIncCookies=" + this.mIncCookies + ",mIncNologinCookies=" + this.mIncNologinCookies + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) parcel, i3);
            return;
        }
        if (this.mCookies != null) {
            parcel.writeByte((byte) 1);
            parcel.writeByteArray(this.mCookies);
        } else {
            parcel.writeByte((byte) 0);
        }
        parcel.writeString(this.mEnv);
        parcel.writeLong(this.mConfigSeq);
        parcel.writeString(this.mConfigNologinSnapshot);
        if (this.mIncCookies != null) {
            parcel.writeByte((byte) 1);
            parcel.writeByteArray(this.mIncCookies);
        } else {
            parcel.writeByte((byte) 0);
        }
        if (this.mIncNologinCookies != null) {
            parcel.writeByte((byte) 1);
            parcel.writeByteArray(this.mIncNologinCookies);
        } else {
            parcel.writeByte((byte) 0);
        }
    }

    public ControlInfo(@Nullable byte[] bArr, @NonNull String str, long j3, @NonNull String str2, @Nullable byte[] bArr2, @Nullable byte[] bArr3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, bArr, str, Long.valueOf(j3), str2, bArr2, bArr3);
            return;
        }
        this.mCookies = bArr;
        this.mEnv = str;
        this.mConfigSeq = j3;
        this.mConfigNologinSnapshot = str2;
        this.mIncCookies = bArr2;
        this.mIncNologinCookies = bArr3;
    }
}
