package com.tencent.mobileqq.tablequery;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

/* compiled from: P */
/* loaded from: classes18.dex */
public class d extends MSFServlet {
    static IPatchRedirector $redirector_;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        boolean z16;
        int i3;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        Bundle bundle = new Bundle();
        boolean isSuccess = fromServiceMsg.isSuccess();
        if (isSuccess) {
            byte[] bArr = new byte[r13.getInt() - 4];
            ByteBuffer.wrap(fromServiceMsg.getWupBuffer()).get(bArr);
            oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
            try {
                oidb_sso_oidbssopkg.mergeFrom(bArr);
                i3 = oidb_sso_oidbssopkg.uint32_result.get();
                if (i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e = e16;
            }
            try {
                if (z17) {
                    ReportData$RspBody reportData$RspBody = new ReportData$RspBody();
                    reportData$RspBody.mergeFrom(oidb_sso_oidbssopkg.bytes_bodybuffer.get().toByteArray());
                    long j3 = reportData$RspBody.ret.get();
                    byte[] byteArray = reportData$RspBody.f291342msg.get().toByteArray();
                    List<ReportData$ReportDataItem> list = reportData$RspBody.reportArray.get();
                    if (list != null && list.size() != 0) {
                        ReportData$ReportDataItem reportData$ReportDataItem = list.get(0);
                        bundle.putLong("ret", j3);
                        bundle.putByteArray("msg", byteArray);
                        bundle.putString("reqReportId", reportData$ReportDataItem.reqReportId.get());
                        bundle.putString("reportId", reportData$ReportDataItem.reportId.get());
                        bundle.putLong("pv", reportData$ReportDataItem.f291340pv.get());
                        bundle.putString("pv_day_earlier", reportData$ReportDataItem.pv_day_earlier.get());
                        bundle.putString("pv_month_earlier", reportData$ReportDataItem.pv_month_earlier.get());
                        bundle.putLong("uv", reportData$ReportDataItem.f291341uv.get());
                        bundle.putString("uv_day_earlier", reportData$ReportDataItem.uv_day_earlier.get());
                        bundle.putString("uv_month_earlier", reportData$ReportDataItem.uv_month_earlier.get());
                        bundle.putString("time", reportData$ReportDataItem.time.get());
                        bundle.putString("param", reportData$ReportDataItem.param.get());
                        bundle.putString("description", reportData$ReportDataItem.description.get());
                    }
                } else {
                    QLog.d("TableQueryServlet", 1, "OIDBSSOPkg\u56de\u5305\u9519\u8bef\uff0cResult: " + i3);
                }
                z16 = z17;
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                isSuccess = z17;
                QLog.e("TableQueryServlet", 2, e, new Object[0]);
                z16 = isSuccess;
                notifyObserver(intent, 0, z16, bundle, c.class);
            }
            notifyObserver(intent, 0, z16, bundle, c.class);
        }
        z16 = isSuccess;
        notifyObserver(intent, 0, z16, bundle, c.class);
    }

    @Override // mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
        } else {
            if (intent == null) {
                return;
            }
            packet.setSSOCommand("OidbSvc.0xd34_2");
            packet.putSendData(fh.b(intent.getByteArrayExtra("RequestBytes")));
        }
    }
}
