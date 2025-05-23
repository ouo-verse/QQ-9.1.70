package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicPluginUtil;
import com.tencent.comic.api.IQQComicService;
import com.tencent.mobileqq.apollo.game.api.ICmGameHelper;
import com.tencent.mobileqq.app.BrowserAppInterface;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.icgame.runtime.ICGameToolAppInterface;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoFeedsAppInterfaceFactory;
import com.tencent.mobileqq.nearby.api.IFactoryApi;
import com.tencent.mobileqq.olympic.OlympicToolAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqgift.runtime.QQGiftToolAppInterface;
import com.tencent.mobileqq.qqlive.runtime.QQLiveToolAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.INewQWalletApi;
import com.tencent.mobileqq.remoteweb.RemoteWebRenderIPCClient;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ToolAppRuntime extends ToolRuntimeBase {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private AppInterface f99532d;

    public ToolAppRuntime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f99532d = null;
        }
    }

    private AppRuntime f() {
        if (isModuleRunning("qq_live_tool")) {
            return getAppRuntime("qq_live_tool");
        }
        return null;
    }

    @Override // mqq.app.AppRuntime
    public String getModuleId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "tool";
    }

    @Override // mqq.app.AppRuntime
    public boolean highPriorityWhenBackground() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        boolean M = RemoteWebRenderIPCClient.y().M();
        if (QLog.isColorLevel()) {
            QLog.i("ToolAppRuntime", 2, "highPriorityWhenBackground isWebRender=" + M);
        }
        AppRuntime f16 = f();
        if (f16 != null) {
            z16 = f16.highPriorityWhenBackground();
            if (QLog.isColorLevel()) {
                QLog.i("ToolAppRuntime", 2, "highPriorityWhenBackground isOpenLive=" + z16);
            }
        } else {
            z16 = false;
        }
        if (!M && !z16 && !super.highPriorityWhenBackground()) {
            return false;
        }
        return true;
    }

    @Override // mqq.app.AppRuntime
    public boolean isProcessIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        boolean M = RemoteWebRenderIPCClient.y().M();
        if (QLog.isColorLevel()) {
            QLog.i("ToolAppRuntime", 2, "isProcessIdle isWebRender=" + M);
        }
        if (M) {
            return false;
        }
        AppRuntime f16 = f();
        if (f16 != null && !f16.isProcessIdle()) {
            return false;
        }
        return super.isProcessIdle();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.pluginsdk.PluginRuntime, mqq.app.AppRuntime
    public void onCreate(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) bundle);
        } else {
            super.onCreate(bundle);
            DtSdkInitStep.initDTSDK(0);
        }
    }

    @Override // mqq.app.AppRuntime
    public AppRuntime onGetSubRuntime(String str) {
        AppRuntime appRuntime;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (AppRuntime) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        }
        if (QLog.isColorLevel()) {
            QLog.i("ToolAppRuntime", 2, "ToolAppRuntime.onGetSubRuntime() moduleId " + str);
        }
        BaseApplicationImpl application = BaseApplicationImpl.getApplication();
        boolean z16 = true;
        if (FaceConstant.NEARBY_MODULAR_MODULE_ID.equals(str)) {
            appRuntime = (AppRuntime) ((IFactoryApi) QRoute.api(IFactoryApi.class)).getNearbyAppInterface(application, MobileQQ.processName);
        } else {
            if (IQQComicPluginUtil.COMIC_PLUGIN_ID.equals(str)) {
                appRuntime = ((IQQComicService) getRuntimeService(IQQComicService.class, "tool")).createComicRuntime(application, MobileQQ.processName);
            } else if ("qqpim_plugin.apk".equals(str)) {
                appRuntime = cooperation.qqpim.c.a(application, MobileQQ.processName);
            } else if ("module_olympic".equals(str)) {
                appRuntime = new OlympicToolAppInterface(application, MobileQQ.processName);
            } else if ("qwallet_plugin.apk".equals(str)) {
                appRuntime = ((INewQWalletApi) QRoute.api(INewQWalletApi.class)).createQWalletAppInterface(application, MobileQQ.processName);
            } else if ("qqindividuality_plugin.apk".equals(str)) {
                appRuntime = cooperation.qqindividuality.a.a(application, MobileQQ.processName);
            } else if ("modular_web".equals(str)) {
                appRuntime = new BrowserAppInterface(application, MobileQQ.processName);
            } else if ("module_videofeeds".equals(str)) {
                appRuntime = ((IVideoFeedsAppInterfaceFactory) QRoute.api(IVideoFeedsAppInterfaceFactory.class)).create(application, MobileQQ.processName);
            } else if ("cmshowgame_module".equals(str)) {
                appRuntime = ((ICmGameHelper) QRoute.api(ICmGameHelper.class)).createGameAppInterface(application, MobileQQ.processName);
            } else if ("peak".equals(str)) {
                appRuntime = new PeakAppInterface(application, MobileQQ.processName);
            } else if ("qq_live_tool".equals(str)) {
                appRuntime = new QQLiveToolAppInterface(application, MobileQQ.processName);
            } else if ("qq_gift_tool".equals(str)) {
                appRuntime = new QQGiftToolAppInterface(application, MobileQQ.processName);
            } else if ("icgame_live_tool".equals(str)) {
                appRuntime = new ICGameToolAppInterface(application, MobileQQ.processName);
            } else {
                appRuntime = null;
            }
            z16 = false;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ToolAppRuntime", 2, "moduleId needInitSkin =" + z16 + ", appInstance=" + appRuntime);
        }
        if (!InitSkin.sToolProcessInitComplete && z16) {
            InitSkin.waitAsynInitSkin();
        }
        return appRuntime;
    }

    @Override // mqq.app.AppRuntime
    public void preExit() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        AppRuntime f16 = f();
        if (f16 != null) {
            f16.preExit();
        }
    }
}
