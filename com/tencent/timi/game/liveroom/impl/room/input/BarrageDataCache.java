package com.tencent.timi.game.liveroom.impl.room.input;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0010\u001a\u0004\b\t\u0010\u0011R\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016R\u0019\u0010\u001c\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0019\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/input/p;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "barrageSwitchStatus", "", "Lcom/tencent/timi/game/liveroom/impl/room/input/o;", "Ljava/util/List;", "()Ljava/util/List;", "barrageData", "Lcom/tencent/timi/game/liveroom/impl/room/input/u;", "c", "Lcom/tencent/timi/game/liveroom/impl/room/input/u;", "()Lcom/tencent/timi/game/liveroom/impl/room/input/u;", "currentBarrage", "", "d", "Ljava/lang/Long;", "()Ljava/lang/Long;", "payLevel", "<init>", "(ZLjava/util/List;Lcom/tencent/timi/game/liveroom/impl/room/input/u;Ljava/lang/Long;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.timi.game.liveroom.impl.room.input.p, reason: from toString */
/* loaded from: classes26.dex */
public final /* data */ class BarrageDataCache {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean barrageSwitchStatus;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final List<BarrageData> barrageData;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final CurrentBarrage currentBarrage;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Long payLevel;

    public BarrageDataCache(boolean z16, @Nullable List<BarrageData> list, @Nullable CurrentBarrage currentBarrage, @Nullable Long l3) {
        this.barrageSwitchStatus = z16;
        this.barrageData = list;
        this.currentBarrage = currentBarrage;
        this.payLevel = l3;
    }

    @Nullable
    public final List<BarrageData> a() {
        return this.barrageData;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getBarrageSwitchStatus() {
        return this.barrageSwitchStatus;
    }

    @Nullable
    /* renamed from: c, reason: from getter */
    public final CurrentBarrage getCurrentBarrage() {
        return this.currentBarrage;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final Long getPayLevel() {
        return this.payLevel;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BarrageDataCache)) {
            return false;
        }
        BarrageDataCache barrageDataCache = (BarrageDataCache) other;
        if (this.barrageSwitchStatus == barrageDataCache.barrageSwitchStatus && Intrinsics.areEqual(this.barrageData, barrageDataCache.barrageData) && Intrinsics.areEqual(this.currentBarrage, barrageDataCache.currentBarrage) && Intrinsics.areEqual(this.payLevel, barrageDataCache.payLevel)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    public int hashCode() {
        int hashCode;
        int hashCode2;
        boolean z16 = this.barrageSwitchStatus;
        ?? r06 = z16;
        if (z16) {
            r06 = 1;
        }
        int i3 = r06 * 31;
        List<BarrageData> list = this.barrageData;
        int i16 = 0;
        if (list == null) {
            hashCode = 0;
        } else {
            hashCode = list.hashCode();
        }
        int i17 = (i3 + hashCode) * 31;
        CurrentBarrage currentBarrage = this.currentBarrage;
        if (currentBarrage == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = currentBarrage.hashCode();
        }
        int i18 = (i17 + hashCode2) * 31;
        Long l3 = this.payLevel;
        if (l3 != null) {
            i16 = l3.hashCode();
        }
        return i18 + i16;
    }

    @NotNull
    public String toString() {
        return "BarrageDataCache(barrageSwitchStatus=" + this.barrageSwitchStatus + ", barrageData=" + this.barrageData + ", currentBarrage=" + this.currentBarrage + ", payLevel=" + this.payLevel + ")";
    }
}
