package com.tencent.qqnt.emotion.relatedemo;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import androidx.core.view.ViewCompat;
import com.heytap.databaseengine.apiv3.data.Element;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0015\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 h2\u00020\u00012\u00020\u0002:\u0002ijB'\b\u0007\u0012\u0006\u0010b\u001a\u00020a\u0012\n\b\u0002\u0010d\u001a\u0004\u0018\u00010c\u0012\b\b\u0002\u0010e\u001a\u00020\u0007\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001e\u0010\u000f\u001a\u00020\u00032\n\u0010\f\u001a\u00020\n\"\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\b\u0010\u0016\u001a\u00020\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u000e\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u0007J\u000e\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u001fJ\u0006\u0010\"\u001a\u00020\u0003J\u000e\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0007J\u0010\u0010%\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J \u0010)\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0007H\u0016J \u0010*\u001a\u00020\u00032\u0006\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001fH\u0016J0\u00100\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0007H\u0016J(\u00104\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0016J(\u00107\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000b2\u0006\u00103\u001a\u00020\rH\u0016J \u00108\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u000b2\u0006\u00106\u001a\u00020\u000bH\u0016J\b\u00109\u001a\u00020\u0007H\u0016R\u0016\u0010<\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\t\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010FR\u0016\u0010H\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010=R\u0016\u0010K\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010M\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010JR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010;R\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010=R\u0016\u0010R\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010JR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010Y\u001a\u00020W8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010XR\u0016\u0010\\\u001a\u00020\u00018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010JR\u0016\u0010`\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010=\u00a8\u0006k"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSlideBottomPanel;", "Landroid/widget/FrameLayout;", "Landroidx/core/view/NestedScrollingParent;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", DomainData.DOMAIN_NAME, "", "targetHeight", tl.h.F, "", "", "values", "", "updatePanel", "e", "isIntercept", "k", "r", "dy", "u", "v", "t", "Landroid/view/MotionEvent;", "ev", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSlideBottomPanel$a;", "callback", IECSearchBar.METHOD_SET_CALLBACK, "contentHeight", "setContentHeight", "Landroid/view/View;", "view", "setContentView", "i", "dismissType", "l", "dispatchTouchEvent", "child", "target", "axes", "onStartNestedScroll", "onNestedScrollAccepted", "onStopNestedScroll", "dxConsumed", "dyConsumed", "dxUnconsumed", "dyUnconsumed", "onNestedScroll", "dx", "", "consumed", "onNestedPreScroll", "velocityX", "velocityY", "onNestedFling", "onNestedPreFling", "getNestedScrollAxes", "d", UserInfo.SEX_FEMALE, "mDensity", "I", "mScaledTouchSlop", "Landroid/widget/LinearLayout;", "f", "Landroid/widget/LinearLayout;", "mContentView", "Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSlideBottomPanel$a;", "mCallback", "Landroidx/core/view/NestedScrollingParentHelper;", "Landroidx/core/view/NestedScrollingParentHelper;", "mNestedScrollingParentHelper", "mContentHeight", BdhLogUtil.LogTag.Tag_Conn, "Z", "mConsumeTouchEvent", "D", "mIsTouch", "E", "mLastY", "mMoveDistance", "G", "mMoved", "", "H", "B", "mSlideStartDir", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "mIvDragIcon", "J", "Landroid/widget/FrameLayout;", "mDragArea", "K", "mPanelDragging", "L", "mDismissType", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "M", "a", "b", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class RelatedEmoSlideBottomPanel extends FrameLayout implements NestedScrollingParent {
    static IPatchRedirector $redirector_;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private boolean mConsumeTouchEvent;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsTouch;

    /* renamed from: E, reason: from kotlin metadata */
    private float mLastY;

    /* renamed from: F, reason: from kotlin metadata */
    private int mMoveDistance;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean mMoved;

    /* renamed from: H, reason: from kotlin metadata */
    private byte mSlideStartDir;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mIvDragIcon;

    /* renamed from: J, reason: from kotlin metadata */
    private FrameLayout mDragArea;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mPanelDragging;

    /* renamed from: L, reason: from kotlin metadata */
    private int mDismissType;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float mDensity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mScaledTouchSlop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private LinearLayout mContentView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private a mCallback;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final NestedScrollingParentHelper mNestedScrollingParentHelper;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mContentHeight;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\t\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSlideBottomPanel$a;", "", "", Element.ELEMENT_NAME_DISTANCE, "", "b", "", "type", "a", "d", "c", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public interface a {
        void a(int type);

        void b(float distance);

        void c();

        void d();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0004R\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0004\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/emotion/relatedemo/RelatedEmoSlideBottomPanel$b;", "", "", "DEFAULT_ANIMATION_DURATION", "I", "", "SLIDE_DIR_DEFAULT", "B", "SLIDE_DIR_DOWN", "SLIDE_DIR_UP", "", "TAG", "Ljava/lang/String;", "TYPE_BACK_DISMISS", "TYPE_CLICK_DISMISS", "TYPE_DRAG_DISMISS", "TYPE_EMPTY_DISMISS", "TYPE_NONE_DISMISS", "<init>", "()V", "emotionpanel_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.emotion.relatedemo.RelatedEmoSlideBottomPanel$b, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39852);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RelatedEmoSlideBottomPanel(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
    }

    private final void e(final float[] values, final boolean updatePanel) {
        LinearLayout linearLayout = this.mContentView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout = null;
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(linearLayout, "y", Arrays.copyOf(values, values.length));
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.qqnt.emotion.relatedemo.e
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelatedEmoSlideBottomPanel.g(updatePanel, this, values, valueAnimator);
            }
        });
        ofFloat.setDuration(250L).start();
    }

    static /* synthetic */ void f(RelatedEmoSlideBottomPanel relatedEmoSlideBottomPanel, float[] fArr, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        relatedEmoSlideBottomPanel.e(fArr, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(boolean z16, RelatedEmoSlideBottomPanel this$0, float[] values, ValueAnimator valueAnimator) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(values, "$values");
        LinearLayout linearLayout = null;
        if (z16) {
            Object animatedValue = valueAnimator.getAnimatedValue();
            Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            float floatValue = ((Float) animatedValue).floatValue();
            a aVar = this$0.mCallback;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                aVar = null;
            }
            aVar.b(floatValue - this$0.r());
        }
        if (this$0.mDismissType > 0) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            boolean z18 = false;
            if (animatedFraction == 1.0f) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (values[1] == this$0.getMeasuredHeight()) {
                    z18 = true;
                }
                if (z18) {
                    a aVar2 = this$0.mCallback;
                    if (aVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                        aVar2 = null;
                    }
                    aVar2.a(this$0.mDismissType);
                    LinearLayout linearLayout2 = this$0.mContentView;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                    } else {
                        linearLayout = linearLayout2;
                    }
                    linearLayout.removeAllViews();
                }
            }
        }
    }

    private final void h(int targetHeight) {
        boolean z16;
        LinearLayout linearLayout = this.mContentView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout = null;
        }
        float f16 = targetHeight;
        if (linearLayout.getY() == f16) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            float[] fArr = new float[2];
            LinearLayout linearLayout2 = this.mContentView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                linearLayout2 = null;
            }
            fArr[0] = linearLayout2.getY();
            fArr[1] = f16;
            f(this, fArr, false, 2, null);
            this.mConsumeTouchEvent = false;
            k(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(RelatedEmoSlideBottomPanel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.setVisibility(0);
        f(this$0, new float[]{this$0.getMeasuredHeight(), this$0.r()}, false, 2, null);
    }

    private final void k(boolean isIntercept) {
        ViewParent parent = getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).requestDisallowInterceptTouchEvent(isIntercept);
    }

    private final void m() {
        this.mDensity = getContext().getResources().getDisplayMetrics().density;
        this.mScaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
        n();
        p();
        setVisibility(4);
    }

    private final void n() {
        int i3;
        this.mContentView = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.height = this.mContentHeight;
        LinearLayout linearLayout = this.mContentView;
        LinearLayout linearLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout = null;
        }
        linearLayout.setLayoutParams(layoutParams);
        boolean areEqual = Intrinsics.areEqual("2971", QQTheme.getCurrentThemeId());
        boolean isNowThemeIsNight = QQTheme.isNowThemeIsNight();
        if (areEqual) {
            LinearLayout linearLayout3 = this.mContentView;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                linearLayout3 = null;
            }
            linearLayout3.setBackgroundResource(R.drawable.lks);
        } else {
            LinearLayout linearLayout4 = this.mContentView;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                linearLayout4 = null;
            }
            if (isNowThemeIsNight) {
                i3 = R.drawable.lkr;
            } else {
                i3 = R.drawable.f162424hj1;
            }
            linearLayout4.setBackgroundResource(i3);
        }
        LinearLayout linearLayout5 = this.mContentView;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout5 = null;
        }
        linearLayout5.setOrientation(1);
        LinearLayout linearLayout6 = this.mContentView;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
        } else {
            linearLayout2 = linearLayout6;
        }
        addView(linearLayout2);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.emotion.relatedemo.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RelatedEmoSlideBottomPanel.o(RelatedEmoSlideBottomPanel.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(RelatedEmoSlideBottomPanel this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mDismissType = 1;
        this$0.h(this$0.getMeasuredHeight());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void p() {
        int dip2px = ViewUtils.dip2px(38.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, dip2px);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.mDragArea = frameLayout;
        frameLayout.setLayoutParams(layoutParams);
        LinearLayout linearLayout = this.mContentView;
        FrameLayout frameLayout2 = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout = null;
        }
        FrameLayout frameLayout3 = this.mDragArea;
        if (frameLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragArea");
            frameLayout3 = null;
        }
        linearLayout.addView(frameLayout3);
        this.mIvDragIcon = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dip2px, dip2px);
        layoutParams2.gravity = 17;
        ImageView imageView = this.mIvDragIcon;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvDragIcon");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.hzl);
        ImageView imageView2 = this.mIvDragIcon;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvDragIcon");
            imageView2 = null;
        }
        imageView2.setLayoutParams(layoutParams2);
        FrameLayout frameLayout4 = this.mDragArea;
        if (frameLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragArea");
            frameLayout4 = null;
        }
        ImageView imageView3 = this.mIvDragIcon;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mIvDragIcon");
            imageView3 = null;
        }
        frameLayout4.addView(imageView3);
        FrameLayout frameLayout5 = this.mDragArea;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDragArea");
        } else {
            frameLayout2 = frameLayout5;
        }
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.emotion.relatedemo.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RelatedEmoSlideBottomPanel.q(RelatedEmoSlideBottomPanel.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(RelatedEmoSlideBottomPanel this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mDismissType = 2;
        this$0.h(this$0.getMeasuredHeight());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final int r() {
        return getMeasuredHeight() - this.mContentHeight;
    }

    private final void s(MotionEvent ev5) {
        float rawY = ev5.getRawY();
        float f16 = rawY - this.mLastY;
        u(f16);
        v((int) (this.mLastY - rawY));
        this.mLastY = ev5.getRawY();
        this.mMoveDistance += (int) Math.abs(f16);
    }

    private final void t() {
        LinearLayout linearLayout = null;
        boolean z16 = false;
        if (this.mPanelDragging) {
            this.mPanelDragging = false;
            a aVar = this.mCallback;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                aVar = null;
            }
            aVar.c();
        }
        if (this.mContentHeight != 0) {
            z16 = true;
        }
        if (z16) {
            LinearLayout linearLayout2 = this.mContentView;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            } else {
                linearLayout = linearLayout2;
            }
            float y16 = ((linearLayout.getY() - r()) * 1.0f) / this.mContentHeight;
            if (this.mSlideStartDir == 1 && y16 > 0.2f) {
                h(getMeasuredHeight());
                return;
            } else {
                h(r());
                return;
            }
        }
        throw new IllegalArgumentException("content height is 0 !!!".toString());
    }

    private final void u(float dy5) {
        if (dy5 > 0.0f) {
            this.mSlideStartDir = (byte) 1;
        } else if (dy5 < 0.0f) {
            this.mSlideStartDir = (byte) 2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0044  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final float v(int dy5) {
        int r16;
        a aVar;
        LinearLayout linearLayout;
        LinearLayout linearLayout2 = this.mContentView;
        LinearLayout linearLayout3 = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout2 = null;
        }
        float f16 = dy5;
        float y16 = linearLayout2.getY() - f16;
        if (y16 > getMeasuredHeight()) {
            f16 -= y16 - getMeasuredHeight();
            r16 = getMeasuredHeight();
        } else {
            if (y16 < r()) {
                f16 -= r() - y16;
                r16 = r();
            }
            if (!this.mPanelDragging) {
                this.mPanelDragging = true;
                a aVar2 = this.mCallback;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                    aVar2 = null;
                }
                aVar2.d();
            }
            aVar = this.mCallback;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                aVar = null;
            }
            aVar.b(y16 - r());
            linearLayout = this.mContentView;
            if (linearLayout != null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            } else {
                linearLayout3 = linearLayout;
            }
            linearLayout3.setY(y16);
            return f16;
        }
        y16 = r16;
        if (!this.mPanelDragging) {
        }
        aVar = this.mCallback;
        if (aVar == null) {
        }
        aVar.b(y16 - r());
        linearLayout = this.mContentView;
        if (linearLayout != null) {
        }
        linearLayout3.setY(y16);
        return f16;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@NotNull MotionEvent ev5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) ev5)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(ev5, "ev");
        int action = ev5.getAction();
        FrameLayout frameLayout = null;
        boolean z16 = false;
        if (action != 0) {
            if (action != 1) {
                if (action != 2) {
                    if (action == 3) {
                        this.mIsTouch = false;
                        this.mMoved = false;
                    }
                } else if (this.mConsumeTouchEvent) {
                    this.mMoved = true;
                    s(ev5);
                    return true;
                }
            } else {
                this.mIsTouch = false;
                if (this.mConsumeTouchEvent) {
                    int i3 = this.mMoveDistance;
                    if ((i3 == 0 && !this.mMoved) || (this.mMoved && i3 < this.mScaledTouchSlop)) {
                        FrameLayout frameLayout2 = this.mDragArea;
                        if (frameLayout2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mDragArea");
                        } else {
                            frameLayout = frameLayout2;
                        }
                        frameLayout.performClick();
                    } else {
                        this.mDismissType = 3;
                        t();
                    }
                }
                this.mMoved = false;
            }
        } else {
            this.mLastY = ev5.getRawY();
            this.mIsTouch = true;
            this.mMoved = false;
            this.mMoveDistance = 0;
            this.mPanelDragging = false;
            int[] iArr = new int[2];
            FrameLayout frameLayout3 = this.mDragArea;
            if (frameLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragArea");
                frameLayout3 = null;
            }
            frameLayout3.getLocationOnScreen(iArr);
            int i16 = iArr[0];
            int i17 = iArr[1];
            FrameLayout frameLayout4 = this.mDragArea;
            if (frameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragArea");
                frameLayout4 = null;
            }
            int measuredWidth = frameLayout4.getMeasuredWidth() + i16;
            int i18 = iArr[1];
            FrameLayout frameLayout5 = this.mDragArea;
            if (frameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDragArea");
            } else {
                frameLayout = frameLayout5;
            }
            Rect rect = new Rect(i16, i17, measuredWidth, i18 + frameLayout.getMeasuredHeight());
            if (!rect.isEmpty() && rect.contains((int) ev5.getRawX(), (int) ev5.getRawY())) {
                z16 = true;
            }
            this.mConsumeTouchEvent = z16;
            if (z16) {
                k(true);
            }
            QLog.d("RelatedEmoSlideBottomPanel", 2, "mConsumeTouchEvent : " + this.mConsumeTouchEvent);
        }
        if (this.mConsumeTouchEvent) {
            return true;
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.mNestedScrollingParentHelper.getNestedScrollAxes();
    }

    public final void i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            post(new Runnable() { // from class: com.tencent.qqnt.emotion.relatedemo.h
                @Override // java.lang.Runnable
                public final void run() {
                    RelatedEmoSlideBottomPanel.j(RelatedEmoSlideBottomPanel.this);
                }
            });
        }
    }

    public final void l(int dismissType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, dismissType);
            return;
        }
        if (this.mDismissType != dismissType) {
            this.mDismissType = dismissType;
            float[] fArr = new float[2];
            LinearLayout linearLayout = this.mContentView;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                linearLayout = null;
            }
            fArr[0] = linearLayout.getY();
            fArr[1] = getMeasuredHeight();
            f(this, fArr, false, 2, null);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NotNull View target, float velocityX, float velocityY, boolean consumed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, this, target, Float.valueOf(velocityX), Float.valueOf(velocityY), Boolean.valueOf(consumed))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NotNull View target, float velocityX, float velocityY) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, target, Float.valueOf(velocityX), Float.valueOf(velocityY))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(target, "target");
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, target, Integer.valueOf(dx5), Integer.valueOf(dy5), consumed);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        LinearLayout linearLayout = this.mContentView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout = null;
        }
        float y16 = linearLayout.getY();
        if (y16 == r()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (y16 > r()) {
            z17 = true;
        }
        if ((z16 && !ViewCompat.canScrollVertically(target, dy5)) || z17) {
            u(-dy5);
            consumed[1] = (int) v(dy5);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00a4  */
    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onNestedScroll(@NotNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {
        int r16;
        a aVar;
        LinearLayout linearLayout;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, target, Integer.valueOf(dxConsumed), Integer.valueOf(dyConsumed), Integer.valueOf(dxUnconsumed), Integer.valueOf(dyUnconsumed));
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        LinearLayout linearLayout2 = this.mContentView;
        LinearLayout linearLayout3 = null;
        if (linearLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout2 = null;
        }
        if (linearLayout2.getY() < r()) {
            z16 = false;
        }
        if (z16) {
            LinearLayout linearLayout4 = this.mContentView;
            if (linearLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                linearLayout4 = null;
            }
            float f16 = dyUnconsumed;
            float y16 = linearLayout4.getY() - f16;
            if (y16 > getMeasuredHeight()) {
                r16 = getMeasuredHeight();
            } else {
                if (y16 < r()) {
                    r16 = r();
                }
                u(-f16);
                aVar = this.mCallback;
                if (aVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mCallback");
                    aVar = null;
                }
                aVar.b(y16 - r());
                linearLayout = this.mContentView;
                if (linearLayout != null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mContentView");
                } else {
                    linearLayout3 = linearLayout;
                }
                linearLayout3.setY(y16);
            }
            y16 = r16;
            u(-f16);
            aVar = this.mCallback;
            if (aVar == null) {
            }
            aVar.b(y16 - r());
            linearLayout = this.mContentView;
            if (linearLayout != null) {
            }
            linearLayout3.setY(y16);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NotNull View child, @NotNull View target, int axes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, child, target, Integer.valueOf(axes));
            return;
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        this.mNestedScrollingParentHelper.onNestedScrollAccepted(child, target, axes);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NotNull View child, @NotNull View target, int axes) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, child, target, Integer.valueOf(axes))).booleanValue();
        }
        Intrinsics.checkNotNullParameter(child, "child");
        Intrinsics.checkNotNullParameter(target, "target");
        if ((axes & 2) != 0) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NotNull View target) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) target);
            return;
        }
        Intrinsics.checkNotNullParameter(target, "target");
        this.mNestedScrollingParentHelper.onStopNestedScroll(target);
        if (!this.mIsTouch && this.mDismissType != 4) {
            this.mDismissType = 3;
            t();
        }
    }

    public final void setCallback(@NotNull a callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(callback, "callback");
            this.mCallback = callback;
        }
    }

    public final void setContentHeight(int contentHeight) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, contentHeight);
        } else {
            this.mContentHeight = contentHeight;
            m();
        }
    }

    public final void setContentView(@NotNull View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = this.mContentView;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            linearLayout = null;
        }
        linearLayout.addView(view, new LinearLayout.LayoutParams(-1, -1));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RelatedEmoSlideBottomPanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) {
            return;
        }
        iPatchRedirector.redirect((short) 17, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ RelatedEmoSlideBottomPanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public RelatedEmoSlideBottomPanel(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.mNestedScrollingParentHelper = new NestedScrollingParentHelper(this);
            this.mDismissType = -1;
        }
    }
}
