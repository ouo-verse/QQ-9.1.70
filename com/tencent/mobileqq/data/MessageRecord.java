package com.tencent.mobileqq.data;

import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.guild.api.data.msglist.GuildMsgItem;
import com.tencent.imcore.message.an;
import com.tencent.imcore.message.s;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.message.RecordForTest;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.util.aw;
import com.tencent.qphone.base.util.QLog;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Random;
import org.json.JSONObject;

/* compiled from: P */
@uniqueConstraints(clause = ConflictClause.IGNORE, columnNames = "time,senderuin,msgData,istroop,shmsgseq,msgseq")
/* loaded from: classes10.dex */
public class MessageRecord extends Entity {
    public static final int EXTRA_ERROR_INT = -1;
    public static final int EXTRA_STREAM_PTT_FLAG = 10001;
    public static final int MIN_VERSION_CODE_SUPPORT_IMAGE_MD5_TRANS = 2;
    private static final long MSG_SEQ_CRITICAL_VAL = 100000000000000L;
    public static final int MSG_TYPE_0X7F = -2006;
    public static final int MSG_TYPE_ACTIVATE_FRIENDS = -5003;
    public static final int MSG_TYPE_ACTIVITY = -4002;
    public static final int MSG_TYPE_AIO_FOR_LOCATION_SHARE = -2076;
    public static final int MSG_TYPE_AIO_FOR_STORY_VIDEO = -2074;
    public static final int MSG_TYPE_AI_SPECIAL_GUIDE = -1052;
    public static final int MSG_TYPE_APPROVAL_GRAY_TIPS = -2041;
    public static final int MSG_TYPE_APPROVAL_MSG = -2040;
    public static final int MSG_TYPE_ARK_APP = -5008;
    public static final int MSG_TYPE_ARK_BABYQ_REPLY = -5016;
    public static final int MSG_TYPE_ARK_SDK_SHARE = -5017;
    public static final int MSG_TYPE_AUTHORIZE_FAILED = -4005;
    public static final int MSG_TYPE_AUTOREPLY = -10000;
    public static final int MSG_TYPE_BAT_PROCESS_FILE = -3013;
    public static final int MSG_TYPE_BIRTHDAY_NOTICE = -7007;
    public static final int MSG_TYPE_BIZ_DATA = -2023;
    public static final int MSG_TYPE_C2C_CHAT_FREQ_CALL_TIP = -1014;
    public static final int MSG_TYPE_C2C_KEYWORD_CALL_TIP = -1015;
    public static final int MSG_TYPE_C2C_MIXED = -30002;
    public static final int MSG_TYPE_CMGAME_TIPS = -7004;
    public static final int MSG_TYPE_COLOR_RING_TIPS = -3012;
    public static final int MSG_TYPE_COMMON_HOBBY_FOR_AIO_SHOW = -2023;
    public static final int MSG_TYPE_CONFESS_CARD = -2066;
    public static final int MSG_TYPE_CONFESS_NEWS = -2065;
    public static final int MSG_TYPE_CONFIGURABLE_GRAY_TIPS = 2024;
    public static final int MSG_TYPE_CONFIGURABLE_TAB_VISIBLE_GRAY_TIPS = -2042;
    public static final int MSG_TYPE_DAREN_ASSISTANT = -2068;
    public static final int MSG_TYPE_DATE_FEED = -1042;
    public static final int MSG_TYPE_DEVICE_CLOSEGROUPCHAT = -4506;
    public static final int MSG_TYPE_DEVICE_DISMISSBIND = -4507;
    public static final int MSG_TYPE_DEVICE_FILE = -4500;
    public static final int MSG_TYPE_DEVICE_LITTLE_VIDEO = -4509;
    public static final int MSG_TYPE_DEVICE_OPENGROUPCHAT = -4505;
    public static final int MSG_TYPE_DEVICE_PTT = -4501;
    public static final int MSG_TYPE_DEVICE_SHORT_VIDEO = -4503;
    public static final int MSG_TYPE_DEVICE_SINGLESTRUCT = -4502;
    public static final int MSG_TYPE_DEVICE_TEXT = -4508;
    public static final int MSG_TYPE_DINGDONG_SCHEDULE_MSG = -5010;
    public static final int MSG_TYPE_DING_DONG_GRAY_TIPS = -2034;
    public static final int MSG_TYPE_DISCUSS_PUSH = -1004;
    public static final int MSG_TYPE_DISCUSS_TO_TROOP_TIP = -7091;
    public static final int MSG_TYPE_DISCUSS_UPGRADE_TO_GROUP_TIPS = -1050;
    public static final int MSG_TYPE_DISC_CREATE_CALL_TIP = -1016;
    public static final int MSG_TYPE_DISC_PTT_FREQ_CALL_TIP = -1017;
    public static final int MSG_TYPE_ENTER_TROOP = -4003;
    public static final int MSG_TYPE_FAILED_MSG = -2013;
    public static final int MSG_TYPE_FAKE_EMOTION = -7008;
    public static final int MSG_TYPE_FILE_RECEIPT = -3008;
    public static final int MSG_TYPE_FLASH_CHAT = -5013;
    public static final int MSG_TYPE_FOLD_MSG_GRAY_TIPS = -5011;
    public static final int MSG_TYPE_FORWARD_IMAGE = -20000;
    public static final int MSG_TYPE_FRIEND_SYSTEM_STRUCT_MSG = -2050;
    public static final int MSG_TYPE_FU_DAI = -2072;
    public static final int MSG_TYPE_GAME_INVITE = -3004;
    public static final int MSG_TYPE_GAME_PARTY_GRAY_TIPS = -2049;
    public static final int MSG_TYPE_GAME_SHARE = -3005;
    public static final int MSG_TYPE_GRAY_DATALINE_TIM_TIPS = -5041;
    public static final int MSG_TYPE_GRAY_TIPS = -5000;
    public static final int MSG_TYPE_GRAY_TIPS_TAB_VISIBLE = -5001;
    public static final int MSG_TYPE_GROUPDISC_FILE = -2014;
    public static final int MSG_TYPE_GUILD_APP_CHANNEL = -4051;
    public static final int MSG_TYPE_GUILD_GIFT = -5009;
    public static final int MSG_TYPE_GUILD_GRAYTIP_NOT_ROAM = -4100;
    public static final int MSG_TYPE_GUILD_LIVE_GIFT = -4070;
    public static final int MSG_TYPE_GUILD_MARK_DOWN = -4052;
    public static final int MSG_TYPE_GUILD_MSG_NOTIFY_SETTING_TIPS = -4092;
    public static final int MSG_TYPE_GUILD_REVOKE_GRAY_TIP = -4050;
    public static final int MSG_TYPE_GUILD_ROBOT_BLACK_GRAY = -4089;
    public static final int MSG_TYPE_GUILD_ROBOT_DIRECT_MSG_LIMIT_TIPS = -4093;
    public static final int MSG_TYPE_GUILD_ROBOT_WELCOME_TIPS = -4090;
    public static final int MSG_TYPE_GUILD_SUBSCRIBE_CHANNEL_TIPS = -4091;
    public static final int MSG_TYPE_GUILD_WELCOME_TIPS = -4028;
    public static final int MSG_TYPE_GUILD_YOLO_GAME_RESULT = -4029;
    public static final int MSG_TYPE_GUILD_YOLO_SYSTEM = -4030;
    public static final int MSG_TYPE_GUILD_YOLO_TEAM = -4031;
    public static final int MSG_TYPE_HOMEWORK_PRAISE = -2043;
    public static final int MSG_TYPE_HONGBAO_KEYWORDS_TIPS = -1045;
    public static final int MSG_TYPE_HOT_CHAT_TO_SEE_TIP = 1018;
    public static final int MSG_TYPE_HR_INFO = -7003;
    public static final int MSG_TYPE_INCOMPATIBLE_GRAY_TIPS = -5002;
    public static final int MSG_TYPE_INTERACT_AND_FOLLOW = -2055;
    public static final int MSG_TYPE_LIFEONLINEACCOUNT = -5004;
    public static final int MSG_TYPE_LIGHTALK_MSG = -2026;
    public static final int MSG_TYPE_LIMIT_CHAT_CONFIRM = -7005;
    public static final int MSG_TYPE_LIMIT_CHAT_TOPIC = -4023;
    public static final int MSG_TYPE_LIMIT_CHAT_TOPIC_RECEIVER = -4024;
    public static final int MSG_TYPE_LOCAL_COMMON = -4000;
    public static final int MSG_TYPE_LOCAL_URL = -4001;
    public static final int MSG_TYPE_LONG_MIX = -1036;
    public static final int MSG_TYPE_LONG_TEXT = -1037;
    public static final int MSG_TYPE_MASTER_UIN_NAVIGATION = -2064;
    public static final int MSG_TYPE_MEDAL_NEWS = -2062;
    public static final int MSG_TYPE_MEDIA_EMO = -2001;
    public static final int MSG_TYPE_MEDIA_FILE = -2005;
    public static final int MSG_TYPE_MEDIA_LIGHTVIDEO = -2071;
    public static final int MSG_TYPE_MEDIA_MARKFACE = -2007;
    public static final int MSG_TYPE_MEDIA_MULTI09 = -2003;
    public static final int MSG_TYPE_MEDIA_MULTI513 = -2004;
    public static final int MSG_TYPE_MEDIA_PIC = -2000;
    public static final int MSG_TYPE_MEDIA_PTT = -2002;
    public static final int MSG_TYPE_MEDIA_SECRETFILE = -2008;
    public static final int MSG_TYPE_MEDIA_SHORTVIDEO = -2022;
    public static final int MSG_TYPE_MEDIA_VIDEO = -2009;
    public static final int MSG_TYPE_MEETING_NOTIFY = -5006;
    public static final int MSG_TYPE_MIX = -1035;
    public static final int MSG_TYPE_MULTI_TEXT_VIDEO = -4008;
    public static final int MSG_TYPE_MULTI_VIDEO = -2016;
    public static final int MSG_TYPE_MY_ENTER_TROOP = -4004;
    public static final int MSG_TYPE_NEARBY_DATING_SAFETY_TIP = -1028;
    public static final int MSG_TYPE_NEARBY_DATING_TIP = -1024;
    public static final int MSG_TYPE_NEARBY_FLOWER_TIP = -2037;
    public static final int MSG_TYPE_NEARBY_LIVE_TIP = -2053;
    public static final int MSG_TYPE_NEARBY_MARKET = -2027;
    public static final int MSG_TYPE_NEARBY_RECOMMENDER = -4011;
    public static final int MSG_TYPE_NEW_FRIEND_TIPS = -1013;
    public static final int MSG_TYPE_NEW_FRIEND_TIPS_GAME_ADDEE = -1019;
    public static final int MSG_TYPE_NEW_FRIEND_TIPS_GAME_ADDER = -1018;
    public static final int MSG_TYPE_NULL = -999;
    public static final int MSG_TYPE_ONLINE_FILE_REQ = -3007;
    public static final int MSG_TYPE_OPERATE_TIPS = -1041;
    public static final int MSG_TYPE_PA_PHONE_MSG_TIPS = -1048;
    public static final int MSG_TYPE_PC_PUSH = -3001;
    public static final int MSG_TYPE_PIC_AND_TEXT_MIXED = -3000;
    public static final int MSG_TYPE_PIC_QSECRETARY = -1032;
    public static final int MSG_TYPE_PL_NEWS = -2060;
    public static final int MSG_TYPE_POKE_EMO_MSG = -5018;
    public static final int MSG_TYPE_POKE_MSG = -5012;
    public static final int MSG_TYPE_PSTN_CALL = -2046;
    public static final int MSG_TYPE_PTT_QSECRETARY = -1031;
    public static final int MSG_TYPE_PUBLIC_ACCOUNT = -3006;
    public static final int MSG_TYPE_PUSH_REMINDER = -7090;
    public static final int MSG_TYPE_QCIRCLE_NEWEST_FEED = -2077;
    public static final int MSG_TYPE_QLINK_AP_CREATE_SUC_TIPS = -3011;
    public static final int MSG_TYPE_QLINK_FILE_TIPS = -3009;
    public static final int MSG_TYPE_QLINK_SEND_FILE_TIPS = -3010;
    public static final int MSG_TYPE_QQSTORY = -2051;
    public static final int MSG_TYPE_QQSTORY_COMMENT = -2052;
    public static final int MSG_TYPE_QQSTORY_LATEST_FEED = -2061;
    public static final int MSG_TYPE_QQWALLET_MSG = -2025;
    public static final int MSG_TYPE_QQWALLET_TIPS = -2029;
    public static final int MSG_TYPE_QZONE_NEWEST_FEED = -2015;
    public static final int MSG_TYPE_RECOMMAND_TIPS = -5007;
    public static final int MSG_TYPE_RED_PACKET_TIPS = -1044;
    public static final int MSG_TYPE_RENEWAL_TAIL_TIP = -4020;
    public static final int MSG_TYPE_REPLY_TEXT = -1049;
    public static final int MSG_TYPE_REVOKE_GRAY_TIPS = -2031;
    public static final int MSG_TYPE_SCRIBBLE_MSG = -7001;
    public static final int MSG_TYPE_SENSITIVE_MSG_MASK_TIPS = -1046;
    public static final int MSG_TYPE_SHAKE_WINDOW = -2020;
    public static final int MSG_TYPE_SHARE_HOT_CHAT_GRAY_TIPS = -2033;
    public static final int MSG_TYPE_SHARE_LBS_PUSH = -4010;
    public static final int MSG_TYPE_SHIELD_MSG = -2012;
    public static final int MSG_TYPE_SINGLE_WAY_FRIEND_ADD_ALLOW_ALL_MSG = -7006;
    public static final int MSG_TYPE_SINGLE_WAY_FRIEND_MSG = -2019;
    public static final int MSG_TYPE_SOUGOU_INPUT_TIPS = -1043;
    public static final int MSG_TYPE_SPECIALCARE_TIPS = -5005;
    public static final int MSG_TYPE_SPLIT_LINE_GRAY_TIPS = -4012;
    public static final int MSG_TYPE_STICKER_MSG = -2058;
    public static final int MSG_TYPE_STRUCT_LONG_TEXT = -1051;
    public static final int MSG_TYPE_STRUCT_MSG = -2011;
    public static final int MSG_TYPE_STRUCT_TROOP_NOTIFICATION = -2021;
    public static final int MSG_TYPE_SYSTEM_STRUCT_MSG = -2018;
    public static final int MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS = -2063;
    public static final int MSG_TYPE_TEAM_WORK_FILE_IMPORT_SUCCESS_TIPS_DL = -2073;
    public static final int MSG_TYPE_TEXT = -1000;
    public static final int MSG_TYPE_TEXT_FRIEND_FEED = -1034;
    public static final int MSG_TYPE_TEXT_GROUPMAN_ACCEPT = -1021;
    public static final int MSG_TYPE_TEXT_GROUPMAN_ADDREQUEST = -1020;
    public static final int MSG_TYPE_TEXT_GROUPMAN_INVITE = -1023;
    public static final int MSG_TYPE_TEXT_GROUPMAN_REFUSE = -1022;
    public static final int MSG_TYPE_TEXT_GROUP_CREATED = -1047;
    public static final int MSG_TYPE_TEXT_QSECRETARY = -1003;
    public static final int MSG_TYPE_TEXT_RECOMMEND_CIRCLE = -1033;
    public static final int MSG_TYPE_TEXT_RECOMMEND_CONTACT = -1030;
    public static final int MSG_TYPE_TEXT_RECOMMEND_TROOP = -1039;
    public static final int MSG_TYPE_TEXT_RECOMMEND_TROOP_BUSINESS = -1040;
    public static final int MSG_TYPE_TEXT_SAFE = -1002;
    public static final int MSG_TYPE_TEXT_SYSTEM_ACCEPT = -1008;
    public static final int MSG_TYPE_TEXT_SYSTEM_ACCEPTANDADD = -1007;
    public static final int MSG_TYPE_TEXT_SYSTEM_ADDREQUEST = -1006;
    public static final int MSG_TYPE_TEXT_SYSTEM_ADDSUCCESS = -1010;
    public static final int MSG_TYPE_TEXT_SYSTEM_OLD_VERSION_ADDREQUEST = -1011;
    public static final int MSG_TYPE_TEXT_SYSTEM_REFUSE = -1009;
    public static final int MSG_TYPE_TEXT_VIDEO = -1001;
    public static final int MSG_TYPE_TIM_AIOMSG_TIPS = -3016;
    public static final int MSG_TYPE_TIM_DOUFU_GUIDE = -3015;
    public static final int MSG_TYPE_TIM_GUIDE = -3014;
    public static final int MSG_TYPE_TRIBE_SHORT_VIDEO = -7002;
    public static final int MSG_TYPE_TROOP_CONFESS = -2067;
    public static final int MSG_TYPE_TROOP_DELIVER_GIFT = -2035;
    public static final int MSG_TYPE_TROOP_DELIVER_GIFT_OBJ = -2038;
    public static final int MSG_TYPE_TROOP_EFFECT_PIC = -5015;
    public static final int MSG_TYPE_TROOP_FEE = -2036;
    public static final int MSG_TYPE_TROOP_GAP_GRAY_TIPS = -2030;
    public static final int MSG_TYPE_TROOP_MIXED = -30003;
    public static final int MSG_TYPE_TROOP_NEWER_POBING = -2059;
    public static final int MSG_TYPE_TROOP_OBJ_MSG = -2017;
    public static final int MSG_TYPE_TROOP_REWARD = -2048;
    public static final int MSG_TYPE_TROOP_SIGN = -2054;
    public static final int MSG_TYPE_TROOP_STAR_LEAGUE = -2069;
    public static final int MSG_TYPE_TROOP_STORY = -2057;
    public static final int MSG_TYPE_TROOP_TIPS_ADD_MEMBER = -1012;
    public static final int MSG_TYPE_TROOP_UNREAD_TIPS = -4009;
    public static final int MSG_TYPE_TROOP_WANT_GIFT_MSG = -2056;
    public static final int MSG_TYPE_UNCOMMONLY_USED_CONTACTS = -1026;
    public static final int MSG_TYPE_UNCOMMONLY_USED_CONTACTS_CANCEL_SET = -1027;
    public static final int MSG_TYPE_UNITE_GRAY_HISTORY_INVI = -5021;
    public static final int MSG_TYPE_UNITE_GRAY_NORMAL = -5040;
    public static final int MSG_TYPE_UNITE_GRAY_TAB_INVI = -5020;
    public static final int MSG_TYPE_UNITE_TAB_DB_INVI = -5022;
    public static final int MSG_TYPE_UNITE_TAB_HISTORI_INVI = -5023;
    public static final int MSG_TYPE_VAS_APOLLO = -2039;
    public static final int MSG_TYPE_VIDEO_EMOTICON = -2079;
    public static final int MSG_TYPE_VIP_AIO_SEND_TIPS = -4022;
    public static final int MSG_TYPE_VIP_DONATE = -2047;
    public static final int MSG_TYPE_VIP_KEYWORD = -4021;
    public static final int MSG_TYPE_VIP_VIDEO = -2045;
    public static final int MSG_TYPE_YANZHI = -2070;
    public static final int MSG_TYPE_ZPLAN = -2078;
    public static final int MSG_VERSION_CODE = 3;
    public static final int MSG_VERSION_CODE_FOR_PICPTT = 3;
    public static final String QUERY_NEW_TABLE_FIELDS = "_id, extraflag, frienduin, isread, issend, istroop, NULL as msg, msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, versionCode, longMsgIndex, longMsgId, longMsgCount, isValid, msgUid, vipBubbleID, uniseq, sendFailCode, extStr, extInt, extLong ";
    public static final String QUERY_OLD_TABLE_FIELDS = "_id, extraflag, frienduin, isread, issend, istroop, msg, NULL as msgData, msgId, msgseq, msgtype, selfuin, senderuin, shmsgseq, time, 0 as versionCode, NULL as longMsgIndex, NULL as longMsgId, NULL as longMsgCount, 1 as isValid, NULL as msgUid, NULL as vipBubbleID, 0 as uniseq, 0 as sendFailCode, NULL as extStr, 0 as extInt, 0 as extLong";
    public static final int SEND_FAIL_CODE_DEFAULT = 0;
    public static final int SEND_FAIL_CODE_GOLDMSG_ERROR = -900;
    private static final String TAG = "MessageRecord";

    @RecordForTest
    @notColumn
    public ArrayList<AtTroopMemberInfo> atInfoList;

    @notColumn
    public ArrayList<AtTroopMemberInfo> atInfoTempList;
    public int extInt;
    public int extLong;

    @notColumn
    public Object extObj;
    public String extStr;
    public int extraflag;
    public String frienduin;
    public boolean isread;
    public int issend;
    public int istroop;
    public int longMsgCount;
    public int longMsgId;
    public int longMsgIndex;
    public JSONObject mExJsonObject;

    @notColumn
    public int mIsShowQidianTips;

    @notColumn
    public com.tencent.mobileqq.troop.data.c mMessageInfo;

    @notColumn
    public long mQidianMasterUin;

    @notColumn
    public int mQidianTaskId;

    @notColumn
    public String mQidianTipText;

    @notColumn
    public int mRobotFlag;

    /* renamed from: msg, reason: collision with root package name */
    @notColumn
    public String f203106msg;

    @notColumn
    public String msg2;

    @notColumn
    public long msgBackupMsgRandom;

    @notColumn
    public long msgBackupMsgSeq;
    public byte[] msgData;

    @Deprecated
    public long msgId;
    public long msgUid;
    public long msgseq;
    public int msgtype;
    public String selfuin;
    public int sendFailCode;
    public String senderuin;
    public long shmsgseq;

    @notColumn
    public Object stickerInfo;

    @notColumn
    public String telemetryTracerKey;
    public long time;
    public long uniseq;

    @notColumn
    public int vipBubbleDiyTextId;
    public long vipBubbleID;

    @notColumn
    public int vipSubBubbleId;
    public static final String[] QUERY_OLD_TABLE_FIELDS_ARRAY = {"_id", AppConstants.Key.COLUMN_EXTRA_FLAG, "frienduin", AppConstants.Key.COLUMN_IS_READ, AppConstants.Key.COLUMN_IS_SEND, AppConstants.Key.COLUMN_IS_TROOP, "msg", "msgId", AppConstants.Key.COLUMN_MSG_SEQ, AppConstants.Key.COLUMN_MSG_TYPE, "selfuin", "senderuin", AppConstants.Key.COLUMN_SHMSG_SEQ, "time"};
    public static Callback sCallback = new MessageRecordDummyCallback();

    @notColumn
    public boolean isReplySource = false;

    @notColumn
    public boolean isMultiMsg = false;

    @notColumn
    public boolean isBlessMsg = false;

    @notColumn
    public boolean needUpdateMsgTag = true;

    @notColumn
    public boolean isCheckNeedShowInListTypeMsg = false;

    @notColumn
    public boolean needNeedShowInList = false;

    @notColumn
    public boolean isReMultiMsg = false;
    public boolean isValid = true;
    public int versionCode = 3;

    @notColumn
    public Object advertisementItem = null;

    @notColumn
    public boolean isOpenTroopMessage = false;

    @notColumn
    public boolean stickerHidden = false;

    @notColumn
    public boolean isFolded = true;

    @notColumn
    public boolean updateMsgAnimation = false;

    @notColumn
    public boolean isGlassReaded = false;

    @notColumn
    public boolean fromRegisterProxy = false;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public interface Callback {
        String getTableName(MessageRecord messageRecord);

        boolean isSend(MessageRecord messageRecord);
    }

    static {
        s.a();
    }

    public MessageRecord() {
        createMessageUniseq();
    }

    public static void copyMessageRecordBaseField(MessageRecord messageRecord, MessageRecord messageRecord2) {
        messageRecord.selfuin = messageRecord2.selfuin;
        messageRecord.senderuin = messageRecord2.senderuin;
        messageRecord.msgtype = messageRecord2.msgtype;
        messageRecord.f203106msg = messageRecord2.f203106msg;
        messageRecord.time = messageRecord2.time;
        messageRecord.shmsgseq = messageRecord2.shmsgseq;
        messageRecord.msgseq = messageRecord2.msgseq;
        messageRecord.isread = messageRecord2.isread;
        messageRecord.issend = messageRecord2.issend;
        messageRecord.frienduin = messageRecord2.frienduin;
        messageRecord.istroop = messageRecord2.istroop;
        messageRecord.extraflag = messageRecord2.extraflag;
        messageRecord.sendFailCode = messageRecord2.sendFailCode;
        messageRecord.msgId = messageRecord2.msgId;
        messageRecord.msgUid = messageRecord2.msgUid;
        messageRecord.uniseq = messageRecord2.uniseq;
        messageRecord.extInt = messageRecord2.extInt;
        messageRecord.extLong = messageRecord2.extLong;
        messageRecord.extStr = messageRecord2.extStr;
        messageRecord.mExJsonObject = messageRecord2.mExJsonObject;
        messageRecord.isValid = messageRecord2.isValid;
        messageRecord.versionCode = messageRecord2.versionCode;
        messageRecord.vipBubbleID = messageRecord2.vipBubbleID;
        messageRecord.longMsgCount = messageRecord2.longMsgCount;
        messageRecord.longMsgId = messageRecord2.longMsgId;
        messageRecord.longMsgIndex = messageRecord2.longMsgIndex;
        messageRecord.msgData = messageRecord2.msgData;
        messageRecord.vipBubbleDiyTextId = messageRecord2.vipBubbleDiyTextId;
        messageRecord.vipSubBubbleId = messageRecord2.vipSubBubbleId;
    }

    public static void copyMessageRecordStatusField(MessageRecord messageRecord, MessageRecord messageRecord2) {
        messageRecord.time = messageRecord2.time;
        messageRecord.shmsgseq = messageRecord2.shmsgseq;
        messageRecord.msgseq = messageRecord2.msgseq;
        messageRecord.isread = messageRecord2.isread;
        messageRecord.issend = messageRecord2.issend;
        messageRecord.extraflag = messageRecord2.extraflag;
        messageRecord.sendFailCode = messageRecord2.sendFailCode;
        messageRecord.msgUid = messageRecord2.msgUid;
        messageRecord.uniseq = messageRecord2.uniseq;
        messageRecord.extInt = messageRecord2.extInt;
        messageRecord.extLong = messageRecord2.extLong;
        messageRecord.extStr = messageRecord2.extStr;
        messageRecord.isValid = messageRecord2.isValid;
        messageRecord.versionCode = messageRecord2.versionCode;
        messageRecord.vipBubbleID = messageRecord2.vipBubbleID;
        messageRecord.longMsgCount = messageRecord2.longMsgCount;
        messageRecord.longMsgId = messageRecord2.longMsgId;
        messageRecord.longMsgIndex = messageRecord2.longMsgIndex;
        messageRecord.vipBubbleDiyTextId = messageRecord2.vipBubbleDiyTextId;
        messageRecord.vipSubBubbleId = messageRecord2.vipSubBubbleId;
    }

    public static long getLogicMsgID(long j3, int i3) {
        if (i3 > 0) {
            return j3;
        }
        return (-100) - j3;
    }

    public static String getOldTableName(String str, int i3) {
        String str2;
        if (i3 != 1) {
            if (i3 != 1006) {
                if (i3 != 3000) {
                    str2 = GuildMsgItem.NICK_FRIEND;
                } else {
                    str2 = "discusssion";
                }
            } else {
                str2 = "contact";
            }
        } else {
            str2 = "troop";
        }
        return "mr_" + str2 + "_" + getUinMD5(str);
    }

    public static int getTypeByTableName(String str) {
        if (str.startsWith("mr_troop")) {
            return 1;
        }
        if (str.startsWith("mr_discusssion")) {
            return 3000;
        }
        if (str.startsWith("mr_contact")) {
            return 1006;
        }
        if (str.startsWith("mr_devicemsg")) {
            return 9501;
        }
        if (str.startsWith("mr_data_line_ipad")) {
            return 6003;
        }
        if (str.startsWith("mr_data_line_phone")) {
            return 6005;
        }
        if (str.startsWith("mr_data_line")) {
            return 6000;
        }
        if (str.startsWith("mr_confess_a")) {
            return 1033;
        }
        if (str.startsWith("mr_confess_b")) {
            return 1034;
        }
        if (str.startsWith("mr_guild")) {
            return 10014;
        }
        return 0;
    }

    private static String getUinMD5(String str) {
        return an.a(str);
    }

    private void initInner(String str, String str2, String str3, String str4, long j3, int i3, int i16, long j16) {
        this.selfuin = str;
        this.frienduin = str2;
        this.senderuin = str3;
        this.f203106msg = str4;
        if (j3 <= 0) {
            j3 = (int) NetConnInfoCenter.getServerTime();
        }
        this.time = j3;
        this.msgtype = i3;
        this.istroop = i16;
        this.msgseq = j16;
    }

    public static boolean isShmsgseqVal(long j3) {
        if (j3 < MSG_SEQ_CRITICAL_VAL) {
            return true;
        }
        return false;
    }

    private void onUpdateExtraFlag(int i3, int i16) {
        QLog.i(TAG, 1, "onUpdateExtraFlag() called with: from = [" + com.tencent.mobileqq.service.message.remote.a.a(i3) + "], to = [" + com.tencent.mobileqq.service.message.remote.a.a(i16) + "], " + toString(), new RuntimeException());
    }

    private void onUpdateSendFailCode(int i3, int i16) {
        QLog.i(TAG, 1, "onUpdateSendFailCode() called with: from = [" + i3 + "], to = [" + i16 + "], " + toString(), new RuntimeException());
    }

    public static void setCallback(Callback callback) {
        sCallback = callback;
    }

    public void createMessageUniseq() {
        long j3 = (int) this.time;
        this.uniseq = j3;
        if (j3 == 0) {
            this.uniseq = (int) (System.currentTimeMillis() / 1000);
        }
        this.uniseq = (this.uniseq << 32) | Math.abs(new Random().nextInt());
    }

    public String getBaseInfoString() {
        int i3;
        if (isLongMsg()) {
            i3 = 69;
        } else {
            i3 = 0;
        }
        StringBuilder sb5 = new StringBuilder(i3 + 256);
        sb5.append("MessageRecord BaseInfo=friendUin:");
        sb5.append(MsfSdkUtils.getShortUin(this.frienduin));
        sb5.append(",_id:");
        sb5.append(getId());
        sb5.append(",shmsgseq:");
        sb5.append(this.shmsgseq);
        sb5.append(",uid:");
        sb5.append(this.msgUid);
        sb5.append(",uniseq:");
        sb5.append(this.uniseq);
        sb5.append(",time:");
        sb5.append(this.time);
        sb5.append(",extraFlag:");
        sb5.append(com.tencent.mobileqq.service.message.remote.a.a(this.extraflag));
        sb5.append(",istroop:");
        sb5.append(this.istroop);
        sb5.append(",msgType:");
        sb5.append(this.msgtype);
        sb5.append(",msg:");
        sb5.append(getLogColorContent());
        if (isLongMsg()) {
            sb5.append(",longMsgId:");
            sb5.append(this.longMsgId);
            sb5.append(",longMsgCount:");
            sb5.append(this.longMsgCount);
            sb5.append(",longMsgIndex:");
            sb5.append(this.longMsgIndex);
        }
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public Class<? extends Entity> getClassForTable() {
        return MessageRecord.class;
    }

    public int getConfessTopicId() {
        return (this.extLong >>> 3) & 262143;
    }

    public String getContentForSearch() {
        if (isSupportFTS()) {
            return this.f203106msg;
        }
        return null;
    }

    public String getExtInfoFromExtStr(String str) {
        if ((this.extLong & 1) != 1 || TextUtils.isEmpty(this.extStr)) {
            return "";
        }
        try {
            if (this.mExJsonObject == null) {
                this.mExJsonObject = new JSONObject(this.extStr);
            }
            if (!this.mExJsonObject.has(str)) {
                return "";
            }
            return this.mExJsonObject.getString(str);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage(), e16);
            }
            return "";
        }
    }

    public String getExtInfoString() {
        JSONObject jSONObject = this.mExJsonObject;
        if (jSONObject == null) {
            return "";
        }
        return jSONObject.toString();
    }

    public int getExtraKey() {
        return (4194296 & this.extLong) >>> 3;
    }

    public int getIntFromExtStr(String str) {
        if ((this.extLong & 1) != 1 || TextUtils.isEmpty(this.extStr)) {
            return -1;
        }
        try {
            if (this.mExJsonObject == null) {
                this.mExJsonObject = new JSONObject(this.extStr);
            }
            if (!this.mExJsonObject.has(str)) {
                return -1;
            }
            return this.mExJsonObject.optInt(str, -1);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage(), e16);
            }
            return -1;
        }
    }

    public String getLogColorContent() {
        return aw.a(this.f203106msg);
    }

    public String getLongMsgInfoString() {
        int i3;
        if (isLongMsg()) {
            i3 = 69;
        } else {
            i3 = 0;
        }
        StringBuilder sb5 = new StringBuilder(i3 + 129);
        sb5.append("MessageRecord LongMsgInfo=friendUin:");
        sb5.append(this.frienduin);
        sb5.append(",istroop:");
        sb5.append(this.istroop);
        sb5.append(",msgType:");
        sb5.append(this.msgtype);
        sb5.append(",msg:");
        sb5.append(getLogColorContent());
        sb5.append(",time:");
        sb5.append(this.time);
        if (isLongMsg()) {
            sb5.append(",longMsgId:");
            sb5.append(this.longMsgId);
            sb5.append(",longMsgCount:");
            sb5.append(this.longMsgCount);
            sb5.append(",longMsgIndex:");
            sb5.append(this.longMsgIndex);
        }
        return sb5.toString();
    }

    public int getPttStreamFlag() {
        return (short) (this.extInt & 65535);
    }

    public int getRepeatCount() {
        return (short) (this.extInt >> 16);
    }

    @Override // com.tencent.mobileqq.persistence.Entity
    public String getTableName() {
        return sCallback.getTableName(this);
    }

    public long getTime() {
        return this.time;
    }

    public String getUserLogString() {
        StringBuilder sb5 = new StringBuilder(133);
        sb5.append("MessageRecord=");
        String str = this.frienduin;
        if (str != null && str.length() >= 4) {
            sb5.append("friendUin:");
            String str2 = this.frienduin;
            sb5.append(str2.substring(str2.length() - 4));
        }
        String str3 = this.senderuin;
        if (str3 != null && str3.length() >= 4) {
            sb5.append("senderuin:");
            String str4 = this.senderuin;
            sb5.append(str4.substring(str4.length() - 4));
        }
        sb5.append(",istroop:");
        sb5.append(this.istroop);
        sb5.append(",msgType:");
        sb5.append(this.msgtype);
        sb5.append(",time:");
        sb5.append(this.time);
        sb5.append(",shmsgseq:");
        sb5.append(this.shmsgseq);
        return sb5.toString();
    }

    public void init(String str, String str2, String str3, String str4, long j3, int i3, int i16, long j16) {
        initInner(str, str2, str3, str4, j3, i3, i16, j16);
    }

    public boolean isLongMsg() {
        if (this.longMsgCount > 1) {
            return true;
        }
        return false;
    }

    public boolean isSelf() {
        return com.tencent.mobileqq.service.message.remote.a.b(this.issend);
    }

    public boolean isSelfConfessor() {
        if ((this.extLong & 2097152) > 0) {
            return true;
        }
        return false;
    }

    public boolean isSend() {
        return sCallback.isSend(this);
    }

    public boolean isSendFromLocal() {
        return com.tencent.mobileqq.service.message.remote.a.c(this.issend);
    }

    public boolean isSendFromOtherTerminal() {
        return com.tencent.mobileqq.service.message.remote.a.d(this.issend);
    }

    public boolean isSupportFTS() {
        return false;
    }

    public boolean needVipBubble() {
        int i3 = this.istroop;
        if (i3 == 0 || i3 == 1 || i3 == 3000 || i3 == 1000 || i3 == 1004 || i3 == 1006 || i3 == 1001 || i3 == 10002 || i3 == 10004 || i3 == 1010 || i3 == 1020 || i3 == 10008) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        byte[] bArr;
        try {
            if (this.versionCode > 0 && (bArr = this.msgData) != null) {
                this.f203106msg = new String(bArr, "UTF-8");
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        String str = this.f203106msg;
        if (str != null) {
            try {
                if (this.versionCode > 0 && str != null) {
                    this.msgData = str.getBytes("UTF-8");
                }
            } catch (UnsupportedEncodingException e16) {
                e16.printStackTrace();
            }
        }
    }

    public void removeExtInfoToExtStr(String str) {
        try {
            if (!TextUtils.isEmpty(this.extStr)) {
                JSONObject jSONObject = new JSONObject(this.extStr);
                if (jSONObject.has(str)) {
                    jSONObject.remove(str);
                    this.extStr = jSONObject.toString();
                    this.mExJsonObject = jSONObject;
                }
                if (jSONObject.length() == 0) {
                    this.extStr = null;
                    this.extLong = (int) (this.extLong & (-2));
                }
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage(), e16);
            }
        }
    }

    public void saveExtInfoToExtStr(String str, String str2) {
        try {
            if (TextUtils.isEmpty(this.extStr)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(str, str2);
                this.extStr = jSONObject.toString();
                this.mExJsonObject = jSONObject;
            } else {
                JSONObject jSONObject2 = new JSONObject(this.extStr);
                jSONObject2.put(str, str2);
                this.extStr = jSONObject2.toString();
                this.mExJsonObject = jSONObject2;
            }
            this.extLong |= 1;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, e16.getMessage(), e16);
            }
        }
    }

    public void setConfessTopicId(int i3) {
        this.extLong = (i3 << 3) | this.extLong;
    }

    public void setExtraFlag(int i3) {
        int i16 = this.extraflag;
        if (i16 == i3) {
            return;
        }
        this.extraflag = i3;
        onUpdateExtraFlag(i16, i3);
    }

    public void setPttStreamFlag(int i3) {
        this.extInt = (((short) i3) & 65535) | (this.extInt & SupportMenu.CATEGORY_MASK);
    }

    public void setRepeatCount(int i3) {
        this.extInt = (i3 << 16) | (this.extInt & 65535);
    }

    public void setSelfIsConfessor(boolean z16) {
        if (z16) {
            this.extLong |= 2097152;
        } else {
            this.extLong &= -2097153;
        }
    }

    public void setSendFailCode(int i3) {
        int i16 = this.sendFailCode;
        if (i16 == i3) {
            return;
        }
        this.sendFailCode = i3;
        onUpdateSendFailCode(i16, i3);
    }

    public String toString() {
        int i3;
        int length = getClass().getSimpleName().length() + 39 + 9 + 10 + 11 + 10 + 11 + 10 + 10 + 10 + 5 + 19 + 6 + 19 + 8 + 5 + 8 + 5 + 11 + 10 + 14 + 10 + 9 + 5 + 9 + 10 + 5 + 14 + 10 + 19 + 8 + 19 + 12 + 5 + 8 + 19;
        if (isLongMsg()) {
            i3 = 69;
        } else {
            i3 = 0;
        }
        StringBuilder sb5 = new StringBuilder(length + i3);
        sb5.append("-----Dump MessageRecord-----,classname:");
        sb5.append(getClass().getSimpleName());
        sb5.append(",selfUin:");
        sb5.append(MsfSdkUtils.getShortUin(this.selfuin));
        sb5.append(",friendUin:");
        sb5.append(MsfSdkUtils.getShortUin(this.frienduin));
        sb5.append(",senderUin:");
        sb5.append(MsfSdkUtils.getShortUin(this.senderuin));
        sb5.append(",shmsgseq:");
        sb5.append(this.shmsgseq);
        sb5.append(",uid:");
        sb5.append(this.msgUid);
        sb5.append(",time:");
        sb5.append(this.time);
        sb5.append(",isRead:");
        sb5.append(this.isread);
        sb5.append(",isSend:");
        sb5.append(this.issend);
        sb5.append(",extraFlag:");
        sb5.append(com.tencent.mobileqq.service.message.remote.a.a(this.extraflag));
        sb5.append(",sendFailCode:");
        sb5.append(this.sendFailCode);
        sb5.append(",istroop:");
        sb5.append(this.istroop);
        sb5.append(",msgType:");
        sb5.append(this.msgtype);
        sb5.append(",msg:");
        sb5.append(getLogColorContent());
        sb5.append(",bubbleid:");
        sb5.append(this.vipBubbleID);
        sb5.append(",subBubbleId:");
        sb5.append(this.vipSubBubbleId);
        sb5.append(",uniseq:");
        sb5.append(this.uniseq);
        sb5.append(",isMultiMsg:");
        sb5.append(this.isMultiMsg);
        sb5.append(",msgseq:");
        sb5.append(this.msgseq);
        if (isLongMsg()) {
            sb5.append(",longMsgId:");
            sb5.append(this.longMsgId);
            sb5.append(",longMsgCount:");
            sb5.append(this.longMsgCount);
            sb5.append(",longMsgIndex:");
            sb5.append(this.longMsgIndex);
        }
        return sb5.toString();
    }

    public static String getTableName(String str, int i3) {
        String str2 = i3 != 1 ? i3 != 1006 ? i3 != 1026 ? i3 != 1036 ? i3 != 3000 ? i3 != 9501 ? i3 != 10007 ? i3 != 10014 ? i3 != 1033 ? i3 != 1034 ? GuildMsgItem.NICK_FRIEND : "confess_b" : "confess_a" : "guild" : "temp_game_msg" : "devicemsg" : "discusssion" : "cmgame_temp" : "troop_hctopic" : "contact" : "troop";
        if (TextUtils.isEmpty(str)) {
            return "MessageRecord_frienduin_null";
        }
        return "mr_" + str2 + "_" + getUinMD5(str) + "_New";
    }

    public void init(long j3, long j16, long j17, String str, long j18, int i3, int i16, long j19) {
        initInner(String.valueOf(j3), String.valueOf(j16), String.valueOf(j17), str, j18, i3, i16, j19);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.persistence.Entity
    public void postwrite() {
    }
}
