package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class QQGameResFlowControl$DSLPermitReq extends MessageMicro<QQGameResFlowControl$DSLPermitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"active_id"}, new Object[]{""}, QQGameResFlowControl$DSLPermitReq.class);
    public final PBStringField active_id = PBField.initString("");
}
