package com.tencent.mobileqq.intervideo.huayang.impl;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.intervideo.ILoginKeyHelper;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity;
import com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangJsPlugin;
import com.tencent.mobileqq.intervideo.huayang.IHuayangOpenHelper;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.intervideo.huayang.c;
import com.tencent.mobileqq.intervideo.od.IODProxyUtil;
import com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proxyinner.plugin.loader.QTProxyService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.PluginProcessService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HuayangDowanloadHelperImpl implements PluginProcessKiller, IHuayangDowanloadHelper {
    private IHuayangPluginNewDownloader huayangPluginNewDownloader;
    private volatile boolean isNeedStop;
    private String mAction;
    private Context mAppContext;
    private String mAppName;
    private IVPluginDataReporter mDataReporter;
    private Map<String, IVPluginInfo> mPluginInfoMap;
    private String mPluginPackageName;
    private long mStartGetHYAITime;
    private long mStartGetODAITime;
    private String mUin;
    private String mUri;
    private ILoginKeyHelper mLoginKeyHelper = (ILoginKeyHelper) QRoute.api(ILoginKeyHelper.class);
    private List<GetLoginKeyDataListener> mGetLoginKeyDataListeners = new ArrayList();
    private IHuayangPluginNewDownloader.a pluginDownloaderPreLoaderListener = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class GetLoginKeyDataListener implements ILoginKeyHelper.b {
        private Handler C = new Handler(Looper.getMainLooper());

        /* renamed from: d, reason: collision with root package name */
        private final IVPluginInfo f238258d;

        /* renamed from: e, reason: collision with root package name */
        private final InstalledPlugin f238259e;

        /* renamed from: f, reason: collision with root package name */
        private final boolean f238260f;

        /* renamed from: h, reason: collision with root package name */
        private final String f238261h;

        /* renamed from: i, reason: collision with root package name */
        private final long f238262i;

        /* renamed from: m, reason: collision with root package name */
        private volatile boolean f238263m;

        public GetLoginKeyDataListener(String str, IVPluginInfo iVPluginInfo, InstalledPlugin installedPlugin, boolean z16, long j3) {
            this.f238261h = str;
            this.f238258d = iVPluginInfo;
            this.f238259e = installedPlugin;
            this.f238260f = z16;
            this.f238262i = j3;
        }

        @Override // com.tencent.mobileqq.intervideo.ILoginKeyHelper.b
        public void a(String str, boolean z16, int i3) {
            String str2;
            if (z16) {
                IVPluginInfo iVPluginInfo = this.f238258d;
                int i16 = iVPluginInfo.C;
                if (i16 == 1) {
                    iVPluginInfo.D = HuayangDowanloadHelperImpl.this.mLoginKeyHelper.getAccountInfo().f238095d.getExtras();
                    if ("Hy".equalsIgnoreCase(this.f238258d.f238101d)) {
                        Monitor.d("2653752");
                    }
                } else if (i16 == 2) {
                    iVPluginInfo.D = ((IODProxyUtil) QRoute.api(IODProxyUtil.class)).getODIntentBundle(this.f238258d, HuayangDowanloadHelperImpl.this.mLoginKeyHelper);
                    if ("Od".equalsIgnoreCase(this.f238258d.f238101d)) {
                        Monitor.d("2691711");
                    }
                }
            } else {
                if ("Hy".equalsIgnoreCase(this.f238258d.f238101d)) {
                    Monitor.d("2653753");
                } else if ("Od".equalsIgnoreCase(this.f238258d.f238101d)) {
                    Monitor.d("2691712");
                }
                QQToast.makeText(HuayangDowanloadHelperImpl.this.mAppContext, HardCodeUtil.qqStr(R.string.nbk) + i3, 0).show();
            }
            g(this.f238260f, z16);
            long currentTimeMillis = System.currentTimeMillis() - ("Hy".equalsIgnoreCase(this.f238258d.f238101d) ? HuayangDowanloadHelperImpl.this.mStartGetHYAITime : HuayangDowanloadHelperImpl.this.mStartGetODAITime);
            if (QLog.isColorLevel()) {
                QLog.d(IHuayangPluginNewDownloader.TAG, 2, "\u62c9\u53d6\u7968\u636e\u5b8c\u6210 \u8017\u65f6\uff1a" + currentTimeMillis + "appId = " + str + " isSuccess =  " + z16 + " code = " + i3);
            }
            if (Monitor.a()) {
                str2 = "huayang";
            } else {
                str2 = "group_video";
            }
            id0.a.n(str2, "getLoginKey", z16 ? 1 : 0, (int) currentTimeMillis, HuayangDowanloadHelperImpl.this.mAppName, i3 + "", str, AppSetting.f99551k);
            HuayangDowanloadHelperImpl.this.mDataReporter.opName(HuayangDowanloadHelperImpl.this.mPluginPackageName).opType("getLoginKey").opIn(z16 ? 1 : 0).opResult(i3).report();
        }

        public void f() {
            this.f238263m = true;
            this.C.removeCallbacksAndMessages(null);
        }

        private void g(final boolean z16, final boolean z17) {
            if (z16 && !z17) {
                HuayangDowanloadHelperImpl.this.pluginDownloaderPreLoaderListener.a(5, "");
                return;
            }
            long j3 = z16 ? 0L : 2000L;
            if (this.f238263m) {
                if (QLog.isColorLevel()) {
                    QLog.d(IHuayangPluginNewDownloader.TAG, 2, "\u9700\u8981stop");
                    return;
                }
                return;
            }
            this.C.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.intervideo.huayang.impl.HuayangDowanloadHelperImpl.GetLoginKeyDataListener.1
                @Override // java.lang.Runnable
                public void run() {
                    if (QLog.isColorLevel()) {
                        QLog.d(IHuayangPluginNewDownloader.TAG, 2, "startLoadingActivity\uff1a" + System.currentTimeMillis());
                    }
                    if (!HuayangDowanloadHelperImpl.this.isNeedStop) {
                        HuayangLoadbackgroudActivity.d(HuayangDowanloadHelperImpl.this.mAppContext, GetLoginKeyDataListener.this.f238261h, GetLoginKeyDataListener.this.f238258d, GetLoginKeyDataListener.this.f238259e, HuayangDowanloadHelperImpl.this.mUin, z16 ? HuayangDowanloadHelperImpl.this.mUri : null, z17, z16, HuayangDowanloadHelperImpl.this.mAppName, GetLoginKeyDataListener.this.f238262i);
                    } else if (QLog.isColorLevel()) {
                        QLog.d(IHuayangPluginNewDownloader.TAG, 2, "isNeedStop");
                    }
                }
            }, j3);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a implements IHuayangPluginNewDownloader.a {
        a() {
        }

        @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginNewDownloader.a
        public void a(int i3, Object... objArr) {
            Intent intent = new Intent(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getDownloadNotifyAction(HuayangDowanloadHelperImpl.this.mPluginPackageName));
            intent.putExtra("key_state", i3);
            if (i3 == 0) {
                intent.putExtra("key_totalSize", ((Long) objArr[0]).longValue());
            } else if (i3 == 1) {
                int intValue = ((Integer) objArr[0]).intValue();
                intent.putExtra("key_totalSize", ((Long) objArr[1]).longValue());
                intent.putExtra("key_progress", intValue);
            } else if (i3 == 2) {
                intent.putExtra("key_installedplugin", (InstalledPlugin) objArr[0]);
                if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2691709");
                } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2597857");
                }
            } else if (i3 == 3) {
                intent.putExtra("key_error_msg", (String) objArr[0]);
                if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2691710");
                } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2597858");
                }
            } else if (i3 == 4) {
                if ("download".equals(HuayangDowanloadHelperImpl.this.mAction)) {
                    HuayangDowanloadHelperImpl.this.getAIData((InstalledPlugin) objArr[0], ((Boolean) objArr[1]).booleanValue(), ((Long) objArr[2]).longValue());
                }
                if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2691703");
                } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2597720");
                }
            } else if (i3 == 5) {
                intent.putExtra("key_error_msg", (String) objArr[0]);
                if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2691704");
                } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(HuayangDowanloadHelperImpl.this.mPluginPackageName)) {
                    Monitor.d("2597721");
                }
            } else if (i3 == 10) {
                HuayangDowanloadHelperImpl.this.stopLoad();
                return;
            }
            HuayangDowanloadHelperImpl.this.mAppContext.sendBroadcast(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stopLoad() {
        Iterator<GetLoginKeyDataListener> it = this.mGetLoginKeyDataListeners.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
        if (QLog.isColorLevel()) {
            QLog.d(IHuayangPluginNewDownloader.TAG, 2, "setStop");
        }
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper
    public void canceLauncher() {
        this.huayangPluginNewDownloader.setDonwanlodPreloadListener(null);
        this.mGetLoginKeyDataListeners.clear();
        this.mUin = null;
        this.mUri = null;
        this.mAction = null;
        if (!NetworkUtil.isWifiEnabled(this.mAppContext)) {
            this.huayangPluginNewDownloader.cancelDownload();
        }
        this.huayangPluginNewDownloader.cancelLauncher();
    }

    @Override // com.tencent.mobileqq.intervideo.shadow.PluginProcessKiller
    public void onKillPluginProcess() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.isNeedStop = true;
            Intent intent = new Intent(this.mAppContext, (Class<?>) QTProxyService.class);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            long currentTimeMillis = System.currentTimeMillis();
            QLog.i(IHuayangPluginNewDownloader.TAG, 2, "bindService ");
            this.mAppContext.bindService(intent, new b(countDownLatch), 1);
            try {
                if (true ^ countDownLatch.await(3L, TimeUnit.SECONDS)) {
                    QLog.e(IHuayangPluginNewDownloader.TAG, 2, "onKillPluginProcess timeout");
                    ((IHuayangOpenHelper) QRoute.api(IHuayangOpenHelper.class)).killProcess(this.mAppContext, this.mAppContext.getPackageName() + ":troophomework");
                }
            } catch (InterruptedException e16) {
                e16.printStackTrace();
            }
            QLog.i(IHuayangPluginNewDownloader.TAG, 2, "onKillPluginProcess end costTime:" + (System.currentTimeMillis() - currentTimeMillis));
            return;
        }
        throw new RuntimeException(HardCodeUtil.qqStr(R.string.nbj));
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper
    public void downloadPlugin(String str, String str2, String str3, String str4, Map<String, IVPluginInfo> map) {
        this.isNeedStop = false;
        this.huayangPluginNewDownloader.setUin(str2);
        if (!str2.equals(this.mUin)) {
            this.mLoginKeyHelper.clearAccount();
        }
        Monitor.c(TextUtils.equals(str, "hy_sixgod"));
        this.mUin = str2;
        this.mUri = str3;
        this.mAction = str4;
        this.mAppName = str;
        this.mPluginInfoMap = map;
        this.mGetLoginKeyDataListeners.clear();
        this.huayangPluginNewDownloader.setDonwanlodPreloadListener(this.pluginDownloaderPreLoaderListener);
        this.huayangPluginNewDownloader.download(str, str4, this.mPluginPackageName, map);
    }

    @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangDowanloadHelper
    public HuayangDowanloadHelperImpl init(Context context, String str, String str2) {
        this.mAppContext = context.getApplicationContext();
        this.mPluginPackageName = str;
        IVPluginDataReporter iVPluginDataReporter = new IVPluginDataReporter();
        this.mDataReporter = iVPluginDataReporter;
        iVPluginDataReporter.opDepartment(str2);
        this.huayangPluginNewDownloader = c.b(context, str, str2);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getAIData(InstalledPlugin installedPlugin, boolean z16, long j3) {
        IVPluginInfo iVPluginInfo = this.mPluginInfoMap.get(installedPlugin.pluginPackageName);
        if (QLog.isColorLevel()) {
            QLog.d(IHuayangPluginNewDownloader.TAG, 2, "\u5f00\u59cb\u62c9\u53d6AI\u7968\u636e\uff1a" + iVPluginInfo.C);
        }
        GetLoginKeyDataListener getLoginKeyDataListener = new GetLoginKeyDataListener(this.mPluginPackageName, iVPluginInfo, installedPlugin, z16, j3);
        this.mGetLoginKeyDataListeners.add(getLoginKeyDataListener);
        int i3 = iVPluginInfo.C;
        if (i3 == 1) {
            this.mStartGetHYAITime = System.currentTimeMillis();
            this.mLoginKeyHelper.getA1(this.mUin, iVPluginInfo.f238101d, iVPluginInfo.f238103f, iVPluginInfo.f238102e, getLoginKeyDataListener, true, iVPluginInfo.L);
        } else if (i3 == 2) {
            this.mStartGetODAITime = System.currentTimeMillis();
            this.mLoginKeyHelper.getAccessToken((AppInterface) ((BaseApplicationImpl) BaseApplication.getContext()).waitAppRuntime(null), iVPluginInfo.f238101d, this.mAppContext, iVPluginInfo.f238102e, getLoginKeyDataListener);
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements ServiceConnection {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ CountDownLatch f238268d;

        b(CountDownLatch countDownLatch) {
            this.f238268d = countDownLatch;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            QLog.i(IHuayangPluginNewDownloader.TAG, 2, "onServiceConnected ");
            HuayangDowanloadHelperImpl.this.mAppContext.unbindService(this);
            try {
                PluginProcessService.wrapBinder(iBinder).exit();
            } catch (Exception e16) {
                QLog.d(IHuayangPluginNewDownloader.TAG, 2, "exit over", e16);
            }
            this.f238268d.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }
}
