package cooperation.qzone.model;

import NS_FASHION_FEEDS_TAG_PROTO.TagInfo;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.galleryactivity.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.panorama.IPanoramaUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import mqq.util.WeakReference;

/* loaded from: classes28.dex */
public class PhotoInfo extends k implements Parcelable {
    public static final Parcelable.Creator<PhotoInfo> CREATOR = new Parcelable.Creator<PhotoInfo>() { // from class: cooperation.qzone.model.PhotoInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoInfo createFromParcel(Parcel parcel) {
            PhotoInfo photoInfo = new PhotoInfo();
            photoInfo.albumId = parcel.readString();
            photoInfo.albumPriv = parcel.readInt();
            photoInfo.currentUrl = parcel.readString();
            photoInfo.bigUrl = parcel.readString();
            photoInfo.orgUrl = parcel.readString();
            photoInfo.downloadUrl = parcel.readString();
            photoInfo.desc = parcel.readString();
            photoInfo.praiseCount = parcel.readInt();
            photoInfo.commentCount = parcel.readInt();
            photoInfo.hasPraise = parcel.readInt() == 1;
            photoInfo.unikey = parcel.readString();
            photoInfo.curkey = parcel.readString();
            photoInfo.lloc = parcel.readString();
            photoInfo.sloc = parcel.readString();
            photoInfo.busi_param = parcel.readHashMap(getClass().getClassLoader());
            photoInfo.mNeedEncodeGifPics = parcel.readArrayList(getClass().getClassLoader());
            photoInfo.mNeedEncodeGifDelay = parcel.readInt();
            photoInfo.photoType = parcel.readInt();
            photoInfo.opsynflag = parcel.readInt();
            photoInfo.isIndependentUgc = parcel.readInt();
            photoInfo.gpsInfo = (GpsInfo4LocalImage) parcel.readParcelable(getClass().getClassLoader());
            photoInfo.isSelected = parcel.readInt() == 1;
            photoInfo.ctime = parcel.readLong();
            photoInfo.date = parcel.readLong();
            ArrayList<ImageTagInfo> arrayList = new ArrayList<>();
            photoInfo.tagList = arrayList;
            parcel.readTypedList(arrayList, ImageTagInfo.CREATOR);
            photoInfo.isFakeFeed = parcel.readInt() == 1;
            photoInfo.showGifState = parcel.readInt();
            photoInfo.flag = parcel.readInt();
            photoInfo.opMask = parcel.readInt();
            photoInfo.allow_share = parcel.readInt();
            photoInfo.videoflag = parcel.readInt();
            photoInfo.videodata = (VideoInfo) parcel.readParcelable(VideoInfo.class.getClassLoader());
            photoInfo.albumName = parcel.readString();
            photoInfo.uploadtime = parcel.readInt();
            photoInfo.photoOpmask = parcel.readInt();
            photoInfo.uploadOwner = parcel.readString();
            photoInfo.uploaduin = parcel.readLong();
            photoInfo.appid = parcel.readInt();
            photoInfo.pssCellId = parcel.readString();
            photoInfo.pssCellSubId = parcel.readString();
            photoInfo.pssUgcKey = parcel.readString();
            photoInfo.pssSubId = parcel.readInt();
            photoInfo.pssCurLikeKey = parcel.readString();
            photoInfo.pssOrgLikeKey = parcel.readString();
            photoInfo.pssBusiParam = parcel.readHashMap(getClass().getClassLoader());
            photoInfo.pssHasFeedPraise = parcel.readInt() == 1;
            photoInfo.shareWeixinUrl = parcel.readString();
            photoInfo.shareQqUrl = parcel.readString();
            photoInfo.shareTitle = parcel.readString();
            photoInfo.shareSummary = parcel.readString();
            photoInfo.sharePhotoUrl = parcel.readString();
            photoInfo.shareSpaceRight = parcel.readInt();
            photoInfo.shareAlbumRight = parcel.readInt();
            photoInfo.hasCheckFace = parcel.readInt() == 1;
            photoInfo.mFaceList = (ArrayList) parcel.readSerializable();
            photoInfo.needShowFaceIcon = parcel.readInt() == 1;
            photoInfo.originSize = parcel.readLong();
            photoInfo.appAdShow = parcel.readInt() == 1;
            photoInfo.appAdText = parcel.readString();
            photoInfo.appAdSchema = parcel.readString();
            photoInfo.picInfoOpen = parcel.readInt() == 1;
            photoInfo.picTaginfoList = parcel.readArrayList(getClass().getClassLoader());
            photoInfo.heightWeightProportion = parcel.readFloat();
            photoInfo.missionId = parcel.readString();
            photoInfo.shareArkInfo = (ShareArkInfo) parcel.readSerializable();
            photoInfo.videoUgcRight = parcel.readInt();
            photoInfo.isShowOriginState = parcel.readInt() == 1;
            photoInfo.isShowRepair = parcel.readInt() == 1;
            photoInfo.isSrUrl = parcel.readInt() == 1;
            photoInfo.groupId = parcel.readString();
            photoInfo.shootingTime = parcel.readInt();
            photoInfo.mOriginWidth = parcel.readInt();
            photoInfo.mOriginHeight = parcel.readInt();
            photoInfo.cellColorfulTail = (CellColorfulTail) parcel.readParcelable(CellColorfulTail.class.getClassLoader());
            return photoInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoInfo[] newArray(int i3) {
            return new PhotoInfo[i3];
        }
    };
    public static final int IMAGE_RESOLUTION_BIG = 1;
    public static final int IMAGE_RESOLUTION_ORIGINAL = 2;
    public static int SHOW_GIF = 2;
    public static int SHOW_NEITHER_GIF_NOR_PLAY = 1;
    public static int SHOW_STATIC_PHOTO;
    public String albumName;
    public int albumPriv;
    public int appid;
    public CellColorfulTail cellColorfulTail;
    public int commentCount;
    public long ctime;
    public long date;
    public GpsInfo4LocalImage gpsInfo;
    public String groupId;
    public boolean hasLoaded;
    public boolean hasShowHighScaleTips;
    private WeakReference<Drawable> imageDrawable;
    public boolean isSelected;
    public boolean isShowOriginState;
    public boolean isShowRepair;
    public boolean isSrUrl;
    public float lastScale;
    public int mBigUrlHeight;
    public int mBigUrlWidth;
    public int mCurrentUrlHeight;
    public int mCurrentUrlWith;
    public int mNeedEncodeGifDelay;
    public int mOriginHeight;
    public int mOriginWidth;
    public String missionId;
    public int opsynflag;
    public int photoOpmask;
    public ArrayList<TagInfo> picTaginfoList;
    public int praiseCount;
    public int progress;
    public Map<Integer, String> pssBusiParam;
    public boolean pssHasFeedPraise;
    public int pssSubId;
    public int shareAlbumRight;
    public ShareArkInfo shareArkInfo;
    public int shareSpaceRight;
    public ArrayList<ImageTagInfo> tagList;
    private WeakReference<Drawable> thumbDrawable;
    public int uploadtime;
    public int videoUgcRight;
    public String albumId = "";
    public String currentUrl = "";
    public String bigUrl = "";
    public String orgUrl = "";
    public String downloadUrl = "";
    public String desc = "";
    public boolean hasPraise = false;
    public String unikey = "";
    public String curkey = "";
    public String lloc = "";
    public String sloc = "";
    public Map<Integer, String> busi_param = new HashMap();
    public ArrayList<String> mNeedEncodeGifPics = new ArrayList<>();
    public int photoType = 1;
    public int isIndependentUgc = -1;
    public int flag = 0;
    public Boolean hasLocalOrgFile = null;
    public boolean hasPreDownload = false;
    public boolean hasVisited = false;
    public boolean quanLoaded = false;
    public boolean isFakeFeed = false;
    public int showGifState = SHOW_STATIC_PHOTO;
    public Boolean hasQRCode = null;
    public Boolean hasQQCode = null;
    public int opMask = 0;
    public int allow_share = 0;
    public int videoflag = 0;
    public VideoInfo videodata = null;
    public String uploadOwner = "";
    public long uploaduin = 0;
    public String pssCellId = "";
    public String pssCellSubId = "";
    public String pssUgcKey = "";
    public String pssCurLikeKey = "";
    public String pssOrgLikeKey = "";
    public String shareWeixinUrl = "";
    public String shareQqUrl = "";
    public String shareTitle = "";
    public String shareSummary = "";
    public String sharePhotoUrl = "";
    public boolean hasCheckFace = false;
    public boolean needShowFaceIcon = false;
    public ArrayList<FaceData> mFaceList = null;
    public long originSize = 0;
    public long fileSize = 0;
    public int imageResolution = 0;
    public boolean appAdShow = false;
    public String appAdText = "";
    public String appAdSchema = "";
    public boolean picInfoOpen = false;
    public float heightWeightProportion = 0.0f;
    public int shootingTime = 0;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.tencent.common.galleryactivity.k
    public Drawable getAnimationDrawable() {
        Drawable imageDrawable = getImageDrawable();
        if (imageDrawable == null) {
            return getThumbDrawable();
        }
        return imageDrawable;
    }

    @Override // com.tencent.common.galleryactivity.k
    public int getCutValue() {
        return 0;
    }

    public Drawable getImageDrawable() {
        WeakReference<Drawable> weakReference = this.imageDrawable;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public String getPicId() {
        if (!TextUtils.isEmpty(this.lloc)) {
            return this.lloc;
        }
        return this.sloc;
    }

    @Override // com.tencent.common.galleryactivity.k
    public int getStartX() {
        return 0;
    }

    @Override // com.tencent.common.galleryactivity.k
    public int getStartY() {
        return 0;
    }

    public Drawable getThumbDrawable() {
        WeakReference<Drawable> weakReference = this.thumbDrawable;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // com.tencent.common.galleryactivity.k
    public Rect getThumbRect() {
        return null;
    }

    public boolean hasFace() {
        if ((this.flag & 2) > 0) {
            return true;
        }
        return false;
    }

    public boolean isPanorama() {
        if (!((IPanoramaUtil) QRoute.api(IPanoramaUtil.class)).isNeedShowPanorama()) {
            return false;
        }
        int i3 = this.flag;
        if (i3 != 32 && i3 != 16) {
            return false;
        }
        return true;
    }

    public boolean isVideo() {
        if (this.videoflag == 1) {
            return true;
        }
        return false;
    }

    public boolean isWebPic() {
        if ((this.flag & 4) > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.common.galleryactivity.k
    public boolean needAnimation(boolean z16) {
        return true;
    }

    public void setImageDrawable(Drawable drawable) {
        if (drawable != null) {
            this.imageDrawable = new WeakReference<>(drawable);
        }
    }

    public String toDebugString() {
        return "PhotoInfo{\nalbumName='" + this.albumName + "'\n, albumId='" + this.albumId + "'\n, albumPriv=" + this.albumPriv + "\n, currentUrl='" + this.currentUrl + "'\n, bigUrl='" + this.bigUrl + "'\n, orgUrl='" + this.orgUrl + "'\n, downloadUrl='" + this.downloadUrl + "'\n, desc='" + this.desc + "'\n, praiseCount=" + this.praiseCount + "\n, commentCount=" + this.commentCount + "\n, hasPraise=" + this.hasPraise + "\n, unikey='" + this.unikey + "'\n, curkey='" + this.curkey + "'\n, lloc='" + this.lloc + "'\n, sloc='" + this.sloc + "'\n, busi_param=" + this.busi_param + "\n, mNeedEncodeGifPics=" + this.mNeedEncodeGifPics + "\n, mNeedEncodeGifDelay=" + this.mNeedEncodeGifDelay + "\n, photoType=" + this.photoType + "\n, opsynflag=" + this.opsynflag + "\n, isIndependentUgc=" + this.isIndependentUgc + "\n, flag=" + this.flag + "\n, isSelected=" + this.isSelected + "\n, hasLoaded=" + this.hasLoaded + "\n, hasShowHighScaleTips=" + this.hasShowHighScaleTips + "\n, lastScale=" + this.lastScale + "\n, hasLocalOrgFile=" + this.hasLocalOrgFile + "\n, progress=" + this.progress + "\n, hasPreDownload=" + this.hasPreDownload + "\n, hasVisited=" + this.hasVisited + "\n, tagList=" + this.tagList + "\n, quanLoaded=" + this.quanLoaded + "\n, isFakeFeed=" + this.isFakeFeed + "\n, showGifState=" + this.showGifState + "\n, ctime=" + this.ctime + "\n, gpsInfo=" + this.gpsInfo + "\n, date=" + this.date + "\n, hasQRCode=" + this.hasQRCode + "\n, opMask=" + this.opMask + "\n, allow_share=" + this.allow_share + "\n, videoflag=" + this.videoflag + "\n, videodata=" + this.videodata.toDebugString() + "\n, uploadtime=" + this.uploadtime + "\n, photoOpmask=" + this.photoOpmask + "\n, uploadOwner='" + this.uploadOwner + "'\n, uploaduin=" + this.uploaduin + "\n, appid=" + this.appid + "\n, pssCellId='" + this.pssCellId + "'\n, pssCellSubId='" + this.pssCellSubId + "'\n, pssUgcKey='" + this.pssUgcKey + "'\n, pssSubId=" + this.pssSubId + "\n, pssCurLikeKey='" + this.pssCurLikeKey + "'\n, pssOrgLikeKey='" + this.pssOrgLikeKey + "'\n, pssBusiParam=" + this.pssBusiParam + "\n, pssHasFeedPraise=" + this.pssHasFeedPraise + "\n, shareWeixinUrl='" + this.shareWeixinUrl + "'\n, shareQqUrl='" + this.shareQqUrl + "'\n, shareTitle='" + this.shareTitle + "'\n, shareSummary='" + this.shareSummary + "'\n, sharePhotoUrl='" + this.sharePhotoUrl + "'\n, shareSpaceRight=" + this.shareSpaceRight + "\n, shareAlbumRight=" + this.shareAlbumRight + "\n, hasCheckFace=" + this.hasCheckFace + "\n, needShowFaceIcon=" + this.needShowFaceIcon + "\n, mFaceList=" + this.mFaceList + "\n, originSize=" + this.originSize + "\n, fileSize=" + this.fileSize + "\n, imageResolution=" + this.imageResolution + "\n, appAdShow=" + this.appAdShow + "\n, appAdText='" + this.appAdText + "'\n, appAdSchema='" + this.appAdSchema + "'\n, picInfoOpen=" + this.picInfoOpen + "\n, thumbDrawable=" + this.thumbDrawable + "\n, imageDrawable=" + this.imageDrawable + "\n, heightWeightProportion=" + this.heightWeightProportion + "\n, missionId=" + this.missionId + "\n, videoUgcRight=" + this.videoUgcRight + "\n, isShowOriginState=" + this.isShowOriginState + "\n, isShowRepair=" + this.isShowRepair + "\n, isSrUrl=" + this.isSrUrl + "\n, groupId=" + this.groupId + "\n, shootingTime=" + this.shootingTime + "\n}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.albumId);
        parcel.writeInt(this.albumPriv);
        parcel.writeString(this.currentUrl);
        parcel.writeString(this.bigUrl);
        parcel.writeString(this.orgUrl);
        parcel.writeString(this.downloadUrl);
        parcel.writeString(this.desc);
        parcel.writeInt(this.praiseCount);
        parcel.writeInt(this.commentCount);
        parcel.writeInt(this.hasPraise ? 1 : 0);
        parcel.writeString(this.unikey);
        parcel.writeString(this.curkey);
        parcel.writeString(this.lloc);
        parcel.writeString(this.sloc);
        parcel.writeMap(this.busi_param);
        parcel.writeList(this.mNeedEncodeGifPics);
        parcel.writeInt(this.mNeedEncodeGifDelay);
        parcel.writeInt(this.photoType);
        parcel.writeInt(this.opsynflag);
        parcel.writeInt(this.isIndependentUgc);
        parcel.writeParcelable(this.gpsInfo, i3);
        parcel.writeInt(this.isSelected ? 1 : 0);
        parcel.writeLong(this.ctime);
        parcel.writeLong(this.date);
        parcel.writeTypedList(this.tagList);
        parcel.writeInt(this.isFakeFeed ? 1 : 0);
        parcel.writeInt(this.showGifState);
        parcel.writeInt(this.flag);
        parcel.writeInt(this.opMask);
        parcel.writeInt(this.allow_share);
        parcel.writeInt(this.videoflag);
        parcel.writeParcelable(this.videodata, i3);
        parcel.writeString(this.albumName);
        parcel.writeInt(this.uploadtime);
        parcel.writeInt(this.photoOpmask);
        parcel.writeString(this.uploadOwner);
        parcel.writeLong(this.uploaduin);
        parcel.writeInt(this.appid);
        parcel.writeString(this.pssCellId);
        parcel.writeString(this.pssCellSubId);
        parcel.writeString(this.pssUgcKey);
        parcel.writeInt(this.pssSubId);
        parcel.writeString(this.pssCurLikeKey);
        parcel.writeString(this.pssOrgLikeKey);
        parcel.writeMap(this.pssBusiParam);
        parcel.writeInt(this.pssHasFeedPraise ? 1 : 0);
        parcel.writeString(this.shareWeixinUrl);
        parcel.writeString(this.shareQqUrl);
        parcel.writeString(this.shareTitle);
        parcel.writeString(this.shareSummary);
        parcel.writeString(this.sharePhotoUrl);
        parcel.writeInt(this.shareSpaceRight);
        parcel.writeInt(this.shareAlbumRight);
        parcel.writeInt(this.hasCheckFace ? 1 : 0);
        parcel.writeSerializable(this.mFaceList);
        parcel.writeInt(this.needShowFaceIcon ? 1 : 0);
        parcel.writeLong(this.originSize);
        parcel.writeInt(this.appAdShow ? 1 : 0);
        parcel.writeString(this.appAdText);
        parcel.writeString(this.appAdSchema);
        parcel.writeInt(this.picInfoOpen ? 1 : 0);
        parcel.writeList(this.picTaginfoList);
        parcel.writeFloat(this.heightWeightProportion);
        parcel.writeString(this.missionId);
        parcel.writeSerializable(this.shareArkInfo);
        parcel.writeInt(this.videoUgcRight);
        parcel.writeInt(this.isShowOriginState ? 1 : 0);
        parcel.writeInt(this.isShowRepair ? 1 : 0);
        parcel.writeInt(this.isSrUrl ? 1 : 0);
        parcel.writeString(this.groupId);
        parcel.writeInt(this.shootingTime);
        parcel.writeInt(this.mOriginWidth);
        parcel.writeInt(this.mOriginHeight);
        parcel.writeParcelable(this.cellColorfulTail, i3);
    }
}
