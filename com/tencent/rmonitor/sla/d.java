package com.tencent.rmonitor.sla;

import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class d implements f {

    /* renamed from: a, reason: collision with root package name */
    private final f f365870a;

    /* compiled from: P */
    /* loaded from: classes25.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f365871a = new d();
    }

    public static f b() {
        return b.f365871a;
    }

    @Override // com.tencent.rmonitor.sla.f
    public void a(String str, int i3, int i16, long j3) {
        f fVar = this.f365870a;
        if (fVar != null) {
            fVar.a(str, i3, i16, j3);
        }
    }

    d() {
        try {
            this.f365870a = (f) AttaReportImpl.class.newInstance();
        } catch (Throwable th5) {
            try {
                Logger.f365497g.b("", "init atta report fail", th5);
            } finally {
                this.f365870a = null;
            }
        }
    }
}
