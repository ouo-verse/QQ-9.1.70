package com.tencent.qqnt.doutu.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class Doutu$ImgInfo extends MessageMicro<Doutu$ImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pic_down_url;
    public final PBBytesField bytes_pic_md5;
    public final PBBytesField bytes_source_name;
    public final PBBytesField bytes_thumb_down_url;
    public final PBBytesField bytes_thumb_file_md5;
    public final PBUInt32Field uint32_pic_height;
    public final PBUInt32Field uint32_pic_width;
    public final PBUInt32Field uint32_thumb_height;
    public final PBUInt32Field uint32_thumb_width;
    public final PBUInt64Field uint64_pic_size;
    public final PBUInt64Field uint64_thumb_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 56, 64, 72, 82, 90}, new String[]{"bytes_pic_md5", "uint64_pic_size", "uint32_pic_width", "uint32_pic_height", "bytes_pic_down_url", "bytes_thumb_file_md5", "uint64_thumb_size", "uint32_thumb_width", "uint32_thumb_height", "bytes_thumb_down_url", "bytes_source_name"}, new Object[]{byteStringMicro, 0L, 0, 0, byteStringMicro, byteStringMicro, 0L, 0, 0, byteStringMicro, byteStringMicro}, Doutu$ImgInfo.class);
    }

    public Doutu$ImgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_pic_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_pic_size = PBField.initUInt64(0L);
        this.uint32_pic_width = PBField.initUInt32(0);
        this.uint32_pic_height = PBField.initUInt32(0);
        this.bytes_pic_down_url = PBField.initBytes(byteStringMicro);
        this.bytes_thumb_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_thumb_size = PBField.initUInt64(0L);
        this.uint32_thumb_width = PBField.initUInt32(0);
        this.uint32_thumb_height = PBField.initUInt32(0);
        this.bytes_thumb_down_url = PBField.initBytes(byteStringMicro);
        this.bytes_source_name = PBField.initBytes(byteStringMicro);
    }
}
