package com.vivo.push.b;

import android.text.TextUtils;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class x extends com.vivo.push.v {

    /* renamed from: a, reason: collision with root package name */
    private HashMap<String, String> f387609a;

    /* renamed from: b, reason: collision with root package name */
    private long f387610b;

    public x() {
        super(2012);
    }

    public final void a(HashMap<String, String> hashMap) {
        this.f387609a = hashMap;
    }

    @Override // com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        dVar.a("ReporterCommand.EXTRA_PARAMS", this.f387609a);
        dVar.a("ReporterCommand.EXTRA_REPORTER_TYPE", this.f387610b);
    }

    @Override // com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        this.f387609a = (HashMap) dVar.d("ReporterCommand.EXTRA_PARAMS");
        this.f387610b = dVar.b("ReporterCommand.EXTRA_REPORTER_TYPE", this.f387610b);
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "ReporterCommand\uff08" + this.f387610b + ")";
    }

    public x(long j3) {
        this();
        this.f387610b = j3;
    }

    public final void d() {
        if (this.f387609a == null) {
            com.vivo.push.util.u.d("ReporterCommand", "reportParams is empty");
            return;
        }
        StringBuilder sb5 = new StringBuilder("report message reportType:");
        sb5.append(this.f387610b);
        sb5.append(",msgId:");
        String str = this.f387609a.get(com.heytap.mcssdk.a.a.f36093c);
        if (TextUtils.isEmpty(str)) {
            str = this.f387609a.get("message_id");
        }
        sb5.append(str);
        com.vivo.push.util.u.d("ReporterCommand", sb5.toString());
    }
}
