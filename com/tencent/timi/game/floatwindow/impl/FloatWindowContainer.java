package com.tencent.timi.game.floatwindow.impl;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Outline;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.miniaio.MiniChatConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.f;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.timi.game.floatwindow.FloatPosFixHelper;
import com.tencent.timi.game.floatwindow.impl.FloatWindowContainer;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh4.d;
import xh4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 x2\u00020\u00012\u00020\u0002:\u0002yzB'\b\u0007\u0012\u0006\u0010r\u001a\u00020Y\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010s\u0012\b\b\u0002\u0010u\u001a\u00020\u000b\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0018\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\tH\u0002J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u000bH\u0002J\u0012\u0010\u001c\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00020\u0005H\u0002J\u0012\u0010#\u001a\u00020\u00032\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\u0010\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020$H\u0016J\u0010\u0010(\u001a\u00020\u00052\u0006\u0010'\u001a\u00020$H\u0016J\u0006\u0010\u000e\u001a\u00020\u0003J\u0016\u0010,\u001a\u00020+2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ\u0016\u0010-\u001a\u00020\u00032\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020\u000bJ\u0016\u0010/\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000bJ\u000e\u00101\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u0005J\u000e\u00104\u001a\u00020\u00032\u0006\u00103\u001a\u000202J\u0012\u00107\u001a\u00020\u00032\b\u00106\u001a\u0004\u0018\u000105H\u0014J\u000e\u00109\u001a\u00020\u00032\u0006\u00108\u001a\u00020\u0005J,\u0010>\u001a\u00020\u00032\b\u0010;\u001a\u0004\u0018\u00010:2\b\u0010<\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0016\u001a\u00020\u0015J\"\u0010@\u001a\u00020\u00032\b\u0010<\u001a\u0004\u0018\u00010\u00122\b\u0010=\u001a\u0004\u0018\u00010\u00122\u0006\u0010?\u001a\u00020\u000bJ\u0006\u0010A\u001a\u00020\u0005J\u0006\u0010.\u001a\u00020\u0003J\u0010\u0010B\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tJ\u0006\u0010C\u001a\u00020\u0003J\u0018\u0010E\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010D\u001a\u00020\u0005J\u0006\u0010F\u001a\u00020\u000bJ\u0006\u0010G\u001a\u00020\u000bR\u0016\u0010I\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010KR\u0016\u0010M\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010HR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010HR\u0016\u0010O\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010Q\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010PR\u0018\u0010S\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010RR\u0018\u0010T\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010RR\u0016\u0010W\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010VR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010VR\u0014\u0010\\\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010_R\"\u00108\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010P\u001a\u0004\b8\u0010a\"\u0004\bb\u0010cR\u0018\u0010;\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010g\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010PR\u0018\u0010j\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0018\u0010m\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\"\u0010q\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bn\u0010P\u001a\u0004\bo\u0010a\"\u0004\bp\u0010c\u00a8\u0006{"}, d2 = {"Lcom/tencent/timi/game/floatwindow/impl/FloatWindowContainer;", "Landroid/widget/FrameLayout;", "Lxh4/c;", "", ReportConstant.COSTREPORT_PREFIX, "", "fixPos", "isFreeDrag", "t", "Landroid/view/WindowManager$LayoutParams;", "layoutParams", "", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, HippyTKDListViewAdapter.X, "y", "u", "e", "Landroid/view/View;", "view", "roundCorners", "Luh4/c;", "floatParams", "c", "newLayoutParams", "E", "oldWidth", "r", "f", "j", "o", MiniChatConstants.MINI_APP_LANDSCAPE, DomainData.DOMAIN_NAME, "Lxh4/b;", "onDragListener", "setOnDragListener", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "newLeft", "newTop", "Lcom/tencent/timi/game/floatwindow/FloatPosFixHelper$FloatPosItem;", h.F, "p", "w", BdhLogUtil.LogTag.Tag_Conn, "canFreeDrag", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lxh4/a;", "listener", "setDragListener", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "isHorizontal", "d", "", "key", "floatingWidgetWrapper", "customView", "g", "roundCorner", "setRoundCorner", "v", "D", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "isNeedUpdateWidthHeight", "B", "k", "i", "I", "mTouchSlop", "Landroid/view/WindowManager;", "Landroid/view/WindowManager;", "mWindowManager", "mScreenWidth", "mScreenHeight", "mWindowType", "Z", "mIsBeingDragged", "Luh4/c;", "mFloatParams", "mNewFloatParams", "", UserInfo.SEX_FEMALE, "mInitialMotionY", "mInitialMotionX", "Landroid/content/Context;", "G", "Landroid/content/Context;", "mContext", "Landroid/animation/ValueAnimator;", "H", "Landroid/animation/ValueAnimator;", "mDragEndAnimator", "()Z", "setHorizontal", "(Z)V", "J", "Ljava/lang/String;", "K", "mCanFreeDrag", "L", "Landroid/view/WindowManager$LayoutParams;", "mFloatWindowLayoutParams", "M", "Lxh4/a;", "mFloatingViewTouchCallback", "N", "getFloatShowing", "setFloatShowing", "floatShowing", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "P", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class FloatWindowContainer extends FrameLayout implements xh4.c {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private uh4.c mFloatParams;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private uh4.c mNewFloatParams;

    /* renamed from: E, reason: from kotlin metadata */
    private float mInitialMotionY;

    /* renamed from: F, reason: from kotlin metadata */
    private float mInitialMotionX;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Context mContext;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ValueAnimator mDragEndAnimator;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isHorizontal;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private String key;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean mCanFreeDrag;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private WindowManager.LayoutParams mFloatWindowLayoutParams;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private a mFloatingViewTouchCallback;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean floatShowing;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mTouchSlop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private WindowManager mWindowManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int mScreenWidth;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int mScreenHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int mWindowType;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean mIsBeingDragged;

    /* compiled from: P */
    @RequiresApi(api = 21)
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\u000b\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/timi/game/floatwindow/impl/FloatWindowContainer$b;", "Landroid/view/ViewOutlineProvider;", "Landroid/view/View;", "view", "Landroid/graphics/Outline;", "outline", "", "getOutline", "", "a", "I", "mRadius", "<init>", "(I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends ViewOutlineProvider {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final int mRadius;

        public b(int i3) {
            this.mRadius = i3;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(@NotNull View view, @NotNull Outline outline) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(outline, "outline");
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            outline.setRoundRect(new Rect(0, 0, (rect.right - rect.left) - 0, (rect.bottom - rect.top) - 0), this.mRadius);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/timi/game/floatwindow/impl/FloatWindowContainer$c", "Lcom/tencent/mobileqq/widget/f;", "Landroid/animation/Animator;", "animator", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c extends f {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            animator.removeAllListeners();
            FloatWindowContainer.b(FloatWindowContainer.this);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
        }

        @Override // com.tencent.mobileqq.widget.f, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animator) {
            Intrinsics.checkNotNullParameter(animator, "animator");
            FloatWindowContainer.b(FloatWindowContainer.this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatWindowContainer(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void E(WindowManager.LayoutParams newLayoutParams) {
        D(newLayoutParams);
        uh4.c cVar = this.mFloatParams;
        if (cVar != null) {
            cVar.o(newLayoutParams.x);
        }
        uh4.c cVar2 = this.mFloatParams;
        if (cVar2 != null) {
            cVar2.p(newLayoutParams.y);
        }
        uh4.c cVar3 = this.mNewFloatParams;
        if (cVar3 != null) {
            cVar3.o(newLayoutParams.x);
        }
        uh4.c cVar4 = this.mNewFloatParams;
        if (cVar4 != null) {
            cVar4.p(newLayoutParams.y);
        }
    }

    public static final /* synthetic */ xh4.b b(FloatWindowContainer floatWindowContainer) {
        floatWindowContainer.getClass();
        return null;
    }

    private final void c(uh4.c floatParams) {
        try {
            if (this.mWindowManager != null) {
                WindowManager.LayoutParams f16 = f(floatParams);
                WindowManager windowManager = this.mWindowManager;
                Intrinsics.checkNotNull(windowManager);
                windowManager.addView(this, f16);
            }
        } catch (Exception e16) {
            QLog.e("Open_Live|FloatWindowContainer", 1, "addToWindowManager error:" + e16);
        }
    }

    private final void e() {
        try {
            if (Build.VERSION.SDK_INT >= 28) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
                WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
                this.mFloatWindowLayoutParams = layoutParams2;
                Intrinsics.checkNotNull(layoutParams2);
                layoutParams2.layoutInDisplayCutoutMode = 2;
                WindowManager windowManager = this.mWindowManager;
                if (windowManager != null) {
                    Intrinsics.checkNotNull(windowManager);
                    windowManager.updateViewLayout(this, this.mFloatWindowLayoutParams);
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private final WindowManager.LayoutParams f(uh4.c floatParams) {
        int mWidth = (this.mScreenWidth - floatParams.getMWidth()) / 2;
        int mHeight = (this.mScreenHeight - floatParams.getMHeight()) / 2;
        if (QBaseActivity.mAppForground) {
            boolean z16 = this.isHorizontal;
        }
        int j3 = j();
        int i3 = this.mScreenHeight / 4;
        floatParams.o(j3);
        floatParams.p(i3);
        uh4.c cVar = this.mNewFloatParams;
        if (cVar != null) {
            cVar.o(j3);
        }
        uh4.c cVar2 = this.mNewFloatParams;
        if (cVar2 != null) {
            cVar2.p(i3);
        }
        if (this.mFloatWindowLayoutParams == null) {
            this.mFloatWindowLayoutParams = new WindowManager.LayoutParams();
        }
        WindowManager.LayoutParams layoutParams = this.mFloatWindowLayoutParams;
        if (layoutParams != null) {
            layoutParams.type = this.mWindowType;
            layoutParams.format = 1;
            layoutParams.flags = 16777256;
            layoutParams.width = floatParams.getMWidth();
            layoutParams.height = floatParams.getMHeight();
            layoutParams.x = floatParams.getMFloatingCenterX();
            layoutParams.y = floatParams.getMFloatingCenterY();
            if (Build.VERSION.SDK_INT >= 28) {
                layoutParams.layoutInDisplayCutoutMode = 2;
            }
            if (!vh4.c.a(this.mContext)) {
                layoutParams.systemUiVisibility = 5892;
            }
        }
        return this.mFloatWindowLayoutParams;
    }

    private final int j() {
        int i3 = this.mScreenWidth / 2;
        uh4.c cVar = this.mFloatParams;
        Intrinsics.checkNotNull(cVar);
        return (i3 - (cVar.getMWidth() / 2)) + n(getIsHorizontal());
    }

    private final int l(WindowManager.LayoutParams layoutParams) {
        int j3 = j();
        int i3 = -this.mScreenWidth;
        int i16 = layoutParams.x;
        int i17 = -j3;
        if (i16 < i17) {
            i3 = i17;
        }
        if (i16 > j3) {
            i3 = j3;
        }
        if (i16 >= i17 && i16 <= j3) {
            if (i16 >= 0) {
                i17 = j3;
            }
            i3 = i17;
        }
        QLog.d("Open_Live|FloatWindowContainer", 1, "getMaxWidthEdge... layoutParams:(" + i16 + "," + layoutParams.y + ") maxLeft:" + j3 + " newLeft:" + i3);
        return i3;
    }

    private final int m(WindowManager.LayoutParams layoutParams) {
        if (QBaseActivity.mAppForground) {
            boolean z16 = this.isHorizontal;
        }
        int i3 = i();
        int i16 = -k();
        uh4.c cVar = this.mFloatParams;
        Intrinsics.checkNotNull(cVar);
        int mFloatingCenterY = cVar.getMFloatingCenterY();
        int i17 = layoutParams.y;
        if (i17 <= i3) {
            i3 = mFloatingCenterY;
        }
        if (i17 >= i16) {
            return i3;
        }
        return i16;
    }

    private final int n(boolean isLandscape) {
        if (isLandscape) {
            return com.tencent.timi.game.utils.b.a(50);
        }
        return com.tencent.timi.game.utils.b.a(0);
    }

    /* renamed from: o, reason: from getter */
    private final boolean getIsHorizontal() {
        return this.isHorizontal;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(WindowManager.LayoutParams layoutParams, int i3, int i16, int i17, int i18, FloatWindowContainer this$0, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(layoutParams, "$layoutParams");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float floatValue = ((Float) animatedValue).floatValue();
        layoutParams.x = (int) (i3 + ((i16 - i3) * floatValue));
        layoutParams.y = (int) (i17 + (floatValue * (i18 - i17)));
        this$0.E(layoutParams);
    }

    private final boolean r(uh4.c floatParams, int oldWidth) {
        int mWidth;
        boolean z16;
        if (floatParams.getMWidth() <= oldWidth) {
            return true;
        }
        if (this.mScreenWidth / 2 > floatParams.getMWidth()) {
            mWidth = (this.mScreenWidth / 2) - floatParams.getMWidth();
        } else {
            mWidth = ((this.mScreenWidth - floatParams.getMWidth()) / 2) * (-1);
        }
        if (floatParams.getMFloatingCenterX() > mWidth) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("Open_Live|FloatWindowContainer", 1, "needMoveFloatLogo: maxCenterX:" + mWidth + ", result:" + z16);
        return z16;
    }

    private final void s() {
        t(false, this.mCanFreeDrag);
    }

    private final void t(boolean fixPos, boolean isFreeDrag) {
        int i3;
        int i16;
        List<? extends FloatPosFixHelper.FloatPosItem> mutableListOf;
        uh4.c cVar = this.mNewFloatParams;
        if (cVar == null) {
            QLog.e("Open_Live|FloatWindowContainer", 1, "onDragEndAnimation with null mNewFloatParams");
            return;
        }
        Intrinsics.checkNotNull(cVar);
        this.mFloatParams = cVar.clone();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
        WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
        int l3 = l(layoutParams2);
        int m3 = m(layoutParams2);
        if (isFreeDrag) {
            uh4.c cVar2 = this.mFloatParams;
            Intrinsics.checkNotNull(cVar2);
            i16 = cVar2.getMFloatingCenterX();
            uh4.c cVar3 = this.mFloatParams;
            Intrinsics.checkNotNull(cVar3);
            i3 = cVar3.getMFloatingCenterY();
        } else {
            i3 = m3;
            i16 = l3;
        }
        QLog.d("Open_Live|FloatWindowContainer", 1, "onDragEndAnimation... isFreeDrag:" + isFreeDrag + " max:(" + l3 + "," + m3 + ") toLeft:(" + i16 + "," + i3 + ")");
        FloatPosFixHelper.FloatPosItem h16 = h(i16, i3);
        d.Companion companion = d.INSTANCE;
        companion.a().j(h16);
        if (fixPos) {
            d a16 = companion.a();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(h16);
            a16.m(mutableListOf, true);
        }
        p(i16, i3);
        a aVar = this.mFloatingViewTouchCallback;
        if (aVar != null) {
            aVar.c(i16, l3);
        }
    }

    private final void u(int x16, int y16) {
        boolean z16;
        uh4.c cVar = this.mFloatParams;
        if (cVar != null && cVar.getMCanMove()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.mNewFloatParams != null) {
            uh4.c cVar2 = this.mFloatParams;
            Intrinsics.checkNotNull(cVar2);
            int mFloatingCenterX = cVar2.getMFloatingCenterX() + x16;
            uh4.c cVar3 = this.mFloatParams;
            Intrinsics.checkNotNull(cVar3);
            int mFloatingCenterY = cVar3.getMFloatingCenterY() + y16;
            if (mFloatingCenterY >= k() * (-1) && mFloatingCenterY <= i()) {
                uh4.c cVar4 = this.mNewFloatParams;
                Intrinsics.checkNotNull(cVar4);
                uh4.c cVar5 = this.mFloatParams;
                Intrinsics.checkNotNull(cVar5);
                cVar4.p(cVar5.getMFloatingCenterY() + y16);
            } else {
                QLog.e("Open_Live|FloatWindowContainer", 1, "onDragStart Y out of bounds.");
            }
            if (Math.abs(mFloatingCenterX) > j()) {
                QLog.e("Open_Live|FloatWindowContainer", 1, "onDragStart X out of bounds.");
            } else {
                uh4.c cVar6 = this.mNewFloatParams;
                Intrinsics.checkNotNull(cVar6);
                uh4.c cVar7 = this.mFloatParams;
                Intrinsics.checkNotNull(cVar7);
                cVar6.o(cVar7.getMFloatingCenterX() + x16);
            }
            uh4.c cVar8 = this.mNewFloatParams;
            Intrinsics.checkNotNull(cVar8);
            D(B(cVar8, false));
        }
    }

    private final void y(View view, int roundCorners) {
        view.setOutlineProvider(new b(roundCorners));
        view.setClipToOutline(true);
    }

    public final void A(boolean canFreeDrag) {
        if (this.mCanFreeDrag != canFreeDrag) {
            this.mCanFreeDrag = canFreeDrag;
            if (!canFreeDrag) {
                s();
            }
        }
    }

    @Nullable
    public final WindowManager.LayoutParams B(@NotNull uh4.c floatParams, boolean isNeedUpdateWidthHeight) {
        Intrinsics.checkNotNullParameter(floatParams, "floatParams");
        int i3 = i();
        if (floatParams.getMFloatingCenterY() > i3) {
            floatParams.p(i3);
        }
        if (this.mFloatWindowLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
            this.mFloatWindowLayoutParams = (WindowManager.LayoutParams) layoutParams;
        }
        WindowManager.LayoutParams layoutParams2 = this.mFloatWindowLayoutParams;
        if (layoutParams2 != null) {
            if (isNeedUpdateWidthHeight) {
                int i16 = layoutParams2.width;
                int i17 = layoutParams2.height;
                layoutParams2.width = floatParams.getMWidth();
                layoutParams2.height = floatParams.getMHeight();
                if (r(floatParams, i16)) {
                    floatParams.o(floatParams.getMFloatingCenterX() + ((floatParams.getMWidth() - i16) / 2));
                } else {
                    floatParams.o((floatParams.getMFloatingCenterX() + (floatParams.getMWidth() / 2)) - (i16 / 2));
                }
                floatParams.p(floatParams.getMFloatingCenterY() + ((floatParams.getMHeight() - i17) / 2));
            }
            layoutParams2.x = floatParams.getMFloatingCenterX();
            layoutParams2.y = floatParams.getMFloatingCenterY();
        }
        return this.mFloatWindowLayoutParams;
    }

    public final void C(int w3, int h16) {
        boolean z16;
        int i3;
        int i16;
        uh4.c cVar = this.mFloatParams;
        boolean z17 = false;
        if (cVar != null && w3 == cVar.getMWidth()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            uh4.c cVar2 = this.mFloatParams;
            if (cVar2 != null && h16 == cVar2.getMHeight()) {
                z17 = true;
            }
            if (z17) {
                return;
            }
        }
        uh4.c cVar3 = this.mNewFloatParams;
        if (cVar3 != null) {
            cVar3.s(w3);
        }
        uh4.c cVar4 = this.mNewFloatParams;
        if (cVar4 != null) {
            cVar4.q(h16);
        }
        uh4.c cVar5 = this.mFloatParams;
        if (cVar5 != null) {
            cVar5.s(w3);
        }
        uh4.c cVar6 = this.mFloatParams;
        if (cVar6 != null) {
            cVar6.q(h16);
        }
        uh4.c cVar7 = this.mFloatParams;
        Intrinsics.checkNotNull(cVar7);
        this.mNewFloatParams = cVar7.clone();
        uh4.c cVar8 = this.mFloatParams;
        Intrinsics.checkNotNull(cVar8);
        WindowManager.LayoutParams B = B(cVar8, true);
        if (B != null) {
            int l3 = l(B);
            int m3 = m(B);
            if (this.mCanFreeDrag) {
                uh4.c cVar9 = this.mFloatParams;
                Intrinsics.checkNotNull(cVar9);
                i3 = cVar9.getMFloatingCenterX();
                uh4.c cVar10 = this.mFloatParams;
                Intrinsics.checkNotNull(cVar10);
                i16 = cVar10.getMFloatingCenterY();
            } else {
                i3 = l3;
                i16 = m3;
            }
            QLog.d("Open_Live|FloatWindowContainer", 1, "updateSize max:(" + l3 + "," + m3 + ") toLeft:(" + i3 + "," + i16 + ") freeDrag:" + this.mCanFreeDrag);
            B.x = i3;
            B.y = i16;
            E(B);
        }
    }

    public final void D(@Nullable WindowManager.LayoutParams layoutParams) {
        try {
            WindowManager windowManager = this.mWindowManager;
            if (windowManager != null) {
                Intrinsics.checkNotNull(windowManager);
                windowManager.updateViewLayout(this, layoutParams);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public final void d(boolean isHorizontal) {
        boolean z16;
        if (this.isHorizontal != isHorizontal) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.isHorizontal = isHorizontal;
        QLog.i("Open_Live|FloatWindowContainer", 1, "changeOrientation: isHorizontal:" + isHorizontal);
        uh4.c cVar = this.mFloatParams;
        if (cVar != null) {
            if (isHorizontal) {
                int max = Math.max(this.mScreenHeight, this.mScreenWidth);
                this.mScreenHeight = Math.min(this.mScreenHeight, this.mScreenWidth);
                this.mScreenWidth = max;
            } else {
                int max2 = Math.max(this.mScreenHeight, this.mScreenWidth);
                int min = Math.min(this.mScreenHeight, this.mScreenWidth);
                this.mScreenHeight = max2;
                this.mScreenWidth = min;
            }
            cVar.n(isHorizontal);
            if (z16) {
                ViewGroup.LayoutParams layoutParams = getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.WindowManager.LayoutParams");
                WindowManager.LayoutParams layoutParams2 = (WindowManager.LayoutParams) layoutParams;
                int i3 = layoutParams2.x;
                int i16 = layoutParams2.y;
                if (isHorizontal) {
                    layoutParams2.x = i16;
                    layoutParams2.y = -i3;
                } else {
                    layoutParams2.x = -i16;
                    layoutParams2.y = i3;
                }
                E(layoutParams2);
            }
        }
    }

    public final void g(@Nullable String key, @Nullable View floatingWidgetWrapper, @Nullable View customView, @NotNull uh4.c floatParams) {
        Intrinsics.checkNotNullParameter(floatParams, "floatParams");
        this.key = key;
        this.mFloatParams = floatParams;
        this.mNewFloatParams = floatParams.clone();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        removeAllViews();
        addView(floatingWidgetWrapper, layoutParams);
        c(floatParams);
        s();
        this.floatShowing = true;
    }

    @NotNull
    public final FloatPosFixHelper.FloatPosItem h(int newLeft, int newTop) {
        int i3;
        FloatPosFixHelper.FloatPosItem floatPosItem = new FloatPosFixHelper.FloatPosItem();
        floatPosItem.key = this.key;
        floatPosItem.centerX = newLeft;
        floatPosItem.centerY = newTop;
        int i16 = 0;
        if (newLeft > 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        floatPosItem.side = i3;
        uh4.c cVar = this.mFloatParams;
        if (cVar != null) {
            i16 = cVar.getMHeight();
        }
        floatPosItem.sizeH = i16;
        return floatPosItem;
    }

    public final int i() {
        int i3 = this.mScreenHeight / 2;
        uh4.c cVar = this.mFloatParams;
        Intrinsics.checkNotNull(cVar);
        return i3 - (cVar.getMHeight() / 2);
    }

    public final int k() {
        int i3 = this.mScreenHeight / 2;
        uh4.c cVar = this.mFloatParams;
        Intrinsics.checkNotNull(cVar);
        return (i3 - (cVar.getMHeight() / 2)) - n(!getIsHorizontal());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig != null) {
            if (newConfig.orientation == 2) {
                d(true);
            } else {
                d(false);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001b, code lost:
    
        if (r0 != 3) goto L23;
     */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onInterceptTouchEvent(@NotNull MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        boolean z16 = true;
        if (ev5.getPointerCount() >= 2) {
            return true;
        }
        int action = ev5.getAction();
        if (action != 0) {
            if (action != 1) {
                if (action == 2) {
                    float y16 = ev5.getY();
                    float x16 = ev5.getX();
                    if (Math.abs(this.mInitialMotionY - y16) <= this.mTouchSlop && Math.abs(this.mInitialMotionX - x16) <= this.mTouchSlop) {
                        z16 = false;
                    }
                    this.mIsBeingDragged = z16;
                    if (z16) {
                        this.mInitialMotionY = ev5.getRawY();
                        this.mInitialMotionX = ev5.getRawX();
                    }
                }
            }
            this.mIsBeingDragged = false;
        } else {
            this.mInitialMotionY = ev5.getY();
            this.mInitialMotionX = ev5.getX();
            this.mIsBeingDragged = false;
        }
        return this.mIsBeingDragged;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0016, code lost:
    
        if (r1 != 3) goto L24;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int pointerCount = event.getPointerCount();
        int action = event.getAction();
        boolean z16 = false;
        if (action != 1) {
            if (action == 2) {
                if (pointerCount == 1) {
                    if (!this.mIsBeingDragged) {
                        float y16 = event.getY();
                        float x16 = event.getX();
                        if (Math.abs(this.mInitialMotionY - y16) > this.mTouchSlop || Math.abs(this.mInitialMotionX - x16) > this.mTouchSlop) {
                            z16 = true;
                        }
                        this.mIsBeingDragged = z16;
                        if (z16) {
                            this.mInitialMotionY = event.getRawY();
                            this.mInitialMotionX = event.getRawX();
                        }
                    } else {
                        u((int) (event.getRawX() - this.mInitialMotionX), (int) (event.getRawY() - this.mInitialMotionY));
                    }
                }
            }
            return this.mIsBeingDragged;
        }
        if (this.mIsBeingDragged) {
            this.mIsBeingDragged = false;
            t(true, this.mCanFreeDrag);
        }
        return this.mIsBeingDragged;
    }

    public final void p(final int newLeft, final int newTop) {
        final WindowManager.LayoutParams layoutParams;
        boolean z16;
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        if (layoutParams2 instanceof WindowManager.LayoutParams) {
            layoutParams = (WindowManager.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        boolean z17 = true;
        if (layoutParams != null && newLeft == layoutParams.x) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (layoutParams == null || newTop != layoutParams.y) {
                z17 = false;
            }
            if (z17) {
                return;
            }
        }
        ValueAnimator valueAnimator = this.mDragEndAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mDragEndAnimator;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
            this.mDragEndAnimator = null;
        }
        if (layoutParams != null) {
            layoutParams.gravity = 17;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mDragEndAnimator = ofFloat;
            Intrinsics.checkNotNull(ofFloat);
            ofFloat.setTarget(this);
            ValueAnimator valueAnimator3 = this.mDragEndAnimator;
            Intrinsics.checkNotNull(valueAnimator3);
            valueAnimator3.setDuration(200L);
            final int i3 = layoutParams.x;
            final int i16 = layoutParams.y;
            ValueAnimator valueAnimator4 = this.mDragEndAnimator;
            Intrinsics.checkNotNull(valueAnimator4);
            valueAnimator4.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: vh4.a
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator5) {
                    FloatWindowContainer.q(layoutParams, i3, newLeft, i16, newTop, this, valueAnimator5);
                }
            });
            ValueAnimator valueAnimator5 = this.mDragEndAnimator;
            Intrinsics.checkNotNull(valueAnimator5);
            valueAnimator5.addListener(new c());
            ValueAnimator valueAnimator6 = this.mDragEndAnimator;
            Intrinsics.checkNotNull(valueAnimator6);
            valueAnimator6.start();
        }
    }

    public final void setDragListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.mFloatingViewTouchCallback = listener;
    }

    public final void setFloatShowing(boolean z16) {
        this.floatShowing = z16;
    }

    public final void setHorizontal(boolean z16) {
        this.isHorizontal = z16;
    }

    public final void setRoundCorner(@Nullable View floatingWidgetWrapper, @Nullable View customView, int roundCorner) {
        if (roundCorner > 0) {
            if (floatingWidgetWrapper != null) {
                y(floatingWidgetWrapper, roundCorner);
            }
            if (customView != null) {
                y(customView, roundCorner);
            }
            y(this, roundCorner);
        }
    }

    public final boolean v() {
        if (!this.floatShowing) {
            return false;
        }
        this.floatShowing = false;
        setVisibility(8);
        e();
        w();
        this.mFloatWindowLayoutParams = null;
        z();
        removeAllViews();
        this.mNewFloatParams = null;
        return true;
    }

    public final void w() {
        try {
            WindowManager windowManager = this.mWindowManager;
            if (windowManager != null) {
                Intrinsics.checkNotNull(windowManager);
                windowManager.removeView(this);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public final void x() {
        List<? extends FloatPosFixHelper.FloatPosItem> mutableListOf;
        uh4.c cVar = this.mFloatParams;
        if (cVar != null) {
            FloatPosFixHelper.FloatPosItem h16 = h(cVar.getMFloatingCenterX(), cVar.getMFloatingCenterY());
            d.Companion companion = d.INSTANCE;
            companion.a().j(h16);
            d a16 = companion.a();
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(h16);
            a16.m(mutableListOf, true);
        }
    }

    public final void z() {
        ValueAnimator valueAnimator = this.mDragEndAnimator;
        if (valueAnimator != null) {
            Intrinsics.checkNotNull(valueAnimator);
            if (valueAnimator.isRunning()) {
                ValueAnimator valueAnimator2 = this.mDragEndAnimator;
                Intrinsics.checkNotNull(valueAnimator2);
                valueAnimator2.cancel();
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatWindowContainer(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ FloatWindowContainer(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public FloatWindowContainer(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mTouchSlop = 20;
        this.mContext = context;
        Object systemService = context.getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        WindowManager windowManager = (WindowManager) systemService;
        this.mWindowManager = windowManager;
        if (windowManager != null) {
            this.mScreenHeight = windowManager.getDefaultDisplay().getHeight();
            this.mScreenWidth = windowManager.getDefaultDisplay().getWidth();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            this.mWindowType = 2038;
        } else {
            this.mWindowType = 2002;
        }
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    public void setOnDragListener(@Nullable xh4.b onDragListener) {
    }
}
