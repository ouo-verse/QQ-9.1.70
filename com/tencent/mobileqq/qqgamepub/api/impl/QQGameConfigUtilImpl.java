package com.tencent.mobileqq.qqgamepub.api.impl;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.obj.HippyResConfigBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.comm.api.IGameCenterUnitedConfigApi;
import com.tencent.mobileqq.zplan.scheme.ISchemeApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.URLUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QQGameConfigUtilImpl implements IQQGameConfigUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String DEBUG_FEED_URL = "https://hao.gamecenter.qq.com/sgame-official-account";
    private static final String KEY_PRELOAD_KUIKLY_BUNDLE_LIST = "PreloadBundleList";
    private static final String TAG = "QQGamePub_QQGameConfigUtilImpl";
    public static List<String> sFloadWindowShowedGames;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            sFloadWindowShowedGames = new ArrayList(3);
        }
    }

    public QQGameConfigUtilImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NonNull
    private static JSONObject getGameMallConfigBean() {
        return (JSONObject) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_MALL_HIPPY, new JSONObject());
    }

    @NonNull
    private static HippyResConfigBean getHippyResConfigBean() {
        return (HippyResConfigBean) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.HIPPP_ANDROID_RES, new HippyResConfigBean());
    }

    @NonNull
    private static com.tencent.mobileqq.qqgamepub.config.d getPushConfigBean() {
        return (com.tencent.mobileqq.qqgamepub.config.d) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_TIANSHU_PUSH_REQ, new com.tencent.mobileqq.qqgamepub.config.d());
    }

    @NonNull
    private static com.tencent.mobileqq.qqgamepub.config.b getQqGameH5ConfigBean() {
        return (com.tencent.mobileqq.qqgamepub.config.b) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_PUB_H5_CONFIG, new com.tencent.mobileqq.qqgamepub.config.b());
    }

    public static boolean isFold() {
        if (PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean canShowFloatWindow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str)).booleanValue();
        }
        if (sFloadWindowShowedGames == null) {
            sFloadWindowShowedGames = new ArrayList(3);
        }
        if (sFloadWindowShowedGames.size() < 3 && !sFloadWindowShowedGames.contains(str)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean checkGamePubAccountConfig() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (!isPubFeedByWeb() && !((IQQGameConfigUtil) QRoute.api(IQQGameConfigUtil.class)).isGamePubHippySwitch()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            QLog.d(TAG, 1, "checkGamePubAccountConfig false,so enter aio gamepubaccount !!!!!");
        }
        return z16;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public String getFeedWebUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        String a16 = getQqGameH5ConfigBean().a();
        if (TextUtils.isEmpty(a16)) {
            return "";
        }
        return a16;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public String getGameMallBundleName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        JSONObject gameMallConfigBean = getGameMallConfigBean();
        if (!gameMallConfigBean.has("bundleName")) {
            QLog.e(TAG, 1, "startGameMallPubAccount no config");
            return null;
        }
        return gameMallConfigBean.optString("bundleName");
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public List<String> getGamePubPreloadKuilyBundleList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (List) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_PUB_ACCOUNT_PRELOAD_KUIKLY_BUNDLE_LIST);
        if (configJsonObj == null) {
            return arrayList;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "getGamePubPreloadKuilyBundleList config:", configJsonObj);
        }
        JSONArray optJSONArray = configJsonObj.optJSONArray(KEY_PRELOAD_KUIKLY_BUNDLE_LIST);
        if (optJSONArray != null && optJSONArray.length() > 0) {
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                String optString = optJSONArray.optString(i3);
                if (!TextUtils.isEmpty(optString)) {
                    arrayList.add(optString);
                }
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public String getGamePubUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        String b16 = getQqGameH5ConfigBean().b();
        if (TextUtils.isEmpty(b16) || TextUtils.isEmpty(b16) || (!b16.startsWith("http://") && !b16.startsWith("https://"))) {
            return "https://speed.gamecenter.qq.com/pushgame/v1/home/index?ADTAG=gzh&_wv=18950115&_wwv=393";
        }
        return b16;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public String getHippyBridgeSoName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        HippyResConfigBean hippyResConfigBean = getHippyResConfigBean();
        if (hippyResConfigBean.getHippyBridgeSoName() == null) {
            return null;
        }
        return hippyResConfigBean.getHippyBridgeSoName().trim();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean getHippySwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAMEPLAT_CENTER_HIPPY_SWITCH, true);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public int getPushMsgInterval() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, (Object) this)).intValue();
        }
        return Math.abs(getPushConfigBean().b());
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public String getSubscribePageUrl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this);
        }
        return "https://youxi.gamecenter.qq.com/ogame/game-subscribe-manager/index.html?_wwv=132&_fv=0&_wv=2";
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isCustomGameMallPubAccount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        if (getGameMallConfigBean().has("bundleName")) {
            return true;
        }
        QLog.e(TAG, 1, "startGameMallPubAccount no config");
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isFlutterPreLoad() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isGamePubHippySwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        return !TextUtils.isEmpty(((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGamePaHippyModuleName());
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isGamePubKuiklySwitch() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_PUB_ACCOUNT_ENTER_KUIKLY_CONFIG);
        if (configJsonObj == null) {
            QLog.i(TAG, 1, "[isGamePubKuiklySwitch] config is null.");
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "[isGamePubKuiklySwitch] config:" + configJsonObj.toString());
        }
        try {
            if (configJsonObj.optBoolean("toggle", false) && configJsonObj.has("pageName")) {
                if (configJsonObj.has(ISchemeApi.KEY_PAGE_DATA)) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isHippyUseAllInOneSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return getHippyResConfigBean().getIsHippyUseAllInOneSo();
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isInterceptMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Boolean) iPatchRedirector.redirect((short) 20, (Object) this, (Object) str)).booleanValue();
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ArrayList<String> a16 = ((com.tencent.mobileqq.qqgamepub.config.d) ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfig(IGameCenterUnitedConfigApi.GAMEPLAT_TIANSHU_PUSH_REQ, new com.tencent.mobileqq.qqgamepub.config.d())).a();
        if (a16.isEmpty()) {
            return false;
        }
        Iterator<String> it = a16.iterator();
        while (it.hasNext()) {
            if (str.equals(it.next())) {
                QLog.d(TAG, 1, "advId:" + str + " is intercept msg");
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isPubFeedByWeb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        com.tencent.mobileqq.qqgamepub.config.b qqGameH5ConfigBean = getQqGameH5ConfigBean();
        if (qqGameH5ConfigBean.c() != 1) {
            return false;
        }
        String a16 = qqGameH5ConfigBean.a();
        if (TextUtils.isEmpty(a16) || !URLUtil.isValidUrl(a16)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isPushMsgSwitchOn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (getPushConfigBean().c() == 1) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isTroopUnitedGameCard() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.TROOP_UNITED_GAME_CARD_SWITCH, true);
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean isUpdateHippyJsBundleByHttp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (getHippyResConfigBean().getHippyJsPluginType() == 2) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil
    public boolean openGameCenterByKuikly(Context context, String str, boolean z16) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, this, context, str, Boolean.valueOf(z16))).booleanValue();
        }
        JSONObject configJsonObj = ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).getConfigJsonObj(IGameCenterUnitedConfigApi.GAME_ENTER_PAGE);
        try {
            HashMap hashMap = new HashMap();
            if (configJsonObj != null && configJsonObj.has("pageName") && configJsonObj.has(ISchemeApi.KEY_PAGE_DATA)) {
                str2 = configJsonObj.optString("pageName");
                hashMap.putAll(KuiklyLaunchParams.INSTANCE.m(configJsonObj.optJSONObject(ISchemeApi.KEY_PAGE_DATA)));
            } else {
                QLog.d(TAG, 1, "[openGameCenterByKuikly] openKuikly: use default config");
                str2 = "QQGameCenterShell";
                hashMap.put("bundle_name", "gamecenter_shell");
                hashMap.put("ssr_page_name", "QQGameCenterRootPage");
                hashMap.put("ssr_bundle_name", "gamecenter");
            }
            hashMap.put("page_name", str2);
            hashMap.put("url", str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 1, "[openGameCenterByKuikly] openKuikly:" + hashMap);
            }
            if (z16 && isFold() && ((IGameCenterUnitedConfigApi) QRoute.api(IGameCenterUnitedConfigApi.class)).isSwitchOn(IGameCenterUnitedConfigApi.GAME_CENTER_IS_SUPPORT_SPLIT_MODE, false)) {
                Boolean bool = Boolean.TRUE;
                hashMap.put("is_support_split_mode", bool);
                hashMap.put("is_cover_split_page", Boolean.FALSE);
                hashMap.put("is_need_clear_other_fragment", bool);
                hashMap.put(KuiklyLaunchParams.PARAM_LAUNCH_MODE_ON_SPLIT_MODE, KuiklyLaunchParams.SPLIT_MODE_LAUNCH_MODE_SINGLE_TASK);
            }
            ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(context, nf2.a.b(hashMap));
            return true;
        } catch (Exception e16) {
            QLog.e(TAG, 1, "openGameCenterByKuikly e:", e16);
            return false;
        }
    }
}
