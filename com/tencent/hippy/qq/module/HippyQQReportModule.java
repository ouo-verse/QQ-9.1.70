package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.mobileqq.qqecommerce.biz.hr.api.IQReportModuleFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.annotation.HippyMethod;
import com.tencent.mtt.hippy.annotation.HippyNativeModule;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.nativemodules.HippyNativeModuleBase;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
@HippyNativeModule(name = HippyQQReportModule.CLASSNAME)
/* loaded from: classes7.dex */
public class HippyQQReportModule extends HippyNativeModuleBase {
    static final String CLASSNAME = "QReport";
    private com.tencent.mobileqq.qqecommerce.biz.hr.api.f mQReportModule;

    public HippyQQReportModule(HippyEngineContext hippyEngineContext) {
        super(hippyEngineContext);
        this.mQReportModule = ((IQReportModuleFactory) QRoute.api(IQReportModuleFactory.class)).create();
    }

    @HippyMethod(name = "DTReportEvent")
    public void DTReportEvent(String str, HippyMap hippyMap) {
        if (!TextUtils.isEmpty(str) && hippyMap != null) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, Object> entry : hippyMap.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            VideoReport.reportEvent(str, hashMap);
        }
    }

    @HippyMethod(name = "DTTraverseExposure")
    public void DTTraverseExposure() {
        VideoReport.traverseExposure();
    }

    @HippyMethod(name = "reportDT")
    public void reportDT(String str, HippyMap hippyMap) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mQReportModule.b(str, jSONObject);
    }

    @HippyMethod(name = "reportT")
    public void reportT(String str, HippyMap hippyMap) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (hippyMap != null) {
            jSONObject = hippyMap.toJSONObject();
        } else {
            jSONObject = new JSONObject();
        }
        this.mQReportModule.a(str, jSONObject);
    }
}
