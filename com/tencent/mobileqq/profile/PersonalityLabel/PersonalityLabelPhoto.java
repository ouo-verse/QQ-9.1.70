package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.Utils;
import java.io.Serializable;
import tencent.im.label.comm.PersonalityTagComm$LabelPhoto;

/* loaded from: classes16.dex */
public class PersonalityLabelPhoto implements Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<PersonalityLabelPhoto> CREATOR;
    public static final long ID_INVALID = -1;
    public static final String TAG = "PersonalityLabelPhoto";
    long fileId;
    boolean local;
    String localThumbPath;
    long praiseCount;
    long uniseq;
    public String url;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<PersonalityLabelPhoto> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PersonalityLabelPhoto createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PersonalityLabelPhoto) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PersonalityLabelPhoto(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PersonalityLabelPhoto[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PersonalityLabelPhoto[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PersonalityLabelPhoto[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            CREATOR = new a();
        }
    }

    public PersonalityLabelPhoto() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.uniseq = 0L;
        this.local = false;
        this.fileId = -1L;
        this.url = "";
        this.praiseCount = 0L;
        this.localThumbPath = "";
        this.uniseq = System.currentTimeMillis();
    }

    @NonNull
    public static PersonalityLabelPhoto convertFromPb(PersonalityTagComm$LabelPhoto personalityTagComm$LabelPhoto) {
        long j3;
        String str;
        PersonalityLabelPhoto personalityLabelPhoto = new PersonalityLabelPhoto();
        long j16 = 0;
        if (personalityTagComm$LabelPhoto.uint64_file_id.has()) {
            j3 = personalityTagComm$LabelPhoto.uint64_file_id.get();
        } else {
            j3 = 0;
        }
        personalityLabelPhoto.fileId = j3;
        if (personalityTagComm$LabelPhoto.uint32_url.has()) {
            str = personalityTagComm$LabelPhoto.uint32_url.get();
        } else {
            str = "";
        }
        personalityLabelPhoto.url = str;
        if (personalityTagComm$LabelPhoto.uint64_praise_count.has()) {
            j16 = personalityTagComm$LabelPhoto.uint64_praise_count.get();
        }
        personalityLabelPhoto.praiseCount = j16;
        return personalityLabelPhoto;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (!Utils.p(((PersonalityLabelPhoto) obj).url, this.url)) {
            return false;
        }
        return true;
    }

    public String get128SizeUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.url + "128";
    }

    public String get350SizeUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.url + "350";
    }

    public String getOriginUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        if (TextUtils.isEmpty(this.url)) {
            return this.localThumbPath;
        }
        return this.url + "0";
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("fileId");
        sb5.append(":");
        sb5.append(this.fileId);
        sb5.append("|");
        sb5.append("praiseCount");
        sb5.append(":");
        sb5.append(this.praiseCount);
        sb5.append("|");
        sb5.append("url");
        sb5.append(":");
        sb5.append(this.url);
        sb5.append("|");
        sb5.append("localThumbPath");
        sb5.append(":");
        sb5.append(this.localThumbPath);
        sb5.append("|");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(ProfilePersonalityLabelInfo.CURRENT_VERSION);
        parcel.writeLong(this.fileId);
        parcel.writeString(this.url);
        parcel.writeLong(this.praiseCount);
        parcel.writeString(this.localThumbPath);
    }

    protected PersonalityLabelPhoto(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        this.fileId = -1L;
        this.url = "";
        this.praiseCount = 0L;
        this.localThumbPath = "";
        this.uniseq = 0L;
        this.local = false;
        parcel.readInt();
        this.fileId = parcel.readLong();
        this.url = parcel.readString();
        this.praiseCount = parcel.readLong();
        this.localThumbPath = parcel.readString();
    }
}
