package com.tencent.mobileqq.qqvideoplatform.api;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class SceneID {
    static IPatchRedirector $redirector_ = null;
    public static final int AIO_LONG_BUBBLE = 101;
    public static final int AIO_QQFLOATING = 116;
    public static final int AIO_RFW_LAYER = 148;
    public static final int AIO_SHORT_BUBBLE = 100;
    public static final int ALBUM_RFW_LAYER = 165;
    public static final int ALBUM_VIDEO = 105;
    public static final int AR_VIDEO = 108;
    public static final int AVGAME_VIDEO = 107;
    public static final int COMIC_VIDEO = 119;
    public static final int DATA_LINE_LAYER = 166;
    public static final int FILE_VIDEO = 109;
    public static final int FLOCK_RFW_LAYER = 147;
    public static final int FORWARD_RFW_LAYER = 152;
    public static final int GDT_AD_VIDEO = 110;
    public static final int GUILD_AIO_RFW_LAYER = 149;
    public static final int GUILD_AIO_VIDEO_BUBBLE = 155;
    public static final int GUILD_DISCOVER_AD_CARD_VIDEO = 141;
    public static final int GUILD_DISCOVER_CARD = 121;
    public static final int GUILD_FEED_CHANNEL = 122;
    public static final int GUILD_INTEREST_LABEL = 133;
    public static final int GUILD_LIVE_CHANNEL = 125;
    public static final int GUILD_LIVE_CHANNEL_PROGRAM_READY = 127;
    public static final int GUILD_LIVE_Q_CIRCLE_LIVE_ITEM = 135;
    public static final int GUILD_MAIN_FRAME_GUIDE_SHOW_ANIM = 145;
    public static final int GUILD_MEMBER_LIST = 142;
    public static final int GUILD_NEW_USER_SHOW_ANIM = 144;
    public static final int GUILD_ONLINE_MEMBER_DIALOG = 143;
    public static final int GUILD_OPEN_TAB_VIDEO = 134;
    public static final int GUILD_THIRD_APP_LOADING = 138;
    public static final int GUILD_TOP_CHANNEL_CARD = 128;
    public static final int GUILD_VISITOR_CARD = 131;
    public static final int ICGAME_SCENE_ID = 139;
    public static final int MARKDOWN_MULTI_PIC = 173;
    public static final int MINIAPP_VIDEO = 114;
    public static final int NEARBY_PRO_GALLERY_LAYER = 154;
    public static final int QQGAME_STRATEGY_VIDEO = 123;
    public static final int QQGME_VIDEO = 106;
    public static final int QQLIVE_MINI_SDK = 130;
    public static final int QQLIVE_SCENE_ID = 129;
    public static final int QQ_CIRCLE_VIDEO = 126;
    public static final int QQ_CIRCLE_VIDEO_AV1_DETECT = 174;
    public static final int QQ_HEALTH_CENTER = 117;
    public static final int QQ_ROBOT_LAYER = 168;
    public static final int QQ_ROBOT_OPEN_AIO = 170;
    public static final int QQ_RTC_VIDEO = 115;
    public static final int QQ_STRANGER_LAYER = 167;
    public static final int QQ_TBS_TOOL_MEDIA_PREVIEW = 171;
    public static final int QQ_TROOP_PREVIEW = 169;
    public static final int QQ_VIP_THEME = 132;
    public static final int QQ_VOICE = 118;
    public static final int QZONE_ALBUM_FEED = 151;
    public static final int QZONE_FEED_PRO_LAYER = 175;
    public static final int QZONE_FEED_RFW_LAYER = 146;
    public static final int QZONE_GDT_VIDEO = 103;
    public static final int QZONE_INTIMATE_ALBUM_FEED = 150;
    public static final int QZONE_VIDEO = 102;
    public static final int READINJOY_VIDEO = 104;
    public static final int RFW_COMMON_LAYER = 136;
    public static final int RICH_MEDIA_SCENE_ID = 172;
    public static final int SPLASH_VIDEO = 120;
    public static final int SUPER_QQ_SHOW = 124;
    public static final int TENCENT_VIDEO_PLAYER = 137;
    public static final int TRIBE_VIDEO = 111;
    public static final int TROOP_FILE_RICH_MEDIA_SCENE_ID = 175;
    public static final int WINK_EDITOR_OPENING_ENDING_TEMPLATE_SCENE_ID = 157;
    public static final int WINK_LOCAL_VIDEO_PREVIEW_SCENE_ID = 159;
    public static final int WINK_MEMORY_ALBUM_GUIDE_DIALOG_SCENE_ID = 158;
    public static final int WINK_ONLINE_MATERIAL_PREVIEW_SCENE_ID = 162;
    public static final int WINK_QCIRCLE_SUPER_PLAYER_SCENE_ID = 161;
    public static final int WINK_QZONE_VIDEO_PREVIEW_SCENE_ID = 160;
    public static final int WINK_SCENE_ID = 153;
    public static final int WINK_TEMPLATE_PREVIEW_ADAPTER_SCENE_ID = 163;
    public static final int WINK_TEMPLATE_PREVIEW_SCENE_ID = 156;
    public static final int WS_VIDEO = 112;
    public static final int ZPLAN_SCENE_ID = 140;
    public static final int ZPLAN_SMALL_HOME_SCENE_ID = 164;

    public SceneID() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String getSceneStr(int i3) {
        if (i3 != 119) {
            if (i3 != 121) {
                if (i3 != 125) {
                    if (i3 != 127) {
                        if (i3 != 129) {
                            if (i3 != 131) {
                                if (i3 != 153) {
                                    if (i3 != 175) {
                                        if (i3 != 138) {
                                            if (i3 != 139) {
                                                if (i3 != 142) {
                                                    if (i3 != 143) {
                                                        switch (i3) {
                                                            case 100:
                                                                return "AIO_SHORT_BUBBLE";
                                                            case 101:
                                                                return "AIO_LONG_BUBBLE";
                                                            case 102:
                                                                return "QZONE_VIDEO";
                                                            case 103:
                                                                return "QZONE_GDT_VIDEO";
                                                            case 104:
                                                                return "READINJOY_VIDEO";
                                                            case 105:
                                                                return "ALBUM_VIDEO";
                                                            case 106:
                                                                return "QQGME_VIDEO";
                                                            case 107:
                                                                return "AVGAME_VIDEO";
                                                            case 108:
                                                                return "AR_VIDEO";
                                                            case 109:
                                                                return "FILE_VIDEO";
                                                            case 110:
                                                                return "GDT_AD_VIDEO";
                                                            case 111:
                                                                return "TRIBE_VIDEO";
                                                            case 112:
                                                                return "WS_VIDEO";
                                                            default:
                                                                switch (i3) {
                                                                    case 114:
                                                                        return "MINIAPP_VIDEO";
                                                                    case 115:
                                                                        return "QQ_RTC_VIDEO";
                                                                    case 116:
                                                                        return "AIO_QQFLOATING";
                                                                    case 117:
                                                                        return "QQ_HEALTH_CENTER";
                                                                    default:
                                                                        switch (i3) {
                                                                            case 133:
                                                                                return "GUILD_INTEREST_LABEL";
                                                                            case 134:
                                                                                return "GUILD_OPEN_TAB_VIDEO";
                                                                            case 135:
                                                                                return "GUILD_LIVE_Q_CIRCLE_LIVE_ITEM";
                                                                            case 136:
                                                                                return "RFW_COMMON_LAYER";
                                                                            default:
                                                                                switch (i3) {
                                                                                    case 156:
                                                                                        return "WINK_TEMPLATE_PREVIEW_SCENE_ID";
                                                                                    case 157:
                                                                                        return "WINK_EDITOR_OPENING_ENDING_TEMPLATE_SCENE_ID";
                                                                                    case 158:
                                                                                        return "WINK_MEMORY_ALBUM_GUIDE_DIALOG_SCENE_ID";
                                                                                    case 159:
                                                                                        return "WINK_LOCAL_VIDEO_PREVIEW_SCENE_ID";
                                                                                    case 160:
                                                                                        return "WINK_QZONE_VIDEO_PREVIEW_SCENE_ID";
                                                                                    case 161:
                                                                                        return "WINK_QCIRCLE_SUPER_PLAYER_SCENE_ID";
                                                                                    case 162:
                                                                                        return "WINK_ONLINE_MATERIAL_PREVIEW_SCENE_ID";
                                                                                    case 163:
                                                                                        return "WINK_TEMPLATE_PREVIEW_ADAPTER_SCENE_ID";
                                                                                    default:
                                                                                        switch (i3) {
                                                                                            case 167:
                                                                                                return "QQ_STRANGER_LAYER";
                                                                                            case 168:
                                                                                                return "QQ_ROBOT_LAYER";
                                                                                            case 169:
                                                                                                return "QQ_TROOP_PREVIEW";
                                                                                            case 170:
                                                                                                return "QQ_ROBOT_OPEN_AIO";
                                                                                            case 171:
                                                                                                return "QQ_TBS_TOOL_MEDIA_PREVIEW";
                                                                                            case 172:
                                                                                                return "RICH_MEDIA_SCENE_ID";
                                                                                            default:
                                                                                                return "UNKNOW";
                                                                                        }
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                    }
                                                    return "GUILD_ONLINE_MEMBER_DIALOG";
                                                }
                                                return "GUILD_MEMBER_LIST";
                                            }
                                            return "ICGAME_SCENE_ID";
                                        }
                                        return "GUILD_THIRD_APP_LOADING";
                                    }
                                    return "TROOP_FILE_RICH_MEDIA_SCENE_ID";
                                }
                                return "WINK_SCENE_ID";
                            }
                            return "GUILD_VISITOR_CARD";
                        }
                        return "QQLIVE_SCENE_ID";
                    }
                    return "GUILD_LIVE_CHANNEL_PROGRAM_READY";
                }
                return "GUILD_LIVE_CHANNEL";
            }
            return "GUILD_DISCOVER_CARD";
        }
        return "COMIC_VIDEO";
    }
}
