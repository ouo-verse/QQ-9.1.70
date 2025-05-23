package com.tencent.mobileqq.guild.feed.manager;

import android.text.TextUtils;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedPreloadConfigAPi;
import com.tencent.mobileqq.guild.feed.event.GuildWebBundleStateEvent;
import com.tencent.mobileqq.guild.feed.preload.detail.FeedDetailBatchHttpTask;
import com.tencent.mobileqq.guild.feed.preload.detail.FeedDetailSingleHttpTask;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheData;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailCacheResponse;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.feed.util.m;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundlePreloadState;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProMVPFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetFeedsCallback;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001,B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*JH\u0010\u000b\u001a4\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\b0\u0006j\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\n`\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J \u0010\u000f\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J \u0010\u0010\u001a\u00020\u000e2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0002J\u0016\u0010\u0013\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u001e\u0010\u0015\u001a\u00020\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0004H\u0002J\u0010\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u001e\u0010\u001d\u001a\u00020\u00122\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0012\u0010 \u001a\u00020\u000e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J$\u0010\"\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!0\bj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020!`\nH\u0016R'\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/manager/GuildFeedDetailNetTaskManager;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/guild/feed/event/GuildWebBundleStateEvent;", "", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "needLoadFeedList", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "g", "Lcom/tencent/mobileqq/guild/feed/preload/detail/g;", "callback", "", "f", DomainData.DOMAIN_NAME, "feedParamsList", "", "l", "innerCallback", "o", "feedParamList", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "params", "i", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheResponse;", "resp", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "onReceiveEvent", "Ljava/lang/Class;", "getEventClass", "Ljava/util/concurrent/ConcurrentHashMap;", "d", "Lkotlin/Lazy;", "j", "()Ljava/util/concurrent/ConcurrentHashMap;", "feedFromNetLoadingMaps", "<init>", "()V", "e", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedDetailNetTaskManager implements SimpleEventReceiver<GuildWebBundleStateEvent> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static final Lazy<GuildFeedDetailNetTaskManager> f220123f;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy feedFromNetLoadingMaps;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0007R\u001b\u0010\b\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000bR\u0014\u0010\r\u001a\u00020\t8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/manager/GuildFeedDetailNetTaskManager$a;", "", "Lcom/tencent/mobileqq/guild/feed/manager/GuildFeedDetailNetTaskManager;", "a", "sInstance$delegate", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/guild/feed/manager/GuildFeedDetailNetTaskManager;", "sInstance", "", "NET_TASK_TYPE_BATCH_HTTP", "I", "NET_TASK_TYPE_MSF", "NET_TASK_TYPE_SINGLE_HTTP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailNetTaskManager$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final GuildFeedDetailNetTaskManager b() {
            return (GuildFeedDetailNetTaskManager) GuildFeedDetailNetTaskManager.f220123f.getValue();
        }

        @JvmStatic
        @NotNull
        public final GuildFeedDetailNetTaskManager a() {
            return b();
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/manager/GuildFeedDetailNetTaskManager$b", "Lcom/tencent/mobileqq/guild/feed/preload/detail/g;", "", "isSuccess", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailCacheResponse;", "resp", "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.feed.preload.detail.g {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List<GuildFeedDetailPreloadParams> f220125a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.feed.preload.detail.g f220126b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildFeedDetailNetTaskManager f220127c;

        b(List<GuildFeedDetailPreloadParams> list, com.tencent.mobileqq.guild.feed.preload.detail.g gVar, GuildFeedDetailNetTaskManager guildFeedDetailNetTaskManager) {
            this.f220125a = list;
            this.f220126b = gVar;
            this.f220127c = guildFeedDetailNetTaskManager;
        }

        @Override // com.tencent.mobileqq.guild.feed.preload.detail.g
        public void a(boolean isSuccess, @NotNull GuildFeedDetailCacheResponse resp) {
            Intrinsics.checkNotNullParameter(resp, "resp");
            List<GuildFeedDetailPreloadParams> list = this.f220125a;
            GuildFeedDetailNetTaskManager guildFeedDetailNetTaskManager = this.f220127c;
            for (GuildFeedDetailPreloadParams guildFeedDetailPreloadParams : list) {
                String i3 = guildFeedDetailNetTaskManager.i(guildFeedDetailPreloadParams);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildFeedDetailNetTaskManager", 2, "remove " + i3 + " from feedFromNetLoadingMaps");
                }
                guildFeedDetailNetTaskManager.j().remove(i3);
                guildFeedDetailNetTaskManager.j().remove(guildFeedDetailPreloadParams.getFeedId() + "_0");
            }
            com.tencent.mobileqq.guild.feed.preload.detail.g gVar = this.f220126b;
            if (gVar != null) {
                gVar.a(isSuccess, resp);
            }
            this.f220127c.m(resp);
        }
    }

    static {
        Lazy<GuildFeedDetailNetTaskManager> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0) new Function0<GuildFeedDetailNetTaskManager>() { // from class: com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailNetTaskManager$Companion$sInstance$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedDetailNetTaskManager invoke() {
                return new GuildFeedDetailNetTaskManager(null);
            }
        });
        f220123f = lazy;
    }

    public /* synthetic */ GuildFeedDetailNetTaskManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private final void f(List<GuildFeedDetailPreloadParams> needLoadFeedList, com.tencent.mobileqq.guild.feed.preload.detail.g callback) {
        b bVar = new b(needLoadFeedList, callback, this);
        if (!((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).isLongFeedNativeSwitchOpen()) {
            if (!needLoadFeedList.isEmpty()) {
                QLog.i("GuildFeedDetailNetTaskManager", 2, "req feed detail for web size=" + needLoadFeedList.size());
                if (!l(needLoadFeedList)) {
                    Iterator<Map.Entry<String, ArrayList<GuildFeedDetailPreloadParams>>> it = g(needLoadFeedList).entrySet().iterator();
                    while (it.hasNext()) {
                        if (!it.next().getValue().isEmpty()) {
                            n(needLoadFeedList, bVar);
                        }
                    }
                    return;
                }
                n(needLoadFeedList, bVar);
                return;
            }
            return;
        }
        if (!needLoadFeedList.isEmpty()) {
            QLog.i("GuildFeedDetailNetTaskManager", 2, "req feed detail for native size=" + needLoadFeedList.size());
            o(needLoadFeedList, bVar);
        }
    }

    private final HashMap<String, ArrayList<GuildFeedDetailPreloadParams>> g(List<GuildFeedDetailPreloadParams> needLoadFeedList) {
        HashMap<String, ArrayList<GuildFeedDetailPreloadParams>> hashMap = new HashMap<>();
        for (GuildFeedDetailPreloadParams guildFeedDetailPreloadParams : needLoadFeedList) {
            String str = guildFeedDetailPreloadParams.getGuildId() + "_" + guildFeedDetailPreloadParams.getChannelId();
            ArrayList<GuildFeedDetailPreloadParams> arrayList = hashMap.get(str);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(guildFeedDetailPreloadParams);
            hashMap.put(str, arrayList);
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String i(GuildFeedDetailPreloadParams params) {
        return params.getFeedId() + "_" + params.getLastModifyTime();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConcurrentHashMap<String, Boolean> j() {
        return (ConcurrentHashMap) this.feedFromNetLoadingMaps.getValue();
    }

    @JvmStatic
    @NotNull
    public static final GuildFeedDetailNetTaskManager k() {
        return INSTANCE.a();
    }

    private final boolean l(List<GuildFeedDetailPreloadParams> feedParamsList) {
        boolean z16;
        if (bl.b(feedParamsList)) {
            return false;
        }
        long guildId = feedParamsList.get(0).getGuildId();
        long channelId = feedParamsList.get(0).getChannelId();
        List<GuildFeedDetailPreloadParams> list = feedParamsList;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (GuildFeedDetailPreloadParams guildFeedDetailPreloadParams : list) {
                if (guildFeedDetailPreloadParams.getChannelId() == channelId && guildFeedDetailPreloadParams.getGuildId() == guildId) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m(GuildFeedDetailCacheResponse resp) {
        HashMap hashMapOf;
        if (1 == MobileQQ.sProcessId) {
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(resp.getError().getCode())), TuplesKt.to("msg", resp.getError().getMsg()), TuplesKt.to("time_cost", String.valueOf(resp.getCostTime())), TuplesKt.to("biz_type", String.valueOf(resp.getTaskType())), TuplesKt.to("size", String.valueOf(resp.getCacheList().size())));
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#time_cost#feed_detail_preload", hashMapOf);
            return;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        bVar.a().add("can not start task from other process 1");
        Iterator<T> it = bVar.a().iterator();
        while (it.hasNext()) {
            Logger.f235387a.d().e("GuildFeedDetailNetTaskManager", 1, (String) it.next(), null);
        }
    }

    private final void n(List<GuildFeedDetailPreloadParams> needLoadFeedList, com.tencent.mobileqq.guild.feed.preload.detail.g callback) {
        com.tencent.mobileqq.guild.feed.preload.detail.f.a(com.tencent.mobileqq.guild.feed.preload.detail.f.a(new com.tencent.mobileqq.guild.feed.preload.detail.c(), new FeedDetailSingleHttpTask()), new FeedDetailBatchHttpTask()).a(needLoadFeedList, callback);
    }

    private final void o(List<GuildFeedDetailPreloadParams> feedParamsList, final com.tencent.mobileqq.guild.feed.preload.detail.g innerCallback) {
        GProGetFeedsReq gProGetFeedsReq = new GProGetFeedsReq();
        Iterator<T> it = feedParamsList.iterator();
        while (it.hasNext()) {
            gProGetFeedsReq.feedIds.add(((GuildFeedDetailPreloadParams) it.next()).getFeedId());
        }
        QLog.i("GuildFeedDetailNetTaskManager", 1, "starDownloadDetailFromNT req=" + gProGetFeedsReq);
        final IPerformanceReportTask a16 = Reporters.f231995a.b().a("feed_preload");
        a16.setRealTime(false);
        a16.setExtra("reqList", Integer.valueOf(feedParamsList.size()));
        o c16 = l.c();
        if (c16 != null) {
            c16.getFeeds(gProGetFeedsReq, new IGProgetFeedsCallback() { // from class: com.tencent.mobileqq.guild.feed.manager.c
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProgetFeedsCallback
                public final void onResult(int i3, String str, boolean z16, GProGetFeedsRsp gProGetFeedsRsp) {
                    GuildFeedDetailNetTaskManager.p(IPerformanceReportTask.this, innerCallback, i3, str, z16, gProGetFeedsRsp);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(IPerformanceReportTask perfReportTask, com.tencent.mobileqq.guild.feed.preload.detail.g innerCallback, int i3, String str, boolean z16, GProGetFeedsRsp gProGetFeedsRsp) {
        Intrinsics.checkNotNullParameter(perfReportTask, "$perfReportTask");
        Intrinsics.checkNotNullParameter(innerCallback, "$innerCallback");
        boolean z17 = true;
        QLog.i("GuildFeedDetailNetTaskManager", 1, "starDownloadDetailFromNT result=" + i3 + " isDbCache=" + z16 + "  errMsg=" + str + " rspSize=" + gProGetFeedsRsp.feeds.size());
        perfReportTask.setExtra("rspList", Integer.valueOf(gProGetFeedsRsp.feeds.size()));
        com.tencent.mobileqq.guild.feed.report.c.E(com.tencent.mobileqq.guild.feed.report.c.f223280a, perfReportTask, i3, str, false, 8, null);
        ArrayList arrayList = new ArrayList();
        GuildFeedDetailCacheResponse guildFeedDetailCacheResponse = new GuildFeedDetailCacheResponse(arrayList, 0L, null, 0, 12, null);
        if (i3 == 0) {
            ArrayList<GProMVPFeed> arrayList2 = gProGetFeedsRsp.feeds;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "rsp.feeds");
            for (GProMVPFeed gProMVPFeed : arrayList2) {
                String str2 = gProMVPFeed.f359299id;
                Intrinsics.checkNotNullExpressionValue(str2, "it.id");
                arrayList.add(new GuildFeedDetailCacheData(str2, "", m.a(gProMVPFeed.oldProtoStfeed), gProMVPFeed.lastModifiedTime));
            }
        }
        if (i3 != 0) {
            z17 = false;
        }
        innerCallback.a(z17, guildFeedDetailCacheResponse);
    }

    private final List<GuildFeedDetailPreloadParams> q(List<GuildFeedDetailPreloadParams> feedParamList) {
        boolean z16;
        List<GuildFeedDetailPreloadParams> emptyList;
        if (bl.b(feedParamList)) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList<GuildFeedDetailPreloadParams> arrayList = new ArrayList();
        for (Object obj : feedParamList) {
            GuildFeedDetailPreloadParams guildFeedDetailPreloadParams = (GuildFeedDetailPreloadParams) obj;
            if (!j().containsKey(i(guildFeedDetailPreloadParams)) && !TextUtils.isEmpty(guildFeedDetailPreloadParams.getFeedId())) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        for (GuildFeedDetailPreloadParams guildFeedDetailPreloadParams2 : arrayList) {
            String i3 = i(guildFeedDetailPreloadParams2);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFeedDetailNetTaskManager", 2, "needLoadFeedList add, feedDetailKey=" + i3 + " feedId=" + guildFeedDetailPreloadParams2.getFeedId());
            }
            j().put(i3, Boolean.TRUE);
        }
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<GuildWebBundleStateEvent>> getEventClass() {
        ArrayList<Class<GuildWebBundleStateEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(GuildWebBundleStateEvent.class);
        return arrayListOf;
    }

    public final boolean h(@NotNull List<GuildFeedDetailPreloadParams> feedParamsList, @Nullable com.tencent.mobileqq.guild.feed.preload.detail.g callback) {
        Intrinsics.checkNotNullParameter(feedParamsList, "feedParamsList");
        if (!((IGuildFeedPreloadConfigAPi) QRoute.api(IGuildFeedPreloadConfigAPi.class)).enableFeedDetailPreload()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("getFeedDetailFromNet enableFeedDetailPreload=false");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildFeedDetailNetTaskManager", 1, (String) it.next(), null);
            }
            return false;
        }
        if (feedParamsList.isEmpty()) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("doGetGuildFeedDetailFromNet empty params size");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("GuildFeedDetailNetTaskManager", 1, (String) it5.next(), null);
            }
            return false;
        }
        List<GuildFeedDetailPreloadParams> q16 = q(feedParamsList);
        if (bl.b(q16)) {
            Logger logger3 = Logger.f235387a;
            Logger.b bVar3 = new Logger.b();
            bVar3.a().add("doGetGuildFeedDetailFromNet ListUtils empty");
            Iterator<T> it6 = bVar3.a().iterator();
            while (it6.hasNext()) {
                Logger.f235387a.d().e("GuildFeedDetailNetTaskManager", 1, (String) it6.next(), null);
            }
            return false;
        }
        f(q16, callback);
        return true;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        boolean z16;
        int ordinal;
        HashMap hashMapOf;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("GuildFeedDetailNetTaskManager", 2, "onReceiveEvent " + event + ", process " + MobileQQ.sProcessId);
        }
        if ((event instanceof GuildWebBundleStateEvent) && 1 == MobileQQ.sProcessId) {
            GuildWebBundleStateEvent guildWebBundleStateEvent = (GuildWebBundleStateEvent) event;
            if (guildWebBundleStateEvent.getState() == GuildWebBundlePreloadState.SUCCESS) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                ordinal = 0;
            } else {
                ordinal = guildWebBundleStateEvent.getState().ordinal();
            }
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("ret", String.valueOf(ordinal)), TuplesKt.to("msg", guildWebBundleStateEvent.getState().toString()), TuplesKt.to("time_cost", String.valueOf(guildWebBundleStateEvent.getTimeCost())));
            ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportEvent("gpro_quality#time_cost#feed_detail_webbundle", hashMapOf);
        }
    }

    GuildFeedDetailNetTaskManager() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ConcurrentHashMap<String, Boolean>>() { // from class: com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailNetTaskManager$feedFromNetLoadingMaps$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ConcurrentHashMap<String, Boolean> invoke() {
                return new ConcurrentHashMap<>();
            }
        });
        this.feedFromNetLoadingMaps = lazy;
        SimpleEventBus.getInstance().registerReceiver(this);
    }
}
