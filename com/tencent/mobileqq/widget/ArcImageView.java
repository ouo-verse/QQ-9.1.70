package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ArcImageView extends ImageView {

    /* renamed from: d, reason: collision with root package name */
    private Drawable f315423d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f315424e;

    /* renamed from: f, reason: collision with root package name */
    private Paint f315425f;

    /* renamed from: h, reason: collision with root package name */
    private int f315426h;

    /* renamed from: i, reason: collision with root package name */
    private float f315427i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.ArcImageView$1, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f315428d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f315429e;
        final /* synthetic */ ArcImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            MobileQQ application = this.f315428d.getApplication();
            boolean Z = ea.Z(application, this.f315428d.getCurrentAccountUin(), ea.q(application), this.f315429e);
            if (QLog.isColorLevel()) {
                QLog.d("Q.recent", 2, this.f315429e + " show redDot: " + Z);
            }
            this.this$0.b(Z);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.ArcImageView$2, reason: invalid class name */
    /* loaded from: classes20.dex */
    class AnonymousClass2 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f315430d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f315431e;
        final /* synthetic */ ArcImageView this$0;

        @Override // java.lang.Runnable
        public void run() {
            MobileQQ application = this.f315430d.getApplication();
            int q16 = ea.q(application);
            if (ea.Z(application, this.f315430d.getCurrentAccountUin(), q16, this.f315431e)) {
                ea.M2(application, this.f315430d.getCurrentAccountUin(), q16, this.f315431e);
                if (QLog.isColorLevel()) {
                    QLog.d("Q.recent", 2, this.f315431e + " close redDot");
                }
            }
        }
    }

    public ArcImageView(Context context) {
        super(context);
        this.f315423d = null;
        this.f315424e = false;
        this.f315426h = 3;
        this.f315427i = 0.0f;
        a();
    }

    private void a() {
        Paint paint = new Paint();
        this.f315425f = paint;
        paint.setAntiAlias(true);
        this.f315425f.setStyle(Paint.Style.STROKE);
        try {
            this.f315425f.setColor(getResources().getColor(R.color.f158017al3));
            this.f315426h = (int) (getResources().getDisplayMetrics().density * 1.5f);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        this.f315425f.setStrokeWidth(this.f315426h);
    }

    public void b(boolean z16) {
        if (this.f315424e != z16) {
            this.f315424e = z16;
            if (z16 && this.f315423d == null) {
                this.f315423d = getResources().getDrawable(R.drawable.skin_tips_dot);
            }
            postInvalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Drawable drawable;
        super.onDraw(canvas);
        RectF rectF = new RectF();
        int i3 = this.f315426h;
        rectF.left = i3;
        rectF.top = i3;
        rectF.right = getWidth() - this.f315426h;
        rectF.bottom = getHeight() - this.f315426h;
        canvas.drawArc(rectF, 270.0f, this.f315427i, false, this.f315425f);
        if (this.f315424e && (drawable = this.f315423d) != null) {
            drawable.setState(getDrawableState());
            this.f315423d.setBounds(getWidth() - this.f315423d.getIntrinsicWidth(), 0, getWidth(), this.f315423d.getIntrinsicHeight());
            this.f315423d.draw(canvas);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x000b, code lost:
    
        if (r3 > 1.0f) goto L4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setProgress(float f16) {
        float f17 = 0.0f;
        if (f16 >= 0.0f) {
            f17 = 1.0f;
        }
        f16 = f17;
        float f18 = f16 * 360.0f;
        if (this.f315427i != f18) {
            this.f315427i = f18;
            postInvalidate();
        }
    }

    public ArcImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f315423d = null;
        this.f315424e = false;
        this.f315426h = 3;
        this.f315427i = 0.0f;
        a();
    }

    public ArcImageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f315423d = null;
        this.f315424e = false;
        this.f315426h = 3;
        this.f315427i = 0.0f;
        a();
    }
}
