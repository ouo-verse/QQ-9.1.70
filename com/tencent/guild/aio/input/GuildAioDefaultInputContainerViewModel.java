package com.tencent.guild.aio.input;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fo0.c;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.CharsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import pn0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\b*\u0002\u001c \u0018\u0000 \u00132\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/guild/aio/input/GuildAioDefaultInputContainerViewModel;", "Lpn0/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "height", "r", "", "from", "u", "t", "v", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "f", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "com/tencent/guild/aio/input/GuildAioDefaultInputContainerViewModel$c", h.F, "Lcom/tencent/guild/aio/input/GuildAioDefaultInputContainerViewModel$c;", "mSpeakThresholdUpdateListener", "com/tencent/guild/aio/input/GuildAioDefaultInputContainerViewModel$receiver$1", "i", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputContainerViewModel$receiver$1;", "receiver", "<init>", "()V", "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioDefaultInputContainerViewModel extends a<fo0.c, InputUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver = new b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mSpeakThresholdUpdateListener = new c();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildAioDefaultInputContainerViewModel$receiver$1 receiver = new BroadcastReceiver() { // from class: com.tencent.guild.aio.input.GuildAioDefaultInputContainerViewModel$receiver$1
        @Override // android.content.BroadcastReceiver
        public void onReceive(@NotNull Context context, @NotNull Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            GuildAioDefaultInputContainerViewModel.this.q();
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a8\u0006\u0015"}, d2 = {"com/tencent/guild/aio/input/GuildAioDefaultInputContainerViewModel$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "onGuildInfoUpdated", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "", "expireTime", "onShutUpStateChanged", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (TextUtils.equals(g17, str)) {
                GuildAioDefaultInputContainerViewModel.this.u("onAddGuildWithInfo");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildAioDefaultInputContainerViewModel.this.u("onAdminChanged");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelInfoUpdated(@NotNull String channelUin) {
            long j3;
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            IQQGuildUtilApi iQQGuildUtilApi = (IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            IGProChannelInfo subChannel = iQQGuildUtilApi.getSubChannel(com.tencent.guild.aio.util.a.b(g16));
            if (subChannel != null) {
                j3 = subChannel.getGotoChannelId();
            } else {
                j3 = 0;
            }
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.b(g17), channelUin) || TextUtils.equals(String.valueOf(j3), channelUin)) {
                GuildAioDefaultInputContainerViewModel.this.u("onChannelInfoUpdated");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildAioDefaultInputContainerViewModel.this.u("onChannelListUpdated");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onGuildInfoUpdated(@Nullable String guildId) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildAioDefaultInputContainerViewModel.this.u("onGuildInfoUpdated");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildAioDefaultInputContainerViewModel.this.u("onShutUpStateChanged expireTime = " + expireTime);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guild/aio/input/GuildAioDefaultInputContainerViewModel$c", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements IGuildSpeakThresholdApi.a {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (!TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                return;
            }
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (channelIds.contains(com.tencent.guild.aio.util.a.b(g17))) {
                GuildAioDefaultInputContainerViewModel.this.u("onSpeakThresholdUpdate withChannel");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (guildIds.contains(com.tencent.guild.aio.util.a.g(g16))) {
                GuildAioDefaultInputContainerViewModel.this.u("onSpeakThresholdUpdate guildIds");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) GuildAioDefaultInputContainerViewModel.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildAioDefaultInputContainerViewModel.this.u("onSpeakThresholdUpdate guildId");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void q() {
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
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        } else {
            iRuntimeService = null;
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGPServiceObserver);
        }
        AppRuntime peekAppRuntime2 = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime2 instanceof AppInterface) {
            appInterface2 = (AppInterface) peekAppRuntime2;
        } else {
            appInterface2 = null;
        }
        if (appInterface2 != null) {
            iRuntimeService2 = appInterface2.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService2 = (IGPSService) iRuntimeService2;
        if (iGPSService2 != null) {
            iGPSService2.addObserver(this.mGPServiceObserver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(int height) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildInputBarHeightChangEvent(height));
    }

    private final void t() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.addObserver(this.mGPServiceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).addListener(this.mSpeakThresholdUpdateListener);
        BaseApplication context = BaseApplication.getContext();
        if (context != null && context.getContentResolver() != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(NewIntent.ACTION_LOGIN);
            intentFilter.addAction(NewIntent.ACTION_ACCOUNT_CHANGED);
            MobileQQ.sMobileQQ.registerReceiver(this.receiver, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void u(String from) {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        int a16 = fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18));
        GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(a16);
        int i3 = 2;
        String num = Integer.toString(a16, CharsKt.checkRadix(2));
        Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
        String str = "GuildAioInput.DefaultVM";
        QLog.i("GuildAioInput.DefaultVM", 1, "[handleIntent] permissions = " + num + " from:" + from);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(guildPermissionsChange);
        if (GuildSpeakLimitStatus.INSTANCE.D(a16)) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard(str, false, i3, null));
        }
    }

    private final void v() {
        AppInterface appInterface;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        IRuntimeService iRuntimeService = null;
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            iRuntimeService = appInterface.getRuntimeService(IGPSService.class, "");
        }
        IGPSService iGPSService = (IGPSService) iRuntimeService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.mGPServiceObserver);
        }
        ((IGuildSpeakThresholdApi) QRoute.api(IGuildSpeakThresholdApi.class)).removeListener(this.mSpeakThresholdUpdateListener);
        try {
            MobileQQ.sMobileQQ.unregisterReceiver(this.receiver);
        } catch (Throwable th5) {
            QLog.e("GuildAioInput.DefaultVM", 1, "unRegisterReceiver exception", th5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.j(intent);
        if (intent instanceof GuildPermissionsChange) {
            GuildPermissionsChange guildPermissionsChange = (GuildPermissionsChange) intent;
            String num = Integer.toString(guildPermissionsChange.getPermissions(), CharsKt.checkRadix(2));
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            QLog.i("GuildAioInput.DefaultVM", 1, "[handleIntentAction] GuildPermissionsChange permissions = " + num);
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildPermissionsChangeWrapperMsgIntent(guildPermissionsChange.getPermissions()));
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        return CollectionsKt.listOf(Reflection.getOrCreateKotlinClass(GuildPermissionsChange.class).getQualifiedName());
    }

    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        v();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.InputBarHeightChangeIntent) {
            r(((c.InputBarHeightChangeIntent) intent).getHeight());
            return;
        }
        if (intent instanceof c.a) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
            GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18)));
            String num = Integer.toString(guildPermissionsChange.getPermissions(), CharsKt.checkRadix(2));
            Intrinsics.checkNotNullExpressionValue(num, "toString(this, checkRadix(radix))");
            QLog.i("GuildAioInput.DefaultVM", 1, "[handleIntent] permissions = " + num);
            j(guildPermissionsChange);
        }
    }

    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        t();
        u("onCreate");
    }
}
