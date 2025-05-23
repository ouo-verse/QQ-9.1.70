package com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Predicate;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.detail.event.CommentStatusEvent;
import com.tencent.mobileqq.guild.feed.event.GuildDetailViewDestroyEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDeleteEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedDetailTopUpdateEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalCommentsUpdatedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedExternalPreferUpdatedEvent;
import com.tencent.mobileqq.guild.feed.event.GuildFeedShareChannelEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedPublishSuccessEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.feed.publish.GuildTaskQueueManager;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedMoveEvent2;
import com.tencent.mobileqq.guild.feed.publish.event.GuildFeedUpdateChannelInfoEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildPublishSuccessGetFeedEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRemoveCapsuleEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildRemoveFakeFeedTaskEvent;
import com.tencent.mobileqq.guild.feed.publish.event.GuildTaskProgressStateEvent;
import com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper;
import com.tencent.mobileqq.guild.feed.util.bc;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.az;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.ao;
import com.tencent.mobileqq.qqguildsdk.data.genc.aq;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.bl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetExternalCommentsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetExternalCommentsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGetTopFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStComment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStUser;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopFeed;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetExternalCommentsCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedsCallback;
import com.tencent.richframework.data.base.BaseDataWorker;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.data.idata.IDataDisplaySurface;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.UiThreadUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import wh2.ds;

/* compiled from: P */
/* loaded from: classes13.dex */
public class GuildFeedWorker extends BaseDataWorker implements SimpleEventReceiver {

    /* renamed from: d, reason: collision with root package name */
    private final Map<String, List<ij1.g>> f218351d = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class a extends k<ij1.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildPublishSuccessGetFeedEvent f218362a;

        a(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
            this.f218362a = guildPublishSuccessGetFeedEvent;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        byte[] a() {
            return UIStateDataUtils.f219309a.a(UIStateDataUtils.InsertType.Other);
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        int b() {
            return 8;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        List<ij1.g> c(List<ij1.g> list) {
            int i3;
            String str = this.f218362a.getStFeed().idd;
            Iterator<ij1.g> it = list.iterator();
            while (true) {
                boolean z16 = true;
                if (it.hasNext()) {
                    ij1.g next = it.next();
                    if (next.b() != null && TextUtils.equals(str, next.b().idd)) {
                        QLog.w("Guild_Feed_GUP-T-GuildFeedWorker", 1, "insert feed of id: " + str + " but the same is exist!");
                        return list;
                    }
                } else {
                    Iterator<ij1.g> it5 = list.iterator();
                    while (true) {
                        if (it5.hasNext()) {
                            ij1.g next2 = it5.next();
                            if (next2.n() == null && !next2.b().channelTopInfo.isTop && next2.p() == null) {
                                i3 = list.indexOf(next2);
                                break;
                            }
                        } else {
                            z16 = false;
                            i3 = 0;
                            break;
                        }
                    }
                    if (!z16) {
                        i3 = list.size();
                    }
                    list.add(i3, new ij1.g(this.f218362a.getStFeed()));
                    return list;
                }
            }
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        void d(@NonNull UIStateData<List<ij1.g>> uIStateData) {
            uIStateData.setPos(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class b extends k<ij1.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildPublishSuccessGetFeedEvent f218364a;

        b(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
            this.f218364a = guildPublishSuccessGetFeedEvent;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        int b() {
            return 7;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        List<ij1.g> c(List<ij1.g> list) {
            String str = this.f218364a.getStFeed().idd;
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 < size) {
                    ij1.g gVar = list.get(i3);
                    if (gVar != null && gVar.b() != null && Objects.equals(gVar.b().idd, str)) {
                        break;
                    }
                    i3++;
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 != -1) {
                list.remove(i3);
                list.add(i3, new ij1.g(this.f218364a.getStFeed()));
            } else {
                QLog.w("Guild_Feed_GUP-T-GuildFeedWorker", 1, "edit feed successfully, but there is no target feed in list");
            }
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class c extends k<ij1.g> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public int b() {
            return 6;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public List<ij1.g> c(List<ij1.g> list) {
            ij1.g gVar;
            if (list != null && list.size() > 1 && (gVar = list.get(0)) != null && gVar.n() != null) {
                list.remove(0);
            }
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class d extends k<ij1.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f218367a;

        d(String str) {
            this.f218367a = str;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public int b() {
            return 6;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public List<ij1.g> c(List<ij1.g> list) {
            ArrayList arrayList = new ArrayList();
            for (ij1.g gVar : list) {
                GuildTaskProgressState p16 = gVar.p();
                if (p16 != null && TextUtils.equals(p16.getMainTaskId(), this.f218367a)) {
                    QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[removeFakeFeed] find and remove  | mainTaskId = " + this.f218367a);
                } else {
                    arrayList.add(gVar);
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class e extends k<ij1.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f218369a;

        e(List list) {
            this.f218369a = list;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public int b() {
            return 6;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public List<ij1.g> c(List<ij1.g> list) {
            ArrayList arrayList = new ArrayList();
            for (ij1.g gVar : list) {
                GuildTaskProgressState p16 = gVar.p();
                if (p16 != null) {
                    if (!this.f218369a.contains(p16.getMainTaskId())) {
                        arrayList.add(gVar);
                    } else {
                        QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[removeFakeFeedList] find and remove  | mainTaskId = " + p16.getMainTaskId());
                    }
                }
            }
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class f extends k<ij1.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildFeedDeleteEvent f218371a;

        f(GuildFeedDeleteEvent guildFeedDeleteEvent) {
            this.f218371a = guildFeedDeleteEvent;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        int b() {
            return 6;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        List<ij1.g> c(List<ij1.g> list) {
            Iterator<ij1.g> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GProStFeed b16 = it.next().b();
                if (b16 != null && TextUtils.equals(b16.idd, this.f218371a.getFeedId())) {
                    it.remove();
                    break;
                }
            }
            return list;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class g extends k<ij1.h> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f218373a;

        g(List list) {
            this.f218373a = list;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public int b() {
            return 7;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public List<ij1.h> c(List<ij1.h> list) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f218373a.iterator();
            while (it.hasNext()) {
                arrayList.add(new ij1.h((GProTopFeed) it.next()).i());
            }
            return arrayList;
        }
    }

    /* compiled from: P */
    /* loaded from: classes13.dex */
    class h implements GuildDbDataHelper.a<List<GuildTaskProgressState>> {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.feed.publish.helper.GuildDbDataHelper.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResult(List<GuildTaskProgressState> list) {
            if (bl.b(list)) {
                return;
            }
            Iterator<GuildTaskProgressState> it = list.iterator();
            while (it.hasNext()) {
                GuildFeedWorker.this.q(it.next(), true);
            }
            GuildTaskQueueManager.m().g(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class i extends k<ij1.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ij1.g f218376a;

        i(ij1.g gVar) {
            this.f218376a = gVar;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        byte[] a() {
            return UIStateDataUtils.f219309a.a(UIStateDataUtils.InsertType.Other);
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public int b() {
            return 8;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public List<ij1.g> c(List<ij1.g> list) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(0, this.f218376a);
            arrayList.addAll(list);
            return arrayList;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        void d(@NonNull UIStateData<List<ij1.g>> uIStateData) {
            uIStateData.setPos(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public class j extends k<ij1.g> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GuildTaskProgressState f218378a;

        j(GuildTaskProgressState guildTaskProgressState) {
            this.f218378a = guildTaskProgressState;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public int b() {
            return 7;
        }

        @Override // com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.k
        public List<ij1.g> c(List<ij1.g> list) {
            Iterator<ij1.g> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ij1.g next = it.next();
                GuildTaskProgressState p16 = next.p();
                if (p16 != null && TextUtils.equals(p16.getMainTaskId(), this.f218378a.getMainTaskId())) {
                    next.z(this.f218378a);
                    break;
                }
            }
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(list);
            return arrayList;
        }
    }

    public GuildFeedWorker() {
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private void A(GuildFeedExternalCommentsUpdatedEvent guildFeedExternalCommentsUpdatedEvent) {
        QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[handleExternalCommentsUpdateEvent] commentCount=" + guildFeedExternalCommentsUpdatedEvent.getCommentCount());
        String feedId = guildFeedExternalCommentsUpdatedEvent.getFeedId();
        if (TextUtils.isEmpty(feedId)) {
            QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[handleExternalCommentsUpdateEvent] not found feedId.");
        } else {
            k0(feedId, guildFeedExternalCommentsUpdatedEvent.getCommentCount());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void B(GuildFeedExternalPreferUpdatedEvent guildFeedExternalPreferUpdatedEvent) {
        String feedId = guildFeedExternalPreferUpdatedEvent.getFeedId();
        ArrayList<GProStUser> preferList = guildFeedExternalPreferUpdatedEvent.getPreferList();
        int preferCountWithoutLike = guildFeedExternalPreferUpdatedEvent.getPreferCountWithoutLike();
        QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[handleExternalPreferUpdateEvent] PreferCountWithoutLike " + preferCountWithoutLike + " feedId " + feedId + "externalLikeUserList " + preferList.size());
        if (TextUtils.isEmpty(feedId)) {
            return;
        }
        MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, feedId);
        if (globalData != null && globalData.getValue() != 0) {
            GProStFeed gProStFeed = (GProStFeed) globalData.getValue();
            gProStFeed.externalLikeUserList = preferList;
            gProStFeed.totalPrefer.preferCountWithoutLike = preferCountWithoutLike;
            globalData.postValue(gProStFeed);
            return;
        }
        QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[updateExternalComments] mutable live data should not be null.");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void C(GuildDetailViewDestroyEvent guildDetailViewDestroyEvent) {
        QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[handleFeedDetailPageFinishEvent] commentCount=" + guildDetailViewDestroyEvent.getCommentCount());
        MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, guildDetailViewDestroyEvent.getFeedId());
        if (globalData != null && globalData.getValue() != 0) {
            GProStFeed gProStFeed = (GProStFeed) globalData.getValue();
            int i3 = gProStFeed.totalPrefer.preferStatus;
            if (i3 != guildDetailViewDestroyEvent.getPreferStatus()) {
                bc.l(gProStFeed, i3, guildDetailViewDestroyEvent.getPreferStatus());
            }
            gProStFeed.share.sharedCount = guildDetailViewDestroyEvent.getShareCount();
            gProStFeed.totalPrefer.preferCountWithoutLike = guildDetailViewDestroyEvent.getPreferCount();
            gProStFeed.totalPrefer.preferStatus = guildDetailViewDestroyEvent.getPreferStatus();
            gProStFeed.commentCount = guildDetailViewDestroyEvent.getCommentCount();
            globalData.postValue(gProStFeed);
            return;
        }
        QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 1, "updateFeedShareData: mutable live data should not be null.");
    }

    private void D(GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent) {
        String guildId = guildFeedDetailTopUpdateEvent.getGuildId();
        String channelId = guildFeedDetailTopUpdateEvent.getChannelId();
        if (!TextUtils.isEmpty(guildId) && !TextUtils.isEmpty(channelId)) {
            int serviceType = guildFeedDetailTopUpdateEvent.getServiceType();
            if (guildFeedDetailTopUpdateEvent.isSectionFeedTop()) {
                n0(guildId, channelId, serviceType);
            }
            if (!guildFeedDetailTopUpdateEvent.isFeedTop()) {
                return;
            }
            if (com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a.f(guildId)) {
                channelId = "0";
            }
            n0(guildId, channelId, serviceType);
            return;
        }
        QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "handleFeedDetailTopUpdateEvent: not found channelId.");
    }

    private void E(final GuildFeedDeleteEvent guildFeedDeleteEvent) {
        Predicate<IDataDisplaySurface<?>> h16;
        f fVar = new f(guildFeedDeleteEvent);
        String dataDisplaySurfacePrefixKey = guildFeedDeleteEvent.getDataDisplaySurfacePrefixKey();
        if (TextUtils.isEmpty(dataDisplaySurfacePrefixKey)) {
            h16 = co1.d.f31167a.j(guildFeedDeleteEvent.getGuildId());
        } else {
            h16 = co1.d.f31167a.h(dataDisplaySurfacePrefixKey);
        }
        a0("data_type_feed_list", h16, null, fVar);
        if (guildFeedDeleteEvent.isNeedReFetchTopFeeds()) {
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.a
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedWorker.this.O(guildFeedDeleteEvent);
                }
            });
        }
    }

    private void F(final GuildFeedShareChannelEvent guildFeedShareChannelEvent) {
        IGPSService iGPSService = (IGPSService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGPSService.class, "");
        ao aoVar = new ao();
        aoVar.b(guildFeedShareChannelEvent.feedId);
        aq aqVar = new aq();
        aqVar.b(aoVar);
        iGPSService.reportFeedShareData(guildFeedShareChannelEvent.guildId, guildFeedShareChannelEvent.channelId, guildFeedShareChannelEvent.shareType, aqVar, guildFeedShareChannelEvent.destPlat, GuildFeedShareChannelEvent.INSTANCE.c(guildFeedShareChannelEvent.uinMap), new ds() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.d
            @Override // wh2.ds
            public final void onResult(int i3, String str) {
                GuildFeedWorker.this.P(guildFeedShareChannelEvent, i3, str);
            }
        });
    }

    private void G(@NonNull List<GProTopFeed> list, String str, String str2) {
        c0(new g(list), str, str2, true);
    }

    private void H(@NonNull GuildFeedMoveEvent2 guildFeedMoveEvent2) {
        GuildFeedDeleteEvent guildFeedDeleteEvent = new GuildFeedDeleteEvent(guildFeedMoveEvent2.getFeedId(), guildFeedMoveEvent2.getGuildId(), guildFeedMoveEvent2.getSourceChannelId());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(guildFeedMoveEvent2.getGuildId());
        co1.d dVar = co1.d.f31167a;
        sb5.append(dVar.f());
        sb5.append(guildFeedMoveEvent2.getSourceChannelId());
        sb5.append(dVar.f());
        sb5.append("default");
        guildFeedDeleteEvent.setDataDisplaySurfacePrefixKey(sb5.toString());
        E(guildFeedDeleteEvent);
        N(new GuildFeedUpdateChannelInfoEvent(guildFeedMoveEvent2.getFeedId(), guildFeedMoveEvent2.getGuildId(), guildFeedMoveEvent2.getTargetChannelId()));
    }

    private void I(GuildRemoveCapsuleEvent guildRemoveCapsuleEvent) {
        b0("data_type_feed_list", guildRemoveCapsuleEvent.mGuildId, new c());
    }

    private void J(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        k<ij1.g> y16 = y(guildPublishSuccessGetFeedEvent);
        co1.d dVar = co1.d.f31167a;
        final Predicate<IDataDisplaySurface<?>> k3 = dVar.k(guildPublishSuccessGetFeedEvent.getGuildId(), guildPublishSuccessGetFeedEvent.getChannelId());
        a0("data_type_feed_list", new Predicate() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.l
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean Q;
                Q = GuildFeedWorker.Q(Predicate.this, (IDataDisplaySurface) obj);
                return Q;
            }
        }, null, y16);
        final Predicate<IDataDisplaySurface<?>> j3 = dVar.j(guildPublishSuccessGetFeedEvent.getGuildId());
        a0("data_type_feed_list", new Predicate() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.b
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                boolean R;
                R = GuildFeedWorker.R(Predicate.this, (IDataDisplaySurface) obj);
                return R;
            }
        }, null, y16);
    }

    private void K(final GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        g0(guildPublishSuccessGetFeedEvent.getMainTaskId());
        final String guildId = guildPublishSuccessGetFeedEvent.getGuildId();
        final String channelId = guildPublishSuccessGetFeedEvent.getChannelId();
        String str = guildPublishSuccessGetFeedEvent.getStFeed().idd;
        if (guildPublishSuccessGetFeedEvent.isFeedFullDetail()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.e
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedWorker.this.S(guildPublishSuccessGetFeedEvent);
                }
            }, 600L);
        } else {
            g0(guildPublishSuccessGetFeedEvent.getMainTaskId());
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedWorker.T(guildId, channelId);
                }
            }, 10L);
        }
    }

    private void L(GuildRemoveFakeFeedTaskEvent guildRemoveFakeFeedTaskEvent) {
        if (guildRemoveFakeFeedTaskEvent.getMainTaskIdList() != null && !guildRemoveFakeFeedTaskEvent.getMainTaskIdList().isEmpty()) {
            h0(guildRemoveFakeFeedTaskEvent.getMainTaskIdList());
        } else if (!TextUtils.isEmpty(guildRemoveFakeFeedTaskEvent.getMainTaskId())) {
            g0(guildRemoveFakeFeedTaskEvent.getMainTaskId());
        } else {
            QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "handleRemoveFakeFeedTaskEvent: not has any mainTaskId!");
        }
    }

    private void M(final GuildTaskProgressStateEvent guildTaskProgressStateEvent) {
        if (guildTaskProgressStateEvent != null && guildTaskProgressStateEvent.getTaskProgressState() != null) {
            if (guildTaskProgressStateEvent.getTaskProgressState().getMainState() == 3) {
                RFWThreadManager.getUIHandler().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.10
                    @Override // java.lang.Runnable
                    public void run() {
                        GuildFeedWorker.this.f0(guildTaskProgressStateEvent.getTaskProgressState());
                    }
                }, 500L);
            } else {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.g
                    @Override // java.lang.Runnable
                    public final void run() {
                        GuildFeedWorker.this.U(guildTaskProgressStateEvent);
                    }
                });
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void N(@NonNull GuildFeedUpdateChannelInfoEvent guildFeedUpdateChannelInfoEvent) {
        GProStFeed gProStFeed;
        MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, guildFeedUpdateChannelInfoEvent.getFeedId());
        if (globalData != null) {
            gProStFeed = (GProStFeed) globalData.getValue();
        } else {
            gProStFeed = null;
        }
        if (gProStFeed == null) {
            QLog.w("Guild_Feed_GUP-T-GuildFeedWorker", 1, "handleUpdateChannelInfoEvent| feed:" + guildFeedUpdateChannelInfoEvent.getFeedId() + " origin data is null");
            return;
        }
        long d16 = az.d(guildFeedUpdateChannelInfoEvent.getChannelId(), 0L);
        long d17 = az.d(guildFeedUpdateChannelInfoEvent.getGuildId(), 0L);
        GProStChannelSign gProStChannelSign = gProStFeed.channelInfo.sign;
        gProStChannelSign.channelId = d16;
        gProStChannelSign.guildId = d17;
        IGProChannelInfo B = ch.B(guildFeedUpdateChannelInfoEvent.getChannelId());
        if (B != null && !TextUtils.isEmpty(B.getChannelName())) {
            gProStFeed.channelInfo.name = B.getChannelName();
        }
        globalData.postValue(gProStFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(GuildFeedDeleteEvent guildFeedDeleteEvent) {
        QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[handleFeedOrTopItemRemove] remove feed top Item!");
        GuildFeedDetailTopUpdateEvent guildFeedDetailTopUpdateEvent = new GuildFeedDetailTopUpdateEvent();
        guildFeedDetailTopUpdateEvent.setGuildId(guildFeedDeleteEvent.getGuildId());
        guildFeedDetailTopUpdateEvent.setChannelId(guildFeedDeleteEvent.getChannelId());
        guildFeedDetailTopUpdateEvent.setTopType(3);
        D(guildFeedDetailTopUpdateEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(GuildFeedShareChannelEvent guildFeedShareChannelEvent, int i3, String str) {
        QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "handleFeedShareChannelEvent: result[" + i3 + "] msg[" + str + "]");
        if (i3 == 0) {
            m0(guildFeedShareChannelEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean Q(Predicate predicate, IDataDisplaySurface iDataDisplaySurface) {
        if (predicate.test(iDataDisplaySurface) && !co1.d.f31167a.g(iDataDisplaySurface)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean R(Predicate predicate, IDataDisplaySurface iDataDisplaySurface) {
        if (predicate.test(iDataDisplaySurface) && iDataDisplaySurface.getDisplaySurfaceType() == 2 && !co1.d.f31167a.g(iDataDisplaySurface)) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        g0(guildPublishSuccessGetFeedEvent.getMainTaskId());
        J(guildPublishSuccessGetFeedEvent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void T(String str, String str2) {
        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedPublishSuccessEvent(str, str2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void U(GuildTaskProgressStateEvent guildTaskProgressStateEvent) {
        q(guildTaskProgressStateEvent.getTaskProgressState(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void V(Collection collection, k kVar, String str) {
        o0(collection, kVar, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void W(ArrayList arrayList) {
        GProStFeed decodeStFeed;
        int i3;
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            GProTopFeed gProTopFeed = (GProTopFeed) it.next();
            o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
            if (c16 != null && (decodeStFeed = c16.decodeStFeed(gProTopFeed.getFeed())) != null && ((i3 = decodeStFeed.feedType) == 0 || i3 == 2)) {
                GProStChannelSign gProStChannelSign = decodeStFeed.channelInfo.sign;
                arrayList2.add(new GuildFeedDetailPreloadParams(gProStChannelSign.guildId, gProStChannelSign.channelId, decodeStFeed.idd, decodeStFeed.poster.idd, decodeStFeed.createTime, decodeStFeed.meta.lastModifiedTime));
            }
        }
        if (!arrayList2.isEmpty()) {
            try {
                QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "preloadTopFeed longFeedSize: " + arrayList2.size());
                GuildFeedDetailDataCacheManager.y().s(arrayList2);
            } catch (Exception e16) {
                QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "preloadTopFeed error! " + e16.getMessage());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void X() {
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.f144630pa, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void Y(GProStFeed gProStFeed, int i3, MutableLiveData mutableLiveData, int i16, String str, GProGetExternalCommentsRsp gProGetExternalCommentsRsp) {
        if (i16 != 0) {
            QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[updateExternalComments] result[" + i16 + "] errMsg[" + str + "]");
            return;
        }
        ArrayList<GProStComment> externalCommentList = gProGetExternalCommentsRsp.getExternalCommentList();
        if (externalCommentList == null) {
            QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[updateExternalComments] externalCommentList is null!");
            return;
        }
        gProStFeed.externalCommentList = externalCommentList;
        gProStFeed.commentCount = i3;
        QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[updateExternalComments] externalCommentList.size=" + externalCommentList.size());
        mutableLiveData.postValue(gProStFeed);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Z(IPerformanceReportTask iPerformanceReportTask, String str, String str2, int i3, String str3, GProGetTopFeedsRsp gProGetTopFeedsRsp) {
        com.tencent.mobileqq.guild.feed.report.c.f223280a.D(iPerformanceReportTask, i3, str3, true);
        if (i3 != 0) {
            QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "updateFeedsTopList: result[" + i3 + "] errMsg[" + str3 + "]");
            return;
        }
        ArrayList<GProTopFeed> topFeeds = gProGetTopFeedsRsp.getTopFeeds();
        if (topFeeds == null) {
            QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "updateFeedsTopList: top feed list is null!");
        } else {
            G(topFeeds, str, str2);
            d0(topFeeds);
        }
    }

    private void a0(@NonNull final String str, @Nullable Predicate<? super IDataDisplaySurface<ij1.g>> predicate, @Nullable List<String> list, @NonNull final k<ij1.g> kVar) {
        final Collection collection;
        if (list != null && !list.isEmpty()) {
            collection = new LinkedList();
            for (String str2 : list) {
                IDataDisplaySurface displaySurface = getWorkDataCenter().getDisplaySurface(ij1.g.class, str2);
                if (displaySurface == null) {
                    QLog.w("Guild_Feed_GUP-T-GuildFeedWorker", 1, "modifyWithFeedBlockData|can not find displaySurface of dataSurfaceKey=" + str2);
                } else if (predicate == null || predicate.test(displaySurface)) {
                    collection.add(displaySurface);
                }
            }
        } else {
            Collection<IDataDisplaySurface> allDisplaySurface = getWorkDataCenter().getAllDisplaySurface(ij1.g.class);
            if (allDisplaySurface != null && !allDisplaySurface.isEmpty()) {
                if (predicate != null) {
                    LinkedList linkedList = new LinkedList();
                    for (IDataDisplaySurface iDataDisplaySurface : allDisplaySurface) {
                        if (predicate.test(iDataDisplaySurface)) {
                            linkedList.add(iDataDisplaySurface);
                        }
                    }
                    collection = linkedList;
                } else {
                    collection = allDisplaySurface;
                }
            } else {
                QLog.w("Guild_Feed_GUP-T-GuildFeedWorker", 1, "modifyWithFeedBlockData|getAllDisplaySurface is empty");
                return;
            }
        }
        if (!collection.isEmpty()) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.i
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedWorker.this.V(collection, kVar, str);
                }
            });
        }
    }

    private void b0(final String str, final String str2, final k<ij1.g> kVar) {
        if (kVar == null) {
            return;
        }
        final Collection allDisplaySurface = getWorkDataCenter().getAllDisplaySurface(ij1.g.class);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.4
            @Override // java.lang.Runnable
            public void run() {
                GuildFeedWorker.this.o0(allDisplaySurface, kVar, str, str2);
            }
        });
    }

    private void c0(final k kVar, final String str, final String str2, final boolean z16) {
        if (kVar == null) {
            return;
        }
        final Collection allDisplaySurface = getWorkDataCenter().getAllDisplaySurface(ij1.h.class);
        if (allDisplaySurface != null && !allDisplaySurface.isEmpty()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.GuildFeedWorker.6
                private void a(String str3, String str4) {
                    if (QLog.isColorLevel()) {
                        QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 2, "[forwardLastUpdateTimestamp]: surface.size = " + allDisplaySurface.size());
                    }
                    for (IDataDisplaySurface iDataDisplaySurface : allDisplaySurface) {
                        if (iDataDisplaySurface instanceof com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j) {
                            ((com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.j) iDataDisplaySurface).Y(str3, str4, System.currentTimeMillis());
                        }
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    if (z16) {
                        a(str, str2);
                    }
                    GuildFeedWorker.this.o0(allDisplaySurface, kVar, str, str2);
                }
            });
        } else {
            QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[modifyWithFeedTopData]: allFeedGuildDisplaySurfaces is null");
        }
    }

    private void d0(final ArrayList<GProTopFeed> arrayList) {
        if (arrayList.isEmpty()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedWorker.W(arrayList);
            }
        }, 16, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(GuildTaskProgressState guildTaskProgressState) {
        if (guildTaskProgressState == null) {
            return;
        }
        g0(guildTaskProgressState.getMainTaskId());
    }

    private void g0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Iterator<List<ij1.g>> it = this.f218351d.values().iterator();
        String str2 = "";
        while (it.hasNext()) {
            Iterator<ij1.g> it5 = it.next().iterator();
            while (it5.hasNext()) {
                GuildTaskProgressState p16 = it5.next().p();
                if (p16 != null && TextUtils.equals(p16.getMainTaskId(), str)) {
                    str2 = p16.mGuildId;
                    it5.remove();
                }
            }
        }
        b0("data_type_fake_list", str2, new d(str));
    }

    private void h0(List<String> list) {
        if (list != null && !list.isEmpty()) {
            QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[removeFakeFeedList]");
            Iterator<List<ij1.g>> it = this.f218351d.values().iterator();
            String str = "";
            while (it.hasNext()) {
                Iterator<ij1.g> it5 = it.next().iterator();
                while (it5.hasNext()) {
                    GuildTaskProgressState p16 = it5.next().p();
                    if (p16 != null) {
                        Iterator<String> it6 = list.iterator();
                        while (it6.hasNext()) {
                            if (TextUtils.equals(p16.getMainTaskId(), it6.next())) {
                                str = p16.mGuildId;
                                it5.remove();
                            }
                        }
                    }
                }
            }
            b0("data_type_fake_list", str, new e(list));
        }
    }

    private void i0(CommentStatusEvent commentStatusEvent) {
        String errMsg;
        if (!NetworkUtil.isNetworkAvailable()) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.j
                @Override // java.lang.Runnable
                public final void run() {
                    GuildFeedWorker.X();
                }
            }, 300L);
            return;
        }
        if (TextUtils.isEmpty(commentStatusEvent.getErrMsg())) {
            errMsg = BaseApplication.getContext().getString(R.string.f143860n8);
        } else {
            errMsg = commentStatusEvent.getErrMsg();
        }
        QQToast.makeText(BaseApplication.getContext(), 1, errMsg, 0).show();
    }

    private void j0() {
        QQToast.makeText(BaseApplication.getContext(), 2, R.string.f143870n9, 0).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void k0(String str, final int i3) {
        final MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, str);
        if (globalData != null && globalData.getValue() != 0) {
            final GProStFeed gProStFeed = (GProStFeed) globalData.getValue();
            o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
            if (c16 == null) {
                return;
            }
            GProGetExternalCommentsReq gProGetExternalCommentsReq = new GProGetExternalCommentsReq();
            gProGetExternalCommentsReq.getFeed().idd = str;
            gProGetExternalCommentsReq.getFeed().channelInfo.sign.guildId = gProStFeed.channelInfo.sign.guildId;
            gProGetExternalCommentsReq.getFeed().channelInfo.sign.channelId = gProStFeed.channelInfo.sign.channelId;
            c16.getExternalComments(gProGetExternalCommentsReq, new IGProGetExternalCommentsCallback() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.h
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetExternalCommentsCallback
                public final void onResult(int i16, String str2, GProGetExternalCommentsRsp gProGetExternalCommentsRsp) {
                    GuildFeedWorker.Y(GProStFeed.this, i3, globalData, i16, str2, gProGetExternalCommentsRsp);
                }
            });
            return;
        }
        QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[updateExternalComments] mutable live data should not be null.");
    }

    private void l0(GuildTaskProgressState guildTaskProgressState, ij1.g gVar) {
        GuildTaskProgressState p16 = gVar.p();
        if (p16 != null && p16.getMainState() != guildTaskProgressState.getMainState()) {
            b0("data_type_fake_list", guildTaskProgressState.getGuildId(), new j(guildTaskProgressState));
        }
        gVar.z(guildTaskProgressState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void m0(GuildFeedShareChannelEvent guildFeedShareChannelEvent) {
        MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, guildFeedShareChannelEvent.feedId);
        if (globalData != null && globalData.getValue() != 0) {
            GProStFeed gProStFeed = (GProStFeed) globalData.getValue();
            gProStFeed.share.sharedCount += guildFeedShareChannelEvent.getShareCount();
            globalData.postValue(gProStFeed);
            return;
        }
        QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 1, "updateFeedShareData: mutable live data should not be null.");
    }

    private void n0(final String str, final String str2, int i3) {
        GProGetTopFeedsReq gProGetTopFeedsReq = new GProGetTopFeedsReq();
        try {
            gProGetTopFeedsReq.guildId = Long.parseLong(str);
            gProGetTopFeedsReq.channelId = Long.parseLong(str2);
        } catch (Exception unused) {
            QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[updateFeedsTopList] guildId channelId parseLong error");
        }
        gProGetTopFeedsReq.serviceType = i3;
        o c16 = com.tencent.mobileqq.guild.feed.util.l.c();
        if (c16 == null) {
            return;
        }
        final IPerformanceReportTask j3 = com.tencent.mobileqq.guild.feed.report.c.f223280a.j("" + gProGetTopFeedsReq.guildId, "" + gProGetTopFeedsReq.channelId);
        if (QLog.isDevelopLevel()) {
            QLog.d("Guild_Feed_GUP-T-GuildFeedWorker", 4, "[updateFeedsTopList] " + gProGetTopFeedsReq);
        }
        c16.getTopFeeds(gProGetTopFeedsReq, new IGProGetTopFeedsCallback() { // from class: com.tencent.mobileqq.guild.feed.data.datacenter.worker.feed.k
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProGetTopFeedsCallback
            public final void onResult(int i16, String str3, GProGetTopFeedsRsp gProGetTopFeedsRsp) {
                GuildFeedWorker.this.Z(j3, str, str2, i16, str3, gProGetTopFeedsRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void o0(Collection<IDataDisplaySurface<T>> collection, k<T> kVar, Object... objArr) {
        UIStateData<List<T>> value;
        Iterator<IDataDisplaySurface<T>> it = collection.iterator();
        while (it.hasNext()) {
            MutableLiveData<UIStateData<List<T>>> displaySurfaceData = it.next().getDisplaySurfaceData(objArr);
            if (displaySurfaceData != null && displaySurfaceData.getValue() != null && (value = displaySurfaceData.getValue()) != null) {
                List<T> data = value.getData();
                if (data == null) {
                    data = new ArrayList<>();
                }
                value.setDataList(kVar.c(data));
                value.setState(kVar.b());
                value.setExtraByte(kVar.a());
                kVar.d(value);
                displaySurfaceData.setValue(value);
            }
        }
    }

    private void p(String str, String str2, ij1.g gVar) {
        String u16 = u(str, str2);
        List<ij1.g> list = this.f218351d.get(u16);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(0, gVar);
        this.f218351d.put(u16, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(GuildTaskProgressState guildTaskProgressState, boolean z16) {
        if (guildTaskProgressState != null && (guildTaskProgressState.isTriggerPublish() || z16)) {
            ij1.g s16 = s(guildTaskProgressState.getMainTaskId());
            if (s16 == null) {
                QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[addFakeFeedProgressTask] addFakeFeed  | taskId = " + guildTaskProgressState.getMainTaskId());
                r(guildTaskProgressState);
                return;
            }
            QLog.i("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[addFakeFeedProgressTask] update same task  | taskId = " + guildTaskProgressState.getMainTaskId() + " | mProgress = " + guildTaskProgressState.getProgress());
            l0(guildTaskProgressState, s16);
            return;
        }
        QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "[addFakeFeedProgressTask] invalid progress state.");
    }

    private void r(GuildTaskProgressState guildTaskProgressState) {
        ij1.g gVar = new ij1.g(new GProStFeed());
        gVar.z(guildTaskProgressState);
        p(guildTaskProgressState.getGuildId(), guildTaskProgressState.getChannelId(), gVar);
        b0("data_type_fake_list", guildTaskProgressState.getGuildId(), new i(gVar));
    }

    private ij1.g s(String str) {
        Iterator<List<ij1.g>> it = this.f218351d.values().iterator();
        while (it.hasNext()) {
            for (ij1.g gVar : it.next()) {
                GuildTaskProgressState p16 = gVar.p();
                if (p16 != null && TextUtils.equals(p16.getMainTaskId(), str)) {
                    return gVar;
                }
            }
        }
        return null;
    }

    private static AppRuntime t() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private static String u(String str, String str2) {
        try {
            IGProGuildInfo L = ch.L(str);
            if (L != null && L.isMovePostSection()) {
                str2 = "";
            }
            return t().getAccount() + "_" + str + "_" + str2;
        } catch (Throwable th5) {
            QLog.e("Guild_Feed_GUP-T-GuildFeedWorker", 1, "getChannelUniKey fail.", th5);
            return str + "_" + str2;
        }
    }

    private k<ij1.g> w(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        return new a(guildPublishSuccessGetFeedEvent);
    }

    private k<ij1.g> x(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        return new b(guildPublishSuccessGetFeedEvent);
    }

    @NonNull
    private k<ij1.g> y(GuildPublishSuccessGetFeedEvent guildPublishSuccessGetFeedEvent) {
        if (guildPublishSuccessGetFeedEvent.isEdit()) {
            return x(guildPublishSuccessGetFeedEvent);
        }
        return w(guildPublishSuccessGetFeedEvent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void z(CommentStatusEvent commentStatusEvent) {
        if (commentStatusEvent.getFromList()) {
            if (commentStatusEvent.getStatus() == 2) {
                String feedId = commentStatusEvent.getFeedId();
                MutableLiveData globalData = jj1.b.c().getGlobalData(GProStFeed.class, feedId);
                j0();
                if (globalData != null && globalData.getValue() != 0) {
                    GProStFeed gProStFeed = (GProStFeed) globalData.getValue();
                    gProStFeed.commentCount++;
                    globalData.postValue(gProStFeed);
                    k0(feedId, gProStFeed.commentCount);
                    return;
                }
                QLog.w("Guild_Feed_GUP-T-GuildFeedWorker", 1, "handleCommentStatusEvent: mutable live data should not be null.");
                return;
            }
            if (commentStatusEvent.getStatus() == 3) {
                i0(commentStatusEvent);
            }
        }
    }

    public void e0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        GuildTaskQueueManager.m().I(str, str2, new h());
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class> getEventClass() {
        ArrayList<Class> arrayList = new ArrayList<>();
        arrayList.add(GuildFeedDeleteEvent.class);
        arrayList.add(GuildTaskProgressStateEvent.class);
        arrayList.add(GuildPublishSuccessGetFeedEvent.class);
        arrayList.add(GuildRemoveFakeFeedTaskEvent.class);
        arrayList.add(GuildFeedDetailTopUpdateEvent.class);
        arrayList.add(GuildFeedShareChannelEvent.class);
        arrayList.add(GuildDetailViewDestroyEvent.class);
        arrayList.add(GuildRemoveCapsuleEvent.class);
        arrayList.add(CommentStatusEvent.class);
        arrayList.add(GuildFeedUpdateChannelInfoEvent.class);
        arrayList.add(GuildFeedMoveEvent2.class);
        arrayList.add(GuildFeedExternalCommentsUpdatedEvent.class);
        arrayList.add(GuildFeedExternalPreferUpdatedEvent.class);
        return arrayList;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        if (simpleBaseEvent instanceof GuildTaskProgressStateEvent) {
            M((GuildTaskProgressStateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildPublishSuccessGetFeedEvent) {
            K((GuildPublishSuccessGetFeedEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildRemoveFakeFeedTaskEvent) {
            L((GuildRemoveFakeFeedTaskEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedDeleteEvent) {
            E((GuildFeedDeleteEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedDetailTopUpdateEvent) {
            D((GuildFeedDetailTopUpdateEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedShareChannelEvent) {
            F((GuildFeedShareChannelEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildDetailViewDestroyEvent) {
            C((GuildDetailViewDestroyEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildRemoveCapsuleEvent) {
            I((GuildRemoveCapsuleEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof CommentStatusEvent) {
            z((CommentStatusEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedUpdateChannelInfoEvent) {
            N((GuildFeedUpdateChannelInfoEvent) simpleBaseEvent);
            return;
        }
        if (simpleBaseEvent instanceof GuildFeedMoveEvent2) {
            H((GuildFeedMoveEvent2) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedExternalCommentsUpdatedEvent) {
            A((GuildFeedExternalCommentsUpdatedEvent) simpleBaseEvent);
        } else if (simpleBaseEvent instanceof GuildFeedExternalPreferUpdatedEvent) {
            B((GuildFeedExternalPreferUpdatedEvent) simpleBaseEvent);
        }
    }

    public List<ij1.g> v(String str, String str2) {
        String u16 = u(str, str2);
        List<ij1.g> list = this.f218351d.get(u16);
        if (list == null) {
            list = new ArrayList<>();
            this.f218351d.put(u16, list);
        }
        return Collections.unmodifiableList(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes13.dex */
    public static abstract class k<T> {
        k() {
        }

        byte[] a() {
            return new byte[0];
        }

        abstract int b();

        abstract List<T> c(List<T> list);

        void d(@NonNull UIStateData<List<T>> uIStateData) {
        }
    }
}
