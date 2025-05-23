package com.tencent.mobileqq.mini.servlet;

import NS_MINI_REPORT.REPORT$StDcReportRsp;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes33.dex */
public class DcReportRequest extends ProtoBufRequest {
    private byte[] datas;

    public DcReportRequest(byte[] bArr) {
        this.datas = bArr;
    }

    @Override // com.tencent.mobileqq.mini.servlet.ProtoBufRequest
    public byte[] getBusiBuf() {
        return this.datas;
    }

    public static REPORT$StDcReportRsp onResponse(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        REPORT$StDcReportRsp rEPORT$StDcReportRsp = new REPORT$StDcReportRsp();
        try {
            rEPORT$StDcReportRsp.mergeFrom(ProtoBufRequest.decode(bArr));
            return rEPORT$StDcReportRsp;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ProtoBufRequest", 2, "onResponse fail." + e16);
            }
            return null;
        }
    }
}
