package com.tencent.sqshow.zootopia.samestyle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 F2\u00020\u0001:\u0002GHB'\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\u000b\u00a2\u0006\u0004\bD\u0010EJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013J#\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u000e\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0002J\u0012\u0010\u001f\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014R\u0016\u0010\u0016\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010 R\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010!R\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010 R\u0016\u0010#\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010 R\u0016\u0010%\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010(\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0014\u00102\u001a\u00020/8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0014\u00105\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00108\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00104R\u0016\u0010;\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00103R\u0014\u0010>\u001a\u00020<8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b \u0010=\u00a8\u0006I"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar;", "Landroid/view/View;", "", "positionMs", "", "syncDraw", "", "j", "c", "Landroid/graphics/Canvas;", PM.CANVAS, "", "color", "endX", "e", tl.h.F, "", HippyTKDListViewAdapter.X, "d", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar$b;", "l", "setSeekListener", "totalLengthMs", "", "clipsStartMs", "setVideoLengthInfo", "(J[Ljava/lang/Long;)V", "g", "f", "time", "setPlayPosition", "onDraw", "J", "[Ljava/lang/Long;", "realPositionMs", "drawPositionMs", "i", "positionUpdateTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isPaused", BdhLogUtil.LogTag.Tag_Conn, "isSeekMode", "Landroid/graphics/Paint;", "D", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "E", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, UserInfo.SEX_FEMALE, "I", "clipGapWidth", "G", "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar$b;", "listener", "H", "activePointerId", "lastTouchX", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnTouchListener;", "touchListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "b", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanVideoProgressBar extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isSeekMode;

    /* renamed from: D, reason: from kotlin metadata */
    private final Paint paint;

    /* renamed from: E, reason: from kotlin metadata */
    private final Rect rect;

    /* renamed from: F, reason: from kotlin metadata */
    private final int clipGapWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private b listener;

    /* renamed from: H, reason: from kotlin metadata */
    private int activePointerId;

    /* renamed from: I, reason: from kotlin metadata */
    private float lastTouchX;

    /* renamed from: J, reason: from kotlin metadata */
    private final View.OnTouchListener touchListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long totalLengthMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Long[] clipsStartMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long realPositionMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long drawPositionMs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long positionUpdateTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPaused;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/sqshow/zootopia/samestyle/ZPlanVideoProgressBar$b;", "", "", "time", "", "c", "b", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void a(long time);

        void b(long time);

        void c(long time);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanVideoProgressBar(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final long c() {
        if (this.positionUpdateTime <= 0) {
            return this.realPositionMs;
        }
        long currentTimeMillis = (this.drawPositionMs + System.currentTimeMillis()) - this.positionUpdateTime;
        long j3 = this.realPositionMs;
        if (j3 < this.drawPositionMs) {
            j3 += this.totalLengthMs;
        }
        long min = Math.min(j3, currentTimeMillis);
        long j16 = this.totalLengthMs;
        return min > j16 ? min - j16 : min;
    }

    private final long d(float x16) {
        if (this.totalLengthMs > 0 && getWidth() > 0) {
            return (x16 / getWidth()) * ((float) this.totalLengthMs);
        }
        return -1L;
    }

    private final void e(Canvas canvas, int color, int endX) {
        int coerceIn;
        int coerceIn2;
        this.paint.setColor(color);
        int i3 = 0;
        for (Long l3 : this.clipsStartMs) {
            coerceIn = RangesKt___RangesKt.coerceIn((int) ((getWidth() * ((float) l3.longValue())) / ((float) this.totalLengthMs)), i3, endX);
            Rect rect = this.rect;
            int paddingTop = getPaddingTop();
            coerceIn2 = RangesKt___RangesKt.coerceIn(coerceIn - (this.clipGapWidth / 2), i3, endX);
            rect.set(i3, paddingTop, coerceIn2, getHeight() - getPaddingBottom());
            canvas.drawRect(this.rect, this.paint);
            i3 = RangesKt___RangesKt.coerceIn((this.clipGapWidth / 2) + coerceIn, coerceIn, endX);
        }
        this.rect.set(i3, getPaddingBottom(), endX, getHeight() - getPaddingBottom());
        canvas.drawRect(this.rect, this.paint);
    }

    private final void h() {
        invalidate();
        if (this.isPaused) {
            return;
        }
        post(new Runnable() { // from class: com.tencent.sqshow.zootopia.samestyle.aj
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanVideoProgressBar.i(ZPlanVideoProgressBar.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(ZPlanVideoProgressBar this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.isPaused) {
            return;
        }
        this$0.h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        if (r11 != 3) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean k(ZPlanVideoProgressBar this$0, View view, MotionEvent motionEvent) {
        Long l3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this$0.isSeekMode) {
                        float x16 = motionEvent.getX(motionEvent.findPointerIndex(this$0.activePointerId));
                        Long valueOf = Long.valueOf(this$0.d(x16));
                        l3 = valueOf.longValue() >= 0 ? valueOf : null;
                        if (l3 != null) {
                            long longValue = l3.longValue();
                            QLog.i("ZPlanSameStyle_SEEKBAR", 4, "action move, x = " + x16);
                            this$0.lastTouchX = x16;
                            b bVar = this$0.listener;
                            if (bVar != null) {
                                bVar.b(longValue);
                            }
                        }
                    }
                }
            }
            if (this$0.isSeekMode) {
                QLog.i("ZPlanSameStyle_SEEKBAR", 4, "action up/cancel, x = " + this$0.lastTouchX);
                Long valueOf2 = Long.valueOf(this$0.d(this$0.lastTouchX));
                l3 = valueOf2.longValue() >= 0 ? valueOf2 : null;
                if (l3 != null) {
                    long longValue2 = l3.longValue();
                    b bVar2 = this$0.listener;
                    if (bVar2 != null) {
                        bVar2.a(longValue2);
                    }
                }
                this$0.isSeekMode = false;
            }
        } else {
            float x17 = motionEvent.getX(motionEvent.getActionIndex());
            Long valueOf3 = Long.valueOf(this$0.d(x17));
            l3 = (valueOf3.longValue() > 0L ? 1 : (valueOf3.longValue() == 0L ? 0 : -1)) >= 0 ? valueOf3 : null;
            if (l3 != null) {
                long longValue3 = l3.longValue();
                QLog.i("ZPlanSameStyle_SEEKBAR", 4, "action down, x = " + x17);
                this$0.isSeekMode = true;
                this$0.lastTouchX = x17;
                this$0.activePointerId = motionEvent.getPointerId(0);
                b bVar3 = this$0.listener;
                if (bVar3 != null) {
                    bVar3.c(longValue3);
                }
            }
        }
        return this$0.isSeekMode;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        e(canvas, 872415231, getWidth());
        e(canvas, -1, (int) ((getWidth() * ((float) c())) / ((float) this.totalLengthMs)));
    }

    public final void setSeekListener(b l3) {
        this.listener = l3;
    }

    public final void setVideoLengthInfo(long totalLengthMs, Long[] clipsStartMs) {
        Intrinsics.checkNotNullParameter(clipsStartMs, "clipsStartMs");
        this.totalLengthMs = totalLengthMs;
        this.clipsStartMs = clipsStartMs;
        j(0L, true);
        invalidate();
        setOnTouchListener(this.touchListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ZPlanVideoProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void f() {
        this.isPaused = true;
        j(this.realPositionMs, true);
        h();
    }

    public final void g() {
        this.isPaused = false;
        h();
    }

    public /* synthetic */ ZPlanVideoProgressBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void setPlayPosition(long time) {
        long coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(time, 0L, this.totalLengthMs);
        j(coerceIn, this.isSeekMode);
        invalidate();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanVideoProgressBar(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.clipsStartMs = new Long[0];
        this.isPaused = true;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.paint = paint;
        this.rect = new Rect();
        this.clipGapWidth = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.activePointerId = -1;
        this.lastTouchX = -1.0f;
        this.touchListener = new View.OnTouchListener() { // from class: com.tencent.sqshow.zootopia.samestyle.ai
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean k3;
                k3 = ZPlanVideoProgressBar.k(ZPlanVideoProgressBar.this, view, motionEvent);
                return k3;
            }
        };
    }

    private final void j(long positionMs, boolean syncDraw) {
        this.drawPositionMs = syncDraw ? positionMs : this.realPositionMs;
        this.realPositionMs = positionMs;
        this.positionUpdateTime = System.currentTimeMillis();
    }
}
