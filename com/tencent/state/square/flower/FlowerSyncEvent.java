package com.tencent.state.square.flower;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.square.flower.data.MedalData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/flower/FlowerSyncEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "uin", "", "flowerCount", "", "flowerMedal", "Lcom/tencent/state/square/flower/data/MedalData;", "(Ljava/lang/String;ILcom/tencent/state/square/flower/data/MedalData;)V", "getFlowerCount", "()I", "getFlowerMedal", "()Lcom/tencent/state/square/flower/data/MedalData;", "getUin", "()Ljava/lang/String;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FlowerSyncEvent extends SimpleBaseEvent {
    private final int flowerCount;
    private final MedalData flowerMedal;
    private final String uin;

    public FlowerSyncEvent(String uin, int i3, MedalData medalData) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.flowerCount = i3;
        this.flowerMedal = medalData;
    }

    public final int getFlowerCount() {
        return this.flowerCount;
    }

    public final MedalData getFlowerMedal() {
        return this.flowerMedal;
    }

    public final String getUin() {
        return this.uin;
    }
}
