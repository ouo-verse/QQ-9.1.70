package com.tencent.pb.extendfriend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class GetExtendFriendInfo$RspBody extends MessageMicro<GetExtendFriendInfo$RspBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_declaration;
    public final PBBytesField bytes_personalization;
    public final PBBytesField bytes_voice_url;
    public final PBRepeatMessageField<GetExtendFriendInfo$labelInfo> rpt_label_info;
    public final PBRepeatMessageField<GetExtendFriendInfo$schoolInfo> rpt_school_info;
    public final PBStringField str_nick;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_bigvip_hide;
    public final PBUInt32Field uint32_bigvip_level;
    public final PBUInt32Field uint32_bigvip_open;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_is_show_card;
    public final PBUInt32Field uint32_popularity;
    public final PBUInt32Field uint32_show_vip_info_flag;
    public final PBUInt32Field uint32_svip_level;
    public final PBUInt32Field uint32_total_like_count;
    public final PBUInt32Field uint32_vip_flag;
    public final PBUInt32Field uint32_vipicon_id;
    public final PBUInt32Field uint32_voice_duration;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_update_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 64, 72, 80, 88, 96, 104, 112, 120, 130, 136, 146, 218, 224, 234}, new String[]{"uint64_uin", "bytes_declaration", "bytes_voice_url", "uint32_popularity", "uint64_update_time", "uint32_is_show_card", "uint32_voice_duration", "uint32_show_vip_info_flag", "uint32_svip_level", "uint32_vipicon_id", "uint32_bigvip_level", "uint32_bigvip_open", "uint32_bigvip_hide", "uint32_vip_flag", "uint32_gender", "str_nick", "uint32_total_like_count", "bytes_personalization", "rpt_label_info", "uint32_age", "rpt_school_info"}, new Object[]{0L, byteStringMicro, byteStringMicro, 0, 0L, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, "", 0, byteStringMicro, null, 0, null}, GetExtendFriendInfo$RspBody.class);
    }

    public GetExtendFriendInfo$RspBody() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_declaration = PBField.initBytes(byteStringMicro);
        this.bytes_voice_url = PBField.initBytes(byteStringMicro);
        this.uint32_popularity = PBField.initUInt32(0);
        this.uint64_update_time = PBField.initUInt64(0L);
        this.uint32_is_show_card = PBField.initUInt32(0);
        this.uint32_voice_duration = PBField.initUInt32(0);
        this.uint32_show_vip_info_flag = PBField.initUInt32(0);
        this.uint32_svip_level = PBField.initUInt32(0);
        this.uint32_vipicon_id = PBField.initUInt32(0);
        this.uint32_bigvip_level = PBField.initUInt32(0);
        this.uint32_bigvip_open = PBField.initUInt32(0);
        this.uint32_bigvip_hide = PBField.initUInt32(0);
        this.uint32_vip_flag = PBField.initUInt32(0);
        this.uint32_gender = PBField.initUInt32(0);
        this.str_nick = PBField.initString("");
        this.uint32_total_like_count = PBField.initUInt32(0);
        this.bytes_personalization = PBField.initBytes(byteStringMicro);
        this.rpt_label_info = PBField.initRepeatMessage(GetExtendFriendInfo$labelInfo.class);
        this.uint32_age = PBField.initUInt32(0);
        this.rpt_school_info = PBField.initRepeatMessage(GetExtendFriendInfo$schoolInfo.class);
    }
}
