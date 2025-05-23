package com.tencent.luggage.wxa.ar;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.a0;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class i {

    /* renamed from: a, reason: collision with root package name */
    public int f121645a;

    /* renamed from: b, reason: collision with root package name */
    public int f121646b;

    /* renamed from: d, reason: collision with root package name */
    public String f121648d;

    /* renamed from: g, reason: collision with root package name */
    public String f121651g;

    /* renamed from: h, reason: collision with root package name */
    public String f121652h;

    /* renamed from: i, reason: collision with root package name */
    public m[] f121653i;

    /* renamed from: j, reason: collision with root package name */
    public int f121654j;

    /* renamed from: k, reason: collision with root package name */
    public String f121655k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f121656l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f121657m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f121658n;

    /* renamed from: o, reason: collision with root package name */
    public String f121659o;

    /* renamed from: p, reason: collision with root package name */
    public String f121660p;

    /* renamed from: q, reason: collision with root package name */
    public String f121661q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f121662r;

    /* renamed from: c, reason: collision with root package name */
    public l f121647c = new l();

    /* renamed from: e, reason: collision with root package name */
    public float f121649e = -1.0f;

    /* renamed from: f, reason: collision with root package name */
    public float f121650f = -1.0f;

    public int[] a() {
        if (TextUtils.isEmpty(this.f121651g)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : this.f121651g.split(":")) {
            if (!TextUtils.isEmpty(str)) {
                a0.a c16 = a0.c(str);
                if (c16.f121611a) {
                    int b16 = c16.b();
                    if (b16 >= 0 && b16 <= 10000) {
                        arrayList.add(c16);
                    } else {
                        x0.c("ConfigDef", " get invalid schedule value = " + b16 + ", schedule str is " + this.f121651g);
                        return null;
                    }
                } else {
                    x0.c("ConfigDef", " parse schedule failed, schedule str is " + this.f121651g);
                    return null;
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        int[] iArr = new int[arrayList.size()];
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            int b17 = ((a0.a) arrayList.get(i3)).b();
            if (i3 > 0 && b17 < iArr[i3 - 1]) {
                x0.c("ConfigDef", " get invalid schedule this value smaller than previous one, schedule str is " + this.f121651g);
                return null;
            }
            iArr[i3] = b17;
        }
        return iArr;
    }
}
