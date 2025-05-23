package com.tencent.hippy.qq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.biz.AuthorizeConfig;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.HippyPreloadListener;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.api.IHippyReportCache;
import com.tencent.hippy.qq.api.IHippySetting;
import com.tencent.hippy.qq.api.IHippyThread;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.fragment.CommonHippyFragment;
import com.tencent.hippy.qq.preload.PreloadPrivilegeManager;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.kandian.base.report.ReadInJoyMMapKvStorage;
import com.tencent.mobileqq.minigame.publicaccount.api.IMiniGamePublicAccountApi;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.pskey.api.IPskeyManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mtt.hippy.HippyRootView;
import com.tencent.open.base.http.HttpBaseUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.statemachine.MainStateManager;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import com.tencent.util.LiuHaiUtils;
import com.tencent.util.NumberUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAccessHelper {
    private static final String[] DOMAIN_WHITE_LIST;
    private static final long HALF_HOUR_IN_MILLIS = 1800000;
    public static final String TAG = "HippyAccessHelper";
    private static HashMap<String, Long> sModulesPredownloadTime = new HashMap<>();
    private static final Object sPreloadLock = new Object();
    private static HashMap<String, ArrayList<HippyQQPreloadEngine>> sPreloadEngines = new HashMap<>();
    private static HashMap<String, HippyQQPreloadEngine> sPreloadingEngines = new HashMap<>();
    private static HashMap<String, String> mNeedLoginStateInfoModules = new HashMap<>();
    private static HashMap<String, Class<? extends QPublicBaseFragment>> mModuleClassMap = new HashMap<>();

    static {
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_GAME_CENTER, "gamecenter.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_BOODO_COMIC, "vip.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_GAME_PUBLICACCOUNT, "SGameOfficial.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_VIP, "vip.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_PERSONALITY, "vip.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_BIG_CLUB, "qzone.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_MINI_GAME_PUBLICACCOUNT, "qzone.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_SHOP, "qianbao.qq.com");
        mNeedLoginStateInfoModules.put(HippyQQConstants.ModuleName.QQ_NEARBY_GAME, "yes.qq.com");
        mModuleClassMap.put(HippyQQConstants.ModuleName.QQ_MINI_GAME_PUBLICACCOUNT, ((IMiniGamePublicAccountApi) QRoute.api(IMiniGamePublicAccountApi.class)).getMiniGamePAHippyClass());
        mModuleClassMap.put(HippyQQConstants.ModuleName.QQ_GAME_CENTER, ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGameCenterHippyClass());
        mModuleClassMap.put(HippyQQConstants.ModuleName.QQ_GAME_CENTER_MESSAGE, ((IQQGameHippyApi) QRoute.api(IQQGameHippyApi.class)).getGameCenterHippyClass());
        DOMAIN_WHITE_LIST = new String[]{"*.qq.com", "*.tenpay.com"};
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0021 A[Catch: JSONException -> 0x0040, TryCatch #0 {JSONException -> 0x0040, blocks: (B:3:0x0001, B:5:0x0007, B:9:0x000f, B:11:0x0021, B:12:0x002b, B:14:0x0031), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0031 A[Catch: JSONException -> 0x0040, TRY_LEAVE, TryCatch #0 {JSONException -> 0x0040, blocks: (B:3:0x0001, B:5:0x0007, B:9:0x000f, B:11:0x0021, B:12:0x002b, B:14:0x0031), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void addPreloadParameters(JSONObject jSONObject, OpenHippyInfo openHippyInfo) {
        boolean z16;
        TabPreloadItem.PreloadType preloadType;
        try {
            TabPreloadItem.PreloadType preloadType2 = openHippyInfo.preloadType;
            if (preloadType2 != TabPreloadItem.PreloadType.PRE_DRAW && preloadType2 != TabPreloadItem.PreloadType.PRE_SNAPSHOT) {
                z16 = false;
                jSONObject.put("isPreload", true);
                jSONObject.put("isPredraw", z16);
                preloadType = openHippyInfo.preloadType;
                if (preloadType != TabPreloadItem.PreloadType.NO_PRELOAD) {
                    jSONObject.put(OpenHippyInfo.EXTRA_KEY_PRELOAD_TYPE, TabPreloadItem.preloadTypeToString(preloadType));
                }
                if (openHippyInfo.preloadType != TabPreloadItem.PreloadType.PRE_SNAPSHOT) {
                    jSONObject.put(TabPreloadItem.PRELOAD_TYPE_SNAPSHOT, true);
                    jSONObject.put(OpenHippyInfo.EXTRA_KEY_PRE_RENDER_TAG, openHippyInfo.preRenderTag);
                    return;
                }
                return;
            }
            z16 = true;
            jSONObject.put("isPreload", true);
            jSONObject.put("isPredraw", z16);
            preloadType = openHippyInfo.preloadType;
            if (preloadType != TabPreloadItem.PreloadType.NO_PRELOAD) {
            }
            if (openHippyInfo.preloadType != TabPreloadItem.PreloadType.PRE_SNAPSHOT) {
            }
        } catch (JSONException e16) {
            QLog.e("HippyAccessHelper", 1, "addPreloadParameters error:" + e16);
        }
    }

    public static boolean canUseTabPreload(OpenHippyInfo openHippyInfo) {
        TabPreloadItem.PreloadType preloadType = openHippyInfo.preloadType;
        if (preloadType == TabPreloadItem.PreloadType.PRE_BASE) {
            return true;
        }
        if (preloadType == TabPreloadItem.PreloadType.PRE_SNAPSHOT) {
            return false;
        }
        if (HippyQQConstants.ModuleName.QQ_GAME_CENTER.equals(openHippyInfo.bundleName) && !((IHippyUpdate) QRoute.api(IHippyUpdate.class)).isGameCenterPreloadByTab()) {
            return false;
        }
        if (TabPreloadManager.getInstance().isInTabPreload(openHippyInfo.bundleName) || !openHippyInfo.isDisableTabPreload) {
            return true;
        }
        return false;
    }

    public static void checkAndDestroyPreloadHippy(final OpenHippyInfo openHippyInfo) {
        if (openHippyInfo != null && openHippyInfo.checkData()) {
            String processName = openHippyInfo.getProcessName();
            QLog.d("HippyAccessHelper", 1, "DestroyPreloadHippy curProcessId:" + MobileQQ.sProcessId + " processName:" + processName);
            if (isLocalProcess(processName)) {
                ((IHippyThread) QRoute.api(IHippyThread.class)).createQQHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.utils.b
                    @Override // java.lang.Runnable
                    public final void run() {
                        HippyAccessHelper.destroyPreloadHippy(OpenHippyInfo.this);
                    }
                });
                return;
            }
            if ("main".equals(processName)) {
                Bundle bundle = new Bundle();
                bundle.putBundle(IHippyIPC.BUNDLE_HIPPY_INFO, openHippyInfo.toBundle());
                QIPCClientHelper.getInstance().callServer(IHippyIPC.NAME, IHippyIPC.ACTION_REMOVE_PRELOADED_HIPPY, bundle, null);
                return;
            } else {
                if (!"tool".equals(processName) || !com.tencent.mobileqq.hitrate.d.e("com.tencent.mobileqq:tool")) {
                    return;
                }
                Intent intent = new Intent();
                intent.putExtra(IHippyIPC.KEY_IS_REMOVE_PRELOADED_HIPPY, true);
                intent.putExtra(IHippyIPC.BUNDLE_HIPPY_INFO, openHippyInfo.toBundle());
                HippyUtils.startToolProcess(intent);
                return;
            }
        }
        QLog.d("HippyAccessHelper", 1, "DestroyPreloadHippy parameters error");
    }

    public static boolean checkAndPreloadHippyPage(final OpenHippyInfo openHippyInfo) {
        if (openHippyInfo != null && openHippyInfo.checkData()) {
            String processName = openHippyInfo.getProcessName();
            QLog.d("HippyAccessHelper", 1, "checkAndPreloadHippyPage curProcessId:" + MobileQQ.sProcessId + " processName:" + processName);
            if (isLocalProcess(processName)) {
                ((IHippyThread) QRoute.api(IHippyThread.class)).createQQHandler().post(new Runnable() { // from class: com.tencent.hippy.qq.utils.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        HippyAccessHelper.preloadHippyPage(OpenHippyInfo.this, null);
                    }
                });
            } else if ("main".equals(processName)) {
                Bundle bundle = new Bundle();
                openHippyInfo.callApiTime = System.currentTimeMillis();
                bundle.putBundle(IHippyIPC.BUNDLE_HIPPY_INFO, openHippyInfo.toBundle());
                QIPCClientHelper.getInstance().callServer(IHippyIPC.NAME, IHippyIPC.ACTION_PRELOAD_HIPPY, bundle, null);
            } else if ("tool".equals(processName)) {
                Intent intent = new Intent();
                intent.putExtra(IHippyIPC.KEY_IS_PRELOAD_HIPPY, true);
                openHippyInfo.callApiTime = System.currentTimeMillis();
                intent.putExtra(IHippyIPC.BUNDLE_HIPPY_INFO, openHippyInfo.toBundle());
                HippyUtils.startToolProcess(intent);
            } else {
                QLog.e("HippyAccessHelper", 1, "Unsupported process name:", processName);
                return false;
            }
            preloadPSKey(openHippyInfo);
            return true;
        }
        QLog.d("HippyAccessHelper", 1, "checkAndPreloadHippyPage parameters error");
        return false;
    }

    public static boolean checkDomainPermission(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        int i3 = 0;
        while (true) {
            String[] strArr = DOMAIN_WHITE_LIST;
            if (i3 >= strArr.length) {
                return false;
            }
            if (AuthorizeConfig.P(strArr[i3], lowerCase)) {
                return true;
            }
            i3++;
        }
    }

    public static boolean checkUrlPermission(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            if (!"http".equals(scheme) && !"https".equals(scheme)) {
                return false;
            }
            return checkDomainPermission(parse.getHost());
        } catch (Throwable th5) {
            QLog.e("HippyAccessHelper", 1, "checkUrlPermission e:" + th5);
            return false;
        }
    }

    public static void clearAllPreloads(String str) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        synchronized (sPreloadLock) {
            hashMap.putAll(sPreloadEngines);
            hashMap2.putAll(sPreloadingEngines);
            sPreloadEngines.clear();
            sPreloadingEngines.clear();
        }
        ((IHippyReportCache) QRoute.api(IHippyReportCache.class)).clearAllReportData();
        Iterator it = hashMap2.entrySet().iterator();
        while (it.hasNext()) {
            HippyQQPreloadEngine hippyQQPreloadEngine = (HippyQQPreloadEngine) ((Map.Entry) it.next()).getValue();
            if (hippyQQPreloadEngine != null) {
                hippyQQPreloadEngine.cancelPreload();
                QLog.d("HippyAccessHelper", 1, "clearAllPreloads cancel preload:", hippyQQPreloadEngine.getModuleName(), " from:", str);
            }
        }
        Iterator it5 = hashMap.entrySet().iterator();
        while (it5.hasNext()) {
            ArrayList arrayList = (ArrayList) ((Map.Entry) it5.next()).getValue();
            if (arrayList != null) {
                Iterator it6 = arrayList.iterator();
                while (it6.hasNext()) {
                    HippyQQPreloadEngine hippyQQPreloadEngine2 = (HippyQQPreloadEngine) it6.next();
                    hippyQQPreloadEngine2.destroyEngineImmediately(str);
                    QLog.d("HippyAccessHelper", 1, "clearAllPreloads remove preload:", hippyQQPreloadEngine2.getModuleName(), " from:", str);
                }
            }
        }
    }

    private static void destroyOldPreloadEngine(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        synchronized (sPreloadLock) {
            HippyQQPreloadEngine hippyQQPreloadEngine = sPreloadingEngines.get(str);
            if (hippyQQPreloadEngine != null) {
                hippyQQPreloadEngine.cancelPreload();
                sPreloadingEngines.remove(str);
            }
            ArrayList<HippyQQPreloadEngine> arrayList2 = sPreloadEngines.get(str);
            if (arrayList2 != null && arrayList2.size() > 0) {
                arrayList.addAll(arrayList2);
                arrayList2.clear();
            }
        }
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            HippyQQPreloadEngine hippyQQPreloadEngine2 = (HippyQQPreloadEngine) arrayList.get(i3);
            if (hippyQQPreloadEngine2 != null) {
                hippyQQPreloadEngine2.destroyEngineImmediately(str2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void destroyPreloadHippy(OpenHippyInfo openHippyInfo) {
        if (openHippyInfo == null) {
            return;
        }
        String str = openHippyInfo.bundleName;
        String str2 = openHippyInfo.from;
        if (!TextUtils.isEmpty(str)) {
            destroyOldPreloadEngine(str, str2);
            TabPreloadManager.getInstance().destroyPreloadEngine(str, str2);
        } else if (openHippyInfo.preloadType == TabPreloadItem.PreloadType.PRE_BASE) {
            TabPreloadManager.getInstance().destroyPreloadBaseEngine(openHippyInfo.framework, str2);
        }
    }

    public static String getCurrentUin() {
        String str;
        AppInterface appInterface = ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).getAppInterface();
        if (appInterface != null) {
            str = appInterface.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    public static String getDomainByBundleName(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (String str2 : mNeedLoginStateInfoModules.keySet()) {
            if (str2 != null && str != null && str.startsWith(str2)) {
                return mNeedLoginStateInfoModules.get(str2);
            }
        }
        return null;
    }

    public static JSONObject getJSInitData(AppRuntime appRuntime, String str, String str2, String str3, String str4) {
        if (appRuntime == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bundleName", str);
            if (!TextUtils.isEmpty(str2)) {
                jSONObject.put("url", str2);
            }
            jSONObject.put("QQVersion", ah.P());
            jSONObject.put("processName", MobileQQ.sMobileQQ.getQQProcessName());
            jSONObject.put("isNightModeTheme", QQTheme.isNowThemeIsNight());
            jSONObject.put("themeId", NumberUtil.stringToInt(QQTheme.getCurrentThemeId()));
            jSONObject.put("isVasTheme", QQTheme.isVasTheme(QQTheme.getCurrentThemeId()));
            jSONObject.put("isSupporImmersive", ImmersiveUtils.isSupporImmersive() == 1);
            jSONObject.put("statusBarHeight", ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext()));
            jSONObject.put("notchHeight", LiuHaiUtils.sNotchHeight);
            jSONObject.put("isPad", HippyUtils.isPadOrFoldDevice());
            jSONObject.put("_titleBarHeight", BaseApplication.getContext().getResources().getDimensionPixelSize(R.dimen.title_bar_height) + ImmersiveUtils.getStatusBarHeight(MobileQQ.sMobileQQ.getApplicationContext()));
            String account = appRuntime.getAccount();
            jSONObject.put("uin", HttpBaseUtil.a(account));
            jSONObject.put(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, HttpBaseUtil.a(account));
            jSONObject.put("skey", "");
            if (TextUtils.isEmpty(str3)) {
                str3 = getDomainByBundleName(str);
            }
            if (!TextUtils.isEmpty(str3)) {
                String pSKey = getPSKey(str3);
                jSONObject.put("p_skey", pSKey);
                if (QLog.isColorLevel()) {
                    QLog.d("HippyAccessHelper", 2, "getJSInitData jsInitData:" + jSONObject);
                }
                if (TextUtils.isEmpty(pSKey)) {
                    QLog.e("HippyAccessHelper", 1, "getJSInitData psKey is empty.");
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("domain", str3);
                    hashMap.put("reportFrom", ReadInJoyMMapKvStorage.NAME_DEFAULT);
                    HippyReporter.getInstance().reportToDengTa(str, 0, HippyReporter.EventCode.HIPPY_PSKEY, -1, hashMap);
                }
            }
            if (!TextUtils.isEmpty(str4)) {
                JSONObject jSONObject2 = new JSONObject(str4);
                Iterator keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String str5 = (String) keys.next();
                    jSONObject.put(str5, jSONObject2.opt(str5));
                }
            }
        } catch (Throwable th5) {
            QLog.e("HippyAccessHelper", 1, "getJSInitData error:" + th5);
        }
        return jSONObject;
    }

    private static HippyQQPreloadEngine getOldPreloadEngine(String str, int i3) {
        synchronized (sPreloadLock) {
            ArrayList<HippyQQPreloadEngine> arrayList = sPreloadEngines.get(str);
            if (arrayList != null && arrayList.size() > 0) {
                while (arrayList.size() > 0) {
                    HippyQQPreloadEngine remove = arrayList.remove(0);
                    if (remove != null) {
                        if (TabPreloadManager.canUsePreloadedEngine(remove, str, i3)) {
                            HippyUtils.reportEngineRemoved(remove.getModuleName(), remove.getPreloadModuleVersion(), 0, HippyReporter.RemoveEngineReason.BUS_PRELOAD);
                            return remove;
                        }
                        remove.destroyEngineImmediately(HippyReporter.RemoveEngineReason.INVALID);
                    }
                }
                return null;
            }
            return null;
        }
    }

    public static String getPSKey(String str) {
        AppInterface appInterface = HippyUtils.getAppInterface();
        if (appInterface != null && !TextUtils.isEmpty(str)) {
            IPskeyManager iPskeyManager = (IPskeyManager) appInterface.getRuntimeService(IPskeyManager.class, "all");
            final HashMap hashMap = new HashMap();
            iPskeyManager.getPskey(new String[]{str}, new sd2.a() { // from class: com.tencent.hippy.qq.utils.HippyAccessHelper.2
                @Override // sd2.a
                public void onFail(@NonNull String str2) {
                    QLog.e("HippyAccessHelper", 1, "getPskey failed:", str2);
                }

                @Override // sd2.a
                public void onSuccess(@NonNull Map<String, String> map) {
                    hashMap.putAll(map);
                }
            });
            String str2 = (String) hashMap.get(str);
            if (TextUtils.isEmpty(str2)) {
                QLog.e("HippyAccessHelper", 1, "getPskey failed: pSKey is empty  domain: ", str);
            }
            return str2;
        }
        QLog.e("HippyAccessHelper", 1, "getPSKey error:", appInterface, " domain:", str);
        return null;
    }

    private static HippyRootView getPredrawRootView(String str) {
        synchronized (sPreloadLock) {
            ArrayList<HippyQQPreloadEngine> arrayList = sPreloadEngines.get(str);
            if (arrayList != null && arrayList.size() > 0) {
                return arrayList.get(0).getPredrawHippyRootView();
            }
            return null;
        }
    }

    public static HippyQQPreloadEngine getPreloadedHippyQQEngine(String str, String str2, int i3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HippyQQPreloadEngine tabPreloadEngine = getTabPreloadEngine(str, i3);
        if (tabPreloadEngine == null) {
            HippyQQPreloadEngine oldPreloadEngine = getOldPreloadEngine(str, i3);
            if (oldPreloadEngine == null) {
                return getTabPreloadBaseEngine(str2);
            }
            return oldPreloadEngine;
        }
        return tabPreloadEngine;
    }

    public static String getPreloadingStep(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        synchronized (sPreloadLock) {
            HippyQQPreloadEngine hippyQQPreloadEngine = sPreloadingEngines.get(str);
            if (hippyQQPreloadEngine != null) {
                return hippyQQPreloadEngine.getPreloadStep();
            }
            return TabPreloadManager.getInstance().getPreloadingStep(str);
        }
    }

    private static HippyQQPreloadEngine getTabPreloadBaseEngine(String str) {
        HippyQQPreloadEngine preloadBaseEngine = TabPreloadManager.getInstance().getPreloadBaseEngine(str);
        if (preloadBaseEngine != null) {
            HippyUtils.reportEngineRemoved(preloadBaseEngine.getModuleName(), preloadBaseEngine.getPreloadModuleVersion(), 0, HippyReporter.RemoveEngineReason.TAB_BAR_PRELOAD);
        }
        return preloadBaseEngine;
    }

    private static HippyQQPreloadEngine getTabPreloadEngine(String str, int i3) {
        HippyQQPreloadEngine preloadEngine = TabPreloadManager.getInstance().getPreloadEngine(str, i3);
        if (preloadEngine != null) {
            HippyUtils.reportEngineRemoved(preloadEngine.getModuleName(), preloadEngine.getPreloadModuleVersion(), 0, HippyReporter.RemoveEngineReason.TAB_BAR_PRELOAD);
        }
        return preloadEngine;
    }

    public static boolean isLocalProcess(String str) {
        if ("local".equals(str)) {
            return true;
        }
        if ("main".equals(str) && MobileQQ.sProcessId == 1) {
            return true;
        }
        if ("tool".equals(str) && MobileQQ.sProcessId == 7) {
            return true;
        }
        return false;
    }

    private static boolean isPreloaded(String str) {
        synchronized (sPreloadLock) {
            ArrayList<HippyQQPreloadEngine> arrayList = sPreloadEngines.get(str);
            if (arrayList == null) {
                return false;
            }
            if (QLog.isColorLevel()) {
                QLog.d("HippyAccessHelper", 2, "preloadHippyPage size:" + arrayList.size());
            }
            int moduleVersion = ((IHippySetting) QRoute.api(IHippySetting.class)).getModuleVersion(str);
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                HippyQQPreloadEngine hippyQQPreloadEngine = arrayList.get(size);
                if (hippyQQPreloadEngine.getPreloadModuleVersion() != moduleVersion) {
                    hippyQQPreloadEngine.destroyEngineImmediately(HippyReporter.RemoveEngineReason.INVALID);
                    arrayList.remove(size);
                    if (QLog.isColorLevel()) {
                        QLog.d("HippyAccessHelper", 2, "preloadHippyPage remove old version i:" + size);
                    }
                }
            }
            if (arrayList.size() <= 0) {
                return false;
            }
            return true;
        }
    }

    private static boolean isPreloading(String str) {
        synchronized (sPreloadLock) {
            if (sPreloadingEngines.containsKey(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("HippyAccessHelper", 2, "preloadHippyPage bundleName:" + str + " isLoading");
                }
                return true;
            }
            return false;
        }
    }

    public static void onAppDestroy() {
        MainStateManager.getInstance().onAppDestroy();
        TabPreloadManager.getInstance().onAppDestroy();
        PreloadPrivilegeManager.getInstance().onAppDestroy();
        clearAllPreloads("logout");
    }

    public static void onClearHippyCache() {
        QLog.i("HippyAccessHelper", 1, "onClearHippyCache");
        TabPreloadManager.getInstance().onClearHippyCache();
        clearAllPreloads(HippyReporter.RemoveEngineReason.CLEAR_CACHE);
        if (MobileQQ.sProcessId == 1) {
            Intent intent = new Intent();
            intent.putExtra(IHippyIPC.KEY_IS_CLEAR_HIPPY_CACHE, true);
            HippyUtils.startToolProcess(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onPreloadError(HippyQQPreloadEngine hippyQQPreloadEngine, String str, int i3, String str2) {
        synchronized (sPreloadLock) {
            sPreloadingEngines.remove(str);
        }
        hippyQQPreloadEngine.destroyEngineImmediately(HippyReporter.RemoveEngineReason.PRELOAD_ERROR);
        QLog.e("HippyAccessHelper", 1, "preloadHippyPage onError statusCode:" + i3 + " msg:" + str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onPreloadSuccess(HippyQQPreloadEngine hippyQQPreloadEngine, String str, String str2, String str3) {
        if (!TabPreloadManager.checkHippyEngine(hippyQQPreloadEngine, str2, str3)) {
            return;
        }
        synchronized (sPreloadLock) {
            sPreloadingEngines.remove(str);
            ((IHippyReportCache) QRoute.api(IHippyReportCache.class)).clearReportData(str);
            ArrayList<HippyQQPreloadEngine> arrayList = sPreloadEngines.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                sPreloadEngines.put(str, arrayList);
            }
            arrayList.add(hippyQQPreloadEngine);
        }
    }

    public static boolean openHippyPage(Context context, OpenHippyInfo openHippyInfo) {
        boolean z16;
        if (context != null && openHippyInfo != null && openHippyInfo.checkData()) {
            openHippyInfo.openId = ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).generateOpenId();
            QLog.i("HippyAccessHelper", 1, "openHippy bundleName:" + openHippyInfo.bundleName + " processName:" + openHippyInfo.getProcessName());
            Bundle bundle = openHippyInfo.toBundle();
            bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
            Class<? extends QPublicBaseFragment> cls = mModuleClassMap.get(bundle.getString("bundleName"));
            if (cls != null) {
                openHippyInfo.fragmentClass = cls;
            }
            Intent intent = new Intent();
            intent.putExtra("params", bundle);
            if (openHippyInfo.isTransparent) {
                intent.putExtra("public_fragment_window_feature", 1);
            }
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            if (((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isLaunchByMiniApp(context)) {
                QLog.i("HippyAccessHelper", 1, "Launch by miniApp");
                ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).launchMiniHippy(context, intent);
                return true;
            }
            Class<? extends QPublicFragmentActivity> startActivityClass = openHippyInfo.getStartActivityClass();
            Class<? extends QPublicBaseFragment> startFragmentClass = openHippyInfo.getStartFragmentClass();
            if (startActivityClass != null && startFragmentClass != null) {
                if (openHippyInfo.isAnimated) {
                    intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, R.anim.f154445lb);
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, R.anim.f154449lf);
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, R.anim.f154435l2);
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, R.anim.f154436l4);
                    z16 = false;
                } else {
                    intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
                    z16 = false;
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_ENTER_ANIMATION, 0);
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_OPEN_EXIT_ANIMATION, 0);
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, 0);
                    intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0);
                }
                if (AppSetting.t(context) && bundle.getBoolean("is_support_split_mode", z16)) {
                    com.tencent.mobileqq.pad.b f16 = new com.tencent.mobileqq.pad.b().e(z16).g(bundle.getBoolean("is_need_clear_other_fragment", z16)).h(LaunchMode.standard).f(bundle.getBoolean("is_cover_split_page", z16));
                    bundle.putBoolean("is_load_on_split_mode", true);
                    intent.putExtra("params", bundle);
                    com.tencent.mobileqq.pad.i.e(context, intent.getExtras(), CommonHippyFragment.class, f16.a());
                    QLog.i("HippyAccessHelper", 1, "openHippyPage on split mode");
                } else {
                    QPublicFragmentActivity.b.b(context, intent, startActivityClass, startFragmentClass);
                }
                preloadPSKey(openHippyInfo);
                ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).onOpenHippyStart(openHippyInfo);
                return true;
            }
            QLog.e("HippyAccessHelper", 1, "openHippyPage cannot find activity class or fragment class");
            return false;
        }
        QLog.e("HippyAccessHelper", 1, "openHippyPage params error");
        return false;
    }

    public static boolean preloadHippyPage(OpenHippyInfo openHippyInfo, final HippyPreloadListener hippyPreloadListener) {
        String account;
        if (openHippyInfo != null && openHippyInfo.checkData()) {
            if (canUseTabPreload(openHippyInfo)) {
                if (hippyPreloadListener != null) {
                    hippyPreloadListener.onFinish(1, "use TabPreloader", null);
                }
                return TabPreloadManager.getInstance().manuallyPreload(openHippyInfo);
            }
            final String str = openHippyInfo.bundleName;
            QLog.d("HippyAccessHelper", 1, "preloadHippyPage moduleName:" + str + " preloadType:" + openHippyInfo.preloadType);
            TabPreloadItem.PreloadType preloadType = openHippyInfo.preloadType;
            TabPreloadItem.PreloadType preloadType2 = TabPreloadItem.PreloadType.PRE_SNAPSHOT;
            if (preloadType != preloadType2) {
                if (isPreloading(str)) {
                    String str2 = "preloadHippyPage moduleName:" + str + " is preloading";
                    QLog.d("HippyAccessHelper", 1, str2);
                    if (hippyPreloadListener != null) {
                        hippyPreloadListener.onFinish(3, str2, null);
                    }
                    return false;
                }
                if (isPreloaded(str)) {
                    QLog.d("HippyAccessHelper", 1, "preloadHippyPage moduleName:" + str + " is preloaded");
                    if (hippyPreloadListener != null) {
                        hippyPreloadListener.onFinish(0, null, getPredrawRootView(str));
                    }
                    return true;
                }
            }
            TabPreloadItem.PreloadType preloadType3 = openHippyInfo.preloadType;
            TabPreloadItem.PreloadType preloadType4 = TabPreloadItem.PreloadType.PRE_DRAW;
            if (preloadType3 == preloadType4 && HippyUtils.isPadOrFoldDevice()) {
                openHippyInfo.preloadType = TabPreloadItem.PreloadType.PRE_LOAD;
            }
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            JSONObject jSInitData = getJSInitData(waitAppRuntime, str, openHippyInfo.url, openHippyInfo.domain, openHippyInfo.businessData);
            if (jSInitData == null) {
                jSInitData = new JSONObject();
            }
            addPreloadParameters(jSInitData, openHippyInfo);
            final String currentThemeId = QQTheme.getCurrentThemeId();
            if (waitAppRuntime == null) {
                account = "";
            } else {
                account = waitAppRuntime.getAccount();
            }
            final String str3 = account;
            final HippyQQPreloadEngine hippyQQPreloadEngine = new HippyQQPreloadEngine(null, str, openHippyInfo.url);
            hippyQQPreloadEngine.setOpenHippyInfo(openHippyInfo);
            hippyQQPreloadEngine.setInitData(jSInitData, jSInitData);
            hippyQQPreloadEngine.checkLoginState(jSInitData, !TextUtils.isEmpty(openHippyInfo.domain));
            hippyQQPreloadEngine.setPreloadFrom(openHippyInfo.from);
            hippyQQPreloadEngine.computeSwitchProcessTimeCost(openHippyInfo.callApiTime);
            synchronized (sPreloadLock) {
                if (sPreloadingEngines.containsKey(str)) {
                    return false;
                }
                sPreloadingEngines.put(str, hippyQQPreloadEngine);
                HippyQQEngine.HippyQQEngineListener hippyQQEngineListener = new HippyQQEngine.HippyQQEngineListener() { // from class: com.tencent.hippy.qq.utils.HippyAccessHelper.1
                    @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
                    public void onError(int i3, String str4) {
                        HippyAccessHelper.onPreloadError(HippyQQPreloadEngine.this, str, i3, str4);
                        HippyPreloadListener hippyPreloadListener2 = hippyPreloadListener;
                        if (hippyPreloadListener2 != null) {
                            hippyPreloadListener2.onFinish(i3, str4, null);
                        }
                        QLog.d("HippyAccessHelper", 1, "preloadHippyPage error:", Integer.valueOf(i3), " msg:", str4, " moduleName:", str);
                    }

                    @Override // com.tencent.hippy.qq.app.HippyQQEngine.HippyQQEngineListener
                    public void onSuccess() {
                        HippyAccessHelper.onPreloadSuccess(HippyQQPreloadEngine.this, str, str3, currentThemeId);
                        HippyPreloadListener hippyPreloadListener2 = hippyPreloadListener;
                        if (hippyPreloadListener2 != null) {
                            hippyPreloadListener2.onFinish(0, null, HippyQQPreloadEngine.this.getPredrawHippyRootView());
                        }
                        QLog.d("HippyAccessHelper", 1, "preloadHippyPage onSuccess moduleName:", str);
                    }
                };
                TabPreloadItem.PreloadType preloadType5 = openHippyInfo.preloadType;
                if (preloadType5 != preloadType4 && preloadType5 != preloadType2) {
                    if (preloadType5 == TabPreloadItem.PreloadType.PRE_LOAD) {
                        hippyQQPreloadEngine.preloadHippy(hippyQQEngineListener, false, 0);
                    }
                } else {
                    hippyQQPreloadEngine.predrawHippy(hippyQQEngineListener, false, 0);
                }
                return true;
            }
        }
        QLog.d("HippyAccessHelper", 1, "preloadHippyPage parameters error");
        if (hippyPreloadListener != null) {
            hippyPreloadListener.onFinish(1, "preloadHippyPage parameters error", null);
        }
        return false;
    }

    public static void preloadPSKey(OpenHippyInfo openHippyInfo) {
        String str = openHippyInfo.domain;
        if (TextUtils.isEmpty(str)) {
            str = getDomainByBundleName(openHippyInfo.bundleName);
        }
        if (!TextUtils.isEmpty(str)) {
            getPSKey(str);
        }
    }

    public static JSONObject wrapHashMap(JSONObject jSONObject, HashMap hashMap) {
        if (hashMap == null) {
            return jSONObject;
        }
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        for (Object obj : hashMap.keySet()) {
            try {
                jSONObject.put(obj.toString(), hashMap.get(obj));
            } catch (Exception e16) {
                QLog.e("HippyAccessHelper", 1, e16, new Object[0]);
            }
        }
        return jSONObject;
    }
}
