package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.videocut.utils.e;
import g63.CommonConfig;
import g63.LayoutConfig;
import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 <2\u00020\u0001:\u0001=B'\b\u0007\u0012\u0006\u00105\u001a\u000204\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u000106\u0012\b\b\u0002\u00109\u001a\u000208\u00a2\u0006\u0004\b:\u0010;J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u000b\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0006H\u0017J\u0012\u0010\f\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001b\u0010!\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001b\u0010&\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010%R\u001b\u0010*\u001a\u00020\r8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010\u001e\u001a\u0004\b(\u0010)R\"\u00101\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b2\u00103\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Landroid/view/ScaleGestureDetector;", "detector", "", "I0", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "event", "onTouchEvent", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Landroid/view/View;", "view", "C0", "Lg63/b;", "layoutConfig", "J0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "controller", "D0", "d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanelViewController;", "timelinePanelViewController", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "e", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "onScaleGestureListener", "f", "Lkotlin/Lazy;", "H0", "()Landroid/view/ScaleGestureDetector;", "scaleGestureDetector", "Landroid/widget/LinearLayout;", h.F, "E0", "()Landroid/widget/LinearLayout;", "contentLayout", "i", "F0", "()Landroid/view/View;", "cursorView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "getEnableScale", "()Z", "setEnableScale", "(Z)V", "enableScale", "G0", "()Lg63/b;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class TimelinePanel extends ConstraintLayout {

    @NotNull
    public Map<Integer, View> C;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TimelinePanelViewController timelinePanelViewController;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy scaleGestureDetector;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy contentLayout;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy cursorView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean enableScale;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/TimelinePanel$b", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "Landroid/view/ScaleGestureDetector;", "detector", "", "onScale", "onScaleBegin", "", "onScaleEnd", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ScaleGestureDetector.OnScaleGestureListener {
        b() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(@NotNull ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            TimelinePanelViewController timelinePanelViewController = TimelinePanel.this.timelinePanelViewController;
            if (timelinePanelViewController != null) {
                timelinePanelViewController.t(detector.getScaleFactor());
                return true;
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(@NotNull ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(@NotNull ScaleGestureDetector detector) {
            Intrinsics.checkNotNullParameter(detector, "detector");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelinePanel(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final LinearLayout E0() {
        return (LinearLayout) this.contentLayout.getValue();
    }

    private final LayoutConfig G0() {
        CommonConfig commonConfig;
        TimelinePanelViewController timelinePanelViewController = this.timelinePanelViewController;
        if (timelinePanelViewController != null && (commonConfig = timelinePanelViewController.getCom.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String()) != null) {
            return commonConfig.getLayoutConfig();
        }
        return null;
    }

    private final ScaleGestureDetector H0() {
        return (ScaleGestureDetector) this.scaleGestureDetector.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I0(final ScaleGestureDetector detector) {
        com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.b.a(detector, "mMinSpan", new Function1<Field, Unit>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel$hookMinSpan$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Field field) {
                invoke2(field);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Field it) {
                Intrinsics.checkNotNullParameter(it, "it");
                it.set(detector, 0);
            }
        });
    }

    public final void C0(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        E0().addView(view);
    }

    public final void D0(@NotNull TimelinePanelViewController controller) {
        Intrinsics.checkNotNullParameter(controller, "controller");
        this.timelinePanelViewController = controller;
    }

    @NotNull
    public final View F0() {
        return (View) this.cursorView.getValue();
    }

    public final void J0(@NotNull LayoutConfig layoutConfig) {
        Intrinsics.checkNotNullParameter(layoutConfig, "layoutConfig");
        View F0 = F0();
        e eVar = e.f384236a;
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(eVar.a(layoutConfig.j()), eVar.a(layoutConfig.h()));
        layoutParams.leftToLeft = 0;
        layoutParams.rightToRight = 0;
        layoutParams.topToTop = 0;
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = eVar.a(layoutConfig.getCourseTopMargin());
        F0.setLayoutParams(layoutParams);
        F0.setElevation(eVar.a(layoutConfig.g()));
        Drawable drawable = F0.getResources().getDrawable(R.drawable.f162675m34);
        if (drawable != null) {
            drawable.setColorFilter(layoutConfig.getCourseColor(), PorterDuff.Mode.SRC_ATOP);
        }
        if (drawable != null) {
            F0.setBackgroundDrawable(drawable);
        } else {
            F0.setBackgroundColor(layoutConfig.getCourseColor());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        TimelinePanelViewController timelinePanelViewController = this.timelinePanelViewController;
        if (timelinePanelViewController != null) {
            timelinePanelViewController.D(ev5);
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        int i3;
        if (ev5 != null) {
            i3 = ev5.getPointerCount();
        } else {
            i3 = 0;
        }
        if (i3 > 1) {
            return true;
        }
        return super.onInterceptTouchEvent(ev5);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        if (this.enableScale) {
            H0().onTouchEvent(event);
            return true;
        }
        return super.onTouchEvent(event);
    }

    public final void setEnableScale(boolean z16) {
        this.enableScale = z16;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelinePanel(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelinePanel(@NotNull final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Intrinsics.checkNotNullParameter(context, "context");
        this.C = new LinkedHashMap();
        this.onScaleGestureListener = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ScaleGestureDetector>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel$scaleGestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ScaleGestureDetector invoke() {
                ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener;
                Context context2 = context;
                onScaleGestureListener = this.onScaleGestureListener;
                ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(context2, onScaleGestureListener);
                this.I0(scaleGestureDetector);
                return scaleGestureDetector;
            }
        });
        this.scaleGestureDetector = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<LinearLayout>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel$contentLayout$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LinearLayout invoke() {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                linearLayout.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -1));
                return linearLayout;
            }
        });
        this.contentLayout = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.TimelinePanel$cursorView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final View invoke() {
                View view = new View(context);
                view.setBackgroundColor(-1);
                ViewCompat.setElevation(view, e.f384236a.a(3.0f));
                return view;
            }
        });
        this.cursorView = lazy3;
        this.enableScale = true;
        addView(E0());
        addView(F0());
        LayoutConfig G0 = G0();
        J0(G0 == null ? new LayoutConfig(0, 0.0f, 0.0f, 0.0f, 0.0f, 0, 63, null) : G0);
    }

    public /* synthetic */ TimelinePanel(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
