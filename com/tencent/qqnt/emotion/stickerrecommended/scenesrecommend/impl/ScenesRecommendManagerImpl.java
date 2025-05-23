package com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.temp.report.StatisticCollector;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.IScenesRecommendManager;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.c;
import com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes24.dex */
public class ScenesRecommendManagerImpl extends BroadcastReceiver implements IScenesRecommendManager {
    static IPatchRedirector $redirector_ = null;
    public static final boolean IS_DEBUG_DATA = false;
    public static final int SCENES_REC_KOV_NOT_FIND = 1;
    public static final int SCENES_REC_SUCCESS = 0;
    public static final int SCENES_REC_UIN_NOT_CURRENT = 2;
    public static final String TAG = "ScenesRecommendManager";
    AppInterface mApp;
    private boolean mHasRegisterReceiver;
    List<c> scencesItemList;
    WeakReference<com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a> uiHelperWeakReference;

    public ScenesRecommendManagerImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mApp = null;
            this.scencesItemList = new ArrayList();
        }
    }

    private boolean checkNotifyUinIsCurrentSession(String str) {
        com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a tryGetUIHelper = tryGetUIHelper();
        if (tryGetUIHelper == null) {
            QLog.d("ScenesRecommendManager", 1, "helper is null");
            return false;
        }
        return tryGetUIHelper.a(str);
    }

    private void doScenesEmotionRecommend(c cVar) {
        if (QLog.isColorLevel()) {
            QLog.i("ScenesRecommendManager", 2, "doScenesEmotionRecommend ScenesRecommendItem is " + cVar.c());
        }
        com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a tryGetUIHelper = tryGetUIHelper();
        if (tryGetUIHelper == null) {
            return;
        }
        tryGetUIHelper.v1(cVar);
    }

    private c findScenesRecItemByKOV(String str) {
        List<c> list = this.scencesItemList;
        if (list == null) {
            return null;
        }
        for (c cVar : list) {
            if (cVar.d() != null && cVar.d().equalsIgnoreCase(str)) {
                return cVar;
            }
        }
        return null;
    }

    public static IScenesRecommendManager get(AppRuntime appRuntime) {
        return (IScenesRecommendManager) appRuntime.getRuntimeService(IScenesRecommendManager.class, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$loadConfigFromLocal$0() {
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            String b16 = d.b(appInterface);
            if (QLog.isColorLevel()) {
                QLog.i("ScenesRecommendManager", 2, "loadConfigFromLocal config is " + b16);
            }
            List<c> parseDataByJson = parseDataByJson(b16);
            if (parseDataByJson != null) {
                this.scencesItemList = parseDataByJson;
            }
        }
    }

    static List<c> parseDataByJson(String str) {
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        return d.c(str);
    }

    protected boolean checkUin(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (checkNotifyUinIsCurrentSession(str) && !checkUinisCurrent(str2)) {
            return true;
        }
        return false;
    }

    protected boolean checkUinisCurrent(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str)).booleanValue();
        }
        if (StringUtil.isEmpty(str)) {
            return false;
        }
        return str.equalsIgnoreCase(this.mApp.getCurrentUin());
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.IScenesRecommendManager
    public c findScenesRecItemByID(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (c) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
        }
        List<c> list = this.scencesItemList;
        if (list == null) {
            return null;
        }
        for (c cVar : list) {
            if (cVar.c() != null && cVar.c().equalsIgnoreCase(str)) {
                return cVar;
            }
        }
        return null;
    }

    public void loadConfigFromLocal() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.impl.a
                @Override // java.lang.Runnable
                public final void run() {
                    ScenesRecommendManagerImpl.this.lambda$loadConfigFromLocal$0();
                }
            }, 16, null, true);
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = (AppInterface) appRuntime;
        this.mApp.getApp().getApplicationContext().registerReceiver(this, new IntentFilter("mqq.scenesrecommendemo.notify.action"));
        this.mHasRegisterReceiver = true;
        loadConfigFromLocal();
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.mHasRegisterReceiver) {
            this.mHasRegisterReceiver = false;
            try {
                this.mApp.getApp().getApplicationContext().unregisterReceiver(this);
            } catch (Throwable th5) {
                QLog.e("ScenesRecommendManager", 1, "onDestroy unregisterReceiver error! stack = ", th5);
            }
        }
        this.mApp = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) intent);
            return;
        }
        if (intent.getAction() == "mqq.scenesrecommendemo.notify.action") {
            String stringExtra = intent.getStringExtra("scenes_kov");
            boolean booleanExtra = intent.getBooleanExtra("need_check_uin", true);
            String stringExtra2 = intent.getStringExtra("check_uin");
            String stringExtra3 = intent.getStringExtra("HONGBAO_KEY_SENDERUIN");
            if (QLog.isColorLevel()) {
                QLog.i("ScenesRecommendManager", 2, "onReceive NOTIFY_SCENES_RECOMMEND_EMO_ACTION is " + stringExtra + "|" + booleanExtra + "|" + stringExtra2 + "|" + stringExtra3);
            }
            onReceiveScenesRecNotify(stringExtra, booleanExtra, stringExtra2, stringExtra3);
        }
    }

    public void onReceiveScenesRecNotify(String str, boolean z16, String str2, String str3) {
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, Boolean.valueOf(z16), str2, str3);
            return;
        }
        if (z16 && !checkUin(str2, str3)) {
            z17 = false;
        } else {
            z17 = true;
        }
        if (z17) {
            c findScenesRecItemByKOV = findScenesRecItemByKOV(str);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ScenesRecommendManager", 2, "reportScenesRecNotifyError result: " + i3);
        }
        HashMap<String, String> hashMap = new HashMap<>();
        if (str == null) {
            str = "";
        }
        hashMap.put("kov", str);
        hashMap.put("result", i3 + "");
        StatisticCollector d16 = StatisticCollector.d(BaseApplication.getContext());
        String str2 = StatisticCollector.f292628b;
        if (i3 == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        d16.c(null, str2, z16, 0L, 0L, hashMap, null);
    }

    @Override // com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.IScenesRecommendManager
    public void setUiHelper(com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar);
        } else if (aVar == null) {
            this.uiHelperWeakReference = null;
        } else {
            this.uiHelperWeakReference = new WeakReference<>(aVar);
        }
    }

    com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a tryGetUIHelper() {
        WeakReference<com.tencent.qqnt.emotion.stickerrecommended.scenesrecommend.a> weakReference = this.uiHelperWeakReference;
        if (weakReference != null && !weakReference.isEnqueued()) {
            return this.uiHelperWeakReference.get();
        }
        return null;
    }
}
