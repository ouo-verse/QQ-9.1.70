package com.qzone.reborn.intimate.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o9.e;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0010\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/reborn/intimate/event/QZoneLayerPostDataEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lo9/e;", "bean", "Lo9/e;", "getBean", "()Lo9/e;", "setBean", "(Lo9/e;)V", "", "isLayerDeleteEventTrigger", "Z", "()Z", "setLayerDeleteEventTrigger", "(Z)V", "layerStateBean", "<init>", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneLayerPostDataEvent extends SimpleBaseEvent {
    private e bean;
    private boolean isLayerDeleteEventTrigger;

    public QZoneLayerPostDataEvent(e layerStateBean) {
        Intrinsics.checkNotNullParameter(layerStateBean, "layerStateBean");
        new e();
        this.bean = layerStateBean;
    }

    public final e getBean() {
        return this.bean;
    }

    /* renamed from: isLayerDeleteEventTrigger, reason: from getter */
    public final boolean getIsLayerDeleteEventTrigger() {
        return this.isLayerDeleteEventTrigger;
    }

    public final void setBean(e eVar) {
        Intrinsics.checkNotNullParameter(eVar, "<set-?>");
        this.bean = eVar;
    }

    public final void setLayerDeleteEventTrigger(boolean z16) {
        this.isLayerDeleteEventTrigger = z16;
    }
}
