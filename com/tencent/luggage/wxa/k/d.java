package com.tencent.luggage.wxa.k;

import android.content.Context;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import com.tencent.luggage.wxa.k.i;

/* compiled from: P */
/* loaded from: classes8.dex */
public class d extends c {
    public d(i.a aVar, o oVar, Context context) {
        super(aVar, oVar, context);
    }

    @Override // com.tencent.luggage.wxa.k.c
    public void a(r rVar, StreamConfigurationMap streamConfigurationMap) {
        if (streamConfigurationMap.getHighResolutionOutputSizes(256) != null) {
            for (Size size : streamConfigurationMap.getHighResolutionOutputSizes(256)) {
                rVar.a(new q(size.getWidth(), size.getHeight()));
            }
        }
        if (rVar.b() || rVar.b(b()) == null) {
            super.a(rVar, streamConfigurationMap);
        }
    }
}
