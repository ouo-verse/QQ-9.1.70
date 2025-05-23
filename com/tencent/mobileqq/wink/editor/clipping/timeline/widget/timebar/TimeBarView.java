package com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.PanelEventHandler;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.d;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.e;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.event.k;
import com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import i63.ScalePoint;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0095\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001E\b\u0016\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001YB)\b\u0007\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\n\b\u0002\u0010T\u001a\u0004\u0018\u00010S\u0012\b\b\u0002\u0010U\u001a\u00020\u0005\u00a2\u0006\u0004\bV\u0010WJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0014\u0010\u0019\u001a\u00020\u00032\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010%R\u0014\u0010(\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u001a\u0010,\u001a\u00020$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b\"\u0010?\"\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010CR\u0014\u0010G\u001a\u00020E8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010FR\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u001b\u0010P\u001a\u00020L8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\b#\u0010O\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView;", "Landroid/view/View;", "Lf63/b;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "j", "l", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Li63/b;", "scaleCalculator", "f", "textSize", "setTextSize", "textColor", "setTextColor", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "computeScroll", "Lf63/a;", "controller", ReportConstant.COSTREPORT_PREFIX, "d", "I", "timeBarStatX", "", "e", UserInfo.SEX_FEMALE, "singleTextSize", "pointSize", h.F, "i", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", BdhLogUtil.LogTag.Tag_Conn, "redPaint", "D", "k", "()Landroid/graphics/Paint;", "tipPaint", "Landroid/widget/Scroller;", "E", "Landroid/widget/Scroller;", "scroller", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/a;", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/a;", "timelineViewController", "", "G", "J", "g", "()J", "setMaxDurationLimit", "(J)V", "maxDurationLimit", "", "H", "Ljava/lang/String;", "()Ljava/lang/String;", "setMaxDurationLimitTip", "(Ljava/lang/String;)V", "maxDurationLimitTip", "Z", "isInUserScroll", "com/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView$b;", "listener", "Landroid/view/GestureDetector$OnGestureListener;", "K", "Landroid/view/GestureDetector$OnGestureListener;", "onScrollGestureListener", "Landroid/view/GestureDetector;", "L", "Lkotlin/Lazy;", "()Landroid/view/GestureDetector;", "scrollGestureDetector", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "N", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class TimeBarView extends View implements f63.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Paint redPaint;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Paint tipPaint;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private Scroller scroller;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private a timelineViewController;

    /* renamed from: G, reason: from kotlin metadata */
    private long maxDurationLimit;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String maxDurationLimitTip;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isInUserScroll;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final b listener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final GestureDetector.OnGestureListener onScrollGestureListener;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy scrollGestureDetector;

    @NotNull
    public Map<Integer, View> M;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int timeBarStatX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float singleTextSize;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int pointSize;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int textSize;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int textColor;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView$b", "Lcom/tencent/mobileqq/wink/editor/clipping/timeline/widget/panel/scroll/FlingHelper$a;", "", "xPos", "", "b", "", "cancel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements FlingHelper.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void a(int xPos, boolean cancel) {
            PanelEventHandler k3;
            TimeBarView.this.isInUserScroll = false;
            a aVar = TimeBarView.this.timelineViewController;
            if (aVar != null && (k3 = aVar.k()) != null) {
                k3.a(new d(cancel));
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.panel.scroll.FlingHelper.a
        public void b(int xPos) {
            a aVar = TimeBarView.this.timelineViewController;
            if (aVar != null) {
                aVar.r(xPos);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/clipping/timeline/widget/timebar/TimeBarView$c", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "e1", "e2", "", "velocityX", "velocityY", "onFling", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "onSingleTapUp", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends GestureDetector.SimpleOnGestureListener {
        c() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent e16) {
            PanelEventHandler k3;
            FlingHelper i3;
            a aVar = TimeBarView.this.timelineViewController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.g();
            }
            a aVar2 = TimeBarView.this.timelineViewController;
            if (aVar2 != null && (k3 = aVar2.k()) != null) {
                k3.a(new e());
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            FlingHelper i3;
            a aVar = TimeBarView.this.timelineViewController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.f(-((int) velocityX), TimeBarView.this.getScrollX(), TimeBarView.this.l(), TimeBarView.this.listener);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
            FlingHelper i3;
            a aVar = TimeBarView.this.timelineViewController;
            if (aVar != null && (i3 = aVar.i()) != null) {
                i3.g();
            }
            int scrollX = TimeBarView.this.getScrollX() + ((int) distanceX);
            if (scrollX < 0) {
                scrollX = 0;
            } else if (scrollX > TimeBarView.this.l()) {
                scrollX = TimeBarView.this.l();
            }
            a aVar2 = TimeBarView.this.timelineViewController;
            if (aVar2 != null) {
                aVar2.r(scrollX);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            a aVar = TimeBarView.this.timelineViewController;
            if (aVar != null) {
                aVar.k().a(new k());
            }
            return super.onSingleTapUp(e16);
        }
    }

    @JvmOverloads
    public TimeBarView(@Nullable Context context) {
        this(context, null, 0, 6, null);
    }

    private final GestureDetector i() {
        return (GestureDetector) this.scrollGestureDetector.getValue();
    }

    private final int j() {
        return getMeasuredWidth() / 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int l() {
        i63.b m3;
        a aVar = this.timelineViewController;
        if (aVar != null && (m3 = aVar.m()) != null) {
            return m3.d();
        }
        return 0;
    }

    private final void m() {
        this.paint.setColor(this.textColor);
        this.paint.setStrokeWidth(1.0f);
        this.paint.setTextSize(this.textSize);
        this.paint.setAntiAlias(true);
        this.redPaint.setColor(getResources().getColor(R.color.bdq));
        this.redPaint.setStrokeWidth(1.0f);
        this.redPaint.setTextSize(this.textSize);
        this.redPaint.setAntiAlias(true);
        this.tipPaint.setColor(getResources().getColor(R.color.bdq));
        this.tipPaint.setStrokeWidth(1.0f);
        this.tipPaint.setTextSize(this.textSize);
        this.tipPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    public void computeScroll() {
        Scroller scroller = this.scroller;
        if (scroller != null && scroller.computeScrollOffset()) {
            scrollTo(scroller.getCurrX(), scroller.getCurrY());
            postInvalidate();
        }
        super.computeScroll();
    }

    protected void f(@NotNull Canvas canvas, @NotNull i63.b scaleCalculator) {
        ScalePoint scalePoint;
        boolean z16;
        ScalePoint scalePoint2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(scaleCalculator, "scaleCalculator");
        int size = scaleCalculator.i().size();
        int height = getHeight() / 2;
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        float f16 = height;
        float f17 = fontMetrics.bottom;
        float f18 = 2;
        float f19 = (((f17 - fontMetrics.top) / f18) + f16) - f17;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                ScalePoint scalePoint3 = scaleCalculator.i().get(i3);
                float perSpace = this.timeBarStatX + (scaleCalculator.getPerSpace() * scalePoint3.getPosition());
                if (this.singleTextSize == 0.0f) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    this.singleTextSize = this.paint.measureText("M");
                }
                float f26 = this.singleTextSize * 5;
                if (perSpace >= getScrollX() - f26 && perSpace <= getScrollX() + getWidth() + f26) {
                    if (scalePoint3.getType() == 1) {
                        canvas.drawCircle(perSpace, f16, this.pointSize, this.paint);
                    } else if (scalePoint3.getType() == 0) {
                        String k3 = scaleCalculator.k(scalePoint3);
                        if (TextUtils.isEmpty(k3)) {
                            continue;
                        } else {
                            float measureText = this.paint.measureText(k3);
                            if (scaleCalculator.j(scalePoint3) == this.maxDurationLimit) {
                                if (i3 < size - 1) {
                                    scalePoint2 = scaleCalculator.i().get(i3);
                                } else {
                                    scalePoint2 = null;
                                }
                                canvas.drawText(k3, 0, k3.length(), perSpace - (measureText / f18), f19, this.redPaint);
                                scalePoint = scalePoint2;
                            } else {
                                canvas.drawText(k3, 0, k3.length(), perSpace - (measureText / f18), f19, this.paint);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                i3++;
            } else {
                scalePoint = null;
                break;
            }
        }
        if (scalePoint != null) {
            float perSpace2 = this.timeBarStatX + (scaleCalculator.getPerSpace() * scalePoint.getPosition()) + com.tencent.videocut.utils.e.f384236a.a(18.0f);
            if (!TextUtils.isEmpty(this.maxDurationLimitTip)) {
                canvas.drawText(this.maxDurationLimitTip, 0, this.maxDurationLimitTip.length(), perSpace2, f19, this.tipPaint);
            }
        }
    }

    /* renamed from: g, reason: from getter */
    public final long getMaxDurationLimit() {
        return this.maxDurationLimit;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getMaxDurationLimitTip() {
        return this.maxDurationLimitTip;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @NotNull
    /* renamed from: k, reason: from getter */
    public final Paint getTipPaint() {
        return this.tipPaint;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        i63.b m3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        a aVar = this.timelineViewController;
        if (aVar != null && (m3 = aVar.m()) != null) {
            m();
            if (this.timeBarStatX == 0) {
                this.timeBarStatX = j();
            }
            f(canvas, m3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        PanelEventHandler k3;
        PanelEventHandler k16;
        FlingHelper i3;
        Intrinsics.checkNotNullParameter(event, "event");
        boolean onTouchEvent = i().onTouchEvent(event);
        int action = event.getAction();
        boolean z16 = true;
        if (action != 0) {
            if (action == 1 || action == 3) {
                a aVar = this.timelineViewController;
                if (aVar == null || (i3 = aVar.i()) == null || !i3.d()) {
                    z16 = false;
                }
                if (!z16) {
                    this.isInUserScroll = false;
                    a aVar2 = this.timelineViewController;
                    if (aVar2 != null && (k16 = aVar2.k()) != null) {
                        k16.a(new d(false));
                    }
                }
            }
        } else {
            this.isInUserScroll = true;
            a aVar3 = this.timelineViewController;
            if (aVar3 != null && (k3 = aVar3.k()) != null) {
                k3.a(new e());
            }
        }
        return onTouchEvent;
    }

    @Override // f63.b
    public void s(@NotNull f63.a<?> controller) {
        a aVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (controller instanceof a) {
            aVar = (a) controller;
        } else {
            aVar = null;
        }
        this.timelineViewController = aVar;
    }

    public final void setMaxDurationLimit(long j3) {
        this.maxDurationLimit = j3;
    }

    public final void setMaxDurationLimitTip(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.maxDurationLimitTip = str;
    }

    public final void setTextColor(int textColor) {
        this.textColor = textColor;
    }

    public final void setTextSize(int textSize) {
        this.textSize = textSize;
    }

    @JvmOverloads
    public TimeBarView(@Nullable Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TimeBarView(@Nullable final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
        this.M = new LinkedHashMap();
        this.pointSize = 3;
        this.textColor = -1;
        this.paint = new Paint();
        this.redPaint = new Paint();
        this.tipPaint = new Paint();
        this.maxDurationLimit = TTL.MAX_VALUE;
        this.maxDurationLimitTip = "";
        this.textSize = getResources().getDimensionPixelSize(R.dimen.deb);
        this.pointSize = getResources().getDimensionPixelSize(R.dimen.de9);
        this.textColor = getResources().getColor(R.color.bfq);
        this.scroller = new Scroller(context);
        this.listener = new b();
        this.onScrollGestureListener = new c();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.wink.editor.clipping.timeline.widget.timebar.TimeBarView$scrollGestureDetector$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GestureDetector invoke() {
                GestureDetector.OnGestureListener onGestureListener;
                Context context2 = context;
                onGestureListener = this.onScrollGestureListener;
                return new GestureDetector(context2, onGestureListener);
            }
        });
        this.scrollGestureDetector = lazy;
    }

    public /* synthetic */ TimeBarView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }
}
