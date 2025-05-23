package com.tencent.mobileqq.guild.media.widget.user.adapter;

import androidx.fragment.app.Fragment;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaInviteItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaPlayerMoreItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaPlayerRobotItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaUnknownItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaViewerMoreItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaViewerTitleItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.MediaViewerUserItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.game.GameAudienceUserItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.game.GameWaitingPlayerUserItemDelegate;
import com.tencent.mobileqq.guild.media.widget.user.delegates.game.GamingPlayerUserItemDelegate;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/user/adapter/b;", "Lcom/tencent/mobileqq/guild/media/widget/user/adapter/BaseMediaUserDelegateAdapter;", "", "getTag", "Landroidx/fragment/app/Fragment;", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b extends BaseMediaUserDelegateAdapter {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NotNull Fragment fragment) {
        super(fragment);
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        this.f236209m.c(new MediaInviteItemDelegate(fragment, this));
        this.f236209m.c(new MediaPlayerRobotItemDelegate(this));
        this.f236209m.c(new MediaPlayerMoreItemDelegate(this));
        this.f236209m.c(new MediaViewerMoreItemDelegate());
        this.f236209m.c(new MediaViewerUserItemDelegate());
        this.f236209m.c(new GameAudienceUserItemDelegate(this));
        this.f236209m.c(new GameWaitingPlayerUserItemDelegate(this));
        this.f236209m.c(new GamingPlayerUserItemDelegate(this));
        this.f236209m.c(new MediaViewerTitleItemDelegate(fragment));
        this.f236209m.r(new MediaUnknownItemDelegate());
    }

    @Override // com.tencent.mobileqq.guild.media.widget.user.adapter.BaseMediaUserDelegateAdapter
    @NotNull
    public String getTag() {
        return "QGMC.GuildGameUserDelegateAdapter";
    }
}
