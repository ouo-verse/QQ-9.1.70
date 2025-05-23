package ir;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Typeface;
import android.graphics.Xfermode;
import android.text.TextPaint;
import android.view.animation.LinearInterpolator;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes38.dex */
public class j extends i {

    /* renamed from: i, reason: collision with root package name */
    private String f408332i;

    /* renamed from: j, reason: collision with root package name */
    private String f408333j;

    /* renamed from: k, reason: collision with root package name */
    private Paint f408334k;

    /* renamed from: l, reason: collision with root package name */
    private TextPaint f408335l;

    /* renamed from: m, reason: collision with root package name */
    private Xfermode f408336m;

    /* renamed from: n, reason: collision with root package name */
    private Typeface f408337n;

    /* renamed from: o, reason: collision with root package name */
    private Typeface f408338o;

    /* renamed from: p, reason: collision with root package name */
    private String f408339p;

    /* renamed from: q, reason: collision with root package name */
    int f408340q;

    /* renamed from: r, reason: collision with root package name */
    int f408341r;

    /* renamed from: s, reason: collision with root package name */
    int f408342s;

    /* renamed from: t, reason: collision with root package name */
    int f408343t;

    /* renamed from: u, reason: collision with root package name */
    int f408344u;

    /* renamed from: v, reason: collision with root package name */
    int f408345v;

    /* renamed from: w, reason: collision with root package name */
    int f408346w;

    /* renamed from: x, reason: collision with root package name */
    int f408347x;

    public j(Context context, String str) {
        super(context, str);
        this.f408332i = "15:29";
        this.f408333j = HardCodeUtil.qqStr(R.string.y99);
        this.f408334k = new Paint();
        this.f408335l = new TextPaint();
        this.f408336m = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        this.f408337n = null;
        this.f408338o = null;
        this.f408339p = null;
        this.f408340q = 0;
        this.f408341r = 0;
        this.f408342s = 0;
        this.f408343t = 0;
        this.f408344u = 0;
        this.f408345v = 0;
        this.f408346w = 0;
        this.f408347x = 0;
        k(str);
        o();
        b();
    }

    public static String l(int i3, String str, String str2, String str3) {
        String str4;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", i3);
            jSONObject.put("first_line", str);
            jSONObject.put("second_line", str2);
            jSONObject.put("font_path", str3);
            str4 = jSONObject.toString();
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("Left2RightInfoStickerDrawable", 2, e16, new Object[0]);
            }
            str4 = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("Left2RightInfoStickerDrawable", 2, str4);
        }
        return str4;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f408341r;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f408340q;
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
            this.f408332i = jSONObject.optString("first_line", "");
            this.f408333j = jSONObject.optString("second_line", "");
            this.f408339p = jSONObject.optString("font_path", "");
        }
        return new String[]{this.f408332i, this.f408333j, this.f408339p};
    }

    public String m() {
        return this.f408332i;
    }

    public String n() {
        return this.f408339p;
    }

    protected void o() {
        Paint paint = new Paint();
        this.f408334k = paint;
        paint.setAntiAlias(true);
        this.f408334k.setDither(true);
        this.f408334k.setStrokeWidth(i.c(2.0f, this.f408325c.getResources()));
        this.f408334k.setStrokeCap(Paint.Cap.ROUND);
        this.f408334k.setColor(-15322);
        TextPaint textPaint = new TextPaint();
        this.f408335l = textPaint;
        textPaint.setAntiAlias(true);
        this.f408335l.setDither(true);
        this.f408335l.setColor(-1);
        this.f408338o = Typeface.createFromAsset(this.f408325c.getResources().getAssets(), "info_sticker_typeface/roboto-regular.ttf");
        if (new File(this.f408339p).exists()) {
            try {
                this.f408337n = Typeface.createFromFile(this.f408339p);
            } catch (Exception unused) {
                this.f408337n = Typeface.DEFAULT_BOLD;
            }
        } else {
            this.f408337n = Typeface.DEFAULT_BOLD;
        }
        this.f408335l.setTextSize(i.c(30.0f, this.f408325c.getResources()));
        Paint.FontMetrics fontMetrics = this.f408335l.getFontMetrics();
        this.f408343t = (int) (fontMetrics.bottom - fontMetrics.top);
        TextPaint textPaint2 = this.f408335l;
        String str = this.f408332i;
        this.f408342s = (int) textPaint2.measureText(str, 0, str.length());
        this.f408335l.setTextSize(i.c(12.0f, this.f408325c.getResources()));
        Paint.FontMetrics fontMetrics2 = this.f408335l.getFontMetrics();
        this.f408345v = (int) (fontMetrics2.bottom - fontMetrics2.top);
        TextPaint textPaint3 = this.f408335l;
        String str2 = this.f408333j;
        int measureText = (int) textPaint3.measureText(str2, 0, str2.length());
        this.f408345v = measureText;
        this.f408340q = Math.max(this.f408342s, measureText) + i.c(7.0f, this.f408325c.getResources());
        int c16 = i.c(30.0f, this.f408325c.getResources()) + i.c(12.0f, this.f408325c.getResources()) + i.c(10.0f, this.f408325c.getResources());
        this.f408341r = c16;
        this.f408346w = this.f408323a.a(NodeProps.LINE_HEIGHT, 20L, 200L, 0, c16 - i.c(5.0f, this.f408325c.getResources()), new LinearInterpolator());
        this.f408347x = this.f408323a.a("offsetX", 180L, 330L, -this.f408340q, 0, new LinearInterpolator());
    }

    @Override // ir.i
    protected void j(Canvas canvas, ArrayList<Integer> arrayList) {
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getIntrinsicWidth(), getIntrinsicHeight(), this.f408334k, 31);
        int c16 = i.c(2.0f, this.f408325c.getResources());
        this.f408335l.setColor(-1);
        this.f408335l.setTextSize(i.c(30.0f, this.f408325c.getResources()));
        this.f408335l.setTypeface(this.f408337n);
        float abs = Math.abs(this.f408335l.getFontMetrics().ascent);
        int size = this.f408324b.size();
        int i3 = this.f408347x;
        int intValue = size > i3 ? this.f408324b.get(i3).intValue() : 0;
        if (intValue == 0) {
            this.f408335l.setShadowLayer(1.0f, 1.0f, 1.0f, -1728053248);
        } else {
            this.f408335l.setShadowLayer(0.0f, 0.0f, 0.0f, -1);
        }
        canvas.drawText(this.f408332i, i.c(7.0f, this.f408325c.getResources()) + intValue, c16 + abs, this.f408335l);
        int c17 = c16 + i.c(6.0f, this.f408325c.getResources());
        this.f408335l.setTypeface(this.f408338o);
        this.f408335l.setTextSize(i.c(12.0f, this.f408325c.getResources()));
        canvas.drawText(this.f408333j, i.c(7.0f, this.f408325c.getResources()) + intValue, c17 + abs + Math.abs(this.f408335l.getFontMetrics().ascent), this.f408335l);
        this.f408335l.setXfermode(this.f408336m);
        this.f408335l.setColor(-1);
        this.f408335l.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(intValue, 0.0f, i.c(5.0f, this.f408325c.getResources()), this.f408341r, this.f408335l);
        this.f408335l.setXfermode(null);
        this.f408334k.setColor(-15322);
        canvas.drawLine(i.c(2.0f, this.f408325c.getResources()), i.c(8.0f, this.f408325c.getResources()), i.c(2.0f, this.f408325c.getResources()), this.f408324b.get(this.f408346w).intValue(), this.f408334k);
        canvas.restoreToCount(saveLayer);
    }
}
