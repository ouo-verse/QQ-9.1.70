package com.tencent.mobileqq.guild.mainframe.centerpanel;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.tencent.aio.api.perf.a;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.data.AIOSession;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.guild.aio.activity.GuildChatActivityAbility;
import com.tencent.guild.aio.util.ex.ContainerType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.performance.report.GuildTelemetryTask;
import com.tencent.mobileqq.guild.performance.report.IGuildPerformanceReportApi;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.TraceUtils;
import com.tencent.mobileqq.guild.util.debug.GuildJumpDebugUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.tianjige.GuildHistogramScene;
import com.tencent.mobileqq.qqguildsdk.tianjige.IQQOpenTelemetryReportApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.PerformanceReportUtils;
import cooperation.qzone.QzoneIPCModule;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import ts.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 /2\u00020\u0001:\u0003&\u0014\tB\u0007\u00a2\u0006\u0004\b2\u00103J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0016\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012J\u001c\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0007J\u000e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018J\u0006\u0010\u001b\u001a\u00020\u0006J\u0006\u0010\u001c\u001a\u00020\u0006J\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\b\u0010\u001f\u001a\u00020\bH\u0016J \u0010$\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"J\u0006\u0010%\u001a\u00020\u0006R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010+\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010*R\u0016\u0010-\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010,R\u0013\u00101\u001a\u0004\u0018\u00010.8F\u00a2\u0006\u0006\u001a\u0004\b/\u00100\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/b;", "", "", "directMessageChat", "", "channelType", "", DomainData.DOMAIN_NAME, "", "c", "Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "o", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/b$c;", "param", "l", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/fragment/app/FragmentManager;", "childFragmentManager", "b", "Lcom/tencent/mobileqq/guild/mainframe/centerpanel/b$b;", "afterShowCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mvi/base/route/MsgIntent;", "notifyEvent", "g", "e", "k", "i", "f", "toString", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", h.F, "j", "a", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Lus/a;", "Lus/a;", "chatFragmentProvider", "I", "chatFragmentContainerId", "Landroidx/fragment/app/Fragment;", "d", "()Landroidx/fragment/app/Fragment;", "fragment", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: e, reason: collision with root package name */
    @NotNull
    private static WeakReference<us.a> f227324e = new WeakReference<>(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private FragmentManager fragmentManager;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private us.a chatFragmentProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int chatFragmentContainerId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fR*\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/b$a;", "", "Ljava/lang/ref/WeakReference;", "Lus/a;", "activateChatFragmentProvider", "Ljava/lang/ref/WeakReference;", "a", "()Ljava/lang/ref/WeakReference;", "setActivateChatFragmentProvider", "(Ljava/lang/ref/WeakReference;)V", "", "SCENE", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.centerpanel.b$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WeakReference<us.a> a() {
            return b.f227324e;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u00e6\u0080\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/b$b;", "", "Lcom/tencent/aio/data/AIOParam;", "param", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.centerpanel.b$b, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    public interface InterfaceC7825b {
        void a(@NotNull AIOParam param);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0018\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\t\u0010\fR\u0017\u0010\u0013\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0019\u001a\u0004\b\u0010\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/centerpanel/b$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "guildId", "b", "channelId", "c", "I", "()I", "channelType", "Z", "e", "()Z", "isDirectMessageChat", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "()Landroid/os/Bundle;", WadlProxyConsts.EXTRA_DATA, "<init>", "(Ljava/lang/String;Ljava/lang/String;IZLandroid/os/Bundle;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.centerpanel.b$c, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ShowParam {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String channelId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        private final int channelType;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isDirectMessageChat;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final Bundle extraData;

        public ShowParam(@NotNull String guildId, @NotNull String channelId, int i3, boolean z16, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            this.guildId = guildId;
            this.channelId = channelId;
            this.channelType = i3;
            this.isDirectMessageChat = z16;
            this.extraData = bundle;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getChannelId() {
            return this.channelId;
        }

        /* renamed from: b, reason: from getter */
        public final int getChannelType() {
            return this.channelType;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final Bundle getExtraData() {
            return this.extraData;
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getIsDirectMessageChat() {
            return this.isDirectMessageChat;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowParam)) {
                return false;
            }
            ShowParam showParam = (ShowParam) other;
            if (Intrinsics.areEqual(this.guildId, showParam.guildId) && Intrinsics.areEqual(this.channelId, showParam.channelId) && this.channelType == showParam.channelType && this.isDirectMessageChat == showParam.isDirectMessageChat && Intrinsics.areEqual(this.extraData, showParam.extraData)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = ((((this.guildId.hashCode() * 31) + this.channelId.hashCode()) * 31) + this.channelType) * 31;
            boolean z16 = this.isDirectMessageChat;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            int i16 = (hashCode2 + i3) * 31;
            Bundle bundle = this.extraData;
            if (bundle == null) {
                hashCode = 0;
            } else {
                hashCode = bundle.hashCode();
            }
            return i16 + hashCode;
        }

        @NotNull
        public String toString() {
            return "ShowParam(guildId=" + this.guildId + ", channelId=" + this.channelId + ", channelType=" + this.channelType + ", isDirectMessageChat=" + this.isDirectMessageChat + ", extraData=" + this.extraData + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/mainframe/centerpanel/b$d", "Lcom/tencent/aio/api/perf/a;", "", "time", "", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements com.tencent.aio.api.perf.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f227333a;

        d(int i3) {
            this.f227333a = i3;
        }

        @Override // com.tencent.aio.api.perf.a
        public void a(@NotNull a.b bVar) {
            a.C0622a.a(this, bVar);
        }

        @Override // com.tencent.aio.api.perf.a
        public void c(long time) {
            QLog.d("Guild.MF.Center.GuildChatFragmentUi", 1, "startUpCost: " + time);
            TraceUtils.j("enterAIO", this.f227333a);
            PerformanceReportUtils.j(BaseApplication.context, MobileQQ.sMobileQQ.peekAppRuntime().getCurrentUin(), 10014, time);
            if (time > 0) {
                ((IQQOpenTelemetryReportApi) QRoute.api(IQQOpenTelemetryReportApi.class)).reportMetricTimeCost(GuildHistogramScene.GUILD_AIO_OPEN_DURATION, null, time);
            }
            g12.b.f401087a.h(GuildHistogramScene.GUILD_AIO_ENTER_TO_ANIM_TIME_COST, "");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/mainframe/centerpanel/b$e", "Lts/e$a;", "", "attachViewTree", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements e.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AIOParam f227334d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ts.e f227335e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ InterfaceC7825b f227336f;

        e(AIOParam aIOParam, ts.e eVar, InterfaceC7825b interfaceC7825b) {
            this.f227334d = aIOParam;
            this.f227335e = eVar;
            this.f227336f = interfaceC7825b;
        }

        @Override // ts.e.a
        public void attachViewTree() {
            ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).endAioOpenTimeCostTask(com.tencent.guild.aio.util.a.g(this.f227334d), com.tencent.guild.aio.util.a.b(this.f227334d));
            this.f227335e.a(this);
            InterfaceC7825b interfaceC7825b = this.f227336f;
            if (interfaceC7825b != null) {
                interfaceC7825b.a(this.f227334d);
            }
        }
    }

    private final String c(boolean directMessageChat, int channelType) {
        if (directMessageChat) {
            return GuildTelemetryTask.DIRECT_MSG_C2C_TIME_COST.getTaskName();
        }
        if (channelType == 1000001) {
            return GuildTelemetryTask.YOLO_APP_TIME_COST.getTaskName();
        }
        return GuildTelemetryTask.OPEN_CHANNEL_AIO_TIME_COST.getTaskName();
    }

    private final String l(ShowParam param) {
        if (param.getIsDirectMessageChat()) {
            String name = com.tencent.qqguild.directmessage.aio.a.class.getName();
            Intrinsics.checkNotNullExpressionValue(name, "AioFactory::class.java.name");
            return name;
        }
        String transFactoryName = ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).transFactoryName(param.getChannelType());
        Intrinsics.checkNotNullExpressionValue(transFactoryName, "api(IGuildFeatureAdapter\u2026ryName(param.channelType)");
        return transFactoryName;
    }

    private final void n(boolean directMessageChat, int channelType) {
        String c16 = c(directMessageChat, channelType);
        if (!TextUtils.isEmpty(c16)) {
            ((IGuildPerformanceReportApi) QRoute.api(IGuildPerformanceReportApi.class)).startAioOpenTimeCostTask(c16);
        }
    }

    private final void o(Bundle extraData) {
        if (extraData.containsKey(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP)) {
            long j3 = extraData.getLong(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP);
            extraData.remove(AppConstants.Key.GUILD_GLOBAL_TOP_MSG_SEQ_ID_TO_JUMP);
            extraData.putLong("navigate_msg_seq", j3);
        }
    }

    public final void b(@NotNull ViewGroup parent, @NotNull FragmentManager childFragmentManager) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        Intrinsics.checkNotNullParameter(childFragmentManager, "childFragmentManager");
        this.chatFragmentContainerId = parent.getId();
        this.fragmentManager = childFragmentManager;
    }

    @Nullable
    public final Fragment d() {
        us.a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            return aVar.h();
        }
        return null;
    }

    public final void e() {
        Object m476constructorimpl;
        Fragment d16;
        FragmentManager parentFragmentManager;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            d16 = d();
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (d16 != null && (parentFragmentManager = d16.getParentFragmentManager()) != null) {
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "fragment?.parentFragmentManager ?: return");
            us.a aVar = this.chatFragmentProvider;
            if (aVar != null) {
                aVar.j(parentFragmentManager);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            m476constructorimpl = Result.m476constructorimpl(unit);
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("hide() fail");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.MF.Center.GuildChatFragmentUi", 1, (String) it.next(), m479exceptionOrNullimpl);
                }
            }
        }
    }

    public final boolean f() {
        Fragment h16;
        us.a aVar = this.chatFragmentProvider;
        if (aVar != null && (h16 = aVar.h()) != null) {
            return h16.isVisible();
        }
        return false;
    }

    public final void g(@NotNull MsgIntent notifyEvent) {
        Fragment h16;
        us.a aVar;
        Intrinsics.checkNotNullParameter(notifyEvent, "notifyEvent");
        us.a aVar2 = this.chatFragmentProvider;
        if (aVar2 != null && (h16 = aVar2.h()) != null && h16.isVisible() && (aVar = this.chatFragmentProvider) != null) {
            aVar.a(notifyEvent);
        }
    }

    public final void h(int requestCode, int resultCode, @Nullable Intent data) {
        us.a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            aVar.a(new GuildChatActivityAbility.ActivityResultIntent(requestCode, resultCode, data));
        }
    }

    public final boolean i() {
        us.a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            return aVar.onBackPressed();
        }
        return false;
    }

    public final void j() {
        us.a aVar = this.chatFragmentProvider;
        if (aVar != null) {
            aVar.clearAIOCache();
        }
    }

    public final void k() {
        Object m476constructorimpl;
        Fragment d16;
        FragmentManager parentFragmentManager;
        Unit unit;
        try {
            Result.Companion companion = Result.INSTANCE;
            d16 = d();
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (d16 != null && (parentFragmentManager = d16.getParentFragmentManager()) != null) {
            Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "fragment?.parentFragmentManager ?: return");
            us.a aVar = this.chatFragmentProvider;
            if (aVar != null) {
                aVar.f(parentFragmentManager);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            m476constructorimpl = Result.m476constructorimpl(unit);
            Throwable m479exceptionOrNullimpl = Result.m479exceptionOrNullimpl(m476constructorimpl);
            if (m479exceptionOrNullimpl != null) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("remove() fail");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.MF.Center.GuildChatFragmentUi", 1, (String) it.next(), m479exceptionOrNullimpl);
                }
            }
        }
    }

    @JvmOverloads
    public final void m(@NotNull ShowParam param, @Nullable InterfaceC7825b afterShowCallback) {
        boolean z16;
        boolean z17;
        Intrinsics.checkNotNullParameter(param, "param");
        int i3 = 0;
        if (param.getGuildId().length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (param.getChannelId().length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                GuildJumpDebugUtils.a("GUILD_JUMP", "GuildChatFragmentUi show() param = ", param);
                boolean isDirectMessageChat = param.getIsDirectMessageChat();
                String l3 = l(param);
                Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("AIOParam_ContainerType", ContainerType.MF_TYPE), TuplesKt.to("extra_channel_category", 1));
                if (param.getExtraData() != null) {
                    o(param.getExtraData());
                    bundleOf.putAll(param.getExtraData());
                }
                AIOParam.a a16 = new AIOParam.a().e(l3).h(new AIOSession(new AIOContact(4, param.getChannelId(), param.getGuildId(), ""))).i(true).d(0).a(bundleOf);
                String name = com.tencent.guild.aio.factory.b.class.getName();
                Intrinsics.checkNotNullExpressionValue(name, "GuildFirstScreenHelper::class.java.name");
                AIOParam c16 = a16.g(name).c();
                Integer d16 = com.tencent.guild.aio.util.a.d(c16);
                if (d16 != null) {
                    i3 = d16.intValue();
                }
                n(isDirectMessageChat, i3);
                int g16 = TraceUtils.g("enterAIO");
                GuildJumpDebugUtils.a("GUILD_JUMP", "GuildChatFragmentUi show() aioParam = ", c16);
                FragmentManager fragmentManager = this.fragmentManager;
                if (fragmentManager == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentManager");
                    fragmentManager = null;
                }
                us.a c17 = com.tencent.guild.aio.util.ex.b.c(c16, fragmentManager, this.chatFragmentContainerId, new d(g16), null, 16, null);
                ts.e g17 = c17.g();
                f227324e = new WeakReference<>(c17);
                g17.b(new e(c16, g17, afterShowCallback));
                this.chatFragmentProvider = c17;
                return;
            }
            throw new IllegalArgumentException("guildId is empty".toString());
        }
        throw new IllegalArgumentException("guildId is empty".toString());
    }

    @NotNull
    public String toString() {
        return super.toString() + " chatFragmentContainerId:" + this.chatFragmentContainerId + " " + this.chatFragmentProvider;
    }
}
