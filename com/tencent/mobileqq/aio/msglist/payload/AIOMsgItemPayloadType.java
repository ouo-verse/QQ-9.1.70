package com.tencent.mobileqq.aio.msglist.payload;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\bI\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bI\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/aio/msglist/payload/AIOMsgItemPayloadType;", "", "(Ljava/lang/String;I)V", "RICH_MEDIA_PAYLOAD", "SELECT_PAYLOAD", "TIMESTAMP_PAYLOAD", "NEW_MSG_TIP_LINE", "SEND_STATUS_PAYLOAD", "REPLAY_MSG_COMMENT_COUNT_PAYLOAD", "REPLY_MSG_REVOKED_PAYLOAD", "PTT_TRANSLATE_PAYLOAD", "PTT_FAKE_PAYLOAD", "PTT_PATH_PAYLOAD", "DOUTU_STATUS_PAYLOAD", "BUBBLE_REFRESH_PAYLOAD", "SHOOT_BUBBLE_PAYLOAD", "VAS_AVATAR_PAYLOAD", "AVATAR_EGG_PAYLOAD", "MUTUAL_MASK_PAYLOAD", "VAS_AVATAR_PENDENT_PAYLOAD", "VAS_SPECIAL_SHAPE_PAYLOAD", "ESSENCE_TAIL_PAYLOAD", "GRADE_LEVEL_PAYLOAD", "MEMBER_LEVEL_PAYLOAD", "VAS_FONT_PAYLOAD", "PaiYiPai_PAYLOAD", "GIFT_PAYLOAD", "POKE_VAS_PAYLOAD", "POKE_TOGGLE_QUICK_BACK_PAYLOAD", "POKE_EMO_PAYLOAD", "VIP_ICON_PAYLOAD", "VIP_ICON_EX_PAYLOAD", "GAME_ICON_PAYLOAD", "VAS_NICK_BACKGROUND_PAYLOAD", "LOCATION_SHARE_PAYLOAD", "PTT_PLAY_NEXT_PAYLOAD", "LOAD_AVATAR_PENDANT_PAYLOAD", "AVATAR_CHANGE_PAYLOAD", "GRAY_TIP_CONTENT_PAYLOAD", "NICK_PAYLOAD", "BG_TEXT_COLOR_PAYLOAD", "FILE_TRANSFER_STATUS_PAYLOAD", "FILE_TRANSFER_PROGRESS_PAYLOAD", "FILE_TRANSFER_END_PAYLOAD", "FILE_THUMB_TRANSFER_END_PAYLOAD", "LONGMSG_FETCH_FAIL", "QCIRCLE_RED_DOT", "RANDOM_LOTTIE_RESULT", "LOTTIE_RES_UPDATE_PAYLOAD", "MEDIA_PATH_PAYLOAD", "AIO_TEXT_UPDATE_EMOTICON_PAYLOAD", "AIO_TEXT_RICH_MSG_PAYLOAD", "AUTHENTICATION_PAYLOAD", "FOLLOW_MSG_PAYLOAD", "DOU_TU_PAYLOAD", "SCREEN_SIZE_CHANGE", "TOFU_ACTION_BUTTON_PAYLOAD", "SHOT_MOSAIC", "SHOULD_SHOW_REPLY_PAYLOAD", "MSG_EMO_REPLY_PAYLOAD", "LAST_RECEIVE_MSG_PAYLOAD", "RECOMMEND_MSG_PAYLOAD", "MSG_FEEDBACK_BAR_PAYLOAD", "ADELIE_MSG_PUSH_STATE_PAYLOAD", "NICK_ICON_DATA", "QQ_STRANGER_TAIL_PAYLOAD", "CHAIN_FLAG_CHANGE", "MARKDOWN_STREAM_RUNNING_PAYLOAD", "SHOT_MODE_PAYLOAD", "THEME_CHANGE_PAYLOAD", "ACCESSIBILITY_FOCUS_PAYLOAD", "LOADING_CHANGE_PAYLOAD", "OPEN_AI_CHAT_PAYLOAD", "APP_ICON_BIND_PAYLOAD", "aio_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes11.dex */
public final class AIOMsgItemPayloadType {
    private static final /* synthetic */ AIOMsgItemPayloadType[] $VALUES;
    static IPatchRedirector $redirector_;
    public static final AIOMsgItemPayloadType ACCESSIBILITY_FOCUS_PAYLOAD;
    public static final AIOMsgItemPayloadType ADELIE_MSG_PUSH_STATE_PAYLOAD;
    public static final AIOMsgItemPayloadType AIO_TEXT_RICH_MSG_PAYLOAD;
    public static final AIOMsgItemPayloadType AIO_TEXT_UPDATE_EMOTICON_PAYLOAD;
    public static final AIOMsgItemPayloadType APP_ICON_BIND_PAYLOAD;
    public static final AIOMsgItemPayloadType AUTHENTICATION_PAYLOAD;
    public static final AIOMsgItemPayloadType AVATAR_CHANGE_PAYLOAD;
    public static final AIOMsgItemPayloadType AVATAR_EGG_PAYLOAD;
    public static final AIOMsgItemPayloadType BG_TEXT_COLOR_PAYLOAD;
    public static final AIOMsgItemPayloadType BUBBLE_REFRESH_PAYLOAD;
    public static final AIOMsgItemPayloadType CHAIN_FLAG_CHANGE;
    public static final AIOMsgItemPayloadType DOUTU_STATUS_PAYLOAD;
    public static final AIOMsgItemPayloadType DOU_TU_PAYLOAD;
    public static final AIOMsgItemPayloadType ESSENCE_TAIL_PAYLOAD;
    public static final AIOMsgItemPayloadType FILE_THUMB_TRANSFER_END_PAYLOAD;
    public static final AIOMsgItemPayloadType FILE_TRANSFER_END_PAYLOAD;
    public static final AIOMsgItemPayloadType FILE_TRANSFER_PROGRESS_PAYLOAD;
    public static final AIOMsgItemPayloadType FILE_TRANSFER_STATUS_PAYLOAD;
    public static final AIOMsgItemPayloadType FOLLOW_MSG_PAYLOAD;
    public static final AIOMsgItemPayloadType GAME_ICON_PAYLOAD;
    public static final AIOMsgItemPayloadType GIFT_PAYLOAD;
    public static final AIOMsgItemPayloadType GRADE_LEVEL_PAYLOAD;
    public static final AIOMsgItemPayloadType GRAY_TIP_CONTENT_PAYLOAD;
    public static final AIOMsgItemPayloadType LAST_RECEIVE_MSG_PAYLOAD;
    public static final AIOMsgItemPayloadType LOADING_CHANGE_PAYLOAD;
    public static final AIOMsgItemPayloadType LOAD_AVATAR_PENDANT_PAYLOAD;
    public static final AIOMsgItemPayloadType LOCATION_SHARE_PAYLOAD;
    public static final AIOMsgItemPayloadType LONGMSG_FETCH_FAIL;
    public static final AIOMsgItemPayloadType LOTTIE_RES_UPDATE_PAYLOAD;
    public static final AIOMsgItemPayloadType MARKDOWN_STREAM_RUNNING_PAYLOAD;
    public static final AIOMsgItemPayloadType MEDIA_PATH_PAYLOAD;
    public static final AIOMsgItemPayloadType MEMBER_LEVEL_PAYLOAD;
    public static final AIOMsgItemPayloadType MSG_EMO_REPLY_PAYLOAD;
    public static final AIOMsgItemPayloadType MSG_FEEDBACK_BAR_PAYLOAD;
    public static final AIOMsgItemPayloadType MUTUAL_MASK_PAYLOAD;
    public static final AIOMsgItemPayloadType NEW_MSG_TIP_LINE;
    public static final AIOMsgItemPayloadType NICK_ICON_DATA;
    public static final AIOMsgItemPayloadType NICK_PAYLOAD;
    public static final AIOMsgItemPayloadType OPEN_AI_CHAT_PAYLOAD;
    public static final AIOMsgItemPayloadType POKE_EMO_PAYLOAD;
    public static final AIOMsgItemPayloadType POKE_TOGGLE_QUICK_BACK_PAYLOAD;
    public static final AIOMsgItemPayloadType POKE_VAS_PAYLOAD;
    public static final AIOMsgItemPayloadType PTT_FAKE_PAYLOAD;
    public static final AIOMsgItemPayloadType PTT_PATH_PAYLOAD;
    public static final AIOMsgItemPayloadType PTT_PLAY_NEXT_PAYLOAD;
    public static final AIOMsgItemPayloadType PTT_TRANSLATE_PAYLOAD;
    public static final AIOMsgItemPayloadType PaiYiPai_PAYLOAD;
    public static final AIOMsgItemPayloadType QCIRCLE_RED_DOT;
    public static final AIOMsgItemPayloadType QQ_STRANGER_TAIL_PAYLOAD;
    public static final AIOMsgItemPayloadType RANDOM_LOTTIE_RESULT;
    public static final AIOMsgItemPayloadType RECOMMEND_MSG_PAYLOAD;
    public static final AIOMsgItemPayloadType REPLAY_MSG_COMMENT_COUNT_PAYLOAD;
    public static final AIOMsgItemPayloadType REPLY_MSG_REVOKED_PAYLOAD;
    public static final AIOMsgItemPayloadType RICH_MEDIA_PAYLOAD;
    public static final AIOMsgItemPayloadType SCREEN_SIZE_CHANGE;
    public static final AIOMsgItemPayloadType SELECT_PAYLOAD;
    public static final AIOMsgItemPayloadType SEND_STATUS_PAYLOAD;
    public static final AIOMsgItemPayloadType SHOOT_BUBBLE_PAYLOAD;
    public static final AIOMsgItemPayloadType SHOT_MODE_PAYLOAD;
    public static final AIOMsgItemPayloadType SHOT_MOSAIC;
    public static final AIOMsgItemPayloadType SHOULD_SHOW_REPLY_PAYLOAD;
    public static final AIOMsgItemPayloadType THEME_CHANGE_PAYLOAD;
    public static final AIOMsgItemPayloadType TIMESTAMP_PAYLOAD;
    public static final AIOMsgItemPayloadType TOFU_ACTION_BUTTON_PAYLOAD;
    public static final AIOMsgItemPayloadType VAS_AVATAR_PAYLOAD;
    public static final AIOMsgItemPayloadType VAS_AVATAR_PENDENT_PAYLOAD;
    public static final AIOMsgItemPayloadType VAS_FONT_PAYLOAD;
    public static final AIOMsgItemPayloadType VAS_NICK_BACKGROUND_PAYLOAD;
    public static final AIOMsgItemPayloadType VAS_SPECIAL_SHAPE_PAYLOAD;
    public static final AIOMsgItemPayloadType VIP_ICON_EX_PAYLOAD;
    public static final AIOMsgItemPayloadType VIP_ICON_PAYLOAD;

    private static final /* synthetic */ AIOMsgItemPayloadType[] $values() {
        return new AIOMsgItemPayloadType[]{RICH_MEDIA_PAYLOAD, SELECT_PAYLOAD, TIMESTAMP_PAYLOAD, NEW_MSG_TIP_LINE, SEND_STATUS_PAYLOAD, REPLAY_MSG_COMMENT_COUNT_PAYLOAD, REPLY_MSG_REVOKED_PAYLOAD, PTT_TRANSLATE_PAYLOAD, PTT_FAKE_PAYLOAD, PTT_PATH_PAYLOAD, DOUTU_STATUS_PAYLOAD, BUBBLE_REFRESH_PAYLOAD, SHOOT_BUBBLE_PAYLOAD, VAS_AVATAR_PAYLOAD, AVATAR_EGG_PAYLOAD, MUTUAL_MASK_PAYLOAD, VAS_AVATAR_PENDENT_PAYLOAD, VAS_SPECIAL_SHAPE_PAYLOAD, ESSENCE_TAIL_PAYLOAD, GRADE_LEVEL_PAYLOAD, MEMBER_LEVEL_PAYLOAD, VAS_FONT_PAYLOAD, PaiYiPai_PAYLOAD, GIFT_PAYLOAD, POKE_VAS_PAYLOAD, POKE_TOGGLE_QUICK_BACK_PAYLOAD, POKE_EMO_PAYLOAD, VIP_ICON_PAYLOAD, VIP_ICON_EX_PAYLOAD, GAME_ICON_PAYLOAD, VAS_NICK_BACKGROUND_PAYLOAD, LOCATION_SHARE_PAYLOAD, PTT_PLAY_NEXT_PAYLOAD, LOAD_AVATAR_PENDANT_PAYLOAD, AVATAR_CHANGE_PAYLOAD, GRAY_TIP_CONTENT_PAYLOAD, NICK_PAYLOAD, BG_TEXT_COLOR_PAYLOAD, FILE_TRANSFER_STATUS_PAYLOAD, FILE_TRANSFER_PROGRESS_PAYLOAD, FILE_TRANSFER_END_PAYLOAD, FILE_THUMB_TRANSFER_END_PAYLOAD, LONGMSG_FETCH_FAIL, QCIRCLE_RED_DOT, RANDOM_LOTTIE_RESULT, LOTTIE_RES_UPDATE_PAYLOAD, MEDIA_PATH_PAYLOAD, AIO_TEXT_UPDATE_EMOTICON_PAYLOAD, AIO_TEXT_RICH_MSG_PAYLOAD, AUTHENTICATION_PAYLOAD, FOLLOW_MSG_PAYLOAD, DOU_TU_PAYLOAD, SCREEN_SIZE_CHANGE, TOFU_ACTION_BUTTON_PAYLOAD, SHOT_MOSAIC, SHOULD_SHOW_REPLY_PAYLOAD, MSG_EMO_REPLY_PAYLOAD, LAST_RECEIVE_MSG_PAYLOAD, RECOMMEND_MSG_PAYLOAD, MSG_FEEDBACK_BAR_PAYLOAD, ADELIE_MSG_PUSH_STATE_PAYLOAD, NICK_ICON_DATA, QQ_STRANGER_TAIL_PAYLOAD, CHAIN_FLAG_CHANGE, MARKDOWN_STREAM_RUNNING_PAYLOAD, SHOT_MODE_PAYLOAD, THEME_CHANGE_PAYLOAD, ACCESSIBILITY_FOCUS_PAYLOAD, LOADING_CHANGE_PAYLOAD, OPEN_AI_CHAT_PAYLOAD, APP_ICON_BIND_PAYLOAD};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(49092);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        RICH_MEDIA_PAYLOAD = new AIOMsgItemPayloadType("RICH_MEDIA_PAYLOAD", 0);
        SELECT_PAYLOAD = new AIOMsgItemPayloadType("SELECT_PAYLOAD", 1);
        TIMESTAMP_PAYLOAD = new AIOMsgItemPayloadType("TIMESTAMP_PAYLOAD", 2);
        NEW_MSG_TIP_LINE = new AIOMsgItemPayloadType("NEW_MSG_TIP_LINE", 3);
        SEND_STATUS_PAYLOAD = new AIOMsgItemPayloadType("SEND_STATUS_PAYLOAD", 4);
        REPLAY_MSG_COMMENT_COUNT_PAYLOAD = new AIOMsgItemPayloadType("REPLAY_MSG_COMMENT_COUNT_PAYLOAD", 5);
        REPLY_MSG_REVOKED_PAYLOAD = new AIOMsgItemPayloadType("REPLY_MSG_REVOKED_PAYLOAD", 6);
        PTT_TRANSLATE_PAYLOAD = new AIOMsgItemPayloadType("PTT_TRANSLATE_PAYLOAD", 7);
        PTT_FAKE_PAYLOAD = new AIOMsgItemPayloadType("PTT_FAKE_PAYLOAD", 8);
        PTT_PATH_PAYLOAD = new AIOMsgItemPayloadType("PTT_PATH_PAYLOAD", 9);
        DOUTU_STATUS_PAYLOAD = new AIOMsgItemPayloadType("DOUTU_STATUS_PAYLOAD", 10);
        BUBBLE_REFRESH_PAYLOAD = new AIOMsgItemPayloadType("BUBBLE_REFRESH_PAYLOAD", 11);
        SHOOT_BUBBLE_PAYLOAD = new AIOMsgItemPayloadType("SHOOT_BUBBLE_PAYLOAD", 12);
        VAS_AVATAR_PAYLOAD = new AIOMsgItemPayloadType("VAS_AVATAR_PAYLOAD", 13);
        AVATAR_EGG_PAYLOAD = new AIOMsgItemPayloadType("AVATAR_EGG_PAYLOAD", 14);
        MUTUAL_MASK_PAYLOAD = new AIOMsgItemPayloadType("MUTUAL_MASK_PAYLOAD", 15);
        VAS_AVATAR_PENDENT_PAYLOAD = new AIOMsgItemPayloadType("VAS_AVATAR_PENDENT_PAYLOAD", 16);
        VAS_SPECIAL_SHAPE_PAYLOAD = new AIOMsgItemPayloadType("VAS_SPECIAL_SHAPE_PAYLOAD", 17);
        ESSENCE_TAIL_PAYLOAD = new AIOMsgItemPayloadType("ESSENCE_TAIL_PAYLOAD", 18);
        GRADE_LEVEL_PAYLOAD = new AIOMsgItemPayloadType("GRADE_LEVEL_PAYLOAD", 19);
        MEMBER_LEVEL_PAYLOAD = new AIOMsgItemPayloadType("MEMBER_LEVEL_PAYLOAD", 20);
        VAS_FONT_PAYLOAD = new AIOMsgItemPayloadType("VAS_FONT_PAYLOAD", 21);
        PaiYiPai_PAYLOAD = new AIOMsgItemPayloadType("PaiYiPai_PAYLOAD", 22);
        GIFT_PAYLOAD = new AIOMsgItemPayloadType("GIFT_PAYLOAD", 23);
        POKE_VAS_PAYLOAD = new AIOMsgItemPayloadType("POKE_VAS_PAYLOAD", 24);
        POKE_TOGGLE_QUICK_BACK_PAYLOAD = new AIOMsgItemPayloadType("POKE_TOGGLE_QUICK_BACK_PAYLOAD", 25);
        POKE_EMO_PAYLOAD = new AIOMsgItemPayloadType("POKE_EMO_PAYLOAD", 26);
        VIP_ICON_PAYLOAD = new AIOMsgItemPayloadType("VIP_ICON_PAYLOAD", 27);
        VIP_ICON_EX_PAYLOAD = new AIOMsgItemPayloadType("VIP_ICON_EX_PAYLOAD", 28);
        GAME_ICON_PAYLOAD = new AIOMsgItemPayloadType("GAME_ICON_PAYLOAD", 29);
        VAS_NICK_BACKGROUND_PAYLOAD = new AIOMsgItemPayloadType("VAS_NICK_BACKGROUND_PAYLOAD", 30);
        LOCATION_SHARE_PAYLOAD = new AIOMsgItemPayloadType("LOCATION_SHARE_PAYLOAD", 31);
        PTT_PLAY_NEXT_PAYLOAD = new AIOMsgItemPayloadType("PTT_PLAY_NEXT_PAYLOAD", 32);
        LOAD_AVATAR_PENDANT_PAYLOAD = new AIOMsgItemPayloadType("LOAD_AVATAR_PENDANT_PAYLOAD", 33);
        AVATAR_CHANGE_PAYLOAD = new AIOMsgItemPayloadType("AVATAR_CHANGE_PAYLOAD", 34);
        GRAY_TIP_CONTENT_PAYLOAD = new AIOMsgItemPayloadType("GRAY_TIP_CONTENT_PAYLOAD", 35);
        NICK_PAYLOAD = new AIOMsgItemPayloadType("NICK_PAYLOAD", 36);
        BG_TEXT_COLOR_PAYLOAD = new AIOMsgItemPayloadType("BG_TEXT_COLOR_PAYLOAD", 37);
        FILE_TRANSFER_STATUS_PAYLOAD = new AIOMsgItemPayloadType("FILE_TRANSFER_STATUS_PAYLOAD", 38);
        FILE_TRANSFER_PROGRESS_PAYLOAD = new AIOMsgItemPayloadType("FILE_TRANSFER_PROGRESS_PAYLOAD", 39);
        FILE_TRANSFER_END_PAYLOAD = new AIOMsgItemPayloadType("FILE_TRANSFER_END_PAYLOAD", 40);
        FILE_THUMB_TRANSFER_END_PAYLOAD = new AIOMsgItemPayloadType("FILE_THUMB_TRANSFER_END_PAYLOAD", 41);
        LONGMSG_FETCH_FAIL = new AIOMsgItemPayloadType("LONGMSG_FETCH_FAIL", 42);
        QCIRCLE_RED_DOT = new AIOMsgItemPayloadType("QCIRCLE_RED_DOT", 43);
        RANDOM_LOTTIE_RESULT = new AIOMsgItemPayloadType("RANDOM_LOTTIE_RESULT", 44);
        LOTTIE_RES_UPDATE_PAYLOAD = new AIOMsgItemPayloadType("LOTTIE_RES_UPDATE_PAYLOAD", 45);
        MEDIA_PATH_PAYLOAD = new AIOMsgItemPayloadType("MEDIA_PATH_PAYLOAD", 46);
        AIO_TEXT_UPDATE_EMOTICON_PAYLOAD = new AIOMsgItemPayloadType("AIO_TEXT_UPDATE_EMOTICON_PAYLOAD", 47);
        AIO_TEXT_RICH_MSG_PAYLOAD = new AIOMsgItemPayloadType("AIO_TEXT_RICH_MSG_PAYLOAD", 48);
        AUTHENTICATION_PAYLOAD = new AIOMsgItemPayloadType("AUTHENTICATION_PAYLOAD", 49);
        FOLLOW_MSG_PAYLOAD = new AIOMsgItemPayloadType("FOLLOW_MSG_PAYLOAD", 50);
        DOU_TU_PAYLOAD = new AIOMsgItemPayloadType("DOU_TU_PAYLOAD", 51);
        SCREEN_SIZE_CHANGE = new AIOMsgItemPayloadType("SCREEN_SIZE_CHANGE", 52);
        TOFU_ACTION_BUTTON_PAYLOAD = new AIOMsgItemPayloadType("TOFU_ACTION_BUTTON_PAYLOAD", 53);
        SHOT_MOSAIC = new AIOMsgItemPayloadType("SHOT_MOSAIC", 54);
        SHOULD_SHOW_REPLY_PAYLOAD = new AIOMsgItemPayloadType("SHOULD_SHOW_REPLY_PAYLOAD", 55);
        MSG_EMO_REPLY_PAYLOAD = new AIOMsgItemPayloadType("MSG_EMO_REPLY_PAYLOAD", 56);
        LAST_RECEIVE_MSG_PAYLOAD = new AIOMsgItemPayloadType("LAST_RECEIVE_MSG_PAYLOAD", 57);
        RECOMMEND_MSG_PAYLOAD = new AIOMsgItemPayloadType("RECOMMEND_MSG_PAYLOAD", 58);
        MSG_FEEDBACK_BAR_PAYLOAD = new AIOMsgItemPayloadType("MSG_FEEDBACK_BAR_PAYLOAD", 59);
        ADELIE_MSG_PUSH_STATE_PAYLOAD = new AIOMsgItemPayloadType("ADELIE_MSG_PUSH_STATE_PAYLOAD", 60);
        NICK_ICON_DATA = new AIOMsgItemPayloadType("NICK_ICON_DATA", 61);
        QQ_STRANGER_TAIL_PAYLOAD = new AIOMsgItemPayloadType("QQ_STRANGER_TAIL_PAYLOAD", 62);
        CHAIN_FLAG_CHANGE = new AIOMsgItemPayloadType("CHAIN_FLAG_CHANGE", 63);
        MARKDOWN_STREAM_RUNNING_PAYLOAD = new AIOMsgItemPayloadType("MARKDOWN_STREAM_RUNNING_PAYLOAD", 64);
        SHOT_MODE_PAYLOAD = new AIOMsgItemPayloadType("SHOT_MODE_PAYLOAD", 65);
        THEME_CHANGE_PAYLOAD = new AIOMsgItemPayloadType("THEME_CHANGE_PAYLOAD", 66);
        ACCESSIBILITY_FOCUS_PAYLOAD = new AIOMsgItemPayloadType("ACCESSIBILITY_FOCUS_PAYLOAD", 67);
        LOADING_CHANGE_PAYLOAD = new AIOMsgItemPayloadType("LOADING_CHANGE_PAYLOAD", 68);
        OPEN_AI_CHAT_PAYLOAD = new AIOMsgItemPayloadType("OPEN_AI_CHAT_PAYLOAD", 69);
        APP_ICON_BIND_PAYLOAD = new AIOMsgItemPayloadType("APP_ICON_BIND_PAYLOAD", 70);
        $VALUES = $values();
    }

    AIOMsgItemPayloadType(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
        }
    }

    public static AIOMsgItemPayloadType valueOf(String str) {
        return (AIOMsgItemPayloadType) Enum.valueOf(AIOMsgItemPayloadType.class, str);
    }

    public static AIOMsgItemPayloadType[] values() {
        return (AIOMsgItemPayloadType[]) $VALUES.clone();
    }
}
