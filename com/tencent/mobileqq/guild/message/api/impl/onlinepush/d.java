package com.tencent.mobileqq.guild.message.api.impl.onlinepush;

import android.text.TextUtils;
import com.tencent.mobileqq.guild.message.api.impl.onlinepush.e;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes14.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private long f230236a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f230237b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f230238c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f230239d = 0;

    /* renamed from: e, reason: collision with root package name */
    private long f230240e = 0;

    /* renamed from: f, reason: collision with root package name */
    private long f230241f = 0;

    /* renamed from: g, reason: collision with root package name */
    private long f230242g = 0;

    /* renamed from: h, reason: collision with root package name */
    private long f230243h = 0;

    /* renamed from: i, reason: collision with root package name */
    private long f230244i = 0;

    /* renamed from: j, reason: collision with root package name */
    private long f230245j = 0;

    /* renamed from: k, reason: collision with root package name */
    private long f230246k = 0;

    /* renamed from: l, reason: collision with root package name */
    private long f230247l = 0;

    /* renamed from: m, reason: collision with root package name */
    private long f230248m = 0;

    /* renamed from: n, reason: collision with root package name */
    private long f230249n = 0;

    /* renamed from: o, reason: collision with root package name */
    private Set<String> f230250o = new HashSet();

    /* renamed from: p, reason: collision with root package name */
    private long f230251p = 0;

    /* renamed from: q, reason: collision with root package name */
    private long f230252q = 0;

    /* renamed from: r, reason: collision with root package name */
    private NumberFormat f230253r = NumberFormat.getPercentInstance();

    /* renamed from: s, reason: collision with root package name */
    private HashMap<Long, ArrayList<Long>> f230254s = new HashMap<>();

    /* renamed from: t, reason: collision with root package name */
    private HashMap<Long, ArrayList<Long>> f230255t = new HashMap<>();

    public d() {
        this.f230253r.setMaximumFractionDigits(1);
    }

    public String a() {
        String format;
        long j3 = this.f230239d + this.f230241f;
        long j16 = this.f230236a + this.f230237b + this.f230240e;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("alldiscard: ");
        sb5.append(j3);
        sb5.append("/");
        sb5.append(j16);
        sb5.append("/");
        if (j16 == 0) {
            format = "0%";
        } else {
            format = this.f230253r.format(((float) j3) / ((float) j16));
        }
        sb5.append(format);
        return sb5.toString();
    }

    public String b() {
        return "hugeconsume:" + this.f230243h + "  norconsume:" + this.f230244i;
    }

    public String c() {
        String format;
        long j3 = this.f230236a + this.f230237b;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("hugediscard: ");
        sb5.append(this.f230239d);
        sb5.append("/");
        sb5.append(j3);
        sb5.append("(");
        sb5.append(this.f230236a);
        sb5.append(",");
        sb5.append(this.f230237b);
        sb5.append(")");
        sb5.append("/");
        if (j3 == 0) {
            format = "0%";
        } else {
            format = this.f230253r.format(((float) this.f230239d) / ((float) j3));
        }
        sb5.append(format);
        return sb5.toString();
    }

    public String d() {
        String str = "msgseqsdis:" + this.f230255t.toString();
        this.f230255t.clear();
        return str;
    }

    public String e() {
        String str = "msgseqspush:" + this.f230254s.toString();
        this.f230254s.clear();
        return str;
    }

    public String f() {
        String format;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("nordiscard: ");
        sb5.append(this.f230241f);
        sb5.append("/");
        sb5.append(this.f230240e);
        sb5.append("/");
        if (this.f230240e == 0) {
            format = "0%";
        } else {
            format = this.f230253r.format(((float) this.f230241f) / ((float) r1));
        }
        sb5.append(format);
        return sb5.toString();
    }

    public String g() {
        return "producertasklen:" + this.f230245j;
    }

    public String h() {
        return "packcnt:" + this.f230246k;
    }

    public void i(boolean z16, long j3) {
        if (z16) {
            this.f230243h += j3;
        } else {
            this.f230244i += j3;
        }
    }

    public void j(boolean z16, long j3) {
        if (z16) {
            this.f230239d += j3;
        } else {
            this.f230241f += j3;
        }
    }

    public void k(Long l3, List<Long> list) {
        if (!this.f230255t.containsKey(l3)) {
            this.f230255t.put(l3, new ArrayList<>());
        }
        this.f230255t.get(l3).addAll(list);
    }

    public void l(int i3) {
        if (i3 == 1) {
            this.f230247l++;
        } else if (i3 == 2) {
            this.f230248m++;
        }
    }

    public void m(boolean z16, List<e.h> list) {
        if (z16) {
            for (e.h hVar : list) {
                if (!hVar.f230308d) {
                    this.f230238c++;
                }
                if (hVar.f230305a != 3841 && hVar.f230306b == 0) {
                    this.f230237b++;
                } else {
                    this.f230236a++;
                }
            }
            return;
        }
        Iterator<e.h> it = list.iterator();
        while (it.hasNext()) {
            if (!it.next().f230308d) {
                this.f230242g++;
            }
        }
        this.f230240e += list.size();
    }

    public void n(String str) {
        this.f230249n++;
        if (!TextUtils.isEmpty(str)) {
            this.f230250o.add(str);
        }
    }

    public void o(int i3) {
        this.f230246k += i3;
    }

    public void p(Long l3, List<Long> list) {
        if (!this.f230254s.containsKey(l3)) {
            this.f230254s.put(l3, new ArrayList<>());
        }
        this.f230254s.get(l3).addAll(list);
    }

    public void q(long j3) {
        this.f230245j = j3;
    }
}
