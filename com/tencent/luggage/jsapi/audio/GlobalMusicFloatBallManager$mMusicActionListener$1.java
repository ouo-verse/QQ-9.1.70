package com.tencent.luggage.jsapi.audio;

import com.tencent.luggage.wxa.p9.h;
import com.tencent.luggage.wxa.rb.a;
import com.tencent.luggage.wxa.rb.d;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/luggage/jsapi/audio/GlobalMusicFloatBallManager$mMusicActionListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/luggage/wxa/p9/h;", "event", "", "a", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class GlobalMusicFloatBallManager$mMusicActionListener$1 extends IListener<h> {
    @Override // com.tencent.mm.sdk.event.IListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean callback(h event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        w.g("MicroMsg.GlobalMusicFloatBallManager", "alvinluo dispatchMusicPlayerEvent action: %s", Integer.valueOf(event.f137468d.f137469a));
        int i3 = event.f137468d.f137469a;
        if (i3 == 0 || i3 == 1) {
            d b16 = a.b();
            if (b16 != null && !b16.S) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                w.d("MicroMsg.GlobalMusicFloatBallManager", "alvinluo onMusicAction not need show music float ball, music: %s, isFromNewMusicWrapper: %s", b16.f139443e, Boolean.valueOf(b16.W));
                return false;
            }
        }
        com.tencent.luggage.wxa.k2.a a16 = com.tencent.luggage.wxa.k2.a.a();
        if (a16 != null) {
            a16.a(event);
        }
        return false;
    }
}
