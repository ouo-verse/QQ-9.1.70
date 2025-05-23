package com.xiaomi.push;

import android.os.Bundle;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fb extends fc {
    private String A;
    private boolean B;

    /* renamed from: p, reason: collision with root package name */
    private String f388805p;

    /* renamed from: q, reason: collision with root package name */
    private String f388806q;

    /* renamed from: r, reason: collision with root package name */
    private String f388807r;

    /* renamed from: s, reason: collision with root package name */
    private String f388808s;

    /* renamed from: t, reason: collision with root package name */
    private String f388809t;

    /* renamed from: u, reason: collision with root package name */
    private String f388810u;

    /* renamed from: v, reason: collision with root package name */
    private boolean f388811v;

    /* renamed from: w, reason: collision with root package name */
    private String f388812w;

    /* renamed from: x, reason: collision with root package name */
    private String f388813x;

    /* renamed from: y, reason: collision with root package name */
    private String f388814y;

    /* renamed from: z, reason: collision with root package name */
    private String f388815z;

    public fb() {
        this.f388805p = null;
        this.f388806q = null;
        this.f388811v = false;
        this.f388813x = "";
        this.f388814y = "";
        this.f388815z = "";
        this.A = "";
        this.B = false;
    }

    public void A(boolean z16) {
        this.f388811v = z16;
    }

    public String B() {
        return this.f388805p;
    }

    public void C(String str) {
        this.f388813x = str;
    }

    public void D(boolean z16) {
        this.B = z16;
    }

    public String E() {
        return this.f388812w;
    }

    public void F(String str) {
        this.f388814y = str;
    }

    public String G() {
        return this.f388813x;
    }

    public void H(String str) {
        this.f388815z = str;
    }

    public String I() {
        return this.f388814y;
    }

    public void J(String str) {
        this.A = str;
    }

    public String K() {
        return this.f388815z;
    }

    public void L(String str) {
        this.f388805p = str;
    }

    public String M() {
        return this.A;
    }

    public void N(String str) {
        this.f388808s = str;
    }

    public String O() {
        return this.f388807r;
    }

    public void P(String str) {
        this.f388809t = str;
    }

    public void Q(String str) {
        this.f388806q = str;
    }

    public void R(String str) {
        this.f388807r = str;
    }

    @Override // com.xiaomi.push.fc
    public Bundle a() {
        Bundle a16 = super.a();
        if (!TextUtils.isEmpty(this.f388805p)) {
            a16.putString("ext_msg_type", this.f388805p);
        }
        String str = this.f388807r;
        if (str != null) {
            a16.putString("ext_msg_lang", str);
        }
        String str2 = this.f388808s;
        if (str2 != null) {
            a16.putString("ext_msg_sub", str2);
        }
        String str3 = this.f388809t;
        if (str3 != null) {
            a16.putString("ext_msg_body", str3);
        }
        if (!TextUtils.isEmpty(this.f388810u)) {
            a16.putString("ext_body_encode", this.f388810u);
        }
        String str4 = this.f388806q;
        if (str4 != null) {
            a16.putString("ext_msg_thread", str4);
        }
        String str5 = this.f388812w;
        if (str5 != null) {
            a16.putString("ext_msg_appid", str5);
        }
        if (this.f388811v) {
            a16.putBoolean("ext_msg_trans", true);
        }
        if (!TextUtils.isEmpty(this.f388813x)) {
            a16.putString("ext_msg_seq", this.f388813x);
        }
        if (!TextUtils.isEmpty(this.f388814y)) {
            a16.putString("ext_msg_mseq", this.f388814y);
        }
        if (!TextUtils.isEmpty(this.f388815z)) {
            a16.putString("ext_msg_fseq", this.f388815z);
        }
        if (this.B) {
            a16.putBoolean("ext_msg_encrypt", true);
        }
        if (!TextUtils.isEmpty(this.A)) {
            a16.putString("ext_msg_status", this.A);
        }
        return a16;
    }

    @Override // com.xiaomi.push.fc
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        fb fbVar = (fb) obj;
        if (!super.equals(fbVar)) {
            return false;
        }
        String str = this.f388809t;
        if (str == null ? fbVar.f388809t != null : !str.equals(fbVar.f388809t)) {
            return false;
        }
        String str2 = this.f388807r;
        if (str2 == null ? fbVar.f388807r != null : !str2.equals(fbVar.f388807r)) {
            return false;
        }
        String str3 = this.f388808s;
        if (str3 == null ? fbVar.f388808s != null : !str3.equals(fbVar.f388808s)) {
            return false;
        }
        String str4 = this.f388806q;
        if (str4 == null ? fbVar.f388806q != null : !str4.equals(fbVar.f388806q)) {
            return false;
        }
        if (this.f388805p == fbVar.f388805p) {
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.fc
    public String f() {
        ff d16;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("<message");
        if (w() != null) {
            sb5.append(" xmlns=\"");
            sb5.append(w());
            sb5.append("\"");
        }
        if (this.f388807r != null) {
            sb5.append(" xml:lang=\"");
            sb5.append(O());
            sb5.append("\"");
        }
        if (l() != null) {
            sb5.append(" id=\"");
            sb5.append(l());
            sb5.append("\"");
        }
        if (o() != null) {
            sb5.append(" to=\"");
            sb5.append(fm.b(o()));
            sb5.append("\"");
        }
        if (!TextUtils.isEmpty(G())) {
            sb5.append(" seq=\"");
            sb5.append(G());
            sb5.append("\"");
        }
        if (!TextUtils.isEmpty(I())) {
            sb5.append(" mseq=\"");
            sb5.append(I());
            sb5.append("\"");
        }
        if (!TextUtils.isEmpty(K())) {
            sb5.append(" fseq=\"");
            sb5.append(K());
            sb5.append("\"");
        }
        if (!TextUtils.isEmpty(M())) {
            sb5.append(" status=\"");
            sb5.append(M());
            sb5.append("\"");
        }
        if (q() != null) {
            sb5.append(" from=\"");
            sb5.append(fm.b(q()));
            sb5.append("\"");
        }
        if (m() != null) {
            sb5.append(" chid=\"");
            sb5.append(fm.b(m()));
            sb5.append("\"");
        }
        if (this.f388811v) {
            sb5.append(" transient=\"true\"");
        }
        if (!TextUtils.isEmpty(this.f388812w)) {
            sb5.append(" appid=\"");
            sb5.append(E());
            sb5.append("\"");
        }
        if (!TextUtils.isEmpty(this.f388805p)) {
            sb5.append(" type=\"");
            sb5.append(this.f388805p);
            sb5.append("\"");
        }
        if (this.B) {
            sb5.append(" s=\"1\"");
        }
        sb5.append(">");
        if (this.f388808s != null) {
            sb5.append("<subject>");
            sb5.append(fm.b(this.f388808s));
            sb5.append("</subject>");
        }
        if (this.f388809t != null) {
            sb5.append("<body");
            if (!TextUtils.isEmpty(this.f388810u)) {
                sb5.append(" encode=\"");
                sb5.append(this.f388810u);
                sb5.append("\"");
            }
            sb5.append(">");
            sb5.append(fm.b(this.f388809t));
            sb5.append("</body>");
        }
        if (this.f388806q != null) {
            sb5.append("<thread>");
            sb5.append(this.f388806q);
            sb5.append("</thread>");
        }
        if ("error".equalsIgnoreCase(this.f388805p) && (d16 = d()) != null) {
            sb5.append(d16.b());
        }
        sb5.append(u());
        sb5.append("</message>");
        return sb5.toString();
    }

    @Override // com.xiaomi.push.fc
    public int hashCode() {
        int i3;
        int i16;
        int i17;
        int i18;
        String str = this.f388805p;
        int i19 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i26 = i3 * 31;
        String str2 = this.f388809t;
        if (str2 != null) {
            i16 = str2.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        String str3 = this.f388806q;
        if (str3 != null) {
            i17 = str3.hashCode();
        } else {
            i17 = 0;
        }
        int i28 = (i27 + i17) * 31;
        String str4 = this.f388807r;
        if (str4 != null) {
            i18 = str4.hashCode();
        } else {
            i18 = 0;
        }
        int i29 = (i28 + i18) * 31;
        String str5 = this.f388808s;
        if (str5 != null) {
            i19 = str5.hashCode();
        }
        return i29 + i19;
    }

    public void y(String str) {
        this.f388812w = str;
    }

    public void z(String str, String str2) {
        this.f388809t = str;
        this.f388810u = str2;
    }

    public fb(Bundle bundle) {
        super(bundle);
        this.f388805p = null;
        this.f388806q = null;
        this.f388811v = false;
        this.f388813x = "";
        this.f388814y = "";
        this.f388815z = "";
        this.A = "";
        this.B = false;
        this.f388805p = bundle.getString("ext_msg_type");
        this.f388807r = bundle.getString("ext_msg_lang");
        this.f388806q = bundle.getString("ext_msg_thread");
        this.f388808s = bundle.getString("ext_msg_sub");
        this.f388809t = bundle.getString("ext_msg_body");
        this.f388810u = bundle.getString("ext_body_encode");
        this.f388812w = bundle.getString("ext_msg_appid");
        this.f388811v = bundle.getBoolean("ext_msg_trans", false);
        this.B = bundle.getBoolean("ext_msg_encrypt", false);
        this.f388813x = bundle.getString("ext_msg_seq");
        this.f388814y = bundle.getString("ext_msg_mseq");
        this.f388815z = bundle.getString("ext_msg_fseq");
        this.A = bundle.getString("ext_msg_status");
    }
}
