package com.tencent.wcdb;

import android.content.res.Resources;
import android.database.CharArrayBuffer;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes27.dex */
public class CursorWindow extends com.tencent.wcdb.database.a implements Parcelable {
    static IPatchRedirector $redirector_;
    public static final Parcelable.Creator<CursorWindow> CREATOR;

    /* renamed from: i, reason: collision with root package name */
    private static int f384295i;

    /* renamed from: e, reason: collision with root package name */
    public long f384296e;

    /* renamed from: f, reason: collision with root package name */
    private int f384297f;

    /* renamed from: h, reason: collision with root package name */
    private final String f384298h;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    static class a implements Parcelable.Creator<CursorWindow> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public CursorWindow createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (CursorWindow) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return new CursorWindow(parcel, null);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public CursorWindow[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (CursorWindow[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new CursorWindow[i3];
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15753);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 37)) {
            redirector.redirect((short) 37);
            return;
        }
        int identifier = Resources.getSystem().getIdentifier("config_cursorWindowSize", "integer", "android");
        if (identifier != 0) {
            f384295i = Resources.getSystem().getInteger(identifier) * 1024;
        } else {
            f384295i = 2097152;
        }
        CREATOR = new a();
    }

    /* synthetic */ CursorWindow(Parcel parcel, a aVar) {
        this(parcel);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 36)) {
            return;
        }
        iPatchRedirector.redirect((short) 36, (Object) this, (Object) parcel, (Object) aVar);
    }

    private void l() {
        long j3 = this.f384296e;
        if (j3 != 0) {
            nativeDispose(j3);
            this.f384296e = 0L;
        }
    }

    private static native boolean nativeAllocRow(long j3);

    private static native void nativeClear(long j3);

    private static native void nativeCopyStringToBuffer(long j3, int i3, int i16, CharArrayBuffer charArrayBuffer);

    private static native long nativeCreate(String str, int i3);

    private static native void nativeDispose(long j3);

    private static native void nativeFreeLastRow(long j3);

    private static native byte[] nativeGetBlob(long j3, int i3, int i16);

    private static native double nativeGetDouble(long j3, int i3, int i16);

    private static native long nativeGetLong(long j3, int i3, int i16);

    private static native int nativeGetNumRows(long j3);

    private static native String nativeGetString(long j3, int i3, int i16);

    private static native int nativeGetType(long j3, int i3, int i16);

    private static native boolean nativePutBlob(long j3, byte[] bArr, int i3, int i16);

    private static native boolean nativePutDouble(long j3, double d16, int i3, int i16);

    private static native boolean nativePutLong(long j3, long j16, int i3, int i16);

    private static native boolean nativePutNull(long j3, int i3, int i16);

    private static native boolean nativePutString(long j3, String str, int i3, int i16);

    private static native boolean nativeSetNumColumns(long j3, int i3);

    @Override // android.os.Parcelable
    public int describeContents() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Integer) iPatchRedirector.redirect((short) 32, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.wcdb.database.a
    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this);
        } else {
            l();
        }
    }

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        try {
            l();
        } finally {
            super.finalize();
        }
    }

    public void j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        a();
        try {
            this.f384297f = 0;
            nativeClear(this.f384296e);
        } finally {
            g();
        }
    }

    public void k(int i3, int i16, CharArrayBuffer charArrayBuffer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, this, Integer.valueOf(i3), Integer.valueOf(i16), charArrayBuffer);
        } else {
            if (charArrayBuffer != null) {
                a();
                try {
                    nativeCopyStringToBuffer(this.f384296e, i3 - this.f384297f, i16, charArrayBuffer);
                    return;
                } finally {
                    g();
                }
            }
            throw new IllegalArgumentException("CharArrayBuffer should not be null");
        }
    }

    public byte[] m(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (byte[]) iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        a();
        try {
            return nativeGetBlob(this.f384296e, i3 - this.f384297f, i16);
        } finally {
            g();
        }
    }

    public double n(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Double) iPatchRedirector.redirect((short) 23, this, Integer.valueOf(i3), Integer.valueOf(i16))).doubleValue();
        }
        a();
        try {
            return nativeGetDouble(this.f384296e, i3 - this.f384297f, i16);
        } finally {
            g();
        }
    }

    public float o(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Float) iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16))).floatValue();
        }
        return (float) n(i3, i16);
    }

    public int p(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Integer) iPatchRedirector.redirect((short) 25, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        return (int) q(i3, i16);
    }

    public long q(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Long) iPatchRedirector.redirect((short) 22, this, Integer.valueOf(i3), Integer.valueOf(i16))).longValue();
        }
        a();
        try {
            return nativeGetLong(this.f384296e, i3 - this.f384297f, i16);
        } finally {
            g();
        }
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.f384298h;
    }

    public int s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        a();
        try {
            return nativeGetNumRows(this.f384296e);
        } finally {
            g();
        }
    }

    public short t(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Short) iPatchRedirector.redirect((short) 24, this, Integer.valueOf(i3), Integer.valueOf(i16))).shortValue();
        }
        return (short) q(i3, i16);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            return (String) iPatchRedirector.redirect((short) 35, (Object) this);
        }
        return r() + " {" + Long.toHexString(this.f384296e) + "}";
    }

    public int u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.f384297f;
    }

    public String v(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
        a();
        try {
            return nativeGetString(this.f384296e, i3 - this.f384297f, i16);
        } finally {
            g();
        }
    }

    public int w(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Integer) iPatchRedirector.redirect((short) 18, this, Integer.valueOf(i3), Integer.valueOf(i16))).intValue();
        }
        a();
        try {
            return nativeGetType(this.f384296e, i3 - this.f384297f, i16);
        } finally {
            g();
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) parcel, i3);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public void x(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.f384297f = i3;
        }
    }

    public CursorWindow(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            return;
        }
        this.f384297f = 0;
        str = (str == null || str.length() == 0) ? "<unnamed>" : str;
        this.f384298h = str;
        long nativeCreate = nativeCreate(str, f384295i);
        this.f384296e = nativeCreate;
        if (nativeCreate != 0) {
            return;
        }
        throw new CursorWindowAllocationException("Cursor window allocation of " + (f384295i / 1024) + " kb failed. ");
    }

    CursorWindow(Parcel parcel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            throw new UnsupportedOperationException();
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) parcel);
    }
}
