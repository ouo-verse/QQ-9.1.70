package com.tencent.biz.qqcircle.immersive.layer.biz.outside.publicaccount.staggered.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/layer/biz/outside/publicaccount/staggered/events/QFSPublicAccountScrollStateChangeEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "status", "", "(I)V", ThemeReporter.BUNDLE_KEY_TASK_GET_STATUS, "()I", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSPublicAccountScrollStateChangeEvent extends SimpleBaseEvent {
    private final int status;

    public QFSPublicAccountScrollStateChangeEvent(int i3) {
        this.status = i3;
    }

    public final int getStatus() {
        return this.status;
    }
}
