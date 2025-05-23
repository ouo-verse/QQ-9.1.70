package com.tencent.mobileqq.guild.media.game.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.media.game.memberlist.GuildGameMemberView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GameContentView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "d", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "a", "()Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;", "setGameInfoBar", "(Lcom/tencent/mobileqq/guild/media/game/widget/GuildMediaGameTeamBar;)V", "gameInfoBar", "Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "e", "Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "b", "()Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;", "setGameMemberView", "(Lcom/tencent/mobileqq/guild/media/game/memberlist/GuildGameMemberView;)V", "gameMemberView", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "f", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "c", "()Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;", "setTeamCard", "(Lcom/tencent/mobileqq/guild/media/game/widget/GuildGameTeamCard;)V", "teamCard", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GameContentView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildMediaGameTeamBar gameInfoBar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildGameMemberView gameMemberView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildGameTeamCard teamCard;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameContentView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final GuildMediaGameTeamBar getGameInfoBar() {
        return this.gameInfoBar;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final GuildGameMemberView getGameMemberView() {
        return this.gameMemberView;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildGameTeamCard getTeamCard() {
        return this.teamCard;
    }

    public final void setGameInfoBar(@NotNull GuildMediaGameTeamBar guildMediaGameTeamBar) {
        Intrinsics.checkNotNullParameter(guildMediaGameTeamBar, "<set-?>");
        this.gameInfoBar = guildMediaGameTeamBar;
    }

    public final void setGameMemberView(@NotNull GuildGameMemberView guildGameMemberView) {
        Intrinsics.checkNotNullParameter(guildGameMemberView, "<set-?>");
        this.gameMemberView = guildGameMemberView;
    }

    public final void setTeamCard(@NotNull GuildGameTeamCard guildGameTeamCard) {
        Intrinsics.checkNotNullParameter(guildGameTeamCard, "<set-?>");
        this.teamCard = guildGameTeamCard;
    }

    public /* synthetic */ GameContentView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GameContentView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.eyi, this);
        View findViewById = findViewById(R.id.wpx);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.guild_media_game_team_bar)");
        this.gameInfoBar = (GuildMediaGameTeamBar) findViewById;
        View findViewById2 = findViewById(R.id.wh8);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.guild_game_member_view)");
        this.gameMemberView = (GuildGameMemberView) findViewById2;
        View findViewById3 = findViewById(R.id.wha);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.guild_game_team_card)");
        this.teamCard = (GuildGameTeamCard) findViewById3;
    }
}
