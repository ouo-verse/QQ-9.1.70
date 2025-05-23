package com.tencent.mobileqq.activity.home.chats.background;

import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.home.chats.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.inject.background.a;

@KeepClassConstructor
/* loaded from: classes10.dex */
public class QQTopBackgroundProcessor extends a {
    static IPatchRedirector $redirector_;

    public QQTopBackgroundProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.inject.background.a
    public void a(@NonNull g gVar, @NonNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) gVar, (Object) view);
            return;
        }
        try {
            if (gVar.H()) {
                view.setBackgroundDrawable(c.c());
            } else {
                view.setBackgroundDrawable(c.a());
            }
        } catch (Throwable th5) {
            QLog.i("QQTopBackgroundProcessor", 1, "updateBackground", th5);
        }
    }
}
