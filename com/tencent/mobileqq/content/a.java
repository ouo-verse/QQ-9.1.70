package com.tencent.mobileqq.content;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteDatabase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteDatabase a(AppRuntime appRuntime, String str, boolean z16) {
        if (appRuntime != null && (appRuntime instanceof QQAppInterface)) {
            QQAppInterface qQAppInterface = (QQAppInterface) appRuntime;
            if (z16) {
                return qQAppInterface.getReadableDatabase(str);
            }
            return qQAppInterface.getWritableDatabase(str);
        }
        return null;
    }
}
