package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import com.tencent.hydevteam.pluginframework.pluginmanager.MultiTargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.TargetDownloadInfo;
import com.tencent.hydevteam.pluginframework.pluginmanager.UpgradeablePluginManager;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckException;
import com.tencent.hydevteam.pluginframework.pluginmanager.VersionChecker;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.groupvideo.i;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.huayang.MonitorConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes33.dex */
public class HuayangPluginNewDownloaderImpl implements IHuayangPluginNewDownloader {
    private static final int MSG_CHECK_VERSION = 0;
    private static final int MSG_NOTIFY_DOWNLOAD_COMPLETED = 2;
    private static final int MSG_NOTIFY_DOWNLOAD_FAILED = 3;
    private static final int MSG_NOTIFY_PRELOAD_COMPLETE = 5;
    private static final int MSG_NOTIFY_PRELOAD_FAILED = 6;
    private static final int MSG_NOTIFY_PRELOAD_PLUGIN_PROCESS = 7;
    private static final int MSG_NOTIFY_READ_PROGRESS = 4;
    private static final int MSG_UPDATE_PROGRESS = 1;
    private static final int PLUGIN_MANAGER_INIT_TIME_SECS = 10;
    public static final String TAG = "HuayangPluginNewDownloader";
    private static final int VALUE_MAIN_PLUGIN = 1;
    private String mAction;
    private Context mAppContext;
    private String mAppName;
    private IVPluginDataReporter mDataReporter;
    private IHuayangPluginNewDownloader.a mDownloadListener;
    private volatile List<ProgressFuture<InstalledPlugin>> mGetPluginFuture;
    private volatile boolean mIsHaveCache;
    private Map<String, IVPluginInfo> mPluginInfoMap;
    private String mPluginPackageName;
    private String mPluginVersion;
    private int mProgress;
    private long mStartFlag;
    private long mStartTime;
    private boolean mTestEnv;
    private long mTotalSize;
    private Handler mUiHandler;
    private UpgradeablePluginManager upgradeablePluginManager;
    public String mUin = "";
    private volatile boolean mRunning = false;
    private Handler.Callback mUiHandlerCallback = new a();
    private Runnable mRunnable = new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl.3
        @Override // java.lang.Runnable
        public void run() {
            Monitor.d("3228167");
            HuayangPluginNewDownloaderImpl.this.mRunning = false;
        }
    };

    /* loaded from: classes33.dex */
    class a implements Handler.Callback {
        a() {
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x01c7, code lost:
        
            return false;
         */
        @Override // android.os.Handler.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    if (HuayangPluginNewDownloaderImpl.this.mDownloadListener != null) {
                        HuayangPluginNewDownloaderImpl.this.mDownloadListener.a(0, message.obj);
                        break;
                    }
                    break;
                case 1:
                    int i3 = message.arg1;
                    if (i3 > HuayangPluginNewDownloaderImpl.this.mProgress && HuayangPluginNewDownloaderImpl.this.mDownloadListener != null) {
                        HuayangPluginNewDownloaderImpl.this.mDownloadListener.a(1, Integer.valueOf(message.arg1), Long.valueOf(HuayangPluginNewDownloaderImpl.this.mTotalSize));
                        HuayangPluginNewDownloaderImpl.this.mProgress = i3;
                        break;
                    }
                    break;
                case 2:
                    if (HuayangPluginNewDownloaderImpl.this.mDownloadListener != null) {
                        HuayangPluginNewDownloaderImpl.this.mDownloadListener.a(2, message.obj);
                    }
                    if (MonitorConfig.f238245i.get(HuayangPluginNewDownloaderImpl.this.mAppName) != null) {
                        Monitor.b(String.valueOf(MonitorConfig.f238245i.get(HuayangPluginNewDownloaderImpl.this.mAppName).f238247b));
                        break;
                    }
                    break;
                case 3:
                    if (HuayangPluginNewDownloaderImpl.this.mDownloadListener != null) {
                        HuayangPluginNewDownloaderImpl.this.mDownloadListener.a(3, message.obj);
                    }
                    if (MonitorConfig.f238245i.get(HuayangPluginNewDownloaderImpl.this.mAppName) != null) {
                        Monitor.b(String.valueOf(MonitorConfig.f238245i.get(HuayangPluginNewDownloaderImpl.this.mAppName).f238248c));
                        break;
                    }
                    break;
                case 4:
                    Object obj = message.obj;
                    if (obj instanceof ProgressFuture) {
                        double progress = ((ProgressFuture) obj).getProgress();
                        HuayangPluginNewDownloaderImpl.this.log(HuayangPluginNewDownloaderImpl.TAG, "\u6536\u5230\u8bfb\u53d6\u8fdb\u5ea6\u7684MSG, progress = " + progress);
                        HuayangPluginNewDownloaderImpl.this.mUiHandler.sendMessage(Message.obtain(HuayangPluginNewDownloaderImpl.this.mUiHandler, 1, (int) (progress * 100.0d), 0));
                        HuayangPluginNewDownloaderImpl.this.mUiHandler.sendMessageDelayed(Message.obtain(HuayangPluginNewDownloaderImpl.this.mUiHandler, 4, message.obj), 300L);
                        break;
                    }
                    break;
                case 5:
                    if (HuayangPluginNewDownloaderImpl.this.mDownloadListener != null) {
                        InstalledPlugin installedPlugin = (InstalledPlugin) message.obj;
                        IHuayangPluginNewDownloader.a aVar = HuayangPluginNewDownloaderImpl.this.mDownloadListener;
                        Object[] objArr = new Object[3];
                        objArr[0] = installedPlugin;
                        objArr[1] = Boolean.valueOf(message.arg1 == 1);
                        objArr[2] = Long.valueOf(HuayangPluginNewDownloaderImpl.this.mStartFlag);
                        aVar.a(4, objArr);
                    }
                    HuayangPluginNewDownloaderImpl.this.log(HuayangPluginNewDownloaderImpl.TAG, HardCodeUtil.qqStr(R.string.nbv) + (System.currentTimeMillis() - HuayangPluginNewDownloaderImpl.this.mStartTime));
                    HuayangPluginNewDownloaderImpl.this.mRunning = false;
                    break;
                case 6:
                    if (HuayangPluginNewDownloaderImpl.this.mDownloadListener != null) {
                        HuayangPluginNewDownloaderImpl.this.mDownloadListener.a(5, message.obj);
                        break;
                    }
                    break;
                case 7:
                    Intent intent = new Intent(HuayangPluginNewDownloaderImpl.this.mAppContext, (Class<?>) HuayangLoadbackgroudActivity.class);
                    intent.putExtra("isPreload", true);
                    intent.setFlags(268435456);
                    HuayangPluginNewDownloaderImpl.this.mAppContext.startActivity(intent);
                    break;
            }
        }
    }

    private InstalledPlugin downloadPluginDownloadInfo(ProgressFuture<InstalledPlugin> progressFuture) throws Exception {
        if (!this.mIsHaveCache) {
            Handler handler = this.mUiHandler;
            handler.sendMessage(Message.obtain(handler, 4, progressFuture));
        }
        if (!this.mIsHaveCache && Monitor.a()) {
            Handler handler2 = this.mUiHandler;
            handler2.sendMessageDelayed(Message.obtain(handler2, 1, 30, 0), 2000L);
            Handler handler3 = this.mUiHandler;
            handler3.sendMessageDelayed(Message.obtain(handler3, 1, 70, 0), 6000L);
        }
        try {
            InstalledPlugin installedPlugin = progressFuture.get();
            if (!this.mIsHaveCache) {
                this.mUiHandler.removeMessages(4);
            }
            return installedPlugin;
        } catch (Exception e16) {
            if (!this.mIsHaveCache) {
                this.mUiHandler.removeMessages(4);
            }
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    private void notifyDownloadCompleted(InstalledPlugin installedPlugin, boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(HardCodeUtil.qqStr(R.string.nbr));
        sb5.append(installedPlugin == null);
        log(TAG, sb5.toString());
        reportIsCache(this.mIsHaveCache);
        notifyUIStateChange(2, installedPlugin);
        if (z16) {
            str = "fromCache";
        } else {
            str = "fromServer";
        }
        reportDownloadResult(true, installedPlugin, str, null);
        this.mUiHandler.removeMessages(4);
    }

    private void notifyPreloadCompete(InstalledPlugin installedPlugin, boolean z16) {
        log(TAG, HardCodeUtil.qqStr(R.string.nbt) + installedPlugin);
        Message obtain = Message.obtain(this.mUiHandler, 5, installedPlugin);
        obtain.arg1 = z16 ? 1 : -1;
        this.mUiHandler.sendMessage(obtain);
    }

    private void notifyUIStateChange(int i3, Object obj) {
        this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, i3, obj));
    }

    private void preloadPlugin(InstalledPlugin installedPlugin) {
        Exception exc;
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            this.upgradeablePluginManager.preloadApk(this.mAppContext, installedPlugin, TextUtils.equals(this.mAppName, "group_video")).get();
            log(TAG, HardCodeUtil.qqStr(R.string.nbl));
            if (!this.mIsHaveCache) {
                notifyPreloadCompete(installedPlugin, true);
            }
            exc = null;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "\u9884\u52a0\u8f7d\u8fc7\u7a0b\u4e2d\u51fa\u9519\uff1a", e16);
            }
            if (!this.mIsHaveCache) {
                notifyUIStateChange(6, e16.toString());
            }
            ((IHuayangCrashReport) QRoute.api(IHuayangCrashReport.class)).report(e16);
            exc = e16;
        }
        int currentTimeMillis2 = (int) (System.currentTimeMillis() - currentTimeMillis);
        String installedPlugin2 = installedPlugin.toString();
        if (exc != null) {
            str = exc.getMessage();
        } else {
            str = "";
        }
        report("preLoadFinish", 0, currentTimeMillis2, installedPlugin2, str);
    }

    private void publishProgress(int i3) {
        this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 1, i3, 0));
    }

    private void report(String str, int i3, int i16, String str2, String str3) {
        String str4;
        String str5;
        IVPluginDataReporter opType = this.mDataReporter.opType(str);
        if (TextUtils.isEmpty(this.mAction)) {
            str4 = "null";
        } else {
            str4 = this.mAction;
        }
        IVPluginDataReporter d26 = opType.opName(str4).opIn(i3).opResult(i16).d1(str2).d2(str3);
        if (this.mIsHaveCache) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        d26.d3(str5).d4(this.mPluginPackageName).report();
    }

    private void reportDownloadResult(boolean z16, InstalledPlugin installedPlugin, String str, String str2) {
        report("downloadFinish", z16 ? 1 : 0, (int) (System.currentTimeMillis() - this.mStartTime), installedPlugin == null ? null : installedPlugin.pluginFile.toString(), str2);
    }

    private void reportIsCache(boolean z16) {
        Intent intent = new Intent(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getCacheUserNotifyAction(this.mPluginPackageName));
        intent.putExtra("key_isCache", z16 ? 1 : 0);
        this.mAppContext.sendBroadcast(intent);
        if (z16) {
            return;
        }
        if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.mPluginPackageName)) {
            Monitor.d("2714209");
        } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.mPluginPackageName)) {
            Monitor.d("2714208");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(6:5|(2:8|6)|9|10|(1:14)|15)|16|(1:(3:132|(1:134)|135)(4:118|(4:121|(3:127|128|129)(3:123|124|125)|126|119)|130|131))(1:22)|23|(1:25)(1:114)|26|(1:113)|30|(3:34|35|(3:37|38|(5:45|46|47|48|(2:50|51)(5:52|(1:(1:55)(1:101))(1:102)|(1:(1:100))(1:59)|60|(3:(6:64|65|(3:78|79|(1:81))|(2:72|73)|74|62)|94|95)(1:96)))(1:43)))|112|38|(1:40)|45|46|47|48|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0163, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0168, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x016a, code lost:
    
        com.tencent.qphone.base.util.QLog.e(com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl.TAG, 2, r0, new java.lang.Object[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0170, code lost:
    
        ((com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.intervideo.huayang.IHuayangCrashReport.class)).report(r0);
        r1 = r0;
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x018b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void runDownloadTask() {
        InstalledPlugin installedPlugin;
        boolean z16;
        InstalledPlugin installedPlugin2;
        String str;
        JSONObject jSONObject;
        List<InstalledPlugin> cachedLatestPlugin = this.upgradeablePluginManager.getCachedLatestPlugin(this.mAppName);
        if (cachedLatestPlugin != null && cachedLatestPlugin.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<InstalledPlugin> it = cachedLatestPlugin.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().pluginVersionForPluginLoaderManage);
            }
            Collections.sort(arrayList);
            String obj = arrayList.toString();
            String str2 = this.mPluginVersion;
            if (str2 != null && !TextUtils.equals(obj, str2)) {
                log(TAG, HardCodeUtil.qqStr(R.string.f172097nc0) + obj + " mPluginVersion:" + this.mPluginVersion);
                ((IHuayangOpenHelper) QRoute.api(IHuayangOpenHelper.class)).killProcess(this.mAppContext, this.mAppContext.getPackageName() + ":troophomework");
            }
            this.mPluginVersion = obj;
        }
        if (cachedLatestPlugin != null && cachedLatestPlugin.size() == 1 && cachedLatestPlugin.get(0).pluginFileType == 0) {
            installedPlugin = cachedLatestPlugin.get(0);
            this.mIsHaveCache = true;
            notifyDownloadCompleted(installedPlugin, true);
            notifyPreloadCompete(installedPlugin, true);
        } else if (cachedLatestPlugin != null && !cachedLatestPlugin.isEmpty()) {
            InstalledPlugin installedPlugin3 = null;
            for (InstalledPlugin installedPlugin4 : cachedLatestPlugin) {
                if (installedPlugin4.pluginPackageName.equals(this.mPluginPackageName)) {
                    this.mIsHaveCache = true;
                    notifyDownloadCompleted(installedPlugin4, true);
                    notifyPreloadCompete(installedPlugin4, true);
                    installedPlugin3 = installedPlugin4;
                } else {
                    notifyPreloadCompete(installedPlugin4, false);
                }
            }
            installedPlugin = installedPlugin3;
        } else {
            if (MonitorConfig.f238245i.get(this.mAppName) != null) {
                Monitor.b(String.valueOf(MonitorConfig.f238245i.get(this.mAppName).f238252g));
            }
            installedPlugin = null;
        }
        long currentTimeMillis = this.mIsHaveCache ? System.currentTimeMillis() : 0L;
        if (TextUtils.equals(this.mAction, "slientDownload") || !this.mIsHaveCache) {
            this.mUiHandler.sendEmptyMessage(7);
        }
        IVPluginInfo iVPluginInfo = this.mPluginInfoMap.get(this.mPluginPackageName);
        if (iVPluginInfo != null && (str = iVPluginInfo.K) != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            if (jSONObject.has("preloadOnly")) {
                z16 = jSONObject.getBoolean("preloadOnly");
                if ("huiyin".equals(this.mAppName) || NetworkUtil.isWifiEnabled(this.mAppContext) || !z16) {
                    InstalledPlugin installedPlugin5 = getPluginFromServer(installedPlugin);
                    Exception exc = null;
                    if (!"checkVersion".equals(this.mAction)) {
                        this.mRunning = false;
                        return;
                    }
                    if (this.mIsHaveCache) {
                        reportPreDownload(installedPlugin5, exc, (int) (System.currentTimeMillis() - currentTimeMillis));
                    } else if (exc == null) {
                        publishProgress(100);
                        notifyDownloadCompleted(installedPlugin5, false);
                    } else {
                        notifyUIStateChange(3, exc.toString());
                        reportDownloadResult(false, null, null, exc.toString());
                    }
                    if (installedPlugin5 != null && !PluginRunningPath.isPreOdexFileExists(this.mAppContext, installedPlugin5.pluginPackageName, installedPlugin5.pluginVersionForPluginLoaderManage, installedPlugin5.pluginFile.getName())) {
                        log(TAG, HardCodeUtil.qqStr(R.string.nbz));
                        preloadPlugin(installedPlugin5);
                    } else if (installedPlugin5 != null && !this.mIsHaveCache) {
                        notifyPreloadCompete(installedPlugin5, true);
                    }
                    List<ProgressFuture<InstalledPlugin>> list = this.mGetPluginFuture;
                    this.mGetPluginFuture = null;
                    this.mRunning = false;
                    if (list != null) {
                        for (int i3 = 1; i3 < list.size(); i3++) {
                            try {
                                installedPlugin2 = list.get(i3).get();
                                if (installedPlugin2 != null) {
                                    try {
                                        if (!PluginRunningPath.isPreOdexFileExists(this.mAppContext, installedPlugin2.pluginPackageName, installedPlugin2.pluginVersionForPluginLoaderManage, installedPlugin2.pluginFile.getName())) {
                                            this.upgradeablePluginManager.preloadApk(this.mAppContext, installedPlugin2, TextUtils.equals(this.mAppName, "group_video")).get();
                                        }
                                    } catch (Exception e17) {
                                        e = e17;
                                        Monitor.d("2633400");
                                        report("loadSecondPlugin", 0, 0, installedPlugin2 == null ? null : installedPlugin2.toString(), e.toString());
                                    }
                                }
                                if (installedPlugin2 != null && !this.mIsHaveCache && this.mPluginInfoMap.get(installedPlugin2.pluginPackageName) != null) {
                                    Monitor.d("2633399");
                                    notifyPreloadCompete(installedPlugin2, false);
                                }
                            } catch (Exception e18) {
                                e = e18;
                                installedPlugin2 = null;
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
        }
        z16 = false;
        if ("huiyin".equals(this.mAppName)) {
        }
        InstalledPlugin installedPlugin52 = getPluginFromServer(installedPlugin);
        Exception exc2 = null;
        if (!"checkVersion".equals(this.mAction)) {
        }
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public void cancelDownload() {
        if (this.mGetPluginFuture == null || this.mGetPluginFuture.isEmpty()) {
            return;
        }
        Monitor.d("2597859");
        Iterator<ProgressFuture<InstalledPlugin>> it = this.mGetPluginFuture.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public void cancelLauncher() {
        report("cancelLauncher", 0, (int) (System.currentTimeMillis() - this.mStartTime), "", "");
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public void download(String str, String str2, String str3, Map<String, IVPluginInfo> map) {
        if (this.mRunning) {
            return;
        }
        this.mRunning = true;
        this.mIsHaveCache = false;
        this.mGetPluginFuture = null;
        this.mAction = str2;
        this.mPluginPackageName = str3;
        this.mPluginInfoMap = map;
        this.mStartTime = System.currentTimeMillis();
        this.mAppName = str;
        this.mProgress = 0;
        this.mUiHandler.removeCallbacks(this.mRunnable);
        this.mStartFlag = System.currentTimeMillis();
        this.mUiHandler.postDelayed(this.mRunnable, 40000L);
        report("startDownload", 0, 0, "", "");
        ThreadManagerV2.postDownLoadTask(new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.impl.HuayangPluginNewDownloaderImpl.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    HuayangPluginNewDownloaderImpl.this.runDownloadTask();
                } finally {
                    try {
                    } finally {
                    }
                }
            }
        }, 8, null, false);
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public String getUin() {
        return this.mUin;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public void setDonwanlodPreloadListener(IHuayangPluginNewDownloader.a aVar) {
        this.mDownloadListener = aVar;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public void setRunning(boolean z16) {
        this.mRunning = z16;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public void setUin(String str) {
        this.mUin = str;
    }

    private void doForceUpdate(InstalledPlugin installedPlugin) {
        this.mIsHaveCache = false;
        IHuayangPluginNewDownloader.a aVar = this.mDownloadListener;
        if (aVar != null) {
            aVar.a(10, new Object[0]);
        }
        report("doForceUpdate", 0, 0, installedPlugin.pluginPackageName, installedPlugin.pluginVersionForConfigPluginLoader);
        Intent intent = new Intent("action_iv_plugin_update");
        intent.putExtra("plugin", installedPlugin);
        BaseApplicationImpl.sApplication.sendBroadcast(intent);
        log(TAG, HardCodeUtil.qqStr(R.string.nc5));
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader
    public HuayangPluginNewDownloaderImpl init(Context context, File file, String str) {
        this.mAppContext = context;
        this.mUiHandler = new Handler(Looper.getMainLooper(), this.mUiHandlerCallback);
        this.mTestEnv = i.a();
        this.upgradeablePluginManager = new UpgradeablePluginManager(file, str, this.mTestEnv);
        IVPluginDataReporter iVPluginDataReporter = new IVPluginDataReporter();
        this.mDataReporter = iVPluginDataReporter;
        iVPluginDataReporter.opDepartment(str);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:82:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02bb  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x02a6  */
    /* JADX WARN: Type inference failed for: r0v44, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v15 */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v18, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v9 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.lang.StringBuilder] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private InstalledPlugin getPluginFromServer(InstalledPlugin installedPlugin) throws Exception {
        boolean z16;
        String str;
        int i3;
        String str2;
        boolean z17;
        String str3;
        InstalledPlugin installedPlugin2;
        Map<String, TargetDownloadInfo> map;
        log(TAG, "getPluginFromServer: \u5f00\u59cb\u4ece\u670d\u52a1\u5668\u4e2d\u83b7\u53d6DownloadedPluginInfo\u5f00\u59cb...");
        long currentTimeMillis = System.currentTimeMillis();
        int upgradeIfNeededThenInit = this.upgradeablePluginManager.upgradeIfNeededThenInit(10L, TimeUnit.SECONDS);
        long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
        log(TAG, "upgradeIfNeededThenInit status:" + upgradeIfNeededThenInit + " time:" + currentTimeMillis2);
        ?? r102 = 1;
        ?? r112 = -1;
        if (upgradeIfNeededThenInit != -1) {
            report("downloadPluginManagerFinish", upgradeIfNeededThenInit, (int) currentTimeMillis2, "", "");
            if (upgradeIfNeededThenInit == 1) {
                Monitor.d("2653797");
            } else {
                Monitor.d("2653798");
            }
        }
        VersionChecker versionChecker = this.upgradeablePluginManager.getVersionChecker();
        String[] strArr = {VersionChecker.SOURCE_CGI, VersionChecker.SOURCE_BACKUP_STABLE};
        StringBuilder sb5 = new StringBuilder();
        int i16 = 0;
        InstalledPlugin installedPlugin3 = null;
        while (true) {
            if (i16 >= 2) {
                z16 = r102;
                str = "getPluginFromServer: \u5f00\u59cb\u4ece\u670d\u52a1\u5668\u4e2d\u83b7\u53d6InstalledPlugin\u7ed3\u675f\uff1aresult == null ? ";
                break;
            }
            String str4 = strArr[i16];
            try {
                try {
                    r102 = "getPluginFromServer: \u5f00\u59cb\u4ece\u670d\u52a1\u5668\u4e2d\u83b7\u53d6InstalledPlugin\u7ed3\u675f\uff1aresult == null ? ";
                    i3 = i16;
                    try {
                        TargetDownloadInfo checkForceUpdate = versionChecker.checkForceUpdate(str4, this.mUin, this.mAppName, this.mTestEnv, installedPlugin);
                        try {
                            try {
                                if (str4.equals(VersionChecker.SOURCE_CGI)) {
                                    Monitor.d("2653754");
                                } else if (str4.equals(VersionChecker.SOURCE_BACKUP_STABLE)) {
                                    Monitor.d("2653758");
                                }
                                log(TAG, HardCodeUtil.qqStr(R.string.nbp) + checkForceUpdate.url);
                                this.mTotalSize = checkForceUpdate.size;
                                if (checkForceUpdate.forceUpdate && installedPlugin != null) {
                                    doForceUpdate(installedPlugin);
                                }
                                if ((checkForceUpdate instanceof MultiTargetDownloadInfo) && (map = ((MultiTargetDownloadInfo) checkForceUpdate).allSubTargets) != null) {
                                    for (Map.Entry<String, TargetDownloadInfo> entry : map.entrySet()) {
                                        if (TextUtils.equals(entry.getKey(), this.mPluginPackageName)) {
                                            this.mTotalSize = entry.getValue().size;
                                        }
                                    }
                                }
                                this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 0, Long.valueOf(this.mTotalSize)));
                                if ("checkVersion".equals(this.mAction)) {
                                    return null;
                                }
                                if (!this.mIsHaveCache) {
                                    publishProgress(10);
                                }
                                log(TAG, "updatePlugin start");
                                long currentTimeMillis3 = System.currentTimeMillis();
                                this.mGetPluginFuture = this.upgradeablePluginManager.updatePlugin(this.mAppName, checkForceUpdate, this.mPluginPackageName);
                                try {
                                    InstalledPlugin downloadPluginDownloadInfo = downloadPluginDownloadInfo(this.mGetPluginFuture.get(0));
                                    try {
                                        int currentTimeMillis4 = (int) (System.currentTimeMillis() - currentTimeMillis3);
                                        installedPlugin2 = downloadPluginDownloadInfo;
                                        r112 = str4;
                                        try {
                                            report("updatePlugin", downloadPluginDownloadInfo == null ? -1 : downloadPluginDownloadInfo.pluginFileType, currentTimeMillis4, "", "");
                                            log(TAG, HardCodeUtil.qqStr(R.string.f172100nc3) + currentTimeMillis4);
                                            if (r112.equals(VersionChecker.SOURCE_CGI)) {
                                                Monitor.d("2653761");
                                            } else if (r112.equals(VersionChecker.SOURCE_BACKUP_STABLE)) {
                                                Monitor.d("2653765");
                                            }
                                            try {
                                                ?? sb6 = new StringBuilder();
                                                sb6.append(r102);
                                                sb6.append(installedPlugin2 == null);
                                                log(TAG, sb6.toString());
                                                return installedPlugin2;
                                            } catch (Exception e16) {
                                                e = e16;
                                                installedPlugin3 = installedPlugin2;
                                                if (QLog.isColorLevel()) {
                                                    QLog.e(TAG, 2, "\u4ece" + r112 + "\u83b7\u53d6\u63d2\u4ef6\u5931\u8d25\u3002", e);
                                                }
                                                ((IHuayangCrashReport) QRoute.api(IHuayangCrashReport.class)).report(e);
                                                sb5.append(e.toString());
                                                sb5.append("\u3002");
                                                if (!r112.equals(VersionChecker.SOURCE_CGI) || !this.mIsHaveCache) {
                                                    if (this.mGetPluginFuture != null) {
                                                        Iterator<ProgressFuture<InstalledPlugin>> it = this.mGetPluginFuture.iterator();
                                                        while (it.hasNext()) {
                                                            it.next().cancel(true);
                                                        }
                                                        z17 = true;
                                                        this.mGetPluginFuture = null;
                                                    } else {
                                                        z17 = true;
                                                    }
                                                    i16 = i3 + 1;
                                                    r102 = z17;
                                                    r112 = -1;
                                                } else {
                                                    z16 = true;
                                                    str = r102;
                                                    StringBuilder sb7 = new StringBuilder();
                                                    sb7.append(str);
                                                    sb7.append(installedPlugin3 != null ? z16 : false);
                                                    log(TAG, sb7.toString());
                                                    Monitor.d("2653760");
                                                    if (this.mIsHaveCache) {
                                                    }
                                                    throw new VersionCheckException("\u4ece\u670d\u52a1\u5668\u83b7\u53d6InstalledPlugin\u5931\u8d25\u3002" + sb5.toString());
                                                }
                                            }
                                        } catch (Exception e17) {
                                            e = e17;
                                            str3 = r112;
                                            if (!str3.equals(VersionChecker.SOURCE_CGI)) {
                                                if (str3.equals(VersionChecker.SOURCE_BACKUP_STABLE)) {
                                                    Monitor.d("2653766");
                                                }
                                            } else {
                                                Monitor.d("2653762");
                                            }
                                            throw e;
                                        }
                                    } catch (Exception e18) {
                                        e = e18;
                                        installedPlugin2 = downloadPluginDownloadInfo;
                                        r112 = str4;
                                    }
                                } catch (Exception e19) {
                                    e = e19;
                                    str3 = str4;
                                }
                            } catch (VersionCheckException e26) {
                                e = e26;
                                str2 = str4;
                                if (!str2.equals(VersionChecker.SOURCE_CGI)) {
                                    if (str2.equals(VersionChecker.SOURCE_BACKUP_STABLE)) {
                                        Monitor.d("2653759");
                                    }
                                } else {
                                    Monitor.d("2653755");
                                }
                                throw e;
                            }
                        } catch (Exception e27) {
                            e = e27;
                            r112 = str4;
                        }
                    } catch (VersionCheckException e28) {
                        e = e28;
                        str2 = str4;
                    } catch (Exception e29) {
                        e = e29;
                        r112 = str4;
                    }
                } catch (VersionCheckException e36) {
                    e = e36;
                    str2 = str4;
                } catch (Exception e37) {
                    e = e37;
                    r112 = str4;
                    r102 = "getPluginFromServer: \u5f00\u59cb\u4ece\u670d\u52a1\u5668\u4e2d\u83b7\u53d6InstalledPlugin\u7ed3\u675f\uff1aresult == null ? ";
                    i3 = i16;
                }
            } catch (Exception e38) {
                e = e38;
            }
            i16 = i3 + 1;
            r102 = z17;
            r112 = -1;
        }
        StringBuilder sb72 = new StringBuilder();
        sb72.append(str);
        sb72.append(installedPlugin3 != null ? z16 : false);
        log(TAG, sb72.toString());
        Monitor.d("2653760");
        if (this.mIsHaveCache) {
            Monitor.d("2528856");
        }
        throw new VersionCheckException("\u4ece\u670d\u52a1\u5668\u83b7\u53d6InstalledPlugin\u5931\u8d25\u3002" + sb5.toString());
    }

    private void reportPreDownload(InstalledPlugin installedPlugin, Exception exc, int i3) {
        String str;
        if (installedPlugin != null) {
            report("preDownloadFinish", 1, i3, installedPlugin.toString(), null);
            return;
        }
        if (exc != null) {
            str = exc.getMessage();
        } else {
            str = "";
        }
        report("preDownloadFinish", 0, i3, str, null);
    }
}
