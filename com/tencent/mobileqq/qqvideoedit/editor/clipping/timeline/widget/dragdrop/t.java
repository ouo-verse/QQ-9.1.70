package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.animation.ValueAnimator;
import android.view.View;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
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
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u00102\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010<\u001a\u00020:\u00a2\u0006\u0004\bF\u0010GJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016J\u001a\u0010\u0010\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0016J,\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J \u0010\u0018\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0016J\u0018\u0010\u001b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J,\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J \u0010\u001d\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010 \u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0002J\u0018\u0010!\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\rH\u0002J<\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020\u0002H\u0002J<\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010&\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0002H\u0002J*\u0010,\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010-\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J<\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010.\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u00100\u001a\u00020\u0002H\u0002J<\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00152\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010/\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u0002H\u0002J*\u00105\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\b\u00103\u001a\u0004\u0018\u00010)2\u0006\u00104\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u00106\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J \u00109\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u00107\u001a\u00020\u00022\u0006\u00108\u001a\u00020\u0002H\u0002R\u0014\u0010<\u001a\u00020:8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010;R\u0016\u0010>\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010=R\u0016\u0010?\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010AR\u0016\u0010D\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010CR\u0016\u0010E\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010C\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/t;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/q;", "", "positionOffset", "", "isUp", "Landroid/view/View;", "view", "isLeft", "", "d", "f", "c", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "dragView", "isSelected", "g", "a", tl.h.F, "rawStartPosition", "offsetX", "Lkotlin/Pair;", "b", "rawEndPosition", "e", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "dragViewModel", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "w", "v", "position", "iDragView", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "p", "presetPosition", "minPosition", "maxStartPosition", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "adjustedPosition", DomainData.DOMAIN_NAME, "diff", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/a;", "minStartPoint", "attractX", HippyTKDListViewAdapter.X, "t", "presetEndPosition", "maxEndPosition", "minEndPosition", "k", "l", "minEndPoint", "attractPoint", "y", "r", "startPosition", "endPosition", "o", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/n;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/n;", "dropScrollView", "Z", "isScrollingRight", "isScrollingLeft", "Landroid/animation/ValueAnimator;", "Landroid/animation/ValueAnimator;", "scrollAnimator", "I", "lastVibrateStartPositionByScale", "lastVibrateEndPositionByScale", "<init>", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/n;)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class t implements q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final n dropScrollView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollingRight;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isScrollingLeft;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ValueAnimator scrollAnimator;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int lastVibrateStartPositionByScale;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int lastVibrateEndPositionByScale;

    public t(@NotNull n dropScrollView) {
        Intrinsics.checkNotNullParameter(dropScrollView, "dropScrollView");
        this.dropScrollView = dropScrollView;
        this.lastVibrateStartPositionByScale = -1;
        this.lastVibrateEndPositionByScale = -1;
    }

    private final Pair<Integer, Boolean> k(DragViewModel dragViewModel, int presetEndPosition, int rawEndPosition, int maxEndPosition, int minEndPosition) {
        Pair<Integer, Boolean> l3 = l(presetEndPosition, rawEndPosition, maxEndPosition, dragViewModel, minEndPosition);
        int intValue = l3.getFirst().intValue();
        if (intValue != this.lastVibrateEndPositionByScale) {
            this.lastVibrateEndPositionByScale = -1;
        }
        return new Pair<>(Integer.valueOf(intValue), l3.getSecond());
    }

    private final Pair<Integer, Boolean> l(int position, int rawEndPosition, int maxEndPosition, DragViewModel dragViewModel, int minEndPosition) {
        int coerceAtMost;
        boolean z16;
        boolean z17;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(maxEndPosition, position);
        Integer valueOf = Integer.valueOf(r(dragViewModel));
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
            if (y(Math.abs(rawEndPosition - attractPoint2.getPx()), attractPoint, attractPoint2, dragViewModel)) {
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

    private final Pair<Integer, Boolean> m(View dragView, int presetPosition, int rawStartPosition, int minPosition, int maxStartPosition) {
        DragViewModel j3;
        o a16 = p.a(dragView);
        if (a16 != null && (j3 = a16.j()) != null) {
            Pair<Integer, Boolean> n3 = n(presetPosition, rawStartPosition, minPosition, j3, maxStartPosition);
            int intValue = n3.getFirst().intValue();
            if (this.lastVibrateStartPositionByScale != intValue) {
                this.lastVibrateStartPositionByScale = -1;
            }
            return new Pair<>(Integer.valueOf(intValue), n3.getSecond());
        }
        return new Pair<>(-1, Boolean.FALSE);
    }

    private final Pair<Integer, Boolean> n(int adjustedPosition, int rawStartPosition, int minPosition, DragViewModel dragViewModel, int maxStartPosition) {
        int coerceAtLeast;
        boolean z16;
        boolean z17;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(minPosition, adjustedPosition);
        Integer valueOf = Integer.valueOf(t(dragViewModel));
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
            if (x(Math.abs(rawStartPosition - attractPoint2.getPx()), attractPoint, attractPoint2.getPx(), dragViewModel)) {
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

    private final boolean o(DragViewModel dragViewModel, int startPosition, int endPosition) {
        y yVar = this.dropScrollView.h().get(dragViewModel.getTrackIndex());
        Intrinsics.checkNotNullExpressionValue(yVar, "dropScrollView.trackMode\u2026dragViewModel.trackIndex]");
        return yVar.a(dragViewModel, startPosition, endPosition);
    }

    private final int p(int rawEndPosition, o iDragView) {
        if (rawEndPosition > this.dropScrollView.i() || rawEndPosition >= iDragView.n() + iDragView.t()) {
            return -1;
        }
        return iDragView.n() + iDragView.t();
    }

    private final int q(int position, o iDragView) {
        if (position < 0 || position <= iDragView.h() - iDragView.t()) {
            return -1;
        }
        return iDragView.h() - iDragView.t();
    }

    private final int r(DragViewModel dragViewModel) {
        List sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.dropScrollView.h().get(dragViewModel.getTrackIndex()).d(), new Comparator() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.r
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int s16;
                s16 = t.s((DragViewModel) obj, (DragViewModel) obj2);
                return s16;
            }
        });
        int indexOf = sortedWith.indexOf(dragViewModel) + 1;
        if (indexOf >= sortedWith.size()) {
            return -1;
        }
        return ((DragViewModel) sortedWith.get(indexOf)).getStartPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int s(DragViewModel dragViewModel, DragViewModel dragViewModel2) {
        return Intrinsics.compare(dragViewModel.getStartPosition(), dragViewModel2.getStartPosition());
    }

    private final int t(DragViewModel dragViewModel) {
        List sortedWith;
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(this.dropScrollView.h().get(dragViewModel.getTrackIndex()).d(), new Comparator() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.s
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int u16;
                u16 = t.u((DragViewModel) obj, (DragViewModel) obj2);
                return u16;
            }
        });
        int indexOf = sortedWith.indexOf(dragViewModel) + 1;
        if (indexOf >= sortedWith.size()) {
            return -1;
        }
        return ((DragViewModel) sortedWith.get(indexOf)).getEndPosition();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int u(DragViewModel dragViewModel, DragViewModel dragViewModel2) {
        return Intrinsics.compare(dragViewModel2.getEndPosition(), dragViewModel.getEndPosition());
    }

    private final int v(View dragView, int rawEndPosition, int offsetX) {
        int f16;
        o a16 = p.a(dragView);
        if (a16 == null) {
            return -1;
        }
        int p16 = p(rawEndPosition, a16);
        if (p16 != -1) {
            return p16;
        }
        if (this.isScrollingRight || this.isScrollingLeft) {
            return -1;
        }
        this.dropScrollView.d(50);
        this.dropScrollView.j(50);
        a16.h();
        if (a16.o()) {
            f16 = this.dropScrollView.c();
        } else {
            f16 = this.dropScrollView.f();
        }
        if (a16.r() > 0) {
            f16 = RangesKt___RangesKt.coerceAtMost(f16, a16.r());
        }
        Pair<Integer, Boolean> k3 = k(a16.j(), rawEndPosition, rawEndPosition, f16, a16.n() + a16.t());
        if (k3.getSecond().booleanValue()) {
            dragView.performHapticFeedback(0, 2);
        }
        return k3.getFirst().intValue();
    }

    private final Pair<Boolean, Integer> w(View dragView, int rawStartPosition, int offsetX) {
        o a16 = p.a(dragView);
        if (a16 == null) {
            return new Pair<>(Boolean.FALSE, 0);
        }
        int q16 = q(rawStartPosition, a16);
        if (q16 != -1) {
            return new Pair<>(Boolean.TRUE, Integer.valueOf(q16));
        }
        a16.n();
        if (!this.isScrollingRight && !this.isScrollingLeft) {
            this.dropScrollView.d(50);
            this.dropScrollView.j(50);
            Pair<Integer, Boolean> m3 = m(dragView, rawStartPosition, rawStartPosition, a16.g(), a16.h() - a16.t());
            if (m3.getSecond().booleanValue()) {
                dragView.performHapticFeedback(0, 2);
            }
            return new Pair<>(Boolean.TRUE, m3.getFirst());
        }
        return new Pair<>(Boolean.FALSE, 0);
    }

    private final boolean x(int diff, AttractPoint minStartPoint, int attractX, DragViewModel dragViewModel) {
        if (diff < this.dropScrollView.e() && ((minStartPoint == null || diff < Math.abs(minStartPoint.getPx() - attractX)) && o(dragViewModel, attractX, dragViewModel.getEndPosition()))) {
            return true;
        }
        return false;
    }

    private final boolean y(int diff, AttractPoint minEndPoint, AttractPoint attractPoint, DragViewModel dragViewModel) {
        if (diff < this.dropScrollView.e() && ((minEndPoint == null || diff < Math.abs(minEndPoint.getPx() - attractPoint.getPx())) && o(dragViewModel, dragViewModel.getStartPosition(), attractPoint.getPx()))) {
            return true;
        }
        return false;
    }

    private final void z(boolean isLeft, DragViewModel dragViewModel) {
        if (isLeft) {
            this.dropScrollView.setAdsorbedPoint(null, new AttractPoint(0L, dragViewModel.getEndPosition(), dragViewModel.getId(), false));
        } else {
            this.dropScrollView.setAdsorbedPoint(new AttractPoint(0L, dragViewModel.getStartPosition(), dragViewModel.getId(), true), null);
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    public void a() {
        this.dropScrollView.a();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    @NotNull
    public Pair<Boolean, Integer> b(@NotNull View dragView, int rawStartPosition, int offsetX) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        return w(dragView, rawStartPosition, offsetX);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    /* renamed from: c, reason: from getter */
    public boolean getIsScrollingLeft() {
        return this.isScrollingLeft;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    public void d(int positionOffset, boolean isUp, @NotNull View view, boolean isLeft) {
        DragViewModel j3;
        Intrinsics.checkNotNullParameter(view, "view");
        ValueAnimator valueAnimator = this.scrollAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            valueAnimator.cancel();
            valueAnimator.removeAllUpdateListeners();
            this.scrollAnimator = null;
        }
        if (isUp) {
            this.dropScrollView.g(positionOffset, view);
            o a16 = p.a(view);
            if (a16 != null && (j3 = a16.j()) != null) {
                z(isLeft, j3);
            }
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    public int e(@NotNull View dragView, int rawEndPosition, int offsetX) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        return v(dragView, rawEndPosition, offsetX);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    /* renamed from: f, reason: from getter */
    public boolean getIsScrollingRight() {
        return this.isScrollingRight;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    public void g(@Nullable o dragView, boolean isSelected) {
        this.dropScrollView.q(dragView, isSelected);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.q
    public void h(@NotNull o dragView) {
        Intrinsics.checkNotNullParameter(dragView, "dragView");
        this.dropScrollView.p(dragView);
    }
}
