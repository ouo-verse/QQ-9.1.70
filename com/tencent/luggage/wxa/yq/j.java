package com.tencent.luggage.wxa.yq;

import com.tencent.luggage.wxa.ar.v0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.CommandCfgPlugin;
import com.tencent.xweb.UrlDispatcher;
import com.tencent.xweb.WebView;
import com.tencent.xweb.XWebSdkInternal;
import com.tencent.xweb.updater.IXWebBroadcastListener;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class j implements IXWebBroadcastListener {

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            j.d();
        }
    }

    public static void c() {
        v0.g();
        if (!"true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("dis_refresh_main_cmd", "tools"))) {
            CommandCfg.resetCommandCfg();
            UrlDispatcher.refresh();
            i.c();
            return;
        }
        x0.d("XWebBroadcastListener", "onMainCfgUpdated, dis_refresh_main_cmd false");
    }

    public static void d() {
        if (!"true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("dis_refresh_plugin_cmd", "tools"))) {
            CommandCfgPlugin.resetCommandCfgPlugin();
        } else {
            x0.d("XWebBroadcastListener", "onPluginCfgUpdated, dis_refresh_plugin_cmd false");
        }
    }

    @Override // com.tencent.xweb.updater.IXWebBroadcastListener
    public void onMainCfgUpdated() {
        x0.f("XWebBroadcastListener", "onMainCfgUpdated, package:" + XWalkEnvironment.getPackageName() + ", process:" + XWalkEnvironment.getProcessName());
        com.tencent.luggage.wxa.lq.d.a(new a());
    }

    @Override // com.tencent.xweb.updater.IXWebBroadcastListener
    public void onPluginCfgUpdated() {
        x0.f("XWebBroadcastListener", "onPluginCfgUpdated, package:" + XWalkEnvironment.getPackageName() + ", process:" + XWalkEnvironment.getProcessName());
        com.tencent.luggage.wxa.lq.d.a(new b());
    }

    @Override // com.tencent.xweb.updater.IXWebBroadcastListener
    public void onUpdateFinished(int i3, int i16) {
        boolean isWaitForXWeb;
        x0.f("XWebBroadcastListener", "onUpdateFinished, package:" + XWalkEnvironment.getPackageName() + ", process:" + XWalkEnvironment.getProcessName());
        if (i3 == 0) {
            isWaitForXWeb = XWebSdkInternal.isWaitForXWeb();
            if (!isWaitForXWeb) {
                x0.d("XWebBroadcastListener", "onUpdateFinished, not waiting for xweb");
                return;
            }
            int availableVersion = XWalkEnvironment.getAvailableVersion();
            int installedNewstVersionForCurAbi = XWalkEnvironment.getInstalledNewstVersionForCurAbi();
            if (availableVersion <= 0 && installedNewstVersionForCurAbi > 0 && !"true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("dis_reinit_web_core"))) {
                x0.d("XWebBroadcastListener", "onUpdateFinished, loadedVersion:" + availableVersion + ", installedVersion:" + installedNewstVersionForCurAbi);
                WebView.reinitToXWeb();
            }
        }
    }

    @Override // com.tencent.xweb.updater.IXWebBroadcastListener
    public void onUpdateProgressed(int i3) {
    }

    @Override // com.tencent.xweb.updater.IXWebBroadcastListener
    public void onUpdateStart(int i3) {
    }
}
