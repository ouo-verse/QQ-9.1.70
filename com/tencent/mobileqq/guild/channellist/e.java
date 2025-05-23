package com.tencent.mobileqq.guild.channellist;

import com.tencent.mobileqq.guild.summary.GuildSummaryData;
import com.tencent.mobileqq.guild.summary.api.IGuildSummaryApi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppChnnPreInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProApplicationChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProChannel;
import com.tencent.qqnt.kernel.nativeinterface.MsgConstant;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/channellist/e;", "", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/summary/a;", "a", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProChannel;", "Lkotlin/collections/ArrayList;", "channelInfoList", "", "Lcom/tencent/mobileqq/guild/channellist/c;", "b", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f215292a = new e();

    e() {
    }

    private final GuildSummaryData a(String guildId, String channelId) {
        if (ch.j0(guildId)) {
            IRuntimeService S0 = ch.S0(IGuildSummaryApi.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
            return ((IGuildSummaryApi) S0).getGuestSummary(guildId, channelId);
        }
        IRuntimeService S02 = ch.S0(IGuildSummaryApi.class, "");
        Intrinsics.checkNotNullExpressionValue(S02, "runtimeService(java, process)");
        return ((IGuildSummaryApi) S02).getSummary(guildId, channelId, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public final List<c> b(@NotNull ArrayList<IGProChannel> channelInfoList) {
        boolean z16;
        TextChannelData textChannelData;
        long j3;
        String str;
        Intrinsics.checkNotNullParameter(channelInfoList, "channelInfoList");
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (IGProChannel iGProChannel : channelInfoList) {
            if (iGProChannel.getIsChannelAdmin() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            int channelType = iGProChannel.getChannelType();
            if (channelType != 1) {
                String str2 = null;
                if (channelType != 6) {
                    textChannelData = null;
                } else {
                    long channelId = iGProChannel.getChannelId();
                    long guildId = iGProChannel.getGuildId();
                    String channelName = iGProChannel.getChannelName();
                    Intrinsics.checkNotNullExpressionValue(channelName, "it.channelName");
                    IGProApplicationChannelInfo applicationInfo = iGProChannel.getApplicationInfo();
                    if (applicationInfo != null) {
                        j3 = applicationInfo.getApplicationId();
                    } else {
                        j3 = 0;
                    }
                    long j16 = j3;
                    IGProApplicationChannelInfo applicationInfo2 = iGProChannel.getApplicationInfo();
                    if (applicationInfo2 != null) {
                        str = applicationInfo2.getAppChannelIcon();
                    } else {
                        str = null;
                    }
                    int i16 = i3 + 1;
                    AppChannelData appChannelData = r15;
                    AppChannelData appChannelData2 = new AppChannelData(channelId, guildId, channelName, z16, j16, str, i3, null, null, MsgConstant.KRMFILETHUMBSIZE384, null);
                    appChannelData.q(f215292a.a(String.valueOf(iGProChannel.getGuildId()), String.valueOf(iGProChannel.getChannelId())));
                    IRuntimeService S0 = ch.S0(IGPSService.class, "");
                    Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
                    IGProAppChnnPreInfo pollingChannelOfApp = ((IGPSService) S0).getPollingChannelOfApp(String.valueOf(iGProChannel.getGuildId()), String.valueOf(iGProChannel.getChannelId()));
                    if (pollingChannelOfApp != null) {
                        str2 = pollingChannelOfApp.getText();
                    }
                    appChannelData.p(str2);
                    i3 = i16;
                    textChannelData = appChannelData;
                }
            } else {
                long channelId2 = iGProChannel.getChannelId();
                long guildId2 = iGProChannel.getGuildId();
                String channelName2 = iGProChannel.getChannelName();
                Intrinsics.checkNotNullExpressionValue(channelName2, "it.channelName");
                TextChannelData textChannelData2 = new TextChannelData(channelId2, guildId2, channelName2, z16, iGProChannel.getTextChannelInfo().getSubTypeId(), i3, null, 64, null);
                textChannelData2.o(f215292a.a(String.valueOf(iGProChannel.getGuildId()), String.valueOf(iGProChannel.getChannelId())));
                i3++;
                textChannelData = textChannelData2;
            }
            if (textChannelData != null) {
                arrayList.add(textChannelData);
            }
        }
        return arrayList;
    }
}
