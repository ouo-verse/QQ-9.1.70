package com.tencent.mobileqq.guild.api;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/api/IGuildLoopAvatarViewUtil;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "newInstance", "Lcom/tencent/mobileqq/guild/api/GuildLoopOnlineAvatarView;", "context", "Landroidx/fragment/app/FragmentActivity;", "params", "Landroid/os/Bundle;", "qqguild-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes12.dex */
public interface IGuildLoopAvatarViewUtil extends QRouteApi {
    @NotNull
    GuildLoopOnlineAvatarView newInstance(@NotNull FragmentActivity context, @NotNull Bundle params);
}
