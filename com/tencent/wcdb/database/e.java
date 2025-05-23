package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.wcdb.database.SQLiteDatabase;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class e implements c {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static SQLiteDatabase.b f384404e;

    /* renamed from: a, reason: collision with root package name */
    private final SQLiteDatabase f384405a;

    /* renamed from: b, reason: collision with root package name */
    private final String f384406b;

    /* renamed from: c, reason: collision with root package name */
    private final String f384407c;

    /* renamed from: d, reason: collision with root package name */
    private f f384408d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21409);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            f384404e = b.R;
        }
    }

    public e(SQLiteDatabase sQLiteDatabase, String str, String str2, com.tencent.wcdb.support.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, sQLiteDatabase, str, str2, aVar);
            return;
        }
        this.f384405a = sQLiteDatabase;
        this.f384406b = str2;
        this.f384407c = str;
    }

    @Override // com.tencent.wcdb.database.c
    public void a(com.tencent.wcdb.e eVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) eVar);
        }
    }

    @Override // com.tencent.wcdb.database.c
    public com.tencent.wcdb.e b(SQLiteDatabase.b bVar, Object[] objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.wcdb.e) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bVar, (Object) objArr);
        }
        if (bVar == null) {
            bVar = f384404e;
        }
        f fVar = null;
        try {
            fVar = bVar.b(this.f384405a, this.f384407c, objArr, null);
            com.tencent.wcdb.e a16 = bVar.a(this.f384405a, this, this.f384406b, fVar);
            this.f384408d = fVar;
            return a16;
        } catch (RuntimeException e16) {
            if (fVar != null) {
                fVar.close();
            }
            throw e16;
        }
    }

    @Override // com.tencent.wcdb.database.c
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.wcdb.database.c
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return "SQLiteDirectCursorDriver: " + this.f384407c;
    }
}
