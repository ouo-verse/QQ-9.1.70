package com.tencent.wcdb;

import android.database.CharArrayBuffer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class b extends a {
    static IPatchRedirector $redirector_;
    protected CursorWindow J;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.wcdb.a
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
            return;
        }
        super.a();
        if (this.J != null) {
        } else {
            throw new StaleDataException("Attempting to access a closed CursorWindow.Most probable cause: cursor is deactivated prior to calling this method.");
        }
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public void copyStringToBuffer(int i3, CharArrayBuffer charArrayBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) charArrayBuffer);
        } else {
            a();
            this.J.k(this.f384300e, i3, charArrayBuffer);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.wcdb.a
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
        } else {
            super.d();
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) str);
            return;
        }
        CursorWindow cursorWindow = this.J;
        if (cursorWindow == null) {
            this.J = new CursorWindow(str);
        } else {
            cursorWindow.j();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        CursorWindow cursorWindow = this.J;
        if (cursorWindow != null) {
            cursorWindow.close();
            this.J = null;
        }
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public byte[] getBlob(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (byte[]) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        a();
        return this.J.m(this.f384300e, i3);
    }

    @Override // android.database.Cursor
    public double getDouble(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Double) iPatchRedirector.redirect((short) 9, (Object) this, i3)).doubleValue();
        }
        a();
        return this.J.n(this.f384300e, i3);
    }

    @Override // android.database.Cursor
    public float getFloat(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Float) iPatchRedirector.redirect((short) 8, (Object) this, i3)).floatValue();
        }
        a();
        return this.J.o(this.f384300e, i3);
    }

    @Override // android.database.Cursor
    public int getInt(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, i3)).intValue();
        }
        a();
        return this.J.p(this.f384300e, i3);
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public long getLong(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Long) iPatchRedirector.redirect((short) 7, (Object) this, i3)).longValue();
        }
        a();
        return this.J.q(this.f384300e, i3);
    }

    @Override // android.database.Cursor
    public short getShort(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Short) iPatchRedirector.redirect((short) 5, (Object) this, i3)).shortValue();
        }
        a();
        return this.J.t(this.f384300e, i3);
    }

    @Override // com.tencent.wcdb.a, com.tencent.wcdb.e, android.database.Cursor
    public String getString(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, i3);
        }
        a();
        return this.J.v(this.f384300e, i3);
    }

    @Override // com.tencent.wcdb.a, android.database.Cursor
    public int getType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this, i3)).intValue();
        }
        a();
        return this.J.w(this.f384300e, i3);
    }

    @Override // android.database.Cursor
    public boolean isNull(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        a();
        if (this.J.w(this.f384300e, i3) == 0) {
            return true;
        }
        return false;
    }
}
