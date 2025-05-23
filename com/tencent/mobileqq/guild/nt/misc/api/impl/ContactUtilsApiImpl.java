package com.tencent.mobileqq.guild.nt.misc.api.impl;

import com.tencent.mobileqq.guild.nt.misc.api.IContactUtilsApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/misc/api/impl/ContactUtilsApiImpl;", "Lcom/tencent/mobileqq/guild/nt/misc/api/IContactUtilsApi;", "()V", "getBuddyName", "", "account", "fetchIfNotExist", "", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public final class ContactUtilsApiImpl implements IContactUtilsApi {
    @Override // com.tencent.mobileqq.guild.nt.misc.api.IContactUtilsApi
    @NotNull
    public String getBuddyName(@Nullable String account, boolean fetchIfNotExist) {
        String buddyName = ((com.tencent.mobileqq.relation.api.IContactUtilsApi) QRoute.api(com.tencent.mobileqq.relation.api.IContactUtilsApi.class)).getBuddyName(account, fetchIfNotExist);
        Intrinsics.checkNotNullExpressionValue(buddyName, "api(IContactUtilsApi::cl\u2026account, fetchIfNotExist)");
        return buddyName;
    }
}
