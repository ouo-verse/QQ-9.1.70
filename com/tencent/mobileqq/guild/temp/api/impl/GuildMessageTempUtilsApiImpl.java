package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.ext.codec.decoder.pbelement.ah;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.guild.message.o;
import com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qqva.channel_gift.Msg$msg;
import tencent.im.msg.hummer.resv1.TextMsgExtPb$ResvAttr;
import tencent.im.msg.im_msg_body$Elem;
import tencent.im.msg.im_msg_body$Text;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildMessageTempUtilsApiImpl implements IGuildMessageTempUtilsApi {
    private static final String TAG = "GuildMessageTempUtilsApiImpl";

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public void decodePicMsg(Message message) {
        if (message.msgtype == -2000) {
            MessageForPic messageForPic = new MessageForPic();
            messageForPic.msgData = message.msgData;
            messageForPic.istroop = message.istroop;
            messageForPic.parse();
            message.f203106msg = messageForPic.getSummaryMsg();
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public FileManagerEntity getFileManagerEntityByMsgFile(AppInterface appInterface, ChatMessage chatMessage) {
        return FileManagerUtil.getFileManagerEntityByMsgFile((BaseQQAppInterface) appInterface, (MessageForFile) chatMessage);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public Class<? extends com.tencent.imcore.message.core.codec.a> getGuildMixElemDecoder() {
        return o.class;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public String getShortVideoThumbPicPath(ChatMessage chatMessage, String str) {
        if (chatMessage instanceof MessageForShortVideo) {
            return j.l(((MessageForShortVideo) chatMessage).thumbMD5, str);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public boolean isMessageForPic(MessageRecord messageRecord) {
        return messageRecord instanceof MessageForPic;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public boolean isMyAtMsg(im_msg_body$Elem im_msg_body_elem, String str) {
        if (!((IGuildMessageTempUtilsApi) QRoute.api(IGuildMessageTempUtilsApi.class)).isTextMsg(im_msg_body_elem)) {
            return false;
        }
        im_msg_body$Text im_msg_body_text = im_msg_body_elem.text.get();
        if (!im_msg_body_text.bytes_pb_reserve.has()) {
            return false;
        }
        TextMsgExtPb$ResvAttr textMsgExtPb$ResvAttr = new TextMsgExtPb$ResvAttr();
        try {
            textMsgExtPb$ResvAttr.mergeFrom(im_msg_body_text.bytes_pb_reserve.get().toByteArray());
            if (!textMsgExtPb$ResvAttr.at_type.has() || textMsgExtPb$ResvAttr.at_type.get() == 4) {
                return false;
            }
            int i3 = textMsgExtPb$ResvAttr.at_type.get();
            long j3 = textMsgExtPb$ResvAttr.at_member_tinyid.get();
            if (i3 == 1 && j3 == 0) {
                return true;
            }
            if (j3 != 0) {
                return String.valueOf(j3).equals(str);
            }
            return false;
        } catch (InvalidProtocolBufferMicroException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public boolean isMyGuildGiftMsg(AppInterface appInterface, im_msg_body$Elem im_msg_body_elem) {
        if (!im_msg_body_elem.common_elem.has() || im_msg_body_elem.common_elem.uint32_service_type.get() != 41) {
            return false;
        }
        if (im_msg_body_elem.common_elem.bytes_pb_elem.has()) {
            Msg$msg msg$msg = new Msg$msg();
            try {
                msg$msg.mergeFrom(im_msg_body_elem.common_elem.bytes_pb_elem.get().toByteArray());
                return msg$msg.recvuin.get() == appInterface.getLongAccountUin();
            } catch (InvalidProtocolBufferMicroException e16) {
                QLog.i(TAG, 1, "isMyGuildGiftMsg, e = " + e16);
            }
        }
        return true;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public boolean isTextMsg(im_msg_body$Elem im_msg_body_elem) {
        return ah.d(im_msg_body_elem).booleanValue();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public boolean isWalletMsg(im_msg_body$Elem im_msg_body_elem) {
        return im_msg_body_elem.qqwallet_msg.has();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMessageTempUtilsApi
    public MessageRecord queryRoamMsgItemByShmsgseqFromDB(AppInterface appInterface, String str, long j3) {
        return null;
    }
}
