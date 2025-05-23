package com.tencent.guildmedia.aio.input;

import android.text.TextUtils;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.aio.base.route.msg.PanelMsg;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildPermissionsChange;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guildmedia.utils.GuildMediaLogUtil;
import com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi;
import com.tencent.mobileqq.guild.util.speaklimitstatus.GuildSpeakLimitStatus;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import fo0.c;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001\u001c\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0007\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0006H\u0002J\b\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\r\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0006H\u0016J\u0010\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0002H\u0016R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/guildmedia/aio/input/b;", "Lpn0/a;", "Lfo0/c;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "", "permissions", "", "r", "", "from", "u", ReportConstant.COSTREPORT_PREFIX, "t", "v", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "intent", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "f", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "mGPServiceObserver", "com/tencent/guildmedia/aio/input/b$c", tl.h.F, "Lcom/tencent/guildmedia/aio/input/b$c;", "mSpeakThresholdUpdateListener", "<init>", "()V", "i", "a", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class b extends pn0.a<fo0.c, InputUIState> {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GPServiceObserver mGPServiceObserver = new C1233b();

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c mSpeakThresholdUpdateListener = new c();

    /* compiled from: P */
    @Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\u0012\u0010\t\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0014J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\u0011\u001a\u00020\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0014J\u001a\u0010\u0014\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0014\u00a8\u0006\u0015"}, d2 = {"com/tencent/guildmedia/aio/input/b$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "guildId", "admint", "", "bAdmin", "", "onAdminChanged", "onGuildInfoUpdated", "channelUin", "onChannelInfoUpdated", "onChannelListUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "", "expireTime", "onShutUpStateChanged", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.guildmedia.aio.input.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C1233b extends GPServiceObserver {
        C1233b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (TextUtils.equals(g17, str)) {
                b.this.u("onAddGuildWithInfo");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAdminChanged(@NotNull String guildId, @NotNull String admint, boolean bAdmin) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(admint, "admint");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                b.this.u("onAdminChanged");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.b(g16), channelUin)) {
                b.this.u("onChannelInfoUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelListUpdated(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                b.this.u("onChannelListUpdated");
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                b.this.u("onGuildInfoUpdated");
                b.this.s();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        protected void onShutUpStateChanged(@Nullable String guildId, long expireTime) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputContainerVM", "[onShutUpStateChanged]  expireTime = " + expireTime);
                b.this.u("onShutUpStateChanged");
                b.this.s();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0016\u0010\b\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H\u0016J\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/guildmedia/aio/input/b$c", "Lcom/tencent/mobileqq/guild/api/IGuildSpeakThresholdApi$a;", "", "guildId", "", "M", "", "guildIds", "G", "Ljava/util/HashSet;", "channelIds", "E", "aio-guild-media_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class c implements IGuildSpeakThresholdApi.a {
        c() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void E(@NotNull String guildId, @NotNull HashSet<String> channelIds) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelIds, "channelIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (!TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                return;
            }
            AIOParam g17 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
            if (channelIds.contains(com.tencent.guild.aio.util.a.b(g17))) {
                b.this.u("onSpeakThresholdUpdate withChannel");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void G(@NotNull List<String> guildIds) {
            Intrinsics.checkNotNullParameter(guildIds, "guildIds");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (guildIds.contains(com.tencent.guild.aio.util.a.g(g16))) {
                b.this.u("onSpeakThresholdUpdate guildIds");
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.guild.api.IGuildSpeakThresholdApi.a
        public void M(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) b.this.getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            if (TextUtils.equals(com.tencent.guild.aio.util.a.g(g16), guildId)) {
                b.this.u("onSpeakThresholdUpdate guildId");
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(int permissions) {
        int i3;
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputContainerVM", "[handlePermissionsChange] permissions = " + permissions);
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
        if (companion.x(permissions, com.tencent.guild.aio.util.a.g(g16)) && companion.A(permissions)) {
            i3 = (1 << GuildSpeakLimitStatus.CHANNEL_READ_ONLY_LIVE_ANCHOR_MUTE.getLimitStatus()) | permissions;
        } else {
            i3 = permissions;
        }
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildPermissionsChangeWrapperMsgIntent(i3));
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        Intrinsics.checkNotNullExpressionValue(g17, "mContext.aioParam");
        if (!companion.g(permissions, com.tencent.guild.aio.util.a.g(g17))) {
            s();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void s() {
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new PanelMsg.HideAllPanelAndKeyboard("GuildMediaAioInputContainerVM", false, 2, null));
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
        GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputContainerVM", "[senGuildPermissionChangeIntent] permissions = " + a16 + " from:" + from);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().h(guildPermissionsChange);
        GuildSpeakLimitStatus.Companion companion = GuildSpeakLimitStatus.INSTANCE;
        if (companion.D(a16) || companion.H(a16)) {
            s();
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
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof GuildPermissionsChange) {
            r(((GuildPermissionsChange) intent).getPermissions());
        }
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildPermissionsChange.class).getQualifiedName());
        return listOf;
    }

    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        super.onDestroy();
        v();
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull fo0.c intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof c.InputBarHeightChangeIntent) {
            ((com.tencent.aio.api.runtime.a) getMContext()).e().h(new GuildMsgListIntent.GuildInputBarHeightChangEvent(((c.InputBarHeightChangeIntent) intent).getHeight()));
            return;
        }
        if (intent instanceof c.a) {
            AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g16, "mContext.aioParam");
            String g17 = com.tencent.guild.aio.util.a.g(g16);
            AIOParam g18 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
            Intrinsics.checkNotNullExpressionValue(g18, "mContext.aioParam");
            GuildPermissionsChange guildPermissionsChange = new GuildPermissionsChange(fo0.h.a(g17, com.tencent.guild.aio.util.a.b(g18)));
            GuildMediaLogUtil.INSTANCE.c("GuildMediaAioInputContainerVM", "[handleIntent] permissions = " + guildPermissionsChange.getPermissions());
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
