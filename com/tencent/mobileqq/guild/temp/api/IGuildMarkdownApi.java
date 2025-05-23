package com.tencent.mobileqq.guild.temp.api;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseReq;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseRsp;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes14.dex */
public interface IGuildMarkdownApi extends QRouteApi {
    String parse(MessageRecord messageRecord);

    String parseCompatibleText(List<im_msg_body$Elem> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar);

    String parseCompatibleTextWithAt(List<im_msg_body$Elem> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, ChatMessage chatMessage);

    CharSequence parseExcludeExtData(@NonNull String str, int i3);

    MarkdownParseRsp parseMarkdown(MarkdownParseReq markdownParseReq);

    CharSequence parseMarkdown(@NonNull String str);

    String parseMarkdownText(@NonNull String str);
}
