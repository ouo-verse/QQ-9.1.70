package com.tencent.mobileqq.qqvideoedit.editor.sticker;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0006\u0010\u0003\u001a\u00020\u0002R\u001b\u0010\b\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u000b\u001a\u00020\u00048BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/StickerLayerIndexManager;", "", "", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlin/Lazy;", "getReservedStickerIndex", "()Ljava/util/concurrent/atomic/AtomicInteger;", "reservedStickerIndex", "c", "a", "commonStickerIndex", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class StickerLayerIndexManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StickerLayerIndexManager f275821a = new StickerLayerIndexManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy reservedStickerIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy commonStickerIndex;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AtomicInteger>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.sticker.StickerLayerIndexManager$reservedStickerIndex$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AtomicInteger invoke() {
                return new AtomicInteger(0);
            }
        });
        reservedStickerIndex = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AtomicInteger>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.sticker.StickerLayerIndexManager$commonStickerIndex$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AtomicInteger invoke() {
                return new AtomicInteger(65536);
            }
        });
        commonStickerIndex = lazy2;
    }

    StickerLayerIndexManager() {
    }

    private final AtomicInteger a() {
        return (AtomicInteger) commonStickerIndex.getValue();
    }

    public final int b() {
        return a().getAndIncrement();
    }
}
