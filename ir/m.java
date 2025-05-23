package ir;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class m extends i {

    /* renamed from: i, reason: collision with root package name */
    private String f408374i;

    /* renamed from: j, reason: collision with root package name */
    private String f408375j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f408376k;

    /* renamed from: l, reason: collision with root package name */
    private TextPaint f408377l;

    /* renamed from: m, reason: collision with root package name */
    l f408378m;

    /* renamed from: n, reason: collision with root package name */
    l f408379n;

    /* renamed from: o, reason: collision with root package name */
    int f408380o;

    public m(Context context, String str) {
        super(context, str);
        this.f408374i = "05:36";
        this.f408375j = "2017 SEPTEMBER 30";
        this.f408376k = new Paint();
        this.f408377l = new TextPaint();
        this.f408380o = 0;
        k(str);
        n();
        b();
    }

    private l l(CharSequence charSequence, int i3, int i16, int i17, int i18, int i19, int i26, Typeface typeface, a aVar, int i27) {
        l lVar = new l(i3, i16, typeface, i17, i18, i19, i26);
        lVar.d(charSequence, aVar, i27);
        return lVar;
    }

    public static String m(int i3, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("first_line", str);
            jSONObject.put("second_line", str2);
            str3 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("RandomTextDrawable", 2, e16, new Object[0]);
            }
            str3 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("RandomTextDrawable", 2, str3);
        }
        return str3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return i.c(75.0f, this.f408325c.getResources());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408378m.f408371f;
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
            this.f408374i = jSONObject.optString("first_line", "");
            this.f408375j = jSONObject.optString("second_line", "");
        }
        return new String[]{this.f408374i, this.f408375j};
    }

    protected void n() {
        Typeface typeface;
        Typeface typeface2;
        Paint paint = new Paint();
        this.f408376k = paint;
        paint.setAntiAlias(true);
        this.f408376k.setDither(true);
        this.f408376k.setColor(-1);
        TextPaint textPaint = new TextPaint();
        this.f408377l = textPaint;
        textPaint.setAntiAlias(true);
        this.f408377l.setDither(true);
        this.f408377l.setColor(-1);
        AssetManager assets = this.f408325c.getAssets();
        try {
            typeface = Typeface.createFromAsset(assets, "info_sticker_typeface/roboto-medium.ttf");
        } catch (Exception unused) {
            typeface = Typeface.DEFAULT;
        }
        Typeface typeface3 = typeface;
        try {
            typeface2 = Typeface.createFromAsset(assets, "info_sticker_typeface/roboto-regular.ttf");
        } catch (Exception unused2) {
            typeface2 = Typeface.DEFAULT;
        }
        Typeface typeface4 = typeface2;
        l l3 = l(this.f408374i, i.c(48.0f, this.f408325c.getResources()), -1, 0, 0, 0, 600, typeface3, this.f408323a, 0);
        this.f408378m = l3;
        this.f408380o = this.f408323a.a("", 300L, 500L, 0, l3.f408371f, new LinearInterpolator());
        this.f408379n = l(this.f408375j, i.c(11.0f, this.f408325c.getResources()), -1, 0, i.c(60.0f, this.f408325c.getResources()), 500, 800, typeface4, this.f408323a, this.f408378m.f408371f - 10);
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        if (arrayList == null) {
            return;
        }
        Iterator<h> it = this.f408378m.f408372g.iterator();
        while (it.hasNext()) {
            h next = it.next();
            Bitmap bitmap = next.f408319a;
            TextPaint textPaint = this.f408378m.f408366a;
            textPaint.setAlpha(this.f408324b.get(next.f408321c).intValue());
            l lVar = this.f408378m;
            canvas.drawBitmap(bitmap, lVar.f408367b + next.f408320b, lVar.f408368c, textPaint);
        }
        this.f408376k.setStrokeWidth(i.c(2.0f, this.f408325c.getResources()));
        float c16 = i.c(55.0f, this.f408325c.getResources());
        canvas.drawLine(0.0f, c16, this.f408324b.get(this.f408380o).intValue(), c16, this.f408376k);
        Iterator<h> it5 = this.f408379n.f408372g.iterator();
        while (it5.hasNext()) {
            h next2 = it5.next();
            Bitmap bitmap2 = next2.f408319a;
            TextPaint textPaint2 = this.f408379n.f408366a;
            textPaint2.setAlpha(this.f408324b.get(next2.f408321c).intValue());
            l lVar2 = this.f408379n;
            canvas.drawBitmap(bitmap2, lVar2.f408367b + next2.f408320b, lVar2.f408368c, textPaint2);
        }
    }
}
