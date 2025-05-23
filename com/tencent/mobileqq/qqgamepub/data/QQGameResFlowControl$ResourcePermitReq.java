package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes16.dex */
public final class QQGameResFlowControl$ResourcePermitReq extends MessageMicro<QQGameResFlowControl$ResourcePermitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"res_url", "res_size"}, new Object[]{"", 0}, QQGameResFlowControl$ResourcePermitReq.class);
    public final PBStringField res_url = PBField.initString("");
    public final PBUInt32Field res_size = PBField.initUInt32(0);
}
