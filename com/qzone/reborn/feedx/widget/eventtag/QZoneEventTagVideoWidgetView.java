package com.qzone.reborn.feedx.widget.eventtag;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.qzone.reborn.feedx.widget.eventtag.QZoneEventTagVideoWidgetView;
import com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.richframework.widget.RoundCorneredFrameLayout;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import rh.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0012B'\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002J\b\u0010\t\u001a\u00020\bH\u0014\u00a8\u0006\u0013"}, d2 = {"Lcom/qzone/reborn/feedx/widget/eventtag/QZoneEventTagVideoWidgetView;", "Lcom/qzone/reborn/feedx/widget/picmixvideo/QZoneVideoItemWidgetView;", "", "getLayoutId", "", "F0", NodeProps.MARGIN_BOTTOM, "setTimeMuteLayoutMarginBottom", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "K0", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleArr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneEventTagVideoWidgetView extends QZoneVideoItemWidgetView {
    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagVideoWidgetView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n1(QZoneEventTagVideoWidgetView this$0, LoadState loadState, Option option) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setTag(R.id.nda, option != null ? option.getUrl() : null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public void F0() {
        if (this.D == null) {
            QLog.e("QZoneEventTagVideoWidgetView", 1, "adjustViewSize  params error");
            return;
        }
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        c.f431447a.b(getContext(), layoutParams, this.D);
        i1(this.F, layoutParams.width, layoutParams.height);
        i1(this.E, layoutParams.width, layoutParams.height);
        i1(this.f56457i, layoutParams.width, layoutParams.height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView
    public IPicLoadStateListener K0() {
        return new IPicLoadStateListener() { // from class: rh.b
            @Override // com.tencent.libra.listener.IPicLoadStateListener
            public final void onStateChange(LoadState loadState, Option option) {
                QZoneEventTagVideoWidgetView.n1(QZoneEventTagVideoWidgetView.this, loadState, option);
            }
        };
    }

    @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZoneVideoItemWidgetView, com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chq;
    }

    public final void setTimeMuteLayoutMarginBottom(int marginBottom) {
        LinearLayout linearLayout = this.H;
        if (linearLayout == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        marginLayoutParams.bottomMargin = marginBottom;
        this.H.setLayoutParams(marginLayoutParams);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagVideoWidgetView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ QZoneEventTagVideoWidgetView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QZoneEventTagVideoWidgetView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = this.G;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.lef);
        }
        RoundCorneredFrameLayout roundCorneredFrameLayout = this.f56457i;
        if (roundCorneredFrameLayout != null) {
            roundCorneredFrameLayout.setRadius(0.0f);
        }
    }
}
