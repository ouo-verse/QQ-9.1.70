package com.tencent.icgame.game.liveroom.impl.room.followguide;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\"\u0010\u000e\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u0006\u001a\u0004\b\u000f\u0010\b\"\u0004\b\u0010\u0010\nR\"\u0010\u0011\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0013\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideConfigModel;", "Ljava/io/Serializable;", "", "toString", "", "stayDismissDuration", "I", "getStayDismissDuration", "()I", "setStayDismissDuration", "(I)V", "maxCountWeekly", "getMaxCountWeekly", "setMaxCountWeekly", "maxCountDailyRoom", "getMaxCountDailyRoom", "setMaxCountDailyRoom", "showInterval", "getShowInterval", "setShowInterval", "<init>", "()V", "Companion", "a", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class FollowGuideConfigModel implements Serializable {

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "ICGameFollowGuideConfigModel";
    private int stayDismissDuration = 5;
    private int maxCountWeekly = 2;
    private int maxCountDailyRoom = 3;
    private int showInterval = 10;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideConfigModel$a;", "", "Lcom/tencent/icgame/game/liveroom/impl/room/followguide/FollowGuideConfigModel;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.icgame.game.liveroom.impl.room.followguide.FollowGuideConfigModel$a, reason: from kotlin metadata */
    /* loaded from: classes7.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final FollowGuideConfigModel a() {
            return new FollowGuideConfigModel();
        }

        Companion() {
        }
    }

    public final int getMaxCountDailyRoom() {
        return this.maxCountDailyRoom;
    }

    public final int getMaxCountWeekly() {
        return this.maxCountWeekly;
    }

    public final int getShowInterval() {
        return this.showInterval;
    }

    public final int getStayDismissDuration() {
        return this.stayDismissDuration;
    }

    public final void setMaxCountDailyRoom(int i3) {
        this.maxCountDailyRoom = i3;
    }

    public final void setMaxCountWeekly(int i3) {
        this.maxCountWeekly = i3;
    }

    public final void setShowInterval(int i3) {
        this.showInterval = i3;
    }

    public final void setStayDismissDuration(int i3) {
        this.stayDismissDuration = i3;
    }

    @NotNull
    public String toString() {
        return "FollowGuideConfigModel(stayDismissDuration=" + this.stayDismissDuration + ", maxCountWeekly=" + this.maxCountWeekly + ", maxCountDailyRoom=" + this.maxCountDailyRoom + ", showInterval=" + this.showInterval + ")";
    }
}
