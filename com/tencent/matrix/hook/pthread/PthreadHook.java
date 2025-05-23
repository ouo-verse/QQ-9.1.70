package com.tencent.matrix.hook.pthread;

import android.text.TextUtils;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.matrix.hook.AbsHook;
import g51.b;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes9.dex */
public class PthreadHook extends AbsHook {

    /* renamed from: i, reason: collision with root package name */
    public static final PthreadHook f151479i = new PthreadHook();

    /* renamed from: b, reason: collision with root package name */
    private Set<String> f151480b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private boolean f151481c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f151482d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f151483e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f151484f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f151485g = false;

    /* renamed from: h, reason: collision with root package name */
    private boolean f151486h = false;

    PthreadHook() {
    }

    @Keep
    private native void addHookThreadNameNative(String[] strArr);

    @Keep
    private native void dumpNative(String str);

    @Keep
    private native void enableLoggerNative(boolean z16);

    @Keep
    private native void enableQuickenNative(boolean z16);

    @Keep
    private native void enableTracePthreadReleaseNative(boolean z16);

    @Keep
    private native void installHooksNative(boolean z16);

    @Keep
    private native void setThreadStackShrinkEnabledNative(boolean z16);

    @Keep
    private native boolean setThreadStackShrinkIgnoredCreatorSoPatternsNative(String[] strArr);

    @Keep
    private native void setThreadTraceEnabledNative(boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.hook.AbsHook
    @Nullable
    public String a() {
        return "matrix-pthreadhook";
    }

    @Override // com.tencent.matrix.hook.AbsHook
    public boolean c() {
        addHookThreadNameNative((String[]) this.f151480b.toArray(new String[0]));
        enableQuickenNative(this.f151481c);
        enableLoggerNative(this.f151482d);
        enableTracePthreadReleaseNative(this.f151486h);
        setThreadStackShrinkIgnoredCreatorSoPatternsNative(null);
        setThreadStackShrinkEnabledNative(false);
        setThreadTraceEnabledNative(this.f151484f);
        this.f151483e = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.hook.AbsHook
    public boolean d(boolean z16) {
        if (this.f151484f && !this.f151485g) {
            installHooksNative(z16);
            this.f151485g = true;
        }
        return true;
    }

    public PthreadHook f(String str) {
        if (TextUtils.isEmpty(str)) {
            b.b("Matrix.Pthread", "thread regex is empty!!!", new Object[0]);
        } else {
            this.f151480b.add(str);
        }
        return this;
    }

    public void g(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (b() == AbsHook.Status.COMMIT_SUCCESS) {
                dumpNative(str);
            }
        } else {
            throw new IllegalArgumentException("path NOT valid: " + str);
        }
    }

    public void h(boolean z16) {
        this.f151482d = z16;
        if (this.f151483e) {
            enableLoggerNative(z16);
        }
    }

    public void i(boolean z16) {
        this.f151481c = z16;
        if (this.f151483e) {
            enableQuickenNative(z16);
        }
    }

    public PthreadHook j(boolean z16) {
        this.f151486h = z16;
        return this;
    }

    public PthreadHook k(boolean z16) {
        this.f151484f = z16;
        return this;
    }
}
