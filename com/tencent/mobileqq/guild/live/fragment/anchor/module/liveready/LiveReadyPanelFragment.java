package com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.widget.ViewPager2;
import bh1.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter;
import com.tencent.mobileqq.guild.discover.widget.tab.TabLayout;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.livemanager.GLiveChannelCore;
import com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 P2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0003QRSB\u0007\u00a2\u0006\u0004\bN\u0010OJ\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\nH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\nH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0014J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u0012H\u0014J\u0012\u0010\u0017\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\u0006\u0010\u0018\u001a\u00020\nJ\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\bH\u0016J\b\u0010!\u001a\u00020 H\u0016J\b\u0010\"\u001a\u00020\nH\u0016J\b\u0010#\u001a\u00020\nH\u0016J\"\u0010(\u001a\u00020\n2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\b2\b\u0010'\u001a\u0004\u0018\u00010&H\u0016J\u0010\u0010*\u001a\u00020\n2\u0006\u0010)\u001a\u00020&H\u0016J\u0010\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020\nH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\u0010\u00101\u001a\u00020 2\u0006\u00100\u001a\u00020 H\u0016R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001a\u0010=\u001a\u00060:R\u00020\u00008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010A\u001a\u00020>8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001c\u0010G\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR(\u0010M\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020J0I0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010L\u00a8\u0006T"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment;", "Lcom/tencent/mobileqq/guild/live/fragment/base/QQGuildLiveModuleBaseFragment;", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$d;", "", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveSwipeBackLayout$b;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveSwipeBackLayout$c;", "", "", "th", "", "uh", "initViewPager", "position", "Landroidx/fragment/app/Fragment;", "sh", "clean", "getLayoutId", "Landroid/view/View;", "view", "initView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", "init", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$g;", "tab", "mf", "Nb", "h8", "nameInt", "wh", "", "needImmersive", "onPageSwipeClose", "onPageSwipeOpen", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "intent", "onNewIntent", "v", NodeProps.ON_CLICK, "onBackEvent", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onFinish", "begin", "onSwipe", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout;", "mTabLayout", "Landroidx/viewpager2/widget/ViewPager2;", "D", "Landroidx/viewpager2/widget/ViewPager2;", "mViewPager", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$c;", "E", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$c;", "mAdapter", "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveSwipeBackLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/live/widget/GuildLiveSwipeBackLayout;", "mLiveReadySwipeBackLayout", "G", "Landroid/view/View;", "mCloseIv", "H", "Ljava/util/List;", "tabList", "", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$b;", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyBaseFrag;", "I", "Ljava/util/Map;", "tabFragMap", "<init>", "()V", "J", "a", "b", "c", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class LiveReadyPanelFragment extends QQGuildLiveModuleBaseFragment implements TabLayout.d, GuildLiveSwipeBackLayout.b, View.OnClickListener, GuildLiveSwipeBackLayout.c {

    /* renamed from: C, reason: from kotlin metadata */
    private TabLayout mTabLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private ViewPager2 mViewPager;

    /* renamed from: E, reason: from kotlin metadata */
    private c mAdapter;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildLiveSwipeBackLayout mLiveReadySwipeBackLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private View mCloseIv;

    /* renamed from: H, reason: from kotlin metadata */
    private List<Integer> tabList;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Map<Integer, b<? extends LiveReadyBaseFrag>> tabFragMap;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u0000*\f\b\u0000\u0010\u0003*\u00020\u0001*\u00020\u00022\u00020\u0004B\u0007\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\u0005\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$b;", "Landroidx/fragment/app/Fragment;", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/e;", "T", "", "a", "()Landroidx/fragment/app/Fragment;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static abstract class b<T extends Fragment & com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e> {
        @NotNull
        public abstract T a();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0005H\u0014J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0004\u001a\u00020\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$c;", "Lcom/tencent/mobileqq/guild/discover/widget/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", "fragment", "", "m0", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/e;", "q0", "<init>", "(Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment;Landroidx/fragment/app/Fragment;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public final class c extends FragmentStateAdapter {
        final /* synthetic */ LiveReadyPanelFragment J;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(@NotNull LiveReadyPanelFragment liveReadyPanelFragment, Fragment fragment) {
            super(fragment);
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            this.J = liveReadyPanelFragment;
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter
        @NotNull
        public Fragment createFragment(int position) {
            return this.J.sh(position);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            List list = this.J.tabList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabList");
                list = null;
            }
            return list.size();
        }

        @Override // com.tencent.mobileqq.guild.discover.widget.FragmentStateAdapter
        protected void m0(@NotNull Fragment fragment) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
        }

        @Nullable
        public final com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e q0(int position) {
            ActivityResultCaller i06 = i0(position);
            if (i06 != null) {
                return (com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e) i06;
            }
            return null;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$d", "Lbh1/a$b;", "Lcom/tencent/mobileqq/guild/discover/widget/tab/TabLayout$g;", "tab", "", "position", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements a.b {
        d() {
        }

        @Override // bh1.a.b
        public void a(@NotNull TabLayout.g tab, int position) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            Resources resources = LiveReadyPanelFragment.this.getResources();
            List list = LiveReadyPanelFragment.this.tabList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabList");
                list = null;
            }
            tab.q(resources.getString(((Number) list.get(position)).intValue()));
        }
    }

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$e", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$b;", "a", "()Landroidx/fragment/app/Fragment;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e extends b<LiveGameReadyFragment> {
        @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyPanelFragment.b
        @NotNull
        public LiveGameReadyFragment a() {
            return new LiveGameReadyFragment();
        }
    }

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$f", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$b;", "a", "()Landroidx/fragment/app/Fragment;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f extends b<LiveProgramReadyFragment> {
        @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyPanelFragment.b
        @NotNull
        public LiveProgramReadyFragment a() {
            return new LiveProgramReadyFragment();
        }
    }

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$g", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$b;", "a", "()Landroidx/fragment/app/Fragment;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g extends b<LivePCAssistantFragment> {
        @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyPanelFragment.b
        @NotNull
        public LivePCAssistantFragment a() {
            return new LivePCAssistantFragment();
        }
    }

    @Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u000f\u0010\u0002\u001a\u00028\u0000H\u0016\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$h", "Lcom/tencent/mobileqq/guild/live/fragment/anchor/module/liveready/LiveReadyPanelFragment$b;", "a", "()Landroidx/fragment/app/Fragment;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h extends b<LiveReadyFragment> {
        @Override // com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.LiveReadyPanelFragment.b
        @NotNull
        public LiveReadyFragment a() {
            return new LiveReadyFragment();
        }
    }

    public LiveReadyPanelFragment() {
        Map<Integer, b<? extends LiveReadyBaseFrag>> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Integer.valueOf(R.string.f148560zx), new e()), TuplesKt.to(Integer.valueOf(R.string.f148580zz), new f()), TuplesKt.to(Integer.valueOf(R.string.f148570zy), new g()), TuplesKt.to(Integer.valueOf(R.string.f14859100), new h()));
        this.tabFragMap = mapOf;
    }

    private final void clean() {
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (!Intrinsics.areEqual(gLiveChannelCore.t().D().getValue(), Boolean.TRUE)) {
            gLiveChannelCore.n().w();
        }
    }

    private final void initViewPager() {
        this.mAdapter = new c(this, this);
        ViewPager2 viewPager2 = this.mViewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager2 = null;
        }
        c cVar = this.mAdapter;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            cVar = null;
        }
        viewPager2.setAdapter(cVar);
        ViewPager2 viewPager23 = this.mViewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager23 = null;
        }
        viewPager23.setUserInputEnabled(false);
        if (!AppSetting.t(requireActivity())) {
            ViewPager2 viewPager24 = this.mViewPager;
            if (viewPager24 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
                viewPager24 = null;
            }
            List<Integer> list = this.tabList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tabList");
                list = null;
            }
            viewPager24.setOffscreenPageLimit(list.size());
        }
        ViewPager2 viewPager25 = this.mViewPager;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
        } else {
            viewPager22 = viewPager25;
        }
        viewPager22.getChildAt(0).setOverScrollMode(2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Fragment sh(int position) {
        List<Integer> list = this.tabList;
        TabLayout tabLayout = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabList");
            list = null;
        }
        list.size();
        Map<Integer, b<? extends LiveReadyBaseFrag>> map = this.tabFragMap;
        List<Integer> list2 = this.tabList;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabList");
            list2 = null;
        }
        b<? extends LiveReadyBaseFrag> bVar = map.get(list2.get(position));
        Intrinsics.checkNotNull(bVar);
        LiveReadyBaseFrag a16 = bVar.a();
        TabLayout tabLayout2 = this.mTabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        } else {
            tabLayout = tabLayout2;
        }
        if (position == tabLayout.y()) {
            Intrinsics.checkNotNull(a16, "null cannot be cast to non-null type com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.ITabFragment");
            a16.onSelected(true);
        }
        return a16;
    }

    private final List<Integer> th() {
        ArrayList arrayList = new ArrayList();
        GLiveChannelCore gLiveChannelCore = GLiveChannelCore.f226698a;
        if (com.tencent.mobileqq.guild.live.helper.e.a(gLiveChannelCore.s().getGuildId())) {
            arrayList.add(0, Integer.valueOf(R.string.f148560zx));
        }
        if (com.tencent.mobileqq.guild.live.helper.e.b(gLiveChannelCore.s().getGuildId())) {
            arrayList.add(Integer.valueOf(R.string.f148580zz));
        }
        arrayList.add(Integer.valueOf(R.string.f148570zy));
        arrayList.add(Integer.valueOf(R.string.f14859100));
        return arrayList;
    }

    private final void uh() {
        TabLayout tabLayout;
        ViewPager2 viewPager2;
        TabLayout tabLayout2 = this.mTabLayout;
        TabLayout tabLayout3 = null;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayout = null;
        } else {
            tabLayout = tabLayout2;
        }
        ViewPager2 viewPager22 = this.mViewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            viewPager2 = null;
        } else {
            viewPager2 = viewPager22;
        }
        new bh1.a(tabLayout, viewPager2, true, false, false, new d()).a();
        TabLayout tabLayout4 = this.mTabLayout;
        if (tabLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayout4 = null;
        }
        tabLayout4.d(this);
        TabLayout tabLayout5 = this.mTabLayout;
        if (tabLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayout5 = null;
        }
        tabLayout5.setTabTextColors(getResources().getColor(R.color.brl), getResources().getColor(R.color.brm));
        int decodeInt = bw.L().decodeInt(ILaunchTroopSysMsgUIUtilApi.KEY_PUSH_TYPE, 1);
        if (decodeInt == 1 && com.tencent.mobileqq.guild.live.helper.e.a(GLiveChannelCore.f226698a.s().getGuildId())) {
            wh(R.string.f148560zx);
            return;
        }
        if (decodeInt == 2 && com.tencent.mobileqq.guild.live.helper.e.b(GLiveChannelCore.f226698a.s().getGuildId())) {
            wh(R.string.f148580zz);
            return;
        }
        if (decodeInt == 3) {
            wh(R.string.f148570zy);
            return;
        }
        if (decodeInt == 0) {
            wh(R.string.f14859100);
            return;
        }
        TabLayout tabLayout6 = this.mTabLayout;
        if (tabLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayout6 = null;
        }
        TabLayout tabLayout7 = this.mTabLayout;
        if (tabLayout7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        } else {
            tabLayout3 = tabLayout7;
        }
        tabLayout6.M(tabLayout3.z(0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
    public void Nb(@NotNull TabLayout.g tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        int g16 = tab.g();
        CharSequence h16 = tab.h();
        c cVar = this.mAdapter;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            cVar = null;
        }
        QLog.d("QGL.LiveReadyPanelFragment", 1, "[onTabSelected]-" + g16 + "-" + ((Object) h16) + "-" + cVar.q0(tab.g()));
        c cVar3 = this.mAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            cVar2 = cVar3;
        }
        com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e q06 = cVar2.q0(tab.g());
        if (q06 != null) {
            q06.d6();
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    protected int getLayoutId() {
        return R.layout.ex7;
    }

    @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
    public void h8(@NotNull TabLayout.g tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
    }

    public final void init() {
        initViewPager();
        uh();
        if (AppSetting.t(requireActivity())) {
            GuildLiveSwipeBackLayout guildLiveSwipeBackLayout = this.mLiveReadySwipeBackLayout;
            if (guildLiveSwipeBackLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLiveReadySwipeBackLayout");
                guildLiveSwipeBackLayout = null;
            }
            guildLiveSwipeBackLayout.setBackgroundColor(requireActivity().getResources().getColor(R.color.bqf));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment
    public void initView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.tabList = th();
        View findViewById = view.findViewById(R.id.j_o);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tab_layout)");
        this.mTabLayout = (TabLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.kwk);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.view_pager)");
        this.mViewPager = (ViewPager2) findViewById2;
        View findViewById3 = view.findViewById(R.id.ylz);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.l\u2026_ready_swipe_back_layout)");
        this.mLiveReadySwipeBackLayout = (GuildLiveSwipeBackLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.tzm);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.close_live_ready)");
        this.mCloseIv = findViewById4;
        GuildLiveSwipeBackLayout guildLiveSwipeBackLayout = this.mLiveReadySwipeBackLayout;
        ViewPager2 viewPager2 = null;
        if (guildLiveSwipeBackLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLiveReadySwipeBackLayout");
            guildLiveSwipeBackLayout = null;
        }
        guildLiveSwipeBackLayout.setOnPageSwipeListener(this);
        GuildLiveSwipeBackLayout guildLiveSwipeBackLayout2 = this.mLiveReadySwipeBackLayout;
        if (guildLiveSwipeBackLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLiveReadySwipeBackLayout");
            guildLiveSwipeBackLayout2 = null;
        }
        guildLiveSwipeBackLayout2.setOnSwipeListener(this);
        View view2 = this.mCloseIv;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseIv");
            view2 = null;
        }
        view2.setOnClickListener(this);
        if (AppSetting.t(requireActivity())) {
            ViewPager2 viewPager22 = this.mViewPager;
            if (viewPager22 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewPager");
            } else {
                viewPager2 = viewPager22;
            }
            viewPager2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.aa
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    LiveReadyPanelFragment.vh(view3);
                }
            });
        }
        init();
    }

    @Override // com.tencent.mobileqq.guild.discover.widget.tab.TabLayout.c
    public void mf(@NotNull TabLayout.g tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        int g16 = tab.g();
        CharSequence h16 = tab.h();
        c cVar = this.mAdapter;
        c cVar2 = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            cVar = null;
        }
        QLog.d("QGL.LiveReadyPanelFragment", 1, "[onTabSelected]-" + g16 + "-" + ((Object) h16) + "-" + cVar.q0(tab.g()));
        c cVar3 = this.mAdapter;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
        } else {
            cVar2 = cVar3;
        }
        com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e q06 = cVar2.q0(tab.g());
        if (q06 != null) {
            q06.onSelected(false);
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            InputMethodUtil.hide(activity);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Window window;
        super.onActivityCreated(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(32);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        c cVar = this.mAdapter;
        TabLayout tabLayout = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            cVar = null;
        }
        TabLayout tabLayout2 = this.mTabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        } else {
            tabLayout = tabLayout2;
        }
        com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e q06 = cVar.q0(tabLayout.y());
        if (q06 != null) {
            q06.E8(requestCode, resultCode);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        finishActivityJudgePadWithoutAnim();
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        View view = this.mCloseIv;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCloseIv");
            view = null;
        }
        if (Intrinsics.areEqual(v3, view)) {
            finishActivityJudgePadWithoutAnim();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QLog.i("QGL.LiveReadyPanelFragment", 1, "onDestroy.");
        clean();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        super.onFinish();
        clean();
    }

    @Override // com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onNewIntent(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        c cVar = this.mAdapter;
        TabLayout tabLayout = null;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAdapter");
            cVar = null;
        }
        TabLayout tabLayout2 = this.mTabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        } else {
            tabLayout = tabLayout2;
        }
        com.tencent.mobileqq.guild.live.fragment.anchor.module.liveready.e q06 = cVar.q0(tabLayout.y());
        if (q06 != null) {
            q06.Sb(intent);
        }
    }

    @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.b
    public void onPageSwipeClose() {
        QLog.d("QGL.LiveReadyPanelFragment", 4, "[onPageSwipeClose] ");
        finishActivityJudgePadWithAnim();
    }

    @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.b
    public void onPageSwipeOpen() {
        QLog.d("QGL.LiveReadyPanelFragment", 4, "[onPageSwipeOpen] ");
    }

    @Override // com.tencent.mobileqq.guild.live.widget.GuildLiveSwipeBackLayout.c
    public boolean onSwipe(boolean begin) {
        return true;
    }

    public void wh(int nameInt) {
        List<Integer> list = this.tabList;
        TabLayout tabLayout = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabList");
            list = null;
        }
        int indexOf = list.indexOf(Integer.valueOf(nameInt));
        TabLayout tabLayout2 = this.mTabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
            tabLayout2 = null;
        }
        TabLayout tabLayout3 = this.mTabLayout;
        if (tabLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTabLayout");
        } else {
            tabLayout = tabLayout3;
        }
        tabLayout2.N(tabLayout.z(indexOf), true);
    }
}
