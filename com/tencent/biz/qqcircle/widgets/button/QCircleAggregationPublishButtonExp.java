package com.tencent.biz.qqcircle.widgets.button;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qqcircle.utils.cd;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.button.QCircleAggregationPublishButtonExp;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleFeedBase$StPublisherButton;
import tl.h;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \b2\u00020\u0001:\u00010B\u001d\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010J\u0016\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u0010\u0010\u001c\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\b\u0010\u001d\u001a\u00020\u0002H\u0014R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0018\u0010)\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010(\u00a8\u00061"}, d2 = {"Lcom/tencent/biz/qqcircle/widgets/button/QCircleAggregationPublishButtonExp;", "Landroidx/cardview/widget/CardView;", "", "j", "k", "Landroid/view/View;", "view", "Landroid/graphics/Bitmap;", "i", "imageView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "from", "to", "Landroid/animation/AnimatorSet;", h.F, "Landroid/graphics/drawable/Drawable;", "drawable", "setButtonIcon", "", "width", "height", "setButtonWidthAndHeight", "", "title", "setButtonText", "Lqqcircle/QQCircleFeedBase$StPublisherButton;", "publisherButton", "setData", NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "iconImageView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleText", "f", "titleImage", "Landroid/animation/AnimatorSet;", "finalSet", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "a", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes5.dex */
public final class QCircleAggregationPublishButtonExp extends CardView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ImageView iconImageView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView titleText;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private ImageView titleImage;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AnimatorSet finalSet;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QCircleAggregationPublishButtonExp(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final AnimatorSet h(View view, float from, float to5) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_X, from, to5);
        ofFloat.setDuration(720L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, BasicAnimation.KeyPath.SCALE_Y, from, to5);
        ofFloat2.setDuration(720L);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(ofFloat, ofFloat2);
        return animatorSet;
    }

    private final Bitmap i(View view) {
        if (view.getWidth() == 0 || view.getHeight() == 0) {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (measuredWidth > 0 && measuredHeight > 0) {
            Bitmap createBitmap = Bitmap.createBitmap(measuredWidth, measuredHeight, Bitmap.Config.ARGB_8888);
            view.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return null;
    }

    private final void j() {
        setCardBackgroundColor(-1);
        setRadius(cx.a(25.0f));
        setCardElevation(cx.a(5.0f));
        LayoutInflater.from(getContext()).inflate(R.layout.g26, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.tji);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.button_icon)");
        this.iconImageView = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.tk8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.button_text_fake)");
        this.titleText = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.tk9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.button_text_image)");
        this.titleImage = (ImageView) findViewById3;
    }

    private final void k() {
        TextView textView = this.titleText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
            textView = null;
        }
        textView.post(new Runnable() { // from class: nc0.a
            @Override // java.lang.Runnable
            public final void run() {
                QCircleAggregationPublishButtonExp.l(QCircleAggregationPublishButtonExp.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void l(QCircleAggregationPublishButtonExp this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TextView textView = this$0.titleText;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
            textView = null;
        }
        Bitmap i3 = this$0.i(textView);
        if (i3 != null) {
            ImageView imageView = this$0.titleImage;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleImage");
                imageView = null;
            }
            imageView.setImageBitmap(i3);
            TextView textView3 = this$0.titleText;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("titleText");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(4);
        }
        this$0.m(this$0);
    }

    private final void m(View imageView) {
        boolean z16;
        AnimatorSet animatorSet = this.finalSet;
        if (animatorSet != null && animatorSet.isRunning()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return;
        }
        AnimatorSet h16 = h(imageView, 1.0f, 1.05f);
        AnimatorSet h17 = h(imageView, 1.05f, 1.0f);
        AnimatorSet animatorSet2 = new AnimatorSet();
        animatorSet2.playSequentially(h16, h17);
        AnimatorSet animatorSet3 = new AnimatorSet();
        animatorSet3.playSequentially(animatorSet2, animatorSet2.clone(), animatorSet2.clone());
        this.finalSet = animatorSet3;
        animatorSet3.start();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        AnimatorSet animatorSet = this.finalSet;
        if (animatorSet != null) {
            animatorSet.removeAllListeners();
        }
        AnimatorSet animatorSet2 = this.finalSet;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
    }

    public final void setButtonIcon(@Nullable Drawable drawable) {
        if (drawable != null) {
            ImageView imageView = this.iconImageView;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("iconImageView");
                imageView = null;
            }
            imageView.setImageDrawable(drawable);
        }
    }

    public final void setButtonText(@NotNull String title) {
        Intrinsics.checkNotNullParameter(title, "title");
        TextView textView = this.titleText;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
            textView = null;
        }
        textView.setText(title);
    }

    public final void setButtonWidthAndHeight(int width, int height) {
        ImageView imageView = this.iconImageView;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconImageView");
            imageView = null;
        }
        imageView.getLayoutParams().width = width;
        ImageView imageView3 = this.iconImageView;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconImageView");
        } else {
            imageView2 = imageView3;
        }
        imageView2.getLayoutParams().height = height;
    }

    public final void setData(@Nullable QQCircleFeedBase$StPublisherButton publisherButton) {
        if (publisherButton == null) {
            QLog.e("QCircleAggregationPublishButtonExp", 1, "data is null");
            return;
        }
        String str = publisherButton.iconURL.get();
        ImageView imageView = this.iconImageView;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconImageView");
            imageView = null;
        }
        cd.c(imageView, str);
        TextView textView2 = this.titleText;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleText");
        } else {
            textView = textView2;
        }
        textView.setText(publisherButton.title.get());
        k();
    }

    public /* synthetic */ QCircleAggregationPublishButtonExp(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public QCircleAggregationPublishButtonExp(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        j();
    }
}
