package com.tencent.mobileqq.guild.homev2.parts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.fling.FlingGestureHandler;
import com.tencent.mobileqq.activity.fling.FlingHandler;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.guild.base.extension.u;
import com.tencent.mobileqq.guild.component.GuildQUIPageTabBar;
import com.tencent.mobileqq.guild.event.GuildHomeTabChangeEvent;
import com.tencent.mobileqq.guild.homev2.viewmodels.GuildHomeViewModel;
import com.tencent.mobileqq.guild.homev2.views.GuildHomeV2ContentLayout;
import com.tencent.mobileqq.guild.mainframe.util.GuildMainFrameUtils;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowKt;
import lp1.SubTabData;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011*\u0001\u0017\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\u0016\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u000e\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\u0010\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u000f\u0010\u0018\u001a\u00020\u0017H\u0002\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u001e\u001a\u00020\u0004J\u000e\u0010!\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u001fJ\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u001c\u0010'\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010&\u001a\u0004\u0018\u00010%H\u0016J\u0012\u0010(\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\u0012\u0010)\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010+\u001a\u0004\u0018\u00010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010:\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010=\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0014\u0010@\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/parts/GuildTabsPart;", "Lcom/tencent/mobileqq/guild/homev2/parts/a;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "R9", "Y9", "Q9", "W9", "initData", "", "Llp1/c;", "it", "ba", "O9", "T9", "", "index", "", "isClick", "V9", "enable", "M9", "com/tencent/mobileqq/guild/homev2/parts/GuildTabsPart$b", "U9", "()Lcom/tencent/mobileqq/guild/homev2/parts/GuildTabsPart$b;", "view", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "X9", "onInitView", "ca", "", "channelId", "S9", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartStart", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onPartResume", "Lcom/tencent/mobileqq/webview/swift/WebViewFragment;", "N9", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2ContentLayout;", "e", "Lcom/tencent/mobileqq/guild/homev2/views/GuildHomeV2ContentLayout;", "contentLayout", "Llp1/a;", "f", "Llp1/a;", "adapter", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", tl.h.F, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "i", "Llp1/c;", "currentSubTab", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", "hasAutoNavigated", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/homev2/parts/GuildTabsPart$b;", "fragmentLifecycleCallbacks", "<init>", "()V", "D", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildTabsPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b fragmentLifecycleCallbacks = U9();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildHomeV2ContentLayout contentLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private lp1.a adapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IPerformanceReportTask reportTask;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SubTabData currentSubTab;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean hasAutoNavigated;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\"\u0010\u000f\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/guild/homev2/parts/GuildTabsPart$b", "Landroidx/fragment/app/FragmentManager$FragmentLifecycleCallbacks;", "Landroidx/fragment/app/FragmentManager;", "fm", "Landroidx/fragment/app/Fragment;", "f", "", "onFragmentResumed", "", "d", "I", "a", "()I", "b", "(I)V", "manageIndex", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends FragmentManager.FragmentLifecycleCallbacks {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private int manageIndex = -1;

        b() {
        }

        /* renamed from: a, reason: from getter */
        public final int getManageIndex() {
            return this.manageIndex;
        }

        public final void b(int i3) {
            this.manageIndex = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
        public void onFragmentResumed(@NotNull FragmentManager fm5, @NotNull Fragment f16) {
            com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b bVar;
            Unit unit;
            View c65;
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(f16, "f");
            Logger logger = Logger.f235387a;
            GuildTabsPart guildTabsPart = GuildTabsPart.this;
            Logger.a d16 = logger.d();
            String simpleName = f16.getClass().getSimpleName();
            int manageIndex = getManageIndex();
            GuildHomeV2ContentLayout guildHomeV2ContentLayout = guildTabsPart.contentLayout;
            GuildHomeV2ContentLayout guildHomeV2ContentLayout2 = null;
            if (guildHomeV2ContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeV2ContentLayout = null;
            }
            d16.i("TabContentPart", 1, "onFragmentResumed: " + simpleName + ", " + manageIndex + " / " + guildHomeV2ContentLayout.getViewPager2().getCurrentItem());
            super.onFragmentResumed(fm5, f16);
            int i3 = this.manageIndex;
            GuildHomeV2ContentLayout guildHomeV2ContentLayout3 = GuildTabsPart.this.contentLayout;
            if (guildHomeV2ContentLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeV2ContentLayout3 = null;
            }
            if (i3 != guildHomeV2ContentLayout3.getViewPager2().getCurrentItem()) {
                GuildHomeV2ContentLayout guildHomeV2ContentLayout4 = GuildTabsPart.this.contentLayout;
                if (guildHomeV2ContentLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeV2ContentLayout4 = null;
                }
                this.manageIndex = guildHomeV2ContentLayout4.getViewPager2().getCurrentItem();
                GuildHomeV2ContentLayout guildHomeV2ContentLayout5 = GuildTabsPart.this.contentLayout;
                if (guildHomeV2ContentLayout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeV2ContentLayout5 = null;
                }
                guildHomeV2ContentLayout5.getManageContainer().removeAllViews();
                if (f16 instanceof com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b) {
                    bVar = (com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b) f16;
                } else {
                    bVar = null;
                }
                if (bVar != null && (c65 = bVar.c6()) != null) {
                    GuildTabsPart guildTabsPart2 = GuildTabsPart.this;
                    GuildHomeV2ContentLayout guildHomeV2ContentLayout6 = guildTabsPart2.contentLayout;
                    if (guildHomeV2ContentLayout6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                        guildHomeV2ContentLayout6 = null;
                    }
                    guildHomeV2ContentLayout6.getManageContainer().setMinimumWidth(ViewUtils.dpToPx(24.0f));
                    GuildHomeV2ContentLayout guildHomeV2ContentLayout7 = guildTabsPart2.contentLayout;
                    if (guildHomeV2ContentLayout7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                        guildHomeV2ContentLayout7 = null;
                    }
                    guildHomeV2ContentLayout7.getManageContainer().addView(c65);
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    GuildHomeV2ContentLayout guildHomeV2ContentLayout8 = GuildTabsPart.this.contentLayout;
                    if (guildHomeV2ContentLayout8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    } else {
                        guildHomeV2ContentLayout2 = guildHomeV2ContentLayout8;
                    }
                    guildHomeV2ContentLayout2.getManageContainer().setMinimumWidth(0);
                }
            }
        }
    }

    private final void M9(boolean enable) {
        FlingGestureHandler flingGestureHandler;
        Logger logger = Logger.f235387a;
        logger.d().i("TabContentPart", 1, "enableFlingBackGesture: " + enable);
        FlingHandler flingHandler = GestureActivityModule.getFlingHandler(x9());
        if (flingHandler instanceof FlingGestureHandler) {
            flingGestureHandler = (FlingGestureHandler) flingHandler;
        } else {
            flingGestureHandler = null;
        }
        if (flingGestureHandler != null && flingGestureHandler.mTopLayout != null) {
            logger.d().i("TabContentPart", 1, "enableFlingBackGesture: " + enable + ", set to topLayout");
            flingGestureHandler.mTopLayout.setInterceptTouchFlag(enable);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O9(List<SubTabData> it) {
        if (!this.hasAutoNavigated && !it.isEmpty()) {
            String channelId = B9().f().getChannelId();
            Intrinsics.checkNotNullExpressionValue(channelId, "guildHomeProvider.jumpGuildParam.channelId");
            if (!GuildMainFrameUtils.q(channelId)) {
                this.hasAutoNavigated = S9(channelId);
            }
            long categoryId = B9().f().getCategoryId();
            if (!this.hasAutoNavigated && categoryId != 0) {
                this.hasAutoNavigated = S9(String.valueOf(categoryId));
            }
            if (!this.hasAutoNavigated) {
                T9(it);
                this.hasAutoNavigated = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Q9() {
        IPerformanceReportTask stageCode = B9().getReportTask().duplicate("guild_id").setStageCode("stage_tab");
        this.reportTask = stageCode;
        cp1.d dVar = cp1.d.f391542a;
        if (stageCode == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            stageCode = null;
        }
        dVar.a(stageCode);
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            iPerformanceReportTask = null;
        }
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        qw1.b.k(iPerformanceReportTask, guildHomeV2ContentLayout.getViewTab(), null, 2, null);
    }

    private final void R9(View rootView) {
        View findViewById = rootView.findViewById(R.id.b9w);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.content_layout)");
        this.contentLayout = (GuildHomeV2ContentLayout) findViewById;
        Q9();
        Y9();
    }

    private final void T9(List<SubTabData> it) {
        Iterator<SubTabData> it5 = it.iterator();
        int i3 = 0;
        while (true) {
            if (it5.hasNext()) {
                boolean z16 = true;
                if (it5.next().getType() != 1) {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
            if (guildHomeV2ContentLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                guildHomeV2ContentLayout = null;
            }
            guildHomeV2ContentLayout.getViewPager2().setCurrentItem(i3, false);
        }
    }

    private final b U9() {
        return new b();
    }

    private final void V9(int index, boolean isClick) {
        Object orNull;
        long j3;
        boolean z16;
        Logger.f235387a.d().i("TabContentPart", 1, "notifyTabChange: " + index);
        lp1.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        List<SubTabData> items = aVar.getItems();
        Iterator<SubTabData> it = items.iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                long categoryId = it.next().getCategoryId();
                SubTabData subTabData = this.currentSubTab;
                if (subTabData != null) {
                    j3 = subTabData.getCategoryId();
                } else {
                    j3 = 0;
                }
                if (categoryId == j3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        orNull = CollectionsKt___CollectionsKt.getOrNull(items, index);
        SubTabData subTabData2 = (SubTabData) orNull;
        this.currentSubTab = subTabData2;
        Logger logger = Logger.f235387a;
        if (QLog.isDebugVersion()) {
            logger.d().d("TabContentPart", 1, "onTabChanged index:" + index + " isClick:" + isClick + " " + subTabData2);
        }
        C9().getGuildSubTabPageViewModel().U1(index, i3, isClick);
        if (subTabData2 != null) {
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            GuildHomeTabChangeEvent guildHomeTabChangeEvent = new GuildHomeTabChangeEvent(C9().getGuildId(), subTabData2.getCategoryId(), subTabData2.getType(), index, isClick);
            guildHomeTabChangeEvent.mHashCode = getContext().hashCode();
            simpleEventBus.dispatchEvent(guildHomeTabChangeEvent);
        }
    }

    private final void W9() {
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        lp1.a aVar = null;
        if (iPerformanceReportTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            iPerformanceReportTask = null;
        }
        this.adapter = new lp1.a(hostFragment, iPerformanceReportTask);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        ViewPager2 viewPager2 = guildHomeV2ContentLayout.getViewPager2();
        lp1.a aVar2 = this.adapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            aVar = aVar2;
        }
        viewPager2.setAdapter(aVar);
    }

    private final void X9(View view, SubTabData item) {
        Map mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_section_name", item.getName()), TuplesKt.to("sgrp_sub_channel_id", String.valueOf(item.getCategoryId())), TuplesKt.to("sgrp_section_type", item.f()));
        com.tencent.mobileqq.guild.base.extension.g.b(view, "em_sgrp_forum_section", false, false, mapOf, 6, null);
    }

    private final void Y9() {
        RecyclerView b16;
        Fragment hostFragment = getHostFragment();
        Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = null;
        if (iPerformanceReportTask == null) {
            Intrinsics.throwUninitializedPropertyAccessException("reportTask");
            iPerformanceReportTask = null;
        }
        this.adapter = new lp1.a(hostFragment, iPerformanceReportTask);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout2 = this.contentLayout;
        if (guildHomeV2ContentLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout2 = null;
        }
        ViewPager2 viewPager2 = guildHomeV2ContentLayout2.getViewPager2();
        lp1.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        viewPager2.setAdapter(aVar);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout3 = this.contentLayout;
        if (guildHomeV2ContentLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout3 = null;
        }
        u.a(guildHomeV2ContentLayout3.getViewPager2());
        GuildHomeV2ContentLayout guildHomeV2ContentLayout4 = this.contentLayout;
        if (guildHomeV2ContentLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout4 = null;
        }
        b16 = p.b(guildHomeV2ContentLayout4.getViewPager2());
        b16.setItemViewCacheSize(100);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout5 = this.contentLayout;
        if (guildHomeV2ContentLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout5 = null;
        }
        guildHomeV2ContentLayout5.getViewTab().setFontSize(14.0f);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout6 = this.contentLayout;
        if (guildHomeV2ContentLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout6 = null;
        }
        GuildQUIPageTabBar viewTab = guildHomeV2ContentLayout6.getViewTab();
        GuildHomeV2ContentLayout guildHomeV2ContentLayout7 = this.contentLayout;
        if (guildHomeV2ContentLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout7 = null;
        }
        viewTab.bindViewPager2(guildHomeV2ContentLayout7.getViewPager2());
        GuildHomeV2ContentLayout guildHomeV2ContentLayout8 = this.contentLayout;
        if (guildHomeV2ContentLayout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout8 = null;
        }
        guildHomeV2ContentLayout8.getViewTab().setDataSetChangeListener(new GuildQUIPageTabBar.c() { // from class: com.tencent.mobileqq.guild.homev2.parts.n
            @Override // com.tencent.mobileqq.guild.component.GuildQUIPageTabBar.c
            public final void onChanged() {
                GuildTabsPart.Z9(GuildTabsPart.this);
            }
        });
        GuildHomeV2ContentLayout guildHomeV2ContentLayout9 = this.contentLayout;
        if (guildHomeV2ContentLayout9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        } else {
            guildHomeV2ContentLayout = guildHomeV2ContentLayout9;
        }
        guildHomeV2ContentLayout.getViewTab().setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.guild.homev2.parts.o
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                GuildTabsPart.aa(GuildTabsPart.this, i3, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(GuildTabsPart this$0) {
        Object orNull;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        lp1.a aVar = this$0.adapter;
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        List<SubTabData> items = aVar.getItems();
        GuildHomeV2ContentLayout guildHomeV2ContentLayout2 = this$0.contentLayout;
        if (guildHomeV2ContentLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        } else {
            guildHomeV2ContentLayout = guildHomeV2ContentLayout2;
        }
        int i3 = 0;
        for (View view : guildHomeV2ContentLayout.getViewTab().d()) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            View view2 = view;
            orNull = CollectionsKt___CollectionsKt.getOrNull(items, i3);
            SubTabData subTabData = (SubTabData) orNull;
            if (subTabData != null) {
                this$0.X9(view2, subTabData);
            }
            i3 = i16;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(GuildTabsPart this$0, int i3, boolean z16) {
        String str;
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean z17 = true;
        Logger.f235387a.d().i("TabContentPart", 1, "onTabClick: " + i3 + ", " + z16);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this$0.contentLayout;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        View e16 = guildHomeV2ContentLayout.getViewTab().e(i3);
        if (e16 != null) {
            if (z16) {
                str = "1";
            } else {
                str = "2";
            }
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_clck_type", str));
            VideoReport.setElementId(e16, "em_sgrp_forum_section");
            VideoReport.setElementClickPolicy(e16, ClickPolicy.REPORT_NONE);
            VideoReport.reportEvent("clck", e16, mapOf);
        }
        this$0.V9(i3, z16);
        if (i3 != 0) {
            z17 = false;
        }
        this$0.M9(z17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ba(List<SubTabData> it) {
        Object obj;
        if (it.isEmpty()) {
            return;
        }
        Iterator<T> it5 = it.iterator();
        while (true) {
            if (it5.hasNext()) {
                obj = it5.next();
                SubTabData subTabData = (SubTabData) obj;
                SubTabData subTabData2 = this.currentSubTab;
                boolean z16 = false;
                if (subTabData2 != null && subTabData.getCategoryId() == subTabData2.getCategoryId()) {
                    z16 = true;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((SubTabData) obj) == null) {
            Logger.f235387a.d().i("TabContentPart", 1, "tryNavigateToFeedSquareIfCurrentTabNotExist, navigateToFeedSquare");
            T9(it);
        }
    }

    private final void initData() {
        LiveData asLiveData$default = FlowLiveDataConversions.asLiveData$default(C9().P1(), (CoroutineContext) null, 0L, 3, (Object) null);
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GuildHomeViewModel.GuildHomeUiState, Unit> function1 = new Function1<GuildHomeViewModel.GuildHomeUiState, Unit>() { // from class: com.tencent.mobileqq.guild.homev2.parts.GuildTabsPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
                invoke2(guildHomeUiState);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeViewModel.GuildHomeUiState guildHomeUiState) {
                GuildHomeV2ContentLayout guildHomeV2ContentLayout = GuildTabsPart.this.contentLayout;
                if (guildHomeV2ContentLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
                    guildHomeV2ContentLayout = null;
                }
                guildHomeV2ContentLayout.setVisibility(guildHomeUiState.getIsNormalGuild() || guildHomeUiState.getIsVisitorVisibleGuild() ? 0 : 8);
            }
        };
        asLiveData$default.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.homev2.parts.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildTabsPart.P9(Function1.this, obj);
            }
        });
        FlowKt.launchIn(FlowKt.onEach(C9().getGuildInfoViewModel().O1(), new GuildTabsPart$initData$2(null)), com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this));
        FlowKt.launchIn(FlowKt.onEach(C9().b2().S1(), new GuildTabsPart$initData$3(this, null)), com.tencent.mobileqq.guild.discoveryv2.content.part.d.b(this));
    }

    @Nullable
    public final WebViewFragment N9() {
        lp1.a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        long itemId = aVar.getItemId(guildHomeV2ContentLayout.getViewPager2().getCurrentItem());
        lp1.a aVar2 = this.adapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar2 = null;
        }
        Fragment findFragmentByTag = aVar2.getChildFragmentManager().findFragmentByTag("f" + itemId);
        if (!(findFragmentByTag instanceof WebViewFragment)) {
            return null;
        }
        return (WebViewFragment) findFragmentByTag;
    }

    public final boolean S9(@NotNull String channelId) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        lp1.a aVar = this.adapter;
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        Iterator<SubTabData> it = aVar.getItems().iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(String.valueOf(it.next().getCategoryId()), channelId)) {
                    break;
                }
                i3++;
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 != -1) {
            GuildHomeV2ContentLayout guildHomeV2ContentLayout2 = this.contentLayout;
            if (guildHomeV2ContentLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            } else {
                guildHomeV2ContentLayout = guildHomeV2ContentLayout2;
            }
            guildHomeV2ContentLayout.getViewPager2().setCurrentItem(i3, false);
            Logger.f235387a.d().d("TabContentPart", 1, "navigateToChannelId: " + channelId);
            return true;
        }
        Logger logger = Logger.f235387a;
        Logger.b bVar = new Logger.b();
        String str = "navigateToChannelId: " + channelId + " not found, " + ch.B(channelId);
        if (str instanceof String) {
            bVar.a().add(str);
        }
        Iterator<T> it5 = bVar.a().iterator();
        while (it5.hasNext()) {
            Logger.f235387a.d().e("TabContentPart", 1, (String) it5.next(), null);
        }
        return false;
    }

    public final void ca() {
        this.fragmentLifecycleCallbacks.b(-1);
        W9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        R9(rootView);
        initData();
    }

    @Override // com.tencent.mobileqq.guild.homev2.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        FragmentManager childFragmentManager;
        super.onPartCreate(activity, savedInstanceState);
        Logger.f235387a.d().i("TabContentPart", 1, "onPartCreate");
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
            childFragmentManager.registerFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks, false);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        FragmentManager childFragmentManager;
        super.onPartDestroy(activity);
        Fragment hostFragment = getHostFragment();
        if (hostFragment != null && (childFragmentManager = hostFragment.getChildFragmentManager()) != null) {
            childFragmentManager.unregisterFragmentLifecycleCallbacks(this.fragmentLifecycleCallbacks);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
        GuildHomeV2ContentLayout guildHomeV2ContentLayout2 = null;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        boolean z16 = false;
        V9(guildHomeV2ContentLayout.getViewPager2().getCurrentItem(), false);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout3 = this.contentLayout;
        if (guildHomeV2ContentLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
        } else {
            guildHomeV2ContentLayout2 = guildHomeV2ContentLayout3;
        }
        if (guildHomeV2ContentLayout2.getViewTab().getCurrentPosition() == 0) {
            z16 = true;
        }
        M9(z16);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStart(@Nullable Activity activity) {
        boolean z16;
        super.onPartStart(activity);
        GuildHomeV2ContentLayout guildHomeV2ContentLayout = this.contentLayout;
        if (guildHomeV2ContentLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentLayout");
            guildHomeV2ContentLayout = null;
        }
        if (guildHomeV2ContentLayout.getViewTab().getCurrentPosition() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        M9(z16);
    }
}
