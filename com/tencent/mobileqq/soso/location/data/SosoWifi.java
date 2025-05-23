package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class SosoWifi implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SosoWifi> CREATOR;
    public long mMac;
    public String mMacStr;
    public int mRssi;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37251);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new Parcelable.Creator<SosoWifi>() { // from class: com.tencent.mobileqq.soso.location.data.SosoWifi.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoWifi createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SosoWifi(parcel) : (SosoWifi) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoWifi[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SosoWifi[i3] : (SosoWifi[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public SosoWifi(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            return;
        }
        this.mRssi = i3;
        this.mMacStr = str;
        this.mMac = macToLong(str);
    }

    public static long macToLong(String str) {
        try {
            String[] split = str.split(":");
            if (split.length != 6) {
                return 0L;
            }
            int i3 = 40;
            long j3 = 0;
            for (String str2 : split) {
                long parseLong = Long.parseLong(str2, 16);
                if (i3 > 0) {
                    parseLong <<= i3;
                }
                j3 += parseLong;
                i3 -= 8;
            }
            return j3;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(this.mRssi);
        parcel.writeLong(this.mMac);
        parcel.writeString(this.mMacStr);
    }

    protected SosoWifi(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.mRssi = parcel.readInt();
        this.mMac = parcel.readLong();
        this.mMacStr = parcel.readString();
    }
}
