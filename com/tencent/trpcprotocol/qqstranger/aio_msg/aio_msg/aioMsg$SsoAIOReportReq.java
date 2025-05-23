package com.tencent.trpcprotocol.qqstranger.aio_msg.aio_msg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class aioMsg$SsoAIOReportReq extends MessageMicro<aioMsg$SsoAIOReportReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"to_tinyid", "aio_action", "aio_source", "ext_data"}, new Object[]{0L, 0, 0, ByteStringMicro.EMPTY}, aioMsg$SsoAIOReportReq.class);
    public final PBUInt64Field to_tinyid = PBField.initUInt64(0);
    public final PBEnumField aio_action = PBField.initEnum(0);
    public final PBEnumField aio_source = PBField.initEnum(0);
    public final PBBytesField ext_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
