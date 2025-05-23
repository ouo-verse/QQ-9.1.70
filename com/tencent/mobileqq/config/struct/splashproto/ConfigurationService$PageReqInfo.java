package com.tencent.mobileqq.config.struct.splashproto;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes10.dex */
public final class ConfigurationService$PageReqInfo extends MessageMicro<ConfigurationService$PageReqInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34}, new String[]{"task_id", "offset", "version", "cookies"}, new Object[]{0, 0, 0, ByteStringMicro.EMPTY}, ConfigurationService$PageReqInfo.class);
    public final PBUInt32Field task_id = PBField.initUInt32(0);
    public final PBInt32Field offset = PBField.initInt32(0);
    public final PBUInt32Field version = PBField.initUInt32(0);
    public final PBBytesField cookies = PBField.initBytes(ByteStringMicro.EMPTY);
}
