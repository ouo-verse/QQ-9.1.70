package com.tencent.android.gldrawable.api;

import com.tencent.android.gldrawable.api.base.EmptyLoaderCallback;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH&J\u0012\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH&R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0004R\u0012\u0010\u0006\u001a\u00020\u0007X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\b\u0010\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/android/gldrawable/api/IGLDrawableLoader;", "", "isLoaded", "", "()Z", "isStatic", "loaderUtils", "Lcom/tencent/android/gldrawable/api/ILoadUtils;", "getLoaderUtils", "()Lcom/tencent/android/gldrawable/api/ILoadUtils;", "getClassLoader", "Ljava/lang/ClassLoader;", "loadSync", "", "callback", "Lcom/tencent/android/gldrawable/api/ILoaderCallback;", "api_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes3.dex */
public interface IGLDrawableLoader {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes3.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void loadSync$default(IGLDrawableLoader iGLDrawableLoader, ILoaderCallback iLoaderCallback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    iLoaderCallback = new EmptyLoaderCallback();
                }
                iGLDrawableLoader.loadSync(iLoaderCallback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSync");
        }
    }

    @Nullable
    ClassLoader getClassLoader();

    @NotNull
    ILoadUtils getLoaderUtils();

    boolean isLoaded();

    boolean isStatic();

    void loadSync(@NotNull ILoaderCallback callback);
}
