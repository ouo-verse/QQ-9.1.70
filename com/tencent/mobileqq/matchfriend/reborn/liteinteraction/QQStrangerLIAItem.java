package com.tencent.mobileqq.matchfriend.reborn.liteinteraction;

import com.tencent.mobileqq.matchfriend.aio.foreground.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0086\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0002\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\b\b\u0002\u0010 \u001a\u00020\u0006\u0012\b\b\u0002\u0010\"\u001a\u00020\u0006\u0012\b\b\u0002\u0010%\u001a\u00020\u0002\u00a2\u0006\u0004\b+\u0010,J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u0017\u0010\u0014\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0016\u0010\rR\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010 \u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\"\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001d\u001a\u0004\b\u0010\u0010\u001fR\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\f\u001a\u0004\b!\u0010\r\"\u0004\b#\u0010$R\"\u0010*\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010&\u001a\u0004\b\u0015\u0010'\"\u0004\b(\u0010)\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/d;", "", "", "scene", "", "i", "", "toString", "hashCode", "other", "equals", "a", "I", "()I", "chatType", "", "b", "J", "d", "()J", "peerTinyId", "c", h.F, "type", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/f;", "Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/f;", "e", "()Lcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/f;", "resource", "Ljava/lang/String;", "g", "()Ljava/lang/String;", "startTime", "f", "endTime", "k", "(I)V", "showScene", "Z", "()Z", "j", "(Z)V", "hasReportExpose", "<init>", "(IJILcom/tencent/mobileqq/matchfriend/reborn/liteinteraction/f;Ljava/lang/String;Ljava/lang/String;I)V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.matchfriend.reborn.liteinteraction.d, reason: from toString */
/* loaded from: classes33.dex */
public final /* data */ class QQStrangerLIAItem {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int chatType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final long peerTinyId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int type;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final QQStrangerLIAResource resource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private final String startTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private final String endTime;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private int showScene;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hasReportExpose;

    public QQStrangerLIAItem(int i3, long j3, int i16, QQStrangerLIAResource resource, String startTime, String endTime, int i17) {
        Intrinsics.checkNotNullParameter(resource, "resource");
        Intrinsics.checkNotNullParameter(startTime, "startTime");
        Intrinsics.checkNotNullParameter(endTime, "endTime");
        this.chatType = i3;
        this.peerTinyId = j3;
        this.type = i16;
        this.resource = resource;
        this.startTime = startTime;
        this.endTime = endTime;
        this.showScene = i17;
    }

    /* renamed from: a, reason: from getter */
    public final int getChatType() {
        return this.chatType;
    }

    /* renamed from: b, reason: from getter */
    public final String getEndTime() {
        return this.endTime;
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHasReportExpose() {
        return this.hasReportExpose;
    }

    /* renamed from: d, reason: from getter */
    public final long getPeerTinyId() {
        return this.peerTinyId;
    }

    /* renamed from: e, reason: from getter */
    public final QQStrangerLIAResource getResource() {
        return this.resource;
    }

    /* renamed from: f, reason: from getter */
    public final int getShowScene() {
        return this.showScene;
    }

    /* renamed from: g, reason: from getter */
    public final String getStartTime() {
        return this.startTime;
    }

    /* renamed from: h, reason: from getter */
    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.chatType * 31) + g.a(this.peerTinyId)) * 31) + this.type) * 31) + this.resource.hashCode()) * 31) + this.startTime.hashCode()) * 31) + this.endTime.hashCode()) * 31) + this.showScene;
    }

    public final boolean i(int scene) {
        return (this.showScene & scene) == scene;
    }

    public final void j(boolean z16) {
        this.hasReportExpose = z16;
    }

    public final void k(int i3) {
        this.showScene = i3;
    }

    public String toString() {
        return "QQStrangerLIAItem(chatType=" + this.chatType + ", peerTinyId=" + this.peerTinyId + ", type=" + this.type + ", resource=" + this.resource + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", showScene=" + this.showScene + ")";
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QQStrangerLIAItem)) {
            return false;
        }
        QQStrangerLIAItem qQStrangerLIAItem = (QQStrangerLIAItem) other;
        return this.chatType == qQStrangerLIAItem.chatType && this.peerTinyId == qQStrangerLIAItem.peerTinyId && this.type == qQStrangerLIAItem.type && Intrinsics.areEqual(this.resource, qQStrangerLIAItem.resource) && Intrinsics.areEqual(this.startTime, qQStrangerLIAItem.startTime) && Intrinsics.areEqual(this.endTime, qQStrangerLIAItem.endTime) && this.showScene == qQStrangerLIAItem.showScene;
    }
}
