package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.cache.ClientConfigManagerImpl;
import com.vivo.push.model.InsideNotificationItem;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
public final class u extends aa {

    /* compiled from: P */
    /* loaded from: classes13.dex */
    public interface a {
        void a();

        void b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        if (vVar == null) {
            com.vivo.push.util.u.a("OnNotificationArrivedTask", "command is null");
            return;
        }
        boolean isEnablePush = ClientConfigManagerImpl.getInstance(this.f387838a).isEnablePush();
        com.vivo.push.b.q qVar = (com.vivo.push.b.q) vVar;
        Context context = this.f387838a;
        if (!com.vivo.push.util.aa.d(context, context.getPackageName())) {
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(2101L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(qVar.f()));
            String a16 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a16)) {
                hashMap.put("remoteAppId", a16);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        com.vivo.push.m.a().a(new com.vivo.push.b.h(String.valueOf(qVar.f())));
        com.vivo.push.util.u.d("OnNotificationArrivedTask", "PushMessageReceiver " + this.f387838a.getPackageName() + " isEnablePush :" + isEnablePush);
        if (!isEnablePush) {
            com.vivo.push.b.x xVar2 = new com.vivo.push.b.x(1020L);
            HashMap<String, String> hashMap2 = new HashMap<>();
            hashMap2.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(qVar.f()));
            String a17 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a17)) {
                hashMap2.put("remoteAppId", a17);
            }
            xVar2.a(hashMap2);
            com.vivo.push.m.a().a(xVar2);
            return;
        }
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f387838a), qVar.e(), qVar.g())) {
            com.vivo.push.b.x xVar3 = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap3 = new HashMap<>();
            hashMap3.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(qVar.f()));
            String a18 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a18)) {
                hashMap3.put("remoteAppId", a18);
            }
            xVar3.a(hashMap3);
            com.vivo.push.m.a().a(xVar3);
            return;
        }
        InsideNotificationItem d16 = qVar.d();
        if (d16 != null) {
            com.vivo.push.util.u.d("OnNotificationArrivedTask", "tragetType is " + d16.getTargetType() + " ; target is " + d16.getTragetContent());
            com.vivo.push.t.c(new v(this, d16, qVar));
            return;
        }
        com.vivo.push.util.u.a("OnNotificationArrivedTask", "notify is null");
        com.vivo.push.util.u.c(this.f387838a, "\u901a\u77e5\u5185\u5bb9\u4e3a\u7a7a\uff0c" + qVar.f());
        com.vivo.push.util.f.a(qVar.f(), 1027L);
    }
}
