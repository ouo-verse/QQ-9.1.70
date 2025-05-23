package com.tencent.beacon.base.net.a;

import android.text.TextUtils;
import com.tencent.beacon.base.net.call.JceRequestEntity;
import com.tencent.beacon.d.h;
import com.tencent.beacon.pack.SocketRequestPackage;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class d implements c<JceRequestEntity, SocketRequestPackage> {
    private Map<String, String> b(JceRequestEntity jceRequestEntity) {
        Map<String, String> header = jceRequestEntity.getHeader();
        if (!header.containsKey("sid")) {
            String d16 = h.c().d();
            if (!TextUtils.isEmpty(d16)) {
                header.put("sid", d16);
            }
        }
        return header;
    }

    @Override // com.tencent.beacon.base.net.a.c
    public SocketRequestPackage a(JceRequestEntity jceRequestEntity) {
        return new SocketRequestPackage(b(jceRequestEntity), jceRequestEntity.getContent());
    }
}
