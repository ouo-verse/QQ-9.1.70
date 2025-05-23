package com.tencent.sqshow.zootopia.card.view;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.card.view.ZootopiaDoublePraiseView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t74.u;
import tl.h;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 42\u00020\u0001:\u00015B'\b\u0007\u0012\u0006\u0010.\u001a\u00020-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\b\b\u0002\u00101\u001a\u00020\u000b\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0003J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0017\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0016\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bJ\u001a\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00022\b\b\u0002\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0019\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0005H\u0014J\b\u0010\u001e\u001a\u00020\u0005H\u0014R\u0016\u0010 \u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0016\u0010!\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001fR\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001fR\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010(\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001fR\u0016\u0010*\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010\u001fR\u0016\u0010,\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010\u001f\u00a8\u00066"}, d2 = {"Lcom/tencent/sqshow/zootopia/card/view/ZootopiaDoublePraiseView;", "Landroid/widget/FrameLayout;", "", HippyTKDListViewAdapter.X, "y", "", "c", "Landroid/widget/ImageView;", "imageView", "b", "i", "", "count", "g", "resId", "setPraiseDrawable", "(Ljava/lang/Integer;)V", "width", "height", "setPraiseViewWH", "eventX", "eventY", "d", "Landroid/view/MotionEvent;", "event", "e", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "I", "drawableId", "iconWidth", "f", "iconHeight", "", h.F, "Z", "enableRotate", "mCount", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mScreenWidth", BdhLogUtil.LogTag.Tag_Conn, "mScreenHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaDoublePraiseView extends FrameLayout {
    private static final int E = ViewUtils.dpToPx(125.0f);
    private static final int F = ViewUtils.dpToPx(125.0f);
    private static int G = R.drawable.ick;

    /* renamed from: C, reason: from kotlin metadata */
    private int mScreenHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int drawableId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int iconWidth;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int iconHeight;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean enableRotate;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mCount;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mScreenWidth;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/card/view/ZootopiaDoublePraiseView$b", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f370186d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ScaleAnimation f370187e;

        b(ImageView imageView, ScaleAnimation scaleAnimation) {
            this.f370186d = imageView;
            this.f370187e = scaleAnimation;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "firstAnimation, onAnimationEnd");
            this.f370186d.startAnimation(this.f370187e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "firstAnimation, onAnimationRepeat");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "firstAnimation, onAnimationStart");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/card/view/ZootopiaDoublePraiseView$c", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f370188d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ AnimationSet f370189e;

        c(ImageView imageView, AnimationSet animationSet) {
            this.f370188d = imageView;
            this.f370189e = animationSet;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "secondAnimation, onAnimationEnd");
            this.f370188d.startAnimation(this.f370189e);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "secondAnimation, onAnimationRepeat");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "secondAnimation, onAnimationStart");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/card/view/ZootopiaDoublePraiseView$d", "Landroid/view/animation/Animation$AnimationListener;", "Landroid/view/animation/Animation;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationRepeat", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f370190d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZootopiaDoublePraiseView f370191e;

        d(ImageView imageView, ZootopiaDoublePraiseView zootopiaDoublePraiseView) {
            this.f370190d = imageView;
            this.f370191e = zootopiaDoublePraiseView;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(ZootopiaDoublePraiseView this$0, ImageView imageView) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(imageView, "$imageView");
            this$0.removeView(imageView);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "thirdAnimation, onAnimationEnd, removeView:" + this.f370190d);
            final ImageView imageView = this.f370190d;
            final ZootopiaDoublePraiseView zootopiaDoublePraiseView = this.f370191e;
            imageView.post(new Runnable() { // from class: m84.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaDoublePraiseView.d.b(ZootopiaDoublePraiseView.this, imageView);
                }
            });
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "thirdAnimation, onAnimationRepeat");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            QLog.d("ZootopiaDoublePraiseView", 1, "thirdAnimation, onAnimationStart");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDoublePraiseView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b(ImageView imageView) {
        Animation loadAnimation = AnimationUtils.loadAnimation(getContext(), R.anim.f154365jm);
        Intrinsics.checkNotNull(loadAnimation, "null cannot be cast to non-null type android.view.animation.AnimationSet");
        AnimationSet animationSet = (AnimationSet) loadAnimation;
        Animation loadAnimation2 = AnimationUtils.loadAnimation(getContext(), R.anim.f154366jn);
        Intrinsics.checkNotNull(loadAnimation2, "null cannot be cast to non-null type android.view.animation.ScaleAnimation");
        ScaleAnimation scaleAnimation = (ScaleAnimation) loadAnimation2;
        Animation loadAnimation3 = AnimationUtils.loadAnimation(getContext(), R.anim.f154367jo);
        Intrinsics.checkNotNull(loadAnimation3, "null cannot be cast to non-null type android.view.animation.AnimationSet");
        AnimationSet animationSet2 = (AnimationSet) loadAnimation3;
        animationSet.setAnimationListener(new b(imageView, scaleAnimation));
        scaleAnimation.setAnimationListener(new c(imageView, animationSet2));
        animationSet2.setAnimationListener(new d(imageView, this));
        imageView.startAnimation(animationSet);
    }

    private final void c(float x16, float y16) {
        QLog.d("ZootopiaDoublePraiseView", 1, "addHeartView");
        ImageView imageView = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.iconWidth, this.iconHeight);
        layoutParams.leftMargin = (int) (x16 - (this.iconWidth / 2));
        layoutParams.topMargin = (int) (y16 - this.iconHeight);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackgroundResource(this.drawableId);
        if (this.enableRotate) {
            imageView.setRotation(g(this.mCount));
        }
        addView(imageView);
        b(imageView);
        this.mCount++;
    }

    private final float g(int count) {
        int i3 = count % 3;
        if (i3 == 0) {
            return 0.0f;
        }
        return i3 == 1 ? 15.0f : -15.0f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(ZootopiaDoublePraiseView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.removeAllViews();
    }

    private final void i() {
        u.Companion companion = u.INSTANCE;
        this.mScreenWidth = companion.c(getContext());
        int b16 = companion.b(getContext());
        this.mScreenHeight = b16;
        QLog.d("ZootopiaDoublePraiseView", 1, "refreshScreenSizeParam mScreenWidth:" + this.mScreenWidth + ", mScreenHeight:" + b16);
    }

    public final void e(MotionEvent event) {
        QLog.d("ZootopiaDoublePraiseView", 1, "doPraise, event:" + event);
        d(event != null ? event.getX() : 0.0f, event != null ? event.getY() : 0.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        QLog.d("ZootopiaDoublePraiseView", 1, NodeProps.ON_ATTACHED_TO_WINDOW);
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        i();
        QLog.d("ZootopiaDoublePraiseView", 1, "onConfigurationChanged");
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QLog.d("ZootopiaDoublePraiseView", 1, "onDetachedFromWindow, remove all views");
        post(new Runnable() { // from class: m84.c
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaDoublePraiseView.h(ZootopiaDoublePraiseView.this);
            }
        });
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZootopiaDoublePraiseView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZootopiaDoublePraiseView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void setPraiseDrawable(Integer resId) {
        if (resId != null && resId.intValue() > 0) {
            this.drawableId = resId.intValue();
        } else {
            this.drawableId = G;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaDoublePraiseView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.drawableId = G;
        this.iconWidth = E;
        this.iconHeight = F;
        u.Companion companion = u.INSTANCE;
        this.mScreenWidth = companion.c(context);
        this.mScreenHeight = companion.b(context);
    }

    public final void setPraiseViewWH(int width, int height) {
        if (width <= 0 || height <= 0) {
            QLog.d("ZootopiaDoublePraiseView", 1, "setPraiseViewWH, invalid params, return");
        }
        this.iconWidth = width;
        this.iconHeight = height;
    }

    public final void d(float eventX, float eventY) {
        if (eventX > 0.0f && eventY > 0.0f) {
            c(eventX, eventY);
            return;
        }
        QLog.d("ZootopiaDoublePraiseView", 1, "x or y is 0, user center xy in screen");
        float f16 = 2;
        c(this.mScreenWidth / f16, (this.mScreenHeight / f16) + (this.iconHeight / 2));
    }

    public static /* synthetic */ void f(ZootopiaDoublePraiseView zootopiaDoublePraiseView, float f16, float f17, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f16 = 0.0f;
        }
        if ((i3 & 2) != 0) {
            f17 = 0.0f;
        }
        zootopiaDoublePraiseView.d(f16, f17);
    }
}
