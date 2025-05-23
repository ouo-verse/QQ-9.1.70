package com.tencent.mobileqq.guild.mission.beginmission.presentdialog;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildRouterApi;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.BaseDialogFragment;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateDialogFragment;
import com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment;
import com.tencent.mobileqq.guild.mission.beginmission.presentdialog.MissionPresentFragment;
import com.tencent.mobileqq.guild.theme.GuildThemeManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProAppInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import uu1.e;
import xu1.MissionPresentItem;
import xu1.a;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u0011\u001a\u00020\u0005H\u0014J\b\u0010\u0012\u001a\u00020\u0002H\u0014J\u0006\u0010\u0013\u001a\u00020\u0002J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0005J\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00070\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u0010$\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/presentdialog/MissionPresentFragment;", "Lcom/tencent/mobileqq/guild/channel/create/fragment/BaseCreateSubChannelFragment;", "", "Dh", "Eh", "", "index", "Lxu1/g;", OcrConfig.CHINESE, "Bh", "Ih", "position", "Hh", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProAppInfo;", "appBean", "Landroid/os/Bundle;", "yh", "getContentLayoutId", "init", "initDtReport", "Jh", "", "Ah", "Landroid/view/View;", UserInfo.SEX_FEMALE, "Landroid/view/View;", "clickInterceptBg", "Landroidx/viewpager2/widget/ViewPager2;", "G", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/google/android/material/tabs/TabLayout;", "H", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "submit", "Lxu1/a;", "J", "Lxu1/a;", "adapter", "", "K", "Ljava/lang/String;", "guildId", "L", "missionId", "<init>", "()V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class MissionPresentFragment extends BaseCreateSubChannelFragment {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final int[] N = {5, 2, 1, 7};

    @NotNull
    private static final String[] P = {"\u76f4\u64ad\u5b50\u9891\u9053", "\u97f3\u89c6\u9891\u5b50\u9891\u9053", "\u8ba8\u8bba\u5b50\u9891\u9053", "\u5e16\u5b50\u5b50\u9891\u9053", "\u65e5\u7a0b\u5b50\u9891\u9053"};

    @NotNull
    private static final String[] Q = {"\u89c2\u770b\u9891\u9053\u5185\u7cbe\u5f69\u5206\u4eab", "\u591a\u4eba\u8bed\u97f3\u8fde\u9ea6\uff0c\u5728\u7ebf\u4e92\u76f8\u966a\u4f34", "\u4e0e\u9891\u9053\u597d\u53cb\u5373\u65f6\u7545\u804a", "\u6c89\u6dc0\u9891\u9053\u7cbe\u534e\u5185\u5bb9", "\u6709\u5e8f\u7ec4\u7ec7\u9891\u9053\u5185\u6d3b\u52a8\u65e5\u7a0b"};

    @NotNull
    private static final String[] R = {"live.png", "voice.png", "word.png", "forum.png", "date.png"};

    @NotNull
    private static final String[] S = {"live_night.png", "voice_night.png", "word_night.png", "forum_night.png", "date_night.png"};

    @NotNull
    private static final String[] T = {"\u65b0\u4eba\u6b22\u8fce\u8bed", "\u9891\u9053\u7b49\u7ea7\u4f53\u7cfb", "\u8eab\u4efd\u7ec4\u5206\u914d"};

    @NotNull
    private static final String[] U = {"\u505a\u4e2a\u793c\u8c8c\u7684\u9891\u9053\u4e3b\uff0c\u7cbe\u5fc3\u6b22\u8fce\u65b0\u6210\u5458", "\u5b9a\u5236\u9891\u9053\u6210\u5458\u7b49\u7ea7\uff0c\u4fc3\u8fdb\u9891\u9053\u6d3b\u8dc3", "\u8bbe\u7f6e\u4e0d\u540c\u7684\u8eab\u4efd\u7ec4\u6743\u9650\uff0c\u8ba9\u9891\u9053\u4e95\u7136\u6709\u5e8f"};

    @NotNull
    private static final String[] V = {"welcome.png", "level.png", "role.png"};

    @NotNull
    private static final String[] W = {"welcome_night.png", "level_night.png", "role_night.png"};

    /* renamed from: F, reason: from kotlin metadata */
    private View clickInterceptBg;

    /* renamed from: G, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: H, reason: from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: I, reason: from kotlin metadata */
    private TextView submit;

    /* renamed from: J, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: K, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: L, reason: from kotlin metadata */
    private int missionId = -1;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u001d\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0013\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0014\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000e\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/mission/beginmission/presentdialog/MissionPresentFragment$a;", "", "", "guildId", "", "missionId", "Lcom/tencent/mobileqq/guild/mission/beginmission/presentdialog/MissionPresentFragment;", "b", "", "channelTitle", "[Ljava/lang/String;", "a", "()[Ljava/lang/String;", "EXTRA_KEY_GUILD_ID", "Ljava/lang/String;", "MISSION_ID", "TAG", "channelPreFix", "createPreFix", "robotPreFix", "robotText", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mission.beginmission.presentdialog.MissionPresentFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String[] a() {
            return MissionPresentFragment.P;
        }

        @NotNull
        public final MissionPresentFragment b(@NotNull String guildId, int missionId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Logger.f235387a.d().d("Guild.mission.RobotMissionDialogFragment", 1, "show guildId:" + guildId);
            Bundle bundle = new Bundle();
            bundle.putString("guild_id", guildId);
            bundle.putInt("mission_id", missionId);
            MissionPresentFragment missionPresentFragment = new MissionPresentFragment();
            missionPresentFragment.setArguments(bundle);
            return missionPresentFragment;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/mission/beginmission/presentdialog/MissionPresentFragment$b", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements TabLayout.d {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(MissionPresentFragment this$0, TabLayout.g tab, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(tab, "$tab");
            if (!QQGuildUIUtil.v()) {
                this$0.Hh(tab.g());
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(MissionPresentFragment this$0, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (!QQGuildUIUtil.v()) {
                BaseDialogFragment baseDialogFragment = this$0.E;
                if (baseDialogFragment != null) {
                    baseDialogFragment.dismiss();
                }
                this$0.Ih();
            }
            EventCollector.getInstance().onViewClicked(view);
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(@NotNull final TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
            int i3 = MissionPresentFragment.this.missionId;
            TextView textView = null;
            if (i3 != 1) {
                if (i3 == 2) {
                    TextView textView2 = MissionPresentFragment.this.submit;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("submit");
                        textView2 = null;
                    }
                    textView2.setText("\u8bbe\u7f6e\u7ba1\u7406\u673a\u5668\u4eba\u670d\u52a1");
                    TextView textView3 = MissionPresentFragment.this.submit;
                    if (textView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("submit");
                    } else {
                        textView = textView3;
                    }
                    final MissionPresentFragment missionPresentFragment = MissionPresentFragment.this;
                    textView.setOnClickListener(new View.OnClickListener() { // from class: xu1.f
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view) {
                            MissionPresentFragment.b.d(MissionPresentFragment.this, view);
                        }
                    });
                    return;
                }
                return;
            }
            MissionPresentFragment.this.Jh(tab.g());
            TextView textView4 = MissionPresentFragment.this.submit;
            if (textView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("submit");
                textView4 = null;
            }
            textView4.setText("\u521b\u5efa" + MissionPresentFragment.INSTANCE.a()[tab.g()]);
            TextView textView5 = MissionPresentFragment.this.submit;
            if (textView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("submit");
            } else {
                textView = textView5;
            }
            final MissionPresentFragment missionPresentFragment2 = MissionPresentFragment.this;
            textView.setOnClickListener(new View.OnClickListener() { // from class: xu1.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MissionPresentFragment.b.c(MissionPresentFragment.this, tab, view);
                }
            });
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(@NotNull TabLayout.g tab) {
            Intrinsics.checkNotNullParameter(tab, "tab");
        }
    }

    private final MissionPresentItem Bh(int index) {
        if (GuildThemeManager.f235286a.b()) {
            return new MissionPresentItem(T[index], U[index], "https://downv6.qq.com/innovate/guild/tips/guild_task_robot_" + W[index]);
        }
        return new MissionPresentItem(T[index], U[index], "https://downv6.qq.com/innovate/guild/tips/guild_task_robot_" + V[index]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ch(MissionPresentFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseDialogFragment baseDialogFragment = this$0.E;
        if (baseDialogFragment != null) {
            baseDialogFragment.dismiss();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Dh() {
        String str;
        Integer num;
        boolean z16;
        Bundle arguments = getArguments();
        String str2 = null;
        if (arguments != null) {
            str = arguments.getString("guild_id", "");
        } else {
            str = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            num = Integer.valueOf(arguments2.getInt("mission_id", -1));
        } else {
            num = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && num != null && num.intValue() >= 0) {
            this.guildId = str;
            this.missionId = num.intValue();
            e eVar = e.f440046e;
            String str3 = this.guildId;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
            } else {
                str2 = str3;
            }
            eVar.m(str2);
            return;
        }
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void Eh() {
        ViewPager2 viewPager2 = this.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        View childAt = viewPager2.getChildAt(0);
        Intrinsics.checkNotNull(childAt, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView) childAt).setOverScrollMode(2);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager23 = null;
        }
        View childAt2 = viewPager23.getChildAt(0);
        Intrinsics.checkNotNull(childAt2, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        ((RecyclerView) childAt2).setNestedScrollingEnabled(false);
        this.adapter = new a();
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager24 = null;
        }
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar = null;
        }
        viewPager24.setAdapter(aVar);
        TabLayout tabLayout = this.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayout = null;
        }
        ViewPager2 viewPager25 = this.viewPager;
        if (viewPager25 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager25 = null;
        }
        new d(tabLayout, viewPager25, new d.b() { // from class: xu1.c
            @Override // com.google.android.material.tabs.d.b
            public final void a(TabLayout.g gVar, int i3) {
                MissionPresentFragment.Fh(gVar, i3);
            }
        }).a();
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
            tabLayout2 = null;
        }
        tabLayout2.f(new b());
        a aVar2 = this.adapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            aVar2 = null;
        }
        aVar2.k0(Ah());
        ViewPager2 viewPager26 = this.viewPager;
        if (viewPager26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager26;
        }
        viewPager22.post(new Runnable() { // from class: xu1.d
            @Override // java.lang.Runnable
            public final void run() {
                MissionPresentFragment.Gh(MissionPresentFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fh(TabLayout.g gVar, int i3) {
        Intrinsics.checkNotNullParameter(gVar, "<anonymous parameter 0>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(MissionPresentFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPager2 viewPager2 = this$0.viewPager;
        ViewPager2 viewPager22 = null;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            viewPager2 = null;
        }
        ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
        ViewPager2 viewPager23 = this$0.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        } else {
            viewPager22 = viewPager23;
        }
        layoutParams.height = viewPager22.getMeasuredHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hh(int position) {
        String str = this.guildId;
        String str2 = null;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        e eVar = e.f440046e;
        String str3 = this.guildId;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str3 = null;
        }
        CreateSubChannelInfo createSubChannelInfo = new CreateSubChannelInfo(str, eVar.h(str3), "main_setting");
        int[] iArr = N;
        if (position < iArr.length) {
            createSubChannelInfo.b(iArr[position]);
        } else if (position == iArr.length) {
            createSubChannelInfo.b(6);
            String str4 = this.guildId;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
            } else {
                str2 = str4;
            }
            IGProAppInfo g16 = eVar.g(str2, 1000050L);
            if (g16 == null) {
                return;
            } else {
                createSubChannelInfo.a(yh(g16));
            }
        } else {
            throw new IllegalArgumentException(" illegal position");
        }
        QQGuildSubChannelCreateDialogFragment Eh = QQGuildSubChannelCreateDialogFragment.Eh(createSubChannelInfo);
        Eh.Dh(this.E);
        Eh.show(requireActivity().getSupportFragmentManager(), "QQGuildAppSubChannelCreateDialogFragment");
        BaseDialogFragment baseDialogFragment = this.E;
        baseDialogFragment.D = Boolean.FALSE;
        baseDialogFragment.yh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ih() {
        IQQGuildRouterApi iQQGuildRouterApi = (IQQGuildRouterApi) QRoute.api(IQQGuildRouterApi.class);
        FragmentActivity activity = getActivity();
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        iQQGuildRouterApi.openRobotListAndOpenRobotProfileByRobotUin(activity, str, "2854202589");
    }

    private final Bundle yh(IGProAppInfo appBean) {
        Bundle bundle = new Bundle();
        bundle.putLong("appId", appBean.getAppId());
        bundle.putString("iconUrl", appBean.getIconUrl());
        bundle.putString("appName", appBean.getAppName());
        bundle.putString("appDescription", appBean.getAppDescription());
        bundle.putStringArrayList("previewUrls", new ArrayList<>(appBean.getPreViewList()));
        return bundle;
    }

    private final MissionPresentItem zh(int index) {
        if (GuildThemeManager.f235286a.b()) {
            return new MissionPresentItem(P[index], Q[index], "https://downv6.qq.com/innovate/guild/tips/guild_task_channel_" + S[index]);
        }
        return new MissionPresentItem(P[index], Q[index], "https://downv6.qq.com/innovate/guild/tips/guild_task_channel_" + R[index]);
    }

    @NotNull
    public final List<MissionPresentItem> Ah() {
        ArrayList arrayList = new ArrayList();
        int i3 = this.missionId;
        int i16 = 0;
        if (i3 != 1) {
            if (i3 == 2) {
                int length = T.length;
                while (i16 < length) {
                    arrayList.add(Bh(i16));
                    i16++;
                }
            }
        } else {
            int length2 = P.length;
            while (i16 < length2) {
                arrayList.add(zh(i16));
                i16++;
            }
        }
        return arrayList;
    }

    public final void Jh(int position) {
        int i3;
        int[] iArr = N;
        if (position < iArr.length) {
            i3 = iArr[position];
        } else if (position == iArr.length) {
            i3 = 6;
        } else {
            i3 = 0;
        }
        TextView textView = this.submit;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submit");
            textView = null;
        }
        VideoReport.setElementParam(textView, "sgrp_subchannel_type", Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f09;
    }

    @Override // com.tencent.mobileqq.guild.channel.create.fragment.BaseCreateSubChannelFragment
    protected void init() {
        Dh();
        View findViewById = this.C.findViewById(R.id.zbz);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R.id.mission_view_pager)");
        this.viewPager = (ViewPager2) findViewById;
        View findViewById2 = this.C.findViewById(R.id.j_o);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mRootView.findViewById(R.id.tab_layout)");
        this.tabLayout = (TabLayout) findViewById2;
        View findViewById3 = this.C.findViewById(R.id.j6n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mRootView.findViewById(R.id.submit)");
        this.submit = (TextView) findViewById3;
        View findViewById4 = this.C.findViewById(R.id.f164814ty2);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mRootView.findViewById(R.id.click_intercept_bg)");
        this.clickInterceptBg = findViewById4;
        if (findViewById4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clickInterceptBg");
            findViewById4 = null;
        }
        findViewById4.setOnClickListener(new View.OnClickListener() { // from class: xu1.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MissionPresentFragment.Ch(MissionPresentFragment.this, view);
            }
        });
        Eh();
        initDtReport();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v4, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r4v8, types: [android.view.View] */
    public final void initDtReport() {
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        int i3 = this.missionId;
        TextView textView = null;
        if (i3 != 1) {
            if (i3 == 2) {
                ViewGroup viewGroup3 = this.C;
                FragmentActivity activity = getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type android.app.Activity");
                String str = this.guildId;
                if (str == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildId");
                    str = null;
                }
                Object parent = viewGroup3.getParent();
                if (parent instanceof View) {
                    viewGroup2 = (View) parent;
                } else {
                    viewGroup2 = null;
                }
                if (viewGroup2 != null) {
                    viewGroup3 = viewGroup2;
                }
                VideoReport.addToDetectionWhitelist(activity);
                VideoReport.setPageId(viewGroup3, "pg_sgrp_master_guide_robot");
                ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(viewGroup3, str, null);
                TextView textView2 = this.submit;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("submit");
                } else {
                    textView = textView2;
                }
                ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
                ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
                VideoReport.setElementId(textView, "em_sgrp_master_guide_robot_set");
                VideoReport.setElementExposePolicy(textView, exposurePolicy);
                VideoReport.setElementClickPolicy(textView, clickPolicy);
                return;
            }
            return;
        }
        ViewGroup viewGroup4 = this.C;
        FragmentActivity activity2 = getActivity();
        Intrinsics.checkNotNull(activity2, "null cannot be cast to non-null type android.app.Activity");
        String str2 = this.guildId;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str2 = null;
        }
        Object parent2 = viewGroup4.getParent();
        if (parent2 instanceof View) {
            viewGroup = (View) parent2;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup4 = viewGroup;
        }
        VideoReport.addToDetectionWhitelist(activity2);
        VideoReport.setPageId(viewGroup4, "pg_sgrp_master_guide_subchannel");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(viewGroup4, str2, null);
        TextView textView3 = this.submit;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submit");
        } else {
            textView = textView3;
        }
        ExposurePolicy exposurePolicy2 = ExposurePolicy.REPORT_ALL;
        ClickPolicy clickPolicy2 = ClickPolicy.REPORT_ALL;
        VideoReport.setElementId(textView, "em_sgrp_master_guide_subchannel_create");
        VideoReport.setElementExposePolicy(textView, exposurePolicy2);
        VideoReport.setElementClickPolicy(textView, clickPolicy2);
    }
}
