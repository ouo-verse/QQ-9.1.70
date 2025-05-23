package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.common.config.AppSetting;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.pluginloader.DynamicPluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.PluginLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.RunningPlugin;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes33.dex */
public class HuayangPluginLauncher implements IHuayangPluginLauncher {
    private static final int MSG_NOTIFY_LAUNCH_COMPLETED = 3;
    private static final int MSG_NOTIFY_LOAD_COMPLETED = 2;
    private static final int MSG_UPDATE_PROGRESS = 1;
    public static final String TAG = "HuayangPluginLauncher";
    private static Map<String, HuayangPluginLauncher> sLauncherMap = new HashMap();
    private final Context appContext;
    private final InstalledPlugin installedPlugin;
    private boolean isMainPlugin;
    private boolean isNeedStart;
    private String mAppName;
    private IVPluginInfo mPluginInfo;
    private int mProgress;
    private boolean mRunning;
    private RunningPlugin mRunningPlugin;
    private long mStartTime;
    private String mTargetPageUri;
    private String mUin;
    volatile boolean mStartActivityCalled = false;
    volatile boolean mStartPluginCalled = false;
    private Handler.Callback mUiHandlerCallback = new a();
    private final List<IHuayangPluginLauncher.a> mLauncherListeners = new LinkedList();
    private final Handler mUiHandler = new Handler(Looper.getMainLooper(), this.mUiHandlerCallback);
    private final PluginLoader pluginLoader = new DynamicPluginLoader();
    private IVPluginDataReporter mDataReporter = new IVPluginDataReporter();

    /* loaded from: classes33.dex */
    class a implements Handler.Callback {
        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i3 = message.what;
            if (i3 == 1) {
                Iterator it = HuayangPluginLauncher.this.mLauncherListeners.iterator();
                while (it.hasNext()) {
                    ((IHuayangPluginLauncher.a) it.next()).onProgressUpdate(message.arg1);
                }
            } else if (i3 == 2) {
                Intent intent = new Intent(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(HuayangPluginLauncher.this.mPluginInfo.f238103f));
                intent.putExtra("key_state", 6);
                HuayangPluginLauncher.this.appContext.sendBroadcast(intent);
                if (MonitorConfig.f238245i.get(HuayangPluginLauncher.this.mAppName) != null) {
                    Monitor.b(String.valueOf(MonitorConfig.f238245i.get(HuayangPluginLauncher.this.mAppName).f238249d));
                }
            } else if (i3 == 3) {
                Iterator it5 = HuayangPluginLauncher.this.mLauncherListeners.iterator();
                while (it5.hasNext()) {
                    ((IHuayangPluginLauncher.a) it5.next()).a(message.arg1 == 0, (Throwable) message.obj);
                }
                Intent intent2 = new Intent(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(HuayangPluginLauncher.this.mPluginInfo.f238103f));
                if (message.arg1 == 0) {
                    intent2.putExtra("key_state", ((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangPluginLauncher.this.mPluginInfo.f238103f) ? 9 : 8);
                    HuayangPluginLauncher.this.appContext.sendBroadcast(intent2);
                    if (MonitorConfig.f238245i.get(HuayangPluginLauncher.this.mAppName) != null) {
                        Monitor.b(String.valueOf(MonitorConfig.f238245i.get(HuayangPluginLauncher.this.mAppName).f238251f));
                    }
                } else {
                    if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangPluginLauncher.this.mPluginInfo.f238103f)) {
                        Monitor.d("2691708");
                    } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangPluginLauncher.this.mPluginInfo.f238103f)) {
                        Monitor.d("2597726");
                    } else if (MonitorConfig.f238245i.get(HuayangPluginLauncher.this.mAppName) != null) {
                        Monitor.b(String.valueOf(MonitorConfig.f238245i.get(HuayangPluginLauncher.this.mAppName).f238250e));
                    }
                    ((IHuayangCrashReport) QRoute.api(IHuayangCrashReport.class)).report((Throwable) message.obj);
                    intent2.putExtra("key_state", 7);
                    HuayangPluginLauncher.this.appContext.sendBroadcast(intent2);
                }
            }
            return false;
        }
    }

    HuayangPluginLauncher(Context context, InstalledPlugin installedPlugin) {
        this.installedPlugin = installedPlugin;
        this.appContext = context.getApplicationContext();
    }

    private Intent getPluginIntentData() {
        Intent intent = new Intent();
        String str = this.mTargetPageUri;
        if (str != null) {
            intent.setData(Uri.parse(str));
        }
        intent.putExtras(this.mPluginInfo.D);
        intent.putExtra("PluginStartMode", this.isMainPlugin ? 1 : 2);
        intent.putExtra("isNeedTransparent", true);
        intent.putExtra("qqVersion", AppSetting.f99551k);
        return intent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initPlugin(RunningPlugin runningPlugin) {
        long currentTimeMillis = System.currentTimeMillis();
        log(TAG, HardCodeUtil.qqStr(R.string.nbs) + this.installedPlugin.pluginFile);
        try {
            runningPlugin.startInitActivity(getPluginIntentData()).get();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5, new Object[0]);
            }
            ((IHuayangCrashReport) QRoute.api(IHuayangCrashReport.class)).report(th5);
        }
        log(TAG, HardCodeUtil.qqStr(R.string.nbq) + this.installedPlugin.pluginFile + HardCodeUtil.qqStr(R.string.nbn) + (System.currentTimeMillis() - currentTimeMillis));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RunningPlugin loadPlugin() {
        RunningPlugin runningPlugin;
        long currentTimeMillis = System.currentTimeMillis();
        log(TAG, HardCodeUtil.qqStr(R.string.nbo));
        try {
            ProgressFuture<RunningPlugin> loadPlugin = this.pluginLoader.loadPlugin(this.appContext, this.installedPlugin);
            if (loadPlugin == null) {
                log(TAG, HardCodeUtil.qqStr(R.string.nby) + (System.currentTimeMillis() - currentTimeMillis));
                notifyCompleted(false, new Exception("loadFuture == null"));
                return null;
            }
            Runnable runnable = new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.3

                /* renamed from: d, reason: collision with root package name */
                private int f238241d = 0;

                @Override // java.lang.Runnable
                public void run() {
                    HuayangPluginLauncher.this.publishProgress(this.f238241d);
                    int i3 = this.f238241d + 20;
                    this.f238241d = i3;
                    if (i3 < 80) {
                        HuayangPluginLauncher.this.mUiHandler.postDelayed(this, 300L);
                    }
                }
            };
            this.mUiHandler.post(runnable);
            try {
                runningPlugin = loadPlugin.get(100L, TimeUnit.SECONDS);
                e = null;
            } catch (Exception e16) {
                e = e16;
                if (QLog.isColorLevel()) {
                    QLog.e(TAG, 2, e, new Object[0]);
                }
                runningPlugin = null;
            }
            this.mUiHandler.removeCallbacks(runnable);
            if (e != null) {
                notifyCompleted(false, e);
                return null;
            }
            publishProgress(80);
            log(TAG, HardCodeUtil.qqStr(R.string.f172099nc2) + this.installedPlugin.pluginFile + HardCodeUtil.qqStr(R.string.nbx) + (System.currentTimeMillis() - currentTimeMillis));
            return runningPlugin;
        } catch (Exception e17) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "\u5728\u52a0\u8f7d\u63d2\u4ef6\u5e76\u8c03\u7528\u5176Application\u7684OnCreate\u65b9\u6cd5\u8fc7\u7a0b\u4e2d\u51fa\u9519", e17);
            }
            notifyCompleted(false, e17);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void log(String str, String str2) {
        if (QLog.isColorLevel()) {
            QLog.d(str, 2, str2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void publishProgress(int i3) {
        if (i3 < this.mProgress) {
            return;
        }
        log(TAG, HardCodeUtil.qqStr(R.string.nbw) + i3);
        this.mProgress = i3;
        this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 1, i3, 0));
    }

    private void report(String str, int i3, int i16, String str2, String str3, String str4) {
        this.mDataReporter.opDepartment(this.mAppName).opName(str).opType(str).opIn(i3).opResult(i16).d1(str2).d2(str3).d4(this.mPluginInfo.f238103f).report();
    }

    private void reportLaunchResult(boolean z16, String str) {
        String str2;
        int currentTimeMillis = (int) (System.currentTimeMillis() - this.mStartTime);
        if (this.isNeedStart) {
            str2 = "1";
        } else {
            str2 = "0";
        }
        report("launchFinish", z16 ? 1 : 0, currentTimeMillis, str, str2, this.mAppName + "_" + this.mPluginInfo.f238103f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startupPlugin(RunningPlugin runningPlugin) {
        this.mStartPluginCalled = true;
        long currentTimeMillis = System.currentTimeMillis();
        log(TAG, HardCodeUtil.qqStr(R.string.nbm) + this.installedPlugin.pluginFile);
        ProgressFuture startLauncherActivity = runningPlugin.startLauncherActivity(getPluginIntentData());
        publishProgress(90);
        try {
            startLauncherActivity.get();
            notifyCompleted(true, null);
            if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.mPluginInfo.f238103f)) {
                Monitor.d("2691707");
            } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.mPluginInfo.f238103f)) {
                Monitor.d("2597725");
            }
            SharedPreferences.Editor edit = this.appContext.getSharedPreferences("pre_huayang_plugin_new_start_mode", 4).edit();
            edit.putBoolean("huayang_plugin_start_flag" + this.mUin + this.mPluginInfo.f238103f, true);
            edit.putString("huayang_plugin_launch_appType_", this.mAppName);
            edit.apply();
            Monitor.d("2585917");
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, th5, new Object[0]);
            }
            notifyCompleted(false, th5);
        }
        log(TAG, HardCodeUtil.qqStr(R.string.f172098nc1) + this.installedPlugin.pluginFile + HardCodeUtil.qqStr(R.string.nbu) + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher
    public boolean isStartPluginCalled() {
        return this.mStartPluginCalled;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher
    public void launchPlugin(String str, boolean z16, final boolean z17, IVPluginInfo iVPluginInfo, String str2, String str3) {
        if (this.mRunning) {
            log(TAG, "launchPlugin mRunning return");
            return;
        }
        this.mRunning = true;
        this.mAppName = str3;
        this.mStartActivityCalled = false;
        this.mStartPluginCalled = false;
        this.isNeedStart = z16;
        this.isMainPlugin = z17;
        this.mPluginInfo = iVPluginInfo;
        this.mUin = str2;
        this.mStartTime = System.currentTimeMillis();
        this.mTargetPageUri = str;
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.HuayangPluginLauncher.2
            @Override // java.lang.Runnable
            public void run() {
                if (HuayangPluginLauncher.this.mRunningPlugin == null) {
                    HuayangPluginLauncher huayangPluginLauncher = HuayangPluginLauncher.this;
                    huayangPluginLauncher.mRunningPlugin = huayangPluginLauncher.loadPlugin();
                    if (z17) {
                        long currentTimeMillis = 1000 - (System.currentTimeMillis() - HuayangPluginLauncher.this.mStartTime);
                        if (currentTimeMillis > 0) {
                            HuayangPluginLauncher.this.log(HuayangPluginLauncher.TAG, HardCodeUtil.qqStr(R.string.f172101nc4) + currentTimeMillis);
                            try {
                                LockMethodProxy.sleep(currentTimeMillis);
                            } catch (InterruptedException e16) {
                                e16.printStackTrace();
                            }
                        }
                    }
                }
                if (HuayangPluginLauncher.this.mRunningPlugin != null && HuayangPluginLauncher.this.isNeedStart) {
                    if (z17) {
                        HuayangPluginLauncher.this.mUiHandler.sendMessage(Message.obtain(HuayangPluginLauncher.this.mUiHandler, 2));
                        HuayangPluginLauncher huayangPluginLauncher2 = HuayangPluginLauncher.this;
                        huayangPluginLauncher2.startupPlugin(huayangPluginLauncher2.mRunningPlugin);
                        HuayangPluginLauncher.this.mStartActivityCalled = true;
                    } else {
                        HuayangPluginLauncher huayangPluginLauncher3 = HuayangPluginLauncher.this;
                        huayangPluginLauncher3.initPlugin(huayangPluginLauncher3.mRunningPlugin);
                    }
                }
                HuayangPluginLauncher.this.mRunning = false;
            }
        });
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher
    public synchronized HuayangPluginLauncher getInstance(Context context, Object obj) {
        HuayangPluginLauncher huayangPluginLauncher;
        huayangPluginLauncher = sLauncherMap.get(((InstalledPlugin) obj).pluginFile.getName());
        if (huayangPluginLauncher == null) {
            huayangPluginLauncher = new HuayangPluginLauncher(context, (InstalledPlugin) obj);
            sLauncherMap.put(((InstalledPlugin) obj).pluginFile.getName(), huayangPluginLauncher);
        }
        return huayangPluginLauncher;
    }

    private void notifyCompleted(boolean z16, Throwable th5) {
        publishProgress(100);
        if (!z16 && !(th5 instanceof TimeoutException) && !(th5 instanceof InterruptedException)) {
            this.pluginLoader.setPluginDisabled(this.installedPlugin);
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "\u8bbe\u7f6e\u63d2\u4ef6\u542f\u52a8\u5931\u8d25\u6807\u5fd7\u5931\u8d25");
            }
        }
        this.mUiHandler.sendMessage(Message.obtain(this.mUiHandler, 3, !z16 ? 1 : 0, 0, th5));
        if (z16) {
            reportLaunchResult(z16, null);
        } else {
            reportLaunchResult(z16, th5.toString());
            ((IHuayangCrashReport) QRoute.api(IHuayangCrashReport.class)).report(th5);
        }
        this.mRunning = false;
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher
    public void addLauncherListener(IHuayangPluginLauncher.a aVar) {
        if (aVar != null) {
            this.mLauncherListeners.add(aVar);
        }
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher
    public void removeLauncherListener(IHuayangPluginLauncher.a aVar) {
        if (aVar != null) {
            this.mLauncherListeners.remove(aVar);
        }
    }
}
