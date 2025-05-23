package com.tencent.wcdb.database;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.wcdb.CursorWindowAllocationException;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ChunkedCursorWindow extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    long f384308e;

    /* renamed from: f, reason: collision with root package name */
    private int f384309f;

    public ChunkedCursorWindow(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.f384309f = 0;
        long nativeCreate = nativeCreate(i3);
        this.f384308e = nativeCreate;
        if (nativeCreate != 0) {
        } else {
            throw new CursorWindowAllocationException("Cursor window allocation failed.");
        }
    }

    private void k() {
        long j3 = this.f384308e;
        if (j3 != 0) {
            nativeDispose(j3);
            this.f384308e = 0L;
        }
    }

    private static native void nativeClear(long j3);

    private static native long nativeCreate(int i3);

    private static native void nativeDispose(long j3);

    private static native void nativeEndRow(long j3, long j16);

    private static native byte[] nativeGetBlob(long j3, int i3);

    private static native double nativeGetDouble(long j3, int i3);

    private static native long nativeGetLong(long j3, int i3);

    private static native int nativeGetNumChunks(long j3);

    private static native long nativeGetRow(long j3, int i3);

    private static native String nativeGetString(long j3, int i3);

    private static native int nativeGetType(long j3, int i3);

    private static native long nativeRemoveChunk(long j3, int i3);

    private static native boolean nativeSetNumColumns(long j3, int i3);

    @Override // com.tencent.wcdb.database.a
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            k();
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        try {
            k();
        } finally {
            super.finalize();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        a();
        try {
            nativeClear(this.f384308e);
        } finally {
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(long j3) {
        if (j3 == 0) {
            return;
        }
        nativeEndRow(this.f384308e, j3);
        g();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public byte[] m(long j3, int i3) {
        return nativeGetBlob(j3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public double n(long j3, int i3) {
        return nativeGetDouble(j3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long o(long j3, int i3) {
        return nativeGetLong(j3, i3);
    }

    public int p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        a();
        try {
            return nativeGetNumChunks(this.f384308e);
        } finally {
            g();
        }
    }

    public int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f384309f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long r(int i3) {
        a();
        long nativeGetRow = nativeGetRow(this.f384308e, i3);
        if (nativeGetRow == 0) {
            g();
        }
        return nativeGetRow;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String s(long j3, int i3) {
        return nativeGetString(j3, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int t(long j3, int i3) {
        return nativeGetType(j3, i3);
    }

    public long u(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        a();
        try {
            return nativeRemoveChunk(this.f384308e, i3);
        } finally {
            g();
        }
    }

    public boolean v(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, i3)).booleanValue();
        }
        a();
        try {
            boolean nativeSetNumColumns = nativeSetNumColumns(this.f384308e, i3);
            if (nativeSetNumColumns) {
                this.f384309f = i3;
            }
            return nativeSetNumColumns;
        } finally {
            g();
        }
    }
}
