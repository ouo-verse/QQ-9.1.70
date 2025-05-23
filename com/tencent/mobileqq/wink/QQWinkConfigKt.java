package com.tencent.mobileqq.wink;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\"!\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\"!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0006\u0010\u0004\u00a8\u0006\b"}, d2 = {"", "Lcom/tencent/mobileqq/wink/QQWinkPage;", "a", "Lkotlin/Lazy;", "()Ljava/util/List;", "winkIndexPages", "b", "winkInspirationPages", "qq-wink-temp-api_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QQWinkConfigKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Lazy f317647a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final Lazy f317648b;

    static {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends QQWinkPage>>() { // from class: com.tencent.mobileqq.wink.QQWinkConfigKt$winkIndexPages$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends QQWinkPage> invoke() {
                List<? extends QQWinkPage> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new QQWinkPage[]{QQWinkPage.Capture, QQWinkPage.MediaPicker, QQWinkPage.Inspiration, QQWinkPage.Live});
                return listOf;
            }
        });
        f317647a = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<List<? extends QQWinkPage>>() { // from class: com.tencent.mobileqq.wink.QQWinkConfigKt$winkInspirationPages$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final List<? extends QQWinkPage> invoke() {
                List<? extends QQWinkPage> listOf;
                listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new QQWinkPage[]{QQWinkPage.TextVideo, QQWinkPage.MemoryAlbum, QQWinkPage.WangZheReport});
                return listOf;
            }
        });
        f317648b = lazy2;
    }

    @NotNull
    public static final List<QQWinkPage> a() {
        return (List) f317647a.getValue();
    }

    @NotNull
    public static final List<QQWinkPage> b() {
        return (List) f317648b.getValue();
    }
}
