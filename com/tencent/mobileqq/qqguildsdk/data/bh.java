package com.tencent.mobileqq.qqguildsdk.data;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n\u00a2\u0006\u0004\b\u0010\u0010\u0011R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\u0003\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/bh;", "", "", "a", "I", "b", "()I", "setId", "(I)V", "id", "", "Ljava/util/List;", "()Ljava/util/List;", "setChildIds", "(Ljava/util/List;)V", "childIds", "<init>", "(ILjava/util/List;)V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class bh {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<Integer> childIds;

    public bh(int i3, @NotNull List<Integer> childIds) {
        Intrinsics.checkNotNullParameter(childIds, "childIds");
        this.id = i3;
        this.childIds = childIds;
    }

    @NotNull
    public final List<Integer> a() {
        return this.childIds;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    public /* synthetic */ bh(int i3, List list, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? new ArrayList() : list);
    }
}
