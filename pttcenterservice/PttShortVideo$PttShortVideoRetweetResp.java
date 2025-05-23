package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoRetweetResp extends MessageMicro<PttShortVideo$PttShortVideoRetweetResp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 74, 82, 88, 96}, new String[]{"int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "str_fileid", "bytes_ukey", "uint32_file_exist", "rpt_same_area_inner_addr", "rpt_diff_area_inner_addr", "rpt_data_hole", "uint32_is_hot_file", "uint32_long_video_carry_watch_point_type"}, new Object[]{0, "", null, null, "", ByteStringMicro.EMPTY, 0, null, null, null, 0, 0}, PttShortVideo$PttShortVideoRetweetResp.class);
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);
    public final PBStringField str_fileid = PBField.initString("");
    public final PBBytesField bytes_ukey = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_file_exist = PBField.initUInt32(0);
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_same_area_inner_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_diff_area_inner_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo$DataHole> rpt_data_hole = PBField.initRepeatMessage(PttShortVideo$DataHole.class);
    public final PBUInt32Field uint32_is_hot_file = PBField.initUInt32(0);
    public final PBUInt32Field uint32_long_video_carry_watch_point_type = PBField.initUInt32(0);
}
