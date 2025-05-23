package com.tencent.mobileqq.guild.feed.feedsquare.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.emoticon.QQSysAndEmojiResMgr;
import com.tencent.mobileqq.guild.channel.frame.GuildPostsLoadFragment;
import com.tencent.mobileqq.guild.feed.adapter.GuildFeedCacheRecycleViewPool;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.feed.feedsquare.part.GuildFeedSquareContentPart;
import com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.guild.feed.square.GuildFeedSquareInitBean;
import com.tencent.mobileqq.guild.feed.util.GuildFeedHtmlOfflineUtil;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.webbundle.GuildFeedDetailIdleTaskHelper;
import com.tencent.mobileqq.guild.feed.webbundle.GuildWebBundleManager;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.GuildChannelReportManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pad.LaunchMode;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\t*\u0001.\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0017\u001a\u00020\u00022\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u001a\u001a\u00020\u0002H\u0016J\b\u0010\u001b\u001a\u00020\u0002H\u0016J\b\u0010\u001c\u001a\u00020\u0002H\u0016J\u000e\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\b\u0010 \u001a\u00020\nH\u0014J\b\u0010!\u001a\u00020\fH\u0014R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareHomeFragment;", "Lcom/tencent/mobileqq/guild/feed/fragment/GuildBasePartFragment;", "", "sh", "th", "pageDtReport", "registerIoc", "uh", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "getInitBean", "", "getContentLayoutId", "", "needSupportFullScreen", "Landroidx/fragment/app/Fragment;", "childFragment", "onAttachFragment", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onViewCreatedBeforePartInit", "contentView", "onViewCreatedAfterPartInit", "onResume", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "needAdjustImmersive", "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/square/GuildFeedSquareInitBean;", "mInitBean", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareContentPart;", "D", "Lcom/tencent/mobileqq/guild/feed/feedsquare/part/GuildFeedSquareContentPart;", "mContentPart", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "E", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "recyclerViewPool", "com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareHomeFragment$b", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareHomeFragment$b;", "recycledViewPoolIoc", "<init>", "()V", "G", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareHomeFragment extends GuildBasePartFragment {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private GuildFeedSquareInitBean mInitBean;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.widget.a recyclerViewPool;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final GuildFeedSquareContentPart mContentPart = new GuildFeedSquareContentPart();

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private b recycledViewPoolIoc = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareHomeFragment$a;", "", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "extra", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.fragment.GuildFeedSquareHomeFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull Bundle extra) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(extra, "extra");
            boolean z16 = extra.getBoolean(JumpGuildParam.EXTRA_OPEN_STANDALONE, false);
            if (AppSetting.t(context) && !z16) {
                com.tencent.mobileqq.pad.i.e(context, extra, GuildPostsLoadFragment.class, new com.tencent.mobileqq.pad.b().e(false).g(true).h(LaunchMode.singleTop).a());
                return;
            }
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("public_fragment_window_feature", 1);
            intent.putExtras(new Bundle(extra));
            QPublicTransFragmentActivity.start(context, intent, GuildPostsLoadFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/fragment/GuildFeedSquareHomeFragment$b", "Lxj1/d;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/a;", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements xj1.d {
        b() {
        }

        @Override // xj1.d
        @Nullable
        public com.tencent.mobileqq.guild.feed.feedsquare.widget.a a() {
            return GuildFeedSquareHomeFragment.this.recyclerViewPool;
        }
    }

    private final void pageDtReport() {
        if (this.mInitBean == null) {
            sh();
        }
        getFragmentContentView();
    }

    private final void registerIoc() {
        RFWIocAbilityProvider.g().registerIoc(getFragmentContentView(), this.recycledViewPoolIoc, xj1.d.class);
    }

    private final void sh() {
        GuildFeedBaseInitBean o16 = ax.o(this);
        if (o16 instanceof GuildFeedSquareInitBean) {
            GuildFeedSquareInitBean guildFeedSquareInitBean = (GuildFeedSquareInitBean) o16;
            this.mInitBean = guildFeedSquareInitBean;
            guildFeedSquareInitBean.getFeedReportSourceInfo().addReportItem("extra_feeds_page_id", "pg_sgrp_forum");
            guildFeedSquareInitBean.getFeedReportSourceInfo().addReportItem("extra_feeds_page_forum_type", "2");
            QLog.d(getTAG(), 1, "getInitBeanSuccess:" + this.mInitBean);
        }
        ax.K(getActivity(), o16);
    }

    private final void th() {
        boolean z16;
        String guildId = getInitBean().getGuildId();
        if (guildId != null && guildId.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.w("GuildFeedSquareHomeFragment", 1, "registerFeedTopData|guildId is empty");
        }
    }

    private final void uh() {
        RFWIocAbilityProvider.g().unregisterSingleIoc(getFragmentContentView(), xj1.d.class);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(this.mContentPart);
        return linkedList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168090er2;
    }

    @NotNull
    protected GuildFeedBaseInitBean getInitBean() {
        if (this.mInitBean == null) {
            sh();
        }
        GuildFeedSquareInitBean guildFeedSquareInitBean = this.mInitBean;
        Intrinsics.checkNotNull(guildFeedSquareInitBean);
        return guildFeedSquareInitBean;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needAdjustImmersive() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean needSupportFullScreen() {
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttachFragment(@NotNull Fragment childFragment) {
        Intrinsics.checkNotNullParameter(childFragment, "childFragment");
        super.onAttachFragment(childFragment);
        sh();
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).initGuildTaskQueueManager();
        GuildInfoManager.q().R();
        GuildFeedHtmlOfflineUtil.f();
        Logger.f235387a.d().i("GuildFeedSquareHomeFragment", 1, "onCreate id:" + System.identityHashCode(this));
    }

    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        GuildInfoManager.q().e0();
        gn1.a.b();
        GuildFeedCacheRecycleViewPool.INSTANCE.a().e();
        ej1.d.f396347a.a();
        com.tencent.mobileqq.guild.feed.widget.comment.d.f224303h.d();
        com.tencent.mobileqq.guild.feed.feedsquare.widget.a aVar = this.recyclerViewPool;
        if (aVar != null) {
            aVar.b();
        }
        uh();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QQSysAndEmojiResMgr.getInstance().refreshConfig();
        GuildFeedDetailIdleTaskHelper.INSTANCE.a().f(new GuildWebBundleManager.c());
        GuildChannelReportManager.f231987a.e(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        GuildChannelReportManager.f231987a.f(GuildChannelReportManager.PageType.CHANNEL_PAGE_FEED_LIST, null);
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Context context = getContext();
        if (context != null) {
            this.recyclerViewPool = new com.tencent.mobileqq.guild.feed.feedsquare.widget.a(context);
        }
        registerIoc();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        pageDtReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.feed.fragment.GuildBasePartFragment, com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(view, savedInstanceState);
        th();
    }
}
