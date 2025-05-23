package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o;
import com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0017\u0018\u0000 \u0082\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001.B1\b\u0007\u0012\u0006\u0010z\u001a\u00020y\u0012\n\b\u0002\u0010|\u001a\u0004\u0018\u00010{\u0012\b\b\u0002\u0010}\u001a\u00020\n\u0012\u0006\u0010\u007f\u001a\u00020~\u00a2\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0011H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0016J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\nH\u0016J\b\u0010\u001b\u001a\u00020\nH\u0016J\b\u0010\u001c\u001a\u00020\nH\u0016J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0010\u0010 \u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\bH\u0014J\u0010\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\bH\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\bH\u0016J\b\u0010'\u001a\u00020\bH\u0016J\u0012\u0010*\u001a\u00020\b2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020\u00052\u0006\u0010+\u001a\u00020\u000eH\u0016J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\bH\u0016J\u0010\u0010/\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\bH\u0016J2\u00106\u001a\u00020\u00052\b\u00101\u001a\u0004\u0018\u0001002\u0006\u00102\u001a\u00020\n2\u0006\u00103\u001a\u00020\n2\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0016J\u0012\u00109\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u000107H\u0016R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010@\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010;R$\u0010G\u001a\u0004\u0018\u0001078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u0018\u0010#\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010HR$\u0010P\u001a\u0004\u0018\u00010I8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u0016\u0010S\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\"\u0010Y\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010J\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010]\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010J\u001a\u0004\b[\u0010V\"\u0004\b\\\u0010XR\u0016\u0010_\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010=R\u0016\u0010a\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010;R\u0016\u0010c\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010JR$\u0010k\u001a\u0004\u0018\u00010d8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\"\u0010s\u001a\u00020l8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bm\u0010n\u001a\u0004\bo\u0010p\"\u0004\bq\u0010rR\"\u0010u\u001a\u00020\b8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bt\u0010R\u001a\u0004\bu\u0010v\"\u0004\bw\u0010x\u00a8\u0006\u0083\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/EffectTimelineView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timeline/TimelineView;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/o;", "Luj2/b;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/m;", "", "h1", "g1", "", ICustomDataEditor.STRING_PARAM_1, "", "i1", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/q;", "listener", "", "moveX", "p1", "", "l1", "m1", "o1", DomainData.DOMAIN_NAME, tl.h.F, "g", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "l", "p", "W0", "X0", "isLeft", "Y0", "selected", "setSelected", "valueChangeListener", "setValueChangeListener", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "o", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "rawX", "f", "left", "a", "i", "Landroid/view/View;", "scrollView", HippyTKDListViewAdapter.X, "y", "oldX", "oldY", "c", "Lrj2/a;", "scaleCalculator", "setScaleCalculator", "E", "I", "lastStartPosition", UserInfo.SEX_FEMALE, "lastEndPosition", "G", "downEndPosition", "H", "Lrj2/a;", "k1", "()Lrj2/a;", "setInnerScaleCalculator", "(Lrj2/a;)V", "innerScaleCalculator", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/q;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/u;", "J", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/u;", "getTimelineViewListener", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/u;", "setTimelineViewListener", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/u;)V", "timelineViewListener", "K", "Z", "selectedState", "L", "getFixedMaxDuration", "()J", "setFixedMaxDuration", "(J)V", "fixedMaxDuration", "M", "getSourceDurationUs", "setSourceDurationUs", "sourceDurationUs", "N", "lastMoveX", "P", "currentScrollDistance", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "minDuration", "Landroid/graphics/PointF;", BdhLogUtil.LogTag.Tag_Req, "Landroid/graphics/PointF;", "e", "()Landroid/graphics/PointF;", "setStartTouchPoint", "(Landroid/graphics/PointF;)V", "startTouchPoint", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "j", "()Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;", "setDragViewModel", "(Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/k;)V", "dragViewModel", "T", "isDragging", "()Z", "setDragging", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;", "dragModel", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/h;)V", "U", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes17.dex */
public class EffectTimelineView extends TimelineView implements o, uj2.b, m {
    private static long V = JsonGrayBusiId.UI_RESERVE_100000_110000;

    /* renamed from: E, reason: from kotlin metadata */
    private int lastStartPosition;

    /* renamed from: F, reason: from kotlin metadata */
    private int lastEndPosition;

    /* renamed from: G, reason: from kotlin metadata */
    private int downEndPosition;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private rj2.a innerScaleCalculator;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private q valueChangeListener;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private u timelineViewListener;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean selectedState;

    /* renamed from: L, reason: from kotlin metadata */
    private long fixedMaxDuration;

    /* renamed from: M, reason: from kotlin metadata */
    private long sourceDurationUs;

    /* renamed from: N, reason: from kotlin metadata */
    private float lastMoveX;

    /* renamed from: P, reason: from kotlin metadata */
    private int currentScrollDistance;

    /* renamed from: Q, reason: from kotlin metadata */
    private long minDuration;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private PointF startTouchPoint;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private DragViewModel dragViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isDragging;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EffectTimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull DragModel dragModel) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dragModel, "dragModel");
        this.minDuration = V;
        this.dragViewModel = new DragViewModel(dragModel.a(), 0, 0, 0L, 0, dragModel.getId(), this.innerScaleCalculator, 30, null);
        setTimelineListener(this);
    }

    private final void g1() {
        int coerceAtMost;
        int coerceAtMost2;
        rj2.a aVar = this.innerScaleCalculator;
        if (this.fixedMaxDuration != 0 && aVar != null) {
            int endPosition = this.dragViewModel.getEndPosition() - this.dragViewModel.getStartPosition();
            long t16 = aVar.t(endPosition);
            if (QLog.isColorLevel()) {
                QLog.i("EffectTimelineView", 2, "adjustLeftPositionWhenRightMove durationInPx:" + endPosition + ", durationInUs:" + t16);
            }
            long j3 = this.fixedMaxDuration;
            if (t16 <= j3) {
                return;
            }
            int u16 = aVar.u(this.sourceDurationUs - j3);
            int u17 = aVar.u(this.sourceDurationUs);
            int endPosition2 = this.dragViewModel.getEndPosition() - aVar.u(this.fixedMaxDuration);
            if (QLog.isColorLevel()) {
                QLog.i("EffectTimelineView", 2, "adjustLeftPositionWhenRightMove fitStartPoint:" + endPosition2 + ", dragViewModel.endPosition:" + this.dragViewModel.getEndPosition() + ", sourceDurationUs:" + this.sourceDurationUs + ", maxAutoStartPoint:" + u16 + ", maxEndPoint=" + u17);
            }
            DragViewModel dragViewModel = this.dragViewModel;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(endPosition2, u16);
            coerceAtMost2 = RangesKt___RangesKt.coerceAtMost(this.dragViewModel.getEndPosition(), u17);
            this.dragViewModel = DragViewModel.b(dragViewModel, null, coerceAtMost, coerceAtMost2, 0L, 0, null, null, 121, null);
        }
    }

    private final void h1() {
        rj2.a aVar = this.innerScaleCalculator;
        if (this.fixedMaxDuration != 0 && aVar != null) {
            int endPosition = this.dragViewModel.getEndPosition() - this.dragViewModel.getStartPosition();
            long t16 = aVar.t(endPosition);
            if (QLog.isColorLevel()) {
                QLog.i("EffectTimelineView", 2, "adjustRightPositionWhenLeftMove durationInPx:" + endPosition + ", durationInUs:" + t16);
            }
            long j3 = this.fixedMaxDuration;
            if (t16 <= j3) {
                return;
            }
            int u16 = aVar.u(j3) + this.dragViewModel.getStartPosition();
            int r16 = r();
            if (QLog.isColorLevel()) {
                QLog.i("EffectTimelineView", 2, "adjustRightPositionWhenLeftMove fitEndPoint:" + u16 + ", maxEndPoint:" + r16 + " dragViewModel.startPosition:" + this.dragViewModel.getStartPosition());
            }
            this.dragViewModel = DragViewModel.b(this.dragViewModel, null, 0, u16, 0L, 0, null, null, 123, null);
        }
    }

    private final int i1() {
        rj2.a aVar = this.innerScaleCalculator;
        if (aVar != null) {
            return aVar.u(this.minDuration);
        }
        return 0;
    }

    private final void p1(q listener, float moveX) {
        listener.d(this.dragViewModel.getEndPosition() - this.downEndPosition, false, this, false);
        this.lastMoveX = moveX;
    }

    private final boolean s1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView
    public void W0(float moveX) {
        int roundToInt;
        setDragging(true);
        q qVar = this.valueChangeListener;
        if (qVar != null) {
            if (moveX < this.lastMoveX && qVar.getIsScrollingRight()) {
                p1(qVar, moveX);
            } else if (moveX <= this.lastMoveX || !qVar.getIsScrollingLeft()) {
                roundToInt = MathKt__MathJVMKt.roundToInt(moveX - this.lastMoveX);
                int i3 = this.currentScrollDistance + roundToInt;
                this.currentScrollDistance = i3;
                Pair<Boolean, Integer> b16 = qVar.b(this, this.lastStartPosition + i3, roundToInt);
                if (b16.getFirst().booleanValue()) {
                    this.dragViewModel = DragViewModel.b(this.dragViewModel, null, b16.getSecond().intValue(), 0, 0L, 0, null, null, 125, null);
                    h1();
                    qVar.h(this);
                }
                this.lastMoveX = moveX;
            } else {
                p1(qVar, moveX);
            }
        }
        super.W0(moveX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView
    public void X0(float moveX) {
        int roundToInt;
        setDragging(true);
        q qVar = this.valueChangeListener;
        if (qVar != null) {
            if (moveX < this.lastMoveX && qVar.getIsScrollingRight()) {
                p1(qVar, moveX);
            } else if (moveX <= this.lastMoveX || !qVar.getIsScrollingLeft()) {
                roundToInt = MathKt__MathJVMKt.roundToInt(moveX - this.lastMoveX);
                int i3 = this.currentScrollDistance + roundToInt;
                this.currentScrollDistance = i3;
                int e16 = qVar.e(this, this.lastEndPosition + i3, roundToInt);
                if (e16 >= 0) {
                    this.dragViewModel = DragViewModel.b(this.dragViewModel, null, 0, e16, 0L, 0, null, null, 123, null);
                    g1();
                    qVar.h(this);
                }
                this.lastMoveX = moveX;
            } else {
                p1(qVar, moveX);
            }
        }
        super.X0(moveX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView
    public void Y0(boolean isLeft) {
        super.Y0(isLeft);
        this.lastMoveX = 0.0f;
    }

    @Override // uj2.b
    public void a(float moveX, boolean left) {
        u uVar = this.timelineViewListener;
        if (uVar != null) {
            uVar.a(moveX, left);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent event) {
        boolean z16 = false;
        if (event != null && event.getAction() == 0) {
            z16 = true;
        }
        if (z16) {
            setStartTouchPoint(new PointF(event.getX(), event.getY()));
        }
        return super.dispatchTouchEvent(event);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    @Nullable
    /* renamed from: e, reason: from getter */
    public PointF getStartTouchPoint() {
        return this.startTouchPoint;
    }

    @Override // uj2.b
    public void f(float rawX) {
        this.lastStartPosition = this.dragViewModel.getStartPosition();
        this.lastEndPosition = this.dragViewModel.getEndPosition();
        this.downEndPosition = this.dragViewModel.getEndPosition();
        this.currentScrollDistance = 0;
        this.lastMoveX = rawX;
        if (!getIsFixedLayout()) {
            f1(true);
        }
        q qVar = this.valueChangeListener;
        if (qVar != null) {
            qVar.a();
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int g() {
        rj2.a aVar = this.innerScaleCalculator;
        if (aVar != null) {
            return aVar.u(o1());
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int getLength() {
        return o.a.a(this);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int getTrackType() {
        return o.a.b(this);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int h() {
        return this.dragViewModel.getEndPosition();
    }

    @Override // uj2.b
    public void i(boolean isLeft) {
        q qVar = this.valueChangeListener;
        if (qVar != null) {
            qVar.d(this.dragViewModel.getEndPosition() - this.downEndPosition, true, this, isLeft);
        }
        u uVar = this.timelineViewListener;
        if (uVar != null) {
            uVar.d(this.dragViewModel.h(), isLeft);
        }
        if (s1()) {
            bringToFront();
        }
        setDragging(false);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    @NotNull
    /* renamed from: j, reason: from getter */
    public final DragViewModel getDragViewModel() {
        return this.dragViewModel;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public boolean k() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: k1, reason: from getter */
    public final rj2.a getInnerScaleCalculator() {
        return this.innerScaleCalculator;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int l() {
        return K0();
    }

    public long l1() {
        return -1L;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int m() {
        rj2.a aVar = this.innerScaleCalculator;
        if (aVar != null) {
            return aVar.u(m1());
        }
        return -1;
    }

    public long m1() {
        return l1();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int n() {
        return this.dragViewModel.getStartPosition();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public boolean o() {
        return true;
    }

    public long o1() {
        return -1L;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int p() {
        return K0();
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public void q() {
        u uVar = this.timelineViewListener;
        if (uVar != null) {
            uVar.c(this.dragViewModel.h());
        }
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int r() {
        rj2.a aVar = this.innerScaleCalculator;
        if (aVar != null) {
            return aVar.u(l1());
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int s() {
        return o.a.c(this);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public final void setDragViewModel(@NotNull DragViewModel dragViewModel) {
        Intrinsics.checkNotNullParameter(dragViewModel, "<set-?>");
        this.dragViewModel = dragViewModel;
    }

    public void setDragging(boolean z16) {
        this.isDragging = z16;
    }

    public final void setFixedMaxDuration(long j3) {
        this.fixedMaxDuration = j3;
    }

    public void setScaleCalculator(@Nullable rj2.a scaleCalculator) {
        this.innerScaleCalculator = scaleCalculator;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timeline.TimelineView, android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected && s1()) {
            bringToFront();
        }
        if (this.selectedState == selected) {
            return;
        }
        this.selectedState = selected;
        q qVar = this.valueChangeListener;
        if (qVar != null) {
            qVar.g(this, selected);
        }
        u uVar = this.timelineViewListener;
        if (uVar != null) {
            uVar.b(selected, this);
        }
    }

    public final void setSourceDurationUs(long j3) {
        this.sourceDurationUs = j3;
    }

    public void setStartTouchPoint(@Nullable PointF pointF) {
        this.startTouchPoint = pointF;
    }

    public final void setTimelineViewListener(@Nullable u uVar) {
        this.timelineViewListener = uVar;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public void setValueChangeListener(@Nullable q valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.o
    public int t() {
        return i1();
    }

    public void u1(@NotNull DragModel dragModel) {
        o.a.d(this, dragModel);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.m
    public void c(@Nullable View scrollView, int x16, int y16, int oldX, int oldY) {
    }
}
