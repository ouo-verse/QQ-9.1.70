package com.tencent.timi.game.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.av.utils.ba;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yn4.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 I2\u00020\u0001:\u0001JB1\b\u0007\u0012\u0006\u0010C\u001a\u00020B\u0012\n\b\u0002\u0010E\u001a\u0004\u0018\u00010D\u0012\b\b\u0002\u0010F\u001a\u00020\u0011\u0012\b\b\u0002\u0010%\u001a\u00020\t\u00a2\u0006\u0004\bG\u0010HJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J0\u0010\u0013\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u000e\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011J\u0006\u0010\u0017\u001a\u00020\u0016J\u0016\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010\u001e\u001a\u00020\u0011J\u0006\u0010\u001f\u001a\u00020\tJ\u0006\u0010 \u001a\u00020\u0002J\u0006\u0010!\u001a\u00020\u0002J\u0010\u0010\"\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010%\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010*\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\f\n\u0004\b&\u0010'\u0012\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00104\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010,R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010,R\u0016\u00107\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010$R&\u0010<\u001a\u0012\u0012\u0004\u0012\u00020\u001c08j\b\u0012\u0004\u0012\u00020\u001c`98\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010>\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010=R\u0014\u0010A\u001a\u00020\u00018\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006K"}, d2 = {"Lcom/tencent/timi/game/ui/widget/TGRightDrawerView;", "Landroid/widget/FrameLayout;", "", "w", BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "v", "Landroid/view/MotionEvent;", "motionEvent", "", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "fromTranX", "targetTranX", "fromAlpha", "targetAlpha", "", "targetState", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "resid", "setBackgroundResource", "Landroid/view/View;", DomainData.DOMAIN_NAME, "content", "Landroid/widget/FrameLayout$LayoutParams;", "layoutParams", "k", "Lcom/tencent/timi/game/ui/f;", "l", "o", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "r", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "d", "Z", "canDrag", "e", "I", "getMState$annotations", "()V", "mState", "f", UserInfo.SEX_FEMALE, "mTouchDownX", tl.h.F, "mTouchDownY", "", "i", "J", "mTouchDownTime", "mContentTranX", "mShadowAlpha", "D", "mOnAnimation", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "stateListenerPool", "Landroid/view/View;", "shadowView", "G", "Landroid/widget/FrameLayout;", "contentRootView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "H", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public class TGRightDrawerView extends FrameLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private float mShadowAlpha;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mOnAnimation;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private ArrayList<com.tencent.timi.game.ui.f> stateListenerPool;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final View shadowView;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final FrameLayout contentRootView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean canDrag;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mState;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mTouchDownX;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float mTouchDownY;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long mTouchDownTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float mContentTranX;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/ui/widget/TGRightDrawerView$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f380115d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TGRightDrawerView f380116e;

        b(int i3, TGRightDrawerView tGRightDrawerView) {
            this.f380115d = i3;
            this.f380116e = tGRightDrawerView;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            com.tencent.timi.game.utils.l.i("TGRightDrawerView", "doAnim onAnimationEnd");
            if (this.f380115d == 2) {
                this.f380116e.v();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/ui/widget/TGRightDrawerView$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends AnimatorListenerAdapter {
        c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            TGRightDrawerView.this.v();
            TGRightDrawerView.this.mOnAnimation = false;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/ui/widget/TGRightDrawerView$d", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class d extends AnimatorListenerAdapter {
        d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            TGRightDrawerView.this.mOnAnimation = false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGRightDrawerView(@NotNull Context context) {
        this(context, null, 0, false, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void C() {
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "showAnim");
        setVisibility(0);
        this.mOnAnimation = true;
        this.shadowView.setAlpha(0.0f);
        post(new Runnable() { // from class: com.tencent.timi.game.ui.widget.y
            @Override // java.lang.Runnable
            public final void run() {
                TGRightDrawerView.D(TGRightDrawerView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(final TGRightDrawerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int width = this$0.contentRootView.getWidth();
        this$0.contentRootView.setTranslationX(width);
        this$0.contentRootView.setVisibility(0);
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "showAnim contentRootViewWidth=" + width);
        this$0.post(new Runnable() { // from class: com.tencent.timi.game.ui.widget.z
            @Override // java.lang.Runnable
            public final void run() {
                TGRightDrawerView.E(TGRightDrawerView.this, width);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(TGRightDrawerView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.contentRootView, "translationX", i3, 0.0f);
        ofFloat.setDuration(500L);
        ofFloat.setInterpolator(b.f.f450693a);
        ofFloat.addListener(new d());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.shadowView, com.tencent.luggage.wxa.c8.c.f123400v, 0.0f, 1.0f);
        ofFloat2.setInterpolator(b.f.f450693a);
        ofFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "showAnim anim.start()");
    }

    private final void m(float fromTranX, float targetTranX, float fromAlpha, float targetAlpha, int targetState) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.contentRootView, "translationX", fromTranX, targetTranX);
        int screenWidth = ba.getScreenWidth(getContext());
        float abs = Math.abs(targetTranX - fromTranX) / screenWidth;
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "doAnim fromTranX:" + fromTranX + ", targetTranX:" + targetTranX + ", durationFactor:" + abs + ", screenWith:" + screenWidth);
        ofFloat.setDuration((long) (((float) 500) * abs));
        ofFloat.addListener(new b(targetState, this));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.shadowView, com.tencent.luggage.wxa.c8.c.f123400v, fromAlpha, targetAlpha);
        ofFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    private final boolean p(MotionEvent motionEvent) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        long currentTimeMillis = System.currentTimeMillis() - this.mTouchDownTime;
        float rawX = motionEvent.getRawX() - this.mTouchDownX;
        float rawY = motionEvent.getRawY() - this.mTouchDownY;
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "distanceX:" + rawX + ", duration:" + currentTimeMillis + ", motionEvent.action=" + motionEvent.getAction());
        boolean z26 = true;
        if (currentTimeMillis <= 200 && 50.0f < rawX) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (currentTimeMillis > 200 && rawX >= 300.0f) {
            z17 = true;
        } else {
            z17 = false;
        }
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "shortSlide:" + z16 + ", slideEnoughDistance:" + z17);
        if (rawY == 0.0f) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18 ? !(rawX <= 0.0f || rawX / Math.abs(rawY) <= 1.3f) : rawX > 0.0f) {
            z19 = true;
        } else {
            z19 = false;
        }
        if (z19 && (z16 || z17)) {
            m(0.0f, ba.getScreenWidth(getContext()), 1.0f, 0.0f, 2);
            return true;
        }
        if (rawX != 0.0f) {
            z26 = false;
        }
        if (!z26) {
            if (this.canDrag) {
                m(this.mContentTranX, 0.0f, this.mShadowAlpha, 1.0f, 1);
            }
        } else {
            com.tencent.timi.game.utils.l.i("TGRightDrawerView", "distanceX is 0, do nothing!");
        }
        return false;
    }

    private final void q(MotionEvent motionEvent) {
        float rawX = motionEvent.getRawX() - this.mTouchDownX;
        float f16 = 0.0f;
        if (rawX < 0.0f) {
            rawX = 0.0f;
        }
        this.mContentTranX = rawX;
        this.contentRootView.setTranslationX(rawX);
        float screenWidth = this.mContentTranX / ba.getScreenWidth(getContext());
        float f17 = 1;
        if (screenWidth >= 0.0f) {
            f16 = 1.0f;
            if (screenWidth <= 1.0f) {
                f16 = screenWidth;
            }
        }
        float f18 = f17 - f16;
        this.mShadowAlpha = f18;
        this.shadowView.setAlpha(f18);
    }

    private final void s() {
        this.mOnAnimation = true;
        post(new Runnable() { // from class: com.tencent.timi.game.ui.widget.w
            @Override // java.lang.Runnable
            public final void run() {
                TGRightDrawerView.t(TGRightDrawerView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(final TGRightDrawerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final int width = this$0.contentRootView.getWidth();
        this$0.contentRootView.setTranslationX(0.0f);
        this$0.contentRootView.setVisibility(0);
        this$0.post(new Runnable() { // from class: com.tencent.timi.game.ui.widget.x
            @Override // java.lang.Runnable
            public final void run() {
                TGRightDrawerView.u(TGRightDrawerView.this, width);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(TGRightDrawerView this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this$0.contentRootView, "translationX", 0.0f, i3);
        ofFloat.setInterpolator(b.f.f450694b);
        ofFloat.setDuration(500L);
        ofFloat.addListener(new c());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this$0.shadowView, com.tencent.luggage.wxa.c8.c.f123400v, 1.0f, 0.0f);
        ofFloat2.setInterpolator(b.f.f450694b);
        ofFloat2.setDuration(500L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat);
        animatorSet.play(ofFloat2);
        animatorSet.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void v() {
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "hideSelf");
        setVisibility(8);
        this.mState = 2;
        this.contentRootView.setTranslationX(this.contentRootView.getWidth());
        this.shadowView.setAlpha(0.0f);
    }

    private final void w() {
        this.shadowView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TGRightDrawerView.x(TGRightDrawerView.this, view);
            }
        });
        this.shadowView.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.tencent.timi.game.ui.widget.u
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                boolean y16;
                y16 = TGRightDrawerView.y(view);
                return y16;
            }
        });
        this.contentRootView.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        this.contentRootView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.ui.widget.v
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TGRightDrawerView.z(view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(TGRightDrawerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "OnClicked");
        this$0.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean y(View view) {
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "OnLongClicked");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "contentRootView clicked!");
        EventCollector.getInstance().onViewClicked(view);
    }

    public final boolean A() {
        if (this.mState == 1) {
            return true;
        }
        return false;
    }

    public final void B() {
        com.tencent.timi.game.utils.l.i("TGRightDrawerView", "show mState=" + this.mState);
        if (this.mState == 1) {
            return;
        }
        this.mState = 1;
        C();
        Iterator<com.tencent.timi.game.ui.f> it = this.stateListenerPool.iterator();
        while (it.hasNext()) {
            it.next().onShow(this);
        }
    }

    public final void k(@NotNull View content, @NotNull FrameLayout.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(layoutParams, "layoutParams");
        this.contentRootView.removeAllViews();
        this.contentRootView.addView(content, layoutParams);
    }

    public final void l(@NotNull com.tencent.timi.game.ui.f l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.stateListenerPool.add(l3);
    }

    @NotNull
    public final View n() {
        return this.contentRootView;
    }

    /* renamed from: o, reason: from getter */
    public final int getMState() {
        return this.mState;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
    
        if (r0 != 3) goto L33;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.mOnAnimation) {
            com.tencent.timi.game.utils.l.i("TGRightDrawerView", "onInterceptTouchEvent give up, mOnAnimation is true");
            return super.onInterceptTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    if (this.canDrag && this.mTouchDownTime > 0 && this.mTouchDownX > 0.0f) {
                        q(motionEvent);
                    }
                }
            }
            if (this.mTouchDownTime > 0 && this.mTouchDownX > 0.0f && p(motionEvent)) {
                return true;
            }
        } else {
            Rect rect = new Rect();
            this.contentRootView.getGlobalVisibleRect(rect);
            com.tencent.timi.game.utils.l.i("TGRightDrawerView", "pos.left=" + rect.left + ", rawX=" + motionEvent.getRawX());
            if (motionEvent.getRawX() < rect.left) {
                this.mTouchDownTime = 0L;
                this.mTouchDownX = 0.0f;
                this.mTouchDownY = 0.0f;
            } else {
                this.mTouchDownTime = System.currentTimeMillis();
                this.mTouchDownX = motionEvent.getRawX();
                this.mTouchDownY = motionEvent.getRawY();
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public final void r() {
        if (this.mState == 2) {
            return;
        }
        this.mState = 2;
        s();
        Iterator<com.tencent.timi.game.ui.f> it = this.stateListenerPool.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    @Override // android.view.View
    public final void setBackgroundResource(int resid) {
        super.setBackgroundResource(resid);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGRightDrawerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, false, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGRightDrawerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TGRightDrawerView(Context context, AttributeSet attributeSet, int i3, boolean z16, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? false : z16);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TGRightDrawerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, boolean z16) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.canDrag = z16;
        this.mState = 2;
        this.stateListenerPool = new ArrayList<>();
        View.inflate(context, R.layout.f169135hy0, this);
        View findViewById = findViewById(R.id.f84014l4);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.shadowView)");
        this.shadowView = findViewById;
        View findViewById2 = findViewById(R.id.u7v);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.contentRootView)");
        this.contentRootView = (FrameLayout) findViewById2;
        setBackgroundResource(R.color.ajr);
        w();
    }
}
