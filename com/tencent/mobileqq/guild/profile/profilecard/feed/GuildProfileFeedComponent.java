package com.tencent.mobileqq.guild.profile.profilecard.feed;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.profilecard.GuildProfileData;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedLauncherApi;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent;
import com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.controller.IGuildComponentController;
import com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.cp;

@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 E2\u00020\u00012\u00020\u0002:\u0001FB\u0017\u0012\u0006\u0010B\u001a\u00020A\u0012\u0006\u0010(\u001a\u00020'\u00a2\u0006\u0004\bC\u0010DJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J \u0010\u0013\u001a\u00020\u00052\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011H\u0002J&\u0010\u001a\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0005H\u0016J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\fH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0003H\u0016J\u0012\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0014J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'H\u0016J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020'H\u0016R\u0016\u0010,\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u0010/\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00102\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00105\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00108\u001a\u0002078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010@\u00a8\u0006G"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedComponent;", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/component/AbsGuildProfileComponent;", "Landroid/view/View$OnClickListener;", "", "visibility", "", "setContainerVisibleAwareLoading", "bindUI", "initFeedTitleContainer", "bindViewModel", "initRecyclerView", "openMyFeedsFragment", "", "count", "setFeedCount", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/g;", "Lkotlin/collections/ArrayList;", "list", "setFeedList", "Landroidx/fragment/app/Fragment;", "fragment", "Lcom/tencent/common/app/AppInterface;", "appInterface", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", HippyQQPagView.EventName.ON_LOAD_START, "onLoadFinish", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "getComponentName", "getComponentType", "getContentLayoutId", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;", "guildProfileData", "onInitData", "onUpdateData", "Landroid/widget/TextView;", QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT, "Landroid/widget/TextView;", "Landroid/widget/ImageView;", "moreArrow", "Landroid/widget/ImageView;", "Landroid/widget/RelativeLayout;", "feedTitleContainer", "Landroid/widget/RelativeLayout;", "Landroidx/recyclerview/widget/RecyclerView;", "feedRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedItemAdapter;", "feedListAdapter", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedItemAdapter;", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewModel;", "feedViewModel", "Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedViewModel;", "", "isLoading", "Z", "I", "Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/controller/IGuildComponentController;", "componentController", "<init>", "(Lcom/tencent/mobileqq/guild/profile/profilecard/baseprofile/framework/controller/IGuildComponentController;Lcom/tencent/mobileqq/guild/data/profilecard/GuildProfileData;)V", "Companion", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildProfileFeedComponent extends AbsGuildProfileComponent implements View.OnClickListener {

    @NotNull
    private static final Lazy<Integer> CLICK_EXPEND_SIZE$delegate;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    public static final String TAG = "Guild.profile.GuildProfileFeedComponent";
    private TextView feedCount;
    private GuildProfileFeedItemAdapter feedListAdapter;
    private RecyclerView feedRecyclerView;
    private RelativeLayout feedTitleContainer;
    private GuildProfileFeedViewModel feedViewModel;
    private boolean isLoading;
    private ImageView moreArrow;
    private int visibility;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fR\u001b\u0010\u0007\u001a\u00020\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\n\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedComponent$a;", "", "", "CLICK_EXPEND_SIZE$delegate", "Lkotlin/Lazy;", "b", "()I", "CLICK_EXPEND_SIZE", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedComponent$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final int b() {
            return ((Number) GuildProfileFeedComponent.CLICK_EXPEND_SIZE$delegate.getValue()).intValue();
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/profile/profilecard/feed/GuildProfileFeedComponent$b", "Lcom/tencent/mobileqq/guild/media/widget/audiofaceview/e;", "", "canScrollHorizontally", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.guild.media.widget.audiofaceview.e {
        b(Context context) {
            super(context, 0, false);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return false;
        }
    }

    static {
        Lazy<Integer> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedComponent$Companion$CLICK_EXPEND_SIZE$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(ViewUtils.dpToPx(8.0f));
            }
        });
        CLICK_EXPEND_SIZE$delegate = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildProfileFeedComponent(@NotNull IGuildComponentController componentController, @NotNull GuildProfileData guildProfileData) {
        super(componentController, guildProfileData);
        Intrinsics.checkNotNullParameter(componentController, "componentController");
        Intrinsics.checkNotNullParameter(guildProfileData, "guildProfileData");
        this.visibility = 8;
    }

    private final void bindUI() {
        initFeedTitleContainer();
        initRecyclerView();
    }

    private final void bindViewModel() {
        GuildProfileFeedViewModel.Companion companion = GuildProfileFeedViewModel.INSTANCE;
        Fragment mFragment = this.mFragment;
        Intrinsics.checkNotNullExpressionValue(mFragment, "mFragment");
        GuildProfileFeedViewModel a16 = companion.a(mFragment);
        this.feedViewModel = a16;
        GuildProfileFeedViewModel guildProfileFeedViewModel = null;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            a16 = null;
        }
        a16.O1().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFeedComponent.bindViewModel$lambda$4(GuildProfileFeedComponent.this, (String) obj);
            }
        });
        GuildProfileFeedViewModel guildProfileFeedViewModel2 = this.feedViewModel;
        if (guildProfileFeedViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
        } else {
            guildProfileFeedViewModel = guildProfileFeedViewModel2;
        }
        guildProfileFeedViewModel.P1().observe(this.mFragment, new Observer() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildProfileFeedComponent.bindViewModel$lambda$5(GuildProfileFeedComponent.this, (ArrayList) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindViewModel$lambda$4(GuildProfileFeedComponent this$0, String it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.setFeedCount(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bindViewModel$lambda$5(GuildProfileFeedComponent this$0, ArrayList it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.setFeedList(it);
    }

    private final void initFeedTitleContainer() {
        View findViewById = this.mViewContainer.findViewById(R.id.f165588wt3);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mViewContainer.findViewById(R.id.guild_num)");
        this.feedCount = (TextView) findViewById;
        View findViewById2 = this.mViewContainer.findViewById(R.id.ezw);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mViewContainer.findViewB\u2026ageView>(R.id.more_arrow)");
        this.moreArrow = (ImageView) findViewById2;
        View findViewById3 = this.mViewContainer.findViewById(R.id.wug);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mViewContainer.findViewB\u2026ofile_rl_title_container)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById3;
        this.feedTitleContainer = relativeLayout;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedTitleContainer");
            relativeLayout = null;
        }
        Object parent = relativeLayout.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        final View view = (View) parent;
        view.post(new Runnable() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.c
            @Override // java.lang.Runnable
            public final void run() {
                GuildProfileFeedComponent.initFeedTitleContainer$lambda$3(GuildProfileFeedComponent.this, view);
            }
        });
        RelativeLayout relativeLayout3 = this.feedTitleContainer;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedTitleContainer");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        relativeLayout2.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initFeedTitleContainer$lambda$3(GuildProfileFeedComponent this$0, View parentView) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(parentView, "$parentView");
        Rect rect = new Rect();
        RelativeLayout relativeLayout = this$0.feedTitleContainer;
        RelativeLayout relativeLayout2 = null;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedTitleContainer");
            relativeLayout = null;
        }
        relativeLayout.getHitRect(rect);
        int i3 = rect.left;
        Companion companion = INSTANCE;
        rect.left = i3 - companion.b();
        rect.top -= companion.b();
        rect.right += companion.b();
        rect.bottom += companion.b();
        RelativeLayout relativeLayout3 = this$0.feedTitleContainer;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedTitleContainer");
        } else {
            relativeLayout2 = relativeLayout3;
        }
        parentView.setTouchDelegate(new TouchDelegate(rect, relativeLayout2));
    }

    private final void initRecyclerView() {
        View findViewById = this.mViewContainer.findViewById(R.id.wxi);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mViewContainer.findViewB\u2026ld_rv_feed_item_recycler)");
        this.feedRecyclerView = (RecyclerView) findViewById;
        GuildProfileFeedItemAdapter guildProfileFeedItemAdapter = new GuildProfileFeedItemAdapter();
        this.feedListAdapter = guildProfileFeedItemAdapter;
        guildProfileFeedItemAdapter.t0(new Function2<Integer, ProfileFeedItem, Unit>() { // from class: com.tencent.mobileqq.guild.profile.profilecard.feed.GuildProfileFeedComponent$initRecyclerView$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, ProfileFeedItem profileFeedItem) {
                invoke(num.intValue(), profileFeedItem);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull ProfileFeedItem profileFeedItem) {
                Intrinsics.checkNotNullParameter(profileFeedItem, "<anonymous parameter 1>");
                Logger.f235387a.d().d(GuildProfileFeedComponent.TAG, 1, "[feedListAdapter] onclick " + i3 + " ");
                IGuildComponentController componentController = GuildProfileFeedComponent.this.getComponentController();
                if (componentController != null) {
                    componentController.handleDismissAction();
                }
            }
        });
        RecyclerView recyclerView = this.feedRecyclerView;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedRecyclerView");
            recyclerView = null;
        }
        GuildProfileFeedItemAdapter guildProfileFeedItemAdapter2 = this.feedListAdapter;
        if (guildProfileFeedItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
            guildProfileFeedItemAdapter2 = null;
        }
        recyclerView.setAdapter(guildProfileFeedItemAdapter2);
        RecyclerView recyclerView3 = this.feedRecyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedRecyclerView");
            recyclerView3 = null;
        }
        recyclerView3.setLayoutManager(new b(this.mFragment.getContext()));
        RecyclerView recyclerView4 = this.feedRecyclerView;
        if (recyclerView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedRecyclerView");
        } else {
            recyclerView2 = recyclerView4;
        }
        recyclerView2.addItemDecoration(new ProfileFeedItemDecoration());
    }

    private final void openMyFeedsFragment() {
        String e16 = this.mData.getGuildBaseProfileData().e();
        Logger.f235387a.d().d(TAG, 1, "[openMyFeedsFragment] guildId " + e16);
        Bundle bundle = new Bundle();
        JumpGuildParam.JoinInfoParam joinInfoParam = new JumpGuildParam.JoinInfoParam();
        joinInfoParam.setMainSource("profile_card");
        joinInfoParam.setSubSource("channel_profile_card");
        bundle.putParcelable(JumpGuildParam.KEY_JOIN_INFO_PARAM, joinInfoParam);
        bundle.putInt("feed_my_feeds_type", 3);
        IGuildFeedLauncherApi iGuildFeedLauncherApi = (IGuildFeedLauncherApi) QRoute.api(IGuildFeedLauncherApi.class);
        FragmentActivity requireActivity = this.mFragment.requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "mFragment.requireActivity()");
        String e17 = this.mData.getGuildBaseProfileData().e();
        Intrinsics.checkNotNullExpressionValue(e17, "mData.guildBaseProfileData.guildId");
        String b16 = this.mData.getGuildBaseProfileData().b();
        Intrinsics.checkNotNullExpressionValue(b16, "mData.guildBaseProfileData.dstTinyId");
        iGuildFeedLauncherApi.launchGuildFeedPostsLoadFragment(requireActivity, e17, b16, "profile_card", bundle);
        IGuildComponentController componentController = getComponentController();
        if (componentController != null) {
            componentController.handleDismissAction();
        }
    }

    private final void setContainerVisibleAwareLoading(int visibility) {
        this.visibility = visibility;
        if (!this.isLoading) {
            this.mViewContainer.setVisibility(visibility);
        }
    }

    private final void setFeedCount(String count) {
        ImageView imageView = null;
        TextView textView = null;
        if (!Intrinsics.areEqual(count, "") && !Intrinsics.areEqual(count, "0")) {
            TextView textView2 = this.feedCount;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT);
                textView2 = null;
            }
            textView2.setVisibility(0);
            ImageView imageView2 = this.moreArrow;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("moreArrow");
                imageView2 = null;
            }
            imageView2.setVisibility(0);
            TextView textView3 = this.feedCount;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT);
            } else {
                textView = textView3;
            }
            textView.setText(count);
            return;
        }
        TextView textView4 = this.feedCount;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(QFSSearchBaseRequest.EXTRA_KEY_FEED_COUNT);
            textView4 = null;
        }
        textView4.setVisibility(8);
        ImageView imageView3 = this.moreArrow;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("moreArrow");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(8);
    }

    private final void setFeedList(ArrayList<ProfileFeedItem> list) {
        GuildProfileFeedItemAdapter guildProfileFeedItemAdapter = this.feedListAdapter;
        if (guildProfileFeedItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
            guildProfileFeedItemAdapter = null;
        }
        guildProfileFeedItemAdapter.s0(list);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    @NotNull
    protected View createView(@Nullable Context context) {
        LinearLayout root = cp.g(LayoutInflater.from(context)).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "inflate(LayoutInflater.from(context)).root");
        return root;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    @NotNull
    /* renamed from: getComponentName */
    public String getTAG() {
        return TAG;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getComponentType() {
        return 1008;
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public int getContentLayoutId() {
        return R.layout.f1z;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.wug) {
            openMyFeedsFragment();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onCreate(@Nullable Fragment fragment, @Nullable AppInterface appInterface, @Nullable Bundle savedInstanceState) {
        super.onCreate(fragment, appInterface, savedInstanceState);
        bindUI();
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onDestroy() {
        super.onDestroy();
        Logger.f235387a.d().d(TAG, 1, "[onDestroy] ");
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadFinish() {
        this.isLoading = false;
        setContainerVisibleAwareLoading(this.visibility);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent, com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.a
    public void onLoadStart() {
        this.isLoading = true;
        this.mViewContainer.setVisibility(8);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onInitData(@Nullable GuildProfileData guildProfileData) {
        super.onInitData(guildProfileData);
        if (guildProfileData == null) {
            return;
        }
        boolean needShowFeed = guildProfileData.needShowFeed();
        boolean z16 = guildProfileData.getUserProfileInfo().getPublishedFeedShowSwitch() == 2;
        Logger.f235387a.d().d(TAG, 1, "[onInitData] needShowFeeds " + z16 + ", " + needShowFeed);
        bindViewModel();
        GuildProfileFeedViewModel guildProfileFeedViewModel = this.feedViewModel;
        GuildProfileFeedItemAdapter guildProfileFeedItemAdapter = null;
        if (guildProfileFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            guildProfileFeedViewModel = null;
        }
        guildProfileFeedViewModel.R1(guildProfileData);
        GuildProfileFeedItemAdapter guildProfileFeedItemAdapter2 = this.feedListAdapter;
        if (guildProfileFeedItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
        } else {
            guildProfileFeedItemAdapter = guildProfileFeedItemAdapter2;
        }
        guildProfileFeedItemAdapter.o0(guildProfileData);
        setContainerVisibleAwareLoading(needShowFeed ? 0 : 8);
    }

    @Override // com.tencent.mobileqq.guild.profile.profilecard.baseprofile.framework.component.AbsGuildProfileComponent
    public void onUpdateData(@NotNull GuildProfileData guildProfileData) {
        Intrinsics.checkNotNullParameter(guildProfileData, "guildProfileData");
        super.onUpdateData(guildProfileData);
        boolean needShowFeed = guildProfileData.needShowFeed();
        boolean z16 = guildProfileData.getUserProfileInfo().getPublishedFeedShowSwitch() == 2;
        Logger.f235387a.d().d(TAG, 1, "[onUpdateData] needShowFeeds " + z16 + ", " + needShowFeed);
        GuildProfileFeedViewModel guildProfileFeedViewModel = this.feedViewModel;
        GuildProfileFeedItemAdapter guildProfileFeedItemAdapter = null;
        if (guildProfileFeedViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedViewModel");
            guildProfileFeedViewModel = null;
        }
        guildProfileFeedViewModel.R1(guildProfileData);
        GuildProfileFeedItemAdapter guildProfileFeedItemAdapter2 = this.feedListAdapter;
        if (guildProfileFeedItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedListAdapter");
        } else {
            guildProfileFeedItemAdapter = guildProfileFeedItemAdapter2;
        }
        guildProfileFeedItemAdapter.o0(guildProfileData);
        setContainerVisibleAwareLoading(needShowFeed ? 0 : 8);
    }
}
