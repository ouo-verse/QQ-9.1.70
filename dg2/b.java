package dg2;

import android.app.Activity;
import com.tencent.ecommerce.biz.pay.api.IECVasPayObserver;
import com.tencent.ecommerce.biz.pay.api.IECVasRechargeApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.vas.pay.api.IVasNativePayManager;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J0\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Ldg2/b;", "Lcom/tencent/ecommerce/biz/pay/api/IECVasRechargeApi;", "Lorg/json/JSONObject;", "jsonParams", "", "", "a", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "title", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REPORT_PARAMS, "Lcom/tencent/ecommerce/biz/pay/api/IECVasPayObserver;", "ecObserve", "", "openVasRecharge", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b implements IECVasRechargeApi {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"dg2/b$b", "Lcom/tencent/mobileqq/vas/pay/api/IVasNativePayManager$PayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: dg2.b$b, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10178b implements IVasNativePayManager.PayObserver {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECVasPayObserver f393740a;

        C10178b(IECVasPayObserver iECVasPayObserver) {
            this.f393740a = iECVasPayObserver;
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayError(int code) {
            QLog.i("ECVasPayImpl", 1, "[openRecharge] onPayError, code = " + code);
            this.f393740a.onPayError(code);
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewFail() {
            QLog.i("ECVasPayImpl", 1, "[openRecharge] onOpenPayViewFail");
            this.f393740a.onOpenPayViewFail();
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onOpenPayViewSuccess() {
            QLog.i("ECVasPayImpl", 1, "[openRecharge] onOpenPayViewSuccess");
            this.f393740a.onOpenPayViewSuccess();
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPaySuccess() {
            QLog.i("ECVasPayImpl", 1, "[openRecharge] onPaySuccess");
            this.f393740a.onPaySuccess();
        }

        @Override // com.tencent.mobileqq.vas.pay.api.IVasNativePayManager.PayObserver
        public void onPayViewClose() {
            QLog.i("ECVasPayImpl", 1, "[openRecharge] onPayViewClose");
            this.f393740a.onPayViewClose();
        }
    }

    private final Map<String, String> a(JSONObject jsonParams) {
        HashMap hashMap = new HashMap();
        Iterator keys = jsonParams.keys();
        Intrinsics.checkNotNullExpressionValue(keys, "jsonParams.keys()");
        while (keys.hasNext()) {
            String valueOf = String.valueOf(keys.next());
            String optString = jsonParams.optString(valueOf);
            Intrinsics.checkNotNullExpressionValue(optString, "jsonParams.optString(keyStr)");
            hashMap.put(valueOf, optString);
        }
        return hashMap;
    }

    @Override // com.tencent.ecommerce.biz.pay.api.IECVasRechargeApi
    public void openVasRecharge(Activity activity, String title, String businessName, JSONObject reportParams, IECVasPayObserver ecObserve) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(businessName, "businessName");
        Intrinsics.checkNotNullParameter(reportParams, "reportParams");
        Intrinsics.checkNotNullParameter(ecObserve, "ecObserve");
        QLog.i("ECVasPayImpl", 1, "[openVasRecharge] invoked");
        if (((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).isSwitchEnable()) {
            QLog.i("ECVasPayImpl", 1, "[openVasRecharge] invoked, isSwitchEnable = true, title = " + title + ", businessName = " + businessName + ", reportParams = " + reportParams);
            String optString = reportParams.optString("app_id");
            if (optString == null) {
                optString = "";
            }
            String optString2 = reportParams.optString(IECVasRechargeApi.SUB_SCENE_ID);
            if (optString2 == null) {
                optString2 = "";
            }
            String optString3 = reportParams.optString("source");
            if (optString3 == null) {
                optString3 = "";
            }
            String optString4 = reportParams.optString("param_id");
            if (optString4 == null) {
                optString4 = "";
            }
            String optString5 = reportParams.optString(IECVasRechargeApi.PARAM_SUB_ID);
            String str = optString5 != null ? optString5 : "";
            JSONObject optJSONObject = reportParams.optJSONObject(IECVasRechargeApi.EXT_PARAMS);
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            IVasNativePayManager.ReportData reportData = new IVasNativePayManager.ReportData(optString, optString2, optString3, "0_0_" + optString4 + "_" + str);
            reportData.mDtData = a(optJSONObject);
            if (((IVasNativePayManager) QRoute.api(IVasNativePayManager.class)).initAndShowPayPanel(activity, title, businessName, reportData, new C10178b(ecObserve)) == null) {
                ecObserve.onOpenPayViewFail();
            }
        }
    }
}
