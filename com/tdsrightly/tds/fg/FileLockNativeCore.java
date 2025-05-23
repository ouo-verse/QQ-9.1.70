package com.tdsrightly.tds.fg;

import android.util.Log;
import np.a;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FileLockNativeCore {

    /* renamed from: b, reason: collision with root package name */
    public static int f61293b;

    /* renamed from: a, reason: collision with root package name */
    public int f61294a = -1;

    static {
        try {
            System.loadLibrary("fg");
            f61293b = 1;
        } catch (Throwable th5) {
            Log.e("FileLockNativeCore", "load so fail", th5);
            a.f("load so fail", th5);
        }
    }

    private native int initInner(String str);

    public int a(String str) {
        int initInner = initInner(str);
        if (initInner > 0) {
            this.f61294a = initInner;
        }
        return initInner;
    }

    public boolean b() {
        return isLocked(this.f61294a);
    }

    public int c(boolean z16) {
        return updateLockState(z16, this.f61294a);
    }

    public native boolean isLocked(int i3);

    public native int updateLockState(boolean z16, int i3);
}
