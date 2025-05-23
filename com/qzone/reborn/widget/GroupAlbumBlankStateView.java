package com.qzone.reborn.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.qzone.reborn.widget.QZoneBlankStateView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u00a2\u0006\u0004\b\u0019\u0010\u001dB#\b\u0016\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\u0006\u0010\u001e\u001a\u00020\b\u00a2\u0006\u0004\b\u0019\u0010\u001fJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\bH\u0014J\u0006\u0010\u000e\u001a\u00020\rJ\u0006\u0010\u000f\u001a\u00020\rJ\u0006\u0010\u0010\u001a\u00020\u0003R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013\u00a8\u0006 "}, d2 = {"Lcom/qzone/reborn/widget/GroupAlbumBlankStateView;", "Lcom/qzone/reborn/widget/QZoneBaseWidgetView;", "Luc/a;", "", "hideErrorView", "p0", "Landroid/view/ViewGroup$LayoutParams;", "n0", "", "getLayoutId", "data", "position", "m0", "", "q0", "r0", "o0", "Landroid/view/View;", "e", "Landroid/view/View;", "mEmptyView", "f", "mErrorView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class GroupAlbumBlankStateView extends QZoneBaseWidgetView<uc.a> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View mEmptyView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View mErrorView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumBlankStateView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void hideErrorView() {
        View view = this.mErrorView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    private final ViewGroup.LayoutParams n0() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        return layoutParams;
    }

    private final void p0() {
        View view = this.mEmptyView;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return 0;
    }

    public final boolean q0() {
        QZoneBlankStateView.a a16;
        View view = this.mEmptyView;
        if (view != null) {
            if (view != null) {
                view.setVisibility(0);
            }
            hideErrorView();
            setVisibility(0);
            return true;
        }
        uc.a data = getData();
        QUIEmptyState.Builder builder = (data == null || (a16 = data.a()) == null) ? null : a16.f59617e;
        if (builder == null) {
            return false;
        }
        QUIEmptyState build = builder.build();
        this.mEmptyView = build;
        if (build != null) {
            build.setVisibility(0);
        }
        addView(this.mEmptyView, n0());
        hideErrorView();
        setVisibility(0);
        return true;
    }

    public final boolean r0() {
        QZoneBlankStateView.a b16;
        View view = this.mErrorView;
        if (view != null) {
            if (view != null) {
                view.setVisibility(0);
            }
            p0();
            setVisibility(0);
            return true;
        }
        uc.a data = getData();
        QUIEmptyState.Builder builder = (data == null || (b16 = data.b()) == null) ? null : b16.f59617e;
        if (builder == null) {
            return false;
        }
        QUIEmptyState build = builder.build();
        this.mErrorView = build;
        if (build != null) {
            build.setVisibility(0);
        }
        addView(this.mErrorView, n0());
        p0();
        setVisibility(0);
        return true;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumBlankStateView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupAlbumBlankStateView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void o0() {
        setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void bindData(uc.a data, int position) {
    }
}
