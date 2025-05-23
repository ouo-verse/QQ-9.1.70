package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class EditExtendFriendInfo$ReqBody extends MessageMicro<EditExtendFriendInfo$ReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_declaration;
    public final PBBytesField bytes_personalization;
    public final PBBytesField bytes_voice_url;
    public EditExtendFriendInfo$SchoolInfo msg_school_info;
    public final PBUInt32Field uint32_is_show_card;
    public final PBUInt32Field uint32_voice_attr;
    public final PBUInt32Field uint32_voice_duration;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 58, 66}, new String[]{"uint64_uin", "bytes_declaration", "bytes_voice_url", "uint32_is_show_card", "uint32_voice_duration", "uint32_voice_attr", "bytes_personalization", "msg_school_info"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, 0, 0, byteStringMicro, null}, EditExtendFriendInfo$ReqBody.class);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.tencent.pb.profilecard.EditExtendFriendInfo$SchoolInfo] */
    public EditExtendFriendInfo$ReqBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_declaration = PBField.initBytes(byteStringMicro);
        this.bytes_voice_url = PBField.initBytes(byteStringMicro);
        this.uint32_is_show_card = PBField.initUInt32(0);
        this.uint32_voice_duration = PBField.initUInt32(0);
        this.uint32_voice_attr = PBField.initUInt32(0);
        this.bytes_personalization = PBField.initBytes(byteStringMicro);
        this.msg_school_info = new MessageMicro<EditExtendFriendInfo$SchoolInfo>() { // from class: com.tencent.pb.profilecard.EditExtendFriendInfo$SchoolInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 800}, new String[]{"uint32_category", "str_school_id", "str_school_name", "str_department_id", "str_department_name", "uint32_degree", "uint32_enrollment_year", "uint32_graduation_year", "uint32_allow_recommend", "uint32_create_source", "uint32_create_time", "uint32_update_source", "uint32_update_time", "uint32_hidden_flag", "uint32_verified", "uint32_idx"}, new Object[]{0, "", "", "", "", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, EditExtendFriendInfo$SchoolInfo.class);
            public final PBUInt32Field uint32_idx = PBField.initUInt32(0);
            public final PBUInt32Field uint32_category = PBField.initUInt32(0);
            public final PBStringField str_school_id = PBField.initString("");
            public final PBStringField str_school_name = PBField.initString("");
            public final PBStringField str_department_id = PBField.initString("");
            public final PBStringField str_department_name = PBField.initString("");
            public final PBUInt32Field uint32_degree = PBField.initUInt32(0);
            public final PBUInt32Field uint32_enrollment_year = PBField.initUInt32(0);
            public final PBUInt32Field uint32_graduation_year = PBField.initUInt32(0);
            public final PBUInt32Field uint32_allow_recommend = PBField.initUInt32(0);
            public final PBUInt32Field uint32_create_source = PBField.initUInt32(0);
            public final PBUInt32Field uint32_create_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_update_source = PBField.initUInt32(0);
            public final PBUInt32Field uint32_update_time = PBField.initUInt32(0);
            public final PBUInt32Field uint32_hidden_flag = PBField.initUInt32(0);
            public final PBUInt32Field uint32_verified = PBField.initUInt32(0);
        };
    }
}
