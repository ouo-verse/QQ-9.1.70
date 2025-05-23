package ir;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class g extends i {

    /* renamed from: i, reason: collision with root package name */
    private String f408312i;

    /* renamed from: j, reason: collision with root package name */
    private TextPaint f408313j;

    /* renamed from: k, reason: collision with root package name */
    int f408314k;

    /* renamed from: l, reason: collision with root package name */
    int f408315l;

    /* renamed from: m, reason: collision with root package name */
    int f408316m;

    /* renamed from: n, reason: collision with root package name */
    int f408317n;

    /* renamed from: o, reason: collision with root package name */
    int f408318o;

    public g(Context context, String str) {
        super(context, str);
        this.f408312i = "15:29";
        this.f408313j = new TextPaint();
        this.f408314k = 0;
        this.f408315l = 0;
        this.f408316m = 0;
        this.f408317n = 0;
        k(str);
        n();
        b();
    }

    public static String l(int i3, String str) {
        String str2;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("first_line", str);
            str2 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("FilmDigitInfoStickerDrawable", 2, e16, new Object[0]);
            }
            str2 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("FilmDigitInfoStickerDrawable", 2, str2);
        }
        return str2;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408315l;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408314k;
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
            String optString = jSONObject.optString("first_line", "");
            if (optString.contains("\u00b7")) {
                optString = optString.substring(0, optString.indexOf("\u00b7"));
            }
            this.f408312i = ChnToSpell.d(optString, 1);
        }
        return new String[]{this.f408312i};
    }

    public String m() {
        return this.f408312i;
    }

    protected void n() {
        TextPaint textPaint = new TextPaint();
        this.f408313j = textPaint;
        textPaint.setAntiAlias(true);
        this.f408313j.setDither(true);
        this.f408313j.setColor(this.f408325c.getResources().getColor(R.color.afx));
        this.f408313j.setTypeface(Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/dov_digital.ttf"));
        this.f408313j.setTextSize(i.c(30.0f, this.f408325c.getResources()));
        Paint.FontMetrics fontMetrics = this.f408313j.getFontMetrics();
        this.f408317n = (int) (fontMetrics.bottom - fontMetrics.top);
        TextPaint textPaint2 = this.f408313j;
        String str = this.f408312i;
        int measureText = (int) textPaint2.measureText(str, 0, str.length());
        this.f408316m = measureText;
        this.f408314k = measureText + i.c(7.0f, this.f408325c.getResources());
        this.f408315l = i.c(30.0f, this.f408325c.getResources()) + i.c(10.0f, this.f408325c.getResources());
        this.f408318o = this.f408323a.a("anim", 0L, 1000L, 0, 999, new LinearInterpolator());
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicWidth(), this.f408313j, 31);
        int c16 = i.c(2.0f, this.f408325c.getResources());
        float abs = Math.abs(this.f408313j.getFontMetrics().ascent);
        this.f408313j.setShadowLayer((((arrayList.get(this.f408318o).intValue() % 100) * 1.0f) / 99.0f) * 20.0f, 0.0f, 0.0f, this.f408325c.getResources().getColor(R.color.afy));
        canvas.drawText(this.f408312i, i.c(7.0f, this.f408325c.getResources()), c16 + abs, this.f408313j);
        canvas.restoreToCount(saveLayer);
    }
}
