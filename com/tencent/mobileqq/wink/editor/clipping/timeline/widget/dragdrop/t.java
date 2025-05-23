package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u0000 X2\u00020\u0001:\u0001@B\u000f\u0012\u0006\u0010J\u001a\u00020H\u00a2\u0006\u0004\bV\u0010WJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J,\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J \u0010\u0011\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\u0018\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0018\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J \u0010\u0019\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J \u0010\u001a\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\nH\u0002J<\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\nH\u0002J<\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\nH\u0002J*\u0010$\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010#\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010%\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J<\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010(\u001a\u00020\nH\u0002J(\u0010,\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\nH\u0002J(\u0010-\u001a\u00020\u00062\u0006\u0010*\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\nH\u0002J<\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010'\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\nH\u0002J*\u00101\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\n2\b\u0010/\u001a\u0004\u0018\u00010!2\u0006\u00100\u001a\u00020!2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u00102\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J \u00105\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\nH\u0002J\u0010\u00107\u001a\u0002062\u0006\u0010*\u001a\u00020\nH\u0002J(\u0010;\u001a\u00020\u00062\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010<\u001a\u00020\u0002H\u0016J\b\u0010=\u001a\u00020\u0002H\u0016J\u001a\u0010?\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00132\u0006\u0010>\u001a\u00020\u0002H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\u0018\u0010D\u001a\u00020\u00062\u0006\u0010B\u001a\u00020A2\u0006\u0010C\u001a\u00020\u0002H\u0016J\u0010\u0010E\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0013H\u0016J,\u0010F\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J \u0010G\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016R\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b@\u0010IR\u0016\u0010L\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010KR\u0016\u0010M\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010KR\u0016\u0010N\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010KR\u0018\u0010Q\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010PR\u0016\u0010R\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010\u000eR\u0016\u0010S\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010\u000eR\u0016\u0010T\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010\u000eR\u0016\u0010U\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010\u000e\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/o;", "", "isLeft", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", "dragViewModel", "", "L", "Landroid/view/View;", "dragView", "", "rawStartPosition", "offsetX", "Lkotlin/Pair;", "I", "B", "rawEndPosition", "H", "position", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "iDragView", "w", "v", "beforeScrollPosition", "adjustedPosition", "M", "N", "presetPosition", "minPosition", "maxStartPosition", ReportConstant.COSTREPORT_PREFIX, "t", "diff", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;", "minStartPoint", "attractX", "J", UserInfo.SEX_FEMALE, "presetEndPosition", "maxEndPosition", "minEndPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "animatedValue", "startScrollX", HippyTKDListViewAdapter.X, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "r", "minEndPoint", "attractPoint", "K", "D", "startPosition", "endPosition", "u", "", BdhLogUtil.LogTag.Tag_Conn, "positionOffset", "isUp", "view", "d", "f", "c", "isSelected", "i", "a", "", "moveX", "left", "g", tl.h.F, "b", "e", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/l;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/l;", "dropScrollView", "Z", "isScrollingRight", "isScrollingLeft", "toShortToasted", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "scrollAnimator", "currentScrollStartPosition", "currentScrollEndPosition", "lastVibrateStartPositionByScale", "lastVibrateEndPositionByScale", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/l;)V", "j", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class t implements o {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final l dropScrollView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollingRight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollingLeft;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean toShortToasted;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator scrollAnimator;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int currentScrollStartPosition;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int currentScrollEndPosition;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int lastVibrateStartPositionByScale;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int lastVibrateEndPositionByScale;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/b;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f319391e;

        b(m mVar) {
            this.f319391e = mVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            t.this.isScrollingRight = false;
            t.this.isScrollingLeft = false;
            t.this.scrollAnimator = null;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            t.this.isScrollingRight = false;
            t.this.isScrollingLeft = false;
            t.this.scrollAnimator = null;
            this.f319391e.B();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/t$c", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/reorder/b;", "Landroid/animation/Animator;", "animation", "", "onAnimationStart", "onAnimationEnd", "onAnimationCancel", "onAnimationRepeat", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f319393e;

        c(m mVar) {
            this.f319393e = mVar;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            t.this.isScrollingRight = false;
            t.this.isScrollingLeft = false;
            t.this.scrollAnimator = null;
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
            t.this.isScrollingRight = false;
            t.this.isScrollingLeft = false;
            t.this.scrollAnimator = null;
            this.f319393e.B();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.reorder.b, android.animation.Animator.AnimatorListener
        public void onAnimationStart(@NotNull Animator animation) {
            Intrinsics.checkNotNullParameter(animation, "animation");
        }
    }

    public t(@NotNull l dropScrollView) {
        Intrinsics.checkNotNullParameter(dropScrollView, "dropScrollView");
        this.dropScrollView = dropScrollView;
        this.lastVibrateStartPositionByScale = -1;
        this.lastVibrateEndPositionByScale = -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(t this$0, int i3, m dragView, int i16, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dragView, "$dragView");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.currentScrollEndPosition = i3 + intValue;
        dragView.setDragViewModel(DragViewModel.b(dragView.getDragViewModel(), null, 0, this$0.currentScrollEndPosition, 0L, 0, null, null, 123, null));
        this$0.dropScrollView.k(dragView);
        this$0.dropScrollView.l(i16 + intValue, 0);
    }

    private final void B(View dragView) {
        if (!this.toShortToasted) {
            this.toShortToasted = true;
            QQToast.makeText(dragView.getContext(), dragView.getContext().getString(R.string.f241367ro), 0).show();
            dragView.performHapticFeedback(0, 2);
        }
    }

    private final long C(int animatedValue) {
        return Math.abs(animatedValue);
    }

    private final int D(DragViewModel dragViewModel) {
        List sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.dropScrollView.h().get(dragViewModel.getTrackIndex()).d(), new Comparator() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.q
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int E;
                E = t.E((DragViewModel) obj, (DragViewModel) obj2);
                return E;
            }
        });
        int indexOf = sortedWith.indexOf(dragViewModel) + 1;
        if (indexOf >= sortedWith.size()) {
            return -1;
        }
        return ((DragViewModel) sortedWith.get(indexOf)).getStartPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int E(DragViewModel dragViewModel, DragViewModel dragViewModel2) {
        return Intrinsics.compare(dragViewModel.getStartPosition(), dragViewModel2.getStartPosition());
    }

    private final int F(DragViewModel dragViewModel) {
        List sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.dropScrollView.h().get(dragViewModel.getTrackIndex()).d(), new Comparator() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int G;
                G = t.G((DragViewModel) obj, (DragViewModel) obj2);
                return G;
            }
        });
        int indexOf = sortedWith.indexOf(dragViewModel) + 1;
        if (indexOf >= sortedWith.size()) {
            return -1;
        }
        return ((DragViewModel) sortedWith.get(indexOf)).getEndPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int G(DragViewModel dragViewModel, DragViewModel dragViewModel2) {
        return Intrinsics.compare(dragViewModel2.getEndPosition(), dragViewModel.getEndPosition());
    }

    private final int H(View dragView, int rawEndPosition, int offsetX) {
        int f16;
        int i3;
        boolean z16;
        m a16 = n.a(dragView);
        if (a16 == null) {
            return -1;
        }
        int v3 = v(rawEndPosition, a16);
        if (v3 != -1) {
            B(dragView);
            return v3;
        }
        this.toShortToasted = false;
        if (this.isScrollingRight || this.isScrollingLeft) {
            return -1;
        }
        int d16 = this.dropScrollView.d(50);
        int j3 = this.dropScrollView.j(50);
        int h16 = offsetX + a16.h();
        if (a16.o()) {
            f16 = this.dropScrollView.c();
        } else {
            f16 = this.dropScrollView.f();
        }
        if (a16.r() > 0) {
            f16 = RangesKt___RangesKt.coerceAtMost(f16, a16.r());
        }
        int i16 = f16;
        int n3 = a16.n() + a16.t();
        if (rawEndPosition >= j3 && rawEndPosition > a16.h()) {
            z16 = true;
            i3 = i16;
        } else {
            if (rawEndPosition <= d16 && rawEndPosition < a16.h()) {
                N(a16, h16, n3);
                return -1;
            }
            i3 = rawEndPosition;
            z16 = false;
        }
        Pair<Integer, Boolean> q16 = q(a16.getDragViewModel(), i3, rawEndPosition, i16, n3);
        if (q16.getSecond().booleanValue()) {
            dragView.performHapticFeedback(0, 2);
        }
        if (z16 && q16.getFirst().intValue() > rawEndPosition) {
            N(a16, h16, q16.getFirst().intValue());
            return -1;
        }
        return q16.getFirst().intValue();
    }

    private final Pair<Boolean, Integer> I(View dragView, int rawStartPosition, int offsetX) {
        int i3;
        boolean z16;
        m a16 = n.a(dragView);
        if (a16 == null) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        int w3 = w(rawStartPosition, a16);
        if (w3 != -1) {
            B(dragView);
            return new Pair<>(Boolean.TRUE, Integer.valueOf(w3));
        }
        this.toShortToasted = false;
        int n3 = offsetX + a16.n();
        if (!this.isScrollingRight && !this.isScrollingLeft) {
            int d16 = this.dropScrollView.d(50);
            int j3 = this.dropScrollView.j(50);
            int g16 = a16.g();
            int h16 = a16.h() - a16.t();
            boolean z17 = true;
            if (rawStartPosition <= d16 && rawStartPosition < a16.n()) {
                z16 = true;
                i3 = g16;
            } else {
                if (j3 > rawStartPosition || rawStartPosition >= h16) {
                    z17 = false;
                }
                if (z17) {
                    M(a16, n3, h16);
                    return new Pair<>(Boolean.FALSE, 0);
                }
                i3 = rawStartPosition;
                z16 = false;
            }
            Pair<Integer, Boolean> s16 = s(dragView, i3, rawStartPosition, g16, h16);
            if (s16.getSecond().booleanValue()) {
                dragView.performHapticFeedback(0, 2);
            }
            if (z16 && s16.getFirst().intValue() < rawStartPosition) {
                M(a16, rawStartPosition, s16.getFirst().intValue());
                return new Pair<>(Boolean.FALSE, 0);
            }
            return new Pair<>(Boolean.TRUE, s16.getFirst());
        }
        return new Pair<>(Boolean.FALSE, 0);
    }

    private final boolean J(int diff, AttractPoint minStartPoint, int attractX, DragViewModel dragViewModel) {
        if (diff < this.dropScrollView.e() && ((minStartPoint == null || diff < Math.abs(minStartPoint.getPx() - attractX)) && u(dragViewModel, attractX, dragViewModel.getEndPosition()))) {
            return true;
        }
        return false;
    }

    private final boolean K(int diff, AttractPoint minEndPoint, AttractPoint attractPoint, DragViewModel dragViewModel) {
        if (diff < this.dropScrollView.e() && ((minEndPoint == null || diff < Math.abs(minEndPoint.getPx() - attractPoint.getPx())) && u(dragViewModel, dragViewModel.getStartPosition(), attractPoint.getPx()))) {
            return true;
        }
        return false;
    }

    private final void L(boolean isLeft, DragViewModel dragViewModel) {
        if (isLeft) {
            this.dropScrollView.setAdsorbedPoint(null, new AttractPoint(0L, dragViewModel.getEndPosition(), dragViewModel.getId(), false));
        } else {
            this.dropScrollView.setAdsorbedPoint(new AttractPoint(0L, dragViewModel.getStartPosition(), dragViewModel.getId(), true), null);
        }
    }

    private final void M(m dragView, int beforeScrollPosition, int adjustedPosition) {
        int i3;
        if (beforeScrollPosition < adjustedPosition) {
            this.isScrollingRight = true;
        } else if (beforeScrollPosition > adjustedPosition) {
            this.isScrollingLeft = true;
        }
        int n3 = this.dropScrollView.n();
        if (adjustedPosition == dragView.n()) {
            l lVar = this.dropScrollView;
            i3 = (adjustedPosition - beforeScrollPosition) + (lVar.j(lVar.m()) - this.dropScrollView.d(50));
        } else {
            i3 = adjustedPosition - beforeScrollPosition;
        }
        x(i3, beforeScrollPosition, dragView, n3);
    }

    private final void N(m dragView, int beforeScrollPosition, int adjustedPosition) {
        int i3;
        if (beforeScrollPosition < adjustedPosition) {
            this.isScrollingRight = true;
        } else if (beforeScrollPosition > adjustedPosition) {
            this.isScrollingLeft = true;
        }
        if (adjustedPosition == this.dropScrollView.i()) {
            int j3 = this.dropScrollView.j(50);
            l lVar = this.dropScrollView;
            i3 = (adjustedPosition - beforeScrollPosition) + (j3 - lVar.j(lVar.m()));
        } else {
            i3 = adjustedPosition - beforeScrollPosition;
        }
        z(i3, beforeScrollPosition, dragView, this.dropScrollView.n());
    }

    private final Pair<Integer, Boolean> q(DragViewModel dragViewModel, int presetEndPosition, int rawEndPosition, int maxEndPosition, int minEndPosition) {
        Pair<Integer, Boolean> r16 = r(presetEndPosition, rawEndPosition, maxEndPosition, dragViewModel, minEndPosition);
        int intValue = r16.getFirst().intValue();
        if (intValue != this.lastVibrateEndPositionByScale) {
            this.lastVibrateEndPositionByScale = -1;
        }
        return new Pair<>(Integer.valueOf(intValue), r16.getSecond());
    }

    private final Pair<Integer, Boolean> r(int position, int rawEndPosition, int maxEndPosition, DragViewModel dragViewModel, int minEndPosition) {
        int coerceAtMost;
        boolean z16;
        boolean z17;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(maxEndPosition, position);
        Integer valueOf = Integer.valueOf(D(dragViewModel));
        boolean z18 = false;
        if (valueOf.intValue() != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(coerceAtMost, valueOf.intValue());
        }
        List<AttractPoint> b16 = this.dropScrollView.b(dragViewModel.getId());
        ArrayList<AttractPoint> arrayList = new ArrayList();
        for (Object obj : b16) {
            if (((AttractPoint) obj).getPx() > minEndPosition) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        AttractPoint attractPoint = null;
        for (AttractPoint attractPoint2 : arrayList) {
            if (K(Math.abs(rawEndPosition - attractPoint2.getPx()), attractPoint, attractPoint2, dragViewModel)) {
                coerceAtMost = RangesKt___RangesKt.coerceAtMost(attractPoint2.getPx(), maxEndPosition);
                if (this.lastVibrateEndPositionByScale == -1) {
                    this.lastVibrateEndPositionByScale = coerceAtMost;
                    attractPoint = attractPoint2;
                    z18 = true;
                }
            }
        }
        if (attractPoint != null) {
            this.dropScrollView.setAdsorbedPoint(null, attractPoint);
        }
        return new Pair<>(Integer.valueOf(coerceAtMost), Boolean.valueOf(z18));
    }

    private final Pair<Integer, Boolean> s(View dragView, int presetPosition, int rawStartPosition, int minPosition, int maxStartPosition) {
        DragViewModel dragViewModel;
        m a16 = n.a(dragView);
        if (a16 != null && (dragViewModel = a16.getDragViewModel()) != null) {
            Pair<Integer, Boolean> t16 = t(presetPosition, rawStartPosition, minPosition, dragViewModel, maxStartPosition);
            int intValue = t16.getFirst().intValue();
            if (this.lastVibrateStartPositionByScale != intValue) {
                this.lastVibrateStartPositionByScale = -1;
            }
            return new Pair<>(Integer.valueOf(intValue), t16.getSecond());
        }
        return new Pair<>(-1, Boolean.FALSE);
    }

    private final Pair<Integer, Boolean> t(int adjustedPosition, int rawStartPosition, int minPosition, DragViewModel dragViewModel, int maxStartPosition) {
        int coerceAtLeast;
        boolean z16;
        boolean z17;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(minPosition, adjustedPosition);
        Integer valueOf = Integer.valueOf(F(dragViewModel));
        boolean z18 = false;
        if (valueOf.intValue() != -1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            valueOf = null;
        }
        if (valueOf != null) {
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(coerceAtLeast, valueOf.intValue());
        }
        List<AttractPoint> b16 = this.dropScrollView.b(dragViewModel.getId());
        ArrayList<AttractPoint> arrayList = new ArrayList();
        for (Object obj : b16) {
            if (((AttractPoint) obj).getPx() < maxStartPosition) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList.add(obj);
            }
        }
        AttractPoint attractPoint = null;
        for (AttractPoint attractPoint2 : arrayList) {
            if (J(Math.abs(rawStartPosition - attractPoint2.getPx()), attractPoint, attractPoint2.getPx(), dragViewModel)) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(attractPoint2.getPx(), minPosition);
                if (this.lastVibrateStartPositionByScale == -1) {
                    this.lastVibrateStartPositionByScale = coerceAtLeast;
                    attractPoint = attractPoint2;
                    z18 = true;
                }
            }
        }
        if (attractPoint != null) {
            this.dropScrollView.setAdsorbedPoint(attractPoint, null);
        }
        return new Pair<>(Integer.valueOf(coerceAtLeast), Boolean.valueOf(z18));
    }

    private final boolean u(DragViewModel dragViewModel, int startPosition, int endPosition) {
        y yVar = this.dropScrollView.h().get(dragViewModel.getTrackIndex());
        Intrinsics.checkNotNullExpressionValue(yVar, "dropScrollView.trackMode\u2026dragViewModel.trackIndex]");
        return yVar.a(dragViewModel, startPosition, endPosition);
    }

    private final int v(int rawEndPosition, m iDragView) {
        if (rawEndPosition > this.dropScrollView.i() || rawEndPosition >= iDragView.n() + iDragView.t()) {
            return -1;
        }
        return iDragView.n() + iDragView.t();
    }

    private final int w(int position, m iDragView) {
        if (position < 0 || position <= iDragView.h() - iDragView.t()) {
            return -1;
        }
        return iDragView.h() - iDragView.t();
    }

    private final void x(int animatedValue, final int beforeScrollPosition, final m dragView, final int startScrollX) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, animatedValue);
        ofInt.setDuration(C(animatedValue));
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.p
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                t.y(t.this, beforeScrollPosition, dragView, startScrollX, valueAnimator);
            }
        });
        ofInt.addListener(new b(dragView));
        ofInt.start();
        this.scrollAnimator = ofInt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(t this$0, int i3, m dragView, int i16, ValueAnimator animation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(dragView, "$dragView");
        Intrinsics.checkNotNullParameter(animation, "animation");
        Object animatedValue = animation.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) animatedValue).intValue();
        this$0.currentScrollStartPosition = i3 + intValue;
        dragView.setDragViewModel(DragViewModel.b(dragView.getDragViewModel(), null, this$0.currentScrollStartPosition, 0, 0L, 0, null, null, 125, null));
        this$0.dropScrollView.k(dragView);
        this$0.dropScrollView.l(i16 + intValue, 0);
    }

    private final void z(int animatedValue, final int beforeScrollPosition, final m dragView, final int startScrollX) {
        ValueAnimator ofInt = ValueAnimator.ofInt(0, animatedValue);
        ofInt.setDuration(C(animatedValue));
        ofInt.setInterpolator(new LinearInterpolator());
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.r
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                t.A(t.this, beforeScrollPosition, dragView, startScrollX, valueAnimator);
            }
        });
        ofInt.addListener(new c(dragView));
        ofInt.start();
        this.scrollAnimator = ofInt;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    public void a() {
        this.dropScrollView.a();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    @NotNull
    public Pair<Boolean, Integer> b(@NotNull View dragView, int rawStartPosition, int offsetX) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        return I(dragView, rawStartPosition, offsetX);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    /* renamed from: c, reason: from getter */
    public boolean getIsScrollingLeft() {
        return this.isScrollingLeft;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    public void d(int positionOffset, boolean isUp, @NotNull View view, boolean isLeft) {
        DragViewModel dragViewModel;
        Intrinsics.checkNotNullParameter(view, "view");
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
            this.scrollAnimator = null;
        }
        if (isUp) {
            this.dropScrollView.g(positionOffset, view);
            m a16 = n.a(view);
            if (a16 != null && (dragViewModel = a16.getDragViewModel()) != null) {
                L(isLeft, dragViewModel);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    public int e(@NotNull View dragView, int rawEndPosition, int offsetX) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        return H(dragView, rawEndPosition, offsetX);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    /* renamed from: f, reason: from getter */
    public boolean getIsScrollingRight() {
        return this.isScrollingRight;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    public void h(@NotNull m dragView) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        this.dropScrollView.k(dragView);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    public void i(@Nullable m dragView, boolean isSelected) {
        this.dropScrollView.r(dragView, isSelected);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.o
    public void g(float moveX, boolean left) {
    }
}
