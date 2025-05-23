package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.wcdb.database.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class SQLiteCustomFunction {
    static IPatchRedirector $redirector_;
    public final SQLiteDatabase.CustomFunction callback;
    public final String name;
    public final int numArgs;

    public SQLiteCustomFunction(String str, int i3, SQLiteDatabase.CustomFunction customFunction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), customFunction);
        } else {
            if (str != null) {
                this.name = str;
                this.numArgs = i3;
                this.callback = customFunction;
                return;
            }
            throw new IllegalArgumentException("name must not be null.");
        }
    }

    private void dispatchCallback(String[] strArr) {
        this.callback.a(strArr);
    }
}
