package com.qzone.preview.service;

import NS_MOBILE_PHOTO.EditPhoto;
import NS_MOBILE_PHOTO.MarkFaceItemFeed;
import NS_MOBILE_PHOTO.MarkFaceItemMood;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.preview.service.base.PictureConst;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.Comment;
import com.qzone.proxy.feedcomponent.model.Reply;
import com.qzone.proxy.feedcomponent.model.User;
import com.qzone.widget.RapidCommentExpressionInfo;
import com.tencent.YTFace.model.FaceTarget;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.qqlive.module.videoreport.dtreport.video.tvkplayer.TVKDataBinder;
import com.tencent.util.Pair;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.SimpleFontInfo;
import cooperation.qzone.model.MapParcelable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes39.dex */
public class RequestSender implements PictureConst {
    private PictureManager manager;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RequestSender(PictureManager pictureManager) {
        this.manager = pictureManager;
    }

    public int addFavor(Handler handler, long j3, long j16, long j17, String str, String str2, String str3, HashMap<String, String> hashMap, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putLong(PictureConst.PARAM_FAVOR_OWN_UIN, j3);
        bundle.putLong(PictureConst.PARAM_FAVOR_APPID, j16);
        bundle.putLong(PictureConst.PARAM_FAVOR_SUBID, j17);
        bundle.putString(PictureConst.PARAM_FAVOR_CELLID, str);
        bundle.putString(PictureConst.PARAM_FAVOR_SID, str2);
        bundle.putString(PictureConst.PARAM_FAVOR_UGCKEY, str3);
        bundle.putSerializable(PictureConst.PARAM_FAVOR_BUSIPARAM, hashMap);
        bundle.putStringArrayList(PictureConst.PARAM_FAVOR_PHOTOS, arrayList);
        return this.manager.sendData(PictureConst.CMD_ADD_FAVOR, bundle, handler);
    }

    public int cloudBatchFaceRecognize(Handler handler, ArrayList<float[]> arrayList, FaceTarget faceTarget, String str) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(PictureConst.PARAM_FEATURELIST, arrayList);
        bundle.putSerializable(PictureConst.PARAM_FACETARGET, faceTarget);
        bundle.putString(PictureConst.PARAM_FACE_PIC_LLOC, str);
        return this.manager.sendData(PictureConst.CMD_CLOUD_BATCH_FACE_RECOGNIZE, bundle, handler);
    }

    public int commentFriendVideo(Handler handler, BusinessFeedData businessFeedData, String str, String str2, ArrayList<String> arrayList, boolean z16) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_CACHE_UNIKEY, str);
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_FRIEND_VIDEO_FEED_DATA, businessFeedData);
        bundle.putStringArrayList(PictureConst.PARAM_COMMENT_PICS, arrayList);
        bundle.putString("param.content", str2);
        bundle.putBoolean(PictureConst.PARAM_IS_PRIVATE, z16);
        return this.manager.sendData(PictureConst.CMD_COMMENT_FRIEND_VIDEO, bundle, handler);
    }

    public int commentPhoto(Handler handler, String str, String str2, String str3, int i3, long j3, String str4, String str5, int i16, String str6, Map<Integer, String> map, int i17, Pair<String, String> pair, boolean z16, ArrayList<String> arrayList, int i18, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_UGCKEY, str);
        bundle.putString(PictureConst.PARAM_FEEDKEY, str2);
        bundle.putString(PictureConst.PARAM_FAKEUNIKEY, UUID.randomUUID().toString());
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putLong("param.uin", j3);
        bundle.putString(PictureConst.PARAM_SRCID, str4);
        bundle.putString("param.content", str5);
        bundle.putInt(PictureConst.PARAM_ISVERIFY, i16);
        bundle.putString(PictureConst.PARAM_FONT_INFO, str7);
        bundle.putString(PictureConst.PARAM_SUPER_FONT_INFO, str8);
        bundle.putString(PictureConst.PARAM_BARRAGE_EFFECT_INFO, str9);
        bundle.putString(PictureConst.PARAM_LLOC, str3);
        bundle.putString(PictureConst.PARAM_CACHE_UNIKEY, str6);
        bundle.putSerializable(PictureConst.PARAM_BUSI_PARAM, (HashMap) map);
        bundle.putInt(PictureConst.PARAM_SYN, i17);
        if (pair != null) {
            bundle.putSerializable(PictureConst.PARAM_PICTURE_ITEM, pair);
        }
        bundle.putString("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW);
        bundle.putBoolean(PictureConst.PARAM_IS_PRIVATE, z16);
        bundle.putStringArrayList(PictureConst.PARAM_COMMENT_PICS, arrayList);
        bundle.putInt("param.index", i18);
        return this.manager.sendData(PictureConst.CMD_COMMENT_PHOTO, bundle, handler);
    }

    public int commentQunPhoto(Handler handler, int i3, String str, String str2, String str3, int i16, long j3, String str4, String str5, int i17, String str6, Map<Integer, String> map, int i18, Pair<String, String> pair, boolean z16, ArrayList<String> arrayList, int i19, String str7, String str8, String str9) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_UGCKEY, str);
        bundle.putString(PictureConst.PARAM_FEEDKEY, str2);
        bundle.putString(PictureConst.PARAM_FAKEUNIKEY, UUID.randomUUID().toString());
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putLong("param.uin", j3);
        bundle.putString(PictureConst.PARAM_SRCID, str4);
        bundle.putString("param.content", str5);
        bundle.putInt(PictureConst.PARAM_ISVERIFY, i17);
        bundle.putString(PictureConst.PARAM_FONT_INFO, str7);
        bundle.putString(PictureConst.PARAM_SUPER_FONT_INFO, str8);
        bundle.putString(PictureConst.PARAM_BARRAGE_EFFECT_INFO, str9);
        bundle.putString(PictureConst.PARAM_LLOC, str3);
        bundle.putString(PictureConst.PARAM_CACHE_UNIKEY, str6);
        bundle.putSerializable(PictureConst.PARAM_BUSI_PARAM, (HashMap) map);
        bundle.putInt(PictureConst.PARAM_SYN, i18);
        if (pair != null) {
            bundle.putSerializable(PictureConst.PARAM_PICTURE_ITEM, pair);
        }
        bundle.putString("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW);
        bundle.putBoolean(PictureConst.PARAM_IS_PRIVATE, z16);
        bundle.putStringArrayList(PictureConst.PARAM_COMMENT_PICS, arrayList);
        bundle.putInt("param.index", i19);
        return this.manager.sendData(PictureConst.CMD_QUN_COMMENT_PHOTO, bundle, handler);
    }

    public int delFavor(Handler handler, long j3, String str, long j16, long j17) {
        Bundle bundle = new Bundle();
        bundle.putLong(PictureConst.PARAM_FAVOR_OWN_UIN, j3);
        bundle.putString(PictureConst.PARAM_FAVOR_UGCKEY, str);
        bundle.putLong(PictureConst.PARAM_FAVOR_APPID, j16);
        bundle.putLong(PictureConst.PARAM_FAVOR_SUBID, j17);
        return this.manager.sendData(PictureConst.CMD_DEL_FAVOR, bundle, handler);
    }

    public int delLocalPhoto(Handler handler, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_DEL_PHOTO_PATH, str);
        return this.manager.sendData(PictureConst.CMD_DEL_LOCAL_PHOTO, bundle, handler);
    }

    public int deleteComment(Handler handler, BusinessFeedData businessFeedData, Comment comment) {
        Bundle bundle = new Bundle();
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_FEED_DATA, businessFeedData);
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_COMMENT_ITEM, comment);
        return this.manager.sendData(PictureConst.CMD_DELETE_COMMENT, bundle, handler);
    }

    public int deletePhoto(Handler handler, String str, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_ALBUMID, str);
        bundle.putStringArrayList(PictureConst.PARAM_PHOTOIDLIST, arrayList);
        bundle.putStringArrayList(PictureConst.PARAM_VIDEOIDLIST, arrayList2);
        bundle.putString("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW);
        return this.manager.sendData(PictureConst.CMD_DELETE_PHOTO, bundle, handler);
    }

    public int deleteReply(Handler handler, BusinessFeedData businessFeedData, Reply reply, Comment comment, int i3) {
        Bundle bundle = new Bundle();
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_FEED_DATA, businessFeedData);
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_REPLY_ITEM, reply);
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_COMMENT_ITEM, comment);
        bundle.putInt(PictureConst.PARAM_POSITION, i3);
        return this.manager.sendData(PictureConst.CMD_DELETE_REPLY, bundle, handler);
    }

    public int deleteSearchPhoto(Handler handler, String str, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_ALBUMID, str);
        bundle.putStringArrayList(PictureConst.PARAM_PHOTOIDLIST, arrayList);
        bundle.putStringArrayList(PictureConst.PARAM_VIDEOIDLIST, arrayList2);
        bundle.putBoolean(PictureConst.PARAM_FROM_SEARCH_RESULT, true);
        bundle.putString("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW);
        return this.manager.sendData(PictureConst.CMD_DELETE_PHOTO, bundle, handler);
    }

    public int deleteShuoShuoVideo(Handler handler, int i3, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putStringArrayList(PictureConst.PARAM_VIDEOIDLIST, arrayList);
        bundle.putString("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW);
        return this.manager.sendData(PictureConst.CMD_DELETE_PHOTO, bundle, handler);
    }

    public int downloadVideo(String str, Handler handler) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_URL, str);
        return this.manager.sendData(PictureConst.CMD_DOWNLOAD_VIDEO, bundle, handler);
    }

    public int editPhotoDesc(Handler handler, String str, ArrayList<String> arrayList, EditPhoto editPhoto, int i3, Map<Integer, String> map, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_ALBUMID, str);
        bundle.putStringArrayList(PictureConst.PARAM_PHOTOEDIT_IDLIST, arrayList);
        bundle.putInt(PictureConst.PARAM_PHOTOEDIT_OPERATYPE, i3);
        bundle.putSerializable(PictureConst.PARAM_PHOTOEDIT_PHOTOINFO, editPhoto);
        bundle.putString(PictureConst.PARAM_PHOTOEDIT_CACHEKEY, str2);
        return this.manager.sendData(PictureConst.CMD_EDIT_PHOTOINFO, bundle, handler);
    }

    public int faceOperation(Handler handler, MarkFaceItemMood markFaceItemMood, MarkFaceItemFeed markFaceItemFeed, long j3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(PictureConst.PARAM_MARKFACE_MARKFACEITEMMOOD, markFaceItemMood);
        bundle.putSerializable(PictureConst.PARAM_MARKFACE_MARKFACEITEMFEED, markFaceItemFeed);
        bundle.putLong(PictureConst.PARAM_MARKFACE_OWNERUIN, j3);
        bundle.putInt(PictureConst.PARAM_MARKFACE_SCENE, i3);
        return this.manager.sendData(PictureConst.CMD_FACE_OPERATION, bundle, handler);
    }

    public int forwardFriendVideo(Handler handler, BusinessFeedData businessFeedData, String str, String str2) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_CACHE_UNIKEY, str);
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_FRIEND_VIDEO_FEED_DATA, businessFeedData);
        bundle.putString("param.content", str2);
        bundle.putInt(PictureConst.PARAM_ACTION_TYPE, 1);
        return this.manager.sendData(PictureConst.CMD_FORWARD_FRIEND_VIDEO, bundle, handler);
    }

    public int forwardPhoto(Handler handler, String str, String str2, int i3, int i16, long j3, String str3, ArrayList<String> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putString("param.content", str);
        bundle.putString(PictureConst.PARAM_CACHE_UNIKEY, str2);
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putInt(PictureConst.PARAM_SUBID, i16);
        bundle.putLong("param.uin", j3);
        bundle.putString(PictureConst.PARAM_SRCID, str3);
        bundle.putStringArrayList(PictureConst.PARAM_SRCSUBID, arrayList);
        bundle.putString("refer", QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW);
        return this.manager.sendData(PictureConst.CMD_FORWARD_PHOTO, bundle, handler);
    }

    public int getBigPhotoAdList(int i3, int i16, Handler handler) {
        Bundle bundle = new Bundle();
        bundle.putInt("local_type", i3);
        bundle.putInt("remote_type", i16);
        return this.manager.sendData(PictureConst.CMD_GET_BIG_PHOTO_AD_LIST, bundle, handler);
    }

    public int getFeedComment(Handler handler, long j3, int i3, String str, String str2, Map<Integer, String> map) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putString(PictureConst.PARAM_CELLID, str);
        bundle.putString(PictureConst.PARAM_SUBID, str2);
        bundle.putParcelable(PictureConst.PARAM_BUSI_PARAM, new MapParcelable(map));
        return this.manager.sendData(PictureConst.CMD_GET_FEED_COMMENT, bundle, handler);
    }

    public int getMoreComment(Handler handler, long j3, int i3, String str, String str2, String str3, int i16, Map<Integer, String> map, int i17, boolean z16, boolean z17) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putString(PictureConst.PARAM_CELLID, str);
        bundle.putString(PictureConst.PARAM_SUBID, str2);
        bundle.putString(PictureConst.PARAM_ATTACHINFO, str3);
        bundle.putInt(PictureConst.PARAM_COUNT, i16);
        bundle.putParcelable(PictureConst.PARAM_BUSI_PARAM, new MapParcelable(map));
        bundle.putInt(PictureConst.PARAM_REFRESHTYPE, i17);
        bundle.putBoolean(PictureConst.PARAM_REQUEST_LIKE_INFO, z16);
        bundle.putBoolean(PictureConst.PARAM_SAVE_DB, z17);
        return this.manager.sendData(PictureConst.CMD_GET_MORE_COMMENT, bundle, handler);
    }

    public int getMoreCommentEssence(Handler handler, long j3, int i3, String str, String str2, String str3, int i16, Map<Integer, String> map, int i17, boolean z16, boolean z17) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putString(PictureConst.PARAM_CELLID, str);
        bundle.putString(PictureConst.PARAM_SUBID, str2);
        bundle.putString(PictureConst.PARAM_ATTACHINFO, str3);
        bundle.putInt(PictureConst.PARAM_COUNT, i16);
        bundle.putParcelable(PictureConst.PARAM_BUSI_PARAM, new MapParcelable(map));
        bundle.putInt(PictureConst.PARAM_REFRESHTYPE, i17);
        bundle.putBoolean(PictureConst.PARAM_REQUEST_LIKE_INFO, z16);
        bundle.putBoolean(PictureConst.PARAM_SAVE_DB, z17);
        return this.manager.sendData(PictureConst.CMD_GET_MORE_COMMENT_ESSENCE, bundle, handler);
    }

    public int getMorePhotoDataList(int i3, Handler handler) {
        Bundle bundle = new Bundle();
        bundle.putInt("scroll_orientation", i3);
        return this.manager.sendData(PictureConst.CMD_GET_MORE_PHOTO_DATA_LIST, bundle, handler);
    }

    public int getOutShareUrl(Handler handler, int i3, int i16, String str, String str2, String str3, String str4, int i17, long j3, int i18, Map<Integer, String> map) {
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putInt(PictureConst.PARAM_TYPE, i16);
        bundle.putString(PictureConst.PARAM_SRCID, str);
        bundle.putString(PictureConst.PARAM_ALBUMID, str2);
        bundle.putString(PictureConst.PARAM_LLOC, str3);
        bundle.putString(PictureConst.PARAM_BATCHID, str4);
        bundle.putInt(PictureConst.PARAM_IISSHARETO, i17);
        bundle.putLong(PictureConst.PARAM_HOSTUIN, j3);
        bundle.putInt(PictureConst.PARAM_SHARESCENE, i18);
        bundle.putSerializable(PictureConst.PARAM_BUSI_PARAM, (HashMap) map);
        return this.manager.sendData(PictureConst.CMD_GET_OUT_SHARE_URL, bundle, handler);
    }

    public int getQzonePhotoCommentEx(Handler handler, long j3, String str, String str2, String str3, int i3) {
        Bundle bundle = new Bundle();
        bundle.putLong("param.uin", j3);
        bundle.putString(PictureConst.PARAM_CELLID, str);
        bundle.putString(PictureConst.PARAM_ALBUMID, str3);
        bundle.putString(PictureConst.PARAM_PHOTOID, str2);
        bundle.putInt(PictureConst.PARAM_REQ_TYPE, i3);
        return this.manager.sendData(PictureConst.CMD_GET_QZONE_PHOTOCOMMENTEX, bundle, handler);
    }

    public int getVideoId(Handler handler, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_URL, str);
        return this.manager.sendData(PictureConst.CMD_GET_VIDEO_ID, bundle, handler);
    }

    public int likeComment(Handler handler, QZoneWriteOperationService.k kVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.PARAM_APPID, kVar.f45701h);
        bundle.putParcelable(PictureConst.PARAM_BUSI_PARAM, new MapParcelable(kVar.f45702i));
        bundle.putString(PictureConst.PARAM_FEEDKEY, kVar.f45697d);
        bundle.putString(PictureConst.PARAM_UGCKEY, kVar.f45696c);
        bundle.putString(PictureConst.PARAM_UNIKEY, kVar.f45698e);
        bundle.putLong("param.uin", kVar.f45694a);
        bundle.putString(PictureConst.PARAM_COMM_KEY, kVar.f45699f);
        bundle.putString(PictureConst.PARAM_COMMENT_ID, kVar.f45703j);
        bundle.putBoolean(PictureConst.PARAM_ISLIKE, kVar.f45700g);
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_TARGET_USER, kVar.f45695b);
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_CUSTOM_PRAISE_DATA, kVar.f45706m);
        bundle.putInt(PictureConst.PARAM_COMBO_COUNT, kVar.f45707n);
        return this.manager.sendData(PictureConst.CMD_LIKE_COMMENT, bundle, handler);
    }

    public int praiseFriendVideo(Handler handler, BusinessFeedData businessFeedData) {
        Bundle bundle = new Bundle();
        ParcelableWrapper.putDataToBundle(bundle, PictureConst.PARAM_FRIEND_VIDEO_FEED_DATA, businessFeedData);
        bundle.putString(PictureConst.PARAM_FRIEND_VIDEO_UNIKEY, businessFeedData.getCellUserInfo().uniKey);
        return this.manager.sendData(PictureConst.CMD_PRAISE_FRIEND_VIDEO, bundle, handler);
    }

    public int praisePhoto(Handler handler, String str, String str2, String str3, String str4, boolean z16, int i3, Map<Integer, String> map, int i16, int i17) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_UGCKEY, str);
        bundle.putString(PictureConst.PARAM_FEEDKEY, str2);
        bundle.putString(PictureConst.PARAM_CURKEY, str3);
        bundle.putString(PictureConst.PARAM_UNIKEY, str4);
        bundle.putBoolean(PictureConst.PARAM_ISLIKE, z16);
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putSerializable(PictureConst.PARAM_BUSI_PARAM, (HashMap) map);
        bundle.putInt(PictureConst.PARAM_SYN, i16);
        bundle.putInt("param.index", i17);
        return this.manager.sendData(PictureConst.CMD_PRAISE_PHOTO, bundle, handler);
    }

    public int queryAlbum(Handler handler, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_ALBUMID, str);
        return this.manager.sendData(PictureConst.CMD_QUERY_ALBUM, bundle, handler);
    }

    public int rapidCommentFeed(Handler handler, QZoneWriteOperationService.l lVar, RapidCommentExpressionInfo rapidCommentExpressionInfo) {
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.PARAM_APPID, lVar.f45712e);
        bundle.putParcelable(PictureConst.PARAM_BUSI_PARAM, new MapParcelable(lVar.f45718k));
        bundle.putString("param.content", lVar.f45715h);
        bundle.putString(PictureConst.PARAM_CACHE_UNIKEY, lVar.f45716i);
        bundle.putString(PictureConst.PARAM_FAKEUNIKEY, lVar.f45710c);
        bundle.putString(PictureConst.PARAM_FEEDKEY, lVar.f45709b);
        bundle.putString(PictureConst.PARAM_CLIENT_KEY, lVar.f45711d);
        bundle.putBoolean(PictureConst.PARAM_IS_PRIVATE, lVar.f45725r);
        bundle.putBoolean(PictureConst.PARAM_IS_TODAY_IN_HIS_FEED, lVar.f45724q);
        bundle.putParcelable(PictureConst.PARAM_PICTURE_ITEM, ParcelableWrapper.obtain(lVar.f45720m));
        bundle.putLong("param.uin", lVar.f45713f);
        bundle.putString(PictureConst.PARAM_SRCID, lVar.f45714g);
        bundle.putString(PictureConst.PARAM_UGCKEY, lVar.f45708a);
        bundle.putString(PictureConst.PARAM_RELATIVE_UGC_KEY, lVar.f45722o);
        bundle.putStringArrayList(PictureConst.PARAM_COMMENT_PICS, lVar.f45726s);
        bundle.putInt(PictureConst.PARAM_SRC_REFER, lVar.f45728u);
        Map<String, String> map = lVar.f45730w;
        if (map != null && !map.isEmpty()) {
            try {
                SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
                simpleFontInfo.fontId = Integer.valueOf(lVar.f45730w.get("diy_font_id")).intValue();
                simpleFontInfo.formatType = Integer.valueOf(lVar.f45730w.get("diy_font_type")).intValue();
                simpleFontInfo.fontUrl = lVar.f45730w.get("diy_font_url");
                bundle.putString(PictureConst.PARAM_FONT_INFO, simpleFontInfo.toString());
            } catch (Throwable unused) {
            }
            bundle.putString(PictureConst.PARAM_SUPER_FONT_INFO, lVar.f45730w.get("sparkle_json"));
            bundle.putString(PictureConst.PARAM_BARRAGE_EFFECT_INFO, lVar.f45730w.get("private_barrage_data"));
        }
        bundle.putString(PictureConst.PARAM_LLOC, lVar.f45729v);
        bundle.putInt(PictureConst.PARAM_POSITION, lVar.f45723p);
        bundle.putParcelable(PictureConst.PARAM_RAPID_COMMENT_INFO, rapidCommentExpressionInfo);
        return this.manager.sendData(PictureConst.CMD_COMMENT_FEED, bundle, handler);
    }

    public int replyFeed(Handler handler, String str, String str2, String str3, int i3, long j3, long j16, User user, String str4, String str5, String str6, String str7, String str8, String str9, int i16, Map<Integer, String> map, String str10, boolean z16, int i17, int i18, Map<String, String> map2) {
        Bundle bundle = new Bundle();
        bundle.putString(PictureConst.PARAM_UGCKEY, str);
        bundle.putString(PictureConst.PARAM_FEEDKEY, str2);
        bundle.putString(PictureConst.PARAM_FAKEUNIKEY, str3);
        bundle.putInt(PictureConst.PARAM_APPID, i3);
        bundle.putLong("param.uin", j3);
        bundle.putLong(PictureConst.PARAM_COMMENT_UIN, j16);
        bundle.putParcelable(PictureConst.PARAM_TARGET_USER, ParcelableWrapper.obtain(user));
        bundle.putString(PictureConst.PARAM_SRCID, str4);
        bundle.putString(PictureConst.PARAM_LLOC, str5);
        bundle.putString(PictureConst.PARAM_COMMENT_ID, str6);
        bundle.putString("param.content", str7);
        bundle.putString(PictureConst.PARAM_ORI_CONTENT, str8);
        bundle.putString(PictureConst.PARAM_CACHE_UNIKEY, str9);
        bundle.putInt(PictureConst.PARAM_ISVERIFY, i16);
        bundle.putParcelable(PictureConst.PARAM_BUSI_PARAM, new MapParcelable(map));
        bundle.putString(PictureConst.PARAM_REFER, str10);
        bundle.putBoolean(PictureConst.PARAM_IS_TODAY_IN_HIS_FEED, z16);
        bundle.putInt(PictureConst.PARAM_POSITION, i17);
        bundle.putInt(PictureConst.PARAM_CLICK_SCENE, i18);
        if (map2 != null && !map2.isEmpty()) {
            try {
                SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
                simpleFontInfo.fontId = Integer.valueOf(map2.get("diy_font_id")).intValue();
                simpleFontInfo.formatType = Integer.valueOf(map2.get("diy_font_type")).intValue();
                simpleFontInfo.fontUrl = map2.get("diy_font_url");
                bundle.putString(PictureConst.PARAM_FONT_INFO, simpleFontInfo.toString());
            } catch (Throwable unused) {
            }
            bundle.putString(PictureConst.PARAM_SUPER_FONT_INFO, map2.get("sparkle_json"));
        }
        return this.manager.sendData(PictureConst.CMD_REPLY_FEED, bundle, handler);
    }

    public int reship(Handler handler, String str, QZoneWriteOperationService.p pVar) {
        Bundle bundle = new Bundle();
        bundle.putInt(PictureConst.PARAM_APPID, pVar.f45771c);
        bundle.putLong("param.uin", pVar.f45773e);
        bundle.putString(PictureConst.PARAM_SRCID, pVar.f45774f);
        bundle.putStringArrayList(PictureConst.PARAM_SRCSUBID, pVar.f45775g);
        bundle.putSerializable(PictureConst.PARAM_PHOTOIDLIST, (HashMap) pVar.f45790v);
        bundle.putString(PictureConst.PARAM_ALBUMID, str);
        return this.manager.sendData(PictureConst.CMD_RESHIP, bundle, handler);
    }

    public int sendReportExposeOrClick(String str, String str2, boolean z16, Handler handler) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        Bundle bundle = new Bundle();
        bundle.putString("trace_info", str);
        bundle.putString("account_type", str2);
        bundle.putBoolean(TVKDataBinder.KEY_REPORT_TYPE, z16);
        return this.manager.sendData(PictureConst.CMD_SEND_REPORT_EXPOSE_OR_CLICK, bundle, handler);
    }

    public int startDownloadVideo(Handler handler) {
        return this.manager.sendData(PictureConst.CMD_START_DOWNLOAD_VIDEO, new Bundle(), handler);
    }

    public int stopDownloadVideo(Handler handler) {
        return this.manager.sendData(PictureConst.CMD_STOP_DOWNLOAD_VIDEO, new Bundle(), handler);
    }

    public int commentFeed(Handler handler, QZoneWriteOperationService.l lVar) {
        return rapidCommentFeed(handler, lVar, null);
    }

    public int faceOperation(Handler handler, MarkFaceItemMood markFaceItemMood, MarkFaceItemFeed markFaceItemFeed, long j3, int i3, String str, int i16) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(PictureConst.PARAM_MARKFACE_MARKFACEITEMMOOD, markFaceItemMood);
        bundle.putSerializable(PictureConst.PARAM_MARKFACE_MARKFACEITEMFEED, markFaceItemFeed);
        bundle.putLong(PictureConst.PARAM_MARKFACE_OWNERUIN, j3);
        bundle.putInt(PictureConst.PARAM_MARKFACE_SCENE, i3);
        bundle.putString(PictureConst.PARAM_MARKFACE_UNIKEY, str);
        bundle.putInt(PictureConst.PARAM_MARKFACE_INDEX, i16);
        return this.manager.sendData(PictureConst.CMD_FACE_OPERATION, bundle, handler);
    }
}
