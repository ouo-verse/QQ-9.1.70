package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoDeleteReq extends MessageMicro<PttShortVideo$PttShortVideoDeleteReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66, 72}, new String[]{"uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "uint32_agent_type", "bytes_file_md5", "uint32_business_type"}, new Object[]{0L, 0L, 0, 0, "", 0L, 0, ByteStringMicro.EMPTY, 0}, PttShortVideo$PttShortVideoDeleteReq.class);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
}
