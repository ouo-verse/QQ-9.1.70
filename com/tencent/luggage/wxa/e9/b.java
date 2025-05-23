package com.tencent.luggage.wxa.e9;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b implements f {

    /* renamed from: a, reason: collision with root package name */
    public String f124593a;

    public b(String str) {
        this.f124593a = str;
    }

    @Override // com.tencent.luggage.wxa.e9.f
    public void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "runTask, appId:%s", this.f124593a);
        com.tencent.luggage.wxa.d9.f.c().a();
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "delete all pcm cache File");
        ArrayList e16 = com.tencent.luggage.wxa.d9.f.c().e();
        if (e16.size() > 0) {
            com.tencent.luggage.wxa.m9.a.a(this.f124593a, e16);
        }
    }

    @Override // com.tencent.luggage.wxa.e9.f
    public void b() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackCleanTask", "end task");
    }
}
