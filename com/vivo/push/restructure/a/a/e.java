package com.vivo.push.restructure.a.a;

import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;
import com.vivo.push.util.u;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes15.dex */
public final class e extends a<com.vivo.push.restructure.a.a> {
    public e(com.vivo.push.restructure.a.a aVar, i iVar) {
        super("ClientDispatchNode", aVar, iVar);
    }

    private static PushMessageCallback b(com.vivo.push.restructure.a.a aVar) {
        try {
            return (PushMessageCallback) Class.forName(com.vivo.push.restructure.a.a().e().a(com.vivo.push.restructure.a.a().b(), aVar.b().getAction())).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e16) {
            u.b("DispatchNode", "reflect e: ", e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.vivo.push.restructure.a.a.a
    public int a(com.vivo.push.restructure.a.a aVar) {
        PushMessageCallback b16 = b(aVar);
        if (b16 == null) {
            return 2804;
        }
        int i3 = 0;
        if (aVar != null && aVar.g()) {
            com.vivo.push.restructure.request.d.a().a(aVar);
            return 0;
        }
        if (aVar != null) {
            int k3 = aVar.k();
            String l3 = aVar.l();
            if (k3 == 3) {
                String i16 = com.vivo.push.m.a().i();
                if (TextUtils.isEmpty(i16) || !TextUtils.equals(i16, l3)) {
                    i3 = 2810;
                }
            } else if (k3 == 4) {
                com.vivo.push.m.a();
                if (!com.vivo.push.m.c().contains(l3)) {
                    i3 = 2811;
                }
            }
            if (i3 != 0) {
                com.vivo.push.util.g.a().execute(new f(this, k3, l3));
                return i3;
            }
        }
        try {
            return com.vivo.push.m.a().a(aVar.b(), b16);
        } catch (Exception unused) {
            return 2808;
        }
    }
}
