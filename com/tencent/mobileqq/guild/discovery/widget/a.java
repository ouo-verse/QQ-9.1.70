package com.tencent.mobileqq.guild.discovery.widget;

import android.view.View;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.widget.GuildUserAvatarView;
import com.tencent.qphone.base.util.QLog;
import fh1.AvatarInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0017\u0010\n\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0015\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/widget/a;", "", "Lfh1/a;", "info", "", "a", "Landroid/view/View;", "Landroid/view/View;", "getItemView", "()Landroid/view/View;", "itemView", "", "b", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "kotlin.jvm.PlatformType", "c", "Lcom/tencent/mobileqq/guild/widget/GuildUserAvatarView;", "avatarView", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View itemView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final GuildUserAvatarView avatarView;

    public a(@NotNull View itemView, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.itemView = itemView;
        this.guildId = guildId;
        this.avatarView = (GuildUserAvatarView) itemView.findViewById(R.id.a2o);
    }

    public final void a(@NotNull AvatarInfo info) {
        Intrinsics.checkNotNullParameter(info, "info");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.discovery.mine.SmallUserAvatarList", 2, "[bindAvatar] type:" + info.getType() + ", avatarUrl:" + info.getAvatarUrl());
        }
        this.avatarView.setAvatarMeta(this.guildId, "0", info.getAvatarUrl());
    }
}
