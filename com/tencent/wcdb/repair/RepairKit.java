package com.tencent.wcdb.repair;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.wcdb.a;
import com.tencent.wcdb.database.SQLiteCipherSpec;

/* compiled from: P */
/* loaded from: classes27.dex */
public class RepairKit {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private long f384440a;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    private static class RepairCursor extends a {
        static IPatchRedirector $redirector_;
        long J;

        RepairCursor() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        private static native byte[] nativeGetBlob(long j3, int i3);

        private static native int nativeGetColumnCount(long j3);

        private static native double nativeGetDouble(long j3, int i3);

        private static native long nativeGetLong(long j3, int i3);

        private static native String nativeGetString(long j3, int i3);

        private static native int nativeGetType(long j3, int i3);

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public byte[] getBlob(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return (byte[]) iPatchRedirector.redirect((short) 12, (Object) this, i3);
            }
            return nativeGetBlob(this.J, i3);
        }

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public int getColumnCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return nativeGetColumnCount(this.J);
        }

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public String[] getColumnNames() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String[]) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            throw new UnsupportedOperationException();
        }

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            throw new UnsupportedOperationException();
        }

        @Override // android.database.Cursor
        public double getDouble(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Double) iPatchRedirector.redirect((short) 11, (Object) this, i3)).doubleValue();
            }
            return nativeGetDouble(this.J, i3);
        }

        @Override // android.database.Cursor
        public float getFloat(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return ((Float) iPatchRedirector.redirect((short) 10, (Object) this, i3)).floatValue();
            }
            return (float) getDouble(i3);
        }

        @Override // android.database.Cursor
        public int getInt(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                return ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, i3)).intValue();
            }
            return (int) getLong(i3);
        }

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public long getLong(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
                return ((Long) iPatchRedirector.redirect((short) 9, (Object) this, i3)).longValue();
            }
            return nativeGetLong(this.J, i3);
        }

        @Override // android.database.Cursor
        public short getShort(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Short) iPatchRedirector.redirect((short) 7, (Object) this, i3)).shortValue();
            }
            return (short) getLong(i3);
        }

        @Override // com.tencent.wcdb.a, com.tencent.wcdb.e, android.database.Cursor
        public String getString(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (String) iPatchRedirector.redirect((short) 6, (Object) this, i3);
            }
            return nativeGetString(this.J, i3);
        }

        @Override // com.tencent.wcdb.a, android.database.Cursor
        public int getType(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, i3)).intValue();
            }
            return nativeGetType(this.J, i3);
        }

        @Override // android.database.Cursor
        public boolean isNull(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
                return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, i3)).booleanValue();
            }
            if (getType(i3) == 0) {
                return true;
            }
            return false;
        }
    }

    private static native void nativeCancel(long j3);

    private static native void nativeFini(long j3);

    private static native void nativeFreeMaster(long j3);

    private static native long nativeInit(String str, byte[] bArr, SQLiteCipherSpec sQLiteCipherSpec, byte[] bArr2);

    private static native int nativeIntegrityFlags(long j3);

    private static native String nativeLastError();

    private static native long nativeLoadMaster(String str, byte[] bArr, String[] strArr, byte[] bArr2);

    private static native long nativeMakeMaster(String[] strArr);

    private native int nativeOutput(long j3, long j16, long j17, int i3);

    private static native boolean nativeSaveMaster(long j3, String str, byte[] bArr);

    private int onProgress(String str, int i3, long j3) {
        return 0;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        long j3 = this.f384440a;
        if (j3 != 0) {
            nativeFini(j3);
            this.f384440a = 0L;
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            a();
            super.finalize();
        }
    }
}
