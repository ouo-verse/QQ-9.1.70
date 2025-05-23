package com.tencent.wcdb.database;

import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import com.tencent.wcdb.CursorIndexOutOfBoundsException;
import com.tencent.wcdb.StaleDataException;
import com.tencent.wcdb.database.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SQLiteAsyncCursor extends com.tencent.wcdb.a {
    static IPatchRedirector $redirector_;
    public static final SQLiteDatabase.b S;
    private final SQLiteAsyncQuery J;
    private final c K;
    private final String[] L;
    private ChunkedCursorWindow M;
    private long N;
    private volatile int P;
    private final Object Q;
    private QueryThread R;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class QueryThread extends BaseThread {
        static IPatchRedirector $redirector_;
        private volatile int C;
        private int D;
        private int E;

        QueryThread() {
            super("SQLiteAsyncCursor.QueryThread");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SQLiteAsyncCursor.this);
                return;
            }
            this.C = 0;
            this.E = 0;
            this.D = 0;
        }

        void c(int i3) {
            synchronized (this) {
                this.C = i3;
                notifyAll();
            }
        }

        void quit() {
            interrupt();
        }

        @Override // com.tencent.thread.monitor.plugin.proxy.BaseThread, java.lang.Thread, java.lang.Runnable
        public void run() {
            int i3;
            int i16;
            int u16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            try {
                int count = SQLiteAsyncCursor.this.J.getCount();
                synchronized (SQLiteAsyncCursor.this.Q) {
                    SQLiteAsyncCursor.this.P = count;
                    SQLiteAsyncCursor.this.Q.notifyAll();
                }
                while (!Thread.interrupted()) {
                    synchronized (this) {
                        while (this.C + 256 <= this.D && this.C >= this.E) {
                            LockMethodProxy.wait(this);
                        }
                        i3 = this.C;
                        i16 = i3 + 256;
                    }
                    if (i3 < this.E) {
                        SQLiteAsyncCursor.this.J.w();
                        this.D = 0;
                        SQLiteAsyncCursor.this.M.j();
                        this.E = 0;
                    }
                    if (this.D < i16) {
                        if (SQLiteAsyncCursor.this.M.p() > 32) {
                            long u17 = SQLiteAsyncCursor.this.M.u(this.E);
                            if (u17 != -1) {
                                this.E = (int) u17;
                            }
                        }
                        synchronized (SQLiteAsyncCursor.this.Q) {
                            u16 = SQLiteAsyncCursor.this.J.u(SQLiteAsyncCursor.this.M, this.D, 32);
                            int i17 = this.D;
                            if (i17 <= i3 && i17 + u16 > i3) {
                                SQLiteAsyncCursor.this.Q.notifyAll();
                            }
                        }
                        this.D += u16;
                    }
                }
            } catch (InterruptedException unused) {
            } catch (Throwable th5) {
                SQLiteAsyncCursor.this.J.release();
                throw th5;
            }
            SQLiteAsyncCursor.this.J.release();
        }
    }

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
            return new SQLiteAsyncCursor(cVar, str, (SQLiteAsyncQuery) fVar);
        }

        @Override // com.tencent.wcdb.database.SQLiteDatabase.b
        public f b(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (f) iPatchRedirector.redirect((short) 3, this, sQLiteDatabase, str, objArr, aVar);
            }
            return new SQLiteAsyncQuery(sQLiteDatabase, str, objArr, aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(17727);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            S = new a();
        }
    }

    public SQLiteAsyncCursor(c cVar, String str, SQLiteAsyncQuery sQLiteAsyncQuery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cVar, str, sQLiteAsyncQuery);
            return;
        }
        if (sQLiteAsyncQuery != null) {
            this.J = sQLiteAsyncQuery;
            this.K = cVar;
            this.L = sQLiteAsyncQuery.getColumnNames();
            this.P = -1;
            this.Q = new Object();
            this.M = new ChunkedCursorWindow(16777216);
            QueryThread queryThread = new QueryThread();
            this.R = queryThread;
            queryThread.start();
            return;
        }
        throw new IllegalArgumentException("query object cannot be null");
    }

    private void j() {
        if (this.N != 0) {
            return;
        }
        if (!k(this.f384300e)) {
            throw new CursorIndexOutOfBoundsException(this.f384300e, this.P);
        }
        throw new StaleDataException("Cannot get valid Row object");
    }

    private boolean k(int i3) {
        if (i3 >= 0 && i3 < getCount()) {
            return true;
        }
        return false;
    }

    private boolean l() {
        if (this.M == null || !k(this.f384300e)) {
            return false;
        }
        this.R.c(this.f384300e);
        long r16 = this.M.r(this.f384300e);
        this.N = r16;
        if (r16 == 0) {
            this.N = m(this.f384300e);
        }
        if (this.N == 0) {
            return false;
        }
        return true;
    }

    private long m(int i3) {
        long r16;
        try {
            synchronized (this.Q) {
                while (true) {
                    r16 = this.M.r(i3);
                    if (r16 == 0) {
                        if (k(i3)) {
                            LockMethodProxy.wait(this.Q);
                        } else {
                            throw new CursorIndexOutOfBoundsException(this.f384300e, this.P);
                        }
                    }
                }
            }
            return r16;
        } catch (InterruptedException unused) {
            return 0L;
        }
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.e, android.database.Cursor, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        super.close();
        this.J.close();
        this.K.c();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.wcdb.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long j3 = this.N;
        if (j3 != 0) {
            this.M.l(j3);
            this.N = 0L;
        }
        QueryThread queryThread = this.R;
        if (queryThread != null) {
            queryThread.quit();
            try {
                this.R.join();
            } catch (InterruptedException unused) {
            }
            this.R = null;
        }
        ChunkedCursorWindow chunkedCursorWindow = this.M;
        if (chunkedCursorWindow != null) {
            chunkedCursorWindow.close();
            this.M = null;
        }
        this.P = -1;
        this.f384300e = -1;
        super.d();
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public void deactivate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            super.deactivate();
            this.K.d();
        }
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public byte[] getBlob(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (byte[]) iPatchRedirector.redirect((short) 9, (Object) this, i3);
        }
        j();
        return this.M.m(this.N, i3);
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public String[] getColumnNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.L;
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        if (this.P >= 0) {
            return this.P;
        }
        if (this.M == null) {
            return -1;
        }
        try {
            synchronized (this.Q) {
                while (this.P < 0) {
                    LockMethodProxy.wait(this.Q);
                }
            }
        } catch (InterruptedException unused) {
        }
        return this.P;
    }

    @Override // android.database.Cursor
    public double getDouble(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Double) iPatchRedirector.redirect((short) 15, (Object) this, i3)).doubleValue();
        }
        j();
        return this.M.n(this.N, i3);
    }

    @Override // android.database.Cursor
    public float getFloat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Float) iPatchRedirector.redirect((short) 14, (Object) this, i3)).floatValue();
        }
        return (float) getDouble(i3);
    }

    @Override // android.database.Cursor
    public int getInt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, i3)).intValue();
        }
        return (int) getLong(i3);
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public long getLong(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Long) iPatchRedirector.redirect((short) 13, (Object) this, i3)).longValue();
        }
        j();
        return this.M.o(this.N, i3);
    }

    @Override // android.database.Cursor
    public short getShort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Short) iPatchRedirector.redirect((short) 11, (Object) this, i3)).shortValue();
        }
        return (short) getLong(i3);
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.e, android.database.Cursor
    public String getString(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        j();
        return this.M.s(this.N, i3);
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public int getType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
        }
        j();
        return this.M.t(this.N, i3);
    }

    @Override // android.database.Cursor
    public boolean isNull(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, i3)).booleanValue();
        }
        if (getType(i3) == 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public boolean moveToPosition(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, i3)).booleanValue();
        }
        if (i3 < -1) {
            i3 = -1;
        }
        if (i3 != this.f384300e) {
            this.M.l(this.N);
            this.N = 0L;
        }
        int count = getCount();
        if (i3 >= count) {
            this.f384300e = count;
            return false;
        }
        this.f384300e = i3;
        if (i3 < 0 || !l()) {
            return false;
        }
        return true;
    }
}
