package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.Serializable;
import tencent.im.label.comm.PersonalityTagComm$PraiseUserInfo;

/* loaded from: classes16.dex */
public class PersonalityLabelZan implements Serializable, Parcelable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<PersonalityLabelZan> CREATOR;
    public static final String TAG = "PersonalityLabelPhoto";
    String nick;
    long uin;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<PersonalityLabelZan> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PersonalityLabelZan createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PersonalityLabelZan) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PersonalityLabelZan(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PersonalityLabelZan[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PersonalityLabelZan[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PersonalityLabelZan[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73738);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            CREATOR = new a();
        }
    }

    public PersonalityLabelZan() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.uin = 0L;
            this.nick = "";
        }
    }

    public static PersonalityLabelZan convertFromPb(PersonalityTagComm$PraiseUserInfo personalityTagComm$PraiseUserInfo) {
        PersonalityLabelZan personalityLabelZan = new PersonalityLabelZan();
        if (personalityTagComm$PraiseUserInfo.uint64_praise_uin.has()) {
            personalityLabelZan.uin = personalityTagComm$PraiseUserInfo.uint64_praise_uin.get();
        }
        if (personalityTagComm$PraiseUserInfo.str_nick.has()) {
            personalityLabelZan.nick = personalityTagComm$PraiseUserInfo.str_nick.get();
        }
        return personalityLabelZan;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "uin:" + this.uin + "|nick:" + this.nick + "|";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(ProfilePersonalityLabelInfo.CURRENT_VERSION);
        parcel.writeLong(this.uin);
        parcel.writeString(this.nick);
    }

    protected PersonalityLabelZan(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
            return;
        }
        parcel.readInt();
        this.uin = parcel.readLong();
        this.nick = parcel.readString();
    }
}
