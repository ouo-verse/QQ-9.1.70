package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoDownloadReq extends MessageMicro<PttShortVideo$PttShortVideoDownloadReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 42, 48, 56, 66, 72, 80, 88, 96, 104, 112, 120, 160, 240, 248, 258, 264}, new String[]{"uint64_fromuin", "uint64_touin", "uint32_chat_type", "uint32_client_type", "str_fileid", "uint64_group_code", "uint32_agent_type", "bytes_file_md5", "uint32_business_type", "uint32_file_type", "uint32_down_type", "uint32_scene_type", "uint32_need_inner_addr", "uint32_req_transfer_type", "uint32_req_host_type", "uint32_flag_support_large_size", "uint32_flag_client_quic_proto_enable", "uint32_target_codec_format", "msg_codec_config", "uint32_source_codec_format"}, new Object[]{0L, 0L, 0, 0, "", 0L, 0, ByteStringMicro.EMPTY, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, 0}, PttShortVideo$PttShortVideoDownloadReq.class);
    public final PBUInt64Field uint64_fromuin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_touin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBBytesField bytes_file_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_business_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_file_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_down_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_scene_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_need_inner_addr = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_transfer_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_host_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_support_large_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flag_client_quic_proto_enable = PBField.initUInt32(0);
    public final PBUInt32Field uint32_target_codec_format = PBField.initUInt32(0);
    public PttShortVideo$CodecConfigReq msg_codec_config = new PttShortVideo$CodecConfigReq();
    public final PBUInt32Field uint32_source_codec_format = PBField.initUInt32(0);
}
