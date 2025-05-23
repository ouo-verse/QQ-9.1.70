package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class QBoxEmoticonAuth$GetExpressAuthReq extends MessageMicro<QBoxEmoticonAuth$GetExpressAuthReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"package_id", "expression_id"}, new Object[]{0L, ""}, QBoxEmoticonAuth$GetExpressAuthReq.class);
    public final PBUInt64Field package_id = PBField.initUInt64(0);
    public final PBStringField expression_id = PBField.initString("");
}
