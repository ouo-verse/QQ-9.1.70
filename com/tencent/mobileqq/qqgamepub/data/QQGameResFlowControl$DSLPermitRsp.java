package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* loaded from: classes16.dex */
public final class QQGameResFlowControl$DSLPermitRsp extends MessageMicro<QQGameResFlowControl$DSLPermitRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"res_state"}, new Object[]{0}, QQGameResFlowControl$DSLPermitRsp.class);
    public final PBEnumField res_state = PBField.initEnum(0);
}
