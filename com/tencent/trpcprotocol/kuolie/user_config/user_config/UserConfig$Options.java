package com.tencent.trpcprotocol.kuolie.user_config.user_config;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.ProfileCardDtReportUtil;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UserConfig$Options extends MessageMicro<UserConfig$Options> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"match_info_option", "shield_qq_friend_ption", "privacy_option", "message_option", "hide_plugin_option", "channel_option", "msg_box_option", "msg_box_dialog_option", "msg_box_bar_option", "userinfo_hide_option", "user_status_option", "user_mood_option"}, new Object[]{null, null, null, null, null, null, null, null, null, null, null, null}, UserConfig$Options.class);
    public UserConfig$MatchInfoOption match_info_option = new MessageMicro<UserConfig$MatchInfoOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$MatchInfoOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"prefer_gender"}, new Object[]{0}, UserConfig$MatchInfoOption.class);
        public final PBEnumField prefer_gender = PBField.initEnum(0);
    };
    public UserConfig$ShieldQQFriendOption shield_qq_friend_ption = new MessageMicro<UserConfig$ShieldQQFriendOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$ShieldQQFriendOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"is_shield_qq_friend"}, new Object[]{Boolean.FALSE}, UserConfig$ShieldQQFriendOption.class);
        public final PBBoolField is_shield_qq_friend = PBField.initBool(false);
    };
    public UserConfig$PrivacyOption privacy_option = new UserConfig$PrivacyOption();
    public UserConfig$MessageOption message_option = new UserConfig$MessageOption();
    public UserConfig$HidePluginOption hide_plugin_option = new UserConfig$HidePluginOption();
    public UserConfig$ChannelOption channel_option = new MessageMicro<UserConfig$ChannelOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$ChannelOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"hide_greet"}, new Object[]{Boolean.FALSE}, UserConfig$ChannelOption.class);
        public final PBBoolField hide_greet = PBField.initBool(false);
    };
    public UserConfig$MsgBoxOption msg_box_option = new MessageMicro<UserConfig$MsgBoxOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$MsgBoxOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"subscribe"}, new Object[]{Boolean.FALSE}, UserConfig$MsgBoxOption.class);
        public final PBBoolField subscribe = PBField.initBool(false);
    };
    public UserConfig$MsgBoxDialogOption msg_box_dialog_option = new MessageMicro<UserConfig$MsgBoxDialogOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$MsgBoxDialogOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"hide_dialog"}, new Object[]{Boolean.FALSE}, UserConfig$MsgBoxDialogOption.class);
        public final PBBoolField hide_dialog = PBField.initBool(false);
    };
    public UserConfig$MsgBoxBarOption msg_box_bar_option = new MessageMicro<UserConfig$MsgBoxBarOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$MsgBoxBarOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"hide_bar"}, new Object[]{Boolean.FALSE}, UserConfig$MsgBoxBarOption.class);
        public final PBBoolField hide_bar = PBField.initBool(false);
    };
    public UserConfig$UserInfoHideOption userinfo_hide_option = new MessageMicro<UserConfig$UserInfoHideOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$UserInfoHideOption
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField nick_logo_hide = PBField.initBool(false);
        public final PBBoolField sign_hide = PBField.initBool(false);
        public final PBBoolField pics_hide = PBField.initBool(false);

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"nick_logo_hide", "sign_hide", "pics_hide"}, new Object[]{bool, bool, bool}, UserConfig$UserInfoHideOption.class);
        }
    };
    public UserConfig$UserStatusOption user_status_option = new MessageMicro<UserConfig$UserStatusOption>() { // from class: com.tencent.trpcprotocol.kuolie.user_config.user_config.UserConfig$UserStatusOption
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{ProfileCardDtReportUtil.STATUS_ID, "setting_time"}, new Object[]{0, 0L}, UserConfig$UserStatusOption.class);
        public final PBUInt32Field status_id = PBField.initUInt32(0);
        public final PBInt64Field setting_time = PBField.initInt64(0);
    };
    public UserConfig$UserMoodOption user_mood_option = new UserConfig$UserMoodOption();
}
