package com.tencent.mobileqq.qqecommerce.biz.webview;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.webview.ECSlideFloatWebViewFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.ak;
import com.tencent.mobileqq.webview.swift.proxy.a;
import com.tencent.mobileqq.webview.swift.utils.t;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0018\u001a\u00020\u0006H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002R\u0016\u0010\"\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010!R\u0018\u0010\n\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001e\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010*R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010*R\u0016\u00105\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010.R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010;\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0018\u0010=\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u00108R\u0018\u0010?\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u00108R\u0016\u0010A\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010.R\u0018\u0010D\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010'R\u0016\u0010J\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010!R\u0016\u0010L\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010!R\u0016\u0010N\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010.R\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/webview/ECSlideFloatWebViewFragment;", "Lcom/tencent/mobileqq/activity/QQTranslucentBrowserActivity$QQTranslucentBrowserFragment;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "Lcom/tencent/mobileqq/webview/swift/utils/t;", "webViewKernelCallBack", "", "onInitUIContent", "getWebViewKernelCallBack", "Landroid/view/View;", "browserContainer", "Landroid/content/Intent;", "intent", "Gh", "Ch", "Fh", "view", "Eh", "Bh", "initTitleBar", "Landroid/view/MotionEvent;", "event", "", "Mh", "Ph", "Kh", "Nh", "", "height", "Lh", "Rh", "Th", BdhLogUtil.LogTag.Tag_Conn, "I", "minFlingVelocity", "D", "maxFlingVelocity", "Landroid/view/ViewGroup;", "E", "Landroid/view/ViewGroup;", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", UserInfo.SEX_FEMALE, "Landroid/view/VelocityTracker;", "velocityTracker", "G", "Z", "draging", "", "H", "touchDownY", "contentOriginY", "J", "attachTop", "Landroid/animation/ValueAnimator;", "K", "Landroid/animation/ValueAnimator;", "attachTopAnim", "L", "closeAnim", "M", "backAnim", "N", "popAnim", "P", "animing", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/view/View;", "headerView", BdhLogUtil.LogTag.Tag_Req, "titleBar", ExifInterface.LATITUDE_SOUTH, "webviewContent", "T", "maxContentHeight", "U", "initialContentHeight", "V", "needConsumeTouchEvent", "Landroid/widget/ImageView;", "W", "Landroid/widget/ImageView;", "floatCloseBtn", "<init>", "()V", "X", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ECSlideFloatWebViewFragment extends QQTranslucentBrowserActivity.QQTranslucentBrowserFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private int minFlingVelocity;

    /* renamed from: D, reason: from kotlin metadata */
    private int maxFlingVelocity;

    /* renamed from: E, reason: from kotlin metadata */
    private ViewGroup browserContainer;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean draging;

    /* renamed from: H, reason: from kotlin metadata */
    private float touchDownY;

    /* renamed from: I, reason: from kotlin metadata */
    private float contentOriginY;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean attachTop;

    /* renamed from: K, reason: from kotlin metadata */
    private ValueAnimator attachTopAnim;

    /* renamed from: L, reason: from kotlin metadata */
    private ValueAnimator closeAnim;

    /* renamed from: M, reason: from kotlin metadata */
    private ValueAnimator backAnim;

    /* renamed from: N, reason: from kotlin metadata */
    private ValueAnimator popAnim;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean animing;

    /* renamed from: Q, reason: from kotlin metadata */
    private View headerView;

    /* renamed from: R, reason: from kotlin metadata */
    private View titleBar;

    /* renamed from: S, reason: from kotlin metadata */
    private ViewGroup webviewContent;

    /* renamed from: T, reason: from kotlin metadata */
    private int maxContentHeight;

    /* renamed from: U, reason: from kotlin metadata */
    private int initialContentHeight;

    /* renamed from: W, reason: from kotlin metadata */
    private ImageView floatCloseBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private VelocityTracker velocityTracker = VelocityTracker.obtain();

    /* renamed from: V, reason: from kotlin metadata */
    private boolean needConsumeTouchEvent = true;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/webview/ECSlideFloatWebViewFragment$c", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends ViewOutlineProvider {
        c() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight() + ViewUtils.dpToPx(16.0f), ViewUtils.dpToPx(16.0f));
        }
    }

    private final void Ch(View browserContainer) {
        if ((browserContainer instanceof ViewGroup ? (ViewGroup) browserContainer : null) != null) {
            ImageView imageView = new ImageView(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dpToPx(32.0f), ViewUtils.dpToPx(32.0f));
            layoutParams.topMargin = ViewUtils.dpToPx(16.0f);
            layoutParams.rightMargin = ViewUtils.dpToPx(16.0f);
            layoutParams.addRule(6, R.id.cq6);
            layoutParams.addRule(7, R.id.cq6);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            try {
                imageView.setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.ew7));
            } catch (Resources.NotFoundException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("SlideFloatWebViewFragment", 2, "initCloseBtn: ", e16);
                }
            }
            imageView.setOnClickListener(new View.OnClickListener() { // from class: mg2.g
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ECSlideFloatWebViewFragment.Dh(ECSlideFloatWebViewFragment.this, view);
                }
            });
            this.floatCloseBtn = imageView;
            ((ViewGroup) browserContainer).addView(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Dh(ECSlideFloatWebViewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Eh(View view) {
        view.setOutlineProvider(new c());
        view.setClipToOutline(true);
    }

    private final void Gh(final View browserContainer, Intent intent) {
        this.browserContainer = browserContainer instanceof ViewGroup ? (ViewGroup) browserContainer : null;
        this.minFlingVelocity = ViewConfiguration.get(getContext()).getScaledMinimumFlingVelocity();
        this.maxFlingVelocity = ViewConfiguration.get(getContext()).getScaledMaximumFlingVelocity();
        this.maxContentHeight = (ViewUtils.getScreenHeight() - ViewUtils.dpToPx(50.0f)) - ViewUtils.dpToPx(25.0f);
        browserContainer.post(new Runnable() { // from class: mg2.c
            @Override // java.lang.Runnable
            public final void run() {
                ECSlideFloatWebViewFragment.Hh(ECSlideFloatWebViewFragment.this, browserContainer);
            }
        });
        browserContainer.setOnClickListener(new View.OnClickListener() { // from class: mg2.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ECSlideFloatWebViewFragment.Ih(ECSlideFloatWebViewFragment.this, view);
            }
        });
        Fh(browserContainer, intent);
        initTitleBar(browserContainer);
        Ch(browserContainer);
        ViewGroup viewGroup = this.webviewContent;
        if (viewGroup != null) {
            Eh(viewGroup);
        }
        ViewGroup viewGroup2 = this.webviewContent;
        if (viewGroup2 != null) {
            viewGroup2.setBackground(new ColorDrawable(-1));
        }
        Lh(0);
        browserContainer.post(new Runnable() { // from class: mg2.e
            @Override // java.lang.Runnable
            public final void run() {
                ECSlideFloatWebViewFragment.Jh(ECSlideFloatWebViewFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(ECSlideFloatWebViewFragment this$0, View browserContainer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(browserContainer, "$browserContainer");
        View view = this$0.titleBar;
        if (view != null) {
            this$0.maxContentHeight = browserContainer.getHeight() - view.getHeight();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(ECSlideFloatWebViewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Rh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(ECSlideFloatWebViewFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Th();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Kh() {
        View a36 = getWebTitleBarInterface().a3();
        if (a36 != null) {
            a36.setVisibility(0);
        }
        View view = this.headerView;
        if (view != null) {
            view.setVisibility(8);
        }
        ViewGroup viewGroup = this.webviewContent;
        if (viewGroup != null) {
            Bh(viewGroup);
        }
        View view2 = this.titleBar;
        if (view2 != null) {
            view2.setAlpha(1.0f);
        }
        ImageView imageView = this.floatCloseBtn;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    private final void Lh(int height) {
        ViewGroup viewGroup = this.webviewContent;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.height = height;
        }
        ViewGroup viewGroup2 = this.webviewContent;
        if (viewGroup2 != null) {
            viewGroup2.setLayoutParams(layoutParams);
        }
        int i3 = this.initialContentHeight;
        float f16 = height < i3 ? 0.0f : (height - i3) / (this.maxContentHeight - i3);
        View view = this.titleBar;
        if (view == null) {
            return;
        }
        view.setAlpha(f16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Mh(MotionEvent event) {
        this.velocityTracker.addMovement(event);
        if (this.animing) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.needConsumeTouchEvent = !this.attachTop;
            this.touchDownY = event.getRawY();
            ViewGroup viewGroup = this.webviewContent;
            this.contentOriginY = viewGroup != null ? viewGroup.getY() : 0.0f;
        } else if (action == 1) {
            this.draging = false;
            this.velocityTracker.computeCurrentVelocity(1000);
            float abs = Math.abs(this.velocityTracker.getYVelocity());
            float rawY = event.getRawY() - this.touchDownY;
            if (abs > this.minFlingVelocity) {
                if (rawY > 0.0f) {
                    Rh();
                } else {
                    Nh();
                }
            } else if (this.attachTop) {
                Kh();
            } else {
                Ph();
            }
            this.velocityTracker.clear();
        } else if (action == 2) {
            if (this.attachTop) {
                return this.needConsumeTouchEvent;
            }
            this.draging = true;
            float screenHeight = ViewUtils.getScreenHeight() - (event.getRawY() + (this.contentOriginY - this.touchDownY));
            int i3 = this.maxContentHeight;
            if (screenHeight > i3) {
                screenHeight = i3;
                this.attachTop = true;
            }
            Lh((int) screenHeight);
        }
        return this.needConsumeTouchEvent;
    }

    private final void Nh() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideFloatWebViewFragment", 2, "smoothAttachTop: ");
        }
        this.attachTop = true;
        ViewGroup viewGroup = this.webviewContent;
        if (viewGroup != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(viewGroup.getHeight(), this.maxContentHeight);
            ofInt.setDuration(250L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mg2.f
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ECSlideFloatWebViewFragment.Oh(ECSlideFloatWebViewFragment.this, valueAnimator);
                }
            });
            ofInt.addListener(new d());
            this.attachTopAnim = ofInt;
            ofInt.start();
            this.animing = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(ECSlideFloatWebViewFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.Lh(((Integer) animatedValue).intValue());
    }

    private final void Ph() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideFloatWebViewFragment", 2, "smoothBack: ");
        }
        ViewGroup viewGroup = this.webviewContent;
        if (viewGroup != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(viewGroup.getHeight(), this.initialContentHeight);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mg2.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ECSlideFloatWebViewFragment.Qh(ECSlideFloatWebViewFragment.this, valueAnimator);
                }
            });
            ofInt.addListener(new e());
            this.backAnim = ofInt;
            ofInt.start();
            this.animing = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(ECSlideFloatWebViewFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.Lh(((Integer) animatedValue).intValue());
    }

    private final void Rh() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideFloatWebViewFragment", 2, "smoothClose: ");
        }
        ViewGroup viewGroup = this.webviewContent;
        if (viewGroup != null) {
            ValueAnimator ofInt = ValueAnimator.ofInt(viewGroup.getHeight(), 0);
            ofInt.setDuration(200L);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mg2.b
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                    ECSlideFloatWebViewFragment.Sh(ECSlideFloatWebViewFragment.this, valueAnimator);
                }
            });
            ofInt.addListener(new f());
            this.closeAnim = ofInt;
            ofInt.start();
            this.animing = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Sh(ECSlideFloatWebViewFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.Lh(((Integer) animatedValue).intValue());
    }

    private final void Th() {
        if (QLog.isColorLevel()) {
            QLog.d("SlideFloatWebViewFragment", 2, "smoothPop: ");
        }
        View view = this.headerView;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.webviewContent != null) {
            if (this.browserContainer != null) {
                ValueAnimator ofInt = ValueAnimator.ofInt(0, this.initialContentHeight);
                ofInt.setDuration(250L);
                ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: mg2.h
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                        ECSlideFloatWebViewFragment.Uh(ECSlideFloatWebViewFragment.this, valueAnimator);
                    }
                });
                ofInt.addListener(new g());
                this.popAnim = ofInt;
                ValueAnimator valueAnimator = this.closeAnim;
                if (valueAnimator != null) {
                    valueAnimator.start();
                }
            }
            ValueAnimator valueAnimator2 = this.popAnim;
            if (valueAnimator2 != null) {
                valueAnimator2.start();
            }
            this.animing = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(ECSlideFloatWebViewFragment this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        this$0.Lh(((Integer) animatedValue).intValue());
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment, com.tencent.mobileqq.webview.swift.WebViewFragment, com.tencent.mobileqq.webviewplugin.s
    public t getWebViewKernelCallBack() {
        return new b(this.webViewSurface);
    }

    @Override // com.tencent.mobileqq.activity.QQTranslucentBrowserActivity.QQTranslucentBrowserFragment
    public void onInitUIContent(Bundle extraData, t webViewKernelCallBack) {
        View findViewById;
        Intrinsics.checkNotNullParameter(webViewKernelCallBack, "webViewKernelCallBack");
        getUIStyle().f314622e = 0L;
        getUIStyleHandler().f314499a0 = true;
        QBaseActivity qBaseActivity = super.getQBaseActivity();
        if (qBaseActivity != null && (findViewById = qBaseActivity.findViewById(R.id.ae8)) != null) {
            Intent intent = super.getQBaseActivity().getIntent();
            Intrinsics.checkNotNullExpressionValue(intent, "super.getQBaseActivity().intent");
            Gh(findViewById, intent);
        }
        super.onInitUIContent(extraData, webViewKernelCallBack);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001c\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/webview/ECSlideFloatWebViewFragment$b", "Lcom/tencent/mobileqq/webview/swift/proxy/a;", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "", "onInitUIContent", "onInitTitleBar", "Landroid/view/View;", "v", "Landroid/view/MotionEvent;", "event", "", "interceptTouchEvent", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends a {
        b(ak akVar) {
            super(akVar);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitTitleBar(Bundle extraData) {
            super.onInitTitleBar(extraData);
            ECSlideFloatWebViewFragment.this.getWebTitleBarInterface().Kb(ViewUtils.dpToPx(20.0f), 0);
            View a36 = ECSlideFloatWebViewFragment.this.getWebTitleBarInterface().a3();
            if (a36 != null) {
                a36.setVisibility(8);
            }
            ImmersiveUtils.clearCoverForStatus(ECSlideFloatWebViewFragment.this.getQBaseActivity().getWindow(), true);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public void onInitUIContent(Bundle extraData) {
            ECSlideFloatWebViewFragment eCSlideFloatWebViewFragment = ECSlideFloatWebViewFragment.this;
            t webViewKernelCallBack = this.webViewKernelCallBack;
            Intrinsics.checkNotNullExpressionValue(webViewKernelCallBack, "webViewKernelCallBack");
            eCSlideFloatWebViewFragment.onInitUIContent(extraData, webViewKernelCallBack);
        }

        @Override // com.tencent.mobileqq.webview.swift.proxy.a, com.tencent.mobileqq.webview.swift.utils.t
        public boolean interceptTouchEvent(View v3, MotionEvent event) {
            if (event != null) {
                return ECSlideFloatWebViewFragment.this.Mh(event);
            }
            return false;
        }
    }

    private final void Bh(View view) {
        view.setOutlineProvider(null);
        view.setClipToOutline(false);
    }

    private final void Fh(View browserContainer, Intent intent) {
        int screenHeight;
        ViewGroup viewGroup = (ViewGroup) browserContainer.findViewById(R.id.cq6);
        this.webviewContent = viewGroup;
        ViewGroup.LayoutParams layoutParams = viewGroup != null ? viewGroup.getLayoutParams() : null;
        if ((layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null) != null) {
            int intExtra = intent.getIntExtra("KEY_HEIGHT_PERCENTAGE", -1);
            int dpToPx = ViewUtils.dpToPx(25.0f);
            boolean z16 = false;
            if (intExtra >= 0 && intExtra < 101) {
                z16 = true;
            }
            if (z16) {
                screenHeight = ((ViewUtils.getScreenHeight() * intExtra) / 100) - dpToPx;
            } else {
                screenHeight = (ViewUtils.getScreenHeight() - ((int) (ViewUtils.getScreenWidth() * 0.48d))) - dpToPx;
            }
            this.initialContentHeight = screenHeight;
            ((ViewGroup.LayoutParams) ((ViewGroup.MarginLayoutParams) layoutParams)).height = screenHeight;
            if ((layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null) != null) {
                ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
            }
            if ((layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null) != null) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(12);
            }
            ViewGroup viewGroup2 = this.webviewContent;
            if (viewGroup2 == null) {
                return;
            }
            viewGroup2.setLayoutParams(layoutParams);
        }
    }

    private final void initTitleBar(View browserContainer) {
        View findViewById = browserContainer.findViewById(R.id.f166798ic2);
        this.titleBar = findViewById;
        if (findViewById != null) {
            findViewById.setAlpha(0.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/webview/ECSlideFloatWebViewFragment$d", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements Animator.AnimatorListener {
        d() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            ECSlideFloatWebViewFragment.this.animing = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ECSlideFloatWebViewFragment.this.animing = false;
            ECSlideFloatWebViewFragment.this.Kh();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/webview/ECSlideFloatWebViewFragment$e", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements Animator.AnimatorListener {
        e() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            ECSlideFloatWebViewFragment.this.animing = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ECSlideFloatWebViewFragment.this.animing = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/webview/ECSlideFloatWebViewFragment$f", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements Animator.AnimatorListener {
        f() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            ECSlideFloatWebViewFragment.this.animing = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            View view = ECSlideFloatWebViewFragment.this.headerView;
            if (view != null) {
                view.setVisibility(8);
            }
            ECSlideFloatWebViewFragment.this.animing = false;
            FragmentActivity activity = ECSlideFloatWebViewFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqecommerce/biz/webview/ECSlideFloatWebViewFragment$g", "Landroid/animation/Animator$AnimatorListener;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements Animator.AnimatorListener {
        g() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            ECSlideFloatWebViewFragment.this.animing = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            ECSlideFloatWebViewFragment.this.animing = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animation) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
        }
    }
}
