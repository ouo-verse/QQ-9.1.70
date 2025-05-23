package com.tencent.aelight.camera.aioeditor.capture.text;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import androidx.core.internal.view.SupportMenu;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ab extends DynamicTextItem {
    public static final int A;
    public static final int B;
    public static final float C = ScreenUtil.dip2px(22.0f);
    public static final float D = ScreenUtil.dip2px(3.0f);
    private static int E = 0;

    /* renamed from: z, reason: collision with root package name */
    public static final int f66923z;

    /* renamed from: p, reason: collision with root package name */
    private RectF f66924p;

    /* renamed from: q, reason: collision with root package name */
    private RectF f66925q;

    /* renamed from: r, reason: collision with root package name */
    private Rect f66926r;

    /* renamed from: s, reason: collision with root package name */
    private TextPaint f66927s;

    /* renamed from: t, reason: collision with root package name */
    private float f66928t;

    /* renamed from: u, reason: collision with root package name */
    private float f66929u;

    /* renamed from: v, reason: collision with root package name */
    private String f66930v;

    /* renamed from: w, reason: collision with root package name */
    private int[] f66931w;

    /* renamed from: x, reason: collision with root package name */
    boolean f66932x;

    /* renamed from: y, reason: collision with root package name */
    private int f66933y;

    public ab(int i3, List<String> list, Typeface typeface) {
        super(i3, list);
        this.f66924p = new RectF();
        this.f66925q = new RectF();
        this.f66926r = new Rect();
        this.f66932x = false;
        TextPaint textPaint = new TextPaint();
        this.f66927s = textPaint;
        textPaint.setTypeface(Typeface.DEFAULT);
        this.f66927s.setTextAlign(Paint.Align.CENTER);
        if (typeface == null) {
            this.f66927s.setTypeface(Typeface.defaultFromStyle(1));
        } else {
            this.f66927s.setTypeface(typeface);
        }
        this.f66927s.setAntiAlias(true);
        this.f66927s.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f66927s.setTextSize(f66923z);
        this.f66927s.setColor(-1);
        this.f66927s.setTextAlign(Paint.Align.LEFT);
        Paint.FontMetrics fontMetrics = this.f66927s.getFontMetrics();
        E = (int) Math.abs(fontMetrics.bottom - fontMetrics.top);
        if (list.isEmpty()) {
            return;
        }
        M(0, list.get(0));
    }

    private static final boolean Q(char c16) {
        if (c16 >= '\u4e00' && c16 <= '\u9fbb') {
            return true;
        }
        return false;
    }

    private static final boolean R(char c16) {
        if (c16 < 'a' || c16 > 'z') {
            if (c16 >= 'A' && c16 <= 'Z') {
                return true;
            }
            return false;
        }
        return true;
    }

    private static final boolean S(char c16) {
        if (c16 == '\n') {
            return true;
        }
        return false;
    }

    private static final boolean T(char c16) {
        if (c16 >= '0' && c16 <= '9') {
            return true;
        }
        return false;
    }

    private void U() {
        this.f66931w = new int[this.f66930v.length()];
        char[] cArr = new char[this.f66930v.length()];
        String str = this.f66930v;
        str.getChars(0, str.length(), cArr, 0);
        int i3 = -1;
        for (int i16 = 0; i16 < this.f66930v.length(); i16++) {
            char c16 = cArr[i16];
            if (i16 > 0) {
                int i17 = i16 - 1;
                while (true) {
                    if (i17 < 0) {
                        break;
                    }
                    if (cArr[i17] != '\n') {
                        i3 = i17;
                        break;
                    }
                    i17--;
                }
            } else {
                i3 = -1;
            }
            char c17 = i3 == -1 ? (char) 0 : cArr[i3];
            if (Q(c16)) {
                this.f66931w[i16] = 2;
            } else if (R(c16)) {
                this.f66931w[i16] = 3;
                if (c17 != 0 && R(c17)) {
                    this.f66931w[i3] = -3;
                }
            } else if (T(c16)) {
                this.f66931w[i16] = 4;
            } else if (S(c16)) {
                this.f66931w[i16] = 5;
            } else {
                this.f66931w[i16] = 1;
                if (c17 != 0) {
                    if (Q(c17)) {
                        this.f66931w[i3] = -2;
                    } else if (R(c17)) {
                        this.f66931w[i3] = -3;
                    } else if (T(c17)) {
                        this.f66931w[i3] = -4;
                    } else {
                        this.f66931w[i3] = -1;
                    }
                }
            }
        }
        this.f66933y = 0;
        char[] charArray = this.f66930v.toCharArray();
        int length = charArray.length;
        for (int i18 = 0; i18 < length && S(charArray[i18]); i18++) {
            this.f66933y++;
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public boolean F() {
        return true;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public void M(int i3, String str) {
        super.M(i3, str);
        String k3 = super.k(i3);
        if (TextUtils.isEmpty(k3)) {
            k3 = "\u3000\u3000";
        }
        String str2 = k3;
        this.f66930v = str2;
        this.f66898k = new StaticLayout(str2, this.f66927s, A, Layout.Alignment.ALIGN_NORMAL, 1.0f, C, false);
        float f16 = 0.0f;
        for (int i16 = 0; i16 < this.f66898k.getLineCount(); i16++) {
            f16 = Math.max(f16, this.f66898k.getLineWidth(i16));
        }
        this.f66928t = f16;
        this.f66929u = this.f66898k.getHeight();
        U();
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float m() {
        return this.f66929u;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public int o() {
        return 1;
    }

    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    public float w() {
        return this.f66928t;
    }

    static {
        Resources resources = BaseApplication.getContext().getResources();
        f66923z = BaseAIOUtils.f(27.0f, resources);
        B = BaseAIOUtils.f(6.0f, resources);
        A = (resources.getDisplayMetrics().widthPixels - com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g.f67981e0) - (zr.a.d() * 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00ff A[SYNTHETIC] */
    @Override // com.tencent.aelight.camera.aioeditor.capture.text.DynamicTextItem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void I(Canvas canvas) {
        int i3;
        if (this.f66898k != null) {
            this.f66927s.setTextAlign(Paint.Align.LEFT);
            float x16 = super.x(this.f66898k);
            float height = this.f66898k.getHeight();
            int i16 = 0;
            int i17 = 0;
            while (i16 < this.f66898k.getLineCount()) {
                this.f66898k.getLineBounds(i16, this.f66926r);
                int lineVisibleEnd = this.f66898k.getLineVisibleEnd(i16);
                Rect rect = this.f66926r;
                rect.bottom = rect.top + E;
                float[] fArr = new float[lineVisibleEnd - i17];
                this.f66927s.getTextWidths(this.f66930v, i17, lineVisibleEnd, fArr);
                float f16 = 0.0f;
                int i18 = i17;
                while (i18 < lineVisibleEnd) {
                    if (String.valueOf(this.f66930v.charAt(i18)).equals("\n")) {
                        this.f66932x = true;
                        i3 = i18;
                    } else {
                        if (i18 == this.f66933y || this.f66932x) {
                            if (this.f66932x) {
                                this.f66932x = false;
                                int i19 = this.f66931w[i18];
                                if (i19 != -1 && i19 != 1 && i19 != -3 && i19 != 3) {
                                    Rect rect2 = this.f66926r;
                                    int i26 = rect2.left;
                                    int i27 = rect2.bottom;
                                    i3 = i18;
                                    canvas.drawLine(i26 + f16, i27 - D, i26 + f16, i27, this.f66927s);
                                }
                            } else {
                                i3 = i18;
                                Rect rect3 = this.f66926r;
                                int i28 = rect3.left;
                                int i29 = rect3.bottom;
                                canvas.drawLine(i28 + f16, i29 - D, i28 + f16, i29, this.f66927s);
                            }
                            f16 += fArr[i3 - i17];
                            if (this.f66931w[i3] <= 0) {
                                Rect rect4 = this.f66926r;
                                int i36 = rect4.left;
                                int i37 = rect4.bottom;
                                canvas.drawLine(i36 + f16, i37 - D, i36 + f16, i37, this.f66927s);
                            }
                        }
                        i3 = i18;
                        f16 += fArr[i3 - i17];
                        if (this.f66931w[i3] <= 0) {
                        }
                    }
                    i18 = i3 + 1;
                }
                Rect rect5 = this.f66926r;
                int i38 = rect5.left;
                int i39 = rect5.bottom;
                canvas.drawLine(i38, i39, i38 + f16, i39, this.f66927s);
                i16++;
                i17 = lineVisibleEnd;
            }
            this.f66927s.setColor(SupportMenu.CATEGORY_MASK);
            this.f66927s.setColor(-1);
            this.f66898k.draw(canvas);
            if (super.H(0)) {
                RectF rectF = this.f66924p;
                rectF.left = 0.0f;
                rectF.top = 0.0f;
                rectF.right = x16;
                rectF.bottom = height;
                canvas.drawRoundRect(rectF, 6.0f, 6.0f, j());
            }
        }
    }
}
