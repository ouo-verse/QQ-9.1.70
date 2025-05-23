package com.tenpay.sdk.net.core.actions;

import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.report.beacon.cgi.IQWalletCgiReport;
import com.tenpay.sdk.net.core.result.NetResult;
import com.tenpay.sdk.net.core.statistic.StatisticInfo;
import com.tenpay.sdk.net.sso.PaySsoResult;
import com.tenpay.sdk.net.utils.ExceptionUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nl2.CgiReportBean;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/sdk/net/core/actions/BeaconReportAction;", "Lcom/tenpay/sdk/net/core/actions/IByPassAction;", "Lcom/tenpay/sdk/net/core/result/NetResult;", "()V", "getRequestBody", "", "result", "retCode", "onBeforeCallback", "", "url", "reportToBeacon", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BeaconReportAction implements IByPassAction<NetResult> {
    private final String getRequestBody(NetResult result, String retCode) {
        StatisticInfo.ConnectUnit connectUnit;
        RequestBody requestBody;
        StatisticInfo.StatisticUnit lastUnit;
        if (!((IQWalletCgiReport) QRoute.api(IQWalletCgiReport.class)).shouldReportRequestBody(retCode)) {
            return "";
        }
        StatisticInfo statisticsInfo = result.getStatisticsInfo();
        FormBody formBody = null;
        if (statisticsInfo != null && (lastUnit = statisticsInfo.getLastUnit()) != null) {
            connectUnit = lastUnit.getConnectUnit();
        } else {
            connectUnit = null;
        }
        if (connectUnit != null) {
            requestBody = connectUnit.getBody();
        } else {
            requestBody = null;
        }
        if (requestBody instanceof FormBody) {
            formBody = (FormBody) requestBody;
        }
        if (formBody == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        int size = formBody.size();
        for (int i3 = 0; i3 < size; i3++) {
            sb5.append("\"" + formBody.name(i3) + "\":\"" + formBody.value(i3) + "\",");
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "requestBody.toString()");
        return sb6;
    }

    private final void reportToBeacon(NetResult result) {
        JSONObject jSONObject;
        String str;
        String str2;
        BeaconReportAction beaconReportAction;
        String str3;
        String str4;
        long j3;
        Object bizResponse = result.getBizResponse();
        String str5 = null;
        if (bizResponse instanceof JSONObject) {
            jSONObject = (JSONObject) bizResponse;
        } else {
            jSONObject = null;
        }
        if (jSONObject != null) {
            str = jSONObject.optString("retcode");
        } else {
            str = null;
        }
        if (str == null) {
            str = "-1";
        }
        String str6 = str;
        String url = result.getUrl();
        if (jSONObject != null) {
            str5 = jSONObject.optString("retmsg");
        }
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        String simpleString = ExceptionUtils.INSTANCE.toSimpleString(result.getThrowable());
        if (simpleString == null) {
            str3 = "";
            beaconReportAction = this;
        } else {
            beaconReportAction = this;
            str3 = simpleString;
        }
        String requestBody = beaconReportAction.getRequestBody(result, str6);
        if (result instanceof PaySsoResult) {
            str4 = q.f250387s;
        } else {
            str4 = "cgi";
        }
        CgiReportBean cgiReportBean = new CgiReportBean("e_cgi", url, str6, str2, str3, requestBody, 0L, 0L, 0L, 0L, 0L, null, 0, str4, 8128, null);
        StatisticInfo statisticsInfo = result.getStatisticsInfo();
        if (statisticsInfo != null) {
            cgiReportBean.j(statisticsInfo.getTotalTime());
            StatisticInfo.StatisticUnit lastUnit = statisticsInfo.getLastUnit();
            if (lastUnit != null) {
                j3 = lastUnit.getUnitTotalTime();
            } else {
                j3 = -1;
            }
            cgiReportBean.i(j3);
            cgiReportBean.e(statisticsInfo.getEncryptUnit().getDhCostTime());
            cgiReportBean.h(statisticsInfo.getEncryptUnit().getEncryptTime());
            cgiReportBean.d(statisticsInfo.getEncryptUnit().getDecryptTime());
            cgiReportBean.g(statisticsInfo.getEncryptUnit().getEncryptAlgorithm());
            cgiReportBean.f(statisticsInfo.getEncryptUnit().getDhCtrlCode());
        }
        ((IQWalletCgiReport) QRoute.api(IQWalletCgiReport.class)).report(cgiReportBean);
    }

    @Override // com.tenpay.sdk.net.core.actions.IByPassAction
    public void onBeforeCallback(@NotNull String url, @NotNull NetResult result) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(result, "result");
        reportToBeacon(result);
    }
}
