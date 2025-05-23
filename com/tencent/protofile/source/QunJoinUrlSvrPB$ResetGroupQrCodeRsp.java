package com.tencent.protofile.source;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;

/* loaded from: classes22.dex */
public final class QunJoinUrlSvrPB$ResetGroupQrCodeRsp extends MessageMicro<QunJoinUrlSvrPB$ResetGroupQrCodeRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{VRReportDefine$ReportParam.IS_SUCCESS}, new Object[]{Boolean.FALSE}, QunJoinUrlSvrPB$ResetGroupQrCodeRsp.class);
    public final PBBoolField is_success = PBField.initBool(false);
}
