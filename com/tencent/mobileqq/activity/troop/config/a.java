package com.tencent.mobileqq.activity.troop.config;

import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends com.tencent.mobileqq.troop.api.config.o {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void h(@NonNull AppInterface appInterface, String str) {
        MqqHandler handler = appInterface.getHandler(AVNotifyCenter.class);
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage(10011);
            try {
                obtainMessage.obj = Long.valueOf(str);
            } catch (NumberFormatException e16) {
                QLog.e("GAudioMsgTroopMngProcessor", 1, "sendGAudioMessage e = " + e16);
            }
            handler.sendMessage(obtainMessage);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.o
    public void a(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) str);
        } else {
            h(appInterface, str);
        }
    }

    @Override // com.tencent.mobileqq.troop.api.config.o
    public void g(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        } else {
            h(appInterface, str);
        }
    }
}
