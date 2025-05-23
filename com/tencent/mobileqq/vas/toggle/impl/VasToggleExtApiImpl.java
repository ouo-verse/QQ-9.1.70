package com.tencent.mobileqq.vas.toggle.impl;

import com.tencent.mobileqq.vas.ar;
import com.tencent.mobileqq.vas.toggle.IVasToggleExtApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/vas/toggle/impl/VasToggleExtApiImpl;", "Lcom/tencent/mobileqq/vas/toggle/IVasToggleExtApi;", "()V", "toggle", "", "owner", "", "time", "key", "default", "aio_ext_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes20.dex */
public final class VasToggleExtApiImpl implements IVasToggleExtApi {
    @Override // com.tencent.mobileqq.vas.toggle.IVasToggleExtApi
    public boolean toggle(@NotNull String owner, @NotNull String time, @NotNull String key, boolean r56) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(key, "key");
        return ar.INSTANCE.b(owner, time, key).isEnable(r56);
    }
}
