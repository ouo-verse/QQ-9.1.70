package com.tencent.mobileqq.webview.api.impl;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.biz.common.util.k;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.webprocess.WebProcessReceiver;
import com.tencent.mobileqq.webview.api.IWebProcessPreload;
import com.tencent.mobileqq.webview.util.t;
import com.tencent.mobileqq.webview.util.u;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.util.AppSetting;
import com.tencent.xweb.FileReaderHelper;
import java.io.File;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* loaded from: classes35.dex */
public class WebProcessPreloadImpl implements IWebProcessPreload {
    private static final String DNS_PROFILE = "dns_profile";
    private static final String TAG = "WebProcessStartServiceImpl";
    private static final AtomicBoolean sStartWebProcessRunning = new AtomicBoolean(false);
    private static final AtomicBoolean sStartPreDownX5Running = new AtomicBoolean(false);
    private static int isNeedPreparseDns = -1;
    private static final ConcurrentHashMap<String, Integer> webProcessBuffer = new ConcurrentHashMap<>();

    /* loaded from: classes35.dex */
    private class WebProcessPreloadJob implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        int f313807d;

        /* renamed from: e, reason: collision with root package name */
        u f313808e;

        WebProcessPreloadJob(int i3, u uVar) {
            this.f313807d = i3;
            this.f313808e = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!WebProcessPreloadImpl.this.isWebProcessExist()) {
                WebProcessPreloadImpl.this.doPreloadWebProcess(this.f313807d, null);
                u uVar = this.f313808e;
                if (uVar != null) {
                    uVar.onResult(true);
                }
            } else {
                u uVar2 = this.f313808e;
                if (uVar2 != null) {
                    uVar2.onResult(false);
                }
            }
            WebProcessPreloadImpl.sStartWebProcessRunning.set(false);
        }
    }

    private Long getDnsPreParseTimeMills(String str) {
        return Long.valueOf(BaseApplication.getContext().getSharedPreferences(DNS_PROFILE, 0).getLong(str, 0L));
    }

    private boolean isDnsParseTime(String str) {
        if (isNeedPreparseDns == 0) {
            return false;
        }
        long longValue = getDnsPreParseTimeMills(str).longValue();
        return longValue == 0 || System.currentTimeMillis() - longValue > 600000;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void lambda$preDownX5$1(int i3, boolean z16) {
        if (TbsDownloader.needDownload(BaseApplication.getContext(), false)) {
            QLog.i(TAG, 1, "[preDownX5] send ACTION_DOWNLOAD_TBS, from: " + i3 + ", force: " + z16);
            Intent intent = new Intent(BaseApplication.context, (Class<?>) WebProcessReceiver.class);
            intent.setAction(com.tencent.qqmini.miniapp.receiver.WebProcessReceiver.ACTION_DOWNLOAD_TBS);
            intent.putExtra(FileReaderHelper.OPEN_FILE_FROM_FORCE, z16);
            intent.putExtra("from", i3);
            BaseApplication.context.sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        } else if (QLog.isDevelopLevel()) {
            QLog.d(TAG, 1, "[preDownX5] no need to download from: " + i3);
        }
        sStartWebProcessRunning.set(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$preloadWebProcessWithData$0(int i3, Bundle bundle) {
        doPreloadWebProcess(i3, bundle);
        sStartWebProcessRunning.set(false);
    }

    private void setDnsPreParseTimeMills(String str, long j3) {
        BaseApplication.getContext().getSharedPreferences(DNS_PROFILE, 0).edit().putLong(str, j3).commit();
    }

    public static void setPreloadSuccess(boolean z16) {
        t.j().d("key_preload", Boolean.valueOf(z16)).a();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public long getBusinessClickTimeMills(String str, String str2) {
        return ((Long) t.j().b("key_business_click_time" + str + "_" + str2, -1L)).longValue();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public boolean isPreloadWebProcess() {
        return ((Boolean) t.j().b("key_preload_web_process", Boolean.FALSE)).booleanValue();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public boolean isWebProcessExist() {
        k.a("Web_Module_Check_Is_Exit");
        boolean isModuleRunning = QIPCServerHelper.getInstance().isModuleRunning("modular_web");
        k.d("Web_Module_Check_Is_Exit");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Web module is exist: " + isModuleRunning);
        }
        return isModuleRunning;
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void preDownX5(final int i3, final boolean z16) {
        if (sStartPreDownX5Running.compareAndSet(false, true)) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.api.impl.c
                @Override // java.lang.Runnable
                public final void run() {
                    WebProcessPreloadImpl.lambda$preDownX5$1(i3, z16);
                }
            }, 128, null, false);
        }
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void preParseDns(final List<String> list, String str) {
        if (isDnsParseTime(str)) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "begin to parse dns,isNeedPreparseDns = " + isNeedPreparseDns);
            }
            setDnsPreParseTimeMills(str, System.currentTimeMillis());
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.webview.api.impl.WebProcessPreloadImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (WebProcessPreloadImpl.isNeedPreparseDns == -1) {
                            File file = new File(BaseApplication.getContext().getFilesDir(), ClubContentJsonTask.WebViewCrashJSONTask.jsonName);
                            if (!file.exists()) {
                                WebProcessPreloadImpl.isNeedPreparseDns = -1;
                                if (QLog.isColorLevel()) {
                                    QLog.i(WebProcessPreloadImpl.TAG, 2, "null == file || !file.exists() = true,return!");
                                    return;
                                }
                                return;
                            }
                            String readFileContent = FileUtils.readFileContent(file);
                            if (TextUtils.isEmpty(readFileContent)) {
                                WebProcessPreloadImpl.isNeedPreparseDns = -1;
                                if (QLog.isColorLevel()) {
                                    QLog.i(WebProcessPreloadImpl.TAG, 2, "TextUtils.isEmpty(JsonStr) = true,return!");
                                    return;
                                }
                                return;
                            }
                            WebProcessPreloadImpl.isNeedPreparseDns = new JSONObject(readFileContent).getBoolean("use_dns") ? 1 : 0;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i(WebProcessPreloadImpl.TAG, 2, "isNeedPreparseDns :" + WebProcessPreloadImpl.isNeedPreparseDns);
                        }
                        if (WebProcessPreloadImpl.isNeedPreparseDns == 1) {
                            for (String str2 : list) {
                                long currentTimeMillis = System.currentTimeMillis();
                                InetAddress.getByName(str2);
                                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                                if (QLog.isColorLevel()) {
                                    QLog.i("WebStatusReport", 2, "time used:" + currentTimeMillis2);
                                }
                                WebProcessPreloadImpl.reportTimeUsed(str2, currentTimeMillis2);
                            }
                        }
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.e(WebProcessPreloadImpl.TAG, 2, "UnKnownHost Exception!", e16);
                        }
                    }
                }
            }, 5, null, true);
        }
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void preloadWebProcess(int i3, final u uVar) {
        preloadCheck(i3);
        if (sStartWebProcessRunning.compareAndSet(false, true)) {
            ThreadManagerV2.excute(new WebProcessPreloadJob(i3, uVar), 128, null, false);
        } else if (uVar != null) {
            if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                uVar.onResult(false);
            } else {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.api.impl.WebProcessPreloadImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        uVar.onResult(false);
                    }
                }, 128, null, false);
            }
        }
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void preloadWebProcessWithData(final int i3, final Bundle bundle) {
        preloadCheck(i3);
        sStartWebProcessRunning.set(true);
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.webview.api.impl.d
            @Override // java.lang.Runnable
            public final void run() {
                WebProcessPreloadImpl.this.lambda$preloadWebProcessWithData$0(i3, bundle);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void releaseLightWebProcess() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "releaseHalfToolProcess, send release tool process broadcast!");
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.webprocess.release_tool_process");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void setBusinessClickTimeMills(String str, String str2) {
        t.j().d("key_business_click_time" + str + "_" + str2, Long.valueOf(System.currentTimeMillis())).g();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void setPreloadWebProcess(boolean z16) {
        t.j().d("key_preload_web_process", Boolean.valueOf(z16)).a();
    }

    @Override // com.tencent.mobileqq.webview.api.IWebProcessPreload
    public void stopWebCoreService() {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "stop web core service");
        }
        Intent intent = new Intent();
        intent.setAction("com.tencent.mobileqq.webprocess.stop_web_core_service");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    private static void preloadCheck(int i3) {
        if (i3 >= 0 && i3 <= 10000) {
            QLog.d(TAG, 1, "preloadWebProcess from:" + i3);
            return;
        }
        String str = "Illegal from value: " + i3 + " for preloadWebProcess!!!";
        if (AppSetting.isPublicVersion()) {
            QLog.w(TAG, 1, str, new Throwable());
            return;
        }
        throw new RuntimeException(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void reportTimeUsed(String str, long j3) {
        int i3;
        String str2;
        try {
            i3 = NetworkUtil.getSystemNetwork(null);
        } catch (Exception unused) {
            i3 = 0;
        }
        if (i3 == 1) {
            str2 = "wifi";
        } else if (i3 == 2) {
            str2 = "2G";
        } else if (i3 == 3) {
            str2 = "3G";
        } else if (i3 != 4) {
            str2 = "";
        } else {
            str2 = "4G";
        }
        try {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("net_state", str2);
            hashMap.put("current_url", str);
            hashMap.put("time_used", String.valueOf(j3));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "dns_parse_time", true, j3, 1L, hashMap, "", false);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "report dns parse time error=" + e16.toString());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void doPreloadWebProcess(int i3, Bundle bundle) {
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "doPreloadWebProcess from: " + i3);
        }
        setPreloadWebProcess(true);
        setPreloadSuccess(false);
        try {
            SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences("CrashControl_com.tencent.mobileqq:tool", 4);
            if (sharedPreferences != null && !sharedPreferences.getBoolean("allowpreload", true)) {
                long j3 = sharedPreferences.getLong(AEEditorConstants.VIDEO_CLIP_START_TIME, 0L);
                int i16 = sharedPreferences.getInt("controlwindow", 86400);
                long currentTimeMillis = System.currentTimeMillis();
                if (j3 > 0 && i16 > 0 && currentTimeMillis > j3 && currentTimeMillis - j3 > i16 * 1000) {
                    sharedPreferences.edit().putBoolean("allowpreload", true).commit();
                } else {
                    QLog.d(TAG, 1, "preloadWebProcess is not allowed as crash frequently.");
                    setPreloadWebProcess(false);
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount(), "actNoPreloadWeb", true, 0L, 0L, null, "");
                    return;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        Intent intent = new Intent(MobileQQ.sMobileQQ, (Class<?>) WebProcessReceiver.class);
        intent.putExtra("from", i3);
        intent.setAction("com.tencent.mobileqq.webprocess.preload_web_process");
        intent.setPackage(BaseApplication.getContext().getPackageName());
        intent.putExtra("com.tencent.mobileqq.webprocess.start_time", System.currentTimeMillis());
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "Send preload web process broadcast...");
        }
    }
}
