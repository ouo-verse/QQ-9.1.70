package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class QQGameResFlowControl$ResourcePermitRsp extends MessageMicro<QQGameResFlowControl$ResourcePermitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"res_state", "internal_time"}, new Object[]{0, 0L}, QQGameResFlowControl$ResourcePermitRsp.class);
    public final PBEnumField res_state = PBField.initEnum(0);
    public final PBUInt64Field internal_time = PBField.initUInt64(0);
}
