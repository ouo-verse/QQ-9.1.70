package com.tencent.mobileqq.troop.shortcutbar.importantmsg;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.am;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.i;
import com.tencent.mobileqq.service.message.p;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.ImportantMsgItem;
import com.tencent.mobileqq.troop.shortcutbar.importantmsg.c;
import com.tencent.mobileqq.utils.bt;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import msf.msgcomm.msg_comm$MsgHead;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$MsgBody;
import tencent.im.oidb.cmd0xea3.oidb_0xea3$BackMsg;

/* compiled from: P */
/* loaded from: classes19.dex */
public class d {
    static IPatchRedirector $redirector_;

    public static void a(QQAppInterface qQAppInterface, oidb_0xea3$BackMsg oidb_0xea3_backmsg, List<MessageRecord> list) {
        boolean z16;
        long j3;
        long j16;
        long j17;
        boolean z17;
        if (qQAppInterface != null && oidb_0xea3_backmsg != null && list != null) {
            try {
                MessageHandler msgHandler = qQAppInterface.getMsgHandler();
                if (oidb_0xea3_backmsg.f435995msg.has()) {
                    msg_comm$Msg msg_comm_msg = new msg_comm$Msg();
                    msg_comm_msg.mergeFrom(oidb_0xea3_backmsg.f435995msg.get().toByteArray());
                    int i3 = 0;
                    if (msg_comm_msg.msg_head.has()) {
                        msg_comm$MsgHead msg_comm_msghead = msg_comm_msg.msg_head.get();
                        if (msg_comm_msghead.group_info.has() && msg_comm_msghead.group_info.get().group_type.get() == 127) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        long j18 = msg_comm_msghead.msg_seq.get();
                        long j19 = msg_comm_msghead.msg_time.get();
                        long j26 = msg_comm_msghead.from_uin.get();
                        z16 = z17;
                        j17 = j26;
                        j16 = j19;
                        j3 = j18;
                    } else {
                        z16 = false;
                        j3 = 0;
                        j16 = 0;
                        j17 = 0;
                    }
                    if (msg_comm_msg.content_head.has()) {
                        i3 = msg_comm_msg.content_head.get().pkg_num.get();
                    }
                    int i16 = i3;
                    if (msg_comm_msg.msg_body.has()) {
                        im_msg_body$MsgBody im_msg_body_msgbody = msg_comm_msg.msg_body.get();
                        if (im_msg_body_msgbody.rich_text.has()) {
                            if (im_msg_body_msgbody.rich_text.get().ptt.has()) {
                                new com.tencent.mobileqq.service.message.codec.decoder.f().a(msgHandler, msg_comm_msg, list, null);
                            } else {
                                p.f(msgHandler, list, msg_comm_msg, false, false, new com.tencent.mobileqq.troop.data.c());
                            }
                        }
                    }
                    if (list.size() == 0 && i16 > 1) {
                        if (QLog.isColorLevel()) {
                            QLog.i("ImportantMsgUtil", 2, "<---decodeSinglePbMsg_GroupDis, empty long msg fragment");
                        }
                        MessageForText messageForText = (MessageForText) q.d(-1000);
                        messageForText.msgtype = -1000;
                        messageForText.f203106msg = "";
                        list.add(messageForText);
                    }
                    for (MessageRecord messageRecord : list) {
                        if (z16) {
                            messageRecord.msgtype = -2006;
                        }
                        messageRecord.time = j16;
                        messageRecord.shmsgseq = j3;
                        messageRecord.senderuin = String.valueOf(j17);
                    }
                }
            } catch (InvalidProtocolBufferMicroException e16) {
                e16.printStackTrace();
            }
        }
    }

    public static ImportantMsgItem.MsgInfo b(long j3) {
        return new ImportantMsgItem.MsgInfo(0L, j3, "", 0, "", true, 0);
    }

    public static int c(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return -1;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(i.F);
        if (TextUtils.isEmpty(extInfoFromExtStr)) {
            return -1;
        }
        try {
            return Integer.parseInt(extInfoFromExtStr);
        } catch (NumberFormatException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private static String d(QQAppInterface qQAppInterface, Context context, MessageRecord messageRecord) {
        Message message = new Message();
        MessageRecord.copyMessageRecordBaseField(message, messageRecord);
        message.emoRecentMsg = null;
        message.fileType = -1;
        qQAppInterface.getMessageFacade().w(message);
        MsgSummary msgSummary = new MsgSummary();
        bt.b(context, qQAppInterface, message, message.istroop, msgSummary, "", false, false);
        return msgSummary.d(context).toString();
    }

    public static String e(QQAppInterface qQAppInterface, Context context, MessageRecord messageRecord, int i3) {
        c.a b16;
        c cVar = (c) am.s().x(658);
        if (cVar == null || (b16 = cVar.b(i3)) == null) {
            return "";
        }
        int i16 = b16.f298729c;
        if (i16 == 0) {
            return f(qQAppInterface, context, i3, messageRecord);
        }
        if (i16 == 1) {
            return b16.f298730d;
        }
        if (i16 != 2) {
            return "";
        }
        return d(qQAppInterface, context, messageRecord);
    }

    private static String f(QQAppInterface qQAppInterface, Context context, int i3, MessageRecord messageRecord) {
        if (messageRecord == null) {
            return "";
        }
        if (i3 == 1) {
            return i(messageRecord);
        }
        if (i3 == 3) {
            return g(messageRecord);
        }
        if (i3 == 2) {
            return k(messageRecord);
        }
        if (i3 == 4) {
            return j(messageRecord);
        }
        if (i3 == 5) {
            return h(messageRecord, false);
        }
        if (i3 != 6) {
            return "";
        }
        return h(messageRecord, true);
    }

    private static String g(MessageRecord messageRecord) {
        ArkAppMessage arkAppMessage;
        String string = BaseApplication.getContext().getResources().getString(R.string.f2342979k);
        if ((messageRecord instanceof MessageForArkApp) && (arkAppMessage = ((MessageForArkApp) messageRecord).ark_app_message) != null) {
            try {
                JSONObject optJSONObject = new JSONObject(arkAppMessage.metaList).optJSONObject("albumData");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("title", "");
                    String optString2 = optJSONObject.optString(AEEditorConstants.ALBUMNAME, "");
                    if (!optString.isEmpty() && !optString2.isEmpty()) {
                        String str = "\u300a" + optString2 + "\u300b";
                        if (optString.startsWith(str)) {
                            return optString.substring(str.length());
                        }
                    } else if (optString2.isEmpty() && !optString.isEmpty()) {
                        return optString;
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return string;
    }

    private static String h(MessageRecord messageRecord, boolean z16) {
        AbsStructMsg d16;
        String str;
        String string = BaseApplication.getContext().getResources().getString(R.string.f2343079l);
        if (z16) {
            string = BaseApplication.getContext().getResources().getString(R.string.f2343279n);
        }
        if (messageRecord instanceof MessageForArkApp) {
            ArkAppMessage arkAppMessage = ((MessageForArkApp) messageRecord).ark_app_message;
            if (arkAppMessage != null && (str = arkAppMessage.appName) != null) {
                if (str.equals("com.tencent.structmsg")) {
                    try {
                        JSONObject optJSONObject = new JSONObject(arkAppMessage.metaList).optJSONObject("news");
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("title", "");
                            if (!optString.isEmpty()) {
                                return optString;
                            }
                        }
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    }
                } else if (arkAppMessage.appName.equals("com.tencent.miniapp_01")) {
                    try {
                        JSONObject optJSONObject2 = new JSONObject(arkAppMessage.metaList).optJSONObject("detail_1");
                        if (optJSONObject2 != null) {
                            String optString2 = optJSONObject2.optString("desc", "");
                            if (!optString2.isEmpty()) {
                                return optString2;
                            }
                        }
                    } catch (JSONException e17) {
                        e17.printStackTrace();
                    }
                }
            }
        } else if ((messageRecord instanceof MessageForStructing) && (d16 = com.tencent.mobileqq.structmsg.i.d(messageRecord.msgData)) != null && (d16 instanceof StructMsgForGeneralShare)) {
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) d16;
            if (!TextUtils.isEmpty(structMsgForGeneralShare.mContentTitle)) {
                return structMsgForGeneralShare.mContentTitle;
            }
        }
        return string;
    }

    private static String i(MessageRecord messageRecord) {
        String string = BaseApplication.getContext().getResources().getString(R.string.f2343179m);
        if (messageRecord instanceof MessageForTroopFile) {
            MessageForTroopFile messageForTroopFile = (MessageForTroopFile) messageRecord;
            if (!TextUtils.isEmpty(messageForTroopFile.fileName)) {
                return messageForTroopFile.fileName;
            }
        }
        return string;
    }

    private static String j(MessageRecord messageRecord) {
        AbsStructMsg d16;
        String string = BaseApplication.getContext().getResources().getString(R.string.f2343379o);
        if (messageRecord instanceof MessageForArkApp) {
            ArkAppMessage arkAppMessage = ((MessageForArkApp) messageRecord).ark_app_message;
            if (arkAppMessage != null && !TextUtils.isEmpty(arkAppMessage.getSummery())) {
                return arkAppMessage.getSummery();
            }
        } else if ((messageRecord instanceof MessageForStructing) && (d16 = com.tencent.mobileqq.structmsg.i.d(messageRecord.msgData)) != null && (d16 instanceof StructMsgForGeneralShare)) {
            StructMsgForGeneralShare structMsgForGeneralShare = (StructMsgForGeneralShare) d16;
            if (!TextUtils.isEmpty(structMsgForGeneralShare.mContentTitle)) {
                return structMsgForGeneralShare.mContentTitle;
            }
        }
        return string;
    }

    private static String k(MessageRecord messageRecord) {
        ArkAppMessage arkAppMessage;
        String string = BaseApplication.getContext().getResources().getString(R.string.f2343479p);
        if ((messageRecord instanceof MessageForArkApp) && (arkAppMessage = ((MessageForArkApp) messageRecord).ark_app_message) != null) {
            try {
                JSONObject optJSONObject = new JSONObject(arkAppMessage.metaList).optJSONObject("mannounce");
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString("text", "");
                    if (!optString.isEmpty()) {
                        return new String(Base64.decode(optString, 2));
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return string;
    }

    public static boolean l(MessageRecord messageRecord) {
        if (messageRecord == null) {
            return false;
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr(i.E);
        if (TextUtils.isEmpty(extInfoFromExtStr) || !extInfoFromExtStr.equals("1")) {
            return false;
        }
        return true;
    }

    public static boolean m(MessageRecord messageRecord) {
        if (messageRecord == null || messageRecord.msgtype != -2006) {
            return false;
        }
        return true;
    }

    private static boolean n(MessageRecord messageRecord) {
        JSONObject optJSONObject;
        if (messageRecord != null && (messageRecord instanceof MessageForArkApp)) {
            MessageForArkApp messageForArkApp = (MessageForArkApp) messageRecord;
            try {
                if (messageForArkApp.ark_app_message != null && (optJSONObject = new JSONObject(messageForArkApp.ark_app_message.metaList).optJSONObject("mannounce")) != null) {
                    if (optJSONObject.optInt("tw", 1) == 0) {
                        return true;
                    }
                }
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00c7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<ImportantMsgItem.MsgInfo> o(QQAppInterface qQAppInterface, long j3, List<MessageRecord> list, boolean z16) {
        String e16;
        boolean z17;
        int i3;
        int i16;
        if (list == null) {
            return null;
        }
        ArrayList<ImportantMsgItem.MsgInfo> arrayList = new ArrayList<>();
        for (MessageRecord messageRecord : list) {
            int c16 = c(messageRecord);
            if (z16 || (l(messageRecord) && -1 != c16)) {
                long j16 = messageRecord.time;
                long j17 = messageRecord.shmsgseq;
                String str = messageRecord.senderuin;
                String str2 = "";
                if (m(messageRecord)) {
                    QLog.i("ImportantMsgUtil", 1, "parseImportantMsg isRevokedMsg troopUin:" + j3 + " msgSeq:" + j17);
                    i16 = 2;
                } else if (n(messageRecord)) {
                    QLog.i("ImportantMsgUtil", 1, "parseImportantMsg isTroopNotificationShowWindow troopUin:" + j3 + " msgSeq:" + j17);
                    i16 = 4;
                } else {
                    e16 = e(qQAppInterface, BaseApplication.getContext(), messageRecord, c16);
                    if (TextUtils.isEmpty(e16)) {
                        QLog.i("ImportantMsgUtil", 1, "parseImportantMsg msgSummary == null troopUin:" + j3 + " msgSeq:" + j17);
                        i3 = 3;
                        e16 = "";
                        z17 = false;
                    } else {
                        z17 = true;
                        i3 = 0;
                    }
                    if (!TextUtils.isEmpty(e16)) {
                        str2 = e16;
                    }
                    arrayList.add(new ImportantMsgItem.MsgInfo(j16, j17, str, c16, str2, z17, i3));
                }
                z17 = false;
                i3 = i16;
                e16 = "";
                if (!TextUtils.isEmpty(e16)) {
                }
                arrayList.add(new ImportantMsgItem.MsgInfo(j16, j17, str, c16, str2, z17, i3));
            }
        }
        return arrayList;
    }
}
