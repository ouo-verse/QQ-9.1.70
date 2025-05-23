package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.tdf;

import com.tencent.mobileqq.gamecenter.api.IGameCenterWidgetMgrApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tdf.annotation.TDFMethod;
import com.tencent.tdf.annotation.TDFModule;
import com.tencent.tdf.module.TDFModuleContext;
import com.tencent.tdf.module.TDFModulePromise;

/* compiled from: P */
@TDFModule(name = QQWidgetModule.CLASSNAME)
/* loaded from: classes35.dex */
public class QQWidgetModule extends QQBaseModule {
    static final String CLASSNAME = "QQWidgetModule";
    public static final String TAG = "GCWidget.QQWidgetModule";

    public QQWidgetModule(TDFModuleContext tDFModuleContext) {
        super(tDFModuleContext);
    }

    @TDFMethod(name = "createWidget")
    public void createWidget(String str, TDFModulePromise tDFModulePromise) {
        QLog.i("GCWidget.QQWidgetModule", 1, "[createWidget], req:" + str);
        try {
            ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).addWidgetV2();
        } catch (Throwable th5) {
            QLog.e("GCWidget.QQWidgetModule", 1, "[createWidget], th:" + th5);
        }
    }

    @TDFMethod(name = "queryWidget")
    public void queryWidget(String str, TDFModulePromise tDFModulePromise) {
        QLog.i("GCWidget.QQWidgetModule", 1, "[queryWidget], req:" + str);
        try {
            boolean hasWidgetV2 = ((IGameCenterWidgetMgrApi) QRoute.api(IGameCenterWidgetMgrApi.class)).hasWidgetV2();
            QLog.i("GCWidget.QQWidgetModule", 1, "isHasWidget:" + hasWidgetV2);
            HippyMap hippyMap = new HippyMap();
            hippyMap.pushInt("ret", hasWidgetV2 ? 0 : 1);
            tDFModulePromise.resolve(hippyMap);
        } catch (Throwable th5) {
            QLog.e("GCWidget.QQWidgetModule", 1, "[queryWidget], th:" + th5);
        }
    }
}
