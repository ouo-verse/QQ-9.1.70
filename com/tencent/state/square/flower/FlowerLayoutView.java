package com.tencent.state.square.flower;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.state.decode.BitmapUtils;
import com.tencent.state.square.SquareBaseKt;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u00020\u0001:\u0001*B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u0007H\u0002J$\u0010!\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010\u000e2\u0006\u0010%\u001a\u00020\u001aH\u0002J\u0012\u0010&\u001a\u00020\u001e2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0014J\u0018\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u0007H\u0014R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/tencent/state/square/flower/FlowerLayoutView;", "Landroid/view/View;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "drawPaint", "Landroid/graphics/Paint;", "drawRect", "Landroid/graphics/Rect;", "flower", "Landroid/graphics/Bitmap;", "getFlower", "()Landroid/graphics/Bitmap;", "value", "flowerCount", "getFlowerCount", "()I", "setFlowerCount", "(I)V", "flowerSize", "locations", "", "Landroid/graphics/Point;", "[Landroid/graphics/Point;", "size", "calcGridLocations", "", "width", "height", "draw", PM.CANVAS, "Landroid/graphics/Canvas;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "location", "onDraw", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FlowerLayoutView extends View {
    private static final int MAX_GRID_COUNT = 10;
    private static final int ROW_OF_GRID = 5;
    private static final String TAG = "FlowerLayoutView";
    private static Bitmap flowerBitmap;
    private static final Pair<Float, Float>[] lOfIndexes;
    private final Paint drawPaint;
    private final Rect drawRect;
    private int flowerCount;
    private int flowerSize;
    private final Point[] locations;
    private int size;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Integer[][] zOrders = {new Integer[]{6, 9}, new Integer[]{3, 4}, new Integer[]{1, 5, 7}, new Integer[]{0, 2, 8}};

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\f0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000eR\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000b0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/state/square/flower/FlowerLayoutView$Companion;", "", "()V", "MAX_GRID_COUNT", "", "ROW_OF_GRID", "TAG", "", "flowerBitmap", "Landroid/graphics/Bitmap;", "lOfIndexes", "", "Lkotlin/Pair;", "", "[Lkotlin/Pair;", "zOrders", "[[Ljava/lang/Integer;", "recycle", "", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final void recycle() {
            Bitmap bitmap = FlowerLayoutView.flowerBitmap;
            if (bitmap != null) {
                bitmap.recycle();
            }
            FlowerLayoutView.flowerBitmap = null;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        Float valueOf = Float.valueOf(4.0f);
        Float valueOf2 = Float.valueOf(3.0f);
        Float valueOf3 = Float.valueOf(12.0f);
        Float valueOf4 = Float.valueOf(2.0f);
        Float valueOf5 = Float.valueOf(1.0f);
        Float valueOf6 = Float.valueOf(0.0f);
        lOfIndexes = new Pair[]{TuplesKt.to(valueOf, valueOf2), TuplesKt.to(valueOf3, valueOf4), TuplesKt.to(Float.valueOf(9.0f), valueOf2), TuplesKt.to(valueOf5, valueOf5), TuplesKt.to(Float.valueOf(10.5f), valueOf5), TuplesKt.to(valueOf2, valueOf4), TuplesKt.to(valueOf4, valueOf6), TuplesKt.to(Float.valueOf(10.0f), valueOf4), TuplesKt.to(valueOf4, valueOf2), TuplesKt.to(valueOf3, valueOf6)};
    }

    public FlowerLayoutView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final Bitmap getFlower() {
        Bitmap bitmap = flowerBitmap;
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap decode = BitmapUtils.INSTANCE.decode(getContext(), R.drawable.i9q);
        if (decode == null) {
            return null;
        }
        flowerBitmap = decode;
        return decode;
    }

    public final int getFlowerCount() {
        return this.flowerCount;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int coerceAtMost;
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(this.flowerCount, 10);
        for (Integer[] numArr : zOrders) {
            ArrayList arrayList = new ArrayList();
            for (Integer num : numArr) {
                if (num.intValue() < coerceAtMost) {
                    arrayList.add(num);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                draw(canvas, getFlower(), this.locations[((Number) it.next()).intValue()]);
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        calcGridLocations(getMeasuredWidth(), getMeasuredHeight());
    }

    public final void setFlowerCount(int i3) {
        if (this.flowerCount != i3) {
            this.flowerCount = i3;
            invalidate();
        }
    }

    public FlowerLayoutView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ FlowerLayoutView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void draw(Canvas canvas, Bitmap bitmap, Point location) {
        if (bitmap != null) {
            Rect rect = this.drawRect;
            int i3 = location.x;
            int i16 = location.y;
            int i17 = this.flowerSize;
            rect.set(i3, i16, i3 + i17, i17 + i16);
            SquareBaseKt.getSquareLog().i(TAG, "draw: " + this.drawRect);
            if (canvas != null) {
                canvas.drawBitmap(bitmap, (Rect) null, this.drawRect, this.drawPaint);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowerLayoutView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        Point[] pointArr = new Point[10];
        for (int i16 = 0; i16 < 10; i16++) {
            pointArr[i16] = new Point();
        }
        this.locations = pointArr;
        this.drawRect = new Rect();
        this.drawPaint = new Paint();
    }

    private final void calcGridLocations(int width, int height) {
        Object orNull;
        if (width <= 0 || height <= 0) {
            return;
        }
        int i3 = height / 5;
        this.size = i3;
        this.flowerSize = i3 * 2;
        Point[] pointArr = this.locations;
        int length = pointArr.length;
        int i16 = 0;
        int i17 = 0;
        while (i16 < length) {
            Point point = pointArr[i16];
            int i18 = i17 + 1;
            orNull = ArraysKt___ArraysKt.getOrNull(lOfIndexes, i17);
            Pair pair = (Pair) orNull;
            if (pair == null) {
                return;
            }
            point.x = (int) (this.size * ((Number) pair.getFirst()).floatValue());
            point.y = (int) (this.size * ((Number) pair.getSecond()).floatValue());
            i16++;
            i17 = i18;
        }
    }
}
