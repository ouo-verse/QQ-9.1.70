package cooperation.qzone.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BaseBusinessAlbumInfo implements Parcelable, Cloneable {
    public int allow_share;
    public String individualCover;
    public boolean isAlbumExist;
    public boolean isFake;
    public boolean isIndividualityAlbum;
    public int isShare;
    public int isSharingOwner;
    public String mAlbumId;
    public int mAlbumType;
    public int mAnonymity;
    public String mCover;
    public long mLastUploadTime;
    public int mPrivacy;
    public long mSvrTime;
    public String mTitle;
    public int mTotal;
    public long mUin;
    public int opmask;
    public int sortType;

    public BaseBusinessAlbumInfo(long j3, String str, String str2, String str3, int i3, int i16, int i17, boolean z16) {
        this.isFake = false;
        this.isShare = 0;
        this.isSharingOwner = 0;
        this.sortType = 0;
        this.isAlbumExist = true;
        this.mUin = j3;
        this.mAlbumId = str;
        this.mTitle = str2;
        this.mCover = str3;
        this.mTotal = i3;
        this.mPrivacy = i16;
        this.mAlbumType = i17;
        this.isIndividualityAlbum = z16;
    }

    public void copyFrom(BaseBusinessAlbumInfo baseBusinessAlbumInfo) {
        if (baseBusinessAlbumInfo == null) {
            return;
        }
        this.mAlbumId = baseBusinessAlbumInfo.mAlbumId;
        this.mUin = baseBusinessAlbumInfo.mUin;
        this.mTitle = baseBusinessAlbumInfo.mTitle;
        this.mCover = baseBusinessAlbumInfo.mCover;
        this.mTotal = baseBusinessAlbumInfo.mTotal;
        this.mPrivacy = baseBusinessAlbumInfo.mPrivacy;
        this.mLastUploadTime = baseBusinessAlbumInfo.mLastUploadTime;
        this.mAlbumType = baseBusinessAlbumInfo.mAlbumType;
        this.mSvrTime = baseBusinessAlbumInfo.mSvrTime;
        this.mAnonymity = baseBusinessAlbumInfo.mAnonymity;
        this.isIndividualityAlbum = baseBusinessAlbumInfo.isIndividualityAlbum;
        this.opmask = baseBusinessAlbumInfo.opmask;
        this.allow_share = baseBusinessAlbumInfo.allow_share;
        this.individualCover = baseBusinessAlbumInfo.individualCover;
        this.isShare = baseBusinessAlbumInfo.isShare;
        this.isSharingOwner = baseBusinessAlbumInfo.isSharingOwner;
        this.sortType = baseBusinessAlbumInfo.sortType;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BaseBusinessAlbumInfo baseBusinessAlbumInfo = (BaseBusinessAlbumInfo) obj;
        String str = this.mAlbumId;
        if (str == null) {
            if (baseBusinessAlbumInfo.mAlbumId != null) {
                return false;
            }
        } else if (!str.equals(baseBusinessAlbumInfo.mAlbumId)) {
            return false;
        }
        return true;
    }

    public String getId() {
        return this.mAlbumId;
    }

    public String getTitle() {
        return this.mTitle;
    }

    public int hashCode() {
        int hashCode;
        String str = this.mAlbumId;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        return 31 + hashCode;
    }

    public void updateFrom(BaseBusinessAlbumInfo baseBusinessAlbumInfo) {
        if (baseBusinessAlbumInfo == null) {
            return;
        }
        this.mUin = baseBusinessAlbumInfo.mUin;
        this.mTotal = baseBusinessAlbumInfo.mTotal;
        this.mPrivacy = baseBusinessAlbumInfo.mPrivacy;
        this.mAlbumType = baseBusinessAlbumInfo.mAlbumType;
        if (!TextUtils.isEmpty(baseBusinessAlbumInfo.mTitle)) {
            this.mTitle = baseBusinessAlbumInfo.mTitle;
        }
        if (!TextUtils.isEmpty(baseBusinessAlbumInfo.mCover)) {
            this.mCover = baseBusinessAlbumInfo.mCover;
        }
        this.mSvrTime = baseBusinessAlbumInfo.mSvrTime;
        this.mAnonymity = baseBusinessAlbumInfo.mAnonymity;
        this.isIndividualityAlbum = baseBusinessAlbumInfo.isIndividualityAlbum;
        this.opmask = baseBusinessAlbumInfo.opmask;
        this.allow_share = baseBusinessAlbumInfo.allow_share;
        this.individualCover = baseBusinessAlbumInfo.individualCover;
        this.isShare = baseBusinessAlbumInfo.isShare;
        this.isSharingOwner = baseBusinessAlbumInfo.isSharingOwner;
        this.sortType = baseBusinessAlbumInfo.sortType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.mUin);
        parcel.writeString(this.mAlbumId);
        parcel.writeInt(this.mPrivacy);
        parcel.writeInt(this.mTotal);
        parcel.writeString(this.mCover);
        parcel.writeString(this.mTitle);
        parcel.writeLong(this.mLastUploadTime);
        parcel.writeInt(this.mAlbumType);
        parcel.writeLong(this.mSvrTime);
        parcel.writeInt(this.mAnonymity);
        parcel.writeInt(this.isIndividualityAlbum ? 1 : 0);
        parcel.writeInt(this.opmask);
        parcel.writeInt(this.allow_share);
        parcel.writeString(this.individualCover);
        parcel.writeInt(this.isShare);
        parcel.writeInt(this.isSharingOwner);
        parcel.writeInt(this.sortType);
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BaseBusinessAlbumInfo m469clone() {
        BaseBusinessAlbumInfo baseBusinessAlbumInfo = new BaseBusinessAlbumInfo(this.mAlbumId);
        baseBusinessAlbumInfo.copyFrom(this);
        return baseBusinessAlbumInfo;
    }

    public BaseBusinessAlbumInfo(String str) {
        this.isFake = false;
        this.isIndividualityAlbum = false;
        this.isShare = 0;
        this.isSharingOwner = 0;
        this.sortType = 0;
        this.isAlbumExist = true;
        this.mAlbumId = str;
    }

    public BaseBusinessAlbumInfo() {
        this.isFake = false;
        this.isIndividualityAlbum = false;
        this.isShare = 0;
        this.isSharingOwner = 0;
        this.sortType = 0;
        this.isAlbumExist = true;
    }
}
