package com.tencent.mobileqq.guild.homev2.parts.title.viewmodel;

import android.graphics.Bitmap;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.base.repository.AccountChangedNotifier;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.v;
import com.tencent.mobileqq.guild.widget.GuildLevelRoleView;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.ai;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProFetchGuildActiveLiveChannelNumRsp;
import com.tencent.mobileqq.qqguildsdk.data.genc.at;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetActiveLiveAudioChannelNumRsp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import tl.h;
import vh2.ba;
import wh2.al;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0007*\u0001\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001(B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u000f\u0010\f\u001a\u00020\u000bH\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001d\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u001fR\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00110\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0019R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g;", "Lcom/tencent/mobileqq/guild/base/repository/a;", "", "guildId", "", DomainData.DOMAIN_NAME, "p", "r", "", "isLiving", ReportConstant.COSTREPORT_PREFIX, "com/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$b", h.F, "()Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$b;", "l", "i", "k", "Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$a;", "listener", "g", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "account", "onAccountChanged", "", "e", "Ljava/util/Set;", "guildIdSet", "f", "Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$b;", "gproServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "livingStatusListeners", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/Map;", "livingStatusCache", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class g implements com.tencent.mobileqq.guild.base.repository.a {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final g f226031d;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<String> guildIdSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final b gproServiceObserver;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static IGPSService gProService;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Set<a> livingStatusListeners;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<String, Boolean> livingStatusCache;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$a;", "", "", "guildId", "", "isLiving", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface a {
        void a(@NotNull String guildId, boolean isLiving);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0014\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/homev2/parts/title/viewmodel/g$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onGuildInfoUpdated", "Ljava/util/HashSet;", "changedGuildIdSet", "onPollingLiveAudioChannelPresence", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            if (g.guildIdSet.contains(guildId)) {
                g.f226031d.l(guildId);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPollingLiveAudioChannelPresence(@NotNull HashSet<String> changedGuildIdSet) {
            Intrinsics.checkNotNullParameter(changedGuildIdSet, "changedGuildIdSet");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildHomeV2TitleRepository", 1, "onPollingLiveAudioChannelPresence gIds:" + changedGuildIdSet);
            }
            for (String str : changedGuildIdSet) {
                if (g.guildIdSet.contains(str)) {
                    g.f226031d.r(str);
                }
            }
        }
    }

    static {
        g gVar = new g();
        f226031d = gVar;
        guildIdSet = new LinkedHashSet();
        b h16 = gVar.h();
        gproServiceObserver = h16;
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        gProService = (IGPSService) S0;
        livingStatusListeners = new LinkedHashSet();
        livingStatusCache = new LinkedHashMap();
        AccountChangedNotifier.f214789d.a(gVar);
        gProService.addObserver(h16);
    }

    g() {
    }

    private final b h() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(String guildId, at reqData, int i3, String str, IGProFetchGuildActiveLiveChannelNumRsp iGProFetchGuildActiveLiveChannelNumRsp) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(reqData, "$reqData");
        boolean z16 = true;
        if (i3 != 0) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "fetchLivingStatus result:" + i3 + " msg:" + str + " reqData:" + reqData;
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildHomeV2TitleRepository", 1, (String) it.next(), null);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildHomeV2TitleRepository", 1, "fetchLivingStatus respData:" + iGProFetchGuildActiveLiveChannelNumRsp);
        }
        g gVar = f226031d;
        if (iGProFetchGuildActiveLiveChannelNumRsp.getActiveLiveChannelNum() <= 0) {
            z16 = false;
        }
        gVar.s(guildId, z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(String guildId, String str, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeV2TitleRepository", 1, "preloadCoverImage " + guildId + " ok, " + str);
        }
    }

    @JvmStatic
    public static final void n(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.c
            @Override // java.lang.Runnable
            public final void run() {
                g.o(guildId);
            }
        }, 16, null, false);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeV2TitleRepository", 1, "preActiveGuild guildId:" + guildId);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        f226031d.p(guildId);
    }

    private final void p(String guildId) {
        guildIdSet.add(guildId);
        l(guildId);
        i(guildId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void r(final String guildId) {
        ArrayList<Integer> arrayListOf;
        ai.a e16 = new ai.a().e(guildId);
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(3);
        ai c16 = e16.d(arrayListOf).c();
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("GuildHomeV2TitleRepository", 1, "updateLivingStatus start reqData:" + c16);
        }
        gProService.getActiveLiveAudioChannelNumV2(c16, new ba() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.e
            @Override // vh2.ba
            public final void onResult(GProGetActiveLiveAudioChannelNumRsp gProGetActiveLiveAudioChannelNumRsp) {
                g.t(guildId, gProGetActiveLiveAudioChannelNumRsp);
            }
        });
    }

    private final void s(String guildId, boolean isLiving) {
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeV2TitleRepository", 1, "updateLivingStatus guildId:" + guildId + " isLiving:" + isLiving);
        }
        livingStatusCache.put(guildId, Boolean.valueOf(isLiving));
        Iterator<T> it = livingStatusListeners.iterator();
        while (it.hasNext()) {
            ((a) it.next()).a(guildId, isLiving);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(String guildId, GProGetActiveLiveAudioChannelNumRsp gProGetActiveLiveAudioChannelNumRsp) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger logger = Logger.f235387a;
        boolean z16 = true;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildHomeV2TitleRepository", 1, "updateLivingStatus num:" + gProGetActiveLiveAudioChannelNumRsp);
        }
        g gVar = f226031d;
        Integer num = gProGetActiveLiveAudioChannelNumRsp.activeNumMap.get(3);
        if (num == null) {
            num = 0;
        }
        if (num.intValue() <= 0) {
            z16 = false;
        }
        gVar.s(guildId, z16);
    }

    public final void g(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        livingStatusListeners.add(listener);
    }

    public final void i(@NotNull final String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        final at atVar = new at();
        atVar.c(MiscKt.l(guildId));
        List<IGProChannelInfo> channelList = gProService.getChannelList(guildId);
        Intrinsics.checkNotNullExpressionValue(channelList, "gProService.getChannelList(guildId)");
        ArrayList<IGProChannelInfo> arrayList = new ArrayList();
        Iterator<T> it = channelList.iterator();
        while (true) {
            boolean z16 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((IGProChannelInfo) next).getType() != 5) {
                z16 = false;
            }
            if (z16) {
                arrayList.add(next);
            }
        }
        for (IGProChannelInfo iGProChannelInfo : arrayList) {
            ArrayList<Long> a16 = atVar.a();
            String channelUin = iGProChannelInfo.getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "it.channelUin");
            a16.add(Long.valueOf(MiscKt.l(channelUin)));
        }
        if (atVar.a().isEmpty()) {
            Logger logger = Logger.f235387a;
            if (QLog.isDebugVersion()) {
                logger.d().d("GuildHomeV2TitleRepository", 1, "pre fetchLivingStatus " + guildId + " no LiveChannel");
            }
            livingStatusCache.put(guildId, Boolean.FALSE);
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger2.d().d("GuildHomeV2TitleRepository", 1, "pre fetchLivingStatus reqData:" + atVar);
        }
        gProService.fetchGuildActiveLiveChannelNum(atVar, new al() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.f
            @Override // wh2.al
            public final void a(int i3, String str, IGProFetchGuildActiveLiveChannelNumRsp iGProFetchGuildActiveLiveChannelNumRsp) {
                g.j(guildId, atVar, i3, str, iGProFetchGuildActiveLiveChannelNumRsp);
            }
        });
    }

    public final boolean k(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Boolean bool = livingStatusCache.get(guildId);
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    public final void l(@NotNull final String guildId) {
        final String str;
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        IGProGuildInfo guildInfo = gProService.getGuildInfo(guildId);
        if (guildInfo != null) {
            str = guildInfo.getCoverUrl(0, 0);
        } else {
            str = null;
        }
        if (str == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "preloadCoverImage " + guildId + " has no coverUrl";
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildHomeV2TitleRepository", 1, (String) it.next(), null);
            }
            return;
        }
        Logger logger2 = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger2.d().d("GuildHomeV2TitleRepository", 1, "preloadCoverImage " + guildId + " start");
        }
        v.f(str, 0, 0, new GuildLevelRoleView.a() { // from class: com.tencent.mobileqq.guild.homev2.parts.title.viewmodel.d
            @Override // com.tencent.mobileqq.guild.widget.GuildLevelRoleView.a
            public final void a(Bitmap bitmap) {
                g.m(guildId, str, bitmap);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        IGPSService iGPSService = gProService;
        b bVar = gproServiceObserver;
        iGPSService.deleteObserver(bVar);
        livingStatusCache.clear();
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGPSService iGPSService2 = (IGPSService) S0;
        gProService = iGPSService2;
        iGPSService2.addObserver(bVar);
    }

    public final void q(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        livingStatusListeners.remove(listener);
    }
}
