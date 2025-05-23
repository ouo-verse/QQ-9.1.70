package com.tencent.mobileqq.utils.abtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Deprecated
/* loaded from: classes20.dex */
public class QCommonOnlineExpProviderImpl implements IOnlineExpProvider {
    public static final String EXP_ACCOUNT_MANAGE_SWITCH_A = "exp_account_manage_switch_8885_A";
    public static final String EXP_ACCOUNT_MANAGE_SWITCH_A_A = "exp_account_manage_switch_8885_A";
    public static final String EXP_ACCOUNT_MANAGE_SWITCH_A_PLACEHOLDER = "exp_account_manage_switch_8885_A_placeholder";
    public static final String EXP_ACCOUNT_MANAGE_SWITCH_B = "exp_account_manage_switch_8885_B";
    public static final String EXP_ACCOUNT_MANAGE_SWITCH_B_B = "exp_account_manage_switch_8885_B";
    public static final String EXP_ACCOUNT_MANAGE_SWITCH_B_PLACEHOLDER = "exp_account_manage_switch_8885_B_placeholder";
    public static final String EXP_CMSHOW_MOOD = "exp_cmshow_mood";
    public static final String EXP_EMOTICON_HOTPIC_SEARCH_AIO_INPUT_BAR = "exp_qq_msg_marketface_shanzi_icon";
    public static final String EXP_EMOTICON_HOTPIC_SEARCH_AIO_INPUT_BAR_A = "exp_qq_msg_marketface_shanzi_icon_A";
    public static final String EXP_EMOTICON_HOTPIC_SEARCH_AIO_INPUT_BAR_B = "exp_qq_msg_marketface_shanzi_icon_B";
    public static final String EXP_EXP_QQ_ZHENGAN = "exp_qq_zhengan";
    public static final String EXP_EXP_QQ_ZHENGAN_A = "exp_qq_zhengan_A";
    public static final String EXP_EXP_QQ_ZHENGAN_B = "exp_qq_zhengan_B";
    public static final String EXP_FORWARD_SELECTOR = "exp_latestforward_new";
    public static final String EXP_FORWARD_SELECTOR_GRID = "exp_latestforward_new_grid";
    public static final String EXP_FORWARD_SELECTOR_LIST = "exp_latestforward_new_list";
    public static final String EXP_GUILD_MSG_NOTIFY_FOLLOW_ADMIN_SETTING = "exp_qq_sgrp_msgnote_ownersetting";
    public static final String EXP_GUILD_MSG_NOTIFY_FOLLOW_ADMIN_SETTING_A = "exp_qq_sgrp_msgnote_ownersetting_a";
    public static final String EXP_GUILD_MSG_NOTIFY_FOLLOW_ADMIN_SETTING_BENCH = "exp_qq_sgrp_msgnote_ownersetting_bench";
    public static final String EXP_MINIGAME_BOTTOM_GUIDE = "exp_miniapp_minigame_pulldown_backhome_20210831";
    public static final String EXP_NEARBY_ADD_FRIEND = "exp_fj_aio_addfriend";
    public static final String EXP_NEARBY_ADD_FRIEND_A = "exp_fj_aio_addfriend_A";
    public static final String EXP_NEARBY_ADD_FRIEND_B = "exp_fj_aio_addfriend_B";
    public static final String EXP_PERSONAL_NEW_PROFILE_CARD = "exp_qq_profile_new_copy";
    public static final String EXP_PERSONAL_NEW_PROFILE_CARD_A = "exp_qq_profile_new_A";
    public static final String EXP_PERSONAL_NEW_PROFILE_CARD_B = "exp_qq_profile_new_B";
    public static final String EXP_PERSONAL_NEW_PROFILE_CARD_C = "exp_qq_profile_new_C";
    public static final String EXP_PERSONAL_PROFILE_DEFAULT_MODE = "exp_qq_qqprofile1";
    public static final String EXP_PUBLISH_IMAGE_ENHANCE = "exp_publish_image_enhance";
    public static final String EXP_QQGAME_PUBLICACCOUNT_MSGEXPOSURE = "exp_qq_qqgame_publicaccount_msg";
    public static final String EXP_QQ_GAME_BOX = "game_box1";
    public static final String EXP_QQ_LEBA_CONCISE_THEME_CONTENT = "exp_shouq_dongtai_jianjie_copy_copy";
    public static final String EXP_QQ_LEBA_CONCISE_THEME_CONTENT_A = "exp_shouq_dongtai_jianjie_A";
    public static final String EXP_QQ_LEBA_CONCISE_THEME_CONTENT_B = "exp_shouq_dongtai_jianjie_B";
    public static final String EXP_QQ_LEBA_CONCISE_THEME_CONTENT_C = "exp_shouq_dongtai_jianjie_C";
    public static final String EXP_QQ_LEBA_POST_BTN_MODE = "exp_shouq_dongtai_jianjie_public_button";
    public static final String EXP_QQ_LEBA_POST_BTN_MODE_A = "exp_shouq_dongtai_jianjie_public_button_A";
    public static final String EXP_QQ_LEBA_POST_BTN_MODE_B = "exp_shouq_dongtai_jianjie_public_button_B";
    public static final String EXP_QQ_LEBA_POST_BTN_MODE_C = "exp_shouq_dongtai_jianjie_public_button_C";
    public static final String EXP_QQ_LEBA_SIMPLE_UI_FEEDS_PROFILE_JUMP = "exp_shouq_dongtai_jianjie_profile_jump";
    public static final String EXP_QQ_MESSAGE_REMINDER_DND = "exp_XIAOXI_XIAOXITONGZHI_MIANDARAO";
    public static final String EXP_QQ_MINI_APP_AIO_FILE = "exp_qq_miniapp_progame_aiofile";
    public static final String EXP_QQ_MODE_UPPER = "exp_qq_mode_upper";
    public static final String EXP_QQ_NEW_VIDEO_EDIT = "exp_QQ_new_video_edit";
    public static final String EXP_QQ_SEARCH_C2C_220126 = "exp_qq_search_c2c_220126";
    public static final String EXP_QQ_SEARCH_C2C_22509 = "exp_qq_search_c2c_22509";
    public static final String EXP_QQ_STATUS = "exp_status_new";
    public static final String EXP_QQ_TAB_SETTING_ENTRANCE = "exp_qq_tab_new";
    public static final String EXP_QQ_TAB_SETTING_ENTRANCE_A = "exp_qq_tab_new_A";
    public static final String EXP_QQ_TAB_SETTING_ENTRANCE_B = "exp_qq_tab_new_B";
    public static final String EXP_QQ_YELLOW_STICKER = "exp_qq_yellow_sticker_manage";
    public static final String EXP_QZONE_PEZRMISSION_SWITCH = "exp_addprivilege_copy_copy";
    public static final String EXP_QZONE_PEZRMISSION_SWITCH_A = "exp_addprivilege_copy_A";
    public static final String EXP_QZONE_PEZRMISSION_SWITCH_B = "exp_addprivilege_copy_B";
    public static final String EXP_QZONE_PEZRMISSION_SWITCH_C = "exp_addprivilege_copy_C";
    public static final String EXP_QZONE_PEZRMISSION_SWITCH_D = "exp_addprivilege_copy_D";
    public static final String EXP_SGRP_MESSAGE_PUSH_SETTING = "exp_sgrp_message_push_setting";
    public static final String EXP_SGRP_MESSAGE_PUSH_SETTING_A = "exp_sgrp_message_push_setting_A";
    public static final String EXP_SGRP_MESSAGE_PUSH_SETTING_B = "exp_sgrp_message_push_setting_B";
    public static final String EXP_XSJ_DELAY_PRELOAD_1505 = "exp_xsj_delay_preload_1505";
    public static final String EXP_XSJ_DELAY_PRELOAD_VIDEO_1505 = "exp_xsj_delay_preload_video_1505";
    public static final String EXP_ZPLAN_EMOTICON_AVATAR_ICON_DRESSED = "exp_zplan_emote_tab_dressed0";
    public static final String EXP_ZPLAN_EMOTICON_AVATAR_ICON_GROUP_A = "exp_zplan_emote_tab_dressed_A";
    public static final String EXP_ZPLAN_EMOTICON_AVATAR_ICON_GROUP_B = "exp_zplan_emote_tab_dressed_B";
    public static final String EXP_ZPLAN_EMOTICON_AVATAR_ICON_GROUP_C = "exp_zplan_emote_tab_dressed_C";
    public static final String EXP_ZPLAN_EMOTICON_AVATAR_ICON_NODRESSED = "exp_zplan_emote_tab_nodressed0";

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public Map<String, String> getBusinessProfiles() {
        return null;
    }

    @Override // com.tencent.mobileqq.utils.abtest.IOnlineExpProvider
    public List<String> getRegisterExpNameList() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(EXP_QQ_MESSAGE_REMINDER_DND);
        arrayList.add(EXP_QQ_STATUS);
        arrayList.add(EXP_QQ_MINI_APP_AIO_FILE);
        arrayList.add(EXP_QQ_GAME_BOX);
        arrayList.add(EXP_QQ_YELLOW_STICKER);
        arrayList.add(EXP_CMSHOW_MOOD);
        arrayList.add(EXP_QQ_MODE_UPPER);
        arrayList.add(EXP_QQ_LEBA_CONCISE_THEME_CONTENT);
        arrayList.add(EXP_PERSONAL_PROFILE_DEFAULT_MODE);
        arrayList.add(EXP_QQGAME_PUBLICACCOUNT_MSGEXPOSURE);
        arrayList.add(EXP_MINIGAME_BOTTOM_GUIDE);
        arrayList.add(EXP_PUBLISH_IMAGE_ENHANCE);
        arrayList.add(EXP_QQ_LEBA_POST_BTN_MODE);
        arrayList.add(EXP_QQ_SEARCH_C2C_220126);
        arrayList.add(EXP_QQ_SEARCH_C2C_22509);
        arrayList.add(EXP_QQ_TAB_SETTING_ENTRANCE);
        arrayList.add(EXP_QQ_NEW_VIDEO_EDIT);
        arrayList.add(EXP_QQ_LEBA_SIMPLE_UI_FEEDS_PROFILE_JUMP);
        arrayList.add(EXP_PERSONAL_NEW_PROFILE_CARD);
        arrayList.add(EXP_NEARBY_ADD_FRIEND);
        arrayList.add("exp_account_manage_switch_8885_A");
        arrayList.add("exp_account_manage_switch_8885_B");
        arrayList.add(EXP_EXP_QQ_ZHENGAN);
        arrayList.add(EXP_QZONE_PEZRMISSION_SWITCH);
        arrayList.add(EXP_GUILD_MSG_NOTIFY_FOLLOW_ADMIN_SETTING);
        arrayList.add(EXP_XSJ_DELAY_PRELOAD_1505);
        arrayList.add(EXP_XSJ_DELAY_PRELOAD_VIDEO_1505);
        arrayList.add(EXP_ZPLAN_EMOTICON_AVATAR_ICON_DRESSED);
        arrayList.add(EXP_ZPLAN_EMOTICON_AVATAR_ICON_NODRESSED);
        return arrayList;
    }
}
