package com.tencent.mobileqq.guild.setting.guildsetting.viewmodel;

import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleUtils;
import com.tencent.mobileqq.guild.setting.guildmanage.QQGuildManageFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.fragment.GuildModifyMemberNameAndAvatarFragment;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vaswebviewplugin.MessageRoamJsPlugin;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.util.QQToastUtil;
import com.tencent.util.URLUtil;
import com.tencent.widget.ActionSheet;
import ef1.c;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.dv;

/* compiled from: P */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 D2\u00020\u0001:\u0001EB\u0017\u0012\u0006\u0010&\u001a\u00020!\u0012\u0006\u0010+\u001a\u00020\u0004\u00a2\u0006\u0004\bB\u0010CJ(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u0010\u0010\u000f\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rJ\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0004J&\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J(\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\rJ\u0016\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0002J\u000e\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001dJ\u0006\u0010 \u001a\u00020\tR\u0017\u0010&\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010+\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\"\u00102\u001a\u00020\r8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0016\u00104\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u0010(R0\u0010:\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020605j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u000206`78\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010A\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/l;", "Lef1/b;", "Landroid/view/View;", "view", "", "url", "", "isSDKUserType", "isGuildNamedChannel", "", SemanticAttributes.DbSystemValues.H2, "Z1", "j2", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "mGuildInfo", "i2", "e2", "c2", "mOperationHelperUrl", "f2", "X1", "U1", "v", "userName", "d2", "W1", "b2", "g2", "Q1", "Lcom/tencent/mobileqq/guild/profile/profilecard/main/l;", "showToastModel", "l2", "R1", "Lcom/tencent/mobileqq/app/QBaseActivity;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "D", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "E", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "getGuildInfo", "()Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "k2", "(Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;)V", "guildInfo", UserInfo.SEX_FEMALE, "channelId", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "G", "Ljava/util/HashMap;", "mReportParams", "Lcom/tencent/widget/ActionSheet;", "H", "Lcom/tencent/widget/ActionSheet;", "mExitActionSheet", "I", "Z", "mExitReportAdded", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Ljava/lang/String;)V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class l extends ef1.b {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final QBaseActivity activity;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String guildId;

    /* renamed from: E, reason: from kotlin metadata */
    public IGProGuildInfo guildInfo;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String channelId;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final HashMap<String, Object> mReportParams;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ActionSheet mExitActionSheet;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean mExitReportAdded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/l$a;", "", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "guildId", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/l;", "a", "TAG", "Ljava/lang/String;", "URL_MANAGE_RECORD", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.l$a$a, reason: collision with other inner class name */
        /* loaded from: classes14.dex */
        public static final class C7902a implements ViewModelProvider.Factory {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ViewModelStoreOwner f234550a;

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ QBaseActivity f234551b;

            /* renamed from: c, reason: collision with root package name */
            final /* synthetic */ String f234552c;

            public C7902a(ViewModelStoreOwner viewModelStoreOwner, QBaseActivity qBaseActivity, String str) {
                this.f234550a = viewModelStoreOwner;
                this.f234551b = qBaseActivity;
                this.f234552c = str;
            }

            @Override // androidx.lifecycle.ViewModelProvider.Factory
            @NotNull
            public <T extends ViewModel> T create(@NotNull Class<T> p06) {
                Intrinsics.checkNotNullParameter(p06, "p0");
                TimedValue timedValue = new TimedValue(new l(this.f234551b, this.f234552c), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
                }
                return (T) timedValue.getValue();
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final l a(@NotNull ViewModelStoreOwner owner, @NotNull String guildId, @NotNull QBaseActivity activity) {
            Intrinsics.checkNotNullParameter(owner, "owner");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(activity, "activity");
            c.Companion companion = ef1.c.INSTANCE;
            ViewModel viewModel = new ViewModelProvider(owner, new C7902a(owner, activity, guildId)).get(l.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
            return (l) viewModel;
        }

        Companion() {
        }
    }

    public l(@NotNull QBaseActivity activity, @NotNull String guildId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        this.activity = activity;
        this.guildId = guildId;
        this.channelId = "";
        this.mReportParams = new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(l this$0, int i3, String errMsg, IGProSecurityResult iGProSecurityResult) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("GuildSettingJumpViewModel", 1, "exitGuild failed result: " + i3 + ", msg: " + errMsg);
        if (i3 == 0 && ch.p(iGProSecurityResult)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.k
                @Override // java.lang.Runnable
                public final void run() {
                    l.T1();
                }
            }, 200L);
            return;
        }
        if (i3 == 26001) {
            ((IGPSService) ch.R0(IGPSService.class)).refreshGuildList(true);
        }
        com.tencent.mobileqq.guild.profile.profilecard.main.l lVar = new com.tencent.mobileqq.guild.profile.profilecard.main.l();
        lVar.f(i3);
        lVar.h(cb.d(errMsg, BaseApplication.getContext().getString(R.string.f143580mg)));
        lVar.g(iGProSecurityResult);
        this$0.l2(lVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1() {
        QQToastUtil.showQQToast(2, HardCodeUtil.qqStr(R.string.f143590mh));
    }

    private final void Z1() {
        ActionSheet actionSheet = this.mExitActionSheet;
        if (actionSheet != null) {
            Intrinsics.checkNotNull(actionSheet);
            if (actionSheet.isShowing()) {
                return;
            }
        }
        if (this.mExitActionSheet == null) {
            ActionSheet create = ActionSheet.create(this.activity);
            this.mExitActionSheet = create;
            Intrinsics.checkNotNull(create);
            create.setMainTitle(R.string.f143600mi);
            ActionSheet actionSheet2 = this.mExitActionSheet;
            Intrinsics.checkNotNull(actionSheet2);
            actionSheet2.addButton(R.string.f142540jn, 3, R.id.wzx);
            ActionSheet actionSheet3 = this.mExitActionSheet;
            Intrinsics.checkNotNull(actionSheet3);
            actionSheet3.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.i
                @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
                public final void onClick(View view, int i3) {
                    l.a2(l.this, view, i3);
                }
            });
            ActionSheet actionSheet4 = this.mExitActionSheet;
            Intrinsics.checkNotNull(actionSheet4);
            actionSheet4.addCancelButton(this.activity.getResources().getString(R.string.f140850f3));
        }
        ActionSheet actionSheet5 = this.mExitActionSheet;
        Intrinsics.checkNotNull(actionSheet5);
        actionSheet5.show();
        if (!this.mExitReportAdded) {
            Q1();
            this.mExitReportAdded = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a2(l this$0, View view, int i3) {
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == R.id.wzx) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            si1.a.f433837a.b(this$0.guildId, "", 2);
            this$0.R1();
            ActionSheet actionSheet = this$0.mExitActionSheet;
            Intrinsics.checkNotNull(actionSheet);
            actionSheet.dismiss();
        }
    }

    private final void h2(View view, String url, boolean isSDKUserType, boolean isGuildNamedChannel) {
        VideoReport.reportEvent("clck", view, this.mReportParams);
        ch.j1(this.activity, U1(url, isSDKUserType, isGuildNamedChannel, getGuildInfo()), getGuildInfo().getGuildID());
    }

    private final void j2() {
        List<IGProChannelInfo> channelList = ((IGuildAdapterService) ch.R0(IGuildAdapterService.class)).getChannelList(getGuildInfo().getGuildID(), true);
        if (TextUtils.isEmpty(this.channelId) && channelList != null && !channelList.isEmpty()) {
            String channelUin = channelList.get(0).getChannelUin();
            Intrinsics.checkNotNullExpressionValue(channelUin, "channelList[0].channelUin");
            this.channelId = channelUin;
        }
    }

    public final void Q1() {
        VideoReport.addToDetectionWhitelist(this.activity);
        ActionSheet actionSheet = this.mExitActionSheet;
        Intrinsics.checkNotNull(actionSheet);
        VideoReport.setPageId(actionSheet.getRootView(), "pg_sgrp_manage");
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        hashMap.putAll(com.tencent.mobileqq.guild.report.b.d());
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ActionSheet actionSheet2 = this.mExitActionSheet;
        Intrinsics.checkNotNull(actionSheet2);
        iGuildDTReportApi.setGuildPageParams(actionSheet2.getRootView(), this.guildId, hashMap);
        ActionSheet actionSheet3 = this.mExitActionSheet;
        Intrinsics.checkNotNull(actionSheet3);
        View findViewById = actionSheet3.findViewById(R.id.action_sheet_btnCancel);
        VideoReport.setElementId(findViewById, "em_sgrp_set_confirm");
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(findViewById, exposurePolicy);
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(findViewById, clickPolicy);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("quit_result", 2);
        hashMap2.put("pgid", "pg_sgrp_manage");
        VideoReport.setElementParam(findViewById, "quit_result", 2);
        VideoReport.reportEvent("clck", findViewById, hashMap2);
        ActionSheet actionSheet4 = this.mExitActionSheet;
        Intrinsics.checkNotNull(actionSheet4);
        View findViewById2 = actionSheet4.findViewById(R.id.wzx);
        VideoReport.setElementId(findViewById2, "em_sgrp_set_confirm");
        VideoReport.setElementExposePolicy(findViewById2, exposurePolicy);
        VideoReport.setElementClickPolicy(findViewById2, clickPolicy);
        VideoReport.setElementParam(findViewById2, "quit_result", 1);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("quit_result", 1);
        hashMap3.put("pgid", "pg_sgrp_manage");
        VideoReport.reportEvent("clck", findViewById2, hashMap3);
    }

    public final void R1() {
        ((IGPSService) ch.R0(IGPSService.class)).removeGuild(this.guildId, new dv() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.j
            @Override // wh2.dv
            public final void a(int i3, String str, IGProSecurityResult iGProSecurityResult) {
                l.S1(l.this, i3, str, iGProSecurityResult);
            }
        });
    }

    @Nullable
    public final String U1(@NotNull String url, boolean isSDKUserType, boolean isGuildNamedChannel, @NotNull IGProGuildInfo mGuildInfo) {
        String str;
        String valueOf;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(mGuildInfo, "mGuildInfo");
        if (isGuildNamedChannel) {
            str = WadlProxyConsts.CHANNEL;
        } else {
            str = "guildId";
        }
        if (isSDKUserType) {
            valueOf = String.valueOf(mGuildInfo.getUserType());
        } else {
            valueOf = String.valueOf(v.b(mGuildInfo.getUserType()));
        }
        String addParameter = URLUtil.addParameter(url, str, mGuildInfo.getGuildID());
        Intrinsics.checkNotNullExpressionValue(addParameter, "addParameter(url, keyGuildId, mGuildInfo.guildID)");
        String addParameter2 = URLUtil.addParameter(addParameter, "channelName", mGuildInfo.getGuildName());
        Intrinsics.checkNotNullExpressionValue(addParameter2, "addParameter(url, \"chann\u2026e\", mGuildInfo.guildName)");
        String addParameter3 = URLUtil.addParameter(addParameter2, MessageRoamJsPlugin.USERTYPE, valueOf);
        Intrinsics.checkNotNullExpressionValue(addParameter3, "addParameter(url, \"userType\", userType)");
        QLog.i("GuildSettingJumpViewModel", 2, "getH5StartUrl:" + addParameter3);
        return addParameter3;
    }

    public final void W1(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.reportEvent("clck", view, this.mReportParams);
        QBaseActivity qBaseActivity = this.activity;
        String guildID = getGuildInfo().getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.guildID");
        GuildLevelRoleUtils.a(qBaseActivity, guildID, 1);
    }

    public final void X1(@NotNull View view, @NotNull String url, boolean isSDKUserType, boolean isGuildNamedChannel) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        VideoReport.reportEvent("clck", view, this.mReportParams);
        if (this.guildInfo == null) {
            QLog.w("GuildSettingJumpViewModel", 1, "mGuildInfo is null.");
        } else {
            ch.j1(this.activity, U1(url, isSDKUserType, isGuildNamedChannel, getGuildInfo()), this.guildId);
        }
    }

    public final void b2(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (QQGuildUIUtil.v()) {
            return;
        }
        VideoReport.reportEvent("clck", v3, this.mReportParams);
        Z1();
    }

    public final void c2(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (QQGuildUIUtil.v()) {
            return;
        }
        QPublicFragmentActivity.b.b(this.activity, QQGuildManageFragment.jj(getGuildInfo(), 0, 1), QPublicFragmentActivity.class, QQGuildManageFragment.class);
        VideoReport.reportEvent("clck", view, this.mReportParams);
    }

    public final void d2(@NotNull View v3, @NotNull String userName) {
        Intrinsics.checkNotNullParameter(v3, "v");
        Intrinsics.checkNotNullParameter(userName, "userName");
        if (QQGuildUIUtil.v()) {
            return;
        }
        VideoReport.reportEvent("clck", v3, this.mReportParams);
        GuildModifyMemberNameAndAvatarFragment.INSTANCE.a(this.activity, this.guildId, userName);
    }

    public final void e2(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (QQGuildUIUtil.v()) {
            return;
        }
        QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
        IGuildFeedLauncherApi.a.b((IGuildFeedLauncherApi) api, new JumpGuildNoticeMsg(0, this.guildId, null, null, false, 0, 61, null), 0, 2, null);
        VideoReport.reportEvent("clck", view, this.mReportParams);
    }

    public final void f2(@NotNull View view, @NotNull String mOperationHelperUrl) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mOperationHelperUrl, "mOperationHelperUrl");
        if (QQGuildUIUtil.v()) {
            return;
        }
        h2(view, mOperationHelperUrl, true, false);
    }

    public final void g2(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        if (QQGuildUIUtil.v()) {
            return;
        }
        VideoReport.reportEvent("clck", v3, this.mReportParams);
        if (TextUtils.isEmpty(this.channelId)) {
            j2();
        }
        ((IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class)).reportGuild(this.activity, this.guildId, this.channelId, TVKEventId.PLAYER_STATE_START_BUFFERING, true);
    }

    @NotNull
    public final IGProGuildInfo getGuildInfo() {
        IGProGuildInfo iGProGuildInfo = this.guildInfo;
        if (iGProGuildInfo != null) {
            return iGProGuildInfo;
        }
        Intrinsics.throwUninitializedPropertyAccessException("guildInfo");
        return null;
    }

    public final void i2(@Nullable IGProGuildInfo mGuildInfo) {
        if (mGuildInfo == null && ch.L(this.guildId) == null) {
            return;
        }
        if (mGuildInfo == null) {
            mGuildInfo = ch.L(this.guildId);
            Intrinsics.checkNotNullExpressionValue(mGuildInfo, "getGuildInfo(guildId)");
        }
        k2(mGuildInfo);
    }

    public final void k2(@NotNull IGProGuildInfo iGProGuildInfo) {
        Intrinsics.checkNotNullParameter(iGProGuildInfo, "<set-?>");
        this.guildInfo = iGProGuildInfo;
    }

    public final void l2(@NotNull com.tencent.mobileqq.guild.profile.profilecard.main.l showToastModel) {
        Intrinsics.checkNotNullParameter(showToastModel, "showToastModel");
        if (showToastModel.d()) {
            ch.e1(2, showToastModel.c());
        } else {
            SecurityTipHelperKt.F(this.activity, showToastModel.a(), showToastModel.c(), showToastModel.b(), null, null, 48, null);
        }
    }
}
