package com.tencent.luggage.wxa.e9;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes8.dex */
public class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public String f124591a;

    /* renamed from: b, reason: collision with root package name */
    public String f124592b;

    public a(String str, String str2) {
        this.f124591a = str;
        this.f124592b = str2;
    }

    @Override // com.tencent.luggage.wxa.e9.f
    public void a() {
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "runTask, appId:%s", this.f124591a);
        if (TextUtils.isEmpty(this.f124592b)) {
            com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file task");
            ArrayList e16 = com.tencent.luggage.wxa.d9.f.c().e();
            if (e16.size() > 0) {
                a(e16);
                return;
            }
            return;
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", this.f124592b, Integer.valueOf(com.tencent.luggage.wxa.d9.f.c().c(this.f124592b)));
        com.tencent.luggage.wxa.c9.d b16 = com.tencent.luggage.wxa.d9.f.c().b(this.f124592b);
        if (b16 == null || !b16.h() || b16.g()) {
            return;
        }
        b16.a(this.f124591a);
    }

    public final void a(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        String str = "";
        int i3 = 0;
        while (it.hasNext()) {
            String str2 = (String) it.next();
            com.tencent.luggage.wxa.c9.d b16 = com.tencent.luggage.wxa.d9.f.c().b(str2);
            if (b16 == null || !b16.h() || !b16.g()) {
                int c16 = com.tencent.luggage.wxa.d9.f.c().c(str2);
                if (c16 >= i3) {
                    str = str2;
                    i3 = c16;
                }
            }
        }
        com.tencent.luggage.wxa.c9.d b17 = com.tencent.luggage.wxa.d9.f.c().b(str);
        if (b17 != null && b17.h() && !b17.g()) {
            b17.a(this.f124591a);
        }
        com.tencent.luggage.wxa.m9.b.b("MicroMsg.Mix.AudioPcmDataTrackCacheToFileTask", "cache to file path :%s, size:%d", str, Integer.valueOf(i3));
    }

    @Override // com.tencent.luggage.wxa.e9.f
    public void b() {
    }
}
