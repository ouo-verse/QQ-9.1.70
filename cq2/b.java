package cq2;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b-\u0010.J(\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004R$\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R$\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0017\u0010\u000f\"\u0004\b\u0018\u0010\u0011R$\u0010\u001f\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u001b\u001a\u0004\b\u0013\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010%\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b\f\u0010#\"\u0004\b!\u0010$R$\u0010,\u001a\u0004\u0018\u00010&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+\u00a8\u0006/"}, d2 = {"Lcq2/b;", "", "Landroid/graphics/drawable/Drawable;", "drawable", "", "showFrame", "", WidgetCacheConstellationData.NUM, "gif", "", "g", "Landroid/widget/TextView;", "a", "Landroid/widget/TextView;", "getPreviewImage", "()Landroid/widget/TextView;", h.F, "(Landroid/widget/TextView;)V", "previewImage", "b", "getDummyFirstPreviewImage", "c", "dummyFirstPreviewImage", "getEditPicTag", "d", "editPicTag", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "()Landroid/widget/ImageView;", "f", "(Landroid/widget/ImageView;)V", "framePreviewImage", "Landroid/view/View;", "e", "Landroid/view/View;", "()Landroid/view/View;", "(Landroid/view/View;)V", "framePreview", "Landroid/widget/ProgressBar;", "Landroid/widget/ProgressBar;", "getProgressBar", "()Landroid/widget/ProgressBar;", "i", "(Landroid/widget/ProgressBar;)V", "progressBar", "<init>", "()V", "qq_selectfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private TextView previewImage;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private TextView dummyFirstPreviewImage;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private TextView editPicTag;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView framePreviewImage;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private View framePreview;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ProgressBar progressBar;

    /* renamed from: a, reason: from getter */
    public final View getFramePreview() {
        return this.framePreview;
    }

    /* renamed from: b, reason: from getter */
    public final ImageView getFramePreviewImage() {
        return this.framePreviewImage;
    }

    public final void c(TextView textView) {
        this.dummyFirstPreviewImage = textView;
    }

    public final void d(TextView textView) {
        this.editPicTag = textView;
    }

    public final void e(View view) {
        this.framePreview = view;
    }

    public final void f(ImageView imageView) {
        this.framePreviewImage = imageView;
    }

    public final void h(TextView textView) {
        this.previewImage = textView;
    }

    public final void i(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    public final void g(Drawable drawable, boolean showFrame, int num, boolean gif) {
        if (drawable == null) {
            return;
        }
        if (showFrame) {
            View view = this.framePreview;
            Intrinsics.checkNotNull(view);
            view.setVisibility(0);
            TextView textView = this.previewImage;
            Intrinsics.checkNotNull(textView);
            textView.setVisibility(8);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.addRule(13);
            ImageView imageView = this.framePreviewImage;
            Intrinsics.checkNotNull(imageView);
            imageView.setLayoutParams(layoutParams);
            if (!gif) {
                ImageView imageView2 = this.framePreviewImage;
                Intrinsics.checkNotNull(imageView2);
                imageView2.setAdjustViewBounds(true);
                ImageView imageView3 = this.framePreviewImage;
                Intrinsics.checkNotNull(imageView3);
                imageView3.setMaxHeight(ViewUtils.dip2px(140.0f));
                ImageView imageView4 = this.framePreviewImage;
                Intrinsics.checkNotNull(imageView4);
                imageView4.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                ImageView imageView5 = this.framePreviewImage;
                Intrinsics.checkNotNull(imageView5);
                imageView5.setAdjustViewBounds(true);
                ImageView imageView6 = this.framePreviewImage;
                Intrinsics.checkNotNull(imageView6);
                imageView6.setMaxWidth(ViewUtils.dip2px(120.0f));
                ImageView imageView7 = this.framePreviewImage;
                Intrinsics.checkNotNull(imageView7);
                imageView7.setMaxHeight(ViewUtils.dip2px(120.0f));
                ImageView imageView8 = this.framePreviewImage;
                Intrinsics.checkNotNull(imageView8);
                imageView8.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            ImageView imageView9 = this.framePreviewImage;
            Intrinsics.checkNotNull(imageView9);
            imageView9.setImageDrawable(drawable);
            if (num < 2) {
                View view2 = this.framePreview;
                Intrinsics.checkNotNull(view2);
                view2.setBackgroundDrawable(null);
                return;
            } else if (num == 2) {
                View view3 = this.framePreview;
                Intrinsics.checkNotNull(view3);
                view3.setBackgroundResource(R.drawable.cmv);
                return;
            } else {
                View view4 = this.framePreview;
                Intrinsics.checkNotNull(view4);
                view4.setBackgroundResource(R.drawable.cmw);
                return;
            }
        }
        View view5 = this.framePreview;
        Intrinsics.checkNotNull(view5);
        view5.setVisibility(8);
        TextView textView2 = this.previewImage;
        Intrinsics.checkNotNull(textView2);
        textView2.setVisibility(0);
        TextView textView3 = this.previewImage;
        Intrinsics.checkNotNull(textView3);
        textView3.setCompoundDrawablePadding(0);
        TextView textView4 = this.previewImage;
        Intrinsics.checkNotNull(textView4);
        textView4.setCompoundDrawables(drawable, null, null, null);
        TextView textView5 = this.previewImage;
        Intrinsics.checkNotNull(textView5);
        textView5.setVisibility(0);
    }
}
