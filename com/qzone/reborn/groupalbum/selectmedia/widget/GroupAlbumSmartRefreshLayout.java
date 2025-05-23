package com.qzone.reborn.groupalbum.selectmedia.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\b\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/widget/GroupAlbumSmartRefreshLayout;", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "", "a", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumSmartRefreshLayout extends SmartRefreshLayout {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumSmartRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean a() {
        return this.mEnableLoadMore;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public GroupAlbumSmartRefreshLayout(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
