package com.tencent.mobileqq.vasgift.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.timi.game.api.ITimiGameApi;
import com.tencent.timi.game.api.auth.AuthScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vasgift/utils/k;", "", "Lnh2/c;", "sdk", "", "a", "Lcom/tencent/timi/game/api/auth/AuthScene;", "authScene", "b", "<init>", "()V", "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f312037a = new k();

    k() {
    }

    public final boolean a(@Nullable nh2.c sdk) {
        if (sdk == null) {
            return false;
        }
        int i3 = sdk.getSDKConfig().f264972a;
        if (i3 != 10011 && i3 != 10008) {
            return false;
        }
        return true;
    }

    public final boolean b(@NotNull AuthScene authScene) {
        Intrinsics.checkNotNullParameter(authScene, "authScene");
        return ((ITimiGameApi) QRoute.api(ITimiGameApi.class)).needRealNameAuth(authScene);
    }
}
