package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.cache.ClientConfigManagerImpl;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class ai extends com.vivo.push.s {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        Context context = this.f387838a;
        if (context == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + vVar + " ; mContext is Null");
            return;
        }
        if (vVar == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask pushCommand is Null");
            return;
        }
        com.vivo.push.model.b a16 = com.vivo.push.util.aa.a(context, com.vivo.push.restructure.a.a().f());
        int b16 = vVar.b();
        if (b16 != 2009) {
            if (b16 != 2011) {
                switch (b16) {
                    case 2002:
                    case 2003:
                    case 2004:
                    case 2005:
                        if (a16 != null && !a16.c()) {
                            com.vivo.push.b.c cVar = (com.vivo.push.b.c) vVar;
                            int a17 = com.vivo.push.util.y.a(cVar);
                            if (a17 != 0) {
                                com.vivo.push.m.a().a(cVar.f(), a17);
                                return;
                            }
                        } else {
                            com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1005);
                            break;
                        }
                        break;
                }
            } else {
                com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f387838a).isDebug(((com.vivo.push.b.w) vVar).d()));
            }
        } else {
            com.vivo.push.util.u.a(ClientConfigManagerImpl.getInstance(this.f387838a).isDebug());
            if (com.vivo.push.util.u.b()) {
                com.vivo.push.m.a();
                com.vivo.push.restructure.a.a().e().e();
                com.vivo.push.util.c cVar2 = new com.vivo.push.util.c();
                cVar2.a(this.f387838a, "com.vivo.push_preferences.hybridapptoken_v1");
                cVar2.a();
                com.vivo.push.util.c cVar3 = new com.vivo.push.util.c();
                cVar3.a(this.f387838a, "com.vivo.push_preferences.appconfig_v1");
                cVar3.a();
                if (!com.vivo.push.m.a().f()) {
                    ClientConfigManagerImpl.getInstance(this.f387838a).clearPush();
                }
            }
        }
        if (a16 == null) {
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + vVar + " ; pushPkgInfo is Null");
            return;
        }
        String a18 = a16.a();
        if (a16.c()) {
            try {
                com.vivo.push.m.a().a(((com.vivo.push.b.c) vVar).f(), 1004);
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            vVar = new com.vivo.push.b.e();
            com.vivo.push.util.u.d("SendCommandTask", "SendCommandTask " + vVar + " ; pkgName is InBlackList ");
        }
        com.vivo.push.a.a.a(this.f387838a, a18, vVar);
    }
}
