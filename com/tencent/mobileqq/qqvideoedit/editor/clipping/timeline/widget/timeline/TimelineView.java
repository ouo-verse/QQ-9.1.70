package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline;

import android.content.Context;
import android.util.AttributeSet;
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
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import uj2.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 g2\u00020\u0001:\u0001hB'\b\u0007\u0012\u0006\u0010a\u001a\u00020`\u0012\n\b\u0002\u0010c\u001a\u0004\u0018\u00010b\u0012\b\b\u0002\u0010d\u001a\u00020\u0018\u00a2\u0006\u0004\be\u0010fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0004J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u000fH\u0014J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u000e\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015J\u0010\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0016J\u0010\u0010 \u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u0018H\u0015J\b\u0010!\u001a\u00020\u0018H\u0014J\u0010\u0010#\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0018H\u0005J\u0010\u0010$\u001a\u00020\"2\u0006\u0010\u001e\u001a\u00020\u0018H\u0005J\u0010\u0010'\u001a\u00020\u00022\b\u0010&\u001a\u0004\u0018\u00010%J\b\u0010(\u001a\u0004\u0018\u00010\u001fJ\u0012\u0010+\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)H\u0016J\u0012\u0010-\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010,H\u0016R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R$\u00108\u001a\u0004\u0018\u00010\"8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R$\u0010<\u001a\u0004\u0018\u00010\"8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b9\u00103\u001a\u0004\b:\u00105\"\u0004\b;\u00107R\u0018\u0010?\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010C\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0018\u0010&\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\"\u0010L\u001a\u00020\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020\u00188EX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bM\u0010NR\u0014\u0010Q\u001a\u00020\u00188DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bP\u0010NR\u0014\u0010S\u001a\u00020\u00188DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bR\u0010NR\u0014\u0010U\u001a\u00020\u00188TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bT\u0010NR\u0014\u0010W\u001a\u00020\u00188EX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bV\u0010NR\u0014\u0010Y\u001a\u00020\u00188EX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\bX\u0010NR\u0014\u0010[\u001a\u00020\u00188TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\bZ\u0010NR\u0014\u0010]\u001a\u00020\u00188DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\\\u0010NR\u0014\u0010_\u001a\u00020\u00188DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b^\u0010N\u00a8\u0006i"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/TimelineView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "Z0", ICustomDataEditor.STRING_ARRAY_PARAM_1, "b1", "d1", "c1", "C0", "B0", "D0", "E0", "F0", "z0", "A0", "", "rawX", "V0", "moveX", "W0", "X0", "", "isLeft", "Y0", "", "visibility", "setSliderViewVisibility", "selected", "f1", "setSelected", "id", "Landroid/view/ViewGroup;", "G0", "K0", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;", "H0", "I0", "Luj2/b;", "timelineListener", "setTimelineListener", "M0", "Landroid/view/View$OnLongClickListener;", "l", "setOnLongClickListener", "Landroid/view/View$OnClickListener;", "setOnClickListener", "Landroidx/constraintlayout/widget/ConstraintSet;", "d", "Landroidx/constraintlayout/widget/ConstraintSet;", "constraintSet", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;", "Q0", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;", "setLeftSliderView", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/SliderView;)V", "leftSliderView", "f", "getRightSliderView", "setRightSliderView", "rightSliderView", h.F, "Landroid/view/ViewGroup;", "contentView", "Landroidx/constraintlayout/widget/Group;", "i", "Landroidx/constraintlayout/widget/Group;", VipFunCallConstants.KEY_GROUP, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Luj2/b;", BdhLogUtil.LogTag.Tag_Conn, "Z", "e1", "()Z", "setFixedLayout", "(Z)V", "isFixedLayout", "N0", "()I", "contentViewId", "O0", "contentWidth", "J0", "contentHeight", "L0", "contentPadding", "R0", "leftSliderViewId", "S0", "rightSliderViewId", "U0", "sliderWidth", "T0", "sliderHeight", "P0", "frameHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "D", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class TimelineView extends ConstraintLayout {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isFixedLayout;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintSet constraintSet;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SliderView leftSliderView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SliderView rightSliderView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewGroup contentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Group group;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private uj2.b timelineListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/TimelineView$b", "Luj2/a;", "", "rawX", "", "b", "moveX", "c", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements a {
        b() {
        }

        @Override // uj2.a
        public void a() {
            TimelineView.this.Y0(true);
        }

        @Override // uj2.a
        public void b(float rawX) {
            TimelineView.this.V0(rawX);
        }

        @Override // uj2.a
        public void c(float moveX) {
            TimelineView.this.W0(moveX);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/TimelineView$c", "Luj2/a;", "", "rawX", "", "b", "moveX", "c", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class c implements a {
        c() {
        }

        @Override // uj2.a
        public void a() {
            TimelineView.this.Y0(false);
        }

        @Override // uj2.a
        public void b(float rawX) {
            TimelineView.this.V0(rawX);
        }

        @Override // uj2.a
        public void c(float moveX) {
            TimelineView.this.X0(moveX);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelineView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A0() {
        SliderView I0 = I0(S0());
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
            this.constraintSet.connect(viewGroup.getId(), 6, 0, 6, U0());
            this.constraintSet.connect(viewGroup.getId(), 3, 0, 3);
            this.constraintSet.connect(viewGroup.getId(), 7, 0, 7, U0());
            this.constraintSet.connect(viewGroup.getId(), 4, 0, 4);
        }
    }

    private final void E0() {
        int i3;
        SliderView sliderView = this.leftSliderView;
        if (sliderView != null) {
            this.constraintSet.constrainWidth(sliderView.getId(), e.f384236a.a(12.0f));
            this.constraintSet.constrainHeight(sliderView.getId(), T0());
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
        int i3;
        SliderView sliderView = this.rightSliderView;
        if (sliderView != null) {
            this.constraintSet.constrainWidth(sliderView.getId(), e.f384236a.a(12.0f));
            this.constraintSet.constrainHeight(sliderView.getId(), T0());
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

    private final void Z0() {
        a1();
        C0();
        c1();
    }

    private final void a1() {
        b1();
        d1();
    }

    private final void b1() {
        ViewGroup G0 = G0(N0());
        addView(G0);
        this.contentView = G0;
    }

    private final void c1() {
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

    private final void d1() {
        z0();
        A0();
    }

    private final void z0() {
        SliderView H0 = H0(R0());
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
        sliderView.setImageResource(R.drawable.nh7);
        return sliderView;
    }

    @MainThread
    @NotNull
    protected final SliderView I0(int id5) {
        SliderView sliderView = new SliderView(getContext(), null, 0, 6, null);
        sliderView.setId(id5);
        sliderView.setImageResource(R.drawable.nh8);
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
        return getResources().getDimensionPixelOffset(R.dimen.de_);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: Q0, reason: from getter */
    public final SliderView getLeftSliderView() {
        return this.leftSliderView;
    }

    @IdRes
    protected final int R0() {
        return R.id.f97485ki;
    }

    @IdRes
    protected final int S0() {
        return R.id.f97505kk;
    }

    protected final int T0() {
        return e.f384236a.a(47.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int U0() {
        return e.f384236a.a(16.0f);
    }

    protected final void V0(float rawX) {
        getParent().requestDisallowInterceptTouchEvent(true);
        uj2.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.f(rawX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void W0(float moveX) {
        uj2.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.a(moveX, true);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void X0(float moveX) {
        uj2.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.a(moveX, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Y0(boolean isLeft) {
        getParent().requestDisallowInterceptTouchEvent(false);
        uj2.b bVar = this.timelineListener;
        if (bVar != null) {
            bVar.i(isLeft);
        }
    }

    /* renamed from: e1, reason: from getter */
    public final boolean getIsFixedLayout() {
        return this.isFixedLayout;
    }

    public final void f1(boolean selected) {
        if (selected) {
            setBackgroundResource(R.drawable.kvo);
        } else {
            setBackgroundResource(R.drawable.kvn);
        }
        ViewGroup viewGroup = this.contentView;
        if (viewGroup != null) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            marginLayoutParams.topMargin = P0();
            marginLayoutParams.bottomMargin = P0();
        }
    }

    public final void setFixedLayout(boolean z16) {
        this.isFixedLayout = z16;
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
    }

    public final void setSliderViewVisibility(int visibility) {
        Group group = this.group;
        if (group != null) {
            group.setVisibility(visibility);
        }
    }

    public final void setTimelineListener(@Nullable uj2.b timelineListener) {
        this.timelineListener = timelineListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ TimelineView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.constraintSet = new ConstraintSet();
        Z0();
    }
}
