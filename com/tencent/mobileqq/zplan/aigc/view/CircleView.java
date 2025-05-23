package com.tencent.mobileqq.zplan.aigc.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015B\u001d\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0018B%\b\u0016\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0014\u0010\u001aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/aigc/view/CircleView;", "Landroid/view/View;", "", "a", "", "colorString", "setColor", "Landroid/graphics/Canvas;", PM.CANVAS, "onDraw", "Landroid/graphics/Paint;", "d", "Landroid/graphics/Paint;", "mPaint", "", "e", "I", "mColor", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CircleView extends View {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private Paint mPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int mColor;

    public CircleView(Context context) {
        super(context);
        a();
    }

    private final void a() {
        Paint paint = new Paint();
        this.mPaint = paint;
        this.mColor = -1;
        Intrinsics.checkNotNull(paint);
        paint.setColor(this.mColor);
        Paint paint2 = this.mPaint;
        Intrinsics.checkNotNull(paint2);
        paint2.setStyle(Paint.Style.FILL);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int min = Math.min(width, height);
        Paint paint = this.mPaint;
        Intrinsics.checkNotNull(paint);
        canvas.drawCircle(width, height, min, paint);
    }

    public final void setColor(String colorString) {
        boolean startsWith$default;
        String str;
        Intrinsics.checkNotNullParameter(colorString, "colorString");
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(colorString, "#", false, 2, null);
        if (!startsWith$default) {
            str = "#" + colorString;
        } else {
            str = "";
        }
        this.mColor = Color.parseColor(str);
        Paint paint = this.mPaint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(this.mColor);
        invalidate();
    }

    public CircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public CircleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
