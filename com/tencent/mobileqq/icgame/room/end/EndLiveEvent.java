package com.tencent.mobileqq.icgame.room.end;

import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/icgame/room/end/d;", "Lg32/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "c", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "()Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "endInfo", "<init>", "(Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;)V", "ic-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.room.end.d, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class EndLiveEvent extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final EndPageRealTimeInfo endInfo;

    public EndLiveEvent(@Nullable EndPageRealTimeInfo endPageRealTimeInfo) {
        this.endInfo = endPageRealTimeInfo;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final EndPageRealTimeInfo getEndInfo() {
        return this.endInfo;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof EndLiveEvent) && Intrinsics.areEqual(this.endInfo, ((EndLiveEvent) other).endInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        EndPageRealTimeInfo endPageRealTimeInfo = this.endInfo;
        if (endPageRealTimeInfo == null) {
            return 0;
        }
        return endPageRealTimeInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "EndLiveEvent(endInfo=" + this.endInfo + ")";
    }
}
