package com.tencent.mobileqq.profilecard.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes16.dex */
public class ProfileContactInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ProfileContactInfo> CREATOR;
    public String phoneName;
    public String phoneNationalCode;
    public String phoneNumber;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(41869);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new Parcelable.Creator<ProfileContactInfo>() { // from class: com.tencent.mobileqq.profilecard.data.ProfileContactInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ProfileContactInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        return (ProfileContactInfo) iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
                    }
                    ProfileContactInfo profileContactInfo = new ProfileContactInfo();
                    profileContactInfo.phoneName = parcel.readString();
                    profileContactInfo.phoneNumber = parcel.readString();
                    profileContactInfo.phoneNationalCode = parcel.readString();
                    return profileContactInfo;
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public ProfileContactInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new ProfileContactInfo[i3] : (ProfileContactInfo[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
                }
            };
        }
    }

    ProfileContactInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
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
        parcel.writeString(this.phoneName);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.phoneNationalCode);
    }

    public ProfileContactInfo(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, str3);
            return;
        }
        this.phoneName = str;
        this.phoneNumber = str2;
        this.phoneNationalCode = str3;
    }
}
