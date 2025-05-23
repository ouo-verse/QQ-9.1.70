package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes3.dex */
public final class ReqGroupVideo$RspShareBackflowVerify extends MessageMicro<ReqGroupVideo$RspShareBackflowVerify> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50}, new String[]{"result", "uint64_group_code", "uint64_room_id", "uint32_room_create_time", "enum_verify_status", "bytes_wording"}, new Object[]{null, 0L, 0L, 0, 0, ByteStringMicro.EMPTY}, ReqGroupVideo$RspShareBackflowVerify.class);
    public common$ErrorInfo result = new common$ErrorInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt64Field uint64_room_id = PBField.initUInt64(0);
    public final PBUInt32Field uint32_room_create_time = PBField.initUInt32(0);
    public final PBEnumField enum_verify_status = PBField.initEnum(0);
    public final PBBytesField bytes_wording = PBField.initBytes(ByteStringMicro.EMPTY);
}
