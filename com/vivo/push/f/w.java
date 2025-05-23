package com.vivo.push.f;

import android.text.TextUtils;
import com.vivo.push.f.u;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes13.dex */
final class w implements u.a {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f387700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f387700a = vVar;
    }

    @Override // com.vivo.push.f.u.a
    public final void a() {
        long k3 = com.vivo.push.m.a().k();
        if (k3 < 1400 && k3 != 1340) {
            com.vivo.push.util.u.b("OnNotificationArrivedTask", "\u5f15\u64ce\u7248\u672c\u592a\u4f4e\uff0c\u4e0d\u652f\u6301\u6b63\u5411\u5c55\u793a\u529f\u80fd\uff0cpushEngineSDKVersion\uff1a".concat(String.valueOf(k3)));
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("srt", "1");
        hashMap.put("message_id", String.valueOf(this.f387700a.f387698b.f()));
        String a16 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a16)) {
            hashMap.put("app_id", a16);
        }
        hashMap.put("type", "1");
        hashMap.put("dtp", "1");
        com.vivo.push.util.f.a(6L, (HashMap<String, String>) hashMap);
    }

    @Override // com.vivo.push.f.u.a
    public final void b() {
        HashMap hashMap = new HashMap();
        hashMap.put(com.heytap.mcssdk.a.a.f36093c, String.valueOf(this.f387700a.f387698b.f()));
        String a16 = com.vivo.push.restructure.a.a().e().a();
        if (!TextUtils.isEmpty(a16)) {
            hashMap.put("remoteAppId", a16);
        }
        com.vivo.push.util.f.a(2122L, (HashMap<String, String>) hashMap);
    }
}
