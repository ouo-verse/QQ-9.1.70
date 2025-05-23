package com.tencent.mobileqq.ar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.internal.view.SupportMenu;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.List;

/* compiled from: P */
/* loaded from: classes11.dex */
public class DrawView2 extends View {
    public static float C = 1.0f;
    public static int D = 0;
    public static int E = 0;
    public static int F = 0;
    public static int G = 0;

    /* renamed from: m, reason: collision with root package name */
    public static float f197420m = 1.0f;

    /* renamed from: d, reason: collision with root package name */
    private Paint f197421d;

    /* renamed from: e, reason: collision with root package name */
    private Paint f197422e;

    /* renamed from: f, reason: collision with root package name */
    HandlerThread f197423f;

    /* renamed from: h, reason: collision with root package name */
    Handler f197424h;

    /* renamed from: i, reason: collision with root package name */
    List<a> f197425i;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.ar.DrawView2$1, reason: invalid class name */
    /* loaded from: classes11.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ List f197426d;
        final /* synthetic */ DrawView2 this$0;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.setFaceData(this.f197426d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public float[] f197427a;

        /* renamed from: b, reason: collision with root package name */
        public Rect f197428b;

        /* renamed from: c, reason: collision with root package name */
        public RectF f197429c;

        /* renamed from: d, reason: collision with root package name */
        public String f197430d;

        /* renamed from: e, reason: collision with root package name */
        public String f197431e;

        /* renamed from: f, reason: collision with root package name */
        public int f197432f;

        /* renamed from: g, reason: collision with root package name */
        public String f197433g;

        /* renamed from: h, reason: collision with root package name */
        public boolean f197434h;

        /* renamed from: i, reason: collision with root package name */
        public String f197435i;

        /* renamed from: j, reason: collision with root package name */
        public String f197436j;

        /* renamed from: k, reason: collision with root package name */
        public String f197437k;

        /* renamed from: l, reason: collision with root package name */
        public String f197438l;

        /* renamed from: m, reason: collision with root package name */
        public boolean f197439m;

        /* renamed from: n, reason: collision with root package name */
        public boolean f197440n;

        /* renamed from: o, reason: collision with root package name */
        public float f197441o;

        /* renamed from: p, reason: collision with root package name */
        public String f197442p;

        /* renamed from: q, reason: collision with root package name */
        public boolean f197443q;

        /* renamed from: r, reason: collision with root package name */
        public boolean f197444r;

        public static RectF b(Rect rect, float[] fArr) {
            float f16;
            if (rect != null && fArr != null && fArr.length >= 180) {
                float[] fArr2 = (float[]) fArr.clone();
                float[] fArr3 = {fArr2[12], fArr2[13]};
                float[] fArr4 = {fArr2[28], fArr2[29]};
                float f17 = fArr2[64];
                float f18 = fArr2[65];
                float f19 = (fArr3[0] + fArr4[0]) - f17;
                float[] fArr5 = {f19, (fArr3[1] + fArr4[1]) - f18};
                float min = Math.min(rect.left, f19);
                float max = Math.max(rect.right, fArr5[0]);
                float min2 = Math.min(rect.top, fArr5[1]);
                float max2 = Math.max(rect.bottom, fArr5[1]);
                float f26 = DrawView2.F / DrawView2.G;
                float max3 = Math.max(DrawView2.D, DrawView2.E);
                float min3 = Math.min(DrawView2.D, DrawView2.E);
                if (f26 > min3 / max3) {
                    f16 = DrawView2.F / min3;
                } else {
                    f16 = DrawView2.G / max3;
                }
                float f27 = min3 * f16;
                int i3 = DrawView2.F;
                float f28 = (min * f16) - ((f27 - i3) / 2.0f);
                float f29 = (max * f16) - ((f27 - i3) / 2.0f);
                float f36 = max3 * f16;
                int i16 = DrawView2.G;
                RectF rectF = new RectF(f28, (min2 * f16) - ((f36 - i16) / 2.0f), f29, (max2 * f16) - ((f36 - i16) / 2.0f));
                if (QLog.isColorLevel()) {
                    QLog.d("DrawView", 2, "mapFaceRect2Screen  result = " + rectF.toString());
                }
                return rectF;
            }
            return null;
        }

        public static RectF c(RectF rectF) {
            if (rectF == null) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DrawView", 2, "faceRect  result = " + rectF.toString());
            }
            float f16 = rectF.left;
            if (f16 == 0.0f && rectF.top == 0.0f && rectF.right == 0.0f) {
                return new RectF((DrawView2.F / 2) - 210, (DrawView2.G / 2) - 210, (DrawView2.F / 2) + 210, (DrawView2.G / 2) + 210);
            }
            float f17 = rectF.right;
            float f18 = ((f16 + f17) / 2.0f) * (DrawView2.F / 480);
            float f19 = ((rectF.top + rectF.bottom) / 2.0f) * (DrawView2.G / 856);
            float f26 = f18 - 210.0f;
            float f27 = f19 - 210.0f;
            float f28 = f18 + 210.0f;
            float f29 = f19 + 210.0f;
            if (QLog.isColorLevel()) {
                QLog.d("DrawView", 2, "mapMigObjectRect2Screen1  result = " + f26 + "   \uff1a" + f27 + "  \uff1a" + f28 + "  \uff1a" + f29);
            }
            if (f26 < 40.0f) {
                f28 = (f28 - f26) + 40.0f;
                f26 = 40.0f;
            }
            if (f27 < 40.0f) {
                f29 = (f29 - f27) + 40.0f;
                f27 = 40.0f;
            }
            int i3 = DrawView2.F;
            if (f28 > i3 - 40) {
                f26 = (i3 - 40) - (f28 - f26);
                f28 = i3 - 40;
            }
            int i16 = DrawView2.G;
            if (f29 > i16 - 40) {
                f27 = (i16 - 40) - (f29 - f27);
                f29 = i16 - 40;
            }
            if (QLog.isColorLevel()) {
                QLog.d("DrawView", 2, "mapMigObjectRect2Screen1  result = " + f26 + "   \uff1a" + f27 + "  \uff1a" + f28 + "  \uff1a" + f29);
            }
            float f36 = (f26 + f28) / 2.0f;
            int i17 = DrawView2.F;
            if (f36 < (i17 / 2) - 125) {
                f26 = ((i17 / 2) - 125) - 210;
                f28 = ((i17 / 2) - 125) + 210;
            }
            if ((f26 + f28) / 2.0f > (i17 / 2) + 125) {
                f26 = ((i17 / 2) + 125) - 210;
                f28 = (i17 / 2) + 125 + 210;
            }
            float f37 = (f27 + f29) / 2.0f;
            int i18 = DrawView2.G;
            if (f37 < (i18 / 2) - 417) {
                f27 = ((i18 / 2) - 417) - 210;
                f29 = ((i18 / 2) - 417) + 210;
            }
            if ((f27 + f29) / 2.0f > (i18 / 2) + 417) {
                f27 = ((i18 / 2) + 417) - 210;
                f29 = (i18 / 2) + 417 + 210;
            }
            RectF rectF2 = new RectF(f26, f27, f28, f29);
            if (QLog.isColorLevel()) {
                QLog.d("DrawView", 2, "mapMigObjectRect2Screen3  result = " + rectF2.toString());
            }
            return rectF2;
        }

        public RectF a() {
            return this.f197429c;
        }
    }

    public DrawView2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f197421d = new Paint();
        this.f197422e = new Paint();
        this.f197421d.setARGB(255, 0, 255, 0);
        this.f197421d.setStrokeWidth(10.0f);
        this.f197421d.setStyle(Paint.Style.STROKE);
        this.f197422e.setStrokeWidth(10.0f);
        this.f197422e.setTextSize(30.0f);
        this.f197422e.setColor(SupportMenu.CATEGORY_MASK);
        setWillNotDraw(false);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("DrawViewThread");
        this.f197423f = baseHandlerThread;
        baseHandlerThread.start();
        this.f197424h = new Handler(this.f197423f.getLooper());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f16;
        float f17;
        List<a> list = this.f197425i;
        if (list != null && list.size() > 0) {
            for (a aVar : this.f197425i) {
                canvas.save();
                for (int i3 = 0; i3 < 90; i3++) {
                    float f18 = f197420m;
                    if (f18 != 1.0f) {
                        float[] fArr = aVar.f197427a;
                        int i16 = i3 * 2;
                        float f19 = fArr[i16];
                        int i17 = D;
                        int i18 = F;
                        f16 = ((f19 - (i17 / 2)) * ((i18 / 2) / ((i17 / 2) / f18))) + (i18 / 2);
                        f17 = (fArr[i16 + 1] * G) / E;
                    } else {
                        float f26 = C;
                        if (f26 != 1.0f) {
                            float[] fArr2 = aVar.f197427a;
                            int i19 = i3 * 2;
                            f16 = (fArr2[i19] * F) / D;
                            float f27 = fArr2[i19 + 1];
                            int i26 = E;
                            int i27 = G;
                            f17 = (i27 / 2) + ((f27 - (i26 / 2)) * ((i27 / 2) / ((i26 / 2) / f26)));
                        } else {
                            f16 = 0.0f;
                            f17 = 0.0f;
                        }
                    }
                    canvas.drawPoint(f16, f17, this.f197421d);
                    if (!TextUtils.isEmpty(aVar.f197430d) && i3 == 87) {
                        canvas.drawText(aVar.f197430d, f16, f17, this.f197422e);
                    }
                }
                canvas.restore();
            }
        }
    }

    public void setFaceData(List<a> list) {
        this.f197425i = list;
        postInvalidate();
    }
}
