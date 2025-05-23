package com.qzone.reborn.feedx.util;

import androidx.recyclerview.widget.RecyclerView;
import com.qzone.reborn.feedx.util.QZoneFeedEventTagItemViewFactory;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/qzone/reborn/feedx/util/b;", "Landroidx/recyclerview/widget/RecyclerView$RecycledViewPool;", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class b extends RecyclerView.RecycledViewPool {
    public b() {
        setMaxRecycledViews(QZoneFeedEventTagItemViewFactory.ItemType.TEXT.getType(), 12);
        setMaxRecycledViews(QZoneFeedEventTagItemViewFactory.ItemType.PICTURE.getType(), 12);
        setMaxRecycledViews(QZoneFeedEventTagItemViewFactory.ItemType.VIDEO.getType(), 12);
    }
}
