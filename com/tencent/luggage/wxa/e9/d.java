package com.tencent.luggage.wxa.e9;

import com.tencent.luggage.wxa.g9.k;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d {
    public void a(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cleanAllCache appId:%s", str);
        a(new b(str), "AudioPcmDataTrackCleanTask");
    }

    public void b(String str) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", str);
        a(new c(str), "AudioPcmDataTrackRecycleCacheTask");
    }

    public void a(String str, String str2) {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", str, str2);
        a(new a(str, str2), "AudioPcmDataTrackCacheToFileTask");
    }

    public void a(f fVar, String str) {
        e eVar = new e(fVar, str, 5);
        k.a();
        k.b(eVar);
    }
}
