package com.tencent.mobileqq.msg.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForSplitLineTips;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.msg.api.IMessageForGrayTips;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.service.message.q;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MessageForGrayTipsImpl implements IMessageForGrayTips {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "MessageForGrayTipsImpl";
    private QQAppInterface mApp;

    public MessageForGrayTipsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageForGrayTips
    public void addHightlightItem(MessageRecord messageRecord, int i3, int i16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, messageRecord, Integer.valueOf(i3), Integer.valueOf(i16), bundle);
        } else if (messageRecord instanceof MessageForGrayTips) {
            ((MessageForGrayTips) messageRecord).addHightlightItem(i3, i16, bundle);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageForGrayTips
    public MessageRecord getMessageForGrayTips(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MessageRecord) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        return q.d(i3);
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageForGrayTips
    public boolean isMessageForSplitLineTips(MessageRecord messageRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageRecord)).booleanValue();
        }
        return messageRecord instanceof MessageForSplitLineTips;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) appRuntime);
            return;
        }
        if (QLog.isColorLevel()) {
            Object[] objArr = new Object[4];
            boolean z16 = false;
            objArr[0] = "MessageForGrayTipsImpl onCreate: app instanceOf QQApp: ";
            objArr[1] = Boolean.valueOf(appRuntime instanceof QQAppInterface);
            objArr[2] = "app is null: ";
            if (appRuntime == null) {
                z16 = true;
            }
            objArr[3] = Boolean.valueOf(z16);
            QLog.d(TAG, 2, objArr);
        }
        if (appRuntime instanceof QQAppInterface) {
            this.mApp = (QQAppInterface) appRuntime;
        }
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.msg.api.IMessageForGrayTips
    public void setTextGravity(MessageRecord messageRecord, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageRecord, i3);
        } else if (messageRecord instanceof MessageForGrayTips) {
            ((MessageForGrayTips) messageRecord).setTextGravity(i3);
        }
    }
}
