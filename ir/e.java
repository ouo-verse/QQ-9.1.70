package ir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class e extends i {
    private RectF A;
    Bitmap B;
    Paint C;
    TextPaint D;

    /* renamed from: i, reason: collision with root package name */
    private String f408277i;

    /* renamed from: j, reason: collision with root package name */
    private String f408278j;

    /* renamed from: k, reason: collision with root package name */
    private int f408279k;

    /* renamed from: l, reason: collision with root package name */
    private int f408280l;

    /* renamed from: m, reason: collision with root package name */
    private int f408281m;

    /* renamed from: n, reason: collision with root package name */
    private int f408282n;

    /* renamed from: o, reason: collision with root package name */
    private int f408283o;

    /* renamed from: p, reason: collision with root package name */
    private int f408284p;

    /* renamed from: q, reason: collision with root package name */
    private int f408285q;

    /* renamed from: r, reason: collision with root package name */
    private int f408286r;

    /* renamed from: s, reason: collision with root package name */
    private int f408287s;

    /* renamed from: t, reason: collision with root package name */
    private int f408288t;

    /* renamed from: u, reason: collision with root package name */
    private int f408289u;

    /* renamed from: v, reason: collision with root package name */
    private Typeface f408290v;

    /* renamed from: w, reason: collision with root package name */
    private Typeface f408291w;

    /* renamed from: x, reason: collision with root package name */
    private String f408292x;

    /* renamed from: y, reason: collision with root package name */
    private String f408293y;

    /* renamed from: z, reason: collision with root package name */
    private Rect f408294z;

    public e(Context context, String str) {
        super(context, str);
        this.f408277i = HardCodeUtil.qqStr(R.string.f169911y94);
        this.f408278j = "DEC 06 15:39";
        this.f408279k = 0;
        this.f408280l = 0;
        this.f408281m = 0;
        this.f408282n = 0;
        this.f408283o = 0;
        this.f408284p = 0;
        this.f408285q = 0;
        this.f408286r = 0;
        this.f408287s = 0;
        this.f408288t = 0;
        this.f408289u = 0;
        this.f408290v = null;
        this.f408291w = null;
        this.f408292x = null;
        this.f408293y = null;
        this.B = null;
        this.C = null;
        this.D = null;
        k(str);
        p();
        b();
    }

    public static String l(int i3, String str, String str2, String str3, String str4) {
        String str5;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("first_line", str);
            jSONObject.put("second_line", str2);
            jSONObject.put("icon_path", str3);
            jSONObject.put("font_path", str4);
            str5 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("EaseInLocationStickerDrawable", 2, e16, new Object[0]);
            }
            str5 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EaseInLocationStickerDrawable", 2, str5);
        }
        return str5;
    }

    private int m(int i3) {
        return (this.f408280l - i3) / 2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408281m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408280l;
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int e16 = e(this.f408324b, this.f408286r, 255);
        this.C.setAlpha(e16);
        this.A.set(m((int) this.A.width()), 0.0f, r0 + i.c(8.5f, this.f408325c.getResources()), i.c(11.5f, this.f408325c.getResources()));
        l.a(e16, this.C);
        canvas.drawBitmap(this.B, this.f408294z, this.A, this.C);
        int height = this.B.getHeight() + i.c(6.0f, this.f408325c.getResources());
        this.D.setTypeface(this.f408290v);
        int e17 = e(this.f408324b, this.f408287s, 255);
        this.D.setAlpha(e17);
        this.D.setTextSize(i.c(16.0f, this.f408325c.getResources()));
        float abs = Math.abs(this.D.getFontMetrics().ascent);
        l.a(e17, this.D);
        canvas.drawText(this.f408277i, m(this.f408282n), height + abs, this.D);
        int c16 = height + i.c(16.0f, this.f408325c.getResources());
        int e18 = e(this.f408324b, this.f408289u, 255);
        int c17 = c16 + i.c(6.0f, this.f408325c.getResources());
        this.C.setAlpha(e18);
        l.a(e18, this.D);
        float f16 = c17;
        canvas.drawLine(m(this.f408279k), f16, m(this.f408279k) + this.f408279k, f16, this.C);
        int e19 = e(this.f408324b, this.f408288t, 255);
        int c18 = c17 + i.c(6.0f, this.f408325c.getResources());
        this.D.setTypeface(this.f408291w);
        this.D.setAlpha(e19);
        this.D.setTextSize(i.c(9.0f, this.f408325c.getResources()));
        float abs2 = Math.abs(this.D.getFontMetrics().ascent);
        l.a(e19, this.D);
        canvas.drawText(this.f408278j, m(this.f408284p), c18 + abs2, this.D);
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
            this.f408277i = jSONObject.optString("first_line", "");
            this.f408278j = jSONObject.optString("second_line", "");
            this.f408292x = jSONObject.optString("font_path", "");
            this.f408293y = jSONObject.optString("icon_path", "");
        }
        return new String[]{this.f408277i, this.f408278j, this.f408292x, this.f408293y};
    }

    public String n() {
        return this.f408292x;
    }

    public String o() {
        return this.f408293y;
    }

    protected void p() {
        Paint paint = new Paint();
        this.C = paint;
        paint.setAntiAlias(true);
        this.C.setDither(true);
        this.C.setColor(-1);
        if (new File(this.f408293y).exists()) {
            this.B = BitmapFactory.decodeFile(this.f408293y);
        }
        if (this.B == null) {
            this.B = BitmapFactory.decodeResource(this.f408325c.getResources(), R.drawable.cqa);
        }
        TextPaint textPaint = new TextPaint();
        this.D = textPaint;
        textPaint.setAntiAlias(true);
        this.D.setDither(true);
        this.D.setColor(-1);
        this.f408279k = i.c(36.0f, this.f408325c.getResources());
        this.D.setTextSize(i.c(16.0f, this.f408325c.getResources()));
        TextPaint textPaint2 = this.D;
        String str = this.f408277i;
        this.f408282n = (int) textPaint2.measureText(str, 0, str.length());
        this.f408283o = i.c(36.0f, this.f408325c.getResources());
        this.D.setTextSize(i.c(9.0f, this.f408325c.getResources()));
        TextPaint textPaint3 = this.D;
        String str2 = this.f408278j;
        this.f408284p = (int) textPaint3.measureText(str2, 0, str2.length());
        this.f408285q = i.c(9.0f, this.f408325c.getResources());
        this.f408294z = new Rect(0, 0, this.B.getWidth(), this.B.getHeight());
        this.A = new RectF(0.0f, 0.0f, i.c(8.5f, this.f408325c.getResources()), i.c(11.5f, this.f408325c.getResources()));
        this.f408280l = Math.max(Math.max(this.f408279k, this.f408282n), this.f408284p);
        this.f408281m = (int) (this.A.height() + this.f408283o + this.f408285q + i.c(19.0f, this.f408325c.getResources()));
        this.f408291w = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
        if (new File(this.f408292x).exists()) {
            try {
                this.f408290v = Typeface.createFromFile(this.f408292x);
            } catch (RuntimeException e16) {
                QLog.e("EaseInLocationStickerDrawable", 1, "createFromFile fail, ", e16);
                this.f408290v = Typeface.DEFAULT_BOLD;
            }
        } else {
            this.f408290v = Typeface.DEFAULT_BOLD;
        }
        this.f408286r = this.f408323a.a("iconAlpha", 20L, 230L, 0, 255, new LinearInterpolator());
        this.f408287s = this.f408323a.a("firstLineAlpha", 120L, 230L, 0, 255, new LinearInterpolator());
        this.f408289u = this.f408323a.a("lineAlpha", 220L, 230L, 0, 255, new LinearInterpolator());
        this.f408288t = this.f408323a.a("secondLineAlpha", 330L, 230L, 0, 255, new LinearInterpolator());
    }
}
