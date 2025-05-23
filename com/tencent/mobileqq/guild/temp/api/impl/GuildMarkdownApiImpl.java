package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.android.androidbypass.parser.a;
import com.tencent.mobileqq.data.AtTroopMemberInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.aa;
import com.tencent.mobileqq.service.message.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseReq;
import com.tencent.qqnt.kernel.nativeinterface.MarkdownParseRsp;
import java.util.ArrayList;
import java.util.List;
import msf.msgcomm.msg_comm$Msg;
import tencent.im.msg.im_msg_body$Elem;

/* compiled from: P */
/* loaded from: classes33.dex */
public class GuildMarkdownApiImpl implements IGuildMarkdownApi {
    private static final String TAG = "GuildMarkdownApiImpl";

    private String parseMarkdownCompatOldMessageRecord(MessageRecord messageRecord) {
        if (((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).isEnableMarkdown()) {
            String str = messageRecord.f203106msg;
            if (com.tencent.android.androidbypass.parser.c.b(str)) {
                String parseMarkdownText = parseMarkdownText(str);
                messageRecord.saveExtInfoToExtStr(MessageRecordForMarkdown.MSG_MARKDOWN_PARSED_TEXT, parseMarkdownText);
                return parseMarkdownText;
            }
            return messageRecord.getExtInfoFromExtStr(MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT);
        }
        return fq0.a.f400309a.f();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi
    public String parseCompatibleText(List<im_msg_body$Elem> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar) {
        return new o().t(null, list, sb5, msg_comm_msg.msg_head.msg_seq.get(), cVar, new aa(), new ArrayList<>(2), msg_comm_msg.msg_head.msg_time.get()).toString();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi
    public CharSequence parseExcludeExtData(String str, int i3) {
        return fq0.a.f400309a.r(str, i3);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi
    public CharSequence parseMarkdown(String str) {
        return fq0.a.f400309a.m(str);
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi
    public String parseMarkdownText(String str) {
        return fq0.a.f400309a.m(str).toString();
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi
    public MarkdownParseRsp parseMarkdown(MarkdownParseReq markdownParseReq) {
        MarkdownParseRsp markdownParseRsp = new MarkdownParseRsp();
        if (markdownParseReq == null) {
            QLog.e(TAG, 1, "parseMarkdown req is null");
            markdownParseRsp.result = -1;
            markdownParseRsp.errMsg = "illegal argument: req is null";
            return markdownParseRsp;
        }
        new a.b(0L, markdownParseReq.markdownReqType != 2);
        markdownParseRsp.parseResult = fq0.a.f400309a.r(markdownParseReq.getMarkdownText(), -1).toString();
        return markdownParseRsp;
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi
    public String parse(MessageRecord messageRecord) {
        if (messageRecord != null && messageRecord.msgtype == -4052) {
            return parseMarkdownCompatOldMessageRecord(messageRecord);
        }
        return "";
    }

    @Override // com.tencent.mobileqq.guild.temp.api.IGuildMarkdownApi
    public String parseCompatibleTextWithAt(List<im_msg_body$Elem> list, StringBuilder sb5, msg_comm$Msg msg_comm_msg, com.tencent.mobileqq.troop.data.c cVar, ChatMessage chatMessage) {
        o oVar = new o();
        aa aaVar = new aa();
        ArrayList<AtTroopMemberInfo> arrayList = new ArrayList<>(2);
        StringBuilder t16 = oVar.t(null, list, sb5, msg_comm_msg.msg_head.msg_seq.get(), cVar, aaVar, arrayList, msg_comm_msg.msg_head.msg_time.get());
        if (cVar != null) {
            com.tencent.mobileqq.troop.text.a.n(cVar.f294892b, arrayList, chatMessage);
        }
        return t16.toString();
    }
}
