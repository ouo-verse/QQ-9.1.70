package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.support.Log;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class b extends com.tencent.wcdb.b {
    static IPatchRedirector $redirector_;
    public static final SQLiteDatabase.b R;
    private final String[] K;
    private final g L;
    private final c M;
    private int N;
    private int P;
    private Map<String, Integer> Q;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class a implements SQLiteDatabase.b {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.wcdb.database.SQLiteDatabase.b
        public com.tencent.wcdb.e a(SQLiteDatabase sQLiteDatabase, c cVar, String str, f fVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (com.tencent.wcdb.e) iPatchRedirector.redirect((short) 2, this, sQLiteDatabase, cVar, str, fVar);
            }
            return new b(cVar, str, (g) fVar);
        }

        @Override // com.tencent.wcdb.database.SQLiteDatabase.b
        public f b(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (f) iPatchRedirector.redirect((short) 3, this, sQLiteDatabase, str, objArr, aVar);
            }
            return new g(sQLiteDatabase, str, objArr, aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18960);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 15)) {
            redirector.redirect((short) 15);
        } else {
            R = new a();
        }
    }

    public b(c cVar, String str, g gVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, cVar, str, gVar);
            return;
        }
        this.N = -1;
        if (gVar != null) {
            this.M = cVar;
            this.Q = null;
            this.L = gVar;
            String[] columnNames = gVar.getColumnNames();
            this.K = columnNames;
            this.f384301f = com.tencent.wcdb.g.c(columnNames);
            return;
        }
        throw new IllegalArgumentException("query object cannot be null");
    }

    private void h(int i3) {
        e(j().getPath());
        try {
            if (this.N == -1) {
                this.N = this.L.t(this.J, com.tencent.wcdb.g.a(i3, 0), i3, true);
                this.P = this.J.s();
            } else {
                this.L.t(this.J, com.tencent.wcdb.g.a(i3, this.P), i3, false);
            }
        } catch (RuntimeException e16) {
            g();
            throw e16;
        }
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.e, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        super.close();
        synchronized (this) {
            this.L.close();
            this.M.c();
        }
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public void deactivate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            super.deactivate();
            this.M.d();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.wcdb.a
    public void finalize() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        try {
            if (this.J != null) {
                close();
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public int getColumnIndex(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).intValue();
        }
        if (this.Q == null) {
            String[] strArr = this.K;
            int length = strArr.length;
            HashMap hashMap = new HashMap(length, 1.0f);
            for (int i3 = 0; i3 < length; i3++) {
                hashMap.put(strArr[i3], Integer.valueOf(i3));
            }
            this.Q = hashMap;
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf != -1) {
            Log.b("WCDB.SQLiteCursor", "requesting column name with table name -- " + str, new Exception());
            str = str.substring(lastIndexOf + 1);
        }
        Integer num = this.Q.get(str);
        if (num == null) {
            return -1;
        }
        return num.intValue();
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public String[] getColumnNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String[]) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.K;
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.N == -1) {
            h(0);
        }
        return this.N;
    }

    public SQLiteDatabase j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.L.p();
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public boolean moveToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3)).booleanValue();
        }
        if (!super.moveToPosition(i3)) {
            return false;
        }
        int count = getCount();
        if (i3 >= count) {
            this.f384300e = count;
            return false;
        }
        return true;
    }

    @Override // com.tencent.wcdb.a
    public boolean onMove(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Integer.valueOf(i16))).booleanValue();
        }
        CursorWindow cursorWindow = this.J;
        if (cursorWindow == null || i16 < cursorWindow.u() || i16 >= this.J.u() + this.J.s()) {
            h(i16);
            int u16 = this.J.u() + this.J.s();
            if (i16 >= u16) {
                this.N = u16;
            }
        }
        return true;
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public boolean requery() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        if (isClosed()) {
            return false;
        }
        synchronized (this) {
            if (!this.L.p().isOpen()) {
                return false;
            }
            CursorWindow cursorWindow = this.J;
            if (cursorWindow != null) {
                cursorWindow.j();
            }
            this.f384300e = -1;
            this.N = -1;
            this.M.a(this);
            try {
                return super.requery();
            } catch (IllegalStateException e16) {
                Log.h("WCDB.SQLiteCursor", "requery() failed " + e16.getMessage(), e16);
                return false;
            }
        }
    }
}
