package com.tencent.imcore.message.aiolist;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.data.TroopTipsEntity;
import com.tencent.mobileqq.troop.utils.bf;
import java.util.List;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class h implements f {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.aiolist.f
    public Object[] a(AppRuntime appRuntime, String str, int i3, boolean z16, List<ChatMessage> list, List<ChatMessage> list2, List<ChatMessage> list3, MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Object[]) iPatchRedirector.redirect((short) 2, this, appRuntime, str, Integer.valueOf(i3), Boolean.valueOf(z16), list, list2, list3, messageRecord);
        }
        if (i3 == 1008 && (messageRecord instanceof MessageForStructing)) {
            String extInfoFromExtStr = messageRecord.getExtInfoFromExtStr("pa_phone_msg_tip");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                TroopTipsEntity troopTipsEntity = new TroopTipsEntity();
                troopTipsEntity.optContent = extInfoFromExtStr;
                ((bf) appRuntime.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a(troopTipsEntity);
                MessageForGrayTips messageForGrayTips = new MessageForGrayTips();
                long j3 = messageRecord.time;
                String account = appRuntime.getAccount();
                messageForGrayTips.init(account, str, account, troopTipsEntity.optContent, j3, MessageRecord.MSG_TYPE_PA_PHONE_MSG_TIPS, i3, j3);
                messageForGrayTips.isread = true;
                bf.h(messageForGrayTips, troopTipsEntity.highlightItems);
                list.add(messageForGrayTips);
            }
        }
        return new Object[]{messageRecord, Boolean.FALSE};
    }
}
