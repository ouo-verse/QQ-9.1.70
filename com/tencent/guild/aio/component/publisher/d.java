package com.tencent.guild.aio.component.publisher;

import com.tencent.guild.api.input.INTPostMediaRecyclerViewApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0006\u0010\u0001\u001a\u00020\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/guild/api/input/INTPostMediaRecyclerViewApi;", "a", "aio-guild_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class d {
    @NotNull
    public static final INTPostMediaRecyclerViewApi a() {
        QRouteApi api = QRoute.api(INTPostMediaRecyclerViewApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(INTPostMediaRecyclerViewApi::class.java)");
        return (INTPostMediaRecyclerViewApi) api;
    }
}
