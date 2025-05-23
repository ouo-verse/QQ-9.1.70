package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.data;

import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0012\u0010\u0006\u001a\u00020\u0003*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0001\u00a8\u0006\u0007"}, d2 = {"Ls53/a;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/WinkAlbumItemType;", "type", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/data/a;", "b", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "a", "qq-wink-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {
    @NotNull
    public static final WinkAlbumItemWrapper a(@NotNull WinkNewMemoryAlbumResult winkNewMemoryAlbumResult, @NotNull WinkAlbumItemType type) {
        Intrinsics.checkNotNullParameter(winkNewMemoryAlbumResult, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return new WinkAlbumItemWrapper(type, null, winkNewMemoryAlbumResult, 2, null);
    }

    @NotNull
    public static final WinkAlbumItemWrapper b(@NotNull s53.a aVar, @NotNull WinkAlbumItemType type) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return new WinkAlbumItemWrapper(type, aVar, null, 4, null);
    }
}
