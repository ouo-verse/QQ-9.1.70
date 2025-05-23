package com.tencent.mobileqq.intervideo.huayang;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.UseDynamicPluginLoaderInstalledPlugin;
import com.tencent.mobileqq.intervideo.IVPluginInfo;
import com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.dynamic.host.DynamicRuntime;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes33.dex */
public class HuayangLoadbackgroudActivity extends Activity {
    public static long C;

    /* renamed from: d, reason: collision with root package name */
    private IHuayangPluginLauncher f238227d;

    /* renamed from: e, reason: collision with root package name */
    private IVPluginInfo f238228e;

    /* renamed from: h, reason: collision with root package name */
    private String f238230h;

    /* renamed from: m, reason: collision with root package name */
    private static Map<String, InstalledApk> f238226m = new HashMap();
    private static BroadcastReceiver D = new a();

    /* renamed from: f, reason: collision with root package name */
    private long f238229f = 0;

    /* renamed from: i, reason: collision with root package name */
    private IHuayangPluginLauncher.a f238231i = new b();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            InstalledPlugin installedPlugin;
            if (QLog.isColorLevel()) {
                QLog.d(IHuayangPluginLauncher.TAG, 2, "onReceive ACTION_FORCE_UPDATE");
            }
            if (!TextUtils.equals(intent.getAction(), "action_iv_plugin_update") || (installedPlugin = (InstalledPlugin) intent.getSerializableExtra("plugin")) == null) {
                return;
            }
            boolean isStartPluginCalled = ((IHuayangPluginLauncher) QRoute.api(IHuayangPluginLauncher.class)).getInstance(context, installedPlugin).isStartPluginCalled();
            if (QLog.isColorLevel()) {
                QLog.d(IHuayangPluginLauncher.TAG, 2, "onReceive isCalled:" + isStartPluginCalled);
            }
            if (isStartPluginCalled) {
                return;
            }
            HuayangLoadbackgroudActivity.C = 0L;
            SystemMethodProxy.killProcess(Process.myPid());
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    class b implements IHuayangPluginLauncher.a {
        b() {
        }

        @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher.a
        public void a(boolean z16, Throwable th5) {
            HuayangLoadbackgroudActivity.this.finish();
        }

        @Override // com.tencent.mobileqq.intervideo.huayang.IHuayangPluginLauncher.a
        public void onProgressUpdate(int i3) {
            Intent intent = new Intent(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getLauncherNotifyAction(HuayangLoadbackgroudActivity.this.f238230h));
            intent.putExtra("key_state", 4);
            intent.putExtra("key_progress", i3);
            intent.putExtra("key_totalSize", 100L);
            HuayangLoadbackgroudActivity.this.sendBroadcast(intent);
        }
    }

    static {
        ((IHuayangLoadbackgroudActivityUtil) QRoute.api(IHuayangLoadbackgroudActivityUtil.class)).init();
    }

    public static BroadcastReceiver b() {
        return D;
    }

    public static void d(Context context, String str, IVPluginInfo iVPluginInfo, InstalledPlugin installedPlugin, String str2, String str3, boolean z16, boolean z17, String str4, long j3) {
        Intent intent = new Intent(context, (Class<?>) HuayangLoadbackgroudActivity.class);
        intent.setFlags(268435456);
        intent.putExtra("plugin", installedPlugin);
        intent.putExtra("pageUri", str3);
        intent.putExtra("uin", str2);
        intent.putExtra("needStart", z16);
        intent.putExtra("isMainPlugin", z17);
        intent.putExtra("ivpluginInfo", iVPluginInfo);
        intent.putExtra("launchpkgname", str);
        intent.putExtra("appName", str4);
        intent.putExtra("key_start_flag", j3);
        context.startActivity(intent);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.f238230h)) {
            Monitor.d("2691706");
        } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.f238230h)) {
            Monitor.d("2597724");
        }
        finish();
        sendBroadcast(new Intent(((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).getBackNotifyAction(this.f238230h)));
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        if (Build.VERSION.SDK_INT == 26) {
            setRequestedOrientation(-1);
        } else {
            setRequestedOrientation(1);
        }
        super.onCreate(bundle);
        boolean booleanExtra = getIntent().getBooleanExtra("isPreload", false);
        if (bundle == null && !booleanExtra) {
            this.f238229f = System.currentTimeMillis();
            c();
            boolean booleanExtra2 = getIntent().getBooleanExtra("isMainPlugin", false);
            long longExtra = getIntent().getLongExtra("key_start_flag", 0L);
            if (QLog.isColorLevel()) {
                QLog.d(IHuayangPluginNewDownloader.TAG, 2, "LoadingActivity onCreate\uff1a" + this.f238229f + " isMainPlugin:" + booleanExtra2);
            }
            if (booleanExtra2) {
                long j3 = C;
                if (j3 != 0 && j3 == longExtra) {
                    finish();
                    if (QLog.isColorLevel()) {
                        QLog.d(IHuayangPluginLauncher.TAG, 2, "\u4e0d\u542f\u52a8\u4e0b\u8f7d\u7684\u65b0\u63d2\u4ef6");
                        return;
                    }
                    return;
                }
                C = longExtra;
            }
            this.f238230h = getIntent().getStringExtra("launchpkgname");
            String stringExtra = getIntent().getStringExtra("appName");
            UseDynamicPluginLoaderInstalledPlugin useDynamicPluginLoaderInstalledPlugin = (UseDynamicPluginLoaderInstalledPlugin) getIntent().getSerializableExtra("plugin");
            if (f238226m.get(stringExtra) == null) {
                File file = useDynamicPluginLoaderInstalledPlugin.dynamicPluginContainerFile;
                String str = useDynamicPluginLoaderInstalledPlugin.dynamicPluginLoaderVersion;
                File file2 = new File(file.getParentFile(), "plugin_container_odex_" + str);
                file2.mkdirs();
                InstalledApk installedApk = new InstalledApk(file.getAbsolutePath(), file2.getAbsolutePath(), null);
                DynamicRuntime.loadRuntime(installedApk);
                DynamicRuntime.saveLastRuntimeInfo(this, installedApk);
                f238226m.put(stringExtra, installedApk);
            }
            Bundle extras = getIntent().getExtras();
            extras.setClassLoader(getClass().getClassLoader());
            String string = extras.getString("pageUri");
            String string2 = extras.getString("uin");
            this.f238228e = (IVPluginInfo) extras.getParcelable("ivpluginInfo");
            boolean z16 = extras.getBoolean("needStart", false);
            Monitor.c(TextUtils.equals(stringExtra, "hy_sixgod"));
            MonitorConfig.a(this, stringExtra);
            this.f238228e.f238103f = this.f238230h;
            if (booleanExtra2) {
                if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isODPkg(this.f238230h)) {
                    Monitor.d("2691705");
                } else if (((IHuayangJsPlugin) QRoute.api(IHuayangJsPlugin.class)).isHyPkg(this.f238230h)) {
                    Monitor.d("2597722");
                }
                IHuayangPluginLauncher iHuayangPluginLauncher = ((IHuayangPluginLauncher) QRoute.api(IHuayangPluginLauncher.class)).getInstance(this, useDynamicPluginLoaderInstalledPlugin);
                this.f238227d = iHuayangPluginLauncher;
                iHuayangPluginLauncher.addLauncherListener(this.f238231i);
                this.f238227d.launchPlugin(string, z16, true, this.f238228e, string2, stringExtra);
                return;
            }
            ((IHuayangPluginLauncher) QRoute.api(IHuayangPluginLauncher.class)).getInstance(this, useDynamicPluginLoaderInstalledPlugin).launchPlugin(string, z16, false, this.f238228e, string2, stringExtra);
            finish();
            return;
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        IHuayangPluginLauncher iHuayangPluginLauncher = this.f238227d;
        if (iHuayangPluginLauncher != null) {
            iHuayangPluginLauncher.removeLauncherListener(this.f238231i);
        }
    }

    private void c() {
        requestWindowFeature(1);
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.flags = attributes.flags | 32 | 128;
        attributes.alpha = 0.0f;
        attributes.width = 2;
        attributes.height = 2;
        window.setAttributes(attributes);
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
    }
}
