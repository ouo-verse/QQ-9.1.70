package com.tencent.luggage.wxa.z6;

import android.text.TextUtils;
import com.tencent.luggage.wxa.q7.r;
import com.tencent.luggage.wxa.tn.w0;
import com.tencent.luggage.wxa.xd.d;
import com.tencent.luggage.wxa.xd.i;
import com.tencent.luggage.wxa.xd.o;

/* compiled from: P */
/* loaded from: classes9.dex */
public class c extends com.tencent.luggage.wxa.ic.c {

    /* renamed from: d, reason: collision with root package name */
    public final com.tencent.luggage.wxa.g7.d f146346d;

    /* renamed from: e, reason: collision with root package name */
    public final i f146347e;

    /* renamed from: f, reason: collision with root package name */
    public final a f146348f;

    public c(com.tencent.luggage.wxa.g7.d dVar, i iVar) {
        super(dVar, iVar, dVar.B1());
        this.f146346d = dVar;
        this.f146347e = iVar;
        this.f146348f = dVar.getApiReporter();
    }

    public final String a() {
        if (this.f146346d.Q1()) {
            try {
                return w0.d(this.f146346d.S().f125813f);
            } catch (Exception unused) {
                return "";
            }
        }
        com.tencent.luggage.wxa.y4.b Y = this.f146346d.Y();
        if (Y == null) {
            return null;
        }
        return Y.getCurrentUrl();
    }

    @Override // com.tencent.luggage.wxa.ic.c, com.tencent.luggage.wxa.xd.d.c
    public boolean a(o oVar, String str, String str2, int i3, d.b bVar) {
        this.f146348f.a(i3, this.f146347e, oVar, str, a());
        return super.a(oVar, str, str2, i3, bVar);
    }

    @Override // com.tencent.luggage.wxa.ic.c
    public void a(o oVar, String str, String str2, int i3, int i16) {
        super.a(oVar, str, str2, i3, i16);
        this.f146348f.a(i3, i16);
    }

    @Override // com.tencent.luggage.wxa.ic.c, com.tencent.luggage.wxa.xd.d.c
    public void a(int i3, String str) {
        super.a(i3, str);
        this.f146348f.a(i3, str);
    }

    @Override // com.tencent.luggage.wxa.ic.c, com.tencent.luggage.wxa.xd.d.c
    public void a(o oVar, String str, String str2, int i3, String str3) {
        super.a(oVar, str, str2, i3, str3);
        if (TextUtils.isEmpty(str3)) {
            return;
        }
        if (r.a() && "fail:internal error invalid js component".equals(str3)) {
            throw new ClassCastException(String.format("Mismatch api(%s) component", oVar.getName()));
        }
        this.f146348f.a(i3, str3);
    }
}
