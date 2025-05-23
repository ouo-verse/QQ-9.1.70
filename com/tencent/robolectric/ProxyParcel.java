package com.tencent.robolectric;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

/* loaded from: classes25.dex */
public final class ProxyParcel {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    public static final Parcelable.Creator<String> f365887e;

    /* renamed from: f, reason: collision with root package name */
    private static final ProxyParcel[] f365888f;

    /* renamed from: g, reason: collision with root package name */
    private static final ProxyParcel[] f365889g;

    /* renamed from: h, reason: collision with root package name */
    private static final HashMap<ClassLoader, HashMap<String, Parcelable.Creator<?>>> f365890h;

    /* renamed from: a, reason: collision with root package name */
    private long f365891a;

    /* renamed from: b, reason: collision with root package name */
    private boolean f365892b;

    /* renamed from: c, reason: collision with root package name */
    private long f365893c;

    /* renamed from: d, reason: collision with root package name */
    private b f365894d;

    /* loaded from: classes25.dex */
    class a implements Parcelable.Creator<String> {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public String createFromParcel(Parcel parcel) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parcel);
            }
            return parcel.readString();
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public String[] newArray(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String[]) iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            return new String[i3];
        }
    }

    /* loaded from: classes25.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final b f365895a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50898);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 4)) {
                redirector.redirect((short) 4);
            } else {
                f365895a = new b();
            }
        }

        public b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 153)) {
            redirector.redirect((short) 153);
            return;
        }
        f365887e = new a();
        f365888f = new ProxyParcel[6];
        f365889g = new ProxyParcel[6];
        f365890h = new HashMap<>();
    }

    private void a() {
        long j3 = this.f365891a;
        if (j3 != 0) {
            if (this.f365892b) {
                nativeDestroy(j3);
                b(0L);
            }
            this.f365891a = 0L;
        }
        this.f365894d = null;
    }

    private void b(long j3) {
        if (this.f365892b) {
            if (j3 > TTL.MAX_VALUE) {
                j3 = 2147483647L;
            }
            if (j3 != this.f365893c) {
                this.f365893c = j3;
            }
        }
    }

    @Deprecated
    static native void closeFileDescriptor(FileDescriptor fileDescriptor) throws IOException;

    @Deprecated
    static native FileDescriptor dupFileDescriptor(FileDescriptor fileDescriptor) throws IOException;

    public static native long getGlobalAllocCount();

    public static native long getGlobalAllocSize();

    private static native long nativeAppendFrom(long j3, long j16, int i3, int i16);

    private static native int nativeCompareData(long j3, long j16);

    private static native long nativeCreate();

    private static native byte[] nativeCreateByteArray(long j3);

    private static native int nativeDataAvail(long j3);

    private static native int nativeDataCapacity(long j3);

    private static native int nativeDataPosition(long j3);

    private static native int nativeDataSize(long j3);

    private static native void nativeDestroy(long j3);

    private static native void nativeEnforceInterface(long j3, String str);

    private static native long nativeFreeBuffer(long j3);

    private static native long nativeGetBlobAshmemSize(long j3);

    private static native boolean nativeHasFileDescriptors(long j3);

    private static native boolean nativePushAllowFds(long j3, boolean z16);

    private static native byte[] nativeReadBlob(long j3);

    private static native boolean nativeReadByteArray(long j3, byte[] bArr, int i3);

    private static native double nativeReadDouble(long j3);

    private static native FileDescriptor nativeReadFileDescriptor(long j3);

    private static native float nativeReadFloat(long j3);

    private static native int nativeReadInt(long j3);

    private static native long nativeReadLong(long j3);

    static native String nativeReadString(long j3);

    private static native IBinder nativeReadStrongBinder(long j3);

    private static native void nativeRestoreAllowFds(long j3, boolean z16);

    private static native void nativeSetDataCapacity(long j3, int i3);

    private static native void nativeSetDataPosition(long j3, int i3);

    private static native long nativeSetDataSize(long j3, int i3);

    @Deprecated
    static native FileDescriptor openFileDescriptor(String str, int i3) throws FileNotFoundException;

    protected void finalize() throws Throwable {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 149)) {
            iPatchRedirector.redirect((short) 149, (Object) this);
        } else {
            a();
        }
    }
}
