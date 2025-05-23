package com.tencent.mobileqq.mini.apkg;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiRightController;
import NS_MINI_INTERFACE.INTERFACE$StApiRightItem;
import NS_MINI_INTERFACE.INTERFACE$StAppBasicInfo;
import NS_MINI_INTERFACE.INTERFACE$StAppFixInfoExt;
import NS_MINI_INTERFACE.INTERFACE$StAppMediaInfo;
import NS_MINI_INTERFACE.INTERFACE$StAppMode;
import NS_MINI_INTERFACE.INTERFACE$StAppPkgInfo;
import NS_MINI_INTERFACE.INTERFACE$StAppPreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE$StAppVideoInfo;
import NS_MINI_INTERFACE.INTERFACE$StDeveloperInfo;
import NS_MINI_INTERFACE.INTERFACE$StDomainConfig;
import NS_MINI_INTERFACE.INTERFACE$StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE$StFirstPage;
import NS_MINI_INTERFACE.INTERFACE$StGamePublicationInfo;
import NS_MINI_INTERFACE.INTERFACE$StIdeConfig;
import NS_MINI_INTERFACE.INTERFACE$StMDebugInfo;
import NS_MINI_INTERFACE.INTERFACE$StMainPageExtInfo;
import NS_MINI_INTERFACE.INTERFACE$StModuleInfo;
import NS_MINI_INTERFACE.INTERFACE$StMotionPicInfo;
import NS_MINI_INTERFACE.INTERFACE$StOperationInfo;
import NS_MINI_INTERFACE.INTERFACE$StRegistrationInfo;
import NS_MINI_INTERFACE.INTERFACE$StResourcePreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE$StStartExtInfo;
import NS_MINI_INTERFACE.INTERFACE$StSubPkgInfo;
import NS_MINI_INTERFACE.INTERFACE$StUserAppInfo;
import NS_MINI_INTERFACE.INTERFACE$TagInfo;
import NS_MINI_INTERFACE.INTERFACE$UseUserInfo;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppEntityManager;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByIdEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoByLinkEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppInfoEntity;
import com.tencent.mobileqq.mini.apkgEntity.MiniAppShowInfoEntity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.model.ResourcePreCacheInfo;
import java.io.Serializable;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppInfo implements Parcelable, Serializable {
    public static final String APP_STORE_MINI_APP_ID = "1108291530";
    public static final Parcelable.Creator<MiniAppInfo> CREATOR = new Parcelable.Creator<MiniAppInfo>() { // from class: com.tencent.mobileqq.mini.apkg.MiniAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniAppInfo createFromParcel(Parcel parcel) {
            MiniAppInfo miniAppInfo = new MiniAppInfo();
            try {
                miniAppInfo.appId = parcel.readString();
                miniAppInfo.name = parcel.readString();
                miniAppInfo.iconUrl = parcel.readString();
                miniAppInfo.downloadUrl = parcel.readString();
                miniAppInfo.topType = parcel.readInt();
                miniAppInfo.version = parcel.readString();
                miniAppInfo.versionId = parcel.readString();
                miniAppInfo.desc = parcel.readString();
                miniAppInfo.verType = parcel.readInt();
                miniAppInfo.timestamp = parcel.readLong();
                miniAppInfo.baselibMiniVersion = parcel.readString();
                miniAppInfo.subpkgs = parcel.createTypedArrayList(SubPkgInfo.CREATOR);
                miniAppInfo.firstPage = (FirstPageInfo) parcel.readParcelable(FirstPageInfo.class.getClassLoader());
                miniAppInfo.engineType = parcel.readInt();
                List<String> arrayList = new ArrayList<>();
                miniAppInfo.whiteList = arrayList;
                parcel.readStringList(arrayList);
                List<String> arrayList2 = new ArrayList<>();
                miniAppInfo.blackList = arrayList2;
                parcel.readStringList(arrayList2);
                miniAppInfo.secondApiRightInfoList = parcel.createTypedArrayList(SecondApiRightInfo.CREATOR);
                miniAppInfo.debugInfo = (DebugInfo) parcel.readParcelable(DebugInfo.class.getClassLoader());
                miniAppInfo.fileSize = parcel.readInt();
                List<String> arrayList3 = new ArrayList<>();
                miniAppInfo.requestDomainList = arrayList3;
                parcel.readStringList(arrayList3);
                List<String> arrayList4 = new ArrayList<>();
                miniAppInfo.socketDomainList = arrayList4;
                parcel.readStringList(arrayList4);
                List<String> arrayList5 = new ArrayList<>();
                miniAppInfo.downloadFileDomainList = arrayList5;
                parcel.readStringList(arrayList5);
                List<String> arrayList6 = new ArrayList<>();
                miniAppInfo.uploadFileDomainList = arrayList6;
                parcel.readStringList(arrayList6);
                List<String> arrayList7 = new ArrayList<>();
                miniAppInfo.businessDomainList = arrayList7;
                parcel.readStringList(arrayList7);
                parcel.readStringList(miniAppInfo.udpIpList);
                miniAppInfo.developerDesc = parcel.readString();
                miniAppInfo.extraData = parcel.readString();
                miniAppInfo.recommend = parcel.readInt();
                miniAppInfo.reportData = parcel.readString();
                miniAppInfo.appMode = (AppMode) parcel.readParcelable(AppMode.class.getClassLoader());
                miniAppInfo.openId = parcel.readString();
                miniAppInfo.tinyId = parcel.readLong();
                miniAppInfo.skipDomainCheck = parcel.readInt();
                miniAppInfo.position = parcel.readInt();
                miniAppInfo.isSupportBlueBar = parcel.readByte() != 0;
                miniAppInfo.isSupportOffline = parcel.readInt() == 1;
                miniAppInfo.recommendAppIconUrl = parcel.readString();
                miniAppInfo.extendData = parcel.readString();
                miniAppInfo.clearAuths = parcel.readInt();
                miniAppInfo.commonExt = parcel.createByteArray();
                miniAppInfo.extConfigInfoList = parcel.createTypedArrayList(ExtConfigInfo.CREATOR);
                miniAppInfo.appStoreAnimPicUrl = parcel.readString();
                ArrayList<String> arrayList8 = new ArrayList<>();
                miniAppInfo.motionPics = arrayList8;
                parcel.readStringList(arrayList8);
                miniAppInfo.usrFileSizeLimit = parcel.readLong();
                miniAppInfo.preCacheList = parcel.createTypedArrayList(PreCacheInfo.CREATOR);
                miniAppInfo.versionUpdateTime = parcel.readInt();
                miniAppInfo.noNeedRealRecommend = parcel.readInt();
                miniAppInfo.miniGamePluginInfo = (MiniGamePluginInfo) parcel.readParcelable(MiniGamePluginInfo.class.getClassLoader());
                miniAppInfo.reportType = parcel.readInt();
                ArrayList<String> arrayList9 = new ArrayList<>();
                miniAppInfo.qualifications = arrayList9;
                parcel.readStringList(arrayList9);
                miniAppInfo.shareId = parcel.readString();
                miniAppInfo.via = parcel.readString();
                miniAppInfo.amsAdInfo = parcel.readString();
                miniAppInfo.apngUrl = parcel.readString();
                miniAppInfo.ide_scene = parcel.readString();
                miniAppInfo.ide_extraAppid = parcel.readString();
                miniAppInfo.ide_extraData = parcel.readString();
                miniAppInfo.tianshuAdId = parcel.readInt();
                miniAppInfo.resourcePreCacheInfo = parcel.createTypedArrayList(ResourcePreCacheInfo.CREATOR);
                miniAppInfo.enableLoadingAd = parcel.readInt() == 1;
                miniAppInfo.deviceOrientation = parcel.readInt();
                miniAppInfo.showStatusBar = parcel.readInt();
                miniAppInfo.prepayId = parcel.readString();
                miniAppInfo.userNum = parcel.readInt();
                miniAppInfo.friendNum = parcel.readInt();
                miniAppInfo.users = parcel.createTypedArrayList(UseUserInfo.CREATOR);
                miniAppInfo.gameCopyrightInfo = parcel.readString();
                miniAppInfo.gamePublicationNumber = parcel.readString();
                miniAppInfo.gamePublicationCompany = parcel.readString();
                miniAppInfo.gameApprovalNumber = parcel.readString();
                miniAppInfo.gameOperatingCompany = parcel.readString();
                miniAppInfo.extInfo = parcel.readString();
                miniAppInfo.miniAppType = parcel.readInt();
                miniAppInfo.tags = parcel.readString();
                miniAppInfo.pkgInfo = (AppPkgInfo) parcel.readParcelable(AppPkgInfo.class.getClassLoader());
                miniAppInfo.videoInfo = parcel.createTypedArrayList(AppVideoInfo.CREATOR);
                miniAppInfo.coverInfo = parcel.createTypedArrayList(AppMediaInfo.CREATOR);
                miniAppInfo.isMultiLogin = parcel.readInt() == 1;
                miniAppInfo.isSupportPay = parcel.readInt() == 1;
                miniAppInfo.isGdtMiniAppAd = parcel.readInt() == 1;
                miniAppInfo.gdtAdInfo = (GdtAd) parcel.readParcelable(GdtAd.class.getClassLoader());
                miniAppInfo.gameRegistrationNumber = parcel.readString();
                miniAppInfo.rightAge = parcel.readInt();
                miniAppInfo.rightAgeNoticeUrl = parcel.readString();
                miniAppInfo.bindingAppId = parcel.readString();
            } catch (Throwable th5) {
                QLog.e(MiniAppInfo.TAG, 1, "createFromParcel exception!", th5);
            }
            return miniAppInfo;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniAppInfo[] newArray(int i3) {
            return new MiniAppInfo[i3];
        }
    };
    public static final String ENV_VERSION_DEVELOP = "develop";
    public static final String ENV_VERSION_RELEASE = "release";
    public static final String ENV_VERSION_TRIAL = "trial";
    public static final String NATIVE_MINI_APP_ID_CHECKIN = "1108164955";
    public static final String TAG = "[mini] MiniAppInfo";
    public static final String TAG_DB = "miniapp-db";
    public String amsAdInfo;
    public String apngUrl;
    public String appId;
    public AppMode appMode;
    public String appStoreAnimPicUrl;
    public String baselibMiniVersion;
    public String bindingAppId;
    public List<String> blackList;
    public int bubbleClickCount;
    public String bubbleText;
    public List<String> businessDomainList;
    public int clearAuths;
    public byte[] commonExt;
    public List<AppMediaInfo> coverInfo;
    public DebugInfo debugInfo;
    public String desc;
    public String developerDesc;
    public int deviceOrientation;
    public List<String> downloadFileDomainList;
    public String downloadUrl;
    public boolean enableLoadingAd;
    public int engineType;
    public ArrayList<ExtConfigInfo> extConfigInfoList;
    public String extInfo;
    public String extendData;
    public String extraData;
    public int fileSize;
    public FirstPageInfo firstPage;
    public String friendMessageQuery;
    public int friendNum;
    public String gameApprovalNumber;
    public String gameCopyrightInfo;
    public String gameOperatingCompany;
    public String gamePublicationCompany;
    public String gamePublicationNumber;
    public String gameRegistrationNumber;
    public transient GdtAd gdtAdInfo;
    public String hostScene;
    public String iconUrl;
    public String ide_extraAppid;
    public String ide_extraData;
    public String ide_scene;
    public boolean isGdtMiniAppAd;
    public boolean isMultiLogin;
    public boolean isSupportBlueBar;
    public boolean isSupportOffline;
    public boolean isSupportPay;
    public List<String> loopIcos;
    public int miniAppType;
    public MiniGamePluginInfo miniGamePluginInfo;
    public HashMap<Integer, String> moduleReportDataMap;
    public HashMap<Integer, TagInfo> moduleTagMap;
    public HashMap<Integer, Integer> moduleTianShuAdIdMap;
    public HashMap<Integer, String> moduleViaMap;
    public ArrayList<String> motionPics;
    public String name;
    public int noNeedRealRecommend;
    public String openId;
    public AppPkgInfo pkgInfo;
    public int position;
    public ArrayList<PreCacheInfo> preCacheList;
    public String prepayId;
    public ArrayList<String> qualifications;
    public int recommend;
    public String recommendAppIconUrl;
    public RenderInfo renderInfo;
    public String reportData;
    private int reportType;
    public List<String> requestDomainList;
    public ArrayList<ResourcePreCacheInfo> resourcePreCacheInfo;
    public int rightAge;
    public String rightAgeNoticeUrl;
    public String schema;
    public List<SecondApiRightInfo> secondApiRightInfoList;
    public String shareId;
    public int showStatusBar;
    public int skipDomainCheck;
    public List<String> socketDomainList;
    public List<SubPkgInfo> subpkgs;
    public TagInfo tagInfo;
    public ArrayList<TagInfo> tagList;
    public String tags;
    public int tianshuAdId;
    public long timestamp;
    public long tinyId;
    public int topType;
    public final List<String> udpIpList;
    public List<String> uploadFileDomainList;
    public int userNum;
    public List<UseUserInfo> users;
    public long usrFileSizeLimit;
    public int verType;
    public String version;
    public String versionId;
    public int versionUpdateTime;
    public String via;
    public List<AppVideoInfo> videoInfo;
    public List<String> whiteList;

    public MiniAppInfo() {
        this.udpIpList = new ArrayList();
        this.moduleReportDataMap = new HashMap<>();
        this.tagInfo = new TagInfo();
        this.tagList = new ArrayList<>();
        this.moduleTagMap = new HashMap<>();
        this.appMode = new AppMode();
        this.moduleViaMap = new HashMap<>();
        this.friendMessageQuery = "";
        this.moduleTianShuAdIdMap = new HashMap<>();
    }

    public static MiniAppInfo copy(MiniAppInfo miniAppInfo) {
        MiniAppInfo miniAppInfo2 = new MiniAppInfo();
        miniAppInfo2.appId = miniAppInfo.appId;
        miniAppInfo2.name = miniAppInfo.name;
        miniAppInfo2.iconUrl = miniAppInfo.iconUrl;
        miniAppInfo2.downloadUrl = miniAppInfo.downloadUrl;
        miniAppInfo2.topType = miniAppInfo.topType;
        miniAppInfo2.version = miniAppInfo.version;
        miniAppInfo2.versionId = miniAppInfo.versionId;
        miniAppInfo2.desc = miniAppInfo.desc;
        miniAppInfo2.verType = miniAppInfo.verType;
        miniAppInfo2.timestamp = miniAppInfo.timestamp;
        miniAppInfo2.baselibMiniVersion = miniAppInfo.baselibMiniVersion;
        miniAppInfo2.subpkgs = miniAppInfo.subpkgs;
        FirstPageInfo firstPageInfo = new FirstPageInfo();
        firstPageInfo.setPagePath("");
        firstPageInfo.setSubPkgName("");
        miniAppInfo2.firstPage = firstPageInfo;
        miniAppInfo2.reportType = miniAppInfo.reportType;
        miniAppInfo2.engineType = miniAppInfo.engineType;
        miniAppInfo2.whiteList = miniAppInfo.whiteList;
        miniAppInfo2.blackList = miniAppInfo.blackList;
        miniAppInfo2.secondApiRightInfoList = miniAppInfo.secondApiRightInfoList;
        miniAppInfo2.debugInfo = miniAppInfo.debugInfo;
        miniAppInfo2.requestDomainList = miniAppInfo.requestDomainList;
        miniAppInfo2.socketDomainList = miniAppInfo.socketDomainList;
        miniAppInfo2.uploadFileDomainList = miniAppInfo.uploadFileDomainList;
        miniAppInfo2.downloadFileDomainList = miniAppInfo.downloadFileDomainList;
        miniAppInfo2.businessDomainList = miniAppInfo.businessDomainList;
        miniAppInfo2.udpIpList.clear();
        miniAppInfo2.udpIpList.addAll(miniAppInfo.udpIpList);
        miniAppInfo2.fileSize = miniAppInfo.fileSize;
        miniAppInfo2.developerDesc = miniAppInfo.developerDesc;
        miniAppInfo2.extraData = miniAppInfo.extraData;
        miniAppInfo2.recommend = miniAppInfo.recommend;
        miniAppInfo2.isSupportOffline = miniAppInfo.isSupportOffline;
        miniAppInfo2.reportData = miniAppInfo.reportData;
        miniAppInfo2.appMode = miniAppInfo.appMode;
        miniAppInfo2.skipDomainCheck = miniAppInfo.skipDomainCheck;
        miniAppInfo2.position = miniAppInfo.position;
        miniAppInfo2.isSupportBlueBar = miniAppInfo.isSupportBlueBar;
        miniAppInfo2.recommendAppIconUrl = miniAppInfo.recommendAppIconUrl;
        miniAppInfo2.bubbleText = miniAppInfo.bubbleText;
        miniAppInfo2.bubbleClickCount = miniAppInfo.bubbleClickCount;
        miniAppInfo2.extendData = null;
        miniAppInfo2.commonExt = miniAppInfo.commonExt;
        miniAppInfo2.extConfigInfoList = miniAppInfo.extConfigInfoList;
        miniAppInfo2.appStoreAnimPicUrl = miniAppInfo.appStoreAnimPicUrl;
        miniAppInfo2.motionPics = miniAppInfo.motionPics;
        miniAppInfo2.usrFileSizeLimit = miniAppInfo.usrFileSizeLimit;
        if (miniAppInfo.preCacheList != null) {
            miniAppInfo2.preCacheList = new ArrayList<>();
            Iterator<PreCacheInfo> it = miniAppInfo.preCacheList.iterator();
            while (it.hasNext()) {
                PreCacheInfo next = it.next();
                miniAppInfo2.preCacheList.add(new PreCacheInfo(next.getDataUrl, next.preCacheKey, next.expireTime, next.cacheType, next.useProxy));
            }
        }
        if (miniAppInfo.resourcePreCacheInfo != null) {
            miniAppInfo2.resourcePreCacheInfo = new ArrayList<>();
            Iterator<ResourcePreCacheInfo> it5 = miniAppInfo.resourcePreCacheInfo.iterator();
            while (it5.hasNext()) {
                miniAppInfo2.resourcePreCacheInfo.add(new ResourcePreCacheInfo(it5.next().getDataUrl));
            }
        }
        miniAppInfo2.versionUpdateTime = miniAppInfo.versionUpdateTime;
        miniAppInfo2.noNeedRealRecommend = miniAppInfo.noNeedRealRecommend;
        miniAppInfo2.miniGamePluginInfo = miniAppInfo.miniGamePluginInfo;
        miniAppInfo2.qualifications = miniAppInfo.qualifications;
        miniAppInfo2.gameCopyrightInfo = miniAppInfo.gameCopyrightInfo;
        miniAppInfo2.gamePublicationNumber = miniAppInfo.gamePublicationNumber;
        miniAppInfo2.gamePublicationCompany = miniAppInfo.gamePublicationCompany;
        miniAppInfo2.gameApprovalNumber = miniAppInfo.gameApprovalNumber;
        miniAppInfo2.gameOperatingCompany = miniAppInfo.gameOperatingCompany;
        miniAppInfo2.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        miniAppInfo2.extInfo = miniAppInfo.extInfo;
        miniAppInfo2.shareId = miniAppInfo.shareId;
        miniAppInfo2.via = miniAppInfo.via;
        miniAppInfo2.amsAdInfo = miniAppInfo.amsAdInfo;
        miniAppInfo2.apngUrl = miniAppInfo.apngUrl;
        miniAppInfo2.ide_scene = miniAppInfo.ide_scene;
        miniAppInfo2.ide_extraAppid = miniAppInfo.ide_extraAppid;
        miniAppInfo2.ide_extraData = miniAppInfo.ide_extraData;
        miniAppInfo2.tianshuAdId = miniAppInfo.tianshuAdId;
        miniAppInfo2.enableLoadingAd = miniAppInfo.enableLoadingAd;
        miniAppInfo2.userNum = miniAppInfo.userNum;
        miniAppInfo2.friendNum = miniAppInfo.friendNum;
        miniAppInfo2.users = miniAppInfo.users;
        miniAppInfo2.miniAppType = miniAppInfo.miniAppType;
        miniAppInfo2.tags = miniAppInfo.tags;
        miniAppInfo2.pkgInfo = miniAppInfo.pkgInfo;
        miniAppInfo2.videoInfo = miniAppInfo.videoInfo;
        miniAppInfo2.coverInfo = miniAppInfo.coverInfo;
        miniAppInfo2.isGdtMiniAppAd = miniAppInfo.isGdtMiniAppAd;
        ArrayList<TagInfo> arrayList = miniAppInfo2.tagList;
        if (arrayList != null && miniAppInfo.tagList != null) {
            arrayList.clear();
            miniAppInfo2.tagList.addAll(miniAppInfo.tagList);
        }
        HashMap<Integer, Integer> hashMap = miniAppInfo2.moduleTianShuAdIdMap;
        if (hashMap != null && miniAppInfo.moduleTianShuAdIdMap != null) {
            hashMap.clear();
            miniAppInfo2.moduleTianShuAdIdMap.putAll(miniAppInfo.moduleTianShuAdIdMap);
        }
        HashMap<Integer, TagInfo> hashMap2 = miniAppInfo2.moduleTagMap;
        if (hashMap2 != null && miniAppInfo.moduleTagMap != null) {
            hashMap2.clear();
            miniAppInfo2.moduleTagMap.putAll(miniAppInfo.moduleTagMap);
        }
        HashMap<Integer, String> hashMap3 = miniAppInfo2.moduleViaMap;
        if (hashMap3 != null && miniAppInfo.moduleViaMap != null) {
            hashMap3.clear();
            miniAppInfo2.moduleViaMap.putAll(miniAppInfo.moduleViaMap);
        }
        HashMap<Integer, String> hashMap4 = miniAppInfo2.moduleReportDataMap;
        if (hashMap4 != null && miniAppInfo.moduleReportDataMap != null) {
            hashMap4.clear();
            miniAppInfo2.moduleReportDataMap.putAll(miniAppInfo.moduleReportDataMap);
        }
        miniAppInfo2.rightAge = miniAppInfo.rightAge;
        miniAppInfo2.rightAgeNoticeUrl = miniAppInfo.rightAgeNoticeUrl;
        miniAppInfo2.bindingAppId = miniAppInfo.bindingAppId;
        return miniAppInfo2;
    }

    public static MiniAppInfo createMiniAppInfo(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("appInfo");
        if (optJSONObject == null) {
            QLog.e(TAG, 1, "createMiniAppInfo, appInfo is null");
            return null;
        }
        try {
            return from((INTERFACE$StApiAppInfo) GdtJsonPbUtil.pbFromJson(new INTERFACE$StApiAppInfo(), optJSONObject));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "createMiniAppInfo, appInfo exception:", e16);
            return null;
        }
    }

    public static MiniAppInfo from(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo == null) {
            return new MiniAppInfo();
        }
        return new MiniAppInfo(iNTERFACE$StApiAppInfo.appId.get(), iNTERFACE$StApiAppInfo.appName.get(), iNTERFACE$StApiAppInfo.icon.get(), iNTERFACE$StApiAppInfo.donwLoadUrl.get(), iNTERFACE$StApiAppInfo.appType.get(), 0, iNTERFACE$StApiAppInfo.type.get(), iNTERFACE$StApiAppInfo.version.get(), iNTERFACE$StApiAppInfo.versionId.get(), iNTERFACE$StApiAppInfo.baselibMiniVersion.get(), 0L, iNTERFACE$StApiAppInfo.subPkgs.get(), iNTERFACE$StApiAppInfo.desc.get(), iNTERFACE$StApiAppInfo.first.get(), iNTERFACE$StApiAppInfo.apiRight.get(), iNTERFACE$StApiAppInfo.mDebug, iNTERFACE$StApiAppInfo.domain.get(), iNTERFACE$StApiAppInfo.mainExt, iNTERFACE$StApiAppInfo.devInfo, null, iNTERFACE$StApiAppInfo.isRecommend.get(), iNTERFACE$StApiAppInfo.appMode.get(), iNTERFACE$StApiAppInfo.skipDomainCheck.get(), getSupportBlueBar(iNTERFACE$StApiAppInfo), iNTERFACE$StApiAppInfo.supportOffline.get() == 1, getRecommendIconUrl(iNTERFACE$StApiAppInfo), getBubbleText(iNTERFACE$StApiAppInfo), getBubbleClickCount(iNTERFACE$StApiAppInfo), iNTERFACE$StApiAppInfo.extendData.get(), iNTERFACE$StApiAppInfo.appNoCacheExt.clearAuths.get(), iNTERFACE$StApiAppInfo.extInfo, iNTERFACE$StApiAppInfo.extConfig.get(), iNTERFACE$StApiAppInfo.basicInfo.get(), iNTERFACE$StApiAppInfo.operInfo.get(), iNTERFACE$StApiAppInfo.basicInfo.ideConfig.get(), iNTERFACE$StApiAppInfo.appNoCacheExt.prepayId.get(), iNTERFACE$StApiAppInfo.miniAppType.get(), iNTERFACE$StApiAppInfo.extInfo.get(), iNTERFACE$StApiAppInfo.tags.get(), iNTERFACE$StApiAppInfo.pkgInfo.get(), iNTERFACE$StApiAppInfo.videoInfo.get(), iNTERFACE$StApiAppInfo.coverInfo.get(), iNTERFACE$StApiAppInfo.schema.get(), iNTERFACE$StApiAppInfo.loopIcons.get(), false, null, iNTERFACE$StApiAppInfo.registrationInfo.get(), iNTERFACE$StApiAppInfo.right_age.get(), iNTERFACE$StApiAppInfo.right_age_notice_url.get(), iNTERFACE$StApiAppInfo.binding_appid.get());
    }

    private static int getBubbleClickCount(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.extInfo == null) {
            return 1;
        }
        int i3 = 1;
        for (int i16 = 0; i16 < iNTERFACE$StApiAppInfo.extInfo.mapInfo.size(); i16++) {
            COMM.Entry entry = iNTERFACE$StApiAppInfo.extInfo.mapInfo.get(i16);
            if ("bubbleClickCount".equals(entry.key.get())) {
                try {
                    i3 = Math.max(1, Integer.parseInt(entry.value.get()));
                } catch (NumberFormatException e16) {
                    QLog.e(TAG, 1, "getBubbleClickCount failed, value=" + entry.value.get(), e16);
                }
            }
        }
        return i3;
    }

    private static String getBubbleText(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.extInfo == null) {
            return "";
        }
        for (int i3 = 0; i3 < iNTERFACE$StApiAppInfo.extInfo.mapInfo.size(); i3++) {
            COMM.Entry entry = iNTERFACE$StApiAppInfo.extInfo.mapInfo.get(i3);
            if ("bubbleText".equals(entry.key.get())) {
                return entry.value.get();
            }
        }
        return "";
    }

    public static MiniAppInfo getMiniAppInfoByIdFromDB(MiniAppByIdEntity miniAppByIdEntity, MiniAppInfoEntity miniAppInfoEntity) {
        try {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            iNTERFACE$StApiAppInfo.mergeFrom(miniAppInfoEntity.appInfo);
            iNTERFACE$StApiAppInfo.first.mergeFrom(miniAppByIdEntity.first);
            iNTERFACE$StApiAppInfo.mDebug.mergeFrom(miniAppByIdEntity.mDebug);
            iNTERFACE$StApiAppInfo.extData.set(miniAppByIdEntity.extData);
            iNTERFACE$StApiAppInfo.operInfo.mergeFrom(miniAppByIdEntity.operInfo);
            iNTERFACE$StApiAppInfo.extInfo.mergeFrom(miniAppByIdEntity.extInfo);
            iNTERFACE$StApiAppInfo.extendData.set(miniAppByIdEntity.extendData);
            iNTERFACE$StApiAppInfo.appNoCacheExt.mergeFrom(new INTERFACE$StAppFixInfoExt().toByteArray());
            return from(iNTERFACE$StApiAppInfo);
        } catch (Throwable th5) {
            QLog.e("miniapp-db", 1, "getMiniAppInfoByIdFromDB error,", th5);
            return null;
        }
    }

    @Deprecated
    public static MiniAppInfo getMiniAppInfoByLinkFromDB(MiniAppByLinkEntity miniAppByLinkEntity, MiniAppInfoEntity miniAppInfoEntity) {
        try {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            iNTERFACE$StApiAppInfo.mergeFrom(miniAppInfoEntity.appInfo);
            iNTERFACE$StApiAppInfo.first.mergeFrom(miniAppByLinkEntity.first);
            iNTERFACE$StApiAppInfo.mDebug.mergeFrom(miniAppByLinkEntity.mDebug);
            iNTERFACE$StApiAppInfo.extData.set(miniAppByLinkEntity.extData);
            iNTERFACE$StApiAppInfo.operInfo.mergeFrom(miniAppByLinkEntity.operInfo);
            iNTERFACE$StApiAppInfo.extInfo.mergeFrom(miniAppByLinkEntity.extInfo);
            iNTERFACE$StApiAppInfo.extendData.set(miniAppByLinkEntity.extendData);
            INTERFACE$StAppFixInfoExt iNTERFACE$StAppFixInfoExt = new INTERFACE$StAppFixInfoExt();
            iNTERFACE$StAppFixInfoExt.prepayId.set(miniAppByLinkEntity.prepayId);
            iNTERFACE$StApiAppInfo.appNoCacheExt.mergeFrom(iNTERFACE$StAppFixInfoExt.toByteArray());
            return from(iNTERFACE$StApiAppInfo);
        } catch (Throwable th5) {
            QLog.e("miniapp-db", 1, "getMiniAppInfoByLinkFromDB error,", th5);
            return null;
        }
    }

    private static ArrayList<String> getMotionPics(List<INTERFACE$StMotionPicInfo> list) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (list != null && list.size() > 0) {
            for (INTERFACE$StMotionPicInfo iNTERFACE$StMotionPicInfo : list) {
                if (iNTERFACE$StMotionPicInfo != null && iNTERFACE$StMotionPicInfo.get() != null) {
                    arrayList.add(iNTERFACE$StMotionPicInfo.pic.get());
                }
            }
        }
        return arrayList;
    }

    private static String getRecommendIconUrl(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.extInfo == null) {
            return "";
        }
        for (int i3 = 0; i3 < iNTERFACE$StApiAppInfo.extInfo.mapInfo.size(); i3++) {
            COMM.Entry entry = iNTERFACE$StApiAppInfo.extInfo.mapInfo.get(i3);
            if ("recommIcon".equals(entry.key.get())) {
                return entry.value.get();
            }
        }
        return "";
    }

    private static Map<String, String> getReportDataFromAppInfo(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        INTERFACE$StOperationInfo iNTERFACE$StOperationInfo = iNTERFACE$StApiAppInfo.operInfo;
        HashMap hashMap = null;
        if (iNTERFACE$StOperationInfo != null) {
            String str = iNTERFACE$StOperationInfo.reportData.get();
            if (!TextUtils.isEmpty(str)) {
                try {
                    for (String str2 : str.split(ContainerUtils.FIELD_DELIMITER)) {
                        int indexOf = str2.indexOf(ContainerUtils.KEY_VALUE_DELIMITER);
                        if (indexOf > 0 && indexOf < str2.length() - 1) {
                            String decode = URLDecoder.decode(str2.substring(0, indexOf), "UTF-8");
                            String decode2 = URLDecoder.decode(str2.substring(indexOf + 1), "UTF-8");
                            if (hashMap == null) {
                                hashMap = new HashMap();
                            }
                            hashMap.put(decode, decode2);
                        }
                    }
                } catch (Exception e16) {
                    QLog.e(TAG, 1, " parse reportData error.", e16);
                }
            }
        }
        return hashMap;
    }

    public static String getReportDataString(Map<String, String> map) {
        String str = "";
        if (map != null && map.size() > 0) {
            try {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    if (TextUtils.isEmpty(str)) {
                        str = str + URLEncoder.encode(entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(entry.getValue(), "UTF-8");
                    } else {
                        str = str + ContainerUtils.FIELD_DELIMITER + URLEncoder.encode(entry.getKey()) + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(entry.getValue(), "UTF-8");
                    }
                }
            } catch (Exception e16) {
                QLog.e(TAG, 1, " getReportDataString error.", e16);
            }
        }
        return str;
    }

    private static boolean getSupportBlueBar(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.extInfo == null) {
            return false;
        }
        for (int i3 = 0; i3 < iNTERFACE$StApiAppInfo.extInfo.mapInfo.size(); i3++) {
            COMM.Entry entry = iNTERFACE$StApiAppInfo.extInfo.mapInfo.get(i3);
            if ("support_blue_bar".equals(entry.key.get())) {
                return "1".equals(entry.value.get());
            }
        }
        return false;
    }

    public static int getVerType(String str) {
        if ("develop".equalsIgnoreCase(str)) {
            return 0;
        }
        return "trial".equalsIgnoreCase(str) ? 1 : 3;
    }

    private static String list2String(List<ExtConfigInfo> list) {
        try {
            StringBuilder sb5 = new StringBuilder();
            if (list == null) {
                return "";
            }
            Iterator<ExtConfigInfo> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append(",");
            }
            return sb5.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "list2String error.", th5);
            return "";
        }
    }

    public static String list2string(List<String> list) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            if (list == null) {
                return "";
            }
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                stringBuffer.append(it.next().toString() + ",");
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String list2stringO(List<SubPkgInfo> list) {
        try {
            StringBuilder sb5 = new StringBuilder();
            if (list == null) {
                return "";
            }
            Iterator<SubPkgInfo> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append(",");
            }
            return sb5.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String list2stringSecond(List<SecondApiRightInfo> list) {
        try {
            StringBuilder sb5 = new StringBuilder();
            if (list == null) {
                return "";
            }
            Iterator<SecondApiRightInfo> it = list.iterator();
            while (it.hasNext()) {
                sb5.append(it.next().toString());
                sb5.append(",");
            }
            return sb5.toString();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "list2stringSecond str error.", th5);
            return "";
        }
    }

    private static ArrayList<String> parseArrayList(JSONObject jSONObject, String str) {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            ArrayList<String> arrayList = new ArrayList<>(length);
            for (int i3 = 0; i3 < length; i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        }
        return new ArrayList<>();
    }

    public static void saveMiniAppByAppInfoLinkEntity(String str, int i3, String str2, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.appType.get() == 5) {
            return;
        }
        MiniAppInfoByLinkEntity miniAppInfoByLinkEntity = new MiniAppInfoByLinkEntity();
        miniAppInfoByLinkEntity.link = str;
        miniAppInfoByLinkEntity.linkType = i3;
        miniAppInfoByLinkEntity.shareTicket = str2;
        miniAppInfoByLinkEntity.appInfo = iNTERFACE$StApiAppInfo.get().toByteArray();
        miniAppInfoByLinkEntity.timeStamp = System.currentTimeMillis();
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity(miniAppInfoByLinkEntity);
            QLog.d("miniapp-db", 1, "saveMiniAppByAppInfoLinkEntity ok." + miniAppInfoByLinkEntity.link + " linkType:" + i3);
        }
    }

    public static void saveMiniAppByIdEntity(String str, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.appType.get() == 5) {
            return;
        }
        if (str == null) {
            str = "";
        }
        MiniAppByIdEntity miniAppByIdEntity = new MiniAppByIdEntity();
        miniAppByIdEntity.appId = iNTERFACE$StApiAppInfo.appId.get();
        miniAppByIdEntity.entryPath = str;
        miniAppByIdEntity.shareTicket = null;
        miniAppByIdEntity.first = iNTERFACE$StApiAppInfo.first.get().toByteArray();
        miniAppByIdEntity.mDebug = iNTERFACE$StApiAppInfo.mDebug.get().toByteArray();
        miniAppByIdEntity.extData = iNTERFACE$StApiAppInfo.extData.get();
        miniAppByIdEntity.operInfo = iNTERFACE$StApiAppInfo.operInfo.get().toByteArray();
        miniAppByIdEntity.extInfo = iNTERFACE$StApiAppInfo.extInfo.get().toByteArray();
        miniAppByIdEntity.extendData = iNTERFACE$StApiAppInfo.extendData.get();
        miniAppByIdEntity.timeStamp = System.currentTimeMillis();
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity(miniAppByIdEntity);
            QLog.d("miniapp-db", 1, "saveMiniAppByIdEntity ok." + miniAppByIdEntity.appId);
        }
    }

    public static void saveMiniAppByLinkEntity(String str, int i3, String str2, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.appType.get() == 5) {
            return;
        }
        MiniAppByLinkEntity miniAppByLinkEntity = new MiniAppByLinkEntity();
        miniAppByLinkEntity.appId = iNTERFACE$StApiAppInfo.appId.get();
        miniAppByLinkEntity.link = str;
        miniAppByLinkEntity.linkType = i3;
        miniAppByLinkEntity.shareTicket = str2;
        miniAppByLinkEntity.first = iNTERFACE$StApiAppInfo.first.get().toByteArray();
        miniAppByLinkEntity.mDebug = iNTERFACE$StApiAppInfo.mDebug.get().toByteArray();
        miniAppByLinkEntity.extData = iNTERFACE$StApiAppInfo.extData.get();
        miniAppByLinkEntity.operInfo = iNTERFACE$StApiAppInfo.operInfo.get().toByteArray();
        miniAppByLinkEntity.extInfo = iNTERFACE$StApiAppInfo.extInfo.get().toByteArray();
        miniAppByLinkEntity.extendData = iNTERFACE$StApiAppInfo.extendData.get();
        miniAppByLinkEntity.timeStamp = System.currentTimeMillis();
        miniAppByLinkEntity.prepayId = iNTERFACE$StApiAppInfo.appNoCacheExt.prepayId.get();
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity(miniAppByLinkEntity);
            QLog.d("miniapp-db", 1, "saveMiniAppByLinkEntity ok." + miniAppByLinkEntity.appId);
        }
    }

    public static void saveMiniAppInfoByIdEntity(String str, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.appType.get() == 5) {
            return;
        }
        if (str == null) {
            str = "";
        }
        MiniAppInfoByIdEntity miniAppInfoByIdEntity = new MiniAppInfoByIdEntity();
        miniAppInfoByIdEntity.appId = iNTERFACE$StApiAppInfo.appId.get();
        miniAppInfoByIdEntity.entryPath = str;
        miniAppInfoByIdEntity.appInfo = iNTERFACE$StApiAppInfo.get().toByteArray();
        miniAppInfoByIdEntity.timeStamp = System.currentTimeMillis();
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity(miniAppInfoByIdEntity);
            QLog.d("miniapp-db", 1, "saveMiniAppInfoByIdEntity ok." + miniAppInfoByIdEntity.appId + " entryPath:" + str);
        }
    }

    public static void saveMiniAppInfoEntity(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo.appType.get() == 5) {
            return;
        }
        MiniAppInfoEntity miniAppInfoEntity = new MiniAppInfoEntity();
        miniAppInfoEntity.appId = iNTERFACE$StApiAppInfo.appId.get();
        miniAppInfoEntity.appInfo = iNTERFACE$StApiAppInfo.get().toByteArray();
        miniAppInfoEntity.timeStamp = System.currentTimeMillis();
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity(miniAppInfoEntity);
            QLog.d("miniapp-db", 1, "saveMiniAppInfoEntity ok." + miniAppInfoEntity.appId);
        }
    }

    public static void saveMiniAppShowInfoEntity(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        INTERFACE$StGamePublicationInfo iNTERFACE$StGamePublicationInfo;
        INTERFACE$StAppMode iNTERFACE$StAppMode;
        if ((iNTERFACE$StApiAppInfo != null && (iNTERFACE$StAppMode = iNTERFACE$StApiAppInfo.appMode) != null && (iNTERFACE$StAppMode.isAppStore.get() || iNTERFACE$StApiAppInfo.appMode.interMode.get())) || iNTERFACE$StApiAppInfo == null || iNTERFACE$StApiAppInfo.appType.get() == 5) {
            return;
        }
        MiniAppShowInfoEntity miniAppShowInfoEntity = new MiniAppShowInfoEntity();
        miniAppShowInfoEntity.appId = iNTERFACE$StApiAppInfo.appId.get();
        miniAppShowInfoEntity.appName = iNTERFACE$StApiAppInfo.appName.get();
        miniAppShowInfoEntity.icon = iNTERFACE$StApiAppInfo.icon.get();
        miniAppShowInfoEntity.desc = iNTERFACE$StApiAppInfo.desc.get();
        INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo = iNTERFACE$StApiAppInfo.basicInfo;
        if (iNTERFACE$StAppBasicInfo != null) {
            miniAppShowInfoEntity.gameCopyrightInfo = iNTERFACE$StAppBasicInfo.gameCopyrightInfo.get();
        }
        INTERFACE$StRegistrationInfo iNTERFACE$StRegistrationInfo = iNTERFACE$StApiAppInfo.registrationInfo;
        if (iNTERFACE$StRegistrationInfo != null) {
            miniAppShowInfoEntity.gameRegistrationNumber = iNTERFACE$StRegistrationInfo.registrationNumber.get();
        }
        INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo2 = iNTERFACE$StApiAppInfo.basicInfo;
        if (iNTERFACE$StAppBasicInfo2 != null && (iNTERFACE$StGamePublicationInfo = iNTERFACE$StAppBasicInfo2.gamePublicationInfo) != null) {
            miniAppShowInfoEntity.gamePublicationNumber = iNTERFACE$StGamePublicationInfo.gamePublicationNumber.get();
            miniAppShowInfoEntity.gamePublicationCompany = iNTERFACE$StApiAppInfo.basicInfo.gamePublicationInfo.gamePublicationCommpany.get();
            miniAppShowInfoEntity.gameApprovalNumber = iNTERFACE$StApiAppInfo.basicInfo.gamePublicationInfo.gameApprovalNumber.get();
            miniAppShowInfoEntity.gameOperatingCompany = iNTERFACE$StApiAppInfo.basicInfo.gamePublicationInfo.gameOperatingCompany.get();
        }
        miniAppShowInfoEntity.reportType = iNTERFACE$StApiAppInfo.appType.get();
        if (iNTERFACE$StApiAppInfo.basicInfo.pkgType.has()) {
            if (iNTERFACE$StApiAppInfo.basicInfo.pkgType.get() == 1) {
                miniAppShowInfoEntity.engineType = 1;
            } else if (iNTERFACE$StApiAppInfo.basicInfo.pkgType.get() == 2) {
                miniAppShowInfoEntity.engineType = 0;
            } else {
                miniAppShowInfoEntity.engineType = iNTERFACE$StApiAppInfo.basicInfo.pkgType.get();
            }
        } else {
            miniAppShowInfoEntity.engineType = miniAppShowInfoEntity.reportType;
        }
        INTERFACE$StAppMode iNTERFACE$StAppMode2 = iNTERFACE$StApiAppInfo.appMode;
        if (iNTERFACE$StAppMode2 != null) {
            miniAppShowInfoEntity.interMode = iNTERFACE$StAppMode2.interMode.get();
        }
        miniAppShowInfoEntity.timeStamp = System.currentTimeMillis();
        miniAppShowInfoEntity.miniAppType = iNTERFACE$StApiAppInfo.miniAppType.get();
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity(miniAppShowInfoEntity);
            QLog.d("miniapp-db", 1, "saveMiniAppShowInfoEntity ok." + miniAppShowInfoEntity.appId);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getEngineType() {
        return this.engineType;
    }

    public int getReportType() {
        return this.reportType;
    }

    public String getVerTypeStr() {
        int i3 = this.verType;
        if (i3 == 0 || i3 == 4) {
            return "develop";
        }
        if (i3 == 1) {
            return "trial";
        }
        return "release";
    }

    public boolean isAppStoreMiniApp() {
        AppMode appMode = this.appMode;
        if (appMode == null) {
            return false;
        }
        return appMode.isAppStore;
    }

    public boolean isAppTypeEnterUri() {
        int i3 = this.reportType;
        return i3 == 7 || i3 == 8;
    }

    public boolean isAppTypeVirtualApp() {
        return this.reportType == 5;
    }

    public boolean isAppTypeYungGameApp() {
        return this.reportType == 6;
    }

    public boolean isEngineTypeMiniApp() {
        return this.engineType == 0;
    }

    public boolean isEngineTypeMiniGame() {
        return this.engineType == 1;
    }

    public boolean isInternalApp() {
        AppMode appMode = this.appMode;
        return appMode != null && appMode.interMode;
    }

    public boolean isLandScape() {
        int i3 = this.deviceOrientation;
        return i3 == 2 || i3 == 3 || i3 == 4;
    }

    public boolean isLimitedAccessApp() {
        AppMode appMode = this.appMode;
        return appMode != null && appMode.isLimitedAccess;
    }

    public boolean isQQMiniApp() {
        return this.miniAppType == 0;
    }

    public boolean isReportTypeMiniApp() {
        return this.reportType == 0;
    }

    public boolean isReportTypeMiniGame() {
        return this.reportType == 1;
    }

    public boolean isShowStatusBar() {
        return this.showStatusBar == 1;
    }

    public boolean isSpecialMiniApp() {
        return isAppStoreMiniApp();
    }

    public boolean isWxMiniApp() {
        return this.miniAppType == 1;
    }

    public MiniAppInfo mergeData(MiniAppInfo miniAppInfo) {
        MiniGamePluginInfo miniGamePluginInfo;
        this.topType = miniAppInfo.topType;
        this.timestamp = miniAppInfo.timestamp;
        this.openId = miniAppInfo.openId;
        this.tinyId = miniAppInfo.tinyId;
        this.firstPage = miniAppInfo.firstPage;
        this.appStoreAnimPicUrl = miniAppInfo.appStoreAnimPicUrl;
        this.motionPics = miniAppInfo.motionPics;
        this.apngUrl = miniAppInfo.apngUrl;
        this.gameCopyrightInfo = miniAppInfo.gameCopyrightInfo;
        this.gamePublicationNumber = miniAppInfo.gamePublicationNumber;
        this.gamePublicationCompany = miniAppInfo.gamePublicationCompany;
        this.gameApprovalNumber = miniAppInfo.gameApprovalNumber;
        this.gameOperatingCompany = miniAppInfo.gameOperatingCompany;
        this.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        this.extInfo = miniAppInfo.extInfo;
        if (this.miniGamePluginInfo == null && (miniGamePluginInfo = miniAppInfo.miniGamePluginInfo) != null) {
            this.miniGamePluginInfo = miniGamePluginInfo;
        }
        return this;
    }

    public void setEngineType(int i3) {
        this.engineType = i3;
    }

    public void setReportType(int i3) {
        this.reportType = i3;
    }

    public String simpleInfo() {
        return "[appId=" + this.appId + "][name=" + this.name + "]";
    }

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("MiniAppInfo{appId='");
        sb5.append(this.appId);
        sb5.append('\'');
        sb5.append(", name='");
        sb5.append(this.name);
        sb5.append('\'');
        sb5.append(", iconUrl='");
        sb5.append(this.iconUrl);
        sb5.append('\'');
        sb5.append(", downloadUrl='");
        sb5.append(this.downloadUrl);
        sb5.append('\'');
        sb5.append(", topType=");
        sb5.append(this.topType);
        sb5.append(", version='");
        sb5.append(this.version);
        sb5.append('\'');
        sb5.append(", desc='");
        sb5.append(this.desc);
        sb5.append('\'');
        sb5.append(", engineType='");
        sb5.append(this.engineType);
        sb5.append('\'');
        sb5.append(", reportType='");
        sb5.append(this.reportType);
        sb5.append('\'');
        sb5.append(", verType=");
        sb5.append(this.verType);
        sb5.append(", timestamp=");
        sb5.append(this.timestamp);
        sb5.append(", baselibMiniVersion='");
        sb5.append(this.baselibMiniVersion);
        sb5.append('\'');
        sb5.append(", filesize=");
        sb5.append(this.fileSize);
        sb5.append(", extraData=");
        sb5.append(this.extraData);
        sb5.append(", developerDesc=");
        sb5.append(this.developerDesc);
        sb5.append(", firstPage=");
        sb5.append(this.firstPage);
        sb5.append(", whiteList=");
        sb5.append(list2string(this.whiteList));
        sb5.append(", blackList=");
        sb5.append(list2string(this.blackList));
        sb5.append(", secondApiRightInfoList=");
        sb5.append(list2stringSecond(this.secondApiRightInfoList));
        sb5.append(", requestDomainList=");
        sb5.append(list2string(this.requestDomainList));
        sb5.append(", socketDomainList=");
        sb5.append(list2string(this.socketDomainList));
        sb5.append(", uploadFileDomainList=");
        sb5.append(list2string(this.uploadFileDomainList));
        sb5.append(", downloadFileDomainList=");
        sb5.append(list2string(this.downloadFileDomainList));
        sb5.append(", businessDomainList=");
        sb5.append(list2string(this.businessDomainList));
        sb5.append(", udpIpList=");
        sb5.append(list2string(this.udpIpList));
        sb5.append(", subpkgs=");
        sb5.append(list2stringO(this.subpkgs));
        sb5.append(", isSupportOffline=");
        sb5.append(this.isSupportOffline);
        sb5.append(", skipDomainCheck=");
        sb5.append(this.skipDomainCheck);
        sb5.append(", openId=");
        sb5.append(this.openId);
        sb5.append(", tinyId=");
        sb5.append(this.tinyId);
        sb5.append(", isSupportBlueBar=");
        sb5.append(this.isSupportBlueBar);
        sb5.append(", isSupportOffline=");
        sb5.append(this.isSupportOffline);
        sb5.append(", recommendIconUrl=");
        sb5.append(this.recommendAppIconUrl);
        sb5.append(", extendData=");
        sb5.append(this.extendData);
        sb5.append(", extConfigInfo=");
        sb5.append(list2String(this.extConfigInfoList));
        sb5.append(", clearAuths=");
        sb5.append(this.clearAuths);
        sb5.append(", appStoreAnimPicUrl=");
        sb5.append(this.appStoreAnimPicUrl);
        sb5.append(", usrFileSizeLimit=");
        sb5.append(this.usrFileSizeLimit);
        sb5.append(", versionUpdateTime=");
        sb5.append(this.versionUpdateTime);
        sb5.append(", noNeedRealRecommend=");
        sb5.append(this.noNeedRealRecommend);
        sb5.append(", miniGamePluginInfo=");
        sb5.append(this.miniGamePluginInfo);
        sb5.append(", renderInfo=");
        RenderInfo renderInfo = this.renderInfo;
        sb5.append(renderInfo != null ? renderInfo.renderMode : 0);
        sb5.append(", shareId=");
        sb5.append(this.shareId);
        sb5.append(", via=");
        sb5.append(this.via);
        sb5.append(", enableLoadingAd=");
        sb5.append(this.enableLoadingAd);
        sb5.append(", prepayId=");
        sb5.append(this.prepayId);
        sb5.append(", userNum=");
        sb5.append(this.userNum);
        sb5.append(", friendNum=");
        sb5.append(this.friendNum);
        sb5.append(", miniAppType=");
        sb5.append(this.miniAppType);
        sb5.append(", tags=");
        sb5.append(this.tags);
        sb5.append(", pkgInfo=");
        sb5.append(this.pkgInfo);
        sb5.append(", videoInfo=");
        sb5.append(this.videoInfo);
        sb5.append(", coverInfo=");
        sb5.append(this.coverInfo);
        sb5.append(", isMultiLogin=");
        sb5.append(this.isMultiLogin);
        sb5.append(", isSupportPay=");
        sb5.append(this.isSupportPay);
        sb5.append(", isGdtMiniAppAd=");
        sb5.append(this.isGdtMiniAppAd);
        sb5.append('}');
        return sb5.toString();
    }

    public void updateTimeStamp() {
        this.timestamp = NetConnInfoCenter.getServerTimeMillis();
    }

    public boolean versionIdEquals(MiniAppInfo miniAppInfo) {
        return (TextUtils.isEmpty(this.versionId) || miniAppInfo == null || !this.versionId.equals(miniAppInfo.versionId)) ? false : true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.appId);
        parcel.writeString(this.name);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.topType);
        parcel.writeString(this.version);
        parcel.writeString(this.versionId);
        parcel.writeString(this.desc);
        parcel.writeInt(this.verType);
        parcel.writeLong(this.timestamp);
        parcel.writeString(this.baselibMiniVersion);
        parcel.writeTypedList(this.subpkgs);
        parcel.writeParcelable(this.firstPage, 0);
        parcel.writeInt(this.engineType);
        parcel.writeStringList(this.whiteList);
        parcel.writeStringList(this.blackList);
        parcel.writeTypedList(this.secondApiRightInfoList);
        parcel.writeParcelable(this.debugInfo, 0);
        parcel.writeInt(this.fileSize);
        parcel.writeStringList(this.requestDomainList);
        parcel.writeStringList(this.socketDomainList);
        parcel.writeStringList(this.downloadFileDomainList);
        parcel.writeStringList(this.uploadFileDomainList);
        parcel.writeStringList(this.businessDomainList);
        parcel.writeStringList(this.udpIpList);
        parcel.writeString(this.developerDesc);
        parcel.writeString(this.extraData);
        parcel.writeInt(this.recommend);
        parcel.writeString(this.reportData);
        parcel.writeParcelable(this.appMode, 0);
        parcel.writeString(this.openId);
        parcel.writeLong(this.tinyId);
        parcel.writeInt(this.skipDomainCheck);
        parcel.writeInt(this.position);
        parcel.writeByte(this.isSupportBlueBar ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.isSupportOffline ? 1 : 0);
        parcel.writeString(this.recommendAppIconUrl);
        parcel.writeString(this.extendData);
        parcel.writeInt(this.clearAuths);
        parcel.writeByteArray(this.commonExt);
        parcel.writeTypedList(this.extConfigInfoList);
        parcel.writeString(this.appStoreAnimPicUrl);
        parcel.writeStringList(this.motionPics);
        parcel.writeLong(this.usrFileSizeLimit);
        parcel.writeTypedList(this.preCacheList);
        parcel.writeInt(this.versionUpdateTime);
        parcel.writeInt(this.noNeedRealRecommend);
        parcel.writeParcelable(this.miniGamePluginInfo, 0);
        parcel.writeInt(this.reportType);
        parcel.writeStringList(this.qualifications);
        parcel.writeString(this.shareId);
        parcel.writeString(this.via);
        parcel.writeString(this.amsAdInfo);
        parcel.writeString(this.apngUrl);
        parcel.writeString(this.ide_scene);
        parcel.writeString(this.ide_extraAppid);
        parcel.writeString(this.ide_extraData);
        parcel.writeInt(this.tianshuAdId);
        parcel.writeTypedList(this.resourcePreCacheInfo);
        parcel.writeInt(this.enableLoadingAd ? 1 : 0);
        parcel.writeInt(this.deviceOrientation);
        parcel.writeInt(this.showStatusBar);
        parcel.writeString(this.prepayId);
        parcel.writeInt(this.userNum);
        parcel.writeInt(this.friendNum);
        parcel.writeTypedList(this.users);
        parcel.writeString(this.gameCopyrightInfo);
        parcel.writeString(this.gamePublicationNumber);
        parcel.writeString(this.gamePublicationCompany);
        parcel.writeString(this.gameApprovalNumber);
        parcel.writeString(this.gameOperatingCompany);
        parcel.writeString(this.extInfo);
        parcel.writeInt(this.miniAppType);
        parcel.writeString(this.tags);
        parcel.writeParcelable(this.pkgInfo, 0);
        parcel.writeTypedList(this.videoInfo);
        parcel.writeTypedList(this.coverInfo);
        parcel.writeInt(this.isMultiLogin ? 1 : 0);
        parcel.writeInt(this.isSupportPay ? 1 : 0);
        parcel.writeInt(this.isGdtMiniAppAd ? 1 : 0);
        parcel.writeParcelable(this.gdtAdInfo, 0);
        parcel.writeString(this.gameRegistrationNumber);
        parcel.writeInt(this.rightAge);
        parcel.writeString(this.rightAgeNoticeUrl);
        parcel.writeString(this.bindingAppId);
    }

    private void fillCoverInfo(List<INTERFACE$StAppMediaInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.coverInfo = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            INTERFACE$StAppMediaInfo iNTERFACE$StAppMediaInfo = list.get(i3);
            this.coverInfo.add(new AppMediaInfo(iNTERFACE$StAppMediaInfo.type.get(), iNTERFACE$StAppMediaInfo.width.get(), iNTERFACE$StAppMediaInfo.height.get(), iNTERFACE$StAppMediaInfo.URL.get()));
        }
    }

    private void fillPkgInfo(INTERFACE$StAppPkgInfo iNTERFACE$StAppPkgInfo) {
        if (iNTERFACE$StAppPkgInfo != null) {
            this.pkgInfo = new AppPkgInfo(iNTERFACE$StAppPkgInfo.name.get());
            this.isSupportPay = iNTERFACE$StAppPkgInfo.isSupportPay.get() == 1;
            this.isMultiLogin = iNTERFACE$StAppPkgInfo.isMultiLogin.get() == 1;
        }
    }

    private void fillVideoInfo(List<INTERFACE$StAppVideoInfo> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.videoInfo = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            INTERFACE$StAppVideoInfo iNTERFACE$StAppVideoInfo = list.get(i3);
            INTERFACE$StAppMediaInfo iNTERFACE$StAppMediaInfo = iNTERFACE$StAppVideoInfo.video.get();
            List<INTERFACE$StAppMediaInfo> list2 = iNTERFACE$StAppVideoInfo.pics.get();
            AppMediaInfo appMediaInfo = new AppMediaInfo(iNTERFACE$StAppMediaInfo.type.get(), iNTERFACE$StAppMediaInfo.width.get(), iNTERFACE$StAppMediaInfo.height.get(), iNTERFACE$StAppMediaInfo.URL.get());
            ArrayList arrayList = new ArrayList();
            for (INTERFACE$StAppMediaInfo iNTERFACE$StAppMediaInfo2 : list2) {
                arrayList.add(new AppMediaInfo(iNTERFACE$StAppMediaInfo2.type.get(), iNTERFACE$StAppMediaInfo2.width.get(), iNTERFACE$StAppMediaInfo2.height.get(), iNTERFACE$StAppMediaInfo2.URL.get()));
            }
            this.videoInfo.add(new AppVideoInfo(appMediaInfo, arrayList));
        }
    }

    public boolean canUpdateMiniAppInfo(MiniAppInfo miniAppInfo) {
        return miniAppInfo != null && TextUtils.equals(miniAppInfo.appId, this.appId) && miniAppInfo.verType == this.verType && miniAppInfo.engineType == this.engineType && miniAppInfo.reportType == this.reportType;
    }

    private static boolean domainEquals(List<String> list, List<String> list2) {
        if (list == list2) {
            return true;
        }
        if (list != null) {
            return list.equals(list2);
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MiniAppInfo)) {
            return false;
        }
        MiniAppInfo miniAppInfo = (MiniAppInfo) obj;
        return TextUtils.equals(miniAppInfo.appId, this.appId) && TextUtils.equals(miniAppInfo.name, this.name) && miniAppInfo.verType == this.verType;
    }

    public MiniAppInfo(String str) {
        this.udpIpList = new ArrayList();
        this.moduleReportDataMap = new HashMap<>();
        this.tagInfo = new TagInfo();
        this.tagList = new ArrayList<>();
        this.moduleTagMap = new HashMap<>();
        this.appMode = new AppMode();
        this.moduleViaMap = new HashMap<>();
        this.friendMessageQuery = "";
        this.moduleTianShuAdIdMap = new HashMap<>();
        this.name = str;
    }

    public static MiniAppInfo getMiniAppInfoByIdFromDB(MiniAppInfoByIdEntity miniAppInfoByIdEntity) {
        try {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            iNTERFACE$StApiAppInfo.mergeFrom(miniAppInfoByIdEntity.appInfo);
            return from(iNTERFACE$StApiAppInfo);
        } catch (Throwable th5) {
            QLog.e("miniapp-db", 1, "getMiniAppInfoByIdFromDB 2 error,", th5);
            return null;
        }
    }

    public static MiniAppInfo getMiniAppInfoByLinkFromDB(MiniAppInfoByLinkEntity miniAppInfoByLinkEntity) {
        try {
            INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
            iNTERFACE$StApiAppInfo.mergeFrom(miniAppInfoByLinkEntity.appInfo);
            return from(iNTERFACE$StApiAppInfo);
        } catch (Throwable th5) {
            QLog.e("miniapp-db", 1, "getMiniAppInfoByLinkFromDB 2 error,", th5);
            return null;
        }
    }

    public MiniAppInfo(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7) {
        this(str2, str3, str4, i3, i16, i17, str5, str, str7, 0L, str6);
    }

    MiniAppInfo(String str, String str2, String str3, int i3, int i16, int i17, String str4, String str5, String str6, long j3, String str7) {
        this(str5, str, str2, str3, i3, i16, i17, str4, str7, str6, j3, null, "", null, null);
    }

    MiniAppInfo(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, long j3, List<INTERFACE$StSubPkgInfo> list, String str8, INTERFACE$StFirstPage iNTERFACE$StFirstPage, INTERFACE$StApiRightController iNTERFACE$StApiRightController) {
        this(str, str2, str3, str4, i3, i16, i17, str5, str6, str7, j3, list, str8, iNTERFACE$StFirstPage, iNTERFACE$StApiRightController, null);
    }

    MiniAppInfo(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, long j3, List<INTERFACE$StSubPkgInfo> list, String str8, INTERFACE$StFirstPage iNTERFACE$StFirstPage, INTERFACE$StApiRightController iNTERFACE$StApiRightController, INTERFACE$StMDebugInfo iNTERFACE$StMDebugInfo) {
        this(str, str2, str3, str4, i3, i16, i17, str5, str6, str7, j3, list, str8, iNTERFACE$StFirstPage, iNTERFACE$StApiRightController, iNTERFACE$StMDebugInfo, null, null, null, "", 0, null, 0, false, false, "", "", 1, null, 0, null, null, null, null, null, null, 0, null, null, null, null, null, "", null, false, null, null, 0, "", "");
    }

    MiniAppInfo(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, long j3, List<INTERFACE$StSubPkgInfo> list, String str8, INTERFACE$StFirstPage iNTERFACE$StFirstPage, INTERFACE$StApiRightController iNTERFACE$StApiRightController, INTERFACE$StMDebugInfo iNTERFACE$StMDebugInfo, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig, INTERFACE$StMainPageExtInfo iNTERFACE$StMainPageExtInfo, INTERFACE$StDeveloperInfo iNTERFACE$StDeveloperInfo, String str9, int i18, INTERFACE$StAppMode iNTERFACE$StAppMode, int i19, boolean z16, boolean z17, String str10, String str11, int i26, String str12, int i27, COMM.StCommonExt stCommonExt, List<INTERFACE$StExtConfigInfo> list2, INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo, INTERFACE$StOperationInfo iNTERFACE$StOperationInfo, INTERFACE$StIdeConfig iNTERFACE$StIdeConfig, String str13, int i28, COMM.StCommonExt stCommonExt2, String str14, INTERFACE$StAppPkgInfo iNTERFACE$StAppPkgInfo, List<INTERFACE$StAppVideoInfo> list3, List<INTERFACE$StAppMediaInfo> list4, String str15, List<String> list5, boolean z18, GdtAd gdtAd, INTERFACE$StRegistrationInfo iNTERFACE$StRegistrationInfo, int i29, String str16, String str17) {
        this.udpIpList = new ArrayList();
        this.moduleReportDataMap = new HashMap<>();
        this.tagInfo = new TagInfo();
        this.tagList = new ArrayList<>();
        this.moduleTagMap = new HashMap<>();
        this.appMode = new AppMode();
        this.moduleViaMap = new HashMap<>();
        this.friendMessageQuery = "";
        this.moduleTianShuAdIdMap = new HashMap<>();
        this.appId = str;
        this.name = str2;
        this.iconUrl = str3;
        this.downloadUrl = str4;
        this.reportType = i3;
        this.topType = i16;
        this.verType = i17;
        this.version = str5;
        this.versionId = str6;
        this.baselibMiniVersion = str7;
        this.desc = str8;
        this.timestamp = j3;
        if (list != null) {
            this.subpkgs = new ArrayList();
            for (INTERFACE$StSubPkgInfo iNTERFACE$StSubPkgInfo : list) {
                if (iNTERFACE$StSubPkgInfo != null) {
                    SubPkgInfo subPkgInfo = new SubPkgInfo();
                    subPkgInfo.subPkgName = iNTERFACE$StSubPkgInfo.subPkgName.get();
                    subPkgInfo.downloadUrl = iNTERFACE$StSubPkgInfo.dowLoadUrl.get();
                    subPkgInfo.independent = iNTERFACE$StSubPkgInfo.independent.get();
                    subPkgInfo.fileSize = iNTERFACE$StSubPkgInfo.file_size.get();
                    this.subpkgs.add(subPkgInfo);
                }
            }
        }
        if (iNTERFACE$StFirstPage != null) {
            FirstPageInfo firstPageInfo = new FirstPageInfo();
            this.firstPage = firstPageInfo;
            firstPageInfo.pagePath = iNTERFACE$StFirstPage.pagePath.get();
            this.firstPage.subPkgName = iNTERFACE$StFirstPage.subPkgName.get();
        }
        if (iNTERFACE$StApiRightController != null) {
            if (iNTERFACE$StApiRightController.whiteLst.get() != null) {
                ArrayList arrayList = new ArrayList();
                this.whiteList = arrayList;
                arrayList.addAll(iNTERFACE$StApiRightController.whiteLst.get());
            }
            if (iNTERFACE$StApiRightController.blackLst.get() != null) {
                ArrayList arrayList2 = new ArrayList();
                this.blackList = arrayList2;
                arrayList2.addAll(iNTERFACE$StApiRightController.blackLst.get());
            }
            if (iNTERFACE$StApiRightController.secondApiRights.get() != null) {
                this.secondApiRightInfoList = new ArrayList();
                for (INTERFACE$StApiRightItem iNTERFACE$StApiRightItem : iNTERFACE$StApiRightController.secondApiRights.get()) {
                    if (iNTERFACE$StApiRightItem != null) {
                        SecondApiRightInfo secondApiRightInfo = new SecondApiRightInfo();
                        secondApiRightInfo.apiName = iNTERFACE$StApiRightItem.apiName.get();
                        secondApiRightInfo.secondName = iNTERFACE$StApiRightItem.secondName.get();
                        secondApiRightInfo.right = iNTERFACE$StApiRightItem.right.get();
                        this.secondApiRightInfoList.add(secondApiRightInfo);
                    }
                }
            }
        }
        if (iNTERFACE$StMDebugInfo != null && !TextUtils.isEmpty(iNTERFACE$StMDebugInfo.roomId.get()) && !TextUtils.isEmpty(iNTERFACE$StMDebugInfo.wsUrl.get())) {
            DebugInfo debugInfo = new DebugInfo();
            this.debugInfo = debugInfo;
            debugInfo.roomId = iNTERFACE$StMDebugInfo.roomId.get();
            this.debugInfo.wsUrl = iNTERFACE$StMDebugInfo.wsUrl.get();
        }
        if (iNTERFACE$StDomainConfig != null) {
            if (iNTERFACE$StDomainConfig.requestDomain.get() != null) {
                ArrayList arrayList3 = new ArrayList();
                this.requestDomainList = arrayList3;
                arrayList3.addAll(iNTERFACE$StDomainConfig.requestDomain.get());
            }
            if (iNTERFACE$StDomainConfig.socketDomain.get() != null) {
                ArrayList arrayList4 = new ArrayList();
                this.socketDomainList = arrayList4;
                arrayList4.addAll(iNTERFACE$StDomainConfig.socketDomain.get());
            }
            if (iNTERFACE$StDomainConfig.uploadFileDomain.get() != null) {
                ArrayList arrayList5 = new ArrayList();
                this.uploadFileDomainList = arrayList5;
                arrayList5.addAll(iNTERFACE$StDomainConfig.uploadFileDomain.get());
            }
            if (iNTERFACE$StDomainConfig.downloadFileDomain.get() != null) {
                ArrayList arrayList6 = new ArrayList();
                this.downloadFileDomainList = arrayList6;
                arrayList6.addAll(iNTERFACE$StDomainConfig.downloadFileDomain.get());
            }
            if (iNTERFACE$StDomainConfig.businessDomain.get() != null) {
                ArrayList arrayList7 = new ArrayList();
                this.businessDomainList = arrayList7;
                arrayList7.addAll(iNTERFACE$StDomainConfig.businessDomain.get());
            }
            if (iNTERFACE$StDomainConfig.udpIpList.get() != null) {
                this.udpIpList.addAll(iNTERFACE$StDomainConfig.udpIpList.get());
            }
        }
        if (iNTERFACE$StMainPageExtInfo != null) {
            this.fileSize = iNTERFACE$StMainPageExtInfo.file_size.get();
        }
        if (iNTERFACE$StDeveloperInfo != null) {
            this.developerDesc = iNTERFACE$StDeveloperInfo.name.get();
        }
        this.extraData = str9;
        this.recommend = i18;
        this.appMode = AppMode.from(iNTERFACE$StAppMode);
        this.skipDomainCheck = i19;
        this.isSupportBlueBar = z16;
        this.isSupportOffline = z17;
        this.recommendAppIconUrl = str10;
        this.bubbleText = str11;
        this.bubbleClickCount = i26;
        this.extendData = str12;
        this.clearAuths = i27;
        this.prepayId = str13;
        this.commonExt = stCommonExt.toByteArray();
        if (list2 != null) {
            this.extConfigInfoList = new ArrayList<>();
            Iterator<INTERFACE$StExtConfigInfo> it = list2.iterator();
            while (it.hasNext()) {
                this.extConfigInfoList.add(ExtConfigInfo.from(it.next()));
            }
        }
        if (iNTERFACE$StAppBasicInfo != null) {
            this.usrFileSizeLimit = iNTERFACE$StAppBasicInfo.usrFileSizeLimit.get();
            List<INTERFACE$StAppPreCacheInfo> list6 = iNTERFACE$StAppBasicInfo.preCacheList.get();
            if (!list6.isEmpty()) {
                this.preCacheList = new ArrayList<>();
                for (INTERFACE$StAppPreCacheInfo iNTERFACE$StAppPreCacheInfo : list6) {
                    this.preCacheList.add(new PreCacheInfo(iNTERFACE$StAppPreCacheInfo.getDataUrl.get(), iNTERFACE$StAppPreCacheInfo.preCacheKey.get(), iNTERFACE$StAppPreCacheInfo.expireTime.get(), iNTERFACE$StAppPreCacheInfo.cacheType.get(), iNTERFACE$StAppPreCacheInfo.useProxy.get()));
                }
            }
            List<INTERFACE$StResourcePreCacheInfo> list7 = iNTERFACE$StAppBasicInfo.resourcePreCacheList.get();
            if (!list7.isEmpty()) {
                this.resourcePreCacheInfo = new ArrayList<>();
                Iterator<INTERFACE$StResourcePreCacheInfo> it5 = list7.iterator();
                while (it5.hasNext()) {
                    this.resourcePreCacheInfo.add(new ResourcePreCacheInfo(it5.next().getDataUrl.get()));
                }
            }
            this.versionUpdateTime = iNTERFACE$StAppBasicInfo.versionUpdateTime.get();
            if (iNTERFACE$StAppBasicInfo.pkgType.has()) {
                if (iNTERFACE$StAppBasicInfo.pkgType.get() == 1) {
                    this.engineType = 1;
                } else if (iNTERFACE$StAppBasicInfo.pkgType.get() == 2) {
                    this.engineType = 0;
                } else {
                    this.engineType = iNTERFACE$StAppBasicInfo.pkgType.get();
                }
            } else {
                this.engineType = this.reportType;
            }
            this.noNeedRealRecommend = iNTERFACE$StAppBasicInfo.noNeedRealRecommend.get();
            this.miniGamePluginInfo = MiniGamePluginInfo.fromProtocol(iNTERFACE$StAppBasicInfo.pluginInfo);
            this.renderInfo = RenderInfo.from(iNTERFACE$StAppBasicInfo.renderInfo);
            this.qualifications = new ArrayList<>(iNTERFACE$StAppBasicInfo.qualificationInfo.get());
            this.gameCopyrightInfo = iNTERFACE$StAppBasicInfo.gameCopyrightInfo.get();
            INTERFACE$StGamePublicationInfo iNTERFACE$StGamePublicationInfo = iNTERFACE$StAppBasicInfo.gamePublicationInfo;
            if (iNTERFACE$StGamePublicationInfo != null) {
                this.gamePublicationNumber = iNTERFACE$StGamePublicationInfo.gamePublicationNumber.get();
                this.gamePublicationCompany = iNTERFACE$StAppBasicInfo.gamePublicationInfo.gamePublicationCommpany.get();
                this.gameApprovalNumber = iNTERFACE$StAppBasicInfo.gamePublicationInfo.gameApprovalNumber.get();
                this.gameOperatingCompany = iNTERFACE$StAppBasicInfo.gamePublicationInfo.gameOperatingCompany.get();
            }
            this.shareId = iNTERFACE$StAppBasicInfo.shareId.get();
            this.via = iNTERFACE$StAppBasicInfo.via.get();
            this.enableLoadingAd = iNTERFACE$StAppBasicInfo.splashScreenAd.get() == 1;
        }
        if (iNTERFACE$StOperationInfo != null) {
            this.amsAdInfo = iNTERFACE$StOperationInfo.amsAdInfo.get();
            this.tianshuAdId = iNTERFACE$StOperationInfo.tianshuAdId.get();
            this.reportData = iNTERFACE$StOperationInfo.reportData.get();
            this.tagInfo = TagInfo.from(iNTERFACE$StOperationInfo.tagInfo);
            if (iNTERFACE$StOperationInfo.tagInfos.get() != null) {
                ArrayList<TagInfo> arrayList8 = new ArrayList<>();
                for (INTERFACE$TagInfo iNTERFACE$TagInfo : iNTERFACE$StOperationInfo.tagInfos.get()) {
                    if (iNTERFACE$TagInfo != null) {
                        arrayList8.add(TagInfo.from(iNTERFACE$TagInfo));
                    }
                }
                this.tagList = arrayList8;
            }
        }
        if (iNTERFACE$StIdeConfig != null) {
            this.ide_scene = iNTERFACE$StIdeConfig.scene.get();
            this.ide_extraAppid = iNTERFACE$StIdeConfig.extraAppid.get();
            this.ide_extraData = iNTERFACE$StIdeConfig.extraData.get();
            INTERFACE$StStartExtInfo iNTERFACE$StStartExtInfo = iNTERFACE$StIdeConfig.startExtInfo;
            if (iNTERFACE$StStartExtInfo != null) {
                this.deviceOrientation = iNTERFACE$StStartExtInfo.deviceOrientation.get();
                this.showStatusBar = iNTERFACE$StIdeConfig.startExtInfo.showStatusBar.get();
            }
        }
        this.extInfo = com.tencent.qqmini.sdk.launcher.model.MiniAppInfo.parseExtInfo(stCommonExt2);
        this.miniAppType = i28;
        this.tags = str14;
        fillPkgInfo(iNTERFACE$StAppPkgInfo);
        fillVideoInfo(list3);
        fillCoverInfo(list4);
        this.schema = str15;
        this.loopIcos = list5;
        this.isGdtMiniAppAd = z18;
        this.gdtAdInfo = gdtAd;
        if (iNTERFACE$StRegistrationInfo != null) {
            this.gameRegistrationNumber = iNTERFACE$StRegistrationInfo.registrationNumber.get();
        }
        this.rightAge = i29;
        this.rightAgeNoticeUrl = str16;
        this.bindingAppId = str17;
    }

    public static void saveMiniAppShowInfoEntity(MiniAppInfo miniAppInfo) {
        AppMode appMode;
        if ((miniAppInfo != null && (appMode = miniAppInfo.appMode) != null && (appMode.isAppStore || appMode.interMode)) || miniAppInfo == null || miniAppInfo.isAppTypeVirtualApp()) {
            return;
        }
        MiniAppShowInfoEntity miniAppShowInfoEntity = new MiniAppShowInfoEntity();
        miniAppShowInfoEntity.appId = miniAppInfo.appId;
        miniAppShowInfoEntity.appName = miniAppInfo.name;
        miniAppShowInfoEntity.icon = miniAppInfo.iconUrl;
        miniAppShowInfoEntity.desc = miniAppInfo.desc;
        miniAppShowInfoEntity.gameCopyrightInfo = miniAppInfo.gameCopyrightInfo;
        miniAppShowInfoEntity.gamePublicationNumber = miniAppInfo.gamePublicationNumber;
        miniAppShowInfoEntity.gamePublicationCompany = miniAppInfo.gamePublicationCompany;
        miniAppShowInfoEntity.gameApprovalNumber = miniAppInfo.gameApprovalNumber;
        miniAppShowInfoEntity.gameOperatingCompany = miniAppInfo.gameOperatingCompany;
        miniAppShowInfoEntity.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        miniAppShowInfoEntity.reportType = miniAppInfo.reportType;
        miniAppShowInfoEntity.engineType = miniAppInfo.engineType;
        AppMode appMode2 = miniAppInfo.appMode;
        miniAppShowInfoEntity.interMode = appMode2 != null && appMode2.interMode;
        miniAppShowInfoEntity.timeStamp = System.currentTimeMillis();
        miniAppShowInfoEntity.miniAppType = miniAppInfo.miniAppType;
        MiniAppEntityManager miniAppEntityManager = MiniAppEntityManager.get();
        if (miniAppEntityManager != null) {
            miniAppEntityManager.insertOrReplaceEntity(miniAppShowInfoEntity);
            QLog.d("miniapp-db", 1, "saveMiniAppShowInfoEntity ok." + miniAppShowInfoEntity.appId);
        }
    }

    public static MiniAppInfo from(INTERFACE$StUserAppInfo iNTERFACE$StUserAppInfo) {
        if (iNTERFACE$StUserAppInfo == null) {
            return new MiniAppInfo();
        }
        MiniAppInfo from = from(iNTERFACE$StUserAppInfo.appInfo.get());
        from.topType = iNTERFACE$StUserAppInfo.putTop.get();
        from.timestamp = iNTERFACE$StUserAppInfo.useTime.get();
        from.openId = iNTERFACE$StUserAppInfo.openid.get();
        from.tinyId = iNTERFACE$StUserAppInfo.tinyid.get();
        from.appStoreAnimPicUrl = iNTERFACE$StUserAppInfo.bgPic.get();
        from.motionPics = getMotionPics(iNTERFACE$StUserAppInfo.motionPics.get());
        from.apngUrl = iNTERFACE$StUserAppInfo.apngUrl.get();
        from.userNum = iNTERFACE$StUserAppInfo.userNum.get();
        int i3 = iNTERFACE$StUserAppInfo.friendNum.get();
        from.friendNum = i3;
        if (i3 > 0) {
            ArrayList arrayList = new ArrayList();
            for (INTERFACE$UseUserInfo iNTERFACE$UseUserInfo : iNTERFACE$StUserAppInfo.users.get()) {
                if (iNTERFACE$UseUserInfo != null) {
                    UseUserInfo useUserInfo = new UseUserInfo();
                    useUserInfo.uin = iNTERFACE$UseUserInfo.uin.get();
                    useUserInfo.avatar = iNTERFACE$UseUserInfo.avatar.get();
                    useUserInfo.nick = iNTERFACE$UseUserInfo.nick.get();
                    arrayList.add(useUserInfo);
                }
            }
            from.users = arrayList;
        }
        return from;
    }

    public static MiniAppInfo from(INTERFACE$StModuleInfo iNTERFACE$StModuleInfo) {
        if (iNTERFACE$StModuleInfo == null) {
            return new MiniAppInfo();
        }
        return new MiniAppInfo(iNTERFACE$StModuleInfo.title.get());
    }
}
