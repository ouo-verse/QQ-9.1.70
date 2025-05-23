package com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import ck1.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareChannelDeleteEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.event.GuildFeedSquareScheduleDeleteEvent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartCallerMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.part.remake.msgintent.FeedSectionListPartMsgIntent;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.DeleteFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildNewFeedPostDelegate;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.InsertFeedArgs;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGuildMsgService;
import com.tencent.mobileqq.qqguildsdk.data.GuildScheduleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProNewPostAndSystemPromptNotifyFeedEventData;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsFilter;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProPreloadGuildFeedsRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import com.tencent.richframework.data.base.UIStateData;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0002J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0016\u0010\u001a\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u0016\u0010\u001b\u001a\u00020\u00032\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0002J\u000e\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00180\u001cH\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J\b\u0010\u001f\u001a\u00020\u0003H\u0002J\b\u0010 \u001a\u00020\u0003H\u0002J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020!H\u0002J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u0015H\u0002J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0016J\u0010\u0010(\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0010\u0010+\u001a\u00020\u00032\u0006\u0010*\u001a\u00020)H\u0016J+\u00101\u001a\u00020\u00032\u0006\u0010,\u001a\u00020\u00152\u0006\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020/H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00109\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010;\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u00108R\u0016\u0010=\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010$\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/FeedSquareListWorkerDelegate;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/worker/DefaultFeedListWorkerDelegate;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate$b;", "", "J", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProNewPostAndSystemPromptNotifyFeedEventData;", "data", "E", "", "K", "", "guildId", "L", "N", "M", "O", "Lcom/tencent/mobileqq/guild/feed/feedsquare/event/GuildFeedSquareChannelDeleteEvent;", "event", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/event/GuildFeedSquareScheduleDeleteEvent;", "G", "", BdhLogUtil.LogTag.Tag_Conn, "", "Lij1/g;", "feedList", "P", "U", "", "D", "T", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/remake/msgintent/FeedSectionListPartMsgIntent$OnScrolledChangeMsgIntent;", "H", "sortMode", "I", "Lvi1/e;", "listUIOperationApi", "i", "a", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsReq;", "req", "c", "result", "", "errMsg", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsRsp;", "rsp", "b", "(ILjava/lang/String;Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProPreloadGuildFeedsRsp;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/GuildNewFeedPostDelegate;", "newFeedPostDelegate", "f", "Z", "canInsertFeedForPos", "g", "hiddenNavBarWhenScroll", tl.h.F, "scrollPosForSpecialFeed", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class FeedSquareListWorkerDelegate extends DefaultFeedListWorkerDelegate implements GuildNewFeedPostDelegate.b {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildNewFeedPostDelegate newFeedPostDelegate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean canInsertFeedForPos;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hiddenNavBarWhenScroll;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int scrollPosForSpecialFeed = -1;

    private final int C() {
        a.b bVar;
        com.tencent.mvi.base.route.k k3 = e().getMessenger().k(new FeedSectionListPartMsgIntent.GetFeedListSortModeMsgIntent(e().d()));
        if (k3 instanceof a.b) {
            bVar = (a.b) k3;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            return bVar.getFeedSortMode();
        }
        return 0;
    }

    private final List<ij1.g> D() {
        List<ij1.g> data;
        List<ij1.g> mutableList;
        UIStateData<List<ij1.g>> value = e().getVmApi().j().getValue();
        if (value != null && (data = value.getData()) != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : data) {
                GProStFeed b16 = ((ij1.g) obj).b();
                Intrinsics.checkNotNullExpressionValue(b16, "it.sourceData");
                if (!com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(b16)) {
                    arrayList.add(obj);
                }
            }
            if (!arrayList.isEmpty()) {
                mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) arrayList);
                return mutableList;
            }
            Logger.f235387a.d().w("FeedSquareListWorkerDelegate", 1, "getValidGProFeedBlockDataInVM is allLocalFeed");
            return data;
        }
        return new ArrayList();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(GProNewPostAndSystemPromptNotifyFeedEventData data) {
        if (K(data)) {
            if (L(data.guildId)) {
                e().getMessenger().h(new FeedSectionListPartCallerMsgIntent.CallRefreshMsgIntent(e().d().a(), false, false, true, null));
                Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "handleFeedNewPost isAutoRefreshFeedEvent autoRefresh");
                return;
            } else {
                Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "handleFeedNewPost isAutoRefreshFeedEvent notMatch");
                return;
            }
        }
        GuildNewFeedPostDelegate guildNewFeedPostDelegate = this.newFeedPostDelegate;
        if (guildNewFeedPostDelegate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("newFeedPostDelegate");
            guildNewFeedPostDelegate = null;
        }
        guildNewFeedPostDelegate.m(data);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F(final GuildFeedSquareChannelDeleteEvent event) {
        e().getVmApi().J0(new DeleteFeedArgs(new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$handleGuildFeedChannelDelete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull ij1.g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf((it.b().getRecommendCard().cardType == 1 || it.b().getRecommendCard().cardType == 2) && GuildFeedSquareChannelDeleteEvent.this.getChannelIds().contains(String.valueOf(it.b().getChannelInfo().getSign().getChannelId())));
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(final GuildFeedSquareScheduleDeleteEvent event) {
        e().getVmApi().J0(new DeleteFeedArgs(new Function1<ij1.g, Boolean>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$handleGuildFeedScheduleDelete$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull ij1.g it) {
                Intrinsics.checkNotNullParameter(it, "it");
                if (it.b().getRecommendCard().cardType != 3) {
                    return Boolean.FALSE;
                }
                Object d16 = it.d(it.m());
                if (d16 instanceof GuildScheduleInfo) {
                    if (GuildFeedSquareScheduleDeleteEvent.this.getScheduleIdList().contains(Long.valueOf(((GuildScheduleInfo) d16).getScheduleId()))) {
                        return Boolean.TRUE;
                    }
                }
                return Boolean.FALSE;
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H(FeedSectionListPartMsgIntent.OnScrolledChangeMsgIntent event) {
        a.C0197a c0197a;
        com.tencent.mvi.base.route.k k3 = e().getMessenger().k(new FeedSectionListPartMsgIntent.GetFeedListAdapterPosMsgIntent(e().d()));
        if (k3 != null) {
            if (k3 instanceof a.C0197a) {
                c0197a = (a.C0197a) k3;
            } else {
                c0197a = null;
            }
            if (c0197a != null) {
                boolean z16 = this.canInsertFeedForPos;
                boolean z17 = false;
                this.canInsertFeedForPos = false;
                int i3 = this.scrollPosForSpecialFeed;
                this.scrollPosForSpecialFeed = -1;
                if (c0197a.a().getFirst().intValue() != c0197a.a().getSecond().intValue()) {
                    if (c0197a.a().getFirst().intValue() >= event.a().getFirst().intValue() && c0197a.a().getFirst().intValue() <= event.a().getSecond().intValue()) {
                        z17 = true;
                    }
                    if (c0197a.a().getFirst().intValue() <= event.b().getFirst().intValue()) {
                        if (!z17) {
                            this.canInsertFeedForPos = true;
                        } else {
                            this.scrollPosForSpecialFeed = c0197a.a().getFirst().intValue();
                        }
                    }
                    if ((c0197a.a().getFirst().intValue() > event.b().getFirst().intValue() || z17) && this.hiddenNavBarWhenScroll) {
                        com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).o().setValue(Boolean.FALSE);
                    }
                }
                if (z16 != this.canInsertFeedForPos || i3 != this.scrollPosForSpecialFeed) {
                    Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "handleOnScrolledChangeMsgIntent feedListAdapterPos:" + c0197a.a() + " event.visiblePositionPair:" + event.b() + " event.completelyVisiblePositionPair: " + event.a() + " canInsertFeedForPos:" + this.canInsertFeedForPos + " isFirstFeedCompletelyVisible:" + z17 + " hiddenNavBarWhenScroll:" + this.hiddenNavBarWhenScroll + " scrollPosForSpecialFeed:" + this.scrollPosForSpecialFeed);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(int sortMode) {
        Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "handleOnSortModeChange sortMode:" + sortMode);
        if (sortMode != 3) {
            com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).o().setValue(Boolean.FALSE);
        }
    }

    private final void J() {
        this.newFeedPostDelegate = new GuildNewFeedPostDelegate(e().getLifecycleOwner(), this);
        FlowKt.launchIn(FlowKt.onEach(((IGuildMsgService) QRoute.api(IGuildMsgService.class)).registerGuildNewPostFlow(), new FeedSquareListWorkerDelegate$initNewFeedPostDelegate$1(this, null)), LifecycleOwnerKt.getLifecycleScope(e().getLifecycleOwner()));
    }

    private final boolean K(GProNewPostAndSystemPromptNotifyFeedEventData data) {
        boolean z16;
        boolean z17;
        boolean z18;
        int i3;
        if (String.valueOf(data.posterTinyId).length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && Intrinsics.areEqual(String.valueOf(data.posterTinyId), ax.u())) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (data.mainType == 4 && ((i3 = data.subType) == 1 || i3 == 2 || i3 == 3)) {
            z18 = true;
        } else {
            z18 = false;
        }
        if (!z17 || !z18) {
            return false;
        }
        return true;
    }

    private final boolean L(long guildId) {
        if (!Intrinsics.areEqual(e().d().a().getGuildId(), String.valueOf(guildId))) {
            Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "isMatchGuildAndSortMode not match guildId:" + e().d().a().getGuildId());
            return false;
        }
        if (ch.j0(e().d().a().getGuildId())) {
            Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "isMatchGuildAndSortMode isGuest guildId:" + e().d().a().getGuildId());
            return false;
        }
        int C = C();
        if (C == 3) {
            return true;
        }
        Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "isMatchGuildAndSortMode curSortMode:" + C);
        return false;
    }

    private final boolean M(GProNewPostAndSystemPromptNotifyFeedEventData data) {
        boolean z16;
        if (!GuardManager.sInstance.isApplicationForeground()) {
            Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "needHandlerPushNormal isApplicationBackground");
            return false;
        }
        if (!L(data.guildId)) {
            return false;
        }
        MutableLiveData<Boolean> o16 = com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).o();
        if (o16 != null) {
            z16 = Intrinsics.areEqual(o16.getValue(), Boolean.TRUE);
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "needHandlerPushNormal canInsertFeedForPos:" + this.canInsertFeedForPos + " hasNewFeedNavBar:" + z16);
        if (this.canInsertFeedForPos || !z16) {
            return true;
        }
        return false;
    }

    private final boolean N(GProNewPostAndSystemPromptNotifyFeedEventData data) {
        return L(data.guildId);
    }

    private final void O() {
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new FeedSquareListWorkerDelegate$onEventFlowObserve$$inlined$eventFlow$1(simpleEventBus, null)), new FeedSquareListWorkerDelegate$onEventFlowObserve$1(this, null)), LifecycleOwnerKt.getLifecycleScope(e().getLifecycleOwner()));
        SimpleEventBus simpleEventBus2 = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus2, "getInstance()");
        FlowKt.launchIn(FlowKt.onEach(FlowKt.callbackFlow(new FeedSquareListWorkerDelegate$onEventFlowObserve$$inlined$eventFlow$2(simpleEventBus2, null)), new FeedSquareListWorkerDelegate$onEventFlowObserve$2(this, null)), LifecycleOwnerKt.getLifecycleScope(e().getLifecycleOwner()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ba A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void P(List<? extends ij1.g> feedList) {
        Object firstOrNull;
        long j3;
        Object obj;
        boolean z16;
        long j16;
        String str;
        GProStFeed b16;
        Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "onInsertFeedList size:" + feedList.size());
        if (!feedList.isEmpty()) {
            List<ij1.g> D = D();
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) D);
            ij1.g gVar = (ij1.g) firstOrNull;
            if (gVar != null && (b16 = gVar.b()) != null) {
                j3 = b16.createTimeNs;
            } else {
                j3 = 0;
            }
            long j17 = 1000000;
            long j18 = j3 / j17;
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : feedList) {
                ij1.g gVar2 = (ij1.g) obj2;
                Iterator<T> it = D.iterator();
                while (true) {
                    obj = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    GProStFeed b17 = ((ij1.g) next).b();
                    if (b17 != null) {
                        str = b17.idd;
                    } else {
                        str = null;
                    }
                    GProStFeed b18 = gVar2.b();
                    if (b18 != null) {
                        obj = b18.idd;
                    }
                    if (Intrinsics.areEqual(str, obj)) {
                        obj = next;
                        break;
                    }
                }
                if (obj == null) {
                    GProStFeed b19 = gVar2.b();
                    if (b19 != null) {
                        j16 = b19.createTimeNs;
                    } else {
                        j16 = 0;
                    }
                    if (j16 / j17 >= j18) {
                        z16 = false;
                        if (z16) {
                            arrayList.add(obj2);
                        }
                    }
                }
                z16 = true;
                if (z16) {
                }
            }
            U(arrayList);
        }
    }

    private final void Q() {
        MutableLiveData<Boolean> o16 = com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).o();
        LifecycleOwner lifecycleOwner = e().getLifecycleOwner();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.FeedSquareListWorkerDelegate$onNavbarDataObserve$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                if (bool.booleanValue()) {
                    return;
                }
                FeedSquareListWorkerDelegate.this.hiddenNavBarWhenScroll = false;
                Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "onNavbarDataObserve hiddenNavBarWhenScroll: false");
            }
        };
        o16.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                FeedSquareListWorkerDelegate.R(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void S() {
        Flow callbackFlow = FlowKt.callbackFlow(new FeedSquareListWorkerDelegate$onScrollStateChangeListener$$inlined$eventFlow$1(e().getMessenger(), null));
        LifecycleOwner lifecycleOwner = e().getLifecycleOwner();
        Lifecycle.State state = Lifecycle.State.STARTED;
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new FeedSquareListWorkerDelegate$onScrollStateChangeListener$$inlined$collectIn$default$1(lifecycle, state, callbackFlow, null, this));
    }

    private final void T() {
        Flow callbackFlow = FlowKt.callbackFlow(new FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$eventFlow$1(e().getMessenger(), null));
        LifecycleOwner lifecycleOwner = e().getLifecycleOwner();
        Lifecycle.State state = Lifecycle.State.STARTED;
        Lifecycle lifecycle = lifecycleOwner.getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "owner.lifecycle");
        LifecycleKt.getCoroutineScope(lifecycle).launchWhenCreated(new FeedSquareListWorkerDelegate$onSortModeChangeListener$$inlined$collectIn$default$1(lifecycle, state, callbackFlow, null, this));
    }

    private final void U(List<? extends ij1.g> feedList) {
        boolean z16;
        Object first;
        int C = C();
        boolean z17 = false;
        if ((!feedList.isEmpty()) && C == 3) {
            List<? extends ij1.g> list = feedList;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (GuildNewFeedPostDelegate.INSTANCE.a((ij1.g) it.next())) {
                        z17 = true;
                        break;
                    }
                }
            }
            GuildNewFeedPostDelegate.Companion companion = GuildNewFeedPostDelegate.INSTANCE;
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) feedList);
            z16 = companion.a((ij1.g) first);
            if (!z17) {
                if (this.canInsertFeedForPos) {
                    com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).J1(feedList, new InsertFeedArgs(UIStateDataUtils.InsertType.NewFeed, 0, 0, null, 14, null));
                    this.hiddenNavBarWhenScroll = true;
                }
                com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).o().setValue(Boolean.TRUE);
            } else {
                if (this.scrollPosForSpecialFeed != -1 && z16) {
                    com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).J1(feedList, new InsertFeedArgs(UIStateDataUtils.InsertType.NewFeed, this.scrollPosForSpecialFeed, 0, null, 12, null));
                } else {
                    com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).J1(feedList, new InsertFeedArgs(UIStateDataUtils.InsertType.NewFeed, 0, 0, null, 14, null));
                }
                this.hiddenNavBarWhenScroll = true;
                com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).o().setValue(Boolean.TRUE);
            }
        } else {
            z16 = false;
        }
        Logger.f235387a.d().i("FeedSquareListWorkerDelegate", 1, "realInsertFeedList filter list size:" + feedList.size() + " curSortMode:" + C + " canInsertFeedForPos:" + this.canInsertFeedForPos + " hiddenNavBarWhenScroll:" + this.hiddenNavBarWhenScroll + "hasSpecialFeed:" + z17 + " isFirstSpecialFeed:" + z16 + " scrollPosForSpecialFeed:" + this.scrollPosForSpecialFeed);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildNewFeedPostDelegate.b
    public boolean a(@NotNull GProNewPostAndSystemPromptNotifyFeedEventData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (GuildNewFeedPostDelegate.INSTANCE.b(data)) {
            return N(data);
        }
        return M(data);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildNewFeedPostDelegate.b
    @Nullable
    public Object b(int i3, @NotNull String str, @NotNull GProPreloadGuildFeedsRsp gProPreloadGuildFeedsRsp, @NotNull Continuation<? super Unit> continuation) {
        return CorountineFunKt.i(i.b.f261780e, "FeedSquareListAdapterWorker.onHandlerRsp", null, new FeedSquareListWorkerDelegate$onHandlerRsp$2(gProPreloadGuildFeedsRsp, this, null), continuation, 4, null);
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildNewFeedPostDelegate.b
    public void c(@NotNull GProPreloadGuildFeedsReq req) {
        Object firstOrNull;
        GProStFeed sourceData;
        Intrinsics.checkNotNullParameter(req, "req");
        req.guildId = Long.parseLong(e().d().a().getGuildId());
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) D());
        ij1.g gVar = (ij1.g) firstOrNull;
        if (gVar != null && (sourceData = gVar.b()) != null) {
            Intrinsics.checkNotNullExpressionValue(sourceData, "sourceData");
            req.latestFeedId = sourceData.idd;
            req.latestContentTime = sourceData.createTimeNs / 1000000;
            req.getType = 2;
            req.sortOption = 1;
            GProPreloadGuildFeedsFilter gProPreloadGuildFeedsFilter = new GProPreloadGuildFeedsFilter();
            gProPreloadGuildFeedsFilter.needLive = true;
            gProPreloadGuildFeedsFilter.needVoice = true;
            gProPreloadGuildFeedsFilter.needScheduler = true;
            gProPreloadGuildFeedsFilter.needSysMsg = true;
            gProPreloadGuildFeedsFilter.needSum = true;
            req.filter = gProPreloadGuildFeedsFilter;
            req.token = com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.l.a(e().getVmApi()).getToken();
        }
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.part.remake.worker.DefaultFeedListWorkerDelegate, bk1.a.b
    public void i(@NotNull vi1.e listUIOperationApi) {
        Intrinsics.checkNotNullParameter(listUIOperationApi, "listUIOperationApi");
        super.i(listUIOperationApi);
        J();
        S();
        T();
        Q();
        O();
    }
}
