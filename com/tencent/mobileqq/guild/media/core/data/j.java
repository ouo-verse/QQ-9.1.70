package com.tencent.mobileqq.guild.media.core.data;

import com.tencent.mobileqq.guild.media.core.MediaChannelUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserDevStateData;
import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\tB\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/j;", "", "", "f", "", "d", "", "Lcom/tencent/mobileqq/guild/media/core/data/p;", "e", "a", "I", "roomTheme", "", "b", "Ljava/util/List;", "userInfos", "<init>", "()V", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int roomTheme;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<p> userInfos;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0007J\b\u0010\u0010\u001a\u00020\u000eH\u0007R\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/core/data/j$a;", "", "", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProUserInfo;", "userList", "", "c", "Lcom/tencent/mobileqq/qqguildsdk/data/IAudioChannelMemberInfos;", "channelMemberInfo", "", "d", "", "guildId", "channelId", "Lcom/tencent/mobileqq/guild/media/core/data/j;", "b", "a", "", "MIN_INTERVAL", "I", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.media.core.data.j$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean c(List<IGProUserInfo> userList) {
            Iterator<T> it = userList.iterator();
            while (it.hasNext()) {
                if (((IGProUserInfo) it.next()).getBusinessInfo().getUserListGroupInfo().getGroupType() != 2) {
                    return false;
                }
            }
            return true;
        }

        private final void d(IAudioChannelMemberInfos channelMemberInfo) {
            if (channelMemberInfo != null) {
                String channleId = channelMemberInfo.getChannleId();
                Intrinsics.checkNotNullExpressionValue(channleId, "it.channleId");
                if (MediaChannelUtils.C(channleId)) {
                    List<IGProUserInfo> userList = channelMemberInfo.getUserList();
                    Intrinsics.checkNotNullExpressionValue(userList, "it.userList");
                    for (IGProUserInfo iGProUserInfo : userList) {
                        IGProUserDevStateData userDevState = iGProUserInfo.getBusinessInfo().getUserAVInfo().getUserDevState();
                        if (iGProUserInfo.getRobotType() == 0 && userDevState.getMicState() != 2 && userDevState.getScreenState() != 2) {
                            iGProUserInfo.setGroupType(2);
                        }
                    }
                }
            }
        }

        @JvmStatic
        @NotNull
        public final j a() {
            return new j(null);
        }

        @JvmStatic
        @NotNull
        public final j b(@NotNull String guildId, @NotNull String channelId) {
            int collectionSizeOrDefault;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            IAudioChannelMemberInfos pollingChannelOfVoice = ((IGPSService) ch.S0(IGPSService.class, "")).getPollingChannelOfVoice(guildId, channelId);
            d(pollingChannelOfVoice);
            if (pollingChannelOfVoice != null && (System.currentTimeMillis() / 1000) - pollingChannelOfVoice.getUpdateTime() <= 120000 && !pollingChannelOfVoice.getUserList().isEmpty()) {
                List<IGProUserInfo> userList = pollingChannelOfVoice.getUserList();
                Intrinsics.checkNotNullExpressionValue(userList, "channelMemberInfo.userList");
                if (!c(userList)) {
                    j jVar = new j(null);
                    int i3 = 1;
                    Logger.f235387a.d().i("PreviewData", 1, "roomTheme: " + pollingChannelOfVoice.getChannelGameStatus() + " ; size: " + pollingChannelOfVoice.getUserList().size());
                    jVar.userInfos.clear();
                    List list = jVar.userInfos;
                    List<IGProUserInfo> userList2 = pollingChannelOfVoice.getUserList();
                    Intrinsics.checkNotNullExpressionValue(userList2, "channelMemberInfo.userList");
                    List<IGProUserInfo> list2 = userList2;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    for (IGProUserInfo iGProUserInfo : list2) {
                        p j3 = p.j();
                        j3.f(iGProUserInfo);
                        arrayList.add(j3);
                    }
                    list.addAll(arrayList);
                    int channelGameStatus = pollingChannelOfVoice.getChannelGameStatus();
                    if (channelGameStatus != 4 && channelGameStatus != 6) {
                        if (channelGameStatus != 9) {
                            if (channelGameStatus != 17) {
                                i3 = 0;
                            }
                        } else {
                            i3 = 2;
                        }
                    }
                    jVar.roomTheme = i3;
                    return jVar;
                }
            }
            return a();
        }

        Companion() {
        }
    }

    public /* synthetic */ j(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    @NotNull
    public static final j c(@NotNull String str, @NotNull String str2) {
        return INSTANCE.b(str, str2);
    }

    /* renamed from: d, reason: from getter */
    public final int getRoomTheme() {
        return this.roomTheme;
    }

    @NotNull
    public final List<p> e() {
        return this.userInfos;
    }

    public final boolean f() {
        if (this.roomTheme != 0 && (!this.userInfos.isEmpty())) {
            return true;
        }
        return false;
    }

    j() {
        this.userInfos = new ArrayList();
    }
}
