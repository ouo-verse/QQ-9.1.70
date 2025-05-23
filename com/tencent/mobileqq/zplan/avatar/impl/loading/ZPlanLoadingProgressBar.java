package com.tencent.mobileqq.zplan.avatar.impl.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.zplan.avatar.impl.loading.ZPlanLoadingProgressBar;
import com.tencent.sqshow.zootopia.utils.i;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB'\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0016\u0010\t\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u000f\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0016\u0010\u0011\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\b\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/avatar/impl/loading/ZPlanLoadingProgressBar;", "Landroid/widget/FrameLayout;", "", "c", "", "progress", HippyQQPagView.FunctionName.SET_PROGRESS, "d", "I", "mHintSize", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "mHintImageView", "f", "mProgressImageView", h.F, "mProgress", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "i", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanLoadingProgressBar extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mHintSize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final ImageView mHintImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ImageView mProgressImageView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mProgress;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingProgressBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ZPlanLoadingProgressBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setProgress(0);
    }

    private final void c() {
        int width = this.mProgressImageView.getWidth();
        ViewGroup.LayoutParams layoutParams = this.mHintImageView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 == null) {
            return;
        }
        layoutParams2.leftMargin = (int) (((this.mProgress * 1.0f) / 100.0f) * (width - this.mHintSize));
        this.mHintImageView.setLayoutParams(layoutParams2);
        requestLayout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanLoadingProgressBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanLoadingProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mHintSize = i.a(3.3f);
        ImageView imageView = new ImageView(context);
        this.mHintImageView = imageView;
        ImageView imageView2 = new ImageView(context);
        this.mProgressImageView = imageView2;
        imageView2.setImageResource(R.drawable.i3u);
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, i.a(0.91f));
        layoutParams.gravity = 17;
        addView(imageView2, layoutParams);
        imageView.setImageResource(R.drawable.igr);
        int i16 = this.mHintSize;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i16, i16);
        layoutParams2.gravity = 16;
        addView(imageView, layoutParams2);
        post(new Runnable() { // from class: gf3.a
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanLoadingProgressBar.b(ZPlanLoadingProgressBar.this);
            }
        });
    }

    public final void setProgress(int progress) {
        if (progress < 0) {
            progress = 0;
        } else if (progress > 100) {
            progress = 100;
        }
        this.mProgress = progress;
        c();
    }
}
