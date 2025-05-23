package com.tencent.mobileqq.ar;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.ar.DrawView2;
import com.tencent.mobileqq.ar.ObjectBaseData;
import com.tencent.mobileqq.olympic.activity.a;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ObjectSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private CopyOnWriteArrayList<String> C;
    public q D;
    private List<DrawView2.a> E;
    private boolean F;
    private HandlerThread G;
    private Handler H;
    private HandlerThread I;
    private Handler J;
    private Runnable K;
    int[] L;
    float[] M;
    SweepGradient N;
    BlurMaskFilter P;
    Matrix Q;

    /* renamed from: d, reason: collision with root package name */
    private SurfaceHolder f197601d;

    /* renamed from: e, reason: collision with root package name */
    private float f197602e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f197603f;

    /* renamed from: h, reason: collision with root package name */
    private long f197604h;

    /* renamed from: i, reason: collision with root package name */
    private CopyOnWriteArrayList<ObjectBaseData> f197605i;

    /* renamed from: m, reason: collision with root package name */
    private ConcurrentHashMap<String, ObjectBaseData> f197606m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements a.i {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ObjectBaseData f197612a;

        a(ObjectBaseData objectBaseData) {
            this.f197612a = objectBaseData;
        }

        @Override // com.tencent.mobileqq.olympic.activity.a.i
        public void a() {
            ObjectSurfaceView.this.D.a();
        }

        @Override // com.tencent.mobileqq.olympic.activity.a.i
        public void onContentClick() {
            if (QLog.isColorLevel()) {
                QLog.d("ObjectSurfaceView", 2, "onContentClick wikiurl = " + this.f197612a.O);
            }
            ObjectSurfaceView.this.u(this.f197612a.O);
        }
    }

    public ObjectSurfaceView(Context context) {
        super(context);
        this.f197602e = 1.0f;
        this.f197604h = 50L;
        this.f197605i = new CopyOnWriteArrayList<>();
        this.f197606m = new ConcurrentHashMap<>();
        this.C = new CopyOnWriteArrayList<>();
        this.K = new Runnable() { // from class: com.tencent.mobileqq.ar.ObjectSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                while (ObjectSurfaceView.this.F) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ObjectSurfaceView.this.v();
                    try {
                        LockMethodProxy.sleep(Math.max(0L, ObjectSurfaceView.this.f197604h - (System.currentTimeMillis() - currentTimeMillis)));
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (ObjectSurfaceView.this.f197603f) {
                    ObjectSurfaceView.this.v();
                }
            }
        };
        this.L = new int[]{Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255)};
        this.M = new float[]{0.0f, 0.5f};
        this.Q = new Matrix();
        s();
    }

    private void i(ObjectBaseData objectBaseData) {
        if (objectBaseData == null || objectBaseData.f197499h || this.f197606m.contains(objectBaseData.U)) {
            return;
        }
        this.f197606m.put(objectBaseData.U, objectBaseData);
    }

    private void j(List<ObjectBaseData> list) {
        if (list != null && list.size() != 0) {
            Iterator<ObjectBaseData> it = list.iterator();
            while (it.hasNext()) {
                i(it.next());
            }
        }
    }

    private void k(ObjectBaseData objectBaseData) {
        if (objectBaseData != null) {
            for (int i3 = 0; i3 < this.f197605i.size(); i3++) {
                try {
                    ObjectBaseData objectBaseData2 = this.f197605i.get(i3);
                    if (objectBaseData2 != null) {
                        if (objectBaseData2.U.equals(objectBaseData.U) && objectBaseData2.f197499h == objectBaseData.f197499h) {
                            return;
                        }
                    } else {
                        this.f197605i.remove(i3);
                    }
                } catch (Exception e16) {
                    QLog.e("ObjectSurfaceView", 1, "addObjectData", e16);
                    return;
                }
            }
            this.f197605i.add(objectBaseData);
        }
    }

    private float n(float f16, float f17) {
        if (f17 >= f16) {
            return f17 - f16;
        }
        return (f17 + 360.0f) - f16;
    }

    public static int o(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:155:0x06d4  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x06de  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0710  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x075c  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0784  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x07aa  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x07ed  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0801  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x08ea  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x08fe  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0839  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x080d  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x07f4  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0790  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0bef  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x0bff  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0c1d  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0c13  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0976  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0980  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x09af  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x09fb  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0a23  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0a49  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0a8e  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0aa2  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x0ac1  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0bb8  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0bcc  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0b2f  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0aaf  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0a95  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0a2f  */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v13, types: [android.graphics.MaskFilter, android.graphics.Shader] */
    /* JADX WARN: Type inference failed for: r2v259 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void p(Canvas canvas) {
        ?? r26;
        ObjectBaseData objectBaseData;
        int i3;
        float f16;
        float f17;
        float f18;
        float f19;
        int i16;
        int length;
        float f26;
        float f27;
        char c16;
        char c17;
        boolean z16;
        float f28;
        float f29;
        float f36;
        float f37;
        int length2;
        float f38;
        Canvas canvas2 = canvas;
        if (canvas2 != null) {
            final ObjectBaseData q16 = q();
            char c18 = 1;
            char c19 = 0;
            char c26 = 1;
            int i17 = 0;
            while (i17 < this.f197605i.size()) {
                final ObjectBaseData objectBaseData2 = this.f197605i.get(i17);
                if (objectBaseData2 == null) {
                    return;
                }
                if (!objectBaseData2.T) {
                    this.H.post(new Runnable() { // from class: com.tencent.mobileqq.ar.ObjectSurfaceView.2
                        @Override // java.lang.Runnable
                        public void run() {
                            boolean z17;
                            ObjectBaseData objectBaseData3 = objectBaseData2;
                            ObjectBaseData objectBaseData4 = q16;
                            if (objectBaseData4 != null && objectBaseData4.f197479c && objectBaseData4.P && !objectBaseData4.f197499h) {
                                z17 = true;
                            } else {
                                z17 = false;
                            }
                            objectBaseData3.f(z17);
                        }
                    });
                    if (objectBaseData2.f197479c && !objectBaseData2.f197483d && objectBaseData2.Q && !objectBaseData2.f197499h) {
                        if (!TextUtils.isEmpty(objectBaseData2.R)) {
                            if (!this.C.contains(objectBaseData2.R)) {
                                final String str = objectBaseData2.R;
                                final String str2 = objectBaseData2.N;
                                this.H.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ar.ObjectSurfaceView.3
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (ObjectSurfaceView.this.f197605i.size() > 0) {
                                            ObjectSurfaceView.this.C.add(str);
                                            ObjectSurfaceView.this.t(str2);
                                        } else {
                                            QLog.d("ObjectSurfaceView", 1, "the dataList is null, cancel the jump action.");
                                        }
                                    }
                                }, 4000L);
                            }
                        } else if (objectBaseData2.Q) {
                            this.H.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ar.ObjectSurfaceView.4
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (ObjectSurfaceView.this.f197605i.size() > 0) {
                                        ObjectSurfaceView.this.t(objectBaseData2.O);
                                    } else {
                                        QLog.d("ObjectSurfaceView", 1, "the dataList is null, cancel the jump action.");
                                    }
                                }
                            }, 4000L);
                        }
                    }
                }
                objectBaseData2.H2.setColor(objectBaseData2.G);
                objectBaseData2.H2.setStrokeWidth(objectBaseData2.f197527o);
                if ((objectBaseData2.f197479c || objectBaseData2.f197491f) && objectBaseData2.P && !objectBaseData2.f197499h) {
                    objectBaseData2.H2.setAlpha((int) (objectBaseData2.F * 255.0f));
                } else {
                    objectBaseData2.H2.setAlpha((int) (objectBaseData2.F * 255.0f * 0.5d));
                }
                float f39 = (objectBaseData2.f197515l * objectBaseData2.f197519m) + objectBaseData2.f197527o;
                float f46 = objectBaseData2.f197469a;
                float f47 = objectBaseData2.f197474b;
                RectF rectF = new RectF(f46 - f39, f47 - f39, f46 + f39, f47 + f39);
                if (objectBaseData2.G != -1 && objectBaseData2.f197479c && !objectBaseData2.f197499h) {
                    this.N = new SweepGradient(objectBaseData2.f197469a, objectBaseData2.f197474b, this.L, this.M);
                    this.Q.setRotate((objectBaseData2.f197531p + objectBaseData2.f197523n) - 5.0f, objectBaseData2.f197469a, objectBaseData2.f197474b);
                    this.N.setLocalMatrix(this.Q);
                    objectBaseData2.H2.setShader(this.N);
                } else {
                    objectBaseData2.H2.setShader(null);
                }
                if (objectBaseData2.f197471a1 != 0.0f) {
                    this.P = new BlurMaskFilter(objectBaseData2.f197476b1 * objectBaseData2.f197471a1, BlurMaskFilter.Blur.SOLID);
                } else {
                    this.P = null;
                }
                BlurMaskFilter blurMaskFilter = this.P;
                if (blurMaskFilter != null) {
                    objectBaseData2.H2.setMaskFilter(blurMaskFilter);
                    objectBaseData2.H2.setShader(null);
                } else {
                    objectBaseData2.H2.setMaskFilter(null);
                }
                float f48 = objectBaseData2.f197531p;
                float f49 = objectBaseData2.f197523n;
                canvas.drawArc(rectF, f48 + f49, n(f48 + f49, objectBaseData2.f197535q + f49), false, objectBaseData2.H2);
                if (objectBaseData2.G != -1 && objectBaseData2.f197479c && !objectBaseData2.f197499h) {
                    int[] iArr = new int[2];
                    iArr[c19] = objectBaseData2.f197551u;
                    iArr[c18] = objectBaseData2.f197547t;
                    this.L = iArr;
                    this.N = new SweepGradient(objectBaseData2.f197469a, objectBaseData2.f197474b, this.L, this.M);
                    this.Q.setRotate((objectBaseData2.f197539r + objectBaseData2.f197523n) - 5.0f, objectBaseData2.f197469a, objectBaseData2.f197474b);
                    this.N.setLocalMatrix(this.Q);
                    objectBaseData2.H2.setShader(this.N);
                    r26 = 0;
                } else {
                    r26 = 0;
                    objectBaseData2.H2.setShader(null);
                }
                BlurMaskFilter blurMaskFilter2 = this.P;
                if (blurMaskFilter2 != null) {
                    objectBaseData2.H2.setMaskFilter(blurMaskFilter2);
                    objectBaseData2.H2.setShader(r26);
                } else {
                    objectBaseData2.H2.setMaskFilter(r26);
                }
                float f56 = objectBaseData2.f197539r;
                float f57 = objectBaseData2.f197523n;
                canvas.drawArc(rectF, f56 + f57, n(f56 + f57, objectBaseData2.f197543s + f57), false, objectBaseData2.H2);
                if (objectBaseData2.E <= 0.0f || !((objectBaseData2.f197479c || objectBaseData2.f197491f) && objectBaseData2.P && !objectBaseData2.f197499h)) {
                    objectBaseData = q16;
                    i3 = i17;
                } else {
                    float f58 = objectBaseData2.f197527o;
                    objectBaseData2.f197567y = (float) ((((objectBaseData2.f197515l * objectBaseData2.f197519m) + f58) * Math.cos(((objectBaseData2.f197559w + objectBaseData2.f197523n) * 3.141592653589793d) / 180.0d)) + objectBaseData2.f197469a);
                    objectBaseData2.f197571z = (float) ((((objectBaseData2.f197515l * objectBaseData2.f197519m) + f58) * Math.sin(((objectBaseData2.f197559w + objectBaseData2.f197523n) * 3.141592653589793d) / 180.0d)) + objectBaseData2.f197474b);
                    float f59 = objectBaseData2.f197563x + objectBaseData2.f197523n;
                    float f65 = f59 + 120.0f;
                    float f66 = f65 + 120.0f;
                    if (f59 >= 360.0f) {
                        f59 -= 360.0f;
                    }
                    if (f65 >= 360.0f) {
                        f65 -= 360.0f;
                    }
                    if (f66 >= 360.0f) {
                        f66 -= 360.0f;
                    }
                    i3 = i17;
                    double d16 = (f59 * 3.141592653589793d) / 180.0d;
                    float cos = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.cos(d16)) + objectBaseData2.f197567y);
                    float sin = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.sin(d16)) + objectBaseData2.f197571z);
                    double d17 = (f65 * 3.141592653589793d) / 180.0d;
                    float cos2 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.cos(d17)) + objectBaseData2.f197567y);
                    float sin2 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.sin(d17)) + objectBaseData2.f197571z);
                    double d18 = (f66 * 3.141592653589793d) / 180.0d;
                    objectBaseData = q16;
                    float cos3 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.cos(d18)) + objectBaseData2.f197567y);
                    float sin3 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.sin(d18)) + objectBaseData2.f197571z);
                    Path path = new Path();
                    path.moveTo(cos, sin);
                    path.lineTo(cos2, sin2);
                    path.lineTo(cos3, sin3);
                    path.close();
                    objectBaseData2.I2.setColor(objectBaseData2.C);
                    objectBaseData2.I2.setAlpha((int) (objectBaseData2.E * 255.0f));
                    canvas.drawPath(path, objectBaseData2.I2);
                    objectBaseData2.A = (float) ((((objectBaseData2.f197515l * objectBaseData2.f197519m) + f58) * Math.cos(((objectBaseData2.f197563x + objectBaseData2.f197523n) * 3.141592653589793d) / 180.0d)) + objectBaseData2.f197469a);
                    objectBaseData2.B = (float) ((((objectBaseData2.f197515l * objectBaseData2.f197519m) + f58) * Math.sin(((objectBaseData2.f197563x + objectBaseData2.f197523n) * 3.141592653589793d) / 180.0d)) + objectBaseData2.f197474b);
                    float f67 = objectBaseData2.f197559w + objectBaseData2.f197523n;
                    float f68 = f67 + 120.0f;
                    float f69 = 120.0f + f68;
                    if (f67 >= 360.0f) {
                        f67 -= 360.0f;
                    }
                    if (f68 >= 360.0f) {
                        f68 -= 360.0f;
                    }
                    if (f69 >= 360.0f) {
                        f69 -= 360.0f;
                    }
                    double d19 = (f67 * 3.141592653589793d) / 180.0d;
                    float cos4 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.cos(d19)) + objectBaseData2.A);
                    float sin4 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.sin(d19)) + objectBaseData2.B);
                    double d26 = (f68 * 3.141592653589793d) / 180.0d;
                    float cos5 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.cos(d26)) + objectBaseData2.A);
                    float sin5 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.sin(d26)) + objectBaseData2.B);
                    double d27 = (f69 * 3.141592653589793d) / 180.0d;
                    float cos6 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.cos(d27)) + objectBaseData2.A);
                    float sin6 = (float) ((objectBaseData2.f197555v * objectBaseData2.f197519m * Math.sin(d27)) + objectBaseData2.B);
                    path.reset();
                    path.moveTo(cos4, sin4);
                    path.lineTo(cos5, sin5);
                    path.lineTo(cos6, sin6);
                    path.close();
                    objectBaseData2.I2.setColor(objectBaseData2.D);
                    objectBaseData2.I2.setAlpha((int) (objectBaseData2.E * 255.0f));
                    canvas2 = canvas;
                    canvas2.drawPath(path, objectBaseData2.I2);
                }
                if (objectBaseData2.f197488e0 > 0.0f && ((objectBaseData2.f197479c || objectBaseData2.f197491f) && objectBaseData2.P && !objectBaseData2.f197499h)) {
                    objectBaseData2.J2.setColor(objectBaseData2.f197484d0);
                    objectBaseData2.J2.setStrokeWidth(objectBaseData2.Y);
                    objectBaseData2.J2.setAlpha((int) (objectBaseData2.f197488e0 * 255.0f * 0.4d));
                    float f75 = (objectBaseData2.V * objectBaseData2.W) + objectBaseData2.Y;
                    float f76 = objectBaseData2.f197469a;
                    float f77 = objectBaseData2.f197474b;
                    RectF rectF2 = new RectF(f76 - f75, f77 - f75, f76 + f75, f77 + f75);
                    float f78 = objectBaseData2.Z;
                    float f79 = objectBaseData2.X;
                    canvas.drawArc(rectF2, f78 + f79, n(f78 + f79, objectBaseData2.f197470a0 + f79), false, objectBaseData2.J2);
                    float f85 = objectBaseData2.f197475b0;
                    float f86 = objectBaseData2.X;
                    canvas.drawArc(rectF2, f85 + f86, n(f85 + f86, objectBaseData2.f197480c0 + f86), false, objectBaseData2.J2);
                }
                objectBaseData2.K2.setColor(objectBaseData2.f197540r0);
                objectBaseData2.K2.setStrokeWidth(objectBaseData2.f197512k0);
                objectBaseData2.K2.setAlpha((int) (objectBaseData2.f197544s0 * 255.0f * 0.3d));
                float f87 = (objectBaseData2.f197496g0 * objectBaseData2.f197500h0) + objectBaseData2.f197512k0;
                float f88 = objectBaseData2.f197469a;
                float f89 = objectBaseData2.f197474b;
                RectF rectF3 = new RectF(f88 - f87, f89 - f87, f88 + f87, f89 + f87);
                float f95 = objectBaseData2.f197516l0;
                float f96 = objectBaseData2.f197504i0;
                canvas.drawArc(rectF3, f95 + f96, n(f95 + f96, objectBaseData2.f197520m0 + f96), false, objectBaseData2.K2);
                float f97 = objectBaseData2.f197532p0;
                float f98 = objectBaseData2.f197504i0;
                canvas.drawArc(rectF3, f97 + f98, n(f97 + f98, objectBaseData2.f197536q0 + f98), false, objectBaseData2.K2);
                float f99 = objectBaseData2.f197524n0;
                float f100 = objectBaseData2.f197504i0;
                canvas.drawArc(rectF3, f99 + f100, n(f99 + f100, objectBaseData2.f197528o0 + f100), false, objectBaseData2.K2);
                if (objectBaseData2.C0 > 0.0f && ((objectBaseData2.f197479c || objectBaseData2.f197491f) && objectBaseData2.P && !objectBaseData2.f197499h)) {
                    objectBaseData2.L2.setColor(objectBaseData2.B0);
                    objectBaseData2.L2.setStrokeWidth(objectBaseData2.f197552u0);
                    objectBaseData2.L2.setAlpha((int) (objectBaseData2.C0 * 255.0f));
                    float f101 = objectBaseData2.f197556v0;
                    float f102 = objectBaseData2.f197504i0;
                    canvas.drawArc(rectF3, f101 + f102, n(f101 + f102, objectBaseData2.f197560w0 + f102), false, objectBaseData2.L2);
                    float f103 = objectBaseData2.f197572z0;
                    float f104 = objectBaseData2.f197504i0;
                    canvas.drawArc(rectF3, f103 + f104, n(f103 + f104, objectBaseData2.A0 + f104), false, objectBaseData2.L2);
                    float f105 = objectBaseData2.f197564x0;
                    float f106 = objectBaseData2.f197504i0;
                    canvas.drawArc(rectF3, f105 + f106, n(f105 + f106, objectBaseData2.f197568y0 + f106), false, objectBaseData2.L2);
                }
                if (objectBaseData2.H0 > 0.0f && ((objectBaseData2.f197479c || objectBaseData2.f197491f) && objectBaseData2.P && !objectBaseData2.f197499h)) {
                    objectBaseData2.M2.setColor(objectBaseData2.G0);
                    objectBaseData2.M2.setStrokeWidth(objectBaseData2.F0);
                    objectBaseData2.M2.setAlpha((int) (objectBaseData2.H0 * 255.0f * 0.1d));
                    canvas2.drawCircle(objectBaseData2.f197469a, objectBaseData2.f197474b, (objectBaseData2.D0 * objectBaseData2.E0) + (objectBaseData2.F0 / 2.0f), objectBaseData2.M2);
                }
                if (objectBaseData2.V0 > 0.0f && ((objectBaseData2.f197479c || objectBaseData2.f197491f) && objectBaseData2.P && !objectBaseData2.f197499h)) {
                    objectBaseData2.N2.setColor(objectBaseData2.U0);
                    objectBaseData2.N2.setStrokeWidth(objectBaseData2.L0);
                    objectBaseData2.N2.setAlpha((int) (objectBaseData2.V0 * 255.0f * 0.3d));
                    float f107 = (objectBaseData2.K0 * objectBaseData2.I0) + objectBaseData2.L0;
                    float f108 = objectBaseData2.f197469a;
                    float f109 = objectBaseData2.f197474b;
                    RectF rectF4 = new RectF(f108 - f107, f109 - f107, f108 + f107, f109 + f107);
                    float f110 = objectBaseData2.O0;
                    float f111 = objectBaseData2.J0;
                    canvas.drawArc(rectF4, f110 + f111, n(f110 + f111, objectBaseData2.P0 + f111), false, objectBaseData2.N2);
                    float f112 = objectBaseData2.M0;
                    float f113 = objectBaseData2.J0;
                    canvas.drawArc(rectF4, f112 + f113, n(f112 + f113, objectBaseData2.N0 + f113), false, objectBaseData2.N2);
                    float f114 = objectBaseData2.S0;
                    float f115 = objectBaseData2.J0;
                    canvas.drawArc(rectF4, f114 + f115, n(f114 + f115, objectBaseData2.T0 + f115), false, objectBaseData2.N2);
                    float f116 = objectBaseData2.Q0;
                    float f117 = objectBaseData2.J0;
                    canvas.drawArc(rectF4, f116 + f117, n(f116 + f117, objectBaseData2.R0 + f117), false, objectBaseData2.N2);
                }
                if (objectBaseData2.Z0 > 0.0f && ((objectBaseData2.f197479c || objectBaseData2.f197491f) && objectBaseData2.P && !objectBaseData2.f197499h)) {
                    objectBaseData2.O2.setColor(objectBaseData2.Y0);
                    objectBaseData2.O2.setAlpha((int) (objectBaseData2.Z0 * 255.0f));
                    canvas2.drawCircle(objectBaseData2.f197469a, objectBaseData2.f197474b, (objectBaseData2.X0 * objectBaseData2.W0) + 0.0f, objectBaseData2.O2);
                }
                char c27 = objectBaseData2.f197474b < (objectBaseData2.f197515l + ((float) r(objectBaseData2))) + 80.0f ? (char) 2 : c18;
                boolean z17 = objectBaseData2.P;
                if (z17) {
                    float f118 = objectBaseData2.f197569y1;
                    if (f118 > 0.0f && !objectBaseData2.f197499h && c27 == c18) {
                        objectBaseData2.R2.setAlpha((int) (f118 * 255.0f));
                        objectBaseData2.R2.setStrokeWidth(objectBaseData2.f197513k1);
                        objectBaseData2.P2.setStrokeWidth(objectBaseData2.f197509j1);
                        objectBaseData2.P2.setAlpha((int) (objectBaseData2.f197569y1 * 255.0f));
                        boolean z18 = objectBaseData2.f197479c;
                        if (z18) {
                            float f119 = objectBaseData2.W;
                            if (f119 != 0.0f) {
                                objectBaseData2.f197489e1 = (((objectBaseData2.V * f119) + objectBaseData2.Y) * 2.0f) / 3.6f;
                                f28 = objectBaseData2.f197489e1;
                                f29 = objectBaseData2.f197493f1;
                                if (f28 > f29) {
                                    objectBaseData2.f197489e1 = f29;
                                }
                                f36 = objectBaseData2.f197489e1;
                                f37 = objectBaseData2.f197497g1;
                                if (f36 < f37) {
                                    objectBaseData2.f197489e1 = f37;
                                }
                                float f120 = objectBaseData2.f197469a;
                                float f121 = objectBaseData2.f197515l;
                                float f122 = objectBaseData2.f197519m;
                                float f123 = objectBaseData2.f197527o;
                                float f124 = objectBaseData2.f197557v1;
                                float f125 = ((f120 - (f121 * f122)) - f123) - f124;
                                objectBaseData2.f197501h1 = f125;
                                float f126 = objectBaseData2.f197474b;
                                float f127 = ((f126 - (f121 * f122)) - f123) - (objectBaseData2.f197561w1 * objectBaseData2.L1);
                                objectBaseData2.f197505i1 = f127;
                                if (z18 && objectBaseData2.P) {
                                    f38 = objectBaseData2.W;
                                    if (f38 != 0.0f) {
                                        float f128 = (((f120 - (f121 * f122)) - f123) - f124) - ObjectBaseData.a.f197579e;
                                        objectBaseData2.f197501h1 = f128;
                                        objectBaseData2.I = f127 - objectBaseData2.f197489e1;
                                        float f129 = objectBaseData2.V;
                                        float f130 = objectBaseData2.Y;
                                        objectBaseData2.K = f126 + (f129 * f38) + f130;
                                        objectBaseData2.L = (f129 * f38) + f120 + f130;
                                        objectBaseData2.J = f128;
                                        float f131 = ((((f120 + objectBaseData2.f197496g0) + objectBaseData2.F0) + objectBaseData2.F2) - objectBaseData2.f197554u2) - (objectBaseData2.f197558v2 * 4.0f);
                                        if (!TextUtils.isEmpty(objectBaseData2.f197481c1) && !TextUtils.isEmpty(objectBaseData2.f197485d1)) {
                                            objectBaseData2.f197485d1 = objectBaseData2.f197485d1.toUpperCase();
                                            objectBaseData2.R2.setTextSize(objectBaseData2.f197541r1 * objectBaseData2.L1);
                                            objectBaseData2.R2.setTextAlign(Paint.Align.LEFT);
                                            if (objectBaseData2.f197569y1 == 0.0f) {
                                                objectBaseData2.R2.setShadowLayer(objectBaseData2.A1, 0.0f, objectBaseData2.B1, objectBaseData2.C1);
                                            } else {
                                                objectBaseData2.R2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                            }
                                            Paint.FontMetrics fontMetrics = objectBaseData2.R2.getFontMetrics();
                                            float f132 = objectBaseData2.f197505i1;
                                            float f133 = fontMetrics.top + f132;
                                            float f134 = f132 + fontMetrics.bottom;
                                            if (objectBaseData2.f197525n1 == 0.0f) {
                                                float f135 = f131 - objectBaseData2.J;
                                                float f136 = objectBaseData2.f197521m1;
                                                objectBaseData2.Q2.setTextSize(objectBaseData2.L1 * f136);
                                                while (objectBaseData2.Q2.measureText(objectBaseData2.f197481c1) > f135) {
                                                    f136 -= 1.0f;
                                                    objectBaseData2.Q2.setTextSize(objectBaseData2.L1 * f136);
                                                }
                                                objectBaseData2.f197525n1 = f136 / objectBaseData2.f197487e;
                                            }
                                            float f137 = objectBaseData2.f197533p1;
                                            objectBaseData2.f197521m1 = f137;
                                            objectBaseData2.f197541r1 = objectBaseData2.f197549t1;
                                            objectBaseData2.P2.setTextSize(f137 * objectBaseData2.L1);
                                            objectBaseData2.P2.setTextAlign(Paint.Align.LEFT);
                                            if (!objectBaseData2.f197479c) {
                                                objectBaseData2.P2.setFakeBoldText(true);
                                            } else {
                                                objectBaseData2.P2.setFakeBoldText(false);
                                            }
                                            if (objectBaseData2.f197569y1 == 0.0f) {
                                                objectBaseData2.P2.setShadowLayer(objectBaseData2.A1, 0.0f, objectBaseData2.B1, objectBaseData2.C1);
                                            } else {
                                                objectBaseData2.P2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                            }
                                            canvas2.drawText(objectBaseData2.f197485d1, objectBaseData2.f197501h1, objectBaseData2.f197505i1, objectBaseData2.R2);
                                            length2 = objectBaseData2.f197481c1.length();
                                            if (length2 >= 9) {
                                                canvas2.drawText(objectBaseData2.f197481c1, objectBaseData2.f197501h1, (objectBaseData2.f197505i1 - objectBaseData2.f197565x1) - (f134 - f133), objectBaseData2.P2);
                                            } else {
                                                String substring = objectBaseData2.f197481c1.substring(0, 7);
                                                String substring2 = objectBaseData2.f197481c1.substring(7, length2);
                                                if (substring2.length() > 7) {
                                                    substring2 = substring2.substring(0, 6) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                                                }
                                                objectBaseData2.P2.getTextBounds(substring2, 0, substring2.length(), new Rect());
                                                int i18 = (int) (objectBaseData2.f197565x1 + (r3.bottom - r3.top));
                                                canvas2.drawText(substring2, objectBaseData2.f197501h1, objectBaseData2.f197505i1 - (f134 - f133), objectBaseData2.P2);
                                                canvas2.drawText(substring, objectBaseData2.f197501h1, objectBaseData2.f197505i1 - ((int) (i18 + (r4 + 20.0f))), objectBaseData2.P2);
                                            }
                                            objectBaseData2.S2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                            float f138 = objectBaseData2.f197505i1;
                                            float f139 = objectBaseData2.f197561w1;
                                            float f140 = objectBaseData2.L1;
                                            float f141 = f138 + (f139 * f140);
                                            float f142 = objectBaseData2.f197501h1 + objectBaseData2.K1;
                                            float f143 = f141 + (objectBaseData2.H1 * f140);
                                            float cos7 = f142 + ((float) (objectBaseData2.I1 * f140 * Math.cos((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                            float sin7 = f143 + ((float) (objectBaseData2.I1 * objectBaseData2.L1 * Math.sin((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                            if (objectBaseData2.G1 >= 0.2d) {
                                                canvas.drawLine(cos7, sin7, f142, f143, objectBaseData2.S2);
                                            }
                                            if (objectBaseData2.G1 >= 0.5d) {
                                                canvas.drawLine(f142, f143, f142, f141, objectBaseData2.S2);
                                            }
                                            objectBaseData2.T2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                            canvas2.drawCircle(cos7, sin7, objectBaseData2.M1, objectBaseData2.T2);
                                        }
                                        if (objectBaseData2.P1 > 0.0f && ((objectBaseData2.f197479c || objectBaseData2.f197491f) && !objectBaseData2.f197499h)) {
                                            if (!objectBaseData2.P) {
                                                z16 = (TextUtils.isEmpty(objectBaseData2.f197477b2) || TextUtils.isEmpty(objectBaseData2.f197482c2)) ? false : true;
                                            } else {
                                                z16 = !TextUtils.isEmpty(objectBaseData2.f197477b2);
                                            }
                                            if (z16) {
                                                int l3 = this.D.f198550a.l();
                                                if (!objectBaseData2.P) {
                                                    c17 = 1;
                                                    if (l3 != 2) {
                                                        c16 = 0;
                                                        this.D.f198550a.s(2, objectBaseData2.f197477b2, false);
                                                        c26 = c16;
                                                        i17 = i3 + 1;
                                                        c19 = c16;
                                                        c18 = c17;
                                                        q16 = objectBaseData;
                                                    }
                                                } else if (l3 != 3) {
                                                    c17 = 1;
                                                    this.D.f198550a.p(objectBaseData2.f197477b2, objectBaseData2.f197482c2, new a(objectBaseData2), !TextUtils.isEmpty(objectBaseData2.O));
                                                } else {
                                                    c17 = 1;
                                                }
                                                c16 = 0;
                                                c26 = c16;
                                                i17 = i3 + 1;
                                                c19 = c16;
                                                c18 = c17;
                                                q16 = objectBaseData;
                                            }
                                        }
                                        c16 = 0;
                                        c17 = 1;
                                        i17 = i3 + 1;
                                        c19 = c16;
                                        c18 = c17;
                                        q16 = objectBaseData;
                                    }
                                }
                                objectBaseData2.I = f127 - objectBaseData2.f197489e1;
                                objectBaseData2.K = f126 + (f121 * f122) + f123;
                                objectBaseData2.L = (f121 * f122) + f120 + f123;
                                objectBaseData2.J = f125;
                                float f1312 = ((((f120 + objectBaseData2.f197496g0) + objectBaseData2.F0) + objectBaseData2.F2) - objectBaseData2.f197554u2) - (objectBaseData2.f197558v2 * 4.0f);
                                if (!TextUtils.isEmpty(objectBaseData2.f197481c1)) {
                                    objectBaseData2.f197485d1 = objectBaseData2.f197485d1.toUpperCase();
                                    objectBaseData2.R2.setTextSize(objectBaseData2.f197541r1 * objectBaseData2.L1);
                                    objectBaseData2.R2.setTextAlign(Paint.Align.LEFT);
                                    if (objectBaseData2.f197569y1 == 0.0f) {
                                    }
                                    Paint.FontMetrics fontMetrics2 = objectBaseData2.R2.getFontMetrics();
                                    float f1322 = objectBaseData2.f197505i1;
                                    float f1332 = fontMetrics2.top + f1322;
                                    float f1342 = f1322 + fontMetrics2.bottom;
                                    if (objectBaseData2.f197525n1 == 0.0f) {
                                    }
                                    float f1372 = objectBaseData2.f197533p1;
                                    objectBaseData2.f197521m1 = f1372;
                                    objectBaseData2.f197541r1 = objectBaseData2.f197549t1;
                                    objectBaseData2.P2.setTextSize(f1372 * objectBaseData2.L1);
                                    objectBaseData2.P2.setTextAlign(Paint.Align.LEFT);
                                    if (!objectBaseData2.f197479c) {
                                    }
                                    if (objectBaseData2.f197569y1 == 0.0f) {
                                    }
                                    canvas2.drawText(objectBaseData2.f197485d1, objectBaseData2.f197501h1, objectBaseData2.f197505i1, objectBaseData2.R2);
                                    length2 = objectBaseData2.f197481c1.length();
                                    if (length2 >= 9) {
                                    }
                                    objectBaseData2.S2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                    float f1382 = objectBaseData2.f197505i1;
                                    float f1392 = objectBaseData2.f197561w1;
                                    float f1402 = objectBaseData2.L1;
                                    float f1412 = f1382 + (f1392 * f1402);
                                    float f1422 = objectBaseData2.f197501h1 + objectBaseData2.K1;
                                    float f1432 = f1412 + (objectBaseData2.H1 * f1402);
                                    float cos72 = f1422 + ((float) (objectBaseData2.I1 * f1402 * Math.cos((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                    float sin72 = f1432 + ((float) (objectBaseData2.I1 * objectBaseData2.L1 * Math.sin((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                    if (objectBaseData2.G1 >= 0.2d) {
                                    }
                                    if (objectBaseData2.G1 >= 0.5d) {
                                    }
                                    objectBaseData2.T2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                    canvas2.drawCircle(cos72, sin72, objectBaseData2.M1, objectBaseData2.T2);
                                }
                                if (objectBaseData2.P1 > 0.0f) {
                                    if (!objectBaseData2.P) {
                                    }
                                    if (z16) {
                                    }
                                }
                                c16 = 0;
                                c17 = 1;
                                i17 = i3 + 1;
                                c19 = c16;
                                c18 = c17;
                                q16 = objectBaseData;
                            }
                        }
                        objectBaseData2.f197489e1 = (((objectBaseData2.f197515l * objectBaseData2.f197519m) + objectBaseData2.f197527o) * 2.0f) / 3.6f;
                        f28 = objectBaseData2.f197489e1;
                        f29 = objectBaseData2.f197493f1;
                        if (f28 > f29) {
                        }
                        f36 = objectBaseData2.f197489e1;
                        f37 = objectBaseData2.f197497g1;
                        if (f36 < f37) {
                        }
                        float f1202 = objectBaseData2.f197469a;
                        float f1212 = objectBaseData2.f197515l;
                        float f1222 = objectBaseData2.f197519m;
                        float f1232 = objectBaseData2.f197527o;
                        float f1242 = objectBaseData2.f197557v1;
                        float f1252 = ((f1202 - (f1212 * f1222)) - f1232) - f1242;
                        objectBaseData2.f197501h1 = f1252;
                        float f1262 = objectBaseData2.f197474b;
                        float f1272 = ((f1262 - (f1212 * f1222)) - f1232) - (objectBaseData2.f197561w1 * objectBaseData2.L1);
                        objectBaseData2.f197505i1 = f1272;
                        if (z18) {
                            f38 = objectBaseData2.W;
                            if (f38 != 0.0f) {
                            }
                        }
                        objectBaseData2.I = f1272 - objectBaseData2.f197489e1;
                        objectBaseData2.K = f1262 + (f1212 * f1222) + f1232;
                        objectBaseData2.L = (f1212 * f1222) + f1202 + f1232;
                        objectBaseData2.J = f1252;
                        float f13122 = ((((f1202 + objectBaseData2.f197496g0) + objectBaseData2.F0) + objectBaseData2.F2) - objectBaseData2.f197554u2) - (objectBaseData2.f197558v2 * 4.0f);
                        if (!TextUtils.isEmpty(objectBaseData2.f197481c1)) {
                        }
                        if (objectBaseData2.P1 > 0.0f) {
                        }
                        c16 = 0;
                        c17 = 1;
                        i17 = i3 + 1;
                        c19 = c16;
                        c18 = c17;
                        q16 = objectBaseData;
                    }
                }
                if (z17) {
                    float f144 = objectBaseData2.f197569y1;
                    if (f144 > 0.0f && !objectBaseData2.f197499h && c27 == 2) {
                        objectBaseData2.R2.setAlpha((int) (f144 * 255.0f));
                        objectBaseData2.R2.setStrokeWidth(objectBaseData2.f197513k1);
                        objectBaseData2.P2.setStrokeWidth(objectBaseData2.f197509j1);
                        objectBaseData2.P2.setAlpha((int) (objectBaseData2.f197569y1 * 255.0f));
                        boolean z19 = objectBaseData2.f197479c;
                        if (z19) {
                            float f145 = objectBaseData2.W;
                            if (f145 != 0.0f) {
                                objectBaseData2.f197489e1 = (((objectBaseData2.V * f145) + objectBaseData2.Y) * 2.0f) / 3.6f;
                                f16 = objectBaseData2.f197489e1;
                                f17 = objectBaseData2.f197493f1;
                                if (f16 > f17) {
                                    objectBaseData2.f197489e1 = f17;
                                }
                                f18 = objectBaseData2.f197489e1;
                                f19 = objectBaseData2.f197497g1;
                                if (f18 < f19) {
                                    objectBaseData2.f197489e1 = f19;
                                }
                                float f146 = objectBaseData2.f197469a;
                                float f147 = objectBaseData2.f197515l;
                                float f148 = objectBaseData2.f197519m;
                                float f149 = objectBaseData2.f197527o;
                                float f150 = objectBaseData2.f197557v1;
                                float f151 = ((f146 - (f147 * f148)) - f149) - f150;
                                objectBaseData2.f197501h1 = f151;
                                float f152 = objectBaseData2.f197474b;
                                float f153 = (f147 * f148) + f152 + f149 + (objectBaseData2.f197561w1 * objectBaseData2.L1);
                                objectBaseData2.f197505i1 = f153;
                                if (z19 && objectBaseData2.P) {
                                    f27 = objectBaseData2.W;
                                    if (f27 != 0.0f) {
                                        float f154 = (((f146 - (f147 * f148)) - f149) - f150) - ObjectBaseData.a.f197579e;
                                        objectBaseData2.f197501h1 = f154;
                                        float f155 = objectBaseData2.V;
                                        float f156 = objectBaseData2.Y;
                                        objectBaseData2.I = f152 + (f155 * f27) + f156;
                                        objectBaseData2.K = f153 + objectBaseData2.f197489e1;
                                        objectBaseData2.L = (f155 * f27) + f146 + f156;
                                        objectBaseData2.J = f154;
                                        float f157 = ((((f146 + objectBaseData2.f197496g0) + objectBaseData2.F0) + objectBaseData2.F2) - objectBaseData2.f197554u2) - (objectBaseData2.f197558v2 * 4.0f);
                                        if (!TextUtils.isEmpty(objectBaseData2.f197481c1) && !TextUtils.isEmpty(objectBaseData2.f197485d1)) {
                                            objectBaseData2.f197485d1 = objectBaseData2.f197485d1.toUpperCase();
                                            objectBaseData2.R2.setTextSize(objectBaseData2.f197541r1 * objectBaseData2.L1);
                                            objectBaseData2.R2.setTextAlign(Paint.Align.LEFT);
                                            if (objectBaseData2.f197569y1 == 0.0f) {
                                                objectBaseData2.R2.setShadowLayer(objectBaseData2.A1, 0.0f, objectBaseData2.B1, objectBaseData2.C1);
                                            } else {
                                                objectBaseData2.R2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                            }
                                            Paint.FontMetrics fontMetrics3 = objectBaseData2.R2.getFontMetrics();
                                            float f158 = objectBaseData2.f197505i1;
                                            float f159 = fontMetrics3.top + f158;
                                            float f160 = f158 + fontMetrics3.bottom;
                                            if (objectBaseData2.f197525n1 == 0.0f) {
                                                float f161 = f157 - objectBaseData2.J;
                                                float f162 = objectBaseData2.f197521m1;
                                                objectBaseData2.Q2.setTextSize(objectBaseData2.L1 * f162);
                                                while (objectBaseData2.Q2.measureText(objectBaseData2.f197481c1) > f161) {
                                                    f162 -= 1.0f;
                                                    objectBaseData2.Q2.setTextSize(objectBaseData2.L1 * f162);
                                                }
                                                objectBaseData2.f197525n1 = f162 / objectBaseData2.f197487e;
                                            }
                                            float f163 = objectBaseData2.f197533p1;
                                            objectBaseData2.f197521m1 = f163;
                                            objectBaseData2.f197541r1 = objectBaseData2.f197549t1;
                                            objectBaseData2.P2.setTextSize(f163 * objectBaseData2.L1);
                                            objectBaseData2.P2.setTextAlign(Paint.Align.LEFT);
                                            if (!objectBaseData2.f197479c) {
                                                objectBaseData2.P2.setFakeBoldText(true);
                                            } else {
                                                objectBaseData2.P2.setFakeBoldText(false);
                                            }
                                            if (objectBaseData2.f197569y1 == 0.0f) {
                                                objectBaseData2.P2.setShadowLayer(objectBaseData2.A1, 0.0f, objectBaseData2.B1, objectBaseData2.C1);
                                                i16 = 0;
                                            } else {
                                                i16 = 0;
                                                objectBaseData2.P2.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
                                            }
                                            length = objectBaseData2.f197481c1.length();
                                            float f164 = f160 - f159;
                                            int i19 = (int) f164;
                                            if (length < 9) {
                                                String substring3 = objectBaseData2.f197481c1.substring(i16, 7);
                                                String substring4 = objectBaseData2.f197481c1.substring(7, length);
                                                if (substring4.length() > 7) {
                                                    substring4 = substring4.substring(i16, 6) + MiniBoxNoticeInfo.APPNAME_SUFFIX;
                                                }
                                                Rect rect = new Rect();
                                                objectBaseData2.P2.getTextBounds(substring3, i16, substring3.length(), rect);
                                                long j3 = rect.bottom - rect.top;
                                                float f165 = (float) j3;
                                                canvas2.drawText(substring3, objectBaseData2.f197501h1, objectBaseData2.f197505i1 + f165, objectBaseData2.P2);
                                                objectBaseData2.P2.getTextBounds(substring4, 0, substring4.length(), rect);
                                                long j16 = rect.bottom - rect.top;
                                                canvas2.drawText(substring4, objectBaseData2.f197501h1, objectBaseData2.f197505i1 + ((float) j16) + f165 + 20.0f, objectBaseData2.P2);
                                                f26 = (float) (j3 + j16 + 20);
                                            } else {
                                                canvas2.drawText(objectBaseData2.f197481c1, objectBaseData2.f197501h1, objectBaseData2.f197505i1 + i19, objectBaseData2.P2);
                                                f26 = objectBaseData2.f197565x1 + f164;
                                            }
                                            Rect rect2 = new Rect();
                                            Paint paint = objectBaseData2.R2;
                                            String str3 = objectBaseData2.f197485d1;
                                            paint.getTextBounds(str3, 0, str3.length(), rect2);
                                            canvas2.drawText(objectBaseData2.f197485d1, objectBaseData2.f197501h1, objectBaseData2.f197505i1 + f26 + (rect2.bottom - rect2.top) + 20.0f, objectBaseData2.R2);
                                            objectBaseData2.S2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                            float f166 = objectBaseData2.f197505i1;
                                            float f167 = objectBaseData2.f197561w1;
                                            float f168 = objectBaseData2.L1;
                                            float f169 = f166 - (f167 * f168);
                                            float f170 = objectBaseData2.f197501h1 + objectBaseData2.K1;
                                            float f171 = f169 - (objectBaseData2.H1 * f168);
                                            float cos8 = f170 + ((float) (objectBaseData2.I1 * f168 * Math.cos((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                            float sin8 = f171 - ((float) ((objectBaseData2.I1 * objectBaseData2.L1) * Math.sin((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                            if (objectBaseData2.G1 >= 0.2d) {
                                                canvas.drawLine(cos8, sin8, f170, f171, objectBaseData2.S2);
                                            }
                                            if (objectBaseData2.G1 >= 0.5d) {
                                                canvas.drawLine(f170, f171, f170, f169, objectBaseData2.S2);
                                            }
                                            objectBaseData2.T2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                            canvas2.drawCircle(cos8, sin8, objectBaseData2.M1, objectBaseData2.T2);
                                        }
                                    }
                                }
                                objectBaseData2.I = f153 - objectBaseData2.f197489e1;
                                objectBaseData2.K = f152 + (f147 * f148) + f149;
                                objectBaseData2.L = (f147 * f148) + f146 + f149;
                                objectBaseData2.J = f151;
                                float f1572 = ((((f146 + objectBaseData2.f197496g0) + objectBaseData2.F0) + objectBaseData2.F2) - objectBaseData2.f197554u2) - (objectBaseData2.f197558v2 * 4.0f);
                                if (!TextUtils.isEmpty(objectBaseData2.f197481c1)) {
                                    objectBaseData2.f197485d1 = objectBaseData2.f197485d1.toUpperCase();
                                    objectBaseData2.R2.setTextSize(objectBaseData2.f197541r1 * objectBaseData2.L1);
                                    objectBaseData2.R2.setTextAlign(Paint.Align.LEFT);
                                    if (objectBaseData2.f197569y1 == 0.0f) {
                                    }
                                    Paint.FontMetrics fontMetrics32 = objectBaseData2.R2.getFontMetrics();
                                    float f1582 = objectBaseData2.f197505i1;
                                    float f1592 = fontMetrics32.top + f1582;
                                    float f1602 = f1582 + fontMetrics32.bottom;
                                    if (objectBaseData2.f197525n1 == 0.0f) {
                                    }
                                    float f1632 = objectBaseData2.f197533p1;
                                    objectBaseData2.f197521m1 = f1632;
                                    objectBaseData2.f197541r1 = objectBaseData2.f197549t1;
                                    objectBaseData2.P2.setTextSize(f1632 * objectBaseData2.L1);
                                    objectBaseData2.P2.setTextAlign(Paint.Align.LEFT);
                                    if (!objectBaseData2.f197479c) {
                                    }
                                    if (objectBaseData2.f197569y1 == 0.0f) {
                                    }
                                    length = objectBaseData2.f197481c1.length();
                                    float f1642 = f1602 - f1592;
                                    int i192 = (int) f1642;
                                    if (length < 9) {
                                    }
                                    Rect rect22 = new Rect();
                                    Paint paint2 = objectBaseData2.R2;
                                    String str32 = objectBaseData2.f197485d1;
                                    paint2.getTextBounds(str32, 0, str32.length(), rect22);
                                    canvas2.drawText(objectBaseData2.f197485d1, objectBaseData2.f197501h1, objectBaseData2.f197505i1 + f26 + (rect22.bottom - rect22.top) + 20.0f, objectBaseData2.R2);
                                    objectBaseData2.S2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                    float f1662 = objectBaseData2.f197505i1;
                                    float f1672 = objectBaseData2.f197561w1;
                                    float f1682 = objectBaseData2.L1;
                                    float f1692 = f1662 - (f1672 * f1682);
                                    float f1702 = objectBaseData2.f197501h1 + objectBaseData2.K1;
                                    float f1712 = f1692 - (objectBaseData2.H1 * f1682);
                                    float cos82 = f1702 + ((float) (objectBaseData2.I1 * f1682 * Math.cos((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                    float sin82 = f1712 - ((float) ((objectBaseData2.I1 * objectBaseData2.L1) * Math.sin((objectBaseData2.E1 * 3.141592653589793d) / 180.0d)));
                                    if (objectBaseData2.G1 >= 0.2d) {
                                    }
                                    if (objectBaseData2.G1 >= 0.5d) {
                                    }
                                    objectBaseData2.T2.setAlpha((int) (objectBaseData2.G1 * 255.0f));
                                    canvas2.drawCircle(cos82, sin82, objectBaseData2.M1, objectBaseData2.T2);
                                }
                            }
                        }
                        objectBaseData2.f197489e1 = (((objectBaseData2.f197515l * objectBaseData2.f197519m) + objectBaseData2.f197527o) * 2.0f) / 3.6f;
                        f16 = objectBaseData2.f197489e1;
                        f17 = objectBaseData2.f197493f1;
                        if (f16 > f17) {
                        }
                        f18 = objectBaseData2.f197489e1;
                        f19 = objectBaseData2.f197497g1;
                        if (f18 < f19) {
                        }
                        float f1462 = objectBaseData2.f197469a;
                        float f1472 = objectBaseData2.f197515l;
                        float f1482 = objectBaseData2.f197519m;
                        float f1492 = objectBaseData2.f197527o;
                        float f1502 = objectBaseData2.f197557v1;
                        float f1512 = ((f1462 - (f1472 * f1482)) - f1492) - f1502;
                        objectBaseData2.f197501h1 = f1512;
                        float f1522 = objectBaseData2.f197474b;
                        float f1532 = (f1472 * f1482) + f1522 + f1492 + (objectBaseData2.f197561w1 * objectBaseData2.L1);
                        objectBaseData2.f197505i1 = f1532;
                        if (z19) {
                            f27 = objectBaseData2.W;
                            if (f27 != 0.0f) {
                            }
                        }
                        objectBaseData2.I = f1532 - objectBaseData2.f197489e1;
                        objectBaseData2.K = f1522 + (f1472 * f1482) + f1492;
                        objectBaseData2.L = (f1472 * f1482) + f1462 + f1492;
                        objectBaseData2.J = f1512;
                        float f15722 = ((((f1462 + objectBaseData2.f197496g0) + objectBaseData2.F0) + objectBaseData2.F2) - objectBaseData2.f197554u2) - (objectBaseData2.f197558v2 * 4.0f);
                        if (!TextUtils.isEmpty(objectBaseData2.f197481c1)) {
                        }
                    }
                }
                if (objectBaseData2.P1 > 0.0f) {
                }
                c16 = 0;
                c17 = 1;
                i17 = i3 + 1;
                c19 = c16;
                c18 = c17;
                q16 = objectBaseData;
            }
            if (c26 != 0) {
                this.D.f198550a.l();
                this.D.f198550a.k();
            }
        }
    }

    private ObjectBaseData q() {
        ObjectBaseData objectBaseData;
        int i3 = 0;
        while (true) {
            if (i3 < this.f197605i.size()) {
                objectBaseData = this.f197605i.get(i3);
                if (objectBaseData != null && objectBaseData.f197479c && objectBaseData.P && !objectBaseData.f197499h) {
                    break;
                }
                i3++;
            } else {
                objectBaseData = null;
                break;
            }
        }
        if (objectBaseData == null && this.f197606m.size() > 0) {
            Iterator<Map.Entry<String, ObjectBaseData>> it = this.f197606m.entrySet().iterator();
            while (it.hasNext()) {
                ObjectBaseData value = it.next().getValue();
                if (value != null && value.f197479c && value.P && !value.f197499h) {
                    return value;
                }
            }
            return objectBaseData;
        }
        return objectBaseData;
    }

    private long r(ObjectBaseData objectBaseData) {
        long j3;
        if (!objectBaseData.P || objectBaseData.f197569y1 <= 0.0f || objectBaseData.f197499h || TextUtils.isEmpty(objectBaseData.f197481c1) || TextUtils.isEmpty(objectBaseData.f197485d1)) {
            return 0L;
        }
        long o16 = o(getContext(), 10.0f) + 0 + 32;
        if (objectBaseData.f197481c1.length() < 8) {
            j3 = 60;
        } else if (objectBaseData.f197481c1.length() == 8) {
            j3 = 52;
        } else if (objectBaseData.f197481c1.length() > 8) {
            j3 = 160;
        } else {
            return o16;
        }
        return o16 + j3;
    }

    private void s() {
        setZOrderOnTop(true);
        SurfaceHolder holder = getHolder();
        this.f197601d = holder;
        holder.setFormat(-2);
        this.f197601d.addCallback(this);
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("ObjectSurfaceViewAnimationThread");
        this.G = baseHandlerThread;
        baseHandlerThread.start();
        this.H = new Handler(this.G.getLooper());
        BaseHandlerThread baseHandlerThread2 = new BaseHandlerThread("ObjectSurfaceViewDrawThread");
        this.I = baseHandlerThread2;
        baseHandlerThread2.start();
        this.J = new Handler(this.I.getLooper());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t(String str) {
        if (!TextUtils.isEmpty(str) && getContext() != null) {
            try {
                Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str);
                getContext().startActivity(intent);
            } catch (Exception e16) {
                QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(String str) {
        if (!TextUtils.isEmpty(str) && getContext() != null) {
            try {
                Intent intent = new Intent(getContext(), (Class<?>) QQBrowserActivity.class);
                intent.putExtra("url", str);
                intent.putExtra(QQBrowserActivity.EXTRA_FINISH_ANIMATION_UP_DOWN, true);
                getContext().startActivity(intent);
                if (getContext() instanceof Activity) {
                    ((Activity) getContext()).overridePendingTransition(R.anim.f154454a3, 0);
                }
                ReportController.o(null, "dc00898", "", "", "0X800899A", "0X800899A", 0, 0, "", "", "", "");
            } catch (Exception e16) {
                QLog.e("ObjectSurfaceView", 1, "start QQBrowserActivity catch an Exception.", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v() {
        Canvas lockCanvas;
        try {
            try {
                try {
                    lockCanvas = this.f197601d.lockCanvas();
                    if (lockCanvas != null) {
                        lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
                        if (this.f197603f) {
                            QLog.d("ObjectSurfaceView", 1, "clearCanvas");
                        } else {
                            p(lockCanvas);
                            QLog.d("ObjectSurfaceView", 1, "drawCanvas");
                        }
                    }
                } catch (Exception e16) {
                    QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", e16);
                    return;
                }
            } catch (Exception e17) {
                QLog.e("ObjectSurfaceView", 1, "doDraw catch an exception.", e17);
                if (0 != 0) {
                    this.f197601d.unlockCanvasAndPost(null);
                } else {
                    return;
                }
            }
            if (lockCanvas != null) {
                this.f197601d.unlockCanvasAndPost(lockCanvas);
            }
        } catch (Throwable th5) {
            if (0 != 0) {
                try {
                    this.f197601d.unlockCanvasAndPost(null);
                } catch (Exception e18) {
                    QLog.e("ObjectSurfaceView", 1, "doDraw finally catch an exception.", e18);
                }
            }
            throw th5;
        }
    }

    public void l() {
        boolean z16;
        ObjectBaseData objectBaseData;
        boolean z17;
        float f16;
        List<DrawView2.a> list = this.E;
        if (list != null && list.size() > 0) {
            if (q() == null) {
                if (this.E.get(0) != null) {
                    f16 = this.E.get(0).f197441o;
                } else {
                    f16 = 0.0f;
                }
                int i3 = 0;
                for (int i16 = 1; i16 < this.E.size(); i16++) {
                    DrawView2.a aVar = this.E.get(i16);
                    if (aVar != null && aVar.f197441o > f16) {
                        i3 = i16;
                    }
                    if (aVar != null && QLog.isColorLevel()) {
                        String qqStr = HardCodeUtil.qqStr(R.string.ouc);
                        if (!TextUtils.isEmpty(aVar.f197430d)) {
                            qqStr = aVar.f197430d;
                        }
                        QLog.d("ObjectSurfaceView", 2, "name = " + qqStr + ",confidence = " + aVar.f197441o + ",faceId = " + aVar.f197432f + ",isTmpFace = " + aVar.f197444r);
                    }
                }
                DrawView2.a aVar2 = this.E.get(i3);
                if (aVar2 != null) {
                    aVar2.f197434h = true;
                }
            }
            for (int i17 = 0; i17 < this.E.size(); i17++) {
                DrawView2.a aVar3 = this.E.get(i17);
                if (aVar3 != null) {
                    RectF a16 = aVar3.a();
                    int i18 = 0;
                    while (true) {
                        if (i18 < this.f197605i.size()) {
                            objectBaseData = this.f197605i.get(i18);
                            if (objectBaseData != null && objectBaseData.U.equals(aVar3.f197430d) && objectBaseData.f197499h == aVar3.f197444r) {
                                z17 = true;
                                break;
                            }
                            i18++;
                        } else {
                            objectBaseData = null;
                            z17 = false;
                            break;
                        }
                    }
                    if (!aVar3.f197444r && !z17 && this.f197606m.containsKey(Integer.valueOf(aVar3.f197432f)) && (objectBaseData = this.f197606m.get(Integer.valueOf(aVar3.f197432f))) != null) {
                        k(objectBaseData);
                        this.f197606m.remove(Integer.valueOf(aVar3.f197432f));
                        z17 = true;
                    }
                    if (!z17) {
                        objectBaseData = new v(getContext());
                        boolean z18 = aVar3.f197444r;
                        objectBaseData.f197499h = z18;
                        objectBaseData.U = aVar3.f197430d;
                        if (!z18) {
                            objectBaseData.f197479c = aVar3.f197434h;
                            if (QLog.isColorLevel()) {
                                QLog.d("ObjectSurfaceView", 2, "1=" + objectBaseData.f197479c);
                            }
                            objectBaseData.R = aVar3.f197431e;
                            objectBaseData.f197481c1 = aVar3.f197430d;
                            objectBaseData.N = aVar3.f197437k;
                            objectBaseData.P = aVar3.f197439m;
                            objectBaseData.Q = aVar3.f197440n;
                            objectBaseData.S = a16;
                            objectBaseData.M = aVar3.f197442p;
                            objectBaseData.O = aVar3.f197438l;
                            objectBaseData.f197477b2 = aVar3.f197435i;
                            objectBaseData.f197482c2 = aVar3.f197436j;
                            if (!objectBaseData.f197495g && QLog.isColorLevel()) {
                                objectBaseData.f197495g = true;
                                QLog.d("ObjectSurfaceView", 2, "isMainFace = " + objectBaseData.f197479c + ", fNCH = " + objectBaseData.f197481c1 + ", faceID = " + objectBaseData.U + ", isStar = " + objectBaseData.P + ", isActivate = " + objectBaseData.Q + ", fCTitleText = " + objectBaseData.f197477b2 + ", fCContentText = " + objectBaseData.f197482c2 + ", url = " + objectBaseData.N + ", imgUrl = " + objectBaseData.M + ", wikiUrl = " + objectBaseData.O);
                            }
                        }
                        k(objectBaseData);
                    }
                    if (objectBaseData == null) {
                        return;
                    }
                    objectBaseData.S = a16;
                    objectBaseData.f197485d1 = aVar3.f197433g;
                    if (objectBaseData.f197479c) {
                        for (int i19 = 0; i19 < this.f197605i.size(); i19++) {
                            ObjectBaseData objectBaseData2 = this.f197605i.get(i19);
                            if (objectBaseData2 != null && !objectBaseData2.U.equals(objectBaseData.U) && !objectBaseData2.P && objectBaseData2.f197479c) {
                                objectBaseData2.f197479c = false;
                            }
                        }
                    }
                    if (a16 != null) {
                        float centerX = a16.centerX();
                        float centerY = a16.centerY();
                        float abs = Math.abs(centerX - objectBaseData.f197469a);
                        int i26 = ObjectBaseData.a.f197584j;
                        if (abs > i26 || Math.abs(centerY - objectBaseData.f197474b) > i26) {
                            objectBaseData.f197469a = centerX;
                            objectBaseData.f197474b = centerY;
                        }
                        QLog.d("ObjectSurfaceView", 1, "centerX = " + centerX + ", centerY = " + centerY);
                        float min = Math.min(objectBaseData.f197492f0, ((float) Math.sqrt((double) ((a16.width() * a16.width()) + (a16.height() * a16.height())))) / 2.0f);
                        this.f197602e = 1.0f;
                        QLog.d("ObjectSurfaceView", 1, "scale = " + this.f197602e + ",scanningData.scale = " + objectBaseData.f197487e + ", trueRadius = " + min + ", iBCRadiusFix = " + objectBaseData.f197508j0);
                    }
                    if (this.F) {
                        if (Math.abs(objectBaseData.f197487e - this.f197602e) >= 0.03d) {
                            objectBaseData.d();
                            objectBaseData.e(this.f197602e);
                        }
                    } else {
                        objectBaseData.d();
                        objectBaseData.e(this.f197602e);
                    }
                }
            }
            for (int i27 = 0; i27 < this.f197605i.size(); i27++) {
                ObjectBaseData objectBaseData3 = this.f197605i.get(i27);
                int i28 = 0;
                while (true) {
                    if (i28 < this.E.size()) {
                        DrawView2.a aVar4 = this.E.get(i28);
                        if (aVar4 != null && objectBaseData3 != null && objectBaseData3.U.equals(aVar4.f197430d) && objectBaseData3.f197499h == aVar4.f197444r) {
                            z16 = true;
                            break;
                        }
                        i28++;
                    } else {
                        z16 = false;
                        break;
                    }
                }
                if (!z16) {
                    i(objectBaseData3);
                    this.f197605i.remove(i27);
                    QLog.d("ckwkenvencai", 1, "remove2");
                }
            }
            this.f197603f = false;
            if (!this.F && this.f197605i.size() > 0) {
                this.F = true;
                this.J.post(this.K);
            }
            if (this.f197605i.size() == 0) {
                this.F = false;
                return;
            }
            return;
        }
        m();
        QLog.e("ObjectSurfaceView", 1, "lost the face data.");
        this.D.f198550a.l();
        this.D.f198550a.k();
    }

    public void m() {
        this.f197603f = true;
        this.F = false;
        j(this.f197605i);
        this.f197605i.clear();
        this.D.f198550a.l();
        this.D.f198550a.k();
        QLog.d("ObjectSurfaceView", 1, "clear the animation and face data.");
    }

    public void setFaceData(List<DrawView2.a> list) {
        try {
            this.E = list;
            l();
        } catch (Exception e16) {
            QLog.e("ObjectSurfaceView", 1, "setFaceData catch an exception.", e16);
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i16, int i17) {
        if (QLog.isColorLevel()) {
            QLog.d("ObjectSurfaceView", 2, "surfaceChanged");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (QLog.isColorLevel()) {
            QLog.d("ObjectSurfaceView", 2, "surfaceCreated");
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        m();
        if (QLog.isColorLevel()) {
            QLog.d("ObjectSurfaceView", 2, "surfaceDestroyed");
        }
    }

    public ObjectSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f197602e = 1.0f;
        this.f197604h = 50L;
        this.f197605i = new CopyOnWriteArrayList<>();
        this.f197606m = new ConcurrentHashMap<>();
        this.C = new CopyOnWriteArrayList<>();
        this.K = new Runnable() { // from class: com.tencent.mobileqq.ar.ObjectSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                while (ObjectSurfaceView.this.F) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ObjectSurfaceView.this.v();
                    try {
                        LockMethodProxy.sleep(Math.max(0L, ObjectSurfaceView.this.f197604h - (System.currentTimeMillis() - currentTimeMillis)));
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (ObjectSurfaceView.this.f197603f) {
                    ObjectSurfaceView.this.v();
                }
            }
        };
        this.L = new int[]{Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255)};
        this.M = new float[]{0.0f, 0.5f};
        this.Q = new Matrix();
        s();
    }

    public ObjectSurfaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f197602e = 1.0f;
        this.f197604h = 50L;
        this.f197605i = new CopyOnWriteArrayList<>();
        this.f197606m = new ConcurrentHashMap<>();
        this.C = new CopyOnWriteArrayList<>();
        this.K = new Runnable() { // from class: com.tencent.mobileqq.ar.ObjectSurfaceView.1
            @Override // java.lang.Runnable
            public void run() {
                while (ObjectSurfaceView.this.F) {
                    long currentTimeMillis = System.currentTimeMillis();
                    ObjectSurfaceView.this.v();
                    try {
                        LockMethodProxy.sleep(Math.max(0L, ObjectSurfaceView.this.f197604h - (System.currentTimeMillis() - currentTimeMillis)));
                    } catch (InterruptedException e16) {
                        e16.printStackTrace();
                    }
                }
                if (ObjectSurfaceView.this.f197603f) {
                    ObjectSurfaceView.this.v();
                }
            }
        };
        this.L = new int[]{Color.argb(255, 30, 255, 236), Color.argb(255, 0, 191, 255)};
        this.M = new float[]{0.0f, 0.5f};
        this.Q = new Matrix();
        s();
    }
}
