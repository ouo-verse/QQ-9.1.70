package com.tencent.mobileqq.guild.profile.myguild;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim;
import com.tencent.mobileqq.guild.api.IGuildContactApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.jump.GuildJumpUtil;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.mainframe.GuildAppReportSourceInfo;
import com.tencent.mobileqq.guild.mainframe.create.GuildCreateFragment;
import com.tencent.mobileqq.guild.q;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildSplitViewUtils;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 ;2\u00020\u0001:\u0002<=B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J \u0010\u000f\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0006H\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0014J$\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0014J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0006\u0010\u001f\u001a\u00020\u0002J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0015H\u0014J\b\u0010\"\u001a\u00020\rH\u0016R\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "Qh", "Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "type", "Landroid/view/View;", "view", "Wh", "", "guildId", "Th", "guildName", "", "isSetTop", "Uh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Mh", "Sh", "Lcom/tencent/mobileqq/guild/animate/subchannellist/GuildChannelListAnim;", "Rh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Nh", "onResume", "ph", "onBackEvent", "T", "Ljava/lang/String;", "getGuildId", "()Ljava/lang/String;", "setGuildId", "(Ljava/lang/String;)V", "Lcom/tencent/mobileqq/guild/profile/myguild/i;", "U", "Lcom/tencent/mobileqq/guild/profile/myguild/i;", "viewModel", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "V", "Lcom/tencent/richframework/widget/refresh/layout/SmartRefreshLayout;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "W", "Landroidx/recyclerview/widget/RecyclerView;", "guildList", "Lcom/tencent/mobileqq/guild/profile/myguild/d;", "X", "Lcom/tencent/mobileqq/guild/profile/myguild/d;", "adapter", "<init>", "()V", "Y", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMyGuildFragment extends QQGuildTitleBarFragment {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: U, reason: from kotlin metadata */
    private i viewModel;

    /* renamed from: V, reason: from kotlin metadata */
    private SmartRefreshLayout refreshLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private RecyclerView guildList;

    /* renamed from: X, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.profile.myguild.d adapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment$a;", "", "Landroid/content/Context;", "context", "", "a", "", "TAG", "Ljava/lang/String;", "TITLE", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.myguild.GuildMyGuildFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            GuildSplitViewUtils.p(GuildSplitViewUtils.f235370a, context, qw1.b.r(new Intent(), com.tencent.mobileqq.guild.util.report.b.a("guild_list_page")), GuildMyGuildFragment.class, null, 8, null);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u00c4\u0001\u00126\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u00126\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002\u0012K\u0010\u0019\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\t0\u0013\u00a2\u0006\u0004\b\u001a\u0010\u001bRG\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fRG\u0010\u0012\u001a2\u0012\u0013\u0012\u00110\u000e\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\fR\\\u0010\u0019\u001aG\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\t0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0017\u001a\u0004\b\u0010\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment$b;", "", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "guildId", "Landroid/view/View;", "view", "", "a", "Lkotlin/jvm/functions/Function2;", "()Lkotlin/jvm/functions/Function2;", "jumpToGuild", "Lcom/tencent/mobileqq/guild/profile/myguild/GroupType;", "type", "b", "c", "onToggleGroupState", "Lkotlin/Function3;", "guildName", "", "isSetTop", "Lkotlin/jvm/functions/Function3;", "()Lkotlin/jvm/functions/Function3;", NodeProps.ON_LONG_CLICK, "<init>", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function2<String, View, Unit> jumpToGuild;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function2<GroupType, View, Unit> onToggleGroupState;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Function3<String, String, Boolean, Unit> onLongClick;

        /* JADX WARN: Multi-variable type inference failed */
        public b(@NotNull Function2<? super String, ? super View, Unit> jumpToGuild, @NotNull Function2<? super GroupType, ? super View, Unit> onToggleGroupState, @NotNull Function3<? super String, ? super String, ? super Boolean, Unit> onLongClick) {
            Intrinsics.checkNotNullParameter(jumpToGuild, "jumpToGuild");
            Intrinsics.checkNotNullParameter(onToggleGroupState, "onToggleGroupState");
            Intrinsics.checkNotNullParameter(onLongClick, "onLongClick");
            this.jumpToGuild = jumpToGuild;
            this.onToggleGroupState = onToggleGroupState;
            this.onLongClick = onLongClick;
        }

        @NotNull
        public final Function2<String, View, Unit> a() {
            return this.jumpToGuild;
        }

        @NotNull
        public final Function3<String, String, Boolean, Unit> b() {
            return this.onLongClick;
        }

        @NotNull
        public final Function2<GroupType, View, Unit> c() {
            return this.onToggleGroupState;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<T> list = (List) t16;
            SmartRefreshLayout smartRefreshLayout = GuildMyGuildFragment.this.refreshLayout;
            com.tencent.mobileqq.guild.profile.myguild.d dVar = null;
            if (smartRefreshLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
                smartRefreshLayout = null;
            }
            smartRefreshLayout.finishRefresh();
            com.tencent.mobileqq.guild.profile.myguild.d dVar2 = GuildMyGuildFragment.this.adapter;
            if (dVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                dVar = dVar2;
            }
            dVar.setItems(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment$e", "Lcom/tencent/mobileqq/guild/q;", "", "isSuccess", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements q {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.q
        public void a(boolean isSuccess) {
            if (isSuccess) {
                i iVar = GuildMyGuildFragment.this.viewModel;
                if (iVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                    iVar = null;
                }
                iVar.R1("changeTop");
            }
        }
    }

    private final void Mh(View rootView) {
        HashMap hashMapOf;
        VideoReport.addToDetectionWhitelist(getQBaseActivity());
        VideoReport.setPageId(rootView, "pg_sgrp_mine_join_channel");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to(DTParamKey.REPORT_KEY_APPKEY, "0S200MNJT807V3GE"));
        VideoReport.setPageParams(rootView, new PageParams(hashMapOf));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildMyGuildFragment this$0, View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(v3, "v");
        this$0.Sh(v3);
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ph(GuildMyGuildFragment this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        i iVar = this$0.viewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iVar = null;
        }
        iVar.refresh();
    }

    private final void Qh() {
        i iVar = this.viewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iVar = null;
        }
        iVar.P1().observe(this, new c());
    }

    private final GuildChannelListAnim Rh() {
        return new GuildChannelListAnim(new d(), 4);
    }

    private final void Sh(View view) {
        Map emptyMap;
        Activity activity;
        if (FastClickUtils.isFastDoubleClick("GuildMyGuildFragment")) {
            Logger.f235387a.d().w("GuildMyGuildFragment", 1, "handleClickCreateGuild isFastDoubleClick");
            return;
        }
        VideoReport.setElementId(view, "em_sgrp_head_create");
        ch.x(view);
        emptyMap = MapsKt__MapsKt.emptyMap();
        VideoReport.reportEvent("clck", view, emptyMap);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToast(1, R.string.f1510816q);
            return;
        }
        GuildCreateFragment.Companion companion = GuildCreateFragment.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.a(requireContext);
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(R.anim.f154630p2, R.anim.f154442w);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(String guildId, View view) {
        Map mapOf;
        VideoReport.setElementId(view, "em_sgrp_joined_channel");
        ch.x(view);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_channel_id", guildId));
        VideoReport.reportEvent("clck", view, mapOf);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        JumpGuildParam jumpGuildParam = new JumpGuildParam(guildId, "", "", "profile_card", "channel_profile_card");
        jumpGuildParam.setReportSourceInfo(new GuildAppReportSourceInfo("channel_profile_card", ""));
        GuildJumpUtil.n(requireContext, jumpGuildParam);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(final String guildId, String guildName, final boolean isSetTop) {
        String qqStr;
        Dialog createDialog = ActionSheetHelper.createDialog(getContext(), null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        if (isSetTop) {
            qqStr = HardCodeUtil.qqStr(R.string.f155871io);
        } else {
            qqStr = HardCodeUtil.qqStr(R.string.f140880f6);
        }
        actionSheet.addButton(qqStr);
        actionSheet.setMainTitle(guildName);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.guild.profile.myguild.g
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                GuildMyGuildFragment.Vh(guildId, isSetTop, actionSheet, this, view, i3);
            }
        });
        actionSheet.addCancelButton(HardCodeUtil.qqStr(R.string.f140850f3));
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(String guildId, boolean z16, ActionSheet actionSheet, GuildMyGuildFragment this$0, View view, int i3) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            ((IGuildContactApi) QRoute.api(IGuildContactApi.class)).changeGuildTop(guildId, z16, new e());
            actionSheet.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(GroupType type, View view) {
        Map mapOf;
        VideoReport.setElementId(view, "em_sgrp_channel_block");
        ch.x(view);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_block_type", Integer.valueOf(type.getReportType())));
        VideoReport.reportEvent("clck", view, mapOf);
        i iVar = this.viewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iVar = null;
        }
        iVar.U1(type);
    }

    public final void Nh() {
        IPerformanceReportTask g16;
        setTitle("\u6211\u7684\u9891\u9053");
        wh(R.drawable.guild_title_top_right_add_icon, new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.profile.myguild.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildMyGuildFragment.Oh(GuildMyGuildFragment.this, view);
            }
        });
        Integer valueOf = Integer.valueOf(R.color.qui_common_icon_primary);
        DrawableType drawableType = new DrawableType(R.drawable.guild_back_left, valueOf);
        TextView leftView = this.C;
        Intrinsics.checkNotNullExpressionValue(leftView, "leftView");
        drawableType.a(leftView);
        ImageView rightViewImg = this.G;
        Intrinsics.checkNotNullExpressionValue(rightViewImg, "rightViewImg");
        GuildUIUtils.d(rightViewImg, R.drawable.guild_title_top_right_add_icon, valueOf);
        GuildUIUtils guildUIUtils = GuildUIUtils.f235378a;
        TextView centerView = this.E;
        Intrinsics.checkNotNullExpressionValue(centerView, "centerView");
        guildUIUtils.b(centerView, R.color.qui_common_icon_primary);
        getTitleBarView().setBackgroundColor(getResources().getColor(R.color.qui_common_bg_bottom_light));
        View findViewById = this.P.findViewById(R.id.f72333qk);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.refresh_layout)");
        this.refreshLayout = (SmartRefreshLayout) findViewById;
        View findViewById2 = this.P.findViewById(R.id.wlx);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewById(R.id.guild_list)");
        this.guildList = (RecyclerView) findViewById2;
        SmartRefreshLayout smartRefreshLayout = this.refreshLayout;
        if (smartRefreshLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout = null;
        }
        smartRefreshLayout.setEnableLoadMore(false).setEnableOverScrollBounce(true).setEnableOverScrollDrag(true);
        SmartRefreshLayout smartRefreshLayout2 = this.refreshLayout;
        if (smartRefreshLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
            smartRefreshLayout2 = null;
        }
        smartRefreshLayout2.setOnRefreshListener(new OnRefreshListener() { // from class: com.tencent.mobileqq.guild.profile.myguild.f
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnRefreshListener
            public final void onRefresh(IRefreshLayout iRefreshLayout) {
                GuildMyGuildFragment.Ph(GuildMyGuildFragment.this, iRefreshLayout);
            }
        });
        this.adapter = new com.tencent.mobileqq.guild.profile.myguild.d(new b(new GuildMyGuildFragment$bindView$3(this), new GuildMyGuildFragment$bindView$4(this), new GuildMyGuildFragment$bindView$5(this)));
        RecyclerView recyclerView = this.guildList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildList");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        RecyclerView recyclerView2 = this.guildList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildList");
            recyclerView2 = null;
        }
        com.tencent.mobileqq.guild.profile.myguild.d dVar = this.adapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dVar = null;
        }
        recyclerView2.setAdapter(dVar);
        RecyclerView recyclerView3 = this.guildList;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildList");
            recyclerView3 = null;
        }
        recyclerView3.setItemAnimator(Rh());
        Bundle arguments = getArguments();
        if (arguments != null && (g16 = qw1.b.g(arguments, null, 1, null)) != null) {
            RecyclerView recyclerView4 = this.guildList;
            if (recyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildList");
                recyclerView4 = null;
            }
            qw1.b.q(g16, recyclerView4, null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.doOnCreateView(inflater, container, savedInstanceState);
        this.viewModel = (i) ef1.c.INSTANCE.c(this, i.class, new Function0<i>() { // from class: com.tencent.mobileqq.guild.profile.myguild.GuildMyGuildFragment$doOnCreateView$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final i invoke() {
                return new i();
            }
        });
        GuildSplitViewUtils guildSplitViewUtils = GuildSplitViewUtils.f235370a;
        guildSplitViewUtils.B(this.N);
        guildSplitViewUtils.A(getActivity(), this.N, R.drawable.qui_common_bg_bottom_light_bg);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f2r;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        return GuildSplitViewUtils.u(GuildSplitViewUtils.f235370a, getActivity(), false, 2, null);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        i iVar = this.viewModel;
        if (iVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            iVar = null;
        }
        iVar.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Nh();
        Qh();
        Mh(view);
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return GuildSplitViewUtils.f235370a.m(getActivity(), R.color.qui_common_bg_bottom_light);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/profile/myguild/GuildMyGuildFragment$d", "Lcom/tencent/mobileqq/guild/animate/subchannellist/GuildChannelListAnim$h;", "", "c", "b", "a", "onAnimEnd", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements GuildChannelListAnim.h {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
        public void a() {
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
        public void b() {
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
        public void c() {
        }

        @Override // com.tencent.mobileqq.guild.animate.subchannellist.GuildChannelListAnim.h
        public void onAnimEnd() {
        }
    }
}
