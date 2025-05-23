package com.tencent.mobileqq.mini.servlet;

import NS_COMM.COMM;
import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import NS_QWEB_PROTOCAL.PROTOCAL;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.QUA;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DataReportRequest extends ProtoBufRequest {
    public static final String CMD_STRING = "LightAppSvc.mini_app_report_transfer.DataReport";
    private byte[] datas;

    public DataReportRequest(byte[] bArr) {
        this.datas = bArr;
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] encode(Intent intent, int i3, String str) {
        if (!TextUtils.isEmpty(str)) {
            PROTOCAL.StQWebReq stQWebReq = new PROTOCAL.StQWebReq();
            stQWebReq.Seq.set(i3);
            stQWebReq.qua.set(QUA.getQUA3());
            stQWebReq.deviceInfo.set(PlatformInfor.g().getDeviceInfoRemoveAndroidId());
            stQWebReq.busiBuff.set(ByteStringMicro.copyFrom(getBusiBuf()));
            if (!TextUtils.isEmpty(str)) {
                stQWebReq.traceid.set(str);
            }
            if (intent != null) {
                intent.putExtra("traceid", str);
            }
            if (StudyModeManager.t()) {
                COMM.Entry entry = new COMM.Entry();
                entry.key.set("teenager");
                entry.value.set(String.valueOf(1));
                ArrayList arrayList = new ArrayList();
                arrayList.add(entry);
                stQWebReq.Extinfo.set(arrayList);
            }
            return stQWebReq.toByteArray();
        }
        throw new RuntimeException("req traceId is null!");
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.datas;
    }

    public static APP_REPORT_TRANSFER.StDataReportRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        APP_REPORT_TRANSFER.StDataReportRsp stDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
        try {
            stDataReportRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return stDataReportRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
