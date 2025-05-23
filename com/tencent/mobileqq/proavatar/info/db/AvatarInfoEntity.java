package com.tencent.mobileqq.proavatar.info.db;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes16.dex */
public class AvatarInfoEntity extends Entity implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<AvatarInfoEntity> CREATOR;
    public byte apngFaceFlag;
    public byte bFaceFlags;
    public byte bHeadType;
    public byte bSourceType;
    public byte bUsrType;
    public byte dynamicZplanFaceFlag;
    public long headImgTimestamp;

    @unique
    public String key;
    public byte staticZplanFaceFlag;
    public short systemHeadID;
    public long updateTimestamp;
    public String url;
    public String zplanFaceBgUrl;
    public int zplanFaceClipPercent;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements Parcelable.Creator<AvatarInfoEntity> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AvatarInfoEntity createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AvatarInfoEntity) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            AvatarInfoEntity avatarInfoEntity = new AvatarInfoEntity();
            avatarInfoEntity.readFromParcel(parcel);
            return avatarInfoEntity;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public AvatarInfoEntity[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (AvatarInfoEntity[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new AvatarInfoEntity[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20841);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            CREATOR = new a();
        }
    }

    public AvatarInfoEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.headImgTimestamp = 0L;
        this.systemHeadID = (short) 0;
        this.apngFaceFlag = (byte) 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    public void readFromParcel(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) parcel);
            return;
        }
        this.key = parcel.readString();
        this.headImgTimestamp = parcel.readLong();
        this.systemHeadID = (short) parcel.readInt();
        this.bFaceFlags = parcel.readByte();
        this.bUsrType = parcel.readByte();
        this.bHeadType = parcel.readByte();
        this.url = parcel.readString();
        this.bSourceType = parcel.readByte();
        this.updateTimestamp = parcel.readLong();
        this.staticZplanFaceFlag = parcel.readByte();
        this.dynamicZplanFaceFlag = parcel.readByte();
        this.zplanFaceBgUrl = parcel.readString();
        this.zplanFaceClipPercent = parcel.readInt();
        this.apngFaceFlag = parcel.readByte();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel, i3);
            return;
        }
        parcel.writeString(this.key);
        parcel.writeLong(this.headImgTimestamp);
        parcel.writeInt(this.systemHeadID);
        parcel.writeByte(this.bFaceFlags);
        parcel.writeByte(this.bUsrType);
        parcel.writeByte(this.bHeadType);
        parcel.writeString(this.url);
        parcel.writeByte(this.bSourceType);
        parcel.writeLong(this.updateTimestamp);
        parcel.writeByte(this.staticZplanFaceFlag);
        parcel.writeByte(this.dynamicZplanFaceFlag);
        parcel.writeString(this.zplanFaceBgUrl);
        parcel.writeInt(this.zplanFaceClipPercent);
        parcel.writeByte(this.apngFaceFlag);
    }
}
