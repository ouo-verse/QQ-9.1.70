package com.tencent.mobileqq.guild.feed.feedsection.part;

import android.app.Activity;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.PartIOCKt;
import com.tencent.mobileqq.guild.data.IGuildParcelizeSimpleContact;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareLiveRoomItemData;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareMediaRoomItemData;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareChannelDeleteEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareLiveRoomUpdateEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareMediaRoomUpdateEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareScheduleDeleteEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.k;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qqguildsdk.data.IAudioChannelMemberInfos;
import com.tencent.mobileqq.qqguildsdk.data.IGProSchedulePollingInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProScheduleStatusInfo;
import com.tencent.mobileqq.qqguildsdk.data.ILiveRoomInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.eq;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\f\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsection/part/FeedSectionMediaRoomPart;", "Lcom/tencent/biz/richframework/part/Part;", "Lcom/tencent/richframework/data/base/UIStateData;", "", "Lij1/g;", "uiStateData", "", "E9", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "D9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "d", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "e", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "", "f", "Ljava/lang/String;", "currentGuildId", "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/k;", "vmApi", "<init>", "()V", "i", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSectionMediaRoomPart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final IGPSService gProService;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver gProObserver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentGuildId;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private k vmApi;

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0014J \u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0004H\u0014J\u0012\u0010\r\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsection/part/FeedSectionMediaRoomPart$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "channelUinList", "", "onAudioChannelPollingSimpleInfoUpdate", "Lcom/tencent/mobileqq/qqguildsdk/data/ILiveRoomInfo;", "liveChannelPresences", "onPollingLiveChannelPresence", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSchedulePollingInfo;", "info", "onPollingScheduleInfo", "channelIds", "onPushChannelDestroy", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAudioChannelPollingSimpleInfoUpdate(@Nullable String guildId, @Nullable List<String> channelUinList) {
            List<ij1.g> list;
            GuildFeedSquareMediaRoomItemData guildFeedSquareMediaRoomItemData;
            QLog.d("FeedSectionMediaRoomPart", 1, "onAudioChannelPollingSimpleInfoUpdate");
            if (Intrinsics.areEqual(guildId, FeedSectionMediaRoomPart.this.currentGuildId)) {
                k kVar = FeedSectionMediaRoomPart.this.vmApi;
                if (kVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vmApi");
                    kVar = null;
                }
                if (kVar.p() == 3) {
                    k kVar2 = FeedSectionMediaRoomPart.this.vmApi;
                    if (kVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vmApi");
                        kVar2 = null;
                    }
                    UIStateData<List<ij1.g>> value = kVar2.j().getValue();
                    if (value != null) {
                        list = value.getData();
                    } else {
                        list = null;
                    }
                    if (list != null && channelUinList != null) {
                        FeedSectionMediaRoomPart feedSectionMediaRoomPart = FeedSectionMediaRoomPart.this;
                        for (String str : channelUinList) {
                            IAudioChannelMemberInfos pollingChannelOfVoice = feedSectionMediaRoomPart.gProService.getPollingChannelOfVoice(guildId, str);
                            if (pollingChannelOfVoice != null) {
                                Intrinsics.checkNotNullExpressionValue(pollingChannelOfVoice, "gProService.getPollingCh\u2026nnelId) ?: return@forEach");
                                for (ij1.g gVar : list) {
                                    if (((GProStFeed) gVar.b()).recommendCard.cardType == 1) {
                                        Object d16 = gVar.d(gVar.m());
                                        if (d16 instanceof GuildFeedSquareMediaRoomItemData) {
                                            guildFeedSquareMediaRoomItemData = (GuildFeedSquareMediaRoomItemData) d16;
                                        } else {
                                            guildFeedSquareMediaRoomItemData = null;
                                        }
                                        if (guildFeedSquareMediaRoomItemData != null && Intrinsics.areEqual(guildFeedSquareMediaRoomItemData.getGuildId(), guildId) && Intrinsics.areEqual(guildFeedSquareMediaRoomItemData.getChannelId(), str)) {
                                            GuildFeedSquareMediaRoomItemData e16 = GuildFeedSquareMediaRoomItemData.INSTANCE.e(guildId, pollingChannelOfVoice);
                                            if (!Intrinsics.areEqual(e16, guildFeedSquareMediaRoomItemData)) {
                                                gVar.f(gVar.m(), e16);
                                                SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                                                String str2 = ((GProStFeed) gVar.b()).idd;
                                                Intrinsics.checkNotNullExpressionValue(str2, "blockData.sourceData.idd");
                                                simpleEventBus.dispatchEvent(new GuildFeedSquareMediaRoomUpdateEvent(str2, e16));
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPollingLiveChannelPresence(@NotNull String guildId, @Nullable List<ILiveRoomInfo> liveChannelPresences) {
            List<ij1.g> list;
            GuildFeedSquareLiveRoomItemData guildFeedSquareLiveRoomItemData;
            boolean z16;
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            QLog.d("FeedSectionMediaRoomPart", 1, "onPollingLiveChannelPresence");
            if (Intrinsics.areEqual(guildId, FeedSectionMediaRoomPart.this.currentGuildId)) {
                k kVar = FeedSectionMediaRoomPart.this.vmApi;
                if (kVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("vmApi");
                    kVar = null;
                }
                if (kVar.p() == 3) {
                    k kVar2 = FeedSectionMediaRoomPart.this.vmApi;
                    if (kVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("vmApi");
                        kVar2 = null;
                    }
                    UIStateData<List<ij1.g>> value = kVar2.j().getValue();
                    if (value != null) {
                        list = value.getData();
                    } else {
                        list = null;
                    }
                    if (list != null && liveChannelPresences != null) {
                        for (ILiveRoomInfo iLiveRoomInfo : liveChannelPresences) {
                            for (ij1.g gVar : list) {
                                if (((GProStFeed) gVar.b()).recommendCard.cardType == 2) {
                                    Object d16 = gVar.d(gVar.m());
                                    if (d16 instanceof GuildFeedSquareLiveRoomItemData) {
                                        guildFeedSquareLiveRoomItemData = (GuildFeedSquareLiveRoomItemData) d16;
                                    } else {
                                        guildFeedSquareLiveRoomItemData = null;
                                    }
                                    if (guildFeedSquareLiveRoomItemData != null && Intrinsics.areEqual(guildFeedSquareLiveRoomItemData.getGuildId(), guildId) && Intrinsics.areEqual(guildFeedSquareLiveRoomItemData.getChannelId(), iLiveRoomInfo.getChannelId()) && guildFeedSquareLiveRoomItemData.getRoomState() == 1) {
                                        GuildFeedSquareLiveRoomItemData guildFeedSquareLiveRoomItemData2 = new GuildFeedSquareLiveRoomItemData(guildId, iLiveRoomInfo);
                                        if (guildFeedSquareLiveRoomItemData2.c().isEmpty()) {
                                            guildFeedSquareLiveRoomItemData2.c().putAll(guildFeedSquareLiveRoomItemData.c());
                                        }
                                        if (guildFeedSquareLiveRoomItemData2.getRoomTitle().length() == 0) {
                                            z16 = true;
                                        } else {
                                            z16 = false;
                                        }
                                        if (z16) {
                                            guildFeedSquareLiveRoomItemData2.h(guildFeedSquareLiveRoomItemData.getRoomTitle());
                                        }
                                        if (!Intrinsics.areEqual(guildFeedSquareLiveRoomItemData2, guildFeedSquareLiveRoomItemData)) {
                                            gVar.f(gVar.m(), guildFeedSquareLiveRoomItemData2);
                                            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
                                            String str = ((GProStFeed) gVar.b()).idd;
                                            Intrinsics.checkNotNullExpressionValue(str, "blockData.sourceData.idd");
                                            simpleEventBus.dispatchEvent(new GuildFeedSquareLiveRoomUpdateEvent(str, guildFeedSquareLiveRoomItemData2));
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onPollingScheduleInfo(@Nullable IGProSchedulePollingInfo info) {
            QLog.d("FeedSectionMediaRoomPart", 1, "onPollingScheduleInfo");
            if (info != null) {
                if (Intrinsics.areEqual(String.valueOf(info.getGuildId()), FeedSectionMediaRoomPart.this.currentGuildId)) {
                    ArrayList arrayList = new ArrayList();
                    ArrayList<IGProScheduleStatusInfo> schedulerStatus = info.getSchedulerStatus();
                    if (schedulerStatus != null) {
                        Intrinsics.checkNotNullExpressionValue(schedulerStatus, "schedulerStatus");
                        for (IGProScheduleStatusInfo iGProScheduleStatusInfo : schedulerStatus) {
                            if (iGProScheduleStatusInfo.getStatus() == 1) {
                                arrayList.add(Long.valueOf(iGProScheduleStatusInfo.getScheduleId()));
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        SimpleEventBus.getInstance().dispatchEvent(new GuildFeedSquareScheduleDeleteEvent(String.valueOf(info.getGuildId()), String.valueOf(info.getChannelId()), arrayList));
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onPushChannelDestroy(@Nullable String guildId, @Nullable List<String> channelIds) {
            QLog.d("FeedSectionMediaRoomPart", 1, "onPushChannelDestroy");
            if (Intrinsics.areEqual(guildId, FeedSectionMediaRoomPart.this.currentGuildId) && channelIds != null) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedSquareChannelDeleteEvent(guildId, channelIds));
            }
        }
    }

    public FeedSectionMediaRoomPart() {
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        this.gProService = (IGPSService) S0;
        this.gProObserver = D9();
        this.currentGuildId = "";
    }

    private final GPServiceObserver D9() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E9(UIStateData<List<ij1.g>> uiStateData) {
        GuildScheduleInfo guildScheduleInfo;
        int state = uiStateData.getState();
        if (state == 2 || state == 3) {
            List<ij1.g> data = uiStateData.getData();
            Intrinsics.checkNotNullExpressionValue(data, "uiStateData.data");
            for (ij1.g gVar : data) {
                if (gVar.b().recommendCard.cardType == 3) {
                    Object d16 = gVar.d(gVar.m());
                    if (d16 instanceof GuildScheduleInfo) {
                        guildScheduleInfo = (GuildScheduleInfo) d16;
                    } else {
                        guildScheduleInfo = null;
                    }
                    if (guildScheduleInfo != null) {
                        IGPSService iGPSService = this.gProService;
                        eq eqVar = new eq();
                        eqVar.e(gVar.b().channelInfo.sign.guildId);
                        eqVar.d(gVar.b().channelInfo.sign.channelId);
                        eqVar.f(guildScheduleInfo.getScheduleId());
                        iGPSService.subscribePollingSchedule(eqVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        k vmApi;
        String str;
        i<GuildFeedMainInitBean> d16;
        IGuildParcelizeSimpleContact a16;
        super.onInitView(rootView);
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) PartIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
        if (gVar != null && (context = gVar.getContext()) != null && (vmApi = context.getVmApi()) != null) {
            this.vmApi = vmApi;
            com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context2 = gVar.getContext();
            if (context2 == null || (d16 = context2.d()) == null || (a16 = d16.a()) == null || (str = a16.getGuildId()) == null) {
                str = "";
            }
            this.currentGuildId = str;
            k kVar = this.vmApi;
            if (kVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("vmApi");
                kVar = null;
            }
            MutableLiveData<UIStateData<List<ij1.g>>> j3 = kVar.j();
            LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
            final FeedSectionMediaRoomPart$onInitView$1 feedSectionMediaRoomPart$onInitView$1 = new FeedSectionMediaRoomPart$onInitView$1(this);
            j3.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    FeedSectionMediaRoomPart.F9(Function1.this, obj);
                }
            });
            this.gProService.addObserver(this.gProObserver);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        this.gProService.deleteObserver(this.gProObserver);
    }
}
