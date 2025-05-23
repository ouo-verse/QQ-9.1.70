package com.tencent.mobileqq.intervideo.od;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.huayang.Monitor;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.a;
import com.tencent.mobileqq.qroute.module.d;
import com.tencent.mobileqq.troop.utils.api.ITroopBeaconReporter;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import common.config.service.QzoneConfig;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.PluginInfo;
import cooperation.plugin.PluginUpdater;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ODQShadowLoad {

    /* renamed from: j, reason: collision with root package name */
    public static boolean f238394j = false;

    /* renamed from: k, reason: collision with root package name */
    private static boolean f238395k = false;

    /* renamed from: l, reason: collision with root package name */
    private static Handler f238396l;

    /* renamed from: m, reason: collision with root package name */
    private static MyRunnable f238397m;

    /* renamed from: n, reason: collision with root package name */
    private static final BroadcastReceiver f238398n = new a();

    /* renamed from: a, reason: collision with root package name */
    private QQProgressDialog f238399a;

    /* renamed from: c, reason: collision with root package name */
    private boolean f238401c;

    /* renamed from: d, reason: collision with root package name */
    private com.tencent.mobileqq.qroute.module.a f238402d;

    /* renamed from: e, reason: collision with root package name */
    private Bundle f238403e;

    /* renamed from: g, reason: collision with root package name */
    private ODPluginLoadUI f238405g;

    /* renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f238406h;

    /* renamed from: b, reason: collision with root package name */
    private final IVPluginDataReporter f238400b = new IVPluginDataReporter();

    /* renamed from: f, reason: collision with root package name */
    private final ExecutorService f238404f = ThreadManagerExecutor.getSingleThreadExecutorService(192);

    /* renamed from: i, reason: collision with root package name */
    private String f238407i = "";

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class MyRunnable implements Runnable {
        MyRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z16;
            String str = BaseApplicationImpl.sApplication.getPackageName() + ":troophomework";
            ActivityManager activityManager = (ActivityManager) BaseApplicationImpl.sApplication.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            if (activityManager != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = SystemMethodProxy.getRunningAppProcesses(activityManager).iterator();
                while (it.hasNext()) {
                    if (str.equalsIgnoreCase(it.next().processName)) {
                        z16 = true;
                        break;
                    }
                }
            }
            z16 = false;
            if (z16) {
                if (ODQShadowLoad.f238396l != null) {
                    ODQShadowLoad.f238396l.postDelayed(this, 10000L);
                    return;
                }
                return;
            }
            ODQShadowLoad.f238394j = false;
            if (ODQShadowLoad.f238395k) {
                ODQShadowLoad.f238395k = false;
                try {
                    BaseApplicationImpl.sApplication.unregisterReceiver(ODQShadowLoad.f238398n);
                } catch (IllegalArgumentException e16) {
                    QLog.e("ODQShadowLoad", 1, "unregisterReceiver failed. " + e16.getMessage());
                }
            }
            if (ODQShadowLoad.f238396l != null) {
                ODQShadowLoad.f238396l.removeCallbacks(ODQShadowLoad.f238397m);
                ODQShadowLoad.f238397m = null;
                ODQShadowLoad.f238396l = null;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            QLog.i("ODQShadowLoad", 1, "recv " + intent.getAction());
            if ("com.tencent.ACTION_TROOPHOMEWORK_ENTER_ROOM".equals(intent.getAction())) {
                ODQShadowLoad.f238394j = true;
                return;
            }
            if ("com.tencent.ACTION_TROOPHOMEWORK_EXIT_ROOM".equals(intent.getAction())) {
                ODQShadowLoad.f238394j = false;
                if (ODQShadowLoad.f238395k) {
                    ODQShadowLoad.f238395k = false;
                    try {
                        BaseApplicationImpl.sApplication.unregisterReceiver(ODQShadowLoad.f238398n);
                    } catch (IllegalArgumentException e16) {
                        QLog.e("ODQShadowLoad", 1, "unregisterReceiver failed. " + e16.getMessage());
                    }
                }
                if (ODQShadowLoad.f238396l != null) {
                    ODQShadowLoad.f238396l.removeCallbacks(ODQShadowLoad.f238397m);
                    ODQShadowLoad.f238397m = null;
                    ODQShadowLoad.f238396l = null;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements PluginUpdater.b {
        b() {
        }

        @Override // cooperation.plugin.PluginUpdater.b
        public boolean h1(PluginInfo pluginInfo) {
            return false;
        }

        @Override // cooperation.plugin.PluginUpdater.b
        public void z1(boolean z16) {
            QLog.d("ODQShadowLoad", 1, "onUpdateFinish " + z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class c implements com.tencent.mobileqq.qroute.module.c {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<ODQShadowLoad> f238409a;

        public c(ODQShadowLoad oDQShadowLoad) {
            this.f238409a = new WeakReference<>(oDQShadowLoad);
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallBegin(String str) {
            QLog.d("ODQShadowLoad", 1, "onInstallBegin " + str);
            if (this.f238409a.get() != null) {
                this.f238409a.get().w();
            }
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallDownloadProgress(String str, int i3, int i16) {
            if (this.f238409a.get() == null || !this.f238409a.get().v()) {
                return;
            }
            this.f238409a.get().S(i3, i16);
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallError(String str, int i3) {
            QLog.d("ODQShadowLoad", 1, "onInstallError " + str + ";" + i3);
            if (this.f238409a.get() == null || !this.f238409a.get().v()) {
                return;
            }
            if (i3 == 2) {
                this.f238409a.get().H();
            } else {
                this.f238409a.get().N(false, i3);
                this.f238409a.get().Q();
            }
        }

        @Override // com.tencent.mobileqq.qroute.module.c
        public void onInstallFinish(String str) {
            QLog.d("ODQShadowLoad", 1, "onInstallFinish " + str);
            if (this.f238409a.get() == null || !this.f238409a.get().v()) {
                return;
            }
            this.f238409a.get().H();
            this.f238409a.get().N(true, 0);
        }
    }

    public ODQShadowLoad(ODLoadingActivity oDLoadingActivity) {
        this.f238406h = new WeakReference<>(oDLoadingActivity);
    }

    public static boolean A() {
        QLog.d("ODQShadowLoad", 1, "isInTroophomeworkRoom: " + f238394j);
        return f238394j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void B() {
        QQToast.makeText(BaseApplication.getContext(), R.string.f171176cx2, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(boolean z16) {
        QLog.i("ODQShadowLoad", 1, "loadPlugin.onOpenResult: " + z16);
        O(z16);
        w();
        if (v()) {
            this.f238406h.get().finish();
        }
        if (!z16) {
            P(new Runnable() { // from class: com.tencent.mobileqq.intervideo.od.j
                @Override // java.lang.Runnable
                public final void run() {
                    ODQShadowLoad.B();
                }
            });
            return;
        }
        QLog.i("ODQShadowLoad", 1, "register ACTION_TROOPHOMEWORK_ENTER_EXIT_ROOM");
        IntentFilter intentFilter = new IntentFilter("com.tencent.ACTION_TROOPHOMEWORK_EXIT_ROOM");
        intentFilter.addAction("com.tencent.ACTION_TROOPHOMEWORK_ENTER_ROOM");
        intentFilter.addAction("com.tencent.ACTION_TROOPHOMEWORK_EXIT_ROOM");
        f238395k = true;
        BaseApplicationImpl.sApplication.registerReceiver(f238398n, intentFilter);
        f238396l = new Handler(Looper.getMainLooper());
        MyRunnable myRunnable = new MyRunnable();
        f238397m = myRunnable;
        f238396l.postDelayed(myRunnable, 10000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        try {
            Bundle a16 = new com.tencent.mobileqq.intervideo.od.a().a("Od", "1104763709", "qvideo.qq.com");
            QLog.d("ODQShadowLoad", 1, "loadPlugin start");
            this.f238403e.putLong("plugin_start_time", System.currentTimeMillis());
            this.f238402d.f(new d.b(BaseApplication.getContext()).g("GroupVideo-main").b("com.tencent.od.app.newloginprocess.LoginActivity").d(new Intent().putExtras(this.f238403e).putExtras(a16)).e(new a.InterfaceC8440a() { // from class: com.tencent.mobileqq.intervideo.od.h
                @Override // com.tencent.mobileqq.qroute.module.a.InterfaceC8440a
                public final void a(boolean z16) {
                    ODQShadowLoad.this.C(z16);
                }
            }).a());
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E(long j3) {
        com.tencent.mobileqq.qroute.module.e j16;
        com.tencent.mobileqq.qroute.module.a aVar = this.f238402d;
        if (aVar != null && (j16 = aVar.j()) != null) {
            this.f238407i = j16.f();
        }
        this.f238403e.putString("plugin_type", "qshadow");
        L(j3, this.f238407i, Long.valueOf(this.f238403e.getLong("roomid", 0L)));
        if (z()) {
            return;
        }
        x();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void F(final long j3) {
        y();
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.intervideo.od.f
            @Override // java.lang.Runnable
            public final void run() {
                ODQShadowLoad.this.E(j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void G() {
        QQToast.makeText(BaseApplication.getContext(), R.string.av_, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        this.f238404f.submit(new Runnable() { // from class: com.tencent.mobileqq.intervideo.od.g
            @Override // java.lang.Runnable
            public final void run() {
                ODQShadowLoad.this.D();
            }
        });
    }

    private void L(long j3, String str, Long l3) {
        HashMap hashMap = new HashMap();
        hashMap.put("plugin_version", str);
        hashMap.put("group_uin", l3);
        hashMap.put("plugin_type", "qshadow");
        hashMap.put(QzoneConfig.SECONDARY_KEY_IS_SHOW_ENTRANCE, Long.valueOf(j3));
        VideoReport.reportEvent("group_video_open", hashMap);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_open", hashMap);
    }

    private void M() {
        HashMap hashMap = new HashMap();
        hashMap.put("plugin_version", this.f238407i);
        VideoReport.reportEvent("group_video_direct_launch", hashMap);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_direct_launch", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N(boolean z16, int i3) {
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.qroute.module.e j3 = this.f238402d.j();
        if (j3 != null) {
            hashMap.put("plugin_version", j3.f());
            hashMap.put("plugin_url", j3.e());
            hashMap.put("plugin_length", Long.valueOf(j3.c()));
            hashMap.put("plugin_download_duration", Long.valueOf(j3.b()));
            hashMap.put("plugin_dex2oat_duration", Long.valueOf(j3.a()));
        }
        hashMap.put("plugin_type", "qshadow");
        hashMap.put("is_preload", Boolean.FALSE);
        hashMap.put("is_succeed", Boolean.valueOf(z16));
        hashMap.put("error_msg", Integer.valueOf(i3));
        VideoReport.reportEvent("group_video_plugin_install", hashMap);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_plugin_install", hashMap);
    }

    private void O(boolean z16) {
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.qroute.module.e j3 = this.f238402d.j();
        if (j3 != null) {
            hashMap.put("plugin_version", j3.f());
        }
        hashMap.put("is_succeed", Boolean.valueOf(z16));
        VideoReport.reportEvent("group_video_plugin_launch", hashMap);
        ((ITroopBeaconReporter) QRoute.api(ITroopBeaconReporter.class)).report("group_video_plugin_launch", hashMap);
    }

    private void P(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Q() {
        P(new Runnable() { // from class: com.tencent.mobileqq.intervideo.od.i
            @Override // java.lang.Runnable
            public final void run() {
                ODQShadowLoad.G();
            }
        });
        if (v()) {
            this.f238406h.get().finish();
        }
    }

    private void R() {
        if (this.f238406h.get() != null) {
            ODPluginLoadUI oDPluginLoadUI = new ODPluginLoadUI(this.f238406h.get());
            this.f238405g = oDPluginLoadUI;
            oDPluginLoadUI.setInit();
            this.f238406h.get().setContentView(this.f238405g);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S(int i3, int i16) {
        this.f238405g.g(i3, i16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.f238399a == null && this.f238406h.get() != null) {
            QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f238406h.get(), 40);
            this.f238399a = qQProgressDialog;
            qQProgressDialog.setMessage(HardCodeUtil.qqStr(R.string.f172268oy1));
        }
        QQProgressDialog qQProgressDialog2 = this.f238399a;
        if (qQProgressDialog2 != null) {
            qQProgressDialog2.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean v() {
        return (this.f238406h.get() == null || this.f238406h.get().isFinishing() || this.f238406h.get().isDestroyed()) ? false : true;
    }

    private void x() {
        if (!this.f238402d.b()) {
            QLog.d("ODQShadowLoad", 1, "plugin is not Installed");
            if (v()) {
                R();
            }
            this.f238402d.d(new c(this));
            return;
        }
        QLog.d("ODQShadowLoad", 1, "plugin.loadPlugin");
        M();
        H();
    }

    private void y() {
        IPluginManager iPluginManager = (IPluginManager) ((QQAppInterface) BaseApplicationImpl.sApplication.peekAppRuntime()).getManager(QQManagerFactory.MGR_PLUGIN);
        b bVar = new b();
        iPluginManager.m5(bVar);
        try {
            try {
                this.f238402d = QRoute.plugin("GroupVideo.apk");
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        } finally {
            iPluginManager.F5(bVar);
        }
    }

    private boolean z() {
        if (!QLog.isColorLevel()) {
            return false;
        }
        QLog.d("ODQShadowLoad", 2, "installDebugPluginAsNeeded: false not debug");
        return false;
    }

    public void I() {
        this.f238400b.opType("onBackPressed").report();
        ODPluginLoadUI oDPluginLoadUI = this.f238405g;
        if (oDPluginLoadUI != null) {
            oDPluginLoadUI.c();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v21, types: [long] */
    public void J(Bundle bundle) {
        if (this.f238406h.get() == null) {
            return;
        }
        Bundle bundle2 = new Bundle(this.f238406h.get().getIntent().getExtras());
        this.f238403e = bundle2;
        String string = bundle2.getString("fromId");
        int i3 = 2;
        i3 = 2;
        final long j3 = 0;
        try {
            if (string != null) {
                ?? parseLong = Long.parseLong(string);
                j3 = parseLong;
                i3 = parseLong;
            } else {
                QLog.e("ODQShadowLoad", 2, "not have fromId");
            }
        } catch (NumberFormatException unused) {
            QLog.e("ODQShadowLoad", i3, "fromId not long");
        }
        String string2 = this.f238403e.getString("bizType");
        this.f238403e.putString("qqVersion", AppSetting.f99551k);
        this.f238403e.putBoolean("isGooglePlayVersion", false);
        this.f238403e.putBoolean("IS_CPU_64_BIT", true);
        this.f238403e.putBoolean("IS_SUPPORT_CASTER", true);
        this.f238400b.opDepartment("shadow").opName(string2).d1(String.valueOf(j3));
        this.f238400b.opType("enterLoading").report();
        Monitor.b("33669907");
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.intervideo.od.ODQShadowLoad.2
            @Override // java.lang.Runnable
            public void run() {
                if (ODQShadowLoad.this.f238401c) {
                    return;
                }
                ODQShadowLoad.this.T();
            }
        }, 200L);
        this.f238404f.submit(new Runnable() { // from class: com.tencent.mobileqq.intervideo.od.e
            @Override // java.lang.Runnable
            public final void run() {
                ODQShadowLoad.this.F(j3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w() {
        this.f238401c = true;
        QQProgressDialog qQProgressDialog = this.f238399a;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.f238399a = null;
        }
    }

    public void K() {
        QLog.d("ODQShadowLoad", 1, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        w();
    }
}
