package com.tencent.mobileqq.kandian.base.view.widget.ticker;

import android.graphics.Canvas;
import android.graphics.Paint;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public class c {

    /* renamed from: c, reason: collision with root package name */
    private final d f239239c;

    /* renamed from: d, reason: collision with root package name */
    private a[] f239240d;

    /* renamed from: e, reason: collision with root package name */
    private Set<Character> f239241e;

    /* renamed from: a, reason: collision with root package name */
    final ArrayList<b> f239237a = new ArrayList<>();

    /* renamed from: b, reason: collision with root package name */
    ArrayList<String> f239238b = new ArrayList<>();

    /* renamed from: f, reason: collision with root package name */
    boolean f239242f = false;

    /* renamed from: g, reason: collision with root package name */
    boolean f239243g = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f239239c = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(Canvas canvas, Paint paint) {
        int size = this.f239237a.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = this.f239237a.get(i3);
            bVar.b(canvas, paint);
            canvas.translate(bVar.e(), 0.0f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a[] b() {
        return this.f239240d;
    }

    char[] c() {
        int size = this.f239237a.size();
        char[] cArr = new char[size];
        for (int i3 = 0; i3 < size; i3++) {
            cArr[i3] = this.f239237a.get(i3).d();
        }
        return cArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        int size = this.f239237a.size();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            f16 += this.f239237a.get(i3).e();
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        int size = this.f239237a.size();
        float f16 = 0.0f;
        for (int i3 = 0; i3 < size; i3++) {
            f16 += this.f239237a.get(i3).f();
        }
        return f16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        int size = this.f239237a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f239237a.get(i3).h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void g(float f16) {
        int size = this.f239237a.size();
        for (int i3 = 0; i3 < size; i3++) {
            this.f239237a.get(i3).i(f16, this.f239243g);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void h(String... strArr) {
        this.f239240d = new a[strArr.length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            this.f239240d[i3] = new a(strArr[i3]);
        }
        this.f239241e = new HashSet();
        for (int i16 = 0; i16 < strArr.length; i16++) {
            this.f239241e.addAll(this.f239240d[i16].e());
        }
        Iterator<b> it = this.f239237a.iterator();
        while (it.hasNext()) {
            it.next().k(this.f239240d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void i(ArrayList<String> arrayList) {
        this.f239238b = arrayList;
    }

    public void j(boolean z16) {
        this.f239242f = z16;
    }

    public void k(boolean z16) {
        this.f239243g = z16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00dd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(char[] cArr) {
        char[] cArr2;
        boolean z16;
        int i3;
        char[] cArr3;
        boolean z17;
        if (this.f239240d != null) {
            int i16 = 0;
            while (i16 < this.f239237a.size()) {
                if (this.f239237a.get(i16).e() > 0.0f) {
                    i16++;
                } else {
                    this.f239237a.remove(i16);
                }
            }
            int[] b16 = x52.a.b(c(), cArr, this.f239241e);
            int i17 = 0;
            int i18 = 0;
            int i19 = 1;
            int i26 = 1;
            for (int i27 = 0; i27 < b16.length; i27++) {
                int i28 = b16[i27];
                if (i28 != 0) {
                    if (i28 != 1) {
                        if (i28 == 2) {
                            this.f239237a.get(i17).l(i19, (char) 0, this.f239243g);
                            i17++;
                            if (!this.f239242f) {
                            }
                            i19 += i26;
                            i26++;
                        } else {
                            throw new IllegalArgumentException("Unknown action: " + b16[i27]);
                        }
                    } else {
                        this.f239237a.add(i17, new b(this.f239240d, this.f239239c));
                    }
                }
                b bVar = this.f239237a.get(i17);
                ArrayList<String> arrayList = this.f239238b;
                if (arrayList != null && arrayList.size() > i27) {
                    cArr2 = this.f239238b.get(i27).toCharArray();
                    if (cArr2 != null) {
                        int length = cArr2.length - 1;
                        if (cArr2.length > 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        cArr3 = cArr2;
                        i3 = length;
                        z16 = z17;
                        bVar.m(i19, cArr[i18], this.f239243g, z16, cArr3, 0, i3);
                        i17++;
                        i18++;
                        if (this.f239242f) {
                            if (bVar.d() == bVar.g() && i19 <= 1) {
                            }
                            i19 += i26;
                            i26++;
                        }
                    }
                } else {
                    cArr2 = null;
                }
                z16 = false;
                i3 = 0;
                cArr3 = cArr2;
                bVar.m(i19, cArr[i18], this.f239243g, z16, cArr3, 0, i3);
                i17++;
                i18++;
                if (this.f239242f) {
                }
            }
            return;
        }
        throw new IllegalStateException("Need to call #setCharacterLists first.");
    }
}
