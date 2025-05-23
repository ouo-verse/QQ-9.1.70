package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop;

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
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView;
import com.tencent.qqnt.kernel.nativeinterface.JsonGrayBusiId;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 x2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001-B9\b\u0007\u0012\u0006\u0010o\u001a\u00020n\u0012\n\b\u0002\u0010q\u001a\u0004\u0018\u00010p\u0012\b\b\u0002\u0010r\u001a\u00020\u0007\u0012\u0006\u0010t\u001a\u00020s\u0012\b\b\u0002\u0010u\u001a\u00020\u0007\u00a2\u0006\u0004\bv\u0010wJ\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\b\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001b\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u0010\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0005H\u0014J\u0010\u0010 \u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u0005H\u0016J\u0012\u0010\"\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010#\u001a\u00020\rH\u0016J\b\u0010$\u001a\u00020\rH\u0016J\b\u0010%\u001a\u00020\u0005H\u0016J\b\u0010&\u001a\u00020\u0005H\u0016J\u0012\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010+\u001a\u00020\r2\u0006\u0010*\u001a\u00020\u000bH\u0016J\u0018\u0010-\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0005H\u0016J\u0010\u0010.\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J2\u00105\u001a\u00020\r2\b\u00100\u001a\u0004\u0018\u00010/2\u0006\u00101\u001a\u00020\u00072\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u0007H\u0016J\u0012\u00108\u001a\u00020\r2\b\u00107\u001a\u0004\u0018\u000106H\u0016R\u0016\u0010;\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010=\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010:R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010:R$\u0010E\u001a\u0004\u0018\u0001068\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0018\u0010!\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR$\u0010O\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010R\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010T\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u00109R\u0016\u0010V\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010:R\u0016\u0010X\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010FR$\u0010`\u001a\u0004\u0018\u00010Y8\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\"\u0010h\u001a\u00020a8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010c\u001a\u0004\bd\u0010e\"\u0004\bf\u0010gR\"\u0010j\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010Q\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m\u00a8\u0006y"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/EffectTimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timeline/TimelineView;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/m;", "Lk63/b;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/k;", "", "m1", "", "f1", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/o;", "listener", "", "moveX", "", "l1", "", "h1", "i1", "k1", DomainData.DOMAIN_NAME, tl.h.F, "g", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "l", "p", "V0", "W0", "isLeft", "X0", "selected", "setSelected", "valueChangeListener", "setValueChangeListener", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k", "o", "Landroid/view/MotionEvent;", "event", "dispatchTouchEvent", "rawX", "f", "left", "a", "i", "Landroid/view/View;", "scrollView", HippyTKDListViewAdapter.X, "y", "oldX", "oldY", "c", "Li63/b;", "scaleCalculator", "setScaleCalculator", UserInfo.SEX_FEMALE, "I", "lastStartPosition", "G", "lastEndPosition", "H", "downEndPosition", "Li63/b;", "g1", "()Li63/b;", "setInnerScaleCalculator", "(Li63/b;)V", "innerScaleCalculator", "J", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/o;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/u;", "K", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/u;", "getTimelineViewListener", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/u;", "setTimelineViewListener", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/u;)V", "timelineViewListener", "L", "Z", "selectedState", "M", "lastMoveX", "N", "currentScrollDistance", "P", "minDuration", "Landroid/graphics/PointF;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/graphics/PointF;", "e", "()Landroid/graphics/PointF;", "setStartTouchPoint", "(Landroid/graphics/PointF;)V", "startTouchPoint", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", "j", "()Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;", "setDragViewModel", "(Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/i;)V", "dragViewModel", ExifInterface.LATITUDE_SOUTH, "isDragging", "()Z", "setDragging", "(Z)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/f;", "dragModel", "selectedStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/dragdrop/f;I)V", "U", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes21.dex */
public class EffectTimelineView extends TimelineView implements m, k63.b, k {
    private static long V = JsonGrayBusiId.UI_RESERVE_100000_110000;

    /* renamed from: F, reason: from kotlin metadata */
    private int lastStartPosition;

    /* renamed from: G, reason: from kotlin metadata */
    private int lastEndPosition;

    /* renamed from: H, reason: from kotlin metadata */
    private int downEndPosition;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private i63.b innerScaleCalculator;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private o valueChangeListener;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private u timelineViewListener;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean selectedState;

    /* renamed from: M, reason: from kotlin metadata */
    private float lastMoveX;

    /* renamed from: N, reason: from kotlin metadata */
    private int currentScrollDistance;

    /* renamed from: P, reason: from kotlin metadata */
    private long minDuration;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private PointF startTouchPoint;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private DragViewModel dragViewModel;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isDragging;

    @NotNull
    public Map<Integer, View> T;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public EffectTimelineView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull DragModel dragModel, int i16) {
        super(context, attributeSet, i3, i16);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dragModel, "dragModel");
        this.T = new LinkedHashMap();
        this.minDuration = V;
        this.dragViewModel = new DragViewModel(dragModel.a(), 0, 0, 0L, 0, dragModel.getId(), this.innerScaleCalculator, 30, null);
        setTimelineListener(this);
    }

    private final int f1() {
        i63.b bVar = this.innerScaleCalculator;
        if (bVar != null) {
            return bVar.y(this.minDuration);
        }
        return 0;
    }

    private final void l1(o listener, float moveX) {
        listener.d(this.dragViewModel.getEndPosition() - this.downEndPosition, false, this, false);
        this.lastMoveX = moveX;
    }

    private final boolean m1() {
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public void B() {
        this.lastStartPosition = this.dragViewModel.getStartPosition();
        this.lastEndPosition = this.dragViewModel.getEndPosition();
        this.currentScrollDistance = 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView
    public void V0(float moveX) {
        int roundToInt;
        super.V0(moveX);
        setDragging(true);
        o oVar = this.valueChangeListener;
        if (oVar != null) {
            if (moveX < this.lastMoveX && oVar.getIsScrollingRight()) {
                l1(oVar, moveX);
                return;
            }
            if (moveX <= this.lastMoveX || !oVar.getIsScrollingLeft()) {
                roundToInt = MathKt__MathJVMKt.roundToInt(moveX - this.lastMoveX);
                int i3 = this.currentScrollDistance + roundToInt;
                this.currentScrollDistance = i3;
                Pair<Boolean, Integer> b16 = oVar.b(this, this.lastStartPosition + i3, roundToInt);
                if (b16.getFirst().booleanValue()) {
                    this.dragViewModel = DragViewModel.b(this.dragViewModel, null, b16.getSecond().intValue(), 0, 0L, 0, null, null, 125, null);
                    oVar.h(this);
                }
                this.lastMoveX = moveX;
                return;
            }
            l1(oVar, moveX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView
    public void W0(float moveX) {
        int roundToInt;
        super.W0(moveX);
        setDragging(true);
        o oVar = this.valueChangeListener;
        if (oVar != null) {
            if (moveX < this.lastMoveX && oVar.getIsScrollingRight()) {
                l1(oVar, moveX);
                return;
            }
            if (moveX <= this.lastMoveX || !oVar.getIsScrollingLeft()) {
                roundToInt = MathKt__MathJVMKt.roundToInt(moveX - this.lastMoveX);
                int i3 = this.currentScrollDistance + roundToInt;
                this.currentScrollDistance = i3;
                int e16 = oVar.e(this, this.lastEndPosition + i3, roundToInt);
                if (e16 >= 0) {
                    this.dragViewModel = DragViewModel.b(this.dragViewModel, null, 0, e16, 0L, 0, null, null, 123, null);
                    oVar.h(this);
                }
                this.lastMoveX = moveX;
                return;
            }
            l1(oVar, moveX);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView
    public void X0(boolean isLeft) {
        super.X0(isLeft);
        this.lastMoveX = 0.0f;
    }

    @Override // k63.b
    public void a(float moveX, boolean left) {
        o oVar = this.valueChangeListener;
        if (oVar != null) {
            oVar.g(moveX, left);
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

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    @Nullable
    /* renamed from: e, reason: from getter */
    public PointF getStartTouchPoint() {
        return this.startTouchPoint;
    }

    @Override // k63.b
    public void f(float rawX) {
        this.lastStartPosition = this.dragViewModel.getStartPosition();
        this.lastEndPosition = this.dragViewModel.getEndPosition();
        this.downEndPosition = this.dragViewModel.getEndPosition();
        this.currentScrollDistance = 0;
        this.lastMoveX = rawX;
        o oVar = this.valueChangeListener;
        if (oVar != null) {
            oVar.a();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int g() {
        i63.b bVar = this.innerScaleCalculator;
        if (bVar != null) {
            return bVar.y(k1());
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    /* renamed from: g1, reason: from getter */
    public final i63.b getInnerScaleCalculator() {
        return this.innerScaleCalculator;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int getLength() {
        return m.a.a(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int getTrackType() {
        return m.a.b(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int h() {
        return this.dragViewModel.getEndPosition();
    }

    public long h1() {
        return -1L;
    }

    @Override // k63.b
    public void i(boolean isLeft) {
        o oVar = this.valueChangeListener;
        if (oVar != null) {
            oVar.d(this.dragViewModel.getEndPosition() - this.downEndPosition, true, this, isLeft);
        }
        u uVar = this.timelineViewListener;
        if (uVar != null) {
            uVar.c(this.dragViewModel.h(), isLeft);
        }
        if (m1()) {
            bringToFront();
        }
        setDragging(false);
        this.downEndPosition = 0;
    }

    public long i1() {
        return h1();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    @NotNull
    /* renamed from: j, reason: from getter */
    public final DragViewModel getDragViewModel() {
        return this.dragViewModel;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public boolean k() {
        return true;
    }

    public long k1() {
        return -1L;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int l() {
        return K0();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int m() {
        i63.b bVar = this.innerScaleCalculator;
        if (bVar != null) {
            return bVar.y(i1());
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int n() {
        return this.dragViewModel.getStartPosition();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public boolean o() {
        return true;
    }

    public void o1(@NotNull DragModel dragModel) {
        m.a.d(this, dragModel);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int p() {
        return K0();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public void q() {
        u uVar = this.timelineViewListener;
        if (uVar != null) {
            uVar.a(this.dragViewModel.h());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int r() {
        i63.b bVar = this.innerScaleCalculator;
        if (bVar != null) {
            return bVar.y(h1());
        }
        return -1;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int s() {
        return m.a.c(this);
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public final void setDragViewModel(@NotNull DragViewModel dragViewModel) {
        Intrinsics.checkNotNullParameter(dragViewModel, "<set-?>");
        this.dragViewModel = dragViewModel;
    }

    public void setDragging(boolean z16) {
        this.isDragging = z16;
    }

    public void setScaleCalculator(@Nullable i63.b scaleCalculator) {
        this.innerScaleCalculator = scaleCalculator;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timeline.TimelineView, android.view.View
    public void setSelected(boolean selected) {
        super.setSelected(selected);
        if (selected && m1()) {
            bringToFront();
        }
        if (this.selectedState == selected) {
            return;
        }
        this.selectedState = selected;
        o oVar = this.valueChangeListener;
        if (oVar != null) {
            oVar.i(this, selected);
        }
        u uVar = this.timelineViewListener;
        if (uVar != null) {
            uVar.b(selected, this);
        }
    }

    public void setStartTouchPoint(@Nullable PointF pointF) {
        this.startTouchPoint = pointF;
    }

    public final void setTimelineViewListener(@Nullable u uVar) {
        this.timelineViewListener = uVar;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public void setValueChangeListener(@Nullable o valueChangeListener) {
        this.valueChangeListener = valueChangeListener;
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.m
    public int t() {
        return f1();
    }

    @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.dragdrop.k
    public void c(@Nullable View scrollView, int x16, int y16, int oldX, int oldY) {
    }
}
