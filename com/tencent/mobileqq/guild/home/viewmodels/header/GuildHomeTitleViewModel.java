package com.tencent.mobileqq.guild.home.viewmodels.header;

import android.util.Log;
import androidx.annotation.UiThread;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeTitleViewModel;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.NoticeBubbleInfo;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.api.IGProSession;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
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
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.v;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u0007\u0018\u0000 ;2\u00020\u0001:\u0001<B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000f\u0010\b\u001a\u00020\u0007H\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0014R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001bR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001b\u0010(\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010\tR\u0014\u0010/\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00102\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b0\u00101R\u0019\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u0019038F\u00a2\u0006\u0006\u001a\u0004\b4\u00105R\u0017\u00108\u001a\b\u0012\u0004\u0012\u00020\u001d038F\u00a2\u0006\u0006\u001a\u0004\b7\u00105\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel;", "Lef1/b;", "", "j2", "", "source", ICustomDataEditor.STRING_ARRAY_PARAM_2, "com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel$c", "Z1", "()Lcom/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel$c;", SemanticAttributes.DbSystemValues.H2, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "X1", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "k2", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "W1", "account", "onAccountChanged", "onCleared", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "Le12/a;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "D", "Le12/a;", "_guildInfo", "Lcom/tencent/mobileqq/guild/home/viewmodels/header/uidata/g;", "E", "_noticeMsgData", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "G", "Lkotlin/Lazy;", "d2", "()Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "gProObserver", "H", "f2", "kernelObserver", "Ldr1/a;", "I", "Ldr1/a;", "repository", "c2", "()Ljava/lang/String;", "activeGuildId", "Landroidx/lifecycle/LiveData;", "e2", "()Landroidx/lifecycle/LiveData;", "guildInfo", "g2", "noticeMsgData", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeTitleViewModel extends ef1.b {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private FacadeArgsData facadeArgsData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final e12.a<IGProGuildInfo> _guildInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final e12.a<NoticeBubbleInfo> _noticeMsgData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private IGPSService gProService;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy gProObserver;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy kernelObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final dr1.a repository;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0014J2\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0011H\u0014\u00a8\u0006\u0014"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "", "b", "onGuildInfoUpdated", "onRemoveGuild", "onDestoryGuild", "onDeleteGuild", "", "black", "onBeKickFromGuild", "", AppConstants.Key.COLUMN_IS_VALID, "isBanned", "isFrozen", "", "guildBannedTimeLimit", "onBannedStatusChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        private final void b(String guildId) {
            if (Intrinsics.areEqual(guildId, GuildHomeTitleViewModel.this.c2())) {
                GuildHomeTitleViewModel.this._guildInfo.setValue(ch.L(guildId));
            }
        }

        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onBannedStatusChanged(@Nullable String guildId, boolean isValid, boolean isBanned, boolean isFrozen, long guildBannedTimeLimit) {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.NewHome.GuildHomeTitleViewModel", "onBannedStatusChanged: isBanned " + isBanned);
            }
            if (isBanned) {
                GuildHomeTitleViewModel.this._guildInfo.setValue(ch.L(guildId));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onBeKickFromGuild(@Nullable String guildId, int black) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDeleteGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onDestoryGuild(@Nullable String guildId) {
            b(guildId);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (Intrinsics.areEqual(guildId, GuildHomeTitleViewModel.this.c2())) {
                GuildHomeTitleViewModel.this._guildInfo.setValue(ch.L(guildId));
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onRemoveGuild(@Nullable String guildId) {
            b(guildId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/viewmodels/header/GuildHomeTitleViewModel$c", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/IKernelGProGuildMsgListener;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GuildInteractiveNotificationItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onGuildInteractiveUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements IKernelGProGuildMsgListener {
        c() {
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
            String str;
            Logger logger = Logger.f235387a;
            GuildHomeTitleViewModel guildHomeTitleViewModel = GuildHomeTitleViewModel.this;
            boolean z16 = true;
            logger.d().d("Guild.NewHome.GuildHomeTitleViewModel", 1, "onGuildInteractiveUpdate activeGuildId:" + guildHomeTitleViewModel.c2() + " item:" + item);
            if (item == null || item.updateFrom != 0) {
                z16 = false;
            }
            if (z16) {
                if (item != null) {
                    str = item.guildId;
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(str, GuildHomeTitleViewModel.this.c2())) {
                    GuildHomeTitleViewModel.this.h2();
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

    public GuildHomeTitleViewModel(@NotNull FacadeArgsData facadeArgsData) {
        Lazy lazy;
        Lazy lazy2;
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        this._guildInfo = new e12.a<>();
        this._noticeMsgData = new e12.a<>();
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        this.gProService = (IGPSService) R0;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<GPServiceObserver>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeTitleViewModel$gProObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GPServiceObserver invoke() {
                GPServiceObserver X1;
                X1 = GuildHomeTitleViewModel.this.X1();
                return X1;
            }
        });
        this.gProObserver = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeTitleViewModel$kernelObserver$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeTitleViewModel.c invoke() {
                GuildHomeTitleViewModel.c Z1;
                Z1 = GuildHomeTitleViewModel.this.Z1();
                return Z1;
            }
        });
        this.kernelObserver = lazy2;
        this.repository = new dr1.a();
        this.gProService.addObserver(d2());
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.addKernelGProGuildMsgListener(f2());
        }
        j2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final GPServiceObserver X1() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c Z1() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a2(final String source) {
        Logger.f235387a.d().d("Guild.NewHome.GuildHomeTitleViewModel", 1, "[fetchBanMemberCode] " + source);
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(java, process)");
        ((IGPSService) S0).fetchGuildInfoWithSource(c2(), 104, new v() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.l
            @Override // vh2.v
            public final void a(int i3, String str, IGProGuildInfo iGProGuildInfo) {
                GuildHomeTitleViewModel.b2(GuildHomeTitleViewModel.this, source, i3, str, iGProGuildInfo);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(GuildHomeTitleViewModel this$0, String source, int i3, String str, IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(source, "$source");
        Logger.f235387a.d().d("Guild.NewHome.GuildHomeTitleViewModel", 1, "[fetchBanMemberCode] source:" + source + ", result:" + i3 + ", errMsg:" + str);
        if (i3 == 0) {
            this$0._guildInfo.postValue(ch.L(this$0.c2()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String c2() {
        String str = this.facadeArgsData.f227656e;
        Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
        return str;
    }

    private final GPServiceObserver d2() {
        return (GPServiceObserver) this.gProObserver.getValue();
    }

    private final c f2() {
        return (c) this.kernelObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h2() {
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.getGuildInteractiveNotification(c2(), 3, new IGuildInteractiveNotificationCallback() { // from class: com.tencent.mobileqq.guild.home.viewmodels.header.k
                @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGuildInteractiveNotificationCallback
                public final void onResult(int i3, String str, GuildInteractiveNotificationItem guildInteractiveNotificationItem) {
                    GuildHomeTitleViewModel.i2(GuildHomeTitleViewModel.this, i3, str, guildInteractiveNotificationItem);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(GuildHomeTitleViewModel this$0, int i3, String msg2, GuildInteractiveNotificationItem item) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(item, "item");
        Logger.f235387a.d().d("Guild.NewHome.GuildHomeTitleViewModel", 1, "loadFeedNoticeMsgData  InteractiveNotification result:" + i3 + " msg:" + msg2 + " item:" + item);
        this$0._noticeMsgData.setValue(NoticeBubbleInfo.INSTANCE.a(this$0.c2(), item));
    }

    private final void j2() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "Guild.NewHome.GuildHomeTitleViewModel init", null, null, null, new GuildHomeTitleViewModel$refreshData$1(this, null), 14, null);
    }

    @UiThread
    public final void W1(@NotNull FacadeArgsData facadeArgsData, @NotNull GuildFacadeType guildFacadeType) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        Intrinsics.checkNotNullParameter(guildFacadeType, "guildFacadeType");
        this.repository.a(facadeArgsData, guildFacadeType);
    }

    @NotNull
    public final LiveData<IGProGuildInfo> e2() {
        return this._guildInfo;
    }

    @NotNull
    public final LiveData<NoticeBubbleInfo> g2() {
        return this._noticeMsgData;
    }

    public final void k2(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
        j2();
    }

    @Override // ef1.b, com.tencent.mobileqq.guild.base.repository.a
    public void onAccountChanged(@NotNull String account) {
        Intrinsics.checkNotNullParameter(account, "account");
        super.onAccountChanged(account);
        this.gProService.deleteObserver(d2());
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.z(f2());
        }
        IRuntimeService R0 = ch.R0(IGPSService.class);
        Intrinsics.checkNotNullExpressionValue(R0, "runtimeService(IGPSService::class.java)");
        IGPSService iGPSService = (IGPSService) R0;
        this.gProService = iGPSService;
        iGPSService.addObserver(d2());
        uh2.c gProGuildMsgService2 = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService2 != null) {
            gProGuildMsgService2.addKernelGProGuildMsgListener(f2());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ef1.b, androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        this.gProService.deleteObserver(d2());
        uh2.c gProGuildMsgService = ((IGProSession) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IGProSession.class, "")).getGProGuildMsgService();
        if (gProGuildMsgService != null) {
            gProGuildMsgService.z(f2());
        }
    }
}
