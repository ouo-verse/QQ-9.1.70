package com.tencent.mobileqq.qqgamepub.hippy.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;

/* compiled from: P */
@HippyNativeModule(name = QQWadlModule.NAME)
/* loaded from: classes16.dex */
public class QQWadlModule extends BaseWadlModule {
    static final String NAME = "QQWadlModule";

    public QQWadlModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "canDualDownload")
    public void canDualDownload(Promise promise) {
        int b16 = this.qqWadlWrapper.b();
        if (promise != null) {
            promise.resolve(Integer.valueOf(b16));
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "deleteDownload")
    public void deleteDownload(String str) {
        super.deleteDownload(str);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = WadlProxyConsts.REMOTE_CMD_APP_DOWNLOAD_ACTION)
    public void doDownloadAction(String str, Promise promise) {
        super.doDownloadAction(str, promise);
    }

    @HippyMethod(name = "doDualDownloadAction")
    public void doDualDownloadAction(String str, Promise promise) {
        this.qqWadlWrapper.f(str);
        if (promise != null) {
            promise.resolve(0);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "getAvailableBytes")
    public void getAvailableBytes(Promise promise) {
        super.getAvailableBytes(promise);
    }

    @HippyMethod(name = "getDualSwitch")
    public void getDualSwitch(Promise promise) {
        int h16 = this.qqWadlWrapper.h();
        if (promise != null) {
            promise.resolve(Integer.valueOf(h16));
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "getInstalledAppVersionCode")
    public void getInstalledAppVersionCode(String str, String str2, Promise promise) {
        super.getInstalledAppVersionCode(str, str2, promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "getQueryDownloadAction")
    public void getQueryDownloadAction(String str, Promise promise) {
        super.getQueryDownloadAction(str, promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "openFloatingSetting")
    public void openFloatingSetting(String str, Promise promise) {
        super.openFloatingSetting(str, promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "openHuaWeiPureModeSetting")
    public void openHuaWeiPureModeSetting(Promise promise) {
        super.openHuaWeiPureModeSetting(promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "openInstallSetting")
    public void openInstallSetting(Promise promise) {
        super.openInstallSetting(promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "queryAllDownloadTask")
    public void queryAllDownloadTask() {
        super.queryAllDownloadTask();
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "queryFloatingPermission")
    public void queryFloatingPermission(String str, Promise promise) {
        super.queryFloatingPermission(str, promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "queryInstallPermission")
    public void queryInstallPermission(Promise promise) {
        super.queryInstallPermission(promise);
    }

    @HippyMethod(name = "readLastTime")
    public void readLastTime(String str, Promise promise) {
        long u16 = this.qqWadlWrapper.u(str);
        if (promise != null) {
            promise.resolve(Long.valueOf(u16));
        }
    }

    @HippyMethod(name = "readModeState")
    public void readModeState(String str, Promise promise) {
        super.readHuaweiPureModeState(promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "registerListener")
    public void registerListener() {
        super.registerListener();
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "requestFloatingPermission")
    public void requestFloatingPermission(String str, Promise promise) {
        super.requestFloatingPermission(str, promise);
    }

    @HippyMethod(name = "setDualSwitch")
    public void setDualSwitch(String str, Promise promise) {
        this.qqWadlWrapper.x(str);
        if (promise != null) {
            promise.resolve(0);
        }
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "unregisterListener")
    public void unregisterListener() {
        super.unregisterListener();
    }

    @HippyMethod(name = "updateLastTime")
    public void updateLastTime(String str, Promise promise) {
        int A = this.qqWadlWrapper.A(str);
        if (promise != null) {
            promise.resolve(Integer.valueOf(A));
        }
    }
}
