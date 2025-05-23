package com.tencent.state.square.detail.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.state.map.MapItem;
import com.tencent.state.square.detail.MainScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/state/square/detail/event/DetailGuestAddToSquareEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "data", "Lcom/tencent/state/map/MapItem;", "isMale", "", "type", "", "mainScene", "Lcom/tencent/state/square/detail/MainScene;", "needLocateTo", "(Lcom/tencent/state/map/MapItem;ZILcom/tencent/state/square/detail/MainScene;Z)V", "getData", "()Lcom/tencent/state/map/MapItem;", "()Z", "getMainScene", "()Lcom/tencent/state/square/detail/MainScene;", "getNeedLocateTo", "getType", "()I", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class DetailGuestAddToSquareEvent extends SimpleBaseEvent {
    private final MapItem data;
    private final boolean isMale;
    private final MainScene mainScene;
    private final boolean needLocateTo;
    private final int type;

    public DetailGuestAddToSquareEvent(MapItem data, boolean z16, int i3, MainScene mainScene, boolean z17) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(mainScene, "mainScene");
        this.data = data;
        this.isMale = z16;
        this.type = i3;
        this.mainScene = mainScene;
        this.needLocateTo = z17;
    }

    public final MapItem getData() {
        return this.data;
    }

    public final MainScene getMainScene() {
        return this.mainScene;
    }

    public final boolean getNeedLocateTo() {
        return this.needLocateTo;
    }

    public final int getType() {
        return this.type;
    }

    /* renamed from: isMale, reason: from getter */
    public final boolean getIsMale() {
        return this.isMale;
    }
}
