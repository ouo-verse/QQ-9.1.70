package com.tencent.mobileqq.guild.feed.nativedetail.content.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.widgets.multitouchimg.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.gallery.widget.FeedSafeTouchImageView;
import com.tencent.mobileqq.guild.util.ImageViewPorterDuffUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001c2\u00020\u0001:\u0001\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018B\u001b\b\u0016\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u00a2\u0006\u0004\b\u0017\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u000bJ\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/widget/PicPreviewFragmentLayout;", "Landroid/widget/FrameLayout;", "", "a", "onFinishInflate", "", "factor", "setShadowAlpha", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/e;", "listener", "setOnEndDragListener", "Lcom/tencent/biz/qqcircle/widgets/multitouchimg/g;", "setOnMatrixChangeListener", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedSafeTouchImageView;", "d", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedSafeTouchImageView;", "mediaView", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class PicPreviewFragmentLayout extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static String f221720f = "PicPreviewFragmentLayout";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FeedSafeTouchImageView mediaView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicPreviewFragmentLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View findViewById = findViewById(R.id.f27070f9);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.preview_banner)");
        FeedSafeTouchImageView feedSafeTouchImageView = (FeedSafeTouchImageView) findViewById;
        this.mediaView = feedSafeTouchImageView;
        ImageViewPorterDuffUtils imageViewPorterDuffUtils = ImageViewPorterDuffUtils.f235385a;
        if (feedSafeTouchImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
            feedSafeTouchImageView = null;
        }
        imageViewPorterDuffUtils.c(feedSafeTouchImageView);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        FeedSafeTouchImageView feedSafeTouchImageView = this.mediaView;
        if (feedSafeTouchImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
            feedSafeTouchImageView = null;
        }
        return feedSafeTouchImageView.dispatchTouchEvent(event);
    }

    public final void setOnEndDragListener(@NotNull com.tencent.biz.qqcircle.widgets.multitouchimg.e listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FeedSafeTouchImageView feedSafeTouchImageView = this.mediaView;
        if (feedSafeTouchImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
            feedSafeTouchImageView = null;
        }
        feedSafeTouchImageView.setOnEndDragListener(listener);
    }

    public final void setOnMatrixChangeListener(@NotNull g listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FeedSafeTouchImageView feedSafeTouchImageView = this.mediaView;
        if (feedSafeTouchImageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaView");
            feedSafeTouchImageView = null;
        }
        feedSafeTouchImageView.setOnMatrixChangeListener(listener);
    }

    public final void setShadowAlpha(float factor) {
        int i3 = (int) (factor * 255.0f);
        if (i3 < 0) {
            i3 = 0;
        } else if (i3 > 255) {
            i3 = 255;
        }
        getBackground().setAlpha(i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PicPreviewFragmentLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        a();
    }

    private final void a() {
    }
}
