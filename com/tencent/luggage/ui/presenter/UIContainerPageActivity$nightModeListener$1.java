package com.tencent.luggage.ui.presenter;

import com.tencent.luggage.wxa.g6.j;
import com.tencent.luggage.wxa.k0.d;
import com.tencent.luggage.wxa.on.c;
import com.tencent.luggage.wxa.qk.b;
import com.tencent.mm.sdk.event.IListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/luggage/ui/presenter/UIContainerPageActivity$nightModeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/luggage/wxa/qk/b;", "event", "", "a", "luggage-standalone-mode-ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class UIContainerPageActivity$nightModeListener$1 extends IListener<b> {
    public boolean a(b event) {
        Intrinsics.checkNotNullParameter(event, "event");
        j.a(null, false, 1, null);
        return false;
    }

    @Override // com.tencent.mm.sdk.event.IListener
    public /* bridge */ /* synthetic */ boolean callback(c cVar) {
        d.a(cVar);
        return a((b) null);
    }
}
