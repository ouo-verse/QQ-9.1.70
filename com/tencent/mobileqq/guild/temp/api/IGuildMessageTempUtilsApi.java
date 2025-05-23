package com.tencent.mobileqq.guild.temp.api;

import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMessageTempUtilsApi extends QRouteApi {
    void decodePicMsg(Message message);

    FileManagerEntity getFileManagerEntityByMsgFile(AppInterface appInterface, ChatMessage chatMessage);

    Class<? extends com.tencent.imcore.message.core.codec.a> getGuildMixElemDecoder();

    String getShortVideoThumbPicPath(ChatMessage chatMessage, String str);

    boolean isMessageForPic(MessageRecord messageRecord);

    boolean isMyAtMsg(im_msg_body$Elem im_msg_body_elem, String str);

    boolean isMyGuildGiftMsg(AppInterface appInterface, im_msg_body$Elem im_msg_body_elem);

    boolean isTextMsg(im_msg_body$Elem im_msg_body_elem);

    boolean isWalletMsg(im_msg_body$Elem im_msg_body_elem);

    MessageRecord queryRoamMsgItemByShmsgseqFromDB(AppInterface appInterface, String str, long j3);
}
