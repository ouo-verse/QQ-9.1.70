package com.tencent.hippy.qq.module;

import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
@HippyNativeModule(name = "QQWidgetModule")
/* loaded from: classes7.dex */
public class QQWidgetModule extends QQBaseModule {
    public static final String TAG = "GCWidget.QQWidgetModule";

    public QQWidgetModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
    }

    @HippyMethod(name = "createWidget")
    public void createWidget(String str) {
        QLog.i("GCWidget.QQWidgetModule", 1, "[createWidget], req:" + str);
        try {
            ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).addWidgetV2();
        } catch (Throwable th5) {
            QLog.e("GCWidget.QQWidgetModule", 1, "[createWidget], th:" + th5);
        }
    }

    @HippyMethod(name = "queryWidget")
    public void queryWidget(String str, Promise promise) {
        int i3;
        QLog.i("GCWidget.QQWidgetModule", 1, "[queryWidget], req:" + str);
        try {
            boolean hasWidgetV2 = ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).hasWidgetV2();
            QLog.i("GCWidget.QQWidgetModule", 1, "isHasWidget:" + hasWidgetV2);
            HippyMap hippyMap = new HippyMap();
            if (hasWidgetV2) {
                i3 = 0;
            } else {
                i3 = 1;
            }
            hippyMap.pushInt("ret", i3);
            promise.resolve(hippyMap);
        } catch (Throwable th5) {
            QLog.e("GCWidget.QQWidgetModule", 1, "[queryWidget], th:" + th5);
        }
    }
}
