package com.tencent.av.doodle;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.SystemClock;
import androidx.core.internal.view.SupportMenu;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d extends f {

    /* renamed from: l, reason: collision with root package name */
    private Paint f73621l;

    /* renamed from: m, reason: collision with root package name */
    private Queue<a> f73622m = new LinkedList();

    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        public float f73623a;

        /* renamed from: b, reason: collision with root package name */
        public long f73624b = SystemClock.elapsedRealtime();

        public a(float f16) {
            this.f73623a = f16;
        }
    }

    public d() {
        Paint paint = new Paint();
        this.f73621l = paint;
        paint.setAntiAlias(true);
        this.f73621l.setDither(true);
        this.f73621l.setColor(SupportMenu.CATEGORY_MASK);
        this.f73621l.setStyle(Paint.Style.STROKE);
        this.f73621l.setStrokeJoin(Paint.Join.ROUND);
        this.f73621l.setStrokeCap(Paint.Cap.ROUND);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x005a  */
    @Override // com.tencent.av.doodle.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(Canvas canvas, MySurfaceView mySurfaceView, boolean z16) {
        boolean z17;
        this.f73621l.setColor(this.f73614g);
        float f16 = this.f73612e * 0.011111111f;
        this.f73621l.setStrokeWidth(f16);
        this.f73621l.setStyle(Paint.Style.STROKE);
        long j3 = this.f73616i;
        if (j3 != -1) {
            long j16 = mySurfaceView.f73606e;
            if (j16 - j3 > 1200) {
                this.f73621l.setAlpha((int) (255 - ((((j16 - j3) - 1200) * 255) / 800)));
                a aVar = null;
                this.f73621l.setMaskFilter(null);
                float f17 = 0.0f;
                if (this.f73631k.getLength() <= 0.0f) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z17) {
                    canvas.drawPath(this.f73630j, this.f73621l);
                } else {
                    PointF pointF = this.f73615h;
                    canvas.drawPoint(pointF.x, pointF.y, this.f73621l);
                }
                if (!z16 && this.f73622m.size() > 0) {
                    long elapsedRealtime = SystemClock.elapsedRealtime() - 500;
                    a aVar2 = (a) ((LinkedList) this.f73622m).getLast();
                    Iterator<a> it = this.f73622m.iterator();
                    a aVar3 = null;
                    while (it.hasNext()) {
                        aVar3 = it.next();
                        if (aVar3.f73624b - elapsedRealtime >= 0) {
                            break;
                        } else {
                            aVar = aVar3;
                        }
                    }
                    float f18 = aVar2.f73623a;
                    if (aVar3 != null) {
                        if (aVar != null && aVar != aVar3) {
                            float f19 = aVar.f73623a;
                            long j17 = aVar3.f73624b;
                            float f26 = aVar3.f73623a;
                            long j18 = aVar.f73624b;
                            f17 = ((f19 * ((float) (j17 - elapsedRealtime))) + (f26 * ((float) (elapsedRealtime - j18)))) / ((float) (j17 - j18));
                        } else {
                            f17 = aVar3.f73623a;
                        }
                    }
                    float f27 = ((this.f73612e * 0.014814815f) * ((float) (aVar2.f73624b - elapsedRealtime))) / 500.0f;
                    float f28 = f16 / 2.0f;
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    Path path = new Path();
                    this.f73621l.setStyle(Paint.Style.FILL);
                    this.f73621l.setColor(-1);
                    path.setFillType(Path.FillType.WINDING);
                    float f29 = f18 - f17;
                    float f36 = (f27 - f28) / f29;
                    int[] iArr = {this.f73614g, -1};
                    float f37 = this.f73612e * 0.0055555557f;
                    while (f17 <= aVar2.f73623a) {
                        this.f73631k.getPosTan(f17, fArr, fArr2);
                        float f38 = f18 - f17;
                        this.f73621l.setColor(DoodleUtils.c(iArr, 1.0f - (f38 / f29)));
                        canvas.drawCircle(fArr[0], fArr[1], f27 - (f36 * f38), this.f73621l);
                        f17 += f37;
                        aVar2 = aVar2;
                    }
                    if (QLog.isDevelopLevel()) {
                        QLog.w(this.f73608a, 1, "doDrawDoodle, mScreenWidth[" + this.f73612e + "], maxRadius[" + f27 + "], minRadius[" + f28 + "], mPoint[" + this.f73615h.x + ", " + this.f73615h.y + "], startAnimationPathPointDistance[" + f37 + "]");
                        return;
                    }
                    return;
                }
            }
        }
        this.f73621l.setAlpha(255);
        a aVar4 = null;
        this.f73621l.setMaskFilter(null);
        float f172 = 0.0f;
        if (this.f73631k.getLength() <= 0.0f) {
        }
        if (!z17) {
        }
        if (!z16) {
        }
    }

    @Override // com.tencent.av.doodle.f
    public void h() {
        this.f73622m.offer(new a(this.f73631k.getLength()));
    }

    @Override // com.tencent.av.doodle.b
    public void d(long j3) {
    }
}
