package com.tencent.state.square.detail.event;

import android.os.Bundle;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/state/square/detail/event/DetailCommonBackEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "bundle", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "getBundle", "()Landroid/os/Bundle;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailCommonBackEvent extends SimpleBaseEvent {
    private final Bundle bundle;

    public DetailCommonBackEvent(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        this.bundle = bundle;
    }

    public final Bundle getBundle() {
        return this.bundle;
    }
}
