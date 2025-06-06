package com.tencent.commonsdk.util.notification;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class NotificationUtil {
    static IPatchRedirector $redirector_;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface Constants {
        public static final String BLACK_ID_FILE_PATH = "push_id_file_path";
        public static final int NOTIFY_ID_ACTIVEPULL_PUSH = 269;
        public static final int NOTIFY_ID_APPCENTER_BEGIN = 378;
        public static final int NOTIFY_ID_APPCENTER_END = 477;
        public static final int NOTIFY_ID_ARK_GROUP_UP_MSG = 239;
        public static final int NOTIFY_ID_ARK_NEARBY_LIKE = 240;
        public static final int NOTIFY_ID_AUTO_STATUS = 3000530;
        public static final int NOTIFY_ID_AVGAME_PLAYING = 3000531;
        public static final int NOTIFY_ID_DATE_UNREAD = 272;
        public static final int NOTIFY_ID_DEBUG_NOTICE = 523;
        public static final int NOTIFY_ID_DINGDONG_SCHEDULE = 273;
        public static final int NOTIFY_ID_EQLOCK_QUICKLOGIN_MSG = 276;
        public static final int NOTIFY_ID_GAME_PUB_ACCOUNT_PUSH_END = 3001549;
        public static final int NOTIFY_ID_GAME_PUB_ACCOUNT_PUSH_START = 3000549;
        public static final int NOTIFY_ID_GENERAL = 275;
        public static final int NOTIFY_ID_GLASS_AUDIO_FROEGROUND_SERVICE = 3000539;
        public static final int NOTIFY_ID_GUILD_COMMON = 3000537;
        public static final int NOTIFY_ID_GUILD_MAINFRAME_RENDER = 3000548;
        public static final int NOTIFY_ID_GUILD_WEB_RENDER = 3000542;
        public static final int NOTIFY_ID_HASH_VALUE_END = 536870911;
        public static final int NOTIFY_ID_HASH_VALUE_START = 268435456;
        public static final int NOTIFY_ID_IPADONLINE_MSG = 263;
        public static final int NOTIFY_ID_KANDIAN_LIKE = 526;
        public static final int NOTIFY_ID_LBS_FRIEND_UNREAD = 268;
        public static final int NOTIFY_ID_LIMIT_CHAT_UNREAD = 266;
        public static final int NOTIFY_ID_LOCSHARING = 525;
        public static final int NOTIFY_ID_MATCH_FRIEND_VOICE_CHAT = 3000538;
        public static final int NOTIFY_ID_MAX = 3001549;
        public static final int NOTIFY_ID_MINIBOX_PUSH = 3000540;
        public static final int NOTIFY_ID_MODULE_PUSH_END = 3000528;
        public static final int NOTIFY_ID_MODULE_PUSH_START = 528;
        public static final int NOTIFY_ID_MSF_PUSH_AVMSG = 479;
        public static final int NOTIFY_ID_MSF_PUSH_DEVLOCK_QUICKLOGIN_MSG = 480;
        public static final int NOTIFY_ID_MSF_PUSH_OFFLINE = 478;
        public static final int NOTIFY_ID_MSF_PUSH_QQWIFI = 481;
        public static final int NOTIFY_ID_MSGBACKUP_NOTICE = 524;
        public static final int NOTIFY_ID_NBP_PRO_LITE_ACTION_PUSH = 3000546;
        public static final int NOTIFY_ID_NEW_LOCAL_PHOTO = 245;
        public static final int NOTIFY_ID_PATHTRACE = 237;
        public static final int NOTIFY_ID_PCONLINE_MSG = 264;
        public static final int NOTIFY_ID_PCPAY_PUSH = 238;
        public static final int NOTIFY_ID_PHONEONLINE_MSG = 3000541;
        public static final int NOTIFY_ID_PUSH_NOTICE = 277;
        public static final int NOTIFY_ID_PUSH_NOTICE_END = 511;
        public static final int NOTIFY_ID_PUSH_NOTICE_START = 482;
        public static final int NOTIFY_ID_PUSH_SCHEMA = 243;
        public static final int NOTIFY_ID_PUSH_SPECIAL = 244;
        public static final int NOTIFY_ID_QAV = 235;
        public static final int NOTIFY_ID_QCIRCIE_LIKE = 3000533;
        public static final int NOTIFY_ID_QCIRCLE_COM = 3000532;
        public static final int NOTIFY_ID_QCIRCLE_COMMEN = 3000536;
        public static final int NOTIFY_ID_QCIRCLE_PUSH = 3000535;
        public static final int NOTIFY_ID_QCIRCLE_RECOMMEND = 3000543;
        public static final int NOTIFY_ID_QCIRCLE_SECRET = 3000534;
        public static final int NOTIFY_ID_QQGAME_MSG = 527;
        public static final int NOTIFY_ID_QQREADER_DOWNLOAD = 234;
        public static final int NOTIFY_ID_QQSTRANGER_LITE_ACTION_PUSH = 3000544;
        public static final int NOTIFY_ID_QZONE_SPECIAL2 = 242;
        public static final int NOTIFY_ID_SEPARATE_SESSION_END = 522;
        public static final int NOTIFY_ID_SEPARATE_SESSION_START = 512;
        public static final int NOTIFY_ID_STORY_GAME_PK = 261;
        public static final int NOTIFY_ID_STORY_UNREAD_ANSWER_MY_GRADE = 258;
        public static final int NOTIFY_ID_STORY_UNREAD_ANSWER_MY_VOTE = 256;
        public static final int NOTIFY_ID_STORY_UNREAD_ANSWER_OTHER_GRADE = 259;
        public static final int NOTIFY_ID_STORY_UNREAD_ANSWER_OTHER_VOTE = 257;
        public static final int NOTIFY_ID_STORY_UNREAD_AT_FRIEND = 248;
        public static final int NOTIFY_ID_STORY_UNREAD_BIG_V = 253;
        public static final int NOTIFY_ID_STORY_UNREAD_CAPTURE_TOGETHER = 260;
        public static final int NOTIFY_ID_STORY_UNREAD_DISCOVERY = 251;
        public static final int NOTIFY_ID_STORY_UNREAD_INDEX = 249;
        public static final int NOTIFY_ID_STORY_UNREAD_NEW_STORY = 247;
        public static final int NOTIFY_ID_STORY_UNREAD_PGC = 254;
        public static final int NOTIFY_ID_STORY_UNREAD_RECOMMENT = 246;
        public static final int NOTIFY_ID_STORY_UNREAD_TAKE_VIDEO = 252;
        public static final int NOTIFY_ID_STORY_UNREAD_TOPIC = 250;
        public static final int NOTIFY_ID_STORY_UNREAD_URL = 255;
        public static final int NOTIFY_ID_TROOP_NOTIFICATION_PUSH = 3000547;
        public static final int NOTIFY_ID_UNIFORM_DOWNLOAD_BEGIN = 278;
        public static final int NOTIFY_ID_UNIFORM_DOWNLOAD_END = 377;
        public static final int NOTIFY_ID_UNLOCK_PC_PUSH = 3000545;
        public static final int NOTIFY_ID_UNREAD_AV = 236;
        public static final int NOTIFY_ID_UNREAD_PA = 267;
        public static final int NOTIFY_ID_UNREAD_QC = 241;
        public static final int NOTIFY_ID_UNREAD_QQ = 265;
        public static final int NOTIFY_ID_UNREAD_SEC_MSG = 274;
        public static final int NOTIFY_ID_UPCOMING_MSG = 3000529;
        public static final int NOTIFY_ID_UPGRADE_TABLE = 262;
        public static final int NOTIFY_ID_VIPCOMIC_DOWNLOADING = 232;
        public static final int NOTIFY_ID_VIPCOMIC_PAUSE = 233;
        public static final int NOTIFY_ID_XINGQU_BULUO = 271;
    }

    public NotificationUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
