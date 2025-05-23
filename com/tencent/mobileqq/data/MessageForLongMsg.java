package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.ad;
import com.tencent.ims.bankcode_info$BankcodeCtrlInfo;
import com.tencent.ims.bankcode_info$BankcodeElem;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForLongMsg extends RecommendCommonMessage {
    public CharSequence charStr;
    public CharSequence charStr2;
    public Object fragmentListSyncLock;
    public List<MessageRecord> longMsgFragmentList;
    public boolean mHasPullHistorySourceMsg;
    public boolean mIsCutAtInfoLocal;
    public MessageForReplyText.SourceMsgInfo mSourceMsgInfo;

    public MessageForLongMsg() {
        this.fragmentListSyncLock = new Object();
        this.mIsCutAtInfoLocal = false;
        this.mHasPullHistorySourceMsg = false;
        this.longMsgFragmentList = new ArrayList();
    }

    public boolean canSelectable() {
        List<MessageRecord> list;
        List<MessageRecord> list2 = this.longMsgFragmentList;
        if (list2 != null) {
            for (MessageRecord messageRecord : list2) {
                if ((messageRecord instanceof MessageForText) || (messageRecord instanceof MessageForReplyText)) {
                    return true;
                }
                if ((messageRecord instanceof MessageForMixedMsg) && (list = ((MessageForMixedMsg) messageRecord).msgElemList) != null) {
                    Iterator<MessageRecord> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() instanceof MessageForText) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.RecommendCommonMessage, com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        boolean z16;
        bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo;
        List<bankcode_info$BankcodeElem> list;
        int i3;
        String str;
        int i16;
        super.doParse();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        synchronized (this.fragmentListSyncLock) {
            List<MessageRecord> list2 = this.longMsgFragmentList;
            z16 = false;
            if (list2 != null && !list2.isEmpty()) {
                int i17 = 0;
                int i18 = 0;
                boolean z17 = false;
                for (MessageRecord messageRecord : this.longMsgFragmentList) {
                    String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
                    if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                        try {
                            bankcode_info_bankcodectrlinfo = new bankcode_info$BankcodeCtrlInfo();
                            bankcode_info_bankcodectrlinfo.mergeFrom(HexUtil.hexStr2Bytes(extInfoFromExtStr));
                            if (bankcode_info_bankcodectrlinfo.msgtail_id.has()) {
                                i17 = bankcode_info_bankcodectrlinfo.msgtail_id.get();
                            }
                        } catch (Exception e16) {
                            e16.printStackTrace();
                        }
                        if (i17 == 1) {
                            if (bankcode_info_bankcodectrlinfo.bankcode_elems.has() && (list = bankcode_info_bankcodectrlinfo.bankcode_elems.get()) != null) {
                                for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem : list) {
                                    if (bankcode_info_bankcodeelem.bankcode_attr.has()) {
                                        i16 = bankcode_info_bankcodeelem.bankcode_attr.get();
                                    } else {
                                        i16 = 0;
                                    }
                                    if (i16 > i18) {
                                        i18 = i16;
                                    }
                                }
                                if (i18 == 20) {
                                    for (bankcode_info$BankcodeElem bankcode_info_bankcodeelem2 : list) {
                                        if (bankcode_info_bankcodeelem2.bankcode_attr.has()) {
                                            i3 = bankcode_info_bankcodeelem2.bankcode_attr.get();
                                        } else {
                                            i3 = 0;
                                        }
                                        if (i3 == 20) {
                                            if (bankcode_info_bankcodeelem2.clean_bankcode.has()) {
                                                str = bankcode_info_bankcodeelem2.clean_bankcode.get();
                                            } else {
                                                str = null;
                                            }
                                            if (!TextUtils.isEmpty(str) && !MQPSensitiveMsgUtil.g().j(str)) {
                                                z17 = true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (this.mSourceMsgInfo == null) {
                        String extInfoFromExtStr2 = messageRecord.getExtInfoFromExtStr("sens_msg_source_msg_info");
                        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                            try {
                                this.mSourceMsgInfo = (MessageForReplyText.SourceMsgInfo) MessagePkgUtils.getObjectFromBytes(HexUtil.hexStr2Bytes(extInfoFromExtStr2));
                            } catch (Exception e17) {
                                if (QLog.isColorLevel()) {
                                    QLog.d(LogTag.MSG, 2, "getSourceMsgInfo exception:" + e17.getMessage());
                                }
                            }
                        }
                    }
                }
                for (MessageRecord messageRecord2 : this.longMsgFragmentList) {
                    if (messageRecord2 instanceof ChatMessage) {
                        if (i17 == 1) {
                            messageRecord2.saveExtInfoToExtStr("sens_msg_attr", Integer.toString(i18));
                            messageRecord2.saveExtInfoToExtStr("sens_msg_has_not_confirmed_msg", Boolean.toString(z17));
                        }
                        ((ChatMessage) messageRecord2).doParse();
                        if (messageRecord2 instanceof MessageForText) {
                            if (!TextUtils.isEmpty(messageRecord2.f203106msg)) {
                                sb5.append(messageRecord2.f203106msg);
                            }
                            if (!TextUtils.isEmpty(messageRecord2.msg2)) {
                                sb6.append(messageRecord2.msg2);
                                z16 = true;
                            } else if (!TextUtils.isEmpty(messageRecord2.f203106msg)) {
                                sb6.append(messageRecord2.f203106msg);
                            }
                        } else if (messageRecord2 instanceof MessageForReplyText) {
                            sb5.append(((MessageForReplyText) messageRecord2).f203106msg);
                            sb6.append(((MessageForReplyText) messageRecord2).f203106msg);
                        } else if (messageRecord2 instanceof MessageForMixedMsg) {
                            sb5.append(((MessageForMixedMsg) messageRecord2).f203106msg);
                            sb6.append(((MessageForMixedMsg) messageRecord2).msg2);
                        } else if (messageRecord2 instanceof MessageForPic) {
                            sb5.append(((MessageForPic) messageRecord2).getSummaryMsg());
                            sb6.append(((MessageForPic) messageRecord2).getSummaryMsg());
                        }
                    }
                }
            }
        }
        this.f203106msg = sb5.toString();
        this.charStr = new QQText(this.f203106msg, 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this.istroop);
        if (z16) {
            this.charStr2 = new QQText(sb6.toString(), 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this.istroop);
        }
    }

    public boolean getHasPulledSourceMsg() {
        return this.mHasPullHistorySourceMsg;
    }

    public MessageForReplyText.SourceMsgInfo getSourceMsgInfo() {
        return this.mSourceMsgInfo;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return this.charStr.toString();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean isSupportFTS() {
        return ad.s(this.istroop);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    public MessageRecord rebuildLongMsg() {
        return rebuildLongMsg(false);
    }

    public void setPulledSourceMsg() {
        this.mHasPullHistorySourceMsg = true;
    }

    public MessageRecord rebuildLongMsg(boolean z16) {
        boolean z17;
        int i3 = this.msgtype;
        MessageForReplyText messageForReplyText = null;
        if (i3 == -1037) {
            StringBuilder sb5 = new StringBuilder("");
            synchronized (this.fragmentListSyncLock) {
                z17 = false;
                for (MessageRecord messageRecord : this.longMsgFragmentList) {
                    if (messageRecord instanceof MessageForText) {
                        sb5.append(((MessageForText) messageRecord).f203106msg);
                    } else if (messageRecord instanceof MessageForReplyText) {
                        sb5.append(((MessageForReplyText) messageRecord).f203106msg);
                        z17 = true;
                    }
                }
            }
            if (z16 && z17) {
                try {
                    MessageForReplyText messageForReplyText2 = (MessageForReplyText) ((MessageForReplyText) this.longMsgFragmentList.get(0)).deepCopyByReflect();
                    messageForReplyText2.f203106msg = sb5.toString();
                    messageForReplyText = messageForReplyText2;
                } catch (Exception e16) {
                    QLog.e("MultiMsg_TAG", 1, e16, new Object[0]);
                }
            }
            if (messageForReplyText != null) {
                return messageForReplyText;
            }
            MessageRecord d16 = q.d(-1000);
            MessageRecord.copyMessageRecordBaseField(d16, this);
            d16.msgtype = -1000;
            d16.f203106msg = sb5.toString();
            return d16;
        }
        if (i3 != -1036) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (this.fragmentListSyncLock) {
            for (MessageRecord messageRecord2 : this.longMsgFragmentList) {
                if (messageRecord2 instanceof MessageForText) {
                    arrayList.add(messageRecord2);
                } else if (messageRecord2 instanceof MessageForMixedMsg) {
                    for (MessageRecord messageRecord3 : ((MessageForMixedMsg) messageRecord2).msgElemList) {
                        if (messageRecord3 instanceof MessageForText) {
                            arrayList.add(messageRecord3);
                        } else if (messageRecord3 instanceof MessageForPic) {
                            if (!arrayList.isEmpty()) {
                                Iterator it = arrayList.iterator();
                                while (it.hasNext()) {
                                    stringBuffer.append(((MessageRecord) it.next()).f203106msg);
                                }
                                MessageForText messageForText = (MessageForText) q.d(-1000);
                                messageForText.msgtype = -1000;
                                messageForText.f203106msg = stringBuffer.toString();
                                stringBuffer.delete(0, stringBuffer.length());
                                arrayList2.add(messageForText);
                                arrayList.clear();
                            }
                            arrayList2.add((MessageForPic) messageRecord3.deepCopyByReflect());
                        } else if (messageRecord3 instanceof MessageForReplyText) {
                            arrayList.add(messageRecord3);
                        }
                    }
                } else if (messageRecord2 instanceof MessageForPic) {
                    if (!arrayList.isEmpty()) {
                        Iterator it5 = arrayList.iterator();
                        while (it5.hasNext()) {
                            stringBuffer.append(((MessageRecord) it5.next()).f203106msg);
                        }
                        MessageForText messageForText2 = (MessageForText) q.d(-1000);
                        messageForText2.msgtype = -1000;
                        messageForText2.f203106msg = stringBuffer.toString();
                        stringBuffer.delete(0, stringBuffer.length());
                        arrayList2.add(messageForText2);
                        arrayList.clear();
                    }
                    arrayList2.add((MessageForPic) messageRecord2.deepCopyByReflect());
                } else if (messageRecord2 instanceof MessageForReplyText) {
                    arrayList.add(messageRecord2);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                String str = ((MessageRecord) it6.next()).f203106msg;
                if (str == null) {
                    str = "";
                }
                stringBuffer.append(str);
            }
            MessageForText messageForText3 = (MessageForText) q.d(-1000);
            messageForText3.msgtype = -1000;
            messageForText3.f203106msg = stringBuffer.toString();
            stringBuffer.delete(0, stringBuffer.length());
            arrayList2.add(messageForText3);
            arrayList.clear();
        }
        MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) q.d(MessageRecord.MSG_TYPE_MIX);
        MessageRecord.copyMessageRecordBaseField(messageForMixedMsg, this);
        messageForMixedMsg.msgtype = MessageRecord.MSG_TYPE_MIX;
        messageForMixedMsg.msgElemList = arrayList2;
        messageForMixedMsg.prewrite();
        return messageForMixedMsg;
    }

    public MessageForLongMsg(ArrayList<MessageRecord> arrayList) {
        this.fragmentListSyncLock = new Object();
        this.mIsCutAtInfoLocal = false;
        this.mHasPullHistorySourceMsg = false;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        this.longMsgFragmentList = arrayList2;
        MessageRecord messageRecord = (MessageRecord) arrayList2.get(0);
        MessageRecord.copyMessageRecordBaseField(this, messageRecord);
        if (messageRecord instanceof MessageForReplyText) {
            this.atInfoList = ((MessageForReplyText) messageRecord).atInfoList;
        }
        this.msgtype = MessageRecord.MSG_TYPE_LONG_TEXT;
        for (MessageRecord messageRecord2 : this.longMsgFragmentList) {
            if (!(messageRecord2 instanceof MessageForText) && !(messageRecord2 instanceof MessageForReplyText)) {
                this.msgtype = MessageRecord.MSG_TYPE_LONG_MIX;
            }
            if (messageRecord2.extraflag == 32768 && messageRecord2.isSendFromLocal()) {
                this.extraflag = 32768;
            }
        }
    }
}
