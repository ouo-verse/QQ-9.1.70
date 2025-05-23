package com.qzone.reborn.groupalbum.selectmedia.widget.loadMore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.util.ar;
import com.tencent.mobileqq.R;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshFooter;
import com.tencent.richframework.widget.refresh.layout.simple.SimpleComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/qzone/reborn/groupalbum/selectmedia/widget/loadMore/HistoryLoadMoreFooter;", "Lcom/tencent/richframework/widget/refresh/layout/simple/SimpleComponent;", "Lcom/tencent/richframework/widget/refresh/layout/api/IRefreshFooter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes37.dex */
public final class HistoryLoadMoreFooter extends SimpleComponent implements IRefreshFooter {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public HistoryLoadMoreFooter(Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HistoryLoadMoreFooter(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.addView(LayoutInflater.from(context).inflate(R.layout.f127851s, (ViewGroup) null));
        addView(frameLayout, new ViewGroup.LayoutParams(-1, ar.d(50.0f)));
    }
}
