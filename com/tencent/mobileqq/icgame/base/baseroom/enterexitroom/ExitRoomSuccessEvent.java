package com.tencent.mobileqq.icgame.base.baseroom.enterexitroom;

import com.tencent.mobileqq.qqlive.data.room.realtime.EndPageRealTimeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/icgame/base/baseroom/enterexitroom/h;", "Lg32/b;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "c", "Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "getEndPageInfo", "()Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;", "endPageInfo", "<init>", "(Lcom/tencent/mobileqq/qqlive/data/room/realtime/EndPageRealTimeInfo;)V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.icgame.base.baseroom.enterexitroom.h, reason: from toString */
/* loaded from: classes15.dex */
public final /* data */ class ExitRoomSuccessEvent extends g32.b {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final EndPageRealTimeInfo endPageInfo;

    public ExitRoomSuccessEvent() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ExitRoomSuccessEvent) && Intrinsics.areEqual(this.endPageInfo, ((ExitRoomSuccessEvent) other).endPageInfo)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        EndPageRealTimeInfo endPageRealTimeInfo = this.endPageInfo;
        if (endPageRealTimeInfo == null) {
            return 0;
        }
        return endPageRealTimeInfo.hashCode();
    }

    @NotNull
    public String toString() {
        return "ExitRoomSuccessEvent(endPageInfo=" + this.endPageInfo + ")";
    }

    public ExitRoomSuccessEvent(@Nullable EndPageRealTimeInfo endPageRealTimeInfo) {
        this.endPageInfo = endPageRealTimeInfo;
    }

    public /* synthetic */ ExitRoomSuccessEvent(EndPageRealTimeInfo endPageRealTimeInfo, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : endPageRealTimeInfo);
    }
}
