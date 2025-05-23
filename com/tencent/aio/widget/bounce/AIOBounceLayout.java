package com.tencent.aio.widget.bounce;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.aio.base.log.e;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.api.IQQGameCommApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b \u0018\u0000 k2\u00020\u0001:\u0001lB'\b\u0007\u0012\u0006\u0010e\u001a\u00020d\u0012\n\b\u0002\u0010g\u001a\u0004\u0018\u00010f\u0012\b\b\u0002\u0010h\u001a\u00020\u0002\u00a2\u0006\u0004\bi\u0010jJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J.\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u001a\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\b2\b\b\u0002\u0010\u0012\u001a\u00020\u0002H\u0002J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0017\u001a\u00020\bH&J\b\u0010\u0018\u001a\u00020\u0002H&J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0002H&J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\bH&J\u0010\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\bH&J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u000f\u0010 \u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b \u0010!J\u0010\u0010$\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\"H\u0016J(\u0010+\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J(\u0010,\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J0\u00100\u001a\u00020\u00062\u0006\u0010)\u001a\u00020'2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J@\u00105\u001a\u00020\u00062\u0006\u0010)\u001a\u00020'2\u0006\u00101\u001a\u00020\u00022\u0006\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010/\u001a\u00020.H\u0016J\u0018\u00106\u001a\u00020\u00062\u0006\u0010)\u001a\u00020'2\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u00107\u001a\u00020\u00062\u0006\u0010)\u001a\u00020'H\u0016R\u001c\u0010<\u001a\n 9*\u0004\u0018\u000108088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010\u0007R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u0007R\u0016\u0010B\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u00107R\u001e\u0010F\u001a\n 9*\u0004\u0018\u00010C0C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010I\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\"\u0010S\u001a\u00020\u00048\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010T\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00107R\"\u0010Y\u001a\u00020\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0007\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u0014\u0010[\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u00107R\"\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010N\u001a\u0004\b\\\u0010P\"\u0004\b]\u0010RR\u0016\u0010_\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00107R\"\u0010c\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\u0007\u001a\u0004\ba\u0010V\"\u0004\bb\u0010X\u00a8\u0006m"}, d2 = {"Lcom/tencent/aio/widget/bounce/AIOBounceLayout;", "Lcom/tencent/aio/widget/bounce/NestedScrollingAdapterGroup;", "", "action", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", UserInfo.SEX_FEMALE, "", "endSpinner", "", IQQGameCommApi.KEY_START_DELAY, "Landroid/view/animation/Interpolator;", "interpolator", "duration", "Landroid/animation/ValueAnimator;", "p", "dy", "moveType", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "reason", ReportConstant.COSTREPORT_PREFIX, "w", "t", Element.ELEMENT_NAME_DISTANCE, "D", "E", "totalSpinner", HippyTKDListViewAdapter.X, "type", "r", "y", "()V", "Landroid/view/MotionEvent;", "ev", "dispatchTouchEvent", "event", "onTouchEvent", "Landroid/view/View;", "child", "target", "axes", "onStartNestedScroll", "onNestedScrollAccepted", "dx", "", "consumed", "onNestedPreScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "onStopNestedScroll", "I", "Landroid/view/ViewConfiguration;", "kotlin.jvm.PlatformType", "d", "Landroid/view/ViewConfiguration;", "viewConfig", "e", "mMinimumVelocity", "f", "mMaximumVelocity", h.F, "mScrollPointerId", "Landroid/view/VelocityTracker;", "i", "Landroid/view/VelocityTracker;", "mVelocityTracker", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/animation/ValueAnimator;", "mReboundAnimator", "Lcom/tencent/aio/widget/interpolators/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aio/widget/interpolators/a;", "mReboundInterpolator", "Z", "getMIsAllowOverScroll", "()Z", "H", "(Z)V", "mIsAllowOverScroll", "mPreConsumedNeeded", "v", "()F", "setMSpinner", "(F)V", "mSpinner", "G", "mScreenHeightPixels", "u", "setMNestedInProgress", "mNestedInProgress", "scrollType", "J", "getLastMoveDistance", "setLastMoveDistance", "lastMoveDistance", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes3.dex */
public abstract class AIOBounceLayout extends NestedScrollingAdapterGroup {
    static IPatchRedirector $redirector_;

    @NotNull
    private static final a K;

    /* renamed from: C, reason: from kotlin metadata */
    private com.tencent.aio.widget.interpolators.a mReboundInterpolator;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsAllowOverScroll;

    /* renamed from: E, reason: from kotlin metadata */
    private int mPreConsumedNeeded;

    /* renamed from: F, reason: from kotlin metadata */
    private float mSpinner;

    /* renamed from: G, reason: from kotlin metadata */
    private final int mScreenHeightPixels;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean mNestedInProgress;

    /* renamed from: I, reason: from kotlin metadata */
    private int scrollType;

    /* renamed from: J, reason: from kotlin metadata */
    private float lastMoveDistance;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ViewConfiguration viewConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float mMinimumVelocity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float mMaximumVelocity;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mScrollPointerId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private VelocityTracker mVelocityTracker;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator mReboundAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/aio/widget/bounce/AIOBounceLayout$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    private static final class a {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/aio/widget/bounce/AIOBounceLayout$b", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationEnd", "sdk_debug"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class b extends AnimatorListenerAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f69972e;

        b(float f16) {
            this.f69972e = f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, AIOBounceLayout.this, Float.valueOf(f16));
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) animation);
                return;
            }
            Intrinsics.checkNotNullParameter(animation, "animation");
            if (com.tencent.aio.base.a.f69150c.a()) {
                e b16 = com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b);
                a unused = AIOBounceLayout.K;
                b16.d("AIOBounceLayout", "onAnimationEnd  " + animation.getDuration() + TokenParser.SP);
            }
            if (animation.getDuration() == 0) {
                return;
            }
            AIOBounceLayout.this.E(this.f69972e);
            ValueAnimator valueAnimator = AIOBounceLayout.this.mReboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
                valueAnimator.removeAllListeners();
            }
            AIOBounceLayout.this.mReboundAnimator = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 2})
    /* loaded from: classes3.dex */
    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) AIOBounceLayout.this);
            }
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            float f16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) it);
                return;
            }
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            if (!(animatedValue instanceof Float)) {
                animatedValue = null;
            }
            Float f17 = (Float) animatedValue;
            if (f17 != null) {
                f16 = f17.floatValue();
            } else {
                f16 = 0.0f;
            }
            AIOBounceLayout.this.A(f16, 0);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53620);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            K = new a(null);
        }
    }

    @JvmOverloads
    public AIOBounceLayout(@NotNull Context context) {
        this(context, null, 0, 6, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 22)) {
            return;
        }
        iPatchRedirector.redirect((short) 22, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(float dy5, int moveType) {
        this.lastMoveDistance = dy5;
        int childCount = super.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = super.getChildAt(i3);
            Intrinsics.checkNotNullExpressionValue(childAt, "super.getChildAt(i)");
            childAt.setTranslationY(dy5);
        }
        this.mSpinner = dy5;
        D(dy5, moveType);
    }

    static /* synthetic */ void B(AIOBounceLayout aIOBounceLayout, float f16, int i3, int i16, Object obj) {
        if (obj == null) {
            if ((i16 & 2) != 0) {
                i3 = 0;
            }
            aIOBounceLayout.A(f16, i3);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveTranslation");
    }

    private final void F() {
        float x16 = x(this.mSpinner);
        float abs = ((Math.abs(this.mSpinner) - Math.abs(x16)) / (this.mScreenHeightPixels / 4)) * ((float) 800);
        if (abs < 0) {
            abs = 300.0f;
        }
        com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "overSpinner  " + x16 + " time " + abs);
        p(x16, 0L, this.mReboundInterpolator, (long) abs);
    }

    private final ValueAnimator p(float endSpinner, long startDelay, Interpolator interpolator, long duration) {
        if (this.mSpinner != endSpinner) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "animSpinner startDelay " + startDelay + "  start anim  startSpinner  " + this.mSpinner + "   endSpinner " + endSpinner);
            s("animSpinner");
            b bVar = new b(endSpinner);
            c cVar = new c();
            ValueAnimator it = ValueAnimator.ofFloat(this.mSpinner, endSpinner);
            this.mReboundAnimator = it;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            it.setDuration(duration);
            it.setInterpolator(interpolator);
            it.setStartDelay(startDelay);
            it.addListener(bVar);
            it.addUpdateListener(cVar);
            it.start();
            return this.mReboundAnimator;
        }
        E(endSpinner);
        return null;
    }

    private final void s(String reason) {
        com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).i("AIOBounceLayout", "cancelAnimation " + reason);
        ValueAnimator valueAnimator = this.mReboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.setDuration(0L);
            valueAnimator.cancel();
        }
        this.mReboundAnimator = null;
    }

    private final boolean z(int action) {
        if (action == 0) {
            s("actionDown");
        }
        if (this.mReboundAnimator != null) {
            return true;
        }
        return false;
    }

    public abstract void D(float distance, int moveType);

    public abstract void E(float distance);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void H(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.mIsAllowOverScroll = z16;
        }
    }

    public void I(@NotNull View target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) target);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        if (!(target instanceof RecyclerView)) {
            target = null;
        }
        RecyclerView recyclerView = (RecyclerView) target;
        if (recyclerView != null) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).e("AIOBounceLayout", "stopTargetFling ");
            }
            recyclerView.stopScroll();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (z(ev5.getActionMasked())) {
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).e("AIOBounceLayout", " \u62e6\u622a");
                return false;
            }
            return false;
        }
        if (this.mNestedInProgress) {
            return super.dispatchTouchEvent(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // com.tencent.aio.widget.bounce.NestedScrollingAdapterGroup, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, target, Integer.valueOf(dx5), Integer.valueOf(dy5), consumed, Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (dy5 == 0) {
            return;
        }
        if ((type != 0 && type != 1) || this.mPreConsumedNeeded == 0) {
            return;
        }
        com.tencent.aio.base.a aVar = com.tencent.aio.base.a.f69150c;
        if (aVar.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "onNestedPreScroll dy  " + dy5 + "   type " + type);
        }
        if (type == 0) {
            i3 = 1;
        }
        int i16 = this.mPreConsumedNeeded;
        if (i16 * dy5 < 0) {
            int i17 = i16 - dy5;
            this.mPreConsumedNeeded = i17;
            float a16 = com.tencent.aio.widget.bounce.a.a(i17, this.mScreenHeightPixels, getHeight(), t());
            A(a16, i3);
            if (aVar.a()) {
                com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "onNestedPreScroll \u52a0\u5267  type " + type + "  mSpinner " + this.mSpinner + "  mPreConsumedNeeded " + this.mPreConsumedNeeded);
            }
            if (type == 1) {
                if (aVar.a()) {
                    com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).w("AIOBounceLayout", "maxFling " + w() + "  dy1 " + a16);
                }
                if (Math.abs(a16) > w()) {
                    consumed[1] = dy5;
                    I(target);
                    return;
                }
            }
        } else if (Math.abs(dy5) > Math.abs(this.mSpinner)) {
            dy5 = MathKt__MathJVMKt.roundToInt(this.mSpinner);
            this.mPreConsumedNeeded = 0;
            A(0.0f, i3);
            if (aVar.a()) {
                com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "onNestedPreScroll \u62b5\u6d88\u6d88\u8017\u5b8c  type " + type + " mSpinner " + this.mSpinner);
            }
        } else {
            float f16 = this.mSpinner - dy5;
            this.mSpinner = f16;
            this.mPreConsumedNeeded = com.tencent.aio.widget.bounce.a.b(f16, this.mScreenHeightPixels, getHeight(), t());
            A(this.mSpinner, i3);
            if (aVar.a()) {
                com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "onNestedPreScroll \u62b5\u6d88\u90e8\u5206  type " + type + " mSpinner " + this.mSpinner);
            }
        }
        consumed[1] = dy5;
    }

    @Override // com.tencent.aio.widget.bounce.NestedScrollingAdapterGroup, androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type, @NotNull int[] consumed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 3;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, target, Integer.valueOf(dxConsumed), Integer.valueOf(dyConsumed), Integer.valueOf(dxUnconsumed), Integer.valueOf(dyUnconsumed), Integer.valueOf(type), consumed);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (dyUnconsumed == 0) {
            return;
        }
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "onNestedScrollInternal type " + type + "  dyUnconsumed  " + dyUnconsumed);
        }
        if (type == 0) {
            i3 = 1;
        }
        if ((dyUnconsumed < 0 && this.mIsAllowOverScroll && com.tencent.aio.base.tool.e.b(target, null)) || (dyUnconsumed > 0 && this.mIsAllowOverScroll && com.tencent.aio.base.tool.e.a(target, null))) {
            if (type == 0 || r(dyUnconsumed, type)) {
                int i16 = this.mPreConsumedNeeded - dyUnconsumed;
                this.mPreConsumedNeeded = i16;
                A(com.tencent.aio.widget.bounce.a.a(i16, this.mScreenHeightPixels, getHeight(), t()), i3);
                consumed[1] = consumed[1] + dyUnconsumed;
            }
        }
    }

    @Override // com.tencent.aio.widget.bounce.NestedScrollingAdapterGroup, androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int axes, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, child, target, Integer.valueOf(axes), Integer.valueOf(type));
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mPreConsumedNeeded = com.tencent.aio.widget.bounce.a.b(this.mSpinner, this.mScreenHeightPixels, getHeight(), t());
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "onNestedScrollAccepted  mSpinner " + this.mSpinner + "  mPreConsumedNeeded " + this.mPreConsumedNeeded);
        }
        this.mNestedInProgress = true;
        s("receiveScrollAccepted");
        this.scrollType = type;
    }

    @Override // com.tencent.aio.widget.bounce.NestedScrollingAdapterGroup, androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, this, child, target, Integer.valueOf(axes), Integer.valueOf(type))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if (com.tencent.aio.base.a.f69150c.a()) {
            com.tencent.aio.base.log.b.b(com.tencent.aio.base.log.a.f69187b).d("AIOBounceLayout", "onStartNestedScroll type  " + axes);
        }
        if (this.mIsAllowOverScroll && (axes & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.aio.widget.bounce.NestedScrollingAdapterGroup, androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(@NotNull View target, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) target, type);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        com.tencent.aio.base.log.a aVar = com.tencent.aio.base.log.a.f69187b;
        com.tencent.aio.base.log.b.b(aVar).d("AIOBounceLayout", "onStopNestedScroll " + type);
        if (this.scrollType == type) {
            this.mNestedInProgress = false;
            if (com.tencent.aio.base.a.f69150c.a()) {
                com.tencent.aio.base.log.b.b(aVar).w("AIOBounceLayout", "stop overSpinner");
            }
            F();
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) event)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action == 1 || action == 3) {
            F();
        }
        return true;
    }

    public boolean r(int dy5, int type) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            return false;
        }
        return ((Boolean) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(dy5), Integer.valueOf(type))).booleanValue();
    }

    public final void setLastMoveDistance(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, Float.valueOf(f16));
        } else {
            this.lastMoveDistance = f16;
        }
    }

    public final void setMNestedInProgress(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.mNestedInProgress = z16;
        }
    }

    public abstract int t();

    public final boolean u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.mNestedInProgress;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final float v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Float) iPatchRedirector.redirect((short) 3, (Object) this)).floatValue();
        }
        return this.mSpinner;
    }

    public abstract float w();

    public abstract float x(float totalSpinner);

    public final void y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this.mSpinner = 0.0f;
        this.mPreConsumedNeeded = 0;
        s("reset");
        B(this, 0.0f, 0, 2, null);
    }

    @JvmOverloads
    public AIOBounceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) {
            return;
        }
        iPatchRedirector.redirect((short) 21, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ AIOBounceLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 20)) {
            return;
        }
        iPatchRedirector.redirect((short) 20, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIOBounceLayout(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        ViewConfiguration viewConfig = ViewConfiguration.get(context);
        this.viewConfig = viewConfig;
        Intrinsics.checkNotNullExpressionValue(viewConfig, "viewConfig");
        this.mMinimumVelocity = viewConfig.getScaledMinimumFlingVelocity();
        Intrinsics.checkNotNullExpressionValue(viewConfig, "viewConfig");
        this.mMaximumVelocity = viewConfig.getScaledMaximumFlingVelocity();
        this.mScrollPointerId = -1;
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mReboundInterpolator = new com.tencent.aio.widget.interpolators.a(com.tencent.aio.widget.interpolators.b.e());
        this.mIsAllowOverScroll = true;
        Resources resources = context.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
        this.mScreenHeightPixels = resources.getDisplayMetrics().heightPixels;
        this.scrollType = -1;
    }
}
