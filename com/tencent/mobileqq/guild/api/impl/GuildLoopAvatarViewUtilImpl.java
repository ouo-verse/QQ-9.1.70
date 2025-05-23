package com.tencent.mobileqq.guild.api.impl;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.guild.api.GuildLoopOnlineAvatarView;
import com.tencent.mobileqq.guild.api.IGuildLoopAvatarViewUtil;
import com.tencent.mobileqq.guild.widget.GuildLoopOnlineAvatarViewImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildLoopAvatarViewUtilImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildLoopAvatarViewUtil;", "()V", "newInstance", "Lcom/tencent/mobileqq/guild/api/GuildLoopOnlineAvatarView;", "context", "Landroidx/fragment/app/FragmentActivity;", "params", "Landroid/os/Bundle;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes12.dex */
public final class GuildLoopAvatarViewUtilImpl implements IGuildLoopAvatarViewUtil {
    @Override // com.tencent.mobileqq.guild.api.IGuildLoopAvatarViewUtil
    @NotNull
    public GuildLoopOnlineAvatarView newInstance(@NotNull FragmentActivity context, @NotNull Bundle params) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        return new GuildLoopOnlineAvatarViewImpl(context, null, params);
    }
}
