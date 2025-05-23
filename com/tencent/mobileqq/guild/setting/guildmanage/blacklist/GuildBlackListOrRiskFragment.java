package com.tencent.mobileqq.guild.setting.guildmanage.blacklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.guild.api.theme.QQGuildThemeManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.setting.guildmanage.riskmember.GuildRiskMemberFragment;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\t*\u0001!\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0014J&\u0010\r\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J\b\u0010\u000e\u001a\u00020\u0005H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001b\u0010 \u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/blacklist/GuildBlackListOrRiskFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "initView", "Dh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "ph", "onDestroyView", "Landroidx/fragment/app/FragmentContainerView;", "T", "Landroidx/fragment/app/FragmentContainerView;", "fragmentContainer", "Lcom/tencent/mobileqq/guild/setting/guildmanage/blacklist/GuildBlacklistContentFragment;", "U", "Lcom/tencent/mobileqq/guild/setting/guildmanage/blacklist/GuildBlacklistContentFragment;", "blacklistContentFragment", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberFragment;", "V", "Lcom/tencent/mobileqq/guild/setting/guildmanage/riskmember/GuildRiskMemberFragment;", "riskContentFragment", "W", "Lkotlin/Lazy;", "Eh", "()I", "contentMode", "com/tencent/mobileqq/guild/setting/guildmanage/blacklist/GuildBlackListOrRiskFragment$b", "X", "Lcom/tencent/mobileqq/guild/setting/guildmanage/blacklist/GuildBlackListOrRiskFragment$b;", "onThemeChanged", "<init>", "()V", "Y", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBlackListOrRiskFragment extends QQGuildTitleBarFragment {

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private FragmentContainerView fragmentContainer;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private GuildBlacklistContentFragment blacklistContentFragment;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private GuildRiskMemberFragment riskContentFragment;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final Lazy contentMode;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final b onThemeChanged;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/guildmanage/blacklist/GuildBlackListOrRiskFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "", "content", "", "a", "b", "c", "CONTENT_BLACKLIST", "I", "CONTENT_RISK", "KEY_CONTENT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.GuildBlackListOrRiskFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final void a(Context context, String guildId, int content) {
            Intent intent = new Intent();
            intent.putExtra("extra_guild_id", guildId);
            intent.putExtra("content", content);
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildBlackListOrRiskFragment.class);
        }

        @JvmStatic
        public final void b(@NotNull Context context, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            a(context, guildId, 1);
        }

        @JvmStatic
        public final void c(@NotNull Context context, @NotNull String guildId) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            a(context, guildId, 2);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/guild/setting/guildmanage/blacklist/GuildBlackListOrRiskFragment$b", "Lor0/a;", "", "onThemeChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements or0.a {
        b() {
        }

        @Override // or0.a
        public void onThemeChanged() {
            GuildBlackListOrRiskFragment.this.getTitleBarView().setBackgroundResource(R.drawable.qui_common_bg_bottom_light_bg);
            QQGuildUIUtil.L(GuildBlackListOrRiskFragment.this.getActivity(), GuildBlackListOrRiskFragment.this.requireActivity().getResources().getColor(R.color.qui_common_bg_bottom_light));
        }
    }

    public GuildBlackListOrRiskFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.guild.setting.guildmanage.blacklist.GuildBlackListOrRiskFragment$contentMode$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                Bundle arguments = GuildBlackListOrRiskFragment.this.getArguments();
                return Integer.valueOf(arguments != null ? arguments.getInt("content", 1) : 1);
            }
        });
        this.contentMode = lazy;
        this.onThemeChanged = new b();
    }

    private final void Dh() {
        String stringExtra = requireActivity().getIntent().getStringExtra("extra_guild_id");
        FragmentContainerView fragmentContainerView = null;
        if (Eh() == 1) {
            if (this.blacklistContentFragment == null) {
                FragmentManager childFragmentManager = getChildFragmentManager();
                Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
                FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
                Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
                GuildBlacklistContentFragment Oh = GuildBlacklistContentFragment.Oh(stringExtra);
                FragmentContainerView fragmentContainerView2 = this.fragmentContainer;
                if (fragmentContainerView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
                } else {
                    fragmentContainerView = fragmentContainerView2;
                }
                beginTransaction.replace(fragmentContainerView.getId(), Oh);
                this.blacklistContentFragment = Oh;
                beginTransaction.commitAllowingStateLoss();
                return;
            }
            return;
        }
        if (this.riskContentFragment == null) {
            FragmentManager childFragmentManager2 = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager2, "childFragmentManager");
            FragmentTransaction beginTransaction2 = childFragmentManager2.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction2, "beginTransaction()");
            GuildRiskMemberFragment.Companion companion = GuildRiskMemberFragment.INSTANCE;
            if (stringExtra == null) {
                stringExtra = "";
            }
            GuildRiskMemberFragment a16 = companion.a(stringExtra);
            FragmentContainerView fragmentContainerView3 = this.fragmentContainer;
            if (fragmentContainerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("fragmentContainer");
            } else {
                fragmentContainerView = fragmentContainerView3;
            }
            beginTransaction2.replace(fragmentContainerView.getId(), a16);
            this.riskContentFragment = a16;
            beginTransaction2.commitAllowingStateLoss();
        }
    }

    private final int Eh() {
        return ((Number) this.contentMode.getValue()).intValue();
    }

    @JvmStatic
    public static final void Fh(@NotNull Context context, @NotNull String str) {
        INSTANCE.b(context, str);
    }

    @JvmStatic
    public static final void Gh(@NotNull Context context, @NotNull String str) {
        INSTANCE.c(context, str);
    }

    private final void initView() {
        int i3;
        if (Eh() == 2) {
            i3 = R.string.f14903117;
        } else {
            i3 = R.string.f155931iu;
        }
        setTitle(getString(i3));
        View findViewById = this.P.findViewById(R.id.t8q);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewById(R.id.black_list_content)");
        this.fragmentContainer = (FragmentContainerView) findViewById;
        Dh();
        View titleBarView = getTitleBarView();
        Intrinsics.checkNotNull(titleBarView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon");
        ((GuildDefaultThemeNavBarCommon) titleBarView).a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        QQGuildThemeManager.c(this.onThemeChanged);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168041eh3;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        QQGuildThemeManager.d(this.onThemeChanged);
        super.onDestroyView();
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    protected int ph() {
        return R.color.qui_common_bg_bottom_light;
    }
}
