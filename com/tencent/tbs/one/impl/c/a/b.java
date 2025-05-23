package com.tencent.tbs.one.impl.c.a;

import android.content.Intent;
import com.tencent.tbs.one.optional.TBSOneStandaloneService;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends TBSOneStandaloneService.ServiceImpl {
    @Override // com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl
    public void onDestroy() {
        super.onDestroy();
        System.exit(0);
    }

    @Override // com.tencent.tbs.one.optional.TBSOneStandaloneService.ServiceImpl
    public int onStartCommand(Intent intent, int i3, int i16) {
        if (intent != null) {
            String stringExtra = intent.getStringExtra("dexPath");
            String stringExtra2 = intent.getStringExtra("dexName");
            String stringExtra3 = intent.getStringExtra("optimizedDirectory");
            String stringExtra4 = intent.getStringExtra("librarySearchPath");
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.tbs.one.impl.a.g.a("Optimizing dex %s in standalone service", stringExtra);
            d.a(stringExtra2, stringExtra, stringExtra3, stringExtra4, this.f375107a.getClassLoader());
            com.tencent.tbs.one.impl.a.g.a("Optimized dex %s in standalone service, cost %dms", stringExtra, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        }
        return 2;
    }
}
