package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

import android.graphics.PointF;
import android.view.DragEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragEventHandler$scrollRunnable$2;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 b2\u00020\u0001:\u0001cB\u000f\u0012\u0006\u0010H\u001a\u00020E\u00a2\u0006\u0004\b`\u0010aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J \u0010\u0014\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J \u0010\u0018\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J(\u0010\u001c\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J8\u0010 \u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0019H\u0002J \u0010\"\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\r\u001a\u00020\u0019H\u0002J\u0010\u0010#\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0007H\u0002J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010$\u001a\u00020\u001dH\u0002J0\u0010'\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u001d\u0012\u0006\u0012\u0004\u0018\u00010\u001d0&2\u0006\u0010\r\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u0007H\u0002J\u0012\u0010(\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J*\u0010,\u001a\u00020\u00042\u0006\u0010)\u001a\u00020\t2\b\u0010*\u001a\u0004\u0018\u00010\u00122\u0006\u0010+\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\fH\u0002J4\u0010/\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0.2\u0006\u0010-\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00192\u0006\u0010\r\u001a\u00020\fH\u0002J \u00101\u001a\u00020\u00042\u0006\u00100\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0019H\u0002J\u001a\u00103\u001a\u0004\u0018\u00010\u00122\u0006\u00102\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u00104\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u00106\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\u0010\u00107\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0007H\u0002J\u000e\u00109\u001a\u00020\u00042\u0006\u00108\u001a\u00020\tJ\u001c\u0010:\u001a\u00020\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J&\u0010@\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;2\u0006\u0010=\u001a\u00020;2\u0006\u0010>\u001a\u00020;2\u0006\u0010?\u001a\u00020;J\u001f\u0010C\u001a\u00020;2\u0006\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\u0007H\u0000\u00a2\u0006\u0004\bC\u0010DR\u0014\u0010H\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010@R\u0016\u0010M\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010NR\u0016\u0010R\u001a\u00020P8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010QR\u0016\u0010S\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00109R\u0016\u0010T\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010@R\u0016\u0010U\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010@R\u0014\u0010W\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010VR\u0016\u00108\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010LR\u0016\u0010X\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010@R\u0016\u0010Y\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010VR\u0014\u0010Z\u001a\u00020;8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u00109R\u001b\u0010_\u001a\u00020[8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bQ\u0010\\\u001a\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragEventHandler;", "Landroid/view/View$OnDragListener;", "Landroid/view/DragEvent;", "event", "", "v", HippyTKDListViewAdapter.X, "", "y", "", "E", "w", "Landroid/view/View;", "dragView", "Landroid/graphics/PointF;", "newPosition", tl.h.F, BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/y;", "trackModel", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "newX", "newY", "i", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "expectStartPosition", "expectEndPosition", "g", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/a;", "endPoint", "startPoint", "l", "minEndAttractPoint", "j", "B", "minStartAttractPoint", "k", "Lkotlin/Pair;", "p", "t", "needRemoveOriginal", "originalTrack", "iDragView", DomainData.DOMAIN_NAME, "expectY", "Lkotlin/Triple;", "G", "isSameTrack", "o", "needRemoveOriginBlock", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "H", "ratio", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "canAddEmptyTrackOnDrop", "I", "onDrag", "", "scrollX", "scrollY", "oldScrollX", "oldScrollY", UserInfo.SEX_FEMALE, "viewSize", "viewSizeOutOfBounds", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(IF)I", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "d", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;", "dropScrollView", "e", "dragY", "f", "Z", "dragUp", "Landroid/view/View;", "draggingView", "", "J", "scrollStartTime", "maxDragScrollPerFrame", "lastVibrateXByDrag", "lastVibrateYByDrag", "Landroid/graphics/PointF;", "startDragPoint", "xOffset", "startTouchPoint", "touchSlop", "Ljava/lang/Runnable;", "Lkotlin/Lazy;", "r", "()Ljava/lang/Runnable;", "scrollRunnable", "<init>", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/DragDropScrollView;)V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class DragEventHandler implements View.OnDragListener {

    /* renamed from: C, reason: from kotlin metadata */
    private float lastVibrateXByDrag;

    /* renamed from: D, reason: from kotlin metadata */
    private float lastVibrateYByDrag;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final PointF startDragPoint;

    /* renamed from: F, reason: from kotlin metadata */
    private boolean canAddEmptyTrackOnDrop;

    /* renamed from: G, reason: from kotlin metadata */
    private float xOffset;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private PointF startTouchPoint;

    /* renamed from: I, reason: from kotlin metadata */
    private final int touchSlop;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy scrollRunnable;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DragDropScrollView dropScrollView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float dragY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean dragUp;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View draggingView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long scrollStartTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int maxDragScrollPerFrame;

    public DragEventHandler(@NotNull DragDropScrollView dropScrollView) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(dropScrollView, "dropScrollView");
        this.dropScrollView = dropScrollView;
        this.maxDragScrollPerFrame = com.tencent.videocut.utils.e.f384236a.a(20.0f);
        this.lastVibrateXByDrag = -1.0f;
        this.lastVibrateYByDrag = -1.0f;
        this.startDragPoint = new PointF();
        this.canAddEmptyTrackOnDrop = true;
        this.startTouchPoint = new PointF();
        this.touchSlop = ViewConfiguration.get(dropScrollView.getContext()).getScaledTouchSlop();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<DragEventHandler$scrollRunnable$2.AnonymousClass1>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragEventHandler$scrollRunnable$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Type inference failed for: r0v0, types: [com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragEventHandler$scrollRunnable$2$1] */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final AnonymousClass1 invoke() {
                final DragEventHandler dragEventHandler = DragEventHandler.this;
                return new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.DragEventHandler$scrollRunnable$2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        View view;
                        long j3;
                        DragDropScrollView dragDropScrollView;
                        float f16;
                        DragDropScrollView dragDropScrollView2;
                        DragDropScrollView dragDropScrollView3;
                        view = DragEventHandler.this.draggingView;
                        if (view != null) {
                            DragEventHandler dragEventHandler2 = DragEventHandler.this;
                            j3 = dragEventHandler2.scrollStartTime;
                            if (j3 == 0) {
                                dragEventHandler2.scrollStartTime = System.currentTimeMillis();
                            }
                            dragDropScrollView = dragEventHandler2.dropScrollView;
                            f16 = dragEventHandler2.xOffset;
                            if (dragDropScrollView.o0(view, (int) f16)) {
                                dragDropScrollView2 = dragEventHandler2.dropScrollView;
                                dragDropScrollView2.removeCallbacks(this);
                                dragDropScrollView3 = dragEventHandler2.dropScrollView;
                                ViewCompat.postOnAnimation(dragDropScrollView3, this);
                            }
                        }
                    }
                };
            }
        });
        this.scrollRunnable = lazy;
    }

    private final boolean A(View dragView, float y16, y trackModel) {
        if ((y16 > this.startDragPoint.y && D(dragView.getHeight() + y16, trackModel)) || (y16 < this.startDragPoint.y && D(y16, trackModel))) {
            return true;
        }
        return false;
    }

    private final boolean B(float newX) {
        if (Math.abs(newX - this.lastVibrateXByDrag) < this.dropScrollView.N()) {
            return true;
        }
        return false;
    }

    private final boolean C(PointF newPosition) {
        if (Math.abs(newPosition.y - this.startDragPoint.y) % (this.dropScrollView.Q() + this.dropScrollView.S()) > this.dropScrollView.Q() * 0.5f) {
            return true;
        }
        return false;
    }

    private final boolean D(float y16, y trackModel) {
        if (y16 > trackModel.getTop() && y16 < trackModel.getBottom()) {
            return true;
        }
        return false;
    }

    private final boolean E(float x16, float y16) {
        float n3 = x16 - this.dropScrollView.n();
        float f16 = n3 - this.startTouchPoint.x;
        boolean z16 = false;
        if (Math.abs(f16) < this.touchSlop && Math.abs(y16 - this.startTouchPoint.y) < this.touchSlop) {
            return false;
        }
        if (Math.signum(f16) == Math.signum(this.xOffset)) {
            z16 = true;
        }
        if (!z16) {
            this.scrollStartTime = System.currentTimeMillis();
            this.startTouchPoint.set(n3, y16);
        }
        this.xOffset = f16;
        return true;
    }

    private final Triple<y, Boolean, Boolean> G(float expectY, m iDragView, View dragView) {
        boolean z16;
        y yVar;
        boolean z17;
        Iterator<y> it = this.dropScrollView.h().iterator();
        while (true) {
            z16 = false;
            if (it.hasNext()) {
                y trackModel = it.next();
                if (Math.abs((expectY - iDragView.s()) - trackModel.getTop()) < this.dropScrollView.Q() * 0.5f) {
                    ViewGroup.LayoutParams layoutParams = dragView.getLayoutParams();
                    Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                    z17 = true;
                    if (((ViewGroup.MarginLayoutParams) layoutParams).topMargin == trackModel.getTop() - iDragView.s()) {
                        trackModel.l(iDragView.getDragViewModel().getId());
                        z16 = true;
                    }
                    Intrinsics.checkNotNullExpressionValue(trackModel, "trackModel");
                    if (y.b(trackModel, iDragView.getDragViewModel(), 0, 0, 6, null)) {
                        z16 = !z16;
                        yVar = m(z16, trackModel);
                        H(dragView);
                        this.dropScrollView.e0(trackModel, iDragView);
                        break;
                    }
                    iDragView.setDragViewModel(DragViewModel.b(iDragView.getDragViewModel(), null, ((int) this.startDragPoint.x) - this.dropScrollView.P(), (((int) this.startDragPoint.x) + iDragView.getLength()) - this.dropScrollView.P(), 0L, 0, null, null, 121, null));
                    o(z16, trackModel, iDragView);
                }
            } else {
                yVar = null;
                z17 = false;
                break;
            }
        }
        return new Triple<>(yVar, Boolean.valueOf(z16), Boolean.valueOf(z17));
    }

    private final void H(View dragView) {
        dragView.setTranslationX(0.0f);
        dragView.setTranslationY(0.0f);
        dragView.setAlpha(1.0f);
        dragView.setVisibility(0);
    }

    private final boolean g(m dragView, PointF newPosition, float expectStartPosition, float expectEndPosition) {
        if (!B(expectStartPosition) && !B(expectEndPosition)) {
            Pair<AttractPoint, AttractPoint> p16 = p(dragView, expectStartPosition, expectEndPosition);
            AttractPoint component1 = p16.component1();
            AttractPoint component2 = p16.component2();
            if (component1 != null && component2 != null) {
                return l(component2, expectEndPosition, component1, expectStartPosition, newPosition, dragView);
            }
            if (component2 != null) {
                return j(newPosition, component2, dragView);
            }
            if (component1 == null) {
                return false;
            }
            return k(newPosition, component1);
        }
        newPosition.x = this.lastVibrateXByDrag;
        return false;
    }

    private final boolean h(View dragView, PointF newPosition) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19 = true;
        if (C(newPosition)) {
            Iterator<y> it = this.dropScrollView.h().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                y trackModel = it.next();
                float f16 = newPosition.y;
                Intrinsics.checkNotNullExpressionValue(trackModel, "trackModel");
                if (A(dragView, f16, trackModel)) {
                    float top = trackModel.getTop();
                    newPosition.y = top;
                    if (this.lastVibrateYByDrag == top) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (!z18) {
                        this.lastVibrateYByDrag = top;
                        z17 = true;
                    }
                }
            }
            z17 = false;
        } else {
            if (Math.abs(newPosition.y - this.startDragPoint.y) < this.dropScrollView.Q() * 0.25f) {
                if (this.lastVibrateYByDrag == -1.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    float f17 = this.startDragPoint.y;
                    newPosition.y = f17;
                    this.lastVibrateYByDrag = f17;
                    z17 = true;
                } else {
                    z17 = false;
                }
                newPosition.y = this.startDragPoint.y;
            }
            z17 = false;
        }
        if (newPosition.y != this.lastVibrateYByDrag) {
            z19 = false;
        }
        if (!z19) {
            this.lastVibrateYByDrag = -1.0f;
        }
        return z17;
    }

    private final void i(View dragView, float newX, float newY) {
        Boolean bool;
        boolean h16;
        boolean z16;
        m a16 = n.a(dragView);
        if (a16 == null) {
            return;
        }
        PointF pointF = new PointF(newX, newY);
        this.dropScrollView.C(dragView, pointF);
        Object tag = dragView.getTag(R.id.ull);
        if (tag instanceof Boolean) {
            bool = (Boolean) tag;
        } else {
            bool = null;
        }
        if (bool != null && bool.booleanValue()) {
            h16 = false;
        } else {
            h16 = h(dragView, pointF);
        }
        float f16 = pointF.x;
        float length = a16.getLength() + f16;
        boolean z17 = true;
        if (!h16 && !g(a16, pointF, f16, length)) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (this.lastVibrateXByDrag != pointF.x) {
            z17 = false;
        }
        if (!z17) {
            this.lastVibrateXByDrag = -1.0f;
        }
        if (z16) {
            dragView.performHapticFeedback(0, 2);
        }
        a16.setDragViewModel(DragViewModel.b(a16.getDragViewModel(), null, ((int) pointF.x) - this.dropScrollView.P(), (((int) pointF.x) + a16.getLength()) - this.dropScrollView.P(), 0L, 0, null, null, 121, null));
        this.dropScrollView.u0((int) pointF.x, dragView);
        dragView.setX(pointF.x);
        dragView.setY(pointF.y);
    }

    private final boolean j(PointF newPosition, AttractPoint minEndAttractPoint, m dragView) {
        boolean z16;
        float px5 = (minEndAttractPoint.getPx() - dragView.getLength()) + this.dropScrollView.P();
        newPosition.x = px5;
        if (this.lastVibrateXByDrag == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        this.lastVibrateXByDrag = px5;
        this.dropScrollView.setAdsorbedPoint(null, minEndAttractPoint);
        return true;
    }

    private final boolean k(PointF newPosition, AttractPoint minStartAttractPoint) {
        boolean z16;
        float px5 = minStartAttractPoint.getPx() + this.dropScrollView.P();
        newPosition.x = px5;
        if (this.lastVibrateXByDrag == -1.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        this.lastVibrateXByDrag = px5;
        this.dropScrollView.setAdsorbedPoint(minStartAttractPoint, null);
        return true;
    }

    private final boolean l(AttractPoint endPoint, float expectEndPosition, AttractPoint startPoint, float expectStartPosition, PointF newPosition, m dragView) {
        float abs = Math.abs(endPoint.getPx() - expectEndPosition);
        float abs2 = Math.abs(startPoint.getPx() - expectStartPosition);
        if (abs < abs2) {
            return j(newPosition, endPoint, dragView);
        }
        if (abs > abs2) {
            return k(newPosition, startPoint);
        }
        boolean j3 = j(newPosition, endPoint, dragView) | k(newPosition, startPoint);
        this.dropScrollView.setAdsorbedPoint(startPoint, endPoint);
        return j3;
    }

    private final y m(boolean needRemoveOriginBlock, y trackModel) {
        if (needRemoveOriginBlock) {
            return trackModel;
        }
        return null;
    }

    private final void n(boolean needRemoveOriginal, y originalTrack, m iDragView, View dragView) {
        if (needRemoveOriginal) {
            Iterator<y> it = this.dropScrollView.h().iterator();
            while (it.hasNext()) {
                y next = it.next();
                if (originalTrack != next && next.l(iDragView.getDragViewModel().getId())) {
                    return;
                }
            }
            return;
        }
        H(dragView);
    }

    private final void o(boolean isSameTrack, y trackModel, m iDragView) {
        if (isSameTrack) {
            trackModel.k(iDragView.getDragViewModel());
        } else {
            this.dropScrollView.x0(iDragView.getDragViewModel());
        }
    }

    private final Pair<AttractPoint, AttractPoint> p(m dragView, float expectStartPosition, float expectEndPosition) {
        List<AttractPoint> b16 = this.dropScrollView.b(dragView.getDragViewModel().getId());
        int halfScreenWidth = this.dropScrollView.getHalfScreenWidth();
        float N = this.dropScrollView.N();
        AttractPoint attractPoint = null;
        AttractPoint attractPoint2 = null;
        for (AttractPoint attractPoint3 : b16) {
            float px5 = (attractPoint3.getPx() + halfScreenWidth) - dragView.l();
            float abs = Math.abs(expectStartPosition - px5);
            if (abs < N && (attractPoint == null || abs < Math.abs(attractPoint.getPx() - expectStartPosition))) {
                attractPoint = attractPoint3;
            }
            float abs2 = Math.abs(expectEndPosition - px5);
            if (abs2 < N && (attractPoint2 == null || abs2 < Math.abs(attractPoint2.getPx() - expectEndPosition))) {
                attractPoint2 = attractPoint3;
            }
        }
        return new Pair<>(attractPoint, attractPoint2);
    }

    private final float q(float ratio) {
        float f16 = ratio - 1.0f;
        return (f16 * f16 * f16 * f16 * f16) + 1.0f;
    }

    private final Runnable r() {
        return (Runnable) this.scrollRunnable.getValue();
    }

    private final float s(float ratio) {
        return ratio * ratio * ratio * ratio * ratio;
    }

    private final void t(DragEvent event) {
        if (event != null && event.getLocalState() != null) {
            Object localState = event.getLocalState();
            Intrinsics.checkNotNull(localState, "null cannot be cast to non-null type android.view.View");
            View view = (View) localState;
            final m a16 = n.a(view);
            if (a16 == null) {
                return;
            }
            if (!a16.k()) {
                H(view);
                return;
            }
            float y16 = view.getY();
            while (this.canAddEmptyTrackOnDrop && y16 > this.dropScrollView.h().get(this.dropScrollView.h().size() - 1).getBottom()) {
                this.dropScrollView.B(a16.getTrackType());
            }
            boolean Z = this.dropScrollView.Z();
            if (Z) {
                y16 = this.dropScrollView.B(a16.getTrackType()).getTop();
            }
            Triple<y, Boolean, Boolean> G = G(y16, a16, view);
            if (Z) {
                this.dropScrollView.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.e
                    @Override // java.lang.Runnable
                    public final void run() {
                        DragEventHandler.u(DragEventHandler.this, a16);
                    }
                });
            }
            n(G.getSecond().booleanValue(), G.getFirst(), a16, view);
            if (G.getThird().booleanValue()) {
                a16.q();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(DragEventHandler this$0, m iDragView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(iDragView, "$iDragView");
        this$0.dropScrollView.y0(iDragView);
    }

    private final void v(DragEvent event) {
        View view;
        Object localState = event.getLocalState();
        if (localState instanceof View) {
            view = (View) localState;
        } else {
            view = null;
        }
        if (view != null && !this.dragUp && this.dropScrollView.b0(view)) {
            this.dropScrollView.r0();
        }
    }

    private final void w(DragEvent event) {
        this.dropScrollView.removeCallbacks(r());
        View view = this.draggingView;
        if (view != null) {
            view.setTag(R.id.ull, null);
        }
        this.draggingView = null;
        this.scrollStartTime = 0L;
        t(event);
        Object localState = event.getLocalState();
        if (localState instanceof View) {
            H((View) localState);
        }
        this.lastVibrateXByDrag = -1.0f;
        this.lastVibrateYByDrag = -1.0f;
        this.dropScrollView.U();
        this.dropScrollView.l0();
    }

    private final void x(DragEvent event) {
        boolean z16;
        View view;
        m a16;
        PointF startTouchPoint;
        float x16 = event.getX();
        float y16 = event.getY();
        boolean z17 = true;
        if (y16 - this.dragY < 0.0f) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.dragUp = z16;
        this.dragY = y16;
        Object localState = event.getLocalState();
        if (localState instanceof View) {
            view = (View) localState;
        } else {
            view = null;
        }
        if (view == null || (a16 = n.a(view)) == null || (startTouchPoint = a16.getStartTouchPoint()) == null || !E(x16, y16)) {
            return;
        }
        i(view, x16 - startTouchPoint.x, y16 - startTouchPoint.y);
        if (this.lastVibrateXByDrag != -1.0f) {
            z17 = false;
        }
        if (z17) {
            this.dropScrollView.removeCallbacks(r());
            ViewCompat.postOnAnimation(this.dropScrollView, r());
        }
    }

    private final void y(DragEvent event) {
        View view;
        Object localState = event.getLocalState();
        if (localState instanceof View) {
            view = (View) localState;
        } else {
            view = null;
        }
        if (view != null) {
            this.startTouchPoint.set(event.getX() - this.dropScrollView.n(), event.getY());
            this.scrollStartTime = 0L;
            this.draggingView = view;
            view.bringToFront();
            m a16 = n.a(view);
            if (a16 != null) {
                this.dropScrollView.I(new com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.j(a16.getDragViewModel().getId(), view.isSelected()));
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            this.startDragPoint.set(marginLayoutParams.leftMargin + this.dropScrollView.P(), marginLayoutParams.topMargin);
            this.lastVibrateYByDrag = this.startDragPoint.y;
        }
    }

    public final void F(int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        float coerceAtLeast;
        int f16;
        int coerceAtMost;
        View view = this.draggingView;
        if (view != null) {
            int i3 = scrollX - oldScrollX;
            float x16 = view.getX() + i3;
            m a16 = n.a(view);
            if (a16 != null) {
                if (i3 <= 0) {
                    coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(x16, this.dropScrollView.P());
                } else {
                    if (a16.o()) {
                        f16 = this.dropScrollView.c();
                    } else {
                        f16 = this.dropScrollView.f();
                    }
                    coerceAtMost = RangesKt___RangesKt.coerceAtMost(a16.m(), f16);
                    if (coerceAtMost > 0) {
                        coerceAtLeast = RangesKt___RangesKt.coerceAtMost(x16, (coerceAtMost - a16.getLength()) + this.dropScrollView.P());
                    }
                    int i16 = (int) x16;
                    a16.setDragViewModel(DragViewModel.b(a16.getDragViewModel(), null, i16 - this.dropScrollView.P(), (i16 + a16.getLength()) - this.dropScrollView.P(), 0L, 0, null, null, 121, null));
                }
                x16 = coerceAtLeast;
                int i162 = (int) x16;
                a16.setDragViewModel(DragViewModel.b(a16.getDragViewModel(), null, i162 - this.dropScrollView.P(), (i162 + a16.getLength()) - this.dropScrollView.P(), 0L, 0, null, null, 121, null));
            }
            this.dropScrollView.u0((int) x16, view);
            view.setX(x16);
            view.setY(view.getY() + (scrollY - oldScrollY));
        }
    }

    public final void I(boolean canAddEmptyTrackOnDrop) {
        this.canAddEmptyTrackOnDrop = canAddEmptyTrackOnDrop;
    }

    @Override // android.view.View.OnDragListener
    public boolean onDrag(@Nullable View v3, @Nullable DragEvent event) {
        Integer num;
        if (event != null) {
            num = Integer.valueOf(event.getAction());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 1) {
            y(event);
        } else if (num != null && num.intValue() == 4) {
            w(event);
        } else if (num != null && num.intValue() == 5) {
            this.dropScrollView.U();
        } else if (num != null && num.intValue() == 6) {
            v(event);
        } else if (num != null && num.intValue() == 2) {
            x(event);
        } else if (num != null) {
            num.intValue();
        }
        return true;
    }

    public final int z(int viewSize, float viewSizeOutOfBounds) {
        float coerceAtMost;
        long currentTimeMillis = System.currentTimeMillis() - this.scrollStartTime;
        int i3 = this.maxDragScrollPerFrame;
        float abs = Math.abs(viewSizeOutOfBounds);
        float signum = Math.signum(viewSizeOutOfBounds);
        float f16 = 1.0f;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(1.0f, (abs * 1.0f) / viewSize);
        float q16 = signum * i3 * q(coerceAtMost);
        if (currentTimeMillis <= 2000) {
            f16 = ((float) currentTimeMillis) / ((float) 2000);
        }
        return (int) (q16 * s(f16));
    }
}
