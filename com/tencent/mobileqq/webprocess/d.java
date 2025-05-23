package com.tencent.mobileqq.webprocess;

import android.content.Context;
import android.content.Intent;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.intervideo.yiqikan.f;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPluginInstallFactory;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.springhb.main.SpringHbVideoView;
import com.tencent.mobileqq.springhb.main.SpringToMainHelper;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics;
import com.tencent.mobileqq.webview.util.l;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.e;
import com.tencent.mobileqq.zplan.web.api.IZPlanWebDataHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d implements l {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void e(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if (SpringToMainHelper.gIsLoaded.compareAndSet(false, true)) {
                SpringToMainHelper.gSpringHbVideoViewCache = new SpringHbVideoView(context);
            }
            QLog.i("springHb_WebProcessReceiverInjectorImpl", 1, "tool\u8fdb\u7a0b fromOfPreload=" + WebProcessReceiver.f313723b + ",time cost=" + (System.currentTimeMillis() - currentTimeMillis));
        } catch (Exception e16) {
            QLog.e("springHb_WebProcessReceiverInjectorImpl", 1, "preloadSpringHbVideoSDK fail", e16);
        }
    }

    @Override // com.tencent.mobileqq.webview.util.l
    public void a(AppRuntime appRuntime, Context context, Intent intent, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appRuntime, context, intent, Integer.valueOf(i3));
            return;
        }
        if (!((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
            ((IWebIPCOperatorApi) QRoute.api(IWebIPCOperatorApi.class)).doBindService(context.getApplicationContext());
        }
        if (10 != i3) {
            if (QLog.isColorLevel()) {
                QLog.d("WebProcessReceiverInjectorImpl", 2, "onReceive preloadData standard, fromType=" + i3);
            }
            d(i3);
        } else {
            if (QLog.isColorLevel()) {
                QLog.d("WebProcessReceiverInjectorImpl", 2, "onReceive AIOOpenWebMonitor.PRELOAD_FROM_READINJOY_HALF!");
            }
            WebCoreService.d();
            SwiftBrowserStatistics.f314342g1 = true;
        }
        if (6 == i3) {
            if (QLog.isColorLevel()) {
                QLog.d("WebProcessReceiverInjectorImpl", 2, "apollo_client onReceive AIOOpenWebMonitor.PRELOAD_FROM_APOLLO == fromOfPreload");
            }
            ((IZPlanWebDataHandler) QRoute.api(IZPlanWebDataHandler.class)).initInAsyncThreadIfNeed();
        }
        if (9 == i3) {
            if (QLog.isColorLevel()) {
                QLog.d("WebProcessReceiverInjectorImpl", 2, "apollo_client onReceive AIOOpenWebMonitor.PRELOAD_FROM_READINJOY == fromOfPreload");
            }
            ((IVideoPluginInstallFactory) QRoute.api(IVideoPluginInstallFactory.class)).create();
            new ListView(context);
        }
        if (13 == i3) {
            e(context);
        }
        if (14 == i3) {
            ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).executeTaskInToolProcess(intent);
        }
        if (8 == i3) {
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedPreloadWebView();
        }
    }

    @Override // com.tencent.mobileqq.webview.util.l
    public void b(AppRuntime appRuntime, Context context, Intent intent, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appRuntime, context, intent, str);
            return;
        }
        if ("action_show_together_floating_windows".equals(str)) {
            try {
                QIPCClientHelper.getInstance().register(WatchTogetherClientIPCModule.b());
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("WebProcessReceiverInjectorImpl", 1, "register WatchTogetherClientIPCModule ipc module error.", e16);
                }
            }
            WatchTogetherFloatingData watchTogetherFloatingData = (WatchTogetherFloatingData) intent.getSerializableExtra("com.tencent.mobileqq.webprocess.together.floating.data");
            if (watchTogetherFloatingData != null && f.g()) {
                f.l(BaseApplication.context, watchTogetherFloatingData);
                if (QLog.isColorLevel()) {
                    QLog.d("WebProcessReceiverInjectorImpl", 1, "handle ACTION_SHOW_TOGETHER_CONTROL_FLOATING_WINDOWS, data!=null");
                    return;
                }
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WebProcessReceiverInjectorImpl", 1, "handle ACTION_SHOW_TOGETHER_CONTROL_FLOATING_WINDOWS, data!=null");
                return;
            }
            return;
        }
        if ("action_preload_guild_feed_detail".equals(str)) {
            ((IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class)).launchGuildFeedPreloadWebView();
        }
    }

    @Override // com.tencent.mobileqq.webview.util.l
    public void c(AppRuntime appRuntime, Context context, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appRuntime, context, intent);
        } else {
            WebSoService.j().e();
            e.e();
        }
    }

    protected void d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("WebProcessReceiverInjectorImpl", 2, "preloadData");
        }
        try {
            b.a(i3);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
