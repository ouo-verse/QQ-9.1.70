package com.google.android.flexbox;

import android.view.View;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {

    /* renamed from: e, reason: collision with root package name */
    int f33139e;

    /* renamed from: f, reason: collision with root package name */
    int f33140f;

    /* renamed from: g, reason: collision with root package name */
    int f33141g;

    /* renamed from: h, reason: collision with root package name */
    int f33142h;

    /* renamed from: i, reason: collision with root package name */
    int f33143i;

    /* renamed from: j, reason: collision with root package name */
    float f33144j;

    /* renamed from: k, reason: collision with root package name */
    float f33145k;

    /* renamed from: l, reason: collision with root package name */
    int f33146l;

    /* renamed from: m, reason: collision with root package name */
    int f33147m;

    /* renamed from: o, reason: collision with root package name */
    int f33149o;

    /* renamed from: p, reason: collision with root package name */
    int f33150p;

    /* renamed from: q, reason: collision with root package name */
    boolean f33151q;

    /* renamed from: r, reason: collision with root package name */
    boolean f33152r;

    /* renamed from: a, reason: collision with root package name */
    int f33135a = Integer.MAX_VALUE;

    /* renamed from: b, reason: collision with root package name */
    int f33136b = Integer.MAX_VALUE;

    /* renamed from: c, reason: collision with root package name */
    int f33137c = Integer.MIN_VALUE;

    /* renamed from: d, reason: collision with root package name */
    int f33138d = Integer.MIN_VALUE;

    /* renamed from: n, reason: collision with root package name */
    List<Integer> f33148n = new ArrayList();

    public int a() {
        return this.f33141g;
    }

    public int b() {
        return this.f33142h;
    }

    public int c() {
        return this.f33142h - this.f33143i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(View view, int i3, int i16, int i17, int i18) {
        FlexItem flexItem = (FlexItem) view.getLayoutParams();
        this.f33135a = Math.min(this.f33135a, (view.getLeft() - flexItem.getMarginLeft()) - i3);
        this.f33136b = Math.min(this.f33136b, (view.getTop() - flexItem.getMarginTop()) - i16);
        this.f33137c = Math.max(this.f33137c, view.getRight() + flexItem.getMarginRight() + i17);
        this.f33138d = Math.max(this.f33138d, view.getBottom() + flexItem.getMarginBottom() + i18);
    }
}
