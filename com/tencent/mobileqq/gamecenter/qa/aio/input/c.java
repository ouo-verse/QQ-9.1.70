package com.tencent.mobileqq.gamecenter.qa.aio.input;

import android.text.TextUtils;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleFolderFunnelCollect;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import fo0.c;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u0017\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0002H\u0016R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/aio/input/c;", "Lcom/tencent/aio/base/mvvm/b;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "height", "", "l", "", "from", DomainData.DOMAIN_NAME, "Lcom/tencent/aio/api/runtime/a;", "context", "", QCircleFolderFunnelCollect.LAUNCH_TYPE_REUSE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "d", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "com/tencent/mobileqq/gamecenter/qa/aio/input/c$c", "e", "Lcom/tencent/mobileqq/gamecenter/qa/aio/input/c$c;", "mSpeakThresholdUpdateListener", "<init>", "()V", "f", "a", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class c extends com.tencent.aio.base.mvvm.b<fo0.c, InputUIState> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver = new b();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final C7645c mSpeakThresholdUpdateListener = new C7645c();

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/input/c$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "onGuildInfoUpdated", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "", "expireTime", "onShutUpStateChanged", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (TextUtils.equals(g17, str)) {
                c.this.n("onAddGuildWithInfo");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                c.this.n("onAdminChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            long j3;
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            IQQGuildUtilApi iQQGuildUtilApi = (IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class);
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            IGProChannelInfo subChannel = iQQGuildUtilApi.getSubChannel(com.tencent.guild.aio.util.a.b(g16));
            if (subChannel != null) {
                j3 = subChannel.getGotoChannelId();
            } else {
                j3 = 0;
            }
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.b(g17), channelUin) || TextUtils.equals(String.valueOf(j3), channelUin)) {
                c.this.n("onChannelInfoUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                c.this.n("onChannelListUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                c.this.n("onGuildInfoUpdated");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                c.this.n("onShutUpStateChanged expireTime = " + expireTime);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/gamecenter/qa/aio/input/c$c", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.gamecenter.qa.aio.input.c$c, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public static final class C7645c implements IGuildSpeakThresholdApi.a {
        C7645c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (!TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                return;
            }
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (channelIds.contains(com.tencent.guild.aio.util.a.b(g17))) {
                c.this.n("onSpeakThresholdUpdate withChannel");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (guildIds.contains(com.tencent.guild.aio.util.a.g(g16))) {
                c.this.n("onSpeakThresholdUpdate guildIds");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) c.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                c.this.n("onSpeakThresholdUpdate guildId");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void l(int height) {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildInputBarHeightChangEvent(height));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void n(String from) {
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        String g17 = com.tencent.guild.aio.util.a.g(g16);
        AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
        int a16 = fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18));
        GuildPermissionsChangeWrapperMsgIntent guildPermissionsChangeWrapperMsgIntent = new GuildPermissionsChangeWrapperMsgIntent(a16);
        QLog.i("GameQAAioInputContainerViewModel", 1, "[handleIntent] permissions = " + a16 + " from:" + from);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(guildPermissionsChangeWrapperMsgIntent);
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.InputBarHeightChangeIntent) {
            l(((c.InputBarHeightChangeIntent) intent).getHeight());
        }
    }

    @Override // com.tencent.aio.base.mvvm.b
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context, boolean reuse) {
        AppInterface appInterface;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context, reuse);
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
        n("onCreate");
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        AppInterface appInterface;
        super.onDestroy();
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
    }
}
