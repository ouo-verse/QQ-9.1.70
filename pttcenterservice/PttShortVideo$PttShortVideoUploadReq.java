package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoUploadReq extends MessageMicro<PttShortVideo$PttShortVideoUploadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 64, 74, 80, 160, 168}, new String[]{"uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "msg_PttShortVideoFileInfo", "uint64_group_code", "uint32_agent_type", "uint32_business_type", "bytes_encrypt_key", "uint32_sub_business_type", "uint32_flag_support_large_size", "uint32_codec_format"}, new Object[]{0L, 0L, 0, 0, null, 0L, 0, 0, ByteStringMicro.EMPTY, 0, 0, 0}, PttShortVideo$PttShortVideoUploadReq.class);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public PttShortVideo$PttShortVideoFileInfo msg_PttShortVideoFileInfo = new PttShortVideo$PttShortVideoFileInfo();
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBBytesField bytes_encrypt_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_sub_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_support_large_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_codec_format = PBField.initUInt32(0);
}
