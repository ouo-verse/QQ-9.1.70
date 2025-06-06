package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoRetweetReq extends MessageMicro<PttShortVideo$PttShortVideoRetweetReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 66, 72, 82, 88, 160, 168}, new String[]{"uint64_from_uin", "uint64_to_uin", "uint32_from_chat_type", "uint32_to_chat_type", "uint32_from_busi_type", "uint32_to_busi_type", "uint32_client_type", "msg_PttShortVideoFileInfo", "uint32_agent_type", "str_fileid", "uint64_group_code", "uint32_flag_support_large_size", "uint32_codec_format"}, new Object[]{0L, 0L, 0, 0, 0, 0, 0, null, 0, "", 0L, 0, 0}, PttShortVideo$PttShortVideoRetweetReq.class);
    public final PBUInt64Field uint64_from_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_to_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_from_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_to_chat_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_from_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_to_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public PttShortVideo$PttShortVideoFileInfo msg_PttShortVideoFileInfo = new PttShortVideo$PttShortVideoFileInfo();
    public final PBUInt32Field uint32_agent_type = PBField.initUInt32(0);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0);
    public final PBUInt32Field uint32_flag_support_large_size = PBField.initUInt32(0);
    public final PBUInt32Field uint32_codec_format = PBField.initUInt32(0);
}
