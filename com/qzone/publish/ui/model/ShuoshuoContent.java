package com.qzone.publish.ui.model;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import android.os.Bundle;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.common.friend.business.model.Friend;
import com.qzone.proxy.feedcomponent.model.ShuoshuoVideoInfo;
import com.tencent.biz.subscribe.widget.commodity.CommodityBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import cooperation.qzone.model.FaceData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ShuoshuoContent {
    public static final int SYN_BIT_KUOLIE = 16;
    public static final int SYN_BIT_QQ = 1;
    public static final int SYN_BIT_RENZHENGHAO = 32;
    public static final int SYN_BIT_WECHAT = 4;
    public static final int SYN_BIT_WEIBO = 2;
    public static final int SYN_BIT_WEISHI = 8;
    public static final int SYN_BIT_WEZONE = 64;
    private List<Friend> atFriends;
    private String clientKey;
    private LbsDataV2.PoiInfo currentPoiInfo;
    private HashMap<String, PicInfo> eggsUrlMap;
    private LbsDataV2.PoiInfo finalPoiInfo;
    private String imageShootInfoDateAndWeather;
    private String imageShootInfoLbs;
    private Boolean longPicModeOpen;
    private ArrayList<CommodityBean> mCommdityLists;
    private LbsDataV2.PoiInfo mCurrentShootPoiInfo;
    private int mPriv;
    private List<String> mPrivUinList;
    private PublishEventTag publishEventTag;
    private HashMap<String, ShuoshuoVideoInfo> recordedVideoInfoMap;
    private List<String> selectedImage;
    private HashMap<String, LocalMediaInfo> selectedMeidaInfo;
    private HashMap<String, PicInfo> selectedQzonePhotos;
    private HashMap<String, ShuoshuoVideoInfo> selectedVideoInfoMap;
    private int showType;
    private int state;
    private String textDraft;
    private String textDraftSource;
    private long timer;
    private String titleTextDraft;
    private ShuoshuoVideoInfo videoInfo;
    private boolean eggLayoutSwitch = false;
    private HashMap<String, Integer> mShuoShuoDraftVideoMap = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> mRecodeVideoDraftMap = new HashMap<>();
    private HashMap<String, HashMap<String, Integer>> mSelectedVideoInfoDraftMap = new HashMap<>();
    protected HashMap<String, MarkUinInfoBeforeUpload> mMarksUploadMap = new HashMap<>();
    protected HashMap<String, Boolean> mMarkHasCheckFacesMap = new HashMap<>();
    protected HashMap<String, ArrayList<FaceData>> mMarksFaceDataMap = new HashMap<>();
    protected HashMap<String, Boolean> mMarkNeedShowFaceIconMap = new HashMap<>();
    private int syncBit = 0;

    private void parseBundleToDraftMap() {
        ShuoshuoVideoInfo shuoshuoVideoInfo = this.videoInfo;
        if (shuoshuoVideoInfo != null && shuoshuoVideoInfo.mExtras != null) {
            this.mShuoShuoDraftVideoMap = bundleToMap(shuoshuoVideoInfo);
            this.videoInfo.mExtras = null;
        }
        HashMap<String, ShuoshuoVideoInfo> hashMap = this.recordedVideoInfoMap;
        if (hashMap != null && hashMap.size() > 0) {
            for (String str : this.recordedVideoInfoMap.keySet()) {
                ShuoshuoVideoInfo shuoshuoVideoInfo2 = this.recordedVideoInfoMap.get(str);
                if (shuoshuoVideoInfo2 != null && shuoshuoVideoInfo2.mExtras != null) {
                    this.mRecodeVideoDraftMap.put(str, bundleToMap(shuoshuoVideoInfo2));
                    shuoshuoVideoInfo2.mExtras = null;
                }
            }
        }
        HashMap<String, ShuoshuoVideoInfo> hashMap2 = this.selectedVideoInfoMap;
        if (hashMap2 == null || hashMap2.size() <= 0) {
            return;
        }
        for (String str2 : this.selectedVideoInfoMap.keySet()) {
            ShuoshuoVideoInfo shuoshuoVideoInfo3 = this.selectedVideoInfoMap.get(str2);
            if (shuoshuoVideoInfo3 != null && shuoshuoVideoInfo3.mExtras != null) {
                this.mSelectedVideoInfoDraftMap.put(str2, bundleToMap(shuoshuoVideoInfo3));
                shuoshuoVideoInfo3.mExtras = null;
            }
        }
    }

    private void resetDraftMapToBundle() {
        HashMap<String, HashMap<String, Integer>> hashMap;
        HashMap<String, HashMap<String, Integer>> hashMap2;
        HashMap<String, Integer> hashMap3;
        if (this.videoInfo != null && (hashMap3 = this.mShuoShuoDraftVideoMap) != null && hashMap3.size() > 0) {
            this.videoInfo.mExtras = mapToBundle(this.mShuoShuoDraftVideoMap);
        }
        HashMap<String, ShuoshuoVideoInfo> hashMap4 = this.recordedVideoInfoMap;
        if (hashMap4 != null && hashMap4.size() > 0 && (hashMap2 = this.mRecodeVideoDraftMap) != null && hashMap2.size() > 0) {
            for (String str : this.mRecodeVideoDraftMap.keySet()) {
                if (this.recordedVideoInfoMap.containsKey(str)) {
                    this.recordedVideoInfoMap.get(str).mExtras = mapToBundle(this.mRecodeVideoDraftMap.get(str));
                }
            }
        }
        HashMap<String, ShuoshuoVideoInfo> hashMap5 = this.selectedVideoInfoMap;
        if (hashMap5 == null || hashMap5.size() <= 0 || (hashMap = this.mSelectedVideoInfoDraftMap) == null || hashMap.size() <= 0) {
            return;
        }
        for (String str2 : this.mSelectedVideoInfoDraftMap.keySet()) {
            if (this.selectedVideoInfoMap.containsKey(str2)) {
                this.selectedVideoInfoMap.get(str2).mExtras = mapToBundle(this.mSelectedVideoInfoDraftMap.get(str2));
            }
        }
    }

    public static ShuoshuoContent toShuoshuoContent(String str) {
        try {
            ShuoshuoContent shuoshuoContent = (ShuoshuoContent) com.tencent.biz.pubaccount.util.d.b().a(str, ShuoshuoContent.class);
            shuoshuoContent.resetDraftMapToBundle();
            return shuoshuoContent;
        } catch (Exception unused) {
            QLog.d("shuoshuoContent", 4, "to ShuoShuoContent failed");
            return null;
        }
    }

    public List<Friend> getAtFriends() {
        return this.atFriends;
    }

    public String getClientKey() {
        return this.clientKey;
    }

    public ArrayList<CommodityBean> getCommdityLists() {
        return this.mCommdityLists;
    }

    public LbsDataV2.PoiInfo getCurrentPoiInfo() {
        return this.currentPoiInfo;
    }

    public boolean getEggLayoutSwitch() {
        return this.eggLayoutSwitch;
    }

    public HashMap<String, PicInfo> getEggsUrlMap() {
        return this.eggsUrlMap;
    }

    public PublishEventTag getEventTag() {
        return this.publishEventTag;
    }

    public LbsDataV2.PoiInfo getFinalPoiInfo() {
        return this.finalPoiInfo;
    }

    public String getImageShootInfoDateAndWeather() {
        return this.imageShootInfoDateAndWeather;
    }

    public String getImageShootInfoLbs() {
        return this.imageShootInfoLbs;
    }

    public Boolean getIsLongPicModeOpen() {
        return this.longPicModeOpen;
    }

    public HashMap<String, ShuoshuoVideoInfo> getRecordedVideoInfoMap() {
        return this.recordedVideoInfoMap;
    }

    public List<String> getSelectedImage() {
        return this.selectedImage;
    }

    public HashMap<String, LocalMediaInfo> getSelectedMeidaInfo() {
        return this.selectedMeidaInfo;
    }

    public HashMap<String, PicInfo> getSelectedQzonePhotos() {
        return this.selectedQzonePhotos;
    }

    public HashMap<String, ShuoshuoVideoInfo> getSelectedVideoInfoMap() {
        return this.selectedVideoInfoMap;
    }

    public int getShowType() {
        return this.showType;
    }

    public int getState() {
        return this.state;
    }

    public int getSyncBit() {
        return this.syncBit;
    }

    public String getTextDraft() {
        return this.textDraft;
    }

    public String getTextDraftSource() {
        return this.textDraftSource;
    }

    public long getTimer() {
        return this.timer;
    }

    public String getTitleTextDraft() {
        return this.titleTextDraft;
    }

    public ShuoshuoVideoInfo getVideoInfo() {
        return this.videoInfo;
    }

    public LbsDataV2.PoiInfo getmCurrentShootPoiInfo() {
        return this.mCurrentShootPoiInfo;
    }

    public HashMap<String, Boolean> getmMarkHasCheckFacesMap() {
        return this.mMarkHasCheckFacesMap;
    }

    public HashMap<String, Boolean> getmMarkNeedShowFaceIconMap() {
        return this.mMarkNeedShowFaceIconMap;
    }

    public HashMap<String, ArrayList<FaceData>> getmMarksFaceDataMap() {
        return this.mMarksFaceDataMap;
    }

    public HashMap<String, MarkUinInfoBeforeUpload> getmMarksUploadMap() {
        return this.mMarksUploadMap;
    }

    public int getmPriv() {
        return this.mPriv;
    }

    public List<String> getmPrivUinList() {
        return this.mPrivUinList;
    }

    public void setAtFriends(List<Friend> list) {
        this.atFriends = list;
    }

    public void setClientKey(String str) {
        this.clientKey = str;
    }

    public void setCommdityLists(ArrayList arrayList) {
        this.mCommdityLists = arrayList;
    }

    public void setCurrentPoiInfo(LbsDataV2.PoiInfo poiInfo) {
        this.currentPoiInfo = poiInfo;
    }

    public void setEggLayoutSwitch(boolean z16) {
        this.eggLayoutSwitch = z16;
    }

    public void setEggsUrlMap(HashMap<String, PicInfo> hashMap) {
        this.eggsUrlMap = hashMap;
    }

    public void setEventTag(PublishEventTag publishEventTag) {
        this.publishEventTag = publishEventTag;
    }

    public void setFinalPoiInfo(LbsDataV2.PoiInfo poiInfo) {
        this.finalPoiInfo = poiInfo;
    }

    public void setImageShootInfoDateAndWeather(String str) {
        this.imageShootInfoDateAndWeather = str;
    }

    public void setImageShootInfoLbs(String str) {
        this.imageShootInfoLbs = str;
    }

    public void setLongPicModeOpen(Boolean bool) {
        this.longPicModeOpen = bool;
    }

    public void setRecordedVideoInfoMap(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.recordedVideoInfoMap = hashMap;
    }

    public void setSelectedImage(List<String> list) {
        this.selectedImage = list;
    }

    public void setSelectedMeidaInfo(HashMap<String, LocalMediaInfo> hashMap) {
        this.selectedMeidaInfo = hashMap;
    }

    public void setSelectedQzonePhotos(HashMap<String, PicInfo> hashMap) {
        this.selectedQzonePhotos = hashMap;
    }

    public void setSelectedVideoInfoMap(HashMap<String, ShuoshuoVideoInfo> hashMap) {
        this.selectedVideoInfoMap = hashMap;
    }

    public void setShowType(int i3) {
        this.showType = i3;
    }

    public void setState(int i3) {
        this.state = i3;
    }

    public void setTextDraft(String str) {
        this.textDraft = str;
    }

    public void setTextDraftSource(String str) {
        this.textDraftSource = str;
    }

    public void setTimer(long j3) {
        this.timer = j3;
    }

    public void setTitleTextDraft(String str) {
        this.titleTextDraft = str;
    }

    public void setVideoInfo(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        this.videoInfo = shuoshuoVideoInfo;
    }

    public void setmCurrentShootPoiInfo(LbsDataV2.PoiInfo poiInfo) {
        this.mCurrentShootPoiInfo = poiInfo;
    }

    public void setmMarkHasCheckFacesMap(HashMap<String, Boolean> hashMap) {
        this.mMarkHasCheckFacesMap = hashMap;
    }

    public void setmMarkNeedShowFaceIconMap(HashMap<String, Boolean> hashMap) {
        this.mMarkNeedShowFaceIconMap = hashMap;
    }

    public void setmMarksFaceDataMap(HashMap<String, ArrayList<FaceData>> hashMap) {
        this.mMarksFaceDataMap = hashMap;
    }

    public void setmMarksUploadMap(HashMap<String, MarkUinInfoBeforeUpload> hashMap) {
        this.mMarksUploadMap = hashMap;
    }

    public void setmPriv(int i3) {
        this.mPriv = i3;
    }

    public void setmPrivUinList(List<String> list) {
        this.mPrivUinList = list;
    }

    public String toJsonString() {
        try {
            parseBundleToDraftMap();
            return com.tencent.biz.pubaccount.util.d.b().c(this);
        } catch (Exception unused) {
            QLog.d("shuoshuoContent", 4, "to ShuoShuoContent String failed");
            return "";
        }
    }

    private Bundle mapToBundle(HashMap<String, Integer> hashMap) {
        if (hashMap == null || hashMap.size() <= 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        for (String str : hashMap.keySet()) {
            bundle.putInt(str, hashMap.get(str).intValue());
        }
        return bundle;
    }

    public void setSynBitWezone(boolean z16) {
        if (z16) {
            this.syncBit |= 64;
        } else {
            this.syncBit &= -65;
        }
    }

    public void setSyncQQ(boolean z16) {
        if (z16) {
            this.syncBit |= 1;
        } else {
            this.syncBit &= -2;
        }
    }

    public void setSyncRenZhengHao(boolean z16) {
        if (z16) {
            this.syncBit |= 32;
        } else {
            this.syncBit &= -33;
        }
    }

    public void setSyncWechat(boolean z16) {
        if (z16) {
            this.syncBit |= 4;
        } else {
            this.syncBit &= -5;
        }
    }

    public void setSyncWeishi(boolean z16) {
        if (z16) {
            this.syncBit |= 8;
        } else {
            this.syncBit &= -9;
        }
    }

    private HashMap<String, Integer> bundleToMap(ShuoshuoVideoInfo shuoshuoVideoInfo) {
        Bundle bundle;
        if (shuoshuoVideoInfo == null || (bundle = shuoshuoVideoInfo.mExtras) == null) {
            return null;
        }
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj instanceof Integer) {
                hashMap.put(str, (Integer) obj);
            }
        }
        shuoshuoVideoInfo.mExtras = null;
        return hashMap;
    }
}
