package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.cell_comm;
import NS_MOBILE_FEEDS.cell_comment;
import NS_MOBILE_FEEDS.cell_id;
import NS_MOBILE_FEEDS.cell_like;
import NS_MOBILE_FEEDS.cell_operation;
import NS_MOBILE_FEEDS.s_pic_host;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.Photo;
import NS_MOBILE_PHOTO.s_outshare;
import NS_MOBILE_PHOTO.stFaceInfo;
import NS_MOBILE_PHOTO.stLabelInfo;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Parcel;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.business.albumlist.fragment.AlbumVideoTabFragment;
import com.qzone.business.share.ShareUtils;
import com.qzone.common.account.LoginData;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellCommentInfo;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellIdInfo;
import com.qzone.proxy.feedcomponent.model.CellLikeInfo;
import com.qzone.proxy.feedcomponent.model.CellOperationInfo;
import com.qzone.proxy.feedcomponent.model.CellUserInfo;
import com.qzone.proxy.feedcomponent.model.DetailDataOutShare;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.proxy.feedcomponent.model.VideoInfo;
import com.qzone.proxy.feedcomponent.model.VideoUrl;
import com.qzone.proxy.feedcomponent.util.e;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.FaceData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import photo_share_struct.pic_host;

/* loaded from: classes39.dex */
public class PhotoCacheData extends s4.a implements SmartParcelable {
    public static final String ALBUMID = "albumid";
    public static final String CLIENT_KEY = "client_key";
    public static final String FRIEND_NICK_NAME = "FRIEND_NICK_NAME";
    public static final String LLOC = "lloc";
    public static final String NAME_THIS_OBJECT = "namethisobject";
    public static final String OWNER_UIN = "owner_uin";
    public static final String SHOOTTIME = "shoottime";
    public static int SHOW_GIF = 2;
    public static int SHOW_NEITHER_GIF_NOR_PLAY = 1;
    public static int SHOW_STATIC_PHOTO = 0;
    public static final String TYPE_ALBUMID = "TEXT";
    public static final String TYPE_CLIENT_KEY = "TEXT";
    public static final String TYPE_LLOC = "TEXT";
    public static final String TYPE_OWNER_UIN = "INTEGER";
    public static final String TYPE_SHOOTTIME = "INTEGER";
    public static final String TYPE_THIS_OBJECT = "BLOB";
    public static final String TYPE_UPLOADTIME = "INTEGER";
    public static final String TYPE_VIDEO_FLAG = "INTEGER";
    public static final String UPLOADTIME = "uploadtime";
    public static final String VIDEO_FLAG = "video_flag";

    @NeedParcel
    public String albumName;

    @NeedParcel
    public int allow_share;

    @NeedParcel
    public int appid;

    @NeedParcel
    public long ctime;

    @NeedParcel
    public long date;

    @NeedParcel
    public String faceInfoUrl;

    @NeedParcel
    public boolean hasLoaded;

    @NeedParcel
    public boolean isSelected;

    @NeedParcel
    public boolean isShowRepair;

    @NeedParcel
    public long lastRefreshTime;

    @NeedParcel
    public int opmask;

    @NeedParcel
    public int opsynflag;

    @NeedParcel
    public int photoOpmask;

    @NeedParcel
    public PictureItem picItem;

    @NeedParcel
    public int progress;

    @NeedParcel
    public Map<Integer, String> pssBusiParam;

    @NeedParcel
    public boolean pssHasFeedPraise;

    @NeedParcel
    public int pssSubId;

    @NeedParcel
    public long rawPhotoSize;

    @NeedParcel
    public int shareAlbumRight;

    @NeedParcel
    public int shareSpaceRight;

    @NeedParcel
    public Map<Integer, String> shouzhang_extend_map;

    @NeedParcel
    public ArrayList<AlbumImageTagInfo> tagList;

    @NeedParcel
    public int type;
    private static final int[] PIC_SIZE_TYPE = {11, 3, 1, 0};
    public static final IDBCacheDataWrapper.a<PhotoCacheData> DB_CREATOR = new a();

    @NeedParcel
    public long ownerUin = 0;

    @NeedParcel
    public String albumid = "";

    @NeedParcel
    public String desc = "";

    @NeedParcel
    public String lloc = "";

    @NeedParcel
    public long uploadtime = 0;

    @NeedParcel
    public String unikey = "";

    @NeedParcel
    public String curkey = "";

    @NeedParcel
    public int cmtnum = 0;

    @NeedParcel
    public int likenum = 0;

    @NeedParcel
    public int mylike = 0;

    @NeedParcel
    public int videoflag = 0;

    @NeedParcel
    public VideoInfo videodata = null;

    @NeedParcel
    public long uploadUin = 0;

    @NeedParcel
    public String uploadNickName = "";

    @NeedParcel
    public ArrayList<FaceData> faceList = new ArrayList<>();

    @NeedParcel
    public int fakeType = 2;

    @NeedParcel
    public String clientKey = null;

    @NeedParcel
    public long batch_id = 0;

    @NeedParcel
    public long shoottime = 0;

    @NeedParcel
    public long intervalToBirthTime = 0;

    @NeedParcel
    public String currentUrl = "";

    @NeedParcel
    public String thumbUrl = "";

    @NeedParcel
    public String smallUrl = "";

    @NeedParcel
    public String middleUrl = "";

    @NeedParcel
    public String bigUrl = "";

    @NeedParcel
    public String orgUrl = "";

    @NeedParcel
    public String downloadUrl = "";

    @NeedParcel
    public String sloc = "";

    @NeedParcel
    public Map<Integer, String> busi_param = new HashMap();

    @NeedParcel
    public int isIndependentUgc = -1;

    @NeedParcel
    public int flag = 0;

    @NeedParcel
    public Boolean hasLocalOrgFile = null;

    @NeedParcel
    public boolean hasPreDownload = false;

    @NeedParcel
    public boolean hasVisited = false;

    @NeedParcel
    public boolean quanLoaded = false;

    @NeedParcel
    public int showGifState = SHOW_STATIC_PHOTO;

    @NeedParcel
    public Boolean hasQRCode = null;

    @NeedParcel
    public String pssCellId = "";

    @NeedParcel
    public String pssCellSubId = "";

    @NeedParcel
    public String pssUgcKey = "";

    @NeedParcel
    public String pssCurLikeKey = "";

    @NeedParcel
    public String pssOrgLikeKey = "";

    @NeedParcel
    public String shareWeixinUrl = "";

    @NeedParcel
    public String shareQqUrl = "";

    @NeedParcel
    public String shareTitle = "";

    @NeedParcel
    public String shareSummary = "";

    @NeedParcel
    public String sharePhotoUrl = "";

    @NeedParcel
    public ArrayList<String> labelInfos = new ArrayList<>();

    @NeedParcel
    public Map<String, String> mapExtern = new HashMap();

    private static void createFaceAndLabelInfo(PhotoCacheData photoCacheData, Photo photo) {
        ArrayList<String> arrayList;
        stFaceInfo stfaceinfo = photo.face_info;
        if (stfaceinfo != null && !TextUtils.isEmpty(stfaceinfo.url)) {
            photoCacheData.faceInfoUrl = photo.face_info.url;
        } else {
            photoCacheData.faceInfoUrl = "";
        }
        stLabelInfo stlabelinfo = photo.label_info;
        if (stlabelinfo != null && (arrayList = stlabelinfo.labels) != null && arrayList.size() > 0) {
            photoCacheData.labelInfos = photo.label_info.labels;
        } else {
            photoCacheData.labelInfos = null;
        }
    }

    public static PhotoCacheData createFrom(Album album, Photo photo, int i3, cell_id cell_idVar, cell_comm cell_commVar, cell_operation cell_operationVar, cell_like cell_likeVar, cell_comment cell_commentVar, s_outshare s_outshareVar) {
        return createFrom(album, photo, i3, cell_idVar, cell_commVar, cell_operationVar, cell_likeVar, cell_commentVar, s_outshareVar, false);
    }

    private static void createShuoShuoInfo(PhotoCacheData photoCacheData, Album album) {
        if (album != null) {
            if (photoCacheData.ownerUin < 10001) {
                long j3 = album.uin;
                if (j3 >= 10001) {
                    photoCacheData.ownerUin = j3;
                }
            }
            if (TextUtils.isEmpty(photoCacheData.albumid) && !TextUtils.isEmpty(album.albumid)) {
                photoCacheData.albumid = album.albumid;
            }
            photoCacheData.allow_share = album.allow_share;
            photoCacheData.opmask = album.opmask;
            photoCacheData.albumName = album.name;
        }
    }

    private static String fetchSharePhotoUrl(Map<Integer, s_picurl> map) {
        if (map == null) {
            return "";
        }
        for (int i3 : PIC_SIZE_TYPE) {
            if (map.containsKey(Integer.valueOf(i3)) && map.get(Integer.valueOf(i3)) != null && map.get(Integer.valueOf(i3)).url != null) {
                return map.get(Integer.valueOf(i3)).url;
            }
        }
        return "";
    }

    private void setCellFeedOpMask(CellFeedCommInfo cellFeedCommInfo) {
        setShareOpMask();
        cellFeedCommInfo.operatemask = this.photoOpmask;
        if (this.ownerUin == LoginData.getInstance().getUin()) {
            cellFeedCommInfo.operatemask |= 1024;
        } else {
            cellFeedCommInfo.operatemask |= 2097152;
        }
        cellFeedCommInfo.ugcRight = this.shareAlbumRight;
        cellFeedCommInfo.spaceRight = this.shareSpaceRight;
        cellFeedCommInfo.operatemask2 = 512;
    }

    private void setShareOpMask() {
        int d16 = ShareUtils.d(this.ownerUin == LoginData.getInstance().getUin(), this.shareSpaceRight, this.shareAlbumRight, false, false);
        if (d16 == 0 || d16 == 4) {
            this.photoOpmask = this.photoOpmask | 16384 | 8192;
        }
        int c16 = ShareUtils.c(this.appid, this.ownerUin == LoginData.getInstance().getUin(), this.shareSpaceRight, this.shareAlbumRight);
        if (c16 == 0 || c16 == 4) {
            this.photoOpmask |= 2;
        }
    }

    public BusinessFeedData changeToBusinessFeedData(AlbumCacheData albumCacheData) {
        BusinessFeedData businessFeedData = new BusinessFeedData();
        setCommonInfo(businessFeedData);
        if (this.appid == 311) {
            return getShuoShuoFeedData(businessFeedData);
        }
        return getPhotoFeedData(businessFeedData, albumCacheData);
    }

    public PictureUrl getBigPictureUrl() {
        int i3 = 0;
        if (!isVideo()) {
            PictureItem pictureItem = this.picItem;
            PictureUrl[] pictureUrlArr = {pictureItem.bigUrl, pictureItem.originUrl, pictureItem.currentUrl};
            while (i3 < 3) {
                PictureUrl pictureUrl = pictureUrlArr[i3];
                if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                    return pictureUrl;
                }
                i3++;
            }
            return null;
        }
        VideoInfo videoInfo = this.videodata;
        PictureUrl[] pictureUrlArr2 = {videoInfo.bigUrl, videoInfo.originUrl, videoInfo.coverUrl, videoInfo.currentUrl};
        while (i3 < 4) {
            PictureUrl pictureUrl2 = pictureUrlArr2[i3];
            if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
                return pictureUrl2;
            }
            i3++;
        }
        if (this.videodata.getPicUrlDec() != null) {
            return this.videodata.getPicUrlDec();
        }
        return null;
    }

    public String getBigUrl() {
        int i3 = 0;
        if (!isVideo()) {
            PictureItem pictureItem = this.picItem;
            PictureUrl[] pictureUrlArr = {pictureItem.bigUrl, pictureItem.originUrl, pictureItem.currentUrl};
            while (i3 < 3) {
                PictureUrl pictureUrl = pictureUrlArr[i3];
                if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                    return pictureUrl.url;
                }
                i3++;
            }
            return null;
        }
        VideoInfo videoInfo = this.videodata;
        PictureUrl[] pictureUrlArr2 = {videoInfo.bigUrl, videoInfo.originUrl, videoInfo.coverUrl, videoInfo.currentUrl};
        while (i3 < 4) {
            PictureUrl pictureUrl2 = pictureUrlArr2[i3];
            if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
                return pictureUrl2.url;
            }
            i3++;
        }
        if (this.videodata.getPicUrlDec() != null) {
            return this.videodata.getPicUrlDec().url;
        }
        return null;
    }

    public String getCurrentUrl() {
        PictureUrl pictureUrl;
        if (!isVideo()) {
            PictureItem pictureItem = this.picItem;
            if (pictureItem == null || (pictureUrl = pictureItem.currentUrl) == null) {
                return null;
            }
            return pictureUrl.url;
        }
        VideoInfo videoInfo = this.videodata;
        PictureUrl[] pictureUrlArr = {videoInfo.currentUrl, videoInfo.bigUrl, videoInfo.originUrl, videoInfo.coverUrl};
        for (int i3 = 0; i3 < 4; i3++) {
            PictureUrl pictureUrl2 = pictureUrlArr[i3];
            if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
                return pictureUrl2.url;
            }
        }
        return null;
    }

    public String getDownloadVideoUrl() {
        if (!isVideo()) {
            return null;
        }
        VideoUrl videoUrl = this.videodata.downloadVideoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            return this.videodata.downloadVideoUrl.url;
        }
        return getHighPriorityVideoUrl();
    }

    public String getHighPriorityVideoUrl() {
        if (this.videoflag != 1) {
            return null;
        }
        VideoUrl videoUrl = this.videodata.originVideoUrl;
        if (videoUrl != null && !TextUtils.isEmpty(videoUrl.url)) {
            return this.videodata.originVideoUrl.url;
        }
        VideoUrl videoUrl2 = this.videodata.highBrUrl;
        if (videoUrl2 != null && !TextUtils.isEmpty(videoUrl2.url)) {
            return this.videodata.highBrUrl.url;
        }
        VideoUrl videoUrl3 = this.videodata.videoUrl;
        if (videoUrl3 == null || TextUtils.isEmpty(videoUrl3.url)) {
            return null;
        }
        return this.videodata.videoUrl.url;
    }

    public BusinessFeedData getPhotoFeedData(BusinessFeedData businessFeedData, AlbumCacheData albumCacheData) {
        Map<Integer, String> map;
        CellIdInfo cellIdInfo = new CellIdInfo();
        cellIdInfo.cellId = this.albumid;
        businessFeedData.setCellIdInfo(cellIdInfo);
        CellFeedCommInfo cellFeedCommInfo = new CellFeedCommInfo();
        cellFeedCommInfo.appid = this.appid;
        if (albumCacheData != null && (map = albumCacheData.busi_param) != null) {
            cellFeedCommInfo.orglikekey = map.get(5);
            cellFeedCommInfo.curlikekey = albumCacheData.busi_param.get(6);
        }
        if (TextUtils.isEmpty(cellFeedCommInfo.orglikekey)) {
            cellFeedCommInfo.orglikekey = this.unikey;
        }
        if (TextUtils.isEmpty(cellFeedCommInfo.curlikekey)) {
            cellFeedCommInfo.curlikekey = this.curkey;
        }
        setCellFeedOpMask(cellFeedCommInfo);
        businessFeedData.setCellFeedCommInfo(cellFeedCommInfo);
        CellOperationInfo cellOperationInfo = new CellOperationInfo();
        if (this.busi_param == null) {
            this.busi_param = new HashMap();
        }
        this.busi_param.put(2, this.lloc);
        this.busi_param.put(1, this.lloc);
        this.busi_param.put(7, "1");
        this.busi_param.put(12, this.albumid);
        cellOperationInfo.busiParam = this.busi_param;
        DetailDataOutShare detailDataOutShare = new DetailDataOutShare();
        detailDataOutShare.sSummary = this.shareSummary;
        detailDataOutShare.sTitle = this.shareTitle;
        HashMap hashMap = new HashMap(4);
        detailDataOutShare.mapPhotoUrl = hashMap;
        hashMap.put(11, this.videodata.currentUrl);
        detailDataOutShare.mapPhotoUrl.put(3, this.videodata.currentUrl);
        detailDataOutShare.mapPhotoUrl.put(1, this.videodata.bigUrl);
        detailDataOutShare.mapPhotoUrl.put(0, this.videodata.originUrl);
        cellOperationInfo.shareData = detailDataOutShare;
        businessFeedData.setCellOperationInfo(cellOperationInfo);
        CellLikeInfo cellLikeInfo = new CellLikeInfo();
        cellLikeInfo.likeNum = this.likenum;
        cellLikeInfo.isLiked = this.mylike == 1;
        businessFeedData.cellLikeInfo = cellLikeInfo;
        return businessFeedData;
    }

    public PictureUrl getRecentVideoCoverUrl(boolean z16) {
        PictureUrl[] pictureUrlArr;
        if (this.videodata != null && isVideo()) {
            if (z16) {
                VideoInfo videoInfo = this.videodata;
                pictureUrlArr = new PictureUrl[]{videoInfo.dynamicCoverUrl, videoInfo.bigUrl, videoInfo.originUrl, videoInfo.coverUrl, videoInfo.currentUrl};
            } else {
                VideoInfo videoInfo2 = this.videodata;
                pictureUrlArr = new PictureUrl[]{videoInfo2.bigUrl, videoInfo2.originUrl, videoInfo2.coverUrl, videoInfo2.currentUrl};
            }
            for (PictureUrl pictureUrl : pictureUrlArr) {
                if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                    return pictureUrl;
                }
            }
        }
        return null;
    }

    public BusinessFeedData getShuoShuoFeedData(BusinessFeedData businessFeedData) {
        CellIdInfo cellIdInfo = new CellIdInfo();
        cellIdInfo.cellId = this.pssCellId;
        cellIdInfo.subId = this.pssCellSubId;
        businessFeedData.setCellIdInfo(cellIdInfo);
        CellLikeInfo cellLikeInfo = new CellLikeInfo();
        cellLikeInfo.likeNum = this.likenum;
        cellLikeInfo.isLiked = this.pssHasFeedPraise;
        businessFeedData.cellLikeInfo = cellLikeInfo;
        CellFeedCommInfo cellFeedCommInfo = new CellFeedCommInfo();
        cellFeedCommInfo.orglikekey = this.pssOrgLikeKey;
        cellFeedCommInfo.curlikekey = this.pssCurLikeKey;
        cellFeedCommInfo.ugckey = this.pssUgcKey;
        cellFeedCommInfo.subid = this.pssSubId;
        cellFeedCommInfo.appid = this.appid;
        setCellFeedOpMask(cellFeedCommInfo);
        businessFeedData.setCellFeedCommInfo(cellFeedCommInfo);
        CellOperationInfo cellOperationInfo = new CellOperationInfo();
        if (this.pssBusiParam == null) {
            this.pssBusiParam = new HashMap();
        }
        this.pssBusiParam.put(2, this.lloc);
        this.pssBusiParam.put(1, this.lloc);
        this.pssBusiParam.put(7, "1");
        this.pssBusiParam.put(12, this.albumid);
        cellOperationInfo.busiParam = this.pssBusiParam;
        DetailDataOutShare detailDataOutShare = new DetailDataOutShare();
        detailDataOutShare.sSummary = this.shareSummary;
        detailDataOutShare.sTitle = this.shareTitle;
        new PictureUrl().url = this.shareQqUrl;
        HashMap hashMap = new HashMap(4);
        detailDataOutShare.mapPhotoUrl = hashMap;
        hashMap.put(11, this.videodata.currentUrl);
        detailDataOutShare.mapPhotoUrl.put(3, this.videodata.currentUrl);
        detailDataOutShare.mapPhotoUrl.put(1, this.videodata.bigUrl);
        detailDataOutShare.mapPhotoUrl.put(0, this.videodata.originUrl);
        cellOperationInfo.shareData = detailDataOutShare;
        businessFeedData.setCellOperationInfo(cellOperationInfo);
        return businessFeedData;
    }

    public PictureUrl getUrlForMd5() {
        PictureItem pictureItem = this.picItem;
        if (pictureItem == null) {
            return null;
        }
        PictureUrl pictureUrl = pictureItem.bigUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            return this.picItem.bigUrl;
        }
        PictureUrl pictureUrl2 = this.picItem.originUrl;
        if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
            return this.picItem.originUrl;
        }
        PictureUrl pictureUrl3 = this.picItem.currentUrl;
        if (pictureUrl3 == null || TextUtils.isEmpty(pictureUrl3.url)) {
            return null;
        }
        return this.picItem.currentUrl;
    }

    public PictureUrl getVideoCoverUrl() {
        if (this.videodata != null && isVideo()) {
            VideoInfo videoInfo = this.videodata;
            PictureUrl[] pictureUrlArr = {videoInfo.currentUrl, videoInfo.bigUrl, videoInfo.originUrl, videoInfo.coverUrl};
            for (int i3 = 0; i3 < 4; i3++) {
                PictureUrl pictureUrl = pictureUrlArr[i3];
                if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
                    return pictureUrl;
                }
            }
        }
        return null;
    }

    public boolean isFakePhoto() {
        return !TextUtils.isEmpty(this.clientKey);
    }

    public boolean isGif() {
        return this.type == 2;
    }

    public boolean isGifPhoto() {
        return this.type == 2;
    }

    public boolean isLongPhoto() {
        return this.flag == 1;
    }

    public boolean isVideo() {
        return this.videoflag == 1;
    }

    public void setCommonInfo(BusinessFeedData businessFeedData) {
        businessFeedData.setVideoInfo(this.videodata);
        CellCommentInfo cellCommentInfo = new CellCommentInfo();
        int i3 = this.cmtnum;
        cellCommentInfo.commentNum = i3;
        cellCommentInfo.realCount = i3;
        businessFeedData.setCellCommentInfo(cellCommentInfo);
        CellUserInfo cellUserInfo = new CellUserInfo();
        User user = new User();
        long j3 = this.ownerUin;
        user.uin = j3;
        if (AlbumVideoTabFragment.C0.containsKey(Long.valueOf(j3))) {
            user.nickName = AlbumVideoTabFragment.C0.get(Long.valueOf(this.ownerUin));
        } else {
            x6.a g16 = z5.a.f().g(user.uin);
            if (g16 != null) {
                user.nickName = g16.nickName;
                AlbumVideoTabFragment.C0.put(Long.valueOf(user.uin), g16.nickName);
            } else {
                Map<String, String> map = this.mapExtern;
                if (map != null && !TextUtils.isEmpty(map.get(FRIEND_NICK_NAME))) {
                    user.nickName = this.mapExtern.get(FRIEND_NICK_NAME);
                    AlbumVideoTabFragment.C0.put(Long.valueOf(user.uin), this.mapExtern.get(FRIEND_NICK_NAME));
                }
            }
        }
        cellUserInfo.setUser(user);
        businessFeedData.setCellUserInfo(cellUserInfo);
    }

    public String toString() {
        return "(lloc, " + this.lloc + ")\n(desc, " + this.desc + ")\n(uploadtime, " + this.uploadtime + ")\n++(picItem, " + this.picItem.getDebugInfo() + ")++\n(unikey, " + this.unikey + ")\n(curkey, " + this.curkey + ")\n(albumid, " + this.albumid + ")\n(lastRefreshTime, " + this.lastRefreshTime + ")\n(shoottime, " + this.shoottime + ")\n(intervalToBirthTime, " + this.intervalToBirthTime + ")\n(cmtnum, " + this.cmtnum + ")\n(likenum, " + this.likenum + ")\n(mylike, " + this.mylike + ")\n(type, " + this.type + ")\n(fakeType, " + this.fakeType + ")\n(clientKey, " + this.clientKey + ")\n(ownerUin, " + this.ownerUin + ")\n(allow_share, " + this.allow_share + ")\n(opmask, " + this.opmask + ")\n(videoflag, " + this.videoflag + ")\n(videodata, " + this.videodata + ")\n(albumName, " + this.albumName + ")\n(photoOpmask, " + this.photoOpmask + ")\n(uploadUin, " + this.uploadUin + ")\n(uploadNickName, " + this.uploadNickName + ")\n++(faceList, " + this.faceList + ")\n(batch_id, " + this.batch_id + ")\n(currentUrl, " + this.currentUrl + ")\n(thumbUrl, " + this.thumbUrl + ")\n(smallUrl, " + this.smallUrl + ")\n(middleUrl, " + this.middleUrl + ")\n(bigUrl, " + this.bigUrl + ")\n(orgUrl, " + this.orgUrl + ")\n(downloadUrl, " + this.downloadUrl + ")\n(sloc, " + this.sloc + ")\n(opsynflag, " + this.opsynflag + ")\n(isIndependentUgc, " + this.isIndependentUgc + ")\n(flag, " + this.flag + ")\n(isSelected, " + this.isSelected + ")\n(hasLoaded, " + this.hasLoaded + ")\n(isShowRepair, " + this.isShowRepair + ")\n(hasLocalOrgFile, " + this.hasLocalOrgFile + ")\n(progress, " + this.progress + ")\n(hasPreDownload, " + this.hasPreDownload + ")\n(hasVisited, " + this.hasVisited + ")\n(quanLoaded, " + this.quanLoaded + ")\n(showGifState, " + this.showGifState + ")\n(ctime, " + this.ctime + ")\n(date, " + this.date + ")\n(hasQRCode, " + this.hasQRCode + ")\n(appid, " + this.appid + ")\n(pssCellId, " + this.pssCellId + ")\n(pssCellSubId, " + this.pssCellSubId + ")\n(pssUgcKey, " + this.pssUgcKey + ")\n(pssSubId, " + this.pssSubId + ")\n(pssCurLikeKey, " + this.pssCurLikeKey + ")\n(pssOrgLikeKey, " + this.pssOrgLikeKey + ")\n(pssHasFeedPraise, " + this.pssHasFeedPraise + ")\n(shareWeixinUrl, " + this.shareWeixinUrl + ")\n(shareQqUrl, " + this.shareQqUrl + ")\n(shareTitle, " + this.shareTitle + ")\n(shareSummary, " + this.shareSummary + ")\n(sharePhotoUrl, " + this.sharePhotoUrl + ")\n(shareSpaceRight, " + this.shareSpaceRight + ")\n(shareAlbumRight, " + this.shareAlbumRight + ")\n(faceInfoUrl, " + this.faceInfoUrl + ")\n(labelInfos, " + this.labelInfos + ")\n(busi_param, " + this.busi_param + ")\n(tagList, " + this.tagList + ")\n(pssBusiParam, " + this.pssBusiParam + ")";
    }

    public void updateFeedPraiseAndCount(boolean z16) {
        this.pssHasFeedPraise = z16;
        if (this.isIndependentUgc == 0) {
            this.mylike = z16 ? 1 : 0;
        }
        updatePraiseCount(z16);
    }

    public void updatePhotoPraise(boolean z16) {
        this.mylike = z16 ? 1 : 0;
    }

    public void updatePhotoPraiseAndCount(boolean z16) {
        this.mylike = z16 ? 1 : 0;
        updatePraiseCount(z16);
    }

    @Override // s4.a, com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("lloc", this.lloc);
        contentValues.put("uploadtime", Long.valueOf(this.uploadtime));
        contentValues.put("albumid", this.albumid);
        contentValues.put(SHOOTTIME, Long.valueOf(this.shoottime));
        contentValues.put(OWNER_UIN, Long.valueOf(this.ownerUin));
        contentValues.put(VIDEO_FLAG, Integer.valueOf(this.videoflag));
        contentValues.put("client_key", this.clientKey);
        Parcel obtain = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain, 0, this);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(NAME_THIS_OBJECT, marshall);
    }

    public static PhotoCacheData createFrom(Album album, Photo photo, int i3, cell_id cell_idVar, cell_comm cell_commVar, cell_operation cell_operationVar, cell_like cell_likeVar, cell_comment cell_commentVar, s_outshare s_outshareVar, boolean z16) {
        PictureItem pictureItem;
        if (photo == null) {
            return null;
        }
        PhotoCacheData photoCacheData = new PhotoCacheData();
        photoCacheData.ownerUin = photo.uin;
        photoCacheData.albumid = photo.albumid;
        PictureItem pictureItem2 = new PictureItem();
        photoCacheData.picItem = pictureItem2;
        pictureItem2.bigUrl.url = !TextUtils.isEmpty(photo.bigurl) ? photo.bigurl : "";
        photoCacheData.picItem.currentUrl.url = !TextUtils.isEmpty(photo.currenturl) ? photo.currenturl : "";
        photoCacheData.picItem.originUrl.url = !TextUtils.isEmpty(photo.url) ? photo.url : "";
        photoCacheData.picItem.downloadUrl.url = !TextUtils.isEmpty(photo.downloadURL) ? photo.downloadURL : "";
        if (z16 && (pictureItem = photoCacheData.picItem) != null && !TextUtils.isEmpty(pictureItem.bigUrl.url)) {
            PictureItem pictureItem3 = photoCacheData.picItem;
            pictureItem3.lloc = photo.lloc;
            PictureUrl pictureUrl = pictureItem3.bigUrl;
            pictureUrl.width = photo.width;
            pictureUrl.height = photo.height;
        }
        if (!TextUtils.isEmpty(photo.currenturl)) {
            photoCacheData.currentUrl = photo.currenturl;
        } else {
            photoCacheData.currentUrl = "";
        }
        if (!TextUtils.isEmpty(photo.thumburl)) {
            photoCacheData.thumbUrl = photo.thumburl;
        } else {
            photoCacheData.thumbUrl = "";
        }
        if (!TextUtils.isEmpty(photo.smallurl)) {
            photoCacheData.smallUrl = photo.smallurl;
        } else {
            photoCacheData.smallUrl = "";
        }
        if (!TextUtils.isEmpty(photo.midurl)) {
            photoCacheData.middleUrl = photo.midurl;
        } else {
            photoCacheData.middleUrl = "";
        }
        if (!TextUtils.isEmpty(photo.bigurl)) {
            photoCacheData.bigUrl = photo.bigurl;
        } else {
            photoCacheData.bigUrl = "";
        }
        if (!TextUtils.isEmpty(photo.url)) {
            photoCacheData.orgUrl = photo.url;
        } else {
            photoCacheData.orgUrl = "";
        }
        if (!TextUtils.isEmpty(photo.downloadURL)) {
            photoCacheData.downloadUrl = photo.downloadURL;
        } else {
            photoCacheData.downloadUrl = "";
        }
        photoCacheData.type = photo.type;
        photoCacheData.likenum = photo.likenum;
        photoCacheData.cmtnum = photo.cmtnum;
        photoCacheData.mylike = photo.mylike;
        photoCacheData.unikey = photo.unikey;
        photoCacheData.curkey = photo.curkey;
        photoCacheData.lloc = photo.lloc;
        photoCacheData.sloc = photo.sloc;
        photoCacheData.desc = photo.desc;
        Map<Integer, String> map = photo.busi_param;
        if (map != null) {
            Map<Integer, String> map2 = photoCacheData.busi_param;
            if (map2 != null) {
                String str = map2.get(54);
                photoCacheData.busi_param = photo.busi_param;
                if (!TextUtils.isEmpty(str)) {
                    photoCacheData.busi_param.put(54, str);
                }
            } else {
                photoCacheData.busi_param = map;
            }
        }
        photoCacheData.opsynflag = photo.opsynflag;
        photoCacheData.isIndependentUgc = photo.isIndependentUgc;
        ArrayList<AlbumImageTagInfo> createListFrom = AlbumImageTagInfo.createListFrom(photo.photoTag);
        if (createListFrom != null && !createListFrom.isEmpty()) {
            photoCacheData.tagList = createListFrom;
        }
        int i16 = photo.flag;
        photoCacheData.flag = i16;
        if (photo.quanflag != 0) {
            photoCacheData.flag = i16 | 2;
        }
        photoCacheData.videoflag = photo.videoflag;
        VideoInfo s16 = e.s(photo.videodata);
        photoCacheData.videodata = s16;
        if (s16 != null && photoCacheData.videoflag == 1) {
            s16.albumid = photo.albumid;
            s16.lloc = photo.lloc;
        }
        photoCacheData.uploadtime = photo.uploadtime;
        if (z16) {
            photoCacheData.shoottime = photo.shoottime;
            photoCacheData.mapExtern = photo.mapExtern;
            photoCacheData.rawPhotoSize = photo.origin_size;
        }
        photoCacheData.photoOpmask = photo.opmask;
        photoCacheData.isShowRepair = photo.is_show_repair;
        pic_host pic_hostVar = photo.pic_host_nick;
        photoCacheData.uploadNickName = pic_hostVar != null ? pic_hostVar.nick : "";
        photoCacheData.uploadUin = pic_hostVar != null ? pic_hostVar.uin : 0L;
        photoCacheData.appid = i3;
        overridePhotoByVideo(photoCacheData);
        if (!TextUtils.isEmpty(photoCacheData.orgUrl) && photoCacheData.hasLocalOrgFile == null) {
            photoCacheData.hasLocalOrgFile = Boolean.valueOf(ImageLoader.getInstance().getImageFile(photoCacheData.orgUrl) != null);
        }
        createShuoShuoInfo(photoCacheData, album);
        createShuoShuoInfo(photoCacheData, i3, cell_idVar, cell_commVar, cell_operationVar, cell_likeVar, cell_commentVar);
        createShareInfo(photoCacheData, s_outshareVar);
        createFaceAndLabelInfo(photoCacheData, photo);
        photoCacheData.faceList = FaceData.toFaceDataList(photo.facelist, photoCacheData.albumid, photoCacheData.ownerUin);
        photoCacheData.shouzhang_extend_map = photo.shouzhang_extend_map;
        if (!TextUtils.isEmpty(album.albumowner)) {
            photoCacheData.mapExtern.put(FRIEND_NICK_NAME, album.albumowner);
        }
        return photoCacheData;
    }

    private static void createShareInfo(PhotoCacheData photoCacheData, s_outshare s_outshareVar) {
        if (s_outshareVar != null) {
            photoCacheData.shareWeixinUrl = s_outshareVar.weixin_url;
            photoCacheData.shareQqUrl = s_outshareVar.qq_url;
            photoCacheData.shareTitle = s_outshareVar.title;
            photoCacheData.shareSummary = s_outshareVar.summary;
            photoCacheData.sharePhotoUrl = fetchSharePhotoUrl(s_outshareVar.photourl);
            photoCacheData.shareSpaceRight = s_outshareVar.space_right;
            photoCacheData.shareAlbumRight = s_outshareVar.album_right;
        }
    }

    private void updatePraiseCount(boolean z16) {
        if (z16) {
            this.likenum++;
        } else {
            this.likenum--;
        }
        if (this.likenum < 0) {
            this.likenum = 0;
        }
    }

    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<PhotoCacheData> {
        a() {
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PhotoCacheData createFromCursor(Cursor cursor) {
            byte[] blob = cursor.getBlob(cursor.getColumnIndex(PhotoCacheData.NAME_THIS_OBJECT));
            if (blob == null) {
                return null;
            }
            try {
                Parcel obtain = Parcel.obtain();
                obtain.unmarshall(blob, 0, blob.length);
                obtain.setDataPosition(0);
                PhotoCacheData photoCacheData = (PhotoCacheData) ParcelableWrapper.createDataFromParcel(obtain);
                OaidMonitor.parcelRecycle(obtain);
                return photoCacheData;
            } catch (Exception e16) {
                e16.printStackTrace();
                return null;
            }
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return " CREATE INDEX IF NOT EXISTS lloc_index  ON " + str + " (lloc);CREATE INDEX IF NOT EXISTS albumid_index  ON " + str + " (albumid);CREATE INDEX IF NOT EXISTS shoottime_index  ON " + str + " (" + PhotoCacheData.SHOOTTIME + ");CREATE INDEX IF NOT EXISTS uploadtime_index  ON " + str + " (uploadtime);CREATE INDEX IF NOT EXISTS owneruin_index  ON " + str + " (" + PhotoCacheData.OWNER_UIN + ");CREATE INDEX IF NOT EXISTS albumid_and_shoottime_index  ON " + str + " (albumid, " + PhotoCacheData.SHOOTTIME + ")";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("lloc", "TEXT"), new IDBCacheDataWrapper.c("uploadtime", "INTEGER"), new IDBCacheDataWrapper.c("albumid", "TEXT"), new IDBCacheDataWrapper.c(PhotoCacheData.SHOOTTIME, "INTEGER"), new IDBCacheDataWrapper.c(PhotoCacheData.OWNER_UIN, "INTEGER"), new IDBCacheDataWrapper.c(PhotoCacheData.VIDEO_FLAG, "INTEGER"), new IDBCacheDataWrapper.c("client_key", "TEXT"), new IDBCacheDataWrapper.c(PhotoCacheData.NAME_THIS_OBJECT, "BLOB")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 23;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public int delRawSql(SQLiteDatabase sQLiteDatabase, String str, String str2) {
            String[] split;
            if (sQLiteDatabase == null) {
                return 0;
            }
            if (!TextUtils.isEmpty(str2) && str2.contains(ContainerUtils.KEY_VALUE_DELIMITER) && !str2.contains(" and ") && !str2.contains(" AND ") && !str2.contains(" or ") && !str2.contains(" OR ") && (split = str2.split(ContainerUtils.KEY_VALUE_DELIMITER)) != null && split.length > 1 && !TextUtils.isEmpty(split[0]) && !TextUtils.isEmpty(split[1])) {
                String trim = split[0].trim();
                String replace = split[1].trim().replace("'", "");
                if (!TextUtils.isEmpty(trim) && !TextUtils.isEmpty(replace)) {
                    return sQLiteDatabase.delete(str, trim + "=? ", new String[]{replace});
                }
            }
            return sQLiteDatabase.delete(str, str2, null);
        }
    }

    private static void overridePhotoByVideo(PhotoCacheData photoCacheData) {
        VideoInfo videoInfo;
        String str;
        if (photoCacheData == null || photoCacheData.videoflag != 1 || (videoInfo = photoCacheData.videodata) == null) {
            return;
        }
        PictureUrl pictureUrl = videoInfo.currentUrl;
        if (pictureUrl != null && !TextUtils.isEmpty(pictureUrl.url)) {
            str = videoInfo.currentUrl.url;
        } else {
            PictureUrl pictureUrl2 = videoInfo.bigUrl;
            if (pictureUrl2 != null && !TextUtils.isEmpty(pictureUrl2.url)) {
                str = videoInfo.bigUrl.url;
            } else {
                PictureUrl pictureUrl3 = videoInfo.originUrl;
                if (pictureUrl3 != null && !TextUtils.isEmpty(pictureUrl3.url)) {
                    str = videoInfo.originUrl.url;
                } else {
                    str = "";
                }
            }
        }
        PictureUrl pictureUrl4 = videoInfo.bigUrl;
        photoCacheData.bigUrl = pictureUrl4 != null ? pictureUrl4.url : str;
        PictureUrl pictureUrl5 = videoInfo.currentUrl;
        photoCacheData.currentUrl = pictureUrl5 != null ? pictureUrl5.url : str;
        PictureUrl pictureUrl6 = videoInfo.originUrl;
        if (pictureUrl6 != null) {
            str = pictureUrl6.url;
        }
        photoCacheData.orgUrl = str;
    }

    public static PhotoCacheData createFromResponse(s_picdata s_picdataVar, Album album) {
        String str;
        if (s_picdataVar == null) {
            return null;
        }
        PhotoCacheData photoCacheData = new PhotoCacheData();
        photoCacheData.lloc = s_picdataVar.lloc;
        photoCacheData.desc = s_picdataVar.desc;
        photoCacheData.uploadtime = s_picdataVar.uUploadTime;
        photoCacheData.shoottime = s_picdataVar.shoottime;
        if (s_picdataVar.photourl.containsKey(14)) {
            QLog.d("QzonePhotoUtil", 1, "createFromResponse: downUrl: " + s_picdataVar.photourl.get(14).url);
        }
        photoCacheData.picItem = e.m(s_picdataVar);
        photoCacheData.unikey = s_picdataVar.orglikekey;
        photoCacheData.curkey = s_picdataVar.curlikekey;
        photoCacheData.timevisible = false;
        photoCacheData.lastRefreshTime = System.currentTimeMillis();
        photoCacheData.intervalToBirthTime = 0L;
        photoCacheData.cmtnum = s_picdataVar.commentcount;
        photoCacheData.likenum = s_picdataVar.likecount;
        photoCacheData.mylike = s_picdataVar.ismylike ? 1 : 0;
        photoCacheData.type = s_picdataVar.type;
        if (album != null) {
            photoCacheData.albumid = album.albumid;
            photoCacheData.allow_share = album.allow_share;
            photoCacheData.opmask = album.opmask;
            photoCacheData.albumName = album.name;
        }
        photoCacheData.videoflag = s_picdataVar.videoflag;
        photoCacheData.videodata = e.s(s_picdataVar.videodata);
        photoCacheData.photoOpmask = s_picdataVar.opmask;
        s_pic_host s_pic_hostVar = s_picdataVar.pic_host_nick;
        photoCacheData.uploadUin = s_pic_hostVar != null ? s_pic_hostVar.uin : 0L;
        if (s_pic_hostVar != null) {
            str = s_pic_hostVar.nick;
        } else {
            str = "";
        }
        photoCacheData.uploadNickName = str;
        photoCacheData.batch_id = s_picdataVar.batchid;
        photoCacheData.faceList = FaceData.toFaceDataList(s_picdataVar.facelist, photoCacheData.albumid, photoCacheData.ownerUin);
        photoCacheData.shouzhang_extend_map = s_picdataVar.shouzhang_extend_map;
        return photoCacheData;
    }

    private static void createShuoShuoInfo(PhotoCacheData photoCacheData, int i3, cell_id cell_idVar, cell_comm cell_commVar, cell_operation cell_operationVar, cell_like cell_likeVar, cell_comment cell_commentVar) {
        if (i3 == 311) {
            if (cell_idVar != null) {
                photoCacheData.pssCellId = cell_idVar.cellid;
                photoCacheData.pssCellSubId = cell_idVar.subid;
            }
            if (cell_commVar != null) {
                photoCacheData.pssUgcKey = cell_commVar.ugckey;
                photoCacheData.pssSubId = cell_commVar.subid;
                photoCacheData.pssCurLikeKey = cell_commVar.curlikekey;
                photoCacheData.pssOrgLikeKey = cell_commVar.orglikekey;
            }
            if (cell_operationVar != null) {
                photoCacheData.pssBusiParam = cell_operationVar.busi_param;
            }
            if (cell_likeVar != null) {
                int i16 = cell_likeVar.isliked;
                photoCacheData.pssHasFeedPraise = i16 == 1;
                photoCacheData.likenum = cell_likeVar.num;
                photoCacheData.mylike = i16;
            }
            if (cell_commentVar != null) {
                photoCacheData.cmtnum = cell_commentVar.num;
            }
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        PhotoCacheData photoCacheData = (PhotoCacheData) obj;
        String str = this.albumid;
        if (str == null) {
            if (photoCacheData.albumid != null) {
                return false;
            }
        } else if (!str.equals(photoCacheData.albumid)) {
            return false;
        }
        String str2 = this.lloc;
        if (str2 == null) {
            if (photoCacheData.lloc != null) {
                return false;
            }
        } else if (!str2.equals(photoCacheData.lloc)) {
            return false;
        }
        String str3 = this.clientKey;
        String str4 = photoCacheData.clientKey;
        if (str3 != str4) {
            return false;
        }
        return str3 == null || str3.equals(str4);
    }
}
