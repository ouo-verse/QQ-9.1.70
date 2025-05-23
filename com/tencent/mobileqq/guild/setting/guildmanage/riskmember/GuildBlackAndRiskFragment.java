package com.tencent.mobileqq.guild.setting.guildmanage.riskmember;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quipagetabbar.QUIPageTabBar;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.blacklist.GuildBlacklistContentFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.p;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 $2\u00020\u0001:\u0002%&B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildBlackAndRiskFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initView", "th", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "isWrapContent", "needStatusTrans", "needImmersive", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "initWindowStyleAndAnimation", "Lvp1/p;", BdhLogUtil.LogTag.Tag_Conn, "Lvp1/p;", "binding", "", "D", "Ljava/lang/String;", "guildId", "", "E", "I", "targetTabIndex", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "TabPagerAdapter", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBlackAndRiskFragment extends QPublicBaseFragment {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final List<Integer> G;

    /* renamed from: C, reason: from kotlin metadata */
    private p binding;

    /* renamed from: D, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: E, reason: from kotlin metadata */
    private int targetTabIndex;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\b\u0010\u0010RK\u0010\u001a\u001a6\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u00130\u0012j\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00140\u0013`\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildBlackAndRiskFragment$TabPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "", "getCount", "position", "Landroidx/fragment/app/Fragment;", "getItem", "Landroidx/fragment/app/FragmentManager;", "d", "Landroidx/fragment/app/FragmentManager;", "getFm", "()Landroidx/fragment/app/FragmentManager;", "fm", "", "e", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/Function0;", "Lkotlin/collections/ArrayList;", "f", "Ljava/util/ArrayList;", "getTabs", "()Ljava/util/ArrayList;", "tabs", "<init>", "(Landroidx/fragment/app/FragmentManager;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class TabPagerAdapter extends FragmentStatePagerAdapter {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final FragmentManager fm;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String guildId;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final ArrayList<Pair<String, Function0<Fragment>>> tabs;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public TabPagerAdapter(@NotNull FragmentManager fm5, @NotNull String guildId) {
            super(fm5);
            Intrinsics.checkNotNullParameter(fm5, "fm");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.fm = fm5;
            this.guildId = guildId;
            ArrayList<Pair<String, Function0<Fragment>>> arrayList = new ArrayList<>();
            this.tabs = arrayList;
            arrayList.add(TuplesKt.to(HardCodeUtil.qqStr(R.string.f155931iu), new Function0<GuildBlacklistContentFragment>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildBlackAndRiskFragment.TabPagerAdapter.1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final GuildBlacklistContentFragment invoke() {
                    return GuildBlacklistContentFragment.Oh(TabPagerAdapter.this.getGuildId());
                }
            }));
            arrayList.add(TuplesKt.to(HardCodeUtil.qqStr(R.string.f156361k0), new Function0<GuildRiskMemberFragment>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildBlackAndRiskFragment.TabPagerAdapter.2
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @NotNull
                public final GuildRiskMemberFragment invoke() {
                    return GuildRiskMemberFragment.INSTANCE.a(TabPagerAdapter.this.getGuildId());
                }
            }));
        }

        @NotNull
        /* renamed from: d, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.tabs.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        @NotNull
        public Fragment getItem(int position) {
            return this.tabs.get(position).getSecond().invoke();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0006H\u0007R\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildBlackAndRiskFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "targetTab", "", "a", "BLACK_TAB_INDEX", "I", "EXTRA_KEY_TARGET_TAB", "Ljava/lang/String;", "RISK_TAB_INDEX", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildBlackAndRiskFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull String guildId, int targetTab) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("TARGET_TAB", targetTab);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildBlackAndRiskFragment.class);
        }

        Companion() {
        }
    }

    static {
        List<Integer> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.string.f155931iu), Integer.valueOf(R.string.f156361k0)});
        G = listOf;
    }

    private final void initView() {
        int collectionSizeOrDefault;
        FragmentManager childFragmentManager = getChildFragmentManager();
        Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
        String str = this.guildId;
        p pVar = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(childFragmentManager, str);
        p pVar2 = this.binding;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar2 = null;
        }
        pVar2.f443077f.setAdapter(tabPagerAdapter);
        p pVar3 = this.binding;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar3 = null;
        }
        QUIPageTabBar qUIPageTabBar = pVar3.f443075d;
        List<Integer> list = G;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(HardCodeUtil.qqStr(((Number) it.next()).intValue()));
        }
        Object[] array = arrayList.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        qUIPageTabBar.setTabData((String[]) array);
        p pVar4 = this.binding;
        if (pVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar4 = null;
        }
        QUIPageTabBar qUIPageTabBar2 = pVar4.f443075d;
        p pVar5 = this.binding;
        if (pVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar5 = null;
        }
        qUIPageTabBar2.setViewPager(pVar5.f443077f);
        p pVar6 = this.binding;
        if (pVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar6 = null;
        }
        pVar6.f443075d.setCurrentPosition(this.targetTabIndex);
        p pVar7 = this.binding;
        if (pVar7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar7 = null;
        }
        pVar7.f443077f.setCurrentItem(this.targetTabIndex, false);
        p pVar8 = this.binding;
        if (pVar8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar8 = null;
        }
        pVar8.f443075d.setTabChangeListener(new QUIPageTabBar.i() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.b
            @Override // com.tencent.biz.qui.quipagetabbar.QUIPageTabBar.i
            public final void I0(int i3, boolean z16) {
                GuildBlackAndRiskFragment.rh(GuildBlackAndRiskFragment.this, i3, z16);
            }
        });
        p pVar9 = this.binding;
        if (pVar9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            pVar = pVar9;
        }
        pVar.f443073b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.riskmember.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildBlackAndRiskFragment.sh(GuildBlackAndRiskFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void rh(GuildBlackAndRiskFragment this$0, int i3, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        InputMethodUtil.hide(this$0.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(GuildBlackAndRiskFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void th() {
        p pVar = this.binding;
        p pVar2 = null;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar = null;
        }
        pVar.f443076e.setFitsSystemWindows(true);
        p pVar3 = this.binding;
        if (pVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            pVar2 = pVar3;
        }
        pVar2.f443076e.setPadding(0, ImmersiveUtils.getStatusBarHeight(getContext()), 0, 0);
        QQGuildUIUtil.L(getActivity(), getResources().getColor(R.color.qui_common_bg_bottom_light));
        boolean z16 = !GuildThemeManager.f235286a.b();
        Window window = requireActivity().getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "requireActivity().window");
        GuildThemeManager.i(z16, window);
    }

    @JvmStatic
    public static final void uh(@NotNull Context context, @NotNull String str, int i3) {
        INSTANCE.a(context, str, i3);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(@Nullable Activity activity) {
        Window window;
        super.initWindowStyleAndAnimation(activity);
        if (activity != null && (window = activity.getWindow()) != null) {
            window.setSoftInputMode(35);
        }
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean isWrapContent() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        int i3 = 0;
        p g16 = p.g(LayoutInflater.from(getContext()), container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026ntext), container, false)");
        this.binding = g16;
        if (ImmersiveUtils.isSupporImmersive() == 1) {
            th();
        }
        Bundle arguments = getArguments();
        p pVar = null;
        if (arguments != null) {
            str = arguments.getString("extra_guild_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            i3 = arguments2.getInt("TARGET_TAB");
        }
        this.targetTabIndex = i3;
        p pVar2 = this.binding;
        if (pVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            pVar = pVar2;
        }
        LinearLayout root = pVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        p pVar = this.binding;
        if (pVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            pVar = null;
        }
        pVar.f443076e.setBackgroundColor(getResources().getColor(R.color.qui_common_bg_bottom_light));
        initView();
    }
}
