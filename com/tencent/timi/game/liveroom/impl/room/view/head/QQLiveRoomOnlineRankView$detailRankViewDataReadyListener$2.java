package com.tencent.timi.game.liveroom.impl.room.view.head;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n\u00a2\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/view/rank/a;", "invoke", "()Lcom/tencent/timi/game/liveroom/impl/room/view/rank/a;", "<anonymous>"}, k = 3, mv = {1, 7, 1})
/* loaded from: classes26.dex */
final class QQLiveRoomOnlineRankView$detailRankViewDataReadyListener$2 extends Lambda implements Function0<com.tencent.timi.game.liveroom.impl.room.view.rank.a> {
    final /* synthetic */ QQLiveRoomOnlineRankView this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQLiveRoomOnlineRankView$detailRankViewDataReadyListener$2(QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView) {
        super(0);
        this.this$0 = qQLiveRoomOnlineRankView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(QQLiveRoomOnlineRankView this$0, List listTop3, long j3) {
        long w3;
        long j16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        w3 = this$0.w(j3);
        Intrinsics.checkNotNullExpressionValue(listTop3, "listTop3");
        j16 = this$0.queryInterval;
        this$0.J(new OnlineRankData(w3, listTop3, j16));
        com.tencent.timi.game.liveroom.impl.room.util.f.f378635a.a(this$0.u().l(), listTop3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final com.tencent.timi.game.liveroom.impl.room.view.rank.a invoke() {
        final QQLiveRoomOnlineRankView qQLiveRoomOnlineRankView = this.this$0;
        return new com.tencent.timi.game.liveroom.impl.room.view.rank.a() { // from class: com.tencent.timi.game.liveroom.impl.room.view.head.x
            @Override // com.tencent.timi.game.liveroom.impl.room.view.rank.a
            public final void a(List list, long j3) {
                QQLiveRoomOnlineRankView$detailRankViewDataReadyListener$2.b(QQLiveRoomOnlineRankView.this, list, j3);
            }
        };
    }
}
