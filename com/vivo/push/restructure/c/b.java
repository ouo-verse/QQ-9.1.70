package com.vivo.push.restructure.c;

import android.text.TextUtils;
import com.vivo.push.b.x;
import com.vivo.push.m;
import com.vivo.push.util.u;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes15.dex */
public final class b implements a {

    /* renamed from: a, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f387809a;

    public b(com.vivo.push.restructure.b.a aVar) {
        this.f387809a = aVar;
    }

    @Override // com.vivo.push.restructure.c.a
    public final void a(int i3, String str) {
        u.d("ReportImpl", "reportIntercepted() , msgID = " + str + ", code = " + i3);
        if (i3 > 0 && !TextUtils.isEmpty(str)) {
            x xVar = new x(i3);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.heytap.mcssdk.a.a.f36093c, str);
            com.vivo.push.restructure.b.a aVar = this.f387809a;
            if (aVar != null) {
                String a16 = aVar.a();
                if (!TextUtils.isEmpty(a16)) {
                    hashMap.put("remoteAppId", a16);
                }
            }
            xVar.a(hashMap);
            m.a().a(xVar);
        }
    }
}
