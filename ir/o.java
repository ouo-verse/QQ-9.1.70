package ir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class o extends i {
    private static int N = 30;
    private static int O = 30;
    private String A;
    private String B;
    private int C;
    private int D;
    private Rect E;
    private int F;
    private int G;
    private int H;
    private int I;
    private int J;
    private int K;
    private Bitmap L;
    private int M;

    /* renamed from: i, reason: collision with root package name */
    private Paint f408381i;

    /* renamed from: j, reason: collision with root package name */
    private TextPaint f408382j;

    /* renamed from: k, reason: collision with root package name */
    private TextPaint f408383k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f408384l;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f408385m;

    /* renamed from: n, reason: collision with root package name */
    private int f408386n;

    /* renamed from: o, reason: collision with root package name */
    private int f408387o;

    /* renamed from: p, reason: collision with root package name */
    private int f408388p;

    /* renamed from: q, reason: collision with root package name */
    private int f408389q;

    /* renamed from: r, reason: collision with root package name */
    private Typeface f408390r;

    /* renamed from: s, reason: collision with root package name */
    private Typeface f408391s;

    /* renamed from: t, reason: collision with root package name */
    private int f408392t;

    /* renamed from: u, reason: collision with root package name */
    private int f408393u;

    /* renamed from: v, reason: collision with root package name */
    private int f408394v;

    /* renamed from: w, reason: collision with root package name */
    private int f408395w;

    /* renamed from: x, reason: collision with root package name */
    private int f408396x;

    /* renamed from: y, reason: collision with root package name */
    private String f408397y;

    /* renamed from: z, reason: collision with root package name */
    private String f408398z;

    public o(Context context, String str) {
        super(context, str);
        this.f408381i = new Paint();
        this.f408382j = new TextPaint();
        this.f408383k = new TextPaint();
        this.f408386n = 0;
        this.f408387o = 0;
        this.f408388p = 0;
        this.f408389q = 0;
        this.f408390r = null;
        this.f408391s = null;
        this.f408397y = "";
        this.f408398z = "";
        this.A = HardCodeUtil.qqStr(R.string.y9j);
        this.B = "SHENZHEN";
        this.C = 0;
        this.D = 0;
        this.E = new Rect(0, 0, 0, 0);
        this.F = 0;
        this.G = 8;
        this.H = 4;
        this.I = 0;
        this.J = 0;
        this.K = 0;
        this.L = null;
        this.M = 0;
        k(this.f408326d);
        o();
        b();
    }

    public static String l(int i3, String str, String str2, String str3) {
        String str4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("iconpath", str);
            jSONObject.put("ttfpath", str2);
            jSONObject.put("locationString", str3);
            str4 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("TriangleLocationStickerDrawble", 2, e16, new Object[0]);
            }
            str4 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TriangleLocationStickerDrawble", 2, str4);
        }
        return str4;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408387o;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408386n;
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        this.f408381i.setAlpha(arrayList.get(this.f408392t).intValue());
        int i3 = 0;
        if (arrayList.get(this.f408395w).intValue() != 0) {
            int i16 = (int) ((this.f408389q * r0) / 100.0d);
            int i17 = this.f408389q;
            Rect rect = new Rect((i17 - i16) / 2, 0, (i17 + i16) / 2, this.M);
            int i18 = this.f408386n;
            int i19 = N;
            canvas.drawBitmap(this.L, rect, new Rect((i18 - i16) / 2, i19, (i18 + i16) / 2, this.M + i19), this.f408381i);
            i3 = arrayList.get(this.f408396x).intValue() + (i16 / 2);
        }
        int intValue = arrayList.get(this.f408393u).intValue();
        if (intValue == this.J) {
            intValue = arrayList.get(this.f408394v).intValue();
        }
        int c16 = ((this.f408388p - intValue) - this.C) - i.c(1.0f, this.f408325c.getResources());
        int i26 = this.f408386n;
        int i27 = ((i26 / 2) - this.D) - i3;
        int i28 = (i26 / 2) + i3;
        int i29 = N;
        Rect rect2 = new Rect(i27, c16 + i29, this.D + i27, this.C + c16 + i29);
        int i36 = N;
        Rect rect3 = new Rect(i28, c16 + i36, this.D + i28, c16 + this.C + i36);
        Bitmap bitmap = this.f408384l;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.E, rect2, this.f408381i);
        }
        Bitmap bitmap2 = this.f408385m;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, this.E, rect3, this.f408381i);
        }
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
            this.f408397y = jSONObject.optString("iconpath", "");
            this.f408398z = jSONObject.optString("ttfpath", "");
            this.A = jSONObject.optString("locationString", "");
        }
        return new String[]{this.f408397y, this.f408398z, this.A};
    }

    public String m() {
        return this.f408398z;
    }

    public String n() {
        return this.f408397y;
    }

    protected void o() {
        int i3;
        int i16;
        String l3 = com.tencent.aelight.camera.aioeditor.capture.util.d.l(this.A);
        this.A = l3;
        if (l3 != null && !TextUtils.isEmpty(l3)) {
            String d16 = ChnToSpell.d(this.A, 1);
            this.B = d16;
            this.B = d16.toUpperCase();
            String str = this.A;
            if (str != null && !str.contains(HardCodeUtil.qqStr(R.string.y9l)) && !this.A.contains(HardCodeUtil.qqStr(R.string.y9k)) && !this.A.endsWith(HardCodeUtil.qqStr(R.string.y9f)) && !this.A.endsWith(HardCodeUtil.qqStr(R.string.y9g))) {
                this.A += HardCodeUtil.qqStr(R.string.y9i);
            }
        } else {
            this.A = HardCodeUtil.qqStr(R.string.y9h);
            this.B = "YOUR CITY";
        }
        String str2 = this.B;
        if (str2 == null || TextUtils.isEmpty(str2)) {
            this.B = "YOUR CITY";
        }
        int c16 = i.c(15.0f, this.f408325c.getResources());
        N = c16;
        O = c16;
        this.f408390r = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
        if (FileUtils.fileExists(this.f408398z)) {
            this.f408391s = Typeface.createFromFile(this.f408398z);
        } else {
            this.f408391s = Typeface.DEFAULT_BOLD;
        }
        if (this.f408391s == null) {
            this.f408391s = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
        }
        this.F = i.c(24.0f, this.f408325c.getResources());
        this.H = i.c(3.0f, this.f408325c.getResources());
        this.G = i.c(4.5f, this.f408325c.getResources());
        Paint paint = new Paint();
        this.f408381i = paint;
        paint.setAntiAlias(true);
        this.f408381i.setDither(true);
        this.f408382j.setAntiAlias(true);
        this.f408382j.setDither(true);
        this.f408382j.setColor(-1);
        this.f408382j.setTypeface(this.f408391s);
        this.f408382j.setTextSize(i.c(28.0f, this.f408325c.getResources()));
        this.f408383k.setAntiAlias(true);
        this.f408383k.setDither(true);
        this.f408383k.setColor(-1);
        this.f408383k.setTypeface(this.f408390r);
        this.f408383k.setFakeBoldText(true);
        this.f408383k.setTextSize(i.c(9.0f, this.f408325c.getResources()));
        TextPaint textPaint = this.f408382j;
        int i17 = i.f408322h;
        textPaint.setShadowLayer(i17, 0.0f, 0.0f, 1711276032);
        this.f408383k.setShadowLayer(i17, 0.0f, 0.0f, 1711276032);
        this.f408382j.setLetterSpacing(0.0f);
        this.f408383k.setLetterSpacing(0.0f);
        if (FileUtils.fileExists(this.f408397y)) {
            this.f408385m = BitmapFactory.decodeFile(this.f408397y);
        } else {
            QLog.e("TriangleLocationStickerDrawble", 2, "mIconPath not exist");
        }
        Bitmap bitmap = this.f408385m;
        int i18 = 0;
        if (bitmap != null) {
            i3 = bitmap.getWidth();
            i16 = this.f408385m.getHeight();
            Matrix matrix = new Matrix();
            matrix.setRotate(180.0f, i3 / 2.0f, i16 / 2.0f);
            this.f408384l = Bitmap.createBitmap(this.f408385m, 0, 0, i3, i16, matrix, true);
        } else {
            i3 = 0;
            i16 = 0;
        }
        this.E = new Rect(0, 0, i3, i16);
        this.C = i.c(20.5f, this.f408325c.getResources());
        this.D = i.c(10.5f, this.f408325c.getResources());
        Rect rect = this.E;
        rect.left = 0;
        rect.top = 0;
        rect.right = i3;
        rect.bottom = i16;
        int measureText = ((int) this.f408382j.measureText(this.A)) + (this.H * (this.A.length() - 1));
        int measureText2 = ((int) this.f408383k.measureText(this.B)) + (this.G * (this.B.length() - 1));
        if (measureText > measureText2) {
            this.f408389q = measureText;
        } else {
            this.f408389q = measureText2;
        }
        this.f408386n = this.f408389q + ((this.D + this.F) * 2) + (O * 2);
        Paint.FontMetrics fontMetrics = this.f408382j.getFontMetrics();
        Paint.FontMetrics fontMetrics2 = this.f408383k.getFontMetrics();
        this.I = -((int) fontMetrics.top);
        int i19 = -((int) fontMetrics2.top);
        int c17 = i.c(33.0f, this.f408325c.getResources()) + i.c(5.0f, this.f408325c.getResources());
        this.J = c17;
        this.K = c17 - i.c(5.0f, this.f408325c.getResources());
        this.M = this.I + i19 + i.c(4.0f, this.f408325c.getResources());
        this.f408387o = this.I + i19 + i.c(3.0f, this.f408325c.getResources()) + (N * 2);
        this.f408388p = this.I + this.K + i.c(5.0f, this.f408325c.getResources());
        this.f408392t = this.f408323a.a("T", 0L, 165L, 0, 255, new LinearInterpolator());
        this.f408393u = this.f408323a.a("X", 0L, 330L, 0, this.J, new DecelerateInterpolator());
        this.f408394v = this.f408323a.a("X", 330L, 340L, this.J, this.K, new AccelerateInterpolator());
        this.f408395w = this.f408323a.a("X", 825L, 200L, 0, 100, new DecelerateInterpolator());
        this.f408396x = this.f408323a.a("X", 825L, 355L, i.c(10.0f, this.f408325c.getResources()), i.c(20.0f, this.f408325c.getResources()), new DecelerateInterpolator());
        if (this.L == null) {
            this.L = Bitmap.createBitmap(this.f408389q, this.M, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(this.L);
            int i26 = (this.f408389q - measureText) / 2;
            int i27 = 0;
            while (i27 < this.A.length()) {
                int i28 = i27 + 1;
                String substring = this.A.substring(i27, i28);
                canvas.drawText(substring, i26, this.I, this.f408382j);
                i26 = i26 + ((int) this.f408382j.measureText(substring)) + this.H;
                i27 = i28;
            }
            int i29 = (this.f408389q - measureText2) / 2;
            while (i18 < this.B.length()) {
                int i36 = i18 + 1;
                String substring2 = this.B.substring(i18, i36);
                canvas.drawText(substring2, i29, this.M, this.f408383k);
                i29 = i29 + ((int) this.f408383k.measureText(substring2)) + this.G;
                i18 = i36;
            }
        }
    }
}
