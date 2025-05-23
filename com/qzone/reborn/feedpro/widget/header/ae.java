package com.qzone.reborn.feedpro.widget.header;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/feedpro/widget/header/ae;", "", "Landroid/view/View;", "a", "Landroid/view/View;", "b", "()Landroid/view/View;", "startItem", "endItem", "<init>", "(Landroid/view/View;Landroid/view/View;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class ae {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View startItem;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final View endItem;

    public ae(View startItem, View endItem) {
        Intrinsics.checkNotNullParameter(startItem, "startItem");
        Intrinsics.checkNotNullParameter(endItem, "endItem");
        this.startItem = startItem;
        this.endItem = endItem;
    }

    /* renamed from: a, reason: from getter */
    public final View getEndItem() {
        return this.endItem;
    }

    /* renamed from: b, reason: from getter */
    public final View getStartItem() {
        return this.startItem;
    }
}
