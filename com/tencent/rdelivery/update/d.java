package com.tencent.rdelivery.update;

import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.update.AbsUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\t\u001a\u00020\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/rdelivery/update/d;", "Lcom/tencent/rdelivery/update/AbsUpdater;", "Lcom/tencent/rdelivery/update/AbsUpdater$Event;", "event", "", "c", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "b", "Lcom/tencent/rdelivery/net/g;", "requestManager", "<init>", "(Lcom/tencent/rdelivery/net/g;)V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class d extends AbsUpdater {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull g requestManager) {
        super(requestManager, null, 2, null);
        Intrinsics.checkParameterIsNotNull(requestManager, "requestManager");
    }

    @Override // com.tencent.rdelivery.update.AbsUpdater
    @NotNull
    public RDeliveryRequest.RequestSource b() {
        return RDeliveryRequest.RequestSource.SDK_INIT;
    }

    @Override // com.tencent.rdelivery.update.AbsUpdater
    public void c(@NotNull AbsUpdater.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event == AbsUpdater.Event.SDK_INIT) {
            a();
        }
    }
}
