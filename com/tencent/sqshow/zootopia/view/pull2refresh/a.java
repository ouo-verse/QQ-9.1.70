package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import com.tencent.widget.pull2refresh.LoadingMoreHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/pull2refresh/a;", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper;", "Lcom/tencent/widget/pull2refresh/LoadingMoreHelper$OnLoadMoreListener;", "loadMoreListener", "", "setOnLoadMoreListener", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", TtmlNode.TAG_LAYOUT, "Landroid/content/Context;", "context", "<init>", "(Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;Landroid/content/Context;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a extends LoadingMoreHelper {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(ILoadMoreLayout layout, Context context) {
        super(layout, context);
        Intrinsics.checkNotNullParameter(layout, "layout");
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.widget.pull2refresh.LoadingMoreHelper
    public void setOnLoadMoreListener(LoadingMoreHelper.OnLoadMoreListener loadMoreListener) {
        this.mLoadMoreListener = loadMoreListener;
        if (loadMoreListener != null) {
            setLoadMoreEnabled(true);
            setLoadMoreComplete(true, true);
        }
    }
}
