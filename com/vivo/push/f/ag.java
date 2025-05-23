package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.util.NotifyAdapterUtil;
import java.util.HashMap;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class ag extends aa {
    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(com.vivo.push.v vVar) {
        super(vVar);
    }

    @Override // com.vivo.push.s
    protected final void a(com.vivo.push.v vVar) {
        com.vivo.push.b.u uVar = (com.vivo.push.b.u) vVar;
        if (com.vivo.push.m.a().g() && !a(com.vivo.push.util.ag.c(this.f387838a), uVar.e(), uVar.g())) {
            com.vivo.push.util.u.d("OnUndoMsgTask", " vertify msg is error ");
            com.vivo.push.b.x xVar = new com.vivo.push.b.x(1021L);
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(uVar.f()));
            String a16 = com.vivo.push.restructure.a.a().e().a();
            if (!TextUtils.isEmpty(a16)) {
                hashMap.put("remoteAppId", a16);
            }
            xVar.a(hashMap);
            com.vivo.push.m.a().a(xVar);
            return;
        }
        boolean repealNotifyById = NotifyAdapterUtil.repealNotifyById(this.f387838a, uVar.d());
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message " + uVar.d() + ", " + repealNotifyById);
        if (repealNotifyById) {
            com.vivo.push.util.u.b(this.f387838a, "\u56de\u6536client\u901a\u77e5\u6210\u529f, \u4e0a\u62a5\u57cb\u70b9 1031, messageId = " + uVar.d());
            com.vivo.push.util.f.a(uVar.d(), 1031L);
            return;
        }
        com.vivo.push.util.u.d("OnUndoMsgTask", "undo message fail\uff0cmessageId = " + uVar.d());
        com.vivo.push.util.u.c(this.f387838a, "\u56de\u6536client\u901a\u77e5\u5931\u8d25\uff0cmessageId = " + uVar.d());
    }
}
