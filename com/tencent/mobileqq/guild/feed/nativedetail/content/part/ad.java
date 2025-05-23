package com.tencent.mobileqq.guild.feed.nativedetail.content.part;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.data.GProStFeedMemoryKeepSerializer;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedLauncher;
import com.tencent.mobileqq.guild.feed.manager.GuildFeedDetailDataCacheManager;
import com.tencent.mobileqq.guild.feed.preload.detail.data.GuildFeedDetailPreloadParams;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0012\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\rH\u0016J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/part/ad;", "Lcom/tencent/biz/richframework/part/Part;", "Lrl1/b;", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam;", "z9", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "Landroid/content/Intent;", "A9", "Lcom/tencent/mobileqq/guild/feed/preload/detail/data/GuildFeedDetailPreloadParams;", "preloadParams", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "view", "h1", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "e9", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class ad extends Part implements rl1.b {
    private final Intent A9(GProStFeed stFeed) {
        Intent intent = new Intent();
        intent.putExtra("last_Modified_Time", stFeed.latestInteraction.timestamp);
        intent.putExtra("join_info_param", (Parcelable) new JumpGuildParam.JoinInfoParam(String.valueOf(stFeed.channelInfo.sign.channelId), stFeed.channelInfo.sign.joinGuildSig, "discover", "recommend_content_forum"));
        intent.putExtra("st_feed_detail_data", new GProStFeedMemoryKeepSerializer(stFeed));
        return intent;
    }

    private final void B9(final GuildFeedDetailPreloadParams preloadParams) {
        if (!preloadParams.isValid()) {
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.nativedetail.content.part.ac
            @Override // java.lang.Runnable
            public final void run() {
                ad.C9(GuildFeedDetailPreloadParams.this);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C9(GuildFeedDetailPreloadParams preloadParams) {
        ArrayList arrayListOf;
        Intrinsics.checkNotNullParameter(preloadParams, "$preloadParams");
        GuildFeedDetailDataCacheManager y16 = GuildFeedDetailDataCacheManager.y();
        if (y16.x(preloadParams.getFeedId()) <= 0 && !y16.E(preloadParams.getFeedId(), preloadParams.getCreateTime())) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(preloadParams);
            y16.t(arrayListOf, null);
        }
    }

    private final JumpGuildParam z9() {
        String str;
        Activity hostActivity;
        Intent intent;
        Bundle extras;
        String str2 = "";
        JumpGuildParam jumpGuildParam = new JumpGuildParam(yl1.n.r(this), "");
        JumpGuildParam.JoinInfoParam joinInfoParam = (JumpGuildParam.JoinInfoParam) GuildSplitViewUtils.f235370a.h(getPartHost()).getParcelable("join_info_param");
        if (joinInfoParam == null) {
            joinInfoParam = jumpGuildParam.getJoinInfoParam();
            Intrinsics.checkNotNullExpressionValue(joinInfoParam, "jumpGuildParam.joinInfoParam");
        }
        IPartHost partHost = getPartHost();
        if (partHost != null && (hostActivity = partHost.getHostActivity()) != null && (intent = hostActivity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            str = extras.getString("trace_Id", "");
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        jumpGuildParam.extras.putString(JumpGuildParam.EXTRA_KEY_TRACE_ID, str2);
        jumpGuildParam.setJoinInfoParam(joinInfoParam);
        return jumpGuildParam;
    }

    @Override // rl1.b
    public void e9(@Nullable IGProGuildInfo guildInfo) {
        Context context = getPartRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        GuildJumpUtil.n(context, z9());
    }

    @Override // rl1.b
    public void h1(@NotNull GProStFeed stFeed, @NotNull View view) {
        Activity hostActivity;
        Intent intent;
        Bundle extras;
        int i3;
        Activity hostActivity2;
        Intent intent2;
        Bundle extras2;
        Intrinsics.checkNotNullParameter(stFeed, "stFeed");
        Intrinsics.checkNotNullParameter(view, "view");
        String feedId = stFeed.idd;
        String valueOf = String.valueOf(stFeed.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(stFeed.channelInfo.sign.channelId);
        GProStChannelInfo gProStChannelInfo = stFeed.channelInfo;
        String str = gProStChannelInfo.sign.joinGuildSig;
        String str2 = gProStChannelInfo.name;
        QRouteApi api = QRoute.api(IGuildFeedNativeDetailApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedNativeDetailApi::class.java)");
        IGuildFeedNativeDetailApi iGuildFeedNativeDetailApi = (IGuildFeedNativeDetailApi) api;
        int i16 = 0;
        if (iGuildFeedNativeDetailApi.needOpenNativeDetailPage(stFeed)) {
            com.tencent.mobileqq.guild.feed.util.n c16 = com.tencent.mobileqq.guild.feed.util.m.c(stFeed);
            com.tencent.mobileqq.guild.discoveryv2.util.d.f217794a.e(c16.getUrl(), c16.getWidth(), c16.getHeight());
            Intent A9 = A9(stFeed);
            Context context = view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
            IPartHost partHost = getPartHost();
            if (partHost != null && (hostActivity2 = partHost.getHostActivity()) != null && (intent2 = hostActivity2.getIntent()) != null && (extras2 = intent2.getExtras()) != null) {
                i3 = extras2.getInt("business_type");
            } else {
                i3 = 0;
            }
            iGuildFeedNativeDetailApi.openFeedNativeDetailPage(context, valueOf, valueOf2, feedId, i3, A9, true);
            return;
        }
        String tinyId = stFeed.poster.idd;
        long parseLong = Long.parseLong(valueOf);
        long parseLong2 = Long.parseLong(valueOf2);
        Intrinsics.checkNotNullExpressionValue(feedId, "feedId");
        Intrinsics.checkNotNullExpressionValue(tinyId, "tinyId");
        B9(new GuildFeedDetailPreloadParams(parseLong, parseLong2, feedId, tinyId, stFeed.createTime, 0L));
        Context context2 = view.getContext();
        GuildFeedDetailInitBean guildFeedDetailInitBean = new GuildFeedDetailInitBean();
        guildFeedDetailInitBean.setGuildId(valueOf);
        guildFeedDetailInitBean.setChannelId(valueOf2);
        guildFeedDetailInitBean.setChannelInfoName(str2);
        guildFeedDetailInitBean.setPosterTinyId(tinyId);
        guildFeedDetailInitBean.setFeedId(feedId);
        guildFeedDetailInitBean.setCreateTime(stFeed.createTime);
        guildFeedDetailInitBean.setIsMember(!ch.j0(valueOf));
        guildFeedDetailInitBean.setUserType(((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(valueOf));
        guildFeedDetailInitBean.setVisitorTinyId(ch.g());
        guildFeedDetailInitBean.setJoinInfoParam(new JumpGuildParam.JoinInfoParam(valueOf2, str, "discover", "recommend_content_forum"));
        guildFeedDetailInitBean.setShareSource(10);
        IPartHost partHost2 = getPartHost();
        if (partHost2 != null && (hostActivity = partHost2.getHostActivity()) != null && (intent = hostActivity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            i16 = extras.getInt("business_type");
        }
        guildFeedDetailInitBean.setBusinessType(i16);
        GuildFeedLauncher.w(context2, guildFeedDetailInitBean);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        RFWIocAbilityProvider.g().registerIoc(rootView, this, rl1.b.class);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getPartRootView(), rl1.b.class);
    }
}
