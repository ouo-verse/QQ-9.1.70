package com.tencent.sqshow.zootopia.view.pull2refresh;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.widget.pull2refresh.ILoadMoreLayout;
import com.tencent.widget.pull2refresh.anim.IAnimManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0006H\u0014J\b\u0010\n\u001a\u00020\tH\u0014J\u000e\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/pull2refresh/ZootopiaPullRefreshLayout;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/XPullToRefreshView;", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/e;", "J", "Lcom/tencent/widget/pull2refresh/anim/IAnimManager$OnRefreshPullDistanceListener;", "listener", "", "setOnRefreshPullDistanceListener", "j", "Lcom/tencent/widget/pull2refresh/ILoadMoreLayout;", BdhLogUtil.LogTag.Tag_Conn, "", "needNight", "setHeaderNightStyle", "K", "W", "Lcom/tencent/sqshow/zootopia/view/pull2refresh/e;", "animManager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaPullRefreshLayout extends XPullToRefreshView {

    /* renamed from: W, reason: from kotlin metadata */
    private e animManager;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaPullRefreshLayout(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final e J() {
        if (this.animManager == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            this.animManager = new e(context);
        }
        return this.animManager;
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.XPullToRefreshView
    protected ILoadMoreLayout C() {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return new ZootopiaLoadMoreView(context, null, 0, 6, null);
    }

    public final void K() {
        e eVar = this.animManager;
        if (eVar != null) {
            eVar.a();
        }
    }

    @Override // com.tencent.sqshow.zootopia.view.pull2refresh.AbsPullToRefreshView
    protected void j() {
        setAnimType(J());
    }

    public final void setHeaderNightStyle(boolean needNight) {
        e eVar = this.animManager;
        if (eVar != null) {
            eVar.c(needNight);
        }
    }

    public final void setOnRefreshPullDistanceListener(IAnimManager.OnRefreshPullDistanceListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        e J = J();
        if (J != null) {
            J.setRefreshPullDistanceListener(listener);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaPullRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaPullRefreshLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaPullRefreshLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
