package com.tencent.luggage.wxa.t1;

import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.tencent.luggage.wxa.ei.l;
import com.tencent.luggage.wxa.rc.r;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class d implements com.tencent.luggage.wxa.i.d {

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface a {
        String b();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface b extends a {
        r getFileSystem();
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public interface c extends a {
        int a();

        String a(ImageDecodeConfig.ReferrerPolicy referrerPolicy);

        int d();

        String getUserAgentString();
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t1.d$d, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC6731d extends a {
        l c();
    }

    public d(a aVar) {
        w.d("MicroMsg.BaseImageStreamFetcherWxa", "hy: construct fetcher with config %s env %s", aVar.getClass().getSimpleName(), aVar.b());
    }
}
