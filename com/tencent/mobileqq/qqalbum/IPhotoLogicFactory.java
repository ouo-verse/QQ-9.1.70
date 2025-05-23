package com.tencent.mobileqq.qqalbum;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.albumlist.b;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.photolist.f;
import com.tencent.mobileqq.activity.photo.album.preview.AbstractPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.album.preview.e;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process = {"peak"})
@Deprecated
/* loaded from: classes16.dex */
public interface IPhotoLogicFactory extends QRouteApi {
    public static final String BASE_ALBUM_HOME_ACTIVITY_URI = "/base/album/home";
    public static final String ENTER_FROM = "enter_from";
    public static final int FORM_MINIAPP = 4;
    public static final int FROM_AE_CAMERA = 26;
    public static final int FROM_AE_CAMERA_FOR_CM_SHOW = 53;
    public static final int FROM_AE_CIRCLE = 29;
    public static final int FROM_AE_PLAY = 23;
    public static final int FROM_AIO_LONGSHOT = 42;
    public static final int FROM_ARK = 3;
    public static final int FROM_DATALINE_PHOTO_LIST_PANEL = 40;
    public static final int FROM_DEFAULT = 0;
    public static final int FROM_EMOTION_FAVORITE = 2;
    public static final int FROM_EXTEND_FRIEND_AVATAR = 55;
    public static final int FROM_EXTEND_FRIEND_PHOTO_WALL = 54;
    public static final int FROM_FAVOUTITE = 43;
    public static final int FROM_FILEASSISTANT_LIST_PANEL = 51;
    public static final int FROM_GAME_CENTER_STRATEGY = 57;
    public static final int FROM_GUILD_CHANNEL_HOMEPAGE_PUBLISH = 56;
    public static final int FROM_HEALTH_ENTRY = 46;
    public static final int FROM_KUIKLY = 60;
    public static final int FROM_LOGIN = 59;
    public static final int FROM_NEARBY = 30;
    public static final int FROM_NEWER_CROP = 50;
    public static final int FROM_PERSONALITY_LABEL = 48;
    public static final int FROM_PHOTO_LIST_AIO = 1;
    public static final int FROM_PROFILE_CUSTOM_COVER = 44;
    public static final int FROM_QCIRCLE = 31;
    public static final int FROM_QZONE = 7;
    public static final int FROM_READ_IN_JOY = 25;
    public static final int FROM_SCAN_ENTRY = 45;
    public static final int FROM_SCAN_FAST_IMAGE_AND_CAMERA = 52;
    public static final int FROM_SCAN_OCR = 49;
    public static final int FROM_TENCENT_DOCS = 27;
    public static final int FROM_TROOPFILE = 41;
    public static final int FROM_TROOP_BAR_PUBLISH = 24;
    public static final int FROM_TROOP_HW = 47;
    public static final int FROM_WEIYUN = 28;
    public static final int FROM_ZPLAN_BG_EDIT = 58;
    public static final String KEY_ALBUM_LIST_CLASS_NAME = "KEY_ALBUM_LIST_CLASS_NAME";
    public static final String KEY_PHOTO_LIST_CLASS_NAME = "KEY_PHOTO_LIST_CLASS_NAME";
    public static final String KEY_PHOTO_PREVIEW_CLASS_NAME = "KEY_PHOTO_PREVIEW_CLASS_NAME";
    public static final String PHOTO_LIST_ACTIVITY_CLASS_NAME = "com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity";
    public static final String PHOTO_LIST_ACTIVITY_URI = "/base/album/photolist";
    public static final String PHOTO_PREVIEW_ACTIVITY_URI = "/base/album/photopreview";
    public static final String SHORT_VIDEO_PREVIEW_ACTIVITY_URI = "/base/album/shortvideopreview";
    public static final String TAG = "QQAlbum";

    b<? extends OtherCommonData> createAlbumListLogic(AbstractAlbumListFragment abstractAlbumListFragment, Intent intent);

    f<? extends OtherCommonData> createPhotoListLogic(AbstractPhotoListActivity abstractPhotoListActivity, Intent intent);

    e<? extends OtherCommonData> createPhotoPreviewLogic(AbstractPhotoPreviewActivity abstractPhotoPreviewActivity, Intent intent);
}
