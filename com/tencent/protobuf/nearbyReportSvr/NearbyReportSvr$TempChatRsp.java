package com.tencent.protobuf.nearbyReportSvr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NearbyReportSvr$TempChatRsp extends MessageMicro<NearbyReportSvr$TempChatRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ret_code", "ret_msg"}, new Object[]{0, ""}, NearbyReportSvr$TempChatRsp.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
}
