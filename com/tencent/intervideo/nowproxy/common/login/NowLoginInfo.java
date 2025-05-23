package com.tencent.intervideo.nowproxy.common.login;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NowLoginInfo implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<NowLoginInfo> CREATOR;
    public String __client_type;
    public String appid;
    public String ilive_a2;
    public String ilive_tinyid;
    public long ilive_uin;
    public long lastLoginTime;
    public int loginType;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10921);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new Parcelable.Creator<NowLoginInfo>() { // from class: com.tencent.intervideo.nowproxy.common.login.NowLoginInfo.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public NowLoginInfo createFromParcel(Parcel parcel) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new NowLoginInfo(parcel) : (NowLoginInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // android.os.Parcelable.Creator
                public NowLoginInfo[] newArray(int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? new NowLoginInfo[i3] : (NowLoginInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
                }
            };
        }
    }

    public NowLoginInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.lastLoginTime = 0L;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
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
        parcel.writeString(this.appid);
        parcel.writeString(this.__client_type);
        parcel.writeLong(this.ilive_uin);
        parcel.writeString(this.ilive_a2);
        parcel.writeString(this.ilive_tinyid);
        parcel.writeInt(this.loginType);
    }

    public NowLoginInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.lastLoginTime = 0L;
        this.appid = parcel.readString();
        this.__client_type = parcel.readString();
        this.ilive_uin = parcel.readLong();
        this.ilive_a2 = parcel.readString();
        this.ilive_tinyid = parcel.readString();
        this.loginType = parcel.readInt();
    }
}
