package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QCircleMarqueeTextView extends View {
    private float C;
    private int D;
    private float E;
    private float F;
    private int G;
    private boolean H;
    private final Runnable I;

    /* renamed from: d, reason: collision with root package name */
    private float f93032d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f93033e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f93034f;

    /* renamed from: h, reason: collision with root package name */
    private String f93035h;

    /* renamed from: i, reason: collision with root package name */
    private float f93036i;

    /* renamed from: m, reason: collision with root package name */
    private float f93037m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static final class UpdateProgressTask implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private final WeakReference<QCircleMarqueeTextView> f93038d;

        public UpdateProgressTask(QCircleMarqueeTextView qCircleMarqueeTextView) {
            this.f93038d = new WeakReference<>(qCircleMarqueeTextView);
        }

        @Override // java.lang.Runnable
        public void run() {
            QCircleMarqueeTextView qCircleMarqueeTextView;
            WeakReference<QCircleMarqueeTextView> weakReference = this.f93038d;
            if (weakReference != null && (qCircleMarqueeTextView = weakReference.get()) != null) {
                qCircleMarqueeTextView.g();
            }
        }
    }

    public QCircleMarqueeTextView(Context context) {
        this(context, null);
    }

    private void b(Context context) {
        if (TextUtils.isEmpty(this.f93035h)) {
            this.f93035h = "";
        }
        Paint paint = new Paint();
        this.f93034f = paint;
        paint.setAntiAlias(true);
        this.f93034f.setTextSize(this.F);
        this.f93034f.setColor(QCircleSkinHelper.getInstance().getColor(this.G));
    }

    private int c(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            int textSize = ((int) this.f93034f.getTextSize()) + getPaddingTop() + getPaddingBottom();
            if (mode == Integer.MIN_VALUE) {
                return Math.min(textSize, size);
            }
            return textSize;
        }
        return size;
    }

    private int d(int i3) {
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            int measureText = (int) this.f93034f.measureText(this.f93035h);
            if (mode == Integer.MIN_VALUE) {
                return Math.min(measureText, size);
            }
            return measureText;
        }
        return size;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        postInvalidate();
        this.f93036i -= this.f93032d;
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacks(this.I);
        RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(this.I, 16L);
    }

    public void e() {
        if (!this.H && !TextUtils.isEmpty(this.f93035h) && getVisibility() != 8) {
            this.H = true;
            RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacks(this.I);
            RFWThreadManager.getInstance().getSerialThreadHandler().postDelayed(this.I, 16L);
        }
    }

    public void f() {
        if (!this.H) {
            return;
        }
        this.H = false;
        RFWThreadManager.getInstance().getSerialThreadHandler().removeCallbacks(this.I);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        e();
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        Paint paint;
        super.onDraw(canvas);
        if (canvas == null || (str = this.f93035h) == null || (paint = this.f93034f) == null || !this.f93033e) {
            return;
        }
        canvas.drawText(str, this.f93036i, this.f93037m, paint);
        float f16 = this.f93036i;
        float f17 = this.C;
        float f18 = f16 + f17;
        float f19 = this.D;
        float f26 = this.E;
        if (f18 < f19 + f26 && f16 < 0.0f) {
            canvas.drawText(this.f93035h, f16 + f17 + f26, this.f93037m, this.f93034f);
        }
        float f27 = this.f93036i;
        if (this.C + f27 + this.E < 0.0f && f27 < 0.0f) {
            this.f93036i = 0.0f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        this.f93036i = 0.0f;
        this.C = this.f93034f.measureText(this.f93035h);
        this.D = d(i3);
        this.f93037m = getPaddingTop() + Math.abs(this.f93034f.ascent());
        int c16 = c(i16);
        while (true) {
            float f16 = this.C;
            int i17 = this.D;
            if (f16 <= i17) {
                String str = this.f93035h + "     " + this.f93035h;
                this.f93035h = str;
                this.C = this.f93034f.measureText(str);
                this.D = d(i3);
            } else {
                setMeasuredDimension(i17, c16);
                return;
            }
        }
    }

    public void setScroll(boolean z16) {
        this.f93033e = z16;
        invalidate();
    }

    public void setText(String str) {
        this.f93035h = str;
        if (TextUtils.isEmpty(str)) {
            this.f93035h = "";
        }
        this.E = this.f93034f.measureText("     ");
        this.f93036i = 0.0f;
        requestLayout();
        invalidate();
    }

    public void setTextColor(int i3) {
        this.G = i3;
        this.f93034f.setColor(i3);
        invalidate();
    }

    public void setTextSize(float f16) {
        this.F = f16;
        this.f93034f.setTextSize(f16);
        requestLayout();
        invalidate();
    }

    public void setTextSpeed(float f16) {
        this.f93032d = f16;
        invalidate();
    }

    public QCircleMarqueeTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
    
        if (r4 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QCircleMarqueeTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93033e = true;
        this.I = new UpdateProgressTask(this);
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, y91.a.f449773p5);
                this.F = typedArray.getDimensionPixelSize(y91.a.f449812s5, cx.a(20.0f));
                this.G = typedArray.getResourceId(y91.a.f449799r5, R.color.qvideo_skin_color_text_primary);
                this.f93032d = cx.a(typedArray.getFloat(y91.a.f449825t5, 0.75f));
                this.f93035h = typedArray.getString(y91.a.f449786q5);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            typedArray.recycle();
            b(context);
        } catch (Throwable th5) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th5;
        }
    }
}
