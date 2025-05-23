package com.tencent.mobileqq.data;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qq.e.comm.constants.TangramAppConstants;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.sdk.util.UinConfigManager;
import cooperation.qwallet.plugin.IQWalletHelper;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.MobileQQ;
import msf.msgcomm.msg_comm$Msg;
import org.json.JSONObject;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$QQWalletAioBody;
import tencent.im.msg.im_msg_body$QQWalletMsg;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MessageForQQWalletMsg extends ChatMessage {
    public static final int FROM_HB_AIO = 0;
    public static final int FROM_HB_LIST = 1;
    public static final int MSG_TYPE_AA_PAY = 16;
    public static final int MSG_TYPE_BIRTHDAY = 30;
    public static final int MSG_TYPE_COMMAND_REDPACKET = 6;
    public static final int MSG_TYPE_COMMON_REDPACKET = 2;
    public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY = 7;
    public static final int MSG_TYPE_COMMON_REDPACKET_SPECIFY_OVER_3 = 11;
    public static final int MSG_TYPE_COMMON_THEME_REDPACKET = 4;
    public static final int MSG_TYPE_CONTINUE = 27;
    public static final int MSG_TYPE_DRAW_REDPACKET = 22;
    public static final int MSG_TYPE_DRAW_REDPACKET_MULTI_MODEL = 26;
    public static final int MSG_TYPE_EMOJI_REDPACKET = 19;
    public static final int MSG_TYPE_FESTIVAL = 32;
    public static final int MSG_TYPE_GOLD_REDPACKET = 23;
    public static final int MSG_TYPE_H5_COMMON_REDPACKET = 20;
    public static final int MSG_TYPE_H5_REDPACKET = 17;
    public static final int MSG_TYPE_IDIOM_SOLITAIRE = 21;
    public static final int MSG_TYPE_INDIVIDUAL_REDPACKET = 2001;
    public static final int MSG_TYPE_KEYWORD = 25;
    public static final int MSG_TYPE_KSONG_REDPACKET = 18;
    public static final int MSG_TYPE_KUAKUA = 28;
    public static final int MSG_TYPE_LOOK_REDPACKET = 14;
    public static final int MSG_TYPE_LUCY_REDPACKET = 3;
    public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY = 8;
    public static final int MSG_TYPE_LUCY_REDPACKET_SPECIFY_OVER_3 = 12;
    public static final int MSG_TYPE_LUCY_THEME_REDPACKET = 5;
    public static final int MSG_TYPE_PAYER = 9;
    public static final int MSG_TYPE_PAYER_NOTIFY = 10;
    public static final int MSG_TYPE_PUBLIC_ACCOUNT_REDPACKET = 2002;
    public static final int MSG_TYPE_SHENGPIZI = 29;
    public static final int MSG_TYPE_SPECIFY_GUILD = 31;
    public static final int MSG_TYPE_TRANSFER = 1;
    public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET = 13;
    public static final int MSG_TYPE_VOICE_COMMAND_REDPACKET_C2C = 15;
    public static final int MSG_TYPE_WORDCHAIN = 24;
    private static final int PROCESS_MSG_TYPE_ABORT = 1;
    private static final int PROCESS_MSG_TYPE_NORMAL = 2;
    private static final int PROCESS_MSG_TYPE_TEXT = 3;
    public static final int QQWALLET_TYPE_REDPACKET = 2;
    public static final int QQWALLET_TYPE_TRANSFER = 1;
    public static final int SUBVERSION_REDPACKET = 2;
    public static final int SUBVERSION_TRANSFER = 4;
    private static final String TAG = "MessageForQQWalletMsg";
    public static final int VERSION1 = 1;
    public static final int VERSION17 = 17;
    public static final int VERSION2 = 2;
    public static final int VERSION32 = 32;
    public int fromHBList;
    public boolean isLoadFinish;
    public QQWalletRedPacketMsg mQQWalletRedPacketMsg;
    public QQWalletTransferMsg mQQWalletTransferMsg;
    public int messageType;
    public Bitmap specifyIcon;
    public static int[] mMsgTypeForAio = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 2002, 17, 18, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 31, 32};
    public static int[] mMsgTypeForGuild = {2, 3, 31};
    private static Set<Integer> sNeverSupportType = new HashSet<Integer>() { // from class: com.tencent.mobileqq.data.MessageForQQWalletMsg.1
        {
            add(19);
        }
    };
    private static final Map<Integer, Integer> sMsgType2RedType = new HashMap<Integer, Integer>() { // from class: com.tencent.mobileqq.data.MessageForQQWalletMsg.2
        {
            put(6, 0);
            put(13, 1);
            put(15, 1);
            put(18, 2);
            put(19, 3);
            put(22, 5);
            put(26, 5);
            put(23, 6);
            put(21, 4);
            put(24, 4);
            put(25, 4);
            put(27, 4);
            put(28, 7);
            put(29, 8);
        }
    };

    public MessageForQQWalletMsg() {
    }

    public static MessageForQQWalletMsg createQQWalletMsg(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            MessageForQQWalletMsg messageForQQWalletMsg = (MessageForQQWalletMsg) ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).createMsgRecordByMsgType(MessageRecord.MSG_TYPE_QQWALLET_MSG);
            messageForQQWalletMsg.msgtype = MessageRecord.MSG_TYPE_QQWALLET_MSG;
            messageForQQWalletMsg.messageType = jSONObject.getInt(QQBrowserActivity.KEY_MSG_TYPE);
            messageForQQWalletMsg.mQQWalletTransferMsg = null;
            QQWalletRedPacketMsg createRedPacketMsg = createRedPacketMsg(jSONObject, str2);
            messageForQQWalletMsg.mQQWalletRedPacketMsg = createRedPacketMsg;
            if (createRedPacketMsg == null) {
                return null;
            }
            messageForQQWalletMsg.f203106msg = messageForQQWalletMsg.getMsgSummary();
            messageForQQWalletMsg.msgData = messageForQQWalletMsg.getBytes();
            return messageForQQWalletMsg;
        } catch (Exception unused) {
            return null;
        }
    }

    private static vk2.b createQWalletBaseMsgElem(JSONObject jSONObject) {
        if (jSONObject != null) {
            try {
                vk2.b bVar = new vk2.b();
                JSONObject jSONObject2 = jSONObject.getJSONObject("receiver");
                if (jSONObject2 == null) {
                    return null;
                }
                String string = jSONObject2.getString("nativeAndroid");
                bVar.f441775m = string;
                if (string.equals("")) {
                    return null;
                }
                bVar.f441763a = jSONObject2.getInt("background");
                bVar.f441764b = jSONObject2.getInt("icon");
                bVar.f441765c = jSONObject2.getString("title");
                bVar.f441766d = jSONObject2.getString("subtitle");
                bVar.f441767e = jSONObject2.getString("content");
                bVar.f441768f = jSONObject2.getString("linkurl");
                bVar.f441769g = jSONObject2.getString("blackstripe");
                bVar.f441770h = jSONObject2.getString(UinConfigManager.KEY_ADS);
                bVar.f441771i = jSONObject2.getInt("titleColor");
                bVar.f441772j = jSONObject2.getInt("subtitleColor");
                bVar.f441773k = jSONObject2.getString("actionsPriority");
                bVar.f441774l = jSONObject2.getString(WadlProxyConsts.KEY_JUMP_URL);
                bVar.f441776n = jSONObject2.getString(TangramAppConstants.ICON_URL);
                bVar.f441777o = -1;
                bVar.f441778p = -1;
                bVar.f441779q = "";
                bVar.f441780r = "";
                bVar.f441781s = "";
                return bVar;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static QQWalletRedPacketMsg createRedPacketMsg(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                im_msg_body$QQWalletAioBody im_msg_body_qqwalletaiobody = new im_msg_body$QQWalletAioBody();
                im_msg_body_qqwalletaiobody.sint32_channelid.set(jSONObject.getInt("channelid"));
                im_msg_body_qqwalletaiobody.sint32_templateid.set(jSONObject.getInt("templateid"));
                im_msg_body_qqwalletaiobody.uint32_resend.set(jSONObject.getInt("resend"));
                im_msg_body_qqwalletaiobody.sint32_redtype.set(jSONObject.getInt("redtype"));
                im_msg_body_qqwalletaiobody.sint32_envelopeid.set(-1);
                QQWalletRedPacketMsg qQWalletRedPacketMsg = new QQWalletRedPacketMsg(im_msg_body_qqwalletaiobody, str);
                qQWalletRedPacketMsg.redPacketId = jSONObject.getString("billno");
                qQWalletRedPacketMsg.authkey = jSONObject.getString("authkey");
                if (qQWalletRedPacketMsg.redPacketId.equals("")) {
                    return null;
                }
                vk2.b createQWalletBaseMsgElem = createQWalletBaseMsgElem(jSONObject);
                qQWalletRedPacketMsg.elem = createQWalletBaseMsgElem;
                if (createQWalletBaseMsgElem == null) {
                    return null;
                }
                return qQWalletRedPacketMsg;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public static void decodePBMsgElemWalletMsg(Object obj, BaseQQAppInterface baseQQAppInterface, List<im_msg_body$Elem> list, List<MessageRecord> list2, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, com.tencent.mobileqq.service.message.a aVar, boolean z16) {
        im_msg_body$QQWalletMsg im_msg_body_qqwalletmsg;
        int i3;
        int i16;
        Iterator<im_msg_body$Elem> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                im_msg_body$Elem next = it.next();
                if (next.qqwallet_msg.has()) {
                    im_msg_body_qqwalletmsg = next.qqwallet_msg.get();
                    break;
                }
            } else {
                im_msg_body_qqwalletmsg = null;
                break;
            }
        }
        if (im_msg_body_qqwalletmsg == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            sb5.append("elemType:QQWalletMsg;\n");
        }
        if (!im_msg_body_qqwalletmsg.aio_body.has()) {
            return;
        }
        int i17 = im_msg_body_qqwalletmsg.aio_body.sint32_msgtype.get();
        if (aVar == null) {
            i3 = 0;
        } else {
            i3 = aVar.f286163r;
        }
        int processMsgType = getProcessMsgType(i17, i3);
        if (processMsgType == 1) {
            return;
        }
        IQWalletTemp iQWalletTemp = (IQWalletTemp) QRoute.api(IQWalletTemp.class);
        if (processMsgType == 2) {
            MessageForQQWalletMsg messageForQQWalletMsg = (MessageForQQWalletMsg) ((IQWalletTemp) QRoute.api(IQWalletTemp.class)).createMsgRecordByMsgType(MessageRecord.MSG_TYPE_QQWALLET_MSG);
            if (messageForQQWalletMsg == null) {
                if (QLog.isColorLevel()) {
                    sb5.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
                    return;
                }
                return;
            }
            messageForQQWalletMsg.msgtype = MessageRecord.MSG_TYPE_QQWALLET_MSG;
            messageForQQWalletMsg.messageType = i17;
            messageForQQWalletMsg.f203106msg = messageForQQWalletMsg.getMsgSummary();
            messageForQQWalletMsg.msgData = messageForQQWalletMsg.getBytes();
            messageForQQWalletMsg.onDecodeFinish(baseQQAppInterface, msg_comm_msg);
            if (messageForQQWalletMsg.isMsgEmpty()) {
                if (QLog.isColorLevel()) {
                    sb5.append("c2cMsgContent.QQWalletTransferMsg:null or mqt:isMsgEmpty;\n");
                    return;
                }
                return;
            }
            if (im_msg_body_qqwalletmsg.aio_body.uint32_msg_priority.has()) {
                i16 = im_msg_body_qqwalletmsg.aio_body.uint32_msg_priority.get();
            } else {
                i16 = 10;
            }
            if (i16 >= 3) {
                list2.add(messageForQQWalletMsg);
            } else if (i16 >= 2) {
                iQWalletTemp.decodePBMsgElemsRichMsg(obj, list, list2, sb5, msg_comm_msg, cVar);
                if (list2.isEmpty()) {
                    list2.add(messageForQQWalletMsg);
                }
            } else if (i16 >= 1) {
                iQWalletTemp.decodePBMsgElemsRichMsg(obj, list, list2, sb5, msg_comm_msg, cVar);
                if (list2.isEmpty()) {
                    iQWalletTemp.decodePBMsgElemsText(obj, list, list2, sb5, msg_comm_msg, cVar);
                } else {
                    list2.add(messageForQQWalletMsg);
                }
            }
        } else {
            if (sNeverSupportType.contains(Integer.valueOf(i17))) {
                for (im_msg_body$Elem im_msg_body_elem : list) {
                    if (im_msg_body_elem.text.has()) {
                        im_msg_body$Text im_msg_body_text = im_msg_body_elem.text.get();
                        if (im_msg_body_text.str.has()) {
                            im_msg_body_text.str.set(ByteStringMicro.copyFromUtf8("[QQ\u7ea2\u5305]\u5f53\u524d\u5e73\u53f0\u7248\u672c\u6682\u4e0d\u652f\u6301\u8be5\u7c7b\u578b\u7ea2\u5305"));
                        }
                    }
                }
            }
            iQWalletTemp.decodePBMsgElemsText(obj, list, list2, sb5, msg_comm_msg, cVar);
        }
        if (baseQQAppInterface.getLongAccountUin() == msg_comm_msg.msg_head.from_uin.get()) {
            MobileQQ.sMobileQQ.sendBroadcast(new Intent("com.tencent.mobileqq.qwallet.send.message"));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int getProcessMsgType(int i3, int i16) {
        int i17 = 1;
        if (i3 <= 3000) {
            if (i3 <= 1000) {
                if (i16 == 10014) {
                    for (int i18 : mMsgTypeForGuild) {
                        if (i18 == i3) {
                            break;
                        }
                    }
                    i17 = 0;
                    if (i17 == 0) {
                        i17 = 3;
                    }
                } else {
                    for (int i19 : mMsgTypeForAio) {
                        if (i19 == i3) {
                            break;
                        }
                    }
                    i17 = 0;
                    if (i17 == 0) {
                    }
                }
            }
            i17 = 2;
        }
        if (QLog.isColorLevel()) {
            QLog.i(TAG, 2, "--msgType: " + i3 + ",processType:" + i17);
        }
        return i17;
    }

    public static Integer getRedTypeByMsgType(Integer num) {
        return sMsgType2RedType.get(num);
    }

    public static boolean isCommandRedPacketMsg(MessageRecord messageRecord) {
        if ((messageRecord instanceof MessageForQQWalletMsg) && ((MessageForQQWalletMsg) messageRecord).messageType == 6) {
            return true;
        }
        return false;
    }

    public static boolean isRedPacketMsg(MessageRecord messageRecord) {
        return ((IQWalletHbApi) QRoute.api(IQWalletHbApi.class)).isRedPacketMsg(messageRecord);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Not initialized variable reg: 5, insn: 0x008c: MOVE (r4 I:??[OBJECT, ARRAY]) = (r5 I:??[OBJECT, ARRAY]) (LINE:141), block:B:50:0x008c */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0087 -> B:14:0x008a). Please report as a decompilation issue!!! */
    @Override // com.tencent.mobileqq.data.ChatMessage
    public void doParse() {
        QwSafeInputStream qwSafeInputStream;
        QwSafeInputStream qwSafeInputStream2;
        int readInt;
        QwSafeInputStream qwSafeInputStream3 = null;
        try {
            try {
                try {
                    qwSafeInputStream2 = new QwSafeInputStream(this.msgData);
                } catch (Exception e16) {
                    e = e16;
                    qwSafeInputStream2 = null;
                } catch (Throwable th5) {
                    th = th5;
                    if (qwSafeInputStream3 != null) {
                        try {
                            qwSafeInputStream3.close();
                        } catch (Exception e17) {
                            QLog.e(TAG, 1, "doParse: ", e17);
                        }
                    }
                    throw th;
                }
            } catch (Exception e18) {
                QLog.e(TAG, 1, "doParse: ", e18);
            }
            try {
                readInt = qwSafeInputStream2.readInt();
            } catch (Exception e19) {
                e = e19;
                if (QLog.isColorLevel()) {
                    QLog.d(LogTag.QQWALLET_MSG, 2, "convert byte array to QQWalletMsg failed", e);
                }
                this.mQQWalletTransferMsg = null;
                this.mQQWalletRedPacketMsg = null;
                if (qwSafeInputStream2 != null) {
                    qwSafeInputStream2.close();
                }
                return;
            }
            if (readInt != 1 && readInt != 2) {
                if (readInt == 17) {
                    QQWalletRedPacketMsg qQWalletRedPacketMsg = new QQWalletRedPacketMsg();
                    this.mQQWalletRedPacketMsg = qQWalletRedPacketMsg;
                    qQWalletRedPacketMsg.readExternal(qwSafeInputStream2);
                } else if (readInt >= 32) {
                    int readInt2 = qwSafeInputStream2.readInt();
                    qwSafeInputStream2.readInt();
                    this.messageType = qwSafeInputStream2.readInt();
                    if (readInt2 == 1) {
                        QQWalletTransferMsg qQWalletTransferMsg = new QQWalletTransferMsg();
                        this.mQQWalletTransferMsg = qQWalletTransferMsg;
                        qQWalletTransferMsg.readExternal(qwSafeInputStream2);
                    } else if (readInt2 == 2) {
                        QQWalletRedPacketMsg qQWalletRedPacketMsg2 = new QQWalletRedPacketMsg();
                        this.mQQWalletRedPacketMsg = qQWalletRedPacketMsg2;
                        qQWalletRedPacketMsg2.readExternal(qwSafeInputStream2);
                    }
                }
                qwSafeInputStream2.close();
            }
            if (qwSafeInputStream2.readInt() == 1) {
                QQWalletTransferMsg qQWalletTransferMsg2 = new QQWalletTransferMsg();
                this.mQQWalletTransferMsg = qQWalletTransferMsg2;
                qQWalletTransferMsg2.readExternal(qwSafeInputStream2);
            }
            qwSafeInputStream2.close();
        } catch (Throwable th6) {
            th = th6;
            qwSafeInputStream3 = qwSafeInputStream;
        }
    }

    public byte[] getBytes() {
        prewrite();
        return this.msgData;
    }

    public int getIsHideTitleDefault() {
        vk2.b bVar;
        int i3;
        QQWalletRedPacketMsg qQWalletRedPacketMsg = this.mQQWalletRedPacketMsg;
        if (qQWalletRedPacketMsg == null || (bVar = qQWalletRedPacketMsg.elem) == null || bVar.f441784v <= 0 || (i3 = this.messageType) == 18 || i3 == 17 || i3 == 19 || i3 == 21 || i3 == 22 || i3 == 26 || i3 == 23 || i3 == 24 || i3 == 25 || i3 == 27 || i3 == 28 || i3 == 29 || i3 == 32) {
            return 0;
        }
        return 1;
    }

    public String getMsgSummary() {
        vk2.b bVar;
        vk2.b bVar2;
        QQWalletTransferMsg qQWalletTransferMsg = this.mQQWalletTransferMsg;
        if (qQWalletTransferMsg != null && (bVar2 = qQWalletTransferMsg.elem) != null) {
            return bVar2.f441770h;
        }
        QQWalletRedPacketMsg qQWalletRedPacketMsg = this.mQQWalletRedPacketMsg;
        if (qQWalletRedPacketMsg != null && (bVar = qQWalletRedPacketMsg.elem) != null) {
            return bVar.f441770h;
        }
        return "";
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public String getSummaryMsg() {
        return getMsgSummary();
    }

    public boolean isMsgEmpty() {
        if ((this.mQQWalletTransferMsg == null && this.mQQWalletRedPacketMsg == null) || this.msgData == null) {
            return true;
        }
        return false;
    }

    public boolean isRedPackExpired() {
        if (this.time + 90000 < NetConnInfoCenter.getServerTimeMillis() / 1000) {
            return true;
        }
        return false;
    }

    public boolean isSender() {
        String str = this.senderuin;
        if (str != null && str.equalsIgnoreCase(com.tencent.mobileqq.base.a.c())) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.data.ChatMessage
    public boolean isSupportReply() {
        return true;
    }

    @Override // com.tencent.mobileqq.data.MessageRecord
    public boolean needVipBubble() {
        return false;
    }

    public void onDecodeFinish(BaseQQAppInterface baseQQAppInterface, msg_comm$Msg msg_comm_msg) {
        long j3;
        PBUInt64Field pBUInt64Field;
        int i3 = msg_comm_msg.msg_head.msg_type.get();
        if (i3 != 82 && i3 != 43) {
            if (i3 != 83 && i3 != 42) {
                if (baseQQAppInterface.getCurrentAccountUin().equals(String.valueOf(msg_comm_msg.msg_head.to_uin.get()))) {
                    pBUInt64Field = msg_comm_msg.msg_head.from_uin;
                } else {
                    pBUInt64Field = msg_comm_msg.msg_head.to_uin;
                }
                j3 = pBUInt64Field.get();
            } else {
                j3 = msg_comm_msg.msg_head.discuss_info.discuss_uin.get();
            }
        } else {
            j3 = msg_comm_msg.msg_head.group_info.group_code.get();
        }
        this.frienduin = String.valueOf(j3);
        this.time = msg_comm_msg.msg_head.msg_time.get();
    }

    public HashMap<String, String> parseUrlParams(String str) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
            for (int i3 = 0; i3 < split.length; i3++) {
                if (!TextUtils.isEmpty(split[i3])) {
                    String[] split2 = split[i3].split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split2.length == 2) {
                        try {
                            String decode = URLDecoder.decode(split2[1], "UTF-8");
                            split2[1] = decode;
                            hashMap.put(split2[0], decode);
                        } catch (Exception e16) {
                            QLog.e(TAG, 1, "error msg in qqpay-api module: ", e16);
                            if (QLog.isColorLevel()) {
                                QLog.d(LogTag.QQWALLET_MSG, 2, "QQWalletMsgItemBuilder failed to URLDecoder.decode WalletAction value,tmps[1] is:" + split2[0] + ",tmps[1] is:" + split2[1], e16);
                            }
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void postRead() {
        parse();
        try {
            ((IPasswdRedBagService) ((IQWalletHelper) QRoute.api(IQWalletHelper.class)).getRuntime().getAppRuntime(this.selfuin).getRuntimeService(IPasswdRedBagService.class, "")).loadRedBagInfoToCache(true);
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "error msg in qqpay-api module: ", th5);
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QQWALLET_MSG, 2, "postRead init read status");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.data.MessageRecord, com.tencent.mobileqq.persistence.Entity
    public void prewrite() {
        ISafeStream iSafeStream = this.mQQWalletTransferMsg;
        if (iSafeStream == null && (iSafeStream = this.mQQWalletRedPacketMsg) == null) {
            iSafeStream = null;
        }
        if (iSafeStream != null) {
            byte[] flushMsgData = iSafeStream.flushMsgData(this.messageType);
            if (flushMsgData != null) {
                this.msgData = flushMsgData;
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(LogTag.QQWALLET_MSG, 2, "prewrite... ssp is null");
        }
    }

    public MessageForQQWalletMsg(long j3, long j16, long j17, long j18, int i3, long j19) {
        init(j3, j16, j17, "[QQWallet Msg]", j18, MessageRecord.MSG_TYPE_QQWALLET_MSG, i3, j19);
    }
}
