package com.etrump.mixlayout;

import android.text.TextUtils;
import android.text.style.CharacterStyle;
import com.etrump.mixlayout.api.IETFontAdapter;
import java.util.ArrayList;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* compiled from: P */
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private String f32723a;

    /* renamed from: b, reason: collision with root package name */
    private CharacterStyle f32724b;

    /* renamed from: c, reason: collision with root package name */
    private int f32725c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f32726d;

    /* renamed from: e, reason: collision with root package name */
    private int f32727e;

    /* renamed from: f, reason: collision with root package name */
    private int f32728f;

    /* renamed from: g, reason: collision with root package name */
    private int f32729g;

    /* renamed from: h, reason: collision with root package name */
    private boolean f32730h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f32731i;

    /* renamed from: j, reason: collision with root package name */
    private ETFont f32732j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f32733k;

    /* renamed from: l, reason: collision with root package name */
    private ArrayList<c> f32734l = new ArrayList<>(16);

    /* renamed from: m, reason: collision with root package name */
    private int f32735m;

    /* renamed from: n, reason: collision with root package name */
    private int f32736n;

    /* renamed from: o, reason: collision with root package name */
    private int f32737o;

    public f(String str, int i3, int i16, ETFont eTFont, boolean z16) {
        this.f32723a = str;
        this.f32727e = i3;
        this.f32728f = i16;
        this.f32732j = eTFont;
        this.f32731i = z16;
    }

    private int a(ETEngine eTEngine, String str) throws Exception {
        if (str == null || str.length() <= 0) {
            return 0;
        }
        long native_textLayoutLock = eTEngine.native_textLayoutLock(str, this.f32736n, LockFreeTaskQueueCore.MAX_CAPACITY_MASK, this.f32737o, 0, this.f32732j);
        int native_textLayoutLineTotal = eTEngine.native_textLayoutLineTotal(native_textLayoutLock);
        if (native_textLayoutLineTotal < 1) {
            eTEngine.native_textLayoutUnlock(native_textLayoutLock);
            return 0;
        }
        if (eTEngine.native_textLayoutHasPreLine(native_textLayoutLock)) {
            c cVar = new c("");
            cVar.p(this.f32735m);
            cVar.t(0);
            cVar.r(this);
            this.f32734l.add(cVar);
            this.f32737o = 0;
            this.f32735m++;
        }
        c[] cVarArr = new c[native_textLayoutLineTotal];
        for (int i3 = 0; i3 < native_textLayoutLineTotal; i3++) {
            cVarArr[i3] = new c("");
        }
        for (int i16 = 0; i16 < native_textLayoutLineTotal; i16++) {
            int native_textLayoutLineRangeFrom = eTEngine.native_textLayoutLineRangeFrom(native_textLayoutLock, i16);
            int native_textLayoutLineRangeTo = eTEngine.native_textLayoutLineRangeTo(native_textLayoutLock, i16);
            int native_textLayoutLineWidth = eTEngine.native_textLayoutLineWidth(native_textLayoutLock, i16);
            int native_textLayoutLineHeight = eTEngine.native_textLayoutLineHeight(native_textLayoutLock, i16);
            cVarArr[i16].s(str.substring(native_textLayoutLineRangeFrom, native_textLayoutLineRangeTo));
            cVarArr[i16].u(native_textLayoutLineWidth);
            cVarArr[i16].o(native_textLayoutLineHeight);
            cVarArr[i16].p(this.f32735m + i16);
            cVarArr[i16].t(0);
            cVarArr[i16].r(this);
            this.f32734l.add(cVarArr[i16]);
        }
        if (str.substring(str.length() - 1).equals("\n")) {
            c cVar2 = new c("");
            cVar2.p(this.f32735m + native_textLayoutLineTotal);
            cVar2.t(0);
            cVar2.r(this);
            this.f32734l.add(cVar2);
            this.f32737o = 0;
            native_textLayoutLineTotal++;
        } else if (native_textLayoutLineTotal == 1) {
            this.f32737o += cVarArr[0].n();
        } else {
            this.f32737o = cVarArr[native_textLayoutLineTotal - 1].n();
        }
        this.f32735m += native_textLayoutLineTotal - 1;
        eTEngine.native_textLayoutUnlock(native_textLayoutLock);
        return native_textLayoutLineTotal;
    }

    private int f(CharacterStyle characterStyle) {
        return IETFontAdapter.INSTANCE.getInstance().getSpanWidth(characterStyle);
    }

    private void j(CharacterStyle characterStyle, int i3) {
        if (characterStyle == null) {
            return;
        }
        int f16 = f(characterStyle);
        if (this.f32726d) {
            if (this.f32737o != 0) {
                this.f32737o = f16;
                this.f32735m++;
            }
        } else {
            int i16 = this.f32737o;
            if (i16 == 0) {
                this.f32737o = f16;
            } else if (this.f32736n < f16 + i16) {
                this.f32737o = f16;
                this.f32735m++;
            } else {
                this.f32737o = i16 + f16;
            }
        }
        c cVar = new c(characterStyle, i3);
        cVar.p(this.f32735m);
        cVar.r(this);
        this.f32734l.add(cVar);
        if (this.f32726d && this.f32737o != 0) {
            this.f32737o = 0;
            this.f32735m++;
        }
    }

    private void k(ETEngine eTEngine, String str) {
        if (str != null && !TextUtils.isEmpty(str)) {
            int sysMeasureText = eTEngine.sysMeasureText(str, this.f32732j.getSize(), 0, 0, 0, 0, 0, 0, 0);
            int sysFontHeight = eTEngine.sysFontHeight(str, this.f32732j.getSize(), 0, 0, 0, 0, 0, 0, 0);
            int i3 = this.f32736n;
            int i16 = this.f32737o;
            if (i3 < sysMeasureText + i16) {
                this.f32737o = sysMeasureText;
                this.f32735m++;
            } else {
                this.f32737o = i16 + sysMeasureText;
            }
            c cVar = new c(str);
            cVar.u(sysMeasureText);
            cVar.o(sysFontHeight);
            cVar.p(this.f32735m);
            cVar.t(1);
            cVar.r(this);
            this.f32734l.add(cVar);
        }
    }

    private void m(ETEngine eTEngine) throws Exception {
        int i3;
        int length = this.f32723a.length();
        int i16 = -1;
        int i17 = 0;
        while (i17 < length) {
            if (Character.isHighSurrogate(this.f32723a.charAt(i17)) && (i3 = i17 + 1) < length && Character.isLowSurrogate(this.f32723a.charAt(i3))) {
                a(eTEngine, this.f32723a.substring(i16 + 1, i17));
                k(eTEngine, this.f32723a.substring(i17, i17 + 2));
                i16 = i3;
                i17 = i16;
            } else if (i17 + 1 == length) {
                a(eTEngine, this.f32723a.substring(i16 + 1, length));
                i16 = length;
            }
            i17++;
        }
    }

    private void n(ETEngine eTEngine) throws Exception {
        int i3;
        int length = this.f32723a.length();
        int i16 = -1;
        int i17 = 0;
        while (i17 < length) {
            char charAt = this.f32723a.charAt(i17);
            if (Character.isHighSurrogate(charAt) && (i3 = i17 + 1) < length && Character.isLowSurrogate(this.f32723a.charAt(i3))) {
                a(eTEngine, this.f32723a.substring(i16 + 1, i17));
                k(eTEngine, this.f32723a.substring(i17, i17 + 2));
                i16 = i3;
                i17 = i16;
            } else if (!eTEngine.native_isPaintableChar(charAt, this.f32732j)) {
                a(eTEngine, this.f32723a.substring(i16 + 1, i17));
                k(eTEngine, String.valueOf(charAt));
                i16 = i17;
            } else if (i17 + 1 == length) {
                a(eTEngine, this.f32723a.substring(i16 + 1, length));
                i16 = length;
            }
            i17++;
        }
    }

    public int b() {
        return this.f32729g;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int c() {
        return this.f32737o;
    }

    public ETFont d() {
        return this.f32732j;
    }

    public ArrayList<c> e() {
        return this.f32734l;
    }

    public boolean g() {
        return this.f32730h;
    }

    public boolean h() {
        return this.f32731i;
    }

    public void i(int i3) {
        this.f32729g = i3;
    }

    public int l(ETEngine eTEngine, int i3, int i16, int i17) throws Exception {
        this.f32734l.clear();
        this.f32735m = i17;
        this.f32736n = i3;
        this.f32737o = i16;
        CharacterStyle characterStyle = this.f32724b;
        if (characterStyle != null) {
            j(characterStyle, this.f32725c);
            return this.f32735m;
        }
        if (eTEngine != null && this.f32723a != null) {
            if (ETEngine.getInstance().isEnableCallbackDrawing()) {
                m(eTEngine);
            } else {
                n(eTEngine);
            }
            return this.f32735m;
        }
        return i17;
    }

    public f(CharacterStyle characterStyle, int i3, int i16, int i17, boolean z16) {
        this.f32724b = characterStyle;
        this.f32727e = i16;
        this.f32728f = i17;
        this.f32726d = z16;
        this.f32725c = i3;
    }
}
