package com.tencent.mobileqq.zplan.emoticon.panel.view;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.zplan.utils.bb;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0004B%\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0016\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u000f\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/panel/view/ZPlanPopupView;", "Landroid/widget/LinearLayout;", "", "designerPx", "a", "Landroid/graphics/drawable/Drawable;", "image", "", "setImageDrawable", "Landroid/view/ViewGroup;", "parentView", "Landroid/view/View;", "referenceView", "c", "b", "d", "Lcom/tencent/image/URLImageView;", "Lcom/tencent/image/URLImageView;", "imageView", "e", "Landroid/view/ViewGroup;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPopupView extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final URLImageView imageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewGroup parentView;

    public /* synthetic */ ZPlanPopupView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final int a(int designerPx) {
        bb bbVar = bb.f335811a;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return bbVar.a(context, designerPx, 750);
    }

    public final void c(ViewGroup parentView, View referenceView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(referenceView, "referenceView");
        ViewGroup viewGroup = this.parentView;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.parentView = parentView;
        parentView.addView(this, a(203), a(211));
        d(referenceView);
        if (QQTheme.isNowThemeIsNight()) {
            setBackgroundResource(R.drawable.hzj);
        } else {
            setBackgroundResource(R.drawable.hye);
        }
        setVisibility(0);
    }

    public final void d(View referenceView) {
        Intrinsics.checkNotNullParameter(referenceView, "referenceView");
        Rect rect = new Rect();
        View view = (View) getParent();
        if (view != null) {
            view.getGlobalVisibleRect(rect);
        }
        Rect rect2 = new Rect();
        referenceView.getGlobalVisibleRect(rect2);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        int width = (rect2.left - rect.left) - ((marginLayoutParams.width - rect2.width()) / 2);
        marginLayoutParams.leftMargin = width;
        marginLayoutParams.topMargin = (rect2.top - rect.top) - marginLayoutParams.height;
        marginLayoutParams.leftMargin = width - Math.max((marginLayoutParams.width + width) - rect.width(), 0);
        int i3 = marginLayoutParams.topMargin;
        marginLayoutParams.topMargin = i3 - Math.max((marginLayoutParams.height + i3) - rect.height(), 0);
        marginLayoutParams.leftMargin = Math.max(marginLayoutParams.leftMargin, 0);
        marginLayoutParams.topMargin = Math.max(marginLayoutParams.topMargin, 0);
        setLayoutParams(marginLayoutParams);
        requestLayout();
    }

    public final void setImageDrawable(Drawable image) {
        this.imageView.setImageDrawable(image);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanPopupView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        URLImageView uRLImageView = new URLImageView(context);
        uRLImageView.setLayoutParams(new LinearLayout.LayoutParams(a(161), a(166)));
        uRLImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        this.imageView = uRLImageView;
        setVisibility(8);
        setOrientation(1);
        setGravity(17);
        addView(uRLImageView);
    }

    public final void b() {
        setVisibility(8);
        ViewGroup viewGroup = this.parentView;
        if (viewGroup != null) {
            viewGroup.removeView(this);
        }
        this.parentView = null;
    }
}
