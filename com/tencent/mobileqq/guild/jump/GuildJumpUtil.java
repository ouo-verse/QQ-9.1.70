package com.tencent.mobileqq.guild.jump;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.base.extension.MiscKt;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.jump.model.BaseGuildShareParam;
import com.tencent.mobileqq.guild.jump.model.GuildShareUrlParam;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.GuildMainFrameConstants;
import com.tencent.mobileqq.guild.mainframe.api.impl.GuildMainFrameApiImpl;
import com.tencent.mobileqq.guild.mainframe.w;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.temp.api.IGuildFeatureAdapterApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.at;
import com.tencent.mobileqq.guild.util.ca;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.cx;
import com.tencent.mobileqq.guild.util.y;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qcoroutine.api.i;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0007J\"\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007JP\u0010\u0017\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007J\u001a\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u001c\u0010\u001d\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\b\u0010\u001e\u001a\u00020\u0006H\u0002J\u001a\u0010!\u001a\u00020 2\u0006\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u001f\u001a\u00020\u000bH\u0007J\u001a\u0010\"\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J>\u0010%\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0007J>\u0010&\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#H\u0007J\u0010\u0010(\u001a\u00020'2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J8\u0010)\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010$\u001a\u0004\u0018\u00010#H\u0002J\u001a\u0010*\u001a\u00020 2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002J\u001a\u0010+\u001a\u00020 2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\bH\u0002\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/guild/jump/GuildJumpUtil;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "param", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/jump/model/BaseGuildShareParam;", "originalParam", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "url", "Landroid/os/Bundle;", "bundle", "i", "guildId", "channelId", "joinSignature", "mainSource", "subSource", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "appReportSourceInfo", "k", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "w", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "source", "", "f", "v", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$ChannelDetailPageJumpInfo;", "jumpInfo", "t", "y", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "d", "e", "g", tl.h.F, "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildJumpUtil {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildJumpUtil f226378a = new GuildJumpUtil();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/jump/GuildJumpUtil$a", "Lcom/tencent/mobileqq/guild/mainframe/w;", "", "onSuccess", "", "code", "", "msg", "onFailed", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f226379a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Bundle f226380b;

        a(Context context, Bundle bundle) {
            this.f226379a = context;
            this.f226380b = bundle;
        }

        @Override // com.tencent.mobileqq.guild.mainframe.w
        public void onFailed(int code, @NotNull String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str = "jumpGuildTabDiscoverPage requestOpenGuildTab error " + code + " " + msg2;
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it.next(), null);
            }
        }

        @Override // com.tencent.mobileqq.guild.mainframe.w
        public void onSuccess() {
            Logger.f235387a.d().d("Guild.jump.GuildJumpUtil", 1, "jumpGuildTabDiscoverPage requestOpenGuildTab success");
            GuildJumpUtil.f226378a.x(this.f226379a, this.f226380b);
        }
    }

    GuildJumpUtil() {
    }

    private final void A() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.jump.i
            @Override // java.lang.Runnable
            public final void run() {
                GuildJumpUtil.B();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B() {
        com.tencent.mobileqq.guild.util.qqui.g.c(1, R.string.f147320wk);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IPerformanceReportTask d(JumpGuildParam param) {
        IPerformanceReportTask stageCode = Reporters.f231995a.b().newReportTask().setEventCode("guild_jump").setStageCode("stage_start");
        String str = param.guildId;
        Intrinsics.checkNotNullExpressionValue(str, "param.guildId");
        return stageCode.setParam("guild_id", str).setExtra("isGuest", Boolean.valueOf(ch.j0(param.guildId))).setExtra("guildNum", param.guildNumber).setExtra("isInternal", Boolean.TRUE);
    }

    private final void e(Context context, String guildId, String channelId, GuildAppReportSourceInfo appReportSourceInfo, JumpGuildParam.ChannelDetailPageJumpInfo jumpInfo) {
        if (context == null) {
            context = QBaseActivity.sTopActivity;
        }
        if (context == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("doJump isJumpFeedsHome context == null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it.next(), null);
            }
            return;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, channelId);
        jumpGuildParam.setReportSourceInfo(appReportSourceInfo);
        jumpGuildParam.setDetailPageJumpInfo(jumpInfo);
        n(context, jumpGuildParam);
    }

    @JvmStatic
    public static final boolean f(@NotNull String guildId, @NotNull String source) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(source, "source");
        long l3 = MiscKt.l(guildId);
        r rVar = r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        return ((IGPSService) S0).isQQMsgListGuild(l3);
    }

    private final boolean g(Context context, BaseGuildShareParam originalParam) {
        if (!ch.s0()) {
            y.g(com.tencent.mobileqq.guild.ipc.methods.w.class, originalParam);
            return false;
        }
        if (context == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("context is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it.next(), null);
            }
            return false;
        }
        if (h(context, originalParam)) {
            return false;
        }
        if (at.c()) {
            return true;
        }
        Logger logger2 = Logger.f235387a;
        Logger.b bVar2 = new Logger.b();
        bVar2.a().add("sdk is not ready");
        Iterator<T> it5 = bVar2.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it5.next(), null);
        }
        return false;
    }

    private final boolean h(Context context, BaseGuildShareParam originalParam) {
        if (!((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).isSplashActivityAlive()) {
            Logger.f235387a.d().d("Guild.jump.GuildJumpUtil", 1, "checkSplashInvalid restart splash originalParam: " + originalParam);
            ((IGuildFeatureAdapterApi) QRoute.api(IGuildFeatureAdapterApi.class)).launchSplashAndProcessShareJump(context, originalParam);
            return true;
        }
        return false;
    }

    @JvmStatic
    public static final void i(@Nullable Context context, @NotNull String url, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        Logger.f235387a.d().d("Guild.jump.GuildJumpUtil", 1, "addGuildByShareUrl url:" + url + " bundle" + bundle);
        GuildShareUrlParam guildShareUrlParam = new GuildShareUrlParam(url);
        guildShareUrlParam.a().putAll(bundle);
        m(context, guildShareUrlParam);
    }

    @Deprecated(message = "\u6539\u4e3a\u4f7f\u7528 jumpGuildOnFullStandalone \u8df3\u8f6c")
    @JvmStatic
    @JvmOverloads
    public static final void j(@Nullable Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String joinSignature, @NotNull String mainSource, @NotNull String subSource) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(joinSignature, "joinSignature");
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        l(context, guildId, channelId, joinSignature, mainSource, subSource, null, null, 192, null);
    }

    @Deprecated(message = "\u6539\u4e3a\u4f7f\u7528 jumpGuildOnFullStandalone \u8df3\u8f6c")
    @JvmStatic
    @JvmOverloads
    public static final void k(@Nullable Context context, @NotNull String guildId, @NotNull String channelId, @NotNull String joinSignature, @NotNull String mainSource, @NotNull String subSource, @Nullable GuildAppReportSourceInfo appReportSourceInfo, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(joinSignature, "joinSignature");
        Intrinsics.checkNotNullParameter(mainSource, "mainSource");
        Intrinsics.checkNotNullParameter(subSource, "subSource");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (context == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("jumpGuildBySignature context is null");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it.next(), null);
            }
            return;
        }
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, channelId);
        jumpGuildParam.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(joinSignature, mainSource, subSource));
        jumpGuildParam.extras.putAll(bundle);
        n(context, jumpGuildParam);
    }

    public static /* synthetic */ void l(Context context, String str, String str2, String str3, String str4, String str5, GuildAppReportSourceInfo guildAppReportSourceInfo, Bundle bundle, int i3, Object obj) {
        GuildAppReportSourceInfo guildAppReportSourceInfo2;
        Bundle bundle2;
        if ((i3 & 64) != 0) {
            guildAppReportSourceInfo2 = null;
        } else {
            guildAppReportSourceInfo2 = guildAppReportSourceInfo;
        }
        if ((i3 & 128) != 0) {
            bundle2 = new Bundle();
        } else {
            bundle2 = bundle;
        }
        k(context, str, str2, str3, str4, str5, guildAppReportSourceInfo2, bundle2);
    }

    @JvmStatic
    public static final void m(@Nullable Context context, @NotNull BaseGuildShareParam originalParam) {
        Intrinsics.checkNotNullParameter(originalParam, "originalParam");
        if (!f226378a.g(context, originalParam)) {
            return;
        }
        if (context != null) {
            CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
            if (f16 != null) {
                CorountineFunKt.e(f16, "Guild.jump.GuildJumpUtil", null, null, null, new GuildJumpUtil$jumpGuildByUrlOrCode$1(context, originalParam, null), 14, null);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @JvmStatic
    public static final void n(@NotNull Context context, @NotNull JumpGuildParam param) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(param, "param");
        CoroutineScope f16 = com.tencent.mobileqq.qcoroutine.framework.impl.a.f261834a.f(i.e.f261783e);
        if (f16 != null) {
            CorountineFunKt.e(f16, "Guild.jump.GuildJumpUtil", null, null, null, new GuildJumpUtil$jumpGuildOnFullStandalone$1(param, context, null), 14, null);
        }
    }

    @JvmStatic
    public static final void o(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (ca.a()) {
            f226378a.x(context, bundle);
        } else {
            zr1.d.f("share", new a(context, bundle));
        }
    }

    public static /* synthetic */ void p(Context context, Bundle bundle, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            bundle = new Bundle();
        }
        o(context, bundle);
    }

    @JvmStatic
    public static final void q(@NotNull Context context, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        if (!ca.a()) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("jumpGuildTabFeaturedGuild without guildTab");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it.next(), null);
            }
            return;
        }
        f226378a.x(context, bundle);
    }

    @Deprecated(message = "\u65b0\u7248\u672c\u5168\u90e8\u4ee5\u72ec\u7acb\u9875\u6253\u5f00\u9891\u9053\u573a\u666f\uff0c\u4e0d\u518d\u6709\u8df3\u8f6c\u9891\u9053tab\u6253\u5f00\u4e86")
    @JvmStatic
    @JvmOverloads
    public static final void r(@Nullable Context context, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        u(context, guildId, null, null, null, 28, null);
    }

    @Deprecated(message = "\u65b0\u7248\u672c\u5168\u90e8\u4ee5\u72ec\u7acb\u9875\u6253\u5f00\u9891\u9053\u573a\u666f\uff0c\u4e0d\u518d\u6709\u8df3\u8f6c\u9891\u9053tab\u6253\u5f00\u4e86")
    @JvmStatic
    @JvmOverloads
    public static final void s(@Nullable Context context, @NotNull String guildId, @Nullable String str, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        u(context, guildId, str, guildAppReportSourceInfo, null, 16, null);
    }

    @Deprecated(message = "\u65b0\u7248\u672c\u5168\u90e8\u4ee5\u72ec\u7acb\u9875\u6253\u5f00\u9891\u9053\u573a\u666f\uff0c\u4e0d\u518d\u6709\u8df3\u8f6c\u9891\u9053tab\u6253\u5f00\u4e86")
    @JvmStatic
    @JvmOverloads
    public static final void t(@Nullable Context context, @NotNull String guildId, @Nullable String channelId, @Nullable GuildAppReportSourceInfo appReportSourceInfo, @Nullable JumpGuildParam.ChannelDetailPageJumpInfo jumpInfo) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        f226378a.e(context, guildId, channelId, appReportSourceInfo, jumpInfo);
    }

    public static /* synthetic */ void u(Context context, String str, String str2, GuildAppReportSourceInfo guildAppReportSourceInfo, JumpGuildParam.ChannelDetailPageJumpInfo channelDetailPageJumpInfo, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        if ((i3 & 8) != 0) {
            guildAppReportSourceInfo = null;
        }
        if ((i3 & 16) != 0) {
            channelDetailPageJumpInfo = null;
        }
        t(context, str, str2, guildAppReportSourceInfo, channelDetailPageJumpInfo);
    }

    @JvmStatic
    public static final void v(@NotNull Context context, @Nullable String url) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("fail to openNormalUrl, url is empty");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().i("Guild.jump.GuildJumpUtil", 1, "openNormalUrl " + url);
        cx.a(context, url);
    }

    @JvmStatic
    public static final void w(@Nullable Activity activity, @Nullable String url) {
        boolean z16;
        BaseQQAppInterface baseQQAppInterface;
        if (url != null && url.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("fail to openUrlOrSchema, url is empty");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it.next(), null);
            }
            return;
        }
        AppInterface l3 = ch.l();
        if (l3 instanceof BaseQQAppInterface) {
            baseQQAppInterface = (BaseQQAppInterface) l3;
        } else {
            baseQQAppInterface = null;
        }
        if (baseQQAppInterface == null) {
            Logger logger2 = Logger.f235387a;
            Logger.b bVar2 = new Logger.b();
            bVar2.a().add("fail to openUrlOrSchema, app is null");
            Iterator<T> it5 = bVar2.a().iterator();
            while (it5.hasNext()) {
                Logger.f235387a.d().e("Guild.jump.GuildJumpUtil", 1, (String) it5.next(), null);
            }
            return;
        }
        ax c16 = bi.c(baseQQAppInterface, baseQQAppInterface.getApplicationContext(), url);
        if (c16 != null) {
            boolean b16 = c16.b();
            if (!b16) {
                f226378a.A();
            }
            Logger.f235387a.d().i("Guild.jump.GuildJumpUtil", 1, "open schema " + url + MsgSummary.STR_COLON + b16);
            return;
        }
        Logger.f235387a.d().i("Guild.jump.GuildJumpUtil", 1, "open url:" + url);
        IGuildTempApi iGuildTempApi = (IGuildTempApi) QRoute.api(IGuildTempApi.class);
        if (activity == null) {
            activity = QBaseActivity.sTopActivity;
        }
        iGuildTempApi.openGuildByShareUrl(activity, url, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(Context context, Bundle bundle) {
        Logger.f235387a.d().d("Guild.jump.GuildJumpUtil", 1, "realOpenDiscoverPage " + bundle);
        Boolean bool = Boolean.FALSE;
        Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("BUNDLE_KEY_IS_AIO", bool), TuplesKt.to("BUNDLE_KEY_NEED_OPEN_CENTER_PANEL", bool), TuplesKt.to("BUNDLE_KEY_TARGET_ITEM_TYPE", 2), TuplesKt.to("BUNDLE_KEY_TARGET_ITEM_KEY", ""));
        bundleOf.putAll(bundle);
        new GuildMainFrameApiImpl().gotoGuildTab(context, GuildMainFrameConstants.f227282z, bundleOf);
    }

    @Deprecated(message = "\u65b0\u7248\u672c\u76f4\u63a5\u8df3\u8f6c\uff0c\u4e0d\u518d\u548ctab\u76f8\u5173")
    @JvmStatic
    @JvmOverloads
    public static final void y(@Nullable Context context, @NotNull String guildId, @Nullable String channelId, @Nullable GuildAppReportSourceInfo appReportSourceInfo, @Nullable JumpGuildParam.ChannelDetailPageJumpInfo jumpInfo) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        f226378a.e(context, guildId, channelId, appReportSourceInfo, jumpInfo);
    }

    public static /* synthetic */ void z(Context context, String str, String str2, GuildAppReportSourceInfo guildAppReportSourceInfo, JumpGuildParam.ChannelDetailPageJumpInfo channelDetailPageJumpInfo, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = null;
        }
        if ((i3 & 8) != 0) {
            guildAppReportSourceInfo = null;
        }
        if ((i3 & 16) != 0) {
            channelDetailPageJumpInfo = null;
        }
        y(context, str, str2, guildAppReportSourceInfo, channelDetailPageJumpInfo);
    }
}
