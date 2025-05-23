package com.tencent.ecommerce.biz.transactiondata.trendchart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.view.MotionEvent;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import cg0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.ecommerce.biz.util.i;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.util.ArrayList;
import java.util.List;
import kj0.ECChartViewPointAttr;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 q2\u00020\u0001:\u0002\u0011\u000fB3\u0012\u0006\u0010n\u001a\u00020m\u0012\f\u0010i\u001a\b\u0012\u0004\u0012\u00020f0%\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070%\u0012\u0006\u0010l\u001a\u00020\u001b\u00a2\u0006\u0004\bo\u0010pJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u000e\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0014J\u0010\u0010\u001a\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u000e\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001bJ\u000e\u0010 \u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001eJ\u0018\u0010#\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020\u0014H\u0014J\u0010\u0010$\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J\u0014\u0010'\u001a\u00020\u00022\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070%J\u0006\u0010(\u001a\u00020\u0002J\u0012\u0010+\u001a\u00020\u001b2\b\u0010*\u001a\u0004\u0018\u00010)H\u0017R\u0016\u0010.\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010-R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010-R\u0016\u00100\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010-R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010-R\u001c\u00103\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u00102R\u001c\u00107\u001a\b\u0012\u0004\u0012\u0002040\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010B\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010@R\u0016\u0010D\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bC\u0010@R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010IR\u0016\u0010L\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010IR\u0016\u0010N\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bM\u0010-R\u0016\u0010P\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010-R\u0016\u0010R\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010IR\u0016\u0010T\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010IR\u0014\u0010V\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010IR\u0014\u0010X\u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010IR\u0016\u0010Z\u001a\u00020,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010-R\u0016\u0010\\\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010IR\u0016\u0010^\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010IR\u0016\u0010`\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010IR\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010dR\u001c\u0010i\u001a\b\u0012\u0004\u0012\u00020f0%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010hR\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00070%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010hR\u0014\u0010l\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010d\u00a8\u0006r"}, d2 = {"Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECChartView;", "Landroid/view/View;", "", "j", "l", "k", "", "", "c", "()[Ljava/lang/Long;", "Landroid/graphics/Canvas;", PM.CANVAS, "f", "g", "d", "b", "e", "a", "Landroid/graphics/Shader;", "i", "", "count", "setXLabelCount", "setYLabelCount", "Lkj0/c;", "pointAttr", "setPointAttr", "", "drawIndicatorView", "setShouldDrawIndicatorView", "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/IChartViewActionCallback;", "callback", "setActionCallback", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "onDraw", "", "data", "setData", h.F, "Landroid/view/MotionEvent;", "event", "onTouchEvent", "", UserInfo.SEX_FEMALE, "startPointX", "startPointY", "xScale", "yScale", "[Ljava/lang/Long;", "yLabel", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "[[F", "dataCoordinates", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/ecommerce/biz/transactiondata/trendchart/IChartViewActionCallback;", "actionCallback", "D", "Landroid/graphics/Canvas;", "thisCanvas", "Landroid/graphics/Paint;", "E", "Landroid/graphics/Paint;", "axisLinePaint", "dataPointPaint", "G", "labelTextPaint", "Landroid/graphics/Rect;", "H", "Landroid/graphics/Rect;", "bounds", "I", "viewWidth", "J", "viewHeight", "K", "xLength", "L", "yLength", "M", "brandColor", "N", "bottomViewHeight", "P", "chartPaddingHorizon", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "chartPaddingTop", BdhLogUtil.LogTag.Tag_Req, "yLabelTextGap", ExifInterface.LATITUDE_SOUTH, "maxTextBoundsWidth", "T", "xLabelCount", "U", "yLabelCount", "V", "Lkj0/c;", "W", "Z", "shouldDrawIndicatorView", "", "a0", "Ljava/util/List;", "xLabel", "b0", "c0", "isMoneyTab", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Z)V", "d0", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECChartView extends View {

    /* renamed from: C, reason: from kotlin metadata */
    private IChartViewActionCallback actionCallback;

    /* renamed from: D, reason: from kotlin metadata */
    private Canvas thisCanvas;

    /* renamed from: E, reason: from kotlin metadata */
    private Paint axisLinePaint;

    /* renamed from: F, reason: from kotlin metadata */
    private Paint dataPointPaint;

    /* renamed from: G, reason: from kotlin metadata */
    private Paint labelTextPaint;

    /* renamed from: H, reason: from kotlin metadata */
    private Rect bounds;

    /* renamed from: I, reason: from kotlin metadata */
    private int viewWidth;

    /* renamed from: J, reason: from kotlin metadata */
    private int viewHeight;

    /* renamed from: K, reason: from kotlin metadata */
    private float xLength;

    /* renamed from: L, reason: from kotlin metadata */
    private float yLength;

    /* renamed from: M, reason: from kotlin metadata */
    private int brandColor;

    /* renamed from: N, reason: from kotlin metadata */
    private int bottomViewHeight;

    /* renamed from: P, reason: from kotlin metadata */
    private final int chartPaddingHorizon;

    /* renamed from: Q, reason: from kotlin metadata */
    private final int chartPaddingTop;

    /* renamed from: R, reason: from kotlin metadata */
    private float yLabelTextGap;

    /* renamed from: S, reason: from kotlin metadata */
    private int maxTextBoundsWidth;

    /* renamed from: T, reason: from kotlin metadata */
    private int xLabelCount;

    /* renamed from: U, reason: from kotlin metadata */
    private int yLabelCount;

    /* renamed from: V, reason: from kotlin metadata */
    private ECChartViewPointAttr pointAttr;

    /* renamed from: W, reason: from kotlin metadata */
    private boolean shouldDrawIndicatorView;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private List<String> xLabel;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private List<Long> data;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final boolean isMoneyTab;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private float startPointX;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private float startPointY;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private float xScale;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private float yScale;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Long[] yLabel;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private float[][] dataCoordinates;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u000b\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/transactiondata/trendchart/ECChartView$b;", "", "", "a", UserInfo.SEX_FEMALE, "()F", "c", "(F)V", HippyTKDListViewAdapter.X, "b", "d", "y", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private float x;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private float y;

        /* renamed from: a, reason: from getter */
        public final float getX() {
            return this.x;
        }

        /* renamed from: b, reason: from getter */
        public final float getY() {
            return this.y;
        }

        public final void c(float f16) {
            this.x = f16;
        }

        public final void d(float f16) {
            this.y = f16;
        }
    }

    public ECChartView(Context context, List<String> list, List<Long> list2, boolean z16) {
        super(context);
        this.xLabel = list;
        this.data = list2;
        this.isMoneyTab = z16;
        this.bounds = new Rect();
        this.bottomViewHeight = e.c(32.0f);
        this.chartPaddingHorizon = e.c(10.0f);
        this.chartPaddingTop = e.c(10.0f);
        this.yLabelTextGap = 20.0f;
        this.xLabelCount = 7;
        this.yLabelCount = 6;
    }

    private final void b() {
        float f16 = this.startPointX + this.maxTextBoundsWidth + this.yLabelTextGap + this.chartPaddingHorizon;
        float f17 = this.startPointY + this.chartPaddingTop;
        int size = this.data.size();
        float[][] fArr = new float[size];
        for (int i3 = 0; i3 < size; i3++) {
            fArr[i3] = new float[2];
        }
        this.dataCoordinates = fArr;
        int size2 = this.data.size();
        for (int i16 = 0; i16 < size2; i16++) {
            float[][] fArr2 = this.dataCoordinates;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            fArr2[i16][0] = (i16 * this.xScale) + f16;
            float longValue = (float) this.data.get(i16).longValue();
            Long[] lArr = this.yLabel;
            if (lArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yLabel");
            }
            Long[] lArr2 = this.yLabel;
            if (lArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yLabel");
            }
            float longValue2 = (float) lArr[lArr2.length - 1].longValue();
            float[][] fArr3 = this.dataCoordinates;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            float[] fArr4 = fArr3[i16];
            float f18 = this.yScale * (longValue2 - longValue);
            Long[] lArr3 = this.yLabel;
            if (lArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yLabel");
            }
            float longValue3 = (float) lArr3[1].longValue();
            Long[] lArr4 = this.yLabel;
            if (lArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("yLabel");
            }
            fArr4[1] = (f18 / (longValue3 - ((float) lArr4[0].longValue()))) + f17;
        }
    }

    private final Long[] c() {
        Object[] requireNoNulls;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.data);
        CollectionsKt__MutableCollectionsJVMKt.sort(arrayList);
        long longValue = ((Number) arrayList.get(0)).longValue();
        long max = Math.max((long) Math.ceil((((Number) arrayList.get(arrayList.size() - 1)).longValue() - longValue) / (this.yLabelCount - 1)), 1L);
        int i3 = this.yLabelCount;
        Long[] lArr = new Long[i3];
        for (int i16 = 0; i16 < i3; i16++) {
            lArr[i16] = Long.valueOf((i16 * max) + longValue);
        }
        requireNoNulls = ArraysKt___ArraysKt.requireNoNulls(lArr);
        return (Long[]) requireNoNulls;
    }

    private final void d(Canvas canvas) {
        b();
        a(canvas);
    }

    private final void e(Canvas canvas) {
        float[][] fArr = this.dataCoordinates;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
        }
        int length = fArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            Paint paint = this.dataPointPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataPointPaint");
            }
            paint.setColor(this.brandColor);
            float[][] fArr2 = this.dataCoordinates;
            if (fArr2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            float f16 = fArr2[i3][0];
            float[][] fArr3 = this.dataCoordinates;
            if (fArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            float f17 = fArr3[i3][1];
            ECChartViewPointAttr eCChartViewPointAttr = this.pointAttr;
            float outerCircleRadius = eCChartViewPointAttr != null ? eCChartViewPointAttr.getOuterCircleRadius() : 6.0f;
            Paint paint2 = this.dataPointPaint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataPointPaint");
            }
            canvas.drawCircle(f16, f17, outerCircleRadius, paint2);
            Paint paint3 = this.dataPointPaint;
            if (paint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataPointPaint");
            }
            paint3.setColor(-1);
            float[][] fArr4 = this.dataCoordinates;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            float f18 = fArr4[i3][0];
            float[][] fArr5 = this.dataCoordinates;
            if (fArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            float f19 = fArr5[i3][1];
            ECChartViewPointAttr eCChartViewPointAttr2 = this.pointAttr;
            float innerCircleRadius = eCChartViewPointAttr2 != null ? eCChartViewPointAttr2.getInnerCircleRadius() : 3.0f;
            Paint paint4 = this.dataPointPaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataPointPaint");
            }
            canvas.drawCircle(f18, f19, innerCircleRadius, paint4);
        }
    }

    private final void f(Canvas canvas) {
        String valueOf;
        Long[] lArr = this.yLabel;
        if (lArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yLabel");
        }
        int length = lArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            int i16 = (this.yLabelCount - 1) - i3;
            if (this.isMoneyTab) {
                i iVar = i.f104869a;
                Long[] lArr2 = this.yLabel;
                if (lArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yLabel");
                }
                valueOf = iVar.b(lArr2[i16].longValue());
            } else {
                Long[] lArr3 = this.yLabel;
                if (lArr3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("yLabel");
                }
                valueOf = String.valueOf(lArr3[i16].longValue());
            }
            Paint paint = this.labelTextPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
            }
            paint.setTextSize(ECDeviceUtils.f104857e.b(10.0f));
            Paint paint2 = this.labelTextPaint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
            }
            paint2.getTextBounds(valueOf, 0, valueOf.length(), this.bounds);
            this.maxTextBoundsWidth = Math.max(this.maxTextBoundsWidth, this.bounds.width());
            float f16 = this.startPointX;
            float height = this.startPointY + this.chartPaddingTop + (this.yScale * i3) + (this.bounds.height() / 2);
            Paint paint3 = this.labelTextPaint;
            if (paint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
            }
            canvas.drawText(valueOf, f16, height, paint3);
        }
        Long[] lArr4 = this.yLabel;
        if (lArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("yLabel");
        }
        int length2 = lArr4.length;
        for (int i17 = 0; i17 < length2; i17++) {
            Path path = new Path();
            float f17 = i17;
            path.moveTo(this.startPointX + this.maxTextBoundsWidth + this.yLabelTextGap, this.startPointY + this.chartPaddingTop + (this.yScale * f17));
            path.lineTo(this.viewWidth, this.startPointY + this.chartPaddingTop + (f17 * this.yScale));
            Paint paint4 = this.axisLinePaint;
            if (paint4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("axisLinePaint");
            }
            canvas.drawPath(path, paint4);
        }
    }

    private final Shader i(Canvas canvas) {
        return new LinearGradient(0.0f, canvas.getHeight(), 0.0f, 0.0f, Color.argb(0, 255, 255, 255), Color.argb(20, 255, 51, 112), Shader.TileMode.REPEAT);
    }

    private final void j() {
        this.yLabel = c();
        l();
    }

    private final void k() {
        this.viewWidth = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        this.viewHeight = measuredHeight;
        float f16 = ((this.viewWidth - this.maxTextBoundsWidth) - this.yLabelTextGap) - (this.chartPaddingHorizon * 2);
        this.xLength = f16;
        float f17 = (measuredHeight - this.bottomViewHeight) - this.chartPaddingTop;
        this.yLength = f17;
        this.yScale = f17 / (this.yLabelCount - 1);
        this.xScale = f16 / (this.xLabel.size() - 1);
    }

    private final void l() {
        this.dataPointPaint = new Paint();
        this.axisLinePaint = new Paint();
        this.labelTextPaint = new Paint();
        Paint paint = this.axisLinePaint;
        if (paint == null) {
            Intrinsics.throwUninitializedPropertyAccessException("axisLinePaint");
        }
        paint.reset();
        Paint paint2 = this.axisLinePaint;
        if (paint2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("axisLinePaint");
        }
        paint2.setAntiAlias(true);
        Paint paint3 = this.axisLinePaint;
        if (paint3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("axisLinePaint");
        }
        paint3.setStyle(Paint.Style.STROKE);
        Paint paint4 = this.axisLinePaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("axisLinePaint");
        }
        paint4.setStrokeWidth(0.5f);
        Paint paint5 = this.axisLinePaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("axisLinePaint");
        }
        paint5.setColor(Color.parseColor("#E6E6E6"));
        Paint paint6 = this.labelTextPaint;
        if (paint6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
        }
        paint6.setAntiAlias(true);
        Paint paint7 = this.labelTextPaint;
        if (paint7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
        }
        paint7.setColor(Color.parseColor("#666666"));
        Paint paint8 = this.labelTextPaint;
        if (paint8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
        }
        paint8.setTextSize(20.0f);
        Paint paint9 = this.dataPointPaint;
        if (paint9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataPointPaint");
        }
        paint9.setAntiAlias(true);
        Paint paint10 = this.dataPointPaint;
        if (paint10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataPointPaint");
        }
        paint10.setStrokeWidth(10.0f);
        Paint paint11 = this.dataPointPaint;
        if (paint11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataPointPaint");
        }
        paint11.setStrokeCap(Paint.Cap.ROUND);
        this.brandColor = ECSkin.INSTANCE.getColor(R.color.f6170u);
    }

    public final void h() {
        j();
        requestLayout();
        postInvalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        f(canvas);
        this.xScale = (((this.viewWidth - this.maxTextBoundsWidth) - this.yLabelTextGap) - (this.chartPaddingHorizon * 2)) / (this.xLabel.size() - 1);
        g(canvas);
        d(canvas);
        ECChartViewPointAttr eCChartViewPointAttr = this.pointAttr;
        if (eCChartViewPointAttr != null && eCChartViewPointAttr.getShouldDraw()) {
            e(canvas);
        }
        this.thisCanvas = canvas;
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        k();
    }

    public final void setActionCallback(IChartViewActionCallback callback) {
        this.actionCallback = callback;
    }

    public final void setData(List<Long> data) {
        this.data = data;
    }

    public final void setPointAttr(ECChartViewPointAttr pointAttr) {
        this.pointAttr = pointAttr;
    }

    public final void setShouldDrawIndicatorView(boolean drawIndicatorView) {
        this.shouldDrawIndicatorView = drawIndicatorView;
    }

    public final void setXLabelCount(int count) {
        this.xLabelCount = count;
    }

    public final void setYLabelCount(int count) {
        this.yLabelCount = count;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.shouldDrawIndicatorView) {
            return true;
        }
        if (event != null && event.getAction() == 2) {
            float x16 = event.getX();
            float y16 = event.getY();
            float[][] fArr = this.dataCoordinates;
            if (fArr == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            int length = fArr.length;
            for (int i3 = 0; i3 < length; i3++) {
                float[][] fArr2 = this.dataCoordinates;
                if (fArr2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
                }
                float[] fArr3 = fArr2[i3];
                if (Math.abs(x16 - fArr3[0]) < this.xScale / 2) {
                    IChartViewActionCallback iChartViewActionCallback = this.actionCallback;
                    if (iChartViewActionCallback != null) {
                        iChartViewActionCallback.refreshIndicatorView(fArr3[0], fArr3[1], i3);
                    }
                    a.a("ECChartView", "onTouchEvent", "[action move] x = " + x16 + " y = " + y16);
                }
            }
        } else if (event != null && event.getAction() == 0) {
            float x17 = event.getX();
            float y17 = event.getY();
            float[][] fArr4 = this.dataCoordinates;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            int length2 = fArr4.length;
            for (int i16 = 0; i16 < length2; i16++) {
                float[][] fArr5 = this.dataCoordinates;
                if (fArr5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
                }
                float[] fArr6 = fArr5[i16];
                if (Math.abs(x17 - fArr6[0]) < this.xScale / 2) {
                    IChartViewActionCallback iChartViewActionCallback2 = this.actionCallback;
                    if (iChartViewActionCallback2 != null) {
                        iChartViewActionCallback2.refreshIndicatorView(fArr6[0], fArr6[1], i16);
                    }
                    a.a("ECChartView", "onTouchEvent", "[action move] x = " + x17 + " y = " + y17);
                }
            }
            a.a("ECChartView", "onTouchEvent", "[action down2] x = " + x17 + " y = " + y17);
        }
        a.a("ECChartView", "onTouchEvent", "[action down3] x = ");
        return true;
    }

    private final void a(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(this.brandColor);
        paint.setStrokeWidth(3.0f);
        Path path = new Path();
        b bVar = new b();
        b bVar2 = new b();
        float[][] fArr = this.dataCoordinates;
        if (fArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
        }
        float f16 = fArr[0][0];
        float[][] fArr2 = this.dataCoordinates;
        if (fArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
        }
        path.moveTo(f16, fArr2[0][1]);
        float[][] fArr3 = this.dataCoordinates;
        if (fArr3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
        }
        int length = fArr3.length;
        int i3 = 0;
        while (i3 < length) {
            int i16 = i3 + 1;
            int i17 = i16 < length ? i16 : i3;
            float[][] fArr4 = this.dataCoordinates;
            if (fArr4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            bVar.d(fArr4[i3][1]);
            float[][] fArr5 = this.dataCoordinates;
            if (fArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            float f17 = fArr5[i3][0];
            float[][] fArr6 = this.dataCoordinates;
            if (fArr6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            bVar.c((f17 + fArr6[i17][0]) / 2);
            float[][] fArr7 = this.dataCoordinates;
            if (fArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            bVar2.d(fArr7[i17][1]);
            bVar2.c(bVar.getX());
            float x16 = bVar.getX();
            float y16 = bVar.getY();
            float x17 = bVar2.getX();
            float y17 = bVar2.getY();
            float[][] fArr8 = this.dataCoordinates;
            if (fArr8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            float f18 = fArr8[i17][0];
            float[][] fArr9 = this.dataCoordinates;
            if (fArr9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
            }
            path.cubicTo(x16, y16, x17, y17, f18, fArr9[i17][1]);
            i3 = i16;
            length = length;
        }
        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);
        float[][] fArr10 = this.dataCoordinates;
        if (fArr10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
        }
        float[][] fArr11 = this.dataCoordinates;
        if (fArr11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
        }
        path.lineTo(fArr10[fArr11.length - 1][0], this.startPointY + (this.yScale * 5.5f));
        float[][] fArr12 = this.dataCoordinates;
        if (fArr12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dataCoordinates");
        }
        path.lineTo(fArr12[0][0], this.startPointY + (this.yScale * 5.5f));
        path.close();
        Paint paint2 = new Paint();
        paint2.setStyle(Paint.Style.FILL);
        paint2.setShader(i(canvas));
        canvas.drawPath(path, paint2);
    }

    private final void g(Canvas canvas) {
        String replace$default;
        String replace$default2;
        if (this.xLabelCount < 1) {
            return;
        }
        float height = this.startPointY + this.yLength + this.chartPaddingTop + this.bounds.height() + (this.bottomViewHeight / 2);
        float f16 = this.startPointX + this.maxTextBoundsWidth + this.yLabelTextGap + this.chartPaddingHorizon;
        int size = this.xLabel.size() - 1;
        int size2 = this.xLabel.size();
        int i3 = this.xLabelCount;
        int i16 = size2 / (i3 - 1);
        int i17 = i3 - 1;
        for (int i18 = 0; i18 < i17; i18++) {
            int i19 = i18 * i16;
            Paint paint = this.labelTextPaint;
            if (paint == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
            }
            paint.setTextSize(ECDeviceUtils.f104857e.b(10.0f));
            Paint paint2 = this.labelTextPaint;
            if (paint2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
            }
            paint2.getTextBounds(this.xLabel.get(i19), 0, this.xLabel.get(i19).length(), this.bounds);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(this.xLabel.get(i19), '-', '.', false, 4, (Object) null);
            float width = ((this.xScale * i19) + f16) - (this.bounds.width() / 2);
            Paint paint3 = this.labelTextPaint;
            if (paint3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
            }
            canvas.drawText(replace$default2, width, height, paint3);
        }
        Paint paint4 = this.labelTextPaint;
        if (paint4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
        }
        paint4.getTextBounds(this.xLabel.get(size), 0, this.xLabel.get(size).length(), this.bounds);
        replace$default = StringsKt__StringsJVMKt.replace$default(this.xLabel.get(size), '-', '.', false, 4, (Object) null);
        float min = Math.min((f16 + (this.xScale * size)) - (this.bounds.width() / 2), getWidth() - this.bounds.width());
        Paint paint5 = this.labelTextPaint;
        if (paint5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("labelTextPaint");
        }
        canvas.drawText(replace$default, min, height, paint5);
    }
}
