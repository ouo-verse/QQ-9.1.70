package com.tencent.mobileqq.guild.home.viewmodels.header;

import com.tencent.gamecenter.wadl.distribute.data.GameDistributeInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildCapsuleInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderGameDistribute;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderGroupChatInfo;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.GuildHomeHeaderNavigationBar;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.rightlist.headerbars.utils.GuildNavigationConvertHelper;
import com.tencent.mobileqq.guild.message.unread.UnreadInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildMainFrameHeaderInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationV2Info;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u00142\u00020\u0001:\u0001\u0003B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0004\b5\u00106J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u000fJ \u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0013\u001a\u00020\u000fJ \u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0013\u001a\u00020\u000fJ\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bJ\u0006\u0010\u001f\u001a\u00020\u001eJ\u0006\u0010!\u001a\u00020 R\u0016\u0010\u0005\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\"R\u0018\u0010$\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010#R\u0018\u0010'\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010+R\"\u00103\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u00104\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010.\u001a\u0004\b%\u00100\"\u0004\b-\u00102\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/f;", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/c;", "a", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "", "l", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", NodeProps.COLORS, DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", ViewStickEventHelper.IS_SHOW, "k", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;", "data", "from", tl.h.F, "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeInfo;", "distributeInfo", "i", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/a;", "capsuleInfo", "j", "", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/b;", "d", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/f;", "e", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/e;", "b", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildMainFrameHeaderInfo;", "commonHeaderInfo", "c", "Lcom/tencent/gamecenter/wadl/distribute/data/GameDistributeInfo;", "guildGameDistributeInfo", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/e;", "coverColors", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/d;", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/d;", "groupChatInfo", "f", "Z", "getNavigatorExpand", "()Z", "g", "(Z)V", "navigatorExpand", "hasFetchNavigationBarDataFromServer", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private FacadeArgsData facadeArgsData;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IGProGuildMainFrameHeaderInfo commonHeaderInfo;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GameDistributeInfo guildGameDistributeInfo;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private GuildHomeCoverColors coverColors;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildHomeHeaderGroupChatInfo groupChatInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean navigatorExpand;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hasFetchNavigationBarDataFromServer;

    public f(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        this.coverColors = GuildHomeCoverColors.INSTANCE.c(0, -1);
        this.groupChatInfo = new GuildHomeHeaderGroupChatInfo(null, null, false, false, 15, null);
    }

    private final GuildHomeHeaderGameDistribute a() {
        return null;
    }

    @NotNull
    public final com.tencent.mobileqq.guild.home.viewmodels.header.uidata.e b() {
        boolean isShow = this.groupChatInfo.getIsShow();
        String guildId = this.facadeArgsData.f227656e;
        GuildHomeCoverColors guildHomeCoverColors = this.coverColors;
        boolean showTips = this.groupChatInfo.getShowTips();
        UnreadInfo.a unreadInfo = this.groupChatInfo.getUnreadInfo();
        GuildCapsuleInfo capsuleInfo = this.groupChatInfo.getCapsuleInfo();
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        return new com.tencent.mobileqq.guild.home.viewmodels.header.uidata.e(isShow, guildHomeCoverColors, guildId, showTips, unreadInfo, capsuleInfo);
    }

    /* renamed from: c, reason: from getter */
    public final boolean getHasFetchNavigationBarDataFromServer() {
        return this.hasFetchNavigationBarDataFromServer;
    }

    @NotNull
    public final List<com.tencent.mobileqq.guild.home.viewmodels.header.uidata.b> d() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(e());
        GuildHomeHeaderGameDistribute a16 = a();
        if (a16 != null) {
            arrayList.add(a16);
        }
        arrayList.add(b());
        return arrayList;
    }

    @NotNull
    public final GuildHomeHeaderNavigationBar e() {
        IGProGuildNavigationInfo iGProGuildNavigationInfo;
        List<? extends IGProNavigationInfo> emptyList;
        ArrayList<IGProNavigationV2Info> navigationList;
        int collectionSizeOrDefault;
        IGProGuildMainFrameHeaderInfo iGProGuildMainFrameHeaderInfo = this.commonHeaderInfo;
        if (iGProGuildMainFrameHeaderInfo != null) {
            iGProGuildNavigationInfo = iGProGuildMainFrameHeaderInfo.getGuildNavigationInfo();
        } else {
            iGProGuildNavigationInfo = null;
        }
        if (iGProGuildNavigationInfo == null || (navigationList = iGProGuildNavigationInfo.getNavigationList()) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(navigationList, 10);
            emptyList = new ArrayList<>(collectionSizeOrDefault);
            for (IGProNavigationV2Info it : navigationList) {
                GuildNavigationConvertHelper guildNavigationConvertHelper = GuildNavigationConvertHelper.f227675a;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                emptyList.add(guildNavigationConvertHelper.a(it));
            }
        }
        GuildHomeHeaderNavigationBar.Companion companion = GuildHomeHeaderNavigationBar.INSTANCE;
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        GuildHomeHeaderNavigationBar a16 = companion.a(str, this.coverColors, emptyList, this.navigatorExpand);
        a16.o(this.hasFetchNavigationBarDataFromServer);
        return a16;
    }

    public final void f(boolean z16) {
        this.hasFetchNavigationBarDataFromServer = z16;
    }

    public final void g(boolean z16) {
        this.navigatorExpand = z16;
    }

    public final void h(@NotNull String guildId, @Nullable IGProGuildMainFrameHeaderInfo data, @NotNull String from) {
        Integer num;
        IGProGuildNavigationInfo guildNavigationInfo;
        ArrayList<IGProNavigationV2Info> navigationList;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(from, "from");
        if (!Intrinsics.areEqual(guildId, this.facadeArgsData.f227656e)) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            if (data != null && (guildNavigationInfo = data.getGuildNavigationInfo()) != null && (navigationList = guildNavigationInfo.getNavigationList()) != null) {
                num = Integer.valueOf(navigationList.size());
            } else {
                num = null;
            }
            d16.d("GuildHomeHeaderBarsStoreAndConvertor", 1, "updateCommonHeaderInfo " + from + " dataSize:" + num);
        }
        this.commonHeaderInfo = data;
    }

    public final void i(@NotNull String guildId, @Nullable GameDistributeInfo distributeInfo, @NotNull String from) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(from, "from");
        if (!Intrinsics.areEqual(guildId, this.facadeArgsData.f227656e)) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeHeaderBarsStoreAndConvertor", 1, "updateGameDistributeInfo " + from + " distributeInfo:" + distributeInfo);
        }
        this.guildGameDistributeInfo = distributeInfo;
    }

    public final void j(@NotNull String guildId, @Nullable GuildCapsuleInfo capsuleInfo, @NotNull String from) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(from, "from");
        if (!Intrinsics.areEqual(guildId, this.facadeArgsData.f227656e)) {
            return;
        }
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeHeaderBarsStoreAndConvertor", 1, "updateGroupChatCapsuleInfo " + from + " capsuleInfo:" + capsuleInfo);
        }
        this.groupChatInfo.e(capsuleInfo);
    }

    public final void k(boolean isShow) {
        this.groupChatInfo.f(isShow);
    }

    public final void l(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
    }

    public final void m() {
        this.navigatorExpand = !this.navigatorExpand;
    }

    public final void n(@NotNull GuildHomeCoverColors colors) {
        Intrinsics.checkNotNullParameter(colors, "colors");
        this.coverColors = colors;
    }
}
