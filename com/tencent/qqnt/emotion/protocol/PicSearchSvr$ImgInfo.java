package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes24.dex */
public final class PicSearchSvr$ImgInfo extends MessageMicro<PicSearchSvr$ImgInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_icon_url;
    public final PBBytesField bytes_img_down_url;
    public final PBBytesField bytes_img_md5;
    public final PBBytesField bytes_img_other;
    public final PBBytesField bytes_pack_name;
    public final PBBytesField bytes_resource_id;
    public final PBBytesField bytes_src_desc;
    public final PBBytesField bytes_thumb_down_url;
    public final PBBytesField bytes_thumb_img_md5;
    public final PBBytesField bytes_web_url;
    public PicSearchSvr$MallEmojiInfo mall_emoji_info;
    public PicSearchSvr$EmotionInfo msg_emotion_info;
    public final PBUInt32Field uint32_img_height;
    public final PBUInt32Field uint32_img_width;
    public final PBUInt32Field uint32_pack_id;
    public final PBUInt32Field uint32_src_type;
    public final PBUInt32Field uint32_thumb_img_height;
    public final PBUInt32Field uint32_thumb_img_width;
    public final PBUInt64Field uint64_img_size;
    public final PBUInt64Field uint64_thumb_size;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 42, 48, 58, 64, 72, 82, 88, 98, 104, 114, 122, 130, 138, 144, 154, 162}, new String[]{"bytes_resource_id", "bytes_img_md5", "uint32_img_width", "uint32_img_height", "bytes_img_down_url", "uint64_img_size", "bytes_thumb_img_md5", "uint32_thumb_img_width", "uint32_thumb_img_height", "bytes_thumb_down_url", "uint64_thumb_size", "bytes_img_other", "uint32_src_type", "bytes_src_desc", "bytes_web_url", "bytes_icon_url", "bytes_pack_name", "uint32_pack_id", "msg_emotion_info", "mall_emoji_info"}, new Object[]{byteStringMicro, byteStringMicro, 0, 0, byteStringMicro, 0L, byteStringMicro, 0, 0, byteStringMicro, 0L, byteStringMicro, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, null, null}, PicSearchSvr$ImgInfo.class);
    }

    public PicSearchSvr$ImgInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_resource_id = PBField.initBytes(byteStringMicro);
        this.bytes_img_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_img_width = PBField.initUInt32(0);
        this.uint32_img_height = PBField.initUInt32(0);
        this.bytes_img_down_url = PBField.initBytes(byteStringMicro);
        this.uint64_img_size = PBField.initUInt64(0L);
        this.bytes_thumb_img_md5 = PBField.initBytes(byteStringMicro);
        this.uint32_thumb_img_width = PBField.initUInt32(0);
        this.uint32_thumb_img_height = PBField.initUInt32(0);
        this.bytes_thumb_down_url = PBField.initBytes(byteStringMicro);
        this.uint64_thumb_size = PBField.initUInt64(0L);
        this.bytes_img_other = PBField.initBytes(byteStringMicro);
        this.uint32_src_type = PBField.initUInt32(0);
        this.bytes_src_desc = PBField.initBytes(byteStringMicro);
        this.bytes_web_url = PBField.initBytes(byteStringMicro);
        this.bytes_icon_url = PBField.initBytes(byteStringMicro);
        this.bytes_pack_name = PBField.initBytes(byteStringMicro);
        this.uint32_pack_id = PBField.initUInt32(0);
        this.msg_emotion_info = new PicSearchSvr$EmotionInfo();
        this.mall_emoji_info = new PicSearchSvr$MallEmojiInfo();
    }
}
