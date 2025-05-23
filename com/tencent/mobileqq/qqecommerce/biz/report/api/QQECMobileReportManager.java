package com.tencent.mobileqq.qqecommerce.biz.report.api;

import android.text.TextUtils;
import com.tencent.ecommerce.base.report.api.IECMobileReportManager;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.IMobileReportManager;
import com.tencent.mobileqq.vas.spanend.IH5DataCacheApi;
import com.tencent.open.agent.api.IOpenAuthTelemetryReportMgr;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u008c\u0001\u0010\u0013\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0002J\u008c\u0001\u0010\u0014\u001a\u00020\u00122\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/report/api/QQECMobileReportManager;", "Lcom/tencent/ecommerce/base/report/api/IECMobileReportManager;", "", "appId", "pageId", "moduleId", "subModuleId", "itemId", "subItemId", "itemType", "", "actionId", "actionValue", "actionAttr", "ruleId", "busiInfo", "positionId", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "b", IOpenAuthTelemetryReportMgr.KEY_REPORT_ACTION, "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQECMobileReportManager implements IECMobileReportManager {
    /* JADX INFO: Access modifiers changed from: private */
    public final void b(String appId, String pageId, String moduleId, String subModuleId, String itemId, String subItemId, String itemType, int actionId, int actionValue, int actionAttr, String ruleId, String busiInfo, String positionId, String traceInfo) {
        ((IMobileReportManager) QRoute.api(IMobileReportManager.class)).reportAction(appId, pageId, moduleId, subModuleId, itemId, subItemId, itemType, actionId, actionValue, actionAttr, ruleId, busiInfo, positionId, traceInfo);
    }

    @Override // com.tencent.ecommerce.base.report.api.IECMobileReportManager
    public void reportAction(final String appId, final String pageId, final String moduleId, final String subModuleId, final String itemId, final String subItemId, final String itemType, final int actionId, final int actionValue, final int actionAttr, final String ruleId, final String busiInfo, final String positionId, final String traceInfo) {
        Intrinsics.checkNotNullParameter(traceInfo, "traceInfo");
        QLog.i("QQECMobileReportManager", 1, "appId: " + appId + ", pageId:" + pageId + " moduleId: " + moduleId + " subModuleId: " + subModuleId + " itemId:" + itemId + " subItemId:" + subItemId + " itemType:" + itemType + " actionId:" + actionId + " actionValue:" + actionValue + " actionAttr: " + actionAttr + " ruleId:" + ruleId + " busiInfo:" + busiInfo + " positionId:" + positionId + " traceInfo:" + traceInfo);
        if (TextUtils.isEmpty(traceInfo)) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("host", "qq.com");
            jSONObject.put("path", "/vip/tracker/sdk");
            jSONObject.put("key", "vt_lastest_trace_detail");
            IH5DataCacheApi iH5DataCacheApi = (IH5DataCacheApi) QRoute.api(IH5DataCacheApi.class);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
            iH5DataCacheApi.readData(jSONObject2, new Function1<Object, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.report.api.QQECMobileReportManager$reportAction$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                    invoke2(obj);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Object obj) {
                    String str = traceInfo;
                    try {
                        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
                        JSONObject jSONObject3 = new JSONObject((String) obj);
                        if (jSONObject3.optInt("ret") != 0) {
                            QLog.i("QQECMobileReportManager", 1, "read error! result: " + obj);
                        } else {
                            JSONObject optJSONObject = new JSONObject(URLDecoder.decode(jSONObject3.optString("data"))).optJSONObject("trace");
                            String jSONObject4 = optJSONObject != null ? optJSONObject.toString() : null;
                            if (jSONObject4 == null) {
                                jSONObject4 = "";
                            }
                            str = jSONObject4;
                        }
                    } catch (Exception e16) {
                        QLog.i("QQECMobileReportManager", 1, "read error! exception: " + e16);
                    }
                    QLog.i("QQECMobileReportManager", 1, "finalTraceDetail: " + str);
                    this.b(appId, pageId, moduleId, subModuleId, itemId, subItemId, itemType, actionId, actionValue, actionAttr, ruleId, busiInfo, positionId, str);
                }
            });
            return;
        }
        b(appId, pageId, moduleId, subModuleId, itemId, subItemId, itemType, actionId, actionValue, actionAttr, ruleId, busiInfo, positionId, traceInfo);
    }
}
