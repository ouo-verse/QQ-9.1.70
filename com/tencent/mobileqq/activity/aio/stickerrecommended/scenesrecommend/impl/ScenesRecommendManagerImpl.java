package com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.IScenesRecommendManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ScenesRecommendManagerImpl extends BroadcastReceiver implements IScenesRecommendManager {
    public static final boolean IS_DEBUG_DATA = false;
    public static final int SCENES_REC_KOV_NOT_FIND = 1;
    public static final int SCENES_REC_SUCCESS = 0;
    public static final int SCENES_REC_UIN_NOT_CURRENT = 2;
    public static final String TAG = "ScenesRecommendManager";
    WeakReference<a> uiHelperWeakReference;
    AppInterface mApp = null;
    List<com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b> scencesItemList = new ArrayList();
    protected boolean mHasRegisterReceiver = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface a {
        boolean a(String str);

        void p0(com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b bVar);
    }

    private boolean checkNotifyUinIsCurrentSession(String str) {
        a tryGetUIHelper = tryGetUIHelper();
        if (tryGetUIHelper == null) {
            QLog.d("ScenesRecommendManager", 1, "helper is null");
            return false;
        }
        return tryGetUIHelper.a(str);
    }

    private void doScenesEmotionRecommend(com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b bVar) {
        QLog.i("ScenesRecommendManager", 2, "doScenesEmotionRecommend ScenesRecommendItem is " + bVar.b());
        a tryGetUIHelper = tryGetUIHelper();
        if (tryGetUIHelper == null) {
            return;
        }
        tryGetUIHelper.p0(bVar);
    }

    private com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b findScenesRecItemByKOV(String str) {
        List<com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b> list = this.scencesItemList;
        if (list == null) {
            return null;
        }
        for (com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b bVar : list) {
            if (bVar.c() != null && bVar.c().equalsIgnoreCase(str)) {
                return bVar;
            }
        }
        return null;
    }

    public static ScenesRecommendManagerImpl get(AppInterface appInterface) {
        return (ScenesRecommendManagerImpl) appInterface.getRuntimeService(IScenesRecommendManager.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadConfigFromLocal$0() {
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            String b16 = c.b(appInterface);
            QLog.i("ScenesRecommendManager", 2, "loadConfigFromLocal config is " + b16);
            List<com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b> parseDataByJson = parseDataByJson(b16);
            if (parseDataByJson != null) {
                this.scencesItemList = parseDataByJson;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$onCreate$1() {
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("101230");
    }

    static List<com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b> parseDataByJson(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        return c.c(str);
    }

    protected boolean checkUin(String str, String str2) {
        if (checkNotifyUinIsCurrentSession(str) && !checkUinisCurrent(str2)) {
            return true;
        }
        return false;
    }

    protected boolean checkUinisCurrent(String str) {
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(this.mApp.getCurrentUin());
    }

    public com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b findScenesRecItemByID(String str) {
        List<com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b> list = this.scencesItemList;
        if (list == null) {
            return null;
        }
        for (com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b bVar : list) {
            if (bVar.b() != null && bVar.b().equalsIgnoreCase(str)) {
                return bVar;
            }
        }
        return null;
    }

    public void loadConfigFromLocal() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                ScenesRecommendManagerImpl.this.lambda$loadConfigFromLocal$0();
            }
        }, 16, null, true);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.mApp = (AppInterface) appRuntime;
        this.mApp.getApp().getApplicationContext().registerReceiver(this, new IntentFilter("mqq.scenesrecommendemo.notify.action"));
        this.mHasRegisterReceiver = true;
        loadConfigFromLocal();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.impl.a
            @Override // java.lang.Runnable
            public final void run() {
                ScenesRecommendManagerImpl.lambda$onCreate$1();
            }
        }, 16, null, false);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        if (this.mHasRegisterReceiver) {
            this.mHasRegisterReceiver = false;
            this.mApp.getApp().getApplicationContext().unregisterReceiver(this);
        }
        this.mApp = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction() == "mqq.scenesrecommendemo.notify.action") {
            String stringExtra = intent.getStringExtra("scenes_kov");
            boolean booleanExtra = intent.getBooleanExtra("need_check_uin", true);
            String stringExtra2 = intent.getStringExtra("check_uin");
            String stringExtra3 = intent.getStringExtra("HONGBAO_KEY_SENDERUIN");
            QLog.i("ScenesRecommendManager", 2, "onReceive NOTIFY_SCENES_RECOMMEND_EMO_ACTION is " + stringExtra + "|" + booleanExtra + "|" + stringExtra2 + "|" + stringExtra3);
            onReceiveScenesRecNotify(stringExtra, booleanExtra, stringExtra2, stringExtra3);
        }
    }

    public void onReceiveScenesRecNotify(String str, boolean z16, String str2, String str3) {
        boolean z17;
        if (z16 && !checkUin(str2, str3)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            com.tencent.mobileqq.activity.aio.stickerrecommended.scenesrecommend.b findScenesRecItemByKOV = findScenesRecItemByKOV(str);
            if (findScenesRecItemByKOV != null) {
                doScenesEmotionRecommend(findScenesRecItemByKOV);
                reportScenesRecNotifyMonitor(0, str);
                return;
            } else {
                reportScenesRecNotifyMonitor(1, str);
                return;
            }
        }
        reportScenesRecNotifyMonitor(2, str);
    }

    public void reportScenesRecNotifyMonitor(int i3, String str) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.d("ScenesRecommendManager", 2, "reportScenesRecNotifyError result: " + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (str == null) {
            str = "";
        }
        hashMap.put("kov", str);
        hashMap.put("result", i3 + "");
        StatisticCollector statisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        statisticCollector.collectPerformance(null, StatisticCollector.SCENES_REC_EMO_MONITOR, z16, 0L, 0L, hashMap, null);
    }

    public void setUiHelper(a aVar) {
        if (aVar == null) {
            this.uiHelperWeakReference = null;
        } else {
            this.uiHelperWeakReference = new WeakReference<>(aVar);
        }
    }

    a tryGetUIHelper() {
        WeakReference<a> weakReference = this.uiHelperWeakReference;
        if (weakReference != null && !weakReference.isEnqueued()) {
            return this.uiHelperWeakReference.get();
        }
        return null;
    }
}
