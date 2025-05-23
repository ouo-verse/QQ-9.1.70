package com.tencent.timi.game.expand.hall.impl.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.api.param.ExpandHallLaunchParam;
import com.tencent.timi.game.teamlist.view.TeamListSlideView;
import com.tencent.timi.game.ui.widget.TGRightDrawerView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.YesGameInfoOuterClass$GameConfigInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u00012\u00020\u0002:\u0001\bB/\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u0012\u0006\u0010\u000e\u001a\u00020\t\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/timi/game/expand/hall/impl/view/ExpandHallRightDrawerView;", "Lcom/tencent/timi/game/ui/widget/TGRightDrawerView;", "Lcom/tencent/timi/game/ui/f;", "", "H", "Landroid/view/View;", "view", "onShow", "a", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "I", "Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", "getLaunchParam", "()Lcom/tencent/timi/game/api/param/ExpandHallLaunchParam;", ConstantsAPI.Token.WX_LAUNCH_PARAM_KEY, "Lcom/tencent/timi/game/teamlist/view/TeamListSlideView;", "J", "Lcom/tencent/timi/game/teamlist/view/TeamListSlideView;", "teamListSlideView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/tencent/timi/game/api/param/ExpandHallLaunchParam;)V", "K", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ExpandHallRightDrawerView extends TGRightDrawerView implements com.tencent.timi.game.ui.f {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final ExpandHallLaunchParam launchParam;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TeamListSlideView teamListSlideView;

    public /* synthetic */ ExpandHallRightDrawerView(Context context, AttributeSet attributeSet, int i3, ExpandHallLaunchParam expandHallLaunchParam, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, expandHallLaunchParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(ExpandHallRightDrawerView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.r();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void H() {
        YesGameInfoOuterClass$GameConfigInfo l16 = ((ag4.h) mm4.b.b(ag4.h.class)).l1(this.launchParam.f376303f);
        Intrinsics.checkNotNullExpressionValue(l16, "getService(IGameConfigSe\u2026fo(launchParam.yesGameId)");
        String bgColor = l16.team_info.bg_hue.get();
        com.tencent.timi.game.utils.l.i("ExpandHallRightDrawerView_", "adjBgColor bgColor:" + bgColor);
        View n3 = n();
        Intrinsics.checkNotNullExpressionValue(bgColor, "bgColor");
        fh4.g.e(fh4.g.c(n3, fh4.c.a(bgColor)), com.tencent.timi.game.utils.b.c(6), 0.0f, com.tencent.timi.game.utils.b.c(6), 0.0f);
    }

    @Override // com.tencent.timi.game.ui.f
    public void a(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.teamListSlideView.m();
    }

    @Override // com.tencent.timi.game.ui.f
    public void onShow(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.teamListSlideView.o();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ExpandHallRightDrawerView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @NotNull ExpandHallLaunchParam launchParam) {
        super(context, attributeSet, i3, false, 8, null);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(launchParam, "launchParam");
        this.launchParam = launchParam;
        TeamListSlideView teamListSlideView = new TeamListSlideView(context);
        this.teamListSlideView = teamListSlideView;
        k(teamListSlideView, new FrameLayout.LayoutParams(com.tencent.timi.game.utils.b.a(311), -1));
        teamListSlideView.setOnCloseClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.expand.hall.impl.view.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ExpandHallRightDrawerView.G(ExpandHallRightDrawerView.this, view);
            }
        });
        l(this);
        H();
    }
}
