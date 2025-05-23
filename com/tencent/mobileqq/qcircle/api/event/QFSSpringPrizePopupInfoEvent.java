package com.tencent.mobileqq.qcircle.api.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qcircle/api/event/QFSSpringPrizePopupInfoEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "info", "", "([B)V", "getInfo", "()[B", "qcircle-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public final class QFSSpringPrizePopupInfoEvent extends SimpleBaseEvent {

    @NotNull
    private final byte[] info;

    public QFSSpringPrizePopupInfoEvent(@NotNull byte[] info) {
        Intrinsics.checkNotNullParameter(info, "info");
        this.info = info;
    }

    @NotNull
    public final byte[] getInfo() {
        return this.info;
    }
}
