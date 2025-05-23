package com.tencent.mobileqq.soso.location.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class SosoAttribute implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<SosoAttribute> CREATOR;
    public String mImei;
    public String mImsi;
    public String mPhoneNum;
    public String mQQNum;
    public boolean roaming;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(37223);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new Parcelable.Creator<SosoAttribute>() { // from class: com.tencent.mobileqq.soso.location.data.SosoAttribute.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoAttribute createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SosoAttribute(parcel) : (SosoAttribute) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public SosoAttribute[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new SosoAttribute[i3] : (SosoAttribute[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public SosoAttribute(String str, String str2, String str3, String str4, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, Boolean.valueOf(z16));
            return;
        }
        this.mImei = str;
        this.mImsi = str2;
        this.mPhoneNum = str3;
        this.mQQNum = str4;
        this.roaming = z16;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.mImei);
        parcel.writeString(this.mImsi);
        parcel.writeString(this.mPhoneNum);
        parcel.writeString(this.mQQNum);
        parcel.writeByte(this.roaming ? (byte) 1 : (byte) 0);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public SosoAttribute m221clone() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new SosoAttribute(this.mImei, this.mImsi, this.mPhoneNum, this.mQQNum, this.roaming) : (SosoAttribute) iPatchRedirector.redirect((short) 2, (Object) this);
    }

    protected SosoAttribute(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        this.mImei = parcel.readString();
        this.mImsi = parcel.readString();
        this.mPhoneNum = parcel.readString();
        this.mQQNum = parcel.readString();
        this.roaming = parcel.readByte() != 0;
    }
}
