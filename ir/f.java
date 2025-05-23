package ir;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.animation.DecelerateInterpolator;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f extends i {

    /* renamed from: x, reason: collision with root package name */
    private static int f408295x = 30;

    /* renamed from: y, reason: collision with root package name */
    private static int f408296y = 30;

    /* renamed from: i, reason: collision with root package name */
    private Paint f408297i;

    /* renamed from: j, reason: collision with root package name */
    private TextPaint f408298j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f408299k;

    /* renamed from: l, reason: collision with root package name */
    private int f408300l;

    /* renamed from: m, reason: collision with root package name */
    private int f408301m;

    /* renamed from: n, reason: collision with root package name */
    private Typeface f408302n;

    /* renamed from: o, reason: collision with root package name */
    private int f408303o;

    /* renamed from: p, reason: collision with root package name */
    private int f408304p;

    /* renamed from: q, reason: collision with root package name */
    private String f408305q;

    /* renamed from: r, reason: collision with root package name */
    private String f408306r;

    /* renamed from: s, reason: collision with root package name */
    private int f408307s;

    /* renamed from: t, reason: collision with root package name */
    private int f408308t;

    /* renamed from: u, reason: collision with root package name */
    private Rect f408309u;

    /* renamed from: v, reason: collision with root package name */
    private int f408310v;

    /* renamed from: w, reason: collision with root package name */
    private int f408311w;

    public f(Context context, String str) {
        super(context, str);
        this.f408297i = new Paint();
        this.f408298j = new TextPaint();
        this.f408300l = 0;
        this.f408301m = 0;
        this.f408302n = null;
        this.f408305q = "";
        this.f408307s = 0;
        this.f408308t = 0;
        this.f408309u = new Rect(0, 0, 0, 0);
        this.f408310v = 16;
        this.f408311w = 16;
        k(this.f408326d);
        n();
        b();
    }

    public static String l(int i3, String str, String str2) {
        String str3;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("iconpath", str);
            jSONObject.put("locationString", str2);
            str3 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("ExpandLocationStickerDrawable", 2, e16, new Object[0]);
            }
            str3 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ExpandLocationStickerDrawable", 2, str3);
        }
        return str3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408301m;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408300l;
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int i3 = 0;
        int i16 = f408295x + 0;
        int i17 = f408296y;
        int intValue = arrayList.get(this.f408303o).intValue();
        int length = i17 + (((this.f408306r.length() - 1) * (this.f408310v - intValue)) / 2);
        int intValue2 = arrayList.get(this.f408304p).intValue();
        this.f408297i.setAlpha(intValue2);
        this.f408298j.setAlpha(intValue2);
        l.a(intValue2, this.f408298j);
        Rect rect = new Rect(length, i.c(1.0f, this.f408325c.getResources()) + i16, this.f408308t + length, this.f408307s + i16 + i.c(1.0f, this.f408325c.getResources()));
        Bitmap bitmap = this.f408299k;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, this.f408309u, rect, this.f408297i);
        }
        int i18 = length + this.f408308t + this.f408311w;
        while (i3 < this.f408306r.length()) {
            int i19 = i3 + 1;
            String substring = this.f408306r.substring(i3, i19);
            canvas.drawText(substring, i18, this.f408307s + i16, this.f408298j);
            i18 = i18 + ((int) this.f408298j.measureText(substring)) + intValue;
            i3 = i19;
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
            this.f408305q = jSONObject.optString("iconpath", "");
            this.f408306r = jSONObject.optString("locationString", "");
        }
        return new String[]{this.f408305q, this.f408306r};
    }

    public String m() {
        return this.f408305q;
    }

    protected void n() {
        int i3;
        int i16;
        this.f408297i.setAntiAlias(true);
        this.f408297i.setDither(true);
        int c16 = i.c(15.0f, this.f408325c.getResources());
        f408295x = c16;
        f408296y = c16;
        this.f408311w = i.c(10.0f, this.f408325c.getResources());
        this.f408298j.setAntiAlias(true);
        this.f408298j.setDither(true);
        this.f408298j.setColor(-1);
        this.f408310v = i.c(9.0f, this.f408325c.getResources());
        String l3 = com.tencent.aelight.camera.aioeditor.capture.util.d.l(this.f408306r);
        this.f408306r = l3;
        if (l3 != null && !TextUtils.isEmpty(l3)) {
            String d16 = ChnToSpell.d(this.f408306r, 1);
            this.f408306r = d16;
            this.f408306r = d16.toUpperCase();
        } else {
            this.f408306r = "YOUR CITY";
        }
        Typeface createFromAsset = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
        this.f408302n = createFromAsset;
        this.f408298j.setTypeface(createFromAsset);
        this.f408298j.setFakeBoldText(true);
        this.f408298j.setTextSize(i.c(15.0f, this.f408325c.getResources()));
        Paint.FontMetrics fontMetrics = this.f408298j.getFontMetrics();
        this.f408298j.setLetterSpacing(0.0f);
        this.f408303o = this.f408323a.a("X", 190L, 630L, 0, this.f408310v, new DecelerateInterpolator());
        this.f408304p = this.f408323a.a("T", 190L, 2110L, 0, 255, new DecelerateInterpolator());
        if (FileUtils.fileExists(this.f408305q)) {
            this.f408299k = BitmapFactory.decodeFile(this.f408305q);
        } else {
            QLog.e("ExpandLocationStickerDrawable", 2, "mIconPath not exist");
        }
        Bitmap bitmap = this.f408299k;
        if (bitmap != null) {
            i3 = bitmap.getWidth();
            i16 = this.f408299k.getHeight();
        } else {
            i3 = 0;
            i16 = 0;
        }
        this.f408309u = new Rect(0, 0, i3, i16);
        int c17 = ((-((int) fontMetrics.ascent)) - ((int) fontMetrics.descent)) + i.c(3.0f, this.f408325c.getResources());
        this.f408307s = c17;
        if (i16 != 0) {
            this.f408308t = (i3 * c17) / i16;
        }
        this.f408301m = c17 + (f408295x * 2);
        this.f408300l = this.f408308t + (f408296y * 2) + this.f408311w + ((int) this.f408298j.measureText(this.f408306r)) + (this.f408310v * (this.f408306r.length() - 1)) + i.c(3.0f, this.f408325c.getResources());
    }
}
