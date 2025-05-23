package com.tencent.mobileqq.guild.setting.guildsetting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTokenTitleBarFragment;
import com.tencent.mobileqq.guild.data.GuildSharePageSource;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedMiscApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.jump.model.extras.JumpGuildNoticeMsg;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.media.widget.audiofaceview.e;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment;
import com.tencent.mobileqq.guild.setting.guildsetting.data.InviteFriendUpdateEvent;
import com.tencent.mobileqq.guild.setting.guildsetting.data.UpdateMemberDataEvent;
import com.tencent.mobileqq.guild.setting.guildsetting.data.UpdateUserInfoEvent;
import com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingHeadInfoPart;
import com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingItemPart;
import com.tencent.mobileqq.guild.setting.guildsetting.part.GuildSettingMemberPart;
import com.tencent.mobileqq.guild.setting.guildsetting.viewmodel.GuildSettingViewModel;
import com.tencent.mobileqq.guild.share.m;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ef1.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yz1.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0089\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\t\u0018\u0000 M2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u000f\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0006\u0010\u0019\u001a\u00020\u0018J\u001a\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u001c\u001a\u00020\u0004J\b\u0010\u001d\u001a\u00020\u0004H\u0016J\b\u0010\u001e\u001a\u00020\u0004H\u0016J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010$\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"0!j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\"`#H\u0016J\b\u0010&\u001a\u00020%H\u0016R\"\u0010.\u001a\u00020'8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001b\u00108\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107R\u001c\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010B\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010I\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/GuildSettingFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTokenTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "Jh", "Nh", "Oh", "Kh", "com/tencent/mobileqq/guild/setting/guildsetting/GuildSettingFragment$b", "Sh", "()Lcom/tencent/mobileqq/guild/setting/guildsetting/GuildSettingFragment$b;", "registerIoc", "Th", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "Mh", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initView", "rh", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "", "onBackEvent", "", "T", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "U", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "viewModel", "Lxz1/a;", "V", "Lkotlin/Lazy;", "Lh", "()Lxz1/a;", "guildSettingIoc", "W", "Ljava/util/List;", "parts", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "X", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Y", "Lcom/tencent/mobileqq/widget/listitem/QUISettingsRecyclerView;", "recycleView", "Lcom/tencent/mobileqq/guild/share/m;", "Z", "Lcom/tencent/mobileqq/guild/share/m;", "shareActionSheet", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "a0", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "<init>", "()V", "b0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildSettingFragment extends QQGuildTokenTitleBarFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: U, reason: from kotlin metadata */
    private GuildSettingViewModel viewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy guildSettingIoc;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private List<Part> parts;

    /* renamed from: X, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: Y, reason: from kotlin metadata */
    private QUISettingsRecyclerView recycleView;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private m shareActionSheet;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private FacadeArgsData facadeArgsData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildsetting/GuildSettingFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "", "a", "", "PARAM_FACADE_ARGS_DATA", "Ljava/lang/String;", "PARAM_SUPPORT_NEXT_JUMP", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull FacadeArgsData facadeArgsData) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
            Intent intent = new Intent();
            intent.putExtra("param_facade_args_data", facadeArgsData);
            qw1.b.r(intent, Reporters.f231995a.b().a("guild_manager").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, intent, GuildSettingFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u001a\u0010\u0007\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\f\u001a\u00020\b8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0003\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\r8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0017\u001a\u00020\u00138\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000e\u0010\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/mobileqq/guild/setting/guildsetting/GuildSettingFragment$b", "Lxz1/a;", "", "a", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "b", "Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "()Lcom/tencent/mobileqq/guild/setting/guildsetting/viewmodel/GuildSettingViewModel;", "guildSettingViewModel", "Lcom/tencent/mobileqq/app/QBaseActivity;", "c", "Lcom/tencent/mobileqq/app/QBaseActivity;", "getActivity", "()Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "d", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "()Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements xz1.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final GuildSettingViewModel guildSettingViewModel;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final QBaseActivity activity;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FacadeArgsData facadeArgsData;

        b(GuildSettingFragment guildSettingFragment) {
            this.guildId = guildSettingFragment.getGuildId();
            GuildSettingViewModel guildSettingViewModel = guildSettingFragment.viewModel;
            FacadeArgsData facadeArgsData = null;
            if (guildSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildSettingViewModel = null;
            }
            this.guildSettingViewModel = guildSettingViewModel;
            QBaseActivity qBaseActivity = guildSettingFragment.getQBaseActivity();
            Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
            this.activity = qBaseActivity;
            FacadeArgsData facadeArgsData2 = guildSettingFragment.facadeArgsData;
            if (facadeArgsData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            } else {
                facadeArgsData = facadeArgsData2;
            }
            this.facadeArgsData = facadeArgsData;
        }

        @Override // xz1.a
        @NotNull
        /* renamed from: a, reason: from getter */
        public GuildSettingViewModel getGuildSettingViewModel() {
            return this.guildSettingViewModel;
        }

        @Override // xz1.a
        @NotNull
        /* renamed from: c, reason: from getter */
        public FacadeArgsData getFacadeArgsData() {
            return this.facadeArgsData;
        }

        @Override // xz1.a
        @NotNull
        public QBaseActivity getActivity() {
            return this.activity;
        }

        @Override // xz1.a
        @NotNull
        public String getGuildId() {
            return this.guildId;
        }
    }

    public GuildSettingFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<b>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment$guildSettingIoc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildSettingFragment.b invoke() {
                GuildSettingFragment.b Sh;
                Sh = GuildSettingFragment.this.Sh();
                return Sh;
            }
        });
        this.guildSettingIoc = lazy;
        this.parts = new ArrayList();
    }

    private final void Jh() {
        ArrayList arrayList = new ArrayList();
        for (Part part : this.parts) {
            if (part instanceof com.tencent.mobileqq.guild.setting.guildsetting.part.a) {
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, ((com.tencent.mobileqq.guild.setting.guildsetting.part.a) part).D9());
            }
        }
        QUIListItemAdapter qUIListItemAdapter = this.adapter;
        if (qUIListItemAdapter != null) {
            Object[] array = arrayList.toArray(new Group[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            Group[] groupArr = (Group[]) array;
            qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
        }
    }

    private final void Kh() {
        View view;
        View view2 = this.P;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String str = this.guildId;
        HashMap hashMap = new HashMap(com.tencent.mobileqq.guild.report.b.d());
        Object parent = view2.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            view2 = view;
        }
        VideoReport.addToDetectionWhitelist(requireActivity);
        VideoReport.setPageId(view2, "pg_sgrp_manage");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(view2, str, hashMap);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        ImageView imageView = this.G;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("sgrp_channel_id", this.guildId);
        String currentUserType = ((IGuildFeedMiscApi) QRoute.api(IGuildFeedMiscApi.class)).getCurrentUserType(this.guildId);
        if (currentUserType == null) {
            currentUserType = "";
        }
        hashMap2.put("sgrp_user_type", currentUserType);
        hashMap2.put(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(GuildSharePageSource.MEMBER_LIST.ordinal()));
        Unit unit = Unit.INSTANCE;
        iGuildDTReportApi.setElementClickParams(imageView, "em_sgrp_share", hashMap2);
    }

    private final xz1.a Lh() {
        return (xz1.a) this.guildSettingIoc.getValue();
    }

    private final void Nh() {
        m mVar = this.shareActionSheet;
        if (mVar != null) {
            Intrinsics.checkNotNull(mVar);
            if (mVar.p()) {
                return;
            }
        }
        GuildSettingViewModel guildSettingViewModel = this.viewModel;
        if (guildSettingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildSettingViewModel = null;
        }
        IGProGuildInfo value = guildSettingViewModel.j2().getValue();
        if (value == null) {
            value = ch.L(this.guildId);
        }
        m mVar2 = new m(getQBaseActivity(), value, null, GuildSharePageSource.GUILD_PROFILE);
        this.shareActionSheet = mVar2;
        com.tencent.mobileqq.guild.share.util.c.c(mVar2, 1);
        m mVar3 = this.shareActionSheet;
        if (mVar3 != null) {
            mVar3.z();
        }
    }

    private final void Oh() {
        JumpGuildNoticeMsg jumpGuildNoticeMsg;
        FacadeArgsData facadeArgsData = this.facadeArgsData;
        if (facadeArgsData == null) {
            Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
            facadeArgsData = null;
        }
        if (facadeArgsData.C.getBoolean("PARAM_SUPPORT_NEXT_JUMP", false)) {
            FacadeArgsData facadeArgsData2 = this.facadeArgsData;
            if (facadeArgsData2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("facadeArgsData");
                facadeArgsData2 = null;
            }
            Parcelable parcelable = facadeArgsData2.C.getParcelable(JumpGuildParam.EXTRA_JUMP_NOTICE_MSG);
            if (parcelable instanceof JumpGuildNoticeMsg) {
                jumpGuildNoticeMsg = (JumpGuildNoticeMsg) parcelable;
            } else {
                jumpGuildNoticeMsg = null;
            }
            if (jumpGuildNoticeMsg != null) {
                QRouteApi api = QRoute.api(IGuildFeedLauncherApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IGuildFeedLauncherApi::class.java)");
                IGuildFeedLauncherApi.a.b((IGuildFeedLauncherApi) api, jumpGuildNoticeMsg, 0, 2, null);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(GuildSettingFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!o.c("fastClickGuard")) {
            this$0.Nh();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b Sh() {
        return new b(this);
    }

    private final void Th() {
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        RFWIocAbilityProvider.g().unregisterSingleIoc(getView(), xz1.a.class);
    }

    private final void registerIoc() {
        SimpleEventBus.getInstance().registerReceiver(this);
        RFWIocAbilityProvider.g().registerIoc(getView(), Lh(), xz1.a.class);
    }

    @NotNull
    public final QUISettingsRecyclerView Mh() {
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            return null;
        }
        return qUISettingsRecyclerView;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new GuildSettingHeadInfoPart(), new GuildSettingMemberPart(), new GuildSettingItemPart());
        this.parts = mutableListOf;
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    protected int getContentLayoutId() {
        return R.layout.f36;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(UpdateMemberDataEvent.class, UpdateUserInfoEvent.class, InviteFriendUpdateEvent.class);
        return arrayListOf;
    }

    @NotNull
    public final String getGuildId() {
        return this.guildId;
    }

    public final void initView() {
        FacadeArgsData facadeArgsData;
        GuildSettingViewModel guildSettingViewModel;
        IPerformanceReportTask g16;
        rh();
        setTitle(getResources().getString(R.string.f146590ul));
        wh(R.drawable.guild_token_share_icon, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildSettingFragment.Ph(GuildSettingFragment.this, view);
            }
        });
        View findViewById = this.P.findViewById(R.id.i4m);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.recycler_view)");
        this.recycleView = (QUISettingsRecyclerView) findViewById;
        this.adapter = new QUIListItemAdapter(null, false, true, 3, null);
        QUISettingsRecyclerView qUISettingsRecyclerView = this.recycleView;
        if (qUISettingsRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            qUISettingsRecyclerView = null;
        }
        qUISettingsRecyclerView.setLayoutManager(new e(getContext(), 1, false));
        QUISettingsRecyclerView qUISettingsRecyclerView2 = this.recycleView;
        if (qUISettingsRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
            qUISettingsRecyclerView2 = null;
        }
        qUISettingsRecyclerView2.setAdapter(this.adapter);
        Bundle arguments = getArguments();
        if (arguments != null) {
            facadeArgsData = (FacadeArgsData) arguments.getParcelable("param_facade_args_data");
        } else {
            facadeArgsData = null;
        }
        if (facadeArgsData != null) {
            this.facadeArgsData = facadeArgsData;
            String str = facadeArgsData.f227656e;
            Intrinsics.checkNotNullExpressionValue(str, "facadeArgsData.guildId");
            this.guildId = str;
            if (getActivity() != null && GuildSplitViewUtils.f235370a.n(requireActivity())) {
                guildSettingViewModel = (GuildSettingViewModel) ef1.c.INSTANCE.a(this, GuildSettingViewModel.class, this.guildId);
            } else {
                c.Companion companion = ef1.c.INSTANCE;
                FragmentActivity requireActivity = requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                guildSettingViewModel = (GuildSettingViewModel) companion.a(requireActivity, GuildSettingViewModel.class, this.guildId);
            }
            this.viewModel = guildSettingViewModel;
            if (guildSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildSettingViewModel = null;
            }
            LiveData<IGProGuildInfo> j26 = guildSettingViewModel.j2();
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment$initView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                    invoke2(iGProGuildInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                    if (iGProGuildInfo == null) {
                        Logger.f235387a.d().w("GuildSettingFragment", 1, "guildInfo is null, finish");
                        GuildSettingFragment.this.onBackEvent();
                    }
                }
            };
            j26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildSettingFragment.Qh(Function1.this, obj);
                }
            });
            GuildSettingViewModel guildSettingViewModel2 = this.viewModel;
            if (guildSettingViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                guildSettingViewModel2 = null;
            }
            LiveData<Boolean> v26 = guildSettingViewModel2.v2();
            LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
            final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.GuildSettingFragment$initView$3
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean isExitGuild) {
                    Intrinsics.checkNotNullExpressionValue(isExitGuild, "isExitGuild");
                    if (isExitGuild.booleanValue()) {
                        Logger.f235387a.d().w("GuildSettingFragment", 1, "isExitGuild , finish");
                        GuildSettingFragment.this.onBackEvent();
                    }
                }
            };
            v26.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.guildsetting.c
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    GuildSettingFragment.Rh(Function1.this, obj);
                }
            });
            Bundle arguments2 = getArguments();
            if (arguments2 != null && (g16 = qw1.b.g(arguments2, null, 1, null)) != null) {
                QUISettingsRecyclerView qUISettingsRecyclerView3 = this.recycleView;
                if (qUISettingsRecyclerView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("recycleView");
                    qUISettingsRecyclerView3 = null;
                }
                qw1.b.q(g16, qUISettingsRecyclerView3, null, 2, null);
                return;
            }
            return;
        }
        throw new IllegalStateException("GuildSettingFragment param_facade_args_data is null");
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Th();
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        GuildSettingViewModel guildSettingViewModel;
        boolean z16;
        Logger logger = Logger.f235387a;
        boolean z17 = true;
        if (QLog.isColorLevel()) {
            Logger.a d16 = logger.d();
            if (this.viewModel != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            d16.d("GuildSettingFragment", 2, "[onReceiveEvent] event " + event + ", isInit " + z16 + " ");
        }
        if (!(event instanceof UpdateMemberDataEvent)) {
            z17 = event instanceof InviteFriendUpdateEvent;
        }
        GuildSettingViewModel guildSettingViewModel2 = null;
        if (z17) {
            q qVar = q.f451648a;
            int b16 = qVar.b(bi.d());
            GuildSettingViewModel guildSettingViewModel3 = this.viewModel;
            if (guildSettingViewModel3 != null) {
                if (guildSettingViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    guildSettingViewModel2 = guildSettingViewModel3;
                }
                guildSettingViewModel2.e2(qVar.a(b16));
                return;
            }
            return;
        }
        if ((event instanceof UpdateUserInfoEvent) && (guildSettingViewModel = this.viewModel) != null) {
            if (guildSettingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildSettingViewModel2 = guildSettingViewModel;
            }
            guildSettingViewModel2.A2(((UpdateUserInfoEvent) event).getUserName());
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        registerIoc();
        Kh();
        GuildSplitViewUtils.f235370a.B(this.N);
        Oh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        Jh();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        this.J.a();
        this.J.setBackgroundResource(R.drawable.lvj);
    }
}
