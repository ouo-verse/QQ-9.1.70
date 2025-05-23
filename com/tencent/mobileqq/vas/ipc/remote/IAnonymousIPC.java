package com.tencent.mobileqq.vas.ipc.remote;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/vas/ipc/remote/IAnonymousIPC;", "", "getAvatarID", "", "troopUin", "getNickname", "getRankColor", "isAnonymous", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public interface IAnonymousIPC {
    @Nullable
    String getAvatarID(@NotNull String troopUin);

    @Nullable
    String getNickname(@NotNull String troopUin);

    @Nullable
    String getRankColor(@NotNull String troopUin);

    boolean isAnonymous(@NotNull String troopUin);
}
