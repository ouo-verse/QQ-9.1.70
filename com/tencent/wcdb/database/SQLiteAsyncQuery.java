package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.wcdb.database.SQLiteConnection;
import com.tencent.wcdb.support.Log;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SQLiteAsyncQuery extends f {
    static IPatchRedirector $redirector_;
    private final int G;

    public SQLiteAsyncQuery(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        super(sQLiteDatabase, str, objArr, aVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sQLiteDatabase, str, objArr, aVar);
        } else {
            this.G = getColumnNames().length;
        }
    }

    private static native int nativeCount(long j3);

    private static native int nativeFillRows(long j3, long j16, int i3, int i16);

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCount() {
        t();
        try {
            return nativeCount(this.D.s());
        } catch (SQLiteException e16) {
            Log.a("WCDB.SQLiteAsyncQuery", "Got exception on getCount: " + e16.getMessage() + ", SQL: " + r());
            k(e16);
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void release() {
        s();
    }

    void t() {
        if (this.D == null) {
            j(true);
            this.D.p(l());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int u(ChunkedCursorWindow chunkedCursorWindow, int i3, int i16) {
        t();
        int q16 = chunkedCursorWindow.q();
        int i17 = this.G;
        if (q16 != i17) {
            chunkedCursorWindow.v(i17);
        }
        try {
            return nativeFillRows(this.D.s(), chunkedCursorWindow.f384308e, i3, i16);
        } catch (SQLiteException e16) {
            Log.a("WCDB.SQLiteAsyncQuery", "Got exception on fillRows: " + e16.getMessage() + ", SQL: " + r());
            k(e16);
            throw e16;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w() {
        SQLiteConnection.d dVar = this.D;
        if (dVar != null) {
            dVar.t(false);
        }
    }
}
