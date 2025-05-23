package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Scroller;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.videocut.utils.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rj2.ScalePoint;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0001VB)\b\u0007\u0012\b\u0010O\u001a\u0004\u0018\u00010N\u0012\n\b\u0002\u0010Q\u001a\u0004\u0018\u00010P\u0012\b\b\u0002\u0010R\u001a\u00020\u0005\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\bH\u0014J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0014J\u000e\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0005J\u0012\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\u0014\u0010\u0019\u001a\u00020\u00032\n\u0010\u0018\u001a\u0006\u0012\u0002\b\u00030\u0017H\u0016R\u0016\u0010\u001c\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010!\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001bR\u0016\u0010\u000e\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0016\u0010\u0010\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001bR\u0014\u0010&\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010%R\u0014\u0010(\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010%R\u001a\u0010,\u001a\u00020$8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00103\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010B\u001a\u00020<8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b\"\u0010?\"\u0004\b@\u0010AR\u0014\u0010E\u001a\u00020C8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010DR\u0014\u0010H\u001a\u00020F8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u0010GR\u001b\u0010M\u001a\u00020I8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\b#\u0010L\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timebar/TimeBarView;", "Landroid/view/View;", "Lpj2/b;", "", DomainData.DOMAIN_NAME, "", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Lrj2/a;", "scaleCalculator", "f", "textSize", "setTextSize", "textColor", "setTextColor", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "computeScroll", "Lpj2/a;", "controller", "o", "d", "I", "timeBarStatX", "", "e", UserInfo.SEX_FEMALE, "singleTextSize", "pointSize", h.F, "i", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "paint", BdhLogUtil.LogTag.Tag_Conn, "redPaint", "D", "k", "()Landroid/graphics/Paint;", "tipPaint", "Landroid/widget/Scroller;", "E", "Landroid/widget/Scroller;", "scroller", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timebar/b;", "Lcom/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timebar/b;", "timelineViewController", "", "G", "J", "g", "()J", "setMaxDurationLimit", "(J)V", "maxDurationLimit", "", "H", "Ljava/lang/String;", "()Ljava/lang/String;", "setMaxDurationLimitTip", "(Ljava/lang/String;)V", "maxDurationLimitTip", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "listener", "Landroid/view/GestureDetector$OnGestureListener;", "Landroid/view/GestureDetector$OnGestureListener;", "onScrollGestureListener", "Landroid/view/GestureDetector;", "K", "Lkotlin/Lazy;", "()Landroid/view/GestureDetector;", "scrollGestureDetector", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public class TimeBarView extends View implements pj2.b {

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
    private com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b timelineViewController;

    /* renamed from: G, reason: from kotlin metadata */
    private long maxDurationLimit;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String maxDurationLimitTip;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final DynamicAnimation.OnAnimationUpdateListener listener;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final GestureDetector.OnGestureListener onScrollGestureListener;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy scrollGestureDetector;

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
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J,\u0010\u000b\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J,\u0010\u000e\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\bH\u0016J\u0012\u0010\u000f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/timebar/TimeBarView$b", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "", "onDown", "e1", "e2", "", "velocityX", "velocityY", "onFling", "distanceX", "distanceY", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, "onSingleTapUp", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b extends GestureDetector.SimpleOnGestureListener {
        b() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(@Nullable MotionEvent e16) {
            tj2.a h16;
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar = TimeBarView.this.timelineViewController;
            if (bVar != null && (h16 = bVar.h()) != null) {
                h16.c();
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float velocityX, float velocityY) {
            tj2.a h16;
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar = TimeBarView.this.timelineViewController;
            if (bVar != null && (h16 = bVar.h()) != null) {
                h16.b(-velocityX, TimeBarView.this.getScrollX(), TimeBarView.this.m(), TimeBarView.this.listener);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(@Nullable MotionEvent e16, @Nullable MotionEvent e26, float distanceX, float distanceY) {
            tj2.a h16;
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar = TimeBarView.this.timelineViewController;
            if (bVar != null && (h16 = bVar.h()) != null) {
                h16.c();
            }
            int scrollX = TimeBarView.this.getScrollX() + ((int) distanceX);
            if (scrollX < 0) {
                scrollX = 0;
            } else if (scrollX > TimeBarView.this.m()) {
                scrollX = TimeBarView.this.m();
            }
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar2 = TimeBarView.this.timelineViewController;
            if (bVar2 != null) {
                bVar2.p(scrollX);
            }
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(@Nullable MotionEvent e16) {
            com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar = TimeBarView.this.timelineViewController;
            if (bVar != null) {
                bVar.j().a(new com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.panel.event.h());
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
    public static final void l(TimeBarView this$0, DynamicAnimation dynamicAnimation, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar = this$0.timelineViewController;
        if (bVar != null) {
            bVar.p((int) f16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int m() {
        rj2.a l3;
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar = this.timelineViewController;
        if (bVar != null && (l3 = bVar.l()) != null) {
            return l3.c();
        }
        return 0;
    }

    private final void n() {
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

    protected void f(@NotNull Canvas canvas, @NotNull rj2.a scaleCalculator) {
        ScalePoint scalePoint;
        boolean z16;
        ScalePoint scalePoint2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(scaleCalculator, "scaleCalculator");
        int size = scaleCalculator.h().size();
        int height = getHeight() / 2;
        Paint.FontMetrics fontMetrics = this.paint.getFontMetrics();
        float f16 = height;
        float f17 = fontMetrics.bottom;
        float f18 = 2;
        float f19 = (((f17 - fontMetrics.top) / f18) + f16) - f17;
        int i3 = 0;
        while (true) {
            if (i3 < size) {
                ScalePoint scalePoint3 = scaleCalculator.h().get(i3);
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
                        String j3 = scaleCalculator.j(scalePoint3);
                        if (TextUtils.isEmpty(j3)) {
                            continue;
                        } else {
                            float measureText = this.paint.measureText(j3);
                            if (scaleCalculator.i(scalePoint3) == this.maxDurationLimit) {
                                if (i3 < size - 1) {
                                    scalePoint2 = scaleCalculator.h().get(i3);
                                } else {
                                    scalePoint2 = null;
                                }
                                canvas.drawText(j3, 0, j3.length(), perSpace - (measureText / f18), f19, this.redPaint);
                                scalePoint = scalePoint2;
                            } else {
                                canvas.drawText(j3, 0, j3.length(), perSpace - (measureText / f18), f19, this.paint);
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
            float perSpace2 = this.timeBarStatX + (scaleCalculator.getPerSpace() * scalePoint.getPosition()) + e.f384236a.a(18.0f);
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

    @Override // pj2.b
    public void o(@NotNull pj2.a<?> controller) {
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar;
        Intrinsics.checkNotNullParameter(controller, "controller");
        if (controller instanceof com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b) {
            bVar = (com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b) controller;
        } else {
            bVar = null;
        }
        this.timelineViewController = bVar;
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        rj2.a l3;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.b bVar = this.timelineViewController;
        if (bVar != null && (l3 = bVar.l()) != null) {
            n();
            if (this.timeBarStatX == 0) {
                this.timeBarStatX = j();
            }
            f(canvas, l3);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        return i().onTouchEvent(event);
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

    public /* synthetic */ TimeBarView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    @JvmOverloads
    public TimeBarView(@Nullable final Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Lazy lazy;
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
        this.listener = new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.a
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f16, float f17) {
                TimeBarView.l(TimeBarView.this, dynamicAnimation, f16, f17);
            }
        };
        this.onScrollGestureListener = new b();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GestureDetector>() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.timebar.TimeBarView$scrollGestureDetector$2
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
}
