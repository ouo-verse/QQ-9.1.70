package com.tencent.hippy.qq.module;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.ThirdPartyMiniPageProxy;

/* compiled from: P */
@HippyNativeModule(name = QQMiniAppModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQMiniAppModule extends QQBaseModule {
    public static final String CLASSNAME = "QQMiniAppModule";

    public QQMiniAppModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "backToHome")
    public void backToHome() {
        ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).backToHome(getActivity());
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_OPEN_MINI_APP)
    public void openMiniApp(HippyMap hippyMap) {
        String string = hippyMap.getString("url");
        int i3 = hippyMap.getInt("scene");
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "openMiniApp: schema=" + string + ",scene=" + i3);
        }
        Activity activity = getActivity();
        if (activity == null) {
            QLog.e(CLASSNAME, 1, "openMiniApp: activity is null.");
        } else {
            ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, string, i3, null);
        }
    }

    @HippyMethod(name = MiniGameKuiklyModule.METHOD_SET_SHARE_PARAMS)
    public void setShareParams(HippyMap hippyMap, Promise promise) {
        String string = hippyMap.getString(ThirdPartyMiniPageProxy.KEY_SHARE_TEXT);
        String string2 = hippyMap.getString(ThirdPartyMiniPageProxy.KEY_SHARE_PIC_URL);
        String string3 = hippyMap.getString(ThirdPartyMiniPageProxy.KEY_SHARE_QUERY);
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "setShareParams: shareText=" + string + ",picUrl=" + string2 + ",shareQuery=" + string3);
        }
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).setShareParams(string, string2, string3);
            promise.resolve("success");
        } else {
            promise.reject("params is invalid");
            QLog.e(CLASSNAME, 1, "setShareParams: share param invalid.");
        }
    }
}
