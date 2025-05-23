package com.qq.e.comm.plugin.tangramsplash.b;

import android.text.TextUtils;
import com.qq.e.comm.plugin.i.d;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.k.at;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends com.qq.e.comm.plugin.tangramsplash.c.b {

    /* renamed from: i, reason: collision with root package name */
    private final int f39791i;

    public a(h hVar, int i3, String str, String str2, String str3, boolean z16, int i16) {
        super(hVar, i3, str, str2, str3, z16, null);
        this.f39791i = i16;
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.c.b, com.qq.e.comm.plugin.i.a
    public void a(boolean z16) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310111, this.f39814d, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(c.f39800a.b("supplement_download" + this.f39812a.b()), Integer.MIN_VALUE, Integer.MIN_VALUE, 1, this.f39813b == 1 ? 0 : 1, this.f39812a.c(), this.f39817g, this.f39791i, Integer.MIN_VALUE, z16), this.f39816f, String.valueOf(at.a(2, this.f39814d, TextUtils.isEmpty(this.f39815e) ? this.f39812a.c() : this.f39815e).length() / 1024)));
        c.f39800a.c("supplement_download" + this.f39812a.b());
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.c.b, com.qq.e.comm.plugin.i.a
    public void b(boolean z16) {
        int i3;
        long b16 = c.f39800a.b("supplement_download" + this.f39812a.b());
        String str = this.f39814d;
        if (this.f39813b == 1) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310113, str, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(b16, Integer.MIN_VALUE, Integer.MIN_VALUE, 1, i3, this.f39812a.c(), this.f39817g, this.f39791i, Integer.MIN_VALUE, z16), this.f39816f, ""));
        c.f39800a.c("supplement_download" + this.f39812a.b());
    }

    @Override // com.qq.e.comm.plugin.tangramsplash.c.b, com.qq.e.comm.plugin.i.a
    public void a(d dVar, boolean z16) {
        com.qq.e.comm.plugin.tangramsplash.report.c.a(1310112, this.f39814d, com.qq.e.comm.plugin.tangramsplash.report.c.a(com.qq.e.comm.plugin.tangramsplash.report.c.a(c.f39800a.b("supplement_download" + this.f39812a.b()), Integer.MIN_VALUE, Integer.MIN_VALUE, 1, this.f39813b == 1 ? 0 : 1, this.f39812a.c(), this.f39817g, this.f39791i, dVar.c(), dVar.b(), Integer.MIN_VALUE, z16), this.f39816f, ""));
        c.f39800a.c("supplement_download" + this.f39812a.b());
    }
}
