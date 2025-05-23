package com.tencent.hippy.qq.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.hippy.qq.api.HippyInterpolator;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyIPC;
import com.tencent.hippy.qq.api.MMKVCommonFileKeys;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.hippy.qq.app.HippyQQPreloadEngine;
import com.tencent.hippy.qq.intercept.HippyWebNavigationItem;
import com.tencent.hippy.qq.interpolators.HippyInterpolatorConfig;
import com.tencent.hippy.qq.offline.HippyOfflineAssist;
import com.tencent.hippy.qq.preload.TabPreloadManager;
import com.tencent.hippy.qq.update.HippyPredownloadManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import oicq.wlogin_sdk.tools.util;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class HippyAccessHelperImpl implements IHippyAccessHelper {
    private static final String TAG = "HippyAccessHelperImpl";
    private static AtomicInteger gOpenHippyCount = new AtomicInteger();
    private com.tencent.biz.common.offline.a mBidCallback;

    private TabPreloadItem getAdPreloadItem(String str, TabPreloadItem.AdType adType) {
        List<TabPreloadItem> adPreloadList;
        if (!TextUtils.isEmpty(str) && adType != null && (adPreloadList = HippyPredownloadManager.getInstance().getTabPreloadConfigManager().getAdPreloadList()) != null && adPreloadList.size() > 0) {
            for (TabPreloadItem tabPreloadItem : adPreloadList) {
                if (str.equals(tabPreloadItem.adId) && adType == tabPreloadItem.adType) {
                    return tabPreloadItem;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$executeTaskInToolProcess$0(String str) {
        TabPreloadManager.getInstance().onTabChangeForTool(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    @Deprecated
    public boolean checkAndPreloadHippyPage(OpenHippyInfo openHippyInfo) {
        openHippyInfo.isDisableTabPreload = true;
        return HippyAccessHelper.checkAndPreloadHippyPage(openHippyInfo);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void checkAndPreloadRes(String str) {
        Uri uri;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "[checkAndPreloadRes] mJumpUrl: " + str);
        }
        if (TextUtils.isEmpty(str)) {
            QLog.i(TAG, 2, "[checkAndPreloadRes] jumpUrl is empty, return.");
            return;
        }
        try {
            if (str.startsWith("https://")) {
                uri = Uri.parse(str);
            } else if (str.startsWith("mqqapi://hippy")) {
                uri = Uri.parse(URLDecoder.decode(str, "UTF-8"));
            } else {
                uri = null;
            }
            if (uri == null) {
                QLog.i(TAG, 2, "[checkAndPreloadRes] uri is null, return.");
                return;
            }
            String queryParameter = uri.getQueryParameter("offlinePkgID");
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(queryParameter)) {
                arrayList.add(queryParameter);
                QLog.i(TAG, 2, "[checkAndPreloadRes] add id: " + queryParameter);
            }
            if (arrayList.size() > 0) {
                QLog.i(TAG, 2, "[checkAndPreloadRes] getUpdateInfoFromServerByBidsAsync start");
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                com.tencent.biz.common.offline.a aVar = new com.tencent.biz.common.offline.a() { // from class: com.tencent.hippy.qq.api.impl.HippyAccessHelperImpl.1
                    @Override // com.tencent.biz.common.offline.a
                    public void loaded(String str2, int i3) {
                        QLog.i(HippyAccessHelperImpl.TAG, 2, "[checkAndPreloadRes] getUpdateInfoFromServerByBidsAsync code: " + i3 + ", param: " + str2);
                    }

                    @Override // com.tencent.biz.common.offline.a
                    public void progress(int i3) {
                    }
                };
                this.mBidCallback = aVar;
                HtmlOffline.C(arrayList, peekAppRuntime, aVar, true, true);
            }
        } catch (Exception e16) {
            QLog.e(TAG, 2, "[checkAndPreloadRes] " + e16);
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public boolean checkDomainPermission(String str) {
        return HippyAccessHelper.checkDomainPermission(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public boolean checkUrlPermission(String str) {
        return HippyAccessHelper.checkUrlPermission(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void destroyPreloadHippy(OpenHippyInfo openHippyInfo) {
        HippyAccessHelper.checkAndDestroyPreloadHippy(openHippyInfo);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void executeTaskInToolProcess(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra(IHippyIPC.KEY_IS_REMOVE_PRELOADED_HIPPY, false);
        boolean booleanExtra2 = intent.getBooleanExtra(IHippyIPC.KEY_IS_CLEAR_HIPPY_CACHE, false);
        boolean booleanExtra3 = intent.getBooleanExtra(IHippyIPC.KEY_IS_PRELOAD_HIPPY, false);
        boolean booleanExtra4 = intent.getBooleanExtra(IHippyIPC.KEY_IS_PRELOAD_AD_HIPPY, false);
        if (booleanExtra2) {
            HippyAccessHelper.onClearHippyCache();
            return;
        }
        if (booleanExtra) {
            HippyAccessHelper.checkAndDestroyPreloadHippy(new OpenHippyInfo(intent.getBundleExtra(IHippyIPC.BUNDLE_HIPPY_INFO)));
            return;
        }
        if (booleanExtra4) {
            preloadAdHippy(intent.getStringExtra(IHippyIPC.KEY_PRELOAD_AD_ID), TabPreloadItem.convertToAdType(intent.getIntExtra(IHippyIPC.KEY_PRELOAD_AD_TYPD, 0)));
            return;
        }
        if (booleanExtra3) {
            final String stringExtra = intent.getStringExtra(IHippyIPC.KEY_SHOW_TAB_NAME);
            Bundle bundleExtra = intent.getBundleExtra(IHippyIPC.BUNDLE_HIPPY_INFO);
            if (!TextUtils.isEmpty(stringExtra)) {
                TabPreloadManager.getInstance().setSwitchToolProcessTimeCost(System.currentTimeMillis() - intent.getLongExtra(OpenHippyInfo.EXTRA_KEY_CALL_API_TIME, 0L));
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.hippy.qq.api.impl.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        HippyAccessHelperImpl.lambda$executeTaskInToolProcess$0(stringExtra);
                    }
                }, 16, null, false);
                return;
            }
            if (bundleExtra != null) {
                HippyAccessHelper.checkAndPreloadHippyPage(new OpenHippyInfo(bundleExtra));
            }
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public int generateOpenId() {
        return gOpenHippyCount.incrementAndGet();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public long getDynamicTabShowTime() {
        return TabPreloadManager.getInstance().getDynamicTabShowTime();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public JSONObject getJSInitData(AppRuntime appRuntime, String str, String str2, String str3, String str4) {
        return HippyAccessHelper.getJSInitData(appRuntime, str, str2, str3, str4);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public String getOfflineResPath(String str) {
        return HippyOfflineAssist.getOfflineResPath(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public HippyQQPreloadEngine getPreloadedHippyQQEngine(String str, String str2, int i3) {
        return HippyAccessHelper.getPreloadedHippyQQEngine(str, str2, i3);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public String getPreloadingStep(String str) {
        return HippyAccessHelper.getPreloadingStep(str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public boolean interceptHttpUrl(Activity activity, String str) {
        return HippyWebNavigationItem.INSTANCE.interceptHippyUrl(activity, str);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public boolean isAdNeedsPreload(String str, TabPreloadItem.AdType adType) {
        if (getAdPreloadItem(str, adType) != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void onAppDestroy() {
        HippyAccessHelper.onAppDestroy();
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void onHippyDestroy(OpenHippyInfo openHippyInfo) {
        HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(openHippyInfo.bundleName);
        if (interpolator != null) {
            interpolator.onHippyDestroy(openHippyInfo);
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void onOpenHippyStart(OpenHippyInfo openHippyInfo) {
        HippyInterpolator interpolator = HippyInterpolatorConfig.getInterpolator(openHippyInfo.bundleName);
        if (interpolator != null) {
            interpolator.onOpenHippyStart(openHippyInfo);
        }
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public boolean openHippyPage(Context context, OpenHippyInfo openHippyInfo) {
        return HippyAccessHelper.openHippyPage(context, openHippyInfo);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public boolean preNodeSnapShot(OpenHippyInfo openHippyInfo) {
        openHippyInfo.preloadType = TabPreloadItem.PreloadType.PRE_SNAPSHOT;
        if (TextUtils.isEmpty(openHippyInfo.processName)) {
            openHippyInfo.processName = "tool";
        }
        openHippyInfo.from = TabPreloadItem.PRELOAD_TYPE_SNAPSHOT;
        return preloadHippyPage(openHippyInfo);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void preloadAdHippy(String str, TabPreloadItem.AdType adType) {
        TabPreloadItem adPreloadItem = getAdPreloadItem(str, adType);
        if (adPreloadItem == null) {
            return;
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        String str2 = MMKVCommonFileKeys.IS_AD_PRELOADED_PREFIX + HippyAccessHelper.getCurrentUin() + util.base64_pad_url + str;
        if (from.decodeBool(str2, false)) {
            return;
        }
        String str3 = adPreloadItem.preloadProcess;
        if (HippyAccessHelper.isLocalProcess(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preloadAdHippy start preload for ad:", str);
            }
            from.encodeBool(str2, true).commitAsync();
            OpenHippyInfo openHippyInfo = new OpenHippyInfo();
            adPreloadItem.fillParameters(openHippyInfo);
            if (HippyAccessHelper.canUseTabPreload(openHippyInfo)) {
                TabPreloadManager.getInstance().manuallyPreload(TabPreloadItem.TAB_NAME_MESSAGE, adPreloadItem, 0);
                return;
            } else {
                HippyAccessHelper.checkAndPreloadHippyPage(openHippyInfo);
                return;
            }
        }
        if ("tool".equals(str3)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "preloadAdHippy start tool process for ad:", str);
            }
            Intent intent = new Intent();
            intent.putExtra(IHippyIPC.KEY_IS_PRELOAD_AD_HIPPY, true);
            intent.putExtra(IHippyIPC.KEY_PRELOAD_AD_ID, str);
            intent.putExtra(IHippyIPC.KEY_PRELOAD_AD_TYPD, adType.adTypeValue());
            HippyUtils.startToolProcess(intent);
            return;
        }
        QLog.e(TAG, 1, "preloadAdHippy unsupported process:", str3);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public boolean preloadHippyPage(OpenHippyInfo openHippyInfo) {
        return HippyAccessHelper.checkAndPreloadHippyPage(openHippyInfo);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void preloadPSKey(OpenHippyInfo openHippyInfo) {
        HippyAccessHelper.preloadPSKey(openHippyInfo);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public JSONObject wrapHashMap(JSONObject jSONObject, HashMap hashMap) {
        return HippyAccessHelper.wrapHashMap(jSONObject, hashMap);
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void startFPSMonitor(Activity activity) {
    }

    @Override // com.tencent.hippy.qq.api.IHippyAccessHelper
    public void stopFPSMonitor(Activity activity) {
    }
}
