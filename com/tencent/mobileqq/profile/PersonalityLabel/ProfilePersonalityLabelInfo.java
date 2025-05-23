package com.tencent.mobileqq.profile.PersonalityLabel;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.profilecard.entity.IProfileBusinessInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.cd;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x8f0.cmd0x8f0$RspBody;

/* loaded from: classes16.dex */
public class ProfilePersonalityLabelInfo implements IProfileBusinessInfo, Parcelable, Serializable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<ProfilePersonalityLabelInfo> CREATOR;
    public static int CURRENT_VERSION;
    public int isCloseByUser;
    public long lastPraiseUin;
    public int maxPhotoCount;
    public List<PersonalityLabelInfo> personalityLabelInfos;
    public int photoCount;
    public int praiseCount;
    public int remainCount;
    public int unreadCount;

    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<ProfilePersonalityLabelInfo> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ProfilePersonalityLabelInfo createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ProfilePersonalityLabelInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new ProfilePersonalityLabelInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ProfilePersonalityLabelInfo[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (ProfilePersonalityLabelInfo[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new ProfilePersonalityLabelInfo[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73741);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            CURRENT_VERSION = 2;
            CREATOR = new a();
        }
    }

    public ProfilePersonalityLabelInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.isCloseByUser = 0;
        this.personalityLabelInfos = new ArrayList();
        this.remainCount = 10;
    }

    private void a() {
        List<PersonalityLabelInfo> list = this.personalityLabelInfos;
        if (list != null) {
            list.clear();
        } else {
            this.personalityLabelInfos = new ArrayList();
        }
        this.remainCount = 0;
        this.photoCount = 0;
        this.praiseCount = 0;
        this.maxPhotoCount = 0;
        this.unreadCount = 0;
        this.lastPraiseUin = 0L;
        this.isCloseByUser = 0;
    }

    public static ProfilePersonalityLabelInfo convertFromBytes(byte[] bArr) {
        String profilePersonalityLabelInfo;
        if (bArr != null && bArr.length != 0) {
            ProfilePersonalityLabelInfo profilePersonalityLabelInfo2 = (ProfilePersonalityLabelInfo) cd.c(bArr, CREATOR);
            if (QLog.isColorLevel()) {
                if (("convertFromBytes:" + profilePersonalityLabelInfo2) == null) {
                    profilePersonalityLabelInfo = "null";
                } else {
                    profilePersonalityLabelInfo = profilePersonalityLabelInfo2.toString();
                }
                QLog.i("PersonalityLabel", 2, profilePersonalityLabelInfo);
            }
            return profilePersonalityLabelInfo2;
        }
        return null;
    }

    public static ProfilePersonalityLabelInfo convertFromPb(cmd0x8f0$RspBody cmd0x8f0_rspbody) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        long j3;
        int i26;
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = new ProfilePersonalityLabelInfo();
        if (cmd0x8f0_rspbody.uint32_remain_quota.has()) {
            i3 = cmd0x8f0_rspbody.uint32_remain_quota.get();
        } else {
            i3 = 0;
        }
        profilePersonalityLabelInfo.remainCount = i3;
        if (cmd0x8f0_rspbody.uint32_total_photo.has()) {
            i16 = cmd0x8f0_rspbody.uint32_total_photo.get();
        } else {
            i16 = 0;
        }
        profilePersonalityLabelInfo.photoCount = i16;
        if (cmd0x8f0_rspbody.uint32_total_praise.has()) {
            i17 = cmd0x8f0_rspbody.uint32_total_praise.get();
        } else {
            i17 = 0;
        }
        profilePersonalityLabelInfo.praiseCount = i17;
        if (cmd0x8f0_rspbody.uint32_max_photo_quota.has()) {
            i18 = cmd0x8f0_rspbody.uint32_max_photo_quota.get();
        } else {
            i18 = 0;
        }
        profilePersonalityLabelInfo.maxPhotoCount = i18;
        if (cmd0x8f0_rspbody.uint32_unread_praise.has()) {
            i19 = cmd0x8f0_rspbody.uint32_unread_praise.get();
        } else {
            i19 = 0;
        }
        profilePersonalityLabelInfo.unreadCount = i19;
        if (cmd0x8f0_rspbody.uint64_last_praise_uin.has()) {
            j3 = cmd0x8f0_rspbody.uint64_last_praise_uin.get();
        } else {
            j3 = 0;
        }
        profilePersonalityLabelInfo.lastPraiseUin = j3;
        if (cmd0x8f0_rspbody.uint32_is_close.has()) {
            i26 = cmd0x8f0_rspbody.uint32_is_close.get();
        } else {
            i26 = 0;
        }
        profilePersonalityLabelInfo.isCloseByUser = i26;
        if (cmd0x8f0_rspbody.rpt_msg_labels.has() && cmd0x8f0_rspbody.rpt_msg_labels.size() > 0) {
            for (int i27 = 0; i27 < cmd0x8f0_rspbody.rpt_msg_labels.size(); i27++) {
                profilePersonalityLabelInfo.personalityLabelInfos.add(PersonalityLabelInfo.convertFromPb(cmd0x8f0_rspbody.rpt_msg_labels.get(i27)));
            }
        }
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabel", 2, "convertFromPb:" + profilePersonalityLabelInfo.toString());
        }
        return profilePersonalityLabelInfo;
    }

    public static ProfilePersonalityLabelInfo convertFromPbBytes(byte[] bArr) {
        if (QLog.isColorLevel()) {
            QLog.i("PersonalityLabel", 2, "convertFromPbBytes");
        }
        if (bArr != null && bArr.length != 0) {
            cmd0x8f0$RspBody cmd0x8f0_rspbody = new cmd0x8f0$RspBody();
            try {
                cmd0x8f0_rspbody.mergeFrom(bArr);
            } catch (InvalidProtocolBufferMicroException e16) {
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabel", 2, "convertFromPbBytes failed.", e16);
                }
            } catch (Exception e17) {
                if (QLog.isColorLevel()) {
                    QLog.i("PersonalityLabel", 2, "convertFromPbBytes failed.", e17);
                }
            }
            return convertFromPb(cmd0x8f0_rspbody);
        }
        return new ProfilePersonalityLabelInfo();
    }

    public static byte[] convertToBytes(ProfilePersonalityLabelInfo profilePersonalityLabelInfo) {
        if (profilePersonalityLabelInfo != null) {
            if (QLog.isDevelopLevel()) {
                QLog.i("PersonalityLabel", 4, "convertToBytes:" + profilePersonalityLabelInfo.toString());
            }
            return cd.a(profilePersonalityLabelInfo);
        }
        return null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public boolean equals(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        ProfilePersonalityLabelInfo profilePersonalityLabelInfo = (ProfilePersonalityLabelInfo) obj;
        if (profilePersonalityLabelInfo.personalityLabelInfos.size() != this.personalityLabelInfos.size()) {
            return false;
        }
        for (int i3 = 0; i3 < this.personalityLabelInfos.size(); i3++) {
            if (!profilePersonalityLabelInfo.personalityLabelInfos.get(i3).equals(this.personalityLabelInfos.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public PersonalityLabelInfo getLabelById(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (PersonalityLabelInfo) iPatchRedirector.redirect((short) 13, (Object) this, j3);
        }
        if (getSize() <= 0) {
            return null;
        }
        for (int i3 = 0; i3 < this.personalityLabelInfos.size(); i3++) {
            if (this.personalityLabelInfos.get(i3).f259897id == j3) {
                return this.personalityLabelInfos.get(i3);
            }
        }
        return null;
    }

    public String getLabelTexts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        if (this.personalityLabelInfos == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (int i3 = 0; i3 < this.personalityLabelInfos.size(); i3++) {
            if (i3 != 0) {
                sb5.append('\uff0c');
            }
            sb5.append(this.personalityLabelInfos.get(i3).text);
        }
        return sb5.toString();
    }

    public int getLatestLabelPhotoSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Integer) iPatchRedirector.redirect((short) 10, (Object) this)).intValue();
        }
        List<PersonalityLabelInfo> list = this.personalityLabelInfos;
        if (list == null || list.size() <= 0 || this.personalityLabelInfos.get(0).personalityLabelPhotos == null) {
            return 0;
        }
        return this.personalityLabelInfos.get(0).personalityLabelPhotos.size();
    }

    public String getLatestLabelText() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        List<PersonalityLabelInfo> list = this.personalityLabelInfos;
        if (list != null && list.size() > 0) {
            return this.personalityLabelInfos.get(0).text;
        }
        return "";
    }

    public String getLatestThumbLocalUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        List<PersonalityLabelInfo> list = this.personalityLabelInfos;
        if (list != null && list.size() > 0 && this.personalityLabelInfos.get(0).personalityLabelPhotos != null && this.personalityLabelInfos.get(0).personalityLabelPhotos.size() > 0) {
            return this.personalityLabelInfos.get(0).personalityLabelPhotos.get(0).localThumbPath;
        }
        return null;
    }

    public String getLatestThumbUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        List<PersonalityLabelInfo> list = this.personalityLabelInfos;
        if (list != null && list.size() > 0 && this.personalityLabelInfos.get(0).personalityLabelPhotos != null && this.personalityLabelInfos.get(0).personalityLabelPhotos.size() > 0) {
            return this.personalityLabelInfos.get(0).personalityLabelPhotos.get(0).get350SizeUrl();
        }
        return null;
    }

    public int getSize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this)).intValue();
        }
        List<PersonalityLabelInfo> list = this.personalityLabelInfos;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder(1024);
        sb5.append("currentVersion");
        sb5.append(":");
        sb5.append(CURRENT_VERSION);
        sb5.append("|");
        sb5.append("isCloseByUser");
        boolean z16 = true;
        if (this.isCloseByUser != 1) {
            z16 = false;
        }
        sb5.append(z16);
        sb5.append("|");
        sb5.append("remainCount");
        sb5.append(":");
        sb5.append(this.remainCount);
        sb5.append("|");
        sb5.append("labelInfoSize:");
        sb5.append(this.personalityLabelInfos.size());
        sb5.append("|");
        sb5.append("photoCount:");
        sb5.append(this.photoCount);
        sb5.append("|");
        sb5.append("praiseCount:");
        sb5.append(this.praiseCount);
        sb5.append("|");
        sb5.append("unreadCount:");
        sb5.append(this.unreadCount);
        sb5.append("|");
        sb5.append("lastPraiseUin:");
        sb5.append(this.lastPraiseUin);
        sb5.append("|");
        sb5.append("LabelInfos");
        sb5.append(":[");
        sb5.append(this.personalityLabelInfos);
        sb5.append("]");
        return sb5.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeInt(CURRENT_VERSION);
        parcel.writeTypedList(this.personalityLabelInfos);
        parcel.writeInt(this.remainCount);
        parcel.writeInt(this.photoCount);
        parcel.writeInt(this.praiseCount);
        parcel.writeInt(this.maxPhotoCount);
        parcel.writeInt(this.unreadCount);
        parcel.writeLong(this.lastPraiseUin);
        parcel.writeInt(this.isCloseByUser);
    }

    protected ProfilePersonalityLabelInfo(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            return;
        }
        boolean z16 = false;
        this.isCloseByUser = 0;
        int readInt = parcel.readInt();
        this.personalityLabelInfos = parcel.createTypedArrayList(PersonalityLabelInfo.CREATOR);
        this.remainCount = parcel.readInt();
        this.photoCount = parcel.readInt();
        this.praiseCount = parcel.readInt();
        this.maxPhotoCount = parcel.readInt();
        this.unreadCount = parcel.readInt();
        this.lastPraiseUin = parcel.readLong();
        if (readInt >= 2) {
            this.isCloseByUser = parcel.readInt();
        }
        List<PersonalityLabelInfo> list = this.personalityLabelInfos;
        if (list == null || list.size() <= 0) {
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= this.personalityLabelInfos.size()) {
                break;
            }
            if (this.personalityLabelInfos.get(i3) == null) {
                z16 = true;
                break;
            }
            i3++;
        }
        if (z16) {
            this.personalityLabelInfos.clear();
            a();
        }
    }
}
