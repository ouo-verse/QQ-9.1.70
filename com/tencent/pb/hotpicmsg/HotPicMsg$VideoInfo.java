package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class HotPicMsg$VideoInfo extends MessageMicro<HotPicMsg$VideoInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_certificated_icon;
    public final PBBytesField bytes_jump_icon;
    public final PBBytesField bytes_jump_url;
    public final PBBytesField bytes_preview_md5;
    public final PBBytesField bytes_preview_uuid;
    public final PBBytesField bytes_video_md5;
    public final PBBytesField bytes_video_name;
    public final PBBytesField bytes_video_source;
    public final PBBytesField bytes_video_uuid;
    public final PBUInt32Field uint32_preview_height;
    public final PBUInt32Field uint32_preview_width;
    public final PBUInt32Field uint32_video_height;
    public final PBUInt32Field uint32_video_index;
    public final PBUInt32Field uint32_video_width;
    public final PBUInt64Field uint64_preview_size;
    public final PBUInt64Field uint64_video_length;
    public final PBUInt64Field uint64_video_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 48, 58, 66, 74, 82, 88, 96, 104, 114, 122, 130, 136}, new String[]{"bytes_preview_md5", "uint64_preview_size", "uint32_preview_width", "uint32_preview_height", "bytes_preview_uuid", "uint32_video_index", "bytes_jump_icon", "bytes_jump_url", "bytes_video_name", "bytes_video_source", "uint64_video_length", "uint32_video_width", "uint32_video_height", "bytes_video_uuid", "bytes_video_md5", "bytes_certificated_icon", "uint64_video_size"}, new Object[]{byteStringMicro, 0L, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0L, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0L}, HotPicMsg$VideoInfo.class);
    }

    public HotPicMsg$VideoInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_preview_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_preview_size = PBField.initUInt64(0L);
        this.uint32_preview_width = PBField.initUInt32(0);
        this.uint32_preview_height = PBField.initUInt32(0);
        this.bytes_preview_uuid = PBField.initBytes(byteStringMicro);
        this.uint32_video_index = PBField.initUInt32(0);
        this.bytes_jump_icon = PBField.initBytes(byteStringMicro);
        this.bytes_jump_url = PBField.initBytes(byteStringMicro);
        this.bytes_video_name = PBField.initBytes(byteStringMicro);
        this.bytes_video_source = PBField.initBytes(byteStringMicro);
        this.uint64_video_length = PBField.initUInt64(0L);
        this.uint32_video_width = PBField.initUInt32(0);
        this.uint32_video_height = PBField.initUInt32(0);
        this.bytes_video_uuid = PBField.initBytes(byteStringMicro);
        this.bytes_video_md5 = PBField.initBytes(byteStringMicro);
        this.bytes_certificated_icon = PBField.initBytes(byteStringMicro);
        this.uint64_video_size = PBField.initUInt64(0L);
    }
}
