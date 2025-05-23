package com.tencent.mobileqq.qqexpand.bean.chat;

import java.util.ArrayList;
import vg2.e;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public String f263444a;

    /* renamed from: b, reason: collision with root package name */
    public String f263445b;

    /* renamed from: c, reason: collision with root package name */
    public String f263446c;

    /* renamed from: d, reason: collision with root package name */
    public String f263447d;

    /* renamed from: e, reason: collision with root package name */
    public String f263448e;

    /* renamed from: f, reason: collision with root package name */
    public ArrayList<e> f263449f;

    /* renamed from: g, reason: collision with root package name */
    public String f263450g;

    /* renamed from: h, reason: collision with root package name */
    public int f263451h;

    /* renamed from: i, reason: collision with root package name */
    public String f263452i;

    /* renamed from: j, reason: collision with root package name */
    public String f263453j;

    /* renamed from: k, reason: collision with root package name */
    public int f263454k;

    /* renamed from: l, reason: collision with root package name */
    public String f263455l;

    /* renamed from: p, reason: collision with root package name */
    public long f263459p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList<b> f263460q;

    /* renamed from: m, reason: collision with root package name */
    public int f263456m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f263457n = 0;

    /* renamed from: o, reason: collision with root package name */
    public int f263458o = 0;

    /* renamed from: r, reason: collision with root package name */
    public int f263461r = -1;

    /* renamed from: s, reason: collision with root package name */
    public int f263462s = -1;

    /* renamed from: t, reason: collision with root package name */
    public String f263463t = "";

    /* renamed from: u, reason: collision with root package name */
    public String f263464u = "";

    public String toString() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("{friendUin: ");
        sb5.append(this.f263444a);
        sb5.append("}");
        sb5.append("{age: ");
        sb5.append(this.f263445b);
        sb5.append("}");
        sb5.append("{constellation: ");
        sb5.append(this.f263446c);
        sb5.append("}");
        sb5.append("{city: ");
        sb5.append(this.f263447d);
        sb5.append("}");
        sb5.append("{school: ");
        sb5.append(this.f263448e);
        sb5.append("}");
        sb5.append("{constel:");
        sb5.append(this.f263446c);
        sb5.append("}");
        sb5.append("{company:");
        sb5.append(this.f263450g);
        sb5.append("}");
        sb5.append("{mGender: ");
        sb5.append(this.f263451h);
        sb5.append("}");
        sb5.append("{mDeclaration: ");
        sb5.append(this.f263452i);
        sb5.append("}");
        sb5.append("{mVoiceUrl: ");
        sb5.append(this.f263453j);
        sb5.append("}");
        sb5.append("{mVoiceDuration: ");
        sb5.append(this.f263454k);
        sb5.append("}");
        sb5.append("{signWords: ");
        sb5.append(this.f263455l);
        sb5.append("}");
        if (this.f263449f == null) {
            sb5.append("{personalTags: is empty ");
            sb5.append("}");
        } else {
            sb5.append("{personalTags:size  ");
            sb5.append(this.f263449f.size());
            sb5.append("}");
        }
        sb5.append("{popular: ");
        sb5.append(this.f263459p);
        sb5.append("}");
        if (this.f263460q == null) {
            sb5.append("{schoolInfo: is empty ");
            sb5.append("}");
        } else {
            sb5.append("{schoolInfo:size  ");
            sb5.append(this.f263460q.size());
            sb5.append("}");
        }
        sb5.append("{distance: ");
        sb5.append(this.f263461r);
        sb5.append("}");
        sb5.append("{signalBombMatchPool: ");
        sb5.append(this.f263462s);
        sb5.append("}");
        sb5.append("{strFromCity: ");
        sb5.append(this.f263463t);
        sb5.append("}");
        sb5.append("{strToCity: ");
        sb5.append(this.f263464u);
        sb5.append("}");
        return sb5.toString();
    }
}
