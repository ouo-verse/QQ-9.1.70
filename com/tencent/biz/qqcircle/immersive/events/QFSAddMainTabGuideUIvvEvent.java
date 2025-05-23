package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\n\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/events/QFSAddMainTabGuideUIvvEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "feedId", "", "dtPageId", "(Ljava/lang/String;Ljava/lang/String;)V", "getDtPageId", "()Ljava/lang/String;", "getFeedId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class QFSAddMainTabGuideUIvvEvent extends SimpleBaseEvent {

    @NotNull
    private final String dtPageId;

    @NotNull
    private final String feedId;

    public QFSAddMainTabGuideUIvvEvent(@NotNull String feedId, @NotNull String dtPageId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        this.feedId = feedId;
        this.dtPageId = dtPageId;
    }

    public static /* synthetic */ QFSAddMainTabGuideUIvvEvent copy$default(QFSAddMainTabGuideUIvvEvent qFSAddMainTabGuideUIvvEvent, String str, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = qFSAddMainTabGuideUIvvEvent.feedId;
        }
        if ((i3 & 2) != 0) {
            str2 = qFSAddMainTabGuideUIvvEvent.dtPageId;
        }
        return qFSAddMainTabGuideUIvvEvent.copy(str, str2);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getFeedId() {
        return this.feedId;
    }

    @NotNull
    /* renamed from: component2, reason: from getter */
    public final String getDtPageId() {
        return this.dtPageId;
    }

    @NotNull
    public final QFSAddMainTabGuideUIvvEvent copy(@NotNull String feedId, @NotNull String dtPageId) {
        Intrinsics.checkNotNullParameter(feedId, "feedId");
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        return new QFSAddMainTabGuideUIvvEvent(feedId, dtPageId);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QFSAddMainTabGuideUIvvEvent)) {
            return false;
        }
        QFSAddMainTabGuideUIvvEvent qFSAddMainTabGuideUIvvEvent = (QFSAddMainTabGuideUIvvEvent) other;
        if (Intrinsics.areEqual(this.feedId, qFSAddMainTabGuideUIvvEvent.feedId) && Intrinsics.areEqual(this.dtPageId, qFSAddMainTabGuideUIvvEvent.dtPageId)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getDtPageId() {
        return this.dtPageId;
    }

    @NotNull
    public final String getFeedId() {
        return this.feedId;
    }

    public int hashCode() {
        return (this.feedId.hashCode() * 31) + this.dtPageId.hashCode();
    }

    @NotNull
    public String toString() {
        return "QFSAddMainTabGuideUIvvEvent(feedId=" + this.feedId + ", dtPageId=" + this.dtPageId + ")";
    }
}
