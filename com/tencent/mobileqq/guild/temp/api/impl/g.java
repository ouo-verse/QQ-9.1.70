package com.tencent.mobileqq.guild.temp.api.impl;

import com.tencent.guildlive.api.IGuildLiveAioApi;
import com.tencent.guildmedia.api.IGuildMediaAioApi;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameQAUIApi;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/guild/temp/api/impl/g;", "", "", "factoryName", "", "b", "channelType", "a", "<init>", "()V", "qqguild_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    public static final g f235279a = new g();

    g() {
    }

    public final int b(String factoryName) {
        Intrinsics.checkNotNullParameter(factoryName, "factoryName");
        if (Intrinsics.areEqual(factoryName, com.tencent.guild.aio.factory.a.class.getName())) {
            return 1;
        }
        if (Intrinsics.areEqual(factoryName, hn0.a.class.getName())) {
            return 3;
        }
        if (Intrinsics.areEqual(factoryName, ((IGuildMediaAioApi) QRoute.api(IGuildMediaAioApi.class)).getMediaAioFactoryName())) {
            return 10;
        }
        if (Intrinsics.areEqual(factoryName, ((IGuildMediaAioApi) QRoute.api(IGuildMediaAioApi.class)).getMediaAnnounceDetailFactoryName())) {
            return 11;
        }
        if (Intrinsics.areEqual(factoryName, ((IGuildLiveAioApi) QRoute.api(IGuildLiveAioApi.class)).getLiveAioFactoryName())) {
            return 2;
        }
        if (Intrinsics.areEqual(factoryName, ((IGuildLiveAioApi) QRoute.api(IGuildLiveAioApi.class)).getLiveAioDetailFactoryName())) {
            return 5;
        }
        if (Intrinsics.areEqual(factoryName, qn0.a.class.getName())) {
            return 7;
        }
        if (Intrinsics.areEqual(factoryName, ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).getAnnouncementFactoryName())) {
            return 4;
        }
        return Intrinsics.areEqual(factoryName, ((IQQGameQAUIApi) QRoute.api(IQQGameQAUIApi.class)).getAioFactoryName()) ? 9 : 0;
    }

    public final String a(int channelType) {
        if (channelType == 1000137) {
            String aioFactoryName = ((IQQGameQAUIApi) QRoute.api(IQQGameQAUIApi.class)).getAioFactoryName();
            Intrinsics.checkNotNullExpressionValue(aioFactoryName, "api(IQQGameQAUIApi::class.java).aioFactoryName");
            return aioFactoryName;
        }
        String name = com.tencent.guild.aio.factory.a.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "GuildAIODefaultFactory::class.java.name");
        return name;
    }
}
