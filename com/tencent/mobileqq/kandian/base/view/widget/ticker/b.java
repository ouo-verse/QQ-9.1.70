package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.a;

/* compiled from: P */
/* loaded from: classes15.dex */
class b {

    /* renamed from: a, reason: collision with root package name */
    private a[] f239220a;

    /* renamed from: b, reason: collision with root package name */
    private final d f239221b;

    /* renamed from: c, reason: collision with root package name */
    private char f239222c = 0;

    /* renamed from: d, reason: collision with root package name */
    private char f239223d = 0;

    /* renamed from: e, reason: collision with root package name */
    private char[] f239224e;

    /* renamed from: f, reason: collision with root package name */
    private int f239225f;

    /* renamed from: g, reason: collision with root package name */
    private int f239226g;

    /* renamed from: h, reason: collision with root package name */
    private int f239227h;

    /* renamed from: i, reason: collision with root package name */
    private float f239228i;

    /* renamed from: j, reason: collision with root package name */
    private float f239229j;

    /* renamed from: k, reason: collision with root package name */
    private float f239230k;

    /* renamed from: l, reason: collision with root package name */
    private float f239231l;

    /* renamed from: m, reason: collision with root package name */
    private float f239232m;

    /* renamed from: n, reason: collision with root package name */
    private float f239233n;

    /* renamed from: o, reason: collision with root package name */
    private float f239234o;

    /* renamed from: p, reason: collision with root package name */
    private float f239235p;

    /* renamed from: q, reason: collision with root package name */
    private int f239236q;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a[] aVarArr, d dVar) {
        this.f239220a = aVarArr;
        this.f239221b = dVar;
    }

    private void a() {
        float c16 = this.f239221b.c(this.f239223d);
        float f16 = this.f239231l;
        float f17 = this.f239232m;
        if (f16 == f17 && f17 != c16) {
            this.f239232m = c16;
            this.f239231l = c16;
            this.f239233n = c16;
        }
    }

    private boolean c(Canvas canvas, Paint paint, char[] cArr, int i3, float f16) {
        if (i3 >= 0 && i3 < cArr.length) {
            canvas.drawText(cArr, i3, 1, 0.0f, f16, paint);
            return true;
        }
        return false;
    }

    private void j(int i3, boolean z16, boolean z17, char[] cArr, int i16, int i17) {
        String str = null;
        this.f239224e = null;
        char c16 = this.f239223d;
        if (z16 && c16 == 0) {
            c16 = '0';
        }
        int i18 = 0;
        while (true) {
            a[] aVarArr = this.f239220a;
            if (i18 >= aVarArr.length) {
                break;
            }
            a.C7956a a16 = aVarArr[i18].a(this.f239222c, c16, this.f239221b.d());
            if (a16 != null) {
                if (z17) {
                    this.f239224e = cArr;
                    this.f239225f = i16;
                    this.f239226g = i17;
                } else {
                    this.f239224e = this.f239220a[i18].b();
                    this.f239225f = a16.f239217a;
                    this.f239226g = a16.f239218b;
                    str = this.f239220a[i18].d();
                }
            }
            i18++;
        }
        if (this.f239224e != null && i3 > 1 && !TextUtils.isEmpty(str)) {
            int min = Math.min(i3 - 1, 5);
            String str2 = new String(this.f239224e);
            if (this.f239221b.d() == 1) {
                for (int i19 = 0; i19 < min; i19++) {
                    str2 = str2 + str;
                    this.f239225f += str.length();
                }
            } else if (this.f239221b.d() == 2) {
                for (int i26 = 0; i26 < min; i26++) {
                    str2 = str2 + str;
                    this.f239226g += str.length();
                }
            }
            this.f239224e = str2.toCharArray();
        }
        if (this.f239224e == null) {
            char c17 = this.f239222c;
            char c18 = this.f239223d;
            if (c17 == c18) {
                this.f239224e = new char[]{c17};
                this.f239226g = 0;
                this.f239225f = 0;
            } else {
                this.f239224e = new char[]{c17, c18};
                this.f239225f = 0;
                this.f239226g = 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(Canvas canvas, Paint paint) {
        if (c(canvas, paint, this.f239224e, this.f239227h, this.f239228i)) {
            int i3 = this.f239227h;
            if (i3 >= 0) {
                this.f239222c = this.f239224e[i3];
            }
            this.f239234o = this.f239228i;
        }
        c(canvas, paint, this.f239224e, this.f239227h + 1, this.f239228i - this.f239229j);
        c(canvas, paint, this.f239224e, this.f239227h - 1, this.f239228i + this.f239229j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char d() {
        return this.f239222c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        a();
        return this.f239231l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        a();
        return this.f239233n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public char g() {
        return this.f239223d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h() {
        a();
        this.f239233n = this.f239231l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(float f16, boolean z16) {
        if (f16 == 1.0f) {
            this.f239222c = this.f239223d;
            this.f239234o = 0.0f;
            this.f239235p = 0.0f;
        }
        float b16 = this.f239221b.b();
        float abs = ((Math.abs(this.f239226g - this.f239225f) * b16) * f16) / b16;
        int i3 = (int) abs;
        float f17 = this.f239235p * (1.0f - f16);
        int i16 = this.f239236q;
        this.f239228i = ((abs - i3) * b16 * i16) + f17;
        this.f239227h = this.f239225f + (i3 * i16);
        this.f239229j = b16;
        if (z16) {
            this.f239231l = Math.max(this.f239232m, this.f239230k);
            if (f16 > 0.999f) {
                this.f239231l = this.f239232m;
                if (this.f239223d == 0) {
                    this.f239227h = 0;
                    return;
                }
                return;
            }
            return;
        }
        float f18 = this.f239230k;
        this.f239231l = f18 + ((this.f239232m - f18) * f16);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(a[] aVarArr) {
        this.f239220a = aVarArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l(int i3, char c16, boolean z16) {
        boolean z17;
        this.f239223d = c16;
        this.f239230k = this.f239231l;
        float c17 = this.f239221b.c(c16);
        this.f239232m = c17;
        this.f239233n = Math.max(this.f239230k, c17);
        j(i3, z16, false, null, 0, 0);
        int i16 = 1;
        if (this.f239226g >= this.f239225f) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (!z17) {
            i16 = -1;
        }
        this.f239236q = i16;
        this.f239235p = this.f239234o;
        this.f239234o = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void m(int i3, char c16, boolean z16, boolean z17, char[] cArr, int i16, int i17) {
        boolean z18;
        this.f239223d = c16;
        this.f239230k = this.f239231l;
        float c17 = this.f239221b.c(c16);
        this.f239232m = c17;
        this.f239233n = Math.max(this.f239230k, c17);
        j(i3, z16, z17, cArr, i16, i17);
        int i18 = 1;
        if (this.f239226g >= this.f239225f) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z18) {
            i18 = -1;
        }
        this.f239236q = i18;
        this.f239235p = this.f239234o;
        this.f239234o = 0.0f;
    }
}
