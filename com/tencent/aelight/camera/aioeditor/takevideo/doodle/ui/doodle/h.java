package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.view.MotionEvent;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class h implements e {
    private static final int C = Color.parseColor("#FF000000");
    int A;
    int B;

    /* renamed from: a, reason: collision with root package name */
    public byte[] f68353a;

    /* renamed from: b, reason: collision with root package name */
    public byte[][] f68354b;

    /* renamed from: d, reason: collision with root package name */
    public float f68356d;

    /* renamed from: e, reason: collision with root package name */
    public float f68357e;

    /* renamed from: f, reason: collision with root package name */
    public int f68358f;

    /* renamed from: g, reason: collision with root package name */
    public int f68359g;

    /* renamed from: h, reason: collision with root package name */
    public int f68360h;

    /* renamed from: i, reason: collision with root package name */
    public int f68361i;

    /* renamed from: j, reason: collision with root package name */
    public g f68362j;

    /* renamed from: k, reason: collision with root package name */
    public BitmapShader f68363k;

    /* renamed from: l, reason: collision with root package name */
    public Paint f68364l;

    /* renamed from: n, reason: collision with root package name */
    public c.a f68366n;

    /* renamed from: o, reason: collision with root package name */
    b f68367o;

    /* renamed from: q, reason: collision with root package name */
    float f68369q;

    /* renamed from: r, reason: collision with root package name */
    Bitmap f68370r;

    /* renamed from: s, reason: collision with root package name */
    Rect f68371s;

    /* renamed from: t, reason: collision with root package name */
    public float f68372t;

    /* renamed from: u, reason: collision with root package name */
    public float f68373u;

    /* renamed from: v, reason: collision with root package name */
    DoodleLayout f68374v;

    /* renamed from: w, reason: collision with root package name */
    public Bitmap f68375w;

    /* renamed from: x, reason: collision with root package name */
    Canvas f68376x;

    /* renamed from: c, reason: collision with root package name */
    public int f68355c = 10;

    /* renamed from: m, reason: collision with root package name */
    public boolean f68365m = false;

    /* renamed from: p, reason: collision with root package name */
    private int f68368p = 103;

    /* renamed from: y, reason: collision with root package name */
    private boolean f68377y = true;

    /* renamed from: z, reason: collision with root package name */
    private int f68378z = 0;

    public h(b bVar) {
        Paint paint = new Paint();
        this.f68364l = paint;
        paint.setAntiAlias(true);
        this.f68364l.setStyle(Paint.Style.STROKE);
        this.f68364l.setStrokeJoin(Paint.Join.ROUND);
        this.f68364l.setStrokeCap(Paint.Cap.ROUND);
        this.f68367o = bVar;
    }

    private void d(int i3, int i16) {
        int i17;
        byte[] bArr;
        byte b16;
        hd0.c.a("MosaicOperator", "decreaseMask:x=" + i3 + ",y=" + i16 + ",MosaicMaskWidth:" + this.f68360h + ",MosaicMaskHeight:" + this.f68361i);
        int[] iArr = {i3, i3 + (-1), i3, i3 + 1, i3};
        int[] iArr2 = {i16, i16, i16 + (-1), i16, i16 + 1};
        for (int i18 = 0; i18 < 5 && i18 < 5; i18++) {
            int i19 = iArr[i18];
            int i26 = iArr2[i18];
            if (i19 >= 0 && i26 >= 0 && i19 < (i17 = this.f68360h) && i26 < this.f68361i) {
                int i27 = (i17 * i26) + i19;
                byte[] bArr2 = this.f68353a;
                byte b17 = bArr2[i27];
                if (b17 > 0) {
                    bArr2[i27] = (byte) (b17 - 1);
                }
                if (this.f68365m && (b16 = (bArr = this.f68354b[i26])[i19]) > 0) {
                    bArr[i19] = (byte) (b16 - 1);
                }
            }
        }
    }

    private void f(int i3, int i16) {
        int i17;
        byte[] bArr;
        byte b16;
        hd0.c.a("MosaicOperator", "increaseMask:x=" + i3 + ",y=" + i16 + ",MosaicMaskWidth:" + this.f68360h + ",MosaicMaskHeight:" + this.f68361i);
        int[] iArr = {i3, i3 + (-1), i3, i3 + 1, i3};
        int[] iArr2 = {i16, i16, i16 + (-1), i16, i16 + 1};
        for (int i18 = 0; i18 < 5 && i18 < 5; i18++) {
            int i19 = iArr[i18];
            int i26 = iArr2[i18];
            if (i19 >= 0 && i26 >= 0 && i19 < (i17 = this.f68360h) && i26 < this.f68361i) {
                int i27 = (i17 * i26) + i19;
                byte[] bArr2 = this.f68353a;
                byte b17 = bArr2[i27];
                if (b17 != Byte.MAX_VALUE) {
                    bArr2[i27] = (byte) (b17 + 1);
                }
                if (this.f68365m && (b16 = (bArr = this.f68354b[i26])[i19]) < Byte.MAX_VALUE) {
                    bArr[i19] = (byte) (b16 + 1);
                }
            }
        }
    }

    private void k() {
        if (this.f68365m) {
            hd0.c.a("MosaicOperator", "------------------------------------------------------------------------");
            StringBuilder sb5 = new StringBuilder();
            for (int i3 = 0; i3 < this.f68354b.length; i3++) {
                for (int i16 = 0; i16 < this.f68354b[0].length; i16++) {
                    sb5.append(((int) this.f68354b[i3][i16]) + " ");
                }
                hd0.c.a("MosaicOperator", sb5.toString());
                sb5.delete(0, sb5.length());
            }
        }
    }

    public void a() {
        this.f68362j = new g(this.f68368p, this.f68378z);
        int i3 = this.f68368p;
        if (i3 == 104) {
            return;
        }
        if (i3 == 105) {
            c(true);
            return;
        }
        if (this.f68353a != null) {
            int i16 = 0;
            while (true) {
                byte[] bArr = this.f68353a;
                if (i16 >= bArr.length) {
                    break;
                }
                bArr[i16] = 0;
                i16++;
            }
        }
        if (this.f68365m) {
            for (int i17 = 0; i17 < this.f68354b.length; i17++) {
                int i18 = 0;
                while (true) {
                    byte[][] bArr2 = this.f68354b;
                    if (i18 < bArr2[0].length) {
                        bArr2[i17][i18] = 0;
                        i18++;
                    }
                }
            }
        }
        l();
    }

    public void c(boolean z16) {
        if (this.f68368p != 105 || this.f68376x == null) {
            return;
        }
        hd0.c.b("MosaicOperator", "clearMp4MosaicCanvasAndDraw notify=%s", Boolean.valueOf(z16));
        Paint paint = new Paint();
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.f68376x.drawPaint(paint);
        this.f68377y = true;
        if (z16) {
            l();
        }
    }

    public void e(Canvas canvas, g gVar, float f16) {
        int i3 = gVar.f68320a;
        if (i3 == 103) {
            return;
        }
        if (i3 == 104) {
            if (this.f68363k == null) {
                i();
            }
            this.f68364l.setXfermode(null);
            this.f68364l.setStrokeWidth(gVar.f68349d);
            BitmapShader bitmapShader = this.f68363k;
            if (bitmapShader != null) {
                this.f68364l.setShader(bitmapShader);
            }
            canvas.drawPath(gVar.f68347b, this.f68364l);
            return;
        }
        if (i3 == 105) {
            Canvas canvas2 = this.f68376x;
            if (canvas2 == null) {
                hd0.c.t("MosaicOperator", "do not init yet");
                return;
            }
            canvas2.save();
            this.f68376x.scale(f16, f16);
            if (this.f68378z == 0) {
                this.f68378z = BaseAIOUtils.f(16.0f, BaseApplication.getContext().getResources());
            }
            this.f68364l.setXfermode(null);
            this.f68364l.setStrokeWidth(this.f68378z);
            this.f68364l.setShader(null);
            this.f68364l.setColor(C);
            this.f68376x.drawPath(gVar.f68347b, this.f68364l);
            this.f68376x.restore();
            this.f68377y = true;
        }
    }

    public void g(c.a aVar, float f16, Bitmap bitmap, Rect rect) {
        this.f68366n = aVar;
        this.f68369q = f16;
        this.f68370r = bitmap;
        this.f68371s = rect;
    }

    public void h(DoodleLayout doodleLayout) {
        this.f68374v = doodleLayout;
    }

    public void i() {
        if (this.f68363k != null) {
            return;
        }
        DoodleLayout doodleLayout = this.f68374v;
        Bitmap g06 = doodleLayout != null ? doodleLayout.g0() : null;
        this.f68370r = g06;
        if (g06 == null) {
            return;
        }
        RectF r16 = this.f68374v.f68171t0.r();
        int i3 = Math.min(this.f68371s.width(), this.f68371s.height()) / 8 < 28 ? 2 : 8;
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f68371s.width() / i3, this.f68371s.height() / i3, Bitmap.Config.RGB_565);
            float f16 = i3;
            float f17 = 1.0f / f16;
            hd0.c.k("MosaicOperator", "initMosaicPicMode -- contentBounds=" + r16);
            RectF rectF = new RectF(0.0f, 0.0f, (float) createBitmap.getWidth(), (float) createBitmap.getHeight());
            if (r16 != null) {
                Matrix matrix = new Matrix();
                matrix.postScale(f17, f17);
                matrix.mapRect(rectF, r16);
            }
            hd0.c.c("MosaicOperator", "init matrix. scale[%f, %f].", Float.valueOf(f17), Float.valueOf(f17));
            new Canvas(createBitmap).drawBitmap(this.f68370r, (Rect) null, rectF, (Paint) null);
            int min = Math.min(createBitmap.getWidth(), createBitmap.getHeight()) / 28;
            if (min == 0) {
                min = 1;
            }
            zr.b.b(createBitmap, min);
            Bitmap createBitmap2 = Bitmap.createBitmap(this.f68371s.width(), this.f68371s.height(), Bitmap.Config.RGB_565);
            if (createBitmap2 == null) {
                createBitmap.recycle();
                if (QLog.isColorLevel()) {
                    QLog.e("MosaicOperator", 2, "failed to create mosaic bitmap");
                    return;
                }
                return;
            }
            Canvas canvas = new Canvas(createBitmap2);
            Matrix matrix2 = new Matrix();
            matrix2.postScale(f16, f16);
            canvas.drawBitmap(createBitmap, matrix2, null);
            createBitmap.recycle();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            this.f68363k = new BitmapShader(createBitmap2, tileMode, tileMode);
        } catch (IllegalArgumentException e16) {
            hd0.c.h("MosaicOperator", "initMosaicPicMode.", e16);
        } catch (OutOfMemoryError e17) {
            hd0.c.h("MosaicOperator", "initMosaicPicMode.", e17);
        }
    }

    public void j(int i3, int i16) {
        if (this.f68375w != null) {
            return;
        }
        this.A = i3;
        this.B = i16;
        this.f68375w = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
        this.f68376x = new Canvas(this.f68375w);
        this.f68377y = true;
    }

    public void l() {
        c.a aVar = this.f68366n;
        if (aVar != null) {
            if (this.f68368p == 105) {
                aVar.b(this.f68375w, this.f68377y);
            } else {
                aVar.a(this.f68353a, this.f68360h, this.f68361i);
            }
        }
        this.f68377y = false;
        if (this.f68365m) {
            k();
        }
    }

    public void m(g gVar) {
        int i3 = gVar.f68320a;
        if (i3 != 103) {
            if (i3 == 104) {
                id0.b.f("0X80075CF");
                return;
            } else {
                if (i3 == 105) {
                    c(true);
                    DoodleLayout.P1("delete_mosaics");
                    id0.b.i("0X80076C2");
                    return;
                }
                return;
            }
        }
        DoodleLayout.P1("delete_mosaics");
        id0.b.i("0X80076C2");
        List<Integer> list = gVar.f68350e;
        List<Integer> list2 = gVar.f68351f;
        for (int i16 = 0; i16 < list.size() && i16 < list2.size(); i16++) {
            d(list.get(i16).intValue(), list2.get(i16).intValue());
        }
        l();
    }

    public void n() {
        if (this.f68368p == 105) {
            this.f68364l.setXfermode(null);
            this.f68364l.setColor(C);
            this.f68364l.setStrokeWidth(this.f68378z);
        } else {
            this.f68364l.setXfermode(null);
            this.f68364l.setStrokeWidth(this.f68378z);
            BitmapShader bitmapShader = this.f68363k;
            if (bitmapShader != null) {
                this.f68364l.setShader(bitmapShader);
            }
        }
    }

    public void o(float f16) {
        if (this.f68368p != 105) {
            this.f68378z = (int) f16;
            this.f68364l.setStrokeWidth(f16);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.e
    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x16 = motionEvent.getX();
        float y16 = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f68372t = x16;
            this.f68373u = y16;
            g gVar = new g(this.f68368p, this.f68378z);
            this.f68362j = gVar;
            b bVar = this.f68367o;
            if (bVar != null) {
                bVar.d(gVar);
            }
            int i3 = this.f68368p;
            if (i3 == 103) {
                DoodleLayout.P1("use_mosaics");
                id0.b.i("0X80076C1");
                float f16 = this.f68357e;
                int i16 = this.f68355c;
                int i17 = (int) ((x16 * f16) / i16);
                int i18 = (int) ((y16 * f16) / i16);
                if (i17 >= 0 && i18 >= 0) {
                    this.f68362j.f68350e.add(Integer.valueOf(i17));
                    this.f68362j.f68351f.add(Integer.valueOf(i18));
                    f(i17, i18);
                    l();
                }
            } else if (i3 == 104) {
                this.f68362j.f68347b.reset();
                this.f68362j.f68347b.moveTo(x16, y16);
                float f17 = x16 + 1.0f;
                float f18 = 1.0f + y16;
                this.f68362j.f68347b.lineTo(f17, f18);
                this.f68362j.f68352g.add(new n(n.f68419f, x16, y16));
                this.f68362j.f68352g.add(new n(n.f68420g, f17, f18));
            } else if (i3 == 105) {
                this.f68362j.f68347b.reset();
                this.f68362j.f68347b.moveTo(x16, y16);
                float f19 = x16 + 1.0f;
                float f26 = 1.0f + y16;
                this.f68362j.f68347b.lineTo(f19, f26);
                this.f68362j.f68352g.add(new n(n.f68419f, x16, y16));
                this.f68362j.f68352g.add(new n(n.f68420g, f19, f26));
            }
        } else if (action != 1) {
            if (action == 2) {
                int i19 = this.f68368p;
                if (i19 == 103) {
                    List<Integer> list = this.f68362j.f68350e;
                    int intValue = list.get(list.size() - 1).intValue();
                    List<Integer> list2 = this.f68362j.f68351f;
                    int intValue2 = list2.get(list2.size() - 1).intValue();
                    float f27 = this.f68357e;
                    int i26 = this.f68355c;
                    int i27 = (int) ((x16 * f27) / i26);
                    int i28 = (int) ((y16 * f27) / i26);
                    if ((i27 != intValue || i28 != intValue2) && i27 >= 0 && i28 >= 0) {
                        this.f68362j.f68350e.add(Integer.valueOf(i27));
                        this.f68362j.f68351f.add(Integer.valueOf(i28));
                        f(i27, i28);
                        l();
                    }
                } else if (i19 == 104) {
                    float f28 = this.f68372t;
                    float f29 = (x16 + f28) / 2.0f;
                    float f36 = this.f68373u;
                    float f37 = (y16 + f36) / 2.0f;
                    this.f68362j.f68347b.quadTo(f28, f36, f29, f37);
                    this.f68362j.f68352g.add(new n(n.f68421h, this.f68372t, this.f68373u, f29, f37));
                    this.f68372t = x16;
                    this.f68373u = y16;
                } else if (i19 == 105) {
                    float f38 = this.f68372t;
                    float f39 = (x16 + f38) / 2.0f;
                    float f46 = this.f68373u;
                    float f47 = (y16 + f46) / 2.0f;
                    this.f68362j.f68347b.quadTo(f38, f46, f39, f47);
                    this.f68362j.f68352g.add(new n(n.f68421h, this.f68372t, this.f68373u, f39, f47));
                    this.f68372t = x16;
                    this.f68373u = y16;
                }
            }
        } else if (this.f68368p == 103) {
            List<Integer> list3 = this.f68362j.f68350e;
            int intValue3 = list3.get(list3.size() - 1).intValue();
            List<Integer> list4 = this.f68362j.f68351f;
            int intValue4 = list4.get(list4.size() - 1).intValue();
            float f48 = this.f68357e;
            int i29 = this.f68355c;
            int i36 = (int) ((x16 * f48) / i29);
            int i37 = (int) ((y16 * f48) / i29);
            if ((i36 != intValue3 || i37 != intValue4) && i36 >= 0 && i37 >= 0) {
                this.f68362j.f68350e.add(Integer.valueOf(i36));
                this.f68362j.f68351f.add(Integer.valueOf(i37));
                f(i36, i37);
                l();
            }
        }
        return true;
    }

    public void p(int i3) {
        this.f68368p = i3;
    }

    public void q(int i3) {
        hd0.c.a("MosaicOperator", "set MosaicSize:" + i3);
        this.f68355c = i3;
    }

    public void r(int i3, int i16) {
        hd0.c.a("MosaicOperator", "standardWidth:" + i3 + ",standardHeight:" + i16);
        this.f68358f = i3;
        this.f68359g = i16;
    }

    public void s(int i3, int i16) {
        float f16 = i3;
        this.f68356d = this.f68358f / f16;
        float f17 = this.f68359g / i16;
        this.f68357e = f17;
        if (f17 <= 0.0f) {
            hd0.c.g("MosaicOperator", "mosaicHeightScale <= 0.");
            this.f68357e = this.f68369q;
        }
        float f18 = f16 * this.f68357e;
        int i17 = this.f68355c;
        this.f68360h = (int) (f18 / i17);
        this.f68361i = (int) (this.f68359g / i17);
        hd0.c.a("MosaicOperator", "create mosaic mask array, width:" + this.f68360h + ",height:" + this.f68361i + ",array length:" + (this.f68360h * this.f68361i));
        this.f68353a = new byte[this.f68360h * this.f68361i];
        int i18 = 0;
        while (true) {
            byte[] bArr = this.f68353a;
            if (i18 >= bArr.length) {
                break;
            }
            bArr[i18] = 0;
            i18++;
        }
        if (this.f68365m) {
            this.f68354b = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f68361i, this.f68360h);
            for (int i19 = 0; i19 < this.f68361i; i19++) {
                for (int i26 = 0; i26 < this.f68360h; i26++) {
                    this.f68354b[i19][i26] = 0;
                }
            }
        }
    }

    public void b() {
        this.f68363k = null;
    }
}
