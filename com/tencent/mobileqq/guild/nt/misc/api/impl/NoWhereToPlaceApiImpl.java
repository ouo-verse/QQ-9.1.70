package com.tencent.mobileqq.guild.nt.misc.api.impl;

import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.nt.misc.api.INoWhereToPlaceApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/misc/api/impl/NoWhereToPlaceApiImpl;", "Lcom/tencent/mobileqq/guild/nt/misc/api/INoWhereToPlaceApi;", "()V", "obtainGuildMainFrame", "", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class NoWhereToPlaceApiImpl implements INoWhereToPlaceApi {
    @Override // com.tencent.mobileqq.guild.nt.misc.api.INoWhereToPlaceApi
    @Nullable
    public Object obtainGuildMainFrame() {
        return ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).obtainGuildMainFrame();
    }
}
