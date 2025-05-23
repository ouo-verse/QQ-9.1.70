package com.tencent.android.gldrawable.api.base;

import com.tencent.android.gldrawable.api.IGLDrawableLoader;
import com.tencent.android.gldrawable.api.ILoaderCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0004X\u0096D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0005R\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/android/gldrawable/api/base/EmptyLoader;", "Lcom/tencent/android/gldrawable/api/IGLDrawableLoader;", "()V", "isLoaded", "", "()Z", "isStatic", "loaderUtils", "Lcom/tencent/android/gldrawable/api/base/EmptyLoadUtils;", "getLoaderUtils", "()Lcom/tencent/android/gldrawable/api/base/EmptyLoadUtils;", "getClassLoader", "", "loadSync", "", "callback", "Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public final class EmptyLoader implements IGLDrawableLoader {
    private final boolean isLoaded;
    private final boolean isStatic = true;

    @NotNull
    private final EmptyLoadUtils loaderUtils = new EmptyLoadUtils();

    @Nullable
    /* renamed from: getClassLoader, reason: collision with other method in class */
    public Void m92getClassLoader() {
        return null;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    /* renamed from: isLoaded, reason: from getter */
    public boolean getIsLoaded() {
        return this.isLoaded;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    /* renamed from: isStatic, reason: from getter */
    public boolean getIsStatic() {
        return this.isStatic;
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    public void loadSync(@NotNull ILoaderCallback callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    public /* bridge */ /* synthetic */ ClassLoader getClassLoader() {
        return (ClassLoader) m92getClassLoader();
    }

    @Override // com.tencent.android.gldrawable.api.IGLDrawableLoader
    @NotNull
    public EmptyLoadUtils getLoaderUtils() {
        return this.loaderUtils;
    }
}
