package com.tencent.mobileqq.guild.channel.frame.bottom;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.QQGuildJumpSource;
import com.tencent.mobileqq.guild.media.core.j;
import com.tencent.mobileqq.guild.media.core.notify.n;
import com.tencent.mobileqq.guild.media.core.notify.p;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.widget.GuildGuestBottomLayout;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.ev;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u00016\u0018\u0000 \u00102\u00020\u0001:\u0002\u001c;B'\u0012\u0006\u0010 \u001a\u00020\u001b\u0012\u0006\u0010%\u001a\u00020\u000f\u0012\u0006\u0010(\u001a\u00020\u000f\u0012\u0006\u0010-\u001a\u00020)\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0006\u0010\u0014\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\u0002J\u0010\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u001a\u001a\u00020\u0019R\u0017\u0010 \u001a\u00020\u001b8\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010%\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0017\u0010(\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b&\u0010\"\u001a\u0004\b'\u0010$R\u0017\u0010-\u001a\u00020)8\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010*\u001a\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010.R\u0016\u00102\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u00101R\u0014\u00105\u001a\u0002038\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u00104R\u0014\u00108\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u00107\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager;", "", "", "k", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager$GuestViewType;", "g", "type", "u", "j", "t", "Lcom/tencent/mobileqq/guild/widget/GuildGuestBottomLayout;", "guestJoinView", ReportConstant.COSTREPORT_PREFIX, "", "i", "Landroid/view/View;", "v", DomainData.DOMAIN_NAME, "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/FrameLayout;", "layoutView", "r", "", "e", "Landroid/content/Context;", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "b", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "guildId", "c", "f", "channelId", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "getChannelParams", "()Landroid/os/Bundle;", "channelParams", "Landroid/widget/FrameLayout;", "bottomLayoutView", "Luf1/a;", "Luf1/a;", "loadProxyManager", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnClickListener;", "onJoinClickListener", "com/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager$c", "Lcom/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager$c;", "observer", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V", "GuestViewType", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GuildChannelGuestBottomManager {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String channelId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle channelParams;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private FrameLayout bottomLayoutView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private uf1.a loadProxyManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnClickListener onJoinClickListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c observer;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager$GuestViewType;", "", "(Ljava/lang/String;I)V", "GUEST_TYPE_NONE", "GUEST_TYPE_JOIN", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public enum GuestViewType {
        GUEST_TYPE_NONE,
        GUEST_TYPE_JOIN
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes12.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f214903a;

        static {
            int[] iArr = new int[GuestViewType.values().length];
            try {
                iArr[GuestViewType.GUEST_TYPE_JOIN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f214903a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0014J8\u0010\u0011\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0010H\u0014\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/channel/frame/bottom/GuildChannelGuestBottomManager$c", "Lcom/tencent/mobileqq/qqguildsdk/observer/GPServiceObserver;", "", "channelUin", "", "onChannelInfoUpdated", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "info", "", "sourceType", "onAddGuildWithInfo", "onGuildListUpdated", "result", "errMsg", "guildId", "tinyId", "Lcom/tencent/mobileqq/qqguildsdk/data/ev;", "onUserProfileInfoUpdate", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c extends GPServiceObserver {
        c() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onAddGuildWithInfo(@Nullable IGProGuildInfo info, int sourceType) {
            String str;
            String str2 = null;
            if (info != null) {
                str = info.getGuildID();
            } else {
                str = null;
            }
            if (!TextUtils.isEmpty(str)) {
                if (info != null) {
                    str2 = info.getGuildID();
                }
                if (Intrinsics.areEqual(str2, GuildChannelGuestBottomManager.this.getGuildId())) {
                    Logger.f235387a.d().i("GuildChannelBottomManager", 1, "onAddGuildWithInfo: guildId[" + info + "?.guildID]");
                    GuildChannelGuestBottomManager.this.j();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onChannelInfoUpdated(@NotNull String channelUin) {
            Intrinsics.checkNotNullParameter(channelUin, "channelUin");
            if (TextUtils.equals(GuildChannelGuestBottomManager.this.getChannelId(), channelUin)) {
                Logger.f235387a.d().i("GuildChannelBottomManager", 1, "onChannelInfoUpdated: channelUin[" + channelUin + "]");
                GuildChannelGuestBottomManager.this.j();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onGuildListUpdated() {
            GuildChannelGuestBottomManager.this.j();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.mobileqq.qqguildsdk.observer.GPServiceObserver
        public void onUserProfileInfoUpdate(int result, @Nullable String errMsg, @Nullable String guildId, @Nullable String tinyId, @Nullable ev info) {
            if (!TextUtils.isEmpty(guildId) && Intrinsics.areEqual(guildId, GuildChannelGuestBottomManager.this.getGuildId())) {
                Logger.f235387a.d().i("GuildChannelBottomManager", 1, "onAddGuildWithInfo: guildId[" + info + "?.guildID]");
                GuildChannelGuestBottomManager.this.j();
            }
        }
    }

    public GuildChannelGuestBottomManager(@NotNull Context context, @NotNull String guildId, @NotNull String channelId, @NotNull Bundle channelParams) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(channelParams, "channelParams");
        this.context = context;
        this.guildId = guildId;
        this.channelId = channelId;
        this.channelParams = channelParams;
        this.onJoinClickListener = new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.channel.frame.bottom.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildChannelGuestBottomManager.p(GuildChannelGuestBottomManager.this, view);
            }
        };
        this.observer = new c();
    }

    private final void d() {
        ((IGPSService) ch.m().getRuntimeService(IGPSService.class, "")).addObserver(this.observer);
    }

    private final GuestViewType g() {
        if (ch.j0(this.guildId)) {
            return GuestViewType.GUEST_TYPE_JOIN;
        }
        return GuestViewType.GUEST_TYPE_NONE;
    }

    private final String i() {
        IGProChannelInfo C = ch.C(ch.m(), this.guildId, this.channelId);
        if (C == null) {
            return "";
        }
        int type = C.getType();
        if (type != 2) {
            if (type != 5) {
                return "";
            }
            return "em_stream_aio_tourist";
        }
        return "em_sgrp_channelvistor_add";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        if (this.bottomLayoutView == null) {
            return;
        }
        GuestViewType g16 = g();
        boolean z16 = true;
        Logger.f235387a.d().i("GuildChannelBottomManager", 1, "handleGuestStateUpdated: type[" + g16 + "]");
        GuestViewType guestViewType = GuestViewType.GUEST_TYPE_NONE;
        if (g16 != guestViewType) {
            u(g16);
        } else {
            FrameLayout frameLayout = this.bottomLayoutView;
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            FrameLayout frameLayout2 = this.bottomLayoutView;
            if (frameLayout2 != null) {
                frameLayout2.setVisibility(8);
            }
        }
        p d16 = j.d();
        if (g16 == guestViewType) {
            z16 = false;
        }
        d16.i(new n(z16));
    }

    private final void k() {
        uf1.a aVar = new uf1.a(this.channelParams);
        this.loadProxyManager = aVar;
        aVar.i(this.guildId, this.channelId);
    }

    private final void n(View v3) {
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
        com.tencent.mobileqq.guild.channel.joinchannel.h.a(this.context, d16, new JoinGuildLogic.JumpParam(), "GuildChannelBottomManager", new bv() { // from class: com.tencent.mobileqq.guild.channel.frame.bottom.b
            @Override // vh2.bv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                GuildChannelGuestBottomManager.o(GuildChannelGuestBottomManager.this, i3, str, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o(GuildChannelGuestBottomManager this$0, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            this$0.j();
        } else {
            com.tencent.mobileqq.guild.channel.joinchannel.h.c(this$0.context, i3, str, iGProSecurityResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p(GuildChannelGuestBottomManager this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.n(it);
        EventCollector.getInstance().onViewClicked(it);
    }

    private final void q() {
        ((IGPSService) ch.m().getRuntimeService(IGPSService.class, "")).deleteObserver(this.observer);
    }

    private final void s(GuildGuestBottomLayout guestJoinView) {
        String i3 = i();
        if (TextUtils.isEmpty(i3)) {
            return;
        }
        ch.Y0(guestJoinView.a(), i3, ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    private final void t() {
        GuildGuestBottomLayout guildGuestBottomLayout;
        FrameLayout frameLayout = this.bottomLayoutView;
        if (frameLayout == null) {
            return;
        }
        if (frameLayout != null) {
            guildGuestBottomLayout = (GuildGuestBottomLayout) frameLayout.findViewById(R.id.wq5);
        } else {
            guildGuestBottomLayout = null;
        }
        if (guildGuestBottomLayout != null) {
            return;
        }
        GuildGuestBottomLayout guildGuestBottomLayout2 = new GuildGuestBottomLayout(this.context);
        guildGuestBottomLayout2.setId(R.id.wq5);
        guildGuestBottomLayout2.setColorMode(1);
        guildGuestBottomLayout2.setJoinButtonClickListener(this.onJoinClickListener);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        FrameLayout frameLayout2 = this.bottomLayoutView;
        if (frameLayout2 != null) {
            frameLayout2.addView(guildGuestBottomLayout2, layoutParams);
        }
        s(guildGuestBottomLayout2);
    }

    private final void u(GuestViewType type) {
        if (b.f214903a[type.ordinal()] == 1) {
            t();
        }
    }

    public final boolean e() {
        if (this.bottomLayoutView == null) {
            return false;
        }
        GuestViewType g16 = g();
        Logger.f235387a.d().i("GuildChannelBottomManager", 1, "checkAndShowGuestBottom: type[" + g16 + "]");
        GuestViewType guestViewType = GuestViewType.GUEST_TYPE_NONE;
        if (g16 != guestViewType) {
            u(g16);
        }
        if (g16 == guestViewType) {
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getChannelId() {
        return this.channelId;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getGuildId() {
        return this.guildId;
    }

    public final void l() {
        k();
        d();
    }

    public final void m() {
        q();
    }

    public final void r(@Nullable FrameLayout layoutView) {
        this.bottomLayoutView = layoutView;
    }
}
