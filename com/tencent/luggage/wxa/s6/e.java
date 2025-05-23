package com.tencent.luggage.wxa.s6;

import android.content.Context;
import com.tencent.luggage.wxa.q7.l;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.z1.i;
import com.tencent.luggage.wxaapi.WxaApi;
import com.tencent.magicbrush.ui.g;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class e extends i {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull h page) {
        super(page);
        Intrinsics.checkNotNullParameter(page, "page");
    }

    @Override // com.tencent.luggage.wxa.z1.i
    public com.tencent.magicbrush.ui.g b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        WxaApi.MiniGameRenderMode a16 = l.f138013a.a();
        w.d("WxaGamePageViewRenderer", "createMagicBrushView mode:" + a16);
        if (a16 == WxaApi.MiniGameRenderMode.TextureView) {
            return new com.tencent.magicbrush.ui.g(context, g.h.f147524b);
        }
        return new com.tencent.magicbrush.ui.g(context, g.h.f147523a);
    }
}
