package com.tencent.mobileqq.guild.channel.frame.titlebar;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.guildlive.api.IGuildAioMultiSelectStateApi;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IQQGuildAvatarApi;
import com.tencent.mobileqq.guild.channel.frame.unread.GuildChannelUnreadCountManager;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.config.r;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildAIOTitleBar;
import com.tencent.mobileqq.guild.widget.GuildStateType;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.dt;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh2.bt;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001_\u0018\u0000 \u00042\u00020\u0001:\u0001.B'\u0012\u0006\u00103\u001a\u00020/\u0012\u0006\u0010:\u001a\u00020 \u0012\u0006\u0010>\u001a\u00020 \u0012\u0006\u0010E\u001a\u00020#\u00a2\u0006\u0004\bf\u0010gJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u000e\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u0006\u0010\u001d\u001a\u00020\u0002J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u001e\u0010%\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020 2\u0006\u0010$\u001a\u00020#J\u000e\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0011J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0011J\u0006\u0010)\u001a\u00020\u0002J\u000e\u0010,\u001a\u00020\u00022\u0006\u0010+\u001a\u00020*J\u0006\u0010-\u001a\u00020\u0002J\b\u0010.\u001a\u00020\u0002H\u0016R\u0017\u00103\u001a\u00020/8\u0006\u00a2\u0006\f\n\u0004\b.\u00100\u001a\u0004\b1\u00102R\"\u0010:\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b4\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010>\u001a\u00020 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u00105\u001a\u0004\b<\u00107\"\u0004\b=\u00109R\"\u0010E\u001a\u00020#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010M\u001a\u0004\u0018\u00010J8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010P\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0018\u0010R\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010QR\u0016\u0010T\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010SR\u0016\u0010U\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u0010SR#\u0010[\u001a\n W*\u0004\u0018\u00010V0V8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010X\u001a\u0004\bY\u0010ZR\u0018\u0010^\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010]R\u0014\u0010b\u001a\u00020_8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0014\u0010e\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010d\u00a8\u0006h"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager;", "Lcom/tencent/mobileqq/guild/channel/frame/unread/a;", "", DomainData.DOMAIN_NAME, "o", HippyTKDListViewAdapter.X, h.F, "w", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProChannelInfo;", "channelInfo", "I", "K", "G", "H", "J", "", "p", "Lcom/tencent/mobileqq/guild/config/r;", "guildStateIconInfo", "Lcom/tencent/mobileqq/guild/widget/GuildStateType;", "k", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "view", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/g;", "processor", "y", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "r", "v", "", "updateGuildId", "updateChannelId", "Landroid/os/Bundle;", "updateParams", BdhLogUtil.LogTag.Tag_Conn, "needUpdate", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, ReportConstant.COSTREPORT_PREFIX, "t", "a", "Landroid/content/Context;", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "c", "i", "setChannelId", "channelId", "d", "Landroid/os/Bundle;", "getChannelParams", "()Landroid/os/Bundle;", "setChannelParams", "(Landroid/os/Bundle;)V", "channelParams", "Luf1/a;", "e", "Luf1/a;", "loadProxyManager", "Lcom/tencent/mobileqq/guild/channel/frame/unread/GuildChannelUnreadCountManager;", "f", "Lcom/tencent/mobileqq/guild/channel/frame/unread/GuildChannelUnreadCountManager;", "unreadCountManager", "g", "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/g;", "channelProcessor", "Lcom/tencent/mobileqq/guild/widget/GuildAIOTitleBar;", "titleBarView", "Z", "needUpdateChannelName", "needUpdateChannelIcon", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "kotlin.jvm.PlatformType", "Lkotlin/Lazy;", "l", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "iGPSService", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "postSubscribeAction", "com/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager$b;", "observer", "Lvh2/bt;", "Lvh2/bt;", "guildStateListener", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelTitleBarManager implements com.tencent.mobileqq.guild.channel.frame.unread.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bundle channelParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private uf1.a loadProxyManager;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildChannelUnreadCountManager unreadCountManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private g channelProcessor;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAIOTitleBar titleBarView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateChannelName;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean needUpdateChannelIcon;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy iGPSService;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Runnable postSubscribeAction;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b observer;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final bt guildStateListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014J\u001a\u0010\f\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/channel/frame/titlebar/GuildChannelTitleBarManager$b", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "guildId", "onGuildInfoUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b extends GPServiceObserver {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (TextUtils.equals(str, GuildChannelTitleBarManager.this.getGuildId())) {
                GuildChannelTitleBarManager.this.D();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@Nullable String channelUin) {
            if (TextUtils.equals(channelUin, GuildChannelTitleBarManager.this.getChannelId())) {
                GuildChannelTitleBarManager.this.D();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildInfoUpdated(@Nullable String guildId) {
            if (TextUtils.equals(guildId, GuildChannelTitleBarManager.this.getGuildId())) {
                GuildChannelTitleBarManager.this.D();
            }
        }
    }

    public GuildChannelTitleBarManager(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull Bundle channelParams) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(channelParams, "channelParams");
        this.context = context;
        this.guildId = guildId;
        this.channelId = channelId;
        this.channelParams = channelParams;
        this.needUpdateChannelName = true;
        this.needUpdateChannelIcon = true;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IGPSService>() { // from class: com.tencent.mobileqq.guild.channel.frame.titlebar.GuildChannelTitleBarManager$iGPSService$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final IGPSService invoke() {
                return (IGPSService) ch.R0(IGPSService.class);
            }
        });
        this.iGPSService = lazy;
        this.observer = new b();
        this.guildStateListener = new bt() { // from class: com.tencent.mobileqq.guild.channel.frame.titlebar.b
            @Override // vh2.bt
            public final void a(dt dtVar) {
                GuildChannelTitleBarManager.m(GuildChannelTitleBarManager.this, dtVar);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final GuildChannelTitleBarManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final IGProGuildInfo M = ch.M(this$0.guildId);
        final IGProChannelInfo C = ch.C(ch.m(), this$0.guildId, this$0.channelId);
        if (M != null && C != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.frame.titlebar.d
                @Override // java.lang.Runnable
                public final void run() {
                    GuildChannelTitleBarManager.F(GuildChannelTitleBarManager.this, M, C);
                }
            });
        } else {
            QLog.d("GuildChannelTitleBarManager", 1, "updateChannelTitle: error! guild Info or channel info is null");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GuildChannelTitleBarManager this$0, IGProGuildInfo guildInfo, IGProChannelInfo iGProChannelInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(guildInfo, "guildInfo");
        this$0.K(guildInfo, iGProChannelInfo);
        this$0.G(guildInfo, iGProChannelInfo);
        this$0.H(guildInfo, iGProChannelInfo);
        this$0.J(guildInfo, iGProChannelInfo);
        this$0.I(guildInfo, iGProChannelInfo);
        g gVar = this$0.channelProcessor;
        if (gVar != null) {
            gVar.H5(guildInfo, iGProChannelInfo);
        }
    }

    private final void G(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        if (this.needUpdateChannelName && ch.M(this.guildId) != null) {
            String channelName = channelInfo.getChannelName();
            GuildAIOTitleBar guildAIOTitleBar = this.titleBarView;
            if (guildAIOTitleBar != null) {
                Intrinsics.checkNotNullExpressionValue(channelName, "channelName");
                guildAIOTitleBar.setChannelName(channelName);
            }
        }
    }

    private final void I(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        boolean z16;
        boolean isVisibleForVisitor = guildInfo.isVisibleForVisitor();
        boolean j06 = ch.j0(this.guildId);
        boolean isMultiSelect = ((IGuildAioMultiSelectStateApi) QRoute.api(IGuildAioMultiSelectStateApi.class)).isMultiSelect(this.channelId);
        GuildAIOTitleBar guildAIOTitleBar = this.titleBarView;
        if (guildAIOTitleBar != null) {
            if (j06 && isVisibleForVisitor && !isMultiSelect) {
                z16 = true;
            } else {
                z16 = false;
            }
            guildAIOTitleBar.setJoinButtonVisibility(z16);
        }
    }

    private final void J(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        uf1.a aVar = this.loadProxyManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
            aVar = null;
        }
        if (!aVar.h()) {
            GuildAIOTitleBar guildAIOTitleBar = this.titleBarView;
            if (guildAIOTitleBar != null) {
                guildAIOTitleBar.setGuildNavigateVisibility(false);
                return;
            }
            return;
        }
        GuildAIOTitleBar guildAIOTitleBar2 = this.titleBarView;
        if (guildAIOTitleBar2 != null) {
            guildAIOTitleBar2.setGuildNavigateVisibility(true);
        }
        String guildName = guildInfo.getGuildName();
        GuildAIOTitleBar guildAIOTitleBar3 = this.titleBarView;
        if (guildAIOTitleBar3 != null) {
            Intrinsics.checkNotNullExpressionValue(guildName, "guildName");
            guildAIOTitleBar3.setGuildName(guildName);
        }
        r guildStateIconInfo = ds1.a.e(this.guildId);
        if (guildStateIconInfo.d() <= 0) {
            if (p(guildInfo, channelInfo)) {
                QLog.d("GuildChannelTitleBarManager", 1, "updateGuildStateInfo: isLivingChannelForGuest. guildId[" + this.guildId + "]");
                GuildAIOTitleBar guildAIOTitleBar4 = this.titleBarView;
                if (guildAIOTitleBar4 != null) {
                    guildAIOTitleBar4.setGuildStateType(GuildStateType.LIVE);
                    return;
                }
                return;
            }
            QLog.d("GuildChannelTitleBarManager", 1, "updateGuildStateInfo: empty state. guildId[" + this.guildId + "]");
            GuildAIOTitleBar guildAIOTitleBar5 = this.titleBarView;
            if (guildAIOTitleBar5 != null) {
                guildAIOTitleBar5.setGuildStateType(GuildStateType.NONE);
                return;
            }
            return;
        }
        QLog.d("GuildChannelTitleBarManager", 1, "updateGuildStateInfo: guildStateIconInfo:", guildStateIconInfo);
        Intrinsics.checkNotNullExpressionValue(guildStateIconInfo, "guildStateIconInfo");
        GuildStateType k3 = k(guildStateIconInfo);
        GuildAIOTitleBar guildAIOTitleBar6 = this.titleBarView;
        if (guildAIOTitleBar6 != null) {
            guildAIOTitleBar6.setGuildStateType(k3);
        }
    }

    private final void K(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        if (!this.needUpdateChannelIcon) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.frame.titlebar.e
            @Override // java.lang.Runnable
            public final void run() {
                GuildChannelTitleBarManager.L(GuildChannelTitleBarManager.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(final GuildChannelTitleBarManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGProGuildInfo M = ch.M(this$0.guildId);
        if (M != null) {
            M.getAvatarUrl(100);
            String avatarUrl = M.getAvatarUrl(100);
            Intrinsics.checkNotNullExpressionValue(avatarUrl, "guildInfo.getAvatarUrl(I\u2026ldAvatarUrlType.SIZE_100)");
            IRuntimeService runtimeService = MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IQQGuildAvatarApi.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
            final Drawable avatarDrawable = ((IQQGuildAvatarApi) runtimeService).getAvatarDrawable(avatarUrl, 2, false, M.getGuildID() + "GuildChannelTitleBarManager");
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.frame.titlebar.f
                @Override // java.lang.Runnable
                public final void run() {
                    GuildChannelTitleBarManager.M(GuildChannelTitleBarManager.this, avatarDrawable);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(GuildChannelTitleBarManager this$0, Drawable itemDrawable) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildAIOTitleBar guildAIOTitleBar = this$0.titleBarView;
        if (guildAIOTitleBar != null) {
            Intrinsics.checkNotNullExpressionValue(itemDrawable, "itemDrawable");
            guildAIOTitleBar.setGuildAvatarDrawable(itemDrawable);
        }
    }

    private final void h() {
        l().addObserver(this.observer);
        uf1.a aVar = this.loadProxyManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
            aVar = null;
        }
        if (aVar.h()) {
            l().addGuildStateListener(this.guildStateListener);
        }
    }

    private final GuildStateType k(r guildStateIconInfo) {
        switch (guildStateIconInfo.d()) {
            case 1:
            case 3:
                return GuildStateType.LIVE;
            case 2:
            case 6:
                return GuildStateType.VOICE;
            case 4:
            case 5:
            case 9:
            case 10:
            default:
                QLog.e("GuildChannelTitleBarManager", 1, "getGuildStateIconResId: can not handle type[" + guildStateIconInfo.d() + "]");
                return GuildStateType.NONE;
            case 7:
            case 8:
                return GuildStateType.SCREEN_SHARE;
            case 11:
            case 12:
                return GuildStateType.VOICE_GAME;
            case 13:
            case 14:
                return GuildStateType.PLAY_TOGETHER;
        }
    }

    private final IGPSService l() {
        return (IGPSService) this.iGPSService.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(GuildChannelTitleBarManager this$0, dt dtVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D();
    }

    private final void n() {
        JumpGuildParam.JoinInfoParam joinInfoParam;
        uf1.a aVar = new uf1.a(this.channelParams);
        this.loadProxyManager = aVar;
        aVar.i(this.guildId, this.channelId);
        g gVar = this.channelProcessor;
        JumpGuildParam.JoinInfoParam joinInfoParam2 = null;
        if (gVar != null) {
            joinInfoParam = gVar.T3();
        } else {
            joinInfoParam = null;
        }
        if (joinInfoParam != null) {
            uf1.a aVar2 = this.loadProxyManager;
            if (aVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
                aVar2 = null;
            }
            g gVar2 = this.channelProcessor;
            if (gVar2 != null) {
                joinInfoParam2 = gVar2.T3();
            }
            aVar2.j(joinInfoParam2);
        }
    }

    private final void o() {
        uf1.a aVar = this.loadProxyManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
            aVar = null;
        }
        if (aVar.a()) {
            GuildChannelUnreadCountManager guildChannelUnreadCountManager = new GuildChannelUnreadCountManager(this.channelId, this);
            this.unreadCountManager = guildChannelUnreadCountManager;
            Intrinsics.checkNotNull(guildChannelUnreadCountManager);
            guildChannelUnreadCountManager.d();
        }
    }

    private final boolean p(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
        if (channelInfo.getType() == 5 && !guildInfo.isMember() && channelInfo.getLiveRoomId() > 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(GuildChannelTitleBarManager this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            this$0.D();
        } else {
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.context, i3, str, iGProSecurityResult);
        }
    }

    private final void w() {
        l().deleteObserver(this.observer);
        l().removeGuildStateListener(this.guildStateListener);
    }

    private final void x() {
        Runnable runnable = this.postSubscribeAction;
        if (runnable != null) {
            ThreadManagerV2.getUIHandlerV2().removeCallbacks(runnable);
        }
        this.postSubscribeAction = null;
    }

    public final void A(boolean needUpdate) {
        this.needUpdateChannelIcon = needUpdate;
    }

    public final void B(boolean needUpdate) {
        this.needUpdateChannelName = needUpdate;
    }

    public final void C(@NotNull String updateGuildId, @NotNull String updateChannelId, @NotNull Bundle updateParams) {
        Intrinsics.checkNotNullParameter(updateGuildId, "updateGuildId");
        Intrinsics.checkNotNullParameter(updateChannelId, "updateChannelId");
        Intrinsics.checkNotNullParameter(updateParams, "updateParams");
        this.guildId = updateGuildId;
        this.channelId = updateChannelId;
        this.channelParams = updateParams;
        uf1.a aVar = this.loadProxyManager;
        if (aVar != null) {
            uf1.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
                aVar = null;
            }
            aVar.m(this.channelParams);
            uf1.a aVar3 = this.loadProxyManager;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
            } else {
                aVar2 = aVar3;
            }
            aVar2.i(this.guildId, this.channelId);
        }
        D();
    }

    public final void D() {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.channel.frame.titlebar.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildChannelTitleBarManager.E(GuildChannelTitleBarManager.this);
            }
        }, 16, null, false);
    }

    @Override // com.tencent.mobileqq.guild.channel.frame.unread.a
    public void a() {
        GuildChannelUnreadCountManager guildChannelUnreadCountManager;
        uf1.a aVar = this.loadProxyManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
            aVar = null;
        }
        if (aVar.a() && (guildChannelUnreadCountManager = this.unreadCountManager) != null) {
            Intrinsics.checkNotNull(guildChannelUnreadCountManager);
            int unreadCnt = guildChannelUnreadCountManager.getUnreadCnt();
            GuildAIOTitleBar guildAIOTitleBar = this.titleBarView;
            if (guildAIOTitleBar != null) {
                guildAIOTitleBar.setUnreadCount(unreadCnt);
            }
        }
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public final void q() {
        n();
        o();
        h();
    }

    public final void r() {
        GuildChannelUnreadCountManager guildChannelUnreadCountManager = this.unreadCountManager;
        if (guildChannelUnreadCountManager != null) {
            guildChannelUnreadCountManager.e();
        }
        x();
        w();
    }

    public final void s(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        uf1.a aVar = this.loadProxyManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
            aVar = null;
        }
        aVar.l(activity);
    }

    public final void t() {
        boolean z16;
        uf1.a aVar = this.loadProxyManager;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("loadProxyManager");
            aVar = null;
        }
        JumpGuildParam d16 = aVar.d();
        String joinSignature = d16.getJoinInfoParam().getJoinSignature();
        if (joinSignature != null && joinSignature.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            bVar.a().add("onGuildJoinClicked: error. joinParam is null.");
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("GuildChannelBottomManager", 1, (String) it.next(), null);
            }
            return;
        }
        IGProChannelInfo C = ch.C(ch.m(), this.guildId, this.channelId);
        if (C != null) {
            d16.getJoinInfoParam().setPageEntranceId(QQGuildJumpSource.a(C.getType(), C.getApplicationId()));
        } else {
            d16.getJoinInfoParam().setPageEntranceId(4);
        }
        com.tencent.mobileqq.guild.channel.joinchannel.h.a(this.context, d16, new JoinGuildLogic.JumpParam(), "GuildChannelTitleBarManager", new bv() { // from class: com.tencent.mobileqq.guild.channel.frame.titlebar.c
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                GuildChannelTitleBarManager.u(GuildChannelTitleBarManager.this, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    public final void v() {
        QLog.d("GuildChannelTitleBarManager", 1, "============ onPause ================");
        x();
    }

    public final void y(@NotNull g processor) {
        Intrinsics.checkNotNullParameter(processor, "processor");
        this.channelProcessor = processor;
    }

    public final void z(@NotNull GuildAIOTitleBar view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.titleBarView = view;
    }

    private final void H(IGProGuildInfo guildInfo, IGProChannelInfo channelInfo) {
    }
}
