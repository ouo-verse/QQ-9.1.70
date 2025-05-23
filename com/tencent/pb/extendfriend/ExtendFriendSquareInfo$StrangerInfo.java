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
public final class ExtendFriendSquareInfo$StrangerInfo extends MessageMicro<ExtendFriendSquareInfo$StrangerInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_ad_content;
    public final PBBytesField bytes_cover_url;
    public final PBBytesField bytes_declaration;
    public final PBBytesField bytes_nick;
    public final PBBytesField bytes_personalization;
    public final PBBytesField bytes_tmp_session_sig;
    public final PBBytesField bytes_voice_code;
    public final PBBytesField bytes_voice_url;
    public final PBRepeatMessageField<ExtendFriendSquareInfo$labelInfo> rpt_label_info;
    public final PBRepeatMessageField<ExtendFriendSquareInfo$schoolInfo> rpt_school_info;
    public final PBStringField str_recom_trace;
    public final PBUInt32Field uint32_addfri_status;
    public final PBUInt32Field uint32_age;
    public final PBUInt32Field uint32_bigvip_hide;
    public final PBUInt32Field uint32_bigvip_level;
    public final PBUInt32Field uint32_bigvip_open;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_is_my_like;
    public final PBUInt32Field uint32_my_left_like_count;
    public final PBUInt32Field uint32_popularity;
    public final PBUInt32Field uint32_show_vip_info_flag;
    public final PBUInt32Field uint32_svip_level;
    public final PBUInt32Field uint32_total_like_count;
    public final PBUInt32Field uint32_vip_flag;
    public final PBUInt32Field uint32_vipicon_id;
    public final PBUInt32Field uint32_voice_duration;
    public final PBUInt32Field uint32_vote_switch;
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_update_time;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 40, 50, 56, 66, 74, 80, 90, 96, 112, 120, 128, 138, 144, 152, 160, 168, 176, 184, 192, 202, 210, 218, 224, 234, 242}, new String[]{"uint64_uin", "bytes_cover_url", "uint32_total_like_count", "uint32_is_my_like", "uint32_my_left_like_count", "bytes_nick", "uint32_popularity", "bytes_declaration", "bytes_voice_url", "uint64_update_time", "bytes_tmp_session_sig", "uint32_voice_duration", "uint32_gender", "uint32_addfri_status", "uint32_vote_switch", "str_recom_trace", "uint32_show_vip_info_flag", "uint32_svip_level", "uint32_vipicon_id", "uint32_bigvip_level", "uint32_bigvip_open", "uint32_bigvip_hide", "uint32_vip_flag", "bytes_ad_content", "bytes_personalization", "rpt_label_info", "uint32_age", "bytes_voice_code", "rpt_school_info"}, new Object[]{0L, byteStringMicro, 0, 0, 0, byteStringMicro, 0, byteStringMicro, byteStringMicro, 0L, byteStringMicro, 0, 0, 0, 0, "", 0, 0, 0, 0, 0, 0, 0, byteStringMicro, byteStringMicro, null, 0, byteStringMicro, null}, ExtendFriendSquareInfo$StrangerInfo.class);
    }

    public ExtendFriendSquareInfo$StrangerInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_cover_url = PBField.initBytes(byteStringMicro);
        this.uint32_total_like_count = PBField.initUInt32(0);
        this.uint32_is_my_like = PBField.initUInt32(0);
        this.uint32_my_left_like_count = PBField.initUInt32(0);
        this.bytes_nick = PBField.initBytes(byteStringMicro);
        this.uint32_popularity = PBField.initUInt32(0);
        this.bytes_declaration = PBField.initBytes(byteStringMicro);
        this.bytes_voice_url = PBField.initBytes(byteStringMicro);
        this.uint64_update_time = PBField.initUInt64(0L);
        this.bytes_tmp_session_sig = PBField.initBytes(byteStringMicro);
        this.uint32_voice_duration = PBField.initUInt32(0);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_addfri_status = PBField.initUInt32(0);
        this.uint32_vote_switch = PBField.initUInt32(0);
        this.str_recom_trace = PBField.initString("");
        this.uint32_show_vip_info_flag = PBField.initUInt32(0);
        this.uint32_svip_level = PBField.initUInt32(0);
        this.uint32_vipicon_id = PBField.initUInt32(0);
        this.uint32_bigvip_level = PBField.initUInt32(0);
        this.uint32_bigvip_open = PBField.initUInt32(0);
        this.uint32_bigvip_hide = PBField.initUInt32(0);
        this.uint32_vip_flag = PBField.initUInt32(0);
        this.bytes_ad_content = PBField.initBytes(byteStringMicro);
        this.bytes_personalization = PBField.initBytes(byteStringMicro);
        this.rpt_label_info = PBField.initRepeatMessage(ExtendFriendSquareInfo$labelInfo.class);
        this.uint32_age = PBField.initUInt32(0);
        this.bytes_voice_code = PBField.initBytes(byteStringMicro);
        this.rpt_school_info = PBField.initRepeatMessage(ExtendFriendSquareInfo$schoolInfo.class);
    }
}
