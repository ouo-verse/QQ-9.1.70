package com.tencent.mobileqq.qqgamepub.hippy.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.modules.Promise;

/* compiled from: P */
@HippyNativeModule(name = QQGameWadlModule.NAME)
/* loaded from: classes16.dex */
public class QQGameWadlModule extends BaseWadlModule {
    static final String NAME = "QQGameWadlModule";

    public QQGameWadlModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "checkMobileFlowAvailable")
    public void checkMobileFlowAvailable(Promise promise) {
        super.checkMobileFlowAvailable(promise);
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

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "getAvailableBytes")
    public void getAvailableBytes(Promise promise) {
        super.getAvailableBytes(promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "getInstalledAppVersionCode")
    public void getInstalledAppVersionCode(String str, String str2, Promise promise) {
        super.getInstalledAppVersionCode(str, str2, promise);
    }

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "getMobileDownloadRate")
    public void getMobileDownloadRate(Promise promise) {
        super.getMobileDownloadRate(promise);
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

    @HippyMethod(name = "readHuaWeiPureModeState")
    public void readHuaWeiPureModeState(Promise promise) {
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

    @Override // com.tencent.mobileqq.qqgamepub.hippy.module.BaseWadlModule
    @HippyMethod(name = "unregisterListener")
    public void unregisterListener() {
        super.unregisterListener();
    }
}
