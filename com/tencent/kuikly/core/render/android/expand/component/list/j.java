package com.tencent.kuikly.core.render.android.expand.component.list;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.util.Property;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.DecelerateInterpolator;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.hippypager.HippyPagerPageChangeListener;
import com.tencent.mtt.hippy.views.waterfalllist.WaterFallComponentName;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0002\n0B'\u0012\u0006\u0010X\u001a\u00020V\u0012\u0006\u0010[\u001a\u00020Y\u0012\u0006\u0010\\\u001a\u00020\u0006\u0012\u0006\u0010_\u001a\u00020]\u00a2\u0006\u0004\b`\u0010aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u0015\u001a\u00020\u00142\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0017\u001a\u00020\u0014H\u0002J\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u001b\u001a\u00020\u0014H\u0002J\u0018\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001f\u001a\u00020\u0006H\u0002J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010!\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0018\u0010%\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004H\u0002J\u0018\u0010&\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0004H\u0002J\u000e\u0010'\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010(\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010)\u001a\u00020\u0006J\u0006\u0010*\u001a\u00020\u0014J\u0006\u0010+\u001a\u00020\u0006R\u001c\u0010/\u001a\b\u0012\u0004\u0012\u00020-0,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010.R\u0016\u00101\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010\u0015R\u0016\u00104\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00107R\u0016\u00109\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u00107R$\u0010?\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010C\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u00103\u001a\u0004\b@\u0010A\"\u0004\b7\u0010BR\"\u0010F\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u00103\u001a\u0004\bD\u0010A\"\u0004\bE\u0010BR\"\u0010K\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u00107\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010N\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u00107\u001a\u0004\bL\u0010H\"\u0004\bM\u0010JR\u0016\u0010O\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u00103R\u0014\u0010P\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010\u0015R\u001e\u0010T\u001a\n R*\u0004\u0018\u00010Q0Q8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010SR\u0016\u0010U\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010\u0015R\u0014\u0010X\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010WR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010ZR\u0014\u0010\\\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u00103R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010^\u00a8\u0006b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/j;", "", "", "activeIndex", "Landroid/view/MotionEvent;", "event", "", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "a", "", "offset", "currentTranslation", "v", "u", "t", "B", "Lcom/tencent/kuikly/core/render/android/expand/component/list/e;", WaterFallComponentName.PROPERTY_CONTENT_INSET, "", "I", "g", "K", "viewContentInset", "j", "E", "f", "offsetX", "offsetY", tl.h.F, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "H", "motionEvent", "L", "i", "w", "e", HippyTKDListViewAdapter.X, BdhLogUtil.LogTag.Tag_Conn, ReportConstant.COSTREPORT_PREFIX, "Landroid/util/SparseArray;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/j$b;", "Landroid/util/SparseArray;", "pointerDataMap", "b", "touchSlop", "c", "Z", HippyPagerPageChangeListener.DRAGGING, "d", "downing", UserInfo.SEX_FEMALE, "initX", "initY", "Lcom/tencent/kuikly/core/render/android/expand/component/list/e;", "getContentInsetWhenEndDrag", "()Lcom/tencent/kuikly/core/render/android/expand/component/list/e;", "D", "(Lcom/tencent/kuikly/core/render/android/expand/component/list/e;)V", "contentInsetWhenEndDrag", "k", "()Z", "(Z)V", "forceOverScroll", "p", "G", "overScrolling", DomainData.DOMAIN_NAME, "()F", "setOverScrollX", "(F)V", "overScrollX", "o", "setOverScrollY", "overScrollY", "hadBeginDrag", "maxFlingVelocity", "Landroid/view/VelocityTracker;", "kotlin.jvm.PlatformType", "Landroid/view/VelocityTracker;", "velocityTracker", "scrollPointerId", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "recyclerView", "Landroid/view/View;", "Landroid/view/View;", "contentView", "isVertical", "Lcom/tencent/kuikly/core/render/android/expand/component/list/i;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/i;", "overScrollEventCallback", "<init>", "(Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;Landroid/view/View;ZLcom/tencent/kuikly/core/render/android/expand/component/list/i;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private SparseArray<PointerData> pointerDataMap;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean dragging;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean downing;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float initX;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float initY;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private e contentInsetWhenEndDrag;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean forceOverScroll;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean overScrolling;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private float overScrollX;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private float overScrollY;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private boolean hadBeginDrag;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final int maxFlingVelocity;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private VelocityTracker velocityTracker;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private int scrollPointerId;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final KRRecyclerView recyclerView;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final View contentView;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final boolean isVertical;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final i overScrollEventCallback;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\b\u0082\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u0015J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\"\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\t\u0010\u0011\"\u0004\b\u000f\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/j$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "getPointerId", "()I", "pointerId", "", "b", UserInfo.SEX_FEMALE, "()F", "(F)V", "offset", "<init>", "(IF)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.kuikly.core.render.android.expand.component.list.j$b, reason: from toString */
    /* loaded from: classes7.dex */
    public static final /* data */ class PointerData {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final int pointerId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private float offset;

        public PointerData(int i3, float f16) {
            this.pointerId = i3;
            this.offset = f16;
        }

        /* renamed from: a, reason: from getter */
        public final float getOffset() {
            return this.offset;
        }

        public final void b(float f16) {
            this.offset = f16;
        }

        public boolean equals(@Nullable Object other) {
            if (this != other) {
                if (other instanceof PointerData) {
                    PointerData pointerData = (PointerData) other;
                    if (this.pointerId != pointerData.pointerId || Float.compare(this.offset, pointerData.offset) != 0) {
                        return false;
                    }
                    return true;
                }
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (this.pointerId * 31) + Float.floatToIntBits(this.offset);
        }

        @NotNull
        public String toString() {
            return "PointerData(pointerId=" + this.pointerId + ", offset=" + this.offset + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/kuikly/core/render/android/expand/component/list/j$c", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "", "onAnimationCancel", "onAnimationEnd", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ float f117949e;

        c(float f16) {
            this.f117949e = f16;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@Nullable Animator animation) {
            j.this.hadBeginDrag = false;
            j.this.G(false);
            j.this.g(this.f117949e);
            j.this.K();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@Nullable Animator animation) {
            super.onAnimationEnd(animation);
            j.this.hadBeginDrag = false;
            j.this.G(false);
            j.this.g(this.f117949e);
            j.this.K();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/animation/ValueAnimator;", "kotlin.jvm.PlatformType", "onAnimationUpdate"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes7.dex */
    public static final class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator it) {
            j jVar = j.this;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Object animatedValue = it.getAnimatedValue();
            Intrinsics.checkNotNullExpressionValue(animatedValue, "it.animatedValue");
            jVar.g(com.tencent.kuikly.core.render.android.css.ktx.b.H(animatedValue));
        }
    }

    public j(@NotNull KRRecyclerView recyclerView, @NotNull View contentView, boolean z16, @NotNull i overScrollEventCallback) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        Intrinsics.checkNotNullParameter(overScrollEventCallback, "overScrollEventCallback");
        this.recyclerView = recyclerView;
        this.contentView = contentView;
        this.isVertical = z16;
        this.overScrollEventCallback = overScrollEventCallback;
        this.pointerDataMap = new SparseArray<>();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(recyclerView.getContext());
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(recyclerView.context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        ViewConfiguration viewConfiguration2 = ViewConfiguration.get(recyclerView.getContext());
        Intrinsics.checkNotNullExpressionValue(viewConfiguration2, "ViewConfiguration.get(recyclerView.context)");
        this.maxFlingVelocity = viewConfiguration2.getScaledMaximumFlingVelocity();
        this.velocityTracker = VelocityTracker.obtain();
        this.scrollPointerId = -1;
    }

    private final boolean A(int activeIndex, MotionEvent event) {
        this.downing = true;
        this.scrollPointerId = event.getPointerId(activeIndex);
        L(activeIndex, event);
        return false;
    }

    private final boolean B(int activeIndex, MotionEvent event) {
        this.pointerDataMap.remove(event.getPointerId(activeIndex));
        return false;
    }

    private final void E(e viewContentInset) {
        float j3 = j(viewContentInset);
        if (this.isVertical) {
            this.contentView.setTranslationY(j3);
        } else {
            this.contentView.setTranslationX(j3);
        }
        g(j3);
    }

    private final void H(float offset) {
        if (this.isVertical) {
            View view = this.contentView;
            view.setTranslationY(view.getTranslationY() + offset);
        } else {
            View view2 = this.contentView;
            view2.setTranslationX(view2.getTranslationX() + offset);
        }
    }

    private final void I(e contentInset) {
        float translationX;
        Property property;
        float j3 = j(contentInset);
        if (this.isVertical) {
            translationX = this.contentView.getTranslationY();
        } else {
            translationX = this.contentView.getTranslationX();
        }
        if (this.isVertical) {
            property = View.TRANSLATION_Y;
        } else {
            property = View.TRANSLATION_X;
        }
        ObjectAnimator animator = ObjectAnimator.ofFloat(this.contentView, (Property<View, Float>) property, translationX, j3);
        Intrinsics.checkNotNullExpressionValue(animator, "animator");
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setDuration(250L);
        animator.addListener(new c(j3));
        animator.addUpdateListener(new d());
        animator.start();
    }

    static /* synthetic */ void J(j jVar, e eVar, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eVar = null;
        }
        jVar.I(eVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K() {
        Function0<Unit> c16;
        e eVar = this.contentInsetWhenEndDrag;
        if (eVar != null && (c16 = eVar.c()) != null) {
            c16.invoke();
        }
    }

    private final void L(int activeIndex, MotionEvent motionEvent) {
        int pointerId = motionEvent.getPointerId(activeIndex);
        float i3 = i(activeIndex, motionEvent);
        PointerData pointerData = this.pointerDataMap.get(pointerId);
        if (pointerData == null) {
            this.pointerDataMap.put(pointerId, new PointerData(pointerId, i3));
        } else {
            pointerData.b(i3);
        }
    }

    private final boolean a(MotionEvent event) {
        boolean z16;
        float x16 = event.getX() - this.initX;
        float y16 = event.getY() - this.initY;
        if (!this.isVertical && Math.abs(x16) > this.touchSlop && Math.abs(x16) > Math.abs(y16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.isVertical && Math.abs(y16) > this.touchSlop && Math.abs(y16) > Math.abs(x16)) {
            return true;
        }
        return z16;
    }

    private final void f() {
        this.overScrolling = true;
        this.overScrollX = this.contentView.getTranslationX();
        float translationY = this.contentView.getTranslationY();
        this.overScrollY = translationY;
        this.overScrollEventCallback.c(this.overScrollX, translationY, s(), this.dragging);
        this.hadBeginDrag = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void g(float offset) {
        float f16;
        boolean z16 = this.isVertical;
        if (z16) {
            f16 = 0.0f;
        } else {
            f16 = offset;
        }
        if (!z16) {
            offset = 0.0f;
        }
        h(f16, offset);
    }

    private final void h(float offsetX, float offsetY) {
        this.overScrollX = offsetX;
        this.overScrollY = offsetY;
        this.overScrollEventCallback.a(offsetX, offsetY, s(), this.dragging);
    }

    private final float i(int activeIndex, MotionEvent motionEvent) {
        if (this.isVertical) {
            return motionEvent.getY(activeIndex);
        }
        return motionEvent.getX(activeIndex);
    }

    private final float j(e viewContentInset) {
        float right;
        if (viewContentInset == null) {
            viewContentInset = this.contentInsetWhenEndDrag;
        }
        if (viewContentInset != null) {
            if (this.isVertical) {
                if (s()) {
                    return viewContentInset.getTop();
                }
                right = viewContentInset.getBottom();
            } else {
                if (s()) {
                    return viewContentInset.getLeft();
                }
                right = viewContentInset.getRight();
            }
            return -right;
        }
        return 0.0f;
    }

    private final float l(float currentTranslation, float offset) {
        return offset / (2 + (Math.abs(currentTranslation) / com.tencent.kuikly.core.render.android.css.ktx.b.I(this.recyclerView.get_kuiklyRenderContext(), 500.0f)));
    }

    private final float m(MotionEvent event) {
        int pointerCount = event.getPointerCount();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < pointerCount; i3++) {
            PointerData pointerData = this.pointerDataMap.get(event.getPointerId(i3));
            if (pointerData != null) {
                float i16 = i(i3, event);
                f16 += i16 - pointerData.getOffset();
                pointerData.b(i16);
            }
        }
        if (Math.abs(f16) <= this.touchSlop && !this.dragging) {
            return 0.0f;
        }
        return l(q(), f16);
    }

    private final float q() {
        if (this.isVertical) {
            return this.contentView.getTranslationY();
        }
        return this.contentView.getTranslationX();
    }

    private final boolean r() {
        if (this.isVertical) {
            if (this.recyclerView.canScrollVertically(1)) {
                return false;
            }
        } else if (this.recyclerView.canScrollHorizontally(1)) {
            return false;
        }
        return true;
    }

    private final boolean t(float offset, float currentTranslation) {
        if (!r()) {
            return false;
        }
        float f16 = 0;
        if (offset >= f16 && currentTranslation >= f16) {
            return false;
        }
        return true;
    }

    private final boolean u(float offset, float currentTranslation) {
        if (this.recyclerView.getLimitHeaderBounces() || !s()) {
            return false;
        }
        float f16 = 0;
        if (offset <= f16 && currentTranslation <= f16) {
            return false;
        }
        return true;
    }

    private final boolean v(float offset, float currentTranslation) {
        if (!u(offset, currentTranslation) && !t(offset, currentTranslation)) {
            return false;
        }
        return true;
    }

    private final boolean y(int activeIndex, MotionEvent event) {
        this.downing = true;
        L(activeIndex, event);
        if (this.forceOverScroll) {
            this.dragging = true;
            f();
        }
        this.initX = event.getX();
        this.initY = event.getY();
        this.velocityTracker.addMovement(event);
        return false;
    }

    private final boolean z(MotionEvent event) {
        if (!this.downing) {
            y(event.getActionIndex(), event);
        }
        boolean z16 = false;
        if (!a(event)) {
            this.velocityTracker.clear();
            return false;
        }
        float q16 = q();
        float m3 = m(event);
        if (m3 == 0.0f) {
            this.velocityTracker.clear();
            return false;
        }
        if (v(m3, q16)) {
            H(m3);
            z16 = true;
            this.dragging = true;
            if (!this.forceOverScroll && !this.hadBeginDrag) {
                f();
            }
            h(this.contentView.getTranslationX(), this.contentView.getTranslationY());
        }
        if (z16) {
            this.velocityTracker.addMovement(event);
        }
        return z16;
    }

    public final void C() {
        this.pointerDataMap.clear();
        this.dragging = false;
        this.velocityTracker.clear();
        this.downing = false;
    }

    public final void D(@Nullable e eVar) {
        this.contentInsetWhenEndDrag = eVar;
    }

    public final void F(boolean z16) {
        this.forceOverScroll = z16;
    }

    public final void G(boolean z16) {
        this.overScrolling = z16;
    }

    public final void e(@NotNull e contentInset) {
        Intrinsics.checkNotNullParameter(contentInset, "contentInset");
        if (contentInset.getAnimate()) {
            I(contentInset);
        } else {
            E(contentInset);
        }
    }

    /* renamed from: k, reason: from getter */
    public final boolean getForceOverScroll() {
        return this.forceOverScroll;
    }

    /* renamed from: n, reason: from getter */
    public final float getOverScrollX() {
        return this.overScrollX;
    }

    /* renamed from: o, reason: from getter */
    public final float getOverScrollY() {
        return this.overScrollY;
    }

    /* renamed from: p, reason: from getter */
    public final boolean getOverScrolling() {
        return this.overScrolling;
    }

    public final boolean s() {
        if (this.isVertical) {
            if (!this.recyclerView.canScrollVertically(-1)) {
                return true;
            }
        } else if (!this.recyclerView.canScrollHorizontally(-1)) {
            return true;
        }
        return false;
    }

    public final boolean w(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (!s() && !r()) {
            if (event.getAction() == 1) {
                this.downing = false;
            }
            if (this.pointerDataMap.size() != 0) {
                this.pointerDataMap.clear();
            }
            if (!this.forceOverScroll) {
                return false;
            }
        }
        int actionIndex = event.getActionIndex();
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked != 2) {
                    if (actionMasked != 3) {
                        if (actionMasked != 5) {
                            if (actionMasked != 6) {
                                return false;
                            }
                            return B(actionIndex, event);
                        }
                        return A(actionIndex, event);
                    }
                } else {
                    return z(event);
                }
            }
            this.downing = false;
            return x();
        }
        return y(actionIndex, event);
    }

    public final boolean x() {
        float f16;
        this.pointerDataMap.clear();
        this.dragging = false;
        this.overScrollX = this.contentView.getTranslationX();
        this.overScrollY = this.contentView.getTranslationY();
        this.velocityTracker.computeCurrentVelocity(1000, this.maxFlingVelocity);
        float f17 = 0.0f;
        if (this.isVertical) {
            f16 = 0.0f;
        } else {
            f16 = -this.velocityTracker.getXVelocity(this.scrollPointerId);
        }
        if (this.isVertical) {
            f17 = -this.velocityTracker.getYVelocity(this.scrollPointerId);
        }
        this.overScrollEventCallback.b(this.overScrollX, this.overScrollY, f16, f17, s(), this.dragging);
        J(this, null, 1, null);
        this.velocityTracker.clear();
        return false;
    }
}
