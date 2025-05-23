package com.qzone.album.data.model;

import NS_MOBILE_FEEDS.cell_pic;
import NS_MOBILE_FEEDS.s_arkshare;
import NS_MOBILE_FEEDS.s_imgcrop;
import NS_MOBILE_FEEDS.s_picdata;
import NS_MOBILE_FEEDS.s_picurl;
import NS_MOBILE_MATERIAL.CustomAlbumTemplate;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import NS_MOBILE_PHOTO.PhotoSearchBox;
import NS_MOBILE_PHOTO.PhotoSearchBoxItem;
import NS_MOBILE_PHOTO.PhotoSearchBoxItemElem;
import NS_MOBILE_PHOTO.face_show_info;
import NS_MOBILE_PHOTO.stPhotoPoiArea;
import NS_MOBILE_PHOTO.stPhotoPoiAreaList;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.album.business.facescan.FaceShowInfoCacheData;
import com.qzone.album.business.search.PhotoSearchBoxCacheData;
import com.qzone.album.business.search.PhotoSearchBoxItemCacheData;
import com.qzone.album.business.search.PhotoSearchBoxItemElemCacheData;
import com.qzone.common.account.LoginData;
import com.qzone.feed.utils.h;
import com.qzone.lib.wrapper.db.IDBCacheDataWrapper;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.qzone.proxy.feedcomponent.util.e;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qmethod.pandoraex.monitor.OaidMonitor;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.webviewplugin.ugcsetting.UgcSettingUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import photo_share_struct.client_attr;
import photo_share_struct.uin_nick_info;
import s8.f;
import t5.b;

/* compiled from: P */
/* loaded from: classes39.dex */
public class AlbumCacheData extends com.qzone.component.cache.database.a implements Serializable, SmartParcelable {
    public static final String ACTIONTYPE = "actiontype";
    public static final String ACTIONURL = "actionurl";
    public static final String ALBUMANSWER = "albumanswer";
    public static final String ALBUMDESC = "albumdesc";
    public static final String ALBUMID = "albumid";
    public static final String ALBUMNAME = "albumname";
    public static final String ALBUMNUM = "albumnum";
    public static final String ALBUMQUESTION = "albumquestion";
    public static final String ALBUMRIGHTS = "albumrights";
    public static final String ALBUMTYPE = "albumtype";
    public static final String ALBUM_ALLOW_SHARE = "album_allow_share";
    public static final String ALBUM_COVER_LIST = "ALBUM_COVER_LIST";
    public static final String ALBUM_EXTRA_DATA = "album_extra_data";
    private static final String ALBUM_OWNER = "albumOwner";
    public static final String ALBUM_TEMPLATE = "album_template";
    private static final String ALBUM_TYPE_ICON = "albumTypeIcon";
    public static final String ALBUM_WHITE_LIST = "ALBUM_WHITE_LIST";
    public static final String ALLOW_ACCESS = "allow_access";
    private static final String ALLOW_AUTO_JOIN_SHARE_ALBUM_VALUE = "allowAutoJoinShareAlbum";
    public static final String ANONYMITY = "anonymity";
    private static final String ARK_CONTENT = "ark_content";
    private static final String ARK_CONTENT_INVATE = "ark_content_invate";
    private static final String ARK_ID = "ark_id";
    private static final String ARK_ID_INVATE = "ark_id_invate";
    public static final String BIRTHDAY = "birthDay";
    public static final String BIRTHMONTH = "birthMonth";
    public static final String BIRTHNICKNAME = "birthNickname";
    public static final String BIRTHTYPE = "birthType";
    public static final String BIRTHYEAR = "birthYear";
    public static final String BIRTH_DATE_TIME = "birth_date_time";
    private static final String BITMAP_VALUE = "bitmap";
    private static final String COMMON_PHOTO_TIMELINE_LIST = "commonPhotoTimeLineList";
    public static final String CREATE_TIME = "create_time";
    public static final IDBCacheDataWrapper.a<AlbumCacheData> DB_CREATOR = new a();
    private static final String FAMILY_SYNC_STATUS = "familySyncStatus";
    public static final String INDIVIDUAL = "individual";
    private static final String ISSHARINGOWNER_VALUE = "isSharingOwner";
    private static final String IS_TOPPED_ALBUM = "isToppedAlbum";
    public static final String JUSTUPLOADSIGN = "justUploadSign";
    private static final int JUST_UPLOADED = 1;
    public static final String LAST_REFRESH_TIME = "last_refresh_time";
    private static final String LIKE_COUNT = "likeCount";
    public static final String LOGINUIN = "loginUin";
    private static final String LOVE_EVENT_LIST = "loveEventList";
    private static final String LOVE_TIME = "loveTime";
    private static final String LOVE_VALUE = "loveValue";
    public static final String OPERATEMASK = "operatemask";
    public static final String OWNERUIN = "ownerUin";
    public static final String PARENTING_DATA = "parentingdata";
    private static final int PERMISSION_INDEX_AUTO_JOIN_SHARE_ALBUM = 1;
    public static final String PHOTO_NUM = "photonum";
    private static final String PHOTO_SEARCH_BOX = "photoSearchBox";
    private static final String PHOTO_SEARCH_STATUS = "photoSearchStatus";
    public static final String SEXUAL = "sexual";
    private static final String SHARE_CREATEUIN = "createSharingUin";
    private static final String SHARE_SHAREALBUM = "sharealbum";
    private static final String SHARING_ALBUM_CLIENT_ATTR = "sharingAlbumClientAttr";
    private static final String SHARING_ALBUM_MEMBER_DATA_LIST = "shareAlbumMemberDataList";
    public static final String SORTORDER = "sortorder";
    private static final String SORT_TYPE = "sortType";
    private static final String TAG = "AlbumCacheData";
    public static final String TIMEEVENT_DATA = "timeeventdata";
    public static final String TRAVEL_DATA = "traveldata";
    public static final String TYPE_ABIBTNUTY = "INTEGER";
    public static final String TYPE_ACTIONTYPE = "INTEGER";
    public static final String TYPE_ACTIONURL = "TEXT";
    public static final String TYPE_ALBUMANSWER = "TEXT";
    public static final String TYPE_ALBUMDESC = "TEXT";
    public static final String TYPE_ALBUMID = "TEXT UNIQUE";
    public static final String TYPE_ALBUMNAME = "TEXT";
    public static final String TYPE_ALBUMNUM = "INTEGER";
    public static final String TYPE_ALBUMQUESTION = "TEXT";
    public static final String TYPE_ALBUMRIGHTS = "INTEGER";
    public static final String TYPE_ALBUMTYPE = "INTEGER";
    public static final String TYPE_ALBUM_ALLOW_SHARE = "INTEGER";
    public static final String TYPE_ALBUM_COVER_LIST = "BLOB";
    public static final String TYPE_ALBUM_EXTRA_DATA = "BLOB";
    private static final String TYPE_ALBUM_OWNER = "TEXT";
    public static final String TYPE_ALBUM_TEMPLATE = "BLOB";
    private static final String TYPE_ALBUM_TYPE_ICON = "TEXT";
    public static final String TYPE_ALBUM_WHITE_LIST = "BLOB";
    public static final String TYPE_ALLOW_ACCESS = "INTEGER";
    private static final String TYPE_ALLOW_AUTO_JOIN_SHARE_ALBUM_VALUE = "INTEGER";
    private static final String TYPE_ARK_CONTENT = "TEXT";
    private static final String TYPE_ARK_CONTENT_INVATE = "TEXT";
    private static final String TYPE_ARK_ID = "TEXT";
    private static final String TYPE_ARK_ID_INVATE = "TEXT";
    public static final String TYPE_BIRTHDAY = "INTEGER";
    public static final String TYPE_BIRTHMONTH = "INTEGER";
    public static final String TYPE_BIRTHNICKNAME = "TEXT";
    public static final String TYPE_BIRTHTYPE = "INTEGER";
    public static final String TYPE_BIRTHYEAR = "INTEGER";
    public static final String TYPE_BIRTH_DATE_TIME = "INTEGER";
    private static final String TYPE_BITMAP_VALUE = "TEXT";
    private static final String TYPE_COMMON_PHOTO_TIMELINE_LIST = "BLOB";
    public static final String TYPE_CREATE_TIME = "INTEGER";
    private static final String TYPE_FAMILY_SYNC_STATUS = "INTEGER";
    public static final String TYPE_INDIVIDUAL = "INTEGER";
    private static final String TYPE_ISSHARINGOWNER_VALUE = "INTEGER";
    private static final String TYPE_IS_TOPPED_ALBUM = "INTEGER";
    public static final String TYPE_JUSTUPLOADSIGN = "INTEGER";
    public static final String TYPE_LAST_REFRESH_TIME = "INTEGER";
    private static final String TYPE_LIKE_COUNT = "INTEGER";
    public static final String TYPE_LOGINUIN = "INTEGER";
    private static final String TYPE_LOVE_EVENT_LIST = "BLOB";
    private static final String TYPE_LOVE_TIME = "INTEGER";
    private static final String TYPE_LOVE_VALUE = "INTEGER";
    public static final String TYPE_OPERATEMASK = "INTEGER";
    public static final String TYPE_OWNERUIN = "INTEGER";
    public static final String TYPE_PARENTING_DATA = "BLOB";
    public static final String TYPE_PHOTO_NUM = "INTEGER";
    private static final String TYPE_PHOTO_SEARCH_BOX = "BLOB";
    private static final String TYPE_PHOTO_SEARCH_STATUS = "INTEGER";
    public static final String TYPE_SEXUAL = "INTEGER";
    private static final String TYPE_SHARE_CREATEUIN = "INTEGER";
    private static final String TYPE_SHARE_SHAREALBUM = "INTEGER";
    private static final String TYPE_SHARING_ALBUM_CLIENT_ATTR = "BLOB";
    private static final String TYPE_SHARING_ALBUM_MEMBER_DATA_LIST = "BLOB";
    public static final String TYPE_SORTORDER = "INTEGER";
    private static final String TYPE_SORT_TYPE = "INTEGER";
    public static final String TYPE_TIMEEVENT_DATA = "BLOB";
    public static final String TYPE_TRAVEL_DATA = "BLOB";
    public static final String TYPE_UPLOADNUM = "INTEGER";
    public static final String TYPE_VIDEO_NUM = "INTEGER";
    private static final String TYPE_VIEW_COUNT = "INTEGER";
    private static final String TYPE_VIEW_ID = "TEXT";
    private static final String TYPE_VIEW_ID_INVATE = "TEXT";
    public static final String UPLOADNUM = "uploadnum";
    public static final String VIDEO_NUM = "videonum";
    private static final String VIEW_COUNT = "viewCount";
    private static final String VIEW_ID = "view_id";
    private static final String VIEW_ID_INVATE = "view_id_invate";

    @NeedParcel
    public String actionUrl;

    @NeedParcel
    public int actiontype;

    @NeedParcel
    public String albumanswer;

    @NeedParcel
    public String albumdesc;

    @NeedParcel
    public String albumid;

    @NeedParcel
    public String albumname;

    @NeedParcel
    public int albumnum;

    @NeedParcel
    public String albumquestion;

    @NeedParcel
    public int albumrights;

    @NeedParcel
    public int albumtype;

    @NeedParcel
    public int allow_share;

    @NeedParcel
    public int anonymity;

    @NeedParcel
    public long birthDateTime;

    @NeedParcel
    public long birthDay;

    @NeedParcel
    public long birthMonth;

    @NeedParcel
    public String birthNickname;

    @NeedParcel
    public long birthType;

    @NeedParcel
    public long birthYear;

    @NeedParcel
    public String bitmap;

    @NeedParcel
    public PictureUrl coverUrl;

    @NeedParcel
    public boolean isToppedAlbum;

    @NeedParcel
    public long lastRefreshTime;

    @NeedParcel
    public ArrayList<LoveAlbumTimeEvent> loveAlbumTimeEventList;

    @NeedParcel
    public long loveTime;

    @NeedParcel
    public long loveValue;

    @NeedParcel
    public long ownerUin;

    @NeedParcel
    public ParentingAlbumData parentingData;

    @NeedParcel
    public int photoNum;

    @NeedParcel
    public PhotoSearchBoxCacheData photoSearchBox;

    @NeedParcel
    public int photoSearchStatus;

    @NeedParcel
    public int sortType;

    @NeedParcel
    public int sortorder;

    @NeedParcel
    public int syncFanmilyStatus;

    @NeedParcel
    public TravelAlbumData travelData;

    @NeedParcel
    public int uploadnum;

    @NeedParcel
    public int videoNum;

    @NeedParcel
    public boolean allowAccess = false;

    @NeedParcel
    public ArrayList<PictureUrl> coverUrlList = new ArrayList<>();

    @NeedParcel
    public long loginUin = LoginData.getInstance().getUin();

    @NeedParcel
    public ArrayList<Long> album_white_list = new ArrayList<>();

    @NeedParcel
    public Map<Integer, String> busi_param = new HashMap();

    @NeedParcel
    public int operatemask = 0;

    @NeedParcel
    public int createTime = 0;

    @NeedParcel
    public ArrayList<TimeEvent> timeEventData = new ArrayList<>();

    @NeedParcel
    public MaterialItem albumTemplate = null;

    @NeedParcel
    public CustomAlbumTemplate albumTemplateData = null;

    @NeedParcel
    public int sexual = 0;

    @NeedParcel
    public long individual = 0;

    @NeedParcel
    public int justUploadSign = 0;

    @NeedParcel
    public String albumOwner = "";

    @NeedParcel
    public ArrayList<SharingAlbumClientAttr> sharingAlbumClientAttrArrayList = null;

    @NeedParcel
    private boolean isShareAlbumOnServer = false;

    @NeedParcel
    public long createSharingUin = 0;

    @NeedParcel
    public boolean isSharingOwner = false;

    @NeedParcel
    public boolean allowAutoJoinShareAlbum = false;

    @NeedParcel
    public ArrayList<ShareAlbumMemberCacheData> shareAlbumMemberDataList = null;

    @NeedParcel
    public ArrayList<TimeLine> commonPhotoTimeLineList = null;

    @NeedParcel
    public String ark_id = "";

    @NeedParcel
    public String view_id = "";

    @NeedParcel
    public String ark_content = "";

    @NeedParcel
    public String ark_id_invate = "";

    @NeedParcel
    public String view_id_invate = "";

    @NeedParcel
    public String ark_content_invate = "";

    @NeedParcel
    public int viewCount = 0;

    @NeedParcel
    public int likeCount = 0;

    @NeedParcel
    public String albumTypeIcon = "";
    private ArrayList<SharingAlbumClientAttr> confirmedSharingAlbumClientAttrArrayList = new ArrayList<>();

    public static AlbumCacheData createFromResponse(cell_pic cell_picVar, int i3, long j3, int i16, Map<Integer, String> map, int i17) {
        if (cell_picVar == null) {
            return null;
        }
        AlbumCacheData albumCacheData = new AlbumCacheData();
        albumCacheData.albumname = TextUtils.isEmpty(cell_picVar.albumname) ? "" : cell_picVar.albumname.trim();
        albumCacheData.albumid = cell_picVar.albumid;
        albumCacheData.albumnum = cell_picVar.albumnum;
        albumCacheData.uploadnum = cell_picVar.uploadnum;
        albumCacheData.albumrights = cell_picVar.albumrights;
        albumCacheData.albumquestion = TextUtils.isEmpty(cell_picVar.albumquestion) ? "" : cell_picVar.albumquestion.trim();
        albumCacheData.albumanswer = TextUtils.isEmpty(cell_picVar.albumanswer) ? "" : cell_picVar.albumanswer.trim();
        albumCacheData.isToppedAlbum = cell_picVar.is_topped_album;
        ArrayList<s_picdata> arrayList = cell_picVar.picdata;
        if (arrayList != null && arrayList.size() > 0) {
            PictureUrl coverUrlByPicData = getCoverUrlByPicData(cell_picVar.picdata.get(0));
            albumCacheData.coverUrl = coverUrlByPicData;
            if (cell_picVar.is_topped_album) {
                albumCacheData.coverUrlList.add(coverUrlByPicData);
                for (int i18 = 1; i18 < cell_picVar.picdata.size(); i18++) {
                    albumCacheData.coverUrlList.add(getCoverUrlByPicData(cell_picVar.picdata.get(i18)));
                }
            }
        }
        albumCacheData.allowAccess = cell_picVar.allow_access > 0;
        albumCacheData.albumdesc = cell_picVar.desc;
        albumCacheData.ownerUin = j3;
        albumCacheData.busi_param = map;
        albumCacheData.lastRefreshTime = System.currentTimeMillis();
        albumCacheData.anonymity = cell_picVar.anonymity;
        albumCacheData.albumtype = cell_picVar.albumtype;
        albumCacheData.actiontype = cell_picVar.actiontype;
        albumCacheData.actionUrl = cell_picVar.actionurl;
        albumCacheData.birthNickname = "";
        albumCacheData.birthYear = 0L;
        albumCacheData.birthMonth = 0L;
        albumCacheData.birthDay = 0L;
        albumCacheData.birthType = 0L;
        QLog.d(TAG, 1, "createFromResponse, albumInfo = " + albumCacheData);
        int albumThemeTypeValue = albumCacheData.getAlbumThemeTypeValue();
        if (albumThemeTypeValue != 1) {
            albumCacheData.albumtype = albumThemeTypeValue;
        }
        if (albumCacheData.albumtype != 102) {
            albumCacheData.albumtype = albumCacheData.getAlbumThemeTypeValue();
        }
        albumCacheData.operatemask = i17;
        albumCacheData.birthDateTime = 0L;
        albumCacheData.individual = cell_picVar.individualalbum;
        albumCacheData.justUploadSign = cell_picVar.newestupload;
        albumCacheData.isShareAlbumOnServer = cell_picVar.is_share;
        albumCacheData.isSharingOwner = cell_picVar.is_share_owner;
        albumCacheData.sortType = cell_picVar.sort_type;
        albumCacheData.viewCount = cell_picVar.view_cnt;
        albumCacheData.likeCount = cell_picVar.like_cnt;
        albumCacheData.albumTypeIcon = cell_picVar.icon_url;
        return albumCacheData;
    }

    public static int getAnonymityValueByTypeValue(int i3) {
        if (i3 == 8) {
            return 5;
        }
        if (i3 == 9) {
            return 6;
        }
        if (i3 == 10) {
            return 10;
        }
        if (i3 == 11) {
            return 8;
        }
        if (i3 == 12) {
            return 9;
        }
        return 1;
    }

    public int getAlbumThemeTypeValue() {
        int i3 = this.anonymity;
        if (i3 == 5) {
            return 8;
        }
        if (i3 == 6) {
            return 9;
        }
        if (i3 == 10) {
            return 10;
        }
        if (i3 == 8) {
            return 11;
        }
        if (i3 == 101) {
            return 101;
        }
        return i3 == 9 ? 12 : 1;
    }

    public ArrayList<String> getAlreadySharingOwnerList() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.sharingAlbumClientAttrArrayList != null) {
            for (int i3 = 0; i3 < this.sharingAlbumClientAttrArrayList.size(); i3++) {
                arrayList.add(this.sharingAlbumClientAttrArrayList.get(i3).uin + "");
            }
        }
        return arrayList;
    }

    public int getBabyAge() {
        int i3;
        if (!isParentingAlbum()) {
            return -1;
        }
        try {
            i3 = Calendar.getInstance().get(1) - Integer.valueOf(String.valueOf(this.birthDateTime).substring(0, 4)).intValue();
        } catch (Exception e16) {
            QZLog.w(e16);
            i3 = -2;
        }
        if (i3 < 0) {
            QZLog.w(TAG, "[getBabyAge] age=" + i3 + ", birthDateTime=" + this.birthDateTime + ", now=" + System.currentTimeMillis());
        }
        return i3;
    }

    public ArrayList<SharingAlbumClientAttr> getConfirmedSharingAlbumClientAttrArrayList() {
        return this.confirmedSharingAlbumClientAttrArrayList;
    }

    public ArrayList<String> getConfirmedSharingOwnersList() {
        ArrayList<String> arrayList = new ArrayList<>();
        if (this.sharingAlbumClientAttrArrayList != null) {
            for (int i3 = 0; i3 < this.sharingAlbumClientAttrArrayList.size(); i3++) {
                SharingAlbumClientAttr sharingAlbumClientAttr = this.sharingAlbumClientAttrArrayList.get(i3);
                if (sharingAlbumClientAttr.uin > 0 && sharingAlbumClientAttr.uinAttr.status == 2) {
                    arrayList.add(sharingAlbumClientAttr.uin + "");
                }
            }
        }
        return arrayList;
    }

    public int getConfirmedSharingOwnersNumber() {
        if (this.confirmedSharingAlbumClientAttrArrayList == null) {
            this.confirmedSharingAlbumClientAttrArrayList = new ArrayList<>();
        }
        this.confirmedSharingAlbumClientAttrArrayList.clear();
        ArrayList<SharingAlbumClientAttr> arrayList = this.sharingAlbumClientAttrArrayList;
        if (arrayList == null || arrayList.size() <= 0) {
            return 1;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.sharingAlbumClientAttrArrayList.size(); i16++) {
            SharingAlbumClientAttr sharingAlbumClientAttr = this.sharingAlbumClientAttrArrayList.get(i16);
            if (sharingAlbumClientAttr.uin > 0 && sharingAlbumClientAttr.uinAttr.status == 2) {
                i3++;
                this.confirmedSharingAlbumClientAttrArrayList.add(sharingAlbumClientAttr);
            }
        }
        return i3;
    }

    public String getLloc() {
        PictureUrl pictureUrl = this.coverUrl;
        if (pictureUrl == null) {
            return "";
        }
        return pictureUrl.url;
    }

    public int getMaxCount() {
        return getTargetTypeMaxCount(this.albumtype);
    }

    public String getShareAlbumId() {
        SharingOwnerUinAttr shareUinAttr = getShareUinAttr();
        if (shareUinAttr == null) {
            return null;
        }
        return shareUinAttr.shareAlbumId;
    }

    public ArrayList<ShareAlbumMemberCacheData> getShareAlbumMemberDataList() {
        return this.shareAlbumMemberDataList;
    }

    public String getShareOwnerAlbumId() {
        SharingOwnerUinAttr shareUinAttr = getShareUinAttr(this.createSharingUin);
        if (shareUinAttr == null) {
            return null;
        }
        return shareUinAttr.shareAlbumId;
    }

    public SharingOwnerUinAttr getShareUinAttr() {
        return getShareUinAttr(com.qzone.album.env.common.a.m().s());
    }

    public ArrayList<Long> getSharedMemberUins() {
        ArrayList<Long> arrayList = new ArrayList<>();
        ArrayList<SharingAlbumClientAttr> arrayList2 = this.sharingAlbumClientAttrArrayList;
        if (arrayList2 != null) {
            Iterator<SharingAlbumClientAttr> it = arrayList2.iterator();
            while (it.hasNext()) {
                SharingAlbumClientAttr next = it.next();
                long j3 = next.uin;
                if (j3 > 0 && next.uinAttr.status == 2) {
                    arrayList.add(Long.valueOf(j3));
                }
            }
        }
        return arrayList;
    }

    public SharingAlbumClientAttr getSharingAlbumClientAttr(long j3) {
        ArrayList<SharingAlbumClientAttr> arrayList = this.sharingAlbumClientAttrArrayList;
        if (arrayList == null) {
            return null;
        }
        Iterator<SharingAlbumClientAttr> it = arrayList.iterator();
        while (it.hasNext()) {
            SharingAlbumClientAttr next = it.next();
            if (next != null && next.uin == j3) {
                return next;
            }
        }
        return null;
    }

    public int getSharingOwnersNumber() {
        if (this.sharingAlbumClientAttrArrayList == null) {
            return 0;
        }
        int i3 = 0;
        for (int i16 = 0; i16 < this.sharingAlbumClientAttrArrayList.size(); i16++) {
            if (this.sharingAlbumClientAttrArrayList.get(i16).uin > 0) {
                i3++;
            }
        }
        return i3;
    }

    public boolean isAlbumCreator() {
        long j3 = this.createSharingUin;
        return j3 != 0 ? j3 == com.qzone.album.env.common.a.m().s() : this.ownerUin == com.qzone.album.env.common.a.m().s();
    }

    public boolean isApplyFunctionOpen() {
        switch (this.albumtype) {
            case 8:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_BABY_ALBUM_APPLY_FUNCTION_OPEN, 0) != 1) {
                    return false;
                }
                break;
            case 9:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_TRAVEL_ALBUM_APPLY_FUNCTION_OPEN, 0) != 1) {
                    return false;
                }
                break;
            case 10:
            default:
                return false;
            case 11:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_LOVE_ALBUM_APPLY_FUNCTION_OPEN, 0) != 1) {
                    return false;
                }
                break;
            case 12:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_MULTI_ALBUM_APPLY_FUNCTION_OPEN, 1) != 1) {
                    return false;
                }
                break;
        }
        return true;
    }

    public boolean isFamilySyncOn() {
        return (this.syncFanmilyStatus & 2) == 2;
    }

    public boolean isInConfirmedShareList() {
        SharingOwnerUinAttr shareUinAttr = getShareUinAttr();
        return shareUinAttr != null && shareUinAttr.status == 2;
    }

    public boolean isInShareList() {
        return getShareUinAttr() != null;
    }

    public boolean isInviteFunctionOpen() {
        switch (this.albumtype) {
            case 8:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_BABY_ALBUM_INVITE_FUNCTION_OPEN, 1) != 1) {
                    return false;
                }
                break;
            case 9:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_TRAVEL_ALBUM_INVITE_FUNCTION_OPEN, 1) != 1) {
                    return false;
                }
                break;
            case 10:
            default:
                return false;
            case 11:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_LOVE_ALBUM_INVITE_FUNCTION_OPEN, 0) != 1) {
                    return false;
                }
                break;
            case 12:
                if (QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_KEY_MULTI_ALBUM_INVITE_FUNCTION_OPEN, 1) != 1) {
                    return false;
                }
                break;
        }
        return true;
    }

    public boolean isJustUploaded() {
        return this.justUploadSign == 1;
    }

    public boolean isLoveAlbum() {
        return this.albumtype == 11;
    }

    public boolean isMultiAlbum() {
        return this.albumtype == 12;
    }

    public boolean isNormalAlbum() {
        return this.albumtype == 1;
    }

    public boolean isParentingAlbum() {
        return this.albumtype == 8;
    }

    public boolean isShareInvitePanding() {
        SharingOwnerUinAttr shareUinAttr = getShareUinAttr();
        return shareUinAttr != null && shareUinAttr.status == 1;
    }

    public boolean isSharingAlbum() {
        switch (this.albumtype) {
            case 8:
            case 9:
            case 11:
            case 12:
                return true;
            case 10:
            default:
                return false;
        }
    }

    public boolean isSharingAlbumApplicant() {
        return getShareUinAttr() != null && getShareUinAttr().status == 6;
    }

    public boolean isSharingAlbumCreator() {
        return (isSharingAlbumOnServer() || isSharingAlbumOnUI()) && this.createSharingUin == com.qzone.album.env.common.a.m().s();
    }

    public boolean isSharingAlbumMember() {
        return (isSharingAlbumOnServer() || isSharingAlbumOnUI()) && this.createSharingUin != com.qzone.album.env.common.a.m().s() && getSharedMemberUins().contains(Long.valueOf(com.qzone.album.env.common.a.m().s()));
    }

    public boolean isSharingAlbumOnServer() {
        return this.isShareAlbumOnServer;
    }

    public boolean isSharingAlbumOnUI() {
        return getSharingOwnersNumber() > 1;
    }

    public boolean isSharingAlbumPartner() {
        return (isSharingAlbumOnServer() || isSharingAlbumOnUI()) && this.createSharingUin != com.qzone.album.env.common.a.m().s();
    }

    public boolean isTravelAlbum() {
        return this.albumtype == 9;
    }

    public boolean isUnsharingAlbumCreator() {
        return (isSharingAlbumOnServer() || isSharingAlbumOnUI() || this.ownerUin != com.qzone.album.env.common.a.m().s()) ? false : true;
    }

    public boolean needShowFamilySync() {
        return (this.syncFanmilyStatus & 1) == 1;
    }

    public void setPhotoPoiAreaList(stPhotoPoiAreaList stphotopoiarealist, String str, Map<Integer, String> map) {
        TravelAlbumData travelAlbumData = new TravelAlbumData();
        this.travelData = travelAlbumData;
        travelAlbumData.attach_info = str;
        travelAlbumData.busi_param = map;
        if (stphotopoiarealist == null) {
            return;
        }
        stPhotoPoiArea stphotopoiarea = stphotopoiarealist.album_poi;
        if (stphotopoiarea != null) {
            travelAlbumData.albumPoi = PhotoPoiArea.createFromResponse(stphotopoiarea);
        }
        TravelAlbumData travelAlbumData2 = this.travelData;
        travelAlbumData2.startDescription = stphotopoiarealist.start_description;
        travelAlbumData2.endDescription = stphotopoiarealist.end_description;
        ArrayList<stPhotoPoiArea> arrayList = stphotopoiarealist.poi_areas;
        if (arrayList != null) {
            Iterator<stPhotoPoiArea> it = arrayList.iterator();
            while (it.hasNext()) {
                PhotoPoiArea createFromResponse = PhotoPoiArea.createFromResponse(it.next());
                if (createFromResponse != null) {
                    this.travelData.photoPoiAreaList.add(createFromResponse);
                }
            }
        }
        this.travelData.startShootTime = stphotopoiarealist.start_shoot_time;
    }

    public void setShareAlbumMemberDataList(ArrayList<ShareAlbumMemberCacheData> arrayList) {
        this.shareAlbumMemberDataList = arrayList;
    }

    public void setShareStatusToConfirm() {
        SharingOwnerUinAttr shareUinAttr = getShareUinAttr();
        if (shareUinAttr != null) {
            shareUinAttr.status = 2;
        }
    }

    public void setTimeLineList(ArrayList<NS_MOBILE_PHOTO.TimeLine> arrayList, String str, Map<Integer, String> map) {
        ParentingAlbumData parentingAlbumData = new ParentingAlbumData();
        this.parentingData = parentingAlbumData;
        parentingAlbumData.timeLineList = new ArrayList<>();
        if (arrayList != null) {
            Iterator<NS_MOBILE_PHOTO.TimeLine> it = arrayList.iterator();
            while (it.hasNext()) {
                NS_MOBILE_PHOTO.TimeLine next = it.next();
                if (next != null) {
                    TimeLine timeLine = new TimeLine();
                    timeLine.beginTime = next.begin_time;
                    timeLine.endTime = next.end_time;
                    timeLine.total = next.total;
                    timeLine.showTime = next.show_time;
                    timeLine.showYear = next.show_year;
                    timeLine.showMonth = next.show_month;
                    timeLine.showWeek = next.show_week;
                    timeLine.showDay = next.show_day;
                    timeLine.festivals = next.festivals;
                    this.parentingData.timeLineList.add(timeLine);
                }
            }
        }
        ParentingAlbumData parentingAlbumData2 = this.parentingData;
        parentingAlbumData2.attach_info = str;
        parentingAlbumData2.busi_param = map;
    }

    public String toString() {
        return "(albumname, " + this.albumname + ")\n(albumid, " + this.albumid + ")\n(albumtype, " + this.albumtype + ")\n(actiontype, " + this.actiontype + ")\n(actionUrl, " + this.actionUrl + ")\n(albumnum, " + this.albumnum + ")\n(videoNum, " + this.videoNum + ")\n(photoNum, " + this.photoNum + ")\n(uploadnum, " + this.uploadnum + ")\n(albumrights, " + this.albumrights + ")\n(allowAccess, " + this.allowAccess + ")\n(albumquestion, " + this.albumquestion + ")\n(albumanswer, " + this.albumanswer + ")\n(coverUrl, " + this.coverUrl + ")\n(albumdesc, " + this.albumdesc + ")\n(ownerUin, " + this.ownerUin + ")\n(sortorder, " + this.sortorder + ")\n(loginUin, " + this.loginUin + ")\n++(album_white_list, " + this.album_white_list + ")++\n(busi_param, " + this.busi_param + ")\n(lastRefreshTime, " + this.lastRefreshTime + ")\n(anonymity, " + this.anonymity + ")\n(operatemask, " + this.operatemask + ")\n(birthDateTime, " + this.birthDateTime + ")\n(birthNickname, " + this.birthNickname + ")\n(birthYear, " + this.birthYear + ")\n(birthMonth, " + this.birthMonth + ")\n(birthDay, " + this.birthDay + ")\n(birthType, " + this.birthType + ")\n(createTime, " + this.createTime + ")\n++(parentingData, " + this.parentingData + ")++\n++(travelData, " + this.travelData + ")++\n++(timeEventData, " + this.timeEventData + ")++\n++(albumTemplate, " + this.albumTemplate + ")++\n++(albumTemplateData, " + this.albumTemplateData + ")++\n(allow_share, " + this.allow_share + ")\n(sexual, " + this.sexual + ")\n(individual, " + this.individual + ")\n(justUploadSign, " + this.justUploadSign + ")\n(albumOwner, " + this.albumOwner + ")\n++(sharingAlbumClientAttrArrayList, " + this.sharingAlbumClientAttrArrayList + ")++\n(isShareAlbumOnServer, " + this.isShareAlbumOnServer + ")\n(createSharingUin, " + this.createSharingUin + ")\n(isSharingOwner, " + this.isSharingOwner + ")\n(allowAutoJoinShareAlbum, " + this.allowAutoJoinShareAlbum + ")\n(loveTime, " + this.loveTime + ")\n++(loveAlbumTimeEventList, " + this.loveAlbumTimeEventList + ")++\n++(sortType, " + this.sortType + ")++\n(loveValue, " + this.loveValue + ")++photoSearchBox, " + this.photoSearchBox + ")++photoSearchStatus, " + this.photoSearchStatus + ")(viewCount, " + this.viewCount + ")\n(likeCount, " + this.likeCount + ")\n(albumTypeIcon, " + this.albumTypeIcon + ")\n";
    }

    public void turnOffFamilySync() {
        if (needShowFamilySync()) {
            this.syncFanmilyStatus &= 1;
        }
    }

    public void turnOnFamilySync() {
        if (needShowFamilySync()) {
            this.syncFanmilyStatus |= 2;
        }
    }

    @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper
    public void writeTo(ContentValues contentValues) {
        contentValues.put("albumname", this.albumname);
        contentValues.put("albumid", this.albumid);
        contentValues.put("albumtype", Integer.valueOf(this.albumtype));
        contentValues.put("albumnum", Integer.valueOf(this.albumnum));
        contentValues.put(VIDEO_NUM, Integer.valueOf(this.videoNum));
        contentValues.put(PHOTO_NUM, Integer.valueOf(this.photoNum));
        contentValues.put("uploadnum", Integer.valueOf(this.uploadnum));
        contentValues.put("albumrights", Integer.valueOf(this.albumrights));
        contentValues.put(ALLOW_ACCESS, Integer.valueOf(this.allowAccess ? 1 : 0));
        contentValues.put("albumquestion", this.albumquestion);
        contentValues.put("albumanswer", this.albumanswer);
        contentValues.put("albumdesc", this.albumdesc);
        contentValues.put("ownerUin", Long.valueOf(this.ownerUin));
        contentValues.put(SORTORDER, Integer.valueOf(this.sortorder));
        contentValues.put(LOGINUIN, Long.valueOf(this.loginUin));
        Parcel obtain = Parcel.obtain();
        obtain.writeList(this.album_white_list);
        byte[] marshall = obtain.marshall();
        OaidMonitor.parcelRecycle(obtain);
        contentValues.put(ALBUM_WHITE_LIST, marshall);
        Parcel obtain2 = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain2, 0, this.coverUrlList);
        byte[] marshall2 = obtain2.marshall();
        OaidMonitor.parcelRecycle(obtain2);
        contentValues.put(ALBUM_COVER_LIST, marshall2);
        Parcel obtain3 = Parcel.obtain();
        obtain3.writeMap(this.busi_param);
        ParcelableWrapper.writeDataToParcel(obtain3, 0, this.coverUrl);
        byte[] marshall3 = obtain3.marshall();
        OaidMonitor.parcelRecycle(obtain3);
        contentValues.put(ALBUM_EXTRA_DATA, marshall3);
        contentValues.put("last_refresh_time", Long.valueOf(this.lastRefreshTime));
        contentValues.put(ANONYMITY, Integer.valueOf(this.anonymity));
        contentValues.put(OPERATEMASK, Integer.valueOf(this.operatemask));
        contentValues.put("albumtype", Integer.valueOf(this.albumtype));
        contentValues.put(BIRTHNICKNAME, this.birthNickname);
        contentValues.put(BIRTHYEAR, Long.valueOf(this.birthYear));
        contentValues.put(BIRTHMONTH, Long.valueOf(this.birthMonth));
        contentValues.put(BIRTHDAY, Long.valueOf(this.birthDay));
        contentValues.put(BIRTHTYPE, Long.valueOf(this.birthType));
        contentValues.put(BIRTH_DATE_TIME, Long.valueOf(this.birthDateTime));
        contentValues.put(SEXUAL, Integer.valueOf(this.sexual));
        Parcel obtain4 = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain4, 0, this.parentingData);
        byte[] marshall4 = obtain4.marshall();
        OaidMonitor.parcelRecycle(obtain4);
        contentValues.put(PARENTING_DATA, marshall4);
        Parcel obtain5 = Parcel.obtain();
        obtain5.writeList(this.timeEventData);
        byte[] marshall5 = obtain5.marshall();
        OaidMonitor.parcelRecycle(obtain5);
        contentValues.put(TIMEEVENT_DATA, marshall5);
        Parcel obtain6 = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain6, 0, this.travelData);
        byte[] marshall6 = obtain6.marshall();
        OaidMonitor.parcelRecycle(obtain6);
        contentValues.put(TRAVEL_DATA, marshall6);
        contentValues.put("actiontype", Integer.valueOf(this.actiontype));
        contentValues.put(ACTIONURL, this.actionUrl);
        MaterialItem materialItem = this.albumTemplate;
        contentValues.put(ALBUM_TEMPLATE, materialItem != null ? b.c(materialItem) : null);
        contentValues.put(CREATE_TIME, Integer.valueOf(this.createTime));
        contentValues.put(ALBUM_ALLOW_SHARE, Integer.valueOf(this.allow_share));
        contentValues.put(INDIVIDUAL, Long.valueOf(this.individual));
        contentValues.put(JUSTUPLOADSIGN, Integer.valueOf(this.justUploadSign));
        contentValues.put(ALBUM_OWNER, this.albumOwner);
        Parcel obtain7 = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain7, 0, this.sharingAlbumClientAttrArrayList);
        byte[] marshall7 = obtain7.marshall();
        OaidMonitor.parcelRecycle(obtain7);
        contentValues.put(SHARING_ALBUM_CLIENT_ATTR, marshall7);
        contentValues.put(SHARE_SHAREALBUM, Integer.valueOf(this.isShareAlbumOnServer ? 1 : 0));
        contentValues.put(SHARE_CREATEUIN, Long.valueOf(this.createSharingUin));
        contentValues.put(LOVE_TIME, Long.valueOf(this.loveTime));
        Parcel obtain8 = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain8, 0, this.loveAlbumTimeEventList);
        byte[] marshall8 = obtain8.marshall();
        OaidMonitor.parcelRecycle(obtain8);
        contentValues.put(LOVE_EVENT_LIST, marshall8);
        contentValues.put(LOVE_VALUE, Long.valueOf(this.loveValue));
        contentValues.put(ISSHARINGOWNER_VALUE, Integer.valueOf(this.isSharingOwner ? 1 : 0));
        contentValues.put(ALLOW_AUTO_JOIN_SHARE_ALBUM_VALUE, Integer.valueOf(this.allowAutoJoinShareAlbum ? 1 : 0));
        contentValues.put("bitmap", this.bitmap);
        Parcel obtain9 = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain9, 0, this.shareAlbumMemberDataList);
        byte[] marshall9 = obtain9.marshall();
        OaidMonitor.parcelRecycle(obtain9);
        contentValues.put(SHARING_ALBUM_MEMBER_DATA_LIST, marshall9);
        Parcel obtain10 = Parcel.obtain();
        ParcelableWrapper.writeArrayListToParcel(obtain10, 0, this.commonPhotoTimeLineList);
        byte[] marshall10 = obtain10.marshall();
        OaidMonitor.parcelRecycle(obtain10);
        contentValues.put(COMMON_PHOTO_TIMELINE_LIST, marshall10);
        contentValues.put(ARK_ID, this.ark_id);
        contentValues.put("view_id", this.view_id);
        contentValues.put(ARK_CONTENT, this.ark_content);
        contentValues.put(ARK_ID_INVATE, this.ark_id_invate);
        contentValues.put(VIEW_ID_INVATE, this.view_id_invate);
        contentValues.put(ARK_CONTENT_INVATE, this.ark_content_invate);
        contentValues.put(SORT_TYPE, Integer.valueOf(this.sortType));
        contentValues.put(IS_TOPPED_ALBUM, Integer.valueOf(this.isToppedAlbum ? 1 : 0));
        Parcel obtain11 = Parcel.obtain();
        ParcelableWrapper.writeDataToParcel(obtain11, 0, this.photoSearchBox);
        byte[] marshall11 = obtain11.marshall();
        OaidMonitor.parcelRecycle(obtain11);
        contentValues.put(PHOTO_SEARCH_BOX, marshall11);
        contentValues.put(PHOTO_SEARCH_STATUS, Integer.valueOf(this.photoSearchStatus));
        contentValues.put(VIEW_COUNT, Integer.valueOf(this.viewCount));
        contentValues.put("likeCount", Integer.valueOf(this.likeCount));
        contentValues.put(ALBUM_TYPE_ICON, this.albumTypeIcon);
        contentValues.put(FAMILY_SYNC_STATUS, Integer.valueOf(this.syncFanmilyStatus));
    }

    public SharingOwnerUinAttr getShareUinAttr(long j3) {
        ArrayList<SharingAlbumClientAttr> arrayList = this.sharingAlbumClientAttrArrayList;
        if (arrayList == null) {
            return null;
        }
        Iterator<SharingAlbumClientAttr> it = arrayList.iterator();
        while (it.hasNext()) {
            SharingAlbumClientAttr next = it.next();
            if (next != null && next.uin == j3) {
                return next.uinAttr;
            }
        }
        return null;
    }

    private static PictureUrl getCoverUrlByPicData(s_picdata s_picdataVar) {
        Map<Integer, s_picurl> map;
        s_picurl s_picurlVar;
        if (s_picdataVar != null && (map = s_picdataVar.photourl) != null) {
            if (map.get(11) == null) {
                s_picurlVar = s_picdataVar.photourl.get(3);
            } else {
                s_picurlVar = s_picdataVar.photourl.get(11);
            }
            if (s_picurlVar != null) {
                PictureUrl n3 = e.n(s_picurlVar);
                s_imgcrop s_imgcropVar = s_picdataVar.cropinfo;
                n3.pivotXRate = ((float) s_imgcropVar.centerx_scale) / 100.0f;
                n3.pivotYRate = ((float) s_imgcropVar.centery_scale) / 100.0f;
                return n3;
            }
        }
        return null;
    }

    private static String setAlbumPermission(String str, int i3, boolean z16) {
        String str2;
        if (str == null || str.length() <= i3 || 1 != i3) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder(str);
        if (z16) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        sb5.replace(1, 2, str2);
        return sb5.toString();
    }

    public void setCommonPhotoTimeLineList(ArrayList<NS_MOBILE_PHOTO.TimeLine> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        this.commonPhotoTimeLineList = new ArrayList<>();
        Iterator<NS_MOBILE_PHOTO.TimeLine> it = arrayList.iterator();
        while (it.hasNext()) {
            NS_MOBILE_PHOTO.TimeLine next = it.next();
            TimeLine timeLine = new TimeLine();
            timeLine.beginTime = next.begin_time;
            timeLine.endTime = next.end_time;
            timeLine.total = next.total;
            timeLine.showTime = next.show_time;
            timeLine.showYear = next.show_year;
            timeLine.showMonth = next.show_month;
            timeLine.showWeek = next.show_week;
            timeLine.showDay = next.show_day;
            timeLine.festivals = next.festivals;
            this.commonPhotoTimeLineList.add(timeLine);
        }
    }

    public void setPhotoSearchBox(PhotoSearchBox photoSearchBox) {
        if (photoSearchBox != null && photoSearchBox.status == 3 && photoSearchBox.items != null) {
            PhotoSearchBoxCacheData photoSearchBoxCacheData = new PhotoSearchBoxCacheData();
            this.photoSearchBox = photoSearchBoxCacheData;
            photoSearchBoxCacheData.status = photoSearchBox.status;
            photoSearchBoxCacheData.types = photoSearchBox.types;
            photoSearchBoxCacheData.items = new HashMap();
            Iterator<Integer> it = photoSearchBox.items.keySet().iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                PhotoSearchBoxItem photoSearchBoxItem = photoSearchBox.items.get(Integer.valueOf(intValue));
                PhotoSearchBoxItemCacheData photoSearchBoxItemCacheData = new PhotoSearchBoxItemCacheData();
                photoSearchBoxItemCacheData.desc = photoSearchBoxItem.desc;
                photoSearchBoxItemCacheData.elems = new ArrayList<>();
                Iterator<PhotoSearchBoxItemElem> it5 = photoSearchBoxItem.elems.iterator();
                while (it5.hasNext()) {
                    PhotoSearchBoxItemElem next = it5.next();
                    PhotoSearchBoxItemElemCacheData photoSearchBoxItemElemCacheData = new PhotoSearchBoxItemElemCacheData();
                    photoSearchBoxItemElemCacheData.categoryid = next.categoryid;
                    photoSearchBoxItemElemCacheData.desc = next.desc;
                    photoSearchBoxItemElemCacheData.type = next.type;
                    photoSearchBoxItemElemCacheData.url = next.url;
                    FaceShowInfoCacheData faceShowInfoCacheData = new FaceShowInfoCacheData();
                    photoSearchBoxItemElemCacheData.face_show = faceShowInfoCacheData;
                    face_show_info face_show_infoVar = next.face_show;
                    faceShowInfoCacheData.status = face_show_infoVar.status;
                    faceShowInfoCacheData.groupids = face_show_infoVar.groupids;
                    faceShowInfoCacheData.pic_host = new UinNickInfoCacheData();
                    UinNickInfoCacheData uinNickInfoCacheData = photoSearchBoxItemElemCacheData.face_show.pic_host;
                    uin_nick_info uin_nick_infoVar = next.face_show.pic_host;
                    uinNickInfoCacheData.nick = uin_nick_infoVar.nick;
                    uinNickInfoCacheData.uin = uin_nick_infoVar.uin;
                    photoSearchBoxItemCacheData.elems.add(photoSearchBoxItemElemCacheData);
                }
                this.photoSearchBox.items.put(Integer.valueOf(intValue), photoSearchBoxItemCacheData);
            }
            QZLog.d("AlbumPhotoSearchBox", 2, this.photoSearchBox.toString());
            return;
        }
        this.photoSearchBox = null;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements IDBCacheDataWrapper.b<AlbumCacheData> {
        a() {
        }

        private byte[] b(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex != -1) {
                return cursor.getBlob(columnIndex);
            }
            return null;
        }

        private int c(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex != -1) {
                return cursor.getInt(columnIndex);
            }
            return 0;
        }

        private long d(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex != -1) {
                return cursor.getLong(columnIndex);
            }
            return 0L;
        }

        private String e(Cursor cursor, String str) {
            int columnIndex = cursor.getColumnIndex(str);
            if (columnIndex != -1) {
                return cursor.getString(columnIndex);
            }
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AlbumCacheData createFromCursor(Cursor cursor) {
            AlbumCacheData albumCacheData = new AlbumCacheData();
            albumCacheData.albumname = e(cursor, "albumname");
            albumCacheData.albumid = e(cursor, "albumid");
            albumCacheData.albumtype = c(cursor, "albumtype");
            albumCacheData.albumnum = c(cursor, "albumnum");
            albumCacheData.videoNum = c(cursor, AlbumCacheData.VIDEO_NUM);
            albumCacheData.photoNum = c(cursor, AlbumCacheData.PHOTO_NUM);
            albumCacheData.uploadnum = c(cursor, "uploadnum");
            albumCacheData.albumrights = c(cursor, "albumrights");
            albumCacheData.allowAccess = c(cursor, AlbumCacheData.ALLOW_ACCESS) > 0;
            albumCacheData.albumquestion = e(cursor, "albumquestion");
            albumCacheData.albumanswer = e(cursor, "albumanswer");
            albumCacheData.albumdesc = e(cursor, "albumdesc");
            albumCacheData.ownerUin = d(cursor, "ownerUin");
            albumCacheData.sortorder = c(cursor, AlbumCacheData.SORTORDER);
            albumCacheData.loginUin = d(cursor, AlbumCacheData.LOGINUIN);
            albumCacheData.birthNickname = e(cursor, AlbumCacheData.BIRTHNICKNAME);
            albumCacheData.birthYear = d(cursor, AlbumCacheData.BIRTHYEAR);
            albumCacheData.birthMonth = d(cursor, AlbumCacheData.BIRTHMONTH);
            albumCacheData.birthDay = d(cursor, AlbumCacheData.BIRTHDAY);
            albumCacheData.birthType = d(cursor, AlbumCacheData.BIRTHTYPE);
            albumCacheData.sexual = c(cursor, AlbumCacheData.SEXUAL);
            byte[] b16 = b(cursor, AlbumCacheData.ALBUM_WHITE_LIST);
            if (b16 != null) {
                try {
                    Parcel obtain = Parcel.obtain();
                    obtain.unmarshall(b16, 0, b16.length);
                    obtain.setDataPosition(0);
                    albumCacheData.album_white_list = obtain.readArrayList(getClass().getClassLoader());
                    OaidMonitor.parcelRecycle(obtain);
                } catch (Exception e16) {
                    QZLog.w(e16);
                }
            }
            byte[] b17 = b(cursor, AlbumCacheData.ALBUM_COVER_LIST);
            if (b17 != null) {
                try {
                    Parcel obtain2 = Parcel.obtain();
                    obtain2.unmarshall(b17, 0, b17.length);
                    obtain2.setDataPosition(0);
                    albumCacheData.coverUrlList = ParcelableWrapper.createArrayListFromParcel(obtain2);
                    OaidMonitor.parcelRecycle(obtain2);
                } catch (Exception e17) {
                    QZLog.w(e17);
                }
            }
            byte[] b18 = b(cursor, AlbumCacheData.ALBUM_EXTRA_DATA);
            if (b18 != null) {
                try {
                    Parcel obtain3 = Parcel.obtain();
                    obtain3.unmarshall(b18, 0, b18.length);
                    obtain3.setDataPosition(0);
                    albumCacheData.busi_param = obtain3.readHashMap(getClass().getClassLoader());
                    albumCacheData.coverUrl = (PictureUrl) ParcelableWrapper.createDataFromParcel(obtain3);
                    OaidMonitor.parcelRecycle(obtain3);
                } catch (Exception e18) {
                    QZLog.w(e18);
                }
            }
            albumCacheData.lastRefreshTime = d(cursor, "last_refresh_time");
            albumCacheData.anonymity = c(cursor, AlbumCacheData.ANONYMITY);
            albumCacheData.operatemask = c(cursor, AlbumCacheData.OPERATEMASK);
            albumCacheData.birthDateTime = d(cursor, AlbumCacheData.BIRTH_DATE_TIME);
            byte[] b19 = b(cursor, AlbumCacheData.PARENTING_DATA);
            if (b19 != null) {
                try {
                    Parcel obtain4 = Parcel.obtain();
                    obtain4.unmarshall(b19, 0, b19.length);
                    obtain4.setDataPosition(0);
                    albumCacheData.parentingData = (ParentingAlbumData) ParcelableWrapper.createDataFromParcel(obtain4);
                    OaidMonitor.parcelRecycle(obtain4);
                } catch (Exception e19) {
                    QZLog.w(e19);
                }
            }
            byte[] b26 = b(cursor, AlbumCacheData.TRAVEL_DATA);
            if (b26 != null) {
                try {
                    Parcel obtain5 = Parcel.obtain();
                    obtain5.unmarshall(b26, 0, b26.length);
                    obtain5.setDataPosition(0);
                    albumCacheData.travelData = (TravelAlbumData) ParcelableWrapper.createDataFromParcel(obtain5);
                    OaidMonitor.parcelRecycle(obtain5);
                } catch (Exception e26) {
                    QZLog.w(e26);
                }
            }
            byte[] b27 = b(cursor, AlbumCacheData.TIMEEVENT_DATA);
            if (b27 != null) {
                Parcel obtain6 = Parcel.obtain();
                obtain6.unmarshall(b27, 0, b27.length);
                obtain6.setDataPosition(0);
                albumCacheData.timeEventData = obtain6.readArrayList(TimeEvent.class.getClassLoader());
                OaidMonitor.parcelRecycle(obtain6);
            }
            try {
                albumCacheData.actiontype = c(cursor, "actiontype");
                albumCacheData.actionUrl = e(cursor, AlbumCacheData.ACTIONURL);
            } catch (Exception e27) {
                QZLog.w(e27);
            }
            byte[] b28 = b(cursor, AlbumCacheData.ALBUM_TEMPLATE);
            if (b28 != null) {
                MaterialItem materialItem = (MaterialItem) b.b(MaterialItem.class, b28);
                albumCacheData.albumTemplate = materialItem;
                if (materialItem != null) {
                    albumCacheData.albumTemplateData = (CustomAlbumTemplate) b.b(CustomAlbumTemplate.class, materialItem.strExtFields);
                }
            }
            try {
                albumCacheData.createTime = c(cursor, AlbumCacheData.CREATE_TIME);
            } catch (Exception e28) {
                QZLog.w(e28);
            }
            albumCacheData.allow_share = c(cursor, AlbumCacheData.ALBUM_ALLOW_SHARE);
            albumCacheData.individual = c(cursor, AlbumCacheData.INDIVIDUAL);
            albumCacheData.justUploadSign = c(cursor, AlbumCacheData.JUSTUPLOADSIGN);
            albumCacheData.albumOwner = e(cursor, AlbumCacheData.ALBUM_OWNER);
            byte[] b29 = b(cursor, AlbumCacheData.SHARING_ALBUM_CLIENT_ATTR);
            if (b29 != null) {
                try {
                    Parcel obtain7 = Parcel.obtain();
                    obtain7.unmarshall(b29, 0, b29.length);
                    obtain7.setDataPosition(0);
                    albumCacheData.sharingAlbumClientAttrArrayList = ParcelableWrapper.createArrayListFromParcel(obtain7);
                    OaidMonitor.parcelRecycle(obtain7);
                } catch (Exception unused) {
                }
            }
            albumCacheData.isShareAlbumOnServer = c(cursor, AlbumCacheData.SHARE_SHAREALBUM) == 1;
            albumCacheData.createSharingUin = d(cursor, AlbumCacheData.SHARE_CREATEUIN);
            albumCacheData.loveTime = d(cursor, AlbumCacheData.LOVE_TIME);
            byte[] b36 = b(cursor, AlbumCacheData.LOVE_EVENT_LIST);
            if (b36 != null) {
                try {
                    Parcel obtain8 = Parcel.obtain();
                    obtain8.unmarshall(b36, 0, b36.length);
                    obtain8.setDataPosition(0);
                    albumCacheData.loveAlbumTimeEventList = ParcelableWrapper.createArrayListFromParcel(obtain8);
                    OaidMonitor.parcelRecycle(obtain8);
                } catch (Exception e29) {
                    QZLog.w(e29);
                }
            }
            albumCacheData.loveValue = d(cursor, AlbumCacheData.LOVE_VALUE);
            albumCacheData.isSharingOwner = c(cursor, AlbumCacheData.ISSHARINGOWNER_VALUE) == 1;
            albumCacheData.allowAutoJoinShareAlbum = c(cursor, AlbumCacheData.ALLOW_AUTO_JOIN_SHARE_ALBUM_VALUE) == 1;
            albumCacheData.bitmap = e(cursor, "bitmap");
            byte[] b37 = b(cursor, AlbumCacheData.SHARING_ALBUM_MEMBER_DATA_LIST);
            if (b37 != null) {
                try {
                    Parcel obtain9 = Parcel.obtain();
                    obtain9.unmarshall(b37, 0, b37.length);
                    obtain9.setDataPosition(0);
                    albumCacheData.shareAlbumMemberDataList = ParcelableWrapper.createArrayListFromParcel(obtain9);
                    OaidMonitor.parcelRecycle(obtain9);
                } catch (Exception e36) {
                    QZLog.w(e36);
                }
            }
            byte[] b38 = b(cursor, AlbumCacheData.COMMON_PHOTO_TIMELINE_LIST);
            if (b38 != null) {
                try {
                    Parcel obtain10 = Parcel.obtain();
                    obtain10.unmarshall(b38, 0, b38.length);
                    obtain10.setDataPosition(0);
                    albumCacheData.commonPhotoTimeLineList = ParcelableWrapper.createArrayListFromParcel(obtain10);
                    OaidMonitor.parcelRecycle(obtain10);
                } catch (Exception e37) {
                    QZLog.w(e37);
                }
            }
            albumCacheData.ark_id = e(cursor, AlbumCacheData.ARK_ID);
            albumCacheData.view_id = e(cursor, "view_id");
            albumCacheData.ark_content = e(cursor, AlbumCacheData.ARK_CONTENT);
            albumCacheData.sortType = c(cursor, AlbumCacheData.SORT_TYPE);
            albumCacheData.isToppedAlbum = c(cursor, AlbumCacheData.IS_TOPPED_ALBUM) == 1;
            byte[] b39 = b(cursor, AlbumCacheData.PHOTO_SEARCH_BOX);
            if (b39 != null) {
                try {
                    Parcel obtain11 = Parcel.obtain();
                    obtain11.unmarshall(b39, 0, b39.length);
                    obtain11.setDataPosition(0);
                    albumCacheData.photoSearchBox = (PhotoSearchBoxCacheData) ParcelableWrapper.createDataFromParcel(obtain11);
                    OaidMonitor.parcelRecycle(obtain11);
                } catch (Exception e38) {
                    QZLog.w(e38);
                }
            }
            albumCacheData.photoSearchStatus = c(cursor, AlbumCacheData.PHOTO_SEARCH_STATUS);
            albumCacheData.viewCount = c(cursor, AlbumCacheData.VIEW_COUNT);
            albumCacheData.likeCount = c(cursor, "likeCount");
            albumCacheData.albumTypeIcon = e(cursor, AlbumCacheData.ALBUM_TYPE_ICON);
            albumCacheData.syncFanmilyStatus = c(cursor, AlbumCacheData.FAMILY_SYNC_STATUS);
            albumCacheData.ark_id_invate = e(cursor, AlbumCacheData.ARK_ID_INVATE);
            albumCacheData.view_id_invate = e(cursor, AlbumCacheData.VIEW_ID_INVATE);
            albumCacheData.ark_content_invate = e(cursor, AlbumCacheData.ARK_CONTENT_INVATE);
            return albumCacheData;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.b
        public String indexRawSql(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return " CREATE INDEX IF NOT EXISTS album_id_index  ON " + str + " (albumid)";
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public String sortOrder() {
            return null;
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public IDBCacheDataWrapper.c[] structure() {
            return new IDBCacheDataWrapper.c[]{new IDBCacheDataWrapper.c("albumname", "TEXT"), new IDBCacheDataWrapper.c("albumid", "TEXT UNIQUE"), new IDBCacheDataWrapper.c("albumtype", "INTEGER"), new IDBCacheDataWrapper.c("albumnum", "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.VIDEO_NUM, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.PHOTO_NUM, "INTEGER"), new IDBCacheDataWrapper.c("uploadnum", "INTEGER"), new IDBCacheDataWrapper.c("albumrights", "INTEGER"), new IDBCacheDataWrapper.c("albumquestion", "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.ALLOW_ACCESS, "INTEGER"), new IDBCacheDataWrapper.c("albumanswer", "TEXT"), new IDBCacheDataWrapper.c("albumdesc", "TEXT"), new IDBCacheDataWrapper.c("ownerUin", "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.SORTORDER, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.LOGINUIN, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ALBUM_WHITE_LIST, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.ALBUM_COVER_LIST, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.ALBUM_EXTRA_DATA, "BLOB"), new IDBCacheDataWrapper.c("last_refresh_time", "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ANONYMITY, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.OPERATEMASK, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.BIRTH_DATE_TIME, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.PARENTING_DATA, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.TRAVEL_DATA, "BLOB"), new IDBCacheDataWrapper.c("actiontype", "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ACTIONURL, "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.TIMEEVENT_DATA, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.BIRTHNICKNAME, "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.BIRTHYEAR, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.BIRTHMONTH, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.BIRTHDAY, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.BIRTHTYPE, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ALBUM_TEMPLATE, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.CREATE_TIME, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ALBUM_ALLOW_SHARE, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.SEXUAL, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.INDIVIDUAL, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.JUSTUPLOADSIGN, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ALBUM_OWNER, "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.SHARING_ALBUM_CLIENT_ATTR, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.SHARE_SHAREALBUM, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.SHARE_CREATEUIN, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.LOVE_TIME, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.LOVE_EVENT_LIST, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.LOVE_VALUE, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ISSHARINGOWNER_VALUE, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ALLOW_AUTO_JOIN_SHARE_ALBUM_VALUE, "INTEGER"), new IDBCacheDataWrapper.c("bitmap", "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.SHARING_ALBUM_MEMBER_DATA_LIST, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.COMMON_PHOTO_TIMELINE_LIST, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.ARK_ID, "TEXT"), new IDBCacheDataWrapper.c("view_id", "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.ARK_CONTENT, "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.SORT_TYPE, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.IS_TOPPED_ALBUM, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.PHOTO_SEARCH_BOX, "BLOB"), new IDBCacheDataWrapper.c(AlbumCacheData.PHOTO_SEARCH_STATUS, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.VIEW_COUNT, "INTEGER"), new IDBCacheDataWrapper.c("likeCount", "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ALBUM_TYPE_ICON, "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.FAMILY_SYNC_STATUS, "INTEGER"), new IDBCacheDataWrapper.c(AlbumCacheData.ARK_ID_INVATE, "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.VIEW_ID_INVATE, "TEXT"), new IDBCacheDataWrapper.c(AlbumCacheData.ARK_CONTENT_INVATE, "TEXT")};
        }

        @Override // com.qzone.lib.wrapper.db.IDBCacheDataWrapper.a
        public int version() {
            return 48;
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

    private static boolean getAlbumPermission(String str, int i3) {
        if (str == null || str.length() <= i3 || 1 != i3) {
            return false;
        }
        return "1".equals(String.valueOf(str.charAt(1)));
    }

    public void setTimeEventList(ArrayList<NS_MOBILE_PHOTO.TimeEvent> arrayList) {
        if (arrayList == null) {
            return;
        }
        this.timeEventData = new ArrayList<>();
        Iterator<NS_MOBILE_PHOTO.TimeEvent> it = arrayList.iterator();
        while (it.hasNext()) {
            NS_MOBILE_PHOTO.TimeEvent next = it.next();
            TimeEvent timeEvent = new TimeEvent();
            timeEvent.f43879d = next.time;
            timeEvent.f43880e = next.type;
            timeEvent.f43881f = next.content;
            this.timeEventData.add(timeEvent);
        }
    }

    public static Bundle createUgcSettingParam(AlbumCacheData albumCacheData, String str) {
        if (albumCacheData == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        int a16 = h.a(albumCacheData.albumrights);
        bundle.putInt(UgcSettingUtil.KEY_PERMISSION_CODE, a16);
        ArrayList<Long> arrayList = albumCacheData.album_white_list;
        if (arrayList != null && arrayList.size() > 0 && TextUtils.isEmpty(str)) {
            ArrayList<String> arrayList2 = new ArrayList<>();
            ArrayList<String> arrayList3 = new ArrayList<>(arrayList2.size());
            Iterator<Long> it = albumCacheData.album_white_list.iterator();
            while (it.hasNext()) {
                Long next = it.next();
                arrayList2.add(String.valueOf(next));
                arrayList3.add(f.f().g(String.valueOf(next)));
            }
            bundle.putStringArrayList("uin_list", arrayList2);
            bundle.putStringArrayList(UgcSettingUtil.KEY_NICKNAMES, arrayList3);
        }
        if (a16 == 9999) {
            bundle.putString(UgcSettingUtil.KEY_QUESTION, albumCacheData.albumquestion);
            bundle.putString(UgcSettingUtil.KEY_ANSWER, albumCacheData.albumanswer);
        }
        if (h.h(a16) && !TextUtils.isEmpty(str)) {
            bundle.putString(UgcSettingUtil.KEY_UGC_SETTING_RAW_JSON, str);
        }
        return bundle;
    }

    public void setAlbumThemeTypeValue(int i3) {
        if (8 == i3) {
            this.anonymity = 5;
            return;
        }
        if (i3 == 9) {
            this.anonymity = 6;
            return;
        }
        if (i3 == 11) {
            this.anonymity = 8;
        } else if (i3 == 12) {
            this.anonymity = 9;
        } else {
            this.anonymity = 1;
        }
    }

    public Album createAlbumRequestModel(int i3, AlbumCacheData albumCacheData, int i16) {
        if (albumCacheData == null) {
            return null;
        }
        Album album = new Album();
        if (i3 == 1) {
            album.albumid = albumCacheData.albumid;
            PictureUrl pictureUrl = albumCacheData.coverUrl;
            if (pictureUrl != null) {
                album.coverurl = pictureUrl.url;
            }
        } else if (i3 == 0) {
            album.albumid = "";
        } else if (i3 == 2) {
            if (i16 == 2) {
                album.albumid = "";
            } else {
                album.albumid = albumCacheData.getShareOwnerAlbumId();
            }
        }
        album.name = albumCacheData.albumname;
        album.type = albumCacheData.albumtype;
        album.priv = albumCacheData.albumrights;
        album.question = albumCacheData.albumquestion;
        album.answer = albumCacheData.albumanswer;
        album.desc = albumCacheData.albumdesc;
        album.birth_time = albumCacheData.birthDateTime;
        album.uin = LoginData.getInstance().getUin();
        album.album_white_list = albumCacheData.album_white_list;
        album.birth_nickname = albumCacheData.birthNickname;
        album.birth_sexual = albumCacheData.sexual;
        album.individual = albumCacheData.individual;
        album.createtime = albumCacheData.createTime;
        album.albumowner = albumCacheData.albumOwner;
        ArrayList<SharingAlbumClientAttr> arrayList = albumCacheData.sharingAlbumClientAttrArrayList;
        if (arrayList != null && arrayList.size() > 0) {
            album.shareattrs = new ArrayList<>();
            for (int i17 = 0; i17 < albumCacheData.sharingAlbumClientAttrArrayList.size(); i17++) {
                SharingAlbumClientAttr sharingAlbumClientAttr = albumCacheData.sharingAlbumClientAttrArrayList.get(i17);
                if (sharingAlbumClientAttr.uin != 0) {
                    album.shareattrs.add(new client_attr(sharingAlbumClientAttr.uin, sharingAlbumClientAttr.uinAttr.generateJceFromCache(), sharingAlbumClientAttr.qq_nick, sharingAlbumClientAttr.action, 0L));
                }
            }
        }
        album.is_share = albumCacheData.isShareAlbumOnServer ? 1 : 0;
        album.owner = albumCacheData.createSharingUin;
        album.love_time = albumCacheData.loveTime;
        album.love_value = albumCacheData.loveValue;
        album.total = albumCacheData.albumnum;
        String str = albumCacheData.bitmap;
        album.bitmap = str;
        album.bitmap = setAlbumPermission(str, 1, albumCacheData.allowAutoJoinShareAlbum);
        if (albumCacheData.loveAlbumTimeEventList != null) {
            album.lover_events = new ArrayList<>();
            for (int i18 = 0; i18 < albumCacheData.loveAlbumTimeEventList.size(); i18++) {
                album.lover_events.add(albumCacheData.loveAlbumTimeEventList.get(i18).generateRequestModel());
            }
        }
        return album;
    }

    public int getTargetTypeMaxCount(int i3) {
        if (i3 == 11) {
            return 2;
        }
        if (i3 == 12) {
            return u4.a.z().H();
        }
        if (i3 == 1) {
            return 1;
        }
        return u4.a.z().G();
    }

    public static AlbumCacheData createFromResponse(Album album) {
        if (album == null) {
            return null;
        }
        return createFromResponse(album, album.busi_param);
    }

    public static AlbumCacheData createFromResponse(Album album, Map<Integer, String> map) {
        if (album == null) {
            return null;
        }
        AlbumCacheData albumCacheData = new AlbumCacheData();
        albumCacheData.albumname = album.name;
        albumCacheData.albumid = album.albumid;
        int i3 = album.type;
        albumCacheData.albumtype = i3;
        albumCacheData.albumnum = album.total;
        albumCacheData.videoNum = album.video_num;
        albumCacheData.photoNum = album.photo_num;
        albumCacheData.albumrights = album.priv;
        albumCacheData.albumquestion = album.question;
        albumCacheData.albumanswer = album.answer;
        albumCacheData.albumdesc = album.desc;
        albumCacheData.ownerUin = album.uin;
        albumCacheData.album_white_list = album.album_white_list;
        albumCacheData.busi_param = map;
        albumCacheData.operatemask = album.opmask;
        albumCacheData.anonymity = getAnonymityValueByTypeValue(i3);
        albumCacheData.birthDateTime = album.birth_time;
        albumCacheData.birthNickname = album.birth_nickname;
        albumCacheData.birthYear = album.birth_year;
        albumCacheData.birthMonth = album.birth_month;
        albumCacheData.birthDay = album.birth_day;
        albumCacheData.birthType = album.birth_type;
        albumCacheData.coverUrl = new PictureUrl(album.coverurl, 0, 0);
        MaterialItem materialItem = album.material;
        albumCacheData.albumTemplate = materialItem;
        if (materialItem != null) {
            albumCacheData.albumTemplateData = (CustomAlbumTemplate) b.b(CustomAlbumTemplate.class, materialItem.strExtFields);
        }
        albumCacheData.createTime = album.createtime;
        albumCacheData.allow_share = album.allow_share;
        albumCacheData.sexual = album.birth_sexual;
        albumCacheData.individual = album.individual;
        albumCacheData.albumOwner = album.albumowner;
        ArrayList<client_attr> arrayList = album.shareattrs;
        if (arrayList != null && arrayList.size() > 0) {
            albumCacheData.sharingAlbumClientAttrArrayList = new ArrayList<>();
            for (int i16 = 0; i16 < album.shareattrs.size(); i16++) {
                albumCacheData.sharingAlbumClientAttrArrayList.add(new SharingAlbumClientAttr(album.shareattrs.get(i16)));
            }
        }
        albumCacheData.isShareAlbumOnServer = album.is_share == 1;
        albumCacheData.createSharingUin = album.owner;
        albumCacheData.loveTime = album.love_time;
        if (album.lover_events != null) {
            albumCacheData.loveAlbumTimeEventList = new ArrayList<>();
            for (int i17 = 0; i17 < album.lover_events.size(); i17++) {
                albumCacheData.loveAlbumTimeEventList.add(LoveAlbumTimeEvent.createFromResponse(album.lover_events.get(i17)));
            }
        }
        albumCacheData.loveValue = album.love_value;
        String str = album.bitmap;
        albumCacheData.bitmap = str;
        albumCacheData.isToppedAlbum = album.top_flag == 1;
        albumCacheData.syncFanmilyStatus = album.game_album_flag;
        albumCacheData.allowAutoJoinShareAlbum = getAlbumPermission(str, 1);
        s_arkshare s_arkshareVar = album.ark_sharedata;
        if (s_arkshareVar != null && !TextUtils.isEmpty(s_arkshareVar.ark_content)) {
            s_arkshare s_arkshareVar2 = album.ark_sharedata;
            albumCacheData.ark_content = s_arkshareVar2.ark_content;
            albumCacheData.view_id = s_arkshareVar2.view_id;
            albumCacheData.ark_id = s_arkshareVar2.ark_id;
        }
        s_arkshare s_arkshareVar3 = album.share_album_invate_ark;
        if (s_arkshareVar3 != null && !TextUtils.isEmpty(s_arkshareVar3.ark_content)) {
            s_arkshare s_arkshareVar4 = album.share_album_invate_ark;
            albumCacheData.ark_content_invate = s_arkshareVar4.ark_content;
            albumCacheData.view_id_invate = s_arkshareVar4.view_id;
            albumCacheData.ark_id_invate = s_arkshareVar4.ark_id;
        }
        return albumCacheData;
    }
}
