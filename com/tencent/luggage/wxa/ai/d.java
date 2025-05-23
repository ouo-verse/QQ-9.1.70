package com.tencent.luggage.wxa.ai;

import com.tencent.luggage.wxa.j8.c;
import com.tencent.luggage.wxa.tn.h0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d implements com.tencent.luggage.wxa.j8.c {

    /* renamed from: a, reason: collision with root package name */
    public c.a f121481a;

    @Override // com.tencent.luggage.wxa.j8.c
    public void a(c.a aVar) {
        this.f121481a = aVar;
    }

    public final String b(int i3, int i16) {
        if (i3 == -1024) {
            return "VIDEO_ERROR";
        }
        if (i3 == -20000) {
            return "MEDIA_ERR_DRM";
        }
        if (i3 == -1010 || i3 == -1007) {
            return "MEDIA_ERR_SRC_NOT_SUPPORTED";
        }
        if (i3 == -1004) {
            if (!h0.j(z.c())) {
                return "MEDIA_ERR_NETWORK";
            }
            return "MEDIA_ERR_DECODE";
        }
        if (!h0.j(z.c())) {
            return "MEDIA_ERR_NETWORK";
        }
        return "MEDIA_ERR_DECODE";
    }

    @Override // com.tencent.luggage.wxa.j8.c
    public void a(int i3, int i16) {
        w.d("MicroMsg.SameLayer.AppBrandVideoErrorHandler", "onVideoError(%d, %d)", Integer.valueOf(i3), Integer.valueOf(i16));
        c.a aVar = this.f121481a;
        if (aVar != null) {
            aVar.a(b(i3, i16), i3, i16);
        }
    }
}
