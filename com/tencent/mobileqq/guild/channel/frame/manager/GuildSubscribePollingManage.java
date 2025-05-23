package com.tencent.mobileqq.guild.channel.frame.manager;

import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.guildtab.IGuildUserService;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProGlobalService;
import com.tencent.mobileqq.qqguildsdk.data.fl;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProQQMsgListGuild;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\r\u001a\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\u000e\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\bH\u0016R\u0016\u0010\u001c\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001bR\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00060!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R$\u0010)\u001a\u0012\u0012\u0004\u0012\u00020&0%j\b\u0012\u0004\u0012\u00020&`'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/manager/GuildSubscribePollingManage;", "Lcom/tencent/mobileqq/guild/guildtab/IGuildUserService$c;", "", "u", "y", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "hasRefreshOp", HippyTKDListViewAdapter.X, "guildList", DomainData.DOMAIN_NAME, "o", "l", "k", "w", "Lmqq/app/AppRuntime;", "app", "p", "t", ReportConstant.COSTREPORT_PREFIX, "r", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isGuildUser", "b", "e", "Z", "hasInit", "f", "isShowingMsgTab", h.F, "needRegisterUser", "Ljava/util/concurrent/CopyOnWriteArrayList;", "i", "Ljava/util/concurrent/CopyOnWriteArrayList;", "recentMsgGuildList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "registerUserModuleKeySet", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "guildUpdateObserver", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildSubscribePollingManage implements IGuildUserService.c {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static boolean hasInit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private static boolean isShowingMsgTab;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private static boolean needRegisterUser;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final GuildSubscribePollingManage f214907d = new GuildSubscribePollingManage();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final CopyOnWriteArrayList<String> recentMsgGuildList = new CopyOnWriteArrayList<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<Integer> registerUserModuleKeySet = new HashSet<>(2);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private static GPServiceObserver guildUpdateObserver = new a();

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J$\u0010\u000e\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\nH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/channel/frame/manager/GuildSubscribePollingManage$a", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "onRemoveGuild", "", "black", "onBeKickFromGuild", "onDestoryGuild", "", "ops", "Lcom/tencent/mobileqq/qqguildsdk/data/fl;", "list", "onQQMsgListGuildUpdated", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class a extends GPServiceObserver {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            List listOfNotNull;
            if (ca.a()) {
                GuildSubscribePollingManage guildSubscribePollingManage = GuildSubscribePollingManage.f214907d;
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(guildId);
                guildSubscribePollingManage.o(listOfNotNull);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            List listOfNotNull;
            if (ca.a()) {
                GuildSubscribePollingManage guildSubscribePollingManage = GuildSubscribePollingManage.f214907d;
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(guildId);
                guildSubscribePollingManage.o(listOfNotNull);
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onQQMsgListGuildUpdated(@NotNull List<Integer> ops, @NotNull List<fl> list) {
            Intrinsics.checkNotNullParameter(ops, "ops");
            Intrinsics.checkNotNullParameter(list, "list");
            if (ops.isEmpty()) {
                return;
            }
            QLog.i("GuildSubscribePollingManage", 1, "onQQMsgListGuildUpdated: op[" + ops.size() + "]");
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = ops.size();
            boolean z16 = false;
            for (int i3 = 0; i3 < size; i3++) {
                int intValue = ops.get(i3).intValue();
                if (intValue != 1) {
                    if (intValue != 2) {
                        if (intValue != 4) {
                            QLog.i("GuildSubscribePollingManage", 1, "onQQMsgListGuildUpdated: op[" + ops.get(i3) + "]");
                        } else {
                            arrayList.add(list.get(i3).getGuildId());
                            z16 = true;
                        }
                    } else {
                        arrayList2.add(list.get(i3).getGuildId());
                    }
                } else {
                    arrayList.add(list.get(i3).getGuildId());
                }
            }
            if (!arrayList.isEmpty()) {
                GuildSubscribePollingManage.f214907d.n(arrayList);
            }
            if (!arrayList2.isEmpty()) {
                GuildSubscribePollingManage.f214907d.o(arrayList2);
            }
            GuildSubscribePollingManage.f214907d.x(z16);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            List listOfNotNull;
            if (ca.a()) {
                GuildSubscribePollingManage guildSubscribePollingManage = GuildSubscribePollingManage.f214907d;
                listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(guildId);
                guildSubscribePollingManage.o(listOfNotNull);
            }
        }
    }

    GuildSubscribePollingManage() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppInterface appInterface2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildUserService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGuildUserService iGuildUserService = (IGuildUserService) iRuntimeService;
        if (iGuildUserService != null) {
            iGuildUserService.addListener(this);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface2 = (AppInterface) peekAppRuntime2;
        } else {
            appInterface2 = null;
        }
        if (appInterface2 != null) {
            iRuntimeService2 = appInterface2.getRuntimeService(IGProGlobalService.class, "");
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) iRuntimeService2;
        if (iGProGlobalService != null) {
            iGProGlobalService.addObserver(guildUpdateObserver);
        }
    }

    private final boolean l() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildUserService.class, "");
        }
        IGuildUserService iGuildUserService = (IGuildUserService) iRuntimeService;
        if (iGuildUserService != null) {
            return iGuildUserService.isGuildUserCached();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(List<String> guildList) {
        QLog.i("GuildSubscribePollingManage", 1, "[handleAddGuildListToRecentList]: size[" + guildList.size() + "]");
        ArrayList arrayList = new ArrayList();
        for (Object obj : guildList) {
            if (!recentMsgGuildList.contains((String) obj)) {
                arrayList.add(obj);
            }
        }
        QLog.i("GuildSubscribePollingManage", 1, "handleAddGuildListToRecentList: filter size[" + arrayList.size() + "]");
        recentMsgGuildList.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(List<String> guildList) {
        Set set;
        QLog.i("GuildSubscribePollingManage", 1, "handleDeleteGuildListFromRecentList: size:" + guildList.size());
        CopyOnWriteArrayList<String> copyOnWriteArrayList = recentMsgGuildList;
        set = CollectionsKt___CollectionsKt.toSet(guildList);
        copyOnWriteArrayList.removeAll(set);
    }

    private final List<String> q() {
        ArrayList arrayList;
        ArrayList<IGProQQMsgListGuild> qQMsgListGuilds;
        int collectionSizeOrDefault;
        IGPSService d16 = at.d();
        Integer num = null;
        if (d16 != null && (qQMsgListGuilds = d16.getQQMsgListGuilds()) != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(qQMsgListGuilds, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = qQMsgListGuilds.iterator();
            while (it.hasNext()) {
                arrayList.add(String.valueOf(((IGProQQMsgListGuild) it.next()).getGuildId()));
            }
        } else {
            arrayList = null;
        }
        if (arrayList != null) {
            num = Integer.valueOf(arrayList.size());
        }
        QLog.i("GuildSubscribePollingManage", 1, "loadRecentMsgListGuildInfo res.size:" + num);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void u() {
        boolean l3 = l();
        needRegisterUser = l3;
        if (!l3) {
            QLog.i("GuildSubscribePollingManage", 1, "registerAllGuildLoopUpdate: guild is unavailable.!");
        } else {
            RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.frame.manager.b
                @Override // java.lang.Runnable
                public final void run() {
                    GuildSubscribePollingManage.v();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = recentMsgGuildList;
        copyOnWriteArrayList.clear();
        List<String> q16 = f214907d.q();
        if (q16 != null) {
            copyOnWriteArrayList.addAll(q16);
        }
        QLog.i("GuildSubscribePollingManage", 1, "registerAllGuildLoopUpdate: recentMsgGuildList Init completed!");
    }

    private final void w() {
        AppInterface appInterface;
        IRuntimeService iRuntimeService;
        AppInterface appInterface2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService2 = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGuildUserService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGuildUserService iGuildUserService = (IGuildUserService) iRuntimeService;
        if (iGuildUserService != null) {
            iGuildUserService.removeListener(this);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface2 = (AppInterface) peekAppRuntime2;
        } else {
            appInterface2 = null;
        }
        if (appInterface2 != null) {
            iRuntimeService2 = appInterface2.getRuntimeService(IGProGlobalService.class, "");
        }
        IGProGlobalService iGProGlobalService = (IGProGlobalService) iRuntimeService2;
        if (iGProGlobalService != null) {
            iGProGlobalService.deleteObserver(guildUpdateObserver);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(boolean hasRefreshOp) {
        if (hasRefreshOp && isShowingMsgTab && recentMsgGuildList.isEmpty()) {
            QLog.i("GuildSubscribePollingManage", 1, "tryRegisterAllGuildAgain: register on refresh");
            u();
        }
    }

    private final void y() {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.frame.manager.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildSubscribePollingManage.z();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z() {
        CopyOnWriteArrayList<String> copyOnWriteArrayList = recentMsgGuildList;
        QLog.i("GuildSubscribePollingManage", 1, "unregisterAllGuildLoopUpdate: size[" + copyOnWriteArrayList.size() + "]");
        copyOnWriteArrayList.clear();
    }

    @Override // com.tencent.mobileqq.guild.guildtab.IGuildUserService.c
    public void b(boolean isGuildUser) {
        QLog.i("GuildSubscribePollingManage", 1, "onGuildTabChanged: isGuildUser" + isGuildUser + ",isShowingMsgTab:" + isShowingMsgTab + ",needRegisterUser:" + needRegisterUser);
        if (isGuildUser && isShowingMsgTab && !needRegisterUser) {
            u();
        }
    }

    public final void m() {
        QLog.i("GuildSubscribePollingManage", 1, "destroyGuildSubscribeManager:");
        w();
        y();
        hasInit = false;
    }

    public final void p(@NotNull AppRuntime app) {
        Intrinsics.checkNotNullParameter(app, "app");
        QLog.i("GuildSubscribePollingManage", 1, "initGuildSubscribeManager: isShowingMsgTab:" + isShowingMsgTab);
        ((IGuildDelayInitializeService) app.getRuntimeService(IGuildDelayInitializeService.class, "")).scheduleTask(new IGuildDelayInitializeService.InitializeTask("GuildSubscribePollingManage#initGuildSubscribeManager", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.channel.frame.manager.GuildSubscribePollingManage$initGuildSubscribeManager$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                CopyOnWriteArrayList copyOnWriteArrayList;
                GuildSubscribePollingManage.hasInit = true;
                GuildSubscribePollingManage guildSubscribePollingManage = GuildSubscribePollingManage.f214907d;
                guildSubscribePollingManage.k();
                copyOnWriteArrayList = GuildSubscribePollingManage.recentMsgGuildList;
                if (copyOnWriteArrayList.isEmpty()) {
                    guildSubscribePollingManage.u();
                }
            }
        }));
    }

    public final void r() {
        QLog.i("GuildSubscribePollingManage", 1, "notifyGuildHelperDismiss: isShowingMsgTab:" + isShowingMsgTab);
        if (!isShowingMsgTab) {
            y();
        }
    }

    public final void s() {
        QLog.i("GuildSubscribePollingManage", 1, "notifyRecentMsgTabDismiss: hasInit:" + hasInit);
        isShowingMsgTab = false;
        if (hasInit) {
            y();
        }
    }

    public final void t() {
        QLog.i("GuildSubscribePollingManage", 1, "notifyRecentMsgTabShow: hasInit:" + hasInit);
        isShowingMsgTab = true;
        if (hasInit) {
            u();
        }
    }
}
