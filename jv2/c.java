package jv2;

import android.net.Uri;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b f411008a;

    /* renamed from: b, reason: collision with root package name */
    private int f411009b;

    /* renamed from: c, reason: collision with root package name */
    private String f411010c;

    /* renamed from: d, reason: collision with root package name */
    private String f411011d = "javascript:try {%s.callback(%d, %d ,%b ,%s, %b, %d);}catch(e){}";

    public c(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.js.b bVar, int i3) {
        this.f411008a = bVar;
        this.f411009b = i3;
    }

    public void a(String str) {
        b(false, str);
    }

    public void b(boolean z16, String str) {
        String str2;
        StringBuilder sb5 = new StringBuilder();
        if (z16) {
            sb5.append(Uri.encode(String.valueOf(str)));
        } else {
            sb5.append(str);
        }
        if (z16) {
            str2 = "\"" + sb5.toString() + "\"";
        } else {
            str2 = "'" + sb5.toString() + "'";
        }
        String format = String.format(this.f411011d, this.f411010c, Integer.valueOf(this.f411009b), 0, Boolean.valueOf(z16), str2, Boolean.FALSE, 0);
        n.a("JsCallback", format);
        this.f411008a.a(format);
    }

    public void c(String str) {
        this.f411010c = str;
    }
}
