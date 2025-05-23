package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.database.SQLiteConnection;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class f extends a {
    static IPatchRedirector $redirector_;
    private static final String[] F;
    private final Object[] C;
    protected SQLiteConnection.d D;
    private i E;

    /* renamed from: e, reason: collision with root package name */
    private final SQLiteDatabase f384409e;

    /* renamed from: f, reason: collision with root package name */
    private final String f384410f;

    /* renamed from: h, reason: collision with root package name */
    private final boolean f384411h;

    /* renamed from: i, reason: collision with root package name */
    private final String[] f384412i;

    /* renamed from: m, reason: collision with root package name */
    private final int f384413m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(22054);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            F = new String[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public f(SQLiteDatabase sQLiteDatabase, String str, Object[] objArr, com.tencent.wcdb.support.a aVar) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sQLiteDatabase, str, objArr, aVar);
            return;
        }
        this.f384409e = sQLiteDatabase;
        String trim = str.trim();
        this.f384410f = trim;
        int d16 = com.tencent.wcdb.g.d(trim);
        if (d16 != 4 && d16 != 5 && d16 != 6) {
            if (d16 == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            k kVar = new k();
            sQLiteDatabase.s().m(trim, sQLiteDatabase.r(z16), aVar, kVar);
            this.f384411h = d16 != 8 && kVar.f384429c;
            this.f384412i = kVar.f384428b;
            this.f384413m = kVar.f384427a;
        } else {
            this.f384411h = false;
            this.f384412i = F;
            this.f384413m = 0;
        }
        if (objArr != null && objArr.length > this.f384413m) {
            throw new IllegalArgumentException("Too many bind arguments.  " + objArr.length + " arguments were provided but the statement needs " + this.f384413m + " arguments.");
        }
        int i3 = this.f384413m;
        if (i3 != 0) {
            Object[] objArr2 = new Object[i3];
            this.C = objArr2;
            if (objArr != null) {
                System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
            }
        } else {
            this.C = null;
        }
        this.D = null;
        this.E = null;
    }

    public void clearBindings() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        Object[] objArr = this.C;
        if (objArr != null) {
            Arrays.fill(objArr, (Object) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.wcdb.database.a
    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
        } else {
            s();
            clearBindings();
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
            return;
        }
        synchronized (this) {
            if (this.E != null || this.D != null) {
                throw new SQLiteMisuseException("Acquired prepared statement is not released.");
            }
        }
        super.finalize();
    }

    public final String[] getColumnNames() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String[]) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f384412i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized boolean j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this, z16)).booleanValue();
        }
        i s16 = this.f384409e.s();
        i iVar = this.E;
        if (s16 == iVar) {
            return false;
        }
        if (iVar == null) {
            SQLiteConnection.d c16 = s16.c(this.f384410f, this.f384409e.r(this.f384411h), z16);
            this.D = c16;
            c16.p(this.C);
            this.E = s16;
            return true;
        }
        throw new IllegalStateException("SQLiteProgram has bound to another thread.");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k(SQLiteException sQLiteException) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) sQLiteException);
            return;
        }
        boolean z16 = true;
        if (!(sQLiteException instanceof SQLiteDatabaseCorruptException) && (!(sQLiteException instanceof SQLiteFullException) || !this.f384411h)) {
            z16 = false;
        }
        if (z16) {
            SQLiteDebug.b(this.f384409e);
            this.f384409e.z();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Object[] l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Object[]) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f384409e.r(this.f384411h);
    }

    public final SQLiteDatabase p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SQLiteDatabase) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f384409e;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final i q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (i) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.f384409e.s();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.f384410f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public synchronized void s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        i iVar = this.E;
        if (iVar == null && this.D == null) {
            return;
        }
        if (iVar != null && this.D != null) {
            if (iVar == this.f384409e.s()) {
                this.E.q(this.D);
                this.D = null;
                this.E = null;
                return;
            }
            throw new IllegalStateException("SQLiteProgram has bound to another thread.");
        }
        throw new IllegalStateException("Internal state error.");
    }
}
