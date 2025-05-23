package com.tencent.icgame.game.liveroom.impl.room.profile.manager.view;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qw0.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/HistoryBannedFragment;", "Lcom/tencent/icgame/game/liveroom/impl/room/profile/manager/view/BaseMgrHistoryFragment;", "()V", "loadData", "", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes7.dex */
public final class HistoryBannedFragment extends BaseMgrHistoryFragment {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/icgame/game/liveroom/impl/room/profile/manager/view/HistoryBannedFragment$a", "Lqw0/k$f;", "", "Lsw0/a;", "historyList", "", "isEnd", "", "onSuccess", "onFail", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements k.f {
        a() {
        }

        @Override // qw0.k.f
        public void onFail() {
            HistoryBannedFragment.this.th().loadMoreComplete(false, false);
            HistoryBannedFragment.this.ph().setVisibility(0);
        }

        @Override // qw0.k.f
        public void onSuccess(@NotNull List<sw0.a> historyList, boolean isEnd) {
            Intrinsics.checkNotNullParameter(historyList, "historyList");
            HistoryBannedFragment.this.rh().appendList(historyList);
            HistoryBannedFragment.this.rh().notifyDataSetChanged();
            if (HistoryBannedFragment.this.rh().getDataList().isEmpty()) {
                HistoryBannedFragment.this.ph().setVisibility(0);
                HistoryBannedFragment.this.th().loadMoreComplete(false, true);
            } else {
                HistoryBannedFragment.this.ph().setVisibility(8);
                HistoryBannedFragment.this.th().loadMoreComplete(true, !isEnd);
            }
            HistoryBannedFragment.this.getMAegisLog().i(HistoryBannedFragment.this.getTAG(), "loadData onSuccess historyList=" + historyList);
        }
    }

    public HistoryBannedFragment() {
        zh("ICGameHistoryBannedFragment");
        Ah("0");
    }

    @Override // com.tencent.icgame.game.liveroom.impl.room.profile.manager.view.BaseMgrHistoryFragment
    public void loadData() {
        k.m(getRoomId(), getSubRoomID(), getAnchorId(), qh().size(), new a());
    }
}
