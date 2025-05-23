package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.InputFilter;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class k extends DynamicTextItem {
    private static final int[] E = {5, 5, 5, 5};
    private static Method F;
    private static final float G;
    private static final int H;
    private float A;
    private String B;
    private RectF C;
    private InputFilter D;

    /* renamed from: p, reason: collision with root package name */
    private int f67068p;

    /* renamed from: q, reason: collision with root package name */
    private int f67069q;

    /* renamed from: r, reason: collision with root package name */
    private int f67070r;

    /* renamed from: s, reason: collision with root package name */
    private float f67071s;

    /* renamed from: t, reason: collision with root package name */
    private float f67072t;

    /* renamed from: u, reason: collision with root package name */
    private List<Float> f67073u;

    /* renamed from: v, reason: collision with root package name */
    private TextPaint f67074v;

    /* renamed from: w, reason: collision with root package name */
    private float f67075w;

    /* renamed from: x, reason: collision with root package name */
    private float f67076x;

    /* renamed from: y, reason: collision with root package name */
    private Bitmap f67077y;

    /* renamed from: z, reason: collision with root package name */
    private Shader f67078z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements DynamicTextItem.b {
        a() {
        }

        @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem.b
        public String a(int i3, String str) {
            return TroopFileUtils.g(str);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b extends EditTextDialog.j {
        b(int i3) {
            super(i3);
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j
        public int a(CharSequence charSequence) {
            return 0;
        }

        @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.EditTextDialog.j, android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i3, int i16, Spanned spanned, int i17, int i18) {
            String str = spanned.subSequence(0, i17).toString() + charSequence.subSequence(i3, i16).toString() + spanned.subSequence(i18, spanned.length()).toString();
            String g16 = TroopFileUtils.g(str);
            String y16 = k.this.y(g16);
            this.f68129d = (str.length() - g16.length()) + 20;
            int i19 = 0;
            for (String str2 : y16.split("\n")) {
                int length = str2.length();
                i19 += (length / 5) + (length % 5 > 0 ? 1 : 0);
            }
            if (TextUtils.equals(charSequence, "\n")) {
                i19++;
            }
            if (i19 > k.E.length) {
                if (!TextUtils.equals("", charSequence)) {
                    b();
                }
                return "";
            }
            return super.filter(charSequence, i3, i16, spanned, i17, i18);
        }
    }

    public k(int i3, List<String> list, Typeface typeface, Bitmap bitmap) {
        super(i3, list);
        this.f67068p = Color.parseColor("#ffa414");
        this.f67069q = Color.parseColor("#ff1a14");
        this.f67070r = Color.parseColor("#1f14ff");
        this.f67071s = 0.0f;
        this.f67072t = 0.0f;
        this.f67075w = 0.0f;
        this.f67076x = 0.0f;
        this.A = 0.0f;
        this.B = "";
        this.C = new RectF();
        this.D = null;
        S(typeface, bitmap);
        if (list.isEmpty()) {
            return;
        }
        M(0, list.get(0));
    }

    private CharSequence R(String str) {
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < str.length(); i17++) {
            if (str.charAt(i17) != '\n' && str.charAt(i17) != '\r' && i3 < E[i16]) {
                sb5.append(str.charAt(i17));
                i3++;
            } else {
                sb5.append('\n');
                if (str.charAt(i17) == '\n' || str.charAt(i17) == '\r') {
                    i3 = 0;
                } else {
                    sb5.append(str.charAt(i17));
                    i3 = 1;
                }
                i16++;
                if (i16 >= E.length) {
                    break;
                }
            }
        }
        this.f67073u.clear();
        SpannableString spannableString = new SpannableString(sb5.toString());
        float f16 = 0.0f;
        int i18 = 0;
        for (int i19 = 0; i19 < spannableString.length(); i19++) {
            if (spannableString.charAt(i19) != '\n' && spannableString.charAt(i19) != '\r') {
                float f17 = (int) (this.f67071s + (i18 * this.f67072t));
                spannableString.setSpan(new com.tencent.aelight.camera.aioeditor.capture.text.a(f17, 0.85f), i19, i19 + 1, 17);
                f16 += f17;
                i18++;
            } else {
                this.f67073u.add(Float.valueOf(f16));
                f16 = 0.0f;
            }
        }
        this.f67073u.add(Float.valueOf(f16));
        return spannableString;
    }

    private void S(Typeface typeface, Bitmap bitmap) {
        this.A = BaseApplication.getContext().getResources().getDisplayMetrics().density * 2.0f;
        this.f67073u = new ArrayList();
        this.f67071s = BaseAIOUtils.f(25.0f, r0);
        this.f67072t = BaseAIOUtils.f(3.0f, r0);
        TextPaint textPaint = new TextPaint();
        this.f67074v = textPaint;
        textPaint.setTextSize(this.f67071s);
        this.f67074v.setAntiAlias(true);
        if (typeface != null) {
            this.f67074v.setTypeface(typeface);
        }
        try {
            if (F == null) {
                F = Paint.class.getDeclaredMethod("setLetterSpacing", Float.TYPE);
            }
            Method method = F;
            if (method != null) {
                method.invoke(this.f67074v, Float.valueOf(-0.09f));
            }
        } catch (Exception unused) {
        }
        if (bitmap != null) {
            this.f67077y = bitmap;
            Bitmap bitmap2 = this.f67077y;
            Shader.TileMode tileMode = Shader.TileMode.REPEAT;
            this.f67078z = new BitmapShader(bitmap2, tileMode, tileMode);
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean D() {
        return TextUtils.isEmpty(this.B) || super.D();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    protected void I(Canvas canvas) {
        canvas.save();
        canvas.translate(this.A * 2.0f, 0.0f);
        canvas.save();
        this.f67074v.setStyle(Paint.Style.FILL);
        float f16 = this.A;
        canvas.translate(f16 * (-2.0f), f16 * 3.0f);
        this.f67074v.setColor(this.f67070r);
        this.f66898k.draw(canvas);
        this.f67074v.setColor(-16777216);
        this.f67074v.setStyle(Paint.Style.STROKE);
        this.f67074v.setStrokeWidth(2.0f);
        this.f66898k.draw(canvas);
        canvas.restore();
        canvas.save();
        this.f67074v.setStyle(Paint.Style.FILL);
        float f17 = this.A;
        canvas.translate(-f17, f17 * 1.5f);
        this.f67074v.setColor(this.f67069q);
        this.f66898k.draw(canvas);
        this.f67074v.setColor(-16777216);
        this.f67074v.setStyle(Paint.Style.STROKE);
        this.f67074v.setStrokeWidth(2.0f);
        this.f66898k.draw(canvas);
        canvas.restore();
        canvas.save();
        this.f67074v.setStyle(Paint.Style.FILL);
        canvas.translate(0.0f, 0.0f);
        this.f67074v.setColor(this.f67068p);
        this.f66898k.draw(canvas);
        Shader shader = this.f67078z;
        if (shader != null) {
            this.f67074v.setShader(shader);
            this.f66898k.draw(canvas);
            this.f67074v.setShader(null);
        }
        this.f67074v.setColor(-16777216);
        this.f67074v.setStyle(Paint.Style.STROKE);
        this.f67074v.setStrokeWidth(2.0f);
        this.f66898k.draw(canvas);
        if (H(0)) {
            int lineCount = this.f66898k.getLineCount();
            float f18 = 0.0f;
            for (int i3 = 0; i3 < lineCount; i3++) {
                f18 = Math.max(f18, this.f66898k.getLineWidth(i3));
            }
            float f19 = this.f67075w;
            float height = this.f66898k.getHeight();
            float width = this.f66898k.getWidth() / 2.0f;
            RectF rectF = this.C;
            float f26 = this.A;
            float f27 = f19 / 2.0f;
            float f28 = G;
            rectF.left = ((((-2.0f) * f26) + width) - f27) - f28;
            rectF.top = 0.0f - (f28 * 3.0f);
            rectF.right = width + f27 + (f28 * 2.0f);
            rectF.bottom = height + (f26 * 3.0f) + (f28 * 2.0f);
            canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
        }
        canvas.restore();
        canvas.restore();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f67076x;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public InputFilter n() {
        if (this.D == null) {
            this.D = new b(20);
        }
        return this.D;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f66898k.getWidth() + (this.A * 3.0f);
    }

    static {
        Resources resources = BaseApplication.getContext().getResources();
        G = BaseAIOUtils.f(2.0f, resources);
        H = (resources.getDisplayMetrics().widthPixels - com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67981e0) - (zr.a.d() * 2);
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        int lineEnd;
        super.M(i3, str);
        String l3 = l(i3, new a());
        this.B = l3;
        int i16 = 0;
        for (int i17 : E) {
            i16 += i17;
        }
        if (l3.length() > i16) {
            l3 = l3.substring(0, i16);
        }
        CharSequence R = R(l3);
        Iterator<Float> it = this.f67073u.iterator();
        float f16 = 0.0f;
        while (it.hasNext()) {
            f16 = Math.max(it.next().floatValue(), f16);
        }
        float min = Math.min(H, f16);
        int length = R.length();
        TextPaint textPaint = this.f67074v;
        int i18 = (int) min;
        Layout.Alignment alignment = Layout.Alignment.ALIGN_CENTER;
        int[] iArr = E;
        StaticLayout a16 = ag.a(R, 0, length, textPaint, i18, alignment, 1.0f, 0.0f, false, null, 0, iArr.length);
        this.f66898k = a16;
        if (a16.getLineCount() == 4 && (lineEnd = this.f66898k.getLineEnd(3)) > 0) {
            int min2 = Math.min(lineEnd, l3.length());
            String substring = l3.substring(0, min2);
            if (!substring.endsWith("\n") && !substring.endsWith("\r")) {
                l3 = l3.substring(0, min2);
            } else {
                l3 = l3.substring(0, min2 - 1);
            }
        }
        CharSequence R2 = R(l3);
        StaticLayout a17 = ag.a(R2, 0, R2.length(), this.f67074v, i18, Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false, null, 0, iArr.length);
        this.f66898k = a17;
        this.f67075w = 0.0f;
        int lineCount = a17.getLineCount();
        for (int i19 = 0; i19 < lineCount; i19++) {
            this.f67075w = Math.max(this.f66898k.getLineWidth(i19), this.f67075w);
        }
        float height = this.f66898k.getHeight();
        float f17 = this.A;
        this.f67076x = height + (3.0f * f17);
        this.f67075w += f17 * 2.0f;
    }
}
