package com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends tr.a {
    public int K;
    public int L;
    public int M;
    public int N;
    private PointF P;
    private int Q;
    int R;
    int S;
    private Paint T;
    private Paint U;
    private Path V;
    private zr.c W;
    private float X;
    private boolean Y;
    private boolean Z;

    public b(DoodleView doodleView) {
        super(doodleView);
        this.K = 0;
        this.L = 0;
        this.M = 0;
        this.N = 0;
        this.R = 0;
        this.S = 0;
        this.X = 45.0f;
        this.Y = false;
        this.Z = false;
        l();
    }

    private void l() {
        Paint paint = new Paint();
        this.T = paint;
        paint.setAntiAlias(true);
        this.T.setColor(Color.parseColor("#12B7F5"));
        this.T.setStyle(Paint.Style.STROKE);
        this.T.setStrokeWidth(2.0f);
        Paint paint2 = new Paint();
        this.U = paint2;
        paint2.setAntiAlias(true);
        this.U.setColor(Color.parseColor("#12B7F5"));
        this.U.setStyle(Paint.Style.STROKE);
        this.U.setStrokeWidth(2.0f);
        this.U.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, 1.0f));
        this.V = new Path();
        DisplayMetrics displayMetrics = this.f437143e.getResources().getDisplayMetrics();
        this.K = 0;
        this.L = displayMetrics.widthPixels;
        this.M = 0;
        this.N = displayMetrics.heightPixels;
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            this.N = (displayMetrics.heightPixels - LiuHaiUtils.BOTTOM_HEIGHT) - LiuHaiUtils.sNotchHeight;
        }
        this.Q = (int) Math.sqrt(Math.pow(displayMetrics.heightPixels, 2.0d) + Math.pow(displayMetrics.widthPixels, 2.0d));
        this.P = new PointF(this.L / 2, this.N / 2);
        zr.c cVar = new zr.c();
        this.W = cVar;
        cVar.A(true);
        this.W.y(18.0f);
        this.W.z(0.5f);
    }

    public void C(boolean z16, float f16, int i3, int i16, PointF pointF, boolean z17, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d("GuideLineLayer", 2, "GuideLineLayer refreshed, entrance : " + i17);
        }
        this.Z = z16;
        E(f16);
        F(i3);
        G(i16);
        D(pointF);
        this.Y = z17;
        n();
    }

    public void F(int i3) {
        this.R = i3;
    }

    public void G(int i3) {
        this.S = i3;
    }

    @Override // tr.d
    public boolean a(MotionEvent motionEvent) {
        return false;
    }

    @Override // tr.a
    public String h() {
        return "GuideLineLayer";
    }

    @Override // tr.d
    public boolean isEmpty() {
        return true;
    }

    @Override // tr.a
    public boolean m(long j3) {
        return true;
    }

    @Override // tr.a
    protected void p(Canvas canvas) {
        canvas.save();
        if (this.Z && this.Y && Math.abs(((int) this.X) % 45) < 3) {
            PointF pointF = this.P;
            canvas.translate(pointF.x, pointF.y);
            canvas.translate(this.R, this.S);
            int round = Math.round(this.X / 45.0f) * 45;
            if (QLog.isColorLevel()) {
                QLog.d("GuideLineLayer", 2, "currentDegree : " + this.X + "   guideLine Angle : " + round);
            }
            canvas.rotate(round);
            this.V.reset();
            this.V.moveTo(-this.Q, 0.0f);
            this.V.lineTo(this.Q, 0.0f);
            canvas.drawPath(this.V, this.U);
            if (QLog.isColorLevel()) {
                QLog.d("GuideLineLayer", 2, "draw angle guide line");
            }
        }
        canvas.restore();
        canvas.save();
        if (this.Z && Math.abs((this.P.x + this.R) - ((this.K + this.L) / 2)) < 4.0f) {
            this.V.reset();
            this.V.moveTo((this.K + this.L) / 2, 0.0f);
            this.V.lineTo((this.K + this.L) / 2, this.N);
            canvas.drawPath(this.V, this.T);
            if (QLog.isColorLevel()) {
                QLog.d("GuideLineLayer", 2, "draw X guide line");
            }
        }
        if (this.Z && Math.abs((this.P.y + this.S) - ((this.M + this.N) / 2)) < 4.0f) {
            this.V.reset();
            this.V.moveTo(this.K, (this.M + this.N) / 2);
            this.V.lineTo(this.L, (this.M + this.N) / 2);
            canvas.drawPath(this.V, this.T);
            if (QLog.isColorLevel()) {
                QLog.d("GuideLineLayer", 2, "draw Y guide line");
            }
        }
        canvas.restore();
    }

    @Override // tr.a
    protected boolean q(MotionEvent motionEvent) {
        return false;
    }

    public void D(PointF pointF) {
        if (pointF == null) {
            return;
        }
        this.P.set(pointF);
    }

    public void E(float f16) {
        if (f16 < 0.0f) {
            return;
        }
        this.X = f16;
    }

    @Override // tr.d
    public void b(Canvas canvas) {
    }

    @Override // tr.d
    public void clear() {
    }
}
