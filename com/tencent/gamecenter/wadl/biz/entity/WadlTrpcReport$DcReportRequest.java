package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WadlTrpcReport$DcReportRequest extends MessageMicro<WadlTrpcReport$DcReportRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{QQPermissionConstants.Permission.AUIDO_GROUP}, new Object[]{null}, WadlTrpcReport$DcReportRequest.class);
    public final PBRepeatMessageField<WadlTrpcReport$DcRecord> record = PBField.initRepeatMessage(WadlTrpcReport$DcRecord.class);
}
