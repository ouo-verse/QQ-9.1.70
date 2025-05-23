package com.tencent.mobileqq.qqlive.api.ipc;

/* loaded from: classes17.dex */
public interface QQLiveIPCConstants {

    /* loaded from: classes17.dex */
    public interface Action {
        public static final String ACTION_CLIENT_ROOM_CHAT_AV_NOTIFY = "ACTION_CLIENT_ROOM_CHAT_AV_NOTIFY";
        public static final String ACTION_GET_QQ_PROFILE = "action_get_qq_profile";
        public static final String ACTION_QQLIVE_ENTER_GAME_INVITE_ROOM = "action_qqlive_enter_game_invite_room";
        public static final String ACTION_QQLIVE_EXIT_ROOM = "action_qqlive_exit_room";
        public static final String ACTION_QQLIVE_FOLLOW_ANCHOR = "action_qqlive_follow_anchor";
        public static final String ACTION_QQLIVE_PLAY_TOGETHER_LAUNCH_APP = "ACTION_QQLIVE_PLAY_TOGETHER_LAUNCH_APP";
        public static final String ACTION_QQLIVE_QUALITY_REPORT = "action_qqlive_quality_report";
        public static final String ACTION_QQLIVE_SEND_COMMENT = "action_qqlive_send_comment";
        public static final String ACTION_QQLIVE_SEND_FREE_LOVE = "action_qqlive_send_free_love";
        public static final String ACTION_QQLIVE_USE_REMOTE_PLAYER = "action_qqlive_use_remote_player";
        public static final String ACTION_QQLIVE_VERIFY_CALLBACK = "action_qqlive_verify_callback";
        public static final String ACTION_ROOM_BACKGROUND_REPORT = "ACTION_ROOM_BACKGROUND_REPORT";
        public static final String ACTION_ROOM_IS_AUDIO_CHATTING = "ACTION_ROOM_IS_AUDIO_CHATTING";
        public static final String ACTION_ROOM_REGISTER_CHAT_AUDIO_OBSERVER = "ACTION_ROOM_REGISTER_CHAT_AUDIO_OBSERVER";
        public static final String ACTION_ROOM_REMOVE_CHAT_AUDIO_OBSERVER = "ACTION_ROOM_REMOVE_CHAT_AUDIO_OBSERVER";
    }

    /* loaded from: classes17.dex */
    public interface Module {
        public static final String MODULE_CLIENT = "QQLiveClientQIPCModule";
        public static final String MODULE_SERVER = "QQLiveServerQIPCModule";
    }

    /* loaded from: classes17.dex */
    public interface Param {
        public static final String PARAM_ACCOUNT_UIN = "param_account_uin";
        public static final String PARAM_ATTA_ID = "param_atta_id";
        public static final String PARAM_BACKGROUND_ROOM_INFO = "param_background_room_info";
        public static final String PARAM_CHAT_AUDIO_IS_BEING_INVITE = "param_chat_audio_is_being_invite";
        public static final String PARAM_CHAT_AUDIO_IS_CHATTING = "param_chat_audio_is_chatting";
        public static final String PARAM_KUIKLY_CALLBACK_MSG = "param_kuikly_callback_msg";
        public static final String PARAM_KUIKLY_PARAMS = "param_kuikly_params";
        public static final String PARAM_PLAY_TOGETHER_CALLBACK_MSG = "param_play_together_callback_msg";
        public static final String PARAM_PLAY_TOGETHER_GAME_DATA = "param_play_together_game_data";
        public static final String PARAM_QQ_PROFILE = "param_qq_profile";
        public static final String PARAM_REMOTE_PLAYER_INFO = "param_remote_player_info";
        public static final String PARAM_REPORT_DATA = "param_report_data";
    }
}
