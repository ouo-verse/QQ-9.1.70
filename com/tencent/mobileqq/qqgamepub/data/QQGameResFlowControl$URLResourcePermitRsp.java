package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes16.dex */
public final class QQGameResFlowControl$URLResourcePermitRsp extends MessageMicro<QQGameResFlowControl$URLResourcePermitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"state_list", "internal_time"}, new Object[]{null, 0L}, QQGameResFlowControl$URLResourcePermitRsp.class);
    public final PBRepeatMessageField<QQGameResFlowControl$URLResourceState> state_list = PBField.initRepeatMessage(QQGameResFlowControl$URLResourceState.class);
    public final PBUInt64Field internal_time = PBField.initUInt64(0);
}
