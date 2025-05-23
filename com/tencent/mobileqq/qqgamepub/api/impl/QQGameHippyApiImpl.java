package com.tencent.mobileqq.qqgamepub.api.impl;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.api.HippyConfig;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyLibrary;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.IUpdateListener;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.perf.memory.preload.PreloadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.fragment.GameCenterOfDynamicFragment;
import com.tencent.mobileqq.qqgamepub.hippy.module.QQGameWadlModule;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.Provider;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQCustomArkDialogUtil;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameHippyApiImpl implements IQQGameHippyApi {
    static IPatchRedirector $redirector_ = null;
    public static final String SWITCH_GAMECENTER_SSR_CONFIG = "gamecenter_ssr_config";
    private static final String TAG = "QQGamePub_QQGameHippyApiImpl";
    public static volatile boolean isGetHippysManagerConfig;
    public static volatile boolean isPreloadHippy;
    public static volatile boolean isReadyToPreloadHippy;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements IUpdateListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQGameHippyApiImpl.this);
            }
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateFailed(int i3, int i16, String str, String str2, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                QQGameHippyApiImpl.this.onUpdateGameCenterFinished();
            } else {
                iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), str, str2, hashMap);
            }
        }

        @Override // com.tencent.hippy.qq.api.IUpdateListener
        public void onUpdateSuccess(int i3, String str, HashMap<String, String> hashMap) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                QQGameHippyApiImpl.this.onUpdateGameCenterFinished();
            } else {
                iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), str, hashMap);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18963);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
            return;
        }
        isGetHippysManagerConfig = false;
        isReadyToPreloadHippy = false;
        isPreloadHippy = false;
    }

    public QQGameHippyApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private String appendUrlParams(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append(str);
        String str3 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
        if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            str3 = ContainerUtils.FIELD_DELIMITER;
        }
        sb5.append(str3);
        sb5.append(str2);
        return sb5.toString();
    }

    private void fillMsgInfo1(HippyMap hippyMap, QQGameMsgInfo qQGameMsgInfo) {
        if (hippyMap.containsKey("msgid")) {
            qQGameMsgInfo.paMsgid = hippyMap.getString("msgid");
        }
        if (hippyMap.containsKey(QQBrowserActivity.KEY_MSG_TYPE)) {
            qQGameMsgInfo.msgType = hippyMap.getInt(QQBrowserActivity.KEY_MSG_TYPE);
        }
        if (hippyMap.containsKey("gameAppId")) {
            qQGameMsgInfo.gameAppId = hippyMap.getString("gameAppId");
        }
        if (hippyMap.containsKey("msgTime")) {
            qQGameMsgInfo.msgTime = hippyMap.getLong("msgTime");
        }
        if (hippyMap.containsKey("\u00a0sorted_configs")) {
            qQGameMsgInfo.sortedConfigs = hippyMap.getString("\u00a0sorted_configs");
        }
        if (hippyMap.containsKey(WadlProxyConsts.EXT_JSON)) {
            qQGameMsgInfo.extJson = hippyMap.getString(WadlProxyConsts.EXT_JSON);
        }
        if (hippyMap.containsKey("icon")) {
            qQGameMsgInfo.icon = hippyMap.getString("icon");
        }
        if (hippyMap.containsKey("desc")) {
            qQGameMsgInfo.desc = hippyMap.getString("desc");
        }
        if (hippyMap.containsKey("frienduin")) {
            qQGameMsgInfo.frienduin = hippyMap.getString("frienduin");
        }
        if (hippyMap.containsKey("uniseq")) {
            qQGameMsgInfo.uniseq = hippyMap.getLong("uniseq");
        }
        if (hippyMap.containsKey("advId")) {
            qQGameMsgInfo.advId = hippyMap.getString("advId");
        }
        if (hippyMap.containsKey("triggerInfo")) {
            qQGameMsgInfo.triggerInfo = hippyMap.getString("triggerInfo");
        }
    }

    private void fillMsgInfo2(HippyMap hippyMap, QQGameMsgInfo qQGameMsgInfo) {
        if (hippyMap.containsKey("appName")) {
            qQGameMsgInfo.arkAppName = hippyMap.getString("appName");
        }
        if (hippyMap.containsKey(QQCustomArkDialogUtil.APP_VIEW)) {
            qQGameMsgInfo.arkAppView = hippyMap.getString(QQCustomArkDialogUtil.APP_VIEW);
        }
        if (hippyMap.containsKey(QQCustomArkDialogUtil.APP_MIN_VERSION)) {
            qQGameMsgInfo.arkAppMinVersion = hippyMap.getString(QQCustomArkDialogUtil.APP_MIN_VERSION);
        }
        if (hippyMap.containsKey("appMetaList")) {
            qQGameMsgInfo.arkMetaList = hippyMap.getString("appMetaList");
        }
        if (hippyMap.containsKey("appConfig")) {
            qQGameMsgInfo.arkAppConfig = hippyMap.getString("appConfig");
        }
        if (hippyMap.containsKey("width")) {
            qQGameMsgInfo.arkWidth = hippyMap.getInt("width");
        }
        if (hippyMap.containsKey("height")) {
            qQGameMsgInfo.arkHeight = hippyMap.getInt("height");
        }
        if (hippyMap.containsKey("coverUrl")) {
            qQGameMsgInfo.coverUrl = hippyMap.getString("coverUrl");
        }
        if (hippyMap.containsKey("url")) {
            qQGameMsgInfo.url = hippyMap.getString("url");
        }
        if (hippyMap.containsKey("title")) {
            qQGameMsgInfo.title = hippyMap.getString("title");
        }
        if (hippyMap.containsKey("dateTitle")) {
            qQGameMsgInfo.dateTitle = hippyMap.getString("dateTitle");
        }
        if (hippyMap.containsKey("contentText")) {
            qQGameMsgInfo.contentText = hippyMap.getString("contentText");
        }
        if (hippyMap.containsKey("limitText")) {
            qQGameMsgInfo.limitText = hippyMap.getString("limitText");
        }
    }

    private IFeatureRuntimeService getFeatureService() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            return (IFeatureRuntimeService) peekAppRuntime.getRuntimeService(IFeatureRuntimeService.class, "all");
        }
        return null;
    }

    @NonNull
    private String getUrlParams(String str) {
        if (!TextUtils.isEmpty(str) && str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
            return str.substring(str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) + 1);
        }
        return "";
    }

    private void init() {
        IFeatureRuntimeService featureService = getFeatureService();
        if (featureService != null) {
            featureService.initSdk();
        }
    }

    private boolean isLowerO() {
        if (Build.VERSION.SDK_INT < 26) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ HippyNativeModuleBase lambda$putQQGameWadlModule$0(HippyEngineContext hippyEngineContext) {
        return new QQGameWadlModule(hippyEngineContext);
    }

    private void modifyOpenHippyInfo(String str, String str2, OpenHippyInfo openHippyInfo) {
        String urlParams = getUrlParams(str);
        String urlParams2 = getUrlParams(str2);
        JSONObject jSONObject = getJSONObject(SWITCH_GAMECENTER_SSR_CONFIG);
        if (jSONObject != null) {
            String optString = jSONObject.optString("url");
            if (!TextUtils.isEmpty(optString)) {
                openHippyInfo.url = appendUrlParams(optString, urlParams);
            }
            String optString2 = jSONObject.optString("ssrBundleUrl");
            if (!TextUtils.isEmpty(optString2)) {
                openHippyInfo.ssrBundleUrl = appendUrlParams(optString2, urlParams);
            }
            String optString3 = jSONObject.optString(OpenHippyInfo.EXTRA_KEY_ERROR_URL);
            if (!TextUtils.isEmpty(optString3)) {
                openHippyInfo.errorUrl = appendUrlParams(optString3, urlParams2);
            }
            int optInt = jSONObject.optInt(OpenHippyInfo.EXTRA_KEY_MIN_JS_BUNDLE_VERSION);
            if (optInt > 0) {
                openHippyInfo.minJsBundleVersion = optInt;
            }
            String optString4 = jSONObject.optString("domain");
            if (!TextUtils.isEmpty(optString4)) {
                openHippyInfo.domain = optString4;
            }
            String optString5 = jSONObject.optString("ssrBundleData");
            if (!TextUtils.isEmpty(optString5)) {
                openHippyInfo.ssrBundleData = optString5;
            }
        }
        QLog.i(TAG, 2, "[modifyOpenHippyInfo] data:" + jSONObject + ",url:" + openHippyInfo.url);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUpdateGameCenterFinished() {
        boolean z16;
        String str;
        String str2;
        HippyConfig hippyConfig = ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).getHippyConfig();
        if (((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getHippySwitch() && (hippyConfig.isGameCenterPreloadHippy() || hippyConfig.isGameCenterPredrawHippy())) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onGameCenterUpdateFinished isCanPreload:" + z16);
        }
        if (!z16) {
            return;
        }
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_GAME_CENTER;
        if (hippyConfig.isGameCenterLoadHippyInToolProcess()) {
            str = "tool";
        } else {
            str = "main";
        }
        openHippyInfo.processName = str;
        openHippyInfo.from = "gameDongTai";
        if (hippyConfig.isGameCenterPredrawHippy()) {
            openHippyInfo.preloadType = TabPreloadItem.PreloadType.PRE_DRAW;
        } else if (hippyConfig.isGameCenterPreloadHippy()) {
            openHippyInfo.preloadType = TabPreloadItem.PreloadType.PRE_LOAD;
        }
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(openHippyInfo);
        if (hippyConfig.isGameCenterLoadHippyInToolProcess()) {
            str2 = "com.tencent.mobileqq:tool";
        } else {
            str2 = "com.tencent.mobileqq";
        }
        PreloadManager.f257781a.a(PreloadManager.PreloadEntry.GameCenterLeba.name(), str2);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public int canOpenHippyByModuleName(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str)).intValue();
        }
        if (HippyQQConstants.ModuleName.QQ_GAME_CENTER.equals(str) && !((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getHippySwitch()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "canOpenHippyByModuleName " + str + " not allow");
                return -1;
            }
            return -1;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public Class<? extends QPublicBaseFragment> getGameCenterHippyClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (Class) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        return GameCenterOfDynamicFragment.class;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public String getGamePaHippyModuleName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAMEPLAT_GAME_PUB_HIPPY).optString("bundleName", HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNTV3);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public int getHippyReportState(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).intValue();
        }
        if (((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str) <= 0) {
            return -2;
        }
        if (!((IHippyLibrary) QRoute.api(IHippyLibrary.class)).isLibraryExists()) {
            return -3;
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public JSONObject getJSONObject(String str) {
        IFeatureRuntimeService featureService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (JSONObject) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str);
        }
        if (!isFeatureSwitch(str) || (featureService = getFeatureService()) == null) {
            return null;
        }
        return featureService.getJSONObject(str, null);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public JSONObject getJsInitData(Activity activity, @android.support.annotation.NonNull com.tencent.mobileqq.qqgamepub.data.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (JSONObject) iPatchRedirector.redirect((short) 15, (Object) this, (Object) activity, (Object) dVar);
        }
        return com.tencent.mobileqq.qqgamepub.utils.a.e(activity, dVar);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public QQGameMsgInfo getMsgInfoByHippyMap(HippyMap hippyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (QQGameMsgInfo) iPatchRedirector.redirect((short) 12, (Object) this, (Object) hippyMap);
        }
        QQGameMsgInfo qQGameMsgInfo = new QQGameMsgInfo();
        if (hippyMap != null) {
            fillMsgInfo1(hippyMap, qQGameMsgInfo);
            fillMsgInfo2(hippyMap, qQGameMsgInfo);
        }
        return qQGameMsgInfo;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public int getMsgPosByHippyMap(HippyMap hippyMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) hippyMap)).intValue();
        }
        if (hippyMap != null && hippyMap.containsKey(com.tencent.luggage.wxa.c8.c.G)) {
            return hippyMap.getInt(com.tencent.luggage.wxa.c8.c.G);
        }
        return 0;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public HippyAPIProvider getQQGameHippyAPIProvider(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (HippyAPIProvider) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str);
        }
        return new com.tencent.mobileqq.qqgamepub.hippy.module.c(str);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public boolean isCanPreloadByTab(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) str)).booleanValue();
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof AppInterface) && isFollowGamePubAccount((AppInterface) peekAppRuntime)) {
            boolean isGamePubHippySwitch = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isGamePubHippySwitch();
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "[isCanPreloadByTab]" + isGamePubHippySwitch);
            }
            return isGamePubHippySwitch;
        }
        QLog.i(TAG, 2, "[isCanPreloadByTab] is not follow");
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public boolean isFeatureSwitch(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) ? isFeatureSwitch(str, false) : ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this, (Object) str)).booleanValue();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public boolean isFollowGamePubAccount(AppInterface appInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) appInterface)).booleanValue();
        }
        IPublicAccountDetail findAccountDetailInfoCache = ((IPublicAccountDataManager) appInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findAccountDetailInfoCache("2747277822");
        if (findAccountDetailInfoCache == null || findAccountDetailInfoCache.getFollowType() != 1) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public boolean isGameCenterBundle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.startsWith(HippyQQConstants.ModuleName.QQ_GAME_CENTER)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public boolean isQQGameCenterBundle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && (str.startsWith(HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNT) || str.startsWith(HippyQQConstants.ModuleName.QQ_GAME_CENTER))) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public boolean isQQGamePubHippyBundle(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (!TextUtils.isEmpty(str) && str.startsWith(HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNT)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public void openQQGameCenterByHippy(Context context, String str, String str2) {
        String str3;
        String str4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, context, str, str2);
            return;
        }
        if (str != null) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            String str5 = QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER;
            if (str.contains(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER)) {
                str5 = ContainerUtils.FIELD_DELIMITER;
            }
            sb5.append(str5);
            sb5.append("forceHtml=true");
            str3 = sb5.toString();
        } else {
            str3 = null;
        }
        HippyConfig hippyConfig = ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).getHippyConfig();
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        if (IQQGameHippyApi.OPEN_MESSAGE_PAGE_FROM_GAME_MSG_VIEW.equals(str2)) {
            openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_GAME_CENTER_MESSAGE;
        } else {
            openHippyInfo.bundleName = HippyQQConstants.ModuleName.QQ_GAME_CENTER;
        }
        openHippyInfo.url = str;
        openHippyInfo.errorUrl = str3;
        openHippyInfo.isAnimated = true;
        openHippyInfo.isStatusBarDarkFont = true;
        openHippyInfo.isEnbaleRightFling = true;
        openHippyInfo.isCustomNightMode = true;
        openHippyInfo.from = str2;
        openHippyInfo.updateJsBundleType = 1;
        if (hippyConfig.isGameCenterLoadHippyInToolProcess()) {
            str4 = "tool";
        } else {
            str4 = "main";
        }
        openHippyInfo.processName = str4;
        openHippyInfo.isPreloadWhenClosed = hippyConfig.isGameCenterPreloadHippy();
        openHippyInfo.isPredrawWhenClosed = hippyConfig.isGameCenterPredrawHippy();
        if (TabPreloadItem.TAB_NAME_DYNAMIC.equals(str2)) {
            openHippyInfo.fragmentClass = GameCenterOfDynamicFragment.class;
            openHippyInfo.entranceShowTime = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).getDynamicTabShowTime();
            modifyOpenHippyInfo(str, str3, openHippyInfo);
        }
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).openHippyPage(context, openHippyInfo);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public void preloadQQGameCenterByHippy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        boolean hippySwitch = ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).getHippySwitch();
        boolean isGameCenterPreloadByTab = ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).isGameCenterPreloadByTab();
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "preloadQQGameCenterByHippy isHippySwitchOpened:" + hippySwitch + " isPreloadByTab:" + isGameCenterPreloadByTab);
        }
        if (hippySwitch && !isGameCenterPreloadByTab) {
            HippyConfig hippyConfig = ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).getHippyConfig();
            if (!hippyConfig.isGameCenterPreloadHippy() && !hippyConfig.isGameCenterPredrawHippy()) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("reportFrom", "gameDongTai");
            ((IHippyUpdate) QRoute.api(IHippyUpdate.class)).updateJsBundle(HippyQQConstants.ModuleName.QQ_GAME_CENTER, ((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isUpdateHippyJsBundleByHttp(), 3, bundle, new a());
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public void putQQGameWadlModule(@android.support.annotation.NonNull final HippyEngineContext hippyEngineContext, @android.support.annotation.NonNull Map<Class<? extends HippyNativeModuleBase>, Provider<? extends HippyNativeModuleBase>> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) hippyEngineContext, (Object) map);
        } else {
            map.put(QQGameWadlModule.class, new Provider() { // from class: com.tencent.mobileqq.qqgamepub.api.impl.j
                @Override // com.tencent.mtt.hippy.common.Provider
                public final Object get() {
                    HippyNativeModuleBase lambda$putQQGameWadlModule$0;
                    lambda$putQQGameWadlModule$0 = QQGameHippyApiImpl.lambda$putQQGameWadlModule$0(HippyEngineContext.this);
                    return lambda$putQQGameWadlModule$0;
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public void setReadyToPreloadHippy(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            isReadyToPreloadHippy = z16;
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi
    public boolean isFeatureSwitch(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, str, Boolean.valueOf(z16))).booleanValue();
        }
        init();
        IFeatureRuntimeService featureService = getFeatureService();
        if (featureService != null) {
            return featureService.isFeatureSwitchEnable(str, z16);
        }
        return false;
    }
}
