package com.tencent.rdelivery.reshub.processor;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0005H\u0016R\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u000fj\b\u0012\u0004\u0012\u00020\u0003`\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/rdelivery/reshub/processor/l;", "", "", "Lcom/tencent/rdelivery/reshub/processor/a;", "processorList", "", "a", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "d", "c", "b", "", "I", "index", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "list", "<init>", "()V", "reshub_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public class l {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int index = -1;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<a> list = new ArrayList<>();

    public final void a(@NotNull List<? extends a> processorList) {
        Intrinsics.checkParameterIsNotNull(processorList, "processorList");
        this.list.addAll(processorList);
    }

    public void b() {
        this.list.clear();
    }

    public void c(@NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        int i3 = this.index + 1;
        this.index = i3;
        if (i3 >= this.list.size()) {
            return;
        }
        a aVar = this.list.get(this.index);
        Intrinsics.checkExpressionValueIsNotNull(aVar, "list[index]");
        com.tencent.rdelivery.reshub.util.e.c(aVar, req, this);
    }

    public final void d(@NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(req, "req");
        this.list.addAll(com.tencent.rdelivery.reshub.core.j.L.r());
        CollectionsKt__MutableCollectionsJVMKt.sort(this.list);
        c(req);
    }
}
