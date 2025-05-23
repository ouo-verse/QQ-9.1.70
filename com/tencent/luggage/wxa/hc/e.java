package com.tencent.luggage.wxa.hc;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.tencent.mm.picker.base.view.WheelView;
import com.tencent.mobileqq.R;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes8.dex */
public class e {
    public static DateFormat G = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
    public String[] A;
    public final List C;
    public Context E;

    /* renamed from: a, reason: collision with root package name */
    public View f127002a;

    /* renamed from: b, reason: collision with root package name */
    public WheelView f127003b;

    /* renamed from: c, reason: collision with root package name */
    public WheelView f127004c;

    /* renamed from: d, reason: collision with root package name */
    public WheelView f127005d;

    /* renamed from: e, reason: collision with root package name */
    public WheelView f127006e;

    /* renamed from: f, reason: collision with root package name */
    public WheelView f127007f;

    /* renamed from: g, reason: collision with root package name */
    public WheelView f127008g;

    /* renamed from: h, reason: collision with root package name */
    public int f127009h;

    /* renamed from: i, reason: collision with root package name */
    public com.tencent.luggage.wxa.zb.d f127010i;

    /* renamed from: j, reason: collision with root package name */
    public boolean[] f127011j;

    /* renamed from: u, reason: collision with root package name */
    public int f127022u;

    /* renamed from: v, reason: collision with root package name */
    public int f127023v;

    /* renamed from: x, reason: collision with root package name */
    public float f127025x;

    /* renamed from: y, reason: collision with root package name */
    public WheelView.c f127026y;

    /* renamed from: z, reason: collision with root package name */
    public com.tencent.luggage.wxa.fc.a f127027z;

    /* renamed from: k, reason: collision with root package name */
    public int f127012k = 1900;

    /* renamed from: l, reason: collision with root package name */
    public int f127013l = 2100;

    /* renamed from: m, reason: collision with root package name */
    public int f127014m = 1;

    /* renamed from: n, reason: collision with root package name */
    public int f127015n = 12;

    /* renamed from: o, reason: collision with root package name */
    public int f127016o = 1;

    /* renamed from: p, reason: collision with root package name */
    public int f127017p = 31;

    /* renamed from: q, reason: collision with root package name */
    public int f127018q = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f127019r = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f127020s = 23;

    /* renamed from: t, reason: collision with root package name */
    public int f127021t = 59;

    /* renamed from: w, reason: collision with root package name */
    public boolean f127024w = false;
    public String[] B = {"4", "6", "9", "11"};
    public final List D = Arrays.asList(this.B);
    public boolean F = true;

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a implements com.tencent.luggage.wxa.bc.b {
        public a() {
        }

        @Override // com.tencent.luggage.wxa.bc.b
        public void a(int i3) {
            int i16 = i3 + 1;
            if (e.this.f127012k == e.this.f127013l) {
                int i17 = (i16 + e.this.f127014m) - 1;
                if (e.this.f127014m == e.this.f127015n) {
                    e eVar = e.this;
                    eVar.a(eVar.f127022u, i17, e.this.f127016o, e.this.f127017p, e.this.C, e.this.D);
                } else if (e.this.f127014m == i17) {
                    e eVar2 = e.this;
                    eVar2.a(eVar2.f127022u, i17, e.this.f127016o, 31, e.this.C, e.this.D);
                } else if (e.this.f127015n == i17) {
                    e eVar3 = e.this;
                    eVar3.a(eVar3.f127022u, i17, 1, e.this.f127017p, e.this.C, e.this.D);
                } else {
                    e eVar4 = e.this;
                    eVar4.a(eVar4.f127022u, i17, 1, 31, e.this.C, e.this.D);
                }
            } else if (e.this.f127022u == e.this.f127012k) {
                int i18 = (i16 + e.this.f127014m) - 1;
                if (i18 == e.this.f127014m) {
                    e eVar5 = e.this;
                    eVar5.a(eVar5.f127022u, i18, e.this.f127016o, 31, e.this.C, e.this.D);
                } else {
                    e eVar6 = e.this;
                    eVar6.a(eVar6.f127022u, i18, 1, 31, e.this.C, e.this.D);
                }
            } else if (e.this.f127022u == e.this.f127013l) {
                if (i16 == e.this.f127015n) {
                    e eVar7 = e.this;
                    eVar7.a(eVar7.f127022u, e.this.f127004c.getCurrentItem() + 1, 1, e.this.f127017p, e.this.C, e.this.D);
                } else {
                    e eVar8 = e.this;
                    eVar8.a(eVar8.f127022u, e.this.f127004c.getCurrentItem() + 1, 1, 31, e.this.C, e.this.D);
                }
            } else {
                e eVar9 = e.this;
                eVar9.a(eVar9.f127022u, i16, 1, 31, e.this.C, e.this.D);
            }
            if (e.this.f127027z != null) {
                e.this.f127027z.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class b implements com.tencent.luggage.wxa.bc.b {
        public b() {
        }

        @Override // com.tencent.luggage.wxa.bc.b
        public void a(int i3) {
            int i16;
            int i17 = e.this.f127012k + i3;
            if (e.this.f127024w) {
                i17--;
            }
            int i18 = i17;
            int intValue = ((Integer) e.this.f127004c.getAdapter().getItem(e.this.f127004c.getCurrentItem())).intValue();
            e.this.f127022u = i18;
            if (e.this.f127024w && i3 == -1) {
                e.this.f127004c.d(0);
                e.this.f127005d.d(0);
                e.this.f127004c.invalidate();
                e.this.f127005d.invalidate();
            } else {
                if (e.this.F) {
                    e.this.f127004c.d(ContextCompat.getColor(e.this.E, R.color.f156614aj0));
                    e.this.f127005d.d(ContextCompat.getColor(e.this.E, R.color.f156614aj0));
                    e.this.f127004c.invalidate();
                    e.this.f127005d.invalidate();
                }
                int currentItem = e.this.f127004c.getCurrentItem();
                if (e.this.f127012k == e.this.f127013l) {
                    e.this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(e.this.f127014m, e.this.f127015n, new com.tencent.luggage.wxa.zb.b(e.this.E)));
                    if (currentItem > e.this.f127004c.getAdapter().a() - 1) {
                        currentItem = e.this.f127004c.getAdapter().a() - 1;
                        e.this.f127004c.setCurrentItem(currentItem);
                    }
                    int i19 = currentItem + e.this.f127014m;
                    if (e.this.f127014m == e.this.f127015n) {
                        e eVar = e.this;
                        eVar.a(i18, i19, eVar.f127016o, e.this.f127017p, e.this.C, e.this.D);
                    } else if (i19 == e.this.f127014m) {
                        e eVar2 = e.this;
                        eVar2.a(i18, i19, eVar2.f127016o, 31, e.this.C, e.this.D);
                    } else if (i19 == e.this.f127015n) {
                        e eVar3 = e.this;
                        eVar3.a(i18, i19, 1, eVar3.f127017p, e.this.C, e.this.D);
                    } else {
                        e eVar4 = e.this;
                        eVar4.a(i18, i19, 1, 31, eVar4.C, e.this.D);
                    }
                } else if (i18 == e.this.f127012k) {
                    e.this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(e.this.f127014m, 12, new com.tencent.luggage.wxa.zb.b(e.this.E)));
                    if (intValue <= e.this.f127014m) {
                        e.this.f127004c.setCurrentItem(0);
                        i16 = e.this.f127014m;
                    } else {
                        e.this.f127004c.setCurrentItem(intValue - e.this.f127014m);
                        i16 = intValue;
                    }
                    if (i16 == e.this.f127014m) {
                        e eVar5 = e.this;
                        eVar5.a(i18, i16, eVar5.f127016o, 31, e.this.C, e.this.D);
                    } else {
                        e eVar6 = e.this;
                        eVar6.a(i18, i16, 1, 31, eVar6.C, e.this.D);
                    }
                } else if (i18 == e.this.f127013l) {
                    e.this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(1, e.this.f127015n, new com.tencent.luggage.wxa.zb.b(e.this.E)));
                    if (currentItem > e.this.f127004c.getAdapter().a() - 1) {
                        currentItem = e.this.f127004c.getAdapter().a() - 1;
                        e.this.f127004c.setCurrentItem(currentItem);
                    }
                    if (intValue >= e.this.f127015n) {
                        e.this.f127004c.setCurrentItem(e.this.f127015n - 1);
                    } else {
                        e.this.f127004c.setCurrentItem(intValue - 1);
                    }
                    int i26 = currentItem + 1;
                    if (i26 == e.this.f127015n) {
                        e eVar7 = e.this;
                        eVar7.a(i18, i26, 1, eVar7.f127017p, e.this.C, e.this.D);
                    } else {
                        e eVar8 = e.this;
                        eVar8.a(i18, i26, 1, 31, eVar8.C, e.this.D);
                    }
                } else {
                    e.this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(1, 12, new com.tencent.luggage.wxa.zb.b(e.this.E)));
                    e.this.f127004c.setCurrentItem(intValue - 1);
                    e eVar9 = e.this;
                    eVar9.a(i18, eVar9.f127004c.getCurrentItem() + 1, 1, 31, e.this.C, e.this.D);
                }
            }
            if (e.this.f127027z != null) {
                e.this.f127027z.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements com.tencent.luggage.wxa.bc.b {

        /* renamed from: a, reason: collision with root package name */
        public int f127030a;

        public c() {
        }

        @Override // com.tencent.luggage.wxa.bc.b
        public void a(int i3) {
            int intValue = ((Integer) e.this.f127006e.getAdapter().getItem(i3)).intValue();
            this.f127030a = ((Integer) e.this.f127007f.getAdapter().getItem(e.this.f127007f.getCurrentItem())).intValue();
            if (intValue == e.this.f127020s) {
                e.this.f127007f.setAdapter(new com.tencent.luggage.wxa.zb.c(0, e.this.f127021t));
                if (this.f127030a >= e.this.f127021t) {
                    e.this.f127007f.setCurrentItem(e.this.f127021t);
                } else {
                    e.this.f127007f.setCurrentItem(this.f127030a);
                }
            } else if (intValue == e.this.f127018q) {
                e.this.f127007f.setAdapter(new com.tencent.luggage.wxa.zb.c(e.this.f127019r, 59));
                if (this.f127030a < e.this.f127019r) {
                    e.this.f127007f.setCurrentItem(0);
                } else {
                    e.this.f127007f.setCurrentItem(this.f127030a - e.this.f127019r);
                }
            } else {
                e.this.f127007f.setAdapter(new com.tencent.luggage.wxa.zb.c(0, 59));
                e.this.f127007f.setCurrentItem(this.f127030a);
            }
            if (e.this.f127027z != null) {
                e.this.f127027z.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d implements com.tencent.luggage.wxa.bc.b {
        public d() {
        }

        @Override // com.tencent.luggage.wxa.bc.b
        public void a(int i3) {
            e.this.f127027z.a();
        }
    }

    public e(Context context) {
        String[] strArr = {"1", "3", "5", "7", "8", "10", "12"};
        this.A = strArr;
        this.C = Arrays.asList(strArr);
        this.E = context;
    }

    public void c(int i3) {
    }

    public final void h() {
    }

    public final void i() {
    }

    public final void b(int i3, int i16, int i17, int i18, int i19, int i26) {
        this.f127022u = i3;
        this.f127003b = (WheelView) this.f127002a.findViewById(R.id.l6i);
        this.f127004c = (WheelView) this.f127002a.findViewById(R.id.ezb);
        this.f127005d = (WheelView) this.f127002a.findViewById(R.id.bdu);
        com.tencent.luggage.wxa.zb.d dVar = new com.tencent.luggage.wxa.zb.d(this.f127012k, this.f127013l, this.E);
        this.f127010i = dVar;
        this.f127003b.setAdapter(dVar);
        this.f127003b.setCurrentItem(i3 - this.f127012k);
        this.f127003b.setGravity(this.f127009h);
        int i27 = this.f127012k;
        int i28 = this.f127013l;
        if (i27 == i28) {
            this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127014m, this.f127015n, new com.tencent.luggage.wxa.zb.b(this.E)));
            this.f127004c.setCurrentItem((i16 + 1) - this.f127014m);
        } else if (i3 == i27) {
            this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127014m, 12, new com.tencent.luggage.wxa.zb.b(this.E)));
            this.f127004c.setCurrentItem((i16 + 1) - this.f127014m);
        } else if (i3 == i28) {
            this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(1, this.f127015n, new com.tencent.luggage.wxa.zb.b(this.E)));
            this.f127004c.setCurrentItem(i16);
        } else if (this.f127024w && i3 - 1 == i27) {
            this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127014m, 12, new com.tencent.luggage.wxa.zb.b(this.E)));
            this.f127004c.setCurrentItem((i16 + 1) - this.f127014m);
        } else {
            this.f127004c.setAdapter(new com.tencent.luggage.wxa.zb.c(1, 12, new com.tencent.luggage.wxa.zb.b(this.E)));
            this.f127004c.setCurrentItem(i16);
        }
        this.f127004c.setGravity(this.f127009h);
        a(i3, i16, i17);
        this.f127005d.setGravity(this.f127009h);
        WheelView wheelView = (WheelView) this.f127002a.findViewById(R.id.xby);
        this.f127006e = wheelView;
        wheelView.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127018q, this.f127020s));
        this.f127006e.setCurrentItem(i18 - this.f127018q);
        this.f127006e.setGravity(this.f127009h);
        WheelView wheelView2 = (WheelView) this.f127002a.findViewById(R.id.z6s);
        this.f127007f = wheelView2;
        int i29 = this.f127018q;
        if (i18 == i29 && i29 == this.f127020s) {
            wheelView2.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127019r, this.f127021t));
            if (i19 < this.f127019r) {
                this.f127007f.setCurrentItem(0);
            } else {
                int i36 = this.f127021t;
                if (i19 > i36) {
                    this.f127007f.setCurrentItem(i36);
                } else {
                    this.f127007f.setCurrentItem(i19);
                }
            }
        } else if (i18 == i29) {
            wheelView2.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127019r, 59));
            int i37 = this.f127019r;
            if (i19 < i37) {
                this.f127007f.setCurrentItem(0);
            } else {
                this.f127007f.setCurrentItem(i19 - i37);
            }
        } else if (i18 == this.f127020s) {
            wheelView2.setAdapter(new com.tencent.luggage.wxa.zb.c(0, this.f127021t));
            int i38 = this.f127021t;
            if (i19 >= i38) {
                this.f127007f.setCurrentItem(i38);
            } else {
                this.f127007f.setCurrentItem(i19);
            }
        } else {
            wheelView2.setAdapter(new com.tencent.luggage.wxa.zb.c(0, 59));
            this.f127007f.setCurrentItem(i19);
        }
        this.f127007f.setGravity(this.f127009h);
        WheelView wheelView3 = (WheelView) this.f127002a.findViewById(R.id.f81574ej);
        this.f127008g = wheelView3;
        wheelView3.setAdapter(new com.tencent.luggage.wxa.zb.c(0, 59));
        this.f127008g.setCurrentItem(i26);
        this.f127008g.setGravity(this.f127009h);
        a();
        c();
        b();
        a(this.f127005d);
        a(this.f127006e);
        a(this.f127007f);
        a(this.f127008g);
        if (this.f127011j.length == 6) {
            a(f());
            if (this.f127024w && i3 == 2) {
                this.f127004c.d(0);
                this.f127005d.d(0);
                this.f127004c.invalidate();
                this.f127005d.invalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    public void c(int i3, int i16, int i17, int i18, int i19, int i26) {
    }

    public String d() {
        return String.valueOf(b(this.f127003b) + "-" + b(this.f127004c) + "-" + b(this.f127005d) + " " + b(this.f127006e) + ":" + b(this.f127007f) + ":" + b(this.f127008g));
    }

    public View e() {
        return this.f127002a;
    }

    public List f() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < 6; i3++) {
            if (i3 == 0) {
                this.f127003b.setVisibility(this.f127011j[i3] ? 0 : 8);
                if (this.f127011j[i3]) {
                    arrayList.add(this.f127003b);
                }
            } else if (i3 == 1) {
                this.f127004c.setVisibility(this.f127011j[i3] ? 0 : 8);
                if (this.f127011j[i3]) {
                    arrayList.add(this.f127004c);
                }
            } else if (i3 == 2) {
                this.f127005d.setVisibility(this.f127011j[i3] ? 0 : 8);
                if (this.f127011j[i3]) {
                    arrayList.add(this.f127005d);
                }
            } else if (i3 == 3) {
                this.f127006e.setVisibility(this.f127011j[i3] ? 0 : 8);
                if (this.f127011j[i3]) {
                    arrayList.add(this.f127006e);
                }
            } else if (i3 == 4) {
                this.f127007f.setVisibility(this.f127011j[i3] ? 0 : 8);
                if (this.f127011j[i3]) {
                    arrayList.add(this.f127007f);
                }
            } else if (i3 == 5) {
                this.f127008g.setVisibility(this.f127011j[i3] ? 0 : 8);
                if (this.f127011j[i3]) {
                    arrayList.add(this.f127008g);
                }
            }
        }
        return arrayList;
    }

    public final void g() {
        this.f127005d.setDividerColor(this.f127023v);
        this.f127004c.setDividerColor(this.f127023v);
        this.f127003b.setDividerColor(this.f127023v);
        this.f127006e.setDividerColor(this.f127023v);
        this.f127007f.setDividerColor(this.f127023v);
        this.f127008g.setDividerColor(this.f127023v);
    }

    public void a(View view, boolean[] zArr, int i3) {
        if (this.f127002a == null) {
            this.f127002a = view;
        }
        this.f127011j = zArr;
        this.f127009h = i3;
    }

    public final void c() {
        this.f127003b.setOnItemSelectedListener(new b());
    }

    public void c(boolean z16) {
        this.f127003b.setCyclic(z16);
        this.f127004c.setCyclic(z16);
        this.f127005d.setCyclic(z16);
        this.f127006e.setCyclic(z16);
        this.f127007f.setCyclic(z16);
        this.f127008g.setCyclic(z16);
    }

    public void a(int i3, int i16, int i17, int i18, int i19, int i26) {
        b(i3, i16, i17, i18, i19, i26);
    }

    public final void a(int i3, int i16, int i17) {
        int i18;
        int i19;
        if (this.f127024w) {
            i3--;
        }
        int i26 = this.f127012k;
        int i27 = this.f127013l;
        if (i26 == i27 && this.f127014m == this.f127015n) {
            int i28 = i16 + 1;
            if (this.C.contains(String.valueOf(i28))) {
                if (this.f127017p > 31) {
                    this.f127017p = 31;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, this.f127017p));
            } else if (this.D.contains(String.valueOf(i28))) {
                if (this.f127017p > 30) {
                    this.f127017p = 30;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, this.f127017p));
            } else if ((i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0) {
                if (this.f127017p > 29) {
                    this.f127017p = 29;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, this.f127017p));
            } else {
                if (this.f127017p > 28) {
                    this.f127017p = 28;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, this.f127017p));
            }
            this.f127005d.setCurrentItem(i17 - this.f127016o);
            return;
        }
        if (i3 == i26 && (i19 = i16 + 1) == this.f127014m) {
            if (this.C.contains(String.valueOf(i19))) {
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, 31));
            } else if (this.D.contains(String.valueOf(i19))) {
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, 30));
            } else if ((i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0) {
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, 29));
            } else {
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(this.f127016o, 28));
            }
            this.f127005d.setCurrentItem(i17 - this.f127016o);
            return;
        }
        if (i3 == i27 && (i18 = i16 + 1) == this.f127015n) {
            if (this.C.contains(String.valueOf(i18))) {
                if (this.f127017p > 31) {
                    this.f127017p = 31;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, this.f127017p));
            } else if (this.D.contains(String.valueOf(i18))) {
                if (this.f127017p > 30) {
                    this.f127017p = 30;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, this.f127017p));
            } else if ((i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0) {
                if (this.f127017p > 29) {
                    this.f127017p = 29;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, this.f127017p));
            } else {
                if (this.f127017p > 28) {
                    this.f127017p = 28;
                }
                this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, this.f127017p));
            }
            this.f127005d.setCurrentItem(i17 - 1);
            return;
        }
        int i29 = i16 + 1;
        if (this.C.contains(String.valueOf(i29))) {
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, 31));
        } else if (this.D.contains(String.valueOf(i29))) {
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, 30));
        } else if ((i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0) {
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, 29));
        } else {
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(1, 28));
        }
        this.f127005d.setCurrentItem(i17 - 1);
    }

    public void d(int i3) {
        this.f127012k = i3;
    }

    public final void a() {
        this.f127006e.setOnItemSelectedListener(new c());
    }

    public final void a(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((WheelView) it.next()).setLayoutParams(new LinearLayout.LayoutParams(0, -1, 1.0f));
        }
    }

    public final void a(WheelView wheelView) {
        if (this.f127027z != null) {
            wheelView.setOnItemSelectedListener(new d());
        }
    }

    public final void a(int i3, int i16, int i17, int i18, List list, List list2) {
        int b16 = b(this.f127005d);
        int currentItem = this.f127005d.getCurrentItem();
        if (list.contains(String.valueOf(i16))) {
            if (i18 > 31) {
                i18 = 31;
            }
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(i17, i18));
        } else if (list2.contains(String.valueOf(i16))) {
            if (i18 > 30) {
                i18 = 30;
            }
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(i17, i18));
        } else if ((i3 % 4 == 0 && i3 % 100 != 0) || i3 % 400 == 0) {
            if (i18 > 29) {
                i18 = 29;
            }
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(i17, i18));
        } else {
            if (i18 > 28) {
                i18 = 28;
            }
            this.f127005d.setAdapter(new com.tencent.luggage.wxa.zb.c(i17, i18));
        }
        if (currentItem > this.f127005d.getAdapter().a() - 1) {
            this.f127005d.setCurrentItem(this.f127005d.getAdapter().a() - 1);
        }
        if (b(this.f127005d) != b16) {
            int b17 = ((com.tencent.luggage.wxa.zb.c) this.f127005d.getAdapter()).b();
            int c16 = ((com.tencent.luggage.wxa.zb.c) this.f127005d.getAdapter()).c();
            if (b16 <= c16) {
                this.f127005d.setCurrentItem(0);
            } else if (b16 >= b17) {
                this.f127005d.setCurrentItem(r4.getAdapter().a() - 1);
            } else {
                this.f127005d.setCurrentItem(b16 - c16);
            }
        }
    }

    public final void b() {
        this.f127004c.setOnItemSelectedListener(new a());
    }

    public void b(boolean z16) {
        this.f127024w = z16;
    }

    public int b(WheelView wheelView) {
        Object item;
        if (!(wheelView.getAdapter() instanceof com.tencent.luggage.wxa.zb.c) || (item = wheelView.getAdapter().getItem(wheelView.getCurrentItem())) == null) {
            return 0;
        }
        return ((Integer) item).intValue();
    }

    public void b(int i3) {
        this.f127013l = i3;
    }

    public void b(float f16) {
        this.f127025x = f16;
        i();
    }

    public void a(boolean z16, int i3) {
        if (i3 <= 0) {
            i3 = R.string.f174502w1;
        }
        this.f127024w = z16;
        this.f127010i.a(z16, i3);
        this.f127003b.a(z16, i3);
        this.f127004c.setLongTermMonthDay(z16);
        this.f127005d.setLongTermMonthDay(z16);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6) {
        if (str != null) {
            this.f127003b.setLabel(str);
        } else {
            this.f127003b.setLabel(this.f127002a.getContext().getString(R.string.f174722wm));
        }
        if (str2 != null) {
            this.f127004c.setLabel(str2);
        } else {
            this.f127004c.setLabel(this.f127002a.getContext().getString(R.string.f174692wj));
        }
        if (str3 != null) {
            this.f127005d.setLabel(str3);
        } else {
            this.f127005d.setLabel(this.f127002a.getContext().getString(R.string.f174662wg));
        }
        if (str4 != null) {
            this.f127006e.setLabel(str4);
        } else {
            this.f127006e.setLabel(this.f127002a.getContext().getString(R.string.f174672wh));
        }
        if (str5 != null) {
            this.f127007f.setLabel(str5);
        } else {
            this.f127007f.setLabel(this.f127002a.getContext().getString(R.string.f174682wi));
        }
        if (str6 != null) {
            this.f127008g.setLabel(str6);
        } else {
            this.f127008g.setLabel(this.f127002a.getContext().getString(R.string.f174702wk));
        }
    }

    public void a(View view) {
        this.f127002a = view;
    }

    public void a(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i3 = calendar2.get(1);
            int i16 = calendar2.get(2) + 1;
            int i17 = calendar2.get(5);
            int i18 = this.f127012k;
            if (i3 > i18) {
                this.f127013l = i3;
                this.f127015n = i16;
                this.f127017p = i17;
                return;
            } else {
                if (i3 == i18) {
                    int i19 = this.f127014m;
                    if (i16 > i19) {
                        this.f127013l = i3;
                        this.f127015n = i16;
                        this.f127017p = i17;
                        return;
                    } else {
                        if (i16 != i19 || i17 <= this.f127016o) {
                            return;
                        }
                        this.f127013l = i3;
                        this.f127015n = i16;
                        this.f127017p = i17;
                        return;
                    }
                }
                return;
            }
        }
        if (calendar == null || calendar2 != null) {
            if (calendar == null || calendar2 == null) {
                return;
            }
            this.f127012k = calendar.get(1);
            this.f127013l = calendar2.get(1);
            this.f127014m = calendar.get(2) + 1;
            this.f127015n = calendar2.get(2) + 1;
            this.f127016o = calendar.get(5);
            this.f127017p = calendar2.get(5);
            this.f127018q = calendar.get(11);
            this.f127019r = calendar.get(12);
            this.f127020s = calendar2.get(11);
            this.f127021t = calendar2.get(12);
            return;
        }
        int i26 = calendar.get(1);
        int i27 = calendar.get(2) + 1;
        int i28 = calendar.get(5);
        int i29 = this.f127013l;
        if (i26 < i29) {
            this.f127014m = i27;
            this.f127016o = i28;
            this.f127012k = i26;
        } else if (i26 == i29) {
            int i36 = this.f127015n;
            if (i27 < i36) {
                this.f127014m = i27;
                this.f127016o = i28;
                this.f127012k = i26;
            } else {
                if (i27 != i36 || i28 >= this.f127017p) {
                    return;
                }
                this.f127014m = i27;
                this.f127016o = i28;
                this.f127012k = i26;
            }
        }
    }

    public void a(int i3) {
        this.f127023v = i3;
        g();
    }

    public void a(WheelView.c cVar) {
        this.f127026y = cVar;
        h();
    }

    public void a(boolean z16) {
        this.f127005d.a(z16);
        this.f127004c.a(z16);
        this.f127003b.a(z16);
        this.f127006e.a(z16);
        this.f127007f.a(z16);
        this.f127008g.a(z16);
    }

    public void a(com.tencent.luggage.wxa.fc.a aVar) {
        this.f127027z = aVar;
    }

    public void a(float f16) {
        this.f127005d.setDividerHeight(f16);
        this.f127006e.setDividerHeight(f16);
        this.f127007f.setDividerHeight(f16);
        this.f127003b.setDividerHeight(f16);
        this.f127004c.setDividerHeight(f16);
        this.f127008g.setDividerHeight(f16);
    }

    public void a(int i3, int i16, int i17, int i18) {
        this.f127005d.setPadding(i3, i16, i17, i18);
        this.f127006e.setPadding(i3, i16, i17, i18);
        this.f127007f.setPadding(i3, i16, i17, i18);
        this.f127003b.setPadding(i3, i16, i17, i18);
        this.f127004c.setPadding(i3, i16, i17, i18);
        this.f127008g.setPadding(i3, i16, i17, i18);
    }
}
