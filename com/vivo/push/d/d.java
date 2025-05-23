package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.restructure.request.IPushRequestCallback;
import com.vivo.push.util.u;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public final class d implements a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(d dVar, String str, IPushRequestCallback iPushRequestCallback, int i3) {
        if (com.vivo.push.restructure.a.a().g().b() != 0) {
            u.b("core not support sync profileInfo");
            if (iPushRequestCallback != null) {
                iPushRequestCallback.onError(8102);
                return;
            }
        }
        Context b16 = com.vivo.push.restructure.a.a().b();
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            arrayList.add(new b(str));
        }
        com.vivo.push.restructure.request.d.a().a(new com.vivo.push.restructure.request.b(new com.vivo.push.d.a.a(new com.vivo.push.d.a.b(b16.getPackageName(), arrayList, i3)), new j(dVar, iPushRequestCallback, i3), (byte) 0));
    }

    @Override // com.vivo.push.d.a
    public final void addProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new e(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.d.a
    public final void deleteAllProfileId(IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new g(this, iPushRequestCallback));
    }

    @Override // com.vivo.push.d.a
    public final void deleteProfileId(String str, IPushRequestCallback<Integer> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new f(this, str, iPushRequestCallback));
    }

    @Override // com.vivo.push.d.a
    public final void queryProfileIds(IPushRequestCallback<List<String>> iPushRequestCallback) {
        com.vivo.push.util.g.a().execute(new h(this, iPushRequestCallback));
    }
}
