package com.tencent.guild.aio.input.onlinemember;

import android.content.Context;
import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.tencent.aio.data.AIOParam;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.guild.aio.factory.business.holder.msglist.GuildMsgListIntent;
import com.tencent.guild.aio.input.GuildAioDefaultInputUIState;
import com.tencent.guild.aio.input.GuildPermissionsChangeWrapperMsgIntent;
import com.tencent.guild.aio.util.ex.FromScene;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import op0.a;
import org.jetbrains.annotations.NotNull;
import pn0.a;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\b\t*\u0001\u001b\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0018\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0002J \u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0002J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0007J\b\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0016H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0005H\u0016J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/guild/aio/input/onlinemember/GuildAioInputLoopAvatarViewModel;", "Lpn0/a;", "Lop0/a;", "Lcom/tencent/guild/aio/input/GuildAioDefaultInputUIState;", "Landroidx/lifecycle/LifecycleObserver;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "E", "", "channelId", "", "channelType", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "guildId", "feedId", "r", "Lcom/tencent/aio/api/runtime/a;", "context", "onCreate", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "intent", "j", "p", "com/tencent/guild/aio/input/onlinemember/GuildAioInputLoopAvatarViewModel$b", "f", "Lcom/tencent/guild/aio/input/onlinemember/GuildAioInputLoopAvatarViewModel$b;", "mAction", "<init>", "()V", h.F, "a", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes6.dex */
public final class GuildAioInputLoopAvatarViewModel extends a<op0.a, GuildAioDefaultInputUIState> implements LifecycleObserver {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b mAction = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/guild/aio/input/onlinemember/GuildAioInputLoopAvatarViewModel$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "aio-guild_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes6.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(@NotNull MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            GuildAioInputLoopAvatarViewModel.this.E(i3);
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return a.C9235a.a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E(MsgIntent i3) {
        if (i3 instanceof GuildMsgListIntent.GuildInputBarHeightChangEvent) {
            updateUI(new GuildAioDefaultInputUIState.NavButtonPaddingBottom(((GuildMsgListIntent.GuildInputBarHeightChangEvent) i3).getHeight()));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void q(String channelId, int channelType) {
        AppRuntime peekAppRuntime;
        String str;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        GuildAppReportSourceInfo guildAppReportSourceInfo;
        String str2;
        AIOParam g16;
        AIOParam g17;
        AIOParam g18;
        Bundle l3;
        AIOParam g19;
        Bundle l16;
        AIOParam g26;
        if (getMContext() == 0 || ((com.tencent.aio.api.runtime.a) getMContext()).c() == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IGPSService iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
        com.tencent.aio.api.runtime.a aVar = (com.tencent.aio.api.runtime.a) getMContext();
        String str3 = null;
        if (aVar != null && (g26 = aVar.g()) != null) {
            str = com.tencent.guild.aio.util.a.g(g26);
        } else {
            str = null;
        }
        boolean isGuest = iGPSService.isGuest(str);
        com.tencent.aio.api.runtime.a aVar2 = (com.tencent.aio.api.runtime.a) getMContext();
        if (aVar2 != null && (g19 = aVar2.g()) != null && (l16 = g19.l()) != null) {
            joinInfoParam = (JumpGuildParam.JoinInfoParam) l16.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        } else {
            joinInfoParam = null;
        }
        com.tencent.aio.api.runtime.a aVar3 = (com.tencent.aio.api.runtime.a) getMContext();
        if (aVar3 != null && (g18 = aVar3.g()) != null && (l3 = g18.l()) != null) {
            guildAppReportSourceInfo = (GuildAppReportSourceInfo) l3.getParcelable("GuildAppReportSourceInfo");
        } else {
            guildAppReportSourceInfo = null;
        }
        if (isGuest && (joinInfoParam == null || guildAppReportSourceInfo == null)) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getContext(), "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("joinGuildParams or appReportParas is null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildAioInputLoopAvatarViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        com.tencent.aio.api.runtime.a aVar4 = (com.tencent.aio.api.runtime.a) getMContext();
        if (aVar4 != null && (g17 = aVar4.g()) != null) {
            str2 = com.tencent.guild.aio.util.a.b(g17);
        } else {
            str2 = null;
        }
        com.tencent.aio.api.runtime.a aVar5 = (com.tencent.aio.api.runtime.a) getMContext();
        if (aVar5 != null && (g16 = aVar5.g()) != null) {
            str3 = com.tencent.guild.aio.util.a.g(g16);
        }
        iGuildTempApi.openChannelInChannel(context, str2, str3, channelId, channelType, joinInfoParam, guildAppReportSourceInfo, 11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r(String guildId, String channelId, String feedId) {
        AppRuntime peekAppRuntime;
        String str;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        Bundle l3;
        if (((com.tencent.aio.api.runtime.a) getMContext()).c() == null || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null) {
            return;
        }
        IGPSService iGPSService = (IGPSService) peekAppRuntime.getRuntimeService(IGPSService.class, "");
        AIOParam g16 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        if (g16 != null) {
            str = com.tencent.guild.aio.util.a.g(g16);
        } else {
            str = null;
        }
        boolean isGuest = iGPSService.isGuest(str);
        AIOParam g17 = ((com.tencent.aio.api.runtime.a) getMContext()).g();
        if (g17 != null && (l3 = g17.l()) != null) {
            joinInfoParam = (JumpGuildParam.JoinInfoParam) l3.getParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM);
        } else {
            joinInfoParam = null;
        }
        if (isGuest && joinInfoParam == null) {
            QQToast.makeText(((com.tencent.aio.api.runtime.a) getMContext()).c().getContext(), "\u8df3\u8f6c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("joinGuildParams or appReportParas is null!");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildAioInputLoopAvatarViewModel", 1, (String) it.next(), null);
            }
            return;
        }
        QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) api;
        Context context = ((com.tencent.aio.api.runtime.a) getMContext()).c().getContext();
        Bundle bundle = new Bundle();
        bundle.putString("guildId", guildId);
        bundle.putString("channelId", channelId);
        bundle.putString("feedId", feedId);
        String account = peekAppRuntime.getAccount();
        if (account == null) {
            account = "null";
        } else {
            Intrinsics.checkNotNullExpressionValue(account, "app.account ?: \"null\"");
        }
        bundle.putString("visitorTinyId", account);
        bundle.putParcelable("joinInfoParam", joinInfoParam);
        Unit unit = Unit.INSTANCE;
        IGuildFeedLauncherApi.a.a(iGuildFeedLauncherApi, context, bundle, false, 4, null);
    }

    @Override // pn0.a
    public void j(@NotNull MsgIntent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
    }

    @Override // pn0.a
    @NotNull
    public List<String> m() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Reflection.getOrCreateKotlinClass(GuildPermissionsChangeWrapperMsgIntent.class).getQualifiedName());
        return listOf;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onDestroy() {
        updateUI(new GuildAioDefaultInputUIState.OnDestroy());
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().removeObserver(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().b(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), this.mAction);
        super.onDestroy();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        updateUI(new GuildAioDefaultInputUIState.OnResume());
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull op0.a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C10934a) {
            Logger.f235387a.d().i("GuildAioInputLoopAvatarViewModel", 1, "GuildAioInputOnlineMviIntent.JumpChannel:");
            a.C10934a c10934a = (a.C10934a) intent;
            q(c10934a.getChannelId(), c10934a.getChannelType());
        } else if (intent instanceof a.b) {
            Logger.f235387a.d().i("GuildAioInputLoopAvatarViewModel", 1, "GuildAioInputOnlineMviIntent.JumpFeedDetail:");
            a.b bVar = (a.b) intent;
            r(bVar.getGuildId(), bVar.getChannelId(), bVar.getFeedId());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // pn0.a, com.tencent.aio.base.mvvm.b, com.tencent.mvi.mvvm.framework.FrameworkVM
    public void onCreate(@NotNull com.tencent.aio.api.runtime.a context) {
        long j3;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onCreate(context);
        ((com.tencent.aio.api.runtime.a) getMContext()).d().getLifecycle().addObserver(this);
        ((com.tencent.aio.api.runtime.a) getMContext()).e().d(Reflection.getOrCreateKotlinClass(GuildMsgListIntent.GuildInputBarHeightChangEvent.class).getQualifiedName(), this.mAction);
        int i3 = context.g().l().getInt("AIOParam_FromScene", FromScene.DEFAULT.ordinal());
        try {
            AIOParam g16 = context.g();
            Intrinsics.checkNotNullExpressionValue(g16, "context.aioParam");
            j3 = Long.parseLong(com.tencent.guild.aio.util.a.b(g16));
        } catch (Exception unused) {
            updateUI(new GuildAioDefaultInputUIState.HideGuildOnlineMember());
            j3 = 0;
        }
        if (i3 == FromScene.DEFAULT.ordinal()) {
            AIOParam g17 = context.g();
            Intrinsics.checkNotNullExpressionValue(g17, "context.aioParam");
            updateUI(new GuildAioDefaultInputUIState.GuildOnlineMemberUpdateLoop(com.tencent.guild.aio.util.a.g(g17), j3));
            return;
        }
        updateUI(new GuildAioDefaultInputUIState.HideGuildOnlineMember());
    }
}
