package com.tencent.matrix.hook.memory;

import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import com.tencent.matrix.hook.AbsHook;
import g51.b;
import java.util.HashSet;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes9.dex */
public class MemoryHook extends AbsHook {

    /* renamed from: k, reason: collision with root package name */
    public static final MemoryHook f151468k = new MemoryHook();

    /* renamed from: d, reason: collision with root package name */
    private int f151471d;

    /* renamed from: e, reason: collision with root package name */
    private int f151472e;

    /* renamed from: g, reason: collision with root package name */
    private boolean f151474g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f151475h;

    /* renamed from: b, reason: collision with root package name */
    private final Set<String> f151469b = new HashSet();

    /* renamed from: c, reason: collision with root package name */
    private final Set<String> f151470c = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    private int f151473f = 10485760;

    /* renamed from: i, reason: collision with root package name */
    private boolean f151476i = false;

    /* renamed from: j, reason: collision with root package name */
    private boolean f151477j = false;

    MemoryHook() {
    }

    @Keep
    private native void dumpNative(String str, String str2);

    @Keep
    private native void enableMmapHookNative(boolean z16);

    @Keep
    private native void enableStacktraceNative(boolean z16);

    @Keep
    private native void installHooksNative(String[] strArr, String[] strArr2, boolean z16);

    @Keep
    private native void setStacktraceLogThresholdNative(int i3);

    @Keep
    private native void setTracingAllocSizeRangeNative(int i3, int i16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.hook.AbsHook
    @Nullable
    public String a() {
        return "matrix-memoryhook";
    }

    @Override // com.tencent.matrix.hook.AbsHook
    public boolean c() {
        int i3;
        if (this.f151476i) {
            b.e("Matrix.MemoryHook", "MemGuard has been installed, skip MemoryHook install logic.", new Object[0]);
            return false;
        }
        int i16 = this.f151471d;
        if (i16 >= 0 && ((i3 = this.f151472e) == 0 || i3 >= i16)) {
            b.a("Matrix.MemoryHook", "enable mmap? " + this.f151475h, new Object[0]);
            enableMmapHookNative(this.f151475h);
            setTracingAllocSizeRangeNative(this.f151471d, this.f151472e);
            setStacktraceLogThresholdNative(this.f151473f);
            enableStacktraceNative(this.f151474g);
            return true;
        }
        throw new IllegalArgumentException("sizes should not be negative and maxSize should be 0 or greater than minSize: min = " + this.f151471d + ", max = " + this.f151472e);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.hook.AbsHook
    public boolean d(boolean z16) {
        if (!this.f151477j) {
            installHooksNative((String[]) this.f151469b.toArray(new String[0]), (String[]) this.f151470c.toArray(new String[0]), z16);
            this.f151477j = true;
        }
        return true;
    }
}
