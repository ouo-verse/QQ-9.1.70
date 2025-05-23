package com.tencent.mobileqq.vas.ipc.remote;

import com.tencent.biz.anonymous.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/ipc/remote/AnonymousIPC;", "Lcom/tencent/mobileqq/vas/ipc/remote/IAnonymousIPC;", "()V", "getAvatarID", "", "troopUin", "getNickname", "getRankColor", "isAnonymous", "", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class AnonymousIPC implements IAnonymousIPC {
    @Override // com.tencent.mobileqq.vas.ipc.remote.IAnonymousIPC
    @Nullable
    public String getAvatarID(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        a.b g16 = a.h().g(troopUin);
        if (g16 == null) {
            return "";
        }
        return String.valueOf(g16.f78373c);
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.IAnonymousIPC
    @Nullable
    public String getNickname(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        a.b g16 = a.h().g(troopUin);
        if (g16 == null) {
            return "";
        }
        return g16.f78374d;
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.IAnonymousIPC
    @Nullable
    public String getRankColor(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        a.b g16 = a.h().g(troopUin);
        if (g16 == null) {
            return "";
        }
        return g16.f78377g;
    }

    @Override // com.tencent.mobileqq.vas.ipc.remote.IAnonymousIPC
    public boolean isAnonymous(@NotNull String troopUin) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        a.b g16 = a.h().g(troopUin);
        if (g16 == null) {
            return false;
        }
        return g16.f78371a;
    }
}
