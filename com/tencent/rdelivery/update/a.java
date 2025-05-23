package com.tencent.rdelivery.update;

import android.os.SystemClock;
import com.tencent.rdelivery.net.RDeliveryRequest;
import com.tencent.rdelivery.net.g;
import com.tencent.rdelivery.update.AbsUpdater;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016R\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/rdelivery/update/a;", "Lcom/tencent/rdelivery/update/AbsUpdater;", "", "d", "Lcom/tencent/rdelivery/update/AbsUpdater$Event;", "event", "", "c", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "b", "J", "enterBackgroundTs", "Lcom/tencent/rdelivery/net/g;", "requestManager", "<init>", "(Lcom/tencent/rdelivery/net/g;)V", "a", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class a extends AbsUpdater {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private long enterBackgroundTs;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull g requestManager) {
        super(requestManager, null, 2, null);
        Intrinsics.checkParameterIsNotNull(requestManager, "requestManager");
        this.enterBackgroundTs = -1L;
    }

    private final long d() {
        return SystemClock.uptimeMillis() - this.enterBackgroundTs;
    }

    @Override // com.tencent.rdelivery.update.AbsUpdater
    @NotNull
    public RDeliveryRequest.RequestSource b() {
        return RDeliveryRequest.RequestSource.HOT_RELOAD;
    }

    @Override // com.tencent.rdelivery.update.AbsUpdater
    public void c(@NotNull AbsUpdater.Event event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (event == AbsUpdater.Event.APP_ENTER_FOREGROUND && this.enterBackgroundTs > 0) {
            if (d() > 30000) {
                a();
            }
        } else if (event == AbsUpdater.Event.APP_ENTER_BACKGROUND) {
            this.enterBackgroundTs = SystemClock.uptimeMillis();
        }
    }
}
