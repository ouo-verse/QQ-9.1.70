package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.IdRes;
import androidx.annotation.MainThread;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Group;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.videocut.utils.e;
import java.util.LinkedHashMap;
import java.util.Map;
import k63.a;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 _2\u00020\u0001:\u0001`B1\b\u0007\u0012\u0006\u0010Y\u001a\u00020X\u0012\n\b\u0002\u0010[\u001a\u0004\u0018\u00010Z\u0012\b\b\u0002\u0010\\\u001a\u00020\u001c\u0012\b\b\u0002\u00103\u001a\u00020\u001c\u00a2\u0006\u0004\b]\u0010^J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\u0010\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0013H\u0014J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u000fH\u0014J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001cH\u0015J\b\u0010 \u001a\u00020\u001cH\u0014J\u0010\u0010\"\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001cH\u0005J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001d\u001a\u00020\u001cH\u0005J\u0010\u0010&\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$J\b\u0010'\u001a\u0004\u0018\u00010\u001eJ\u0012\u0010*\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010,\u001a\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010+H\u0016R\"\u00103\u001a\u00020\u001c8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010<\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u00109R\u0018\u0010?\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010%\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0014\u0010G\u001a\u00020\u001c8EX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bF\u00100R\u0014\u0010I\u001a\u00020\u001c8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bH\u00100R\u0014\u0010K\u001a\u00020\u001c8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bJ\u00100R\u0014\u0010M\u001a\u00020\u001c8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bL\u00100R\u0014\u0010O\u001a\u00020\u001c8EX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bN\u00100R\u0014\u0010Q\u001a\u00020\u001c8EX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u00100R\u0014\u0010S\u001a\u00020\u001c8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u00100R\u0014\u0010U\u001a\u00020\u001c8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u00100R\u0014\u0010W\u001a\u00020\u001c8DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u00100\u00a8\u0006a"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/TimelineView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Y0", "Z0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "c1", "b1", "C0", "B0", "D0", "E0", "F0", "z0", "A0", "", "selected", "e1", "d1", "", "rawX", "U0", "moveX", "V0", "W0", "isLeft", "X0", "setSelected", "", "id", "Landroid/view/ViewGroup;", "G0", "K0", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "H0", "I0", "Lk63/b;", "timelineListener", "setTimelineListener", "M0", "Landroid/view/View$OnLongClickListener;", "l", "setOnLongClickListener", "Landroid/view/View$OnClickListener;", "setOnClickListener", "d", "I", "getSelectedStyle", "()I", "setSelectedStyle", "(I)V", "selectedStyle", "Landroidx/constraintlayout/widget/ConstraintSet;", "e", "Landroidx/constraintlayout/widget/ConstraintSet;", "constraintSet", "f", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/SliderView;", "leftSliderView", h.F, "rightSliderView", "i", "Landroid/view/ViewGroup;", "contentView", "Landroidx/constraintlayout/widget/Group;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/constraintlayout/widget/Group;", VipFunCallConstants.KEY_GROUP, BdhLogUtil.LogTag.Tag_Conn, "Lk63/b;", "N0", "contentViewId", "O0", "contentWidth", "J0", "contentHeight", "L0", "contentPadding", "Q0", "leftSliderViewId", "R0", "rightSliderViewId", "T0", "sliderWidth", "S0", "sliderHeight", "P0", "frameHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "E", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class TimelineView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private k63.b timelineListener;

    @NotNull
    public Map<Integer, View> D;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int selectedStyle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintSet constraintSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SliderView leftSliderView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SliderView rightSliderView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup contentView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Group group;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/TimelineView$b", "Lk63/a;", "", "rawX", "", "b", "Landroid/view/MotionEvent;", "event", "moveX", "c", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements a {
        b() {
        }

        @Override // k63.a
        public void a() {
            TimelineView.this.X0(true);
        }

        @Override // k63.a
        public void b(float rawX) {
            TimelineView.this.U0(rawX);
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            Intrinsics.checkNotNullParameter(event, "event");
            TimelineView.this.V0(moveX);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/TimelineView$c", "Lk63/a;", "", "rawX", "", "b", "Landroid/view/MotionEvent;", "event", "moveX", "c", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements a {
        c() {
        }

        @Override // k63.a
        public void a() {
            TimelineView.this.X0(false);
        }

        @Override // k63.a
        public void b(float rawX) {
            TimelineView.this.U0(rawX);
        }

        @Override // k63.a
        public void c(@NotNull MotionEvent event, float moveX) {
            Intrinsics.checkNotNullParameter(event, "event");
            TimelineView.this.W0(moveX);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelineView(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A0() {
        SliderView I0 = I0(R0());
        I0.setSliderListener(new c());
        addView(I0);
        this.rightSliderView = I0;
    }

    private final void B0() {
        this.constraintSet.applyTo(this);
    }

    private final void C0() {
        D0();
        E0();
        F0();
        B0();
    }

    private final void D0() {
        ViewGroup viewGroup = this.contentView;
        if (viewGroup != null) {
            viewGroup.setPadding(L0(), 0, L0(), 0);
            this.constraintSet.constrainWidth(viewGroup.getId(), O0());
            this.constraintSet.constrainHeight(viewGroup.getId(), J0());
            this.constraintSet.connect(viewGroup.getId(), 6, 0, 6, T0());
            this.constraintSet.connect(viewGroup.getId(), 3, 0, 3);
            this.constraintSet.connect(viewGroup.getId(), 7, 0, 7, T0());
            this.constraintSet.connect(viewGroup.getId(), 4, 0, 4);
        }
    }

    private final void E0() {
        SliderView sliderView;
        int i3;
        if (!d1() && (sliderView = this.leftSliderView) != null) {
            this.constraintSet.constrainWidth(sliderView.getId(), e.f384236a.a(12.0f));
            this.constraintSet.constrainHeight(sliderView.getId(), S0());
            this.constraintSet.connect(sliderView.getId(), 6, 0, 6);
            ConstraintSet constraintSet = this.constraintSet;
            int id5 = sliderView.getId();
            ViewGroup viewGroup = this.contentView;
            if (viewGroup != null) {
                i3 = viewGroup.getId();
            } else {
                i3 = 0;
            }
            constraintSet.connect(id5, 7, i3, 6);
            this.constraintSet.connect(sliderView.getId(), 3, 0, 3);
            this.constraintSet.connect(sliderView.getId(), 4, 0, 4);
            sliderView.setOnClickListener(null);
        }
    }

    private final void F0() {
        SliderView sliderView;
        int i3;
        if (!d1() && (sliderView = this.rightSliderView) != null) {
            this.constraintSet.constrainWidth(sliderView.getId(), e.f384236a.a(12.0f));
            this.constraintSet.constrainHeight(sliderView.getId(), S0());
            this.constraintSet.connect(sliderView.getId(), 3, 0, 3);
            this.constraintSet.connect(sliderView.getId(), 7, 0, 7);
            ConstraintSet constraintSet = this.constraintSet;
            int id5 = sliderView.getId();
            ViewGroup viewGroup = this.contentView;
            if (viewGroup != null) {
                i3 = viewGroup.getId();
            } else {
                i3 = 0;
            }
            constraintSet.connect(id5, 6, i3, 7);
            this.constraintSet.connect(sliderView.getId(), 4, 0, 4);
            sliderView.setOnClickListener(null);
        }
    }

    private final void Y0() {
        Z0();
        C0();
        b1();
    }

    private final void Z0() {
        a1();
        c1();
    }

    private final void a1() {
        ViewGroup G0 = G0(N0());
        addView(G0);
        this.contentView = G0;
    }

    private final void b1() {
        int i3;
        Group group = new Group(getContext());
        group.setId(R.id.f97465kg);
        this.group = group;
        int[] iArr = new int[2];
        SliderView sliderView = this.leftSliderView;
        int i16 = 0;
        if (sliderView != null) {
            i3 = sliderView.getId();
        } else {
            i3 = 0;
        }
        iArr[0] = i3;
        SliderView sliderView2 = this.rightSliderView;
        if (sliderView2 != null) {
            i16 = sliderView2.getId();
        }
        iArr[1] = i16;
        group.setReferencedIds(iArr);
        addView(this.group);
        group.setVisibility(8);
    }

    private final void c1() {
        z0();
        A0();
    }

    private final boolean d1() {
        if (this.selectedStyle == 1) {
            return true;
        }
        return false;
    }

    private final void e1(boolean selected) {
        int i3 = 0;
        if (selected) {
            setBackgroundResource(R.drawable.f162674m33);
            ViewGroup viewGroup = this.contentView;
            if (viewGroup != null) {
                ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                marginLayoutParams.topMargin = P0();
                marginLayoutParams.bottomMargin = P0();
            }
        } else {
            setBackgroundColor(getResources().getColor(R.color.cto));
            ViewGroup viewGroup2 = this.contentView;
            if (viewGroup2 != null) {
                ViewGroup.LayoutParams layoutParams2 = viewGroup2.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams2;
                marginLayoutParams2.topMargin = 0;
                marginLayoutParams2.bottomMargin = 0;
            }
        }
        if (this.selectedStyle == 0) {
            Group group = this.group;
            if (group != null) {
                if (!selected) {
                    i3 = 8;
                }
                group.setVisibility(i3);
                return;
            }
            return;
        }
        Group group2 = this.group;
        if (group2 != null) {
            group2.setVisibility(8);
        }
    }

    private final void z0() {
        SliderView H0 = H0(Q0());
        H0.setSliderListener(new b());
        addView(H0);
        this.leftSliderView = H0;
    }

    @MainThread
    @NotNull
    protected ViewGroup G0(int id5) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ContentView contentView = new ContentView(context, null, 0, 6, null);
        contentView.setId(id5);
        return contentView;
    }

    @MainThread
    @NotNull
    protected final SliderView H0(int id5) {
        SliderView sliderView = new SliderView(getContext(), null, 0, 6, null);
        sliderView.setId(id5);
        sliderView.setContentDescription("\u5de6\u6ed1\u5757");
        sliderView.setImageResource(R.drawable.onw);
        return sliderView;
    }

    @MainThread
    @NotNull
    protected final SliderView I0(int id5) {
        SliderView sliderView = new SliderView(getContext(), null, 0, 6, null);
        sliderView.setId(id5);
        sliderView.setContentDescription("\u53f3\u6ed1\u5757");
        sliderView.setImageResource(R.drawable.onx);
        return sliderView;
    }

    protected final int J0() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int K0() {
        return getResources().getDimensionPixelOffset(R.dimen.ded);
    }

    protected int L0() {
        return getResources().getDimensionPixelOffset(R.dimen.de9);
    }

    @Nullable
    /* renamed from: M0, reason: from getter */
    public final ViewGroup getContentView() {
        return this.contentView;
    }

    @IdRes
    protected final int N0() {
        return R.id.f97455kf;
    }

    protected final int O0() {
        return 0;
    }

    protected final int P0() {
        if (d1()) {
            return e.f384236a.a(2.0f);
        }
        return e.f384236a.a(2.0f);
    }

    @IdRes
    protected final int Q0() {
        return R.id.f97485ki;
    }

    @IdRes
    protected final int R0() {
        return R.id.f97505kk;
    }

    protected final int S0() {
        return e.f384236a.a(50.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int T0() {
        if (d1()) {
            return e.f384236a.a(2.0f);
        }
        return e.f384236a.a(16.0f);
    }

    protected final void U0(float rawX) {
        getParent().requestDisallowInterceptTouchEvent(true);
        k63.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.f(rawX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void V0(float moveX) {
        k63.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.a(moveX, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0(float moveX) {
        k63.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.a(moveX, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X0(boolean isLeft) {
        getParent().requestDisallowInterceptTouchEvent(false);
        k63.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.i(isLeft);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(@Nullable View.OnClickListener l3) {
        ViewGroup viewGroup = this.contentView;
        if (viewGroup != null) {
            viewGroup.setOnClickListener(l3);
        }
    }

    @Override // android.view.View
    public void setOnLongClickListener(@Nullable View.OnLongClickListener l3) {
        ViewGroup viewGroup = this.contentView;
        if (viewGroup != null) {
            viewGroup.setOnLongClickListener(l3);
        }
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        e1(selected);
    }

    public final void setSelectedStyle(int i3) {
        this.selectedStyle = i3;
    }

    public final void setTimelineListener(@Nullable k63.b timelineListener) {
        this.timelineListener = timelineListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, 0, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, int i16) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.D = new LinkedHashMap();
        this.selectedStyle = i16;
        this.constraintSet = new ConstraintSet();
        Y0();
    }

    public /* synthetic */ TimelineView(Context context, AttributeSet attributeSet, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i17 & 2) != 0 ? null : attributeSet, (i17 & 4) != 0 ? 0 : i3, (i17 & 8) != 0 ? 0 : i16);
    }
}
