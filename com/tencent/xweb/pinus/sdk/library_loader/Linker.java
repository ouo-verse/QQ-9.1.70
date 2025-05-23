package com.tencent.xweb.pinus.sdk.library_loader;

import android.os.Bundle;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.SystemClock;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import java.io.Closeable;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class Linker {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final boolean DEBUG = true;
    public static final String EXTRA_LINKER_SHARED_RELROS = "org.chromium.base.android.linker.shared_relros";
    protected static final String LINKER_JNI_LIBRARY = "xweb_linker";
    private static final String TAG = "Linker";
    protected static final Object sLock = new Object();
    private static Linker sSingleton;
    protected LibInfo mLibInfo;
    protected boolean mWaitForSharedRelros;
    protected boolean mInBrowserProcess = true;
    protected long mBaseLoadAddress = -1;
    protected int mState = 0;

    /* compiled from: P */
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes27.dex */
    public @interface State {
        public static final int DONE = 3;
        public static final int DONE_PROVIDE_RELRO = 2;
        public static final int INITIALIZED = 1;
        public static final int UNINITIALIZED = 0;
    }

    public static Linker getInstance() {
        Linker linker;
        synchronized (sLock) {
            if (sSingleton == null) {
                sSingleton = new LegacyLinker();
            }
            linker = sSingleton;
        }
        return linker;
    }

    public static long getRandomBaseLoadAddress() {
        long nativeGetRandomBaseLoadAddress = nativeGetRandomBaseLoadAddress();
        x0.d(TAG, String.format("Random native base load address: 0x%x", Long.valueOf(nativeGetRandomBaseLoadAddress)));
        return nativeGetRandomBaseLoadAddress;
    }

    private void loadLinkerJniLibraryLocked() {
        x0.d(TAG, String.format("Loading lib%s.so", LINKER_JNI_LIBRARY));
        try {
            System.loadLibrary(LINKER_JNI_LIBRARY);
        } catch (UnsatisfiedLinkError unused) {
        }
    }

    private static native long nativeGetRandomBaseLoadAddress();

    private void setupBaseLoadAddressLocked() {
        if (this.mBaseLoadAddress == -1) {
            long randomBaseLoadAddress = getRandomBaseLoadAddress();
            this.mBaseLoadAddress = randomBaseLoadAddress;
            if (randomBaseLoadAddress == 0) {
                x0.f(TAG, "Disabling shared RELROs due address space pressure");
                this.mWaitForSharedRelros = false;
            }
        }
    }

    public abstract int createMemroyFile(String str);

    public final void disableSharedRelros() {
        x0.d(TAG, "disableSharedRelros() called");
        synchronized (sLock) {
            this.mInBrowserProcess = false;
            ensureInitializedLocked();
            this.mWaitForSharedRelros = false;
        }
    }

    public final void ensureInitializedLocked() {
        if (this.mState != 0) {
            return;
        }
        loadLinkerJniLibraryLocked();
        if (this.mInBrowserProcess) {
            setupBaseLoadAddressLocked();
        }
        this.mState = 1;
    }

    public final long getBaseLoadAddress() {
        long j3;
        synchronized (sLock) {
            ensureInitializedLocked();
            setupBaseLoadAddressLocked();
            x0.d(TAG, String.format("getBaseLoadAddress() returns 0x%x", Long.valueOf(this.mBaseLoadAddress)));
            j3 = this.mBaseLoadAddress;
        }
        return j3;
    }

    public final Bundle getSharedRelros() {
        synchronized (sLock) {
            if (this.mState == 2) {
                Bundle bundle = this.mLibInfo.toBundle();
                x0.d(TAG, String.format("getSharedRelros() = %s", bundle.toString()));
                return bundle;
            }
            x0.d(TAG, "getSharedRelros() = null");
            return null;
        }
    }

    public final void initServiceProcess(long j3) {
        x0.d(TAG, String.format("initServiceProcess(0x%x) called", Long.valueOf(j3)));
        synchronized (sLock) {
            ensureInitializedLocked();
            this.mInBrowserProcess = false;
            this.mWaitForSharedRelros = true;
            this.mBaseLoadAddress = j3;
        }
    }

    public final void loadLibrary(String str, boolean z16) {
        x0.d(TAG, String.format("loadLibrary: %s", str));
        synchronized (sLock) {
            loadLibraryImplLocked(str, z16);
        }
    }

    public final void loadLibraryByFd(String str, boolean z16, int i3, boolean z17) {
        x0.d(TAG, String.format("loadLibrary: %s, fd: %d", str, Integer.valueOf(i3)));
        synchronized (sLock) {
            loadLibraryByFdImplLocked(str, z16, i3, z17);
        }
    }

    public abstract void loadLibraryByFdImplLocked(String str, boolean z16, int i3, boolean z17);

    public abstract void loadLibraryImplLocked(String str, boolean z16);

    public final void provideSharedRelros(Bundle bundle) {
        x0.d(TAG, String.format("provideSharedRelros() called with %s", bundle));
        Object obj = sLock;
        synchronized (obj) {
            this.mLibInfo = LibInfo.fromBundle(bundle);
            obj.notifyAll();
        }
    }

    public final void waitForSharedRelrosLocked() {
        x0.d(TAG, "waitForSharedRelros() called");
        long uptimeMillis = SystemClock.uptimeMillis();
        while (this.mLibInfo == null) {
            try {
                LockMethodProxy.wait(sLock);
            } catch (InterruptedException unused) {
            }
        }
        x0.d(TAG, String.format("Time to wait for shared RELRO: %d ms", Long.valueOf(SystemClock.uptimeMillis() - uptimeMillis)));
    }

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class LibInfo implements Parcelable {
        public static final Parcelable.Creator<LibInfo> CREATOR = new Parcelable.Creator<LibInfo>() { // from class: com.tencent.xweb.pinus.sdk.library_loader.Linker.LibInfo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LibInfo createFromParcel(Parcel parcel) {
                return new LibInfo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public LibInfo[] newArray(int i3) {
                return new LibInfo[i3];
            }
        };
        private static final String EXTRA_LINKER_LIB_INFO = "libinfo";
        public String mLibFilePath;
        public long mLoadAddress;
        public long mLoadSize;
        public int mRelroFd;
        public long mRelroSize;
        public long mRelroStart;

        public LibInfo() {
            this.mRelroFd = -1;
        }

        public static void closeQuietly(Closeable closeable) {
            if (closeable == null) {
                return;
            }
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }

        public static LibInfo fromBundle(Bundle bundle) {
            return (LibInfo) bundle.getParcelable(EXTRA_LINKER_LIB_INFO);
        }

        public void close() {
            int i3 = this.mRelroFd;
            if (i3 >= 0) {
                closeQuietly(ParcelFileDescriptor.adoptFd(i3));
                this.mRelroFd = -1;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 1;
        }

        public Bundle toBundle() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(EXTRA_LINKER_LIB_INFO, this);
            return bundle;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i3) {
            int i16;
            parcel.writeString(this.mLibFilePath);
            parcel.writeLong(this.mLoadAddress);
            parcel.writeLong(this.mLoadSize);
            parcel.writeLong(this.mRelroStart);
            parcel.writeLong(this.mRelroSize);
            if (this.mRelroFd >= 0) {
                i16 = 1;
            } else {
                i16 = 0;
            }
            parcel.writeInt(i16);
            int i17 = this.mRelroFd;
            if (i17 >= 0) {
                try {
                    ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(i17);
                    fromFd.writeToParcel(parcel, 0);
                    fromFd.close();
                } catch (IOException e16) {
                    x0.a(Linker.TAG, "Can't write LibInfo file descriptor to parcel", e16);
                }
            }
        }

        public LibInfo(Parcel parcel) {
            this.mRelroFd = -1;
            this.mLibFilePath = parcel.readString();
            this.mLoadAddress = parcel.readLong();
            this.mLoadSize = parcel.readLong();
            this.mRelroStart = parcel.readLong();
            this.mRelroSize = parcel.readLong();
            if (parcel.readInt() != 0) {
                ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(parcel);
                if (parcelFileDescriptor != null) {
                    this.mRelroFd = parcelFileDescriptor.detachFd();
                    return;
                }
                return;
            }
            this.mRelroFd = -1;
        }
    }

    public void setApkFilePath(String str) {
    }
}
