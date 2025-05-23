package ir;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import androidx.core.internal.view.SupportMenu;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class d extends i {
    private float A;
    private float B;

    /* renamed from: i, reason: collision with root package name */
    private Paint f408259i;

    /* renamed from: j, reason: collision with root package name */
    private TextPaint f408260j;

    /* renamed from: k, reason: collision with root package name */
    private Rect f408261k;

    /* renamed from: l, reason: collision with root package name */
    private int f408262l;

    /* renamed from: m, reason: collision with root package name */
    private int f408263m;

    /* renamed from: n, reason: collision with root package name */
    private PorterDuffXfermode f408264n;

    /* renamed from: o, reason: collision with root package name */
    private Path f408265o;

    /* renamed from: p, reason: collision with root package name */
    private Typeface f408266p;

    /* renamed from: q, reason: collision with root package name */
    private Typeface f408267q;

    /* renamed from: r, reason: collision with root package name */
    private int f408268r;

    /* renamed from: s, reason: collision with root package name */
    private int f408269s;

    /* renamed from: t, reason: collision with root package name */
    private int f408270t;

    /* renamed from: u, reason: collision with root package name */
    private int f408271u;

    /* renamed from: v, reason: collision with root package name */
    private int f408272v;

    /* renamed from: w, reason: collision with root package name */
    private int f408273w;

    /* renamed from: x, reason: collision with root package name */
    private String f408274x;

    /* renamed from: y, reason: collision with root package name */
    private String f408275y;

    /* renamed from: z, reason: collision with root package name */
    private String f408276z;

    public d(Context context, String str) {
        super(context, str);
        this.f408259i = new Paint();
        this.f408260j = new TextPaint();
        this.f408261k = new Rect();
        this.f408262l = 0;
        this.f408263m = 0;
        this.f408264n = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f408265o = new Path();
        this.f408266p = null;
        this.f408267q = null;
        this.f408274x = "27";
        this.f408275y = "OCT";
        this.f408276z = "2017";
        this.A = 0.0f;
        this.B = 0.0f;
        k(this.f408326d);
        m();
        b();
    }

    public static String l(int i3, String str, String str2, String str3) {
        String str4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("first_line", str);
            jSONObject.put("second_line", str2);
            jSONObject.put("third_line", str3);
            str4 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("EaseInInfoStickerDrawable", 2, e16, new Object[0]);
            }
            str4 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("EaseInInfoStickerDrawable", 2, str4);
        }
        return str4;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408263m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408262l;
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
            this.f408274x = jSONObject.optString("first_line", "");
            this.f408275y = jSONObject.optString("second_line", "");
            this.f408276z = jSONObject.optString("third_line", "");
        }
        return new String[]{this.f408274x, this.f408275y, this.f408276z};
    }

    protected void m() {
        Paint paint = new Paint();
        this.f408259i = paint;
        paint.setAntiAlias(true);
        this.f408259i.setDither(true);
        this.f408259i.setColor(-1);
        TextPaint textPaint = new TextPaint();
        this.f408260j = textPaint;
        textPaint.setAntiAlias(true);
        this.f408260j.setDither(true);
        this.f408260j.setColor(-1);
        this.f408262l = i.c(70.0f, this.f408325c.getResources());
        this.f408263m = i.c(130.0f, this.f408325c.getResources());
        this.f408261k = new Rect(0, 0, this.f408262l, this.f408263m);
        try {
            this.f408266p = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-medium.ttf");
        } catch (Exception unused) {
            this.f408266p = Typeface.DEFAULT;
        }
        try {
            this.f408267q = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
        } catch (Exception unused2) {
            this.f408267q = Typeface.DEFAULT;
        }
        this.f408272v = this.f408323a.a("X", 0L, 700L, -this.f408261k.width(), this.f408261k.width(), new LinearInterpolator());
        this.f408273w = this.f408323a.a("Y", 0L, 700L, -this.f408261k.height(), this.f408261k.height(), new LinearInterpolator());
        this.f408268r = this.f408323a.a("firstFont", 500L, 200L, 0, 255, new LinearInterpolator());
        this.A = i.c(10.0f, this.f408325c.getResources());
        this.f408269s = this.f408323a.a("secondLine", 600L, 400L, 0, (int) (this.f408261k.width() - (this.A * 2.0f)), new LinearInterpolator());
        this.f408270t = this.f408323a.a("thirdFont", 800L, 500L, 0, 255, new LinearInterpolator());
        this.f408271u = this.f408323a.a("fourthFont", 900L, 500L, 0, 255, new LinearInterpolator());
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int c16 = i.c(8.5f, this.f408325c.getResources()) + 0;
        this.f408260j.setTypeface(this.f408266p);
        this.f408260j.setTextSize(i.c(49.0f, this.f408325c.getResources()));
        float abs = Math.abs(this.f408260j.getFontMetrics().ascent);
        this.f408260j.setLetterSpacing(0.0f);
        TextPaint textPaint = this.f408260j;
        String str = this.f408274x;
        this.B = textPaint.measureText(str, 0, str.length());
        this.f408260j.setAlpha(arrayList.get(this.f408268r).intValue());
        l.a(arrayList.get(this.f408268r).intValue(), this.f408260j);
        String str2 = this.f408274x;
        canvas.drawText(str2, 0, str2.length(), (this.f408261k.width() - this.B) / 2.0f, c16 + abs, (Paint) this.f408260j);
        int c17 = c16 + i.c(49.0f, this.f408325c.getResources()) + i.c(12.5f, this.f408325c.getResources());
        this.f408259i.setColor(-1);
        this.f408259i.setStrokeWidth(i.c(2.0f, this.f408325c.getResources()));
        this.f408259i.setStyle(Paint.Style.FILL_AND_STROKE);
        float f16 = this.A;
        float f17 = c17;
        canvas.drawLine(f16, f17, f16 + arrayList.get(this.f408269s).intValue(), f17, this.f408259i);
        if (arrayList.get(this.f408269s).intValue() == ((int) (this.f408261k.width() - (this.A * 2.0f)))) {
            this.f408259i.setShadowLayer(1.0f, 1.0f, 1.0f, -1728053248);
        } else {
            this.f408259i.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
        }
        int c18 = c17 + i.c(10.0f, this.f408325c.getResources());
        this.f408260j.setTextSize(i.c(19.0f, this.f408325c.getResources()));
        float abs2 = Math.abs(this.f408260j.getFontMetrics().ascent);
        this.f408260j.setLetterSpacing(0.1f);
        TextPaint textPaint2 = this.f408260j;
        String str3 = this.f408275y;
        this.B = textPaint2.measureText(str3, 0, str3.length());
        this.f408260j.setTypeface(this.f408267q);
        this.f408260j.setTextSize(i.c(19.0f, this.f408325c.getResources()));
        this.f408260j.setAlpha(arrayList.get(this.f408270t).intValue());
        l.a(arrayList.get(this.f408270t).intValue(), this.f408260j);
        String str4 = this.f408275y;
        canvas.drawText(str4, 0, str4.length(), (this.f408261k.width() - this.B) / 2.0f, c18 + abs2, (Paint) this.f408260j);
        int c19 = c18 + i.c(10.0f, this.f408325c.getResources()) + i.c(9.0f, this.f408325c.getResources());
        this.f408260j.setTypeface(this.f408267q);
        this.f408260j.setTextSize(i.c(19.0f, this.f408325c.getResources()));
        float abs3 = Math.abs(this.f408260j.getFontMetrics().ascent);
        this.f408260j.setLetterSpacing(0.0f);
        TextPaint textPaint3 = this.f408260j;
        String str5 = this.f408276z;
        this.B = textPaint3.measureText(str5, 0, str5.length());
        this.f408260j.setAlpha(arrayList.get(this.f408271u).intValue());
        l.a(arrayList.get(this.f408271u).intValue(), this.f408260j);
        String str6 = this.f408276z;
        canvas.drawText(str6, 0, str6.length(), (this.f408261k.width() - this.B) / 2.0f, c19 + abs3, (Paint) this.f408260j);
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, this.f408261k.width(), this.f408261k.height(), this.f408259i, 31);
        this.f408259i.setStyle(Paint.Style.STROKE);
        this.f408259i.setStrokeWidth(i.c(3.0f, this.f408325c.getResources()));
        canvas.drawRect(this.f408261k, this.f408259i);
        this.f408259i.setXfermode(this.f408264n);
        this.f408259i.setColor(SupportMenu.CATEGORY_MASK);
        this.f408259i.setStrokeWidth(i.c(3.0f, this.f408325c.getResources()));
        this.f408259i.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f408265o.reset();
        this.f408265o.moveTo(this.f408261k.width(), this.f408261k.height());
        this.f408265o.lineTo(this.f408261k.width(), arrayList.get(this.f408273w).intValue());
        this.f408265o.lineTo(arrayList.get(this.f408272v).intValue(), this.f408261k.height());
        this.f408265o.close();
        if (this.f408261k.width() == this.f408272v && this.f408261k.height() == this.f408273w) {
            this.f408259i.setShadowLayer(1.0f, 1.0f, 1.0f, -1728053248);
        } else {
            this.f408259i.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
        }
        canvas.drawPath(this.f408265o, this.f408259i);
        this.f408259i.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }
}
