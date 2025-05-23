package com.tencent.qqnt.qbasealbum.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.jsengine.animation.basic.BasicAnimation;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.gridview.HippyQQDragGridViewController;
import com.tencent.luggage.wxa.gh.e;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqnt.qbasealbum.inject.g;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 o2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0003\u000b\bpB\u001f\b\u0007\u0012\b\u0010j\u001a\u0004\u0018\u00010i\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010k\u00a2\u0006\u0004\bm\u0010nJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u000e\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u00020\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0016\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\u0010\u0010\u0019\u001a\u00020\u00072\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017J \u0010 \u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010!\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010%\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010&\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010$\u001a\u00020\u0005H\u0016J(\u0010,\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\t2\u0006\u0010+\u001a\u00020\tH\u0016J\u0010\u0010-\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u0005H\u0016J(\u00100\u001a\u00020\f2\u0006\u0010(\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\tH\u0016J\u0010\u00103\u001a\u00020\u00072\u0006\u00102\u001a\u000201H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u00102\u001a\u000204H\u0016J\u0010\u00106\u001a\u00020\u00072\u0006\u00102\u001a\u000204H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00102\u001a\u000204H\u0016J\u0010\u00108\u001a\u00020\u00072\u0006\u00102\u001a\u000204H\u0016J\u0018\u00105\u001a\u00020\u00072\u0006\u00102\u001a\u0002042\u0006\u00109\u001a\u00020\fH\u0016J\u0018\u00106\u001a\u00020\u00072\u0006\u00102\u001a\u0002042\u0006\u00109\u001a\u00020\fH\u0016R\"\u0010@\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\"\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010I\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010HR\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010HR\u0016\u0010O\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010HR\u0016\u0010Q\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010HR\u0014\u0010S\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bR\u0010HR\u0014\u0010T\u001a\u00020\t8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bH\u0010HR\u0018\u0010X\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0018\u0010Z\u001a\u0004\u0018\u00010U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010WR\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u0016\u0010^\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010;R\u0016\u0010`\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010;R\u0016\u0010b\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010;R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010;R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010;R\u0016\u0010f\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010HR\u0016\u0010h\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010H\u00a8\u0006q"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/DragView;", "Landroid/widget/RelativeLayout;", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/animation/ValueAnimator$AnimatorUpdateListener;", "Landroid/animation/Animator$AnimatorListener;", "Landroid/view/MotionEvent;", "event", "", "b", "", "dragRatio", "a", "", HippyQQDragGridViewController.PropertyName.ENABLE_DRAG, "setEnableDrag", "ratioModify", "setRatioModify", "Lcom/tencent/qqnt/qbasealbum/view/DragView$c;", "onFinishListener", "setGestureChangeListener", "Lcom/tencent/qqnt/qbasealbum/view/DragView$b;", "mDragChangeListener", "setDragChangeListener", "Landroid/graphics/Rect;", "originRect", "setOriginRect", "Landroid/view/View;", "child", "", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "e", "onDown", "onShowPress", "onSingleTapUp", "e1", "e2", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, e.a.NAME, "velocityX", "velocityY", "onFling", "Landroid/animation/ValueAnimator;", "animation", "onAnimationUpdate", "Landroid/animation/Animator;", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "isReverse", "d", "Z", "getMFinishAnimation", "()Z", "setMFinishAnimation", "(Z)V", "mFinishAnimation", "Landroid/view/GestureDetector;", "Landroid/view/GestureDetector;", "mGestureDetector", "f", "Landroid/view/View;", "curView", h.F, UserInfo.SEX_FEMALE, "scale", "i", "mScrollDisX", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mScrollDisY", BdhLogUtil.LogTag.Tag_Conn, "downX", "D", "downY", "E", "scaleThreshold", "alphaOffset", "Landroid/animation/AnimatorSet;", "G", "Landroid/animation/AnimatorSet;", "releaseAnim", "H", "quitAnim", "I", "Landroid/graphics/Rect;", "J", "isInAnimation", "K", "isTriggerMove", "L", "firstDown", "M", "N", "P", "lastX", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "lastY", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", BdhLogUtil.LogTag.Tag_Req, "c", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class DragView extends RelativeLayout implements GestureDetector.OnGestureListener, ValueAnimator.AnimatorUpdateListener, Animator.AnimatorListener {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private float downX;

    /* renamed from: D, reason: from kotlin metadata */
    private float downY;

    /* renamed from: E, reason: from kotlin metadata */
    private final float scaleThreshold;

    /* renamed from: F, reason: from kotlin metadata */
    private final float alphaOffset;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet releaseAnim;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private AnimatorSet quitAnim;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Rect originRect;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isInAnimation;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean isTriggerMove;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean firstDown;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean enableDrag;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean ratioModify;

    /* renamed from: P, reason: from kotlin metadata */
    private float lastX;

    /* renamed from: Q, reason: from kotlin metadata */
    private float lastY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mFinishAnimation;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GestureDetector mGestureDetector;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View curView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float scale;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float mScrollDisX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mScrollDisY;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/DragView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.qbasealbum.view.DragView$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/DragView$b;", "", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface b {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/view/DragView$c;", "", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public interface c {
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(45318);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    @JvmOverloads
    public DragView(@Nullable Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 28)) {
            return;
        }
        iPatchRedirector.redirect((short) 28, (Object) this, (Object) context);
    }

    private final void a(float dragRatio) {
        this.isTriggerMove = true;
    }

    private final void b(MotionEvent event) {
        AnimatorSet animatorSet = this.releaseAnim;
        Intrinsics.checkNotNull(animatorSet);
        animatorSet.setupStartValues();
        AnimatorSet animatorSet2 = this.releaseAnim;
        Intrinsics.checkNotNull(animatorSet2);
        animatorSet2.start();
    }

    @Override // android.view.ViewGroup
    public void addView(@NotNull View child, int index, @NotNull ViewGroup.LayoutParams params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, child, Integer.valueOf(index), params);
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(params, "params");
        if (this.curView == null) {
            super.addView(child, index, params);
            this.curView = child;
            Intrinsics.checkNotNull(child);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(child, "translationX", 0.0f);
            View view = this.curView;
            Intrinsics.checkNotNull(view);
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f);
            View view2 = this.curView;
            Intrinsics.checkNotNull(view2);
            ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, BasicAnimation.KeyPath.SCALE_X, 1.0f);
            View view3 = this.curView;
            Intrinsics.checkNotNull(view3);
            ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view3, BasicAnimation.KeyPath.SCALE_Y, 1.0f);
            AnimatorSet animatorSet = new AnimatorSet();
            this.releaseAnim = animatorSet;
            Intrinsics.checkNotNull(animatorSet);
            animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
            ofFloat4.addUpdateListener(this);
            AnimatorSet animatorSet2 = this.releaseAnim;
            Intrinsics.checkNotNull(animatorSet2);
            animatorSet2.addListener(this);
            View view4 = this.curView;
            Intrinsics.checkNotNull(view4);
            ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(view4, "translationX", 0.0f);
            View view5 = this.curView;
            Intrinsics.checkNotNull(view5);
            ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(view5, "translationY", 0.0f);
            View view6 = this.curView;
            Intrinsics.checkNotNull(view6);
            ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(view6, BasicAnimation.KeyPath.SCALE_X, 0.0f);
            View view7 = this.curView;
            Intrinsics.checkNotNull(view7);
            ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(view7, BasicAnimation.KeyPath.SCALE_Y, 0.0f);
            AnimatorSet animatorSet3 = new AnimatorSet();
            this.quitAnim = animatorSet3;
            Intrinsics.checkNotNull(animatorSet3);
            animatorSet3.playTogether(ofFloat5, ofFloat6, ofFloat7, ofFloat8);
            ofFloat8.addUpdateListener(this);
            AnimatorSet animatorSet4 = this.quitAnim;
            Intrinsics.checkNotNull(animatorSet4);
            animatorSet4.addListener(this);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(@NotNull Animator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) animation);
        } else {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) animation);
            return;
        }
        Intrinsics.checkNotNullParameter(animation, "animation");
        this.isInAnimation = false;
        this.isTriggerMove = false;
        if (Intrinsics.areEqual(animation, this.quitAnim)) {
            this.mFinishAnimation = true;
        } else {
            Intrinsics.areEqual(animation, this.releaseAnim);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(@NotNull Animator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, (Object) animation);
        } else {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) animation);
        } else {
            Intrinsics.checkNotNullParameter(animation, "animation");
            this.isInAnimation = true;
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(@NotNull ValueAnimator animation) {
        float height;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) animation);
            return;
        }
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        AnimatorSet animatorSet = this.quitAnim;
        Intrinsics.checkNotNull(animatorSet);
        if (animatorSet.getChildAnimations().contains(animation)) {
            if (this.originRect == null) {
                float height2 = getHeight();
                Intrinsics.checkNotNull(this.curView);
                height = height2 / r1.getHeight();
            } else {
                View view = this.curView;
                Intrinsics.checkNotNull(view);
                int height3 = view.getHeight();
                Intrinsics.checkNotNull(this.originRect);
                height = r1.height() / height3;
            }
            float f16 = height / floatValue;
            if (f16 > 1.0f) {
                f16 = 1.0f;
            }
            floatValue = 1.0f - f16;
        }
        a(floatValue - this.alphaOffset);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(@NotNull MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) e16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        this.mScrollDisY = 0.0f;
        this.mScrollDisX = 0.0f;
        this.downX = e16.getX();
        this.downY = e16.getY();
        this.scale = 1.0f;
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, this, e16, e26, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e1");
        Intrinsics.checkNotNullParameter(e26, "e2");
        if (this.curView == null) {
            return false;
        }
        if (e16.getY() - e26.getY() > 0.0f && !this.isTriggerMove) {
            return true;
        }
        AnimatorSet animatorSet = this.quitAnim;
        Intrinsics.checkNotNull(animatorSet);
        ArrayList<Animator> childAnimations = animatorSet.getChildAnimations();
        if (this.originRect != null && this.curView != null && childAnimations != null && childAnimations.size() == 4) {
            View view = this.curView;
            Intrinsics.checkNotNull(view);
            int width = view.getWidth();
            View view2 = this.curView;
            Intrinsics.checkNotNull(view2);
            int height = view2.getHeight();
            Rect rect = new Rect(this.originRect);
            if (this.ratioModify) {
                float f16 = width / height;
                try {
                    Rect rect2 = this.originRect;
                    Intrinsics.checkNotNull(rect2);
                    float width2 = rect2.width();
                    Intrinsics.checkNotNull(this.originRect);
                    float height2 = width2 / r6.height();
                    if (height2 < f16) {
                        Intrinsics.checkNotNull(this.originRect);
                        float height3 = r1.height() * f16;
                        Intrinsics.checkNotNull(this.originRect);
                        int width3 = ((int) (height3 - r0.width())) / 2;
                        rect.left -= width3;
                        rect.right += width3;
                    } else if (height2 > f16) {
                        Intrinsics.checkNotNull(this.originRect);
                        float width4 = r1.width() / f16;
                        Intrinsics.checkNotNull(this.originRect);
                        int height4 = ((int) (width4 - r0.height())) / 2;
                        rect.top -= height4;
                        rect.bottom += height4;
                    }
                } catch (Exception e17) {
                    ox3.a.f("DragView", new Function0<String>(e17) { // from class: com.tencent.qqnt.qbasealbum.view.DragView$onFling$1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ Exception $e;

                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                            this.$e = e17;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) e17);
                            }
                        }

                        @Override // kotlin.jvm.functions.Function0
                        @NotNull
                        public final String invoke() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                return (String) iPatchRedirector2.redirect((short) 2, (Object) this);
                            }
                            return "onFling err, " + this.$e;
                        }
                    });
                }
            }
            float f17 = 2;
            float width5 = ((rect.left + rect.right) - getWidth()) / f17;
            g gVar = g.f361234b;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            float height5 = (((rect.top + rect.bottom) - getHeight()) / f17) - gVar.getStatusBarHeight(context);
            float width6 = rect.width() / width;
            float height6 = rect.height() / height;
            Animator animator = childAnimations.get(0);
            Intrinsics.checkNotNull(animator, "null cannot be cast to non-null type android.animation.ObjectAnimator");
            ((ObjectAnimator) animator).setFloatValues(width5);
            Animator animator2 = childAnimations.get(1);
            Intrinsics.checkNotNull(animator2, "null cannot be cast to non-null type android.animation.ObjectAnimator");
            ((ObjectAnimator) animator2).setFloatValues(height5);
            Animator animator3 = childAnimations.get(2);
            Intrinsics.checkNotNull(animator3, "null cannot be cast to non-null type android.animation.ObjectAnimator");
            ((ObjectAnimator) animator3).setFloatValues(width6);
            Animator animator4 = childAnimations.get(3);
            Intrinsics.checkNotNull(animator4, "null cannot be cast to non-null type android.animation.ObjectAnimator");
            ((ObjectAnimator) animator4).setFloatValues(height6);
            View view3 = this.curView;
            Intrinsics.checkNotNull(view3);
            Intrinsics.checkNotNull(this.curView);
            view3.setPivotX(r11.getWidth() / 2);
            View view4 = this.curView;
            Intrinsics.checkNotNull(view4);
            Intrinsics.checkNotNull(this.curView);
            view4.setPivotY(r11.getHeight() / 2);
        } else {
            View view5 = this.curView;
            Intrinsics.checkNotNull(view5);
            view5.setPivotX(getWidth() / 2);
            View view6 = this.curView;
            Intrinsics.checkNotNull(view6);
            view6.setPivotY(getHeight() / 2);
        }
        AnimatorSet animatorSet2 = this.quitAnim;
        Intrinsics.checkNotNull(animatorSet2);
        animatorSet2.setupStartValues();
        AnimatorSet animatorSet3 = this.quitAnim;
        Intrinsics.checkNotNull(animatorSet3);
        animatorSet3.start();
        return true;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (this.enableDrag) {
            int action = ev5.getAction();
            if (action != 0) {
                if (action == 2) {
                    float x16 = ev5.getX() - this.lastX;
                    float y16 = ev5.getY() - this.lastY;
                    this.lastX = ev5.getX();
                    this.lastY = ev5.getY();
                    if (Math.abs(y16) <= Math.abs(x16)) {
                        return false;
                    }
                    return true;
                }
            } else {
                this.lastX = ev5.getX();
                this.lastY = ev5.getY();
                GestureDetector gestureDetector = this.mGestureDetector;
                if (gestureDetector != null) {
                    Intrinsics.checkNotNull(gestureDetector);
                    gestureDetector.onTouchEvent(ev5);
                }
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(@NotNull MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) e16);
        } else {
            Intrinsics.checkNotNullParameter(e16, "e");
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(@NotNull MotionEvent e16, @NotNull MotionEvent e26, float distanceX, float distanceY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, this, e16, e26, Float.valueOf(distanceX), Float.valueOf(distanceY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e1");
        Intrinsics.checkNotNullParameter(e26, "e2");
        if (this.curView != null) {
            float y16 = e16.getY() - e26.getY();
            float f16 = 0.0f;
            if (y16 <= 0.0f) {
                this.mScrollDisX -= distanceX;
                float f17 = this.mScrollDisY - distanceY;
                this.mScrollDisY = f17;
                if (f17 >= 0.0f) {
                    f16 = f17;
                }
                float height = 1.0f - (f16 / getHeight());
                View view = this.curView;
                Intrinsics.checkNotNull(view);
                float f18 = this.downX;
                Intrinsics.checkNotNull(this.curView);
                view.setPivotX(f18 - r0.getLeft());
                View view2 = this.curView;
                Intrinsics.checkNotNull(view2);
                float f19 = this.downY;
                Intrinsics.checkNotNull(this.curView);
                view2.setPivotY(f19 - r0.getTop());
                float f26 = this.scaleThreshold;
                if (height > f26) {
                    f26 = height;
                }
                this.scale = f26;
                View view3 = this.curView;
                Intrinsics.checkNotNull(view3);
                view3.setScaleX(this.scale);
                View view4 = this.curView;
                Intrinsics.checkNotNull(view4);
                view4.setScaleY(this.scale);
                View view5 = this.curView;
                Intrinsics.checkNotNull(view5);
                view5.setTranslationX(this.mScrollDisX);
                View view6 = this.curView;
                Intrinsics.checkNotNull(view6);
                view6.setTranslationY(f16);
                a(height - this.alphaOffset);
            }
        }
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(@NotNull MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) e16);
        } else {
            Intrinsics.checkNotNullParameter(e16, "e");
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(@NotNull MotionEvent e16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) e16)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(e16, "e");
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        boolean z17 = false;
        if (this.isInAnimation) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.firstDown = true;
        } else if (action == 1) {
            this.firstDown = false;
        } else if (action == 2 && !this.firstDown) {
            MotionEvent obtain = MotionEvent.obtain(event);
            obtain.setAction(0);
            GestureDetector gestureDetector = this.mGestureDetector;
            if (gestureDetector != null) {
                gestureDetector.onTouchEvent(obtain);
            }
            this.firstDown = true;
        }
        if (event.getAction() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        GestureDetector gestureDetector2 = this.mGestureDetector;
        if (gestureDetector2 != null && !gestureDetector2.onTouchEvent(event)) {
            z17 = true;
        }
        if (z17 && z16) {
            b(event);
        }
        return true;
    }

    public final void setDragChangeListener(@Nullable b mDragChangeListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) mDragChangeListener);
        }
    }

    public final void setEnableDrag(boolean enableDrag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, enableDrag);
        } else {
            this.enableDrag = enableDrag;
        }
    }

    public final void setGestureChangeListener(@Nullable c onFinishListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) onFinishListener);
        }
    }

    public final void setMFinishAnimation(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.mFinishAnimation = z16;
        }
    }

    public final void setOriginRect(@Nullable Rect originRect) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) originRect);
        } else {
            this.originRect = originRect;
        }
    }

    public final void setRatioModify(boolean ratioModify) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, ratioModify);
        } else {
            this.ratioModify = ratioModify;
        }
    }

    public /* synthetic */ DragView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), defaultConstructorMarker);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(@NotNull Animator animation, boolean isReverse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, animation, Boolean.valueOf(isReverse));
        } else {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationStart(animation);
        }
    }

    @JvmOverloads
    public DragView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.scaleThreshold = 0.25f;
        this.enableDrag = true;
        this.mGestureDetector = new GestureDetector(context, this);
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(@NotNull Animator animation, boolean isReverse) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, animation, Boolean.valueOf(isReverse));
        } else {
            Intrinsics.checkNotNullParameter(animation, "animation");
            onAnimationEnd(animation);
        }
    }
}
