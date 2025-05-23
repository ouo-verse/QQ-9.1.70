package com.tencent.mobileqq.app;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public interface MessageHandlerConstants {
    public static final String KEY_FROM_PUSH_NOTIFY = "fromPushNotify";
    public static final int NOTIFY_TYPE_APPROVALTMP_SEND_ERROR_RSP = 3014;
    public static final int NOTIFY_TYPE_BOX_UNREAD_NUM_REFRESH = 8023;
    public static final int NOTIFY_TYPE_BUDDY_MSG_SEND_ERROR_RSP = 3001;
    public static final int NOTIFY_TYPE_BUSINESS_CRM_SEND_ERROR_RSP = 8010;
    public static final int NOTIFY_TYPE_C2C_ONLINEFILE = 5012;
    public static final int NOTIFY_TYPE_CIRCLE_GROUP_SEND_ERROR_RSP = 6012;
    public static final int NOTIFY_TYPE_CMGAME_SEND_ERROR_RSP = 3022;
    public static final int NOTIFY_TYPE_CONFESS_TMP = 8035;
    public static final int NOTIFY_TYPE_CONTACT_MSG_SEND_ERROR_RSP = 8005;
    public static final int NOTIFY_TYPE_DANCE_MACHINE = 8034;
    public static final int NOTIFY_TYPE_DATE_SEND_ERROR_RSP = 8012;
    public static final int NOTIFY_TYPE_DELETE_ALL_SYSTEMMSG = 8039;
    public static final int NOTIFY_TYPE_DELETE_SUSPICIOUS_MSG = 8051;
    public static final int NOTIFY_TYPE_DELETE_SYSTEM_MSG = 8052;
    public static final int NOTIFY_TYPE_DISCUSSION_MSG_SEND_ERROR_RSP = 3008;
    public static final int NOTIFY_TYPE_DISCUSS_PRIVATE_PUSH = 8001;
    public static final int NOTIFY_TYPE_DISCUSS_TEMP_MSG_SEND_ERROR_RSP = 8002;
    public static final int NOTIFY_TYPE_EMOTICON_RANDOM = 6017;
    public static final int NOTIFY_TYPE_FRIEND_VALIDATION_SEND_ERROR_RSP = 6013;
    public static final int NOTIFY_TYPE_GAME_BUDDY = 8044;
    public static final int NOTIFY_TYPE_GET_ALL_PROXY_TROOPMSG = 4013;
    public static final int NOTIFY_TYPE_GET_DEL_SYSTEMMSG_ERROR = 4015;
    public static final int NOTIFY_TYPE_GET_DEL_SYSTEMMSG_FIN = 4014;
    public static final int NOTIFY_TYPE_GET_DISCUSSION_MSG_FIN = 4002;
    public static final int NOTIFY_TYPE_GET_GROUP_FIRSTMSG_FIN = 4017;
    public static final int NOTIFY_TYPE_GET_MSG_FIN = 4001;
    public static final int NOTIFY_TYPE_GET_OFFLINE_FINISH = 6005;
    public static final int NOTIFY_TYPE_GET_OFFLINE_START = 6006;
    public static final int NOTIFY_TYPE_GET_PUBACCOUNT_FIN = 4016;
    public static final int NOTIFY_TYPE_GET_SYSTEMMSG_FIN = 4005;
    public static final int NOTIFY_TYPE_GET_SYSTEMMSG_FIN_ERROR = 4006;
    public static final int NOTIFY_TYPE_GET_TROOP_MSG_FIN = 4003;
    public static final int NOTIFY_TYPE_GROUP_TMP_MSG_SEND_ERROR_RSP = 6000;
    public static final int NOTIFY_TYPE_HIBOOM_AUTH = 8036;
    public static final int NOTIFY_TYPE_HOTCHAT_TOPIC_SEND_ERROR_RSP = 3013;
    public static final int NOTIFY_TYPE_IPAD_ONLINES_STATUS = 6014;
    public static final int NOTIFY_TYPE_KAN_DIAN_RESP = 8048;
    public static final int NOTIFY_TYPE_LBS_FRIEND_MSG_SEND_ERROR_RSP = 6010;
    public static final int NOTIFY_TYPE_LIMIT_CHAT_ERROR_RSP = 8037;
    public static final int NOTIFY_TYPE_MAC_ONLINES_STATUS = 8033;
    public static final int NOTIFY_TYPE_MATCH_CAMPUS_CHAT_ERROR_RSP = 8041;
    public static final int NOTIFY_TYPE_MATCH_CHAT_ERROR_RSP = 8040;
    public static final int NOTIFY_TYPE_MATCH_FRIEND_CHAT_ERROR_RSP = 8049;
    public static final int NOTIFY_TYPE_MOVIE_TICKET_SEND_ERROR_RSP = 8032;
    public static final int NOTIFY_TYPE_MSGFORWARD_WX = 8031;
    public static final int NOTIFY_TYPE_MSG_REVOKE_RSP = 8016;
    public static final int NOTIFY_TYPE_MSG_START_SENDING_UI = 8022;
    public static final int NOTIFY_TYPE_NEARBY_ASSISTANT_SEND_ERROR_RSP = 8014;
    public static final int NOTIFY_TYPE_NEW_MESSAGE_ADDED = 8020;
    public static final int NOTIFY_TYPE_NEW_REGISTER_PROXY_FIN = 4018;
    public static final int NOTIFY_TYPE_OPEN_TROOP_TMP_MSG_SEND_ERROR_RSP = 6009;
    public static final int NOTIFY_TYPE_PC_ACTIVE_NOTIFY = 8013;
    public static final int NOTIFY_TYPE_PC_ONLINES_STATUS = 6007;
    public static final int NOTIFY_TYPE_PC_QQ_SEARCH_MSG_SEND_ERROR_RSP = 8008;
    public static final int NOTIFY_TYPE_PUBLICPLA_MSG_SEND_ERROR_RSP = 7001;
    public static final int NOTIFY_TYPE_PUSH_UPDATE_LOGINDEV_STATUS = 6016;
    public static final int NOTIFY_TYPE_QQGAME_MSG_RSP = 8042;
    public static final int NOTIFY_TYPE_QQ_AUDIO_ROOM_RESP = 8045;
    public static final int NOTIFY_TYPE_QQ_CIRCLE_RESP = 8043;
    public static final int NOTIFY_TYPE_RECEIPT_ERROR_RSP = 3021;
    public static final int NOTIFY_TYPE_RECEIPT_READ = 6015;
    public static final int NOTIFY_TYPE_RECENT_LIST_REFRESH = 2002;
    public static final int NOTIFY_TYPE_REFRESH_RECENT_LIST_FINISH = 6008;
    public static final int NOTIFY_TYPE_REGISTER_PROXY_FIN = 4004;
    public static final int NOTIFY_TYPE_REGISTER_PROXY_RECECVING = 6018;
    public static final int NOTIFY_TYPE_REQ_BLESS_DIRTY_TEXT_CHECK = 8018;
    public static final int NOTIFY_TYPE_REQ_BLESS_MSG = 8019;
    public static final int NOTIFY_TYPE_REQ_DELETE_BLACKLIST = 6002;
    public static final int NOTIFY_TYPE_REQ_INSERT_BLACKLIST = 6001;
    public static final int NOTIFY_TYPE_REQ_INSERT_BLACKLIST_PB = 8017;
    public static final int NOTIFY_TYPE_RICH_SEND_NOTIFY_MSG = 5006;
    public static final int NOTIFY_TYPE_ROAM_MESSAGE_SEARCH_IN_CLOUD = 8015;
    public static final int NOTIFY_TYPE_SAME_STATE_MSG_SEND_ERROR_RSP = 8006;
    public static final int NOTIFY_TYPE_SEND_BUDDY_PIC = 5001;
    public static final int NOTIFY_TYPE_SEND_GET_C2C_SIG = 5003;
    public static final int NOTIFY_TYPE_SEND_GET_SIG = 5002;
    public static final int NOTIFY_TYPE_SEND_OFFLINE_FILE = 5004;
    public static final int NOTIFY_TYPE_SEND_RESULT = 6003;
    public static final int NOTIFY_TYPE_SEND_RESULT_WITH_TRANSINFO = 8046;
    public static final int NOTIFY_TYPE_SEND_SYSTEMMSG_ACTION_ERROR = 4012;
    public static final int NOTIFY_TYPE_SEND_SYSTEMMSG_ACTION_FIN = 4011;
    public static final int NOTIFY_TYPE_SET_OFFLINE_FILE_STATE = 5005;
    public static final int NOTIFY_TYPE_SQUARE_CHAT_ERROR_RSP = 8050;
    public static final int NOTIFY_TYPE_SUBACCOUNT_GET_MSG = 8003;
    public static final int NOTIFY_TYPE_SUBACCOUNT_MSG_NUM_READED_CONFIRM = 8011;
    public static final int NOTIFY_TYPE_SUBACCOUNT_PUSH_MSG = 8004;
    public static final int NOTIFY_TYPE_SUBACCOUNT_THIRD_QQ_UNREAD_MSG_NUM = 8024;
    public static final int NOTIFY_TYPE_TRANSSERVICE_C2C_UPLOADSTREAMPTT = 3011;
    public static final int NOTIFY_TYPE_TRANSSERVICE_REQOFFFILEPACK = 3006;
    public static final int NOTIFY_TYPE_TRANSSERVICE_TEMPCHAT_DOWNLOADPIC = 3012;
    public static final int NOTIFY_TYPE_TRIBE_TMP = 8028;
    public static final int NOTIFY_TYPE_TROOP_LIST_REFRESH = 2001;
    public static final int NOTIFY_TYPE_TROOP_MSG_SEND_ERROR_RSP = 3002;
    public static final int NOTIFY_TYPE_UPDATE_SECRETFILE_STATUS = 5010;
    public static final int NOTIFY_TYPE_UPDATE_SELF_MSG_SEQ_AND_TIME = 8047;
    public static final int NOTIFY_TYPE_WATCH_ONLINE_STATUS = 8038;
    public static final int NOTIFY_TYPE_WPA_MSG_SEND_ERROR_RSP = 7000;
    public static final int PUSH_READED_NOTIFY = 6004;

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class MsgSendCostParams {
        static IPatchRedirector $redirector_;
        public String ipFamily;
        public boolean isCrossOper;
        public boolean isSentByXG;
        public boolean isWeaknet;
        public boolean isWifi;
        public String isp;
        public long mMsgNetsendToNetrecv;
        public long mMsgNotifyToReflash;
        public long mMsgNotifyUiTime;
        public String mMsgReportTag;
        public long mMsgRequestToResponse;
        public long mMsgSendToRequest;
        public int mUinType;
        public int msgType;
        public Map<String, String> telemetryParams;
        public String telemetryTracerKey;
        public String transChannel;

        public MsgSendCostParams() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.isCrossOper = false;
            this.isSentByXG = false;
            this.isWeaknet = false;
        }
    }
}
