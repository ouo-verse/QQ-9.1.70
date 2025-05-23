package com.tencent.mobileqq.guild;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity2;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.guild.api.IGuildContactApi;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\u00020\u00012\u00020\u0002:\u0001:B\u0007\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0014J\u001a\u0010\f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\r\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u0005H\u0016Jd\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000f2\u001a\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00132\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u00132\u001a\u0010\u0016\u001a\u0016\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011j\n\u0012\u0004\u0012\u00020\u0012\u0018\u0001`\u0013H\u0007R$\u0010\u001f\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010'\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001e\u0010,\u001a\n )*\u0004\u0018\u00010(0(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0019\u00102\u001a\u0004\u0018\u00010-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildTestFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Lcom/tencent/mobileqq/guild/p;", "", "from", "", "qh", "getContentLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "", "account", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lkotlin/collections/ArrayList;", "createdGuilds", "managedGuilds", "joinedGuilds", "sh", "Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;", "getGuildListView", "()Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;", "setGuildListView", "(Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;)V", "guildListView", "Landroid/widget/RelativeLayout;", "D", "Landroid/widget/RelativeLayout;", "getFooterEmptyViewContainer", "()Landroid/widget/RelativeLayout;", "setFooterEmptyViewContainer", "(Landroid/widget/RelativeLayout;)V", "footerEmptyViewContainer", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Lcom/tencent/mobileqq/app/QQAppInterface;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/app/QQAppInterface;", "getApp", "()Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "G", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "emptyInnerView", "<init>", "()V", "H", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildTestFragment extends QIphoneTitleBarFragment implements p {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildsPinnedHeaderExpandableListView guildListView;

    /* renamed from: D, reason: from kotlin metadata */
    private RelativeLayout footerEmptyViewContainer;

    /* renamed from: E, reason: from kotlin metadata */
    private IGPSService gProService = (IGPSService) bz.b(IGPSService.class);

    /* renamed from: F, reason: from kotlin metadata */
    private final QQAppInterface app;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIEmptyState emptyInnerView;

    public GuildTestFragment() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        this.app = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
    }

    private final void qh(int from) {
        IGPSService iGPSService = this.gProService;
        QQAppInterface qQAppInterface = this.app;
        String account = qQAppInterface != null ? qQAppInterface.getAccount() : null;
        if (account == null) {
            account = "0";
        }
        iGPSService.getGuildsInContact(new b(this, from, account));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(View view) {
        com.tencent.mobileqq.guild.report.b.g("connect_pindao", "GuildContactFragment");
        ((IGuildContactApi) QRoute.api(IGuildContactApi.class)).jumpGuildTabDiscoverPage();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f167251d0;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = this.guildListView;
        ExpandableListAdapter expandableListAdapter = guildsPinnedHeaderExpandableListView != null ? guildsPinnedHeaderExpandableListView.getExpandableListAdapter() : null;
        GuildListAdapter guildListAdapter = expandableListAdapter instanceof GuildListAdapter ? (GuildListAdapter) expandableListAdapter : null;
        if (guildListAdapter != null) {
            guildListAdapter.k();
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        qh(1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        QUIButton button;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = (GuildsPinnedHeaderExpandableListView) BaseActivity2.n0(((QIphoneTitleBarFragment) this).mContentView, R.id.f17610r);
        guildsPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
        guildsPinnedHeaderExpandableListView.mForContacts = true;
        GuildListAdapter guildListAdapter = null;
        if (this.footerEmptyViewContainer == null) {
            View inflate = LayoutInflater.from(guildsPinnedHeaderExpandableListView.getContext()).inflate(R.layout.f167249b1, (ViewGroup) guildsPinnedHeaderExpandableListView, false);
            RelativeLayout relativeLayout = inflate instanceof RelativeLayout ? (RelativeLayout) inflate : null;
            if (relativeLayout != null) {
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(BaseApplication.context).setImageType(16);
                String string = relativeLayout.getResources().getString(R.string.f1312104);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026.empty_guilds_in_contact)");
                QUIEmptyState.Builder backgroundColorType = imageType.setTitle(string).setHalfScreenState(true).setBackgroundColorType(0);
                String string2 = relativeLayout.getResources().getString(R.string.f131310d);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.go_to_guild_tab)");
                QUIEmptyState build = backgroundColorType.setButton(string2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.o
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        GuildTestFragment.rh(view2);
                    }
                }).build();
                this.emptyInnerView = build;
                if (build != null && (button = build.getButton()) != null) {
                    VideoReport.setElementId(button, "em_to_discover");
                    VideoReport.setElementExposePolicy(button, ExposurePolicy.REPORT_ALL);
                    VideoReport.setElementClickPolicy(button, ClickPolicy.REPORT_ALL);
                    VideoReport.setElementEndExposePolicy(button, EndExposurePolicy.REPORT_ALL);
                }
                relativeLayout.addView(this.emptyInnerView);
            } else {
                relativeLayout = null;
            }
            this.footerEmptyViewContainer = relativeLayout;
            guildsPinnedHeaderExpandableListView.addFooterView(relativeLayout);
        }
        QQAppInterface qQAppInterface = this.app;
        if (qQAppInterface != null) {
            Context context = guildsPinnedHeaderExpandableListView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            IGPSService gProService = this.gProService;
            Intrinsics.checkNotNullExpressionValue(gProService, "gProService");
            Intrinsics.checkNotNullExpressionValue(guildsPinnedHeaderExpandableListView, "this");
            guildListAdapter = new GuildListAdapter(context, qQAppInterface, gProService, guildsPinnedHeaderExpandableListView, "last_expand_of_guild_test_fragment", this);
        }
        guildsPinnedHeaderExpandableListView.setAdapter(guildListAdapter);
        this.guildListView = guildsPinnedHeaderExpandableListView;
    }

    public final void sh(String account, ArrayList<IGProGuildInfo> createdGuilds, ArrayList<IGProGuildInfo> managedGuilds, ArrayList<IGProGuildInfo> joinedGuilds) {
        Intrinsics.checkNotNullParameter(account, "account");
        QQAppInterface qQAppInterface = this.app;
        if (!TextUtils.equals(account, qQAppInterface != null ? qQAppInterface.getAccount() : null)) {
            QLog.i("GuildTestFragment", 1, "updateGuildData, but not current account, return");
            return;
        }
        int size = (createdGuilds != null ? createdGuilds.size() : 0) + (managedGuilds != null ? managedGuilds.size() : 0) + (joinedGuilds != null ? joinedGuilds.size() : 0);
        RelativeLayout relativeLayout = this.footerEmptyViewContainer;
        if (relativeLayout != null) {
            if (size == 0) {
                relativeLayout.setPadding(0, ViewUtils.dpToPx(169.0f), 0, 0);
                QUIEmptyState qUIEmptyState = this.emptyInnerView;
                if (qUIEmptyState != null) {
                    qUIEmptyState.setVisibility(0);
                }
                relativeLayout.setVisibility(0);
            } else {
                relativeLayout.setVisibility(8);
                QUIEmptyState qUIEmptyState2 = this.emptyInnerView;
                if (qUIEmptyState2 != null) {
                    qUIEmptyState2.setVisibility(8);
                }
                relativeLayout.setPadding(0, 0, 0, 0);
            }
        }
        GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = this.guildListView;
        ExpandableListAdapter expandableListAdapter = guildsPinnedHeaderExpandableListView != null ? guildsPinnedHeaderExpandableListView.getExpandableListAdapter() : null;
        GuildListAdapter guildListAdapter = expandableListAdapter instanceof GuildListAdapter ? (GuildListAdapter) expandableListAdapter : null;
        if (guildListAdapter != null) {
            guildListAdapter.i(size, createdGuilds, managedGuilds, joinedGuilds);
        }
        GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView2 = this.guildListView;
        Object expandableListAdapter2 = guildsPinnedHeaderExpandableListView2 != null ? guildsPinnedHeaderExpandableListView2.getExpandableListAdapter() : null;
        GuildListAdapter guildListAdapter2 = expandableListAdapter2 instanceof GuildListAdapter ? (GuildListAdapter) expandableListAdapter2 : null;
        if (guildListAdapter2 != null) {
            guildListAdapter2.j();
        }
    }
}
