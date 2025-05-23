package com.tencent.mobileqq.guild.api.impl;

import com.tencent.mobileqq.guild.api.IGuildDataApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C11734b;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0001\bB\u0007\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/api/impl/GuildDataApiImpl;", "Lcom/tencent/mobileqq/guild/api/IGuildDataApi;", "", "", "getGuildIds", "<init>", "()V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildDataApiImpl implements IGuildDataApi {

    @NotNull
    private static final String TAG = "GuildDataApiImpl";

    @Override // com.tencent.mobileqq.guild.api.IGuildDataApi
    @NotNull
    public List<String> getGuildIds() {
        List<String> emptyList;
        int collectionSizeOrDefault;
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        List<IGProGuildInfo> guildList = ((IGPSService) S0).getGuildList();
        if (guildList != null) {
            List<IGProGuildInfo> list = guildList;
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(((IGProGuildInfo) it.next()).getGuildID());
            }
            return arrayList;
        }
        C11734b c11734b = C11734b.f433780a;
        QLog.e("Guild.component." + TAG, 1, "getGuildIds: guildList is null", (Throwable) null);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }
}
