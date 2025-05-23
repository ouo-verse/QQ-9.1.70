package com.tencent.android.gldrawable;

import android.util.Log;
import com.tencent.android.gldrawable.api.IConfigStub;
import com.tencent.android.gldrawable.api.IReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/android/gldrawable/ConfigStubImpl;", "Lcom/tencent/android/gldrawable/api/IConfigStub;", "()V", "deleteCacheFiles", "", "disable", "init", "isEnable", "", "log", "msg", "", "e", "", "setDebugGL", "isDebug", "setFpsLimit", "limit", "", "setLogger", "logger", "Lcom/tencent/android/gldrawable/api/IReporter;", "fake_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class ConfigStubImpl implements IConfigStub {
    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public boolean isEnable() {
        return false;
    }

    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public void log(@NotNull String msg2, @Nullable Throwable e16) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Log.e("GLDrawable", msg2, e16);
    }

    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public void deleteCacheFiles() {
    }

    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public void disable() {
    }

    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public void init() {
    }

    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public void setDebugGL(boolean isDebug) {
    }

    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public void setFpsLimit(int limit) {
    }

    @Override // com.tencent.android.gldrawable.api.IConfigStub
    public void setLogger(@Nullable IReporter logger) {
    }
}
