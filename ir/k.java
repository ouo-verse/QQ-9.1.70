package ir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class k extends i {
    l A;
    int B;
    int C;
    private int D;
    private int E;
    private int F;
    private Typeface G;
    private String H;
    private String I;
    private String J;
    private PorterDuffXfermode K;
    private PorterDuffXfermode L;
    private float M;

    /* renamed from: i, reason: collision with root package name */
    private int f408348i;

    /* renamed from: j, reason: collision with root package name */
    private int f408349j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f408350k;

    /* renamed from: l, reason: collision with root package name */
    private Rect f408351l;

    /* renamed from: m, reason: collision with root package name */
    private RectF f408352m;

    /* renamed from: n, reason: collision with root package name */
    private Rect f408353n;

    /* renamed from: o, reason: collision with root package name */
    private Rect f408354o;

    /* renamed from: p, reason: collision with root package name */
    private RectF f408355p;

    /* renamed from: q, reason: collision with root package name */
    private Rect f408356q;

    /* renamed from: r, reason: collision with root package name */
    private Bitmap f408357r;

    /* renamed from: s, reason: collision with root package name */
    private Paint f408358s;

    /* renamed from: t, reason: collision with root package name */
    private Paint f408359t;

    /* renamed from: u, reason: collision with root package name */
    private TextPaint f408360u;

    /* renamed from: v, reason: collision with root package name */
    private String f408361v;

    /* renamed from: w, reason: collision with root package name */
    private String f408362w;

    /* renamed from: x, reason: collision with root package name */
    private String f408363x;

    /* renamed from: y, reason: collision with root package name */
    private String f408364y;

    /* renamed from: z, reason: collision with root package name */
    l f408365z;

    public k(Context context, String str) {
        super(context, str);
        this.f408351l = null;
        this.f408352m = null;
        this.f408353n = null;
        this.f408354o = null;
        this.f408355p = null;
        this.f408356q = null;
        this.f408358s = new Paint();
        this.f408359t = new Paint();
        this.f408360u = new TextPaint();
        this.f408361v = HardCodeUtil.qqStr(R.string.y9_);
        this.f408362w = HardCodeUtil.qqStr(R.string.y9c);
        this.f408363x = HardCodeUtil.qqStr(R.string.y9a);
        this.f408364y = HardCodeUtil.qqStr(R.string.y9b);
        this.B = 0;
        this.C = 0;
        this.D = 0;
        this.E = 0;
        this.F = 0;
        this.G = null;
        this.H = null;
        this.I = null;
        this.J = null;
        this.K = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.L = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.M = 0.0f;
        k(str);
        m();
        b();
    }

    public static String l(int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        String str8;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("first_line", str);
            jSONObject.put("second_line", str2);
            jSONObject.put("third_line", str3);
            jSONObject.put("fourth_line", str4);
            jSONObject.put("font_file_name", str5);
            jSONObject.put("out_side_border", str6);
            jSONObject.put("in_side_border", str7);
            str8 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("LunaInfoStickerDrawable", 2, e16, new Object[0]);
            }
            str8 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("LunaInfoStickerDrawable", 2, str8);
        }
        return str8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return i.c(180.0f, this.f408325c.getResources());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return i.c(88.0f, this.f408325c.getResources());
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
            this.f408361v = jSONObject.optString("first_line", "");
            this.f408362w = jSONObject.optString("second_line", "");
            this.f408363x = jSONObject.optString("third_line", "");
            this.f408364y = jSONObject.optString("fourth_line", "");
            this.H = jSONObject.optString("font_file_name", "");
            this.I = jSONObject.optString("out_side_border", "");
            this.J = jSONObject.optString("in_side_border", "");
        }
        return new String[]{this.f408361v, this.f408362w, this.f408363x, this.f408364y, this.H, this.I, this.J};
    }

    protected void m() {
        if (new File(this.I).exists()) {
            this.f408350k = BitmapFactory.decodeFile(this.I);
        }
        if (this.f408350k != null) {
            this.f408351l = new Rect(0, 0, this.f408350k.getWidth(), this.f408350k.getHeight());
        }
        this.f408352m = new RectF(0.0f, 0.0f, i.c(88.0f, this.f408325c.getResources()), i.c(180.0f, this.f408325c.getResources()));
        if (new File(this.J).exists()) {
            this.f408357r = BitmapFactory.decodeFile(this.J);
        }
        if (this.f408357r != null) {
            this.f408354o = new Rect(0, 0, this.f408357r.getWidth(), this.f408357r.getHeight());
        }
        this.f408355p = new RectF(0.0f, 0.0f, i.c(77.5f, this.f408325c.getResources()), i.c(169.0f, this.f408325c.getResources()));
        this.f408353n = new Rect(0, 0, i.c(88.0f, this.f408325c.getResources()), i.c(180.0f, this.f408325c.getResources()));
        this.B = this.f408323a.a("out", 0L, 500L, 0, i.c(180.0f, this.f408325c.getResources()), new LinearInterpolator());
        this.f408348i = (int) ((this.f408352m.width() - this.f408355p.width()) / 2.0f);
        this.f408349j = (int) ((this.f408352m.height() - this.f408355p.height()) / 2.0f);
        this.f408355p = new RectF(this.f408348i, this.f408349j, r2 + i.c(77.5f, this.f408325c.getResources()), this.f408349j + i.c(169.0f, this.f408325c.getResources()));
        int i3 = this.f408348i;
        this.f408356q = new Rect(i3, this.f408349j, i.c(77.5f, this.f408325c.getResources()) + i3, this.f408349j + i.c(169.0f, this.f408325c.getResources()));
        this.C = this.f408323a.a("in", 150L, 700L, i.c(180.0f, this.f408325c.getResources()), 0, new LinearInterpolator());
        this.D = this.f408323a.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
        this.E = this.f408323a.a("SecondFont", 600L, 200L, 0, 255, new LinearInterpolator());
        this.F = this.f408323a.a("thirdLine", 700L, 200L, 0, i.c(45.0f, this.f408325c.getResources()), new LinearInterpolator());
        if (new File(this.H).exists()) {
            try {
                Typeface createFromFile = Typeface.createFromFile(this.H);
                this.G = createFromFile;
                this.f408360u.setTypeface(createFromFile);
                Paint.FontMetrics fontMetrics = this.f408360u.getFontMetrics();
                if (((int) (fontMetrics.bottom - fontMetrics.top)) <= 0) {
                    this.G = Typeface.DEFAULT;
                }
                this.f408360u.setTypeface(Typeface.DEFAULT);
            } catch (Exception unused) {
                this.G = Typeface.DEFAULT;
            }
        } else {
            this.G = Typeface.DEFAULT;
        }
        this.f408365z = l.b(this.f408363x, i.c(15.0f, this.f408325c.getResources()), -1, 0, 0, 700, 500, this.G, this.f408323a);
        this.A = l.b(this.f408364y, i.c(15.0f, this.f408325c.getResources()), -1, 0, 0, 1100, 300, this.G, this.f408323a);
        Paint paint = new Paint();
        this.f408358s = paint;
        paint.setAntiAlias(true);
        this.f408358s.setDither(true);
        this.f408358s.setColor(-1);
        Paint paint2 = new Paint();
        this.f408359t = paint2;
        paint2.setAntiAlias(true);
        this.f408359t.setDither(true);
        this.f408359t.setColor(-1);
        TextPaint textPaint = new TextPaint();
        this.f408360u = textPaint;
        textPaint.setAntiAlias(true);
        this.f408360u.setDither(true);
        this.f408360u.setColor(-1);
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return;
        }
        try {
            int c16 = i.c(8.5f, this.f408325c.getResources()) + 0;
            this.f408360u.setTypeface(this.G);
            this.f408360u.setTextSize(i.c(45.0f, this.f408325c.getResources()));
            float abs = Math.abs(this.f408360u.getFontMetrics().ascent);
            TextPaint textPaint = this.f408360u;
            String str = this.f408361v;
            this.M = textPaint.measureText(str, 0, str.length());
            this.f408360u.setAlpha(arrayList.get(this.D).intValue());
            l.a(arrayList.get(this.D).intValue(), this.f408360u);
            String str2 = this.f408361v;
            canvas.drawText(str2, 0, str2.length(), (this.f408352m.width() - this.M) / 2.0f, c16 + abs, (Paint) this.f408360u);
            int c17 = c16 + i.c(45.0f, this.f408325c.getResources()) + i.c(8.5f, this.f408325c.getResources());
            this.f408360u.setTypeface(this.G);
            this.f408360u.setTextSize(i.c(45.0f, this.f408325c.getResources()));
            this.f408360u.setShadowLayer(1.0f, 1.0f, 1.0f, -1728053248);
            float abs2 = Math.abs(this.f408360u.getFontMetrics().ascent);
            TextPaint textPaint2 = this.f408360u;
            String str3 = this.f408362w;
            this.M = textPaint2.measureText(str3, 0, str3.length());
            this.f408360u.setAlpha(arrayList.get(this.E).intValue());
            l.a(arrayList.get(this.E).intValue(), this.f408360u);
            String str4 = this.f408362w;
            canvas.drawText(str4, 0, str4.length(), (this.f408352m.width() - this.M) / 2.0f, c17 + abs2, (Paint) this.f408360u);
            int c18 = c17 + i.c(45.0f, this.f408325c.getResources()) + i.c(8.5f, this.f408325c.getResources());
            this.f408358s.setColor(-1);
            this.f408358s.setStrokeWidth(i.c(2.0f, this.f408325c.getResources()));
            this.f408358s.setStyle(Paint.Style.FILL_AND_STROKE);
            int width = (int) ((this.f408352m.width() - this.M) / 2.0f);
            l.a(arrayList.get(this.F).intValue(), this.f408358s);
            if (arrayList.get(this.F).intValue() == i.c(45.0f, this.f408325c.getResources())) {
                this.f408358s.setShadowLayer(1.0f, 1.0f, 1.0f, -1728053248);
            } else {
                this.f408358s.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
            }
            float f16 = c18;
            canvas.drawLine(width, f16, width + arrayList.get(this.F).intValue(), f16, this.f408358s);
            int c19 = c18 + i.c(8.5f, this.f408325c.getResources());
            Iterator<h> it = this.f408365z.f408372g.iterator();
            while (it.hasNext()) {
                h next = it.next();
                Bitmap bitmap = next.f408319a;
                TextPaint textPaint3 = this.f408365z.f408366a;
                textPaint3.setAlpha(arrayList.get(next.f408321c).intValue());
                String str5 = this.f408363x;
                this.M = textPaint3.measureText(str5, 0, str5.length());
                float width2 = (this.f408352m.width() - this.M) / 2.0f;
                l lVar = this.f408365z;
                canvas.drawBitmap(bitmap, width2 + lVar.f408367b + next.f408320b, lVar.f408368c + c19, textPaint3);
            }
            int c26 = c19 + i.c(14.0f, this.f408325c.getResources()) + i.c(8.5f, this.f408325c.getResources());
            Iterator<h> it5 = this.A.f408372g.iterator();
            while (it5.hasNext()) {
                h next2 = it5.next();
                Bitmap bitmap2 = next2.f408319a;
                TextPaint textPaint4 = this.A.f408366a;
                textPaint4.setAlpha(arrayList.get(next2.f408321c).intValue());
                String str6 = this.f408364y;
                this.M = textPaint4.measureText(str6, 0, str6.length());
                float width3 = (this.f408352m.width() - this.M) / 2.0f;
                l lVar2 = this.A;
                canvas.drawBitmap(bitmap2, width3 + lVar2.f408367b + next2.f408320b, lVar2.f408368c + c26, textPaint4);
            }
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight(), this.f408358s, 31);
            Bitmap bitmap3 = this.f408350k;
            if (bitmap3 != null) {
                canvas.drawBitmap(bitmap3, this.f408351l, this.f408352m, this.f408358s);
            }
            this.f408358s.setXfermode(this.K);
            this.f408358s.setColor(SupportMenu.CATEGORY_MASK);
            this.f408358s.setStyle(Paint.Style.FILL_AND_STROKE);
            this.f408353n.set(0, arrayList.get(this.B).intValue(), i.c(88.0f, this.f408325c.getResources()), i.c(180.0f, this.f408325c.getResources()));
            canvas.drawRect(this.f408353n, this.f408358s);
            this.f408358s.setXfermode(null);
            canvas.restoreToCount(saveLayer);
            int saveLayer2 = canvas.saveLayer(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight(), this.f408359t, 31);
            Bitmap bitmap4 = this.f408357r;
            if (bitmap4 != null) {
                canvas.drawBitmap(bitmap4, this.f408354o, this.f408355p, this.f408359t);
            }
            this.f408359t.setXfermode(this.L);
            this.f408359t.setColor(SupportMenu.CATEGORY_MASK);
            this.f408359t.setStyle(Paint.Style.FILL_AND_STROKE);
            Rect rect = this.f408356q;
            int i3 = this.f408348i;
            rect.set(i3, this.f408349j, i.c(77.5f, this.f408325c.getResources()) + i3, this.f408349j + arrayList.get(this.C).intValue());
            canvas.drawRect(this.f408356q, this.f408359t);
            this.f408359t.setXfermode(null);
            canvas.restoreToCount(saveLayer2);
        } catch (Exception e16) {
            StringBuilder sb5 = new StringBuilder(128);
            Iterator<Integer> it6 = arrayList.iterator();
            while (it6.hasNext()) {
                sb5.append(it6.next());
                sb5.append(" ");
            }
            QLog.e("LunaInfoStickerDrawable", 1, "mFourthLineInfo draw fail, " + sb5.toString(), e16);
        }
    }
}
