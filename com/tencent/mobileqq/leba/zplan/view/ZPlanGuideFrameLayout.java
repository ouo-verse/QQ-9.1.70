package com.tencent.mobileqq.leba.zplan.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.leba.zplan.view.ZPlanGuideFrameLayout;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0011\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/leba/zplan/view/ZPlanGuideFrameLayout;", "Landroid/widget/FrameLayout;", "", "d", "b", "f", "e", "", "visibility", "setVisibility", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", "mGuideContainer", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mLottieView", "Lcom/airbnb/lottie/LottieDrawable;", "Lcom/airbnb/lottie/LottieDrawable;", "mLottieDrawable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", h.F, "a", "qqleba-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class ZPlanGuideFrameLayout extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LinearLayout mGuideContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView mLottieView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private LottieDrawable mLottieDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanGuideFrameLayout(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.gxr, this);
        d();
        b();
    }

    private final void b() {
        LottieHelper.b(BaseApplication.getContext(), "zplan/qzone_zplan_guide_lottie.json", null, 20, 20, -1, new LottieHelper.d() { // from class: a72.a
            @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
            public final void onLoad(LottieDrawable lottieDrawable) {
                ZPlanGuideFrameLayout.c(ZPlanGuideFrameLayout.this, lottieDrawable);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(ZPlanGuideFrameLayout this$0, LottieDrawable lottieDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mLottieDrawable = lottieDrawable;
        ImageView imageView = this$0.mLottieView;
        if (imageView != null) {
            imageView.setImageDrawable(lottieDrawable);
        }
        this$0.f();
        this$0.e();
    }

    private final void d() {
        this.mGuideContainer = (LinearLayout) findViewById(R.id.vvj);
        this.mLottieView = (ImageView) findViewById(R.id.y5h);
    }

    public final void e() {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable != null && !lottieDrawable.isAnimating()) {
            lottieDrawable.playAnimation();
        }
    }

    public final void f() {
        LottieDrawable lottieDrawable = this.mLottieDrawable;
        if (lottieDrawable == null) {
            return;
        }
        if (lottieDrawable.isAnimating()) {
            lottieDrawable.stop();
        }
        lottieDrawable.setFrame(0);
    }

    @Override // android.view.View
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        if (visibility == 0) {
            e();
        } else {
            f();
        }
    }
}
