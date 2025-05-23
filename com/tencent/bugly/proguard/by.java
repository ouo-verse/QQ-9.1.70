package com.tencent.bugly.proguard;

import android.text.TextUtils;
import com.tencent.bugly.common.thread.ThreadManager;
import com.tencent.bugly.crashreport.crash.jni.NativeCrashHandler;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class by implements com.tencent.rmonitor.common.lifecycle.d {

    /* renamed from: a, reason: collision with root package name */
    private a f98374a = null;

    /* renamed from: b, reason: collision with root package name */
    private boolean f98375b = false;

    /* renamed from: c, reason: collision with root package name */
    private String f98376c = null;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            NativeCrashHandler nativeCrashHandler = NativeCrashHandler.getInstance();
            if (nativeCrashHandler != null) {
                nativeCrashHandler.setStage(by.this.f98376c);
            }
            by.b(by.this);
        }

        /* synthetic */ a(by byVar, byte b16) {
            this();
        }
    }

    static /* synthetic */ boolean b(by byVar) {
        byVar.f98375b = false;
        return false;
    }

    @Override // com.tencent.rmonitor.common.lifecycle.d
    public final void onSceneChanged(String str) {
        if (TextUtils.equals(this.f98376c, str)) {
            return;
        }
        this.f98376c = str;
        if (!this.f98375b) {
            if (this.f98374a == null) {
                this.f98374a = new a(this, (byte) 0);
            }
            this.f98375b = true;
            ThreadManager.runInMainThread(this.f98374a, 10000L);
        }
    }
}
