package com.tencent.mobileqq.qqgamepub.hippy.module;

import android.app.Activity;
import com.tencent.gamecenter.wadl.biz.entity.WadlParams;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.gamecenter.wadl.util.GameCenterUtil;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.hippy.qq.module.QQBaseModule;
import com.tencent.mobileqq.qqgamepub.hippy.module.e;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.common.HippyArray;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes16.dex */
public class BaseWadlModule extends QQBaseModule {
    protected e qqWadlWrapper;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    class a implements e.a {
        a() {
        }

        @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
        public String a() {
            HippyQQEngine hippyQQEngine = BaseWadlModule.this.getHippyQQEngine();
            if (hippyQQEngine != null) {
                return hippyQQEngine.getPageUrl();
            }
            return "";
        }

        @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
        public void b(ArrayList<WadlResult> arrayList) {
            if (arrayList != null) {
                HippyArray hippyArray = new HippyArray();
                Iterator<WadlResult> it = arrayList.iterator();
                while (it.hasNext()) {
                    hippyArray.pushMap(BaseWadlModule.toHippyMap(it.next()));
                }
                BaseWadlModule.this.sendEvent("onQueryCallback", hippyArray);
            }
        }

        @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
        public Activity getHostActivity() {
            return BaseWadlModule.this.getActivity();
        }

        @Override // com.tencent.mobileqq.qqgamepub.hippy.module.e.a
        public void onWadlTaskStatusChanged(WadlResult wadlResult) {
            if (wadlResult != null && wadlResult.wadlParams != null) {
                BaseWadlModule.this.sendEvent("onWadlTaskStatusChanged", BaseWadlModule.toHippyMap(wadlResult));
            }
        }
    }

    public BaseWadlModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.qqWadlWrapper = new e(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendEvent(String str, Object obj) {
        ((EventDispatcher) this.mContext.getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent(str, obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static HippyMap toHippyMap(WadlResult wadlResult) {
        WadlParams wadlParams;
        HippyMap hippyMap = new HippyMap();
        if (wadlResult != null && (wadlParams = wadlResult.wadlParams) != null) {
            hippyMap.pushString("appid", wadlParams.appId);
            hippyMap.pushInt("downloadType", wadlParams.downloadType);
            hippyMap.pushInt("state", GameCenterUtil.convertRemoteStatusToLocal(wadlResult.taskStatus));
            hippyMap.pushLong("speed", wadlResult.speed);
            hippyMap.pushInt(WadlResult.WEB_KEY_PROGRESS, wadlResult.progress);
            hippyMap.pushDouble(WadlResult.WEB_KEY_F_PROGRESS, wadlResult.floatProgress);
            hippyMap.pushInt("versionCode", wadlParams.versionCode);
            hippyMap.pushString("packagename", wadlParams.packageName);
            hippyMap.pushString("via", wadlParams.via);
            hippyMap.pushLong("mieActId", wadlParams.mieActId);
            hippyMap.pushInt(WadlResult.WEB_KEY_WRITE_CODE_STATE, 0);
            hippyMap.pushString("extraInfo", wadlParams.extraData);
            hippyMap.pushBoolean(WadlResult.WEB_KEY_IS_AUTO_INSTALL_BY_SDK, wadlParams.getFlagEnable(1));
            hippyMap.pushBoolean(WadlResult.WEB_KEY_IS_RES, wadlParams.isRes);
            int wadlErrCode = GameCenterUtil.getWadlErrCode(wadlResult.errCode);
            hippyMap.pushInt("errorCode", wadlErrCode);
            hippyMap.pushString("errorMsg", GameCenterUtil.getWadlErrMsg(wadlErrCode));
            hippyMap.pushString("appName", wadlParams.appName);
            hippyMap.pushString("iconUrl", wadlParams.iconUrl);
        }
        return hippyMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkMobileFlowAvailable(Promise promise) {
        boolean l3 = this.qqWadlWrapper.l();
        if (promise != null) {
            promise.resolve(Boolean.valueOf(l3));
        }
    }

    @HippyMethod(name = "deleteDownload")
    public void deleteDownload(String str) {
        this.qqWadlWrapper.c(str);
    }

    @Override // com.tencent.hippy.qq.module.QQBaseModule, com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase
    public void destroy() {
        super.destroy();
        this.qqWadlWrapper.d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doDownloadAction(String str, Promise promise) {
        this.qqWadlWrapper.e(str);
        if (promise != null) {
            promise.resolve(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getAvailableBytes(Promise promise) {
        long g16 = this.qqWadlWrapper.g();
        if (promise != null) {
            promise.resolve(Long.valueOf(g16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getInstalledAppVersionCode(String str, String str2, Promise promise) {
        if (promise == null) {
            return;
        }
        HashMap<String, Object> i3 = this.qqWadlWrapper.i(str, str2);
        HippyMap hippyMap = new HippyMap();
        hippyMap.pushInt("r", ((Integer) i3.get("r")).intValue());
        hippyMap.pushString("guid", (String) i3.get("guid"));
        if (i3.containsKey("data")) {
            hippyMap.pushString("data", (String) i3.get("data"));
        }
        promise.resolve(hippyMap);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void getMobileDownloadRate(Promise promise) {
        float j3 = this.qqWadlWrapper.j();
        if (promise != null) {
            promise.resolve(Float.valueOf(j3));
        }
    }

    @HippyMethod(name = "getQueryDownloadAction")
    public void getQueryDownloadAction(String str, Promise promise) {
        this.qqWadlWrapper.k(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void openFloatingSetting(String str, Promise promise) {
        int n3 = this.qqWadlWrapper.n(str);
        if (promise != null) {
            promise.resolve(Integer.valueOf(n3));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void openHuaWeiPureModeSetting(Promise promise) {
        int o16 = this.qqWadlWrapper.o();
        if (promise != null) {
            promise.resolve(Integer.valueOf(o16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void openInstallSetting(Promise promise) {
        int p16 = this.qqWadlWrapper.p();
        if (promise != null) {
            promise.resolve(Integer.valueOf(p16));
        }
    }

    @HippyMethod(name = "queryAllDownloadTask")
    public void queryAllDownloadTask() {
        this.qqWadlWrapper.q();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void queryFloatingPermission(String str, Promise promise) {
        boolean r16 = this.qqWadlWrapper.r(str);
        if (promise != null) {
            promise.resolve(Integer.valueOf(r16 ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void queryInstallPermission(Promise promise) {
        boolean s16 = this.qqWadlWrapper.s();
        if (promise != null) {
            promise.resolve(Integer.valueOf(s16 ? 1 : 0));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void readHuaweiPureModeState(Promise promise) {
        int t16 = this.qqWadlWrapper.t();
        if (promise != null) {
            promise.resolve(Integer.valueOf(t16));
        }
    }

    @HippyMethod(name = "registerListener")
    public void registerListener() {
        this.qqWadlWrapper.v();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void requestFloatingPermission(String str, Promise promise) {
        this.qqWadlWrapper.w(str);
        if (promise != null) {
            promise.resolve(0);
        }
    }

    @HippyMethod(name = "unregisterListener")
    public void unregisterListener() {
        this.qqWadlWrapper.z();
    }
}
