package com.tencent.matrix.hook.memory;

import android.os.Build;
import androidx.annotation.Nullable;
import com.tencent.matrix.hook.AbsHook;

/* loaded from: classes9.dex */
public class WVPreAllocHook extends AbsHook {

    /* renamed from: b, reason: collision with root package name */
    public static final WVPreAllocHook f151478b = new WVPreAllocHook();

    private native boolean installHooksNative(int i3, ClassLoader classLoader, boolean z16);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.hook.AbsHook
    @Nullable
    public String a() {
        return "matrix-memoryhook";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.hook.AbsHook
    public boolean c() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.matrix.hook.AbsHook
    public boolean d(boolean z16) {
        return installHooksNative(Build.VERSION.SDK_INT, getClass().getClassLoader(), z16);
    }
}
