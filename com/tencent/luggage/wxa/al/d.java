package com.tencent.luggage.wxa.al;

import android.content.Context;
import com.tencent.luggage.wxa.xg.j;
import com.tencent.mm.plugin.appbrand.video.player.thumb.ThumbMediaPlayer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class d extends com.tencent.luggage.wxa.eh.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.luggage.wxa.eh.a
    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public com.tencent.luggage.wxa.xg.a a() {
        try {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            return new ThumbMediaPlayer(context, null, true, false, false, 26, null);
        } catch (NoClassDefFoundError unused) {
            return new j();
        } catch (RuntimeException unused2) {
            return new j();
        }
    }
}
