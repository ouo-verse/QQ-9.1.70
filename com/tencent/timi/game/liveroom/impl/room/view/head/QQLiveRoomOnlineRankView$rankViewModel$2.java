package com.tencent.timi.game.liveroom.impl.room.view.head;

import com.tencent.timi.game.liveroom.impl.room.view.rank.RankViewModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/tencent/timi/game/liveroom/impl/room/view/rank/RankViewModel;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes26.dex */
final class QQLiveRoomOnlineRankView$rankViewModel$2 extends Lambda implements Function0<RankViewModel> {
    public static final QQLiveRoomOnlineRankView$rankViewModel$2 INSTANCE = new QQLiveRoomOnlineRankView$rankViewModel$2();

    QQLiveRoomOnlineRankView$rankViewModel$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final RankViewModel invoke() {
        return new RankViewModel();
    }
}
