package com.tencent.qqmini.sdk.launcher.model;

import NS_COMM.COMM;
import NS_MINI_INTERFACE.INTERFACE$StApiAppInfo;
import NS_MINI_INTERFACE.INTERFACE$StApiRightController;
import NS_MINI_INTERFACE.INTERFACE$StApiRightItem;
import NS_MINI_INTERFACE.INTERFACE$StAppBasicInfo;
import NS_MINI_INTERFACE.INTERFACE$StAppMode;
import NS_MINI_INTERFACE.INTERFACE$StAppPreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE$StDeveloperInfo;
import NS_MINI_INTERFACE.INTERFACE$StDomainConfig;
import NS_MINI_INTERFACE.INTERFACE$StExtConfigInfo;
import NS_MINI_INTERFACE.INTERFACE$StFirstPage;
import NS_MINI_INTERFACE.INTERFACE$StGamePublicationInfo;
import NS_MINI_INTERFACE.INTERFACE$StIdeConfig;
import NS_MINI_INTERFACE.INTERFACE$StMDebugInfo;
import NS_MINI_INTERFACE.INTERFACE$StMainPageExtInfo;
import NS_MINI_INTERFACE.INTERFACE$StOperationInfo;
import NS_MINI_INTERFACE.INTERFACE$StRegistrationInfo;
import NS_MINI_INTERFACE.INTERFACE$StResourcePreCacheInfo;
import NS_MINI_INTERFACE.INTERFACE$StStartExtInfo;
import NS_MINI_INTERFACE.INTERFACE$StSubPkgInfo;
import android.os.BadParcelableException;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.minispecial.api.impl.ThirdPartyMiniApiImpl;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes23.dex */
public class MiniAppInfo extends MiniAppBaseInfo {
    public static final String APP_STORE_MINI_APP_ID = "1108291530";
    public static final Parcelable.Creator<MiniAppInfo> CREATOR = new Parcelable.Creator<MiniAppInfo>() { // from class: com.tencent.qqmini.sdk.launcher.model.MiniAppInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MiniAppInfo createFromParcel(Parcel parcel) {
            return new MiniAppInfo(parcel);
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
    public static final String TAG = "MiniAppInfo";
    public static final String TAG_DB = "miniapp-db";
    public String appJson;
    public String appStoreAnimPicUrl;
    public BaseLibInfo baseLibInfo;
    public int clearAuths;
    public byte[] commonExt;
    public String customInfo;
    public ArrayList<ExtConfigInfo> extConfigInfoList;
    public String extendData;
    public String extraData;

    @Deprecated
    private int forceReroad;
    public String friendMessageQuery;
    public int gameAdsTotalTime;
    public String gameApprovalNumber;
    public String gameCopyrightInfo;
    public String gameOperatingCompany;
    public String gamePublicationCompany;
    public String gamePublicationNumber;
    public String gameRegistrationNumber;
    public int isContainer;
    private boolean isLoadByContainer;
    public boolean isSupportBlueBar;
    public boolean isSupportOffline;

    @NonNull
    public final LaunchParam launchParam;
    public MiniGamePluginInfo miniGamePluginInfo;
    public ArrayList<String> motionPics;
    public String openId;
    public int position;
    public ArrayList<PreCacheInfo> preCacheList;
    public int recommend;
    public String recommendAppIconUrl;
    public int recordStatus;
    public String recordVideoPath;
    public int renderMode;
    private int reportType;
    public ArrayList<ResourcePreCacheInfo> resourcePreCacheInfo;
    public long tinyId;
    public int topType;

    public MiniAppInfo() {
        this.launchParam = new LaunchParam();
        this.friendMessageQuery = "";
        this.appJson = "";
        this.isContainer = 0;
        this.forceReroad = 0;
        this.renderMode = -1;
        this.isLoadByContainer = false;
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
        ArrayList arrayList = new ArrayList();
        List<SubPkgInfo> list = miniAppInfo.subpkgs;
        if (list != null) {
            for (SubPkgInfo subPkgInfo : list) {
                SubPkgInfo subPkgInfo2 = new SubPkgInfo();
                subPkgInfo2.subPkgName = subPkgInfo.subPkgName;
                subPkgInfo2.version = subPkgInfo.version;
                subPkgInfo2.versionId = subPkgInfo.versionId;
                subPkgInfo2.fileSize = subPkgInfo.fileSize;
                subPkgInfo2.downloadUrl = subPkgInfo.downloadUrl;
                subPkgInfo2.independent = subPkgInfo.independent;
                arrayList.add(subPkgInfo2);
            }
        }
        miniAppInfo2.subpkgs = arrayList;
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
                miniAppInfo2.preCacheList.add(new PreCacheInfo(next.getDataUrl, next.preCacheKey, next.expireTime));
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
        miniAppInfo2.shareId = miniAppInfo.shareId;
        miniAppInfo2.via = miniAppInfo.via;
        miniAppInfo2.enableLoadingAd = miniAppInfo.enableLoadingAd;
        miniAppInfo2.extInfo = miniAppInfo.extInfo;
        miniAppInfo2.appJson = miniAppInfo.appJson;
        miniAppInfo2.isContainer = miniAppInfo.isContainer;
        miniAppInfo2.auditState = miniAppInfo.auditState;
        miniAppInfo2.releaseState = miniAppInfo.releaseState;
        miniAppInfo2.gameRegistrationNumber = miniAppInfo.gameRegistrationNumber;
        return miniAppInfo2;
    }

    public static MiniAppInfo createMiniAppInfo(JSONObject jSONObject) {
        boolean z16;
        if (jSONObject == null) {
            return null;
        }
        try {
            MiniAppInfo miniAppInfo = new MiniAppInfo();
            miniAppInfo.appId = jSONObject.optString("appId");
            miniAppInfo.name = jSONObject.optString("appName");
            miniAppInfo.iconUrl = jSONObject.optString("icon");
            miniAppInfo.downloadUrl = jSONObject.optString("donwLoadUrl");
            miniAppInfo.version = jSONObject.optString("version");
            miniAppInfo.desc = jSONObject.optString("desc");
            miniAppInfo.verType = jSONObject.optInt("type");
            miniAppInfo.extInfo = jSONObject.optString("extInfo");
            miniAppInfo.baselibMiniVersion = jSONObject.optString("baselibMiniVersion");
            miniAppInfo.auditState = jSONObject.optInt("auditState");
            miniAppInfo.releaseState = jSONObject.optInt("releaseState");
            miniAppInfo.subpkgs = parseSubpkgs(jSONObject);
            miniAppInfo.firstPage = new FirstPageInfo();
            JSONObject optJSONObject = jSONObject.optJSONObject(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
            if (optJSONObject != null) {
                miniAppInfo.firstPage.pagePath = optJSONObject.optString("pagePath");
                miniAppInfo.firstPage.subPkgName = optJSONObject.optString("subPkgName");
            }
            parseDomainInfo(miniAppInfo, jSONObject);
            miniAppInfo.appType = jSONObject.optInt("appType");
            miniAppInfo.debugInfo = new DebugInfo();
            JSONObject optJSONObject2 = jSONObject.optJSONObject("mDebug");
            if (optJSONObject2 != null) {
                miniAppInfo.debugInfo.roomId = optJSONObject2.optString("roomId");
                miniAppInfo.debugInfo.wsUrl = optJSONObject2.optString("wsUrl");
            }
            miniAppInfo.versionId = jSONObject.optString("versionId");
            parseApiRights(miniAppInfo, jSONObject);
            if (jSONObject.optJSONObject("mainExt") != null) {
                miniAppInfo.fileSize = jSONObject.optJSONObject("mainExt").optInt("file_size");
            }
            if (jSONObject.optJSONObject("devInfo") != null) {
                miniAppInfo.developerDesc = jSONObject.optJSONObject("devInfo").optString("name");
            }
            if (jSONObject.optJSONObject("basicInfo") != null) {
                JSONObject optJSONObject3 = jSONObject.optJSONObject("basicInfo");
                miniAppInfo.usrFileSizeLimit = optJSONObject3.optInt("usrFileSizeLimit");
                miniAppInfo.versionUpdateTime = optJSONObject3.optInt("versionUpdateTime");
                miniAppInfo.noNeedRealRecommend = optJSONObject3.optInt("noNeedRealRecommend");
                if (optJSONObject3.optInt("splashScreenAd") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                miniAppInfo.enableLoadingAd = z16;
                miniAppInfo.gameCopyrightInfo = optJSONObject3.optString("gameCopyrightInfo");
                miniAppInfo.gamePublicationNumber = optJSONObject3.optString("gamePublicationNumber");
                miniAppInfo.gamePublicationCompany = optJSONObject3.optString("gamePublicationCompany");
                miniAppInfo.gameApprovalNumber = optJSONObject3.optString("gameApprovalNumber");
                miniAppInfo.gameOperatingCompany = optJSONObject3.optString("gameOperatingCompany");
                if (optJSONObject3.has("pkgType")) {
                    int optInt = optJSONObject3.optInt("pkgType");
                    if (optInt == 1) {
                        miniAppInfo.engineType = 1;
                    } else if (optInt == 2) {
                        miniAppInfo.engineType = 0;
                    } else {
                        miniAppInfo.engineType = optInt;
                    }
                } else {
                    miniAppInfo.engineType = miniAppInfo.appType;
                }
                miniAppInfo.miniGamePluginInfo = parseMiniGamePluginInfo(optJSONObject3.optJSONObject("pluginInfo"));
            }
            if (jSONObject.optJSONObject("appMode") != null) {
                miniAppInfo.appMode = new AppMode();
                JSONObject optJSONObject4 = jSONObject.optJSONObject("appMode");
                miniAppInfo.appMode.interMode = optJSONObject4.optBoolean("interMode");
                miniAppInfo.appMode.authoritySilent = optJSONObject4.optBoolean("authoritySilent");
                miniAppInfo.appMode.keepOffPullList = optJSONObject4.optBoolean("keepOffPullList");
                miniAppInfo.appMode.closeTopRightCapsule = optJSONObject4.optBoolean("closeTopRightCapsule");
                miniAppInfo.appMode.openNativeApi = optJSONObject4.optBoolean("openNativeApi");
                miniAppInfo.appMode.hideAppSearch = optJSONObject4.optBoolean("hideAppSearch");
                miniAppInfo.appMode.isAppStore = optJSONObject4.optBoolean("isAppStore");
                miniAppInfo.appMode.isWangKa = optJSONObject4.optBoolean("isWangKa");
                miniAppInfo.appMode.interLoading = optJSONObject4.optBoolean("interLoading");
                miniAppInfo.appMode.isLimitedAccess = optJSONObject4.optBoolean("isLimitedAccess");
                miniAppInfo.appMode.isPayForFriend = optJSONObject4.optBoolean("isPayForFriend");
                miniAppInfo.appMode.useAppInfoWhenNavigate = optJSONObject4.optBoolean("useAppInfoWhenNavigate");
                miniAppInfo.appMode.disableAddToMyApp = optJSONObject4.optBoolean(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYAPP);
                miniAppInfo.appMode.disableAddToMyFavor = optJSONObject4.optBoolean(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYFAVOR);
                miniAppInfo.appMode.reloadWithFirstPageChange = optJSONObject4.optBoolean("reloadWithFirstPageChange");
                miniAppInfo.appMode.unlimitedApiRight = optJSONObject4.optBoolean("unlimitedApiRight");
                miniAppInfo.appMode.disableShareToAIO = optJSONObject4.optBoolean("disableShareToAIO");
                miniAppInfo.appMode.disableShareToQZone = optJSONObject4.optBoolean("disableShareToQZone");
                miniAppInfo.appMode.disableShareToWeChat = optJSONObject4.optBoolean("disableShareToWeChat");
            }
            if (jSONObject.optJSONObject("registrationInfo") != null) {
                miniAppInfo.gameRegistrationNumber = jSONObject.optJSONObject("registrationInfo").optString("registrationNumber");
            }
            return miniAppInfo;
        } catch (Throwable th5) {
            QMLog.e("MiniAppInfo", "", th5);
            return null;
        }
    }

    public static boolean equalObj(Object obj, Object obj2) {
        if (obj == null) {
            if (obj2 == null) {
                return true;
            }
            return false;
        }
        return obj.equals(obj2);
    }

    public static MiniAppInfo from(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        if (iNTERFACE$StApiAppInfo == null) {
            return new MiniAppInfo();
        }
        String str = iNTERFACE$StApiAppInfo.appId.get();
        String str2 = iNTERFACE$StApiAppInfo.appName.get();
        String str3 = iNTERFACE$StApiAppInfo.icon.get();
        String str4 = iNTERFACE$StApiAppInfo.donwLoadUrl.get();
        int i3 = iNTERFACE$StApiAppInfo.appType.get();
        int i16 = iNTERFACE$StApiAppInfo.type.get();
        String str5 = iNTERFACE$StApiAppInfo.version.get();
        String str6 = iNTERFACE$StApiAppInfo.versionId.get();
        String str7 = iNTERFACE$StApiAppInfo.baselibMiniVersion.get();
        List<INTERFACE$StSubPkgInfo> list = iNTERFACE$StApiAppInfo.subPkgs.get();
        String str8 = iNTERFACE$StApiAppInfo.desc.get();
        INTERFACE$StFirstPage iNTERFACE$StFirstPage = iNTERFACE$StApiAppInfo.first.get();
        INTERFACE$StApiRightController iNTERFACE$StApiRightController = iNTERFACE$StApiAppInfo.apiRight.get();
        INTERFACE$StMDebugInfo iNTERFACE$StMDebugInfo = iNTERFACE$StApiAppInfo.mDebug;
        INTERFACE$StDomainConfig iNTERFACE$StDomainConfig = iNTERFACE$StApiAppInfo.domain.get();
        INTERFACE$StMainPageExtInfo iNTERFACE$StMainPageExtInfo = iNTERFACE$StApiAppInfo.mainExt;
        INTERFACE$StDeveloperInfo iNTERFACE$StDeveloperInfo = iNTERFACE$StApiAppInfo.devInfo;
        int i17 = iNTERFACE$StApiAppInfo.isRecommend.get();
        INTERFACE$StAppMode iNTERFACE$StAppMode = iNTERFACE$StApiAppInfo.appMode.get();
        int i18 = iNTERFACE$StApiAppInfo.skipDomainCheck.get();
        boolean supportBlueBar = getSupportBlueBar(iNTERFACE$StApiAppInfo);
        boolean z16 = true;
        if (iNTERFACE$StApiAppInfo.supportOffline.get() != 1) {
            z16 = false;
        }
        MiniAppInfo miniAppInfo = new MiniAppInfo(str, str2, str3, str4, i3, 0, i16, str5, str6, str7, 0L, list, str8, iNTERFACE$StFirstPage, iNTERFACE$StApiRightController, iNTERFACE$StMDebugInfo, iNTERFACE$StDomainConfig, iNTERFACE$StMainPageExtInfo, iNTERFACE$StDeveloperInfo, null, i17, iNTERFACE$StAppMode, i18, supportBlueBar, z16, getRecommendIconUrl(iNTERFACE$StApiAppInfo), iNTERFACE$StApiAppInfo.extendData.get(), iNTERFACE$StApiAppInfo.appNoCacheExt.clearAuths.get(), iNTERFACE$StApiAppInfo.extInfo, iNTERFACE$StApiAppInfo.extConfig.get(), iNTERFACE$StApiAppInfo.basicInfo.get(), iNTERFACE$StApiAppInfo.operInfo.get(), iNTERFACE$StApiAppInfo.basicInfo.ideConfig.get(), iNTERFACE$StApiAppInfo.extInfo, iNTERFACE$StApiAppInfo.auditState.get(), iNTERFACE$StApiAppInfo.releaseState.get(), iNTERFACE$StApiAppInfo.registrationInfo.get());
        miniAppInfo.appJson = iNTERFACE$StApiAppInfo.appJson.get();
        miniAppInfo.isContainer = iNTERFACE$StApiAppInfo.isContainer.get();
        return miniAppInfo;
    }

    public static INTERFACE$StApiRightController getApiRight(JSONObject jSONObject) {
        INTERFACE$StApiRightController iNTERFACE$StApiRightController = new INTERFACE$StApiRightController();
        JSONObject optJSONObject = jSONObject.optJSONObject("apiRight");
        if (optJSONObject != null) {
            if (optJSONObject.optJSONArray("whiteLst") != null) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = optJSONObject.optJSONArray("whiteLst");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    arrayList.add(optJSONArray.optString(i3));
                }
                iNTERFACE$StApiRightController.whiteLst.set(arrayList);
            }
            if (optJSONObject.optJSONArray("blackLst") != null) {
                ArrayList arrayList2 = new ArrayList();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("blackLst");
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    arrayList2.add(optJSONArray2.optString(i16));
                }
                iNTERFACE$StApiRightController.whiteLst.set(arrayList2);
            }
            if (optJSONObject.optJSONArray("secondApiRights") != null) {
                ArrayList arrayList3 = new ArrayList();
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("secondApiRights");
                for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                    JSONObject optJSONObject2 = optJSONArray3.optJSONObject(i17);
                    if (optJSONObject2 != null) {
                        INTERFACE$StApiRightItem iNTERFACE$StApiRightItem = new INTERFACE$StApiRightItem();
                        iNTERFACE$StApiRightItem.apiName.set(optJSONObject2.optString("apiName"));
                        iNTERFACE$StApiRightItem.right.set(optJSONObject2.optInt("right"));
                        iNTERFACE$StApiRightItem.secondName.set(optJSONObject2.optString("secondName"));
                        arrayList3.add(iNTERFACE$StApiRightItem);
                    }
                }
                iNTERFACE$StApiRightController.secondApiRights.set(arrayList3);
            }
        }
        return iNTERFACE$StApiRightController;
    }

    public static INTERFACE$StMDebugInfo getDebugPb(JSONObject jSONObject) {
        INTERFACE$StMDebugInfo iNTERFACE$StMDebugInfo = new INTERFACE$StMDebugInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("mDebug");
        if (optJSONObject != null) {
            iNTERFACE$StMDebugInfo.wsUrl.set(optJSONObject.optString("wsUrl"));
            iNTERFACE$StMDebugInfo.roomId.set(optJSONObject.optString("roomId"));
        }
        return iNTERFACE$StMDebugInfo;
    }

    public static INTERFACE$StDomainConfig getDomain(JSONObject jSONObject) {
        INTERFACE$StDomainConfig iNTERFACE$StDomainConfig = new INTERFACE$StDomainConfig();
        if (jSONObject.optJSONObject("domain") != null) {
            setRequestDomain(jSONObject, iNTERFACE$StDomainConfig);
            setSocketDomain(jSONObject, iNTERFACE$StDomainConfig);
            setUploadFileDomain(jSONObject, iNTERFACE$StDomainConfig);
            setDownloadFileDomain(jSONObject, iNTERFACE$StDomainConfig);
            setBusinessDomain(jSONObject, iNTERFACE$StDomainConfig);
            setUdpIpList(jSONObject, iNTERFACE$StDomainConfig);
        }
        return iNTERFACE$StDomainConfig;
    }

    public static COMM.StCommonExt getExtInfo(JSONObject jSONObject) throws JSONException {
        COMM.StCommonExt stCommonExt = new COMM.StCommonExt();
        ArrayList arrayList = new ArrayList();
        JSONObject optJSONObject = jSONObject.optJSONObject("extInfo");
        if (optJSONObject != null && optJSONObject.optJSONArray(ThirdPartyMiniApiImpl.KEY_MAP_INFO) != null) {
            JSONArray jSONArray = optJSONObject.getJSONArray(ThirdPartyMiniApiImpl.KEY_MAP_INFO);
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                COMM.Entry entry = new COMM.Entry();
                entry.key.set(jSONObject2.optString("key"));
                entry.value.set(jSONObject2.optString("value"));
                arrayList.add(entry);
            }
        }
        stCommonExt.mapInfo.set(arrayList);
        return stCommonExt;
    }

    public static INTERFACE$StFirstPage getFirstPb(JSONObject jSONObject) {
        INTERFACE$StFirstPage iNTERFACE$StFirstPage = new INTERFACE$StFirstPage();
        JSONObject optJSONObject = jSONObject.optJSONObject(MiniConst.WxMiniAppInfoConst.CATEGORY_KEY_FIRST);
        if (optJSONObject != null) {
            iNTERFACE$StFirstPage.pagePath.set(optJSONObject.optString("pagePath"));
            iNTERFACE$StFirstPage.subPkgName.set(optJSONObject.optString("subPkgName"));
        }
        return iNTERFACE$StFirstPage;
    }

    private int getMaxSize(List... listArr) {
        int i3 = 0;
        for (List list : listArr) {
            if (list != null && list.size() > i3) {
                i3 = list.size();
            }
        }
        return i3;
    }

    private static String getRecommendIconUrl(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        COMM.StCommonExt stCommonExt = iNTERFACE$StApiAppInfo.extInfo;
        if (stCommonExt != null && stCommonExt.mapInfo != null) {
            for (int i3 = 0; i3 < iNTERFACE$StApiAppInfo.extInfo.mapInfo.size(); i3++) {
                COMM.Entry entry = iNTERFACE$StApiAppInfo.extInfo.mapInfo.get(i3);
                if ("recommIcon".equals(entry.key.get())) {
                    return entry.value.get();
                }
            }
        }
        return "";
    }

    public static INTERFACE$StRegistrationInfo getRegistrationInfoPb(JSONObject jSONObject) {
        INTERFACE$StRegistrationInfo iNTERFACE$StRegistrationInfo = new INTERFACE$StRegistrationInfo();
        JSONObject optJSONObject = jSONObject.optJSONObject("registrationInfo");
        if (optJSONObject != null) {
            iNTERFACE$StRegistrationInfo.registrationNumber.set(optJSONObject.optString("registrationNumber"));
        }
        return iNTERFACE$StRegistrationInfo;
    }

    private static Map<String, String> getReportDataFromAppInfo(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        PBStringField pBStringField;
        INTERFACE$StOperationInfo iNTERFACE$StOperationInfo = iNTERFACE$StApiAppInfo.operInfo;
        HashMap hashMap = null;
        if (iNTERFACE$StOperationInfo != null && (pBStringField = iNTERFACE$StOperationInfo.reportData) != null) {
            String str = pBStringField.get();
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
                    QMLog.e("MiniAppInfo", " parse reportData error.", e16);
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
                QMLog.e("MiniAppInfo", " getReportDataString error.", e16);
            }
        }
        return str;
    }

    public static ArrayList<INTERFACE$StSubPkgInfo> getSubPkgsPb(JSONObject jSONObject) {
        ArrayList<INTERFACE$StSubPkgInfo> arrayList = new ArrayList<>();
        JSONArray optJSONArray = jSONObject.optJSONArray("subPkgs");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (optJSONObject != null) {
                    INTERFACE$StSubPkgInfo iNTERFACE$StSubPkgInfo = new INTERFACE$StSubPkgInfo();
                    iNTERFACE$StSubPkgInfo.subPkgName.set(optJSONObject.optString("subPkgName"));
                    iNTERFACE$StSubPkgInfo.dowLoadUrl.set(optJSONObject.optString("dowLoadUrl"));
                    iNTERFACE$StSubPkgInfo.independent.set(optJSONObject.optInt("independent"));
                    iNTERFACE$StSubPkgInfo.file_size.set(optJSONObject.optInt("file_size"));
                    iNTERFACE$StSubPkgInfo.version.set(optJSONObject.optString("version"));
                    iNTERFACE$StSubPkgInfo.versionId.set(optJSONObject.optString("versionId"));
                    iNTERFACE$StSubPkgInfo.mainPackVersion.set(optJSONObject.optString("mainPackVersion"));
                    iNTERFACE$StSubPkgInfo.version_type.set(optJSONObject.optString("version_type"));
                    arrayList.add(iNTERFACE$StSubPkgInfo);
                }
            }
        }
        return arrayList;
    }

    private static boolean getSupportBlueBar(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
        COMM.StCommonExt stCommonExt = iNTERFACE$StApiAppInfo.extInfo;
        if (stCommonExt != null && stCommonExt.mapInfo != null) {
            for (int i3 = 0; i3 < iNTERFACE$StApiAppInfo.extInfo.mapInfo.size(); i3++) {
                COMM.Entry entry = iNTERFACE$StApiAppInfo.extInfo.mapInfo.get(i3);
                if ("support_blue_bar".equals(entry.key.get())) {
                    return "1".equals(entry.value.get());
                }
            }
        }
        return false;
    }

    public static int getVerType(String str) {
        if ("develop".equalsIgnoreCase(str)) {
            return 0;
        }
        if ("trial".equalsIgnoreCase(str)) {
            return 1;
        }
        return 3;
    }

    private void parseApiRightController(INTERFACE$StApiRightController iNTERFACE$StApiRightController) {
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
    }

    private static void parseApiRights(MiniAppInfo miniAppInfo, JSONObject jSONObject) throws JSONException {
        JSONObject optJSONObject = jSONObject.optJSONObject("apiRight");
        if (optJSONObject != null) {
            if (optJSONObject.optJSONArray("whiteLst") != null) {
                miniAppInfo.whiteList = new ArrayList();
                JSONArray optJSONArray = optJSONObject.optJSONArray("whiteLst");
                for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                    miniAppInfo.whiteList.add((String) optJSONArray.get(i3));
                }
            }
            if (optJSONObject.optJSONArray("blackLst") != null) {
                miniAppInfo.blackList = new ArrayList();
                JSONArray optJSONArray2 = optJSONObject.optJSONArray("blackLst");
                for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                    miniAppInfo.blackList.add((String) optJSONArray2.get(i16));
                }
            }
            if (optJSONObject.optJSONArray("secondApiRights") != null) {
                miniAppInfo.secondApiRightInfoList = new ArrayList();
                JSONArray optJSONArray3 = optJSONObject.optJSONArray("secondApiRights");
                for (int i17 = 0; i17 < optJSONArray3.length(); i17++) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray3.get(i17);
                    SecondApiRightInfo secondApiRightInfo = new SecondApiRightInfo();
                    secondApiRightInfo.apiName = jSONObject2.optString("apiName");
                    secondApiRightInfo.secondName = jSONObject2.optString("secondName");
                    secondApiRightInfo.right = jSONObject2.optInt("right");
                    miniAppInfo.secondApiRightInfoList.add(secondApiRightInfo);
                }
            }
        }
    }

    private void parseBasicInfo(INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo) {
        if (iNTERFACE$StAppBasicInfo != null) {
            QMLog.i("MiniAppInfo", "appid:" + this.appId + ", usrFileSizeLimit:" + iNTERFACE$StAppBasicInfo.usrFileSizeLimit.get());
            this.usrFileSizeLimit = iNTERFACE$StAppBasicInfo.usrFileSizeLimit.get();
            PBRepeatMessageField<INTERFACE$StAppPreCacheInfo> pBRepeatMessageField = iNTERFACE$StAppBasicInfo.preCacheList;
            if (pBRepeatMessageField != null) {
                List<INTERFACE$StAppPreCacheInfo> list = pBRepeatMessageField.get();
                if (list.size() > 0) {
                    this.preCacheList = new ArrayList<>();
                    for (INTERFACE$StAppPreCacheInfo iNTERFACE$StAppPreCacheInfo : list) {
                        this.preCacheList.add(new PreCacheInfo(iNTERFACE$StAppPreCacheInfo.getDataUrl.get(), iNTERFACE$StAppPreCacheInfo.preCacheKey.get(), iNTERFACE$StAppPreCacheInfo.expireTime.get()));
                    }
                }
            }
            PBRepeatMessageField<INTERFACE$StResourcePreCacheInfo> pBRepeatMessageField2 = iNTERFACE$StAppBasicInfo.resourcePreCacheList;
            if (pBRepeatMessageField2 != null) {
                List<INTERFACE$StResourcePreCacheInfo> list2 = pBRepeatMessageField2.get();
                if (list2.size() > 0) {
                    this.resourcePreCacheInfo = new ArrayList<>();
                    Iterator<INTERFACE$StResourcePreCacheInfo> it = list2.iterator();
                    while (it.hasNext()) {
                        this.resourcePreCacheInfo.add(new ResourcePreCacheInfo(it.next().getDataUrl.get()));
                    }
                }
            }
            this.versionUpdateTime = iNTERFACE$StAppBasicInfo.versionUpdateTime.get();
            boolean z16 = false;
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
            PBRepeatField<String> pBRepeatField = iNTERFACE$StAppBasicInfo.qualificationInfo;
            if (pBRepeatField != null) {
                this.qualifications = new ArrayList<>(pBRepeatField.get());
            }
            PBStringField pBStringField = iNTERFACE$StAppBasicInfo.gameCopyrightInfo;
            if (pBStringField != null) {
                this.gameCopyrightInfo = pBStringField.get();
            }
            INTERFACE$StGamePublicationInfo iNTERFACE$StGamePublicationInfo = iNTERFACE$StAppBasicInfo.gamePublicationInfo;
            if (iNTERFACE$StGamePublicationInfo != null) {
                PBStringField pBStringField2 = iNTERFACE$StGamePublicationInfo.gamePublicationNumber;
                if (pBStringField2 != null) {
                    this.gamePublicationNumber = pBStringField2.get();
                }
                PBStringField pBStringField3 = iNTERFACE$StAppBasicInfo.gamePublicationInfo.gamePublicationCommpany;
                if (pBStringField3 != null) {
                    this.gamePublicationCompany = pBStringField3.get();
                }
                PBStringField pBStringField4 = iNTERFACE$StAppBasicInfo.gamePublicationInfo.gameApprovalNumber;
                if (pBStringField4 != null) {
                    this.gameApprovalNumber = pBStringField4.get();
                }
                PBStringField pBStringField5 = iNTERFACE$StAppBasicInfo.gamePublicationInfo.gameOperatingCompany;
                if (pBStringField5 != null) {
                    this.gameOperatingCompany = pBStringField5.get();
                }
            }
            this.shareId = iNTERFACE$StAppBasicInfo.shareId.get();
            this.via = iNTERFACE$StAppBasicInfo.via.get();
            if (iNTERFACE$StAppBasicInfo.splashScreenAd.get() == 1) {
                z16 = true;
            }
            this.enableLoadingAd = z16;
        }
    }

    private void parseDebugInfo(INTERFACE$StMDebugInfo iNTERFACE$StMDebugInfo) {
        if (iNTERFACE$StMDebugInfo != null && !TextUtils.isEmpty(iNTERFACE$StMDebugInfo.roomId.get()) && !TextUtils.isEmpty(iNTERFACE$StMDebugInfo.wsUrl.get())) {
            DebugInfo debugInfo = new DebugInfo();
            this.debugInfo = debugInfo;
            debugInfo.roomId = iNTERFACE$StMDebugInfo.roomId.get();
            this.debugInfo.wsUrl = iNTERFACE$StMDebugInfo.wsUrl.get();
        }
    }

    private void parseDomainConfig(INTERFACE$StDomainConfig iNTERFACE$StDomainConfig) {
        if (iNTERFACE$StDomainConfig != null) {
            if (iNTERFACE$StDomainConfig.requestDomain.get() != null) {
                ArrayList arrayList = new ArrayList();
                this.requestDomainList = arrayList;
                arrayList.addAll(iNTERFACE$StDomainConfig.requestDomain.get());
            }
            if (iNTERFACE$StDomainConfig.socketDomain.get() != null) {
                ArrayList arrayList2 = new ArrayList();
                this.socketDomainList = arrayList2;
                arrayList2.addAll(iNTERFACE$StDomainConfig.socketDomain.get());
            }
            if (iNTERFACE$StDomainConfig.uploadFileDomain.get() != null) {
                ArrayList arrayList3 = new ArrayList();
                this.uploadFileDomainList = arrayList3;
                arrayList3.addAll(iNTERFACE$StDomainConfig.uploadFileDomain.get());
            }
            if (iNTERFACE$StDomainConfig.downloadFileDomain.get() != null) {
                ArrayList arrayList4 = new ArrayList();
                this.downloadFileDomainList = arrayList4;
                arrayList4.addAll(iNTERFACE$StDomainConfig.downloadFileDomain.get());
            }
            if (iNTERFACE$StDomainConfig.businessDomain.get() != null) {
                ArrayList arrayList5 = new ArrayList();
                this.businessDomainList = arrayList5;
                arrayList5.addAll(iNTERFACE$StDomainConfig.businessDomain.get());
            }
            if (iNTERFACE$StDomainConfig.udpIpList.get() != null) {
                this.udpIpList.addAll(iNTERFACE$StDomainConfig.udpIpList.get());
            }
        }
    }

    private static void parseDomainInfo(MiniAppInfo miniAppInfo, JSONObject jSONObject) throws JSONException {
        if (jSONObject.optJSONObject("domain") != null) {
            if (jSONObject.optJSONObject("domain").optJSONArray("requestDomain") != null) {
                miniAppInfo.requestDomainList = new ArrayList();
                JSONArray jSONArray = jSONObject.getJSONObject("domain").getJSONArray("requestDomain");
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    miniAppInfo.requestDomainList.add(jSONArray.optString(i3));
                }
            }
            if (jSONObject.optJSONObject("domain").optJSONArray("socketDomain") != null) {
                miniAppInfo.socketDomainList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONObject("domain").optJSONArray("socketDomain");
                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                    miniAppInfo.socketDomainList.add(optJSONArray.optString(i16));
                }
            }
            if (jSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain") != null) {
                miniAppInfo.uploadFileDomainList = new ArrayList();
                JSONArray optJSONArray2 = jSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain");
                for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                    miniAppInfo.uploadFileDomainList.add(optJSONArray2.optString(i17));
                }
            }
            if (jSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain") != null) {
                miniAppInfo.downloadFileDomainList = new ArrayList();
                JSONArray optJSONArray3 = jSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain");
                for (int i18 = 0; i18 < optJSONArray3.length(); i18++) {
                    miniAppInfo.downloadFileDomainList.add(optJSONArray3.getString(i18));
                }
            }
            if (jSONObject.optJSONObject("domain").optJSONArray("businessDomain") != null) {
                miniAppInfo.businessDomainList = new ArrayList();
                JSONArray optJSONArray4 = jSONObject.optJSONObject("domain").optJSONArray("businessDomain");
                for (int i19 = 0; i19 < optJSONArray4.length(); i19++) {
                    miniAppInfo.businessDomainList.add(optJSONArray4.getString(i19));
                }
            }
            if (jSONObject.optJSONObject("domain").optJSONArray("udpIpList") != null) {
                miniAppInfo.udpIpList = new ArrayList();
                JSONArray optJSONArray5 = jSONObject.optJSONObject("domain").optJSONArray("udpIpList");
                for (int i26 = 0; i26 < optJSONArray5.length(); i26++) {
                    miniAppInfo.udpIpList.add(optJSONArray5.getString(i26));
                }
            }
        }
    }

    public static final String parseExtInfo(COMM.StCommonExt stCommonExt) {
        JSONObject jSONObject = new JSONObject();
        if (stCommonExt != null) {
            try {
                if (stCommonExt.mapInfo != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (int i3 = 0; i3 < stCommonExt.mapInfo.size(); i3++) {
                        COMM.Entry entry = stCommonExt.mapInfo.get(i3);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("key", entry.key.get());
                        jSONObject2.put("value", entry.value.get());
                        jSONArray.put(i3, jSONObject2);
                    }
                    jSONObject.put(ThirdPartyMiniApiImpl.KEY_MAP_INFO, jSONArray);
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return jSONObject.toString();
    }

    private static MiniGamePluginInfo parseMiniGamePluginInfo(JSONObject jSONObject) {
        if (jSONObject == null) {
            QMLog.i("MiniAppInfo", "No MiniGamePluginInfo");
            return null;
        }
        return new MiniGamePluginInfo(jSONObject.optString("pluginName"), jSONObject.optString("pluginId"), jSONObject.optString("version"), jSONObject.optString("url"), jSONObject.optInt("fileSize"));
    }

    private void parseSubPkgInfo(List<INTERFACE$StSubPkgInfo> list) {
        if (list != null) {
            this.subpkgs = new ArrayList();
            for (INTERFACE$StSubPkgInfo iNTERFACE$StSubPkgInfo : list) {
                if (iNTERFACE$StSubPkgInfo != null) {
                    SubPkgInfo subPkgInfo = new SubPkgInfo();
                    subPkgInfo.subPkgName = iNTERFACE$StSubPkgInfo.subPkgName.get();
                    subPkgInfo.downloadUrl = iNTERFACE$StSubPkgInfo.dowLoadUrl.get();
                    subPkgInfo.independent = iNTERFACE$StSubPkgInfo.independent.get();
                    subPkgInfo.fileSize = iNTERFACE$StSubPkgInfo.file_size.get();
                    subPkgInfo.version = iNTERFACE$StSubPkgInfo.version.get();
                    subPkgInfo.versionId = iNTERFACE$StSubPkgInfo.versionId.get();
                    subPkgInfo.mainPackVersion = iNTERFACE$StSubPkgInfo.mainPackVersion.get();
                    subPkgInfo.subVersionType = iNTERFACE$StSubPkgInfo.version_type.get();
                    subPkgInfo.preFetchConfig = iNTERFACE$StSubPkgInfo.prefetch_config.get();
                    this.subpkgs.add(subPkgInfo);
                }
            }
        }
    }

    private static List<SubPkgInfo> parseSubpkgs(JSONObject jSONObject) throws JSONException {
        ArrayList arrayList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("subPkgs");
        if (optJSONArray != null) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                JSONObject jSONObject2 = (JSONObject) optJSONArray.get(i3);
                SubPkgInfo subPkgInfo = new SubPkgInfo();
                subPkgInfo.subPkgName = jSONObject2.optString("subPkgName");
                subPkgInfo.downloadUrl = jSONObject2.optString("dowLoadUrl");
                subPkgInfo.independent = jSONObject2.optInt("independent");
                subPkgInfo.fileSize = jSONObject2.optInt("file_size");
                subPkgInfo.version = jSONObject2.optString("version");
                subPkgInfo.versionId = jSONObject2.optString("versionId");
                arrayList.add(subPkgInfo);
            }
        }
        return arrayList;
    }

    public static INTERFACE$StApiAppInfo pbFromJSON(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        if (jSONObject == null) {
            return null;
        }
        INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo = new INTERFACE$StApiAppInfo();
        iNTERFACE$StApiAppInfo.appId.set(jSONObject.optString("appId"));
        iNTERFACE$StApiAppInfo.appName.set(jSONObject.optString("appName"));
        iNTERFACE$StApiAppInfo.icon.set(jSONObject.optString("icon"));
        iNTERFACE$StApiAppInfo.donwLoadUrl.set(jSONObject.optString("donwLoadUrl"));
        iNTERFACE$StApiAppInfo.version.set(jSONObject.optString("version"));
        iNTERFACE$StApiAppInfo.desc.set(jSONObject.optString("desc"));
        iNTERFACE$StApiAppInfo.type.set(jSONObject.optInt("type"));
        iNTERFACE$StApiAppInfo.baselibMiniVersion.set(jSONObject.optString("baselibMiniVersion"));
        iNTERFACE$StApiAppInfo.subPkgs.set(getSubPkgsPb(jSONObject));
        iNTERFACE$StApiAppInfo.first.set(getFirstPb(jSONObject));
        iNTERFACE$StApiAppInfo.domain.set(getDomain(jSONObject));
        iNTERFACE$StApiAppInfo.appType.set(jSONObject.optInt("appType"));
        iNTERFACE$StApiAppInfo.mDebug.set(getDebugPb(jSONObject));
        iNTERFACE$StApiAppInfo.versionId.set(jSONObject.optString("versionId"));
        iNTERFACE$StApiAppInfo.apiRight.set(getApiRight(jSONObject));
        iNTERFACE$StApiAppInfo.appJson.set(jSONObject.optString("appJson"));
        iNTERFACE$StApiAppInfo.isContainer.set(jSONObject.optInt("isContainer"));
        iNTERFACE$StApiAppInfo.auditState.set(jSONObject.optInt("auditState"));
        iNTERFACE$StApiAppInfo.releaseState.set(jSONObject.optInt("releaseState"));
        iNTERFACE$StApiAppInfo.registrationInfo.set(getRegistrationInfoPb(jSONObject));
        if (jSONObject.optJSONObject("mainExt") != null) {
            INTERFACE$StMainPageExtInfo iNTERFACE$StMainPageExtInfo = new INTERFACE$StMainPageExtInfo();
            iNTERFACE$StMainPageExtInfo.file_size.set(jSONObject.optJSONObject("mainExt").optInt("file_size"));
            iNTERFACE$StApiAppInfo.mainExt.set(iNTERFACE$StMainPageExtInfo);
        }
        if (jSONObject.optJSONObject("extInfo") != null) {
            try {
                iNTERFACE$StApiAppInfo.extInfo.set(getExtInfo(jSONObject));
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        if (jSONObject.optJSONObject("devInfo") != null) {
            INTERFACE$StDeveloperInfo iNTERFACE$StDeveloperInfo = new INTERFACE$StDeveloperInfo();
            iNTERFACE$StDeveloperInfo.name.set(jSONObject.optJSONObject("devInfo").optString("name"));
            iNTERFACE$StApiAppInfo.devInfo.set(iNTERFACE$StDeveloperInfo);
        }
        if (jSONObject.optJSONObject("basicInfo") != null && (optJSONObject2 = jSONObject.optJSONObject("basicInfo")) != null) {
            INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo = new INTERFACE$StAppBasicInfo();
            iNTERFACE$StAppBasicInfo.usrFileSizeLimit.set(optJSONObject2.optInt("usrFileSizeLimit"));
            iNTERFACE$StAppBasicInfo.versionUpdateTime.set(optJSONObject2.optInt("versionUpdateTime"));
            iNTERFACE$StAppBasicInfo.noNeedRealRecommend.set(optJSONObject2.optInt("noNeedRealRecommend"));
            iNTERFACE$StAppBasicInfo.splashScreenAd.set(optJSONObject2.optInt("splashScreenAd"));
            if (optJSONObject2.has("pkgType")) {
                iNTERFACE$StAppBasicInfo.pkgType.set(optJSONObject2.optInt("pkgType"));
            }
            iNTERFACE$StAppBasicInfo.gameCopyrightInfo.set(optJSONObject2.optString("gameCopyrightInfo"));
            if (optJSONObject2.has("gamePublicationInfo")) {
                iNTERFACE$StAppBasicInfo.gamePublicationInfo.gamePublicationNumber.set(optJSONObject2.optString("gamePublicationNumber"));
                iNTERFACE$StAppBasicInfo.gamePublicationInfo.gamePublicationCommpany.set(optJSONObject2.optString("gamePublicationCompany"));
                iNTERFACE$StAppBasicInfo.gamePublicationInfo.gameApprovalNumber.set(optJSONObject2.optString("gameApprovalNumber"));
                iNTERFACE$StAppBasicInfo.gamePublicationInfo.gameOperatingCompany.set(optJSONObject2.optString("gameOperatingCompany"));
                iNTERFACE$StAppBasicInfo.gamePublicationInfo.setHasFlag(true);
            }
            iNTERFACE$StAppBasicInfo.pluginInfo.set(MiniGamePluginInfo.toProtocol(parseMiniGamePluginInfo(optJSONObject2.optJSONObject("pluginInfo"))));
            iNTERFACE$StApiAppInfo.basicInfo.set(iNTERFACE$StAppBasicInfo);
        }
        if (jSONObject.optJSONObject("appMode") != null && (optJSONObject = jSONObject.optJSONObject("appMode")) != null) {
            INTERFACE$StAppMode iNTERFACE$StAppMode = new INTERFACE$StAppMode();
            iNTERFACE$StAppMode.interMode.set(optJSONObject.optBoolean("interMode"));
            iNTERFACE$StAppMode.authoritySilent.set(optJSONObject.optBoolean("authoritySilent"));
            iNTERFACE$StAppMode.keepOffPullList.set(optJSONObject.optBoolean("keepOffPullList"));
            iNTERFACE$StAppMode.closeTopRightCapsule.set(optJSONObject.optBoolean("closeTopRightCapsule"));
            iNTERFACE$StAppMode.openNativeApi.set(optJSONObject.optBoolean("openNativeApi"));
            iNTERFACE$StAppMode.hideAppSearch.set(optJSONObject.optBoolean("hideAppSearch"));
            iNTERFACE$StAppMode.isAppStore.set(optJSONObject.optBoolean("isAppStore"));
            iNTERFACE$StAppMode.isWangKa.set(optJSONObject.optBoolean("isWangKa"));
            iNTERFACE$StAppMode.interLoading.set(optJSONObject.optBoolean("interLoading"));
            iNTERFACE$StAppMode.isLimitedAccess.set(optJSONObject.optBoolean("isLimitedAccess"));
            iNTERFACE$StAppMode.isPayForFriend.set(optJSONObject.optBoolean("isPayForFriend"));
            iNTERFACE$StAppMode.useAppInfoWhenNavigate.set(optJSONObject.optBoolean("useAppInfoWhenNavigate"));
            iNTERFACE$StAppMode.disableAddToMyApp.set(optJSONObject.optBoolean(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYAPP));
            iNTERFACE$StAppMode.disableAddToMyFavor.set(optJSONObject.optBoolean(MiniChatConstants.MINI_APP_DISABLE_ADD_TO_MYFAVOR));
            iNTERFACE$StAppMode.reloadWithFirstPageChange.set(optJSONObject.optBoolean("reloadWithFirstPageChange"));
            iNTERFACE$StAppMode.unlimitedApiRight.set(optJSONObject.optBoolean("unlimitedApiRight"));
            iNTERFACE$StAppMode.disableShareToAIO.set(optJSONObject.optBoolean("disableShareToAIO"));
            iNTERFACE$StAppMode.disableShareToQZone.set(optJSONObject.optBoolean("disableShareToQZone"));
            iNTERFACE$StAppMode.disableShareToWeChat.set(optJSONObject.optBoolean("disableShareToWeChat"));
            iNTERFACE$StApiAppInfo.appMode.set(iNTERFACE$StAppMode);
        }
        return iNTERFACE$StApiAppInfo;
    }

    public static void saveMiniAppShowInfoEntity(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
    }

    private void setBaseLibInfo(Parcel parcel) {
        try {
            this.baseLibInfo = (BaseLibInfo) parcel.readParcelable(BaseLibInfo.class.getClassLoader());
        } catch (BadParcelableException e16) {
            BaseLibInfo baseLibInfo = new BaseLibInfo();
            this.baseLibInfo = baseLibInfo;
            baseLibInfo.baseLibVersion = "1.74.3.00001";
            QMLog.e("MiniAppInfo", "setBaseLibInfo is BadParcelableException!", e16);
        }
    }

    private static void setBusinessDomain(JSONObject jSONObject, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig) {
        if (jSONObject.optJSONObject("domain").optJSONArray("businessDomain") != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONObject("domain").optJSONArray("businessDomain");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            iNTERFACE$StDomainConfig.businessDomain.set(arrayList);
        }
    }

    private static void setDownloadFileDomain(JSONObject jSONObject, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig) {
        if (jSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain") != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONObject("domain").optJSONArray("downloadFileDomain");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            iNTERFACE$StDomainConfig.downloadFileDomain.set(arrayList);
        }
    }

    private static void setRequestDomain(JSONObject jSONObject, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig) {
        if (jSONObject.optJSONObject("domain").optJSONArray("requestDomain") != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONObject("domain").optJSONArray("requestDomain");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            iNTERFACE$StDomainConfig.requestDomain.set(arrayList);
        }
    }

    private static void setSocketDomain(JSONObject jSONObject, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig) {
        if (jSONObject.optJSONObject("domain").optJSONArray("socketDomain") != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONObject("domain").optJSONArray("socketDomain");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            iNTERFACE$StDomainConfig.socketDomain.set(arrayList);
        }
    }

    private static void setUdpIpList(JSONObject jSONObject, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig) {
        if (jSONObject.optJSONObject("domain").optJSONArray("udpIpList") != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONObject("domain").optJSONArray("udpIpList");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            iNTERFACE$StDomainConfig.udpIpList.set(arrayList);
        }
    }

    private static void setUploadFileDomain(JSONObject jSONObject, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig) {
        if (jSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain") != null) {
            ArrayList arrayList = new ArrayList();
            JSONArray optJSONArray = jSONObject.optJSONObject("domain").optJSONArray("uploadFileDomain");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                arrayList.add(optJSONArray.optString(i3));
            }
            iNTERFACE$StDomainConfig.uploadFileDomain.set(arrayList);
        }
    }

    public boolean canDebug() {
        DebugInfo debugInfo = this.debugInfo;
        if (debugInfo != null && !TextUtils.isEmpty(debugInfo.roomId) && !TextUtils.isEmpty(this.debugInfo.wsUrl)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(MiniAppInfo miniAppInfo) {
        if (miniAppInfo == null) {
            return false;
        }
        if (!miniAppInfo.isShortcutFakeApp() && !miniAppInfo.isFakeAppInfo()) {
            if (isEngineTypeMiniGame()) {
                if (!equalObj(this.appId, miniAppInfo.appId) || !equalObj(Integer.valueOf(this.verType), Integer.valueOf(miniAppInfo.verType))) {
                    return false;
                }
                return true;
            }
            if (!equalObj(this.appId, miniAppInfo.appId) || !equalObj(Integer.valueOf(this.verType), Integer.valueOf(miniAppInfo.verType)) || !equalObj(this.version, miniAppInfo.version)) {
                return false;
            }
            return true;
        }
        return equalObj(this.appId, miniAppInfo.appId);
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo
    public int getEngineType() {
        return this.engineType;
    }

    public int getMaxListSize() {
        return getMaxSize(this.whiteList, this.extConfigInfoList, this.preCacheList, this.resourcePreCacheInfo, this.subpkgs, this.secondApiRightInfoList);
    }

    public int getReportType() {
        return this.reportType;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo
    public String getVerTypeStr() {
        int i3 = this.verType;
        if (i3 != 0 && i3 != 4) {
            if (i3 == 1) {
                return "trial";
            }
            return "release";
        }
        return "develop";
    }

    public boolean isAppStoreMiniApp() {
        AppMode appMode = this.appMode;
        if (appMode == null) {
            return false;
        }
        return appMode.isAppStore;
    }

    public boolean isContainerLoad() {
        return this.isLoadByContainer;
    }

    public boolean isFakeAppInfo() {
        return this.launchParam.isFakeAppInfo;
    }

    public boolean isLimitedAccessApp() {
        AppMode appMode = this.appMode;
        if (appMode != null && appMode.isLimitedAccess) {
            return true;
        }
        return false;
    }

    public boolean isReportTypeMiniApp() {
        if (this.reportType == 0) {
            return true;
        }
        return false;
    }

    public boolean isReportTypeMiniGame() {
        if (this.reportType == 1) {
            return true;
        }
        return false;
    }

    public boolean isShortcutFakeApp() {
        LaunchParam launchParam = this.launchParam;
        if (launchParam != null && launchParam.scene == 1023 && TextUtils.isEmpty(this.downloadUrl)) {
            return true;
        }
        return false;
    }

    public boolean isSpecialMiniApp() {
        if (isAppStoreMiniApp()) {
            return true;
        }
        return false;
    }

    public boolean isStartFromAppId() {
        if (this.launchParam.isFakeAppInfo && TextUtils.isEmpty(this.link) && !TextUtils.isEmpty(this.appId)) {
            return true;
        }
        return false;
    }

    public void setEngineType(int i3) {
        this.engineType = i3;
    }

    public void setIsLoadByContainer(boolean z16) {
        this.isLoadByContainer = z16;
    }

    public void setReportType(int i3) {
        this.reportType = i3;
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo
    public String simpleInfo() {
        return "[appId=" + this.appId + "]";
    }

    public String toDetailString() {
        return "MiniAppInfo {\n\tappId=" + this.appId + "\n\tversionId=" + this.versionId + "\n\tverType=" + this.verType + "\n\ticonUrl=" + this.iconUrl + "\n\tdownloadUrl=" + this.downloadUrl + "\n\twhiteList=" + this.whiteList + "\n\tblackList=" + this.blackList + "\n\tbaselibMiniVersion=" + this.baselibMiniVersion + "\n\tfirstPage=" + this.firstPage + "\n\tlaunchParam=" + this.launchParam + "\n\tvia=" + this.via + "\n\tenableLoadingAd=" + this.enableLoadingAd + "\n\tprepayId=" + this.prepayId + "\n}";
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo
    public String toString() {
        return simpleInfo();
    }

    @Override // com.tencent.qqmini.sdk.launcher.model.MiniAppBaseInfo, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        parcel.writeInt(this.topType);
        parcel.writeInt(this.reportType);
        parcel.writeString(this.extraData);
        parcel.writeInt(this.recommend);
        parcel.writeByte(this.isSupportOffline ? (byte) 1 : (byte) 0);
        parcel.writeString(this.openId);
        parcel.writeLong(this.tinyId);
        parcel.writeInt(this.position);
        parcel.writeByte(this.isSupportBlueBar ? (byte) 1 : (byte) 0);
        parcel.writeString(this.recommendAppIconUrl);
        parcel.writeString(this.extendData);
        parcel.writeInt(this.clearAuths);
        parcel.writeByteArray(this.commonExt);
        parcel.writeTypedList(this.extConfigInfoList);
        parcel.writeString(this.appStoreAnimPicUrl);
        parcel.writeStringList(this.motionPics);
        parcel.writeTypedList(this.preCacheList);
        parcel.writeParcelable(this.miniGamePluginInfo, 0);
        parcel.writeParcelable(this.launchParam, 0);
        parcel.writeParcelable(this.baseLibInfo, 0);
        parcel.writeInt(this.forceReroad);
        parcel.writeString(this.customInfo);
        parcel.writeTypedList(this.resourcePreCacheInfo);
        parcel.writeString(this.gameCopyrightInfo);
        parcel.writeString(this.gamePublicationNumber);
        parcel.writeString(this.gamePublicationCompany);
        parcel.writeString(this.gameApprovalNumber);
        parcel.writeString(this.gameOperatingCompany);
        parcel.writeString(this.extInfo);
        parcel.writeString(this.appJson);
        parcel.writeInt(this.isContainer);
        parcel.writeString(this.reportData);
        parcel.writeString(this.gameRegistrationNumber);
    }

    public static void saveMiniAppShowInfoEntity(MiniAppInfo miniAppInfo) {
    }

    protected MiniAppInfo(Parcel parcel) {
        super(parcel);
        LaunchParam launchParam = new LaunchParam();
        this.launchParam = launchParam;
        this.friendMessageQuery = "";
        this.appJson = "";
        this.isContainer = 0;
        this.forceReroad = 0;
        this.renderMode = -1;
        this.isLoadByContainer = false;
        this.topType = parcel.readInt();
        this.reportType = parcel.readInt();
        this.extraData = parcel.readString();
        this.recommend = parcel.readInt();
        this.isSupportOffline = parcel.readByte() != 0;
        this.openId = parcel.readString();
        this.tinyId = parcel.readLong();
        this.position = parcel.readInt();
        this.isSupportBlueBar = parcel.readByte() != 0;
        this.recommendAppIconUrl = parcel.readString();
        this.extendData = parcel.readString();
        this.clearAuths = parcel.readInt();
        this.commonExt = parcel.createByteArray();
        this.extConfigInfoList = parcel.createTypedArrayList(ExtConfigInfo.CREATOR);
        this.appStoreAnimPicUrl = parcel.readString();
        ArrayList<String> arrayList = new ArrayList<>();
        this.motionPics = arrayList;
        parcel.readStringList(arrayList);
        this.preCacheList = parcel.createTypedArrayList(PreCacheInfo.CREATOR);
        this.miniGamePluginInfo = (MiniGamePluginInfo) parcel.readParcelable(MiniGamePluginInfo.class.getClassLoader());
        launchParam.clone((LaunchParam) parcel.readParcelable(LaunchParam.class.getClassLoader()));
        setBaseLibInfo(parcel);
        this.forceReroad = parcel.readInt();
        this.customInfo = parcel.readString();
        this.resourcePreCacheInfo = parcel.createTypedArrayList(ResourcePreCacheInfo.CREATOR);
        this.gameCopyrightInfo = parcel.readString();
        this.gamePublicationNumber = parcel.readString();
        this.gamePublicationCompany = parcel.readString();
        this.gameApprovalNumber = parcel.readString();
        this.gameOperatingCompany = parcel.readString();
        this.extInfo = parcel.readString();
        this.appJson = parcel.readString();
        this.isContainer = parcel.readInt();
        this.reportData = parcel.readString();
        this.gameRegistrationNumber = parcel.readString();
    }

    public static void saveMiniAppInfoEntity(INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
    }

    public static void saveMiniAppByIdEntity(String str, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
    }

    MiniAppInfo(String str, String str2, String str3, String str4, int i3, int i16, int i17, String str5, String str6, String str7, long j3, List<INTERFACE$StSubPkgInfo> list, String str8, INTERFACE$StFirstPage iNTERFACE$StFirstPage, INTERFACE$StApiRightController iNTERFACE$StApiRightController, INTERFACE$StMDebugInfo iNTERFACE$StMDebugInfo, INTERFACE$StDomainConfig iNTERFACE$StDomainConfig, INTERFACE$StMainPageExtInfo iNTERFACE$StMainPageExtInfo, INTERFACE$StDeveloperInfo iNTERFACE$StDeveloperInfo, String str9, int i18, INTERFACE$StAppMode iNTERFACE$StAppMode, int i19, boolean z16, boolean z17, String str10, String str11, int i26, COMM.StCommonExt stCommonExt, List<INTERFACE$StExtConfigInfo> list2, INTERFACE$StAppBasicInfo iNTERFACE$StAppBasicInfo, INTERFACE$StOperationInfo iNTERFACE$StOperationInfo, INTERFACE$StIdeConfig iNTERFACE$StIdeConfig, COMM.StCommonExt stCommonExt2, int i27, int i28, INTERFACE$StRegistrationInfo iNTERFACE$StRegistrationInfo) {
        INTERFACE$StStartExtInfo iNTERFACE$StStartExtInfo;
        this.launchParam = new LaunchParam();
        this.friendMessageQuery = "";
        this.appJson = "";
        this.isContainer = 0;
        this.forceReroad = 0;
        this.renderMode = -1;
        this.isLoadByContainer = false;
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
        parseSubPkgInfo(list);
        if (iNTERFACE$StFirstPage != null) {
            FirstPageInfo firstPageInfo = new FirstPageInfo();
            this.firstPage = firstPageInfo;
            firstPageInfo.pagePath = iNTERFACE$StFirstPage.pagePath.get();
            this.firstPage.subPkgName = iNTERFACE$StFirstPage.subPkgName.get();
        }
        parseApiRightController(iNTERFACE$StApiRightController);
        parseDebugInfo(iNTERFACE$StMDebugInfo);
        parseDomainConfig(iNTERFACE$StDomainConfig);
        if (iNTERFACE$StMainPageExtInfo != null) {
            this.fileSize = iNTERFACE$StMainPageExtInfo.file_size.get();
        }
        if (iNTERFACE$StDeveloperInfo != null) {
            this.developerDesc = iNTERFACE$StDeveloperInfo.name.get();
        }
        this.extraData = str9;
        this.recommend = i18;
        this.reportData = this.reportData;
        this.appMode = AppMode.from(iNTERFACE$StAppMode);
        this.skipDomainCheck = i19;
        this.isSupportBlueBar = z16;
        this.isSupportOffline = z17;
        this.recommendAppIconUrl = str10;
        this.extendData = str11;
        this.clearAuths = i26;
        this.commonExt = stCommonExt.toByteArray();
        if (list2 != null) {
            this.extConfigInfoList = new ArrayList<>();
            Iterator<INTERFACE$StExtConfigInfo> it = list2.iterator();
            while (it.hasNext()) {
                this.extConfigInfoList.add(ExtConfigInfo.from(it.next()));
            }
        }
        parseBasicInfo(iNTERFACE$StAppBasicInfo);
        if (iNTERFACE$StOperationInfo != null) {
            this.reportData = iNTERFACE$StOperationInfo.reportData.get();
        }
        if (iNTERFACE$StIdeConfig != null && (iNTERFACE$StStartExtInfo = iNTERFACE$StIdeConfig.startExtInfo) != null) {
            this.deviceOrientation = iNTERFACE$StStartExtInfo.deviceOrientation.get();
            this.showStatusBar = iNTERFACE$StIdeConfig.startExtInfo.showStatusBar.get();
        }
        this.extInfo = parseExtInfo(stCommonExt2);
        this.auditState = i27;
        this.releaseState = i28;
        if (iNTERFACE$StRegistrationInfo != null) {
            this.gameRegistrationNumber = iNTERFACE$StRegistrationInfo.registrationNumber.get();
        }
    }

    public static void saveMiniAppByLinkEntity(String str, int i3, String str2, INTERFACE$StApiAppInfo iNTERFACE$StApiAppInfo) {
    }
}
