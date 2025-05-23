package com.tencent.imcore.message.decoder;

import android.text.TextUtils;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.message.IMessageManager;
import com.tencent.mobileqq.app.utils.MessagePkgUtils;
import com.tencent.mobileqq.data.MarkFaceMessage;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes7.dex */
public class k implements j {
    static IPatchRedirector $redirector_;

    public k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.imcore.message.decoder.j
    public void a(Message message, IMessageManager iMessageManager, AppRuntime appRuntime) throws Exception {
        MarkFaceMessage markFaceMessage;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, message, iMessageManager, appRuntime);
            return;
        }
        if (message.msgtype == -2007) {
            try {
                markFaceMessage = (MarkFaceMessage) MessagePkgUtils.getObjectFromBytes(message.msgData);
            } catch (Exception e16) {
                QLog.e("Q.msg.BaseMessageManager", 1, "parse MarkFaceMessage: ", e16);
                markFaceMessage = null;
            }
            if (markFaceMessage != null && !TextUtils.isEmpty(markFaceMessage.faceName)) {
                message.f203106msg = "[" + markFaceMessage.faceName + "]";
                return;
            }
            message.f203106msg = appRuntime.getApp().getString(R.string.axb);
        }
    }
}
