package com.tencent.imcore.message.facade.add;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class a implements com.tencent.imcore.message.facade.g<QQMessageFacade> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageRecord b(List<MessageRecord> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
        }
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            MessageRecord messageRecord = list.get(size);
            if (!TextUtils.equals(messageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN) && (messageRecord.msgtype != -2006 || (messageRecord instanceof MessageForFoldMsg))) {
                return messageRecord;
            }
        }
        return null;
    }
}
