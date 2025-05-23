package com.qzone.preview.service;

import NS_MOBILE_FEEDS.cnst.UNIVERSAL_MALL_QUAL;
import NS_MOBILE_PHOTO.EditPhoto;
import android.text.TextUtils;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.preview.PictureViewerFactory;
import com.qzone.proxy.feedcomponent.model.CustomPraiseData;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.service.QzoneCustomPraiseService;
import com.qzone.publish.ui.model.QzoneBarrageEffectData;
import com.qzone.publish.ui.model.QzoneSuperPersonalFontData;
import com.tencent.util.Pair;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.font.SimpleFontInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import ug.b;

/* loaded from: classes39.dex */
public class QZoneInteractPhotoRequestBuilder {
    public int appId;
    public String cacheKey;
    public ArrayList<String> commentPics;
    public HashMap<String, String> extendMap;
    public Map<Integer, String> extraInfoMap;
    public int index;
    public boolean isFromSearchResult;
    public boolean isLike;
    public boolean isPrivate;
    public boolean isTodayInHisFeed;
    public long ownerUin;
    public Pair<String, String> photo;
    public ArrayList<String> photoIdList;
    public EditPhoto photoInfo;
    public ArrayList<String> photoUrlList;
    public ArrayList<String> srcSubId;
    public ArrayList<String> videoIdList;
    public String ugcKey = "";
    public String feedKey = "";
    public String curKey = "";
    public String uniKey = "";
    public String lloc = "";
    public String srcId = "";
    public String content = "";
    public int isVerified = 0;
    public String contentCacheUniKey = "";
    public int syn = 0;
    public String fontInfo = "";
    public String superFontInfo = "";
    public String barrageEffectInfo = "";
    public int ugcType = 0;
    public String cellId = "";
    public String albumId = "";
    public String batchId = "";
    public int iIsShareTo = 0;
    public int shareScene = 0;
    public long subId = 0;
    public String cellSubId = "";
    public int operateType = 0;
    public String groupId = "";
    public String feedId = "";
    public long uploadUin = 0;
    public String commentText = "";
    public String extendInfo = "";
    public int clickScene = 0;
    public String forwardText = "";

    public QZoneInteractPhotoRequestBuilder setAlbumId(String str) {
        this.albumId = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setAppId(int i3) {
        this.appId = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setBarrageEffectInfo(String str) {
        this.barrageEffectInfo = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setBatchId(String str) {
        this.batchId = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setCacheKey(String str) {
        this.cacheKey = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setCellId(String str) {
        this.cellId = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setCellSubId(String str) {
        this.cellSubId = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setClickScene(int i3) {
        this.clickScene = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setCommentPics(ArrayList<String> arrayList) {
        this.commentPics = arrayList;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setCommentText(String str) {
        this.commentText = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setContent(String str) {
        this.content = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setContentCacheUniKey(String str) {
        this.contentCacheUniKey = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setCurKey(String str) {
        this.curKey = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setExtendInfo(String str) {
        this.extendInfo = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setExtendMap(HashMap<String, String> hashMap) {
        this.extendMap = hashMap;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setExtraInfoMap(Map<Integer, String> map) {
        this.extraInfoMap = map;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setFeedId(String str) {
        this.feedId = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setFeedKey(String str) {
        this.feedKey = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setFontInfo(String str) {
        this.fontInfo = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setForwardText(String str) {
        this.forwardText = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setGroupId(String str) {
        this.groupId = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setIisShareTo(int i3) {
        this.iIsShareTo = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setIndex(int i3) {
        this.index = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setIsFromSearchResult(boolean z16) {
        this.isFromSearchResult = z16;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setIsLike(boolean z16) {
        this.isLike = z16;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setIsPrivate(boolean z16) {
        this.isPrivate = z16;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setIsTodayInHisFeed(boolean z16) {
        this.isTodayInHisFeed = z16;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setIsVerified(int i3) {
        this.isVerified = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setLloc(String str) {
        this.lloc = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setOperateType(int i3) {
        this.operateType = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setOwnerUin(long j3) {
        this.ownerUin = j3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setPairPhoto(Pair<String, String> pair) {
        this.photo = pair;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setPhotoIdList(ArrayList<String> arrayList) {
        this.photoIdList = arrayList;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setPhotoInfo(EditPhoto editPhoto) {
        this.photoInfo = editPhoto;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setPhotoUrlList(ArrayList<String> arrayList) {
        this.photoUrlList = arrayList;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setShareScene(int i3) {
        this.shareScene = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setSrcId(String str) {
        this.srcId = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setSrcSubId(ArrayList<String> arrayList) {
        this.srcSubId = arrayList;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setSubId(long j3) {
        this.subId = j3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setSuperFontInfo(String str) {
        this.superFontInfo = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setSyn(int i3) {
        this.syn = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setUgcKey(String str) {
        this.ugcKey = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setUgcType(int i3) {
        this.ugcType = i3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setUniKey(String str) {
        this.uniKey = str;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setUploadUin(long j3) {
        this.uploadUin = j3;
        return this;
    }

    public QZoneInteractPhotoRequestBuilder setVideoIdList(ArrayList<String> arrayList) {
        this.videoIdList = arrayList;
        return this;
    }

    public QZoneWriteOperationService.l transformBuilderToCommentParams() {
        PictureItem pictureItem;
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45708a = this.ugcKey;
        lVar.f45709b = this.feedKey;
        lVar.f45710c = UUID.randomUUID().toString();
        lVar.f45712e = this.appId;
        lVar.f45713f = this.ownerUin;
        lVar.f45714g = this.srcId;
        lVar.f45715h = this.content;
        lVar.f45717j = this.isVerified;
        lVar.f45716i = this.contentCacheUniKey;
        lVar.f45718k = this.extraInfoMap;
        lVar.f45721n = this.syn;
        Pair<String, String> pair = this.photo;
        if (pair != null) {
            pictureItem = new PictureItem();
            PictureViewerFactory.m0(pictureItem, pair);
        } else {
            pictureItem = null;
        }
        lVar.f45720m = pictureItem;
        lVar.f45725r = this.isPrivate;
        lVar.f45719l = QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW;
        lVar.f45726s = this.commentPics;
        lVar.f45723p = this.index;
        lVar.f45728u = 2;
        lVar.f45729v = this.lloc;
        String str = this.fontInfo;
        if (!TextUtils.isEmpty(str)) {
            SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
            simpleFontInfo.readFrom(str);
            if (simpleFontInfo.hasFont()) {
                HashMap hashMap = new HashMap();
                lVar.f45730w = hashMap;
                hashMap.put("diy_font_id", simpleFontInfo.fontId + "");
                lVar.f45730w.put("diy_font_type", simpleFontInfo.formatType + "");
                lVar.f45730w.put("diy_font_url", simpleFontInfo.fontUrl);
            }
        }
        String str2 = this.superFontInfo;
        if (!TextUtils.isEmpty(str2)) {
            QzoneSuperPersonalFontData.SuperFontInfo fromJson = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str2);
            if (fromJson.f51897id > 0) {
                if (lVar.f45730w == null) {
                    lVar.f45730w = new HashMap();
                }
                lVar.f45730w.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, fromJson.f51897id + "");
                lVar.f45730w.put("sparkle_json", str2);
            }
        }
        String str3 = this.barrageEffectInfo;
        if (!TextUtils.isEmpty(str3)) {
            QzoneBarrageEffectData.BarrageEffectInfo fromJson2 = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(str3);
            if (fromJson2.f51896id > 0) {
                if (lVar.f45730w == null) {
                    lVar.f45730w = new HashMap();
                }
                lVar.f45730w.put(UNIVERSAL_MALL_QUAL.value, fromJson2.f51896id + "");
                lVar.f45730w.put("private_barrage_data", str3);
            }
        }
        return lVar;
    }

    public QZoneWriteOperationService.l transformBuilderToGroupCommentParams() {
        PictureItem pictureItem;
        QzoneBarrageEffectData.BarrageEffectInfo fromJson;
        QZoneWriteOperationService.l lVar = new QZoneWriteOperationService.l();
        lVar.f45708a = this.feedId;
        lVar.f45709b = this.feedKey;
        lVar.f45710c = UUID.randomUUID().toString();
        lVar.B = this.groupId;
        lVar.f45713f = this.uploadUin;
        lVar.f45714g = this.albumId;
        lVar.f45715h = this.commentText;
        lVar.f45717j = this.isVerified;
        lVar.f45716i = this.contentCacheUniKey;
        lVar.f45718k = this.extraInfoMap;
        lVar.f45721n = this.syn;
        Pair<String, String> pair = this.photo;
        if (pair != null) {
            pictureItem = new PictureItem();
            PictureViewerFactory.m0(pictureItem, pair);
        } else {
            pictureItem = null;
        }
        lVar.f45720m = pictureItem;
        lVar.f45725r = this.isPrivate;
        lVar.f45719l = QZoneHelper.QZoneAppConstants.REFER_PHOTO_PREVIEW;
        lVar.f45726s = this.commentPics;
        lVar.f45723p = this.index;
        lVar.f45728u = 2;
        lVar.f45729v = this.lloc;
        lVar.A = true;
        String str = this.fontInfo;
        if (!TextUtils.isEmpty(str)) {
            SimpleFontInfo simpleFontInfo = new SimpleFontInfo();
            simpleFontInfo.readFrom(str);
            if (simpleFontInfo.hasFont()) {
                HashMap hashMap = new HashMap();
                lVar.f45730w = hashMap;
                hashMap.put("diy_font_id", simpleFontInfo.fontId + "");
                lVar.f45730w.put("diy_font_type", simpleFontInfo.formatType + "");
                lVar.f45730w.put("diy_font_url", simpleFontInfo.fontUrl);
            }
        }
        String str2 = this.superFontInfo;
        if (!TextUtils.isEmpty(str2)) {
            QzoneSuperPersonalFontData.SuperFontInfo fromJson2 = QzoneSuperPersonalFontData.SuperFontInfo.fromJson(str2);
            if (fromJson2.f51897id > 0) {
                if (lVar.f45730w == null) {
                    lVar.f45730w = new HashMap();
                }
                lVar.f45730w.put(QZoneHelper.QzoneFeedActionPanelConstants.KEY_SPARKLE_WORD_ID, fromJson2.f51897id + "");
                lVar.f45730w.put("sparkle_json", str2);
            }
        }
        String str3 = this.barrageEffectInfo;
        if (!TextUtils.isEmpty(str3) && (fromJson = QzoneBarrageEffectData.BarrageEffectInfo.fromJson(str3)) != null && fromJson.f51896id > 0) {
            if (lVar.f45730w == null) {
                lVar.f45730w = new HashMap();
            }
            lVar.f45730w.put(UNIVERSAL_MALL_QUAL.value, fromJson.f51896id + "");
            lVar.f45730w.put("private_barrage_data", str3);
        }
        return lVar;
    }

    public QZoneWriteOperationService.m transformBuilderToLikeParams() {
        QZoneWriteOperationService.m mVar = new QZoneWriteOperationService.m();
        mVar.f45734a = this.ugcKey;
        mVar.f45735b = this.curKey;
        mVar.f45736c = this.uniKey;
        mVar.f45738e = this.isLike;
        mVar.f45739f = this.appId;
        mVar.f45752s = this.ownerUin;
        Map<Integer, String> map = this.extraInfoMap;
        mVar.f45740g = map;
        if (map != null) {
            map.put(142, "8");
        }
        mVar.f45741h = this.syn;
        mVar.f45742i = this.index;
        CustomPraiseData g16 = QzoneCustomPraiseService.i().g();
        mVar.f45748o = g16;
        if (g16 == null) {
            mVar.f45748o = b.f438918a.b();
        }
        mVar.f45749p = 1;
        return mVar;
    }
}
