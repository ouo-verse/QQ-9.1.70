package com.tencent.mobileqq.guild.rolegroup.levelrole;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.q;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionEditFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.ChannelPermissionTypeForRole;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildRoleDetailFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.a;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.mini.servlet.MiniAppAddPhoneNumberServlet;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000_\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\r\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u000f\u0010\u000e\u001a\u00020\rH\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0004H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J&\u0010\u0019\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0007H\u0016R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u001b\u0010*\u001a\u00020%8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Landroid/view/View;", "view", "", "initView", "initData", "", MiniAppAddPhoneNumberServlet.KEY_IS_SAVE, "Lh", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "itemData", "Ph", "com/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectFragment$c", "Mh", "()Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectFragment$c;", "Sh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "onBackEvent", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleViewAndSelectParam;", "T", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleViewAndSelectParam;", "mParam", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectViewModel;", "U", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectViewModel;", "mLevelRoleViewModel", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a;", "V", "Lkotlin/Lazy;", "Nh", "()Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a;", "mAdapter", "<init>", "()V", "W", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildLevelRoleViewAndSelectFragment extends QQGuildTitleBarFragment {

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @Nullable
    private static List<String> X;

    /* renamed from: T, reason: from kotlin metadata */
    private LevelRoleViewAndSelectParam mParam;

    /* renamed from: U, reason: from kotlin metadata */
    private GuildLevelRoleViewAndSelectViewModel mLevelRoleViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u0019J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0007J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0007J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0007R0\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0012\u0010\u0013\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectFragment$a;", "", "Landroid/content/Context;", "context", "", "guildId", "title", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/PageLayoutType;", "layoutType", "", "c", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "fragment", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleViewAndSelectParam;", "param", "d", "b", "", "tempSelectedLvRoles", "Ljava/util/List;", "a", "()Ljava/util/List;", "e", "(Ljava/util/List;)V", "getTempSelectedLvRoles$annotations", "()V", "LEVEL_ROLE_VIEW_AND_SELECT_PARAM", "Ljava/lang/String;", "SELECTED_LEVEL_ROLES_CACHE_DATA", "TAG", "<init>", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Nullable
        public final List<String> a() {
            return GuildLevelRoleViewAndSelectFragment.X;
        }

        @JvmStatic
        public final void b(@NotNull Context context, @NotNull LevelRoleViewAndSelectParam param) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtra("LEVEL_ROLE_VIEW_AND_SELECT_PARAM", param);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            QPublicFragmentActivity.start(context, intent, GuildLevelRoleViewAndSelectFragment.class);
        }

        @JvmStatic
        public final void c(@NotNull Context context, @NotNull String guildId, @NotNull String title, @NotNull PageLayoutType layoutType) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(layoutType, "layoutType");
            b(context, new LevelRoleViewAndSelectParam(guildId, title, layoutType, null, null, false, 0, null, null, 504, null));
        }

        @JvmStatic
        public final void d(@NotNull QPublicBaseFragment fragment, @NotNull LevelRoleViewAndSelectParam param) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtra("LEVEL_ROLE_VIEW_AND_SELECT_PARAM", param);
            QPublicFragmentActivity.startForResult(fragment, intent, (Class<? extends QPublicBaseFragment>) GuildLevelRoleViewAndSelectFragment.class, param.getRequestCode());
        }

        public final void e(@Nullable List<String> list) {
            GuildLevelRoleViewAndSelectFragment.X = list;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232619a;

        static {
            int[] iArr = new int[PageLayoutType.values().length];
            try {
                iArr[PageLayoutType.MANAGE_AND_ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageLayoutType.MANAGE_AND_DELETE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[PageLayoutType.VIEW_LEVEL_ROLES_ENTRANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[PageLayoutType.BIND_CHANNEL_VISIBLE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[PageLayoutType.BIND_CHANNEL_SPEAKABLE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f232619a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\u000b\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/levelrole/GuildLevelRoleViewAndSelectFragment$c", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/a$b;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/guild/rolegroup/levelrole/LevelRoleUIData;", "itemData", "", "isChecked", "", "c", "d", "a", "", "roleId", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements a.b {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.levelrole.a.b
        public void a(@Nullable View v3, @NotNull LevelRoleUIData itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            if (!QQGuildUIUtil.v()) {
                GuildLevelRoleViewAndSelectFragment.this.Ph(itemData);
            }
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.levelrole.a.b
        public boolean b(@NotNull String roleId) {
            Intrinsics.checkNotNullParameter(roleId, "roleId");
            GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel = GuildLevelRoleViewAndSelectFragment.this.mLevelRoleViewModel;
            if (guildLevelRoleViewAndSelectViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
                guildLevelRoleViewAndSelectViewModel = null;
            }
            return guildLevelRoleViewAndSelectViewModel.a2(roleId);
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.levelrole.a.b
        public void c(@Nullable View v3, @NotNull LevelRoleUIData itemData, boolean isChecked) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel = GuildLevelRoleViewAndSelectFragment.this.mLevelRoleViewModel;
            if (guildLevelRoleViewAndSelectViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
                guildLevelRoleViewAndSelectViewModel = null;
            }
            guildLevelRoleViewAndSelectViewModel.O1(itemData, isChecked);
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.levelrole.a.b
        public void d(@Nullable View v3, @NotNull LevelRoleUIData itemData) {
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            if (!QQGuildUIUtil.v()) {
                LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = GuildLevelRoleViewAndSelectFragment.this.mParam;
                GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel = null;
                if (levelRoleViewAndSelectParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    levelRoleViewAndSelectParam = null;
                }
                if (levelRoleViewAndSelectParam.isCreating()) {
                    GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel2 = GuildLevelRoleViewAndSelectFragment.this.mLevelRoleViewModel;
                    if (guildLevelRoleViewAndSelectViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
                    } else {
                        guildLevelRoleViewAndSelectViewModel = guildLevelRoleViewAndSelectViewModel2;
                    }
                    guildLevelRoleViewAndSelectViewModel.P1(itemData);
                    return;
                }
                GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel3 = GuildLevelRoleViewAndSelectFragment.this.mLevelRoleViewModel;
                if (guildLevelRoleViewAndSelectViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
                } else {
                    guildLevelRoleViewAndSelectViewModel = guildLevelRoleViewAndSelectViewModel3;
                }
                guildLevelRoleViewAndSelectViewModel.b2(itemData);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildLevelRoleViewAndSelectFragment.this.Nh().i0((List) t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e<T> implements Observer {
        public e() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildLevelRoleViewAndSelectFragment.this.getRightTextView().setEnabled(((Boolean) t16).booleanValue());
        }
    }

    public GuildLevelRoleViewAndSelectFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment$mAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                List emptyList;
                Pair pair;
                GuildLevelRoleViewAndSelectFragment.c Mh;
                LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = GuildLevelRoleViewAndSelectFragment.this.mParam;
                if (levelRoleViewAndSelectParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    levelRoleViewAndSelectParam = null;
                }
                PageLayoutType pageLayoutType = levelRoleViewAndSelectParam.getPageLayoutType();
                LevelRoleViewAndSelectParam levelRoleViewAndSelectParam2 = GuildLevelRoleViewAndSelectFragment.this.mParam;
                if (levelRoleViewAndSelectParam2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    levelRoleViewAndSelectParam2 = null;
                }
                String guildId = levelRoleViewAndSelectParam2.getGuildId();
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                boolean contains = emptyList.contains(guildId);
                r rVar = r.f214743a;
                IRuntimeService S0 = ch.S0(IGPSService.class, "");
                Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
                IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
                Boolean valueOf = guildInfo != null ? Boolean.valueOf(guildInfo.isMovePostSection()) : null;
                if (contains) {
                    pair = TuplesKt.to(Boolean.TRUE, "HardCode");
                } else if (valueOf == null) {
                    pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
                } else {
                    pair = TuplesKt.to(valueOf, "GuildInfo");
                }
                GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
                String str = guildDebugUtils.e().get(guildId);
                String str2 = str != null ? str : "";
                Intrinsics.checkNotNullExpressionValue(str2, "newFeedSquareResults.get(guildId) ?: \"\"");
                String pair2 = pair.toString();
                if (!Intrinsics.areEqual(str2, pair2)) {
                    Logger logger = Logger.f235387a;
                    if (QLog.isColorLevel()) {
                        logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
                    }
                    guildDebugUtils.e().put(guildId, pair2);
                }
                boolean booleanValue = ((Boolean) pair.getFirst()).booleanValue();
                Mh = GuildLevelRoleViewAndSelectFragment.this.Mh();
                return new a(pageLayoutType, booleanValue, Mh);
            }
        });
        this.mAdapter = lazy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v7, types: [com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData[], java.io.Serializable] */
    private final void Lh(boolean isSave) {
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = this.mParam;
        List<String> list = null;
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel = null;
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel2 = null;
        if (levelRoleViewAndSelectParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam = null;
        }
        int i3 = b.f232619a[levelRoleViewAndSelectParam.getPageLayoutType().ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                FragmentActivity requireActivity = requireActivity();
                Intent intent = new Intent();
                GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel3 = this.mLevelRoleViewModel;
                if (guildLevelRoleViewAndSelectViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
                } else {
                    guildLevelRoleViewAndSelectViewModel = guildLevelRoleViewAndSelectViewModel3;
                }
                intent.putExtra("SELECTED_LEVEL_ROLES_CACHE_DATA", (Serializable) guildLevelRoleViewAndSelectViewModel.T1());
                Unit unit = Unit.INSTANCE;
                requireActivity.setResult(-1, intent);
                return;
            }
            return;
        }
        if (isSave) {
            GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel4 = this.mLevelRoleViewModel;
            if (guildLevelRoleViewAndSelectViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
            } else {
                guildLevelRoleViewAndSelectViewModel2 = guildLevelRoleViewAndSelectViewModel4;
            }
            list = guildLevelRoleViewAndSelectViewModel2.Z1();
        }
        X = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c Mh() {
        return new c();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a Nh() {
        return (a) this.mAdapter.getValue();
    }

    @Nullable
    public static final List<String> Oh() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(LevelRoleUIData itemData) {
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = this.mParam;
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam2 = null;
        if (levelRoleViewAndSelectParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam = null;
        }
        int i3 = b.f232619a[levelRoleViewAndSelectParam.getPageLayoutType().ordinal()];
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 == 5) {
                    ChannelPermissionEditFragment.Companion companion = ChannelPermissionEditFragment.INSTANCE;
                    Context requireContext = requireContext();
                    Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
                    ChannelPermissionTypeForRole channelPermissionTypeForRole = ChannelPermissionTypeForRole.ApproveSpeak;
                    LevelRoleViewAndSelectParam levelRoleViewAndSelectParam3 = this.mParam;
                    if (levelRoleViewAndSelectParam3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    } else {
                        levelRoleViewAndSelectParam2 = levelRoleViewAndSelectParam3;
                    }
                    companion.b(requireContext, channelPermissionTypeForRole, levelRoleViewAndSelectParam2.getGuildId(), itemData.getRoleId(), 0);
                    return;
                }
                return;
            }
            ChannelPermissionEditFragment.Companion companion2 = ChannelPermissionEditFragment.INSTANCE;
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            ChannelPermissionTypeForRole channelPermissionTypeForRole2 = ChannelPermissionTypeForRole.ApproveVisible;
            LevelRoleViewAndSelectParam levelRoleViewAndSelectParam4 = this.mParam;
            if (levelRoleViewAndSelectParam4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
            } else {
                levelRoleViewAndSelectParam2 = levelRoleViewAndSelectParam4;
            }
            companion2.b(requireContext2, channelPermissionTypeForRole2, levelRoleViewAndSelectParam2.getGuildId(), itemData.getRoleId(), 0);
            return;
        }
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam5 = this.mParam;
        if (levelRoleViewAndSelectParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        } else {
            levelRoleViewAndSelectParam2 = levelRoleViewAndSelectParam5;
        }
        GuildRoleDetailFragment.Di(levelRoleViewAndSelectParam2.getGuildId(), 2, itemData.getRoleId(), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qh(GuildLevelRoleViewAndSelectFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Lh(true);
        super.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    @JvmStatic
    public static final void Rh(@NotNull Context context, @NotNull LevelRoleViewAndSelectParam levelRoleViewAndSelectParam) {
        INSTANCE.b(context, levelRoleViewAndSelectParam);
    }

    private final void Sh() {
        HashMap hashMapOf;
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = this.mParam;
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam2 = null;
        if (levelRoleViewAndSelectParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam = null;
        }
        if (levelRoleViewAndSelectParam.getPageLayoutType() != PageLayoutType.VIEW_LEVEL_ROLES_ENTRANCE) {
            return;
        }
        VideoReport.addToDetectionWhitelist(requireActivity());
        VideoReport.setPageId(this.P, "pg_sgrp_level_role_set");
        Pair[] pairArr = new Pair[1];
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam3 = this.mParam;
        if (levelRoleViewAndSelectParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam3 = null;
        }
        pairArr[0] = TuplesKt.to("sgrp_sub_channel_id", levelRoleViewAndSelectParam3.getChannelId());
        hashMapOf = MapsKt__MapsKt.hashMapOf(pairArr);
        w.a(hashMapOf);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view = this.P;
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam4 = this.mParam;
        if (levelRoleViewAndSelectParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        } else {
            levelRoleViewAndSelectParam2 = levelRoleViewAndSelectParam4;
        }
        iGuildDTReportApi.setGuildPageParams(view, levelRoleViewAndSelectParam2.getGuildId(), hashMapOf);
    }

    public static final void Th(@Nullable List<String> list) {
        INSTANCE.e(list);
    }

    private final void initData() {
        List<String> emptyList;
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel = (GuildLevelRoleViewAndSelectViewModel) ef1.c.INSTANCE.c(this, GuildLevelRoleViewAndSelectViewModel.class, new Function0<GuildLevelRoleViewAndSelectViewModel>() { // from class: com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildLevelRoleViewAndSelectViewModel invoke() {
                LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = GuildLevelRoleViewAndSelectFragment.this.mParam;
                if (levelRoleViewAndSelectParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    levelRoleViewAndSelectParam = null;
                }
                return new GuildLevelRoleViewAndSelectViewModel(levelRoleViewAndSelectParam);
            }
        });
        this.mLevelRoleViewModel = guildLevelRoleViewAndSelectViewModel;
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel2 = null;
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel3 = null;
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = null;
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel4 = null;
        if (guildLevelRoleViewAndSelectViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
            guildLevelRoleViewAndSelectViewModel = null;
        }
        LiveData<List<LevelRoleUIData>> X1 = guildLevelRoleViewAndSelectViewModel.X1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        X1.observe(viewLifecycleOwner, new d());
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel5 = this.mLevelRoleViewModel;
        if (guildLevelRoleViewAndSelectViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
            guildLevelRoleViewAndSelectViewModel5 = null;
        }
        LiveData<Boolean> U1 = guildLevelRoleViewAndSelectViewModel5.U1();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        U1.observe(viewLifecycleOwner2, new e());
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam2 = this.mParam;
        if (levelRoleViewAndSelectParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam2 = null;
        }
        int i3 = b.f232619a[levelRoleViewAndSelectParam2.getPageLayoutType().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3 || i3 == 4 || i3 == 5) {
                    GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel6 = this.mLevelRoleViewModel;
                    if (guildLevelRoleViewAndSelectViewModel6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
                    } else {
                        guildLevelRoleViewAndSelectViewModel3 = guildLevelRoleViewAndSelectViewModel6;
                    }
                    guildLevelRoleViewAndSelectViewModel3.S1();
                    return;
                }
                return;
            }
            LevelRoleViewAndSelectParam levelRoleViewAndSelectParam3 = this.mParam;
            if (levelRoleViewAndSelectParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                levelRoleViewAndSelectParam3 = null;
            }
            if (levelRoleViewAndSelectParam3.isCreating()) {
                GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel7 = this.mLevelRoleViewModel;
                if (guildLevelRoleViewAndSelectViewModel7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
                    guildLevelRoleViewAndSelectViewModel7 = null;
                }
                LevelRoleViewAndSelectParam levelRoleViewAndSelectParam4 = this.mParam;
                if (levelRoleViewAndSelectParam4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                } else {
                    levelRoleViewAndSelectParam = levelRoleViewAndSelectParam4;
                }
                ArrayList<RoleLabelData> allRolesSelected = levelRoleViewAndSelectParam.getAllRolesSelected();
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                guildLevelRoleViewAndSelectViewModel7.c2(allRolesSelected, emptyList);
                return;
            }
            GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel8 = this.mLevelRoleViewModel;
            if (guildLevelRoleViewAndSelectViewModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
            } else {
                guildLevelRoleViewAndSelectViewModel4 = guildLevelRoleViewAndSelectViewModel8;
            }
            guildLevelRoleViewAndSelectViewModel4.S1();
            return;
        }
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel9 = this.mLevelRoleViewModel;
        if (guildLevelRoleViewAndSelectViewModel9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
            guildLevelRoleViewAndSelectViewModel9 = null;
        }
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam5 = this.mParam;
        if (levelRoleViewAndSelectParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam5 = null;
        }
        ArrayList<RoleLabelData> allRolesSelected2 = levelRoleViewAndSelectParam5.getAllRolesSelected();
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam6 = this.mParam;
        if (levelRoleViewAndSelectParam6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam6 = null;
        }
        guildLevelRoleViewAndSelectViewModel9.c2(allRolesSelected2, levelRoleViewAndSelectParam6.getTempSelectedLvRoles());
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel10 = this.mLevelRoleViewModel;
        if (guildLevelRoleViewAndSelectViewModel10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
        } else {
            guildLevelRoleViewAndSelectViewModel2 = guildLevelRoleViewAndSelectViewModel10;
        }
        guildLevelRoleViewAndSelectViewModel2.S1();
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.wlo);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guild_level_role_list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setAdapter(Nh());
        recyclerView.setLayoutManager(new com.tencent.mobileqq.guild.media.widget.audiofaceview.e(getContext()));
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = null;
        q.b(recyclerView, ViewUtils.dpToPx(16.0f), 0, 2, null);
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam2 = this.mParam;
        if (levelRoleViewAndSelectParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam2 = null;
        }
        setTitle(levelRoleViewAndSelectParam2.getTitle());
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam3 = this.mParam;
        if (levelRoleViewAndSelectParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        } else {
            levelRoleViewAndSelectParam = levelRoleViewAndSelectParam3;
        }
        if (levelRoleViewAndSelectParam.getPageLayoutType() == PageLayoutType.MANAGE_AND_ADD) {
            setRightButtonText(getResources().getString(R.string.f143340lt), new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.rolegroup.levelrole.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    GuildLevelRoleViewAndSelectFragment.Qh(GuildLevelRoleViewAndSelectFragment.this, view2);
                }
            });
            getRightTextView().setEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Serializable serializable = requireArguments().getSerializable("LEVEL_ROLE_VIEW_AND_SELECT_PARAM");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.levelrole.LevelRoleViewAndSelectParam");
        this.mParam = (LevelRoleViewAndSelectParam) serializable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.evu;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        Lh(false);
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        LevelRoleViewAndSelectParam levelRoleViewAndSelectParam = this.mParam;
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel = null;
        if (levelRoleViewAndSelectParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            levelRoleViewAndSelectParam = null;
        }
        if (levelRoleViewAndSelectParam.getPageLayoutType() != PageLayoutType.VIEW_LEVEL_ROLES_ENTRANCE) {
            LevelRoleViewAndSelectParam levelRoleViewAndSelectParam2 = this.mParam;
            if (levelRoleViewAndSelectParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                levelRoleViewAndSelectParam2 = null;
            }
            if (levelRoleViewAndSelectParam2.getPageLayoutType() != PageLayoutType.BIND_CHANNEL_VISIBLE) {
                LevelRoleViewAndSelectParam levelRoleViewAndSelectParam3 = this.mParam;
                if (levelRoleViewAndSelectParam3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    levelRoleViewAndSelectParam3 = null;
                }
                if (levelRoleViewAndSelectParam3.getPageLayoutType() != PageLayoutType.BIND_CHANNEL_SPEAKABLE) {
                    return;
                }
            }
        }
        GuildLevelRoleViewAndSelectViewModel guildLevelRoleViewAndSelectViewModel2 = this.mLevelRoleViewModel;
        if (guildLevelRoleViewAndSelectViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLevelRoleViewModel");
        } else {
            guildLevelRoleViewAndSelectViewModel = guildLevelRoleViewAndSelectViewModel2;
        }
        guildLevelRoleViewAndSelectViewModel.S1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
        Sh();
    }
}
