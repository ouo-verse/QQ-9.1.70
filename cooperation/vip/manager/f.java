package cooperation.vip.manager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.open.business.base.MobileInfoUtil;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QUA;
import cooperation.vip.pb.mobile_monitor_report;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.new_year_2014.Unisso$UniSsoServerReq;
import tencent.im.new_year_2014.Unisso$UniSsoServerReqComm;
import tencent.im.new_year_2014.Unisso$UniSsoServerRsp;

/* compiled from: P */
/* loaded from: classes28.dex */
public class f extends MSFServlet {
    private static mobile_monitor_report.UserCommReport a() {
        mobile_monitor_report.UserCommReport userCommReport = new mobile_monitor_report.UserCommReport();
        userCommReport.qua.set(String.valueOf(QUA.getQUA3()));
        userCommReport.imei.set(String.valueOf(MobileInfoUtil.getImei()));
        userCommReport.city_code.set(((ILbsManagerServiceApi) QRoute.api(ILbsManagerServiceApi.class)).getCityCode());
        userCommReport.mobile_type.set(DeviceInfoMonitor.getModel());
        userCommReport.net_type.set(b());
        userCommReport.from_id.set(2);
        return userCommReport;
    }

    private static int b() {
        int networkType = NetworkUtil.getNetworkType(BaseApplication.getContext());
        if (networkType == 1) {
            return 3;
        }
        if (networkType != 2) {
            if (networkType != 3) {
                if (networkType != 4) {
                    return 1;
                }
                return 4;
            }
            return 5;
        }
        return 6;
    }

    private void c(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        mobile_monitor_report.PkgRsp pkgRsp = new mobile_monitor_report.PkgRsp();
        int resultCode = fromServiceMsg.getResultCode();
        if (resultCode == 1000) {
            try {
                Unisso$UniSsoServerRsp unisso$UniSsoServerRsp = new Unisso$UniSsoServerRsp();
                unisso$UniSsoServerRsp.mergeFrom(bArr);
                long j3 = unisso$UniSsoServerRsp.ret.get();
                if (QLog.isColorLevel()) {
                    QLog.d("MonitorServlet", 1, " unissoResult=", Long.valueOf(j3));
                }
                pkgRsp.mergeFrom(unisso$UniSsoServerRsp.rspdata.get().toByteArray());
                int i3 = pkgRsp.ret.get();
                if (i3 == 0) {
                    MonitorManager.f().m(pkgRsp.mult_cnt.get(), pkgRsp.mult_delay.get());
                    if (QLog.isColorLevel()) {
                        QLog.d("MonitorServlet", 2, "onReceive ret " + i3);
                    }
                    notifyObserver(intent, 1000, true, new Bundle(), e.class);
                    return;
                }
                QLog.d("MonitorServlet", 2, "onReceive ret " + i3);
                notifyObserver(intent, 1000, false, new Bundle(), e.class);
                return;
            } catch (Exception e16) {
                QLog.e("MonitorServlet", 2, "onReceive exception " + e16);
                notifyObserver(intent, 1000, false, new Bundle(), e.class);
                return;
            }
        }
        QLog.e("MonitorServlet", 2, "onReceive result fail with result " + resultCode);
        notifyObserver(intent, 1000, false, new Bundle(), e.class);
    }

    private void d(Intent intent, FromServiceMsg fromServiceMsg) {
        byte[] bArr;
        if (fromServiceMsg.isSuccess()) {
            int length = fromServiceMsg.getWupBuffer().length - 4;
            bArr = new byte[length];
            PkgTools.copyData(bArr, 0, fromServiceMsg.getWupBuffer(), 4, length);
        } else {
            bArr = null;
        }
        mobile_monitor_report.PkgRsp pkgRsp = new mobile_monitor_report.PkgRsp();
        int resultCode = fromServiceMsg.getResultCode();
        if (resultCode == 1000 && bArr != null) {
            try {
                Unisso$UniSsoServerRsp unisso$UniSsoServerRsp = new Unisso$UniSsoServerRsp();
                unisso$UniSsoServerRsp.mergeFrom(bArr);
                long j3 = unisso$UniSsoServerRsp.ret.get();
                if (QLog.isColorLevel()) {
                    QLog.d("MonitorServlet", 1, " unissoResult=", Long.valueOf(j3));
                }
                pkgRsp.mergeFrom(unisso$UniSsoServerRsp.rspdata.get().toByteArray());
                int i3 = pkgRsp.ret.get();
                if (i3 == 0) {
                    MonitorManager.f().m(pkgRsp.mult_cnt.get(), pkgRsp.mult_delay.get());
                    if (QLog.isColorLevel()) {
                        QLog.d("MonitorServlet", 2, "onReceive ret " + i3);
                    }
                    notifyObserver(intent, 1000, true, new Bundle(), e.class);
                    return;
                }
                QLog.d("MonitorServlet", 2, "onReceive ret " + i3);
                notifyObserver(intent, 1000, false, new Bundle(), e.class);
                return;
            } catch (Exception e16) {
                QLog.e("MonitorServlet", 2, "onReceive exception " + e16);
                notifyObserver(intent, 1000, false, new Bundle(), e.class);
                return;
            }
        }
        QLog.e("MonitorServlet", 2, "onReceive result fail with result " + resultCode);
        notifyObserver(intent, 1000, false, new Bundle(), e.class);
    }

    public static void e(List<mobile_monitor_report.ExceptionReport> list) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        mobile_monitor_report.PkgExceptionReq pkgExceptionReq = new mobile_monitor_report.PkgExceptionReq();
        pkgExceptionReq.exception_report.set(list);
        pkgExceptionReq.user_comm_report.set(a());
        NewIntent newIntent = new NewIntent(runtime.getApplication(), f.class);
        Unisso$UniSsoServerReq unisso$UniSsoServerReq = new Unisso$UniSsoServerReq();
        Unisso$UniSsoServerReqComm unisso$UniSsoServerReqComm = new Unisso$UniSsoServerReqComm();
        unisso$UniSsoServerReqComm.platform.set(109L);
        unisso$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
        unisso$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
        unisso$UniSsoServerReq.comm.set(unisso$UniSsoServerReqComm);
        unisso$UniSsoServerReq.reqdata.set(ByteStringMicro.copyFrom(pkgExceptionReq.toByteArray()));
        newIntent.putExtra("data", fh.b(unisso$UniSsoServerReq.toByteArray()));
        newIntent.putExtra("cmd", "MobileReport.ExceptionReport");
        runtime.startServlet(newIntent);
    }

    public static void f(List<mobile_monitor_report.TraceReport> list) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        mobile_monitor_report.PkgTraceReq pkgTraceReq = new mobile_monitor_report.PkgTraceReq();
        pkgTraceReq.trace_report.set(list);
        pkgTraceReq.user_comm_report.set(a());
        NewIntent newIntent = new NewIntent(runtime.getApplication(), f.class);
        Unisso$UniSsoServerReq unisso$UniSsoServerReq = new Unisso$UniSsoServerReq();
        Unisso$UniSsoServerReqComm unisso$UniSsoServerReqComm = new Unisso$UniSsoServerReqComm();
        unisso$UniSsoServerReqComm.platform.set(109L);
        unisso$UniSsoServerReqComm.osver.set(Build.VERSION.RELEASE);
        unisso$UniSsoServerReqComm.mqqver.set(AppSetting.f99551k);
        unisso$UniSsoServerReq.comm.set(unisso$UniSsoServerReqComm);
        unisso$UniSsoServerReq.reqdata.set(ByteStringMicro.copyFrom(pkgTraceReq.toByteArray()));
        newIntent.putExtra("data", fh.b(unisso$UniSsoServerReq.toByteArray()));
        newIntent.putExtra("cmd", "MobileReport.TraceReport");
        runtime.startServlet(newIntent);
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        String serviceCmd;
        String str;
        if (intent == null || fromServiceMsg == null || (serviceCmd = fromServiceMsg.getServiceCmd()) == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            boolean isSuccess = fromServiceMsg.isSuccess();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("resp:");
            sb5.append(serviceCmd);
            sb5.append(" is ");
            if (isSuccess) {
                str = "";
            } else {
                str = "not";
            }
            sb5.append(str);
            sb5.append(" success");
            QLog.d("MonitorServlet", 2, sb5.toString());
        }
        if (serviceCmd.equals("MobileReport.ExceptionReport")) {
            c(intent, fromServiceMsg);
        } else if (serviceCmd.equals("MobileReport.TraceReport")) {
            d(intent, fromServiceMsg);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        byte[] byteArrayExtra = intent.getByteArrayExtra("data");
        String stringExtra = intent.getStringExtra("cmd");
        long longExtra = intent.getLongExtra("timeout", 10000L);
        packet.setSSOCommand(stringExtra);
        packet.setTimeout(longExtra);
        packet.putSendData(byteArrayExtra);
        if (QLog.isColorLevel()) {
            QLog.d("MonitorServlet", 2, "onSend exit cmd=" + stringExtra);
        }
    }
}
