package com.tencent.imcore.message.aiolist;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.ims.bankcode_info$BankcodeCtrlInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class e implements f {
    static IPatchRedirector $redirector_;

    public e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.aiolist.f
    public Object[] a(AppRuntime appRuntime, String str, int i3, boolean z16, List<ChatMessage> list, List<ChatMessage> list2, List<ChatMessage> list3, MessageRecord messageRecord) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, appRuntime, str, Integer.valueOf(i3), Boolean.valueOf(z16), list, list2, list3, messageRecord);
        }
        String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("sens_msg_ctrl_info");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            if (messageRecord.isSend()) {
                messageRecord.saveExtInfoToExtStr("sens_msg_need_parse", Boolean.toString(false));
                return new Object[]{messageRecord, Boolean.TRUE};
            }
            bankcode_info$BankcodeCtrlInfo bankcode_info_bankcodectrlinfo = new bankcode_info$BankcodeCtrlInfo();
            try {
                bankcode_info_bankcodectrlinfo.mergeFrom(HexUtil.hexStr2Bytes(extInfoFromExtStr));
                if (bankcode_info_bankcodectrlinfo.msgtail_id.has()) {
                    i16 = bankcode_info_bankcodectrlinfo.msgtail_id.get();
                } else {
                    i16 = 0;
                }
                if (i16 != 1) {
                    return new Object[]{messageRecord, Boolean.TRUE};
                }
                ((ChatMessage) messageRecord).parse();
                MessageRecord d16 = q.d(-1014);
                d16.msgtype = MessageRecord.MSG_TYPE_SENSITIVE_MSG_MASK_TIPS;
                d16.senderuin = d16.selfuin;
                d16.frienduin = str;
                d16.istroop = messageRecord.istroop;
                d16.f203106msg = "";
                d16.isread = true;
                d16.shmsgseq = messageRecord.shmsgseq;
                d16.time = messageRecord.time;
                d16.saveExtInfoToExtStr("sens_msg_uniseq", Long.toString(messageRecord.uniseq));
                list.add((ChatMessage) d16);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
        }
        return new Object[]{messageRecord, Boolean.FALSE};
    }
}
