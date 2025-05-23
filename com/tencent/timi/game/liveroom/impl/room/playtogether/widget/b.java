package com.tencent.timi.game.liveroom.impl.room.playtogether.widget;

import android.R;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.timi.game.api.live.LiveRoomExtraInfo;
import com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchContainerView;
import com.tencent.timi.game.ui.widget.BaseSlideUpDialog;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;
import ug4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/b;", "Lcom/tencent/timi/game/ui/widget/BaseSlideUpDialog;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$b;", "listener", "j0", "", "T", "Z", "isAnchor", "", "U", "Ljava/lang/Long;", "roomId", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "V", "Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;", "extraInfo", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView;", "W", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView;", "anchorAccountSwitchContainerView", "X", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$b;", "Landroid/content/Context;", "ctx", "<init>", "(Landroid/content/Context;ZLjava/lang/Long;Lcom/tencent/timi/game/api/live/LiveRoomExtraInfo;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b extends BaseSlideUpDialog {

    /* renamed from: T, reason: from kotlin metadata */
    private final boolean isAnchor;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private final Long roomId;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private final LiveRoomExtraInfo extraInfo;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final AnchorAccountSwitchContainerView anchorAccountSwitchContainerView;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private AnchorAccountSwitchContainerView.b listener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/widget/b$a", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$b;", "", "a", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "roleRsp", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements AnchorAccountSwitchContainerView.b {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ AnchorAccountSwitchContainerView.b f378405b;

        a(AnchorAccountSwitchContainerView.b bVar) {
            this.f378405b = bVar;
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchContainerView.b
        public void a() {
            b.this.dismiss();
            this.f378405b.a();
        }

        @Override // com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchContainerView.b
        public void b(@Nullable GameRoleOuterClass$SmobaGameRoleInfo roleRsp) {
            this.f378405b.b(roleRsp);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Context ctx, boolean z16, @Nullable Long l3, @Nullable LiveRoomExtraInfo liveRoomExtraInfo) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.isAnchor = z16;
        this.roomId = l3;
        this.extraInfo = liveRoomExtraInfo;
        this.anchorAccountSwitchContainerView = new AnchorAccountSwitchContainerView(ctx, null, 0, 6, null);
    }

    public final void j0(@NotNull AnchorAccountSwitchContainerView.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.listener = listener;
        this.anchorAccountSwitchContainerView.setAnchorAccountSwitchListener(new a(listener));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.BaseSlideUpDialog, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Long l3;
        Map mutableMapOf;
        super.onCreate(savedInstanceState);
        setContentView(this.anchorAccountSwitchContainerView);
        e0(this.anchorAccountSwitchContainerView);
        c0(false);
        if (!this.isAnchor && (l3 = this.roomId) != null) {
            l3.longValue();
            if (this.extraInfo == null) {
                return;
            }
            mm4.a b16 = mm4.b.b(ug4.a.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(ILiveReportService::class.java)");
            View h16 = this.anchorAccountSwitchContainerView.h();
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zengzhi_moduleid", "em_qqlive_play_entrance"));
            a.C11346a.a((ug4.a) b16, h16, false, null, "em_qqlive_play_sureaccount", mutableMapOf, 6, null);
            PageInfo pageInfo = VideoReport.getPageInfo(null);
            if (pageInfo != null) {
                VideoReport.setLogicParent(findViewById(R.id.content), pageInfo.getPageView());
            }
        }
    }
}
