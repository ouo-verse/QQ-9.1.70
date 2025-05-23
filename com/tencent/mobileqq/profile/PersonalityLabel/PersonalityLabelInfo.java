package com.tencent.mobileqq.profile.PersonalityLabel;

import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.label.comm.PersonalityTagComm$LabelInfo;

/* loaded from: classes16.dex */
public class PersonalityLabelInfo implements Parcelable, Serializable {
    static IPatchRedirector $redirector_ = null;
    public static final Parcelable.Creator<PersonalityLabelInfo> CREATOR;
    public static final String TAG = "PersonalityLabelInfo";
    int addTime;
    public int bgColor;
    String bytesPhotoCookie;
    int category;
    String coverUrl;
    public int fgColor;

    /* renamed from: id, reason: collision with root package name */
    public long f259897id;
    long modTime;
    public List<PersonalityLabelPhoto> personalityLabelPhotos;
    int photoCount;
    long praiseCount;
    int praiseFlag;
    public String text;
    long unreadPraiseCount;
    ArrayList<PersonalityLabelZan> zanUins;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<PersonalityLabelInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PersonalityLabelInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (PersonalityLabelInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new PersonalityLabelInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public PersonalityLabelInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (PersonalityLabelInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new PersonalityLabelInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73729);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            CREATOR = new a();
        }
    }

    public PersonalityLabelInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f259897id = 0L;
        this.addTime = 0;
        this.category = 0;
        this.text = "";
        this.fgColor = 0;
        this.bgColor = 0;
        this.coverUrl = "";
        this.photoCount = 0;
        this.praiseCount = 0L;
        this.unreadPraiseCount = 0L;
        this.personalityLabelPhotos = new ArrayList();
        this.bytesPhotoCookie = null;
        this.modTime = 0L;
        this.praiseFlag = 0;
        this.zanUins = new ArrayList<>();
    }

    private static int a(String str, int i3) {
        try {
            return Color.parseColor(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "getColor exception from" + str, e16);
            }
            return i3;
        }
    }

    @NonNull
    public static PersonalityLabelInfo convertFromPb(PersonalityTagComm$LabelInfo personalityTagComm$LabelInfo) {
        long j3;
        int i3;
        int i16;
        String str;
        long j16;
        long j17;
        int i17;
        String str2;
        int i18;
        PersonalityLabelInfo personalityLabelInfo = new PersonalityLabelInfo();
        long j18 = 0;
        if (personalityTagComm$LabelInfo.uint64_id.has()) {
            j3 = personalityTagComm$LabelInfo.uint64_id.get();
        } else {
            j3 = 0;
        }
        personalityLabelInfo.f259897id = j3;
        if (personalityTagComm$LabelInfo.uint32_add_time.has()) {
            i3 = personalityTagComm$LabelInfo.uint32_add_time.get();
        } else {
            i3 = 0;
        }
        personalityLabelInfo.addTime = i3;
        if (personalityTagComm$LabelInfo.uint32_category.has()) {
            i16 = personalityTagComm$LabelInfo.uint32_category.get();
        } else {
            i16 = 0;
        }
        personalityLabelInfo.category = i16;
        String str3 = "";
        if (!personalityTagComm$LabelInfo.str_text.has()) {
            str = "";
        } else {
            str = personalityTagComm$LabelInfo.str_text.get();
        }
        personalityLabelInfo.text = str;
        int i19 = -1;
        if (personalityTagComm$LabelInfo.str_fg_color.has()) {
            i19 = a(personalityTagComm$LabelInfo.str_fg_color.get(), -1);
        }
        personalityLabelInfo.fgColor = i19;
        int i26 = -16777216;
        if (personalityTagComm$LabelInfo.str_bg_color.has()) {
            i26 = a(personalityTagComm$LabelInfo.str_bg_color.get(), -16777216);
        }
        personalityLabelInfo.bgColor = i26;
        if (personalityTagComm$LabelInfo.str_cover_photo_url.has()) {
            str3 = personalityTagComm$LabelInfo.str_cover_photo_url.get();
        }
        personalityLabelInfo.coverUrl = str3;
        if (personalityTagComm$LabelInfo.uint32_praise_count.has()) {
            j16 = personalityTagComm$LabelInfo.uint32_praise_count.get();
        } else {
            j16 = 0;
        }
        personalityLabelInfo.praiseCount = j16;
        if (personalityTagComm$LabelInfo.uint32_unread_praise.has()) {
            j17 = personalityTagComm$LabelInfo.uint32_unread_praise.get();
        } else {
            j17 = 0;
        }
        personalityLabelInfo.unreadPraiseCount = j17;
        if (personalityTagComm$LabelInfo.uint32_photo_count.has()) {
            i17 = personalityTagComm$LabelInfo.uint32_photo_count.get();
        } else {
            i17 = 0;
        }
        personalityLabelInfo.photoCount = i17;
        if (personalityTagComm$LabelInfo.bytes_photo_cookie.has()) {
            str2 = personalityTagComm$LabelInfo.bytes_photo_cookie.get().toStringUtf8();
        } else {
            str2 = null;
        }
        personalityLabelInfo.bytesPhotoCookie = str2;
        if (personalityTagComm$LabelInfo.uint32_mod_time.has()) {
            j18 = personalityTagComm$LabelInfo.uint32_mod_time.get();
        }
        personalityLabelInfo.modTime = j18;
        if (personalityTagComm$LabelInfo.uint32_praise_flag.has()) {
            i18 = personalityTagComm$LabelInfo.uint32_praise_flag.get();
        } else {
            i18 = 0;
        }
        personalityLabelInfo.praiseFlag = i18;
        if (personalityTagComm$LabelInfo.rpt_msg_photo.has() && personalityTagComm$LabelInfo.rpt_msg_photo.size() > 0) {
            for (int i27 = 0; i27 < personalityTagComm$LabelInfo.rpt_msg_photo.size(); i27++) {
                personalityLabelInfo.personalityLabelPhotos.add(PersonalityLabelPhoto.convertFromPb(personalityTagComm$LabelInfo.rpt_msg_photo.get(i27)));
            }
        }
        if (personalityTagComm$LabelInfo.rpt_last_praise_uins_info.has() && personalityTagComm$LabelInfo.rpt_last_praise_uins_info.size() > 0) {
            for (int i28 = 0; i28 < personalityTagComm$LabelInfo.rpt_last_praise_uins_info.size(); i28++) {
                personalityLabelInfo.zanUins.add(PersonalityLabelZan.convertFromPb(personalityTagComm$LabelInfo.rpt_last_praise_uins_info.get(i28)));
            }
        }
        return personalityLabelInfo;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        PersonalityLabelInfo personalityLabelInfo = (PersonalityLabelInfo) obj;
        if (!TextUtils.equals(personalityLabelInfo.text, this.text) || personalityLabelInfo.fgColor != this.fgColor || personalityLabelInfo.bgColor != this.bgColor || personalityLabelInfo.modTime != this.modTime) {
            return false;
        }
        return true;
    }

    public int getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return this.personalityLabelPhotos.size();
    }

    public boolean isComplete() {
        int size;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        List<PersonalityLabelPhoto> list = this.personalityLabelPhotos;
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        if (size != this.photoCount) {
            return false;
        }
        return true;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("id");
        sb5.append(":");
        sb5.append(this.f259897id);
        sb5.append("|");
        sb5.append("addTime:");
        sb5.append(this.addTime);
        sb5.append("|");
        sb5.append("category:");
        sb5.append(this.category);
        sb5.append("|");
        sb5.append("text:");
        sb5.append(this.text);
        sb5.append("|");
        sb5.append("fgColor:");
        sb5.append(this.fgColor);
        sb5.append("|");
        sb5.append("bgColor:");
        sb5.append(this.bgColor);
        sb5.append("|");
        sb5.append("coverUrl:");
        sb5.append(this.coverUrl);
        sb5.append("|");
        sb5.append("photoCount:");
        sb5.append(this.photoCount);
        sb5.append("|");
        sb5.append("praiseCount:");
        sb5.append(this.praiseCount);
        sb5.append("|");
        sb5.append("unreadPraiseCount:");
        sb5.append(this.unreadPraiseCount);
        sb5.append("|");
        sb5.append("bytesPhotoCookie:");
        sb5.append(this.bytesPhotoCookie);
        sb5.append("|");
        sb5.append("photoSise:");
        sb5.append(this.personalityLabelPhotos.size());
        sb5.append("|");
        sb5.append("modeTime:");
        sb5.append(this.modTime);
        sb5.append("|");
        sb5.append("praiseFlag:");
        sb5.append(this.praiseFlag);
        sb5.append("|");
        sb5.append("personalityLabelPhotos:[");
        sb5.append(this.personalityLabelPhotos);
        sb5.append("]|");
        sb5.append("recent_prase_uins:[");
        sb5.append(this.zanUins);
        sb5.append("]|");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(ProfilePersonalityLabelInfo.CURRENT_VERSION);
        parcel.writeLong(this.f259897id);
        parcel.writeInt(this.addTime);
        parcel.writeInt(this.category);
        parcel.writeString(this.text);
        parcel.writeInt(this.fgColor);
        parcel.writeInt(this.bgColor);
        parcel.writeString(this.coverUrl);
        parcel.writeInt(this.photoCount);
        parcel.writeLong(this.praiseCount);
        parcel.writeLong(this.unreadPraiseCount);
        parcel.writeTypedList(this.personalityLabelPhotos);
        parcel.writeString(this.bytesPhotoCookie);
        parcel.writeLong(this.modTime);
        parcel.writeInt(this.praiseFlag);
        parcel.writeTypedList(this.zanUins);
    }

    protected PersonalityLabelInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) parcel);
            return;
        }
        this.f259897id = 0L;
        this.addTime = 0;
        this.category = 0;
        this.text = "";
        this.fgColor = -1;
        this.bgColor = -16777216;
        this.coverUrl = "";
        this.photoCount = 0;
        this.praiseCount = 0L;
        this.unreadPraiseCount = 0L;
        parcel.readInt();
        this.f259897id = parcel.readLong();
        this.addTime = parcel.readInt();
        this.category = parcel.readInt();
        this.text = parcel.readString();
        this.fgColor = parcel.readInt();
        this.bgColor = parcel.readInt();
        this.coverUrl = parcel.readString();
        this.photoCount = parcel.readInt();
        this.praiseCount = parcel.readLong();
        this.unreadPraiseCount = parcel.readLong();
        this.personalityLabelPhotos = parcel.createTypedArrayList(PersonalityLabelPhoto.CREATOR);
        this.bytesPhotoCookie = parcel.readString();
        this.modTime = parcel.readLong();
        this.praiseFlag = parcel.readInt();
        this.zanUins = parcel.createTypedArrayList(PersonalityLabelZan.CREATOR);
    }
}
