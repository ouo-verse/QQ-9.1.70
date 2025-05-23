package cooperation.qzone.model;

import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes28.dex */
public class BusinessAlbumInfo extends BaseBusinessAlbumInfo {
    public static final int BABY_ALBUM_TYPE = 8;
    public static final int BABY_ANONYMITY_TYPE_VALUE = 5;
    public static final Parcelable.Creator<BusinessAlbumInfo> CREATOR = new Parcelable.Creator<BusinessAlbumInfo>() { // from class: cooperation.qzone.model.BusinessAlbumInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BusinessAlbumInfo createFromParcel(Parcel parcel) {
            return new BusinessAlbumInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BusinessAlbumInfo[] newArray(int i3) {
            return new BusinessAlbumInfo[i3];
        }
    };
    public static final int DEFAULT_ALBUM_TYPE = 1;
    public static final int DEFAULT_ANONYMITY_TYPE = 1;
    public static final int LOVE_ALBUM_TYPE = 11;
    public static final int LOVE_ANONYMITY_TYPE_VALUE = 8;
    public static final int MULTI_ALBUM_TYPE = 12;
    public static final int MULTI_ANONYMITY_TYPE_VALUT = 9;
    public static final int TRAVEL_ALBUM_TYPE = 9;
    public static final int TRAVEL_ANONYMITY_TYPE_VALUE = 6;
    public static final int TRAVEL_BIG_EVENT_TYPE = 1001;
    public static final int VIDEO_ALBUM_TYPE = 7;
    public static final int VIDEO_TYPE = 10;
    public boolean isFromLastUpload;
    public boolean isMoodAlbum;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static class Privacy {
        public static final int QZ_ALBUM_PERMISSION_ANSWER = 5;
        public static final int QZ_ALBUM_PERMISSION_ANSWER_OLD = 2;
        public static final int QZ_ALBUM_PERMISSION_BLACKLIST = 8;
        public static final int QZ_ALBUM_PERMISSION_FRIEND = 4;
        public static final int QZ_ALBUM_PERMISSION_PRIVATE = 3;
        public static final int QZ_ALBUM_PERMISSION_PUBLIC = 1;
        public static final int QZ_ALBUM_PERMISSION_SAFE_MODE = 10;
        public static final int QZ_ALBUM_PERMISSION_SOMEONE = 6;

        Privacy() {
        }

        public static String getDescription(int i3) {
            return BusinessAlbumInfo.getPrivNameFromAlbum(i3);
        }
    }

    public static BusinessAlbumInfo create(String str) {
        if (str == null) {
            return null;
        }
        return new BusinessAlbumInfo(str);
    }

    public static BusinessAlbumInfo createFrom(String str, int i3, String str2, String str3, int i16, int i17, int i18, long j3, int i19, int i26, boolean z16, String str4, boolean z17) {
        boolean z18;
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(str);
        businessAlbumInfo.mAlbumType = i3;
        businessAlbumInfo.mTitle = str2;
        businessAlbumInfo.mCover = str3;
        businessAlbumInfo.mPrivacy = i16;
        businessAlbumInfo.mTotal = i17;
        businessAlbumInfo.mAnonymity = i18;
        if (j3 == 1) {
            z18 = true;
        } else {
            z18 = false;
        }
        businessAlbumInfo.isIndividualityAlbum = z18;
        businessAlbumInfo.opmask = i19;
        businessAlbumInfo.allow_share = i26;
        businessAlbumInfo.isShare = z16 ? 1 : 0;
        if (j3 == 1) {
            businessAlbumInfo.individualCover = str4;
        }
        businessAlbumInfo.isSharingOwner = z17 ? 1 : 0;
        return businessAlbumInfo;
    }

    public static int getAlbumAnonymityByType(int i3) {
        if (i3 == 8) {
            return 5;
        }
        if (i3 == 9) {
            return 6;
        }
        if (i3 == 11) {
            return 8;
        }
        return 1;
    }

    public static String getIndividualCoverUrl(Album album) {
        MaterialItem materialItem;
        MaterialFile materialFile;
        if (album == null || album.individual != 1 || (materialItem = album.material) == null || (materialFile = materialItem.stBanner) == null || TextUtils.isEmpty(materialFile.strUrl)) {
            return null;
        }
        return album.material.stBanner.strUrl;
    }

    public static String getPrivNameFromAlbum(int i3) {
        int i16;
        switch (i3) {
            case 1:
                i16 = R.string.ghc;
                break;
            case 2:
            case 5:
                i16 = R.string.f172992gc2;
                break;
            case 3:
                i16 = R.string.ghd;
                break;
            case 4:
                i16 = R.string.f172994gc4;
                break;
            case 6:
                i16 = R.string.gc7;
                break;
            case 7:
            case 9:
            default:
                i16 = 0;
                break;
            case 8:
                i16 = R.string.f172993gc3;
                break;
            case 10:
                i16 = R.string.f2191465m;
                break;
        }
        if (i16 == 0) {
            return null;
        }
        return BaseApplication.getContext().getResources().getString(i16);
    }

    public static boolean isEmpty(String str) {
        if (str != null && str.length() != 0) {
            return false;
        }
        return true;
    }

    @Override // cooperation.qzone.model.BaseBusinessAlbumInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // cooperation.qzone.model.BaseBusinessAlbumInfo
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        BusinessAlbumInfo businessAlbumInfo = (BusinessAlbumInfo) obj;
        String str = this.mAlbumId;
        if (str == null) {
            if (businessAlbumInfo.mAlbumId != null) {
                return false;
            }
        } else if (!str.equals(businessAlbumInfo.mAlbumId)) {
            return false;
        }
        return true;
    }

    public String getPrivacyDescription() {
        return Privacy.getDescription(this.mPrivacy);
    }

    @Override // cooperation.qzone.model.BaseBusinessAlbumInfo
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

    public boolean isShareAlbum() {
        if (this.isShare == 1) {
            return true;
        }
        return false;
    }

    public void updateFrom(BusinessAlbumInfo businessAlbumInfo) {
        if (businessAlbumInfo == null) {
            return;
        }
        this.mUin = businessAlbumInfo.mUin;
        this.mTotal = businessAlbumInfo.mTotal;
        this.mPrivacy = businessAlbumInfo.mPrivacy;
        this.mAlbumType = businessAlbumInfo.mAlbumType;
        if (!isEmpty(businessAlbumInfo.mTitle)) {
            this.mTitle = businessAlbumInfo.mTitle;
        }
        if (!isEmpty(businessAlbumInfo.mCover)) {
            this.mCover = businessAlbumInfo.mCover;
        }
        this.mSvrTime = businessAlbumInfo.mSvrTime;
        this.mAnonymity = businessAlbumInfo.mAnonymity;
        this.isIndividualityAlbum = businessAlbumInfo.isIndividualityAlbum;
        this.opmask = businessAlbumInfo.opmask;
        this.allow_share = businessAlbumInfo.allow_share;
        this.individualCover = businessAlbumInfo.individualCover;
        this.isShare = businessAlbumInfo.isShare;
        this.isSharingOwner = businessAlbumInfo.isSharingOwner;
        this.sortType = businessAlbumInfo.sortType;
    }

    public BusinessAlbumInfo(String str) {
        super(str);
        this.isMoodAlbum = false;
        this.isFromLastUpload = false;
    }

    public static BusinessAlbumInfo create(Album album) {
        if (album == null) {
            return null;
        }
        BusinessAlbumInfo businessAlbumInfo = new BusinessAlbumInfo(album.albumid);
        businessAlbumInfo.mPrivacy = album.priv;
        businessAlbumInfo.mLastUploadTime = album.lastuploadtime;
        businessAlbumInfo.mTitle = album.name;
        businessAlbumInfo.mTotal = album.total;
        businessAlbumInfo.mUin = album.uin;
        int i3 = album.type;
        businessAlbumInfo.mAlbumType = i3;
        businessAlbumInfo.mSvrTime = album.svrtime;
        businessAlbumInfo.mCover = album.coverurl;
        businessAlbumInfo.isIndividualityAlbum = (getAlbumAnonymityByType(i3) != 1 || album.material == null || album.individual == 0) ? false : true;
        businessAlbumInfo.opmask = album.opmask;
        businessAlbumInfo.allow_share = album.allow_share;
        businessAlbumInfo.individualCover = getIndividualCoverUrl(album);
        businessAlbumInfo.isShare = album.is_share;
        businessAlbumInfo.sortType = album.sort_type;
        businessAlbumInfo.isMoodAlbum = album.is_mood_album;
        return businessAlbumInfo;
    }

    BusinessAlbumInfo(Parcel parcel) {
        this.isMoodAlbum = false;
        this.isFromLastUpload = false;
        this.mUin = parcel.readLong();
        this.mAlbumId = parcel.readString();
        this.mPrivacy = parcel.readInt();
        this.mTotal = parcel.readInt();
        this.mCover = parcel.readString();
        this.mTitle = parcel.readString();
        this.mLastUploadTime = parcel.readLong();
        this.mAlbumType = parcel.readInt();
        this.mSvrTime = parcel.readLong();
        this.mAnonymity = parcel.readInt();
        this.isIndividualityAlbum = parcel.readInt() == 1;
        this.opmask = parcel.readInt();
        this.allow_share = parcel.readInt();
        this.individualCover = parcel.readString();
        this.isShare = parcel.readInt();
        this.isSharingOwner = parcel.readInt();
        this.sortType = parcel.readInt();
    }
}
