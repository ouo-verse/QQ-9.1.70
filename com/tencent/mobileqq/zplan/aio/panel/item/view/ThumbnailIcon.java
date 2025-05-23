package com.tencent.mobileqq.zplan.aio.panel.item.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.huawei.hms.hihealth.HiHealthActivities;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.qqmini.sdk.widget.ToastView;
import com.tencent.util.LoadingUtil;
import kotlin.Metadata;
import kotlin.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012\b\b\u0002\u0010 \u001a\u00020\u001f\u0012\b\b\u0002\u0010!\u001a\u00020\u001f\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0012\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u000eR\u0016\u0010\u0014\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\bR$\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00068F@FX\u0086\u000e\u00a2\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/panel/item/view/ThumbnailIcon;", "Landroid/widget/RelativeLayout;", "Landroid/graphics/Canvas;", PM.CANVAS, "", "onDraw", "", "d", "Z", HiHealthActivities.SPINNING, "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "a", "()Landroid/widget/ImageView;", "imageView", "f", "b", "loadingView", h.F, "masking", "value", "getLoading", "()Z", "setLoading", "(Z)V", ToastView.ICON_LOADING, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ThumbnailIcon extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean spinning;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView imageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView loadingView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean masking;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/aio/panel/item/view/ThumbnailIcon$a", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class a extends ViewOutlineProvider {
        a() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), g.c(ThumbnailIcon.this, 8.0f));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThumbnailIcon(Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a, reason: from getter */
    public final ImageView getImageView() {
        return this.imageView;
    }

    /* renamed from: b, reason: from getter */
    public final ImageView getLoadingView() {
        return this.loadingView;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
    }

    public final void setLoading(boolean z16) {
        this.spinning = z16;
        this.masking = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThumbnailIcon(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ThumbnailIcon(Context context, AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ThumbnailIcon(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailIcon(Context context, AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        ImageView imageView = new ImageView(context, attributeSet, i3, i16);
        addView(imageView);
        imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        imageView.setZ(0.0f);
        this.imageView = imageView;
        ImageView imageView2 = new ImageView(context, attributeSet, i3, i16);
        addView(imageView2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        imageView2.setLayoutParams(layoutParams);
        imageView2.setZ(0.0f);
        imageView2.setImageDrawable(LoadingUtil.getLoadingDrawable(context, 2));
        this.loadingView = imageView2;
        setLoading(true);
        setBackgroundColor(Color.rgb(245, 245, 245));
        setClipToOutline(true);
        setOutlineProvider(new a());
    }
}
