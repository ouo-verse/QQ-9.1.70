package com.tencent.guild.aio.util;

import com.tencent.mobileqq.guild.message.utils.IGuildDirectMsgUtilApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/aio/api/runtime/a;", "", "a", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {
    public static final boolean a(@NotNull com.tencent.aio.api.runtime.a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "<this>");
        if (!com.tencent.guild.aio.util.ex.a.h(aVar) && !com.tencent.guild.aio.util.ex.a.i(aVar)) {
            return false;
        }
        return ((IGuildDirectMsgUtilApi) QRoute.api(IGuildDirectMsgUtilApi.class)).isGuest(com.tencent.guild.aio.util.ex.a.f(aVar));
    }
}
