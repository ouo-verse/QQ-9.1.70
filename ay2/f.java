package ay2;

import com.tencent.mobileqq.tvideo.view.PlayerTipsView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import vx2.PlayerTips;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00102\u00020\u0001:\u0001\u0003B\u0011\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004J \u0010\f\u001a\u00020\u00022\u0010\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\nJ\u0016\u0010\u0010\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000eR\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lay2/f;", "", "", "a", "", "tips", "c", "", "Lvx2/c;", "tipsArray", "", "isInfiniteTips", "d", "feedOnScreen", "", "uiState", "b", "Lcom/tencent/mobileqq/tvideo/view/PlayerTipsView;", "Lcom/tencent/mobileqq/tvideo/view/PlayerTipsView;", "mPlayerTipsView", "<init>", "(Lcom/tencent/mobileqq/tvideo/view/PlayerTipsView;)V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final PlayerTipsView mPlayerTipsView;

    public f(@Nullable PlayerTipsView playerTipsView) {
        this.mPlayerTipsView = playerTipsView;
    }

    private final void a() {
        PlayerTipsView playerTipsView = this.mPlayerTipsView;
        Intrinsics.checkNotNull(playerTipsView);
        if (playerTipsView.getVisibility() == 0) {
            this.mPlayerTipsView.setVisibility(8);
        }
    }

    public final void b(boolean feedOnScreen, int uiState) {
        if (feedOnScreen && uiState == 0) {
            a();
        }
    }

    public final void c(@Nullable String tips) {
        PlayerTipsView playerTipsView = this.mPlayerTipsView;
        if (playerTipsView != null) {
            Intrinsics.checkNotNull(tips);
            PlayerTipsView.i(playerTipsView, tips, false, 2, null);
            cy2.b.e().u();
        }
    }

    public final void d(@Nullable List<PlayerTips> tipsArray, boolean isInfiniteTips) {
        PlayerTipsView playerTipsView = this.mPlayerTipsView;
        if (playerTipsView != null) {
            Intrinsics.checkNotNull(tipsArray, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.tvideo.data.PlayerTips>");
            playerTipsView.j(tipsArray, isInfiniteTips);
            cy2.b.e().u();
        }
    }
}
