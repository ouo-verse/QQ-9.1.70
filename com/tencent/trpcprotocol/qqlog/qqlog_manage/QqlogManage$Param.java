package com.tencent.trpcprotocol.qqlog.qqlog_manage;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class QqlogManage$Param extends MessageMicro<QqlogManage$Param> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"key", "value"}, new Object[]{"", ""}, QqlogManage$Param.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
}
