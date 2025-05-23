package com.tencent.sqshow.zootopia.nativeui.data.repo;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00152\u00020\u0001:\u0001\u0003B%\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001d\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/t;", "", "", "a", "I", "b", "()I", "op", "", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/g;", "Ljava/util/List;", "()Ljava/util/List;", "data", "", "c", "Z", "getHasMore", "()Z", "hasMore", "<init>", "(ILjava/util/List;Z)V", "d", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int op;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<g> data;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean hasMore;

    public t(int i3, List<g> data, boolean z16) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.op = i3;
        this.data = data;
        this.hasMore = z16;
    }

    public final List<g> a() {
        return this.data;
    }

    /* renamed from: b, reason: from getter */
    public final int getOp() {
        return this.op;
    }
}
