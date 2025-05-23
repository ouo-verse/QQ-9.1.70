package com.tencent.mobileqq.guild.discoveryv2.parts;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.Part;
import com.tencent.biz.richframework.part.interfaces.IPartHost;
import com.tencent.guild.aio.util.ex.ViewExtKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.config.GuildAISearchConfBean;
import com.tencent.mobileqq.guild.discoveryv2.adapters.GuildSubTabFragmentAdapter;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabClickData;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabViewModel;
import com.tencent.mobileqq.guild.discoveryv2.parts.tabs.TabsViewModel;
import com.tencent.mobileqq.guild.discoveryv2.widget.GuildDiscoveryTabBar;
import com.tencent.mobileqq.guild.feed.event.bus.SimpleEventBusExtKt;
import com.tencent.mobileqq.guild.mainframe.api.IGuildMainFrameApi;
import com.tencent.mobileqq.guild.report.DummyPerformanceReportTask;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProNavigationTab;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.statustitle.OnBannerChanged;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qcircle.weseevideo.model.utils.LocaleUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.xweb.FileReaderHelper;
import ef1.c;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u00ae\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 k2\u00020\u0001:\u0001lB\u0007\u00a2\u0006\u0004\bi\u0010jJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J \u0010\u0013\u001a\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\b\b\u0002\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u0015\u001a\u00020\u000b2\b\b\u0002\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u001c\u0010\u001a\u001a\u00020\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u000b0\u0017H\u0002J\u0010\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u001c\u0010\"\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010!\u001a\u0004\u0018\u00010 H\u0016J\u0012\u0010#\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010$\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010%\u001a\u00020\u00022\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016J\u0010\u0010'\u001a\u00020\u00022\u0006\u0010&\u001a\u00020\u0007H\u0016J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020(J$\u0010.\u001a\u00020\u00022\u0006\u0010+\u001a\u00020\u000b2\u0014\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010(0,R$\u00106\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010T\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0018\u0010W\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010Z\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010SR*\u0010^\u001a\u0016\u0012\u0004\u0012\u00020(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010,8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010]R\u0016\u0010b\u001a\u00020_8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010f\u001a\u00020c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010e\u00a8\u0006m"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/parts/TabsPart;", "Lcom/tencent/biz/richframework/part/Part;", "", "aa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "U9", "Landroid/content/Intent;", "intent", "", "source", "", LocaleUtils.L_JAPANESE, "Y9", "ca", "la", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProNavigationTab;", "tabs", "ha", FileReaderHelper.OPEN_FILE_FROM_FORCE, "R9", "ma", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "pred", "X9", "onInitView", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "T9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartPause", "onPartStart", "onPartResume", "newIntent", "onNewIntent", "", "height", "ia", "guildTabSelected", "Lkotlin/Pair;", "refreshResult", "ea", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "d", "Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "getAiSearchConfig", "()Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;", "ga", "(Lcom/tencent/mobileqq/guild/config/GuildAISearchConfBean;)V", "aiSearchConfig", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsViewModel;", "e", "Lcom/tencent/mobileqq/guild/discoveryv2/parts/tabs/TabsViewModel;", "viewModel", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar;", "f", "Lcom/tencent/mobileqq/guild/discoveryv2/widget/GuildDiscoveryTabBar;", "viewTab", "Landroidx/viewpager2/widget/ViewPager2;", tl.h.F, "Landroidx/viewpager2/widget/ViewPager2;", "viewPager2", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter;", "i", "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter;", "adapter", "Landroidx/fragment/app/Fragment;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/fragment/app/Fragment;", "fragment", "Landroidx/constraintlayout/widget/ConstraintLayout;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/constraintlayout/widget/ConstraintLayout;", "tabAndManageContainer", "D", "Z", "hasInit", "E", "I", "autoNavigateTimes", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/discoveryv2/adapters/GuildSubTabFragmentAdapter$SubTabData;", "currentTab", "G", "Ljava/lang/Integer;", "navigateTabId", "H", "tabHeight", "Lkotlin/Pair;", "pendingTabs", "Ljava/util/concurrent/atomic/AtomicInteger;", "J", "Ljava/util/concurrent/atomic/AtomicInteger;", "tabsVersion", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "K", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "L", "reportPauseTask", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TabsPart extends Part {

    /* renamed from: C, reason: from kotlin metadata */
    private ConstraintLayout tabAndManageContainer;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean hasInit;

    /* renamed from: E, reason: from kotlin metadata */
    private int autoNavigateTimes;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private GuildSubTabFragmentAdapter.SubTabData currentTab;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Integer navigateTabId;

    /* renamed from: H, reason: from kotlin metadata */
    private int tabHeight;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private Pair<Integer, ? extends List<? extends IGProNavigationTab>> pendingTabs;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private AtomicInteger tabsVersion = new AtomicInteger(0);

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private IPerformanceReportTask reportTask = DummyPerformanceReportTask.INSTANCE;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportPauseTask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GuildAISearchConfBean aiSearchConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TabsViewModel viewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private GuildDiscoveryTabBar viewTab;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ViewPager2 viewPager2;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildSubTabFragmentAdapter adapter;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Fragment fragment;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/parts/TabsPart$b", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", "position", "", "onPageSelected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends ViewPager2.OnPageChangeCallback {
        b() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int position) {
            super.onPageSelected(position);
            GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = TabsPart.this.adapter;
            TabsViewModel tabsViewModel = null;
            if (guildSubTabFragmentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildSubTabFragmentAdapter = null;
            }
            GuildSubTabFragmentAdapter.SubTabData l06 = guildSubTabFragmentAdapter.l0(position);
            if (l06 == null) {
                TabsPart tabsPart = TabsPart.this;
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                GuildSubTabFragmentAdapter guildSubTabFragmentAdapter2 = tabsPart.adapter;
                if (guildSubTabFragmentAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildSubTabFragmentAdapter2 = null;
                }
                String str = "onPageSelected: tabData is null, pos=" + position + ", items.size=" + guildSubTabFragmentAdapter2.j0().size();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("TabsPart", 1, (String) it.next(), null);
                }
                return;
            }
            Logger.f235387a.d().i("TabsPart", 1, "onPageSelected: " + l06.getName());
            TabsPart.this.currentTab = l06;
            TabsViewModel tabsViewModel2 = TabsPart.this.viewModel;
            if (tabsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                tabsViewModel = tabsViewModel2;
            }
            tabsViewModel.U1(l06);
            TabsPart.this.la("onPageSelected");
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/parts/TabsPart$c", "Lcom/tencent/biz/qui/quipagetabbar/QUIPageTabBar$h;", "", "current", "", "k1", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements QUIPageTabBar.h {
        c() {
        }

        @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.h
        public void k1(int current) {
            GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = TabsPart.this.adapter;
            TabsViewModel tabsViewModel = null;
            if (guildSubTabFragmentAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildSubTabFragmentAdapter = null;
            }
            GuildSubTabFragmentAdapter.SubTabData l06 = guildSubTabFragmentAdapter.l0(current);
            if (l06 == null) {
                TabsPart tabsPart = TabsPart.this;
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                GuildSubTabFragmentAdapter guildSubTabFragmentAdapter2 = tabsPart.adapter;
                if (guildSubTabFragmentAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildSubTabFragmentAdapter2 = null;
                }
                String str = "onTabChanged: tabData is null, pos=" + current + ", items.size=" + guildSubTabFragmentAdapter2.j0().size();
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("TabsPart", 1, (String) it.next(), null);
                }
                return;
            }
            Logger.f235387a.d().i("TabsPart", 1, "onCurrentTabClick: " + l06.getName());
            TabsViewModel tabsViewModel2 = TabsPart.this.viewModel;
            if (tabsViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                tabsViewModel = tabsViewModel2;
            }
            tabsViewModel.P1(l06).c2();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f217650d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f217651e;

        public d(Object obj, Observer observer) {
            this.f217650d = obj;
            this.f217651e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f217650d)) != null) {
                this.f217651e.onChanged(b16);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f217652a;

        public e(ViewModelStoreOwner viewModelStoreOwner) {
            this.f217652a = viewModelStoreOwner;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new TabsViewModel(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    private final boolean R9(boolean force) {
        Object orNull;
        if (force) {
            this.autoNavigateTimes = 0;
        }
        int i3 = this.autoNavigateTimes;
        if (i3 > 1) {
            return false;
        }
        this.autoNavigateTimes = i3 + 1;
        TabsViewModel tabsViewModel = null;
        if (this.navigateTabId != null) {
            if (X9(new Function1<GuildSubTabFragmentAdapter.SubTabData, Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$autoNavigate$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull GuildSubTabFragmentAdapter.SubTabData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    int tabId = it.getTabId();
                    Integer num = TabsPart.this.navigateTabId;
                    return Boolean.valueOf(num != null && tabId == num.intValue());
                }
            })) {
                Logger.f235387a.d().i("TabsPart", 1, "autoNavigate: navigateTabId=" + this.navigateTabId + ", navigate success");
                this.autoNavigateTimes = Integer.MAX_VALUE;
            } else if (this.autoNavigateTimes <= 1) {
                Logger.f235387a.d().i("TabsPart", 1, "autoNavigate: navigateTabId=" + this.navigateTabId + ", wait for next loadTabs");
                GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = this.adapter;
                if (guildSubTabFragmentAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    guildSubTabFragmentAdapter = null;
                }
                List<GuildSubTabFragmentAdapter.SubTabData> j06 = guildSubTabFragmentAdapter.j0();
                GuildDiscoveryTabBar guildDiscoveryTabBar = this.viewTab;
                if (guildDiscoveryTabBar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewTab");
                    guildDiscoveryTabBar = null;
                }
                orNull = CollectionsKt___CollectionsKt.getOrNull(j06, guildDiscoveryTabBar.getCurrentPosition());
                GuildSubTabFragmentAdapter.SubTabData subTabData = (GuildSubTabFragmentAdapter.SubTabData) orNull;
                TabsViewModel tabsViewModel2 = this.viewModel;
                if (tabsViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                } else {
                    tabsViewModel = tabsViewModel2;
                }
                tabsViewModel.U1(subTabData);
            } else {
                Logger.f235387a.d().i("TabsPart", 1, "autoNavigate: navigateTabId=" + this.navigateTabId + ", retry times exceed, navigate to recommend tab");
                this.autoNavigateTimes = Integer.MAX_VALUE;
                X9(new Function1<GuildSubTabFragmentAdapter.SubTabData, Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$autoNavigate$5
                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull GuildSubTabFragmentAdapter.SubTabData it) {
                        Intrinsics.checkNotNullParameter(it, "it");
                        return Boolean.valueOf(it.getType() == 1);
                    }
                });
            }
        } else {
            this.autoNavigateTimes = Integer.MAX_VALUE;
            if (!X9(new Function1<GuildSubTabFragmentAdapter.SubTabData, Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$autoNavigate$succ$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull GuildSubTabFragmentAdapter.SubTabData it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(it.getType() == 1);
                }
            })) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                bVar.a().add("autoNavigate: navigate to recommend tab failed");
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("TabsPart", 1, (String) it.next(), null);
                }
            }
        }
        return true;
    }

    static /* synthetic */ boolean S9(TabsPart tabsPart, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        return tabsPart.R9(z16);
    }

    private final void U9(final View rootView) {
        Fragment fragment = this.fragment;
        GuildDiscoveryTabBar guildDiscoveryTabBar = null;
        if (fragment == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment = null;
        }
        IPerformanceReportTask stageCode = qw1.b.d(fragment.getArguments(), null, 1, null).duplicate(new String[0]).setStageCode("stage_main");
        this.reportTask = stageCode;
        this.reportPauseTask = stageCode.duplicate(new String[0]).setStageCode("stage_fragment_onpause");
        cp1.d.f391542a.a(this.reportTask);
        Intrinsics.checkNotNullExpressionValue(OneShotPreDrawListener.add(rootView, new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$initViews$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                GuildSubTabFragmentAdapter.SubTabData subTabData;
                String str;
                IPerformanceReportTask iPerformanceReportTask;
                subTabData = this.currentTab;
                uh1.a aVar = uh1.a.f438959a;
                if (subTabData != null) {
                    str = subTabData.getName();
                } else {
                    str = null;
                }
                aVar.d("viewPage onPreDraw " + str);
                iPerformanceReportTask = this.reportTask;
                iPerformanceReportTask.report();
            }
        }), "OneShotPreDrawListener.add(this) { action(this) }");
        View findViewById = rootView.findViewById(R.id.x1n);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.guild_tab)");
        this.viewTab = (GuildDiscoveryTabBar) findViewById;
        View findViewById2 = rootView.findViewById(R.id.x4u);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.guild_viewpager)");
        this.viewPager2 = (ViewPager2) findViewById2;
        Fragment fragment2 = this.fragment;
        if (fragment2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("fragment");
            fragment2 = null;
        }
        this.adapter = new GuildSubTabFragmentAdapter(fragment2, this.reportTask);
        View findViewById3 = rootView.findViewById(R.id.x1o);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026tab_and_manage_container)");
        this.tabAndManageContainer = (ConstraintLayout) findViewById3;
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager2 = null;
        }
        com.tencent.mobileqq.guild.base.extension.u.a(viewPager2);
        ViewPager2 viewPager22 = this.viewPager2;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager22 = null;
        }
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = this.adapter;
        if (guildSubTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter = null;
        }
        viewPager22.setAdapter(guildSubTabFragmentAdapter);
        GuildDiscoveryTabBar guildDiscoveryTabBar2 = this.viewTab;
        if (guildDiscoveryTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTab");
            guildDiscoveryTabBar2 = null;
        }
        ViewPager2 viewPager23 = this.viewPager2;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager23 = null;
        }
        guildDiscoveryTabBar2.bindViewPager2(viewPager23);
        ViewPager2 viewPager24 = this.viewPager2;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager24 = null;
        }
        viewPager24.registerOnPageChangeCallback(new b());
        GuildDiscoveryTabBar guildDiscoveryTabBar3 = this.viewTab;
        if (guildDiscoveryTabBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTab");
            guildDiscoveryTabBar3 = null;
        }
        guildDiscoveryTabBar3.setOnCurrentTabClickListener(new c());
        GuildDiscoveryTabBar guildDiscoveryTabBar4 = this.viewTab;
        if (guildDiscoveryTabBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTab");
            guildDiscoveryTabBar4 = null;
        }
        guildDiscoveryTabBar4.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.r
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                TabsPart.V9(TabsPart.this, i3, z16);
            }
        });
        GuildDiscoveryTabBar guildDiscoveryTabBar5 = this.viewTab;
        if (guildDiscoveryTabBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTab");
        } else {
            guildDiscoveryTabBar = guildDiscoveryTabBar5;
        }
        guildDiscoveryTabBar.setTabBarsUpdatedCallback(new GuildDiscoveryTabBar.Companion.InterfaceC7730a() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.s
            @Override // com.tencent.mobileqq.guild.discoveryv2.widget.GuildDiscoveryTabBar.Companion.InterfaceC7730a
            public final void a(Sequence sequence) {
                TabsPart.W9(TabsPart.this, sequence);
            }
        });
        this.hasInit = true;
        ia(this.tabHeight);
        ma("initViews");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(TabsPart this$0, int i3, boolean z16) {
        int i16;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = this$0.adapter;
        GuildDiscoveryTabBar guildDiscoveryTabBar = null;
        if (guildSubTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter = null;
        }
        GuildSubTabFragmentAdapter.SubTabData l06 = guildSubTabFragmentAdapter.l0(i3);
        if (l06 == null) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            GuildSubTabFragmentAdapter guildSubTabFragmentAdapter2 = this$0.adapter;
            if (guildSubTabFragmentAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                guildSubTabFragmentAdapter2 = null;
            }
            String str = "TabChangeListener: tabData is null, pos=" + i3 + ", items.size=" + guildSubTabFragmentAdapter2.j0().size();
            if (str instanceof String) {
                bVar.a().add(str);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("TabsPart", 1, (String) it.next(), null);
            }
            return;
        }
        Logger.f235387a.d().i("TabsPart", 1, "TabChangeListener: " + l06.getName() + ", fromUserClick=" + z16);
        if (z16) {
            i16 = 1;
        } else {
            i16 = 2;
        }
        GuildDiscoveryTabBar guildDiscoveryTabBar2 = this$0.viewTab;
        if (guildDiscoveryTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTab");
        } else {
            guildDiscoveryTabBar = guildDiscoveryTabBar2;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_switch_tab", Integer.valueOf(i16)), TuplesKt.to("sgrp_tab_name", l06.getName()), TuplesKt.to("sgrp_tab_type", Integer.valueOf(l06.getType())));
        VideoReport.setElementId(guildDiscoveryTabBar, "em_sgrp_tab");
        VideoReport.setElementClickPolicy(guildDiscoveryTabBar, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", guildDiscoveryTabBar, mapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(TabsPart this$0, Sequence tabs) {
        Sequence asSequence;
        Sequence<Pair> zip;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(tabs, "tabs");
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = this$0.adapter;
        if (guildSubTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter = null;
        }
        asSequence = CollectionsKt___CollectionsKt.asSequence(guildSubTabFragmentAdapter.j0());
        zip = SequencesKt___SequencesKt.zip(tabs, asSequence);
        for (Pair pair : zip) {
            View view = (View) pair.component1();
            GuildSubTabFragmentAdapter.SubTabData subTabData = (GuildSubTabFragmentAdapter.SubTabData) pair.component2();
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_switch_tab", 2), TuplesKt.to("sgrp_tab_name", subTabData.getName()), TuplesKt.to("sgrp_tab_type", Integer.valueOf(subTabData.getType())));
            com.tencent.mobileqq.guild.base.extension.g.b(view, "em_sgrp_tab", false, false, mapOf, 6, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean X9(Function1<? super GuildSubTabFragmentAdapter.SubTabData, Boolean> pred) {
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = this.adapter;
        GuildDiscoveryTabBar guildDiscoveryTabBar = null;
        if (guildSubTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter = null;
        }
        Iterator<GuildSubTabFragmentAdapter.SubTabData> it = guildSubTabFragmentAdapter.j0().iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (pred.invoke(it.next()).booleanValue()) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 < 0) {
            return false;
        }
        Logger.f235387a.d().i("TabsPart", 1, "navigateToTab: " + i3 + ", success!");
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(i3, false);
        GuildDiscoveryTabBar guildDiscoveryTabBar2 = this.viewTab;
        if (guildDiscoveryTabBar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTab");
        } else {
            guildDiscoveryTabBar = guildDiscoveryTabBar2;
        }
        guildDiscoveryTabBar.setCurrentPosition(i3, false);
        return true;
    }

    private final void Y9() {
        TabsViewModel tabsViewModel = this.viewModel;
        if (tabsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            tabsViewModel = null;
        }
        LiveData<ef1.a<TabClickData>> Q1 = tabsViewModel.Q1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        final Function1<TabClickData, Unit> function1 = new Function1<TabClickData, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$observeTabClickRefreshEvent$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TabClickData tabClickData) {
                invoke2(tabClickData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TabClickData event) {
                GuildSubTabFragmentAdapter.SubTabData subTabData;
                Object obj;
                Object obj2;
                GuildSubTabFragmentAdapter.SubTabData subTabData2;
                if (TabsPart.this.navigateTabId != null) {
                    Logger.f235387a.d().i("TabsPart", 1, "onPartCreate: liveEventTabClick: " + event + ", ignore event, using schema jump.");
                    return;
                }
                Logger logger = Logger.f235387a;
                logger.d().i("TabsPart", 1, "onPartCreate: liveEventTabClick: " + event);
                TabsViewModel tabsViewModel2 = TabsPart.this.viewModel;
                if (tabsViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    tabsViewModel2 = null;
                }
                List<IGProNavigationTab> value = tabsViewModel2.R1().getValue();
                if (value == null || value.isEmpty()) {
                    if (event.d() && event.e() != null) {
                        TabsPart.this.navigateTabId = event.e();
                        TabsPart tabsPart = TabsPart.this;
                        logger.d().i("TabsPart", 1, "onPartCreate: liveEventTabClick/listNotReady: targetTabId=" + tabsPart.navigateTabId);
                        return;
                    }
                    logger.d().i("TabsPart", 1, "onPartCreate: liveEventTabClick/listNotReady: ignore");
                    return;
                }
                if (event.f()) {
                    subTabData2 = TabsPart.this.currentTab;
                    if (subTabData2 != null) {
                        int tabId = subTabData2.getTabId();
                        TabsViewModel tabsViewModel3 = TabsPart.this.viewModel;
                        if (tabsViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            tabsViewModel3 = null;
                        }
                        TabViewModel T1 = TabsViewModel.T1(tabsViewModel3, tabId, null, 2, null);
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        T1.d2(event);
                        return;
                    }
                    return;
                }
                if (event.d()) {
                    GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = TabsPart.this.adapter;
                    if (guildSubTabFragmentAdapter == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        guildSubTabFragmentAdapter = null;
                    }
                    Iterator<T> it = guildSubTabFragmentAdapter.j0().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it.next();
                            if (((GuildSubTabFragmentAdapter.SubTabData) obj).getType() == 1) {
                                break;
                            }
                        }
                    }
                    GuildSubTabFragmentAdapter.SubTabData subTabData3 = (GuildSubTabFragmentAdapter.SubTabData) obj;
                    GuildSubTabFragmentAdapter guildSubTabFragmentAdapter2 = TabsPart.this.adapter;
                    if (guildSubTabFragmentAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("adapter");
                        guildSubTabFragmentAdapter2 = null;
                    }
                    Iterator<T> it5 = guildSubTabFragmentAdapter2.j0().iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            obj2 = null;
                            break;
                        }
                        obj2 = it5.next();
                        int tabId2 = ((GuildSubTabFragmentAdapter.SubTabData) obj2).getTabId();
                        Integer e16 = event.e();
                        if (e16 != null && tabId2 == e16.intValue()) {
                            break;
                        }
                    }
                    GuildSubTabFragmentAdapter.SubTabData subTabData4 = (GuildSubTabFragmentAdapter.SubTabData) obj2;
                    if (subTabData4 != null) {
                        subTabData3 = subTabData4;
                    }
                    if (subTabData3 != null) {
                        final int tabId3 = subTabData3.getTabId();
                        Logger.f235387a.d().i("TabsPart", 1, "onPartCreate: liveEventTabClick: targetTabId=" + subTabData3.getName() + "(" + tabId3 + ")");
                        TabsPart.this.X9(new Function1<GuildSubTabFragmentAdapter.SubTabData, Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$observeTabClickRefreshEvent$1.6
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            @NotNull
                            public final Boolean invoke(@NotNull GuildSubTabFragmentAdapter.SubTabData it6) {
                                Intrinsics.checkNotNullParameter(it6, "it");
                                return Boolean.valueOf(it6.getTabId() == tabId3);
                            }
                        });
                        TabsViewModel tabsViewModel4 = TabsPart.this.viewModel;
                        if (tabsViewModel4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                            tabsViewModel4 = null;
                        }
                        TabViewModel T12 = TabsViewModel.T1(tabsViewModel4, tabId3, null, 2, null);
                        Intrinsics.checkNotNullExpressionValue(event, "event");
                        T12.d2(event);
                        return;
                    }
                    Logger logger2 = Logger.f235387a;
                    Logger.b bVar = new Logger.b();
                    bVar.a().add("onPartCreate: liveEventTabClick: not find any tab, ignore");
                    Iterator<T> it6 = bVar.a().iterator();
                    while (it6.hasNext()) {
                        Logger.f235387a.d().e("TabsPart", 1, (String) it6.next(), null);
                    }
                }
                subTabData = TabsPart.this.currentTab;
                if (subTabData != null) {
                    int tabId4 = subTabData.getTabId();
                    TabsViewModel tabsViewModel5 = TabsPart.this.viewModel;
                    if (tabsViewModel5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        tabsViewModel5 = null;
                    }
                    TabViewModel T13 = TabsViewModel.T1(tabsViewModel5, tabId4, null, 2, null);
                    Intrinsics.checkNotNullExpressionValue(event, "event");
                    T13.d2(event);
                }
            }
        };
        Q1.observe(lifecycleOwner, new d(null, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.q
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabsPart.Z9(Function1.this, obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void aa() {
        ArrayList arrayListOf;
        e12.a<String> e16 = GuildThemeManager.f235286a.e();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<String, Unit> function1 = new Function1<String, Unit>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$observeTabContainerBackgroundUpdateEvents$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                TabsPart.this.ma("themeChanged(" + str + ")");
            }
        };
        e16.observe(a16, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabsPart.ba(Function1.this, obj);
            }
        });
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        Intrinsics.checkNotNullExpressionValue(simpleEventBus, "getInstance()");
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(OnBannerChanged.class);
        FlowKt.launchIn(FlowKt.onEach(SimpleEventBusExtKt.a(simpleEventBus, arrayListOf), new TabsPart$observeTabContainerBackgroundUpdateEvents$2(this, null)), com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ba(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ca() {
        TabsViewModel tabsViewModel = this.viewModel;
        if (tabsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            tabsViewModel = null;
        }
        LiveData<List<IGProNavigationTab>> R1 = tabsViewModel.R1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final TabsPart$observeTabListUpdateAndAutoNavigate$1 tabsPart$observeTabListUpdateAndAutoNavigate$1 = new TabsPart$observeTabListUpdateAndAutoNavigate$1(this);
        R1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.p
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TabsPart.da(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void da(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ha(List<? extends IGProNavigationTab> tabs, String source) {
        String joinToString$default;
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        GuildSubTabFragmentAdapter.SubTabData subTabData;
        boolean z16;
        Logger.a d16 = Logger.f235387a.d();
        List<? extends IGProNavigationTab> list = tabs;
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(list, null, null, null, 0, null, new Function1<IGProNavigationTab, CharSequence>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$setTabDataAndTryNavigate$1$1
            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final CharSequence invoke(@NotNull IGProNavigationTab it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getName() + "(" + it.getTabId() + ")";
            }
        }, 31, null);
        d16.i("TabsPart", 1, "setTabDataAndTryNavigate[" + source + "]: tabs=" + joinToString$default);
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = this.adapter;
        if (guildSubTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter = null;
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (IGProNavigationTab iGProNavigationTab : list) {
            String name = iGProNavigationTab.getName();
            Intrinsics.checkNotNullExpressionValue(name, "tab.name");
            arrayList.add(new GuildSubTabFragmentAdapter.SubTabData(name, iGProNavigationTab.getTabType(), iGProNavigationTab.getSubType(), iGProNavigationTab.getTabId()));
        }
        guildSubTabFragmentAdapter.setItems(arrayList);
        GuildDiscoveryTabBar guildDiscoveryTabBar = this.viewTab;
        if (guildDiscoveryTabBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewTab");
            guildDiscoveryTabBar = null;
        }
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter2 = this.adapter;
        if (guildSubTabFragmentAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter2 = null;
        }
        List<GuildSubTabFragmentAdapter.SubTabData> j06 = guildSubTabFragmentAdapter2.j0();
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(j06, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it = j06.iterator();
        while (it.hasNext()) {
            arrayList2.add(new GuildQUIPageTabBar.GuildQUIPagerTabData(((GuildSubTabFragmentAdapter.SubTabData) it.next()).getName(), null));
        }
        guildDiscoveryTabBar.setTabData(arrayList2);
        boolean z17 = false;
        if (!S9(this, false, 1, null) && (subTabData = this.currentTab) != null) {
            final int tabId = subTabData.getTabId();
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it5 = list.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        break;
                    }
                    if (((IGProNavigationTab) it5.next()).getTabId() == tabId) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        z17 = true;
                        break;
                    }
                }
            }
            if (z17) {
                X9(new Function1<GuildSubTabFragmentAdapter.SubTabData, Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$setTabDataAndTryNavigate$5
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    @NotNull
                    public final Boolean invoke(@NotNull GuildSubTabFragmentAdapter.SubTabData it6) {
                        Intrinsics.checkNotNullParameter(it6, "it");
                        return Boolean.valueOf(it6.getTabId() == tabId);
                    }
                });
                return;
            }
            Logger.f235387a.d().i("TabsPart", 1, "onPartCreate: currentTabId=" + tabId + " not exist, navigate to recommend tab");
            X9(new Function1<GuildSubTabFragmentAdapter.SubTabData, Boolean>() { // from class: com.tencent.mobileqq.guild.discoveryv2.parts.TabsPart$setTabDataAndTryNavigate$7
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull GuildSubTabFragmentAdapter.SubTabData it6) {
                    Intrinsics.checkNotNullParameter(it6, "it");
                    return Boolean.valueOf(it6.getType() == 1);
                }
            });
        }
    }

    private final boolean ja(Intent intent, String source) {
        Integer num;
        Bundle bundleExtra = intent.getBundleExtra("goto_guildtab_actionextra");
        if (bundleExtra != null) {
            String string = bundleExtra.getString(IGuildMainFrameApi.GUILD_TAB_ID);
            if (string != null) {
                num = StringsKt__StringNumberConversionsKt.toIntOrNull(string);
            } else {
                num = null;
            }
            Logger.f235387a.d().i("TabsPart", 1, "tryNavigateFromBundle[" + source + "]: " + bundleExtra + " / " + this.navigateTabId);
            if (num != null) {
                intent.removeExtra("goto_guildtab_actionextra");
                bundleExtra.remove(IGuildMainFrameApi.GUILD_TAB_ID);
                this.navigateTabId = num;
                return true;
            }
        }
        Logger.f235387a.d().i("TabsPart", 1, "tryNavigateFromBundle[" + source + "]: no navigateTabId");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la(String source) {
        Pair<Integer, ? extends List<? extends IGProNavigationTab>> pair = this.pendingTabs;
        if (pair == null) {
            return;
        }
        if (this.tabsVersion.get() == pair.getFirst().intValue()) {
            ViewPager2 viewPager2 = this.viewPager2;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
                viewPager2 = null;
            }
            if (viewPager2.getScrollState() != 0) {
                Logger.f235387a.d().i("TabsPart", 1, "tryUpdatePendingTabs[" + source + "]: scrollState not idle, wait for next loadTabs");
                return;
            }
            ha(pair.getSecond(), source);
            this.pendingTabs = null;
            return;
        }
        Logger.f235387a.d().i("TabsPart", 1, "tryUpdatePendingTabs[" + source + "]: version not match, ignore");
        this.pendingTabs = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ma(String source) {
        boolean z16;
        boolean z17 = true;
        Logger.f235387a.d().i("TabsPart", 1, "updateTabContainerBackground[" + source + "]");
        GuildAISearchConfBean guildAISearchConfBean = this.aiSearchConfig;
        if (guildAISearchConfBean != null && guildAISearchConfBean.r()) {
            z16 = true;
        } else {
            z16 = false;
        }
        ii1.b.f407701a.a();
        if (!z16) {
            z17 = false;
        }
        ConstraintLayout constraintLayout = this.tabAndManageContainer;
        ConstraintLayout constraintLayout2 = null;
        if (constraintLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabAndManageContainer");
            constraintLayout = null;
        }
        MainResourceConfig e16 = MainResourceConfig.INSTANCE.e();
        ConstraintLayout constraintLayout3 = this.tabAndManageContainer;
        if (constraintLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabAndManageContainer");
        } else {
            constraintLayout2 = constraintLayout3;
        }
        Context context = constraintLayout2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "tabAndManageContainer.context");
        constraintLayout.setBackground(e16.m(context, false, 1.0f, z17));
    }

    @Nullable
    public final WebViewFragment T9() {
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter = this.adapter;
        if (guildSubTabFragmentAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter = null;
        }
        ViewPager2 viewPager2 = this.viewPager2;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
            viewPager2 = null;
        }
        long itemId = guildSubTabFragmentAdapter.getItemId(viewPager2.getCurrentItem());
        GuildSubTabFragmentAdapter guildSubTabFragmentAdapter2 = this.adapter;
        if (guildSubTabFragmentAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            guildSubTabFragmentAdapter2 = null;
        }
        Fragment findFragmentByTag = guildSubTabFragmentAdapter2.getChildFragmentManager().findFragmentByTag("f" + itemId);
        if (!(findFragmentByTag instanceof WebViewFragment)) {
            return null;
        }
        return (WebViewFragment) findFragmentByTag;
    }

    public final void ea(boolean guildTabSelected, @NotNull Pair<Boolean, Integer> refreshResult) {
        Intrinsics.checkNotNullParameter(refreshResult, "refreshResult");
        Logger.f235387a.d().i("TabsPart", 1, "onGuildTabClick: guildTabSelected=" + guildTabSelected + ", refreshResult=" + refreshResult);
        boolean booleanValue = refreshResult.component1().booleanValue();
        Integer component2 = refreshResult.component2();
        TabsViewModel tabsViewModel = this.viewModel;
        if (tabsViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            tabsViewModel = null;
        }
        tabsViewModel.W1(new TabClickData(guildTabSelected, booleanValue, component2));
    }

    public final void ga(@Nullable GuildAISearchConfBean guildAISearchConfBean) {
        this.aiSearchConfig = guildAISearchConfBean;
    }

    public final void ia(int height) {
        this.tabHeight = height;
        if (this.hasInit) {
            ViewPager2 viewPager2 = this.viewPager2;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager2");
                viewPager2 = null;
            }
            ViewExtKt.c(viewPager2, height);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Logger.f235387a.d().i("TabsPart", 1, "onInitView");
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        this.fragment = hostFragment;
        super.onInitView(rootView);
        U9(rootView);
        aa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onNewIntent(@NotNull Intent newIntent) {
        Intrinsics.checkNotNullParameter(newIntent, "newIntent");
        if (ja(newIntent, "onNewIntent")) {
            R9(true);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        Logger.f235387a.d().i("TabsPart", 1, "onPartCreate");
        c.Companion companion = ef1.c.INSTANCE;
        IPartHost partHost = getPartHost();
        Intrinsics.checkNotNullExpressionValue(partHost, "partHost");
        ViewModel viewModel = new ViewModelProvider(partHost, new e(partHost)).get(TabsViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        this.viewModel = (TabsViewModel) viewModel;
        Intent intent = getPartHost().getHostActivity().getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "partHost.hostActivity.intent");
        ja(intent, "onPartCreate");
        Y9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(@Nullable Activity activity) {
        super.onPartPause(activity);
        qw1.b.m(this.reportPauseTask);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        Logger.f235387a.d().i("TabsPart", 1, "onPartResume");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        Logger.f235387a.d().i("TabsPart", 1, "onPartStart");
        ca();
        super.onPartStart(activity);
    }
}
