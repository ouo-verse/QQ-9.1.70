package com.tencent.luggage.wxa.j6;

import android.content.Context;
import com.tencent.luggage.wxa.al.f;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.mg.h;
import com.tencent.luggage.wxa.tn.w;

/* compiled from: P */
@com.tencent.luggage.wxa.fo.b
/* loaded from: classes8.dex */
public class b extends com.tencent.luggage.wxa.eo.d implements h {
    @Override // com.tencent.luggage.wxa.mg.h
    public g a(Context context, int i3) {
        w.d("LuggageVideoViewFactoryStandaloneServiceProxy", "createVideoView, playerHint: %d", Integer.valueOf(i3));
        if ((i3 & 1) != 0) {
            w.d("LuggageVideoViewFactoryStandaloneServiceProxy", "createVideoView, canRewardVideoUseThumbPlayer: %b", Boolean.TRUE);
            if ((i3 & 2) != 0) {
                w.d("LuggageVideoViewFactoryStandaloneServiceProxy", "createVideoView, use Mp4OnlyThumbVideoViewWrapper");
                return new f(context);
            }
            w.d("LuggageVideoViewFactoryStandaloneServiceProxy", "createVideoView, use AppBrandThumbVideoViewWrapper");
            return new com.tencent.luggage.wxa.al.c(context);
        }
        w.d("LuggageVideoViewFactoryStandaloneServiceProxy", "createVideoView, playerType: 5");
        w.d("LuggageVideoViewFactoryStandaloneServiceProxy", "createVideoView, use AppBrandThumbVideoViewWrapper");
        return new com.tencent.luggage.wxa.al.c(context);
    }

    @Override // com.tencent.luggage.wxa.mg.h
    public String getName() {
        return "LuggageVideoViewFactoryStandaloneServiceProxy";
    }
}
