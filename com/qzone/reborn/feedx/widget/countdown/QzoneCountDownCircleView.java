package com.qzone.reborn.feedx.widget.countdown;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.proxy.feedcomponent.FeedGlobalEnv;
import com.qzone.proxy.feedcomponent.util.g;
import com.tencent.mobileqq.richstatus.RichStatus;

/* compiled from: P */
/* loaded from: classes37.dex */
public class QzoneCountDownCircleView extends View {

    /* renamed from: h, reason: collision with root package name */
    private static final long f56022h = i.H().S("QZoneSetting", "QzoneMoodDeleteTime", 86400);

    /* renamed from: i, reason: collision with root package name */
    static final int f56023i = (int) (FeedGlobalEnv.g().getDensity() * 5.0f);

    /* renamed from: m, reason: collision with root package name */
    static final int f56024m = (int) (FeedGlobalEnv.g().getDensity() * 12.0f);

    /* renamed from: d, reason: collision with root package name */
    private Paint f56025d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f56026e;

    /* renamed from: f, reason: collision with root package name */
    private long f56027f;

    public QzoneCountDownCircleView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.f56025d = paint;
        paint.setAntiAlias(true);
        this.f56025d.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.f56026e = paint2;
        paint2.setAntiAlias(true);
        this.f56026e.setStyle(Paint.Style.STROKE);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        long B0 = this.f56027f - (i.H().B0() / 1000);
        if (B0 > 0) {
            long j3 = f56022h;
            i3 = B0 >= j3 ? 25 : (int) Math.ceil((B0 * 24.0d) / j3);
        } else {
            i3 = 0;
        }
        int i16 = (f56024m / 2) * 2;
        int measuredHeight = (getMeasuredHeight() - i16) / 2;
        int i17 = AreaConst.f48746dp1;
        float f16 = measuredHeight + i17;
        float f17 = i17;
        float f18 = i16;
        RectF rectF = new RectF(f17, f16, f18 + f17, f18 + f16);
        this.f56026e.setStrokeWidth(g.a(1.0f));
        float f19 = 360.0f - (i3 * 14.4f);
        Path path = new Path();
        path.addArc(rectF, 0.0f, 360.0f);
        this.f56026e.setColor(RichStatus.ACTION_COLOR_PRESSED);
        canvas.drawPath(path, this.f56026e);
        this.f56025d.setColor(RichStatus.ACTION_COLOR_PRESSED);
        canvas.drawArc(rectF, -90.0f, f19, true, this.f56025d);
        canvas.translate(r1 + f56023i, 0.0f);
    }

    public void setFeedDelTime(long j3) {
        this.f56027f = j3;
    }

    public QzoneCountDownCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QzoneCountDownCircleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a();
    }
}
