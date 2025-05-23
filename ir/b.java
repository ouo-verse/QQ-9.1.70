package ir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class b extends i {

    /* renamed from: a0, reason: collision with root package name */
    private static int f408229a0 = 0;

    /* renamed from: b0, reason: collision with root package name */
    private static int f408230b0 = 5;
    private int A;
    private int B;
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private int L;
    private int[] M;
    private int[] N;
    private int[] O;
    private int P;
    private int Q;
    private int R;
    private Bitmap S;
    private Canvas T;
    private Bitmap U;
    private Canvas V;
    private Bitmap W;
    private Canvas X;
    private Bitmap Y;
    private Canvas Z;

    /* renamed from: i, reason: collision with root package name */
    private Paint f408231i;

    /* renamed from: j, reason: collision with root package name */
    private TextPaint f408232j;

    /* renamed from: k, reason: collision with root package name */
    private int f408233k;

    /* renamed from: l, reason: collision with root package name */
    private int f408234l;

    /* renamed from: m, reason: collision with root package name */
    private String f408235m;

    /* renamed from: n, reason: collision with root package name */
    private String f408236n;

    /* renamed from: o, reason: collision with root package name */
    private String f408237o;

    /* renamed from: p, reason: collision with root package name */
    private String f408238p;

    /* renamed from: q, reason: collision with root package name */
    private Bitmap f408239q;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f408240r;

    /* renamed from: s, reason: collision with root package name */
    private Bitmap f408241s;

    /* renamed from: t, reason: collision with root package name */
    private Bitmap f408242t;

    /* renamed from: u, reason: collision with root package name */
    private Typeface f408243u;

    /* renamed from: v, reason: collision with root package name */
    private int f408244v;

    /* renamed from: w, reason: collision with root package name */
    private int f408245w;

    /* renamed from: x, reason: collision with root package name */
    private int f408246x;

    /* renamed from: y, reason: collision with root package name */
    private int f408247y;

    /* renamed from: z, reason: collision with root package name */
    private int f408248z;

    public b(Context context, String str) {
        super(context, str);
        this.f408231i = new Paint();
        this.f408232j = new TextPaint();
        this.f408233k = 0;
        this.f408234l = 0;
        this.B = 4;
        this.C = 1;
        this.D = 4;
        this.E = 22;
        this.F = 2;
        this.G = 73;
        this.H = 62;
        this.I = 0;
        this.J = 0;
        this.P = 0;
        this.R = 4;
        k(this.f408326d);
        q();
        b();
    }

    private void l(String str, Canvas canvas) {
        int i3;
        int i16;
        if (str.length() != 4) {
            return;
        }
        Paint.FontMetrics fontMetrics = this.f408232j.getFontMetrics();
        int c16 = (((int) fontMetrics.descent) - ((int) fontMetrics.top)) - i.c(2.0f, this.f408325c.getResources());
        int i17 = 0;
        Rect rect = new Rect(0, 0, 0, this.H);
        int i18 = this.H;
        int i19 = this.F;
        Rect rect2 = new Rect(0, i18 + i19, 0, (i18 * 2) + i19);
        Bitmap bitmap = this.f408241s;
        if (bitmap != null) {
            i3 = bitmap.getWidth();
            i16 = this.f408241s.getHeight();
        } else {
            i3 = 0;
            i16 = 0;
        }
        Rect rect3 = new Rect(0, 0, i3, i16);
        while (i17 < 4) {
            int i26 = i17 + 1;
            String substring = str.substring(i17, i26);
            int measureText = (int) this.f408232j.measureText(substring);
            int i27 = this.G;
            int i28 = (i17 * i27) + ((i27 - measureText) / 2);
            int i29 = (this.H + c16) / 2;
            int i36 = i17 * i27;
            rect.left = i36;
            rect.right = i36 + i27;
            Bitmap bitmap2 = this.f408241s;
            if (bitmap2 != null) {
                canvas.drawBitmap(bitmap2, rect3, rect, this.f408231i);
            }
            rect2.left = rect.left;
            rect2.right = rect.right;
            Bitmap bitmap3 = this.f408242t;
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, rect3, rect2, this.f408231i);
            }
            canvas.drawText(substring, i28, i29, this.f408232j);
            i17 = i26;
        }
    }

    public static String n(int i3, String str, String str2, String str3, String str4) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("upFilePath", str);
            jSONObject.put("downFilePath", str2);
            jSONObject.put("nowHhmm", str3);
            jSONObject.put("lastHhmm", str4);
            return jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("CalendarTimeStickerDrawable", 2, e16, new Object[0]);
            }
            return null;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408234l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408233k;
    }

    @Override // ir.i
    public String[] k(String str) {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(str);
        } catch (JSONException e16) {
            e16.printStackTrace();
            jSONObject = null;
        }
        if (jSONObject != null) {
            this.f408327e = jSONObject.optInt("type", 0);
            this.f408235m = jSONObject.optString("upFilePath", "");
            this.f408236n = jSONObject.optString("downFilePath", "");
            this.f408237o = jSONObject.optString("nowHhmm", "");
            this.f408238p = jSONObject.optString("lastHhmm", "");
        }
        return new String[]{this.f408235m, this.f408236n, this.f408237o};
    }

    public void m() {
        if (this.f408237o.length() != 4) {
            this.f408237o = "0000";
        }
        if (this.f408238p.length() != 4) {
            this.f408238p = "0000";
        }
        int i3 = 0;
        this.C = 0;
        while (i3 < 4) {
            int i16 = i3 + 1;
            if (!this.f408237o.substring(i3, i16).equals(this.f408238p.substring(i3, i16))) {
                this.C++;
            }
            i3 = i16;
        }
        if (this.C == 0) {
            this.C = 1;
        }
    }

    public String o() {
        return this.f408236n;
    }

    public String p() {
        return this.f408235m;
    }

    protected void q() {
        m();
        int i3 = 500;
        long j3 = 500;
        this.K = this.f408323a.a(com.tencent.luggage.wxa.c8.c.f123400v, 165L, j3, 0, 255, new LinearInterpolator());
        int i16 = this.C;
        this.M = new int[i16];
        this.N = new int[i16];
        this.O = new int[i16];
        int i17 = 0;
        while (i17 < this.C) {
            long j16 = i3;
            long j17 = j3;
            this.M[i17] = this.f408323a.a(com.tencent.luggage.wxa.c8.c.f123400v, j16, j17, -40, 0, new LinearInterpolator());
            this.N[i17] = this.f408323a.a("frontFlip", j16, j17, 0, 100, new LinearInterpolator());
            this.O[i17] = this.f408323a.a("groundOldFlip", j16, j17, 255, 0, new LinearInterpolator());
            QLog.e("CalendarTimeStickerDrawable", 2, "groundOldFlip[i]: " + this.O[i17]);
            i3 += 500;
            i17++;
            j3 = j17;
        }
        this.P = i3;
        this.L = this.f408323a.a(com.tencent.luggage.wxa.c8.c.f123400v, 0L, i3, 0, 100, new LinearInterpolator());
        this.f408243u = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
        this.f408231i.setAntiAlias(true);
        this.f408231i.setDither(true);
        this.f408232j.setTextSize(i.c(60.0f, this.f408325c.getResources()));
        this.f408232j.setAntiAlias(true);
        this.f408232j.setDither(true);
        this.f408232j.setColor(-1);
        this.f408232j.setTypeface(this.f408243u);
        this.f408232j.setAlpha(255);
        this.f408232j.setShadowLayer(i.f408322h, 0.0f, 0.0f, 1711276032);
        this.R = i.c(2.0f, this.f408325c.getResources());
        this.D = i.c(1.0f, this.f408325c.getResources());
        this.E = i.c(11.0f, this.f408325c.getResources());
        this.F = i.c(1.0f, this.f408325c.getResources());
        this.G = i.c(36.5f, this.f408325c.getResources());
        this.H = i.c(31.0f, this.f408325c.getResources());
        int c16 = i.c(2.0f, this.f408325c.getResources());
        this.B = c16;
        int i18 = this.G;
        int i19 = (c16 * 2) + i18;
        this.f408246x = i19;
        this.f408247y = (int) ((i18 * 2.0d) / 3.0d);
        int i26 = this.H;
        this.f408248z = i26;
        this.A = 0;
        int i27 = this.D;
        int i28 = (i27 * 4) + this.E + (i18 * 4);
        int i29 = this.R;
        this.f408233k = i28 + (i29 * 2);
        this.f408234l = (i27 * 2) + this.F + (i26 * 2) + (i29 * 2);
        this.f408244v = i19;
        this.f408245w = i26;
        this.S = Bitmap.createBitmap(i18, i26, Bitmap.Config.ARGB_8888);
        this.T = new Canvas(this.S);
        this.U = Bitmap.createBitmap(this.f408244v, this.f408245w, Bitmap.Config.ARGB_8888);
        this.V = new Canvas(this.U);
        this.W = Bitmap.createBitmap(this.G, this.H, Bitmap.Config.ARGB_8888);
        this.X = new Canvas(this.W);
        this.Y = Bitmap.createBitmap(this.f408244v, this.f408245w, Bitmap.Config.ARGB_8888);
        this.Z = new Canvas(this.Y);
        if (FileUtils.fileExists(this.f408235m)) {
            this.f408241s = BitmapFactory.decodeFile(this.f408235m);
        } else {
            QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
        }
        if (FileUtils.fileExists(this.f408236n)) {
            this.f408242t = BitmapFactory.decodeFile(this.f408236n);
        } else {
            QLog.e("CalendarTimeStickerDrawable", 2, "mUpFilePath not exist");
        }
        int i36 = this.G * 4;
        this.I = i36;
        int i37 = (this.H * 2) + this.F;
        this.J = i37;
        this.f408239q = Bitmap.createBitmap(i36, i37, Bitmap.Config.ARGB_8888);
        l(this.f408237o, new Canvas(this.f408239q));
        this.f408240r = Bitmap.createBitmap(this.I, this.J, Bitmap.Config.ARGB_8888);
        l(this.f408238p, new Canvas(this.f408240r));
        this.Q = this.f408323a.a("X", 825L, 1000L, 0, 100, new DecelerateInterpolator());
    }

    private Matrix r(int i3) {
        int i16 = i3;
        Matrix matrix = new Matrix();
        matrix.setValues(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
        int i17 = this.G;
        int i18 = this.H;
        float[] fArr = {0.0f, 0.0f, i17, 0.0f, i17, i18, 0.0f, i18};
        if (i16 < 0) {
            if (i16 > -50) {
                float f16 = (i16 + 50) / 50.0f;
                int i19 = this.f408247y + ((int) ((i17 - r5) * f16));
                int i26 = this.f408244v;
                float f17 = i18 - ((int) (f16 * i18));
                float f18 = i18;
                matrix.setPolyToPoly(fArr, 0, new float[]{(i26 - i19) / 2, f17, (i26 / 2) + (i19 / 2), f17, (i26 / 2) + (i17 / 2), f18, (i26 / 2) - (i17 / 2), f18}, 0, 4);
            }
            return matrix;
        }
        if (i16 < 50) {
            float f19 = i16 / 50.0f;
            int i27 = ((int) ((this.f408246x - i17) * f19)) + i17;
            int i28 = this.f408244v;
            float f26 = i18 - ((int) ((1.0f - f19) * i18));
            float f27 = i18;
            matrix.setPolyToPoly(fArr, 0, new float[]{(i28 - i27) / 2, f26, (i28 / 2) + (i27 / 2), f26, (i28 / 2) + (i17 / 2), f27, (i28 / 2) - (i17 / 2), f27}, 0, 4);
            return matrix;
        }
        if (i16 > 100) {
            i16 = 100;
        }
        float f28 = (i16 - 50) / 50.0f;
        int i29 = this.f408244v;
        int i36 = (i29 / 2) + ((((int) ((this.f408246x - i17) * (1.0d - f28))) + i17) / 2);
        float f29 = 0;
        float f36 = (int) (f28 * i18);
        matrix.setPolyToPoly(fArr, 0, new float[]{(i29 / 2) - (i17 / 2), f29, (i29 / 2) + (i17 / 2), f29, i36, f36, (i29 - r5) / 2, f36}, 0, 4);
        return matrix;
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int i3;
        int i16;
        int intValue;
        int intValue2 = arrayList.get(this.K).intValue();
        this.f408231i.setAlpha(intValue2);
        int i17 = 0;
        if (arrayList.get(this.L).intValue() >= 1000) {
            i3 = f408230b0;
        } else if (intValue2 < 255) {
            i3 = f408229a0;
        } else {
            i3 = 1;
            for (int i18 = 0; i18 < this.C; i18++) {
                if (arrayList.get(this.N[i18]).intValue() == 100) {
                    i3++;
                }
                if (i3 == this.C + 1) {
                    i3 = f408230b0;
                }
            }
        }
        int i19 = 0;
        while (i19 < 4) {
            Rect rect = new Rect(i17, i17, i17, i17);
            Rect rect2 = new Rect(i17, i17, i17, i17);
            Rect rect3 = new Rect(i17, i17, i17, this.H);
            int i26 = this.H;
            int i27 = this.F;
            Rect rect4 = new Rect(i17, i26 + i27, i17, (i26 * 2) + i27);
            int i28 = this.D;
            int i29 = this.R;
            int i36 = i28 + i29;
            rect.top = i36;
            int i37 = this.H;
            rect.bottom = i36 + i37;
            int i38 = i19 > 1 ? this.E - i28 : i17;
            int i39 = this.G;
            int i46 = ((i39 + i28) * i19) + i38 + i29;
            rect.left = i46;
            rect.right = i46 + i39;
            int i47 = i19 * i39;
            rect3.left = i47;
            rect3.right = i47 + i39;
            int i48 = i28 + i37 + this.F + i29;
            rect2.top = i48;
            rect2.bottom = i48 + i37;
            rect2.left = rect.left;
            rect2.right = rect.right;
            rect4.left = rect3.left;
            rect4.right = rect3.right;
            int i49 = 3 - i19;
            if (i3 == f408230b0) {
                canvas.drawBitmap(this.f408239q, rect3, rect, this.f408231i);
                canvas.drawBitmap(this.f408239q, rect4, rect2, this.f408231i);
            } else if (i3 == f408229a0) {
                canvas.drawBitmap(this.f408240r, rect3, rect, this.f408231i);
                canvas.drawBitmap(this.f408240r, rect4, rect2, this.f408231i);
            } else {
                int i56 = i3 - 1;
                if (i56 < i49) {
                    canvas.drawBitmap(this.f408240r, rect3, rect, this.f408231i);
                    canvas.drawBitmap(this.f408240r, rect4, rect2, this.f408231i);
                } else if (i56 > i49) {
                    canvas.drawBitmap(this.f408239q, rect3, rect, this.f408231i);
                    canvas.drawBitmap(this.f408239q, rect4, rect2, this.f408231i);
                } else if (i56 == i49 && (intValue = arrayList.get(this.O[i49]).intValue()) > 0) {
                    this.f408231i.setAlpha(intValue);
                    canvas.drawBitmap(this.f408240r, rect4, rect2, this.f408231i);
                    this.f408231i.setAlpha(intValue2);
                }
            }
            i19++;
            i17 = 0;
        }
        if (i3 == f408229a0 || i3 == f408230b0) {
            return;
        }
        int i57 = i3 - 1;
        int i58 = 3 - i57;
        int intValue3 = arrayList.get(this.M[i57]).intValue();
        int intValue4 = arrayList.get(this.N[i57]).intValue();
        if (intValue3 > -50) {
            Matrix r16 = r(intValue3);
            Rect rect5 = new Rect(0, 0, 0, this.H);
            int i59 = this.G;
            int i65 = i58 * i59;
            rect5.left = i65;
            rect5.right = i65 + i59;
            int i66 = (int) (((intValue3 + 50) * 255.0d) / 50.0d);
            this.T.drawColor(0, PorterDuff.Mode.CLEAR);
            this.V.drawColor(0, PorterDuff.Mode.CLEAR);
            this.T.drawBitmap(this.f408239q, rect5, new Rect(0, 0, this.G, this.H), this.f408231i);
            this.V.drawBitmap(this.S, r16, this.f408231i);
            Rect rect6 = new Rect(0, 0, 0, 0);
            int i67 = this.D;
            int i68 = this.R;
            int i69 = i67 + i68;
            rect6.top = i69;
            rect6.bottom = i69 + this.H;
            int i75 = ((((this.G + i67) * i58) + (i58 > 1 ? this.E - i67 : 0)) + i68) - this.B;
            rect6.left = i75;
            rect6.right = i75 + this.f408246x;
            this.f408231i.setAlpha(i66);
            i16 = 0;
            canvas.drawBitmap(this.U, new Rect(0, 0, this.f408246x, this.f408248z), rect6, this.f408231i);
            this.f408231i.setAlpha(intValue2);
        } else {
            i16 = 0;
        }
        if (intValue4 < 50) {
            Matrix r17 = r(intValue4);
            Rect rect7 = new Rect(i16, i16, i16, this.H);
            int i76 = this.G;
            int i77 = i58 * i76;
            rect7.left = i77;
            rect7.right = i77 + i76;
            this.X.drawColor(i16, PorterDuff.Mode.CLEAR);
            this.Z.drawColor(i16, PorterDuff.Mode.CLEAR);
            this.X.drawBitmap(this.f408240r, rect7, new Rect(i16, i16, this.G, this.H), this.f408231i);
            this.Z.drawBitmap(this.W, r17, this.f408231i);
            Rect rect8 = new Rect(i16, i16, i16, i16);
            int i78 = this.D;
            int i79 = this.R;
            int i85 = i78 + i79;
            rect8.top = i85;
            rect8.bottom = i85 + this.H;
            int i86 = ((((this.G + i78) * i58) + (i58 > 1 ? this.E - i78 : 0)) + i79) - this.B;
            rect8.left = i86;
            rect8.right = i86 + this.f408246x;
            canvas.drawBitmap(this.Y, new Rect(0, 0, this.f408246x, this.f408248z), rect8, this.f408231i);
        }
        if (intValue4 > 50) {
            Matrix r18 = r(intValue4);
            int i87 = this.H;
            int i88 = this.F;
            Rect rect9 = new Rect(0, i87 + i88, 0, (i87 * 2) + i88);
            int i89 = this.G;
            int i95 = i58 * i89;
            rect9.left = i95;
            rect9.right = i95 + i89;
            this.X.drawColor(0, PorterDuff.Mode.CLEAR);
            this.Z.drawColor(0, PorterDuff.Mode.CLEAR);
            this.X.drawBitmap(this.f408239q, rect9, new Rect(0, 0, this.G, this.H), this.f408231i);
            this.Z.drawBitmap(this.W, r18, this.f408231i);
            Rect rect10 = new Rect(0, 0, 0, 0);
            int i96 = this.D;
            int i97 = this.H;
            int i98 = i96 + i97 + this.F;
            int i99 = this.R;
            int i100 = i98 + i99;
            rect10.top = i100;
            rect10.bottom = i100 + i97;
            int i101 = ((((this.G + i96) * i58) + (i58 > 1 ? this.E - i96 : 0)) + i99) - this.B;
            rect10.left = i101;
            rect10.right = i101 + this.f408246x;
            canvas.drawBitmap(this.Y, new Rect(0, 0, this.f408246x, this.f408248z), rect10, this.f408231i);
        }
    }
}
