package com.tencent.timi.game.team.impl.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/timi/game/team/impl/event/ChooseLaneEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "laneId", "", "resId", HippyTKDListViewAdapter.X, "y", "duration", "", "(IIIIJ)V", "getDuration", "()J", "getLaneId", "()I", "getResId", "getX", "getY", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
public final class ChooseLaneEvent extends SimpleBaseEvent {
    private final long duration;
    private final int laneId;
    private final int resId;
    private final int x;
    private final int y;

    public ChooseLaneEvent(int i3, int i16, int i17, int i18, long j3) {
        this.laneId = i3;
        this.resId = i16;
        this.x = i17;
        this.y = i18;
        this.duration = j3;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final int getLaneId() {
        return this.laneId;
    }

    public final int getResId() {
        return this.resId;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }
}
