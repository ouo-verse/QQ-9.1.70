package com.qzone.album.ui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import com.qzone.album.util.r;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes39.dex */
public class LoveWave extends View {
    private int C;
    private int D;
    private Paint E;
    private int F;
    private Paint G;
    private int H;
    private int I;
    private float J;
    private Drawable K;
    private String L;
    private Path M;
    RectF N;
    private float P;
    private a Q;

    /* renamed from: d, reason: collision with root package name */
    private Paint f44190d;

    /* renamed from: e, reason: collision with root package name */
    private long f44191e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f44192f;

    /* renamed from: h, reason: collision with root package name */
    private float f44193h;

    /* renamed from: i, reason: collision with root package name */
    private float f44194i;

    /* renamed from: m, reason: collision with root package name */
    private float f44195m;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class a extends Handler {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<LoveWave> f44196a;

        /* renamed from: b, reason: collision with root package name */
        private int f44197b = 100;

        public a(LoveWave loveWave) {
            this.f44196a = null;
            this.f44196a = new WeakReference<>(loveWave);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (this.f44196a.get() != null) {
                this.f44196a.get().invalidate();
                sendEmptyMessageDelayed(0, this.f44197b);
            }
        }
    }

    public LoveWave(Context context) {
        super(context);
        this.f44190d = null;
        this.f44191e = 0L;
        this.f44192f = false;
        this.f44193h = 5.0f;
        this.f44194i = 0.03f;
        this.f44195m = 0.1f;
        this.C = 255;
        this.D = -105333;
        this.E = null;
        this.F = -10343;
        this.K = null;
        this.L = "M53,1.2 C75.8,-0.9,94.3,13.8,95.6,17.1 C95.6,17.1,108.3,4,128.8,1.2 C149.4,-1.5,167.1,7.3,179.3,20.7 C191.5,34.1,197.6,60.9,185.1,90.6 C172.6,120.4,137,146.2,120.1,155.5 C103.4,164.7,99.2,167,99.2,167 C99.2,167,97.4,167.7,94.6,168 C92.5,166.8,90.6,165.5,90.6,165.5 C90.6,165.5,45.9,142.7,25.5,117.9 C5.2,93,-5.6,68.1,4.7,37.2 C11.1,18,30.2,3.3,53,1.2 Z";
        this.N = new RectF();
        this.P = 1.0f;
        this.Q = null;
        d();
        e();
    }

    private void b() {
        this.M.computeBounds(this.N, false);
        float width = getWidth();
        RectF rectF = this.N;
        if (width < rectF.right + rectF.left) {
            float width2 = getWidth();
            RectF rectF2 = this.N;
            this.P = width2 / (rectF2.right + rectF2.left);
        }
        RectF rectF3 = this.N;
        this.H = (int) rectF3.right;
        this.I = (int) rectF3.bottom;
    }

    private void c(Canvas canvas, Region region, Paint paint) {
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while (regionIterator.next(rect)) {
            canvas.drawRect(rect, paint);
        }
    }

    private void d() {
        this.J = u4.a.z().o(3.0f);
        Paint paint = new Paint();
        this.G = paint;
        paint.setColor(-1);
        this.G.setAlpha(100);
        this.G.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f44190d = paint2;
        paint2.setColor(this.D);
        this.f44190d.setAlpha(this.C);
        this.f44190d.setAntiAlias(true);
        this.Q = new a(this);
        Paint paint3 = new Paint();
        this.E = paint3;
        paint3.setColor(this.F);
        this.E.setAlpha(125);
        this.E.setAntiAlias(true);
        this.K = getResources().getDrawable(R.drawable.fvh);
    }

    private void e() {
        try {
            this.M = new r().c(this.L);
        } catch (Exception e16) {
            e16.printStackTrace();
            this.M = new Path();
        }
    }

    public void a() {
        if (this.f44192f) {
            return;
        }
        this.f44191e = 0L;
        this.f44192f = true;
        this.Q.sendEmptyMessage(0);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        setMeasuredDimension(View.MeasureSpec.getSize(i3), View.MeasureSpec.getSize(i16));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i3;
        int i16;
        int i17;
        Path path;
        Canvas canvas2 = canvas;
        b();
        canvas.save();
        float f16 = this.P;
        canvas2.scale(f16, f16);
        canvas2.drawPath(this.M, this.G);
        if (this.f44192f && (i3 = this.H) != 0 && (i16 = this.I) != 0) {
            long j3 = this.f44191e + 1;
            this.f44191e = j3;
            if (j3 >= TTL.MAX_VALUE) {
                this.f44191e = 0L;
            }
            float f17 = this.J;
            float f18 = 2.0f;
            int i18 = (int) (i3 - (f17 * 2.0f));
            float f19 = 1.0f;
            double d16 = (i16 - (f17 * 2.0f)) * (1.0f - this.f44195m);
            int i19 = 0;
            long j16 = i18;
            double d17 = i18;
            Math.sin((((0 + (((float) (this.f44191e * j16)) * this.f44194i)) * 2.0f) * 3.141592653589793d) / d17);
            Path path2 = new Path();
            Path path3 = new Path();
            boolean z16 = true;
            int i26 = 0;
            while (true) {
                i17 = this.H;
                if (i26 >= i17) {
                    break;
                }
                float f26 = i26;
                int sin = (int) (d16 - (Math.sin(((((((float) (this.f44191e * j16)) * this.f44194i) + f26) * 2.0f) * 3.141592653589793d) / d17) * this.f44193h));
                Path path4 = path2;
                int cos = (int) (d16 - ((this.f44193h + 5.0f) * Math.cos(((((((float) (this.f44191e * j16)) * this.f44194i) + f26) * 2.0f) * 3.141592653589793d) / d17)));
                if (z16) {
                    float f27 = sin;
                    path = path4;
                    path.moveTo(f26, f27);
                    path3.moveTo(f26, cos);
                    z16 = false;
                } else {
                    path = path4;
                    path.lineTo(f26, sin);
                    path3.lineTo(f26, cos);
                }
                i26++;
                canvas2 = canvas;
                path2 = path;
                f18 = 2.0f;
                f19 = 1.0f;
                i19 = 0;
            }
            path2.lineTo(i17, this.I);
            path2.lineTo(0.0f, this.I);
            path2.close();
            Region region = new Region();
            region.setPath(this.M, new Region(i19, i19, this.H, this.I));
            Region region2 = new Region();
            region2.setPath(path2, new Region(i19, i19, this.H, this.I));
            region2.op(region, Region.Op.INTERSECT);
            this.f44190d.setShader(new LinearGradient(0.0f, this.I, this.H, 0.0f, this.D, this.F, Shader.TileMode.REPEAT));
            c(canvas2, region2, this.f44190d);
            canvas.restore();
            Drawable drawable = this.K;
            if (drawable != null) {
                drawable.setBounds(i19, i19, drawable.getIntrinsicWidth(), this.K.getIntrinsicHeight());
                float f28 = this.P;
                if (f28 != f19) {
                    RectF rectF = this.N;
                    canvas2.translate(((((rectF.right * f28) / f18) + (rectF.left * f28)) - (this.K.getIntrinsicWidth() / 2)) + ViewUtils.dip2px(f19), (this.N.bottom * this.P) - ViewUtils.dip2px(f19));
                } else {
                    RectF rectF2 = this.N;
                    canvas2.translate((((rectF2.right / f18) + rectF2.left) - (this.K.getIntrinsicWidth() / 2)) + ViewUtils.dip2px(f19), this.N.bottom - ViewUtils.dip2px(f19));
                }
                this.K.draw(canvas2);
                return;
            }
            return;
        }
        canvas.drawRect(0.0f, r1 / 2, this.H, this.I, this.f44190d);
    }

    public void setPercent(long j3) {
        if (j3 < 10) {
            this.f44195m = 0.1f;
        } else {
            this.f44195m = (float) ((j3 * 1.0d) / 100.0d);
        }
    }

    public LoveWave(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f44190d = null;
        this.f44191e = 0L;
        this.f44192f = false;
        this.f44193h = 5.0f;
        this.f44194i = 0.03f;
        this.f44195m = 0.1f;
        this.C = 255;
        this.D = -105333;
        this.E = null;
        this.F = -10343;
        this.K = null;
        this.L = "M53,1.2 C75.8,-0.9,94.3,13.8,95.6,17.1 C95.6,17.1,108.3,4,128.8,1.2 C149.4,-1.5,167.1,7.3,179.3,20.7 C191.5,34.1,197.6,60.9,185.1,90.6 C172.6,120.4,137,146.2,120.1,155.5 C103.4,164.7,99.2,167,99.2,167 C99.2,167,97.4,167.7,94.6,168 C92.5,166.8,90.6,165.5,90.6,165.5 C90.6,165.5,45.9,142.7,25.5,117.9 C5.2,93,-5.6,68.1,4.7,37.2 C11.1,18,30.2,3.3,53,1.2 Z";
        this.N = new RectF();
        this.P = 1.0f;
        this.Q = null;
        d();
        e();
    }

    public LoveWave(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f44190d = null;
        this.f44191e = 0L;
        this.f44192f = false;
        this.f44193h = 5.0f;
        this.f44194i = 0.03f;
        this.f44195m = 0.1f;
        this.C = 255;
        this.D = -105333;
        this.E = null;
        this.F = -10343;
        this.K = null;
        this.L = "M53,1.2 C75.8,-0.9,94.3,13.8,95.6,17.1 C95.6,17.1,108.3,4,128.8,1.2 C149.4,-1.5,167.1,7.3,179.3,20.7 C191.5,34.1,197.6,60.9,185.1,90.6 C172.6,120.4,137,146.2,120.1,155.5 C103.4,164.7,99.2,167,99.2,167 C99.2,167,97.4,167.7,94.6,168 C92.5,166.8,90.6,165.5,90.6,165.5 C90.6,165.5,45.9,142.7,25.5,117.9 C5.2,93,-5.6,68.1,4.7,37.2 C11.1,18,30.2,3.3,53,1.2 Z";
        this.N = new RectF();
        this.P = 1.0f;
        this.Q = null;
        d();
        e();
    }
}
