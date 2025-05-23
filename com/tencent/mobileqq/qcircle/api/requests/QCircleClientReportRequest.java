package com.tencent.mobileqq.qcircle.api.requests;

import android.text.TextUtils;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.utils.QCircleDeviceInfoUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.o;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon$Entry;
import feedcloud.FeedCloudCommon$Result;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.text.Typography;
import qqcircle.QQCircleReport$SingleDcData;
import qqcircle.QQCircleReport$StDataReportReq;
import qqcircle.QQCircleReport$StDataReportRsp;
import uq3.c;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleClientReportRequest extends QCircleBaseRequest {
    private QQCircleReport$StDataReportReq mReq;

    public QCircleClientReportRequest(List<QQCircleReport$SingleDcData> list) {
        QQCircleReport$StDataReportReq qQCircleReport$StDataReportReq = new QQCircleReport$StDataReportReq();
        this.mReq = qQCircleReport$StDataReportReq;
        qQCircleReport$StDataReportReq.dcdata.set(list);
    }

    private void checkInvalidReportValue() {
        QQCircleReport$StDataReportReq qQCircleReport$StDataReportReq = this.mReq;
        if (qQCircleReport$StDataReportReq != null && !qQCircleReport$StDataReportReq.dcdata.get().isEmpty()) {
            StringBuilder sb5 = new StringBuilder();
            Iterator it = new ArrayList(this.mReq.dcdata.get()).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                QQCircleReport$SingleDcData qQCircleReport$SingleDcData = (QQCircleReport$SingleDcData) it.next();
                if (qQCircleReport$SingleDcData == null) {
                    sb5.append("singleDcData is null");
                    break;
                }
                String str = "";
                String str2 = "";
                for (FeedCloudCommon$Entry feedCloudCommon$Entry : qQCircleReport$SingleDcData.report_data.get()) {
                    if (feedCloudCommon$Entry.key.get().equals("actiontype")) {
                        str = feedCloudCommon$Entry.value.get();
                    }
                    if (feedCloudCommon$Entry.key.get().equals("subactiontype")) {
                        str2 = feedCloudCommon$Entry.value.get();
                    }
                    if (feedCloudCommon$Entry.value.get() == null) {
                        sb5.append("dcId: ");
                        sb5.append(qQCircleReport$SingleDcData.dcid.get());
                        sb5.append(", key: ");
                        sb5.append(feedCloudCommon$Entry.key.get());
                        sb5.append(", ");
                        if (!TextUtils.isEmpty(str)) {
                            sb5.append("actionType: ");
                            sb5.append(str);
                            sb5.append(", ");
                        }
                        if (!TextUtils.isEmpty(str2)) {
                            sb5.append("subActionType: ");
                            sb5.append(str2);
                            sb5.append(", ");
                        }
                    }
                }
            }
            if (!TextUtils.isEmpty(sb5.toString())) {
                QLog.d("QCircleClientReportRequest", 1, sb5);
                return;
            }
            return;
        }
        QLog.d("QCircleClientReportRequest", 1, "mReq empty.");
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected boolean enableGzipCompress() {
        if (QCircleDeviceInfoUtils.isLowDevice()) {
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_gzip_cmds_product", true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.network.request.VSBaseRequest
    public String generateDeviceInfo() {
        if (!c.O()) {
            return super.generateDeviceInfo();
        }
        StringBuilder sb5 = VSBaseRequest.sRequestStringBuilder.get();
        if (sb5 != null) {
            sb5.setLength(0);
            sb5.append("qimei=");
            sb5.append(o.b());
            sb5.append(Typography.amp);
            sb5.append("qimei36=");
            sb5.append(o.c());
            return sb5.toString();
        }
        return "";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public String getCmdName() {
        return "FeedCloudSvr.trpc.circlereport.clientreport.ClientReport.DataReport";
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public int getNewSeq() {
        try {
            return super.getNewSeq();
        } catch (Throwable th5) {
            QLog.d(BaseRequest.TAG, 1, "[getNewSeq] ex: " + th5);
            return 0;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    protected byte[] getRequestByteData() {
        try {
            return this.mReq.toByteArray();
        } catch (Exception e16) {
            checkInvalidReportValue();
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_catch_invalid_quality_report_9080", false)) {
                return new byte[0];
            }
            throw e16;
        }
    }

    @Override // com.tencent.biz.richframework.network.request.BaseRequest
    public MessageMicro decode(byte[] bArr) {
        MessageMicro<QQCircleReport$StDataReportRsp> messageMicro = new MessageMicro<QQCircleReport$StDataReportRsp>() { // from class: qqcircle.QQCircleReport$StDataReportRsp
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"result"}, new Object[]{null}, QQCircleReport$StDataReportRsp.class);
            public FeedCloudCommon$Result result = new FeedCloudCommon$Result();
        };
        if (enableGzipCompress()) {
            return messageMicro;
        }
        try {
            messageMicro.mergeFrom(bArr);
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
        }
        return messageMicro;
    }
}
