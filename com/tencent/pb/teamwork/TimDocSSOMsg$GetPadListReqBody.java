package com.tencent.pb.teamwork;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class TimDocSSOMsg$GetPadListReqBody extends MessageMicro<TimDocSSOMsg$GetPadListReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 56, 66, 72}, new String[]{"uint32_appid", "uint32_timestamp", "uint32_offset", "uint32_count", "uint32_local_count_from_offset", "msg_login_info", "uint32_request_type", "bytes_timestamp", "uint32_list_type"}, new Object[]{0, 0, 0, 0, 0, null, 0, ByteStringMicro.EMPTY, 0}, TimDocSSOMsg$GetPadListReqBody.class);
    public final PBUInt32Field uint32_appid = PBField.initUInt32(0);
    public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
    public final PBUInt32Field uint32_offset = PBField.initUInt32(0);
    public final PBUInt32Field uint32_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_local_count_from_offset = PBField.initUInt32(0);
    public TimDocSSOMsg$LoginInfo msg_login_info = new TimDocSSOMsg$LoginInfo();
    public final PBUInt32Field uint32_request_type = PBField.initUInt32(0);
    public final PBBytesField bytes_timestamp = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_list_type = PBField.initUInt32(0);
}
