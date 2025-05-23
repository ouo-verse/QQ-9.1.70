package com.tencent.mobileqq.wink.editor.clipping.thumbnail;

import android.util.LruCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R#\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/j;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "assetPath", "Landroid/util/LruCache;", "Lcom/tencent/mobileqq/wink/editor/clipping/thumbnail/g;", "", "b", "Landroid/util/LruCache;", "()Landroid/util/LruCache;", "lruCache", "<init>", "(Ljava/lang/String;Landroid/util/LruCache;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String assetPath;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LruCache<LRUKey, Integer> lruCache;

    public j(@NotNull String assetPath, @NotNull LruCache<LRUKey, Integer> lruCache) {
        Intrinsics.checkNotNullParameter(assetPath, "assetPath");
        Intrinsics.checkNotNullParameter(lruCache, "lruCache");
        this.assetPath = assetPath;
        this.lruCache = lruCache;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAssetPath() {
        return this.assetPath;
    }

    @NotNull
    public final LruCache<LRUKey, Integer> b() {
        return this.lruCache;
    }
}
