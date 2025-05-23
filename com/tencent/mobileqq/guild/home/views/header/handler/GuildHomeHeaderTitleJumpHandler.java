package com.tencent.mobileqq.guild.home.views.header.handler;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.channel.joinchannel.q;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.home.viewmodels.header.uidata.NoticeBubbleInfo;
import com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.setting.guildinfo.GuildInfoFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.share.util.c;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.aa;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.visitor.GuildVisitorUtils;
import com.tencent.mobileqq.guild.widget.banner.BannerTipOffDialog;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 \u00112\u00020\u0001:\u0002\u0019\u001dB\u0017\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J+\u0010\u000b\u001a\u00020\t2#\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004J\u0014\u0010\u000e\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ \u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R\u0014\u0010\u001b\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001f\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010$\u001a\u00020\u00028FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R3\u0010\n\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler;", "", "Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler$b;", h.F, "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "onOpenSettingCallback", "l", "Lkotlin/Function0;", "onCheckInCallback", "k", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "g", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "j", "Lcom/tencent/mobileqq/app/QBaseActivity;", "a", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "b", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "guildFacadeType", "c", "Lkotlin/Lazy;", "i", "()Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler$b;", "titleClickCallback", "d", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "e", "Lkotlin/jvm/functions/Function1;", "f", "Lkotlin/jvm/functions/Function0;", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeHeaderTitleJumpHandler {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFacadeType guildFacadeType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy titleClickCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private FacadeArgsData facadeArgsData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Function1<? super View, Unit> onOpenSettingCallback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private Function0<Unit> onCheckInCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J \u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0014\u0010\t\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\r\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\f\u001a\u00020\u000bH&J\u0014\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\u000f\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0014\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/home/views/header/handler/GuildHomeHeaderTitleJumpHandler$b;", "", "Landroid/view/View;", "view", "", "a", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "e", "b", "onBackClick", "", "needJump2AIO", "g", "f", "d", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b {
        void a(@Nullable View view);

        void b(@Nullable View view);

        void c(@Nullable View view);

        void d(@Nullable View view);

        void e(@Nullable View view, @Nullable IGProGuildInfo guildInfo);

        void f(@Nullable View view);

        void g(@Nullable View view, boolean needJump2AIO);

        void onBackClick(@Nullable View view);
    }

    public GuildHomeHeaderTitleJumpHandler(@NotNull QBaseActivity activity, @NotNull GuildFacadeType guildFacadeType) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildFacadeType, "guildFacadeType");
        this.activity = activity;
        this.guildFacadeType = guildFacadeType;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler$titleClickCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeHeaderTitleJumpHandler.b invoke() {
                GuildHomeHeaderTitleJumpHandler.b h16;
                h16 = GuildHomeHeaderTitleJumpHandler.this.h();
                return h16;
            }
        });
        this.titleClickCallback = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b h() {
        return new b() { // from class: com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler$createTitleClickCallback$1
            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void a(@Nullable View view) {
                FacadeArgsData facadeArgsData;
                FacadeArgsData facadeArgsData2;
                QBaseActivity qBaseActivity;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                Logger logger = Logger.f235387a;
                GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = GuildHomeHeaderTitleJumpHandler.this;
                Logger.a d16 = logger.d();
                facadeArgsData = guildHomeHeaderTitleJumpHandler.facadeArgsData;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                d16.d("Guild.NewHome.GuildContentJumpHandler", 1, "onShareGuildClick guildId:" + facadeArgsData.f227656e);
                if (view != null) {
                    VideoReport.setElementId(view, "em_sgrp_cover_share");
                    ch.x(view);
                    VideoReport.reportEvent("clck", view, new HashMap());
                }
                facadeArgsData2 = GuildHomeHeaderTitleJumpHandler.this.facadeArgsData;
                if (facadeArgsData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData2 = null;
                }
                IGProGuildInfo L = ch.L(facadeArgsData2.f227656e);
                if (L != null) {
                    qBaseActivity = GuildHomeHeaderTitleJumpHandler.this.activity;
                    m mVar = new m(qBaseActivity, L, null, GuildSharePageSource.GUILD_PROFILE);
                    c.c(mVar, 1);
                    mVar.z();
                }
            }

            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void b(@Nullable View view) {
                FacadeArgsData facadeArgsData;
                Function1 function1;
                QBaseActivity qBaseActivity;
                FacadeArgsData facadeArgsData2;
                Function1 function12;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                Logger logger = Logger.f235387a;
                GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = GuildHomeHeaderTitleJumpHandler.this;
                Logger.a d16 = logger.d();
                facadeArgsData = guildHomeHeaderTitleJumpHandler.facadeArgsData;
                FacadeArgsData facadeArgsData3 = null;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                d16.d("Guild.NewHome.GuildContentJumpHandler", 1, "onManageGuildCLick guildId:" + facadeArgsData.f227656e);
                function1 = GuildHomeHeaderTitleJumpHandler.this.onOpenSettingCallback;
                if (function1 != null) {
                    function12 = GuildHomeHeaderTitleJumpHandler.this.onOpenSettingCallback;
                    if (function12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("onOpenSettingCallback");
                        function12 = null;
                    }
                    function12.invoke(view);
                }
                GuildSettingFragment.Companion companion = GuildSettingFragment.INSTANCE;
                qBaseActivity = GuildHomeHeaderTitleJumpHandler.this.activity;
                facadeArgsData2 = GuildHomeHeaderTitleJumpHandler.this.facadeArgsData;
                if (facadeArgsData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                } else {
                    facadeArgsData3 = facadeArgsData2;
                }
                companion.a(qBaseActivity, facadeArgsData3);
                if (view != null) {
                    VideoReport.setElementId(view, "em_sgrp_setting");
                    ch.x(view);
                    VideoReport.reportEvent("clck", view, new HashMap());
                }
            }

            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void c(@Nullable View view) {
                FacadeArgsData facadeArgsData;
                Function0 function0;
                Function0 function02;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                if (view != null) {
                    VideoReport.setElementId(view, "em_sgrp_sign_in");
                    ch.x(view);
                    VideoReport.reportEvent("clck", view, new HashMap());
                }
                Logger logger = Logger.f235387a;
                GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = GuildHomeHeaderTitleJumpHandler.this;
                Logger.a d16 = logger.d();
                facadeArgsData = guildHomeHeaderTitleJumpHandler.facadeArgsData;
                Function0 function03 = null;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                d16.d("Guild.NewHome.GuildContentJumpHandler", 1, "onCheckInClick guildId:" + facadeArgsData.f227656e);
                function0 = GuildHomeHeaderTitleJumpHandler.this.onCheckInCallback;
                if (function0 != null) {
                    function02 = GuildHomeHeaderTitleJumpHandler.this.onCheckInCallback;
                    if (function02 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("onCheckInCallback");
                    } else {
                        function03 = function02;
                    }
                    function03.invoke();
                }
            }

            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void d(@Nullable View view) {
                FacadeArgsData facadeArgsData;
                NoticeBubbleInfo noticeBubbleInfo;
                Map mapOf;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                FacadeArgsData facadeArgsData2 = null;
                if (view != null) {
                    Object tag = view.getTag();
                    if (tag instanceof NoticeBubbleInfo) {
                        noticeBubbleInfo = (NoticeBubbleInfo) tag;
                    } else {
                        noticeBubbleInfo = null;
                    }
                    if (noticeBubbleInfo == null) {
                        noticeBubbleInfo = new NoticeBubbleInfo("", 0, 0, null, null, 0L, 0, 126, null);
                    }
                    VideoReport.setElementId(view, "em_sgrp_notice_box");
                    ch.x(view);
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_red_tips_type", Integer.valueOf(noticeBubbleInfo.a())));
                    VideoReport.reportEvent("clck", view, mapOf);
                }
                IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
                facadeArgsData = GuildHomeHeaderTitleJumpHandler.this.facadeArgsData;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                } else {
                    facadeArgsData2 = facadeArgsData;
                }
                String str = facadeArgsData2.f227656e;
                Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
                iGuildFeedLauncherApi.launchGuildFeedNoticeFragment(new JumpGuildNoticeMsg(0, str, null, null, false, 0, 61, null), 1);
            }

            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void e(@Nullable View view, @Nullable IGProGuildInfo guildInfo) {
                FacadeArgsData facadeArgsData;
                Function1 function1;
                GuildFacadeType guildFacadeType;
                QBaseActivity qBaseActivity;
                FacadeArgsData facadeArgsData2;
                Function1 function12;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                Logger logger = Logger.f235387a;
                GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = GuildHomeHeaderTitleJumpHandler.this;
                Logger.a d16 = logger.d();
                facadeArgsData = guildHomeHeaderTitleJumpHandler.facadeArgsData;
                FacadeArgsData facadeArgsData3 = null;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                d16.d("Guild.NewHome.GuildContentJumpHandler", 1, "onManageGuildCLick guildId:" + facadeArgsData.f227656e);
                function1 = GuildHomeHeaderTitleJumpHandler.this.onOpenSettingCallback;
                if (function1 != null) {
                    function12 = GuildHomeHeaderTitleJumpHandler.this.onOpenSettingCallback;
                    if (function12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("onOpenSettingCallback");
                        function12 = null;
                    }
                    function12.invoke(view);
                }
                if (!NetworkUtil.isNetworkAvailable()) {
                    aa.b("\u5f53\u524d\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5");
                }
                if (view != null) {
                    VideoReport.setElementId(view, "em_sgrp_cover");
                    ch.x(view);
                    VideoReport.reportEvent("clck", view, new HashMap());
                }
                guildFacadeType = GuildHomeHeaderTitleJumpHandler.this.guildFacadeType;
                if (guildFacadeType == GuildFacadeType.GameCenter || guildInfo == null) {
                    return;
                }
                if (!guildInfo.isMember() && !GuildVisitorUtils.f235701a.b(guildInfo)) {
                    return;
                }
                GuildInfoFragment.a aVar = GuildInfoFragment.f233570x0;
                qBaseActivity = GuildHomeHeaderTitleJumpHandler.this.activity;
                facadeArgsData2 = GuildHomeHeaderTitleJumpHandler.this.facadeArgsData;
                if (facadeArgsData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                } else {
                    facadeArgsData3 = facadeArgsData2;
                }
                aVar.a(qBaseActivity, facadeArgsData3);
            }

            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void f(@Nullable View view) {
                FacadeArgsData facadeArgsData;
                FacadeArgsData facadeArgsData2;
                GuildFacadeType guildFacadeType;
                QBaseActivity qBaseActivity;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                Logger logger = Logger.f235387a;
                GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = GuildHomeHeaderTitleJumpHandler.this;
                Logger.a d16 = logger.d();
                facadeArgsData = guildHomeHeaderTitleJumpHandler.facadeArgsData;
                FacadeArgsData facadeArgsData3 = null;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                d16.d("Guild.NewHome.GuildContentJumpHandler", 1, "onTipOffClick guildId:" + facadeArgsData.f227656e);
                if (view != null) {
                    VideoReport.setElementId(view, "em_sgrp_top_right_more");
                    ch.x(view);
                    VideoReport.reportEvent("clck", view, new HashMap());
                }
                Bundle bundle = new Bundle();
                facadeArgsData2 = GuildHomeHeaderTitleJumpHandler.this.facadeArgsData;
                if (facadeArgsData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                } else {
                    facadeArgsData3 = facadeArgsData2;
                }
                bundle.putString("guildId", facadeArgsData3.f227656e);
                guildFacadeType = GuildHomeHeaderTitleJumpHandler.this.guildFacadeType;
                bundle.putSerializable("facadeType", guildFacadeType);
                BannerTipOffDialog bannerTipOffDialog = new BannerTipOffDialog();
                bannerTipOffDialog.setArguments(bundle);
                qBaseActivity = GuildHomeHeaderTitleJumpHandler.this.activity;
                FragmentManager supportFragmentManager = qBaseActivity.getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
                supportFragmentManager.beginTransaction().add(bannerTipOffDialog, "BannerTipOff").commitAllowingStateLoss();
            }

            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void g(@Nullable View view, boolean needJump2AIO) {
                FacadeArgsData facadeArgsData;
                QBaseActivity qBaseActivity;
                FacadeArgsData facadeArgsData2;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                Logger logger = Logger.f235387a;
                GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler = GuildHomeHeaderTitleJumpHandler.this;
                Logger.a d16 = logger.d();
                facadeArgsData = guildHomeHeaderTitleJumpHandler.facadeArgsData;
                FacadeArgsData facadeArgsData3 = null;
                if (facadeArgsData == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                    facadeArgsData = null;
                }
                d16.d("Guild.NewHome.GuildContentJumpHandler", 1, "onJoinGuildClick guildId:" + facadeArgsData.f227656e);
                if (view != null) {
                    VideoReport.setElementId(view, "em_sgrp_bottom_join_channel");
                    ch.x(view);
                    VideoReport.reportEvent("clck", view, new HashMap());
                }
                qBaseActivity = GuildHomeHeaderTitleJumpHandler.this.activity;
                facadeArgsData2 = GuildHomeHeaderTitleJumpHandler.this.facadeArgsData;
                if (facadeArgsData2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                } else {
                    facadeArgsData3 = facadeArgsData2;
                }
                final GuildHomeHeaderTitleJumpHandler guildHomeHeaderTitleJumpHandler2 = GuildHomeHeaderTitleJumpHandler.this;
                q.d(qBaseActivity, facadeArgsData3, needJump2AIO, 1, new Function1<IGProJoinGuildResult, Unit>() { // from class: com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler$createTitleClickCallback$1$onJoinGuildClick$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(IGProJoinGuildResult iGProJoinGuildResult) {
                        invoke2(iGProJoinGuildResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull IGProJoinGuildResult joinGuildsResult) {
                        FacadeArgsData facadeArgsData4;
                        Intrinsics.checkNotNullParameter(joinGuildsResult, "joinGuildsResult");
                        if (com.tencent.mobileqq.guild.channel.joinchannel.h.d(joinGuildsResult.getRetCode(), joinGuildsResult.getSecRet())) {
                            facadeArgsData4 = GuildHomeHeaderTitleJumpHandler.this.facadeArgsData;
                            if (facadeArgsData4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                                facadeArgsData4 = null;
                            }
                            facadeArgsData4.c(null);
                        }
                    }
                });
            }

            @Override // com.tencent.mobileqq.guild.home.views.header.handler.GuildHomeHeaderTitleJumpHandler.b
            public void onBackClick(@Nullable View view) {
                QBaseActivity qBaseActivity;
                QBaseActivity qBaseActivity2;
                QBaseActivity qBaseActivity3;
                if (FastClickUtils.isFastDoubleClick("Guild.NewHome.GuildContentJumpHandler")) {
                    return;
                }
                Logger.f235387a.d().d("Guild.NewHome.GuildContentJumpHandler", 1, "onBackClick");
                if (view != null) {
                    VideoReport.setElementId(view, "em_sgrp_tourists_view_preview_close");
                    ch.x(view);
                    VideoReport.reportEvent("clck", view, new HashMap());
                }
                qBaseActivity = GuildHomeHeaderTitleJumpHandler.this.activity;
                if (!qBaseActivity.isFinishing()) {
                    qBaseActivity2 = GuildHomeHeaderTitleJumpHandler.this.activity;
                    if (!qBaseActivity2.isDestroyed()) {
                        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
                        qBaseActivity3 = GuildHomeHeaderTitleJumpHandler.this.activity;
                        GuildSplitViewUtils.u(guildSplitViewUtils, qBaseActivity3, false, 2, null);
                    }
                }
            }
        };
    }

    public final void g(@NotNull FacadeArgsData facadeArgsData) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        this.facadeArgsData = facadeArgsData;
    }

    @NotNull
    public final b i() {
        return (b) this.titleClickCallback.getValue();
    }

    public final void k(@NotNull Function0<Unit> onCheckInCallback) {
        Intrinsics.checkNotNullParameter(onCheckInCallback, "onCheckInCallback");
        this.onCheckInCallback = onCheckInCallback;
    }

    public final void l(@NotNull Function1<? super View, Unit> onOpenSettingCallback) {
        Intrinsics.checkNotNullParameter(onOpenSettingCallback, "onOpenSettingCallback");
        this.onOpenSettingCallback = onOpenSettingCallback;
    }

    public final void j(int requestCode, int resultCode, @Nullable Intent data) {
    }
}
