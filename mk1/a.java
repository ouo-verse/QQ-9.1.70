package mk1;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import hk1.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \"2\u00020\u0001:\u0001\u0006B\u0007\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\"\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0016\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0015R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017R\u0016\u0010\u0019\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u001bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001b\u00a8\u0006#"}, d2 = {"Lmk1/a;", "", "Landroid/graphics/RectF;", "b", "", "panelHeight", "a", "imageViewWidth", "imageViewHeight", "Landroid/graphics/drawable/Drawable;", "drawable", "c", "Landroid/view/ViewGroup;", "bannerView", "Landroid/widget/ImageView;", "drawableImageView", "", "d", "Lhk1/a$e;", "panelInfo", "e", "Landroid/view/ViewGroup;", "drawableGroupView", "Landroid/graphics/drawable/Drawable;", "Landroid/graphics/RectF;", "startRectF", "", "I", NodeProps.MARGIN_BOTTOM, "Landroid/widget/ImageView;", "f", "topPadding", "<init>", "()V", "g", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup drawableGroupView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable drawable;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RectF startRectF = new RectF();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int marginBottom;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView drawableImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int topPadding;

    private final RectF a(float panelHeight) {
        int i3;
        int screenHeight;
        ViewGroup viewGroup = this.drawableGroupView;
        if (viewGroup != null) {
            i3 = viewGroup.getMeasuredWidth();
        } else {
            i3 = ScreenUtil.SCREEN_WIDTH;
        }
        float f16 = i3;
        ViewGroup viewGroup2 = this.drawableGroupView;
        if (viewGroup2 != null) {
            screenHeight = viewGroup2.getMeasuredHeight();
        } else {
            screenHeight = DisplayUtil.getScreenHeight();
        }
        RectF c16 = c(f16, (screenHeight - (panelHeight - (DisplayUtil.getScreenHeight() - screenHeight))) - this.topPadding, this.drawable);
        float f17 = c16.left;
        float f18 = c16.top;
        int i16 = this.topPadding;
        c16.set(f17, f18 + i16, c16.right, c16.bottom + i16);
        return c16;
    }

    private final RectF b() {
        int i3;
        int i16;
        ViewGroup viewGroup = this.drawableGroupView;
        if (viewGroup != null) {
            i3 = viewGroup.getMeasuredWidth();
        } else {
            i3 = ScreenUtil.SCREEN_WIDTH;
        }
        float f16 = i3;
        ViewGroup viewGroup2 = this.drawableGroupView;
        if (viewGroup2 != null) {
            i16 = viewGroup2.getMeasuredHeight();
        } else {
            i16 = ScreenUtil.SCREEN_HIGHT;
        }
        return c(f16, i16, this.drawable);
    }

    private final RectF c(float imageViewWidth, float imageViewHeight, Drawable drawable) {
        int i3;
        int i16;
        if (drawable != null) {
            i3 = drawable.getIntrinsicWidth();
        } else {
            i3 = ScreenUtil.SCREEN_WIDTH;
        }
        if (drawable != null) {
            i16 = drawable.getIntrinsicHeight();
        } else {
            i16 = ScreenUtil.SCREEN_HIGHT / 2;
        }
        float f16 = i3;
        float f17 = i16;
        float min = Math.min(imageViewWidth / f16, imageViewHeight / f17);
        float min2 = Math.min(f16 * min, imageViewWidth);
        float min3 = Math.min(f17 * min, imageViewHeight);
        float f18 = (imageViewWidth - min2) / 2.0f;
        float f19 = ((imageViewHeight - min3) / 2.0f) - this.marginBottom;
        return new RectF(f18, f19, min2 + f18, min3 + f19);
    }

    public final void d(@NotNull ViewGroup bannerView, @NotNull ImageView drawableImageView) {
        int i3;
        int i16;
        int i17;
        Intrinsics.checkNotNullParameter(bannerView, "bannerView");
        Intrinsics.checkNotNullParameter(drawableImageView, "drawableImageView");
        this.drawableGroupView = bannerView;
        this.drawableImageView = drawableImageView;
        this.drawable = drawableImageView.getDrawable();
        this.topPadding = DisplayUtil.getTopHeight(bannerView.getContext());
        ViewGroup.LayoutParams layoutParams = drawableImageView.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if (marginLayoutParams != null) {
            i3 = marginLayoutParams.bottomMargin;
        } else {
            i3 = 0;
        }
        this.marginBottom = i3;
        ViewGroup viewGroup = this.drawableGroupView;
        if (viewGroup != null) {
            i16 = viewGroup.getMeasuredWidth();
        } else {
            i16 = ScreenUtil.SCREEN_WIDTH;
        }
        ViewGroup viewGroup2 = this.drawableGroupView;
        if (viewGroup2 != null) {
            i17 = viewGroup2.getMeasuredHeight();
        } else {
            i17 = ScreenUtil.SCREEN_HIGHT;
        }
        QLog.i("GalleryViewAnimHelper", 1, "onInitOriginalParams===start containerHeight=" + i17 + " drawableImageViewHeight=" + drawableImageView.getMeasuredHeight() + " topPadding=" + this.topPadding + " bottomMargin=" + this.marginBottom);
        RectF b16 = b();
        this.startRectF = b16;
        if (b16.top < DisplayUtil.getTopHeight(bannerView.getContext())) {
            this.topPadding = (int) this.startRectF.top;
        }
        ViewGroup viewGroup3 = this.drawableGroupView;
        if (viewGroup3 != null) {
            viewGroup3.setPivotX(i16 / 2.0f);
        }
        ViewGroup viewGroup4 = this.drawableGroupView;
        if (viewGroup4 != null) {
            viewGroup4.setPivotY(this.startRectF.bottom);
        }
        RectF rectF = this.startRectF;
        QLog.i("GalleryViewAnimHelper", 1, "onInitOriginalParams===result startRectF=" + rectF + " width=" + rectF.width() + " height=" + this.startRectF.height());
    }

    public final void e(@NotNull a.PanelHeightChangeEventDataArgs panelInfo) {
        Intrinsics.checkNotNullParameter(panelInfo, "panelInfo");
        if (this.drawableGroupView != null && this.drawable != null && this.drawableImageView != null) {
            RectF a16 = a(panelInfo.getPanelHeight());
            float height = a16.height() / this.startRectF.height();
            float f16 = (a16.bottom - this.startRectF.bottom) + this.marginBottom;
            if (panelInfo.getPanelHeight() <= 0.0f) {
                QLog.i("GalleryViewAnimHelper", 1, "panelHeightChange is close");
                height = 1.0f;
                f16 = 0.0f;
            }
            ViewGroup viewGroup = this.drawableGroupView;
            if (viewGroup != null) {
                viewGroup.setScaleX(height);
            }
            ViewGroup viewGroup2 = this.drawableGroupView;
            if (viewGroup2 != null) {
                viewGroup2.setScaleY(height);
            }
            ViewGroup viewGroup3 = this.drawableGroupView;
            if (viewGroup3 != null) {
                viewGroup3.setTranslationY(f16);
                return;
            }
            return;
        }
        QLog.i("GalleryViewAnimHelper", 1, "panelHeightChange drawableGroupView == null || drawable == null");
    }
}
