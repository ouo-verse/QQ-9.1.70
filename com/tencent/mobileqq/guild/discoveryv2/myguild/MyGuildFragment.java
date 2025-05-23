package com.tencent.mobileqq.guild.discoveryv2.myguild;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.biz.richframework.ioc.RFWIocAbilityProvider;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDelayInitializeService;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.component.animator.ScanningLightView;
import com.tencent.mobileqq.guild.discoveryv2.myguild.e;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bz;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.GuildSmartRefreshLayout;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.bf;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statustitle.AfterAccountChanged;
import com.tencent.mobileqq.statustitle.BeforeAccountChanged;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqmini.sdk.plugins.UIJsPlugin;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.ca;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 j2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0002klB\u0007\u00a2\u0006\u0004\bh\u0010iJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J&\u0010\u0011\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u001a\u001a\u00020\rH\u0014J\b\u0010\u001b\u001a\u00020\rH\u0014J\b\u0010\u001c\u001a\u00020\rH\u0014J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J&\u0010$\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010%\u001a\u00020\u0004H\u0016J\u0010\u0010'\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\rH\u0014J\u0006\u0010(\u001a\u00020\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ,\u0010/\u001a\u00020\u00042\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\t2\b\u0010.\u001a\u0004\u0018\u00010-J\b\u00100\u001a\u00020\u0004H\u0016J\b\u00101\u001a\u00020\u0004H\u0016J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J$\u00107\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030504j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000305`6H\u0016J\u0012\u00108\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u00109\u001a\u00020\u0006H\u0016R\u0017\u0010?\u001a\u00020:8\u0006\u00a2\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>R\u0017\u0010E\u001a\u00020@8\u0006\u00a2\u0006\f\n\u0004\bA\u0010B\u001a\u0004\bC\u0010DR\"\u0010\u000e\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bF\u0010G\u001a\u0004\bH\u0010I\"\u0004\bJ\u0010KR$\u0010S\u001a\u0004\u0018\u00010L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0016\u0010[\u001a\u00020X8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0018\u0010_\u001a\u0004\u0018\u00010\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0016\u0010g\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010]\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "ii", "", "hasTopGuild", WidgetCacheLunarData.JI, "", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/j;", "ai", "addedGuilds", "", "refreshNum", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/d;", "fetchDataCallback", "Yh", "Lcom/tencent/mobileqq/statustitle/BeforeAccountChanged;", "event", "ci", "Lcom/tencent/mobileqq/statustitle/AfterAccountChanged;", "bi", "Landroid/view/View;", "contentView", "Rh", "getContentLayoutId", "qh", "ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "resId", "yh", "fi", "Sh", "myGuildList", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/aa;", "myGuildRecommendList", "Ljava/lang/Runnable;", "commitCallback", "ei", "rh", "onPostThemeChanged", UIJsPlugin.EVENT_HIDE_LOADING, UIJsPlugin.EVENT_SHOW_LOADING, "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "onReceiveEvent", "onBackEvent", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "T", "Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "Wh", "()Lcom/tencent/mobileqq/guild/discoveryv2/content/base/f;", "loadMoreAdapter", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter;", "U", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter;", "Xh", "()Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildAdapter;", "myGuildAdapter", "V", "I", "Zh", "()I", "di", "(I)V", "Lvp1/ca;", "W", "Lvp1/ca;", "Vh", "()Lvp1/ca;", "setBinding", "(Lvp1/ca;)V", "binding", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/z;", "X", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/z;", "guildObserver", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/u;", "Y", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/u;", "gServiceObserver", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "Z", "Lcom/tencent/mobileqq/qqguildsdk/api/IGPSService;", "gProService", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/STATE;", "a0", "Lcom/tencent/mobileqq/guild/discoveryv2/myguild/STATE;", "curState", "b0", "Ljava/lang/Boolean;", "c0", "inGuildSubTab", "<init>", "()V", "d0", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class MyGuildFragment extends QQGuildTitleBarFragment implements SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.content.base.f loadMoreAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final MyGuildAdapter myGuildAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private int refreshNum;

    /* renamed from: W, reason: from kotlin metadata */
    @Nullable
    private ca binding;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private z guildObserver;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private u gServiceObserver;

    /* renamed from: Z, reason: from kotlin metadata */
    @Nullable
    private IGPSService gProService;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private STATE curState;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean hasTopGuild;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean inGuildSubTab;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u00e6\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment$b;", "Lzu1/b;", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public interface b extends zu1.b<Boolean> {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.OnScrollListener {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traversePage(recyclerView);
            }
        }
    }

    public MyGuildFragment() {
        com.tencent.mobileqq.guild.discoveryv2.content.base.f fVar = new com.tencent.mobileqq.guild.discoveryv2.content.base.f();
        fVar.registerLoadMoreListener(new d(fVar, this));
        this.loadMoreAdapter = fVar;
        this.myGuildAdapter = new MyGuildAdapter(new a(this));
        this.guildObserver = new z(this);
        this.gServiceObserver = new u(this);
        this.curState = STATE.INIT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(MyGuildFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((IGuildMainFrameApi) QRoute.api(IGuildMainFrameApi.class)).doOpenCreateGuild(this$0.getActivity(), view, 5);
        VideoReport.setElementId(view, "em_sgrp_head_create");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(MyGuildFragment this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.refreshNum = 0;
        this$0.Sh(new an(this$0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Qh(MyGuildFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        return this$0.inGuildSubTab;
    }

    private final void Rh(View contentView) {
        FragmentActivity activity;
        if (!this.inGuildSubTab && (activity = getActivity()) != null) {
            VideoReport.addToDetectionWhitelist(activity);
            VideoReport.setPageId(contentView, "pg_sgrp_discover_mine_join_channel");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(com.tencent.mobileqq.guild.discoveryv2.myguild.d fetchDataCallback) {
        Intrinsics.checkNotNullParameter(fetchDataCallback, "$fetchDataCallback");
        fetchDataCallback.success();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Uh(com.tencent.mobileqq.guild.discoveryv2.myguild.d fetchDataCallback) {
        Intrinsics.checkNotNullParameter(fetchDataCallback, "$fetchDataCallback");
        fetchDataCallback.success();
    }

    private final void Yh(List<MyGuildData> addedGuilds, int refreshNum, com.tencent.mobileqq.guild.discoveryv2.myguild.d fetchDataCallback) {
        IGPSService iGPSService = this.gProService;
        if (iGPSService != null) {
            bf bfVar = new bf();
            bfVar.a().i(0);
            bfVar.a().j("");
            bfVar.g(mh1.b.f416778a.a(5));
            bfVar.f(refreshNum);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("Guild.discovery.MyGuildFragment", "getDiscoverRecommendDetail request req: " + bfVar);
            }
            iGPSService.getCategoryPageGuilds(bfVar, new com.tencent.mobileqq.guild.discoveryv2.myguild.c(addedGuilds, this, fetchDataCallback));
        }
    }

    private final List<MyGuildData> ai() {
        List<MyGuildData> list;
        List<IGProGuildInfo> sortedGuildList;
        List<String> list2;
        boolean z16;
        List<MyGuildData> emptyList;
        if (this.inGuildSubTab) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        IGPSService iGPSService = this.gProService;
        if (iGPSService != null && (sortedGuildList = iGPSService.getSortedGuildList()) != null && (!sortedGuildList.isEmpty())) {
            IGPSService iGPSService2 = this.gProService;
            if (iGPSService2 != null) {
                list2 = iGPSService2.getTopGuildList();
            } else {
                list2 = null;
            }
            for (IGProGuildInfo it : sortedGuildList) {
                String guildID = it.getGuildID();
                Intrinsics.checkNotNullExpressionValue(guildID, "it.guildID");
                String avatarUrl = it.getAvatarUrl(140);
                Intrinsics.checkNotNullExpressionValue(avatarUrl, "it.getAvatarUrl(IGuiildAvatarUrlType.SIZE_140)");
                String guildName = it.getGuildName();
                Intrinsics.checkNotNullExpressionValue(guildName, "it.guildName");
                String profile = it.getProfile();
                Intrinsics.checkNotNullExpressionValue(profile, "it.profile");
                if (it.getUserType() == 2) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                e.Companion companion = e.INSTANCE;
                String b16 = companion.b(it.getMedalInfoList());
                Intrinsics.checkNotNullExpressionValue(it, "it");
                arrayList.add(new MyGuildData(guildID, avatarUrl, guildName, profile, z16, b16, companion.a(list2, it)));
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        return list;
    }

    private final void bi(AfterAccountChanged event) {
        QLog.i("Guild.discovery.MyGuildFragment", 1, "handleAfterAccountChanged");
        ((IGuildDelayInitializeService) bz.b(IGuildDelayInitializeService.class)).scheduleTask(new IGuildDelayInitializeService.InitializeTask("MyGuildFragment handleAfterAccountChanged", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildFragment$handleAfterAccountChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                IGPSService iGPSService;
                u uVar;
                z zVar;
                MyGuildFragment.this.gProService = (IGPSService) bz.b(IGPSService.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
                if (appInterface != null) {
                    zVar = MyGuildFragment.this.guildObserver;
                    appInterface.addObserver(zVar);
                }
                iGPSService = MyGuildFragment.this.gProService;
                if (iGPSService != null) {
                    uVar = MyGuildFragment.this.gServiceObserver;
                    iGPSService.addObserver(uVar);
                }
            }
        }));
    }

    private final void ci(BeforeAccountChanged event) {
        AppInterface appInterface;
        QLog.i("Guild.discovery.MyGuildFragment", 1, "handleBeforeAccountChanged");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.guildObserver);
        }
        IGPSService iGPSService = this.gProService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.gServiceObserver);
        }
    }

    private final void ii() {
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.J;
        if (guildDefaultThemeNavBarCommon != null) {
            guildDefaultThemeNavBarCommon.setTitleColor(guildDefaultThemeNavBarCommon.getResources().getColorStateList(R.color.qui_common_text_nav_secondary));
        }
    }

    private final void ji(boolean hasTopGuild) {
        GuildSmartRefreshLayout guildSmartRefreshLayout;
        GuildSmartRefreshLayout guildSmartRefreshLayout2;
        if (Intrinsics.areEqual(this.hasTopGuild, Boolean.valueOf(hasTopGuild))) {
            return;
        }
        this.hasTopGuild = Boolean.valueOf(hasTopGuild);
        rh();
        if (hasTopGuild) {
            this.J.setBackgroundResource(R.drawable.qui_common_bg_nav_primary_bg);
            yh(R.color.qui_common_bg_nav_primary);
            ca caVar = this.binding;
            if (caVar != null && (guildSmartRefreshLayout2 = caVar.f442666d) != null) {
                guildSmartRefreshLayout2.setRefreshHeaderBackgroundColorResId(R.color.qui_common_bg_nav_primary);
                return;
            }
            return;
        }
        this.J.setBackgroundResource(R.drawable.qui_common_bg_nav_secondary_bg);
        yh(R.color.qui_common_bg_nav_secondary);
        ca caVar2 = this.binding;
        if (caVar2 != null && (guildSmartRefreshLayout = caVar2.f442666d) != null) {
            guildSmartRefreshLayout.a();
        }
    }

    public final void Sh(@NotNull final com.tencent.mobileqq.guild.discoveryv2.myguild.d fetchDataCallback) {
        Object firstOrNull;
        STATE state;
        Object firstOrNull2;
        Intrinsics.checkNotNullParameter(fetchDataCallback, "fetchDataCallback");
        STATE state2 = this.curState;
        boolean z16 = false;
        if (state2 != STATE.INIT && state2 != (state = STATE.CONTENT)) {
            if (state2 == STATE.EMPTY) {
                List<MyGuildData> ai5 = ai();
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ai5);
                MyGuildData myGuildData = (MyGuildData) firstOrNull2;
                if (myGuildData != null) {
                    z16 = myGuildData.getIsTop();
                }
                ji(z16);
                if ((fetchDataCallback instanceof an) && (!ai5.isEmpty())) {
                    this.curState = state;
                    com.tencent.mobileqq.guild.discoveryv2.content.base.f.k0(this.loadMoreAdapter, false, false, null, 4, null);
                    ei(ai5, new ArrayList(), new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.q
                        @Override // java.lang.Runnable
                        public final void run() {
                            MyGuildFragment.Uh(d.this);
                        }
                    });
                    return;
                }
                Yh(ai5, this.refreshNum, fetchDataCallback);
                return;
            }
            return;
        }
        List<MyGuildData> ai6 = ai();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ai6);
        MyGuildData myGuildData2 = (MyGuildData) firstOrNull;
        if (myGuildData2 != null) {
            z16 = myGuildData2.getIsTop();
        }
        ji(z16);
        if (!ai6.isEmpty()) {
            this.curState = STATE.CONTENT;
            com.tencent.mobileqq.guild.discoveryv2.content.base.f.k0(this.loadMoreAdapter, false, false, null, 4, null);
            ei(ai6, new ArrayList(), new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.p
                @Override // java.lang.Runnable
                public final void run() {
                    MyGuildFragment.Th(d.this);
                }
            });
        } else {
            this.curState = STATE.EMPTY;
            Yh(new ArrayList(), this.refreshNum, fetchDataCallback);
        }
    }

    @Nullable
    /* renamed from: Vh, reason: from getter */
    public final ca getBinding() {
        return this.binding;
    }

    @NotNull
    /* renamed from: Wh, reason: from getter */
    public final com.tencent.mobileqq.guild.discoveryv2.content.base.f getLoadMoreAdapter() {
        return this.loadMoreAdapter;
    }

    @NotNull
    /* renamed from: Xh, reason: from getter */
    public final MyGuildAdapter getMyGuildAdapter() {
        return this.myGuildAdapter;
    }

    /* renamed from: Zh, reason: from getter */
    public final int getRefreshNum() {
        return this.refreshNum;
    }

    public final void di(int i3) {
        this.refreshNum = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        IPerformanceReportTask g16;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        GuildSmartRefreshLayout guildSmartRefreshLayout;
        RecyclerView recyclerView3;
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.f1506715m));
        setTextWithTalk(this.D, R.string.f142510jk);
        wh(R.drawable.guild_title_top_right_add_icon, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MyGuildFragment.Oh(MyGuildFragment.this, view);
            }
        });
        if (AppSetting.f99565y) {
            this.G.setContentDescription(getString(R.string.f1507215r));
        }
        ji(false);
        ca e16 = ca.e(this.P);
        this.binding = e16;
        if (e16 != null && (recyclerView3 = e16.f442664b) != null) {
            recyclerView3.setLayoutManager(new LinearLayoutManager(recyclerView3.getContext()));
            recyclerView3.setAdapter(new RFWConcatAdapter(this.myGuildAdapter, this.loadMoreAdapter));
            recyclerView3.addOnScrollListener(new c());
        }
        ca caVar = this.binding;
        if (caVar != null && (guildSmartRefreshLayout = caVar.f442666d) != null) {
            guildSmartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.s
                @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
                public final void onRefresh(IRefreshLayout iRefreshLayout) {
                    MyGuildFragment.Ph(MyGuildFragment.this, iRefreshLayout);
                }
            });
            if (this.inGuildSubTab) {
                guildSmartRefreshLayout.setEnableRefresh(false);
            }
        }
        ca caVar2 = this.binding;
        if (caVar2 != null && (recyclerView2 = caVar2.f442664b) != null) {
            RFWIocAbilityProvider.g().registerIoc(recyclerView2, new b() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.t
                @Override // zu1.b
                public final Boolean invoke() {
                    boolean Qh;
                    Qh = MyGuildFragment.Qh(MyGuildFragment.this);
                    return Boolean.valueOf(Qh);
                }
            }, b.class);
        }
        if (container != null) {
            Rh(container);
        }
        Sh(new AutoRefreshFetchDataCallback(this));
        Bundle arguments = getArguments();
        if (arguments != null && (g16 = qw1.b.g(arguments, null, 1, null)) != null) {
            ca caVar3 = this.binding;
            if (caVar3 != null) {
                recyclerView = caVar3.f442664b;
            } else {
                recyclerView = null;
            }
            qw1.b.k(g16, recyclerView, null, 2, null);
        }
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        guildSplitViewUtils.B(this.N);
        guildSplitViewUtils.A(getActivity(), this.N, R.drawable.qui_common_bg_nav_secondary_bg);
    }

    public final void ei(@NotNull List<MyGuildData> myGuildList, @NotNull List<MyGuildRecommendData> myGuildRecommendList, @Nullable Runnable commitCallback) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(myGuildList, "myGuildList");
        Intrinsics.checkNotNullParameter(myGuildRecommendList, "myGuildRecommendList");
        ca caVar = this.binding;
        if (caVar != null && (recyclerView = caVar.f442664b) != null) {
            this.myGuildAdapter.q0(myGuildList, myGuildRecommendList, commitCallback);
            VideoReport.traversePage(recyclerView);
        }
    }

    public final void fi() {
        Object firstOrNull;
        boolean z16;
        int collectionSizeOrDefault;
        Set set;
        List<MyGuildData> ai5 = ai();
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) ai5);
        MyGuildData myGuildData = (MyGuildData) firstOrNull;
        int i3 = 0;
        if (myGuildData != null) {
            z16 = myGuildData.getIsTop();
        } else {
            z16 = false;
        }
        ji(z16);
        if (ai5.isEmpty() && this.myGuildAdapter.l0().isEmpty()) {
            Sh(new an(this));
            return;
        }
        if (ai5.isEmpty()) {
            for (Object obj : this.myGuildAdapter.l0()) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                MyGuildRecommendData myGuildRecommendData = (MyGuildRecommendData) obj;
                if (!myGuildRecommendData.getIsGuest()) {
                    List<MyGuildRecommendData> l06 = this.myGuildAdapter.l0();
                    MyGuildRecommendData a16 = myGuildRecommendData.a();
                    a16.l(true);
                    Unit unit = Unit.INSTANCE;
                    l06.set(i3, a16);
                }
                i3 = i16;
            }
            ei(ai5, this.myGuildAdapter.l0(), new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.n
                @Override // java.lang.Runnable
                public final void run() {
                    MyGuildFragment.gi();
                }
            });
            return;
        }
        List<MyGuildData> list = ai5;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((MyGuildData) it.next()).getGuildId());
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        int i17 = 0;
        for (Object obj2 : this.myGuildAdapter.l0()) {
            int i18 = i17 + 1;
            if (i17 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            MyGuildRecommendData myGuildRecommendData2 = (MyGuildRecommendData) obj2;
            if (set.contains(myGuildRecommendData2.getGuildId()) && myGuildRecommendData2.getIsGuest()) {
                List<MyGuildRecommendData> l07 = this.myGuildAdapter.l0();
                MyGuildRecommendData a17 = myGuildRecommendData2.a();
                a17.l(false);
                Unit unit2 = Unit.INSTANCE;
                l07.set(i17, a17);
            } else if (!set.contains(myGuildRecommendData2.getGuildId()) && !myGuildRecommendData2.getIsGuest()) {
                List<MyGuildRecommendData> l08 = this.myGuildAdapter.l0();
                MyGuildRecommendData a18 = myGuildRecommendData2.a();
                a18.l(true);
                Unit unit3 = Unit.INSTANCE;
                l08.set(i17, a18);
            }
            i17 = i18;
        }
        ei(ai5, this.myGuildAdapter.l0(), new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.o
            @Override // java.lang.Runnable
            public final void run() {
                MyGuildFragment.hi();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f0m;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(BeforeAccountChanged.class, AfterAccountChanged.class);
        Intrinsics.checkNotNull(arrayListOf, "null cannot be cast to non-null type java.util.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>>{ kotlin.collections.TypeAliasesKt.ArrayList<java.lang.Class<com.tencent.biz.richframework.eventbus.SimpleBaseEvent>> }");
        return arrayListOf;
    }

    public final void hideLoading() {
        ScanningLightView scanningLightView;
        ca caVar = this.binding;
        if (caVar != null) {
            scanningLightView = caVar.f442667e;
        } else {
            scanningLightView = null;
        }
        if (scanningLightView != null) {
            scanningLightView.setVisibility(8);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        boolean z16;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            z16 = arguments.getBoolean("inGuildTab");
        } else {
            z16 = false;
        }
        this.inGuildSubTab = z16;
        ((IGuildDelayInitializeService) bz.b(IGuildDelayInitializeService.class)).scheduleTask(new IGuildDelayInitializeService.InitializeTask("MyGuildFragment onCreate", new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.myguild.MyGuildFragment$onCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                IGPSService iGPSService;
                u uVar;
                z zVar;
                MyGuildFragment.this.gProService = (IGPSService) bz.b(IGPSService.class);
                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
                if (appInterface != null) {
                    zVar = MyGuildFragment.this.guildObserver;
                    appInterface.addObserver(zVar);
                }
                iGPSService = MyGuildFragment.this.gProService;
                if (iGPSService != null) {
                    uVar = MyGuildFragment.this.gServiceObserver;
                    iGPSService.addObserver(uVar);
                }
                SimpleEventBus.getInstance().registerReceiver(MyGuildFragment.this);
            }
        }));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        AppInterface appInterface;
        RecyclerView recyclerView;
        super.onDestroy();
        ca caVar = this.binding;
        if (caVar != null && (recyclerView = caVar.f442664b) != null) {
            RFWIocAbilityProvider.g().unregisterSingleIoc(recyclerView, b.class);
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AppInterface) {
            appInterface = (AppInterface) peekAppRuntime;
        } else {
            appInterface = null;
        }
        if (appInterface != null) {
            appInterface.removeObserver(this.guildObserver);
        }
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        IGPSService iGPSService = this.gProService;
        if (iGPSService != null) {
            iGPSService.deleteObserver(this.gServiceObserver);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public void onPostThemeChanged() {
        RecyclerView recyclerView;
        super.onPostThemeChanged();
        Logger.f235387a.d().i("Guild.discovery.MyGuildFragment", 1, "onPostThemeChanged");
        ca caVar = this.binding;
        if (caVar != null && (recyclerView = caVar.f442664b) != null) {
            recyclerView.setItemViewCacheSize(0);
            recyclerView.setItemViewCacheSize(2);
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
        Boolean bool = this.hasTopGuild;
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            this.hasTopGuild = null;
            ji(booleanValue);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
        if (event instanceof BeforeAccountChanged) {
            ci((BeforeAccountChanged) event);
        } else if (event instanceof AfterAccountChanged) {
            bi((AfterAccountChanged) event);
        }
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_nav_secondary);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int qh() {
        return R.drawable.qui_common_bg_nav_secondary_bg;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void rh() {
        super.rh();
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_nav_secondary);
        DrawableType drawableType = new DrawableType(R.drawable.guild_title_top_right_add_icon, valueOf);
        ImageView rightViewImg = this.G;
        Intrinsics.checkNotNullExpressionValue(rightViewImg, "rightViewImg");
        drawableType.b(rightViewImg);
        DrawableType drawableType2 = new DrawableType(R.drawable.guild_back_left, valueOf);
        TextView leftView = this.C;
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        drawableType2.a(leftView);
        ii();
    }

    public final void showLoading() {
        ScanningLightView scanningLightView;
        ca caVar = this.binding;
        if (caVar != null) {
            scanningLightView = caVar.f442667e;
        } else {
            scanningLightView = null;
        }
        if (scanningLightView != null) {
            scanningLightView.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void yh(int resId) {
        FragmentActivity activity;
        Window window;
        if (!GuildSplitViewUtils.f235370a.n(getActivity()) && (activity = getActivity()) != null && (window = activity.getWindow()) != null) {
            Intrinsics.checkNotNullExpressionValue(window, "window");
            int i3 = Build.VERSION.SDK_INT;
            int color = activity.getResources().getColor(resId);
            window.clearFlags(67108864);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(color);
            if (!GuildThemeManager.f235286a.b()) {
                ImmersiveUtils.setStatusTextColor(true, activity.getWindow());
                if (i3 >= 26) {
                    View decorView = window.getDecorView();
                    Intrinsics.checkNotNullExpressionValue(decorView, "it.decorView");
                    decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void hi() {
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/myguild/MyGuildFragment$d", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d implements ILoadMoreProvider$LoadMoreListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.discoveryv2.content.base.f f217518d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ MyGuildFragment f217519e;

        d(com.tencent.mobileqq.guild.discoveryv2.content.base.f fVar, MyGuildFragment myGuildFragment) {
            this.f217518d = fVar;
            this.f217519e = myGuildFragment;
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreStart() {
            com.tencent.mobileqq.guild.discoveryv2.content.base.f.k0(this.f217518d, true, false, null, 4, null);
            MyGuildFragment myGuildFragment = this.f217519e;
            myGuildFragment.Sh(new f(myGuildFragment));
        }

        @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
        public void onLoadMoreEnd(boolean hasMore) {
        }
    }
}
