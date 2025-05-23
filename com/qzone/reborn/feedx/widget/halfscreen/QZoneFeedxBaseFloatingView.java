package com.qzone.reborn.feedx.widget.halfscreen;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0001\u0015B\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011B\u001b\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0010\u0010\u0014J\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005R$\u0010\b\u001a\u0004\u0018\u00010\u00058\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0016"}, d2 = {"Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "", "", "m0", "Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView$a;", "listener", "setOnDismissListener", "dismissListener", "Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView$a;", "n0", "()Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView$a;", "setDismissListener", "(Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView$a;)V", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public abstract class QZoneFeedxBaseFloatingView extends QZoneBaseWidgetView<Object> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/qzone/reborn/feedx/widget/halfscreen/QZoneFeedxBaseFloatingView$a;", "", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes37.dex */
    public interface a {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxBaseFloatingView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void m0() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final a n0() {
        return null;
    }

    public final void setOnDismissListener(a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneFeedxBaseFloatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
