package com.tencent.hippy.qq.module;

import android.app.Activity;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.minihippy.api.IMiniHippyApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyNativeModule(name = QQNavigatorModule.CLASSNAME)
/* loaded from: classes7.dex */
public class QQNavigatorModule extends QQBaseModule {
    public static final String CLASSNAME = "QQNavigatorModule";

    public QQNavigatorModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "openSSRHippy")
    public void openSSRHippy(HippyMap hippyMap, Promise promise) {
        push(hippyMap, promise);
    }

    @HippyMethod(name = "pop")
    public void pop(HippyMap hippyMap, Promise promise) {
        HippyMap hippyMap2 = new HippyMap();
        boolean z16 = hippyMap.getBoolean("animated");
        Activity activity = getActivity();
        if (activity == null) {
            hippyMap2.pushInt("retCode", -1);
            hippyMap2.pushString("errMsg", "activity is null.");
        } else {
            if (((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).isLaunchByMiniApp(activity)) {
                ((IMiniHippyApi) QRoute.api(IMiniHippyApi.class)).popMiniHippy(activity);
            } else if ((activity instanceof com.tencent.mobileqq.pad.l) && AppSetting.t(activity)) {
                com.tencent.mobileqq.pad.m.e(activity);
            } else {
                activity.finish();
                if (z16) {
                    activity.overridePendingTransition(0, R.anim.f154480ae);
                }
            }
            hippyMap2.pushInt("retCode", 0);
        }
        promise.resolve(hippyMap2);
    }

    @HippyMethod(name = "push")
    public void push(HippyMap hippyMap, Promise promise) {
        if (QLog.isColorLevel()) {
            QLog.i(CLASSNAME, 2, "push:" + hippyMap);
        }
        HippyMap hippyMap2 = new HippyMap();
        if (new OpenHippyInfo(hippyMap).openHippy(getActivity())) {
            hippyMap2.pushInt("retCode", 0);
        } else {
            hippyMap2.pushInt("retCode", -1);
            hippyMap2.pushString("errMsg", "error.");
        }
        promise.resolve(hippyMap2);
    }
}
