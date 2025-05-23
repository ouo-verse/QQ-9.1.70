package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.support.Log;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class g extends f {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        super(sQLiteDatabase, str, objArr, aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sQLiteDatabase, str, objArr, aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(CursorWindow cursorWindow, int i3, int i16, boolean z16) {
        a();
        try {
            cursorWindow.a();
            try {
                try {
                    return q().i(r(), l(), cursorWindow, i3, i16, z16, m(), null);
                } catch (SQLiteException e16) {
                    Log.a("WCDB.SQLiteQuery", "exception: " + e16.getMessage() + "; query: " + r());
                    k(e16);
                    throw e16;
                }
            } finally {
                cursorWindow.g();
            }
        } finally {
            g();
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "SQLiteQuery: " + r();
    }
}
