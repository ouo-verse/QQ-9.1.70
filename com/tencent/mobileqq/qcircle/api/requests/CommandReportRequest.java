package com.tencent.mobileqq.qcircle.api.requests;

import NS_MINI_APP_REPORT_TRANSFER.APP_REPORT_TRANSFER;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import java.util.List;

/* compiled from: P */
/* loaded from: classes16.dex */
public class CommandReportRequest extends VSBaseRequest {
    private final APP_REPORT_TRANSFER.StDataReportReq mReq;

    public CommandReportRequest(List<APP_REPORT_TRANSFER.SingleDcData> list) {
        APP_REPORT_TRANSFER.StDataReportReq stDataReportReq = new APP_REPORT_TRANSFER.StDataReportReq();
        this.mReq = stDataReportReq;
        stDataReportReq.dcdata.set(list);
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "MobileQQReport.mini_app_report_transfer.DataReport";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        return this.mReq.toByteArray();
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        APP_REPORT_TRANSFER.StDataReportRsp stDataReportRsp = new APP_REPORT_TRANSFER.StDataReportRsp();
        try {
            stDataReportRsp.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return stDataReportRsp;
    }
}
