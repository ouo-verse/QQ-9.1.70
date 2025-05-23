package com.tencent.mobileqq.guild.setting.member.selector;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.quicksearch.GuildQuickSearchFragment;
import com.tencent.mobileqq.guild.quicksearch.model.SearchMemberInfo;
import com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.bt;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.search.ActionCallbackAdapter;
import com.tencent.mobileqq.widget.search.QUISearchBar;
import com.tencent.mobileqq.widget.search.QUISearchBarResource;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.richframework.widget.refresh.layout.SmartRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.api.IRefreshLayout;
import com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QzoneIPCModule;
import ef1.c;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.bx;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 ;2\u00020\u00012\u00020\u0002:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\u0012\u0010\u0019\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001dH\u0016J\"\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00101\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "Lcom/tencent/mobileqq/guild/setting/member/selector/q;", "", "initView", "initViewModel", "", "isSearchMode", "Qh", "Ph", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "needStatusTrans", "needImmersive", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Lcom/tencent/mobileqq/guild/setting/member/selector/s;", "memberData", "W2", "", "dg", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "guildId", "Lvp1/bx;", "D", "Lvp1/bx;", "binding", "Lcom/tencent/mobileqq/guild/setting/member/selector/d;", "E", "Lcom/tencent/mobileqq/guild/setting/member/selector/d;", "adapter", UserInfo.SEX_FEMALE, "searchAdapter", "Lcom/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorViewModel;", "G", "Lcom/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorViewModel;", "viewModel", "H", "Z", "startSearchList", "<init>", "()V", "I", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberSelectorFragment extends QPublicBaseFragment implements q {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: D, reason: from kotlin metadata */
    private bx binding;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.setting.member.selector.d adapter;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.setting.member.selector.d searchAdapter;

    /* renamed from: G, reason: from kotlin metadata */
    private GuildMemberSelectorViewModel viewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean startSearchList;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\n\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "requestCode", "", "a", "REQUEST_CODE_FOR_SELECT_MEMBER", "I", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String guildId, int requestCode) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            QPublicFragmentActivity.b.f(context, intent, QPublicFragmentActivity.class, GuildMemberSelectorFragment.class, requestCode);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorFragment$b", "Lcom/tencent/mobileqq/widget/search/QUISearchBarResource;", "Lcom/tencent/mobileqq/widget/search/QUISearchBar;", "bar", "Landroid/graphics/drawable/Drawable;", "getBackground", "", "getHintTextColor", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends QUISearchBarResource {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        @NotNull
        public Drawable getBackground(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            return new ColorDrawable(0);
        }

        @Override // com.tencent.mobileqq.widget.search.QUISearchBarResource
        public int getHintTextColor(@NotNull QUISearchBar bar) {
            Intrinsics.checkNotNullParameter(bar, "bar");
            return ie0.a.f().g(bar.getContext(), R.color.qui_common_text_secondary_light, bar.getCurThemeId());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorFragment$c", "Lcom/tencent/mobileqq/widget/search/ActionCallbackAdapter;", "", "onCancel", "", "onClear", "onBack", "", "onSearch", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c extends ActionCallbackAdapter {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onBack() {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildMemberSelectorFragment", "onBack");
                return false;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public int onCancel() {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildMemberSelectorFragment", "onCancel");
            }
            FragmentActivity activity = GuildMemberSelectorFragment.this.getActivity();
            if (activity != null) {
                activity.setResult(10213);
                activity.finish();
                return 2;
            }
            return 2;
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public boolean onClear() {
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildMemberSelectorFragment", "onCancel");
                return false;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.widget.search.ActionCallbackAdapter, com.tencent.mobileqq.widget.search.QUISearchBar.ActionCallback
        public void onSearch() {
            bx bxVar = GuildMemberSelectorFragment.this.binding;
            GuildMemberSelectorViewModel guildMemberSelectorViewModel = null;
            if (bxVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                bxVar = null;
            }
            String obj = bxVar.f442632h.getInputWidget().getText().toString();
            GuildMemberSelectorFragment.this.startSearchList = true;
            GuildMemberSelectorViewModel guildMemberSelectorViewModel2 = GuildMemberSelectorFragment.this.viewModel;
            if (guildMemberSelectorViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                guildMemberSelectorViewModel = guildMemberSelectorViewModel2;
            }
            guildMemberSelectorViewModel.j2(obj);
            Logger logger = Logger.f235387a;
            if (QLog.isDevelopLevel()) {
                Log.d("GuildMemberSelectorFragment", "onSearch\uff1a" + obj);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/member/selector/GuildMemberSelectorFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            if (newState != 1) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                int itemCount = ((LinearLayoutManager) layoutManager).getItemCount();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                Intrinsics.checkNotNull(layoutManager2, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                if (((LinearLayoutManager) layoutManager2).findLastCompletelyVisibleItemPosition() == itemCount - 1) {
                    GuildMemberSelectorViewModel guildMemberSelectorViewModel = GuildMemberSelectorFragment.this.viewModel;
                    if (guildMemberSelectorViewModel == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        guildMemberSelectorViewModel = null;
                    }
                    guildMemberSelectorViewModel.g2();
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f234654a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildMemberSelectorFragment f234655b;

        public e(ViewModelStoreOwner viewModelStoreOwner, GuildMemberSelectorFragment guildMemberSelectorFragment) {
            this.f234654a = viewModelStoreOwner;
            this.f234655b = guildMemberSelectorFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f234655b.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            TimedValue timedValue = new TimedValue(new GuildMemberSelectorViewModel(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(GuildMemberSelectorFragment this$0, IRefreshLayout it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        GuildMemberSelectorViewModel guildMemberSelectorViewModel = this$0.viewModel;
        if (guildMemberSelectorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel = null;
        }
        guildMemberSelectorViewModel.loadMore();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(GuildMemberSelectorFragment this$0, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!z16) {
            InputMethodUtil.hide(this$0.getActivity());
            return;
        }
        bt btVar = bt.f235484a;
        Intrinsics.checkNotNullExpressionValue(view, "view");
        bt.h(btVar, view, "em_sgrp_search_box", "clck", null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Kh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Nh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Ph() {
        VideoReport.addToDetectionWhitelist(getActivity());
        bx bxVar = this.binding;
        bx bxVar2 = null;
        if (bxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar = null;
        }
        VideoReport.setPageId(bxVar.getRoot(), "pg_sgrp_search_member");
        View view = getView();
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        com.tencent.mobileqq.guild.util.report.a.a(view, str, null);
        bx bxVar3 = this.binding;
        if (bxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar3 = null;
        }
        TextView cancelView = bxVar3.f442632h.getCancelView();
        Intrinsics.checkNotNullExpressionValue(cancelView, "binding.searchbar.cancelView");
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        bt.d(cancelView, "em_sgrp_search_cancel", null, clickPolicy, exposurePolicy, endExposurePolicy, 4, null);
        bx bxVar4 = this.binding;
        if (bxVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bxVar2 = bxVar4;
        }
        ImageView backView = bxVar2.f442632h.getBackView();
        Intrinsics.checkNotNullExpressionValue(backView, "binding.searchbar.backView");
        bt.d(backView, "em_sgrp_back_btn", null, clickPolicy, ExposurePolicy.REPORT_NONE, endExposurePolicy, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(boolean isSearchMode) {
        int i3;
        bx bxVar = this.binding;
        bx bxVar2 = null;
        if (bxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar = null;
        }
        SmartRefreshLayout smartRefreshLayout = bxVar.f442629e;
        Intrinsics.checkNotNullExpressionValue(smartRefreshLayout, "binding.refreshLayout");
        int i16 = 0;
        if (!isSearchMode) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        smartRefreshLayout.setVisibility(i3);
        bx bxVar3 = this.binding;
        if (bxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bxVar2 = bxVar3;
        }
        FrameLayout frameLayout = bxVar2.f442631g;
        Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.searchListContainer");
        if (!isSearchMode) {
            i16 = 8;
        }
        frameLayout.setVisibility(i16);
    }

    private final void initView() {
        Window window;
        bx bxVar = this.binding;
        bx bxVar2 = null;
        if (bxVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar = null;
        }
        bxVar.f442626b.getLayoutParams().height = ImmersiveUtils.statusHeight;
        FragmentActivity activity = getActivity();
        if (activity != null) {
            window = activity.getWindow();
        } else {
            window = null;
        }
        ImmersiveUtils.clearCoverForStatus(window, true);
        bx bxVar3 = this.binding;
        if (bxVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar3 = null;
        }
        bxVar3.f442627c.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.adapter = new com.tencent.mobileqq.guild.setting.member.selector.d(this);
        bx bxVar4 = this.binding;
        if (bxVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar4 = null;
        }
        RecyclerView recyclerView = bxVar4.f442627c;
        com.tencent.mobileqq.guild.setting.member.selector.d dVar = this.adapter;
        if (dVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            dVar = null;
        }
        recyclerView.setAdapter(dVar);
        bx bxVar5 = this.binding;
        if (bxVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar5 = null;
        }
        bxVar5.f442629e.setEnableRefresh(false).setEnableLoadMore(true).setEnableOverScrollBounce(true).setEnableOverScrollDrag(true);
        bx bxVar6 = this.binding;
        if (bxVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar6 = null;
        }
        bxVar6.f442629e.setOnLoadMoreListener(new OnLoadMoreListener() { // from class: com.tencent.mobileqq.guild.setting.member.selector.l
            @Override // com.tencent.richframework.widget.refresh.layout.listener.OnLoadMoreListener
            public final void onLoadMore(IRefreshLayout iRefreshLayout) {
                GuildMemberSelectorFragment.Gh(GuildMemberSelectorFragment.this, iRefreshLayout);
            }
        });
        this.searchAdapter = new com.tencent.mobileqq.guild.setting.member.selector.d(this);
        bx bxVar7 = this.binding;
        if (bxVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar7 = null;
        }
        bxVar7.f442630f.setLayoutManager(new LinearLayoutManager(getActivity()));
        bx bxVar8 = this.binding;
        if (bxVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar8 = null;
        }
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = bxVar8.f442630f;
        com.tencent.mobileqq.guild.setting.member.selector.d dVar2 = this.searchAdapter;
        if (dVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
            dVar2 = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setAdapter(dVar2);
        bx bxVar9 = this.binding;
        if (bxVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar9 = null;
        }
        bxVar9.f442630f.setItemAnimator(null);
        bx bxVar10 = this.binding;
        if (bxVar10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar10 = null;
        }
        bxVar10.f442632h.setSearchMode(1);
        bx bxVar11 = this.binding;
        if (bxVar11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar11 = null;
        }
        bxVar11.f442632h.setCustomResource(new b());
        bx bxVar12 = this.binding;
        if (bxVar12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar12 = null;
        }
        bxVar12.f442632h.getInputWidget().setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tencent.mobileqq.guild.setting.member.selector.m
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                GuildMemberSelectorFragment.Hh(GuildMemberSelectorFragment.this, view, z16);
            }
        });
        bx bxVar13 = this.binding;
        if (bxVar13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar13 = null;
        }
        bxVar13.f442632h.setActionCallback(new c());
        bx bxVar14 = this.binding;
        if (bxVar14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            bxVar14 = null;
        }
        bxVar14.f442632h.getInputWidget().clearFocus();
        bx bxVar15 = this.binding;
        if (bxVar15 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bxVar2 = bxVar15;
        }
        bxVar2.f442630f.addOnScrollListener(new d());
    }

    private final void initViewModel() {
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new e(this, this)).get(GuildMemberSelectorViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        GuildMemberSelectorViewModel guildMemberSelectorViewModel = (GuildMemberSelectorViewModel) viewModel;
        this.viewModel = guildMemberSelectorViewModel;
        GuildMemberSelectorViewModel guildMemberSelectorViewModel2 = null;
        if (guildMemberSelectorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel = null;
        }
        LiveData<List<a>> c26 = guildMemberSelectorViewModel.c2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends a>, Unit> function1 = new Function1<List<? extends a>, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment$initViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends a> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<? extends a> list) {
                d dVar;
                dVar = GuildMemberSelectorFragment.this.adapter;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("adapter");
                    dVar = null;
                }
                dVar.submitList(list);
            }
        };
        c26.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.selector.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberSelectorFragment.Kh(Function1.this, obj);
            }
        });
        GuildMemberSelectorViewModel guildMemberSelectorViewModel3 = this.viewModel;
        if (guildMemberSelectorViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel3 = null;
        }
        LiveData<cf1.b> toastEvent = guildMemberSelectorViewModel3.getToastEvent();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<cf1.b, Unit> function12 = new Function1<cf1.b, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment$initViewModel$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(cf1.b bVar) {
                invoke2(bVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(cf1.b bVar) {
                if (bVar == null || bVar.f30775b == 0) {
                    return;
                }
                SecurityTipHelperKt.E(GuildMemberSelectorFragment.this.getContext(), bVar, GuildMemberSelectorFragment.this.getString(R.string.f145790sf));
            }
        };
        toastEvent.observe(viewLifecycleOwner2, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.selector.f
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberSelectorFragment.Lh(Function1.this, obj);
            }
        });
        GuildMemberSelectorViewModel guildMemberSelectorViewModel4 = this.viewModel;
        if (guildMemberSelectorViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel4 = null;
        }
        LiveData<Boolean> f26 = guildMemberSelectorViewModel4.f2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function13 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment$initViewModel$4
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
            public final void invoke2(Boolean isSearchMode) {
                GuildMemberSelectorFragment guildMemberSelectorFragment = GuildMemberSelectorFragment.this;
                Intrinsics.checkNotNullExpressionValue(isSearchMode, "isSearchMode");
                guildMemberSelectorFragment.Qh(isSearchMode.booleanValue());
            }
        };
        f26.observe(viewLifecycleOwner3, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.selector.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberSelectorFragment.Mh(Function1.this, obj);
            }
        });
        GuildMemberSelectorViewModel guildMemberSelectorViewModel5 = this.viewModel;
        if (guildMemberSelectorViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel5 = null;
        }
        LiveData<Boolean> a26 = guildMemberSelectorViewModel5.a2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        final Function1<Boolean, Unit> function14 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment$initViewModel$5
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
            public final void invoke2(Boolean loadMoreFinish) {
                Intrinsics.checkNotNullExpressionValue(loadMoreFinish, "loadMoreFinish");
                if (loadMoreFinish.booleanValue()) {
                    bx bxVar = GuildMemberSelectorFragment.this.binding;
                    if (bxVar == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("binding");
                        bxVar = null;
                    }
                    bxVar.f442629e.finishLoadMore();
                }
            }
        };
        a26.observe(viewLifecycleOwner4, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.selector.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberSelectorFragment.Nh(Function1.this, obj);
            }
        });
        GuildMemberSelectorViewModel guildMemberSelectorViewModel6 = this.viewModel;
        if (guildMemberSelectorViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel6 = null;
        }
        LiveData<Integer> b26 = guildMemberSelectorViewModel6.b2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function15 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment$initViewModel$6
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(Integer num) {
                boolean z16;
                bx bxVar;
                GuildMemberSelectorViewModel.b.Companion companion2 = GuildMemberSelectorViewModel.b.INSTANCE;
                int b16 = companion2.b();
                if (num == null || num.intValue() != b16) {
                    int e16 = companion2.e();
                    if (num == null || num.intValue() != e16) {
                        z16 = false;
                        bxVar = GuildMemberSelectorFragment.this.binding;
                        if (bxVar == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("binding");
                            bxVar = null;
                        }
                        bxVar.f442629e.setEnableLoadMore(z16);
                    }
                }
                z16 = true;
                bxVar = GuildMemberSelectorFragment.this.binding;
                if (bxVar == null) {
                }
                bxVar.f442629e.setEnableLoadMore(z16);
            }
        };
        b26.observe(viewLifecycleOwner5, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.selector.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberSelectorFragment.Oh(Function1.this, obj);
            }
        });
        GuildMemberSelectorViewModel guildMemberSelectorViewModel7 = this.viewModel;
        if (guildMemberSelectorViewModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel7 = null;
        }
        LiveData<List<a>> e26 = guildMemberSelectorViewModel7.e2();
        LifecycleOwner viewLifecycleOwner6 = getViewLifecycleOwner();
        final GuildMemberSelectorFragment$initViewModel$7 guildMemberSelectorFragment$initViewModel$7 = new GuildMemberSelectorFragment$initViewModel$7(this);
        e26.observe(viewLifecycleOwner6, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.selector.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberSelectorFragment.Ih(Function1.this, obj);
            }
        });
        GuildMemberSelectorViewModel guildMemberSelectorViewModel8 = this.viewModel;
        if (guildMemberSelectorViewModel8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            guildMemberSelectorViewModel2 = guildMemberSelectorViewModel8;
        }
        LiveData<Integer> d26 = guildMemberSelectorViewModel2.d2();
        LifecycleOwner viewLifecycleOwner7 = getViewLifecycleOwner();
        final Function1<Integer, Unit> function16 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.setting.member.selector.GuildMemberSelectorFragment$initViewModel$8
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                d dVar;
                d dVar2;
                d dVar3;
                dVar = GuildMemberSelectorFragment.this.searchAdapter;
                d dVar4 = null;
                if (dVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
                    dVar = null;
                }
                if (dVar.getNUM_BACKGOURND_ICON() > 1) {
                    dVar2 = GuildMemberSelectorFragment.this.searchAdapter;
                    if (dVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
                        dVar2 = null;
                    }
                    dVar3 = GuildMemberSelectorFragment.this.searchAdapter;
                    if (dVar3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("searchAdapter");
                    } else {
                        dVar4 = dVar3;
                    }
                    dVar2.notifyItemChanged(dVar4.getNUM_BACKGOURND_ICON() - 1);
                }
            }
        };
        d26.observe(viewLifecycleOwner7, new Observer() { // from class: com.tencent.mobileqq.guild.setting.member.selector.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildMemberSelectorFragment.Jh(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.setting.member.selector.q
    public void W2(@NotNull MemberData memberData) {
        Map<String, ? extends Object> mapOf;
        Intrinsics.checkNotNullParameter(memberData, "memberData");
        Logger logger = Logger.f235387a;
        bx bxVar = null;
        if (QLog.isDevelopLevel()) {
            String str = this.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            Log.d("GuildMemberSelectorFragment", "onSelect(" + str + ", " + memberData.getTinyId() + ")");
        }
        Context context = getContext();
        if (context != null) {
            GuildQuickSearchFragment.Companion companion = GuildQuickSearchFragment.INSTANCE;
            String str2 = this.guildId;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str2 = null;
            }
            companion.c(context, str2, new SearchMemberInfo(memberData.getTinyId(), memberData.getName(), memberData.getUserType()), 1001);
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_user_member_type", Integer.valueOf(v.d(true, memberData.getUserType()))));
        bt btVar = bt.f235484a;
        bx bxVar2 = this.binding;
        if (bxVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bxVar = bxVar2;
        }
        RecyclerView recyclerView = bxVar.f442627c;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "binding.memberList");
        btVar.g(recyclerView, "em_sgrp_member", "clck", mapOf);
    }

    @Override // com.tencent.mobileqq.guild.setting.member.selector.q
    public int dg() {
        GuildMemberSelectorViewModel guildMemberSelectorViewModel = this.viewModel;
        if (guildMemberSelectorViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            guildMemberSelectorViewModel = null;
        }
        Integer value = guildMemberSelectorViewModel.d2().getValue();
        if (value == null) {
            return GuildMemberSelectorViewModel.b.INSTANCE.c();
        }
        return value.intValue();
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(3);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1001 && resultCode == 10213) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(10213);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        bx g16 = bx.g(LayoutInflater.from(getContext()), container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026ntext), container, false)");
        this.binding = g16;
        Bundle arguments = getArguments();
        bx bxVar = null;
        if (arguments != null) {
            str = arguments.getString("extra_guild_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        bx bxVar2 = this.binding;
        if (bxVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            bxVar = bxVar2;
        }
        LinearLayout root = bxVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        VideoReport.traverseExposure();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView();
        initViewModel();
        Ph();
    }
}
