package com.tencent.mobileqq.wink.editor.sticker;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0002R\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u0010\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\u000b\u001a\u0004\b\u000f\u0010\r\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/StickerLayerIndexManager;", "", "", "d", "maskStickerLayerIndex", "", "f", "b", "commonStickerLayerIndex", "e", "Ljava/util/concurrent/atomic/AtomicInteger;", "Lkotlin/Lazy;", "c", "()Ljava/util/concurrent/atomic/AtomicInteger;", "maskStickerIndex", "a", "commonStickerIndex", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class StickerLayerIndexManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final StickerLayerIndexManager f321548a = new StickerLayerIndexManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy maskStickerIndex;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy commonStickerIndex;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AtomicInteger>() { // from class: com.tencent.mobileqq.wink.editor.sticker.StickerLayerIndexManager$maskStickerIndex$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AtomicInteger invoke() {
                return new AtomicInteger(0);
            }
        });
        maskStickerIndex = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<AtomicInteger>() { // from class: com.tencent.mobileqq.wink.editor.sticker.StickerLayerIndexManager$commonStickerIndex$2
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

    private final AtomicInteger c() {
        return (AtomicInteger) maskStickerIndex.getValue();
    }

    public final int b() {
        return a().getAndIncrement();
    }

    public final int d() {
        return c().getAndIncrement();
    }

    public final void e(int commonStickerLayerIndex) {
        a().set(commonStickerLayerIndex + 1);
    }

    public final void f(int maskStickerLayerIndex) {
        c().set(maskStickerLayerIndex + 1);
    }
}
