package com.tencent.mobileqq.qqguildsdk.manager;

import com.tencent.mobileqq.guild.api.IGProGuildMsgRecvService;
import com.tencent.mobileqq.qqguildsdk.data.GProAbstractUpdateData;
import com.tencent.mobileqq.qqguildsdk.data.GProUnreadCntUpData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernelgpro.nativeinterface.FirstViewDirectMsgNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProAvChannelStateMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconEventModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProBeaconStageModel;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProCheckInNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProGuildTopFeedMsg;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProManagerNotice;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProScheduleNotifyInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProUnreadCntInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstract;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006H\u0007J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0007J\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0006H\u0007R<\u0010\u0015\u001a\u001c\u0012\u0004\u0012\u00020\u000e\u0012\u0012\u0012\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0012\u0004\u0012\u00020\u00040\u000f0\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012\"\u0004\b\u0013\u0010\u0014R:\u0010\u0018\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\u000f0\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R:\u0010\u001b\u001a\u001a\u0012\u0004\u0012\u00020\u000e\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00040\u000f0\r8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/manager/GuildMsgServiceMgr;", "", "Luh2/c;", "service", "", "d", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/mobileqq/qqguildsdk/data/t;", "f", "Lcom/tencent/mobileqq/qqguildsdk/data/cd;", "g", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "e", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lkotlin/Function1;", "b", "Ljava/util/concurrent/ConcurrentHashMap;", "()Ljava/util/concurrent/ConcurrentHashMap;", "setOnMsgAbstractUpdateListeners$qqguild_sdk_impl_release", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "onMsgAbstractUpdateListeners", "c", "setOnUnreadCntUpdateListeners$qqguild_sdk_impl_release", "onUnreadCntUpdateListeners", "a", "setOnGuildNewPostListeners$qqguild_sdk_impl_release", "onGuildNewPostListeners", "<init>", "()V", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class GuildMsgServiceMgr {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildMsgServiceMgr f268418a = new GuildMsgServiceMgr();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<GProAbstractUpdateData, Unit>> onMsgAbstractUpdateListeners = new ConcurrentHashMap<>();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<GProUnreadCntUpData, Unit>> onUnreadCntUpdateListeners = new ConcurrentHashMap<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<Integer, Function1<GProNewPostAndSystemPromptNotifyFeedEventData, Unit>> onGuildNewPostListeners = new ConcurrentHashMap<>();

    GuildMsgServiceMgr() {
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<GProNewPostAndSystemPromptNotifyFeedEventData, Unit>> a() {
        return onGuildNewPostListeners;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<GProAbstractUpdateData, Unit>> b() {
        return onMsgAbstractUpdateListeners;
    }

    @NotNull
    public final ConcurrentHashMap<Integer, Function1<GProUnreadCntUpData, Unit>> c() {
        return onUnreadCntUpdateListeners;
    }

    public final void d(@Nullable uh2.c service) {
        QLog.i("GuildMsgServiceMgr", 1, "init");
        if (service != null) {
            service.w0(new a());
        }
        if (service != null) {
            IKernelGProGuildMsgListener r16 = service.r();
            Intrinsics.checkNotNull(r16);
            service.addKernelGProGuildMsgListener(r16);
        }
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<GProNewPostAndSystemPromptNotifyFeedEventData> e() {
        QLog.i("GuildMsgServiceMgr", 1, "registerGuildNewPostFlow");
        return FlowKt.callbackFlow(new GuildMsgServiceMgr$registerGuildNewPostFlow$1(null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<GProAbstractUpdateData> f() {
        QLog.i("GuildMsgServiceMgr", 1, "registerMsgAbstractUpdateFlow");
        return FlowKt.callbackFlow(new GuildMsgServiceMgr$registerMsgAbstractUpdateFlow$1(null));
    }

    @ExperimentalCoroutinesApi
    @NotNull
    public final Flow<GProUnreadCntUpData> g() {
        QLog.i("GuildMsgServiceMgr", 1, "registerUnreadCntInfoUpdateFlow");
        return FlowKt.callbackFlow(new GuildMsgServiceMgr$registerUnreadCntInfoUpdateFlow$1(null));
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000q\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0016J\u001c\u0010\u001c\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016J\"\u0010\u001d\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u00182\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0014H\u0016J.\u0010#\u001a\u00020\u00042$\u0010\"\u001a \u0012\u0004\u0012\u00020\u001f\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020 0\u0014j\b\u0012\u0004\u0012\u00020 `!\u0018\u00010\u001eH\u0016J\u0012\u0010%\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010$H\u0016J\u001e\u0010'\u001a\u00020\u00042\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016\u00a8\u0006("}, d2 = {"com/tencent/mobileqq/qqguildsdk/manager/GuildMsgServiceMgr$a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/FirstViewDirectMsgNotifyInfo;", "notifyInfo", "", "onFeedEventUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProGuildTopFeedMsg;", "topFeedMsg", "onGuildTopFeedUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "data", "onGuildNewPostEvent", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProScheduleNotifyInfo;", "scheduleNotifyInfo", "onGuildScheduleNotify", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProAvChannelStateMsg;", "onGuildAvChannelOpenUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProCheckInNotifyInfo;", "checkInNotifyInfo", "onGuildCheckInNotify", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/MsgAbstract;", "msgAbstractInfos", "onMsgAbstractUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBeaconEventModel;", "eventModel", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProBeaconStageModel;", "stage", "onBeaconReportCount", "onBeaconReportStage", "Ljava/util/HashMap;", "", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProUnreadCntInfo;", "Lkotlin/collections/ArrayList;", "unreadCntInfos", "onUnreadCntUpdate", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProManagerNotice;", "onGuildManagerEventUpdate", "switchValue", "onGuildHelperNotifySwitchUpdate", "qqguild-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class a implements IKernelGProGuildMsgListener {
        a() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onFeedEventUpdate(@Nullable FirstViewDirectMsgNotifyInfo notifyInfo) {
            if (notifyInfo != null) {
                ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onFeed2Msg(notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildAvChannelOpenUpdate(@Nullable GProAvChannelStateMsg notifyInfo) {
            if (notifyInfo != null) {
                ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onAVChannel2Msg(notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildCheckInNotify(@Nullable GProCheckInNotifyInfo checkInNotifyInfo) {
            if (checkInNotifyInfo != null) {
                ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onGuildCheckInNotify(checkInNotifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildHelperNotifySwitchUpdate(@Nullable HashMap<Integer, Integer> switchValue) {
            if (switchValue != null) {
                ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onGuildHelperNotifySwitchUpdate(switchValue);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildInteractiveUpdate(GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.g(this, guildInteractiveNotificationItem);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildManagerEventUpdate(@Nullable GProManagerNotice notifyInfo) {
            if (notifyInfo != null) {
                ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onManageNotice2Msg(notifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildNewPostEvent(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData data) {
            Intrinsics.checkNotNullParameter(data, "data");
            ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onGuildNewPostEvent(data);
            Iterator<Function1<GProNewPostAndSystemPromptNotifyFeedEventData, Unit>> it = GuildMsgServiceMgr.f268418a.a().values().iterator();
            while (it.hasNext()) {
                it.next().invoke(data);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildScheduleNotify(@Nullable GProScheduleNotifyInfo scheduleNotifyInfo) {
            if (scheduleNotifyInfo != null) {
                ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onGuildScheduleNotify(scheduleNotifyInfo);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildTopFeedUpdate(@Nullable GProGuildTopFeedMsg topFeedMsg) {
            if (topFeedMsg != null) {
                ((IGProGuildMsgRecvService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProGuildMsgRecvService.class, "")).onFeedTop2Msg(topFeedMsg);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onMsgAbstractUpdate(@Nullable ArrayList<MsgAbstract> msgAbstractInfos) {
            if (msgAbstractInfos != null) {
                Iterator<Function1<GProAbstractUpdateData, Unit>> it = GuildMsgServiceMgr.f268418a.b().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(new GProAbstractUpdateData(msgAbstractInfos));
                }
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntAfterFirstView(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.m(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onUnreadCntUpdate(@Nullable HashMap<Integer, ArrayList<GProUnreadCntInfo>> unreadCntInfos) {
            if (unreadCntInfos != null) {
                Iterator<Function1<GProUnreadCntUpData, Unit>> it = GuildMsgServiceMgr.f268418a.c().values().iterator();
                while (it.hasNext()) {
                    it.next().invoke(new GProUnreadCntUpData(unreadCntInfos));
                }
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onBeaconReportCount(@Nullable GProBeaconEventModel eventModel, @Nullable GProBeaconStageModel stage) {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onBeaconReportStage(@Nullable GProBeaconEventModel eventModel, @Nullable ArrayList<GProBeaconStageModel> stage) {
        }
    }
}
