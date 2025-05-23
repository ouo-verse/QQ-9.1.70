package com.tencent.mobileqq.guild;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.RelativeLayout;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment;
import com.tencent.mobileqq.activity.framebusiness.GuildInjectImpl;
import com.tencent.mobileqq.activity.framebusiness.controllerinject.TabDataHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.api.IGuildContactApi;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 X2\u00020\u00012\u00020\u0002:\u0001YB\u0007\u00a2\u0006\u0004\bV\u0010WJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u001a\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\n\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016Jd\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00132\u001a\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00172\u001a\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00172\u001a\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u0017H\u0007J\u000e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0010J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010\"\u001a\u00020\u0005H\u0014J\b\u0010#\u001a\u00020\u0005H\u0014J\b\u0010$\u001a\u00020\u0005H\u0016J\u0018\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u0007H\u0016R$\u0010.\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R$\u0010>\u001a\u0004\u0018\u0001078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R$\u0010F\u001a\u0004\u0018\u00010?8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER$\u0010N\u001a\u0004\u0018\u00010G8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010U\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bO\u0010P\u001a\u0004\bQ\u0010R\"\u0004\bS\u0010T\u00a8\u0006Z"}, d2 = {"Lcom/tencent/mobileqq/guild/GuildContactFragment;", "Lcom/tencent/mobileqq/activity/contacts/base/tabs/ContactsBaseFragment;", "Lcom/tencent/mobileqq/guild/p;", "Landroid/view/View;", "view", "", "Mh", "", "from", "Jh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "uh", "getScrollableView", "", "tabChange", "rh", "", "account", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "Lkotlin/collections/ArrayList;", "createdGuilds", "managedGuilds", "joinedGuilds", "Ph", "isSuccess", "Qh", "qh", "doOnDestroy", "refresh", "resetData", "ph", "Ah", "wh", "isDefaultTheme", "tabHeight", OcrConfig.CHINESE, "N", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;", "P", "Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;", "getGuildListView", "()Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;", "setGuildListView", "(Lcom/tencent/mobileqq/guild/GuildsPinnedHeaderExpandableListView;)V", "guildListView", "Landroid/widget/RelativeLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/RelativeLayout;", "getFooterEmptyViewContainer", "()Landroid/widget/RelativeLayout;", "setFooterEmptyViewContainer", "(Landroid/widget/RelativeLayout;)V", "footerEmptyViewContainer", "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "getEmptyInnerView", "()Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;", "setEmptyInnerView", "(Lcom/tencent/biz/qui/quiemptystate/QUIEmptyState;)V", "emptyInnerView", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "getGProService", "()Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Oh", "(Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;)V", "gProService", "T", "Z", "Lh", "()Z", "Nh", "(Z)V", "isFirstLoadData", "<init>", "()V", "U", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class GuildContactFragment extends ContactsBaseFragment implements p {

    /* renamed from: N, reason: from kotlin metadata */
    private View contentView;

    /* renamed from: P, reason: from kotlin metadata */
    private GuildsPinnedHeaderExpandableListView guildListView;

    /* renamed from: Q, reason: from kotlin metadata */
    private RelativeLayout footerEmptyViewContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private QUIEmptyState emptyInnerView;

    /* renamed from: S, reason: from kotlin metadata */
    private IGPSService gProService;

    /* renamed from: T, reason: from kotlin metadata */
    private volatile boolean isFirstLoadData = true;

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(int from) {
        IGPSService iGPSService = this.gProService;
        if (iGPSService != null) {
            String account = this.E.getAccount();
            Intrinsics.checkNotNullExpressionValue(account, "mApp.account");
            iGPSService.getGuildsInContact(new b(this, from, account));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(View view) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            if (TabDataHelper.isTabFull(BaseApplication.context, peekAppRuntime.getAccount()) && !GuildInjectImpl.L()) {
                QQToast.makeText(BaseApplication.context, R.string.f131320e, 0).show();
            } else {
                com.tencent.mobileqq.guild.report.b.g("connect_pindao", "GuildContactFragment");
                ((IGuildContactApi) QRoute.api(IGuildContactApi.class)).jumpGuildTabDiscoverPage();
            }
        }
    }

    private final void Mh(View view) {
        VideoReport.setElementId(view, "em_bas_contanct_channel_tab");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.reportEvent("dt_imp", view, null);
    }

    /* renamed from: Lh, reason: from getter */
    public final boolean getIsFirstLoadData() {
        return this.isFirstLoadData;
    }

    public final void Nh(boolean z16) {
        this.isFirstLoadData = z16;
    }

    public final void Oh(IGPSService iGPSService) {
        this.gProService = iGPSService;
    }

    public final void Ph(String account, ArrayList<IGProGuildInfo> createdGuilds, ArrayList<IGProGuildInfo> managedGuilds, ArrayList<IGProGuildInfo> joinedGuilds) {
        Intrinsics.checkNotNullParameter(account, "account");
        if (!TextUtils.equals(account, this.E.getAccount())) {
            QLog.i("GuildContactFragment", 1, "updateGuildData, but not current account, return");
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
        if (this.isFirstLoadData) {
            GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView2 = this.guildListView;
            Object expandableListAdapter2 = guildsPinnedHeaderExpandableListView2 != null ? guildsPinnedHeaderExpandableListView2.getExpandableListAdapter() : null;
            GuildListAdapter guildListAdapter2 = expandableListAdapter2 instanceof GuildListAdapter ? (GuildListAdapter) expandableListAdapter2 : null;
            if (guildListAdapter2 != null) {
                guildListAdapter2.j();
            }
            this.isFirstLoadData = false;
        }
    }

    public final void Qh(boolean isSuccess) {
        ContactsBaseFragment.c cVar = this.C;
        if (cVar != null) {
            cVar.c(th(), isSuccess, null);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment, com.tencent.mobileqq.activity.contacts.base.h.a
    public View getScrollableView() {
        return this.guildListView;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void qh(boolean tabChange) {
        QLog.i("GuildContactFragment", 1, "doOnPause:" + hashCode() + "\uff0c isFirstLoadData:" + this.isFirstLoadData);
        if (this.isFirstLoadData) {
            return;
        }
        GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = this.guildListView;
        ExpandableListAdapter expandableListAdapter = guildsPinnedHeaderExpandableListView != null ? guildsPinnedHeaderExpandableListView.getExpandableListAdapter() : null;
        GuildListAdapter guildListAdapter = expandableListAdapter instanceof GuildListAdapter ? (GuildListAdapter) expandableListAdapter : null;
        if (guildListAdapter != null) {
            guildListAdapter.k();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void resetData() {
        final GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = this.guildListView;
        if (guildsPinnedHeaderExpandableListView != null) {
            ((IGuildDelayInitializeService) bz.b(IGuildDelayInitializeService.class)).scheduleTask(new IGuildDelayInitializeService.InitializeTask("GuildContactFragment resetData", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.GuildContactFragment$resetData$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    QQAppInterface mApp;
                    GuildContactFragment.this.Nh(true);
                    Logger logger = Logger.f235387a;
                    GuildContactFragment guildContactFragment = GuildContactFragment.this;
                    logger.d().a("GuildContactFragment", 1, "resetData init gProService success, isFirstLoadData:" + guildContactFragment.getIsFirstLoadData() + ", " + guildContactFragment.hashCode());
                    IRuntimeService b16 = bz.b(IGPSService.class);
                    GuildContactFragment guildContactFragment2 = GuildContactFragment.this;
                    GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView2 = guildsPinnedHeaderExpandableListView;
                    IGPSService service = (IGPSService) b16;
                    guildContactFragment2.Oh(service);
                    Context context = guildsPinnedHeaderExpandableListView2.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "context");
                    mApp = ((ContactsBaseFragment) guildContactFragment2).E;
                    Intrinsics.checkNotNullExpressionValue(mApp, "mApp");
                    Intrinsics.checkNotNullExpressionValue(service, "service");
                    guildsPinnedHeaderExpandableListView2.setAdapter(new GuildListAdapter(context, mApp, service, guildsPinnedHeaderExpandableListView2, "last_expand_of_guild_tab", guildContactFragment2));
                    GuildContactFragment.this.Jh(3);
                }
            }));
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected View uh(LayoutInflater inflater, Bundle savedInstanceState) {
        QUIButton button;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        RelativeLayout relativeLayout = null;
        View rootView = inflater.inflate(R.layout.f167250cw, (ViewGroup) null);
        final GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = (GuildsPinnedHeaderExpandableListView) rootView.findViewById(R.id.f17610r);
        guildsPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
        guildsPinnedHeaderExpandableListView.mForContacts = true;
        guildsPinnedHeaderExpandableListView.setOnScrollListener(this);
        if (this.footerEmptyViewContainer == null) {
            View inflate = LayoutInflater.from(guildsPinnedHeaderExpandableListView.getContext()).inflate(R.layout.f167249b1, (ViewGroup) guildsPinnedHeaderExpandableListView, false);
            RelativeLayout relativeLayout2 = inflate instanceof RelativeLayout ? (RelativeLayout) inflate : null;
            if (relativeLayout2 != null) {
                QUIEmptyState.Builder imageType = new QUIEmptyState.Builder(BaseApplication.context).setImageType(16);
                String string = relativeLayout2.getResources().getString(R.string.f1312104);
                Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.st\u2026.empty_guilds_in_contact)");
                QUIEmptyState.Builder backgroundColorType = imageType.setTitle(string).setHalfScreenState(true).setBackgroundColorType(0);
                String string2 = relativeLayout2.getResources().getString(R.string.f131310d);
                Intrinsics.checkNotNullExpressionValue(string2, "resources.getString(R.string.go_to_guild_tab)");
                QUIEmptyState build = backgroundColorType.setButton(string2, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        GuildContactFragment.Kh(view);
                    }
                }).build();
                this.emptyInnerView = build;
                if (build != null && (button = build.getButton()) != null) {
                    VideoReport.setElementId(button, "em_to_discover");
                    VideoReport.setElementExposePolicy(button, ExposurePolicy.REPORT_ALL);
                    VideoReport.setElementClickPolicy(button, ClickPolicy.REPORT_ALL);
                    VideoReport.setElementEndExposePolicy(button, EndExposurePolicy.REPORT_ALL);
                }
                relativeLayout2.addView(this.emptyInnerView);
                relativeLayout = relativeLayout2;
            }
            this.footerEmptyViewContainer = relativeLayout;
            guildsPinnedHeaderExpandableListView.addFooterView(relativeLayout);
        }
        ((IGuildDelayInitializeService) bz.b(IGuildDelayInitializeService.class)).scheduleTask(new IGuildDelayInitializeService.InitializeTask("GuildContactFragment getView", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.GuildContactFragment$getView$1$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                QQAppInterface mApp;
                IRuntimeService b16 = bz.b(IGPSService.class);
                GuildContactFragment guildContactFragment = GuildContactFragment.this;
                GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView2 = guildsPinnedHeaderExpandableListView;
                IGPSService service = (IGPSService) b16;
                QLog.i("GuildContactFragment", 1, "getView init gProService success");
                guildContactFragment.Oh(service);
                Context context = guildsPinnedHeaderExpandableListView2.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                mApp = ((ContactsBaseFragment) guildContactFragment).E;
                Intrinsics.checkNotNullExpressionValue(mApp, "mApp");
                Intrinsics.checkNotNullExpressionValue(service, "service");
                Intrinsics.checkNotNullExpressionValue(guildsPinnedHeaderExpandableListView2, "this");
                guildsPinnedHeaderExpandableListView2.setAdapter(new GuildListAdapter(context, mApp, service, guildsPinnedHeaderExpandableListView2, "last_expand_of_guild_tab", guildContactFragment));
            }
        }));
        this.guildListView = guildsPinnedHeaderExpandableListView;
        this.contentView = rootView;
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        return rootView;
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void wh() {
        super.wh();
        QLog.i("GuildContactFragment", 1, "onBeforeAccountChanged:" + hashCode());
        GuildsPinnedHeaderExpandableListView guildsPinnedHeaderExpandableListView = this.guildListView;
        ExpandableListAdapter expandableListAdapter = guildsPinnedHeaderExpandableListView != null ? guildsPinnedHeaderExpandableListView.getExpandableListAdapter() : null;
        GuildListAdapter guildListAdapter = expandableListAdapter instanceof GuildListAdapter ? (GuildListAdapter) expandableListAdapter : null;
        if (guildListAdapter != null) {
            guildListAdapter.k();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void zh(boolean isDefaultTheme, int tabHeight) {
        super.zh(isDefaultTheme, tabHeight);
        QUIEmptyState qUIEmptyState = this.emptyInnerView;
        if (qUIEmptyState != null) {
            qUIEmptyState.onThemeChanged();
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void refresh() {
        Jh(2);
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void rh(boolean tabChange) {
        Jh(1);
        View view = this.contentView;
        if (view != null) {
            Mh(view);
        }
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void Ah() {
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    public void doOnDestroy() {
    }

    @Override // com.tencent.mobileqq.activity.contacts.base.tabs.ContactsBaseFragment
    protected void ph() {
    }
}
