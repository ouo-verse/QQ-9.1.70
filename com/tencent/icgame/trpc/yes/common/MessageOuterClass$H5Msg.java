package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class MessageOuterClass$H5Msg extends MessageMicro<MessageOuterClass$H5Msg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"key", "value", "url", "type"}, new Object[]{"", "", "", 0}, MessageOuterClass$H5Msg.class);
    public final PBStringField key = PBField.initString("");
    public final PBStringField value = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBInt32Field type = PBField.initInt32(0);
}
