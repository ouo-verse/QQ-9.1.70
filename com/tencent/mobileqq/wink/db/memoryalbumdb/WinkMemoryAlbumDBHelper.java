package com.tencent.mobileqq.wink.db.memoryalbumdb;

import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.templatelibrary.memoryalbum.WinkMemoryAlbumConfig;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000eJ!\u0010\u000f\u001a\u00020\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000f\u0010\fJ!\u0010\u0011\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0011\u0010\fJ\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/db/memoryalbumdb/WinkMemoryAlbumDBHelper;", "", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;", DownloadInfo.spKey_Config, "", "Ls53/a;", "b", "(Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/l;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Ls53/b;", "photoList", "", "e", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "a", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "f", "albums", "d", "", "", "c", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemoryAlbumDBHelper {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final WinkMemoryAlbumDBHelper f318173a = new WinkMemoryAlbumDBHelper();

    WinkMemoryAlbumDBHelper() {
    }

    @Nullable
    public final Object a(@NotNull Continuation<? super List<s53.b>> continuation) {
        return CoroutineScopeKt.coroutineScope(new WinkMemoryAlbumDBHelper$findALlPhotos$2(null), continuation);
    }

    @Nullable
    public final Object b(@NotNull WinkMemoryAlbumConfig winkMemoryAlbumConfig, @NotNull Continuation<? super List<s53.a>> continuation) {
        return CoroutineScopeKt.coroutineScope(new WinkMemoryAlbumDBHelper$findAlbumByConfig$2(winkMemoryAlbumConfig, null), continuation);
    }

    @Nullable
    public final Object c(@NotNull Continuation<? super Set<String>> continuation) {
        return CoroutineScopeKt.coroutineScope(new WinkMemoryAlbumDBHelper$findAllAlbumIds$2(null), continuation);
    }

    @Nullable
    public final Object d(@NotNull List<s53.a> list, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new WinkMemoryAlbumDBHelper$insertAlbums$2(list, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object e(@NotNull List<s53.b> list, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new WinkMemoryAlbumDBHelper$insertPhotos$2(list, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public final Object f(@NotNull List<s53.b> list, @NotNull Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new WinkMemoryAlbumDBHelper$updatePhotosFaceInfo$2(list, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (coroutineScope == coroutine_suspended) {
            return coroutineScope;
        }
        return Unit.INSTANCE;
    }
}
