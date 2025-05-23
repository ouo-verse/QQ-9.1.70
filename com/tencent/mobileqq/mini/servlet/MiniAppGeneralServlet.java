package com.tencent.mobileqq.mini.servlet;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.Packet;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAppGeneralServlet extends MiniAppAbstractServlet {
    public static final String DATA_REPORT_CMD_STRING = "LightAppSvc.mini_app_report_transfer.DataReport";
    public static final int ERR_MSF_EXCEPTION = -1000001;
    public static final int ERR_MSF_FAIL = -1000000;
    public static final String TAG = "MiniAppGetLoginCodeServlet";

    public MiniAppGeneralServlet() {
        this.observerId = 9000;
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        Bundle bundle = new Bundle();
        try {
            bundle.putInt(MiniAppCmdUtil.KEY_INDEX, intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1));
            if (fromServiceMsg != null) {
                if (fromServiceMsg.isSuccess()) {
                    byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
                    bundle.putLong("retCode", 0L);
                    bundle.putString("errMsg", "");
                    bundle.putByteArray(MiniAppCmdUtil.KEY_RSP_DATA, a16);
                    notifyObserver(intent, this.observerId, true, bundle, MiniAppObserver.class);
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("MiniAppGetLoginCodeServlet", 2, "onReceive. " + MiniAppObserver.getCmdByObserverId(this.observerId) + " failed: " + fromServiceMsg.getBusinessFailCode() + "  errMsg:" + fromServiceMsg.getBusinessFailMsg());
                }
                bundle.putLong("retCode", fromServiceMsg.getBusinessFailCode());
                bundle.putString("errMsg", fromServiceMsg.getBusinessFailMsg());
                notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d("MiniAppGetLoginCodeServlet", 2, "onReceive. inform  resultcode fail.");
            }
            bundle.putLong("retCode", -1000000L);
            bundle.putString("errMsg", "msf response fail.");
            notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
        } catch (Throwable th5) {
            QLog.e("MiniAppGetLoginCodeServlet", 1, "onReceive error", th5);
            bundle.putLong("retCode", -1000001L);
            bundle.putString("errMsg", "onReceive exception");
            notifyObserver(intent, this.observerId, false, bundle, MiniAppObserver.class);
        }
    }

    @Override // com.tencent.mobileqq.mini.servlet.MiniAppAbstractServlet, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        intent.getIntExtra(MiniAppCmdUtil.KEY_INDEX, -1);
        byte[] byteArrayExtra = intent.getByteArrayExtra("key_request_data");
        String stringExtra = intent.getStringExtra(MiniAppCmdUtil.KEY_CMD_STRING);
        if (stringExtra.equals("LightAppSvc.mini_app_report_transfer.DataReport")) {
            setShouldPerformDCReport(false);
        }
        String traceId = getTraceId();
        if (byteArrayExtra != null) {
            if (!TextUtils.isEmpty(stringExtra)) {
                if (QLog.isColorLevel()) {
                    QLog.e("MiniAppGetLoginCodeServlet", 2, " cmdString:" + stringExtra + "  traceId:" + traceId);
                }
                packet.setSSOCommand(stringExtra);
                packet.putSendData(fh.b(byteArrayExtra));
                packet.setTimeout(intent.getLongExtra("timeout", 30000L));
                super.onSend(intent, packet);
                return;
            }
            throw new RuntimeException("cmd_string is null!");
        }
        throw new RuntimeException("req data is null!");
    }
}
