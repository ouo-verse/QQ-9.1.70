package com.tencent.mobileqq.webview.api.impl;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.m;
import com.tencent.mobileqq.webprocess.WebAccelerateHelper;
import com.tencent.mobileqq.webview.api.IWebProcessManagerService;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.mobileqq.webview.util.v;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;

/* loaded from: classes35.dex */
public class WebProcessManagerServiceImpl implements IWebProcessManagerService {
    private static final int BIG_MEMORY = 1024;
    private static final int RED_POINT_MEMORY = 512;
    private static final String TAG = "WebProcessStartServiceImpl";
    private static final ConcurrentHashMap<String, Integer> webProcessBuffer = new ConcurrentHashMap<>();
    private AppRuntime app;
    private boolean mIsRegistered = false;
    protected a mReceiver;
    private long totalMemSize;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes35.dex */
    public static class a extends BroadcastReceiver {

        /* renamed from: a, reason: collision with root package name */
        WeakReference<WebProcessManagerServiceImpl> f313804a;

        public a(WebProcessManagerServiceImpl webProcessManagerServiceImpl) {
            this.f313804a = new WeakReference<>(webProcessManagerServiceImpl);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WebProcessManagerServiceImpl webProcessManagerServiceImpl = this.f313804a.get();
            String action = intent.getAction();
            if (action == null || webProcessManagerServiceImpl == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(WebProcessManagerServiceImpl.TAG, 2, "action=" + action);
            }
            if (action.equals("com.tencent.mobileqq.webprocess.restart_web_process")) {
                webProcessManagerServiceImpl.restartWebProcess();
                if (intent.getBooleanExtra("isPreloadWebProcess", false)) {
                    webProcessManagerServiceImpl.reportHitRate();
                    return;
                }
                return;
            }
            if (action.equals("com.tencent.mobileqq.webprocess.report")) {
                webProcessManagerServiceImpl.reportHitRate();
            }
        }
    }

    private void registerReceiver() {
        if (this.mReceiver == null) {
            this.mReceiver = new a(this);
        }
        if (this.mIsRegistered) {
            return;
        }
        this.mIsRegistered = true;
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.tencent.mobileqq.webprocess.restart_web_process");
            intentFilter.addAction("com.tencent.mobileqq.webprocess.report");
            BaseApplication.getContext().registerReceiver(this.mReceiver, intentFilter);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportHitRate() {
        if (v.a()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isPreloadSucess");
            }
            ReportController.n(null, "P_CliOper", "Vip", "", "0X8004874", "0X8004874", 0, 1, 0, "", "", "", "");
        } else {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "isPreloadFail");
            }
            ReportController.n(null, "P_CliOper", "Vip", "", "0X8004875", "0X8004875", 0, 1, 0, "", "", "", "");
        }
        v.b(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void restartWebProcess() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "restartWebProcess");
        }
        new Handler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.webview.api.impl.b
            @Override // java.lang.Runnable
            public final void run() {
                WebProcessManagerServiceImpl.this.lambda$restartWebProcess$0();
            }
        }, 800L);
    }

    private void unregisterReceiver() {
        if (this.mReceiver == null || !this.mIsRegistered) {
            return;
        }
        try {
            this.mIsRegistered = false;
            BaseApplication.getContext().unregisterReceiver(this.mReceiver);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessManagerService
    public boolean enablePreloadInBusiness(int i3) {
        Integer[] webViewFeatureParams = WebAccelerateHelper.getInstance().getWebViewFeatureParams();
        if (i3 < webViewFeatureParams.length && i3 >= 0) {
            if (webViewFeatureParams[i3].intValue() != 0) {
                if (QLog.isColorLevel()) {
                    QLog.i(TAG, 2, "now enable preload tool process for businessId=" + i3);
                }
                return true;
            }
            QLog.e(TAG, 1, "can not preload tool process for businessId=", Integer.valueOf(i3));
            return false;
        }
        QLog.e(TAG, 1, "can not preload tool process for businessId=", Integer.valueOf(i3));
        return false;
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessManagerService
    public boolean isNeedPreloadWebProcess() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = webProcessBuffer;
        Integer num = concurrentHashMap.get("key_preload_strategy");
        if (num == null || num.intValue() != 2) {
            return true;
        }
        Integer num2 = concurrentHashMap.get("key_preload_flag");
        if (num2 == null || num2.intValue() != 1) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "is need prload, totalMemSize = " + this.totalMemSize + "M");
        }
        Integer num3 = concurrentHashMap.get("key_red_ram");
        return num3 != null && this.totalMemSize > ((long) num3.intValue());
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        this.app = appRuntime;
        updatePreloadWebProcessFlag();
        registerReceiver();
        this.totalMemSize = m.c() / 1048576;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        unregisterReceiver();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessManagerService
    public void startWebProcess(int i3, u uVar) {
        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(i3, uVar);
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessManagerService
    public boolean startWebProcessUnderStrategy(int i3, u uVar) {
        if (!isNeedPreloadWebProcess()) {
            return false;
        }
        ((IWebProcessPreload) QRoute.api(IWebProcessPreload.class)).preloadWebProcess(i3, uVar);
        return true;
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessManagerService
    public void updatePreloadWebProcessFlag() {
        ConcurrentHashMap<String, Integer> concurrentHashMap = webProcessBuffer;
        concurrentHashMap.clear();
        concurrentHashMap.put("key_preload_strategy", (Integer) t.j().b("key_preload_strategy" + this.app.getAccount(), 1));
        t j3 = t.j();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("key_preload_flag");
        sb5.append(this.app.getAccount());
        concurrentHashMap.put("key_preload_flag", Integer.valueOf(((Boolean) j3.b(sb5.toString(), Boolean.FALSE)).booleanValue() ? 1 : 0));
        concurrentHashMap.put("key_red_ram", (Integer) t.j().b("key_red_ram" + this.app.getAccount(), 512));
        concurrentHashMap.put("key_click_ram", (Integer) t.j().b("key_click_ram" + this.app.getAccount(), 1024));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$restartWebProcess$0() {
        startWebProcessUnderStrategy(0, null);
    }
}
