package com.tencent.mobileqq.wink.editor;

import android.annotation.SuppressLint;
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
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 C2\u00020\u0001:\u0002D\bB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u000b\u00a2\u0006\u0004\bA\u0010BJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J#\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0002J\u0012\u0010\u001c\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001dR\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001eR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001dR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010'\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010&R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0014\u00104\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00106\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00103R\u0016\u00108\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00102R\u0014\u0010;\u001a\u0002098\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010:\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkVideoProgressBar;", "Landroid/view/View;", "", "positionMs", "", "syncDraw", "", "e", "b", "Landroid/graphics/Canvas;", PM.CANVAS, "", "color", "endX", "d", "", HippyTKDListViewAdapter.X, "c", "Lcom/tencent/mobileqq/wink/editor/WinkVideoProgressBar$b;", "l", "setSeekListener", "totalLengthMs", "", "clipsStartMs", "setVideoLengthInfo", "(J[Ljava/lang/Long;)V", "time", "setPlayPosition", "onDraw", "J", "[Ljava/lang/Long;", "f", "realPositionMs", tl.h.F, "drawPositionMs", "i", "positionUpdateTime", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "isPaused", BdhLogUtil.LogTag.Tag_Conn, "isSeekMode", "Landroid/graphics/Paint;", "D", "Landroid/graphics/Paint;", "paint", "Landroid/graphics/Rect;", "E", "Landroid/graphics/Rect;", CanvasView.ACTION_RECT, UserInfo.SEX_FEMALE, "I", "clipGapWidth", "G", "activePointerId", "H", "lastTouchX", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnTouchListener;", "touchListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "K", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkVideoProgressBar extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isSeekMode;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final Paint paint;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final Rect rect;

    /* renamed from: F, reason: from kotlin metadata */
    private final int clipGapWidth;

    /* renamed from: G, reason: from kotlin metadata */
    private int activePointerId;

    /* renamed from: H, reason: from kotlin metadata */
    private float lastTouchX;

    /* renamed from: I, reason: from kotlin metadata */
    @SuppressLint({"ClickableViewAccessibility"})
    @NotNull
    private final View.OnTouchListener touchListener;

    @NotNull
    public Map<Integer, View> J;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long totalLengthMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Long[] clipsStartMs;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private long realPositionMs;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private long drawPositionMs;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long positionUpdateTime;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isPaused;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/WinkVideoProgressBar$b;", "", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface b {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkVideoProgressBar(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final long b() {
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
        if (min > j16) {
            return min - j16;
        }
        return min;
    }

    private final long c(float x16) {
        if (this.totalLengthMs <= 0 || getWidth() <= 0) {
            return -1L;
        }
        return (x16 / getWidth()) * ((float) this.totalLengthMs);
    }

    private final void d(Canvas canvas, int color, int endX) {
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

    private final void e(long positionMs, boolean syncDraw) {
        long j3;
        if (syncDraw) {
            j3 = positionMs;
        } else {
            j3 = this.realPositionMs;
        }
        this.drawPositionMs = j3;
        this.realPositionMs = positionMs;
        this.positionUpdateTime = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001b, code lost:
    
        if (r11 != 3) goto L38;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean f(WinkVideoProgressBar this$0, View view, MotionEvent motionEvent) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int actionMasked = motionEvent.getActionMasked();
        Long l3 = null;
        boolean z17 = false;
        boolean z18 = true;
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    if (this$0.isSeekMode) {
                        float x16 = motionEvent.getX(motionEvent.findPointerIndex(this$0.activePointerId));
                        Long valueOf = Long.valueOf(this$0.c(x16));
                        if (valueOf.longValue() >= 0) {
                            z17 = true;
                        }
                        if (z17) {
                            l3 = valueOf;
                        }
                        if (l3 != null) {
                            l3.longValue();
                            QLog.i("WinkVideoProgressBar", 4, "action move, x = " + x16);
                            this$0.lastTouchX = x16;
                        }
                    }
                }
            }
            if (this$0.isSeekMode) {
                QLog.i("WinkVideoProgressBar", 4, "action up/cancel, x = " + this$0.lastTouchX);
                Long valueOf2 = Long.valueOf(this$0.c(this$0.lastTouchX));
                if (valueOf2.longValue() < 0) {
                    z18 = false;
                }
                if (z18) {
                    l3 = valueOf2;
                }
                if (l3 != null) {
                    l3.longValue();
                }
                this$0.isSeekMode = false;
            }
        } else {
            float x17 = motionEvent.getX(motionEvent.getActionIndex());
            Long valueOf3 = Long.valueOf(this$0.c(x17));
            if (valueOf3.longValue() >= 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                l3 = valueOf3;
            }
            if (l3 != null) {
                l3.longValue();
                QLog.i("WinkVideoProgressBar", 4, "action down, x = " + x17);
                this$0.isSeekMode = true;
                this$0.lastTouchX = x17;
                this$0.activePointerId = motionEvent.getPointerId(0);
            }
        }
        return this$0.isSeekMode;
    }

    @Override // android.view.View
    protected void onDraw(@Nullable Canvas canvas) {
        super.onDraw(canvas);
        if (canvas == null) {
            return;
        }
        d(canvas, 872415231, getWidth());
        d(canvas, -1, (int) ((getWidth() * ((float) b())) / ((float) this.totalLengthMs)));
    }

    public final void setPlayPosition(long time) {
        long coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(time, 0L, this.totalLengthMs);
        e(coerceIn, this.isSeekMode);
        invalidate();
    }

    public final void setVideoLengthInfo(long totalLengthMs, @NotNull Long[] clipsStartMs) {
        Intrinsics.checkNotNullParameter(clipsStartMs, "clipsStartMs");
        this.totalLengthMs = totalLengthMs;
        this.clipsStartMs = clipsStartMs;
        e(0L, true);
        invalidate();
        setOnTouchListener(this.touchListener);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkVideoProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public WinkVideoProgressBar(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.J = new LinkedHashMap();
        this.clipsStartMs = new Long[0];
        this.isPaused = true;
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        this.paint = paint;
        this.rect = new Rect();
        this.clipGapWidth = (int) TypedValue.applyDimension(1, 2.0f, getResources().getDisplayMetrics());
        this.activePointerId = -1;
        this.lastTouchX = -1.0f;
        this.touchListener = new View.OnTouchListener() { // from class: com.tencent.mobileqq.wink.editor.dt
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean f16;
                f16 = WinkVideoProgressBar.f(WinkVideoProgressBar.this, view, motionEvent);
                return f16;
            }
        };
    }

    public /* synthetic */ WinkVideoProgressBar(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final void setSeekListener(@Nullable b l3) {
    }
}
