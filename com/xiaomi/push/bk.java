package com.xiaomi.push;

import android.content.Context;

/* compiled from: P */
/* loaded from: classes28.dex */
public class bk implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    private lz4.e f388275d;

    /* renamed from: e, reason: collision with root package name */
    private Context f388276e;

    public void a(Context context) {
        this.f388276e = context;
    }

    public void b(lz4.e eVar) {
        this.f388275d = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            lz4.e eVar = this.f388275d;
            if (eVar != null) {
                eVar.a();
            }
            jz4.c.z("begin read and send perf / event");
            lz4.e eVar2 = this.f388275d;
            if (eVar2 instanceof lz4.a) {
                ap.b(this.f388276e).d("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (eVar2 instanceof lz4.b) {
                ap.b(this.f388276e).d("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e16) {
            jz4.c.q(e16);
        }
    }
}
