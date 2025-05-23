package com.tencent.mobileqq.guild.feed.feedsquare.viewmodel;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareNoticeViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
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
import com.tencent.qqnt.kernelgpro.nativeinterface.GuildInteractiveNotificationItem;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback;
import com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener;
import com.tencent.richframework.data.base.UIStateData;
import ij1.GuildFeedsHeaderData;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000;\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014*\u0001\n\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u000f\u0010\u000b\u001a\u00020\nH\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\r\u001a\u00020\u0005H\u0002J,\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000e2\u0014\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0005J\u0012\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u0010J\b\u0010\u0017\u001a\u00020\u0005H\u0014R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010!\u001a\u00020\n8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\f\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareNoticeViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lij1/d;", "headerData", "", "d2", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", "uiData", "c2", "com/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareNoticeViewModel$b", "S1", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareNoticeViewModel$b;", "Z1", "", "guild", "Landroidx/lifecycle/MutableLiveData;", "data", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "W1", "b2", "U1", "onCleared", "i", "Landroidx/lifecycle/MutableLiveData;", "mNoticeBubbleData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "activeGuildId", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "T1", "kernelObserver", "<init>", "()V", "D", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareNoticeViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy kernelObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<GuildInteractiveNotificationItem>> mNoticeBubbleData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String activeGuildId = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/viewmodel/GuildFeedSquareNoticeViewModel$b", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onGuildInteractiveUpdate", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IKernelGProGuildMsgListener {
        b() {
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onBeaconReportCount(GProBeaconEventModel gProBeaconEventModel, GProBeaconStageModel gProBeaconStageModel) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.a(this, gProBeaconEventModel, gProBeaconStageModel);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onBeaconReportStage(GProBeaconEventModel gProBeaconEventModel, ArrayList arrayList) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.b(this, gProBeaconEventModel, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onFeedEventUpdate(FirstViewDirectMsgNotifyInfo firstViewDirectMsgNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.c(this, firstViewDirectMsgNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildAvChannelOpenUpdate(GProAvChannelStateMsg gProAvChannelStateMsg) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.d(this, gProAvChannelStateMsg);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildCheckInNotify(GProCheckInNotifyInfo gProCheckInNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.e(this, gProCheckInNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildHelperNotifySwitchUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.f(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public void onGuildInteractiveUpdate(@Nullable GuildInteractiveNotificationItem item) {
            Integer num;
            String str = GuildFeedSquareNoticeViewModel.this.activeGuildId;
            String str2 = null;
            if (item != null) {
                num = Integer.valueOf(item.updateFrom);
            } else {
                num = null;
            }
            boolean z16 = true;
            QLog.d("GuildFeedSquareNoticeViewModel", 1, "onGuildInteractiveUpdate activeGuildId:" + str + " item:" + num);
            if (item == null || item.updateFrom != 0) {
                z16 = false;
            }
            if (z16) {
                if (item != null) {
                    str2 = item.guildId;
                }
                if (Intrinsics.areEqual(str2, GuildFeedSquareNoticeViewModel.this.activeGuildId)) {
                    GuildFeedSquareNoticeViewModel.this.Z1();
                }
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildManagerEventUpdate(GProManagerNotice gProManagerNotice) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.h(this, gProManagerNotice);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildNewPostEvent(GProNewPostAndSystemPromptNotifyFeedEventData gProNewPostAndSystemPromptNotifyFeedEventData) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.i(this, gProNewPostAndSystemPromptNotifyFeedEventData);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildScheduleNotify(GProScheduleNotifyInfo gProScheduleNotifyInfo) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.j(this, gProScheduleNotifyInfo);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onGuildTopFeedUpdate(GProGuildTopFeedMsg gProGuildTopFeedMsg) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.k(this, gProGuildTopFeedMsg);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onMsgAbstractUpdate(ArrayList arrayList) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.l(this, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntAfterFirstView(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.m(this, hashMap);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgListener
        public /* synthetic */ void onUnreadCntUpdate(HashMap hashMap) {
            com.tencent.qqnt.kernelgpro.nativeinterface.e.n(this, hashMap);
        }
    }

    public GuildFeedSquareNoticeViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareNoticeViewModel$kernelObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildFeedSquareNoticeViewModel.b invoke() {
                GuildFeedSquareNoticeViewModel.b S1;
                S1 = GuildFeedSquareNoticeViewModel.this.S1();
                return S1;
            }
        });
        this.kernelObserver = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b S1() {
        return new b();
    }

    private final b T1() {
        return (b) this.kernelObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z1() {
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getGuildInteractiveNotification(this.activeGuildId, 3, new IGuildInteractiveNotificationCallback() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.h
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback
                public final void onResult(int i3, String str, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
                    GuildFeedSquareNoticeViewModel.a2(GuildFeedSquareNoticeViewModel.this, i3, str, guildInteractiveNotificationItem);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(GuildFeedSquareNoticeViewModel this$0, int i3, String msg2, GuildInteractiveNotificationItem item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(item, "item");
        QLog.d("GuildFeedSquareNoticeViewModel", 1, "loadFeedNoticeMsgData  InteractiveNotification result:" + i3 + " msg:" + msg2);
        UIStateData<GuildInteractiveNotificationItem> data = UIStateData.obtainSuccess(false).setData(false, item);
        Intrinsics.checkNotNullExpressionValue(data, "obtainSuccess<GuildInter\u2026    .setData(false, item)");
        this$0.c2(data);
    }

    private final void c2(final UIStateData<GuildInteractiveNotificationItem> uiData) {
        kotlin.Function0.d(new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.GuildFeedSquareNoticeViewModel$updateNoticeBubble$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MutableLiveData mutableLiveData;
                mutableLiveData = GuildFeedSquareNoticeViewModel.this.mNoticeBubbleData;
                mutableLiveData.setValue(uiData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d2(UIStateData<GuildFeedsHeaderData> headerData) {
        GuildInteractiveNotificationItem noticeData;
        GuildFeedsHeaderData data = headerData.getData();
        if (data != null && (noticeData = data.getNoticeData()) != null) {
            UIStateData<GuildInteractiveNotificationItem> data2 = UIStateData.obtainSuccess(false).setData(false, noticeData);
            Intrinsics.checkNotNullExpressionValue(data2, "obtainSuccess<GuildInter\u2026      .setData(false, it)");
            c2(data2);
        }
    }

    @NotNull
    public final MutableLiveData<UIStateData<GuildInteractiveNotificationItem>> U1() {
        return this.mNoticeBubbleData;
    }

    public final void W1(@NotNull String guild2, @Nullable MutableLiveData<UIStateData<GuildFeedsHeaderData>> data, @NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(guild2, "guild");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        this.activeGuildId = guild2;
        if (data != null) {
            final GuildFeedSquareNoticeViewModel$init$1 guildFeedSquareNoticeViewModel$init$1 = new GuildFeedSquareNoticeViewModel$init$1(this);
            data.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.viewmodel.i
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildFeedSquareNoticeViewModel.X1(Function1.this, obj);
                }
            });
        }
        QLog.d("GuildFeedSquareNoticeViewModel", 1, "onGuildInteractiveUpdate activeGuildId:" + this.activeGuildId);
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.addKernelGProGuildMsgListener(T1());
        }
    }

    public final void b2() {
        Z1();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.z(T1());
        }
    }
}
