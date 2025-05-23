package cooperation.qzone.report.lp;

import NS_MOBILE_CLIENT_UPDATE.REPORT_INFO;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.report.lp.ILpReportUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.statistic.StatisticCollector;
import cooperation.qzone.statistic.access.WnsKeys;
import cooperation.qzone.statistic.access.concept.Statistic;
import cooperation.qzone.util.ProtocolUtils;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes28.dex */
public class LpReportServlet extends MSFServlet {
    public static final String TAG = "LpReport.LpReportServlet";
    private static final int TIMEOUT = 60000;

    private static void prepareReport(int i3, String str) {
        StatisticCollector statisticCollector = StatisticCollector.getInstance();
        Statistic statistic = statisticCollector.getStatistic();
        statistic.setValue(WnsKeys.AppId, Integer.valueOf(statisticCollector.getAppid()));
        statistic.setValue(WnsKeys.ReleaseVersion, statisticCollector.getReleaseVersion());
        statistic.setValue(WnsKeys.CommandId, "ClientReport.update.ClientReport");
        statistic.setValue(WnsKeys.APN, ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getAPN());
        statistic.setValue(WnsKeys.ResultCode_i, Integer.valueOf(i3));
        statistic.setValue(WnsKeys.ToUIN, Long.valueOf(((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getLongAccountUin()));
        statistic.setValue(WnsKeys.Qua, ((ILpReportUtils) QRoute.api(ILpReportUtils.class)).getQUA3());
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

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        try {
            int[] iArr = new int[1];
            String[] strArr = new String[1];
            if (fromServiceMsg != null) {
                if (fromServiceMsg.getResultCode() == 1000) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 4, "LpReportServlet onReceive success.");
                    }
                    ProtocolUtils.decode(fromServiceMsg.getWupBuffer(), "ClientReport", iArr, strArr);
                } else {
                    QZLog.e(TAG, 1, "LpReportServlet onReceive fail. resultCode:" + Integer.valueOf(fromServiceMsg.getResultCode()));
                    iArr[0] = fromServiceMsg.getResultCode() + 300000;
                    strArr[0] = fromServiceMsg.getBusinessFailMsg();
                }
            } else {
                iArr[0] = -1111;
                strArr[0] = "fromServiceMsg == null";
            }
            int i3 = iArr[0];
            if (i3 != 1000006) {
                prepareReport(i3, strArr[0]);
            }
        } catch (Exception e16) {
            QZLog.e(TAG, 1, e16, new Object[0]);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        int i3;
        if (intent instanceof LpReportNewIntent) {
            LpReportNewIntent lpReportNewIntent = (LpReportNewIntent) intent;
            LpReportRequest lpReportRequest = new LpReportRequest(lpReportNewIntent.type, lpReportNewIntent.info, lpReportNewIntent.extra_info, lpReportNewIntent.multi_info);
            byte[] encode = lpReportRequest.encode();
            if (encode == null) {
                encode = new byte[4];
            }
            packet.setTimeout(60000L);
            packet.setSSOCommand(QZoneHelper.CMD_PREFIX_PUBLIC + lpReportRequest.uniKey());
            packet.putSendData(encode);
            if (QLog.isColorLevel()) {
                StringBuilder sb5 = new StringBuilder();
                sb5.append("startReport, tabletype = ");
                sb5.append(lpReportNewIntent.type);
                sb5.append(", size = ");
                ArrayList<REPORT_INFO> arrayList = lpReportNewIntent.multi_info;
                if (arrayList != null) {
                    i3 = arrayList.size();
                } else {
                    i3 = 0;
                }
                sb5.append(i3);
                QLog.i(TAG, 2, sb5.toString());
            }
        }
    }
}
