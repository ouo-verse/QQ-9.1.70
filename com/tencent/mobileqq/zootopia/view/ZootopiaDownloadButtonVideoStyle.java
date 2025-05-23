package com.tencent.mobileqq.zootopia.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import androidx.core.content.res.ResourcesCompat;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.sqshow.zootopia.data.ButtonStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u00a2\u0006\u0004\b\u001c\u0010\u001dB\u001b\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u00a2\u0006\u0004\b\u001c\u0010 B#\b\u0016\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\"\u001a\u00020!\u00a2\u0006\u0004\b\u001c\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0002H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonVideoStyle;", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaDownloadButton;", "", "V", "W", "Lcom/tencent/sqshow/zootopia/data/ButtonStatus;", "status", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, BdhLogUtil.LogTag.Tag_Req, ExifInterface.LATITUDE_SOUTH, "T", "U", "v", "", "r", "setPauseStatusStyle", "setCustomStatusStyle", "", "progress", "setProcess", "setProgressBar", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "d0", "Z", "isShowingAnim", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "defStyle", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaDownloadButtonVideoStyle extends ZootopiaDownloadButton {

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private boolean isShowingAnim;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f329651a;

        static {
            int[] iArr = new int[ButtonStatus.values().length];
            try {
                iArr[ButtonStatus.LOADING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ButtonStatus.PAUSE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ButtonStatus.WAITING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ButtonStatus.INIT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ButtonStatus.UPDATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ButtonStatus.LOADED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[ButtonStatus.ONLY_DOWNLOAD.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            f329651a = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButtonVideoStyle(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void Q(ButtonStatus status) {
        m().setPercentText(p(status));
        m().setTextVisible(true);
        int i3 = a.f329651a[status.ordinal()];
        if (i3 == 4 || i3 == 5) {
            R();
            return;
        }
        if (i3 == 6) {
            S();
            return;
        }
        if (i3 != 7) {
            k().setVisibility(8);
            s().setVisibility(8);
            m().setVisibility(0);
            g().setBackground(null);
            return;
        }
        T();
    }

    private final void R() {
        m().setVisibility(8);
        k().setText(p(getStatus()));
        s().setVisibility(0);
        k().setVisibility(0);
        g().setBackground(getLoadingBackground());
        k().setTextColor(getRootView().getResources().getColor(R.color.f8446z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void S() {
        U();
        g().setBackground(getLoadingBackground());
        k().setTextColor(getRootView().getResources().getColor(R.color.f8446z));
    }

    private final void T() {
        U();
        g().setBackground(ResourcesCompat.getDrawable(getRootView().getResources(), R.drawable.f159839gz0, null));
        k().setTextColor(getContext().getResources().getColor(R.color.f84974));
    }

    private final void V() {
        q().put(ButtonStatus.INIT, "\u52a0\u8f7d\u8fdb\u5165");
        q().put(ButtonStatus.PAUSE, "\u7ee7\u7eed");
        q().put(ButtonStatus.WAITING, "\u7b49\u5f85");
        q().put(ButtonStatus.LOADED, "\u8fdb\u5165");
        q().put(ButtonStatus.UPDATE, "\u66f4\u65b0");
        q().put(ButtonStatus.CLOUD_GAME, "\u79d2\u73a9");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ZootopiaDownloadButtonVideoStyle this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Drawable background = this$0.g().getBackground();
        if (background == null) {
            return;
        }
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        background.setAlpha((int) (((Float) animatedValue).floatValue() * 255));
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    protected void A() {
        if (isAttachedToWindow()) {
            W();
        } else {
            S();
        }
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public String r() {
        int i3 = a.f329651a[getStatus().ordinal()];
        if (i3 != 1 && i3 != 2 && i3 != 3) {
            return k().getText().toString();
        }
        String a16 = m().a();
        Intrinsics.checkNotNullExpressionValue(a16, "{\n                progre\u2026percentText\n            }");
        return a16;
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void setCustomStatusStyle(ButtonStatus status) {
        Intrinsics.checkNotNullParameter(status, "status");
        Q(status);
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void setPauseStatusStyle() {
        Q(getStatus());
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void setProcess(float progress) {
        super.setProcess(progress);
        if (getStatus() == ButtonStatus.LOADING || this.isShowingAnim) {
            return;
        }
        m().setPercentText(p(getStatus()));
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void setProgressBar() {
        if (getCurProgress() < 100) {
            m().setProgress(getCurProgress());
        }
    }

    @Override // com.tencent.mobileqq.zootopia.view.ZootopiaDownloadButton
    public void v() {
        super.v();
        V();
        m().setNeedMultiColor(true);
        m().setProgressDrawable(getLoadingBackground());
        m().setTextVisible(true);
        m().setPaintColor(getRootView().getResources().getColor(R.color.f8446z));
        m().setTypeface(Typeface.DEFAULT_BOLD);
        m().setVisibility(8);
        k().setTextColor(getRootView().getResources().getColor(R.color.f8446z));
        k().setTypeface(Typeface.DEFAULT_BOLD, 1);
        k().setIncludeFontPadding(false);
        setShowButtonSubText(true);
        s().setTextColor(Color.parseColor("#acacac"));
        s().setTypeface(Typeface.DEFAULT_BOLD, 1);
        s().setPadding(0, -ViewUtils.dpToPx(1.0f), 0, ViewUtils.dpToPx(2.0f));
        s().setIncludeFontPadding(false);
        s().setTextSize(7.8f);
        g().setBackground(getLoadingBackground());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButtonVideoStyle(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void U() {
        this.isShowingAnim = false;
        m().setProgress(0);
        m().setVisibility(8);
        k().setText(p(getStatus()));
        k().setVisibility(0);
        s().setVisibility(8);
    }

    private final void W() {
        this.isShowingAnim = true;
        m().setProgress(100);
        g().setBackground(new ColorDrawable(Color.argb(127, 255, 255, 255)));
        g().getBackground().mutate();
        int width = g().getWidth() / 2;
        int height = g().getHeight() / 2;
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(g(), width, height, 0.0f, (float) Math.hypot(width, height));
        createCircularReveal.setInterpolator(new AccelerateDecelerateInterpolator());
        createCircularReveal.setDuration(400L);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.5f, 1.0f);
        ofFloat.setDuration(200L);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.zootopia.view.u
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                ZootopiaDownloadButtonVideoStyle.X(ZootopiaDownloadButtonVideoStyle.this, valueAnimator);
            }
        });
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(400L);
        animatorSet.playTogether(createCircularReveal, ofFloat);
        animatorSet.addListener(new b());
        animatorSet.start();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDownloadButtonVideoStyle(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/view/ZootopiaDownloadButtonVideoStyle$b", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends com.tencent.mobileqq.widget.f {
        b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            ZootopiaDownloadButtonVideoStyle.this.S();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }
    }
}
