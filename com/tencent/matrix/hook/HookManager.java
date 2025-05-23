package com.tencent.matrix.hook;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.matrix.hook.AbsHook;
import g51.b;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class HookManager {

    /* renamed from: e, reason: collision with root package name */
    public static final HookManager f151453e = new HookManager();

    /* renamed from: a, reason: collision with root package name */
    private volatile boolean f151454a = false;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f151455b = new byte[0];

    /* renamed from: c, reason: collision with root package name */
    private final Set<AbsHook> f151456c = new HashSet();

    /* renamed from: d, reason: collision with root package name */
    private volatile boolean f151457d = false;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class HookFailedException extends Exception {
        public HookFailedException(String str) {
            super(str);
        }
    }

    HookManager() {
    }

    private void c() throws HookFailedException {
        synchronized (this.f151456c) {
            for (AbsHook absHook : this.f151456c) {
                String a16 = absHook.a();
                if (!TextUtils.isEmpty(a16)) {
                    try {
                        System.loadLibrary(a16);
                    } catch (Throwable th5) {
                        b.d("Matrix.HookManager", th5, "", new Object[0]);
                        b.b("Matrix.HookManager", "Fail to load native library for %s, skip next steps.", absHook.getClass().getName());
                        absHook.e(AbsHook.Status.COMMIT_FAIL_ON_LOAD_LIB);
                    }
                }
            }
            for (AbsHook absHook2 : this.f151456c) {
                if (absHook2.b() != AbsHook.Status.UNCOMMIT) {
                    b.b("Matrix.HookManager", "%s has failed steps before, skip calling onConfigure on it.", absHook2.getClass().getName());
                } else if (!absHook2.c()) {
                    b.b("Matrix.HookManager", "Fail to configure %s, skip next steps", absHook2.getClass().getName());
                    absHook2.e(AbsHook.Status.COMMIT_FAIL_ON_CONFIGURE);
                }
            }
            for (AbsHook absHook3 : this.f151456c) {
                if (absHook3.b() != AbsHook.Status.UNCOMMIT) {
                    b.b("Matrix.HookManager", "%s has failed steps before, skip calling onHook on it.", absHook3.getClass().getName());
                } else if (absHook3.d(this.f151457d)) {
                    b.c("Matrix.HookManager", "%s is committed successfully.", absHook3.getClass().getName());
                    absHook3.e(AbsHook.Status.COMMIT_SUCCESS);
                } else {
                    b.b("Matrix.HookManager", "Fail to do hook in %s.", absHook3.getClass().getName());
                    absHook3.e(AbsHook.Status.COMMIT_FAIL_ON_HOOK);
                }
            }
            this.f151456c.clear();
        }
    }

    private static String d(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr == null) {
            return "";
        }
        StringBuilder sb5 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            if (!stackTraceElement.getClassName().contains("java.lang.Thread")) {
                sb5.append(stackTraceElement);
                sb5.append(';');
            }
        }
        return sb5.toString();
    }

    private native void doFinalInitializeNative(boolean z16);

    private native boolean doPreHookInitializeNative(boolean z16);

    @Keep
    public static String getStack() {
        return d(Thread.currentThread().getStackTrace());
    }

    public HookManager a(@Nullable AbsHook absHook) {
        if (absHook != null && absHook.b() != AbsHook.Status.COMMIT_SUCCESS) {
            synchronized (this.f151456c) {
                this.f151456c.add(absHook);
            }
        }
        return this;
    }

    public void b() throws HookFailedException {
        synchronized (this.f151455b) {
            synchronized (this.f151456c) {
                if (this.f151456c.isEmpty()) {
                    return;
                }
                if (!this.f151454a) {
                    try {
                        System.loadLibrary("matrix-hookcommon");
                        if (doPreHookInitializeNative(this.f151457d)) {
                            c();
                            doFinalInitializeNative(this.f151457d);
                            this.f151454a = true;
                        } else {
                            throw new HookFailedException("Fail to do hook common pre-hook initialize.");
                        }
                    } catch (Throwable th5) {
                        b.d("Matrix.HookManager", th5, "", new Object[0]);
                    }
                } else {
                    c();
                }
            }
        }
    }
}
