package com.tencent.mobileqq.guild.feed.guildpanel.prefer;

import android.app.Dialog;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.part.adapter.widget.RFWConcatAdapter;
import com.tencent.biz.richframework.part.block.base.SafeLinearLayoutManager;
import com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.gallery.widget.FeedHalfScreenFloatingView;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProLikeUserInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001GB\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J$\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\nJ\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\u0010\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\u0003H\u0016R\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0018\u0010;\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010C\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u00109\u00a8\u0006H"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/GuildFeedUserPreferListFragment;", "Landroidx/fragment/app/DialogFragment;", "Lcom/tencent/biz/richframework/preload/recyclerview/ILoadMoreProvider$LoadMoreListener;", "", "Dh", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", QCircleScheme.AttrDetail.FEED_INFO, "Fh", "", "yh", "Landroid/view/View;", "view", "Gh", "Hh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Ah", OcrConfig.CHINESE, "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "onStart", "onLoadMoreStart", "", "hasMore", "onLoadMoreEnd", "onDestroyView", "Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/gallery/widget/FeedHalfScreenFloatingView;", "floatingView", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "preferNum", "Landroidx/recyclerview/widget/RecyclerView;", UserInfo.SEX_FEMALE, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/j;", "G", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/j;", "viewModel", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "H", "Lcom/tencent/biz/richframework/part/block/base/SafeLinearLayoutManager;", "safeLayoutManager", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/d;", "I", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/d;", "listAdapter", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "J", "Lcom/tencent/mobileqq/guild/feed/feedsquare/adapter/j;", "loadMoreAdapter", "K", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "L", "preferPanelHeight", "<init>", "()V", "M", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedUserPreferListFragment extends ReportAndroidXDialogFragment implements ILoadMoreProvider$LoadMoreListener {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private FeedHalfScreenFloatingView floatingView;

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView preferNum;

    /* renamed from: F, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: G, reason: from kotlin metadata */
    private j viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private SafeLinearLayoutManager safeLayoutManager;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private d listAdapter;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.feedsquare.adapter.j loadMoreAdapter;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private GProStFeed feedInfo;

    /* renamed from: L, reason: from kotlin metadata */
    private int preferPanelHeight;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/GuildFeedUserPreferListFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragManager", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "stFeed", "", "businessType", "Lcom/tencent/mobileqq/guild/jump/model/JumpGuildParam$JoinInfoParam;", "joinInfoParam", "", "previousPageId", "", "a", "GUILD_BUSINESS_TYPE", "Ljava/lang/String;", "GUILD_FEED_INFO", "GUILD_JOIN_INFO_PARAM", "PG_REF_PG_ID", "PREVIOUS_PAGE_ID", "TAG", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.guildpanel.prefer.GuildFeedUserPreferListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragManager, @NotNull GProStFeed stFeed, int businessType, @Nullable JumpGuildParam.JoinInfoParam joinInfoParam, @NotNull String previousPageId) {
            Intrinsics.checkNotNullParameter(fragManager, "fragManager");
            Intrinsics.checkNotNullParameter(stFeed, "stFeed");
            Intrinsics.checkNotNullParameter(previousPageId, "previousPageId");
            GuildFeedUserPreferListFragment guildFeedUserPreferListFragment = new GuildFeedUserPreferListFragment();
            Bundle bundle = new Bundle();
            bundle.putSerializable("guild_feed_info", stFeed);
            bundle.putSerializable("guild_business_type", Integer.valueOf(businessType));
            bundle.putSerializable("guild_join_info_param", joinInfoParam);
            bundle.putSerializable("previous_page_id", previousPageId);
            guildFeedUserPreferListFragment.setArguments(bundle);
            com.tencent.mobileqq.guild.base.extension.d.a(guildFeedUserPreferListFragment, fragManager, "GuildFeedUserPreferListFragment");
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/guild/feed/guildpanel/prefer/GuildFeedUserPreferListFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "", HippyTKDListViewAdapter.X, "y", "", "canScrollUp", "canScrollDown", NodeProps.MAX_HEIGHT, "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollDown(float x16, float y16) {
            RecyclerView recyclerView = GuildFeedUserPreferListFragment.this.recyclerView;
            if (recyclerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                recyclerView = null;
            }
            return recyclerView.canScrollVertically(-1);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public boolean canScrollUp(float x16, float y16) {
            return true;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            View view = LayoutInflater.from(GuildFeedUserPreferListFragment.this.getContext()).inflate(R.layout.ert, (ViewGroup) null);
            GuildFeedUserPreferListFragment guildFeedUserPreferListFragment = GuildFeedUserPreferListFragment.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            guildFeedUserPreferListFragment.zh(view);
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return GuildFeedUserPreferListFragment.this.yh();
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/feed/guildpanel/prefer/GuildFeedUserPreferListFragment$c", "Lcom/tencent/mobileqq/guild/feed/guildpanel/prefer/k;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProLikeUserInfo;", QCircleAlphaUserReporter.KEY_USER, "", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements k {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f219956b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f219957c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f219958d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f219959e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JumpGuildParam.JoinInfoParam f219960f;

        c(String str, String str2, String str3, int i3, JumpGuildParam.JoinInfoParam joinInfoParam) {
            this.f219956b = str;
            this.f219957c = str2;
            this.f219958d = str3;
            this.f219959e = i3;
            this.f219960f = joinInfoParam;
        }

        @Override // com.tencent.mobileqq.guild.feed.guildpanel.prefer.k
        public void a(@NotNull View view, @NotNull GProLikeUserInfo user) {
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(user, "user");
            ax.I(GuildFeedUserPreferListFragment.this.getActivity(), this.f219956b, this.f219957c, String.valueOf(user.idd), this.f219958d, this.f219959e, this.f219960f);
            GuildFeedUserPreferListFragment.this.Gh(view);
        }
    }

    public GuildFeedUserPreferListFragment() {
        setStyle(0, R.style.f173448dl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Dh() {
        View view = this.rootView;
        FeedHalfScreenFloatingView feedHalfScreenFloatingView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.v2r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.feed_half_screen_view)");
        FeedHalfScreenFloatingView feedHalfScreenFloatingView2 = (FeedHalfScreenFloatingView) findViewById;
        this.floatingView = feedHalfScreenFloatingView2;
        if (feedHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            feedHalfScreenFloatingView2 = null;
        }
        feedHalfScreenFloatingView2.P(0);
        feedHalfScreenFloatingView2.setHeadNeedDragIcon(true);
        feedHalfScreenFloatingView2.setAllowConfigurationChanged(true);
        FeedHalfScreenFloatingView feedHalfScreenFloatingView3 = this.floatingView;
        if (feedHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            feedHalfScreenFloatingView3 = null;
        }
        feedHalfScreenFloatingView3.setQUSDragFloatController(new b());
        FeedHalfScreenFloatingView feedHalfScreenFloatingView4 = this.floatingView;
        if (feedHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        } else {
            feedHalfScreenFloatingView = feedHalfScreenFloatingView4;
        }
        feedHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.g
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildFeedUserPreferListFragment.Eh(GuildFeedUserPreferListFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Eh(GuildFeedUserPreferListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void Fh(GProStFeed feedInfo) {
        int i3;
        Serializable serializable;
        JumpGuildParam.JoinInfoParam joinInfoParam;
        String str = feedInfo.idd;
        String valueOf = String.valueOf(feedInfo.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(feedInfo.channelInfo.sign.channelId);
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("guild_business_type");
        } else {
            i3 = 0;
        }
        Bundle arguments2 = getArguments();
        RecyclerView recyclerView = null;
        if (arguments2 != null) {
            serializable = arguments2.getSerializable("guild_join_info_param");
        } else {
            serializable = null;
        }
        if (serializable instanceof JumpGuildParam.JoinInfoParam) {
            joinInfoParam = (JumpGuildParam.JoinInfoParam) serializable;
        } else {
            joinInfoParam = null;
        }
        d dVar = new d(new c(valueOf, valueOf2, str, i3, joinInfoParam));
        dVar.setHasStableIds(true);
        this.listAdapter = dVar;
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = new com.tencent.mobileqq.guild.feed.feedsquare.adapter.j(0, 0, 0, 5, null);
        jVar.setHasStableIds(true);
        jVar.registerLoadMoreListener(this);
        this.loadMoreAdapter = jVar;
        RFWConcatAdapter rFWConcatAdapter = new RFWConcatAdapter(new RFWConcatAdapter.Config.Builder().setIsolateViewTypes(true).setStableIdMode(RFWConcatAdapter.Config.StableIdMode.ISOLATED_STABLE_IDS).build(), (RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) new RecyclerView.Adapter[]{this.listAdapter, this.loadMoreAdapter});
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        } else {
            recyclerView = recyclerView2;
        }
        recyclerView.setAdapter(rFWConcatAdapter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gh(View view) {
        VideoReport.setElementId(view, "em_sgrp_like_list");
        VideoReport.reportEvent("clck", view, new HashMap());
    }

    private final void Hh(View view, GProStFeed feedInfo) {
        String str;
        String str2 = feedInfo.idd;
        String valueOf = String.valueOf(feedInfo.channelInfo.sign.guildId);
        String valueOf2 = String.valueOf(feedInfo.channelInfo.sign.channelId);
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("previous_page_id")) == null) {
            str = "pg_sgrp_channel_feed";
        }
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_sgrp_like_list");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", valueOf);
        hashMap.put("sgrp_sub_channel_id", valueOf2);
        hashMap.put("sgrp_feed_id", str2);
        hashMap.put("sgrp_pg_ref_pg_id", str);
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int yh() {
        int i3 = this.preferPanelHeight;
        if (i3 != 0) {
            return i3;
        }
        int screenWidth = DisplayUtil.getScreenWidth();
        int screenHeight = DisplayUtil.getScreenHeight();
        if (!mk1.e.g()) {
            screenWidth = RangesKt___RangesKt.coerceAtMost(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
            screenHeight = RangesKt___RangesKt.coerceAtLeast(DisplayUtil.getScreenHeight(), DisplayUtil.getScreenWidth());
        }
        int i16 = (int) (screenWidth * 0.5625f);
        int i17 = screenHeight - i16;
        if (i17 < i16) {
            i17 = (int) (cx.b(getContext()) * 0.7d);
        }
        this.preferPanelHeight = i17;
        QLog.d("GuildFeedUserPreferListFragment", 1, "[preferPanelHeight] panelHeight: " + i17 + ", topSpaceHeight: " + i16 + ", screenHeight: " + DisplayUtil.getScreenHeight());
        return i17;
    }

    public final void Ah(@NotNull View view) {
        Serializable serializable;
        GProStFeed gProStFeed;
        j jVar;
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle arguments = getArguments();
        j jVar2 = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("guild_feed_info");
        } else {
            serializable = null;
        }
        if (serializable instanceof GProStFeed) {
            gProStFeed = (GProStFeed) serializable;
        } else {
            gProStFeed = null;
        }
        this.feedInfo = gProStFeed;
        if (gProStFeed == null) {
            QLog.e("GuildFeedUserPreferListFragment", 1, "GProStFeed is null");
            return;
        }
        if (gProStFeed != null) {
            Fh(gProStFeed);
        }
        ViewModel create = j.INSTANCE.a().create(j.class);
        Intrinsics.checkNotNullExpressionValue(create, "GuildFeedUserPreferListV\u2026del::class.java\n        )");
        j jVar3 = (j) create;
        this.viewModel = jVar3;
        if (jVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            jVar = null;
        } else {
            jVar = jVar3;
        }
        GProStFeed gProStFeed2 = this.feedInfo;
        Intrinsics.checkNotNull(gProStFeed2);
        j.S1(jVar, 1, gProStFeed2, false, 4, null);
        j jVar4 = this.viewModel;
        if (jVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            jVar4 = null;
        }
        LiveData<Long> Q1 = jVar4.Q1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<Long, Unit> function1 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.GuildFeedUserPreferListFragment$initData$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                TextView textView;
                textView = GuildFeedUserPreferListFragment.this.preferNum;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("preferNum");
                    textView = null;
                }
                textView.setText(bl1.b.h(bl1.b.f28597a, (int) l3.longValue(), "0", null, 4, null) + "\u4eba\u8d5e\u4e86");
            }
        };
        Q1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedUserPreferListFragment.Bh(Function1.this, obj);
            }
        });
        j jVar5 = this.viewModel;
        if (jVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            jVar2 = jVar5;
        }
        LiveData<GuildFeedUserPreferData> P1 = jVar2.P1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<GuildFeedUserPreferData, Unit> function12 = new Function1<GuildFeedUserPreferData, Unit>() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.GuildFeedUserPreferListFragment$initData$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildFeedUserPreferData guildFeedUserPreferData) {
                invoke2(guildFeedUserPreferData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildFeedUserPreferData guildFeedUserPreferData) {
                d dVar;
                com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar6;
                dVar = GuildFeedUserPreferListFragment.this.listAdapter;
                if (dVar != null) {
                    dVar.setItems(guildFeedUserPreferData.b());
                }
                jVar6 = GuildFeedUserPreferListFragment.this.loadMoreAdapter;
                if (jVar6 != null) {
                    jVar6.setLoadState(false, guildFeedUserPreferData.getHasMore());
                }
            }
        };
        P1.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.feed.guildpanel.prefer.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedUserPreferListFragment.Ch(Function1.this, obj);
            }
        });
        GProStFeed gProStFeed3 = this.feedInfo;
        if (gProStFeed3 != null) {
            Hh(view, gProStFeed3);
        }
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        this.preferPanelHeight = 0;
        FeedHalfScreenFloatingView feedHalfScreenFloatingView = this.floatingView;
        if (feedHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            feedHalfScreenFloatingView = null;
        }
        feedHalfScreenFloatingView.L();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.eoi, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(\n      \u2026          false\n        )");
        this.rootView = inflate;
        Dh();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        com.tencent.mobileqq.guild.feed.feedsquare.adapter.j jVar = this.loadMoreAdapter;
        if (jVar != null) {
            jVar.unRegisterLoadMoreListener(this);
        }
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreEnd(boolean hasMore) {
        QLog.d("GuildFeedUserPreferListFragment", 1, "onLoadsMoreEnd:" + hasMore);
    }

    @Override // com.tencent.biz.richframework.preload.recyclerview.ILoadMoreProvider$LoadMoreListener
    public void onLoadMoreStart() {
        j jVar = this.viewModel;
        if (jVar != null && this.feedInfo != null) {
            if (jVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                jVar = null;
            }
            GProStFeed gProStFeed = this.feedInfo;
            Intrinsics.checkNotNull(gProStFeed);
            jVar.R1(1, gProStFeed, true);
            QLog.d("GuildFeedUserPreferListFragment", 1, "on load more start");
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(0);
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            GuildUIUtils.H(window);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        Ah(view);
    }

    public final void zh(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        SafeLinearLayoutManager safeLinearLayoutManager = new SafeLinearLayoutManager(getContext());
        safeLinearLayoutManager.setOrientation(1);
        this.safeLayoutManager = safeLinearLayoutManager;
        View findViewById = view.findViewById(R.id.f26810ej);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.prefer_num)");
        this.preferNum = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f115756ww);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.user_recycler)");
        RecyclerView recyclerView = (RecyclerView) findViewById2;
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(this.safeLayoutManager);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            recyclerView2 = null;
        }
        recyclerView2.setItemAnimator(null);
    }
}
