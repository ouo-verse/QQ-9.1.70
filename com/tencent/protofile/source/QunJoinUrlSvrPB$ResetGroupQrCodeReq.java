package com.tencent.protofile.source;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class QunJoinUrlSvrPB$ResetGroupQrCodeReq extends MessageMicro<QunJoinUrlSvrPB$ResetGroupQrCodeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", "source_id"}, new Object[]{0L, ""}, QunJoinUrlSvrPB$ResetGroupQrCodeReq.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBStringField source_id = PBField.initString("");
}
