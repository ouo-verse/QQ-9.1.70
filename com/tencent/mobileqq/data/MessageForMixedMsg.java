package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.guild.api.msg.impl.GuildMsgElementApiImpl;
import com.tencent.imcore.message.ad;
import com.tencent.mobileqq.activity.ChatTextSizeSettingActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.structmsg.view.ap;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.troop.robot.api.ITroopRobotService;
import com.tencent.mqp.app.sec.MQPSensitiveMsgUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import localpb.richMsg.MixedMsg$Elem;
import localpb.richMsg.MixedMsg$Msg;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$RichText;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForMixedMsg extends ChatMessage {
    private static final String TAG = "MessageForMixedMsg";
    public String aioShowMsg;
    public int forwardID;
    public AtTroopMemberInfo mAtInfo;
    public int mForwardFromIsTroop;
    public String mForwardFromUin;
    public long mForwardFromUniSeq;
    public int mRichTextLength;
    public List<MessageRecord> msgElemList;
    protected boolean mHasReplyText = false;
    public boolean mIsResend = false;
    public Object msgElemListSyncLock = new Object();

    public static void copyBaseInfoFromMixedToNormal(MessageRecord messageRecord, MessageForMixedMsg messageForMixedMsg) {
        messageRecord.senderuin = messageForMixedMsg.senderuin;
        messageRecord.selfuin = messageForMixedMsg.selfuin;
        messageRecord.frienduin = messageForMixedMsg.frienduin;
        messageRecord.time = messageForMixedMsg.time;
        messageRecord.issend = messageForMixedMsg.issend;
        messageRecord.istroop = messageForMixedMsg.istroop;
        messageRecord.shmsgseq = messageForMixedMsg.shmsgseq;
        messageRecord.uniseq = messageForMixedMsg.uniseq;
        messageRecord.msgseq = messageForMixedMsg.msgseq;
    }

    public static void copyBaseInfoFromMixedToPic(MessageForPic messageForPic, MessageForMixedMsg messageForMixedMsg) {
        messageForPic.senderuin = messageForMixedMsg.senderuin;
        messageForPic.selfuin = messageForMixedMsg.selfuin;
        messageForPic.frienduin = messageForMixedMsg.frienduin;
        messageForPic.time = messageForMixedMsg.time;
        messageForPic.issend = messageForMixedMsg.issend;
        messageForPic.istroop = messageForMixedMsg.istroop;
        messageForPic.shmsgseq = messageForMixedMsg.shmsgseq;
        messageForPic.msgtype = -2000;
        messageForPic.uniseq = messageForMixedMsg.uniseq;
        messageForPic.msgseq = messageForMixedMsg.msgseq;
    }

    public static void copyBaseInfoFromMixedToVideo(MessageRecord messageRecord, MessageForMixedMsg messageForMixedMsg) {
        messageRecord.senderuin = messageForMixedMsg.senderuin;
        messageRecord.selfuin = messageForMixedMsg.selfuin;
        messageRecord.frienduin = messageForMixedMsg.frienduin;
        messageRecord.time = messageForMixedMsg.time;
        messageRecord.issend = messageForMixedMsg.issend;
        messageRecord.istroop = messageForMixedMsg.istroop;
        messageRecord.shmsgseq = messageForMixedMsg.shmsgseq;
        messageRecord.msgtype = MessageRecord.MSG_TYPE_MEDIA_SHORTVIDEO;
        messageRecord.uniseq = messageForMixedMsg.uniseq;
        messageRecord.msgseq = messageForMixedMsg.msgseq;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003f, code lost:
    
        if (android.text.TextUtils.isEmpty(r6) == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0041, code lost:
    
        r4 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006c, code lost:
    
        if (r6.equals("\n") == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String getReplySummary(MessageRecord messageRecord) {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder(32);
        if (messageRecord instanceof MessageForMixedMsg) {
            List<MessageRecord> list = ((MessageForMixedMsg) messageRecord).msgElemList;
            int size = list.size();
            boolean z16 = false;
            boolean z17 = false;
            for (int i3 = 0; i3 < size; i3++) {
                MessageRecord messageRecord2 = list.get(i3);
                if ((messageRecord2 instanceof MessageForReplyText) && !z16) {
                    CharSequence charSequence = ((MessageForReplyText) messageRecord2).charStr;
                    if (charSequence != null) {
                        str2 = charSequence.toString();
                    } else {
                        str2 = messageRecord2.f203106msg;
                        if (str2 == null) {
                            str2 = "";
                        }
                    }
                    sb5.append(str2);
                } else {
                    if ((messageRecord2 instanceof MessageForText) && !z16) {
                        CharSequence charSequence2 = ((MessageForText) messageRecord2).charStr;
                        if (charSequence2 != null) {
                            str = charSequence2.toString();
                        } else {
                            str = messageRecord2.f203106msg;
                            if (str == null) {
                                str = "";
                            }
                        }
                        sb5.append(str);
                        if (!TextUtils.isEmpty(str)) {
                        }
                    } else if ((messageRecord2 instanceof MessageForPic) && !z17) {
                        sb5.append(((MessageForPic) messageRecord2).getSummaryMsg());
                        z17 = true;
                    }
                    if (z17 && z16) {
                        break;
                    }
                }
            }
        } else if (messageRecord instanceof MessageForLongMsg) {
            MessageForLongMsg messageForLongMsg = (MessageForLongMsg) messageRecord;
            synchronized (messageForLongMsg.fragmentListSyncLock) {
                int size2 = messageForLongMsg.longMsgFragmentList.size();
                boolean z18 = false;
                boolean z19 = false;
                for (int i16 = 0; i16 < size2; i16++) {
                    MessageRecord messageRecord3 = messageForLongMsg.longMsgFragmentList.get(i16);
                    if ((messageRecord3 instanceof MessageForReplyText) && !z18) {
                        sb5.append(((MessageForReplyText) messageRecord3).f203106msg);
                    } else if ((messageRecord3 instanceof MessageForText) && !z18) {
                        sb5.append(((MessageForText) messageRecord3).f203106msg);
                    } else {
                        if (messageRecord3 instanceof MessageForMixedMsg) {
                            MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) messageRecord3;
                            int size3 = messageForMixedMsg.msgElemList.size();
                            for (int i17 = 0; i17 < size3; i17++) {
                                MessageRecord messageRecord4 = messageForMixedMsg.msgElemList.get(i17);
                                if ((messageRecord4 instanceof MessageForReplyText) && !z18) {
                                    if (!TextUtils.isEmpty(messageRecord4.f203106msg)) {
                                        sb5.append(((MessageForReplyText) messageRecord4).f203106msg);
                                        z18 = true;
                                    }
                                } else if ((messageRecord4 instanceof MessageForText) && !z18) {
                                    sb5.append(((MessageForText) messageRecord4).f203106msg);
                                    z18 = true;
                                } else {
                                    if ((messageRecord4 instanceof MessageForPic) && !z19) {
                                        sb5.append(((MessageForPic) messageRecord4).getSummaryMsg());
                                        z19 = true;
                                    }
                                }
                            }
                        } else if (messageRecord3 instanceof MessageForPic) {
                            sb5.append(((MessageForPic) messageRecord3).getSummaryMsg());
                            z19 = true;
                        }
                        if (!z19 && z18) {
                            break;
                        }
                    }
                    z18 = true;
                    if (!z19) {
                    }
                }
            }
        }
        return sb5.toString();
    }

    public static CharSequence getTextFromMixedMsg(ChatMessage chatMessage) {
        AbsShareMsg absShareMsg;
        List<AbsStructMsgElement> list;
        AbsStructMsgElement absStructMsgElement;
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder(32);
        int i3 = 0;
        if (chatMessage instanceof MessageForMixedMsg) {
            List<MessageRecord> list2 = ((MessageForMixedMsg) chatMessage).msgElemList;
            int size = list2.size();
            while (i3 < size) {
                MessageRecord messageRecord = list2.get(i3);
                if (messageRecord instanceof MessageForReplyText) {
                    CharSequence charSequence = ((MessageForReplyText) messageRecord).charStr;
                    if (charSequence != null) {
                        str2 = charSequence.toString();
                    } else {
                        str2 = messageRecord.f203106msg;
                        if (str2 == null) {
                            str2 = "";
                        }
                    }
                    sb5.append(str2);
                } else if (messageRecord instanceof MessageForText) {
                    CharSequence charSequence2 = ((MessageForText) messageRecord).charStr;
                    if (charSequence2 != null) {
                        str = charSequence2.toString();
                    } else {
                        str = messageRecord.f203106msg;
                        if (str == null) {
                            str = "";
                        }
                    }
                    sb5.append(str);
                } else if (messageRecord instanceof MessageForPic) {
                    sb5.append(((MessageForPic) messageRecord).getSummaryMsg());
                } else if (messageRecord instanceof MessageForShortVideo) {
                    sb5.append(((MessageForShortVideo) messageRecord).getSummaryMsg());
                }
                i3++;
            }
        } else if (chatMessage instanceof MessageForLongMsg) {
            MessageForLongMsg messageForLongMsg = (MessageForLongMsg) chatMessage;
            synchronized (messageForLongMsg.fragmentListSyncLock) {
                int size2 = messageForLongMsg.longMsgFragmentList.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    MessageRecord messageRecord2 = messageForLongMsg.longMsgFragmentList.get(i16);
                    if (messageRecord2 instanceof MessageForReplyText) {
                        sb5.append(((MessageForReplyText) messageRecord2).f203106msg);
                    } else if (messageRecord2 instanceof MessageForText) {
                        sb5.append(((MessageForText) messageRecord2).f203106msg);
                    } else if (messageRecord2 instanceof MessageForMixedMsg) {
                        MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) messageRecord2;
                        int size3 = messageForMixedMsg.msgElemList.size();
                        for (int i17 = 0; i17 < size3; i17++) {
                            MessageRecord messageRecord3 = messageForMixedMsg.msgElemList.get(i17);
                            if (messageRecord3 instanceof MessageForReplyText) {
                                if (!TextUtils.isEmpty(messageRecord3.f203106msg)) {
                                    sb5.append(((MessageForReplyText) messageRecord3).f203106msg);
                                }
                            } else if (messageRecord3 instanceof MessageForText) {
                                sb5.append(((MessageForText) messageRecord3).f203106msg);
                            } else if (messageRecord3 instanceof MessageForPic) {
                                sb5.append(((MessageForPic) messageRecord3).getSummaryMsg());
                            }
                        }
                    } else if (messageRecord2 instanceof MessageForPic) {
                        sb5.append(((MessageForPic) messageRecord2).getSummaryMsg());
                    }
                }
            }
        } else if (chatMessage instanceof MessageForStructing) {
            if (!QfavUtil.C(chatMessage)) {
                return "";
            }
            AbsStructMsg absStructMsg = ((MessageForStructing) chatMessage).structingMsg;
            if ((absStructMsg instanceof AbsShareMsg) && (list = (absShareMsg = (AbsShareMsg) absStructMsg).mStructMsgItemLists) != null && list.size() > 0 && (absStructMsgElement = absShareMsg.mStructMsgItemLists.get(0)) != null && (absStructMsgElement instanceof com.tencent.mobileqq.structmsg.a)) {
                Iterator<AbsStructMsgElement> it = ((com.tencent.mobileqq.structmsg.a) absStructMsgElement).U0.iterator();
                while (it.hasNext()) {
                    AbsStructMsgElement next = it.next();
                    if (next instanceof StructMsgItemTitle) {
                        i3++;
                        if (i3 == 1) {
                            continue;
                        } else {
                            if (i3 > 3) {
                                break;
                            }
                            String trim = trim(((StructMsgItemTitle) next).X0.replaceFirst(":  ", ":"));
                            if (sb5.length() != 0) {
                                sb5.append("\r\n");
                            }
                            sb5.append(trim);
                        }
                    } else {
                        boolean z16 = next instanceof ap;
                    }
                }
            }
        }
        return sb5.toString();
    }

    public static String getTextFromMixedMsgForForwardPreview(ChatMessage chatMessage) {
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder(32);
        if (chatMessage instanceof MessageForMixedMsg) {
            List<MessageRecord> list = ((MessageForMixedMsg) chatMessage).msgElemList;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                MessageRecord messageRecord = list.get(i3);
                String str3 = "";
                if (messageRecord instanceof MessageForReplyText) {
                    CharSequence charSequence = ((MessageForReplyText) messageRecord).charStr;
                    if (charSequence != null) {
                        str2 = charSequence.toString();
                    } else {
                        String str4 = messageRecord.f203106msg;
                        if (str4 != null) {
                            str3 = str4;
                        }
                        str2 = str3;
                    }
                    sb5.append("[\u56de\u590d\u6d88\u606f]");
                    if (!TextUtils.isEmpty(str2)) {
                        sb5.append(str2 + " ");
                    }
                } else if (messageRecord instanceof MessageForText) {
                    CharSequence charSequence2 = ((MessageForText) messageRecord).charStr;
                    if (charSequence2 != null) {
                        str = charSequence2.toString();
                    } else {
                        String str5 = messageRecord.f203106msg;
                        if (str5 != null) {
                            str3 = str5;
                        }
                        str = str3;
                    }
                    if (!TextUtils.isEmpty(str)) {
                        sb5.append(str + " ");
                    }
                } else if (messageRecord instanceof MessageForPic) {
                    sb5.append(((MessageForPic) messageRecord).getSummaryMsg());
                    sb5.append(" ");
                }
            }
            if (sb5.length() > 0) {
                sb5.deleteCharAt(sb5.length() - 1);
            }
        }
        return sb5.toString();
    }

    public static CharSequence getTextFromMixedMsgForMail(ChatMessage chatMessage, List<String> list, List<String> list2) {
        String f16;
        String f17;
        String f18;
        String str;
        String str2;
        StringBuilder sb5 = new StringBuilder("");
        if (chatMessage instanceof MessageForMixedMsg) {
            MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) chatMessage;
            int size = messageForMixedMsg.msgElemList.size();
            for (int i3 = 0; i3 < size; i3++) {
                MessageRecord messageRecord = messageForMixedMsg.msgElemList.get(i3);
                if (messageRecord instanceof MessageForReplyText) {
                    CharSequence charSequence = ((MessageForReplyText) messageRecord).charStr;
                    if (charSequence != null) {
                        str2 = charSequence.toString();
                    } else {
                        str2 = messageRecord.f203106msg;
                    }
                    sb5.append(str2);
                } else if (messageRecord instanceof MessageForText) {
                    CharSequence charSequence2 = ((MessageForText) messageRecord).charStr;
                    if (charSequence2 != null) {
                        str = charSequence2.toString();
                    } else {
                        str = messageRecord.f203106msg;
                    }
                    sb5.append(str);
                } else if ((messageRecord instanceof MessageForPic) && (f18 = com.tencent.mobileqq.msgforward.a.f((MessageForPic) messageRecord, list, list2)) != null) {
                    sb5.append(f18);
                }
            }
        } else if (chatMessage instanceof MessageForLongMsg) {
            MessageForLongMsg messageForLongMsg = (MessageForLongMsg) chatMessage;
            synchronized (messageForLongMsg.fragmentListSyncLock) {
                int size2 = messageForLongMsg.longMsgFragmentList.size();
                for (int i16 = 0; i16 < size2; i16++) {
                    MessageRecord messageRecord2 = messageForLongMsg.longMsgFragmentList.get(i16);
                    if (messageRecord2 instanceof MessageForReplyText) {
                        sb5.append(((MessageForReplyText) messageRecord2).f203106msg);
                    } else if (messageRecord2 instanceof MessageForText) {
                        sb5.append(((MessageForText) messageRecord2).f203106msg);
                    } else if (messageRecord2 instanceof MessageForMixedMsg) {
                        MessageForMixedMsg messageForMixedMsg2 = (MessageForMixedMsg) messageRecord2;
                        int size3 = messageForMixedMsg2.msgElemList.size();
                        for (int i17 = 0; i17 < size3; i17++) {
                            MessageRecord messageRecord3 = messageForMixedMsg2.msgElemList.get(i17);
                            if (messageRecord3 instanceof MessageForReplyText) {
                                if (!TextUtils.isEmpty(messageRecord3.f203106msg)) {
                                    sb5.append(((MessageForReplyText) messageRecord3).f203106msg);
                                }
                            } else if (messageRecord3 instanceof MessageForText) {
                                sb5.append(((MessageForText) messageRecord3).f203106msg);
                            } else if ((messageRecord3 instanceof MessageForPic) && (f17 = com.tencent.mobileqq.msgforward.a.f((MessageForPic) messageRecord3, list, list2)) != null) {
                                sb5.append(f17);
                            }
                        }
                    } else if ((messageRecord2 instanceof MessageForPic) && (f16 = com.tencent.mobileqq.msgforward.a.f((MessageForPic) messageRecord2, list, list2)) != null) {
                        sb5.append(f16);
                    }
                }
            }
        }
        return sb5.toString();
    }

    public static String trim(String str) {
        if (str == null) {
            return "";
        }
        try {
            if ("".equals(str)) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer(str.replace("\r\n", " ").replace("\n", " "));
            while (stringBuffer.length() > 0 && Character.isWhitespace(stringBuffer.charAt(0))) {
                stringBuffer.deleteCharAt(0);
            }
            for (int length = stringBuffer.length(); length > 0; length = stringBuffer.length()) {
                int i3 = length - 1;
                if (!Character.isWhitespace(stringBuffer.charAt(i3))) {
                    break;
                }
                stringBuffer.deleteCharAt(i3);
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            QLog.e(TAG, 1, "TextUtils|trim|execption:" + str);
            if (str == null) {
                return "";
            }
            return str;
        }
    }

    public boolean canSelectable() {
        boolean z16;
        List<MessageRecord> list = this.msgElemList;
        if (list != null) {
            Iterator<MessageRecord> it = list.iterator();
            while (it.hasNext()) {
                if (it.next() instanceof MessageForText) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (QLog.isColorLevel()) {
            QLog.e(TAG, 2, "canSelect: " + z16);
        }
        return z16;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x043f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0429 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0144  */
    @Override // com.tencent.mobileqq.data.ChatMessage
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void doParse() {
        char c16;
        int i3;
        boolean z16;
        String extInfoFromExtStr;
        boolean parseBoolean;
        boolean z17;
        HashMap hashMap;
        HashMap hashMap2;
        HashMap hashMap3;
        ArrayList<AtTroopMemberInfo> troopMemberInfoFromExtrJson;
        HashMap hashMap4;
        boolean z18;
        im_msg_body$RichText im_msg_body_richtext;
        im_msg_body$RichText im_msg_body_richtext2;
        im_msg_body$RichText im_msg_body_richtext3;
        im_msg_body$RichText im_msg_body_richtext4;
        HashMap hashMap5 = new HashMap();
        HashMap hashMap6 = new HashMap();
        HashMap hashMap7 = new HashMap();
        HashMap hashMap8 = new HashMap();
        List<MessageRecord> list = this.msgElemList;
        if (list != null) {
            for (MessageRecord messageRecord : list) {
                if (messageRecord instanceof MessageForPic) {
                    MessageForPic messageForPic = (MessageForPic) messageRecord;
                    String str = messageForPic.uuid;
                    if (str != null && str.length() > 0 && (im_msg_body_richtext2 = messageForPic.richText) != null) {
                        hashMap5.put(messageForPic.uuid, im_msg_body_richtext2);
                    }
                    String str2 = messageForPic.path;
                    if (str2 != null && str2.length() > 0 && (im_msg_body_richtext = messageForPic.richText) != null) {
                        hashMap6.put(messageForPic.path, im_msg_body_richtext);
                    }
                } else if (messageRecord instanceof MessageForShortVideo) {
                    MessageForShortVideo messageForShortVideo = (MessageForShortVideo) messageRecord;
                    String str3 = messageForShortVideo.uuid;
                    if (str3 != null && str3.length() > 0 && (im_msg_body_richtext4 = messageForShortVideo.richText) != null) {
                        hashMap7.put(messageForShortVideo.uuid, im_msg_body_richtext4);
                    }
                    String str4 = messageForShortVideo.videoFileName;
                    if (str4 != null && str4.length() > 0 && (im_msg_body_richtext3 = messageForShortVideo.richText) != null) {
                        hashMap8.put(messageForShortVideo.videoFileName, im_msg_body_richtext3);
                    }
                }
            }
        }
        MixedMsg$Msg mixedMsg$Msg = new MixedMsg$Msg();
        StringBuilder sb5 = new StringBuilder(32);
        StringBuilder sb6 = new StringBuilder(32);
        StringBuilder sb7 = new StringBuilder(32);
        try {
            mixedMsg$Msg.mergeFrom(this.msgData);
        } catch (InvalidProtocolBufferMicroException e16) {
            QLog.e(TAG, 2, "doParse error", e16);
        }
        int size = mixedMsg$Msg.elems.get().size();
        ArrayList arrayList = new ArrayList(size);
        if (size == 0) {
            this.msgElemList = arrayList;
            if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "MessageForMixedMsg.doParse no element");
                return;
            }
            return;
        }
        String extInfoFromExtStr2 = getExtInfoFromExtStr("disc_at_info_list");
        String extInfoFromExtStr3 = getExtInfoFromExtStr("troop_at_info_list");
        JSONObject jSONObject = null;
        try {
            if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "MessageForMixedMsg.doParse disc_at_info_list extStr " + extInfoFromExtStr2);
                }
                jSONObject = new JSONObject(extInfoFromExtStr2);
                c16 = 1;
            } else {
                c16 = 0;
            }
        } catch (JSONException e17) {
            e = e17;
            c16 = 0;
        }
        try {
            if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "MessageForMixedMsg.doParse troop_at_info_list extStr " + extInfoFromExtStr3);
                }
                jSONObject = new JSONObject(extInfoFromExtStr3);
                c16 = 2;
            }
        } catch (JSONException e18) {
            e = e18;
            QLog.e(TAG, 1, "get mixJSONO error:", e);
            JSONObject jSONObject2 = jSONObject;
            i3 = 0;
            z16 = false;
            while (i3 < size) {
            }
            this.msgElemList = arrayList;
            this.f203106msg = sb5.toString();
            this.aioShowMsg = sb7.toString();
            if (z16) {
            }
            extInfoFromExtStr = getExtInfoFromExtStr("sens_msg_need_parse");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            }
            parseBoolean = true;
            if (parseBoolean) {
            }
            if (!parseBoolean) {
            }
        }
        JSONObject jSONObject22 = jSONObject;
        i3 = 0;
        z16 = false;
        while (i3 < size) {
            MixedMsg$Elem mixedMsg$Elem = mixedMsg$Msg.elems.get().get(i3);
            MixedMsg$Msg mixedMsg$Msg2 = mixedMsg$Msg;
            int i16 = size;
            if (mixedMsg$Elem.sourceMsgInfo.has()) {
                try {
                    MessageForReplyText messageForReplyText = new MessageForReplyText();
                    hashMap3 = hashMap8;
                    try {
                        messageForReplyText.mSourceMsgInfo = (MessageForReplyText.SourceMsgInfo) MessagePkgUtils.getObjectFromBytes(HexUtil.hexStr2Bytes(mixedMsg$Elem.sourceMsgInfo.get()));
                        if (mixedMsg$Elem.textMsg.has()) {
                            messageForReplyText.f203106msg = mixedMsg$Elem.textMsg.get();
                            hashMap2 = hashMap7;
                            try {
                                hashMap = hashMap6;
                                try {
                                    messageForReplyText.charStr = new QQText(messageForReplyText.f203106msg, 45, ChatTextSizeSettingActivity.getChatEmotionSizeWithDP(), this);
                                    copyBaseInfoFromMixedToNormal(messageForReplyText, this);
                                } catch (Exception e19) {
                                    e = e19;
                                    if (QLog.isColorLevel()) {
                                    }
                                    this.mHasReplyText = true;
                                    hashMap8 = hashMap3;
                                    hashMap7 = hashMap2;
                                    hashMap4 = hashMap;
                                    i3++;
                                    hashMap6 = hashMap4;
                                    mixedMsg$Msg = mixedMsg$Msg2;
                                    size = i16;
                                }
                            } catch (Exception e26) {
                                e = e26;
                                hashMap = hashMap6;
                                if (QLog.isColorLevel()) {
                                    QLog.d(TAG, 2, e.getMessage());
                                }
                                this.mHasReplyText = true;
                                hashMap8 = hashMap3;
                                hashMap7 = hashMap2;
                                hashMap4 = hashMap;
                                i3++;
                                hashMap6 = hashMap4;
                                mixedMsg$Msg = mixedMsg$Msg2;
                                size = i16;
                            }
                        } else {
                            hashMap = hashMap6;
                            hashMap2 = hashMap7;
                        }
                        if (messageForReplyText.mSourceMsgInfo != null) {
                            messageForReplyText.setSourceMessageRecord(messageForReplyText.mSourceMsgInfo.unPackSourceMsg(MessageForReplyText.getAppInterface()));
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.MSG, 2, "doParse sourceMessage ok");
                            }
                        }
                        if (jSONObject22 != null) {
                            JSONArray optJSONArray = jSONObject22.optJSONArray("" + i3);
                            if (optJSONArray != null && !TextUtils.isEmpty(optJSONArray.toString()) && (troopMemberInfoFromExtrJson = MessageForText.getTroopMemberInfoFromExtrJson(optJSONArray.toString())) != null && troopMemberInfoFromExtrJson.size() > 0) {
                                messageForReplyText.atInfoList = troopMemberInfoFromExtrJson;
                            }
                        }
                        arrayList.add(messageForReplyText);
                        String str5 = messageForReplyText.f203106msg;
                        if (str5 != null) {
                            sb5.append(str5);
                            sb6.append(messageForReplyText.f203106msg);
                            sb7.append(messageForReplyText.f203106msg);
                        }
                    } catch (Exception e27) {
                        e = e27;
                        hashMap = hashMap6;
                        hashMap2 = hashMap7;
                    }
                } catch (Exception e28) {
                    e = e28;
                    hashMap = hashMap6;
                    hashMap2 = hashMap7;
                    hashMap3 = hashMap8;
                }
                this.mHasReplyText = true;
            } else {
                hashMap = hashMap6;
                hashMap2 = hashMap7;
                hashMap3 = hashMap8;
                if (mixedMsg$Elem.textMsg.has()) {
                    MessageForText messageForText = new MessageForText();
                    messageForText.frienduin = this.frienduin;
                    String str6 = mixedMsg$Elem.textMsg.get();
                    messageForText.f203106msg = str6;
                    messageForText.msgData = str6.getBytes();
                    if (this.istroop == 10014) {
                        messageForText.istroop = 10014;
                    }
                    if (jSONObject22 != null) {
                        if (c16 == 1) {
                            JSONArray optJSONArray2 = jSONObject22.optJSONArray("" + i3);
                            if (optJSONArray2 != null && !TextUtils.isEmpty(optJSONArray2.toString())) {
                                com.tencent.mobileqq.troop.text.a.m(3000, optJSONArray2.toString(), messageForText);
                            }
                        } else {
                            if (c16 == 2) {
                                JSONArray optJSONArray3 = jSONObject22.optJSONArray("" + i3);
                                if (optJSONArray3 != null && !TextUtils.isEmpty(optJSONArray3.toString())) {
                                    z18 = true;
                                    com.tencent.mobileqq.troop.text.a.m(1, optJSONArray3.toString(), messageForText);
                                    messageForText.doParse(z18);
                                    ((ITroopRobotService) MessageForReplyText.getAppInterface().getRuntimeService(ITroopRobotService.class, "all")).preProcessMessageMoreDetail(messageForText);
                                    arrayList.add(messageForText);
                                    sb5.append(messageForText.f203106msg);
                                    sb7.append(messageForText.f203106msg);
                                    if (!TextUtils.isEmpty(messageForText.msg2)) {
                                        sb6.append(messageForText.msg2);
                                        z16 = z18;
                                    } else {
                                        sb6.append(messageForText.f203106msg);
                                    }
                                }
                            }
                            z18 = true;
                            messageForText.doParse(z18);
                            ((ITroopRobotService) MessageForReplyText.getAppInterface().getRuntimeService(ITroopRobotService.class, "all")).preProcessMessageMoreDetail(messageForText);
                            arrayList.add(messageForText);
                            sb5.append(messageForText.f203106msg);
                            sb7.append(messageForText.f203106msg);
                            if (!TextUtils.isEmpty(messageForText.msg2)) {
                            }
                        }
                    }
                    z18 = true;
                    messageForText.doParse(z18);
                    ((ITroopRobotService) MessageForReplyText.getAppInterface().getRuntimeService(ITroopRobotService.class, "all")).preProcessMessageMoreDetail(messageForText);
                    arrayList.add(messageForText);
                    sb5.append(messageForText.f203106msg);
                    sb7.append(messageForText.f203106msg);
                    if (!TextUtils.isEmpty(messageForText.msg2)) {
                    }
                } else {
                    if (mixedMsg$Elem.picMsg.has()) {
                        MessageForPic messageForPic2 = new MessageForPic();
                        messageForPic2.msgData = mixedMsg$Elem.picMsg.get().toByteArray();
                        if (this.istroop == 10014) {
                            messageForPic2.istroop = 10014;
                        }
                        messageForPic2.doParse();
                        String str7 = messageForPic2.uuid;
                        if (str7 != null && str7.length() > 0 && hashMap5.get(messageForPic2.uuid) != null) {
                            messageForPic2.richText = (im_msg_body$RichText) hashMap5.get(messageForPic2.uuid);
                        } else {
                            String str8 = messageForPic2.path;
                            if (str8 != null && str8.length() > 0) {
                                hashMap4 = hashMap;
                                if (hashMap4.get(messageForPic2.path) != null) {
                                    messageForPic2.richText = (im_msg_body$RichText) hashMap4.get(messageForPic2.path);
                                }
                                messageForPic2.subMsgId = i3;
                                copyBaseInfoFromMixedToPic(messageForPic2, this);
                                arrayList.add(messageForPic2);
                                String summaryMsg = messageForPic2.getSummaryMsg();
                                sb5.append(summaryMsg);
                                sb6.append(summaryMsg);
                            }
                        }
                        hashMap4 = hashMap;
                        messageForPic2.subMsgId = i3;
                        copyBaseInfoFromMixedToPic(messageForPic2, this);
                        arrayList.add(messageForPic2);
                        String summaryMsg2 = messageForPic2.getSummaryMsg();
                        sb5.append(summaryMsg2);
                        sb6.append(summaryMsg2);
                    } else {
                        hashMap4 = hashMap;
                        if (!mixedMsg$Elem.markfaceMsg.has() && mixedMsg$Elem.videoMsg.has()) {
                            MessageForShortVideo messageForShortVideo2 = new MessageForShortVideo();
                            messageForShortVideo2.msgData = mixedMsg$Elem.videoMsg.get().toByteArray();
                            if (this.istroop == 10014) {
                                messageForShortVideo2.istroop = 10014;
                            }
                            messageForShortVideo2.doParse();
                            String str9 = messageForShortVideo2.uuid;
                            if (str9 != null && str9.length() > 0 && hashMap5.get(messageForShortVideo2.uuid) != null) {
                                hashMap7 = hashMap2;
                                messageForShortVideo2.richText = (im_msg_body$RichText) hashMap7.get(messageForShortVideo2.uuid);
                            } else {
                                hashMap7 = hashMap2;
                                String str10 = messageForShortVideo2.videoFileName;
                                if (str10 != null && str10.length() > 0 && hashMap4.get(messageForShortVideo2.videoFileName) != null) {
                                    hashMap8 = hashMap3;
                                    messageForShortVideo2.richText = (im_msg_body$RichText) hashMap8.get(messageForShortVideo2.videoFileName);
                                    messageForShortVideo2.subMsgId = i3;
                                    copyBaseInfoFromMixedToVideo(messageForShortVideo2, this);
                                    arrayList.add(messageForShortVideo2);
                                    String summaryMsg3 = messageForShortVideo2.getSummaryMsg();
                                    sb5.append(summaryMsg3);
                                    sb6.append(summaryMsg3);
                                    i3++;
                                    hashMap6 = hashMap4;
                                    mixedMsg$Msg = mixedMsg$Msg2;
                                    size = i16;
                                }
                            }
                            hashMap8 = hashMap3;
                            messageForShortVideo2.subMsgId = i3;
                            copyBaseInfoFromMixedToVideo(messageForShortVideo2, this);
                            arrayList.add(messageForShortVideo2);
                            String summaryMsg32 = messageForShortVideo2.getSummaryMsg();
                            sb5.append(summaryMsg32);
                            sb6.append(summaryMsg32);
                            i3++;
                            hashMap6 = hashMap4;
                            mixedMsg$Msg = mixedMsg$Msg2;
                            size = i16;
                        }
                    }
                    hashMap8 = hashMap3;
                    hashMap7 = hashMap2;
                    i3++;
                    hashMap6 = hashMap4;
                    mixedMsg$Msg = mixedMsg$Msg2;
                    size = i16;
                }
            }
            hashMap8 = hashMap3;
            hashMap7 = hashMap2;
            hashMap4 = hashMap;
            i3++;
            hashMap6 = hashMap4;
            mixedMsg$Msg = mixedMsg$Msg2;
            size = i16;
        }
        this.msgElemList = arrayList;
        this.f203106msg = sb5.toString();
        this.aioShowMsg = sb7.toString();
        if (z16) {
            this.msg2 = sb6.toString();
        }
        extInfoFromExtStr = getExtInfoFromExtStr("sens_msg_need_parse");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            try {
                parseBoolean = Boolean.parseBoolean(extInfoFromExtStr);
            } catch (Exception e29) {
                e29.printStackTrace();
            }
            if (parseBoolean && (BaseActivity.sTopActivity instanceof MultiForwardActivity)) {
                parseBoolean = false;
            }
            if (!parseBoolean) {
                return;
            }
            String extInfoFromExtStr4 = getExtInfoFromExtStr("sens_msg_ctrl_info");
            if (!TextUtils.isEmpty(extInfoFromExtStr4)) {
                String extInfoFromExtStr5 = getExtInfoFromExtStr("sens_msg_confirmed");
                if (!TextUtils.isEmpty(extInfoFromExtStr5) && extInfoFromExtStr5.equalsIgnoreCase("1")) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    for (MessageRecord messageRecord2 : this.msgElemList) {
                        if (messageRecord2 instanceof MessageForText) {
                            messageRecord2.saveExtInfoToExtStr("sens_msg_original_text", messageRecord2.f203106msg);
                        }
                    }
                }
                MQPSensitiveMsgUtil.k(this, this.msgElemList, z17, HexUtil.hexStr2Bytes(extInfoFromExtStr4));
            }
            try {
                this.mRobotFlag = Integer.parseInt(getExtInfoFromExtStr("is_to_robot"));
                return;
            } catch (Exception unused) {
                return;
            }
        }
        parseBoolean = true;
        if (parseBoolean) {
            parseBoolean = false;
        }
        if (!parseBoolean) {
        }
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public String getContentForSearch() {
        try {
            StringBuilder sb5 = new StringBuilder(64);
            for (MessageRecord messageRecord : this.msgElemList) {
                if (messageRecord instanceof MessageForPic) {
                    sb5.append(GuildMsgElementApiImpl.DESC_ELEMENT_PIC);
                } else if (messageRecord instanceof MessageForReplyText) {
                    if (!TextUtils.isEmpty(messageRecord.f203106msg)) {
                        sb5.append(messageRecord.f203106msg);
                    }
                } else if (messageRecord instanceof MessageForText) {
                    sb5.append(messageRecord.f203106msg);
                }
            }
            return sb5.toString();
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "MessageForMixedMsg.getContentForSearch failure: ", th5);
                return null;
            }
            return null;
        }
    }

    public List<MessageRecord> getPicMsgList() {
        List<MessageRecord> list = this.msgElemList;
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (MessageRecord messageRecord : this.msgElemList) {
                if (messageRecord instanceof MessageForPic) {
                    arrayList.add(messageRecord);
                }
            }
            return arrayList;
        }
        return null;
    }

    public MessageForReplyText getReplyMessage(QQAppInterface qQAppInterface) {
        return null;
    }

    public MessageRecord getSubMessage(long j3) {
        if (this.msgElemList != null && j3 >= 0 && j3 < r0.size()) {
            return this.msgElemList.get((int) j3);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return getTextFromMixedMsg(this).toString();
    }

    public boolean hasReplyText() {
        return this.mHasReplyText;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean isSupportFTS() {
        return ad.s(this.istroop);
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public void parse() {
        super.parse();
        for (MessageRecord messageRecord : this.msgElemList) {
            if ((messageRecord instanceof MessageForPic) && messageRecord.uniseq != this.uniseq) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " Error : Info not Equals : child : " + messageRecord.uniseq + " parent:" + this.uniseq);
                }
                copyBaseInfoFromMixedToPic((MessageForPic) messageRecord, this);
            }
            if ((messageRecord instanceof MessageForReplyText) && messageRecord.uniseq != this.uniseq) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " Error : Info not Equals : child : " + messageRecord.uniseq + " parent:" + this.uniseq);
                }
                copyBaseInfoFromMixedToNormal(messageRecord, this);
            }
            if ((messageRecord instanceof MessageForShortVideo) && messageRecord.uniseq != this.uniseq) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, " Video Error : Info not Equals : child : " + messageRecord.uniseq + " parent:" + this.uniseq);
                }
                copyBaseInfoFromMixedToVideo(messageRecord, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        this.msgId = MessageRecord.getLogicMsgID(getId(), this.versionCode);
        parse();
    }

    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        List<MessageRecord> list = this.msgElemList;
        if (list != null && list.size() >= 1) {
            MixedMsg$Msg mixedMsg$Msg = new MixedMsg$Msg();
            for (MessageRecord messageRecord : this.msgElemList) {
                MixedMsg$Elem mixedMsg$Elem = new MixedMsg$Elem();
                if (messageRecord instanceof MessageForText) {
                    String extInfoFromExtStr = getExtInfoFromExtStr("sens_msg_original_text");
                    if (TextUtils.isEmpty(extInfoFromExtStr)) {
                        extInfoFromExtStr = ((MessageForText) messageRecord).f203106msg;
                    }
                    mixedMsg$Elem.textMsg.set(extInfoFromExtStr);
                } else if (messageRecord instanceof MessageForPic) {
                    mixedMsg$Elem.picMsg.set(((MessageForPic) messageRecord).getSerialPB());
                } else if (messageRecord instanceof MessageForReplyText) {
                    MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                    if (!TextUtils.isEmpty(messageForReplyText.f203106msg)) {
                        mixedMsg$Elem.textMsg.set(messageForReplyText.f203106msg);
                    }
                    try {
                        MessageForReplyText.SourceMsgInfo sourceMsgInfo = messageForReplyText.mSourceMsgInfo;
                        if (sourceMsgInfo != null) {
                            sourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), messageForReplyText.getSourceMessage());
                        }
                        mixedMsg$Elem.sourceMsgInfo.set(HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(messageForReplyText.mSourceMsgInfo)));
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.i(TAG, 2, "MessagePkgUtils.getBytesFromObject get Exception:" + e16.getMessage());
                        }
                    }
                    this.mHasReplyText = true;
                } else if (messageRecord instanceof MessageForMarketFace) {
                    QLog.e(TAG, 1, "prewrite err unSupported" + messageRecord);
                } else if (messageRecord instanceof MessageForShortVideo) {
                    mixedMsg$Elem.videoMsg.set(((MessageForShortVideo) messageRecord).getSerialPB());
                } else {
                    QLog.e(TAG, 1, "prewrite err unSupported" + messageRecord);
                }
                mixedMsg$Msg.elems.get().add(mixedMsg$Elem);
            }
            this.msgData = mixedMsg$Msg.toByteArray();
            saveExtInfoToExtStr("is_to_robot", this.mRobotFlag + "");
            return;
        }
        QLog.e(TAG, 1, "prewrite err null elemList");
    }

    public MessageRecord rebuildMixedMsg() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (this.msgElemListSyncLock) {
            for (MessageRecord messageRecord : this.msgElemList) {
                if (messageRecord instanceof MessageForText) {
                    arrayList.add(messageRecord);
                } else if (messageRecord instanceof MessageForPic) {
                    if (!arrayList.isEmpty()) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            String str = ((MessageRecord) it.next()).f203106msg;
                            if (str == null) {
                                str = "";
                            }
                            stringBuffer.append(str);
                        }
                        MessageForText messageForText = (MessageForText) q.d(-1000);
                        messageForText.msgtype = -1000;
                        messageForText.f203106msg = stringBuffer.toString();
                        stringBuffer.delete(0, stringBuffer.length());
                        arrayList2.add(messageForText);
                        arrayList.clear();
                    }
                    arrayList2.add((MessageForPic) messageRecord.deepCopyByReflect());
                } else if (messageRecord instanceof MessageForReplyText) {
                    MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord.deepCopyByReflect();
                    if (((MessageForReplyText) messageRecord).getSourceMessage() != null) {
                        messageForReplyText.deepCopySourceMsg((MessageForReplyText) messageRecord);
                    }
                    arrayList2.add(messageForReplyText);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                String str2 = ((MessageRecord) it5.next()).f203106msg;
                if (str2 == null) {
                    str2 = "";
                }
                stringBuffer.append(str2);
            }
            MessageForText messageForText2 = (MessageForText) q.d(-1000);
            messageForText2.msgtype = -1000;
            messageForText2.f203106msg = stringBuffer.toString();
            stringBuffer.delete(0, stringBuffer.length());
            arrayList2.add(messageForText2);
            arrayList.clear();
        }
        MessageForMixedMsg messageForMixedMsg = (MessageForMixedMsg) q.d(MessageRecord.MSG_TYPE_MIX);
        MessageRecord.copyMessageRecordBaseField(messageForMixedMsg, this);
        messageForMixedMsg.msgtype = MessageRecord.MSG_TYPE_MIX;
        messageForMixedMsg.msgElemList = arrayList2;
        messageForMixedMsg.prewrite();
        return messageForMixedMsg;
    }

    public byte[] upateMessageForPic(MessageForPic messageForPic) {
        int length;
        if (messageForPic == null) {
            return this.msgData;
        }
        if (this.msgElemList == null) {
            return this.msgData;
        }
        MixedMsg$Msg mixedMsg$Msg = new MixedMsg$Msg();
        for (MessageRecord messageRecord : this.msgElemList) {
            MixedMsg$Elem mixedMsg$Elem = new MixedMsg$Elem();
            if (messageRecord instanceof MessageForReplyText) {
                String extInfoFromExtStr = getExtInfoFromExtStr("sens_msg_original_text");
                MessageForReplyText messageForReplyText = (MessageForReplyText) messageRecord;
                if (TextUtils.isEmpty(extInfoFromExtStr)) {
                    extInfoFromExtStr = messageForReplyText.f203106msg;
                }
                if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                    mixedMsg$Elem.textMsg.set(extInfoFromExtStr);
                }
                try {
                    MessageForReplyText.SourceMsgInfo sourceMsgInfo = messageForReplyText.mSourceMsgInfo;
                    if (sourceMsgInfo != null) {
                        sourceMsgInfo.packSourceMsg(MessageForReplyText.getAppInterface(), messageForReplyText.getSourceMessage());
                    }
                    mixedMsg$Elem.sourceMsgInfo.set(HexUtil.bytes2HexStr(MessagePkgUtils.getBytesFromObject(messageForReplyText.mSourceMsgInfo)));
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.i(TAG, 2, "MessagePkgUtils.getBytesFromObject get Exception:" + e16.getMessage());
                    }
                }
            } else if (messageRecord instanceof MessageForText) {
                String extInfoFromExtStr2 = getExtInfoFromExtStr("sens_msg_original_text");
                if (TextUtils.isEmpty(extInfoFromExtStr2)) {
                    extInfoFromExtStr2 = ((MessageForText) messageRecord).f203106msg;
                }
                mixedMsg$Elem.textMsg.set(extInfoFromExtStr2);
            } else if (messageRecord instanceof MessageForPic) {
                MessageForPic messageForPic2 = (MessageForPic) messageRecord;
                if (messageForPic2.uniseq == messageForPic.uniseq && messageForPic2.subMsgId == messageForPic.subMsgId) {
                    mixedMsg$Elem.picMsg.set(messageForPic.getSerialPB());
                } else {
                    mixedMsg$Elem.picMsg.set(messageForPic2.getSerialPB());
                }
            } else {
                boolean z16 = messageRecord instanceof MessageForMarketFace;
            }
            mixedMsg$Msg.elems.get().add(mixedMsg$Elem);
        }
        this.msgData = mixedMsg$Msg.toByteArray();
        if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("upateMessageForPic");
            byte[] bArr = this.msgData;
            if (bArr == null) {
                length = 0;
            } else {
                length = bArr.length;
            }
            sb5.append(length);
            QLog.i(TAG, 2, sb5.toString());
        }
        return this.msgData;
    }
}
