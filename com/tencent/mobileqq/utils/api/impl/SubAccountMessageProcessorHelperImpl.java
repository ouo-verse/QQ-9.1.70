package com.tencent.mobileqq.utils.api.impl;

import ActionMsg.MsgBody;
import IMMsgBodyPack.MsgType0x210;
import PushNotifyPack.RequestPushNotify;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.data.MessageForAniSticker;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import com.tencent.mobileqq.data.MessageForFuDai;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForPubAccount;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageForVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.codec.decoder.msgType0x210.MsgType0x210Decoder;
import com.tencent.mobileqq.service.message.e;
import com.tencent.mobileqq.service.message.q;
import com.tencent.mobileqq.service.message.s;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper;
import com.tencent.mobileqq.utils.c;
import com.tencent.mobileqq.utils.h;
import com.tencent.qphone.base.util.QLog;
import tencent.im.msgsync.cmd0x100.Submsgtype0x8a$ReqBody;

/* loaded from: classes20.dex */
public class SubAccountMessageProcessorHelperImpl implements ISubAccountMessageProcessorHelper {
    @Override // com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper
    public String buildBaseMsg(AppInterface appInterface, MessageRecord messageRecord, String str) {
        switch (messageRecord.msgtype) {
            case -8018:
                return buildBaseMsgForMediaAniSticker(appInterface, messageRecord, str);
            case MessageRecord.MSG_TYPE_ARK_BABYQ_REPLY /* -5016 */:
                if (messageRecord instanceof MessageForArkBabyqReply) {
                    MessageForArkBabyqReply messageForArkBabyqReply = (MessageForArkBabyqReply) messageRecord;
                    messageForArkBabyqReply.parse();
                    return messageForArkBabyqReply.babyqReplyText;
                }
                return str;
            case MessageRecord.MSG_TYPE_LIFEONLINEACCOUNT /* -5004 */:
            case MessageRecord.MSG_TYPE_PUBLIC_ACCOUNT /* -3006 */:
                return buildBaseMsgForPublicAccount(appInterface, messageRecord, str);
            case MessageRecord.MSG_TYPE_GUILD_MARK_DOWN /* -4052 */:
                return buildBaseMsgForMarkdown(messageRecord, str);
            case MessageRecord.MSG_TYPE_STICKER_MSG /* -2058 */:
                return appInterface.getApp().getResources().getString(R.string.hpz);
            case MessageRecord.MSG_TYPE_STRUCT_MSG /* -2011 */:
                return buildBaseMsgForStruct(appInterface, messageRecord, str);
            case -2007:
                return buildBaseMsgForMediaMarkFace(appInterface, messageRecord, str);
            case -2005:
                return buildBaseMsgForMediaFile(appInterface, messageRecord, str);
            case -2002:
                return appInterface.getApp().getResources().getString(R.string.ael);
            case -2000:
                return buildBaseMsgForMediaPic(appInterface, messageRecord, str);
            default:
                return buildBaseMsgForDefault(appInterface, messageRecord, str);
        }
    }

    String buildBaseMsgForDefault(AppInterface appInterface, MessageRecord messageRecord, String str) {
        String str2;
        MessageForVideo messageForVideo;
        String[] strArr;
        try {
            String str3 = "";
            if (c.h(messageRecord.msgtype)) {
                MsgBody a16 = c.a(messageRecord.f203106msg);
                if (a16 != null) {
                    String str4 = a16.actMsgContentValue;
                    if (str4 != null && str4.length() > 0) {
                        str = a16.actMsgContentValue;
                    } else {
                        AppShareID d06 = ((e) appInterface.getMsgCache()).d0(h.g(a16.shareAppID));
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(appInterface.getApp().getString(R.string.f170387pe));
                        if (d06 != null) {
                            str3 = d06.messagetail + appInterface.getApp().getString(R.string.f170388pf);
                        }
                        sb5.append(str3);
                        str = sb5.toString();
                    }
                }
            } else if (c.i(messageRecord.msgtype)) {
                if (messageRecord instanceof MessageForVideo) {
                    messageForVideo = (MessageForVideo) messageRecord;
                } else {
                    messageForVideo = null;
                }
                if (messageForVideo != null) {
                    String str5 = messageRecord.f203106msg;
                    if (str5 != null) {
                        strArr = str5.split("\\|");
                    } else {
                        strArr = null;
                    }
                    if (strArr != null && strArr.length > 0) {
                        str = strArr[0].trim();
                    }
                }
            } else {
                String str6 = messageRecord.f203106msg;
                if (str6 != null && str6.indexOf(AppConstants.GOOGLEMAP_URL_HTTPS) != -1) {
                    String[] m3 = s.m(messageRecord.f203106msg);
                    if (m3 != null && (str2 = m3[2]) != null) {
                        str3 = str2;
                    }
                    str = "[" + appInterface.getApp().getString(R.string.f173220i45) + "] " + str3;
                }
            }
            return str;
        } catch (Exception e16) {
            e16.printStackTrace();
            if (!QLog.isColorLevel()) {
                return null;
            }
            QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + e16.getMessage());
            return null;
        }
    }

    String buildBaseMsgForMarkdown(MessageRecord messageRecord, String str) {
        if (messageRecord instanceof MessageRecordForMarkdown) {
            return ((MessageRecordForMarkdown) messageRecord).getParsedText();
        }
        return str;
    }

    String buildBaseMsgForMediaAniSticker(AppInterface appInterface, MessageRecord messageRecord, String str) {
        String string = appInterface.getApp().getResources().getString(R.string.f230186yg);
        if (messageRecord instanceof MessageForAniSticker) {
            MessageForAniSticker messageForAniSticker = (MessageForAniSticker) messageRecord;
            if (!TextUtils.isEmpty(messageForAniSticker.text) && messageForAniSticker.text.length() > 1) {
                return "[" + messageForAniSticker.text.substring(1) + "]";
            }
            return string;
        }
        return string;
    }

    String buildBaseMsgForMediaFile(AppInterface appInterface, MessageRecord messageRecord, String str) {
        String[] split;
        String[] split2;
        String str2 = messageRecord.f203106msg;
        String str3 = null;
        try {
            if (!TextUtils.isEmpty(str2) && (split = str2.split("/")) != null && split.length > 0 && (split2 = split[split.length - 1].split("\\|")) != null && split2.length > 0) {
                str3 = split2[0];
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(str3)) {
            return appInterface.getApp().getResources().getString(R.string.aef);
        }
        if (!str3.equalsIgnoreCase(appInterface.getApp().getResources().getString(R.string.aef))) {
            return appInterface.getApp().getResources().getString(R.string.aef) + str3;
        }
        return str3;
    }

    String buildBaseMsgForMediaMarkFace(AppInterface appInterface, MessageRecord messageRecord, String str) {
        if (messageRecord instanceof MessageForMarketFace) {
            MarkFaceMessage markFaceMessage = ((MessageForMarketFace) messageRecord).mMarkFaceMessage;
            if (markFaceMessage != null && !TextUtils.isEmpty(markFaceMessage.faceName)) {
                return "[" + markFaceMessage.faceName + "]";
            }
            return appInterface.getApp().getResources().getString(R.string.axb);
        }
        return appInterface.getApp().getResources().getString(R.string.axb);
    }

    String buildBaseMsgForMediaPic(AppInterface appInterface, MessageRecord messageRecord, String str) {
        if (((IPicFlash) QRoute.api(IPicFlash.class)).isFlashPicMsg(messageRecord)) {
            return appInterface.getApp().getResources().getString(R.string.aeg);
        }
        if (messageRecord instanceof MessageForPic) {
            return ((MessageForPic) messageRecord).getSummaryMsg();
        }
        return appInterface.getApp().getResources().getString(R.string.aek);
    }

    String buildBaseMsgForPublicAccount(AppInterface appInterface, MessageRecord messageRecord, String str) {
        if (messageRecord instanceof MessageForPubAccount) {
            try {
                PAMessage pAMessage = ((MessageForPubAccount) messageRecord).mPAMessage;
                if (pAMessage == null) {
                    return null;
                }
                String str2 = pAMessage.items.get(0).title;
                if (pAMessage.items.get(0).cover == null && pAMessage.items.get(0).digestList != null) {
                    return str2 + "\uff1a" + pAMessage.items.get(0).digestList.get(0);
                }
                return str2;
            } catch (Exception e16) {
                e16.printStackTrace();
                if (!QLog.isColorLevel()) {
                    return null;
                }
                QLog.d("SUB_ACCOUNT", 2, "subaccount handlerMsgPB, MSG_TYPE_PUBLIC_ACCOUNT error e = " + e16.getMessage());
                return null;
            }
        }
        return str;
    }

    String buildBaseMsgForStruct(AppInterface appInterface, MessageRecord messageRecord, String str) {
        AbsStructMsg absStructMsg;
        if ((messageRecord instanceof MessageForStructing) && (absStructMsg = ((MessageForStructing) messageRecord).structingMsg) != null) {
            str = absStructMsg.mMsgBrief;
        }
        if (TextUtils.isEmpty(str)) {
            return appInterface.getApp().getResources().getString(R.string.ht6);
        }
        return str;
    }

    @Override // com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper
    public MessageRecord createMsgRecordByMsgType(int i3) {
        return q.d(i3);
    }

    @Override // com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper
    public boolean isMessageFuDai(MessageRecord messageRecord) {
        return messageRecord instanceof MessageForFuDai;
    }

    @Override // com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper
    public boolean isMessagePubAccount(MessageRecord messageRecord) {
        return messageRecord instanceof MessageForPubAccount;
    }

    @Override // com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper
    public boolean isRedPacketMsg(MessageRecord messageRecord) {
        return MessageForQQWalletMsg.isRedPacketMsg(messageRecord);
    }

    @Override // com.tencent.mobileqq.utils.api.ISubAccountMessageProcessorHelper
    public void processSubAccountRevokeNotify(AppInterface appInterface, RequestPushNotify requestPushNotify) {
        MsgType0x210 G = g.G(requestPushNotify.stMsgInfo.vMsg);
        if (G != null && G.vProtobuf != null) {
            long j3 = G.uSubMsgType;
            if (j3 == 138 || j3 == 139) {
                Submsgtype0x8a$ReqBody submsgtype0x8a$ReqBody = new Submsgtype0x8a$ReqBody();
                try {
                    submsgtype0x8a$ReqBody.mergeFrom(G.vProtobuf);
                    MsgType0x210Decoder.K((QQAppInterface) appInterface, submsgtype0x8a$ReqBody, requestPushNotify.lBindedUin, true);
                } catch (Exception unused) {
                    if (QLog.isColorLevel()) {
                        QLog.d("revokeMsg", 2, "recv 0x210_0x8a_8b sub account msg, prase reqBody error");
                    }
                }
            }
        }
    }
}
