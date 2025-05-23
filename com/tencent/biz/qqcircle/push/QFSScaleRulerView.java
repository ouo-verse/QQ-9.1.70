package com.tencent.biz.qqcircle.push;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.utils.bz;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSScaleRulerView extends View {
    private static final float D = ImmersiveUtils.dpToPx(16.0f);
    private static final float E = ImmersiveUtils.dpToPx(0.0f);
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private Paint f91819d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f91820e;

    /* renamed from: f, reason: collision with root package name */
    private int f91821f;

    /* renamed from: h, reason: collision with root package name */
    private float f91822h;

    /* renamed from: i, reason: collision with root package name */
    private int f91823i;

    /* renamed from: m, reason: collision with root package name */
    private final List<Integer> f91824m;

    public QFSScaleRulerView(Context context) {
        super(context);
        this.f91824m = new ArrayList();
    }

    private float a(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.0f;
        }
        TextPaint textPaint = new TextPaint(1);
        textPaint.setTextSize(ImmersiveUtils.dpToPx(13.0f));
        textPaint.setTypeface(Typeface.DEFAULT_BOLD);
        return textPaint.measureText(str);
    }

    private void b(Canvas canvas) {
        int dpToPx;
        for (int i3 = 0; i3 <= this.f91821f; i3++) {
            if (i3 % 8 == 0) {
                dpToPx = ImmersiveUtils.dpToPx(12.0f);
            } else {
                dpToPx = ImmersiveUtils.dpToPx(8.0f);
            }
            float f16 = i3;
            float f17 = this.f91822h;
            float f18 = D;
            float f19 = E;
            canvas.drawLine((f16 * f17) + f18, f19, (f16 * f17) + f18, dpToPx + f19, this.f91819d);
        }
    }

    private void c(Canvas canvas) {
        float f16 = this.f91822h * 8.0f;
        for (int i3 = 0; i3 <= this.f91821f / 8; i3++) {
            if (this.f91824m.get(i3).intValue() >= 0) {
                String valueOf = String.valueOf(this.f91824m.get(i3));
                float a16 = a(valueOf);
                if (i3 != this.f91821f / 8) {
                    a16 /= 2.0f;
                }
                if (i3 == 0) {
                    a16 = 0.0f;
                }
                canvas.drawText(valueOf, (D - a16) + (i3 * f16), E + ImmersiveUtils.dpToPx(30.0f), this.f91820e);
            }
        }
    }

    private void e() {
        this.f91822h = ImmersiveUtils.dpToPx((((ImmersiveUtils.pxToDp(this.f91823i) - 16) - 16) - 1) / this.f91821f);
    }

    public void d() {
        Paint paint = new Paint(1);
        this.f91819d = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f91819d.setStrokeWidth(ImmersiveUtils.dpToPx(1.0f));
        this.f91819d.setColor(getResources().getColor(R.color.clf));
        TextPaint textPaint = new TextPaint(1);
        this.f91820e = textPaint;
        textPaint.setTextSize(ImmersiveUtils.dpToPx(13.0f));
        this.f91820e.setTypeface(Typeface.DEFAULT_BOLD);
        this.f91820e.setColor(getResources().getColor(R.color.clf));
        this.f91821f = 32;
        this.f91823i = bz.i(getContext());
        e();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        int i3;
        if (!this.C || this.f91823i == (i3 = bz.i(getContext()))) {
            return;
        }
        this.f91823i = i3;
        e();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        b(canvas);
        if (this.f91824m.size() != 0 && this.f91824m.size() >= this.f91821f / 8) {
            c(canvas);
        }
    }

    public void setIsShowing(boolean z16) {
        this.C = z16;
    }

    public void setLabelList(List<Integer> list) {
        this.f91824m.clear();
        this.f91824m.addAll(list);
        if (this.f91824m.size() == 4) {
            this.f91821f = 24;
        } else {
            this.f91821f = 32;
        }
        e();
        invalidate();
    }

    public QFSScaleRulerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f91824m = new ArrayList();
        d();
    }

    public QFSScaleRulerView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f91824m = new ArrayList();
        d();
    }
}
