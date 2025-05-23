package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetResponse;
import com.tencent.mapsdk.shell.events.NetFlowEvent;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public class gr extends md {
    public gr() {
    }

    private void a() {
        u.a();
        new NetFlowEvent(this.f149302a);
    }

    @Override // com.tencent.mapsdk.internal.md, com.tencent.map.tools.net.processor.ResponseProcessor
    public void onResponse(NetResponse netResponse) throws Exception {
        super.onResponse(netResponse);
        u.a();
        new NetFlowEvent(this.f149302a);
    }

    gr(HashMap<String, String> hashMap) {
        super(hashMap);
    }
}
