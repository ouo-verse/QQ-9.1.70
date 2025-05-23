package com.qzone.misc.network.ttt;

import ELABORATE_FEED_REPORT.comm_qzone_report_req;
import ELABORATE_FEED_REPORT.comm_qzone_report_rsp;
import android.util.Log;
import com.qzone.common.business.IQZoneServiceListener;
import com.qzone.common.business.QZoneBusinessLooper;
import com.qzone.common.business.task.QZoneTask;
import com.qzone.common.protocol.request.QZoneRequest;
import cooperation.qzone.util.QZLog;

/* compiled from: P */
/* loaded from: classes39.dex */
public class TTTWNSRequestHelper implements IQZoneServiceListener {

    /* renamed from: f, reason: collision with root package name */
    private static TTTWNSRequestHelper f48524f;

    /* renamed from: d, reason: collision with root package name */
    private final String f48525d = "TTTWNSRequestHelper";

    /* renamed from: e, reason: collision with root package name */
    private final String f48526e = "TTTReportCallBack";

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class TTTRealTimeRequest extends QZoneRequest {
        private String cmd;

        public TTTRealTimeRequest(String str, comm_qzone_report_req comm_qzone_report_reqVar) {
            super(str);
            this.cmd = str;
            this.req = comm_qzone_report_reqVar;
        }

        @Override // com.qzone.common.protocol.request.QZoneRequest
        public String getReportEventName() {
            return "TTTRealTimeReport";
        }

        @Override // com.qzone.common.protocol.request.QZoneRequest, cooperation.qzone.QzoneExternalRequest
        public String uniKey() {
            return this.cmd;
        }
    }

    public static TTTWNSRequestHelper b() {
        if (f48524f == null) {
            synchronized (TTTWNSRequestHelper.class) {
                if (f48524f == null) {
                    f48524f = new TTTWNSRequestHelper();
                }
            }
        }
        return f48524f;
    }

    public void a(String str, comm_qzone_report_req comm_qzone_report_reqVar, e eVar) {
        QZoneTask qZoneTask = new QZoneTask(new TTTRealTimeRequest(str, comm_qzone_report_reqVar), null, this, 1);
        qZoneTask.addParameter("TTTReportCallBack", eVar);
        QZoneBusinessLooper.getInstance().runTask(qZoneTask);
    }

    @Override // com.qzone.common.business.IQZoneServiceListener
    public void onTaskResponse(QZoneTask qZoneTask) {
        QZLog.d("TTTWNSRequestHelper", 4, "onTaskResponse type: " + qZoneTask.mType + " resp: " + qZoneTask.mResultCode);
        if (qZoneTask.mType != 1) {
            return;
        }
        e eVar = (e) qZoneTask.getParameter("TTTReportCallBack");
        if (eVar != null) {
            comm_qzone_report_rsp comm_qzone_report_rspVar = (comm_qzone_report_rsp) qZoneTask.mRequest.rsp;
            if (comm_qzone_report_rspVar == null) {
                return;
            }
            int i3 = comm_qzone_report_rspVar.iRetCode;
            if (i3 == 0) {
                eVar.b();
                return;
            } else {
                eVar.a(i3, comm_qzone_report_rspVar.strErrorMsg);
                return;
            }
        }
        comm_qzone_report_rsp comm_qzone_report_rspVar2 = (comm_qzone_report_rsp) qZoneTask.mRequest.rsp;
        if (comm_qzone_report_rspVar2 == null) {
            return;
        }
        if (comm_qzone_report_rspVar2.iRetCode == 0) {
            Log.i("TTTWNSRequestHelper", "report success");
        } else {
            Log.i("TTTWNSRequestHelper", "report failed");
        }
    }
}
