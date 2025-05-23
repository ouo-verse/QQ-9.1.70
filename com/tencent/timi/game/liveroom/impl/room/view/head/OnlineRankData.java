package com.tencent.timi.game.liveroom.impl.room.view.head;

import com.tencent.mobileqq.qqlive.data.room.LiveAudienceInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\r\u001a\u00020\t\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\u0006\u0010\u0017\u001a\u00020\t\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001d\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0017\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u000b\u001a\u0004\b\u0016\u0010\f\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/head/o;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "()J", "onlineCount", "", "Lcom/tencent/mobileqq/qqlive/data/room/LiveAudienceInfo;", "b", "Ljava/util/List;", "getAudienceList", "()Ljava/util/List;", "audienceList", "c", "getPollingInterval", "pollingInterval", "<init>", "(JLjava/util/List;J)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.view.head.o, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class OnlineRankData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final long onlineCount;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final List<LiveAudienceInfo> audienceList;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final long pollingInterval;

    /* JADX WARN: Multi-variable type inference failed */
    public OnlineRankData(long j3, @NotNull List<? extends LiveAudienceInfo> audienceList, long j16) {
        Intrinsics.checkNotNullParameter(audienceList, "audienceList");
        this.onlineCount = j3;
        this.audienceList = audienceList;
        this.pollingInterval = j16;
    }

    /* renamed from: a, reason: from getter */
    public final long getOnlineCount() {
        return this.onlineCount;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OnlineRankData)) {
            return false;
        }
        OnlineRankData onlineRankData = (OnlineRankData) other;
        if (this.onlineCount == onlineRankData.onlineCount && Intrinsics.areEqual(this.audienceList, onlineRankData.audienceList) && this.pollingInterval == onlineRankData.pollingInterval) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((androidx.fragment.app.a.a(this.onlineCount) * 31) + this.audienceList.hashCode()) * 31) + androidx.fragment.app.a.a(this.pollingInterval);
    }

    @NotNull
    public String toString() {
        return "OnlineRankData(onlineCount=" + this.onlineCount + ", audienceList=" + this.audienceList + ", pollingInterval=" + this.pollingInterval + ")";
    }
}
