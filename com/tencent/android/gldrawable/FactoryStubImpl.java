package com.tencent.android.gldrawable;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.android.gldrawable.api.IFactoryStub;
import com.tencent.android.gldrawable.api.IGLDrawable;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\u00012\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/android/gldrawable/FactoryStubImpl;", "Lcom/tencent/android/gldrawable/api/IFactoryStub;", "()V", "fromBundle", "Lcom/tencent/android/gldrawable/api/IGLDrawable;", "bundle", "Landroid/os/Bundle;", "fromFile", "file", "Ljava/io/File;", "setWorkHandler", "handler", "Landroid/os/Handler;", "useCache", "b", "", "fake_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class FactoryStubImpl implements IFactoryStub {
    @Override // com.tencent.android.gldrawable.api.IFactoryStub
    @Nullable
    public IGLDrawable fromBundle(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        return null;
    }

    @Override // com.tencent.android.gldrawable.api.IFactoryStub
    @Nullable
    public IGLDrawable fromFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return null;
    }

    @Override // com.tencent.android.gldrawable.api.IFactoryStub
    @NotNull
    public IFactoryStub setWorkHandler(@Nullable Handler handler) {
        return this;
    }

    @Override // com.tencent.android.gldrawable.api.IFactoryStub
    @NotNull
    public IFactoryStub useCache(boolean b16) {
        return this;
    }
}
