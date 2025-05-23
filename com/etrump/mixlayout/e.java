package com.etrump.mixlayout;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Spanned;
import android.text.style.CharacterStyle;
import android.text.style.ClickableSpan;
import android.text.style.RelativeSizeSpan;
import com.etrump.mixlayout.api.IETFontAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public int f32700a;

    /* renamed from: c, reason: collision with root package name */
    private CharSequence f32702c;

    /* renamed from: d, reason: collision with root package name */
    public ETFont f32703d;

    /* renamed from: e, reason: collision with root package name */
    private int f32704e;

    /* renamed from: h, reason: collision with root package name */
    private h[] f32707h;

    /* renamed from: j, reason: collision with root package name */
    public int f32709j;

    /* renamed from: k, reason: collision with root package name */
    public int f32710k;

    /* renamed from: l, reason: collision with root package name */
    private boolean f32711l;

    /* renamed from: m, reason: collision with root package name */
    private int f32712m;

    /* renamed from: n, reason: collision with root package name */
    private int f32713n;

    /* renamed from: p, reason: collision with root package name */
    public boolean f32715p;

    /* renamed from: q, reason: collision with root package name */
    int f32716q = -1;

    /* renamed from: r, reason: collision with root package name */
    Paint f32717r = new Paint(1);

    /* renamed from: t, reason: collision with root package name */
    public AtomicBoolean f32719t = new AtomicBoolean(false);

    /* renamed from: o, reason: collision with root package name */
    public boolean f32714o = false;

    /* renamed from: b, reason: collision with root package name */
    public long f32701b = 0;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<f> f32706g = new ArrayList<>(16);

    /* renamed from: i, reason: collision with root package name */
    private ArrayList<CharacterStyle> f32708i = new ArrayList<>(4);

    /* renamed from: f, reason: collision with root package name */
    public ETFont f32705f = new ETFont(0, "", 24.0f);

    /* renamed from: s, reason: collision with root package name */
    private ArrayList<i> f32718s = new ArrayList<>(16);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class a implements Comparator<b> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(b bVar, b bVar2) {
            int i3 = bVar.f32720a;
            int i16 = bVar2.f32720a;
            if (i3 != i16) {
                if (i3 > i16) {
                    return 1;
                }
                return -1;
            }
            return bVar.f32721b - bVar2.f32721b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a, reason: collision with root package name */
        int f32720a;

        /* renamed from: b, reason: collision with root package name */
        int f32721b;

        /* renamed from: c, reason: collision with root package name */
        CharacterStyle f32722c;

        b() {
        }
    }

    private void A(int i3, int i16, CharacterStyle characterStyle) {
        IETFontAdapter.INSTANCE.getInstance().setSignatureActionSpanData(i3, i16, characterStyle);
    }

    public static CharSequence B(CharSequence charSequence, int i3, int i16) {
        if (charSequence == null) {
            return "";
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (i16 > charSequence.length()) {
            i16 = charSequence.length();
        }
        int i17 = i16 - i3;
        if (i17 <= 0) {
            return "";
        }
        char[] cArr = new char[i17];
        for (int i18 = 0; i18 < i17; i18++) {
            cArr[i18] = charSequence.charAt(i18 + i3);
        }
        return String.valueOf(cArr);
    }

    private int C(char c16, char c17) {
        return ((c16 << '\n') + c17) - 56613888;
    }

    private void F(ETEngine eTEngine, int i3) throws Exception {
        if (this.f32707h != null) {
            this.f32707h = null;
        }
        int size = this.f32706g.size();
        int i16 = 0;
        int i17 = 0;
        for (int i18 = 0; i18 < size; i18++) {
            f fVar = this.f32706g.get(i18);
            i16 = fVar.l(eTEngine, i3, i17, i16);
            i17 = fVar.c();
        }
        int i19 = i16 + 1;
        this.f32707h = new h[i19];
        for (int i26 = 0; i26 < i19; i26++) {
            this.f32707h[i26] = new h();
        }
        for (int i27 = 0; i27 < size; i27++) {
            ArrayList<c> e16 = this.f32706g.get(i27).e();
            for (int i28 = 0; i28 < e16.size(); i28++) {
                c cVar = e16.get(i28);
                int i29 = cVar.i();
                if (i29 >= 0 && i29 < i19) {
                    this.f32707h[i29].a(cVar);
                }
            }
        }
        int i36 = 0;
        for (int i37 = 0; i37 < i19; i37++) {
            h hVar = this.f32707h[i37];
            hVar.j(eTEngine, 0, i36, this.f32700a);
            Iterator<c> it = hVar.d().iterator();
            int i38 = 0;
            while (it.hasNext()) {
                c next = it.next();
                i[] b16 = next.b(eTEngine, i38, i36, hVar.e(), i37);
                if (b16 != null && b16.length > 0) {
                    Collections.addAll(this.f32718s, b16);
                }
                i38 += next.n();
            }
            i36 += hVar.e();
        }
    }

    private void a(CharacterStyle characterStyle, int i3, int i16, int i17, boolean z16) {
        if (this.f32706g == null) {
            return;
        }
        f fVar = new f(characterStyle, i3, i16, i17, z16);
        fVar.i(this.f32713n);
        this.f32706g.add(fVar);
    }

    private void b(String str, int i3, int i16, ETFont eTFont, boolean z16) {
        if (this.f32706g == null) {
            return;
        }
        f fVar = new f(str, i3, i16, eTFont, z16);
        fVar.i(this.f32713n);
        this.f32706g.add(fVar);
        this.f32714o = false;
    }

    private void c(String str, int i3, int i16, ETFont eTFont, boolean z16, boolean z17) {
        if (this.f32706g == null) {
            return;
        }
        f fVar = new f(str, i3, i16, eTFont, z16);
        fVar.i(this.f32713n);
        fVar.f32733k = z17;
        this.f32706g.add(fVar);
        this.f32714o = false;
    }

    private void d() {
        ArrayList<f> arrayList = this.f32706g;
        if (arrayList != null) {
            arrayList.clear();
        }
        CharSequence charSequence = this.f32702c;
        if (charSequence != null && this.f32703d != null) {
            if (charSequence instanceof Spanned) {
                n();
            } else {
                b(charSequence.toString(), 0, this.f32702c.length(), this.f32703d, false);
            }
        }
    }

    private void i(Bitmap bitmap, ETDecoration eTDecoration) {
        if (eTDecoration != null && 1 == eTDecoration.getDecorationType()) {
            eTDecoration.drawBackground(bitmap, this.f32703d);
        }
    }

    private void j(Bitmap bitmap, ETDecoration eTDecoration) {
        if (eTDecoration != null && 1 == eTDecoration.getDecorationType()) {
            eTDecoration.drawForeground(bitmap, this.f32703d);
        }
    }

    private void k(ETEngine eTEngine, Bitmap bitmap, ETDecoration eTDecoration, boolean z16, int i3) {
        int i16;
        int i17;
        if (z16) {
            eTDecoration.drawScene(bitmap, 0, 0, this.f32703d);
            return;
        }
        Rect rect = eTDecoration.mMargins;
        if (rect != null) {
            int i18 = rect.left;
            i16 = rect.top;
            i17 = i18;
        } else {
            i16 = 0;
            i17 = 0;
        }
        eTDecoration.drawBackground(bitmap, this.f32703d);
        h[] hVarArr = this.f32707h;
        if (hVarArr != null) {
            for (h hVar : hVarArr) {
                hVar.c(eTEngine, bitmap, null, i17, i16);
                i16 += hVar.e();
                if (i16 >= i3) {
                    return;
                }
            }
        }
    }

    private void l(Canvas canvas) {
        IETFontAdapter.INSTANCE.getInstance().drawSignatureSpan(this.f32708i, this.f32703d, this.f32717r, this.f32716q, canvas);
    }

    private void n() {
        this.f32708i.clear();
        Spanned spanned = (Spanned) this.f32702c;
        CharacterStyle[] characterStyleArr = (CharacterStyle[]) spanned.getSpans(0, spanned.length(), CharacterStyle.class);
        int length = characterStyleArr.length;
        b[] bVarArr = new b[length];
        if (length == 0) {
            b(this.f32702c.toString(), 0, this.f32702c.length(), this.f32703d, false);
            return;
        }
        for (int i3 = 0; i3 < characterStyleArr.length; i3++) {
            b bVar = new b();
            bVarArr[i3] = bVar;
            bVar.f32720a = spanned.getSpanStart(characterStyleArr[i3]);
            bVarArr[i3].f32721b = spanned.getSpanEnd(characterStyleArr[i3]);
            bVarArr[i3].f32722c = characterStyleArr[i3];
        }
        Arrays.sort(bVarArr, new a());
        int i16 = 0;
        int i17 = 0;
        while (i17 < characterStyleArr.length) {
            b bVar2 = bVarArr[i17];
            int i18 = bVar2.f32720a;
            int i19 = bVar2.f32721b;
            if (i18 - i16 > 0) {
                b(B(this.f32702c, i16, i18).toString(), i16, i18, this.f32703d, false);
            }
            if (i19 - i18 > 0) {
                if (bVarArr[i17].f32722c instanceof ClickableSpan) {
                    if (i18 > 0 && this.f32702c.charAt(i18 - 1) == IETFontAdapter.INSTANCE.getInstance().getSysEmotcationHead()) {
                        i18++;
                    }
                    int i26 = i18;
                    b(B(this.f32702c, i26, i19).toString(), i26, i19, this.f32705f, true);
                } else {
                    IETFontAdapter.Companion companion = IETFontAdapter.INSTANCE;
                    if (companion.getInstance().isInstanceOfEmoticonSpan(bVarArr[i17].f32722c)) {
                        CharacterStyle characterStyle = bVarArr[i17].f32722c;
                        this.f32708i.add(characterStyle);
                        a(characterStyle, this.f32708i.indexOf(characterStyle), i18, i19, false);
                    } else if (bVarArr[i17].f32722c instanceof RelativeSizeSpan) {
                        CharSequence B = B(this.f32702c, i18, i19);
                        RelativeSizeSpan relativeSizeSpan = (RelativeSizeSpan) bVarArr[i17].f32722c;
                        ETFont eTFont = this.f32703d;
                        ETFont eTFont2 = new ETFont(eTFont.mFontId, eTFont.mFontPath, eTFont.getSize());
                        eTFont2.copy(this.f32703d);
                        eTFont2.setSize(relativeSizeSpan.getSizeChange() * this.f32703d.getSize());
                        c(B.toString(), i18, i19, eTFont2, false, true);
                    } else if (companion.getInstance().isInstanceOfSignatureActionSpan(bVarArr[i17].f32722c)) {
                        CharacterStyle characterStyle2 = bVarArr[i17].f32722c;
                        this.f32708i.add(characterStyle2);
                        a(characterStyle2, this.f32708i.indexOf(characterStyle2), i18, i19, false);
                    }
                }
            }
            if (i17 == characterStyleArr.length - 1 && i19 < this.f32702c.length()) {
                CharSequence charSequence = this.f32702c;
                b(B(charSequence, i19, charSequence.length()).toString(), i19, this.f32702c.length(), this.f32703d, false);
            }
            i17++;
            i16 = i19;
        }
    }

    private String o() {
        ArrayList<f> arrayList;
        StringBuilder sb5 = new StringBuilder();
        h[] hVarArr = this.f32707h;
        if (hVarArr == null || hVarArr.length == 0 || (arrayList = this.f32706g) == null || arrayList.size() == 0) {
            return null;
        }
        Iterator<f> it = this.f32706g.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            ArrayList<c> e16 = it.next().e();
            if (e16 == null) {
                return null;
            }
            Iterator<c> it5 = e16.iterator();
            while (it5.hasNext()) {
                c next = it5.next();
                if (next == null) {
                    return null;
                }
                String j3 = next.j();
                if (j3 != null) {
                    next.q(i3);
                    i3 += j3.length();
                    sb5.append(j3);
                }
            }
        }
        return sb5.toString();
    }

    private int q() {
        h[] hVarArr = this.f32707h;
        if (hVarArr != null && hVarArr.length != 0) {
            return hVarArr[hVarArr.length - 1].i();
        }
        return 0;
    }

    private Object[] s() {
        ArrayList<CharacterStyle> arrayList = this.f32708i;
        if (arrayList != null && arrayList.size() > 0) {
            return this.f32708i.toArray();
        }
        return null;
    }

    public final void D(Canvas canvas, int i3, int i16) {
        h[] hVarArr = this.f32707h;
        if (hVarArr == null) {
            return;
        }
        for (h hVar : hVarArr) {
            hVar.k(canvas, i3, i16);
            i16 += hVar.e();
        }
    }

    public void E(Canvas canvas, int i3, int i16) {
        int i17 = this.f32716q;
        if (i17 > -1 && i17 < this.f32708i.size()) {
            l(canvas);
        }
        h[] hVarArr = this.f32707h;
        if (hVarArr == null) {
            return;
        }
        for (h hVar : hVarArr) {
            hVar.b(canvas, i3, i16);
            i16 += hVar.e();
        }
    }

    public ETDecoration e(ETEngine eTEngine, boolean z16) {
        if (eTEngine == null) {
            return null;
        }
        String o16 = o();
        int q16 = q();
        int r16 = r();
        ETSegment[] f16 = f(eTEngine);
        Object[] s16 = s();
        if (!z16) {
            this.f32716q = -1;
            if (this.f32708i != null) {
                int i3 = 0;
                while (true) {
                    if (i3 >= this.f32708i.size()) {
                        break;
                    }
                    if (IETFontAdapter.INSTANCE.getInstance().isInstanceOfSignatureActionSpan(this.f32708i.get(i3))) {
                        this.f32716q = i3;
                        break;
                    }
                    i3++;
                }
            }
        }
        return (ETDecoration) ETDecoration.createDecoration(eTEngine, o16, this.f32709j, this.f32710k, q16, r16, f16, s16, this.f32711l, this.f32712m, this.f32703d, z16);
    }

    public ETSegment[] f(ETEngine eTEngine) {
        h[] hVarArr;
        ArrayList arrayList = new ArrayList();
        h[] hVarArr2 = this.f32707h;
        ETSegment[] eTSegmentArr = null;
        if (hVarArr2 == null) {
            return null;
        }
        int length = hVarArr2.length;
        int i3 = 0;
        int i16 = 0;
        int i17 = 0;
        while (i3 < length) {
            h hVar = hVarArr2[i3];
            ArrayList<c> d16 = hVar.d();
            if (d16 == null) {
                return eTSegmentArr;
            }
            Iterator<c> it = d16.iterator();
            int i18 = 0;
            while (it.hasNext()) {
                c next = it.next();
                if (next == null) {
                    return eTSegmentArr;
                }
                ETSegment eTSegment = new ETSegment();
                eTSegment.type = 0;
                eTSegment.codePoint = -1;
                eTSegment.textOffset = 0;
                eTSegment.textLength = 0;
                eTSegment.lineNum = 0;
                eTSegment.textSize = 0;
                eTSegment.f32603x = 0;
                eTSegment.f32604y = 0;
                String j3 = next.j();
                if (j3 != null) {
                    eTSegment.textLength = j3.length();
                    eTSegment.textOffset = i16;
                    eTSegment.type = 0;
                    i16 += j3.length();
                    int e16 = ((hVar.e() - next.h()) + i17) - (hVar.g() - next.f(eTEngine));
                    eTSegment.f32603x = i18;
                    eTSegment.f32604y = e16;
                }
                String m3 = next.m();
                if (m3 != null) {
                    eTSegment.textLength = 1;
                    eTSegment.type = 1;
                    hVarArr = hVarArr2;
                    eTSegment.codePoint = C(m3.charAt(0), m3.charAt(1));
                    int e17 = hVar.e() - next.h();
                    eTSegment.f32603x = i18;
                    eTSegment.f32604y = e17 + i17;
                } else {
                    hVarArr = hVarArr2;
                }
                int l3 = next.l();
                if (l3 > -1) {
                    eTSegment.type = 2;
                    eTSegment.codePoint = l3;
                    int e18 = (hVar.e() - next.h()) + i17;
                    eTSegment.f32603x = i18;
                    eTSegment.f32604y = e18;
                    A(i18, eTSegment.f32604y, next.k());
                }
                eTSegment.textSize = next.g();
                eTSegment.lineNum = next.i();
                arrayList.add(eTSegment);
                i18 += next.n();
                hVarArr2 = hVarArr;
                eTSegmentArr = null;
            }
            i17 += hVar.e();
            i3++;
            hVarArr2 = hVarArr2;
            eTSegmentArr = null;
        }
        return (ETSegment[]) arrayList.toArray(new ETSegment[arrayList.size()]);
    }

    @TargetApi(14)
    public final void g(ETEngine eTEngine, Bitmap bitmap, ETDecoration eTDecoration, boolean z16) {
        if (eTEngine != null && bitmap != null && this.f32709j > 0 && this.f32710k > 0) {
            int height = bitmap.getHeight();
            if (eTDecoration != null && 2 == eTDecoration.getDecorationType()) {
                k(eTEngine, bitmap, eTDecoration, z16, height);
                return;
            }
            if (!z16) {
                eTDecoration = null;
            }
            i(bitmap, eTDecoration);
            m(eTEngine, bitmap, eTDecoration, height);
            j(bitmap, eTDecoration);
        }
    }

    public void h(Canvas canvas, int i3, int i16, Bitmap bitmap) {
        int i17;
        int i18;
        if (canvas == null) {
            return;
        }
        canvas.save();
        canvas.translate(i3, i16);
        if (bitmap != null) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int maximumBitmapHeight = canvas.getMaximumBitmapHeight();
            int maximumBitmapWidth = canvas.getMaximumBitmapWidth();
            if (width <= maximumBitmapWidth && height <= maximumBitmapHeight) {
                canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
            } else {
                Rect rect = new Rect(0, 0, 0, 0);
                while (height > 0) {
                    if (height >= maximumBitmapHeight) {
                        i17 = maximumBitmapHeight;
                    } else {
                        i17 = height;
                    }
                    height -= i17;
                    rect.left = 0;
                    rect.bottom += i17;
                    int i19 = width;
                    while (i19 > 0) {
                        if (i19 >= maximumBitmapWidth) {
                            i18 = maximumBitmapWidth;
                        } else {
                            i18 = i19;
                        }
                        i19 -= i18;
                        rect.right += i18;
                        canvas.drawBitmap(bitmap, rect, rect, (Paint) null);
                        rect.left += i18;
                    }
                    rect.top += i17;
                }
            }
        }
        canvas.restore();
    }

    protected void m(ETEngine eTEngine, Bitmap bitmap, ETDecoration eTDecoration, int i3) {
        h[] hVarArr = this.f32707h;
        if (hVarArr != null) {
            int i16 = 0;
            for (h hVar : hVarArr) {
                hVar.c(eTEngine, bitmap, eTDecoration, 0, i16);
                i16 += hVar.e();
                if (i16 >= i3) {
                    return;
                }
            }
        }
    }

    public ArrayList<Rect> p() {
        if (this.f32718s == null) {
            return null;
        }
        ArrayList<Rect> arrayList = new ArrayList<>();
        for (int i3 = 0; i3 < this.f32718s.size(); i3++) {
            arrayList.add(this.f32718s.get(i3).f32746c);
        }
        return arrayList;
    }

    public int r() {
        h[] hVarArr = this.f32707h;
        if (hVarArr != null) {
            return hVarArr.length;
        }
        return 0;
    }

    public Rect t(int i3) {
        if (i3 >= 0) {
            h[] hVarArr = this.f32707h;
            if (i3 < hVarArr.length) {
                h hVar = hVarArr[i3];
                int f16 = hVar.f();
                int h16 = hVar.h();
                return new Rect(f16, h16, this.f32709j + f16, hVar.e() + h16);
            }
            return null;
        }
        return null;
    }

    int u(int i3) {
        int length = this.f32707h.length;
        for (int i16 = 0; i16 < length; i16++) {
            h hVar = this.f32707h[i16];
            if (i3 < hVar.h() + hVar.e()) {
                return i16;
            }
        }
        return length - 1;
    }

    public i[] v(int i3) {
        h[] hVarArr = this.f32707h;
        if (hVarArr != null && i3 < hVarArr.length) {
            ArrayList arrayList = new ArrayList();
            Iterator<i> it = this.f32718s.iterator();
            while (it.hasNext()) {
                i next = it.next();
                if (next.f32745b == i3) {
                    arrayList.add(next);
                }
            }
            return (i[]) arrayList.toArray(new i[0]);
        }
        return null;
    }

    public i w(int i3) {
        if (i3 >= 0 && i3 < this.f32718s.size()) {
            return this.f32718s.get(i3);
        }
        return null;
    }

    public int x(int i3, int i16) {
        int u16 = u(i16);
        int size = this.f32718s.size();
        int i17 = size - 1;
        for (int i18 = 0; i18 < size; i18++) {
            i iVar = this.f32718s.get(i18);
            int i19 = iVar.f32745b;
            if (i19 == u16) {
                if (i3 <= iVar.f32746c.right) {
                    return i18;
                }
                i17 = i18;
            } else if (i19 > u16) {
                break;
            }
        }
        return i17 + 1;
    }

    public boolean y(ETEngine eTEngine, int i3, CharSequence charSequence, ETFont eTFont, int i16, boolean z16, int i17) throws Throwable {
        this.f32704e = i3;
        this.f32711l = z16;
        this.f32712m = i17;
        this.f32702c = charSequence;
        this.f32703d = eTFont;
        this.f32714o = true;
        ETFont eTFont2 = this.f32705f;
        if (eTFont2 != null && eTFont != null) {
            eTFont2.copy(eTFont);
            this.f32705f.setColor(i16);
        }
        d();
        if (this.f32714o) {
            return false;
        }
        F(eTEngine, i3);
        h[] hVarArr = this.f32707h;
        if (hVarArr != null) {
            int length = hVarArr.length;
            int i18 = 0;
            int i19 = 0;
            for (int i26 = 0; i26 < length; i26++) {
                int i27 = this.f32707h[i26].i();
                int e16 = this.f32707h[i26].e();
                if (i27 > i18) {
                    i18 = i27;
                }
                i19 += e16;
            }
            this.f32709j = i18;
            this.f32710k = i19;
            if (i18 <= 0 || i19 <= 0) {
                return false;
            }
            this.f32719t.set(true);
            return true;
        }
        throw new Exception("measure textLines fail");
    }

    public void z(int i3) {
        this.f32713n = i3;
    }
}
