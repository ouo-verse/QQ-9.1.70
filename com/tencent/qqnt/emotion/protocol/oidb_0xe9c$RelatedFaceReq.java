package com.tencent.qqnt.emotion.protocol;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes24.dex */
public final class oidb_0xe9c$RelatedFaceReq extends MessageMicro<oidb_0xe9c$RelatedFaceReq> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_emoji_id;
    public final PBBytesField bytes_package_id;
    public final PBStringField file_uuid;
    public final PBInt32Field store_id;
    public final PBStringField str_uuid;
    public final PBUInt32Field uint32_height;
    public final PBUInt32Field uint32_width;
    public final PBUInt64Field uint64_file_id;
    public final PBUInt64Field uint64_from_uin;
    public final PBUInt64Field uint64_group_code;
    public final PBUInt64Field uint64_msg_time;
    public final PBStringField str_img_md5 = PBField.initString("");
    public final PBStringField str_url = PBField.initString("");
    public final PBRepeatField<String> str_labels = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBUInt32Field uint32_face_type = PBField.initUInt32(0);

    static {
        String[] strArr = {"str_img_md5", "str_url", "str_labels", "uint32_face_type", "bytes_emoji_id", "uint32_width", "uint32_height", "bytes_package_id", "uint64_msg_time", "uint64_from_uin", "str_uuid", "uint64_group_code", "uint64_file_id", "store_id", ShortVideoConstants.FILE_UUID};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 48, 56, 66, 72, 120, 130, 136, 144, 152, 162}, strArr, new Object[]{"", "", "", 0, byteStringMicro, 0, 0, byteStringMicro, 0L, 0L, "", 0L, 0L, 0, ""}, oidb_0xe9c$RelatedFaceReq.class);
    }

    public oidb_0xe9c$RelatedFaceReq() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_emoji_id = PBField.initBytes(byteStringMicro);
        this.uint32_width = PBField.initUInt32(0);
        this.uint32_height = PBField.initUInt32(0);
        this.bytes_package_id = PBField.initBytes(byteStringMicro);
        this.uint64_msg_time = PBField.initUInt64(0L);
        this.uint64_from_uin = PBField.initUInt64(0L);
        this.str_uuid = PBField.initString("");
        this.uint64_group_code = PBField.initUInt64(0L);
        this.uint64_file_id = PBField.initUInt64(0L);
        this.store_id = PBField.initInt32(0);
        this.file_uuid = PBField.initString("");
    }
}
