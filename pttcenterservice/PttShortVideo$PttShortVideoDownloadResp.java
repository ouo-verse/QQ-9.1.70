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
public final class PttShortVideo$PttShortVideoDownloadResp extends MessageMicro<PttShortVideo$PttShortVideoDownloadResp> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_downloadkey;
    public final PBBytesField bytes_encrypt_key;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_server_quic_para;
    public PttShortVideo$PttShortVideoAddr msg_download_addr;
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_diff_area_inner_addr;
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_same_area_inner_addr;
    public final PBUInt32Field uint32_codec_format;
    public final PBUInt32Field uint32_flag_server_quic_proto_enable;
    public final PBInt32Field int32_ret_code = PBField.initInt32(0);
    public final PBStringField str_ret_msg = PBField.initString("");
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_same_area_out_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);
    public final PBRepeatMessageField<PttShortVideo$PttShortVideoIpList> rpt_diff_area_out_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82, 240, 250, 256}, new String[]{"int32_ret_code", "str_ret_msg", "rpt_same_area_out_addr", "rpt_diff_area_out_addr", "bytes_downloadkey", "bytes_file_md5", "rpt_same_area_inner_addr", "rpt_diff_area_inner_addr", "msg_download_addr", "bytes_encrypt_key", "uint32_flag_server_quic_proto_enable", "bytes_server_quic_para", "uint32_codec_format"}, new Object[]{0, "", null, null, byteStringMicro, byteStringMicro, null, null, null, byteStringMicro, 0, byteStringMicro, 0}, PttShortVideo$PttShortVideoDownloadResp.class);
    }

    public PttShortVideo$PttShortVideoDownloadResp() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_downloadkey = PBField.initBytes(byteStringMicro);
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.rpt_same_area_inner_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);
        this.rpt_diff_area_inner_addr = PBField.initRepeatMessage(PttShortVideo$PttShortVideoIpList.class);
        this.msg_download_addr = new PttShortVideo$PttShortVideoAddr();
        this.bytes_encrypt_key = PBField.initBytes(byteStringMicro);
        this.uint32_flag_server_quic_proto_enable = PBField.initUInt32(0);
        this.bytes_server_quic_para = PBField.initBytes(byteStringMicro);
        this.uint32_codec_format = PBField.initUInt32(0);
    }
}
