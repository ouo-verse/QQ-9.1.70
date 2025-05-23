package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qwallet.hb.aio.elem.RedPacketInfoBase;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class YesGameInfoOuterClass$GameConfigInfo extends MessageMicro<YesGameInfoOuterClass$GameConfigInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 74, 82, 90, 98, 106, 112, 122, 130, 136, 146}, new String[]{"game_id", CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_icon", "game_download_url", "game_ios_scheme", "game_adr_scheme", "game_room_type", "game_package_name", "team_info", AegisLogger.ROOM_INFO, "team_room_info", "game_helper_icon", "game_helper_name", "game_helper_uid", "game_teaming_icon", "team_float_window_icon", "style_mode", "game_input_common"}, new Object[]{0, "", "", "", "", "", 0, "", null, null, null, "", "", 0L, "", "", 0, null}, YesGameInfoOuterClass$GameConfigInfo.class);
    public final PBInt32Field game_id = PBField.initInt32(0);
    public final PBStringField game_name = PBField.initString("");
    public final PBStringField game_icon = PBField.initString("");
    public final PBStringField game_download_url = PBField.initString("");
    public final PBStringField game_ios_scheme = PBField.initString("");
    public final PBStringField game_adr_scheme = PBField.initString("");
    public final PBInt32Field game_room_type = PBField.initInt32(0);
    public final PBStringField game_package_name = PBField.initString("");
    public YesGameInfoOuterClass$GameConfigTeamInfo team_info = new YesGameInfoOuterClass$GameConfigTeamInfo();
    public YesGameInfoOuterClass$GameConfigRoom room_info = new MessageMicro<YesGameInfoOuterClass$GameConfigRoom>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"game_info", "label1", "label2", "label3", "chat_info", "hall_config", "mic_card_config", "hall_input_config"}, new Object[]{null, null, null, null, null, null, null, null}, YesGameInfoOuterClass$GameConfigRoom.class);
        public YesGameInfoOuterClass$GameConfigLabel game_info = new MessageMicro<YesGameInfoOuterClass$GameConfigLabel>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigLabel
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"text", "text_hue", "icon", "desc"}, new Object[]{"", "", "", ""}, YesGameInfoOuterClass$GameConfigLabel.class);
            public final PBStringField text = PBField.initString("");
            public final PBStringField text_hue = PBField.initString("");
            public final PBStringField icon = PBField.initString("");
            public final PBStringField desc = PBField.initString("");
        };
        public YesGameInfoOuterClass$GameConfigLabel label1 = new MessageMicro<YesGameInfoOuterClass$GameConfigLabel>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigLabel
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"text", "text_hue", "icon", "desc"}, new Object[]{"", "", "", ""}, YesGameInfoOuterClass$GameConfigLabel.class);
            public final PBStringField text = PBField.initString("");
            public final PBStringField text_hue = PBField.initString("");
            public final PBStringField icon = PBField.initString("");
            public final PBStringField desc = PBField.initString("");
        };
        public YesGameInfoOuterClass$GameConfigLabel label2 = new MessageMicro<YesGameInfoOuterClass$GameConfigLabel>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigLabel
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"text", "text_hue", "icon", "desc"}, new Object[]{"", "", "", ""}, YesGameInfoOuterClass$GameConfigLabel.class);
            public final PBStringField text = PBField.initString("");
            public final PBStringField text_hue = PBField.initString("");
            public final PBStringField icon = PBField.initString("");
            public final PBStringField desc = PBField.initString("");
        };
        public YesGameInfoOuterClass$GameConfigLabel label3 = new MessageMicro<YesGameInfoOuterClass$GameConfigLabel>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigLabel
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"text", "text_hue", "icon", "desc"}, new Object[]{"", "", "", ""}, YesGameInfoOuterClass$GameConfigLabel.class);
            public final PBStringField text = PBField.initString("");
            public final PBStringField text_hue = PBField.initString("");
            public final PBStringField icon = PBField.initString("");
            public final PBStringField desc = PBField.initString("");
        };
        public YesGameInfoOuterClass$GameConfigRoomChat chat_info = new YesGameInfoOuterClass$GameConfigRoomChat();
        public YesGameInfoOuterClass$GameConfigOfHall hall_config = new MessageMicro<YesGameInfoOuterClass$GameConfigOfHall>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigOfHall
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"icon_hall_back", "color_hall_title", "bg_head_area", "icon_online_user_more", "colors_content_area", "icon_fleet_fold", "icon_fleet_unfold", "icon_guild_setting", "colors_operations_indicator"}, new Object[]{"", "", "", "", "", "", "", "", ""}, YesGameInfoOuterClass$GameConfigOfHall.class);
            public final PBRepeatField<String> colors_content_area;
            public final PBRepeatField<String> colors_operations_indicator;
            public final PBStringField icon_fleet_fold;
            public final PBStringField icon_fleet_unfold;
            public final PBStringField icon_guild_setting;
            public final PBStringField icon_hall_back = PBField.initString("");
            public final PBStringField color_hall_title = PBField.initString("");
            public final PBStringField bg_head_area = PBField.initString("");
            public final PBStringField icon_online_user_more = PBField.initString("");

            {
                PBStringField pBStringField = PBStringField.__repeatHelper__;
                this.colors_content_area = PBField.initRepeat(pBStringField);
                this.icon_fleet_fold = PBField.initString("");
                this.icon_fleet_unfold = PBField.initString("");
                this.icon_guild_setting = PBField.initString("");
                this.colors_operations_indicator = PBField.initRepeat(pBStringField);
            }
        };
        public YesGameInfoOuterClass$GameConfigOfMicCard mic_card_config = new MessageMicro<YesGameInfoOuterClass$GameConfigOfMicCard>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigOfMicCard
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"color_mic_item_nick_name", "icon_mic_empty", "icon_mic_apply_entrance"}, new Object[]{"", "", ""}, YesGameInfoOuterClass$GameConfigOfMicCard.class);
            public final PBStringField color_mic_item_nick_name = PBField.initString("");
            public final PBStringField icon_mic_empty = PBField.initString("");
            public final PBStringField icon_mic_apply_entrance = PBField.initString("");
        };
        public YesGameInfoOuterClass$GameConfigOfHallInput hall_input_config = new MessageMicro<YesGameInfoOuterClass$GameConfigOfHallInput>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigOfHallInput
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98}, new String[]{"icon_mic_on", "icon_mic_off", "icon_speaker_on", "icon_speaker_off", RedPacketInfoBase.ICON_EMOJI, "icon_profile", "icon_create_team", "color_bg", "color_bg_edit", "color_text_hint_edit", "color_text_edit", "icon_emoji_select"}, new Object[]{"", "", "", "", "", "", "", "", "", "", "", ""}, YesGameInfoOuterClass$GameConfigOfHallInput.class);
            public final PBStringField icon_mic_on = PBField.initString("");
            public final PBStringField icon_mic_off = PBField.initString("");
            public final PBStringField icon_speaker_on = PBField.initString("");
            public final PBStringField icon_speaker_off = PBField.initString("");
            public final PBStringField icon_emoji = PBField.initString("");
            public final PBStringField icon_profile = PBField.initString("");
            public final PBStringField icon_create_team = PBField.initString("");
            public final PBStringField color_bg = PBField.initString("");
            public final PBStringField color_bg_edit = PBField.initString("");
            public final PBStringField color_text_hint_edit = PBField.initString("");
            public final PBStringField color_text_edit = PBField.initString("");
            public final PBStringField icon_emoji_select = PBField.initString("");
        };
    };
    public YesGameInfoOuterClass$GameConfigTeamRoom team_room_info = new MessageMicro<YesGameInfoOuterClass$GameConfigTeamRoom>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$GameConfigTeamRoom
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66, 74, 82, 90, 98, 106, 114, 122, 130, 138, 146, 154, 162, 170, 178, 186, 194, 202, 210, 218}, new String[]{"chat_info", "button_bg_hue", "button_text_hue", "color_title_name", "icon_title_share", "icon_title_setting", "icon_title_close", "icon_player_pos_empty", "icon_input_chat", "icon_input_gift", "icon_input_speaker_on", "icon_input_speaker_off", "icon_input_mic_on", "icon_input_mic_off", "icon_title_gift_share", "icon_title_gift_setting", "icon_title_gift_close", "color_title_name_gift", "bg_top_area_gift", "icon_player_pos_empty_lock", "color_title_subdesc_txt", "color_player_pos_name", "color_player_pos_subdesc", "color_button_disable_bg", "color_button_disable_text", "icon_title_handle_slider", "icon_title_gift_handle_slider"}, new Object[]{null, "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", "", ""}, YesGameInfoOuterClass$GameConfigTeamRoom.class);
        public YesGameInfoOuterClass$GameConfigRoomChat chat_info = new YesGameInfoOuterClass$GameConfigRoomChat();
        public final PBStringField button_bg_hue = PBField.initString("");
        public final PBStringField button_text_hue = PBField.initString("");
        public final PBStringField color_title_name = PBField.initString("");
        public final PBStringField icon_title_share = PBField.initString("");
        public final PBStringField icon_title_setting = PBField.initString("");
        public final PBStringField icon_title_close = PBField.initString("");
        public final PBStringField icon_player_pos_empty = PBField.initString("");
        public final PBStringField icon_input_chat = PBField.initString("");
        public final PBStringField icon_input_gift = PBField.initString("");
        public final PBStringField icon_input_speaker_on = PBField.initString("");
        public final PBStringField icon_input_speaker_off = PBField.initString("");
        public final PBStringField icon_input_mic_on = PBField.initString("");
        public final PBStringField icon_input_mic_off = PBField.initString("");
        public final PBStringField icon_title_gift_share = PBField.initString("");
        public final PBStringField icon_title_gift_setting = PBField.initString("");
        public final PBStringField icon_title_gift_close = PBField.initString("");
        public final PBStringField color_title_name_gift = PBField.initString("");
        public final PBStringField bg_top_area_gift = PBField.initString("");
        public final PBStringField icon_player_pos_empty_lock = PBField.initString("");
        public final PBStringField color_title_subdesc_txt = PBField.initString("");
        public final PBStringField color_player_pos_name = PBField.initString("");
        public final PBStringField color_player_pos_subdesc = PBField.initString("");
        public final PBStringField color_button_disable_bg = PBField.initString("");
        public final PBStringField color_button_disable_text = PBField.initString("");
        public final PBStringField icon_title_handle_slider = PBField.initString("");
        public final PBStringField icon_title_gift_handle_slider = PBField.initString("");
    };
    public final PBStringField game_helper_icon = PBField.initString("");
    public final PBStringField game_helper_name = PBField.initString("");
    public final PBUInt64Field game_helper_uid = PBField.initUInt64(0);
    public final PBStringField game_teaming_icon = PBField.initString("");
    public final PBStringField team_float_window_icon = PBField.initString("");
    public final PBInt32Field style_mode = PBField.initInt32(0);
    public YesGameInfoOuterClass$InputCommonConfig game_input_common = new MessageMicro<YesGameInfoOuterClass$InputCommonConfig>() { // from class: com.tencent.icgame.trpc.yes.common.YesGameInfoOuterClass$InputCommonConfig
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"add_fav_emo_entrance"}, new Object[]{0}, YesGameInfoOuterClass$InputCommonConfig.class);
        public final PBInt32Field add_fav_emo_entrance = PBField.initInt32(0);
    };
}
