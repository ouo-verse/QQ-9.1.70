package com.qq.e.comm.plugin.e.a;

import android.util.Pair;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.plugin.stat.StatTracer;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c extends a {
    private void a(int i3, int i16, com.tencent.gathererga.tangram.d dVar) {
        if (!d.a().e()) {
            return;
        }
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        if (dVar == null) {
            cVar.a("cost_time", Integer.MIN_VALUE);
            cVar.a("error_code", 1);
            cVar.a("subErrorCode", Integer.MIN_VALUE);
        } else {
            cVar.a("cost_time", Long.valueOf(dVar.c()));
            cVar.a("error_code", Integer.valueOf(1 ^ (dVar.d() ? 1 : 0)));
            cVar.a("subErrorCode", Long.valueOf(dVar.getErrorCode()));
            cVar.a("type", Integer.valueOf(dVar.a()));
        }
        StatTracer.trackEvent(i3, i16, bVar, cVar);
    }

    @Override // com.qq.e.comm.plugin.e.a.a
    protected Pair<Boolean, Boolean> c(int i3, boolean z16) {
        return new Pair<>(Boolean.TRUE, Boolean.valueOf(com.qq.e.comm.plugin.j.c.a(Constants.KEYS.DEVICE_ID_CONFIG + i3, z16 ? 1 : 0, 1)));
    }

    @Override // com.qq.e.comm.plugin.e.a.a
    protected Pair<Boolean, Object> d(int i3, boolean z16) {
        Object result;
        com.tencent.gathererga.tangram.d a16 = d.a().a(i3);
        a(80103, i3, a16);
        if (a16 != null && a16.d()) {
            Boolean bool = Boolean.TRUE;
            if (z16) {
                result = a16.b();
            } else {
                result = a16.getResult();
            }
            return new Pair<>(bool, result);
        }
        return new Pair<>(Boolean.TRUE, null);
    }
}
