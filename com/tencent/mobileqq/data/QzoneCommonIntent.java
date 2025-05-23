package com.tencent.mobileqq.data;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.biz.richframework.network.servlet.VSBaseServlet;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.qzone.QZoneCommonRequest;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.ProtocolUtils;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Servlet;

/* compiled from: P */
/* loaded from: classes10.dex */
public class QzoneCommonIntent extends NewIntent {
    static RespProcessor defaultProcessor = new a();
    private RespProcessor processor;
    private QZoneCommonRequest request;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    class a implements RespProcessor {
        a() {
        }

        @Override // com.tencent.mobileqq.data.RespProcessor
        public void accept(MSFServlet mSFServlet, QzoneCommonIntent qzoneCommonIntent, FromServiceMsg fromServiceMsg) {
            JceStruct decode;
            boolean z16;
            QZoneCommonRequest request = qzoneCommonIntent.getRequest();
            String uniKey = request.uniKey();
            int type = request.getType();
            int[] iArr = new int[1];
            String[] strArr = new String[1];
            if (!fromServiceMsg.isSuccess()) {
                iArr[0] = fromServiceMsg.getResultCode() + 300000;
                strArr[0] = fromServiceMsg.getBusinessFailMsg();
                decode = null;
            } else {
                decode = ProtocolUtils.decode(fromServiceMsg.getWupBuffer(), uniKey, iArr, strArr);
            }
            if (QLog.isColorLevel()) {
                QLog.i("QzoneCommonIntent", 2, String.format("cmd :%s, success:%b,code:%d, msg:%s", request.getCmdString(), Boolean.valueOf(QzoneCommonIntent.succeeded(iArr[0])), Integer.valueOf(iArr[0]), strArr[0]));
            }
            Bundle extras = qzoneCommonIntent.getExtras();
            if (extras == null) {
                extras = new Bundle();
            }
            Bundle bundle = extras;
            bundle.putSerializable("key_response", decode);
            bundle.putInt("key_response_code", iArr[0]);
            bundle.putString(VSBaseServlet.KEY_RESPONSE_MSG, strArr[0]);
            if (qzoneCommonIntent.getObserver() == null) {
                QLog.e("QzoneCommonIntent", 1, "observer ==null,\u65e0\u6cd5\u56de\u8c03\uff0c\u8bf7\u68c0\u67e5\u662f\u5426\u6709\u8c03\u7528setObserver");
            }
            if (decode != null && QzoneCommonIntent.succeeded(iArr[0])) {
                z16 = true;
            } else {
                z16 = false;
            }
            mSFServlet.notifyObserver(qzoneCommonIntent, type, z16, bundle, null);
            int i3 = iArr[0];
            if (i3 != 1000006) {
                QzoneCommonIntent.prepareReport(request, i3, strArr[0]);
            }
        }
    }

    public QzoneCommonIntent(Context context, Class<? extends Servlet> cls) {
        super(context, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void prepareReport(QZoneCommonRequest qZoneCommonRequest, int i3, String str) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.CommandId, qZoneCommonRequest.getCmdString());
        statistic.setValue(WnsKeys.APN, NetworkState.getAPN());
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime != null) {
            statistic.setValue(WnsKeys.ToUIN, Long.valueOf(waitAppRuntime.getLongAccountUin()));
        }
        statistic.setValue(WnsKeys.Qua, QUA.getQUA3());
        statistic.setValue(WnsKeys.Build, AppSetting.f99542b);
        if (i3 != 0 && !TextUtils.isEmpty(str)) {
            statistic.setValue(WnsKeys.Detail, str);
            statistic.setValue(WnsKeys.Frequency, 1);
        }
        statisticCollector.put(statistic);
        if (i3 != 0) {
            statisticCollector.forceReport();
        }
    }

    public static boolean succeeded(int i3) {
        if (i3 != 0 && (Math.abs(i3) > 19999 || Math.abs(i3) < 19000)) {
            return false;
        }
        return true;
    }

    public RespProcessor getProcessor() {
        RespProcessor respProcessor = this.processor;
        if (respProcessor == null) {
            return defaultProcessor;
        }
        return respProcessor;
    }

    public QZoneCommonRequest getRequest() {
        return this.request;
    }

    public void setRequest(QZoneCommonRequest qZoneCommonRequest) {
        this.request = qZoneCommonRequest;
    }
}
