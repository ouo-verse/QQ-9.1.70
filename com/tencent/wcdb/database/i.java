package com.tencent.wcdb.database;

import android.database.sqlite.SQLiteTransactionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.CursorWindow;
import com.tencent.wcdb.database.SQLiteConnection;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class i {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name */
    static final /* synthetic */ boolean f384415g;

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteConnectionPool f384416a;

    /* renamed from: b, reason: collision with root package name */
    private SQLiteConnection f384417b;

    /* renamed from: c, reason: collision with root package name */
    private int f384418c;

    /* renamed from: d, reason: collision with root package name */
    private int f384419d;

    /* renamed from: e, reason: collision with root package name */
    private b f384420e;

    /* renamed from: f, reason: collision with root package name */
    private b f384421f;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public b f384422a;

        /* renamed from: b, reason: collision with root package name */
        public int f384423b;

        /* renamed from: c, reason: collision with root package name */
        public SQLiteTransactionListener f384424c;

        /* renamed from: d, reason: collision with root package name */
        public boolean f384425d;

        /* renamed from: e, reason: collision with root package name */
        public boolean f384426e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        /* synthetic */ b(a aVar) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) aVar);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22116);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 17)) {
            redirector.redirect((short) 17);
        } else {
            f384415g = true;
        }
    }

    public i(SQLiteConnectionPool sQLiteConnectionPool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) sQLiteConnectionPool);
        } else {
            if (sQLiteConnectionPool != null) {
                this.f384416a = sQLiteConnectionPool;
                return;
            }
            throw new IllegalArgumentException("connectionPool must not be null");
        }
    }

    private void a(String str, int i3, boolean z16, com.tencent.wcdb.support.a aVar) {
        if (this.f384417b == null) {
            SQLiteConnection a16 = this.f384416a.a(str, i3, aVar);
            this.f384417b = a16;
            this.f384418c = i3;
            a16.L(true, z16);
        }
        this.f384419d++;
    }

    /* JADX WARN: Finally extract failed */
    private void e(int i3, SQLiteTransactionListener sQLiteTransactionListener, int i16, com.tencent.wcdb.support.a aVar) {
        if (this.f384421f == null) {
            a(null, i16, true, aVar);
        }
        try {
            if (this.f384421f == null) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        this.f384417b.s("BEGIN;", null, aVar);
                    } else {
                        this.f384417b.s("BEGIN EXCLUSIVE;", null, aVar);
                    }
                } else {
                    this.f384417b.s("BEGIN IMMEDIATE;", null, aVar);
                }
            }
            if (sQLiteTransactionListener != null) {
                try {
                    sQLiteTransactionListener.onBegin();
                } catch (RuntimeException e16) {
                    if (this.f384421f == null) {
                        this.f384417b.s("ROLLBACK;", null, aVar);
                    }
                    throw e16;
                }
            }
            b l3 = l(i3, sQLiteTransactionListener);
            l3.f384422a = this.f384421f;
            this.f384421f = l3;
        } catch (Throwable th5) {
            if (this.f384421f == null) {
                o();
            }
            throw th5;
        }
    }

    private void g(com.tencent.wcdb.support.a aVar, boolean z16) {
        boolean z17;
        b bVar = this.f384421f;
        boolean z18 = false;
        if ((bVar.f384425d || z16) && !bVar.f384426e) {
            z17 = true;
        } else {
            z17 = false;
        }
        SQLiteTransactionListener sQLiteTransactionListener = bVar.f384424c;
        if (sQLiteTransactionListener != null) {
            try {
                if (z17) {
                    sQLiteTransactionListener.onCommit();
                } else {
                    sQLiteTransactionListener.onRollback();
                }
            } catch (RuntimeException e16) {
                e = e16;
            }
        }
        z18 = z17;
        e = null;
        this.f384421f = bVar.f384422a;
        n(bVar);
        b bVar2 = this.f384421f;
        if (bVar2 != null) {
            if (!z18) {
                bVar2.f384426e = true;
            }
        } else {
            try {
                if (z18) {
                    this.f384417b.s("COMMIT;", null, aVar);
                } else {
                    this.f384417b.s("ROLLBACK;", null, aVar);
                }
            } finally {
                o();
            }
        }
        if (e == null) {
        } else {
            throw e;
        }
    }

    private boolean k(String str, Object[] objArr, int i3, com.tencent.wcdb.support.a aVar) {
        int d16 = com.tencent.wcdb.g.d(str);
        if (d16 != 4) {
            if (d16 != 5) {
                if (d16 != 6) {
                    return false;
                }
                f(aVar);
                return true;
            }
            r();
            f(aVar);
            return true;
        }
        d(2, null, i3, aVar);
        return true;
    }

    private b l(int i3, SQLiteTransactionListener sQLiteTransactionListener) {
        b bVar = this.f384420e;
        a aVar = null;
        if (bVar != null) {
            this.f384420e = bVar.f384422a;
            bVar.f384422a = null;
            bVar.f384425d = false;
            bVar.f384426e = false;
        } else {
            bVar = new b(aVar);
        }
        bVar.f384423b = i3;
        bVar.f384424c = sQLiteTransactionListener;
        return bVar;
    }

    private void n(b bVar) {
        bVar.f384422a = this.f384420e;
        bVar.f384424c = null;
        this.f384420e = bVar;
    }

    private void o() {
        int i3 = this.f384419d - 1;
        this.f384419d = i3;
        if (i3 == 0) {
            try {
                this.f384417b.L(false, false);
                this.f384416a.z(this.f384417b);
            } finally {
                this.f384417b = null;
            }
        }
    }

    private void s() {
        if (this.f384421f != null) {
        } else {
            throw new IllegalStateException("Cannot perform this operation because there is no current transaction.");
        }
    }

    private void t() {
        b bVar = this.f384421f;
        if (bVar != null && bVar.f384425d) {
            throw new IllegalStateException("Cannot perform this operation because the transaction has already been marked successful.  The only thing you can do now is call endTransaction().");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteConnection b(int i3) {
        a(null, i3, true, null);
        return this.f384417b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SQLiteConnection.d c(String str, int i3, boolean z16) {
        a(str, i3, z16, null);
        return this.f384417b.j(str);
    }

    public void d(int i3, SQLiteTransactionListener sQLiteTransactionListener, int i16, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), sQLiteTransactionListener, Integer.valueOf(i16), aVar);
        } else {
            t();
            e(i3, sQLiteTransactionListener, i16, aVar);
        }
    }

    public void f(com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) aVar);
            return;
        }
        s();
        if (!f384415g && this.f384417b == null) {
            throw new AssertionError();
        }
        g(aVar, false);
    }

    public int h(String str, Object[] objArr, int i3, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, this, str, objArr, Integer.valueOf(i3), aVar)).intValue();
        }
        if (str != null) {
            if (k(str, objArr, i3, aVar)) {
                return 0;
            }
            a(str, i3, false, aVar);
            try {
                return this.f384417b.t(str, objArr, aVar);
            } finally {
                o();
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    public int i(String str, Object[] objArr, CursorWindow cursorWindow, int i3, int i16, boolean z16, int i17, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, this, str, objArr, cursorWindow, Integer.valueOf(i3), Integer.valueOf(i16), Boolean.valueOf(z16), Integer.valueOf(i17), aVar)).intValue();
        }
        if (str != null) {
            if (cursorWindow != null) {
                if (k(str, objArr, i17, aVar)) {
                    cursorWindow.j();
                    return 0;
                }
                a(str, i17, false, aVar);
                try {
                    return this.f384417b.u(str, objArr, cursorWindow, i3, i16, z16, aVar);
                } finally {
                    o();
                }
            }
            throw new IllegalArgumentException("window must not be null.");
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    public long j(String str, Object[] objArr, int i3, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, this, str, objArr, Integer.valueOf(i3), aVar)).longValue();
        }
        if (str != null) {
            if (k(str, objArr, i3, aVar)) {
                return 0L;
            }
            a(str, i3, false, aVar);
            try {
                return this.f384417b.v(str, objArr, aVar);
            } finally {
                o();
            }
        }
        throw new IllegalArgumentException("sql must not be null.");
    }

    public void m(String str, int i3, com.tencent.wcdb.support.a aVar, k kVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), aVar, kVar);
        } else {
            if (str != null) {
                a(str, i3, false, aVar);
                try {
                    this.f384417b.G(str, kVar);
                    return;
                } finally {
                    o();
                }
            }
            throw new IllegalArgumentException("sql must not be null.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void p(Exception exc) {
        SQLiteConnection sQLiteConnection = this.f384417b;
        if (sQLiteConnection != null) {
            sQLiteConnection.r(exc);
        }
        o();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q(SQLiteConnection.d dVar) {
        SQLiteConnection sQLiteConnection = this.f384417b;
        if (sQLiteConnection != null) {
            sQLiteConnection.J(dVar);
            o();
        }
    }

    public void r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        s();
        t();
        this.f384421f.f384425d = true;
    }
}
