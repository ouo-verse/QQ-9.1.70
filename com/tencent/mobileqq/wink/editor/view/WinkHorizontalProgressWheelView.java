package com.tencent.mobileqq.wink.editor.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.hippy.qq.view.viola.list.TkdListView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.views.scroll.HippyScrollViewEventHelper;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\rB\u0011\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u00a2\u0006\u0004\bO\u0010PB\u001b\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u00a2\u0006\u0004\bO\u0010SB#\b\u0016\u0012\u0006\u0010N\u001a\u00020M\u0012\b\u0010R\u001a\u0004\u0018\u00010Q\u0012\u0006\u0010T\u001a\u00020\u0017\u00a2\u0006\u0004\bO\u0010UJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\r\u001a\u00020\nJ\u0006\u0010\u000e\u001a\u00020\u0002J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0017R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0019R\u0016\u0010!\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010 R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010 R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010 R\u0016\u0010*\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010 R\u0016\u0010,\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010 R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010\u0019R\u0016\u0010/\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010 R\u0016\u00101\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010 R\u0016\u00103\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010 R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u00109\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00106R\u0014\u0010;\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u00106R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010 R\u0016\u0010@\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bA\u0010 R\u0016\u0010D\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010 R\u0016\u0010F\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010 R$\u0010I\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8\u0002@BX\u0082\u000e\u00a2\u0006\f\n\u0004\bG\u0010 \"\u0004\b\u0014\u0010HR\u0018\u0010L\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010K\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkHorizontalProgressWheelView;", "Landroid/view/View;", "", "b", "Lcom/tencent/mobileqq/wink/editor/view/WinkHorizontalProgressWheelView$a;", "listener", "setScrollListener", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "", "value", HippyTextInputController.COMMAND_setValue, "a", "c", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "Landroid/graphics/Rect;", "d", "Landroid/graphics/Rect;", "mCanvasClipBounds", "", "e", "I", "middleLineColor", "f", "largeScaleLineColor", tl.h.F, "normalScaleLineColor", "i", UserInfo.SEX_FEMALE, "middleLineWidth", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "largeScaleLineWidth", BdhLogUtil.LogTag.Tag_Conn, "normalScaleLineWidth", "D", "middleLineHeight", "E", "largeScaleLineHeight", "normalScaleLineHeight", "G", "scaleLineMargin", "H", "primaryScaleLineNum", "unitSize", "J", "minValue", "K", "maxValue", "Landroid/graphics/Paint;", "L", "Landroid/graphics/Paint;", "middleLinePaint", "M", "largeScaleLinePaint", "N", "normalScaleLinePaint", "P", "lastTouchedPosition", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", "scrollStarted", BdhLogUtil.LogTag.Tag_Req, "valuePerDistance", ExifInterface.LATITUDE_SOUTH, "maxDistance", "T", "minDistance", "U", "(F)V", "totalScrollDistance", "V", "Lcom/tencent/mobileqq/wink/editor/view/WinkHorizontalProgressWheelView$a;", "scrollListener", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkHorizontalProgressWheelView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private float normalScaleLineWidth;

    /* renamed from: D, reason: from kotlin metadata */
    private float middleLineHeight;

    /* renamed from: E, reason: from kotlin metadata */
    private float largeScaleLineHeight;

    /* renamed from: F, reason: from kotlin metadata */
    private float normalScaleLineHeight;

    /* renamed from: G, reason: from kotlin metadata */
    private float scaleLineMargin;

    /* renamed from: H, reason: from kotlin metadata */
    private int primaryScaleLineNum;

    /* renamed from: I, reason: from kotlin metadata */
    private float unitSize;

    /* renamed from: J, reason: from kotlin metadata */
    private float minValue;

    /* renamed from: K, reason: from kotlin metadata */
    private float maxValue;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Paint middleLinePaint;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Paint largeScaleLinePaint;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Paint normalScaleLinePaint;

    /* renamed from: P, reason: from kotlin metadata */
    private float lastTouchedPosition;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean scrollStarted;

    /* renamed from: R, reason: from kotlin metadata */
    private float valuePerDistance;

    /* renamed from: S, reason: from kotlin metadata */
    private float maxDistance;

    /* renamed from: T, reason: from kotlin metadata */
    private float minDistance;

    /* renamed from: U, reason: from kotlin metadata */
    private float totalScrollDistance;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private a scrollListener;

    @NotNull
    public Map<Integer, View> W;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Rect mCanvasClipBounds;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int middleLineColor;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int largeScaleLineColor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int normalScaleLineColor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private float middleLineWidth;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float largeScaleLineWidth;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H&J\b\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/view/WinkHorizontalProgressWheelView$a;", "", "", "onScrollStart", "", "deltaValue", "currentValue", HippyScrollViewEventHelper.EVENT_TYPE_SCROLL, TkdListView.EVENT_TYPE_SCROLL_END, "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public interface a {
        void onScroll(float deltaValue, float currentValue);

        void onScrollEnd();

        void onScrollStart();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkHorizontalProgressWheelView(@NotNull Context context) {
        this(context, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void b() {
        this.middleLinePaint.setStrokeWidth(this.middleLineWidth);
        this.middleLinePaint.setColor(this.middleLineColor);
        this.normalScaleLinePaint.setStrokeWidth(this.normalScaleLineWidth);
        this.normalScaleLinePaint.setColor(this.normalScaleLineColor);
        this.largeScaleLinePaint.setStrokeWidth(this.largeScaleLineWidth);
        this.largeScaleLinePaint.setColor(this.largeScaleLineColor);
        float f16 = this.unitSize / this.scaleLineMargin;
        this.valuePerDistance = f16;
        float f17 = ((this.maxValue - this.minValue) / 2.0f) / f16;
        this.maxDistance = f17;
        this.minDistance = -f17;
    }

    private final void d(float f16) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(f16, this.minDistance, this.maxDistance);
        this.totalScrollDistance = coerceIn;
    }

    public final float a() {
        return this.valuePerDistance * this.totalScrollDistance;
    }

    public final void c() {
        d(0.0f);
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(@NotNull Canvas canvas) {
        boolean z16;
        float f16;
        Paint paint;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        canvas.getClipBounds(this.mCanvasClipBounds);
        int i3 = (int) ((this.maxValue - this.minValue) / this.unitSize);
        if (i3 >= 0) {
            int i16 = 0;
            while (true) {
                float f17 = (this.minDistance + (i16 * (this.unitSize / this.valuePerDistance))) - this.totalScrollDistance;
                if (Math.abs(f17) > this.mCanvasClipBounds.width() / 2.0f) {
                    if (f17 >= 0.0f) {
                        break;
                    }
                } else {
                    if (i16 % this.primaryScaleLineNum == 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        f16 = this.largeScaleLineHeight;
                    } else {
                        f16 = this.normalScaleLineHeight;
                    }
                    if (z16) {
                        paint = this.largeScaleLinePaint;
                    } else {
                        paint = this.normalScaleLinePaint;
                    }
                    float f18 = f16 / 2.0f;
                    canvas.drawLine(this.mCanvasClipBounds.centerX() + f17, this.mCanvasClipBounds.centerY() - f18, this.mCanvasClipBounds.centerX() + f17, this.mCanvasClipBounds.centerY() + f18, paint);
                }
                if (i16 == i3) {
                    break;
                } else {
                    i16++;
                }
            }
        }
        canvas.drawLine(this.mCanvasClipBounds.centerX(), this.mCanvasClipBounds.centerY() - (this.middleLineHeight / 2.0f), this.mCanvasClipBounds.centerX(), this.mCanvasClipBounds.centerY() + (this.middleLineHeight / 2.0f), this.middleLinePaint);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        int action = event.getAction();
        if (action != 0) {
            boolean z16 = false;
            if (action != 1) {
                if (action == 2) {
                    if (!this.scrollStarted) {
                        this.scrollStarted = true;
                        a aVar = this.scrollListener;
                        if (aVar != null) {
                            aVar.onScrollStart();
                        }
                    }
                    float x16 = event.getX() - this.lastTouchedPosition;
                    this.lastTouchedPosition = event.getX();
                    float f16 = this.totalScrollDistance;
                    d(f16 - x16);
                    if (this.totalScrollDistance - f16 == 0.0f) {
                        z16 = true;
                    }
                    if (!z16) {
                        a aVar2 = this.scrollListener;
                        if (aVar2 != null) {
                            aVar2.onScroll(this.valuePerDistance * x16, a());
                        }
                        postInvalidate();
                    }
                }
            } else if (this.scrollStarted) {
                this.scrollStarted = false;
                a aVar3 = this.scrollListener;
                if (aVar3 != null) {
                    aVar3.onScrollEnd();
                }
            }
        } else {
            this.lastTouchedPosition = event.getX();
        }
        return true;
    }

    public final void setScrollListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.scrollListener = listener;
    }

    public final void setValue(float value) {
        float coerceIn;
        coerceIn = RangesKt___RangesKt.coerceIn(value, this.minValue, this.maxValue);
        d(coerceIn / this.valuePerDistance);
        postInvalidate();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WinkHorizontalProgressWheelView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkHorizontalProgressWheelView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.W = new LinkedHashMap();
        this.mCanvasClipBounds = new Rect();
        this.middleLineColor = -16776961;
        this.largeScaleLineColor = Color.argb(140, 255, 255, 255);
        this.normalScaleLineColor = Color.argb(140, 255, 255, 255);
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        this.middleLineWidth = eVar.a(1.0f);
        this.largeScaleLineWidth = eVar.a(0.5f);
        this.normalScaleLineWidth = eVar.a(0.5f);
        this.middleLineHeight = eVar.a(32.0f);
        this.largeScaleLineHeight = eVar.a(25.0f);
        this.normalScaleLineHeight = eVar.a(15.0f);
        this.scaleLineMargin = eVar.a(6.0f);
        this.primaryScaleLineNum = 5;
        this.unitSize = 1.8f;
        this.minValue = -45.0f;
        this.maxValue = 45.0f;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        this.middleLinePaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        this.largeScaleLinePaint = paint2;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.STROKE);
        this.normalScaleLinePaint = paint3;
        float f16 = this.unitSize / this.scaleLineMargin;
        this.valuePerDistance = f16;
        float f17 = ((this.maxValue - this.minValue) / 2.0f) / f16;
        this.maxDistance = f17;
        this.minDistance = -f17;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.tencent.mobileqq.wink.j.A9);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr\u2026izontalProgressWheelView)");
        this.middleLineColor = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.F9, this.middleLineColor);
        this.largeScaleLineColor = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.B9, this.largeScaleLineColor);
        this.normalScaleLineColor = obtainStyledAttributes.getColor(com.tencent.mobileqq.wink.j.J9, this.normalScaleLineColor);
        this.middleLineWidth = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.H9, this.middleLineWidth);
        this.largeScaleLineWidth = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.D9, this.largeScaleLineWidth);
        this.normalScaleLineWidth = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.L9, this.normalScaleLineWidth);
        this.middleLineHeight = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.G9, this.middleLineHeight);
        this.largeScaleLineHeight = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.C9, this.largeScaleLineHeight);
        this.normalScaleLineHeight = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.K9, this.normalScaleLineHeight);
        this.scaleLineMargin = obtainStyledAttributes.getDimension(com.tencent.mobileqq.wink.j.N9, this.scaleLineMargin);
        this.primaryScaleLineNum = obtainStyledAttributes.getInt(com.tencent.mobileqq.wink.j.M9, this.primaryScaleLineNum);
        this.unitSize = obtainStyledAttributes.getFloat(com.tencent.mobileqq.wink.j.O9, this.unitSize);
        this.maxValue = obtainStyledAttributes.getFloat(com.tencent.mobileqq.wink.j.E9, this.maxValue);
        this.minValue = obtainStyledAttributes.getFloat(com.tencent.mobileqq.wink.j.I9, this.minValue);
        obtainStyledAttributes.recycle();
        b();
    }
}
