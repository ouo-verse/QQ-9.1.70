package com.tencent.pb.hotpicmsg;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes22.dex */
public final class HotPicMsg$ImgInfo extends MessageMicro<HotPicMsg$ImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_file_md5;
    public final PBBytesField bytes_pic_down_url;
    public final PBBytesField bytes_thumb_down_url;
    public final PBBytesField bytes_thumb_file_md5;
    public HotPicMsg$ThirdPartyInfo msg_third_party_info;
    public HotPicMsg$VideoEmojiInfo msg_video_info;
    public final PBUInt32Field uint32_file_height;
    public final PBUInt32Field uint32_file_type;
    public final PBUInt32Field uint32_file_width;
    public final PBUInt32Field uint32_pic_index;
    public final PBUInt32Field uint32_source_type;
    public final PBUInt32Field uint32_thumb_file_height;
    public final PBUInt32Field uint32_thumb_file_width;
    public final PBUInt64Field uint64_file_size;
    public final PBUInt64Field uint64_thumb_file_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40, 50, 58, 64, 72, 80, 90, 96, 104, 114, 122}, new String[]{"bytes_file_md5", "uint32_file_type", "uint64_file_size", "uint32_file_width", "uint32_file_height", "bytes_pic_down_url", "bytes_thumb_file_md5", "uint64_thumb_file_size", "uint32_thumb_file_width", "uint32_thumb_file_height", "bytes_thumb_down_url", "uint32_pic_index", "uint32_source_type", "msg_third_party_info", "msg_video_info"}, new Object[]{byteStringMicro, 0, 0L, 0, 0, byteStringMicro, byteStringMicro, 0L, 0, 0, byteStringMicro, 0, 0, null, null}, HotPicMsg$ImgInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.pb.hotpicmsg.HotPicMsg$VideoEmojiInfo] */
    public HotPicMsg$ImgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_file_type = PBField.initUInt32(0);
        this.uint64_file_size = PBField.initUInt64(0L);
        this.uint32_file_width = PBField.initUInt32(0);
        this.uint32_file_height = PBField.initUInt32(0);
        this.bytes_pic_down_url = PBField.initBytes(byteStringMicro);
        this.bytes_thumb_file_md5 = PBField.initBytes(byteStringMicro);
        this.uint64_thumb_file_size = PBField.initUInt64(0L);
        this.uint32_thumb_file_width = PBField.initUInt32(0);
        this.uint32_thumb_file_height = PBField.initUInt32(0);
        this.bytes_thumb_down_url = PBField.initBytes(byteStringMicro);
        this.uint32_pic_index = PBField.initUInt32(0);
        this.uint32_source_type = PBField.initUInt32(0);
        this.msg_third_party_info = new HotPicMsg$ThirdPartyInfo();
        this.msg_video_info = new MessageMicro<HotPicMsg$VideoEmojiInfo>() { // from class: com.tencent.pb.hotpicmsg.HotPicMsg$VideoEmojiInfo
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
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 88, 96, 106, 112, 120, 130, 138, 146, 154}, new String[]{"bytes_resource_id", "bytes_video_md5", "uint32_video_width", "uint32_video_height", "bytes_video_fileid", "uint64_video_size", "bytes_video_name", "uint64_video_duration", "uint32_video_format", "bytes_thumb_img_md5", "uint32_thumb_img_width", "uint32_thumb_img_height", "bytes_thumb_img_fileid", "uint64_thumb_size", "uint32_src_type", "bytes_src_desc", "bytes_homepage_url", "bytes_icon_url", "bytes_video_other"}, new Object[]{byteStringMicro2, byteStringMicro2, 0, 0, byteStringMicro2, 0L, byteStringMicro2, 0L, 0, byteStringMicro2, 0, 0, byteStringMicro2, 0L, 0, byteStringMicro2, byteStringMicro2, byteStringMicro2, byteStringMicro2}, HotPicMsg$VideoEmojiInfo.class);
            }

            {
                ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                this.bytes_resource_id = PBField.initBytes(byteStringMicro2);
                this.bytes_video_md5 = PBField.initBytes(byteStringMicro2);
                this.uint32_video_width = PBField.initUInt32(0);
                this.uint32_video_height = PBField.initUInt32(0);
                this.bytes_video_fileid = PBField.initBytes(byteStringMicro2);
                this.uint64_video_size = PBField.initUInt64(0L);
                this.bytes_video_name = PBField.initBytes(byteStringMicro2);
                this.uint64_video_duration = PBField.initUInt64(0L);
                this.uint32_video_format = PBField.initUInt32(0);
                this.bytes_thumb_img_md5 = PBField.initBytes(byteStringMicro2);
                this.uint32_thumb_img_width = PBField.initUInt32(0);
                this.uint32_thumb_img_height = PBField.initUInt32(0);
                this.bytes_thumb_img_fileid = PBField.initBytes(byteStringMicro2);
                this.uint64_thumb_size = PBField.initUInt64(0L);
                this.uint32_src_type = PBField.initUInt32(0);
                this.bytes_src_desc = PBField.initBytes(byteStringMicro2);
                this.bytes_homepage_url = PBField.initBytes(byteStringMicro2);
                this.bytes_icon_url = PBField.initBytes(byteStringMicro2);
                this.bytes_video_other = PBField.initBytes(byteStringMicro2);
            }
        };
    }
}
