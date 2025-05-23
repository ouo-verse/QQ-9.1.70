package com.tencent.mobileqq.guild.discoveryv2.hotlive;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.channelcard.AnimationControl;
import com.tencent.mobileqq.guild.discovery.mine.util.MediaChannelParams;
import com.tencent.mobileqq.guild.discovery.mine.util.OpenChannelUtil;
import com.tencent.mobileqq.guild.discovery.startpanel.childs.DiscoverTabType;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.data.OpenParam;
import com.tencent.mobileqq.guild.discoveryv2.hotlive.view.VoicingLinearLayout;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.report.Reporters;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProHotLiveCard;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import gi1.ChannelListenCardItemData;
import gi1.ChannelLiveCardItemData;
import gi1.ChannelNormalMediaCardItemData;
import gi1.ChannelScreenShareCardItemData;
import gi1.ChannelSmobaMediaCardItemData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 C2\u00020\u0001:\u0001DB\u0007\u00a2\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0006H\u0014J$\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014J\u001a\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0006\u0010\u0017\u001a\u00020\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0006H\u0014R\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0014\u00103\u001a\u0002008\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u001e\u0010<\u001a\n\u0012\u0004\u0012\u000209\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?\u00a8\u0006E"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "initData", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "Qh", "", "spanCount", "Sh", "Ph", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Mh", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Nh", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "ph", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveViewModel;", "T", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveViewModel;", "viewModel", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "U", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/ChannelCardAdapter;", "W", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/ChannelCardAdapter;", "cardAdapter", "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl;", "X", "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl;", "mAnimationControl", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/b;", "Y", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/b;", "gridLayoutHelper", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "Z", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "param", "", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProHotLiveCard;", "a0", "Ljava/util/List;", VideoTemplateParser.ITEM_LIST, "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "b0", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "reportTask", "<init>", "()V", "c0", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHotLiveFragment extends QQGuildTitleBarFragment {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private GuildHotLiveViewModel viewModel;

    /* renamed from: U, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: V, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: W, reason: from kotlin metadata */
    private ChannelCardAdapter cardAdapter;

    /* renamed from: X, reason: from kotlin metadata */
    private AnimationControl mAnimationControl;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.discoveryv2.hotlive.b gridLayoutHelper = new com.tencent.mobileqq.guild.discoveryv2.hotlive.b();

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private OpenParam param = new OpenParam(null, null, null, false, 0, 0, null, 0, 0, false, null, null, 4095, null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<? extends IGProHotLiveCard> itemList;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IPerformanceReportTask reportTask;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b#\u0010$J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u008c\u0001\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018H\u0007JB\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u001c\b\u0002\u0010\u0019\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018H\u0007R\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u001fR\u0014\u0010!\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0014\u0010\"\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveFragment$a;", "", "Landroid/content/Context;", "context", "", "pageFrom", "", "a", "", "groupId", "groupName", "traceId", "", "isRecommend", "adapterPosition", "loadNum", "Lcom/tencent/mobileqq/guild/discovery/startpanel/childs/DiscoverTabType;", "tabType", "hasQuickJoinRed", "appChannel", "Lcom/tencent/mobileqq/guild/mainframe/GuildAppReportSourceInfo;", "reportSourceInfo", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProHotLiveCard;", "Lkotlin/collections/ArrayList;", VideoTemplateParser.ITEM_LIST, "d", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/data/OpenParam;", "openParam", "b", "EXTRA_PARAM", "Ljava/lang/String;", "ITEM_LIST", "TAG", "TITLE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void e(Companion companion, Context context, OpenParam openParam, GuildAppReportSourceInfo guildAppReportSourceInfo, ArrayList arrayList, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                guildAppReportSourceInfo = null;
            }
            if ((i3 & 8) != 0) {
                arrayList = null;
            }
            companion.b(context, openParam, guildAppReportSourceInfo, arrayList);
        }

        public static /* synthetic */ void f(Companion companion, Context context, String str, String str2, String str3, boolean z16, int i3, int i16, int i17, DiscoverTabType discoverTabType, boolean z17, String str4, GuildAppReportSourceInfo guildAppReportSourceInfo, ArrayList arrayList, int i18, Object obj) {
            boolean z18;
            String str5;
            ArrayList arrayList2;
            if ((i18 & 512) != 0) {
                z18 = false;
            } else {
                z18 = z17;
            }
            if ((i18 & 1024) != 0) {
                str5 = "";
            } else {
                str5 = str4;
            }
            if ((i18 & 4096) != 0) {
                arrayList2 = null;
            } else {
                arrayList2 = arrayList;
            }
            companion.d(context, str, str2, str3, z16, i3, i16, i17, discoverTabType, z18, str5, guildAppReportSourceInfo, arrayList2);
        }

        @JvmStatic
        public final void a(@NotNull Context context, int pageFrom) {
            Intrinsics.checkNotNullParameter(context, "context");
            e(this, context, new OpenParam(null, null, null, false, 0, 0, null, pageFrom, 0, false, null, null, 3967, null), null, null, 8, null);
        }

        @JvmOverloads
        public final void b(@NotNull Context context, @NotNull OpenParam openParam, @Nullable GuildAppReportSourceInfo reportSourceInfo, @Nullable ArrayList<IGProHotLiveCard> itemList) {
            boolean z16;
            Integer num;
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(openParam, "openParam");
            Intent intent = new Intent();
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("param", openParam);
            if (reportSourceInfo != null) {
                intent.putExtra("GuildAppReportSourceInfo", (Parcelable) reportSourceInfo);
            }
            qw1.b.r(intent, Reporters.f231995a.b().newReportTask().setEventCode("hot_live_main").setAppChannel(com.tencent.mobileqq.guild.report.b.c()));
            if (itemList != null && !itemList.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                intent.putExtra("item_list", itemList);
            }
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildHotLiveFragment.class);
            Logger.a d16 = Logger.f235387a.d();
            if (itemList != null) {
                num = Integer.valueOf(itemList.size());
            } else {
                num = null;
            }
            d16.i("GuildHotLiveFragment", 1, "start openParam=" + openParam + " reportSourceInfo=" + reportSourceInfo + ", itemList:" + num);
        }

        @JvmOverloads
        public final void c(@NotNull Context context, @NotNull String groupId, @NotNull String groupName, @NotNull String traceId, boolean z16, int i3, int i16, int i17, @NotNull DiscoverTabType tabType, boolean z17, @NotNull String appChannel, @Nullable GuildAppReportSourceInfo guildAppReportSourceInfo) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            Intrinsics.checkNotNullParameter(tabType, "tabType");
            Intrinsics.checkNotNullParameter(appChannel, "appChannel");
            f(this, context, groupId, groupName, traceId, z16, i3, i16, i17, tabType, z17, appChannel, guildAppReportSourceInfo, null, 4096, null);
        }

        @JvmOverloads
        public final void d(@NotNull Context context, @NotNull String groupId, @NotNull String groupName, @NotNull String traceId, boolean isRecommend, int adapterPosition, int loadNum, int pageFrom, @NotNull DiscoverTabType tabType, boolean hasQuickJoinRed, @NotNull String appChannel, @Nullable GuildAppReportSourceInfo reportSourceInfo, @Nullable ArrayList<IGProHotLiveCard> itemList) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            Intrinsics.checkNotNullParameter(groupName, "groupName");
            Intrinsics.checkNotNullParameter(traceId, "traceId");
            Intrinsics.checkNotNullParameter(tabType, "tabType");
            Intrinsics.checkNotNullParameter(appChannel, "appChannel");
            b(context, new OpenParam(groupId, groupName, traceId, isRecommend, adapterPosition, loadNum, mh1.a.f416777a.a(pageFrom, tabType), pageFrom, tabType.getTabType(), hasQuickJoinRed, appChannel, null, 2048, null), reportSourceInfo, itemList);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveFragment$b", "Landroidx/recyclerview/widget/GridLayoutManager$SpanSizeLookup;", "", "position", "getSpanSize", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends GridLayoutManager.SpanSizeLookup {
        b() {
        }

        @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
        public int getSpanSize(int position) {
            ChannelCardAdapter channelCardAdapter = GuildHotLiveFragment.this.cardAdapter;
            if (channelCardAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                channelCardAdapter = null;
            }
            if (channelCardAdapter.getItems().get(position) instanceof gi1.a) {
                return 1;
            }
            return GuildHotLiveFragment.this.gridLayoutHelper.getMostCardCnt();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveFragment$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends RecyclerView.ItemDecoration {
        c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.left = ViewUtils.dpToPx(4.0f);
            outRect.top = ViewUtils.dpToPx(4.0f);
            outRect.right = ViewUtils.dpToPx(4.0f);
            outRect.bottom = ViewUtils.dpToPx(4.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<T> list = (List) t16;
            ChannelCardAdapter channelCardAdapter = GuildHotLiveFragment.this.cardAdapter;
            RecyclerView recyclerView = null;
            if (channelCardAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
                channelCardAdapter = null;
            }
            channelCardAdapter.setItems(list);
            RecyclerView recyclerView2 = GuildHotLiveFragment.this.recyclerView;
            if (recyclerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView = recyclerView2;
            }
            final GuildHotLiveFragment guildHotLiveFragment = GuildHotLiveFragment.this;
            recyclerView.post(new Runnable() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveFragment$bindViewModel$1$1
                @Override // java.lang.Runnable
                public final void run() {
                    RecyclerView recyclerView3 = GuildHotLiveFragment.this.recyclerView;
                    if (recyclerView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                        recyclerView3 = null;
                    }
                    VideoReport.traversePage(recyclerView3);
                }
            });
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class f<T> implements Observer {
        public f() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            QQToast.makeText(GuildHotLiveFragment.this.getActivity(), 1, ((cf1.b) t16).f30774a, 1).show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class g<T> implements Observer {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            ((Boolean) t16).booleanValue();
            SmartRefreshLayout smartRefreshLayout = GuildHotLiveFragment.this.refreshLayout;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            smartRefreshLayout.finishRefresh();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0006H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/mobileqq/guild/discoveryv2/hotlive/GuildHotLiveFragment$h", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/d;", "Lcom/tencent/mobileqq/guild/discoveryv2/hotlive/view/VoicingLinearLayout;", "mediaAvatarLayout", "", "c", "Landroid/view/View;", "cardView", "A0", "", "a", "itemView", "", "position", "Lgi1/a;", "itemData", "e", "channelInfo", "d", "view", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class h implements com.tencent.mobileqq.guild.discoveryv2.hotlive.d {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.hotlive.d
        public void A0(@NotNull View cardView) {
            Intrinsics.checkNotNullParameter(cardView, "cardView");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = GuildHotLiveFragment.this.gridLayoutHelper.getCardHeight();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.hotlive.d
        public boolean a() {
            AnimationControl animationControl = GuildHotLiveFragment.this.mAnimationControl;
            if (animationControl == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAnimationControl");
                animationControl = null;
            }
            return animationControl.f();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.hotlive.d
        public void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (NetworkUtil.isNetSupport(GuildHotLiveFragment.this.getContext())) {
                GuildHotLiveViewModel guildHotLiveViewModel = GuildHotLiveFragment.this.viewModel;
                if (guildHotLiveViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    guildHotLiveViewModel = null;
                }
                guildHotLiveViewModel.d2();
                return;
            }
            QQToast.makeText(GuildHotLiveFragment.this.getContext(), R.string.f1510616o, 0).show();
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.hotlive.d
        public void c(@NotNull VoicingLinearLayout mediaAvatarLayout) {
            Intrinsics.checkNotNullParameter(mediaAvatarLayout, "mediaAvatarLayout");
            mediaAvatarLayout.setAvatarSizeAndHorizontalSpacing(GuildHotLiveFragment.this.gridLayoutHelper.getAvatarSize(), GuildHotLiveFragment.this.gridLayoutHelper.getAvatarHorizontalSpacing());
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.hotlive.d
        public void d(@NotNull gi1.a channelInfo) {
            boolean z16;
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            MediaChannelParams mediaChannelParams = new MediaChannelParams(String.valueOf(channelInfo.getGuildId()), String.valueOf(channelInfo.getChannelId()), channelInfo.getJoinGuildSig(), mh1.a.c(mh1.a.f416777a, GuildHotLiveFragment.this.param.getPageFrom(), null, 2, null), eh1.a.f396283a.a(GuildHotLiveFragment.this.param.getPageFrom(), com.tencent.mobileqq.guild.discovery.startpanel.childs.a.a(GuildHotLiveFragment.this.param.getTabTypeValue())), null, null, GuildHotLiveFragment.this.param.getTraceId());
            String appChannel = GuildHotLiveFragment.this.param.getAppChannel();
            GuildHotLiveFragment guildHotLiveFragment = GuildHotLiveFragment.this;
            if (appChannel.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                appChannel = OpenChannelUtil.f216755a.c(com.tencent.mobileqq.guild.discovery.startpanel.childs.a.a(guildHotLiveFragment.param.getTabTypeValue()), guildHotLiveFragment.param.getPageFrom());
            }
            OpenChannelUtil openChannelUtil = OpenChannelUtil.f216755a;
            Context requireContext = GuildHotLiveFragment.this.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            openChannelUtil.g("GuildHotLiveFragment", requireContext, appChannel, mediaChannelParams);
        }

        @Override // com.tencent.mobileqq.guild.discoveryv2.hotlive.d
        public void e(@NotNull View itemView, int position, @NotNull gi1.a itemData) {
            Map mutableMapOf;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("sgrp_channel_id", String.valueOf(itemData.getGuildId())), TuplesKt.to("sgrp_sub_channel_id", String.valueOf(itemData.getChannelId())), TuplesKt.to("sgrp_user_place", Integer.valueOf(position)), TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, itemData.getTraceId()));
            if (itemData instanceof ChannelLiveCardItemData) {
                mutableMapOf.put("sgrp_live_room_id", ((ChannelLiveCardItemData) itemData).getRoomId());
            } else if (itemData instanceof ChannelNormalMediaCardItemData) {
                ChannelNormalMediaCardItemData channelNormalMediaCardItemData = (ChannelNormalMediaCardItemData) itemData;
                mutableMapOf.put("sgrp_content_card_type", Integer.valueOf(channelNormalMediaCardItemData.getCardType()));
                mutableMapOf.put("sgrp_subchannel_session_id", channelNormalMediaCardItemData.getSessionId());
            } else if (itemData instanceof ChannelSmobaMediaCardItemData) {
                ChannelSmobaMediaCardItemData channelSmobaMediaCardItemData = (ChannelSmobaMediaCardItemData) itemData;
                mutableMapOf.put("sgrp_content_card_type", Integer.valueOf(channelSmobaMediaCardItemData.getCardType()));
                mutableMapOf.put("sgrp_subchannel_session_id", channelSmobaMediaCardItemData.getSessionId());
            } else if (itemData instanceof ChannelListenCardItemData) {
                ChannelListenCardItemData channelListenCardItemData = (ChannelListenCardItemData) itemData;
                mutableMapOf.put("sgrp_content_card_type", Integer.valueOf(channelListenCardItemData.getCardType()));
                mutableMapOf.put("sgrp_subchannel_session_id", channelListenCardItemData.getSessionId());
            } else if (itemData instanceof ChannelScreenShareCardItemData) {
                ChannelScreenShareCardItemData channelScreenShareCardItemData = (ChannelScreenShareCardItemData) itemData;
                mutableMapOf.put("sgrp_content_card_type", Integer.valueOf(channelScreenShareCardItemData.getCardType()));
                mutableMapOf.put("sgrp_subchannel_session_id", channelScreenShareCardItemData.getSessionId());
            } else {
                Logger.f235387a.d().w("GuildHotLiveFragment", 1, "new card should care report param!");
            }
            VideoReport.setElementReuseIdentifier(itemView, itemData.getChannelId() + "_" + itemData.getGuildId());
            bt.d(itemView, "em_sgrp_discover_nowplay_content_card", mutableMapOf, null, null, null, 56, null);
        }
    }

    private final void Mh(View rootView) {
        HashMap hashMapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(rootView, "pg_sgrp_discover_nowplay");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(JumpGuildParam.EXTRA_KEY_TRACE_ID, this.param.getTraceId()));
        hashMapOf.putAll(com.tencent.mobileqq.guild.report.b.d());
        VideoReport.setPageParams(rootView, new PageParams(hashMapOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildHotLiveFragment this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        GuildHotLiveViewModel guildHotLiveViewModel = this$0.viewModel;
        if (guildHotLiveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHotLiveViewModel = null;
        }
        guildHotLiveViewModel.refresh();
    }

    private final void Ph() {
        GuildHotLiveViewModel guildHotLiveViewModel = this.viewModel;
        GuildHotLiveViewModel guildHotLiveViewModel2 = null;
        if (guildHotLiveViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHotLiveViewModel = null;
        }
        guildHotLiveViewModel.b2().observe(this, new e());
        GuildHotLiveViewModel guildHotLiveViewModel3 = this.viewModel;
        if (guildHotLiveViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildHotLiveViewModel3 = null;
        }
        guildHotLiveViewModel3.getToastEvent().observe(this, new f());
        GuildHotLiveViewModel guildHotLiveViewModel4 = this.viewModel;
        if (guildHotLiveViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildHotLiveViewModel2 = guildHotLiveViewModel4;
        }
        guildHotLiveViewModel2.a2().observe(this, new g());
    }

    private final com.tencent.mobileqq.guild.discoveryv2.hotlive.d Qh() {
        return new h();
    }

    @JvmStatic
    public static final void Rh(@NotNull Context context, int i3) {
        INSTANCE.a(context, i3);
    }

    private final void Sh(int spanCount) {
        RecyclerView recyclerView = this.recyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            RecyclerView recyclerView3 = this.recyclerView;
            if (recyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            } else {
                recyclerView2 = recyclerView3;
            }
            RecyclerView.LayoutManager layoutManager = recyclerView2.getLayoutManager();
            Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.GridLayoutManager");
            ((GridLayoutManager) layoutManager).setSpanCount(spanCount);
        }
    }

    private final void initData() {
        IPerformanceReportTask iPerformanceReportTask;
        OpenParam openParam;
        Serializable serializable;
        Bundle arguments = getArguments();
        List<? extends IGProHotLiveCard> list = null;
        if (arguments != null) {
            iPerformanceReportTask = qw1.b.g(arguments, null, 1, null);
        } else {
            iPerformanceReportTask = null;
        }
        this.reportTask = iPerformanceReportTask;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            openParam = (OpenParam) arguments2.getParcelable("param");
        } else {
            openParam = null;
        }
        if (openParam != null) {
            this.param = openParam;
        }
        Bundle arguments3 = getArguments();
        if (arguments3 != null) {
            serializable = arguments3.getSerializable("item_list");
        } else {
            serializable = null;
        }
        if (serializable instanceof List) {
            list = (List) serializable;
        }
        this.itemList = list;
    }

    public final void Nh() {
        this.gridLayoutHelper.g();
        setTitle("\u70ed\u95e8\u76f4\u64ad");
        DrawableType drawableType = new DrawableType(R.drawable.guild_back_left, Integer.valueOf(R.color.qui_common_icon_primary));
        TextView leftView = this.C;
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        drawableType.a(leftView);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        TextView centerView = this.E;
        Intrinsics.checkNotNullExpressionValue(centerView, "centerView");
        guildUIUtils.b(centerView, R.color.qui_common_icon_primary);
        getTitleBarView().setBackgroundColor(getResources().getColor(R.color.qui_common_bg_bottom_light));
        View findViewById = this.P.findViewById(R.id.f72333qk);
        SmartRefreshLayout smartRefreshLayout = (SmartRefreshLayout) findViewById;
        smartRefreshLayout.setEnableLoadMore(false).setEnableOverScrollBounce(true).setEnableOverScrollDrag(true);
        smartRefreshLayout.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.c
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                GuildHotLiveFragment.Oh(GuildHotLiveFragment.this, iRefreshLayout);
            }
        });
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI\u2026)\n            }\n        }");
        this.refreshLayout = smartRefreshLayout;
        this.cardAdapter = new ChannelCardAdapter(Qh());
        View findViewById2 = this.P.findViewById(R.id.eap);
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        ChannelCardAdapter channelCardAdapter = this.cardAdapter;
        RecyclerView recyclerView2 = null;
        if (channelCardAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
            channelCardAdapter = null;
        }
        recyclerView.setAdapter(channelCardAdapter);
        recyclerView.setItemAnimator(null);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(recyclerView.getContext(), this.gridLayoutHelper.getMostCardCnt());
        gridLayoutManager.setSpanSizeLookup(new b());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.addItemDecoration(new c());
        recyclerView.addOnScrollListener(new d());
        IPerformanceReportTask iPerformanceReportTask = this.reportTask;
        if (iPerformanceReportTask != null) {
            qw1.b.k(iPerformanceReportTask, recyclerView, null, 2, null);
        }
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI\u2026irstFrame(this)\n        }");
        this.recyclerView = recyclerView;
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView2 = recyclerView3;
        }
        AnimationControl animationControl = new AnimationControl(recyclerView2);
        animationControl.e(this);
        this.mAnimationControl = animationControl;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        initData();
        this.viewModel = (GuildHotLiveViewModel) ef1.c.INSTANCE.c(this, GuildHotLiveViewModel.class, new Function0<GuildHotLiveViewModel>() { // from class: com.tencent.mobileqq.guild.discoveryv2.hotlive.GuildHotLiveFragment$doOnCreateView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHotLiveViewModel invoke() {
                List list;
                OpenParam openParam = GuildHotLiveFragment.this.param;
                list = GuildHotLiveFragment.this.itemList;
                return new GuildHotLiveViewModel(openParam, list != null ? bg.f302144a.n(list) : null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.euh;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.gridLayoutHelper.f((int) cw.d(newConfig.screenWidthDp));
        Sh(this.gridLayoutHelper.getMostCardCnt());
        ChannelCardAdapter channelCardAdapter = this.cardAdapter;
        ChannelCardAdapter channelCardAdapter2 = null;
        if (channelCardAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
            channelCardAdapter = null;
        }
        ChannelCardAdapter channelCardAdapter3 = this.cardAdapter;
        if (channelCardAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cardAdapter");
        } else {
            channelCardAdapter2 = channelCardAdapter3;
        }
        channelCardAdapter.notifyItemRangeChanged(0, channelCardAdapter2.getNUM_BACKGOURND_ICON(), 1);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Nh();
        Ph();
        Mh(view);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_bg_bottom_light;
    }
}
