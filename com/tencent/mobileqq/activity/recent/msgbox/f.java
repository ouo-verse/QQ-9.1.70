package com.tencent.mobileqq.activity.recent.msgbox;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.bt;

/* compiled from: P */
/* loaded from: classes10.dex */
public class f implements c {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.c
    public void a(Context context, BaseQQAppInterface baseQQAppInterface, Message message, int i3, MsgSummary msgSummary, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, context, baseQQAppInterface, message, Integer.valueOf(i3), msgSummary, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            bt.c(context, baseQQAppInterface, message, i3, msgSummary, z16, z17);
        }
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.c
    public String b(AppInterface appInterface, String str, int i3, int i16, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, this, appInterface, str, Integer.valueOf(i3), Integer.valueOf(i16), message);
        }
        return com.tencent.mobileqq.qcall.f.l((QQAppInterface) appInterface, str, i3, i16, null).b();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.c
    public int c(AppInterface appInterface, String str, int i3, int i16, Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, appInterface, str, Integer.valueOf(i3), Integer.valueOf(i16), message)).intValue();
        }
        return com.tencent.mobileqq.qcall.f.l((QQAppInterface) appInterface, str, i3, i16, null).a();
    }

    @Override // com.tencent.mobileqq.activity.recent.msgbox.c
    public boolean d(AppInterface appInterface, String str, int i3) {
        short s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, this, appInterface, str, Integer.valueOf(i3))).booleanValue();
        }
        TempMsgManager tempMsgManager = (TempMsgManager) appInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
        if (i3 != 1000) {
            if (i3 != 1024) {
                if (i3 != 1005) {
                    if (i3 != 1006) {
                        return false;
                    }
                    s16 = -23310;
                } else {
                    s16 = -23309;
                }
            } else {
                s16 = -20457;
            }
        } else {
            s16 = -23308;
        }
        return tempMsgManager.K(s16);
    }
}
