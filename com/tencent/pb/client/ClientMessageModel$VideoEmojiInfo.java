package com.tencent.pb.client;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ClientMessageModel$VideoEmojiInfo extends MessageMicro<ClientMessageModel$VideoEmojiInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_homepage_url;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_resource_id;
    public final PBBytesField bytes_src_desc;
    public final PBBytesField bytes_thumb_img_fileid;
    public final PBBytesField bytes_thumb_img_md5;
    public final PBBytesField bytes_video_fileid;
    public final PBBytesField bytes_video_md5;
    public final PBBytesField bytes_video_name;
    public final PBBytesField bytes_video_other;
    public final PBUInt32Field uint32_src_type;
    public final PBUInt32Field uint32_thumb_img_height;
    public final PBUInt32Field uint32_thumb_img_width;
    public final PBUInt32Field uint32_video_format;
    public final PBUInt32Field uint32_video_height;
    public final PBUInt32Field uint32_video_width;
    public final PBUInt64Field uint64_thumb_size;
    public final PBUInt64Field uint64_video_duration;
    public final PBUInt64Field uint64_video_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 88, 96, 106, 112, 120, 130, 138, 146, 154}, new String[]{"bytes_resource_id", "bytes_video_md5", "uint32_video_width", "uint32_video_height", "bytes_video_fileid", "uint64_video_size", "bytes_video_name", "uint64_video_duration", "uint32_video_format", "bytes_thumb_img_md5", "uint32_thumb_img_width", "uint32_thumb_img_height", "bytes_thumb_img_fileid", "uint64_thumb_size", "uint32_src_type", "bytes_src_desc", "bytes_homepage_url", "bytes_icon_url", "bytes_video_other"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0L, byteStringMicro, 0L, 0, byteStringMicro, 0, 0, byteStringMicro, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro}, ClientMessageModel$VideoEmojiInfo.class);
    }

    public ClientMessageModel$VideoEmojiInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_resource_id = PBField.initBytes(byteStringMicro);
        this.bytes_video_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_video_width = PBField.initUInt32(0);
        this.uint32_video_height = PBField.initUInt32(0);
        this.bytes_video_fileid = PBField.initBytes(byteStringMicro);
        this.uint64_video_size = PBField.initUInt64(0L);
        this.bytes_video_name = PBField.initBytes(byteStringMicro);
        this.uint64_video_duration = PBField.initUInt64(0L);
        this.uint32_video_format = PBField.initUInt32(0);
        this.bytes_thumb_img_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_thumb_img_width = PBField.initUInt32(0);
        this.uint32_thumb_img_height = PBField.initUInt32(0);
        this.bytes_thumb_img_fileid = PBField.initBytes(byteStringMicro);
        this.uint64_thumb_size = PBField.initUInt64(0L);
        this.uint32_src_type = PBField.initUInt32(0);
        this.bytes_src_desc = PBField.initBytes(byteStringMicro);
        this.bytes_homepage_url = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_video_other = PBField.initBytes(byteStringMicro);
    }
}
