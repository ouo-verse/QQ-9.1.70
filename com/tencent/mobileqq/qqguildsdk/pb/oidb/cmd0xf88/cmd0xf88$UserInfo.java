package com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88;

import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.luggage.wxa.uf.l;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.view.FilterEnum;

/* compiled from: P */
/* loaded from: classes17.dex */
public final class cmd0xf88$UserInfo extends MessageMicro<cmd0xf88$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBoolField bool_has_more_archive;
    public final PBBoolField bool_has_set_group_pro_profile;
    public final PBBytesField bytes_avatar_meta;
    public final PBBytesField bytes_birthday;
    public final PBBytesField bytes_city;
    public final PBBytesField bytes_city_id;
    public final PBBytesField bytes_country;
    public final PBBytesField bytes_full_age;
    public final PBBytesField bytes_full_birthday;
    public final PBBytesField bytes_member_name;
    public final PBBytesField bytes_nick_name;
    public final PBBytesField bytes_personal_sign;
    public final PBBytesField bytes_province;
    public final PBBytesField bytes_url;
    public final PBBytesField bytes_verify_url;
    public cmd0xf88$ClientPresence client_presence;
    public cmd0xf88$ArchiveArkData first_archive_ark_data;
    public final PBBoolField is_qq_friend;
    public cmd0xf88$HeadInfo msg_head_info;
    public final PBStringField openid;
    public final PBRepeatMessageField<cmd0xf88$PersonalSignTemplate> personal_sign_template;
    public final PBRepeatMessageField<cmd0xf88$ClientAccount> rpt_bind_client_account;
    public final PBRepeatMessageField<cmd0xf88$ClientArchive> rpt_client_archive;
    public final PBUInt32Field show_voice_live_status_switch;
    public final PBUInt32Field uint32_allow;
    public final PBUInt32Field uint32_avatar_flag;
    public final PBUInt32Field uint32_city_zone_id;
    public final PBUInt32Field uint32_constellation;
    public final PBUInt32Field uint32_direct_msg_black_flag;
    public final PBUInt32Field uint32_face_auth_status;
    public final PBUInt32Field uint32_gender;
    public final PBUInt32Field uint32_is_member;
    public final PBUInt32Field uint32_member_name_flag;
    public final PBUInt32Field uint32_member_role;
    public final PBUInt32Field uint32_member_type;
    public final PBUInt64Field uint64_be_admin_time;
    public final PBUInt64Field uint64_join_group_pro_timestamp;
    public final PBUInt64Field uint64_join_time;
    public final PBUInt64Field uint64_member_id = PBField.initUInt64(0);
    public final PBUInt64Field uint64_member_tinyid = PBField.initUInt64(0);
    public final PBUInt64Field uint64_shutup_expire_time;
    public cmd0xf88$VoiceLiveInfo voice_live_info;

    static {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 50, 58, 66, 74, 82, 90, 98, 106, 112, 122, 128, 136, 144, 152, 162, 170, 178, 186, 192, 202, 208, 216, 224, 232, 242, 248, 256, 266, 272, FilterEnum.MIC_PTU_BAIXI, 290, 296, 304, 314, 322, AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, l.CTRL_INDEX}, new String[]{"uint64_member_id", "uint64_member_tinyid", "bytes_nick_name", "uint32_gender", "uint32_allow", "bytes_url", "bytes_birthday", "bytes_full_birthday", "bytes_full_age", "bytes_country", "bytes_province", "bytes_city", "bytes_city_id", "uint32_city_zone_id", "msg_head_info", "uint64_join_time", "uint32_member_role", "uint32_member_type", "uint64_be_admin_time", "bytes_member_name", "client_presence", "rpt_client_archive", "rpt_bind_client_account", "bool_has_more_archive", "first_archive_ark_data", "uint32_direct_msg_black_flag", "bool_has_set_group_pro_profile", "uint64_join_group_pro_timestamp", "uint64_shutup_expire_time", "bytes_avatar_meta", "uint32_member_name_flag", "uint32_face_auth_status", "bytes_verify_url", "uint32_constellation", "bytes_personal_sign", "voice_live_info", "uint32_avatar_flag", "is_qq_friend", "openid", "personal_sign_template", "show_voice_live_status_switch", "uint32_is_member"}, new Object[]{0L, 0L, byteStringMicro, 0, 0, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, byteStringMicro, 0, null, 0L, 0, 0, 0L, byteStringMicro, null, null, null, bool, null, 0, bool, 0L, 0L, byteStringMicro, 0, 0, byteStringMicro, 0, byteStringMicro, null, 0, bool, "", null, 0, 0}, cmd0xf88$UserInfo.class);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$VoiceLiveInfo] */
    /* JADX WARN: Type inference failed for: r4v11, types: [com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$HeadInfo] */
    /* JADX WARN: Type inference failed for: r4v17, types: [com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ClientPresence] */
    /* JADX WARN: Type inference failed for: r4v23, types: [com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArchiveArkData] */
    public cmd0xf88$UserInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.bytes_nick_name = PBField.initBytes(byteStringMicro);
        this.uint32_gender = PBField.initUInt32(0);
        this.uint32_allow = PBField.initUInt32(0);
        this.bytes_url = PBField.initBytes(byteStringMicro);
        this.bytes_birthday = PBField.initBytes(byteStringMicro);
        this.bytes_full_birthday = PBField.initBytes(byteStringMicro);
        this.bytes_full_age = PBField.initBytes(byteStringMicro);
        this.bytes_country = PBField.initBytes(byteStringMicro);
        this.bytes_province = PBField.initBytes(byteStringMicro);
        this.bytes_city = PBField.initBytes(byteStringMicro);
        this.bytes_city_id = PBField.initBytes(byteStringMicro);
        this.uint32_city_zone_id = PBField.initUInt32(0);
        this.msg_head_info = new MessageMicro<cmd0xf88$HeadInfo>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$HeadInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"uint32_timestamp", "uint32_face_flag", "bytes_base_url", "uint32_type"}, new Object[]{0, 0, ByteStringMicro.EMPTY, 0}, cmd0xf88$HeadInfo.class);
            public final PBUInt32Field uint32_timestamp = PBField.initUInt32(0);
            public final PBUInt32Field uint32_face_flag = PBField.initUInt32(0);
            public final PBBytesField bytes_base_url = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBUInt32Field uint32_type = PBField.initUInt32(0);
        };
        this.uint64_join_time = PBField.initUInt64(0L);
        this.uint32_member_role = PBField.initUInt32(0);
        this.uint32_member_type = PBField.initUInt32(0);
        this.uint64_be_admin_time = PBField.initUInt64(0L);
        this.bytes_member_name = PBField.initBytes(byteStringMicro);
        this.client_presence = new MessageMicro<cmd0xf88$ClientPresence>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ClientPresence
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 48, 56, 66, 72, 80, 90, 80008}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "client_name", "big_icon", "state", "details", "party_size", "party_max", "role", Element.ELEMENT_NAME_START_TIMESTAMP, Element.ELEMENT_NAME_END_TIMESTAMP, "small_icon", "expire_timestamp"}, new Object[]{0, "", "", "", "", 0L, 0L, "", 0L, 0L, "", 0L}, cmd0xf88$ClientPresence.class);
            public final PBUInt32Field client_id = PBField.initUInt32(0);
            public final PBStringField client_name = PBField.initString("");
            public final PBStringField big_icon = PBField.initString("");
            public final PBStringField state = PBField.initString("");
            public final PBStringField details = PBField.initString("");
            public final PBInt64Field party_size = PBField.initInt64(0);
            public final PBInt64Field party_max = PBField.initInt64(0);
            public final PBStringField role = PBField.initString("");
            public final PBInt64Field start_timestamp = PBField.initInt64(0);
            public final PBInt64Field end_timestamp = PBField.initInt64(0);
            public final PBStringField small_icon = PBField.initString("");
            public final PBInt64Field expire_timestamp = PBField.initInt64(0);
        };
        this.rpt_client_archive = PBField.initRepeatMessage(cmd0xf88$ClientArchive.class);
        this.rpt_bind_client_account = PBField.initRepeatMessage(cmd0xf88$ClientAccount.class);
        this.bool_has_more_archive = PBField.initBool(false);
        this.first_archive_ark_data = new MessageMicro<cmd0xf88$ArchiveArkData>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArchiveArkData
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{CommonConstant.ReqAccessTokenParam.CLIENT_ID, "name", "icon", "ark_arg"}, new Object[]{0, "", "", null}, cmd0xf88$ArchiveArkData.class);
            public final PBUInt32Field client_id = PBField.initUInt32(0);
            public final PBStringField name = PBField.initString("");
            public final PBStringField icon = PBField.initString("");
            public cmd0xf88$ArkArg ark_arg = new MessageMicro<cmd0xf88$ArkArg>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$ArkArg
                static final MessageMicro.FieldMap __fieldMap__;
                public final PBBytesField config;
                public final PBBytesField meta;
                public final PBStringField app = PBField.initString("");
                public final PBStringField view = PBField.initString("");
                public final PBStringField ver = PBField.initString("");
                public final PBStringField desc = PBField.initString("");
                public final PBStringField prompt = PBField.initString("");

                static {
                    String[] strArr = {"app", "view", "ver", "desc", "prompt", PublicAccountMessageUtilImpl.META_NAME, DownloadInfo.spKey_Config};
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, strArr, new Object[]{"", "", "", "", "", byteStringMicro2, byteStringMicro2}, cmd0xf88$ArkArg.class);
                }

                {
                    ByteStringMicro byteStringMicro2 = ByteStringMicro.EMPTY;
                    this.meta = PBField.initBytes(byteStringMicro2);
                    this.config = PBField.initBytes(byteStringMicro2);
                }
            };
        };
        this.uint32_direct_msg_black_flag = PBField.initUInt32(0);
        this.bool_has_set_group_pro_profile = PBField.initBool(false);
        this.uint64_join_group_pro_timestamp = PBField.initUInt64(0L);
        this.uint64_shutup_expire_time = PBField.initUInt64(0L);
        this.bytes_avatar_meta = PBField.initBytes(byteStringMicro);
        this.uint32_member_name_flag = PBField.initUInt32(0);
        this.uint32_face_auth_status = PBField.initUInt32(0);
        this.bytes_verify_url = PBField.initBytes(byteStringMicro);
        this.uint32_constellation = PBField.initUInt32(0);
        this.bytes_personal_sign = PBField.initBytes(byteStringMicro);
        this.voice_live_info = new MessageMicro<cmd0xf88$VoiceLiveInfo>() { // from class: com.tencent.mobileqq.qqguildsdk.pb.oidb.cmd0xf88.cmd0xf88$VoiceLiveInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42, 50, 56, 66}, new String[]{"guild_id", "channel_id", "channel_type", "members", "live_title", "room_pv", "anchor_tiny_id", "channel_status_list"}, new Object[]{0L, 0L, 0, null, ByteStringMicro.EMPTY, "", 0L, null}, cmd0xf88$VoiceLiveInfo.class);
            public final PBUInt64Field guild_id = PBField.initUInt64(0);
            public final PBUInt64Field channel_id = PBField.initUInt64(0);
            public final PBUInt32Field channel_type = PBField.initUInt32(0);
            public final PBRepeatMessageField<cmd0xf88$VoiceLiveMemberInfo> members = PBField.initRepeatMessage(cmd0xf88$VoiceLiveMemberInfo.class);
            public final PBBytesField live_title = PBField.initBytes(ByteStringMicro.EMPTY);
            public final PBStringField room_pv = PBField.initString("");
            public final PBUInt64Field anchor_tiny_id = PBField.initUInt64(0);
            public final PBRepeatMessageField<cmd0xf88$ChannelStateInfo> channel_status_list = PBField.initRepeatMessage(cmd0xf88$ChannelStateInfo.class);
        };
        this.uint32_avatar_flag = PBField.initUInt32(0);
        this.is_qq_friend = PBField.initBool(false);
        this.openid = PBField.initString("");
        this.personal_sign_template = PBField.initRepeatMessage(cmd0xf88$PersonalSignTemplate.class);
        this.show_voice_live_status_switch = PBField.initUInt32(0);
        this.uint32_is_member = PBField.initUInt32(0);
    }
}
