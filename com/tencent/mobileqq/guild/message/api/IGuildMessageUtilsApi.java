package com.tencent.mobileqq.guild.message.api;

import bu1.a;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.jump.model.extras.GuildManageNoticePushMsg;
import com.tencent.mobileqq.guild.message.msgtype.MessageForGuildRevokeGrayTip;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.service.message.a;
import java.util.ArrayList;
import java.util.List;
import mqq.app.AppRuntime;
import msf.msgcomm.msg_comm$Msg;
import st1.d;
import st1.l;
import st1.m;
import tencent.im.group_pro_proto.common.common$Msg;
import tencent.im.group_pro_proto.msgpush.servtype$EventBody;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMessageUtilsApi extends QRouteApi {
    public static final String GUILD_AT_INFO_LIST = "guild_at_info_list";
    public static final String GUILD_ID_EXT_STR = "GUILD_ID";
    public static final int HANDLE_SELF_MSG_FROM_DUPLICATED_MSG = 3;
    public static final int HANDLE_SELF_MSG_FROM_PUSH = 2;
    public static final int HANDLE_SELF_MSG_FROM_RESP = 1;
    public static final String MSG_CNT_NAME = "GUILD_MSG_CNT_NAME";
    public static final String MSG_EMOJI_TASK = "GUILD_MSG_EMOJI_TASK";
    public static final String MSG_ENOJ_REACTION = "GUILD_MSG_ENOJ_REACTION";
    public static final String MSG_EVENT_INFO = "GUILD_MSG_EVENT_INFO";
    public static final String MSG_FROM_APPID = "GUILD_MSG_FROME_APPID";
    public static final String MSG_FROM_CHANNEL_ROLE_ID = "MSG_FROM_CHANNEL_ROLE_ID";
    public static final String MSG_FROM_NICK = "GUILD_MSG_FROM_NICK";
    public static final String MSG_FROM_PUSH_CHANNEL = "MSG_FROM_PUSH_CHANNEL";
    public static final String MSG_FROM_ROLE_INFO = "MSG_FROM_ROLE_INFO";
    public static final String MSG_FROM_ROLE_TYPE = "MSG_FROM_ROLE_TYPE";
    public static final String MSG_GAME_NICK = "GUILD_MSG_GAME_NICK";
    public static final String MSG_GAME_TYPE = "GUILD_MSG_GAME_TYPE";
    public static final String MSG_GUILD_MEMBER_NAME = "MSG_GUILD_MEMBER_NAME";
    public static final String MSG_GUILD_TRANS_DATA = "MSG_GUILD_TRANS_DATA";
    public static final String MSG_INNER_KEYBOARD = "MSG_INNER_KEYBOARD";
    public static final String MSG_LOCAL_ONLY = "GUILD_MSG_LOCAL_ONLY";
    public static final String MSG_META_STR = "GUILD_MSG_META_STR";
    public static final String MSG_SELF_COMMENT_INFO = "GUILD_MSG_SELF_EVENTFLOW_COMMENT_INFO";
    public static final String MSG_TYPE = "GUILD_MSG_TYPE";
    public static final int PUSH_FROM_CHANNEL_AUDIO_VIDEO_LIVE = 2;
    public static final int PUSH_FROM_CHANNEL_GUILD_FEED = 3;
    public static final int PUSH_FROM_CHANNEL_GUILD_TOP_FEED = 1;
    public static final int PUSH_FROM_CHANNEL_MANAGE_NOTICE = 4;
    public static final String ROBOT_IS_SHOW_MSG_SETTING = "ROBOT_IS_SHOW_MSG_SETTING";
    public static final String ROBOT_MSG_SRC_GUILD_ID = "ROBOT_MSG_SRC_GUILD_ID";
    public static final String ROBOT_MSG_SRC_GUILD_NAME = "ROBOT_MSG_SRC_GUILD_NAME";
    public static final String ROBOT_MSG_TYPE = "ROBOT_MSG_TYPE";

    void addDirectMsgLimitGray(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, String str4, String str5);

    void addMessageForBlackRobotGray(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, String str4, int i3);

    void addMessageForGuildRobotWelcome(BaseQQAppInterface baseQQAppInterface, String str, String str2, String str3, ArrayList<String> arrayList, int i3);

    void addMessageForGuildWelcome(BaseQQAppInterface baseQQAppInterface, String str);

    void addMessageForMsgNotifySettingGrayTips(BaseQQAppInterface baseQQAppInterface, String str, String str2);

    void addMessageForSubscribeChannelGray(BaseQQAppInterface baseQQAppInterface, String str, String str2);

    MessageRecord createEmptyMR();

    MessageRecord createMessageRecordForAppChannel(String str, String str2, long j3, int i3, String str3, boolean z16);

    MessageRecord createMessageRecordForLiveGift(String str, String str2, String str3, long j3, long j16);

    boolean decodeAppChannelMsg(servtype$EventBody servtype_eventbody, List<MessageRecord> list, msg_comm$Msg msg_comm_msg, a aVar);

    void deleteGrayTipsByType(BaseQQAppInterface baseQQAppInterface, String str, int i3);

    void deleteGuildFileManagerEntity(AppRuntime appRuntime, MessageRecord messageRecord);

    String getAdminRevokeWord(AppRuntime appRuntime, MessageForGuildRevokeGrayTip messageForGuildRevokeGrayTip, String str);

    Class<? extends com.tencent.imcore.message.core.codec.a> getAppChannelInnerKeyboardDecoder();

    Class<? extends com.tencent.imcore.message.core.codec.a> getAppChannelMarkdownDecoder();

    Class<? extends com.tencent.imcore.message.core.codec.a> getAppChannelNormalMsgDecoder();

    long getCntSeqFromMR(MessageRecord messageRecord);

    bu1.a getEventFlow(MessageRecord messageRecord);

    long getGuildIdFromMR(MessageRecord messageRecord);

    GuildManageNoticePushMsg getGuildManageNoticePushMsgFromMr(MessageRecord messageRecord);

    d getGuildMessageCache(AppRuntime appRuntime);

    m getHongbaoInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar);

    long getLiveGiftMessageGiftComboCount(ChatMessage chatMessage);

    long getLiveGiftMessageGiftId(ChatMessage chatMessage);

    String getLiveGiftMessageGiftName(ChatMessage chatMessage);

    String getLiveGiftMessageReceiverUid(ChatMessage chatMessage);

    String getLocalOnlyFromMR(MessageRecord messageRecord);

    Class<? extends com.tencent.imcore.message.core.codec.a> getMessageForLiveGiftDecoder();

    Class<? extends MessageRecord> getMessageMarkdownClazz();

    MessageRecord getMessageRecordForAppChannel();

    Class<? extends MessageRecord> getMessageRecordForBlackRobotGrayTipClazz();

    Class<? extends MessageRecord> getMessageRecordForDirectMessageWelcomeClazz();

    Class<? extends MessageRecord> getMessageRecordForGuildWelcomeClazz();

    MessageRecord getMessageRecordForLiveGift();

    Class<? extends MessageRecord> getMessageRecordForLiveGiftClazz();

    Class<? extends MessageRecord> getMessageRecordForMsgNotifySettingGrayTipsClazz();

    Class<? extends MessageRecord> getMessageRecordForRobotDirectMsgLimitTipClazz();

    Class<? extends MessageRecord> getMessageRecordForSubscribeChannelGrayTipClazz();

    Class<? extends com.tencent.imcore.message.core.codec.a> getMsgEventDecoder();

    String getMsgGuildMemberNameFromMR(MessageRecord messageRecord);

    byte[] getMsgMetaFromMr(MessageRecord messageRecord);

    int getMsgRandomByMsgUid_Hummer(long j3);

    String getMsgTypeFromMR(MessageRecord messageRecord);

    MessageRecord getNewMessageRecordForBlackRobotGrayTip();

    MessageRecord getNewMessageRecordForDirectMessageWelcome();

    MessageRecord getNewMessageRecordForGuildWelcome();

    MessageRecord getNewMessageRecordForMarkdown();

    MessageRecord getNewMessageRecordForMsgNotifySettingGrayTips();

    MessageRecord getNewMessageRecordForRobotDirectMsgLimitGrayTip();

    MessageRecord getNewMessageRecordForSubscribeChannelGrayTip();

    String getNickNameFromMR(MessageRecord messageRecord);

    int getRevokeMsgType(MessageRecord messageRecord);

    String getRoleInfoFromMR(MessageRecord messageRecord);

    m getSubKeywordInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar);

    m getSubQrCodePicInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar, Boolean bool);

    m getSubTextAtInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar);

    m getSubTextLinkInterceptProcessor(l lVar, com.tencent.aio.api.runtime.a aVar);

    void handleNeedAddSubscribeGrayTip(AppInterface appInterface, String str, String str2);

    void handleSelfSendMsg(AppInterface appInterface, MessageRecord messageRecord, MessageRecord messageRecord2, int i3);

    boolean isAtAllMsg(MessageRecord messageRecord);

    boolean isCanNotifyAppChannelMsg(MessageRecord messageRecord);

    boolean isDirectMsg(p pVar);

    boolean isGuest(String str);

    boolean isLocalOnlyMsg(MessageRecord messageRecord);

    boolean isMsgVisible(MessageRecord messageRecord);

    boolean isNotSuccess(ChatMessage chatMessage);

    boolean isRevokeMsg(MessageRecord messageRecord);

    boolean isSysMsg(MessageRecord messageRecord);

    boolean isSysMsg(common$Msg common_msg);

    boolean isTopMsgGray(MessageRecord messageRecord);

    boolean needAddSubscribeGrayAfterSpeaking(AppInterface appInterface, String str, String str2);

    ArrayList<AtTroopMemberInfo> parseAtInfoFromExtStr(String str);

    void saveAtInfoList(MessageRecord messageRecord, ArrayList<AtTroopMemberInfo> arrayList);

    boolean saveEventFlowToMsg(MessageRecord messageRecord, bu1.a aVar);

    void saveEventToMsg(MessageRecord messageRecord, a.b bVar);

    void saveGuildIdToMR(MessageRecord messageRecord, String str);

    void saveMsgMetaToMr(MessageRecord messageRecord, byte[] bArr);

    void saveSyncTimeToMsg(MessageRecord messageRecord, long j3);

    void setMsgReaded(AppInterface appInterface, MessageRecord messageRecord);

    void syncGuildMsg(AppInterface appInterface, boolean z16);

    void updateMsgSendStatus(AppInterface appInterface, String str, long j3, int i3, int i16);

    void updateMsgSeqAndTime(AppInterface appInterface, long j3, MessageRecord messageRecord);

    boolean updateReplyMsgCommentForSourceMsg(MessageRecord messageRecord, MessageRecord messageRecord2, boolean z16, boolean z17);
}
