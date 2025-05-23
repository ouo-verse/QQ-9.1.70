package com.tencent.pb.icebreakhotpic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class IcebreakHotPic$ReqBody extends MessageMicro<IcebreakHotPic$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 48, 56, 66, 74}, new String[]{"bytes_session_id", "uint64_src_uin", "uint32_src_term", "uint32_aio_type", "uint64_to_uin", "uin32_gender", "uint32_age", "str_client_ver", "session_nick"}, new Object[]{ByteStringMicro.EMPTY, 0L, 0, 0, 0L, 0, 0, "", ""}, IcebreakHotPic$ReqBody.class);
    public final PBBytesField bytes_session_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt32Field uint32_aio_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt32Field uin32_gender = PBField.initUInt32(0);
    public final PBUInt32Field uint32_age = PBField.initUInt32(0);
    public final PBStringField str_client_ver = PBField.initString("");
    public final PBStringField session_nick = PBField.initString("");
}
