package cooperation.qzone.video;

import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.mobileqq.myapp.net.HttpResponseException;
import com.tencent.mobileqq.myapp.net.a;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import cooperation.qzone.QUA;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.NetworkState;
import java.net.URLEncoder;
import mqq.app.MSFServlet;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes38.dex */
public class TcSdkDownloadReportServlet extends MSFServlet {
    public static final String TAG = "TcSdkDownloadReportServlet";

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class ReportRunnable implements Runnable {
        private String mReportUrl;

        public ReportRunnable(String str) {
            this.mReportUrl = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TcSdkDownloadReportServlet.TAG, 4, "tcSdkReport, report:" + this.mReportUrl);
                }
                a.d(this.mReportUrl, null, "GET", null);
                if (QLog.isDevelopLevel()) {
                    QLog.d(TcSdkDownloadReportServlet.TAG, 4, "report success");
                }
            } catch (HttpResponseException e16) {
                QLog.w(TcSdkDownloadReportServlet.TAG, 2, "TcSdkDownloadReport failed, code=" + e16.getStateCode());
            } catch (Exception e17) {
                QLog.w(TcSdkDownloadReportServlet.TAG, 2, "", e17);
            }
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String str;
        try {
            String serviceCmd = fromServiceMsg.getServiceCmd();
            if (intent != null) {
                if (!MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd().equalsIgnoreCase(serviceCmd)) {
                    str = "";
                } else {
                    str = (String) fromServiceMsg.getAttribute(MsfMsgUtil.getGatewayIpMsg(null).getServiceCmd());
                }
                if (TextUtils.isEmpty(str)) {
                    QLog.w(TAG, 2, "can not get ip address");
                }
                report(intent, str);
            }
        } catch (Exception e16) {
            QLog.w(TAG, 2, "", e16);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        ToServiceMsg gatewayIpMsg = MsfMsgUtil.getGatewayIpMsg(null);
        gatewayIpMsg.setTimeout(30000L);
        gatewayIpMsg.setNeedCallback(true);
        gatewayIpMsg.setNeedRemindSlowNetwork(false);
        sendToMSF(intent, gatewayIpMsg);
    }

    private void report(Intent intent, String str) {
        int i3;
        int i16;
        try {
            String config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_TCSDKREPORT_URL, "");
            String stringExtra = intent.getStringExtra("uin");
            String qua3 = QUA.getQUA3();
            String model = DeviceInfoMonitor.getModel();
            String str2 = Build.VERSION.RELEASE;
            String stringExtra2 = intent.getStringExtra("report_msg");
            if (NetworkState.isNetSupport()) {
                int networkType = NetworkState.getNetworkType();
                int i17 = networkType != 1 ? networkType != 2 ? networkType != 3 ? networkType != 4 ? networkType != 5 ? 5 : 6 : 4 : 3 : 2 : 1;
                int apnValue = NetworkState.getApnValue();
                if (apnValue == 1) {
                    i3 = i17;
                    i16 = 1;
                } else if (apnValue == 2) {
                    i3 = i17;
                    i16 = 2;
                } else if (apnValue == 3) {
                    i3 = i17;
                    i16 = 3;
                } else if (apnValue != 4) {
                    i3 = i17;
                    i16 = 4;
                } else {
                    i3 = i17;
                    i16 = 5;
                }
            } else {
                i16 = 0;
                i3 = 0;
            }
            try {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.BackGroundThread).post(new ReportRunnable((config + "?BossId=3590&Pwd=1432018701&userLocalIP=" + str + "&uin=" + stringExtra + "&apn=" + i16 + "&netStatus=" + i3 + "&deviceID=" + model + "&deviceOS=" + str2 + "&SDKReportDetailJSONStr=" + URLEncoder.encode(stringExtra2, "UTF-8") + "&QUA=" + qua3 + "&_dc=" + Math.random()).trim().replace(" ", "")));
            } catch (Exception e16) {
                e = e16;
                QLog.w(TAG, 2, "", e);
            }
        } catch (Exception e17) {
            e = e17;
        }
    }
}
