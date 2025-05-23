package pttcenterservice;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$PttShortVideoFileInfo extends MessageMicro<PttShortVideo$PttShortVideoFileInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_decrypt_thumb_md5;
    public final PBBytesField bytes_decrypt_video_md5;
    public final PBBytesField bytes_extend;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_thumb_file_md5;
    public final PBStringField str_file_name = PBField.initString("");
    public final PBUInt32Field uint32_file_format;
    public final PBUInt32Field uint32_file_res_length;
    public final PBUInt32Field uint32_file_res_width;
    public final PBUInt32Field uint32_file_time;
    public final PBUInt64Field uint64_decrypt_file_size;
    public final PBUInt64Field uint64_decrypt_thumb_size;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_thumb_file_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56, 64, 72, 82, 88, 98, 104, 114}, new String[]{"str_file_name", "bytes_file_md5", "bytes_thumb_file_md5", "uint64_file_size", "uint32_file_res_length", "uint32_file_res_width", "uint32_file_format", "uint32_file_time", "uint64_thumb_file_size", "bytes_decrypt_video_md5", "uint64_decrypt_file_size", "bytes_decrypt_thumb_md5", "uint64_decrypt_thumb_size", "bytes_extend"}, new Object[]{"", byteStringMicro, byteStringMicro, 0L, 0, 0, 0, 0, 0L, byteStringMicro, 0L, byteStringMicro, 0L, byteStringMicro}, PttShortVideo$PttShortVideoFileInfo.class);
    }

    public PttShortVideo$PttShortVideoFileInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_thumb_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.uint32_file_res_length = PBField.initUInt32(0);
        this.uint32_file_res_width = PBField.initUInt32(0);
        this.uint32_file_format = PBField.initUInt32(0);
        this.uint32_file_time = PBField.initUInt32(0);
        this.uint64_thumb_file_size = PBField.initUInt64(0L);
        this.bytes_decrypt_video_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_decrypt_file_size = PBField.initUInt64(0L);
        this.bytes_decrypt_thumb_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_decrypt_thumb_size = PBField.initUInt64(0L);
        this.bytes_extend = PBField.initBytes(byteStringMicro);
    }
}
