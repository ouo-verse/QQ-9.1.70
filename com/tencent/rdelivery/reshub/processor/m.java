package com.tencent.rdelivery.reshub.processor;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\" \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0002\u0010\u0004\" \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00010\u00008\u0000X\u0080\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\u0004\u00a8\u0006\t"}, d2 = {"", "Lcom/tencent/rdelivery/reshub/processor/a;", "a", "Ljava/util/List;", "()Ljava/util/List;", "loadResProcessors", "b", "getFetchResConfigProcessors", "fetchResConfigProcessors", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final List<a> f364559a;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final List<a> f364560b;

    static {
        List<a> listOf;
        List<a> listOf2;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new h(), new e(), new f(), new b(), new c(), new d(), new DownloadProcessor(), new g(), new i(), new o(), new q()});
        f364559a = listOf;
        listOf2 = CollectionsKt__CollectionsKt.listOf((Object[]) new a[]{new h(), new n()});
        f364560b = listOf2;
    }

    @NotNull
    public static final List<a> a() {
        return f364559a;
    }
}
