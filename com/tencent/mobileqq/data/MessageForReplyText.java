package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.msgbackup.data.e;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.i;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForReplyText extends ChatMessage {
    public static final String KEY_BARRAGE_SOURCE_MSG_TYPE = "barrage_source_msg_type";
    public static final String KEY_BARRAGE_TIME_LOCATION = "barrage_time_location";
    public String action;
    public int barrageSourceMsgType;
    public long barrageTimeLocation;
    public CharSequence charStr;
    public boolean isBarrageMsg;
    public boolean mHasPullHistorySourceMsg = false;
    public SourceMsgInfo mSourceMsgInfo;
    public int msgVia;

    @notColumn
    private MessageRecord sourceMessage;

    public static QQAppInterface getAppInterface() {
        if (BaseApplicationImpl.getApplication() != null) {
            AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
            if (runtime instanceof QQAppInterface) {
                return (QQAppInterface) runtime;
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportReplyMsg(QQAppInterface qQAppInterface, String str, String str2, String str3, ChatMessage chatMessage) {
        int i3;
        String str4;
        String str5;
        if (chatMessage != null) {
            int i16 = chatMessage.msgtype;
            if (i16 == -2022) {
                i3 = 7;
            } else if (i16 == -2017) {
                i3 = 5;
            } else if (i16 != -2011) {
                i3 = i16 != -2007 ? i16 != -2002 ? i16 != -2000 ? 0 : 3 : 4 : 2;
            } else {
                if (chatMessage instanceof MessageForStructing) {
                    MessageForStructing messageForStructing = (MessageForStructing) chatMessage;
                    if (messageForStructing.structingMsg != null) {
                        str5 = messageForStructing.structingMsg.mMsgServiceID + "";
                    } else {
                        str5 = "";
                    }
                    str4 = str5;
                    i3 = 10;
                    ReportController.o(qQAppInterface, "P_CliOper", chatMessage.istroop != 3000 ? "Grp_Dis_replyMsg" : "Grp_replyMsg", "", str, str2, 0, 0, str3, i3 + "", !com.tencent.biz.anonymous.a.m(chatMessage) ? "1" : "0", str4);
                    return;
                }
                i3 = 10;
            }
            str4 = "";
            ReportController.o(qQAppInterface, "P_CliOper", chatMessage.istroop != 3000 ? "Grp_Dis_replyMsg" : "Grp_replyMsg", "", str, str2, 0, 0, str3, i3 + "", !com.tencent.biz.anonymous.a.m(chatMessage) ? "1" : "0", str4);
            return;
        }
        ReportController.o(qQAppInterface, "P_CliOper", "Grp_replyMsg", "", str, str2, 0, 0, str3, "", "", "");
    }

    public void deepCopySourceMsg(MessageForReplyText messageForReplyText) {
        MessageRecord messageRecord;
        if (messageForReplyText == null) {
            QLog.d(LogTag.MSG, 1, "originMsg is null");
            return;
        }
        this.mSourceMsgInfo = new SourceMsgInfo(messageForReplyText.mSourceMsgInfo);
        MessageRecord messageRecord2 = messageForReplyText.sourceMessage;
        if (messageRecord2 != null) {
            int i3 = messageRecord2.msgtype;
            if (i3 == -1037) {
                messageRecord = ((MessageForLongMsg) messageRecord2).rebuildLongMsg(true);
            } else if (i3 == -1036) {
                messageRecord = (MessageForMixedMsg) ((MessageForLongMsg) messageRecord2).rebuildLongMsg();
            } else if (i3 == -1035) {
                messageRecord = ((MessageForMixedMsg) messageRecord2).rebuildMixedMsg();
            } else if (i3 == -2011) {
                messageRecord = new MessageForStructing(messageRecord2);
            } else {
                messageRecord = (MessageRecord) messageRecord2.deepCopyByReflect();
            }
        } else {
            messageRecord = null;
        }
        if (messageRecord == null && QLog.isColorLevel()) {
            QLog.d(LogTag.MSG, 2, "MessageForReplyText deepCopySourceMsg is null");
        }
        this.sourceMessage = messageRecord;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Can't wrap try/catch for region: R(18:1|(1:3)|4|(15:64|65|7|(1:11)|12|13|14|(1:16)|17|(2:21|(1:23))|25|26|(1:32)|34|(1:36)(4:38|(4:40|(1:44)|(1:46)|47)|48|(2:50|(2:52|53)(1:54))(1:55)))|6|7|(2:9|11)|12|13|14|(0)|17|(3:19|21|(0))|25|26|(3:28|30|32)|34|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00a1, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a6, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00a8, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.app.LogTag.MSG, 2, "doParse MessageForReplyText exception:" + r7.getMessage());
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x0069, code lost:
    
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x006e, code lost:
    
        if (com.tencent.qphone.base.util.QLog.isColorLevel() != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0070, code lost:
    
        com.tencent.qphone.base.util.QLog.d(com.tencent.mobileqq.app.LogTag.MSG, 2, "doParse MessageForReplyText exception:" + r7.getMessage());
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003d A[Catch: Exception -> 0x0069, TryCatch #1 {Exception -> 0x0069, blocks: (B:14:0x0030, B:16:0x003d, B:17:0x0043, B:19:0x0049, B:21:0x004d, B:23:0x005b), top: B:13:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x005b A[Catch: Exception -> 0x0069, TRY_LEAVE, TryCatch #1 {Exception -> 0x0069, blocks: (B:14:0x0030, B:16:0x003d, B:17:0x0043, B:19:0x0049, B:21:0x004d, B:23:0x005b), top: B:13:0x0030 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ce  */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        boolean parseBoolean;
        String extInfoFromExtStr;
        ArrayList<AtTroopMemberInfo> troopMemberInfoFromExtrJson;
        String extInfoFromExtStr2;
        SourceMsgInfo sourceMsgInfo;
        String str = this.f203106msg;
        if (str == null) {
            str = "";
        }
        String extInfoFromExtStr3 = getExtInfoFromExtStr("sens_msg_need_parse");
        if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
            try {
                parseBoolean = Boolean.parseBoolean(extInfoFromExtStr3);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            boolean z16 = false;
            if (parseBoolean && (BaseActivity.sTopActivity instanceof MultiForwardActivity)) {
                parseBoolean = false;
            }
            extInfoFromExtStr2 = getExtInfoFromExtStr("sens_msg_source_msg_info");
            if (TextUtils.isEmpty(extInfoFromExtStr2)) {
                QLog.e(LogTag.MSG, 1, "mfrt sourceMsgInfo is null");
            }
            if (!TextUtils.isEmpty(extInfoFromExtStr2) && this.mSourceMsgInfo == null) {
                sourceMsgInfo = (SourceMsgInfo) MessagePkgUtils.getObjectFromBytes(HexUtil.hexStr2Bytes(extInfoFromExtStr2));
                this.mSourceMsgInfo = sourceMsgInfo;
                if (sourceMsgInfo != null) {
                    setSourceMessageRecord(this.mSourceMsgInfo.unPackSourceMsg(getAppInterface()));
                }
            }
            extInfoFromExtStr = getExtInfoFromExtStr(i.f286266i);
            if (!TextUtils.isEmpty(extInfoFromExtStr) && (troopMemberInfoFromExtrJson = MessageForText.getTroopMemberInfoFromExtrJson(extInfoFromExtStr)) != null && troopMemberInfoFromExtrJson.size() > 0) {
                this.atInfoList = troopMemberInfoFromExtrJson;
            }
            this.charStr = new QQText(str, 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this);
            if (parseBoolean) {
                return;
            }
            String extInfoFromExtStr4 = getExtInfoFromExtStr("sens_msg_ctrl_info");
            if (!TextUtils.isEmpty(extInfoFromExtStr4)) {
                String extInfoFromExtStr5 = getExtInfoFromExtStr("sens_msg_confirmed");
                if (!TextUtils.isEmpty(extInfoFromExtStr5) && extInfoFromExtStr5.equalsIgnoreCase("1")) {
                    z16 = true;
                }
                if (!z16) {
                    saveExtInfoToExtStr("sens_msg_original_text", str);
                }
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                copyOnWriteArrayList.add(this);
                MQPSensitiveMsgUtil.k(this, copyOnWriteArrayList, z16, HexUtil.hexStr2Bytes(extInfoFromExtStr4));
            }
            String extInfoFromExtStr6 = getExtInfoFromExtStr(KEY_BARRAGE_TIME_LOCATION);
            if (!TextUtils.isEmpty(extInfoFromExtStr6)) {
                this.isBarrageMsg = true;
                this.barrageTimeLocation = Long.valueOf(extInfoFromExtStr6).longValue();
                String extInfoFromExtStr7 = getExtInfoFromExtStr(KEY_BARRAGE_SOURCE_MSG_TYPE);
                if (!TextUtils.isEmpty(extInfoFromExtStr7)) {
                    this.barrageSourceMsgType = Integer.valueOf(extInfoFromExtStr7).intValue();
                    return;
                }
                return;
            }
            return;
        }
        parseBoolean = true;
        boolean z162 = false;
        if (parseBoolean) {
            parseBoolean = false;
        }
        extInfoFromExtStr2 = getExtInfoFromExtStr("sens_msg_source_msg_info");
        if (TextUtils.isEmpty(extInfoFromExtStr2)) {
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
            sourceMsgInfo = (SourceMsgInfo) MessagePkgUtils.getObjectFromBytes(HexUtil.hexStr2Bytes(extInfoFromExtStr2));
            this.mSourceMsgInfo = sourceMsgInfo;
            if (sourceMsgInfo != null) {
            }
        }
        extInfoFromExtStr = getExtInfoFromExtStr(i.f286266i);
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            this.atInfoList = troopMemberInfoFromExtrJson;
        }
        this.charStr = new QQText(str, 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this);
        if (parseBoolean) {
        }
    }

    public boolean getHasPulledSourceMsg() {
        return this.mHasPullHistorySourceMsg;
    }

    public MessageRecord getSourceMessage() {
        return this.sourceMessage;
    }

    public SourceMsgInfo getSourceMsgInfo() {
        return this.mSourceMsgInfo;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        CharSequence charSequence = this.charStr;
        if (charSequence == null) {
            return this.f203106msg;
        }
        return charSequence.toString();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean isSupportFTS() {
        return ad.s(this.istroop);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        super.postRead();
        parse();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        serial();
    }

    public void saveSourceMsgInfoToExtStr() {
        try {
            saveExtInfoToExtStr("sens_msg_source_msg_info", HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(this.mSourceMsgInfo)));
        } catch (Exception e16) {
            QLog.e(LogTag.MSG, 1, "prewrite MessageForReplyText exception:" + e16.getMessage());
        }
    }

    public void serial() {
        String str;
        String extInfoFromExtStr = getExtInfoFromExtStr("sens_msg_original_text");
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            extInfoFromExtStr = this.f203106msg;
        }
        this.f203106msg = extInfoFromExtStr;
        if (extInfoFromExtStr == null) {
            str = "";
        } else {
            str = extInfoFromExtStr;
        }
        this.f203106msg = str;
        this.msgData = extInfoFromExtStr.getBytes();
        try {
            QQAppInterface appInterface = getAppInterface();
            MessageRecord messageRecord = this.sourceMessage;
            if (messageRecord != null && appInterface != null) {
                this.mSourceMsgInfo.packSourceMsg(appInterface, messageRecord);
            }
            saveSourceMsgInfoToExtStr();
            if (this.isBarrageMsg) {
                saveExtInfoToExtStr(KEY_BARRAGE_TIME_LOCATION, String.valueOf(this.barrageTimeLocation));
                saveExtInfoToExtStr(KEY_BARRAGE_SOURCE_MSG_TYPE, String.valueOf(this.barrageSourceMsgType));
            }
            this.extLong |= 1;
        } catch (Exception e16) {
            QLog.e(LogTag.MSG, 1, "prewrite MessageForReplyText exception:" + e16.getMessage());
        }
    }

    public void setPulledSourceMsg() {
        this.mHasPullHistorySourceMsg = true;
    }

    public void setSourceMessageRecord(MessageRecord messageRecord) {
        List<MessageRecord> list;
        if (messageRecord == null) {
            return;
        }
        this.sourceMessage = messageRecord;
        messageRecord.isReplySource = true;
        messageRecord.isMultiMsg = this.isMultiMsg;
        messageRecord.isReMultiMsg = this.isReMultiMsg;
        if ((messageRecord instanceof MessageForMixedMsg) && (list = ((MessageForMixedMsg) messageRecord).msgElemList) != null) {
            for (MessageRecord messageRecord2 : list) {
                if (messageRecord2 != null) {
                    messageRecord2.isReplySource = true;
                }
            }
        }
        SourceMsgInfo sourceMsgInfo = this.mSourceMsgInfo;
        if (sourceMsgInfo != null) {
            sourceMsgInfo.setUniSeq(messageRecord.uniseq, false);
            messageRecord.uniseq = this.mSourceMsgInfo.getUniSeq();
        }
    }

    public static void reportReplyMsg(QQAppInterface qQAppInterface, SessionInfo sessionInfo, ChatMessage chatMessage) {
        if (sessionInfo.f179555d == 0) {
            ReportController.o(qQAppInterface, "dc00898", "", "", "0X80095E8", "0X80095E8", 0, 0, "", "", "", "");
        } else {
            reportReplyMsg(qQAppInterface, "Msg_menu", "clk_replyMsg", sessionInfo.f179557e, chatMessage);
        }
    }

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class SourceMsgInfo implements Serializable {
        public static final int REPLY_TYPE_NORMAL = 0;
        public static final int SOURCE_SUMMARY_FLAG_CPMPLETE = 1;
        public static final int SOURCE_SUMMARY_FLAG_DIRTY = 0;
        private static final long serialVersionUID = 1;
        public int aioMsgRevokeType;
        public long commentCnt;
        public String mAnonymousNickName;
        public String mAtInfoStr;
        public long mParentMsgSeq;
        public String mRichMsg;
        public long mRootMsgSeq;
        private byte[] mSourceMessageByte;
        public long mSourceMsgSenderUin;
        public long mSourceMsgSeq;
        public String mSourceMsgText;
        public int mSourceMsgTime;
        public long mSourceMsgToUin;
        public String mSourceMsgTroopName;
        public int mSourceSummaryFlag;
        public int mType;
        public int oriMsgRevokeType;
        public int oriMsgType;
        public String origNickName;
        public long origUid;
        public int replyPicHeight;
        public int replyPicWidth;
        private long uniseq;

        public SourceMsgInfo(SourceMsgInfo sourceMsgInfo) {
            this.mSourceSummaryFlag = 1;
            this.mType = 0;
            this.uniseq = 0L;
            this.commentCnt = 0L;
            this.oriMsgRevokeType = 0;
            this.aioMsgRevokeType = s61.a.f433387a;
            if (sourceMsgInfo != null) {
                this.mRootMsgSeq = sourceMsgInfo.mRootMsgSeq;
                this.mParentMsgSeq = sourceMsgInfo.mParentMsgSeq;
                this.mSourceMsgSeq = sourceMsgInfo.mSourceMsgSeq;
                this.mSourceMsgSenderUin = sourceMsgInfo.mSourceMsgSenderUin;
                this.mSourceMsgToUin = sourceMsgInfo.mSourceMsgToUin;
                this.mSourceMsgText = sourceMsgInfo.mSourceMsgText;
                this.mSourceMsgTime = sourceMsgInfo.mSourceMsgTime;
                this.mAnonymousNickName = sourceMsgInfo.mAnonymousNickName;
                this.mSourceSummaryFlag = sourceMsgInfo.mSourceSummaryFlag;
                this.mType = sourceMsgInfo.mType;
                this.mRichMsg = sourceMsgInfo.mRichMsg;
                this.replyPicWidth = sourceMsgInfo.replyPicWidth;
                this.replyPicHeight = sourceMsgInfo.replyPicHeight;
                this.oriMsgType = sourceMsgInfo.oriMsgType;
                this.origUid = sourceMsgInfo.origUid;
                this.mAtInfoStr = sourceMsgInfo.mAtInfoStr;
                this.mSourceMsgTroopName = sourceMsgInfo.mSourceMsgTroopName;
                this.mSourceMessageByte = sourceMsgInfo.getSourceMsg();
                this.oriMsgRevokeType = sourceMsgInfo.oriMsgRevokeType;
                this.aioMsgRevokeType = sourceMsgInfo.aioMsgRevokeType;
                this.commentCnt = sourceMsgInfo.commentCnt;
                setUniSeq(sourceMsgInfo.uniseq, false);
            }
        }

        public byte[] getSourceMsg() {
            return this.mSourceMessageByte;
        }

        public long getUniSeq() {
            return this.uniseq;
        }

        public void packSourceMsg(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
            byte[] k3;
            if (messageRecord == null || (messageRecord instanceof MessageForReplyText) || (k3 = e.k(qQAppInterface, messageRecord)) == null) {
                return;
            }
            setSourceMsgByte(k3);
            setUniSeq(messageRecord.uniseq, false);
        }

        public void setOrigNickName(MessageRecord messageRecord) {
            String nickNameFromMR = ((IGuildMessageUtilsApi) QRoute.api(IGuildMessageUtilsApi.class)).getNickNameFromMR(messageRecord);
            if (!TextUtils.isEmpty(nickNameFromMR)) {
                this.origNickName = nickNameFromMR;
            }
        }

        public void setSourceMsgByte(byte[] bArr) {
            if (bArr == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("SourceMsgInfo", 2, "sourcemsgbtye is replace by null");
                    return;
                }
                return;
            }
            this.mSourceMessageByte = bArr;
        }

        public void setUniSeq(long j3, boolean z16) {
            if (QLog.isColorLevel()) {
                QLog.d("SourceMsgInfo", 2, "uniSeq has value curUniSq=" + this.uniseq + " expectSeq=" + j3 + " forceToReset=" + z16);
            }
            if (z16) {
                this.uniseq = j3;
            } else if (this.uniseq == 0) {
                this.uniseq = j3;
            }
        }

        public MessageRecord unPackSourceMsg(QQAppInterface qQAppInterface) {
            byte[] bArr = this.mSourceMessageByte;
            if (bArr == null) {
                return null;
            }
            return e.n(qQAppInterface, bArr);
        }

        public SourceMsgInfo() {
            this.mSourceSummaryFlag = 1;
            this.mType = 0;
            this.uniseq = 0L;
            this.commentCnt = 0L;
            this.oriMsgRevokeType = 0;
            this.aioMsgRevokeType = s61.a.f433387a;
        }
    }
}
