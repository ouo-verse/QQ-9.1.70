package com.tencent.mobileqq.matchfriend.reborn.content.signal.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.trpcprotocol.kuolie.common.signal.SignalPB$SignalConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/event/QQStrangerSignalPublishConfigSelectedEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", DownloadInfo.spKey_Config, "Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "partnerPosition", "", "(Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;I)V", "getConfig", "()Lcom/tencent/trpcprotocol/kuolie/common/signal/SignalPB$SignalConfig;", "getPartnerPosition", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerSignalPublishConfigSelectedEvent extends SimpleBaseEvent {
    private final SignalPB$SignalConfig config;
    private final int partnerPosition;

    public QQStrangerSignalPublishConfigSelectedEvent(SignalPB$SignalConfig config, int i3) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.partnerPosition = i3;
    }

    /* renamed from: component1, reason: from getter */
    public final SignalPB$SignalConfig getConfig() {
        return this.config;
    }

    /* renamed from: component2, reason: from getter */
    public final int getPartnerPosition() {
        return this.partnerPosition;
    }

    public final QQStrangerSignalPublishConfigSelectedEvent copy(SignalPB$SignalConfig config, int partnerPosition) {
        Intrinsics.checkNotNullParameter(config, "config");
        return new QQStrangerSignalPublishConfigSelectedEvent(config, partnerPosition);
    }

    public final SignalPB$SignalConfig getConfig() {
        return this.config;
    }

    public final int getPartnerPosition() {
        return this.partnerPosition;
    }

    public int hashCode() {
        return (this.config.hashCode() * 31) + this.partnerPosition;
    }

    public String toString() {
        return "QQStrangerSignalPublishConfigSelectedEvent(config=" + this.config + ", partnerPosition=" + this.partnerPosition + ")";
    }

    public static /* synthetic */ QQStrangerSignalPublishConfigSelectedEvent copy$default(QQStrangerSignalPublishConfigSelectedEvent qQStrangerSignalPublishConfigSelectedEvent, SignalPB$SignalConfig signalPB$SignalConfig, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            signalPB$SignalConfig = qQStrangerSignalPublishConfigSelectedEvent.config;
        }
        if ((i16 & 2) != 0) {
            i3 = qQStrangerSignalPublishConfigSelectedEvent.partnerPosition;
        }
        return qQStrangerSignalPublishConfigSelectedEvent.copy(signalPB$SignalConfig, i3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerSignalPublishConfigSelectedEvent)) {
            return false;
        }
        QQStrangerSignalPublishConfigSelectedEvent qQStrangerSignalPublishConfigSelectedEvent = (QQStrangerSignalPublishConfigSelectedEvent) other;
        return Intrinsics.areEqual(this.config, qQStrangerSignalPublishConfigSelectedEvent.config) && this.partnerPosition == qQStrangerSignalPublishConfigSelectedEvent.partnerPosition;
    }
}
