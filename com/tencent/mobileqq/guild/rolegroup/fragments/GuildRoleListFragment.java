package com.tencent.mobileqq.guild.rolegroup.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.monitor.metric.event.TagValue;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.GuildProgressDialog;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.q;
import com.tencent.mobileqq.guild.nt.perf.api.IPerfApi;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.CreateRoleItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.LevelRoleItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.LevelRoleTipItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.RoleEveryoneItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.RoleItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.RoleVisitorItem;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.p;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.r;
import com.tencent.mobileqq.guild.rolegroup.adapters.rolelist.w;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildAdminRoleFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildCategoryAdminRoleFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildChannelAdminRoleFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildCreatorRoleFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildMemberOrVisitorRoleFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildRoleDetailFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleUtils;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.PageLayoutType;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleToMemberListModel;
import com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller;
import com.tencent.mobileqq.guild.rolegroup.model.repositories.s;
import com.tencent.mobileqq.guild.rolegroup.view.MovableTouchHelper;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.RoleGroupListViewModel;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.cn;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon;
import com.tencent.mobileqq.guild.widget.ItemTouchHelper;
import com.tencent.mobileqq.guild.widget.OverScrollRecyclerViewWithHeaderFooter;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildRoleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d8\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u000f*\u0002,d\b\u0016\u0018\u0000 o2\u00020\u0001:\u0002pqB\u0007\u00a2\u0006\u0004\bm\u0010nJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0012\u001a\u00020\u0002H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u0002H\u0002JH\u0010&\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010!\u001a\u00020\u00172,\b\u0002\u0010%\u001a&\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u00010\"j\u0012\u0012\u0004\u0012\u00020\u0017\u0012\u0006\u0012\u0004\u0018\u00010#\u0018\u0001`$H\u0002J\u0018\u0010+\u001a\u00020*2\u0006\u0010'\u001a\u00020\u001b2\u0006\u0010)\u001a\u00020(H\u0002J\u000f\u0010-\u001a\u00020,H\u0002\u00a2\u0006\u0004\b-\u0010.J\b\u0010/\u001a\u00020(H\u0014J&\u00106\u001a\u00020\u00022\b\u00101\u001a\u0004\u0018\u0001002\b\u00103\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u000104H\u0014J\b\u00107\u001a\u00020\u0002H\u0016J\b\u00108\u001a\u00020*H\u0016R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010[\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\ba\u0010bR\u0014\u0010g\u001a\u00020d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0014\u0010\u000f\u001a\u00020\u000e8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bh\u0010iR\u0014\u0010l\u001a\u00020\u00138BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bj\u0010k\u00a8\u0006r"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "Rh", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Oh", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Ph", "initViewModel", "Lcf1/b;", "event", "Xh", "hi", "gi", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "showState", "Wh", "ai", "ci", "Landroid/view/View;", "v", "Zh", "Yh", "", "roleId", "bi", "di", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/r;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Th", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/s;", "Vh", "initDtReport", "id", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "param", "ei", TagValue.IGNORE, "", "position", "", "Uh", "com/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$c", "Nh", "()Lcom/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$c;", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "onResume", "onBackEvent", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "T", "Lcom/tencent/mobileqq/guild/widget/OverScrollRecyclerViewWithHeaderFooter;", "recyclerView", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/w;", "U", "Lcom/tencent/mobileqq/guild/rolegroup/adapters/rolelist/w;", "adapter", "Lcom/tencent/mobileqq/guild/base/GuildProgressDialog;", "V", "Lcom/tencent/mobileqq/guild/base/GuildProgressDialog;", "loadingDialog", "Lcom/tencent/mobileqq/guild/widget/ItemTouchHelper;", "W", "Lcom/tencent/mobileqq/guild/widget/ItemTouchHelper;", "touchHelper", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$Param;", "X", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$Param;", "params", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel;", "Y", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel;", "roleGroupViewModel", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "Z", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon;", "titleBar", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "a0", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "b0", "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller;", "c0", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller;", "memberPuller", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "d0", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "defaultItemAnimator", "com/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$k", "e0", "Lcom/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$k;", "pullResultListener", "Qh", "()Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/RoleGroupListViewModel$ShowState;", "getContentView", "()Landroid/view/View;", "contentView", "<init>", "()V", "f0", "a", "Param", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class GuildRoleListFragment extends QQGuildTitleBarFragment {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private OverScrollRecyclerViewWithHeaderFooter recyclerView;

    /* renamed from: U, reason: from kotlin metadata */
    private w adapter;

    /* renamed from: V, reason: from kotlin metadata */
    private GuildProgressDialog loadingDialog;

    /* renamed from: W, reason: from kotlin metadata */
    private ItemTouchHelper touchHelper;

    /* renamed from: X, reason: from kotlin metadata */
    private Param params;

    /* renamed from: Y, reason: from kotlin metadata */
    private RoleGroupListViewModel roleGroupViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    private GuildDefaultThemeNavBarCommon titleBar;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private RoleGroupModel role;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private GuildMemberPuller memberPuller;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private RecyclerView.ItemAnimator defaultItemAnimator;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final k pullResultListener = new k();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$Param;", "Ljava/io/Serializable;", "guildId", "", "(Ljava/lang/String;)V", "getGuildId", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class Param implements Serializable {

        @NotNull
        private final String guildId;

        public Param(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            this.guildId = guildId;
        }

        public static /* synthetic */ Param copy$default(Param param, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = param.guildId;
            }
            return param.copy(str);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        public final Param copy(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            return new Param(guildId);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof Param) && Intrinsics.areEqual(this.guildId, ((Param) other).guildId)) {
                return true;
            }
            return false;
        }

        @NotNull
        public final String getGuildId() {
            return this.guildId;
        }

        public int hashCode() {
            return this.guildId.hashCode();
        }

        @NotNull
        public String toString() {
            return "Param(guildId=" + this.guildId + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$a;", "", "", "guildId", "Landroid/content/Intent;", "a", "PARAM_FRAGMENT", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final Intent a(@NotNull String guildId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intent intent = new Intent();
            intent.putExtra("PARAM_FRAGMENT", new Param(guildId));
            return intent;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232469a;

        /* renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f232470b;

        static {
            int[] iArr = new int[RoleGroupListViewModel.RunningState.values().length];
            try {
                iArr[RoleGroupListViewModel.RunningState.REFRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RoleGroupListViewModel.RunningState.REORDER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RoleGroupListViewModel.RunningState.ADD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RoleGroupListViewModel.RunningState.REMOVE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RoleGroupListViewModel.RunningState.UPDATE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RoleGroupListViewModel.RunningState.FINISH.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[RoleGroupListViewModel.RunningState.ERROR.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[RoleGroupListViewModel.RunningState.PAGE_END.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            f232469a = iArr;
            int[] iArr2 = new int[RoleGroupListViewModel.ShowState.values().length];
            try {
                iArr2[RoleGroupListViewModel.ShowState.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[RoleGroupListViewModel.ShowState.SORTABLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            f232470b = iArr2;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0013"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$c", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewHolder", "", "a", "", "c", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "source", "target", "b", "Lcom/tencent/mobileqq/guild/rolegroup/view/MovableTouchHelper$IMovableEventHandler$MoveDirection;", "e", "", "sourcePosition", "targetPosition", "d", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements MovableTouchHelper.IMovableEventHandler {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.MovableTouchHelper.IMovableEventHandler
        public void a(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildRoleListFragment.this.recyclerView;
            if (overScrollRecyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                overScrollRecyclerViewWithHeaderFooter = null;
            }
            overScrollRecyclerViewWithHeaderFooter.M();
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.MovableTouchHelper.IMovableEventHandler
        public boolean b(@NotNull RecyclerView recyclerView, @NotNull RecyclerView.ViewHolder source, @NotNull RecyclerView.ViewHolder target) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(target, "target");
            if (Intrinsics.areEqual(source, target)) {
                return false;
            }
            Object tag = source.itemView.getTag();
            Object tag2 = target.itemView.getTag();
            if ((tag instanceof r) && (tag2 instanceof r)) {
                RoleGroupListViewModel roleGroupListViewModel = GuildRoleListFragment.this.roleGroupViewModel;
                if (roleGroupListViewModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
                    roleGroupListViewModel = null;
                }
                roleGroupListViewModel.j2((r) tag, (r) tag2);
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.MovableTouchHelper.IMovableEventHandler
        public boolean c(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            w wVar = GuildRoleListFragment.this.adapter;
            if (wVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                wVar = null;
            }
            return wVar.j0(viewHolder.getAdapterPosition());
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.MovableTouchHelper.IMovableEventHandler
        public void d(int sourcePosition, int targetPosition, @NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = GuildRoleListFragment.this.recyclerView;
            if (overScrollRecyclerViewWithHeaderFooter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                overScrollRecyclerViewWithHeaderFooter = null;
            }
            overScrollRecyclerViewWithHeaderFooter.P();
            OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = GuildRoleListFragment.this.recyclerView;
            if (overScrollRecyclerViewWithHeaderFooter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
                overScrollRecyclerViewWithHeaderFooter2 = null;
            }
            overScrollRecyclerViewWithHeaderFooter2.setItemAnimator(null);
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.view.MovableTouchHelper.IMovableEventHandler
        @NotNull
        public MovableTouchHelper.IMovableEventHandler.MoveDirection e(@NotNull RecyclerView.ViewHolder viewHolder) {
            Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
            return MovableTouchHelper.IMovableEventHandler.MoveDirection.BOTH;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$d", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d extends RecyclerView.OnScrollListener {
        d() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                ((IPerfApi) QRoute.api(IPerfApi.class)).stopMonitorDropFrame("qqguild_role_group_list");
            } else {
                ((IPerfApi) QRoute.api(IPerfApi.class)).startMonitorDropFrame("qqguild_role_group_list");
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$e", "Lcom/tencent/mobileqq/guild/widget/GuildDefaultThemeNavBarCommon$a;", "Landroid/view/View;", "view", "", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "onItemSelect", "v", "", "onItemLongClick", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class e implements GuildDefaultThemeNavBarCommon.a {
        e() {
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public boolean onItemLongClick(@Nullable View v3, int item) {
            return false;
        }

        @Override // com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon.a
        public void onItemSelect(@NotNull View view, int item) {
            Intrinsics.checkNotNullParameter(view, "view");
            if (item != 1) {
                RoleGroupListViewModel roleGroupListViewModel = null;
                if (item != 2) {
                    if (item != 4) {
                        if (item == 8) {
                            GuildRoleListFragment guildRoleListFragment = GuildRoleListFragment.this;
                            if (!o.c("fastClickGuard")) {
                                guildRoleListFragment.requireActivity().onBackPressed();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    GuildRoleListFragment guildRoleListFragment2 = GuildRoleListFragment.this;
                    if (!o.c("fastClickGuard")) {
                        RoleGroupListViewModel roleGroupListViewModel2 = guildRoleListFragment2.roleGroupViewModel;
                        if (roleGroupListViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
                        } else {
                            roleGroupListViewModel = roleGroupListViewModel2;
                        }
                        roleGroupListViewModel.o2(RoleGroupListViewModel.ShowState.SORTABLE);
                        return;
                    }
                    return;
                }
                GuildRoleListFragment guildRoleListFragment3 = GuildRoleListFragment.this;
                if (!o.c("fastClickGuard")) {
                    RoleGroupListViewModel roleGroupListViewModel3 = guildRoleListFragment3.roleGroupViewModel;
                    if (roleGroupListViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
                    } else {
                        roleGroupListViewModel = roleGroupListViewModel3;
                    }
                    roleGroupListViewModel.q2();
                    return;
                }
                return;
            }
            GuildRoleListFragment guildRoleListFragment4 = GuildRoleListFragment.this;
            if (!o.c("fastClickGuard")) {
                guildRoleListFragment4.requireActivity().onBackPressed();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class f<T> implements Observer {
        public f() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            List<T> list = (List) t16;
            w wVar = GuildRoleListFragment.this.adapter;
            if (wVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                wVar = null;
            }
            wVar.submitList(list);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g<T> implements Observer {
        public g() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildRoleListFragment.this.Xh((cf1.b) t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h<T> implements Observer {
        public h() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildRoleListFragment.this.guildId = (String) t16;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i<T> implements Observer {
        public i() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildRoleListFragment.this.Wh((RoleGroupListViewModel.ShowState) t16);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class j<T> implements Observer {
        public j() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildProgressDialog guildProgressDialog;
            GuildProgressDialog guildProgressDialog2;
            GuildProgressDialog guildProgressDialog3;
            GuildProgressDialog guildProgressDialog4;
            GuildProgressDialog guildProgressDialog5;
            RoleGroupListViewModel.RunningState runningState = (RoleGroupListViewModel.RunningState) t16;
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.rg.RoleGroupListFragment", 2, "liveState -> " + runningState);
            }
            GuildProgressDialog guildProgressDialog6 = null;
            switch (b.f232469a[runningState.ordinal()]) {
                case 1:
                    GuildProgressDialog guildProgressDialog7 = GuildRoleListFragment.this.loadingDialog;
                    if (guildProgressDialog7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                        guildProgressDialog = null;
                    } else {
                        guildProgressDialog = guildProgressDialog7;
                    }
                    GuildProgressDialog.f(guildProgressDialog, "\u52a0\u8f7d\u5217\u8868\u4e2d", 0L, 2, null);
                    return;
                case 2:
                    GuildProgressDialog guildProgressDialog8 = GuildRoleListFragment.this.loadingDialog;
                    if (guildProgressDialog8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                        guildProgressDialog2 = null;
                    } else {
                        guildProgressDialog2 = guildProgressDialog8;
                    }
                    GuildProgressDialog.f(guildProgressDialog2, "\u6392\u5e8f\u8eab\u4efd\u4e2d", 0L, 2, null);
                    return;
                case 3:
                    GuildProgressDialog guildProgressDialog9 = GuildRoleListFragment.this.loadingDialog;
                    if (guildProgressDialog9 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                        guildProgressDialog3 = null;
                    } else {
                        guildProgressDialog3 = guildProgressDialog9;
                    }
                    GuildProgressDialog.f(guildProgressDialog3, "\u65b0\u589e\u8eab\u4efd\u4e2d", 0L, 2, null);
                    return;
                case 4:
                    GuildProgressDialog guildProgressDialog10 = GuildRoleListFragment.this.loadingDialog;
                    if (guildProgressDialog10 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                        guildProgressDialog4 = null;
                    } else {
                        guildProgressDialog4 = guildProgressDialog10;
                    }
                    GuildProgressDialog.f(guildProgressDialog4, "\u6b63\u5728\u5220\u9664\u4e2d", 0L, 2, null);
                    return;
                case 5:
                    GuildProgressDialog guildProgressDialog11 = GuildRoleListFragment.this.loadingDialog;
                    if (guildProgressDialog11 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                        guildProgressDialog5 = null;
                    } else {
                        guildProgressDialog5 = guildProgressDialog11;
                    }
                    GuildProgressDialog.f(guildProgressDialog5, "\u6b63\u5728\u66f4\u65b0\u4e2d", 0L, 2, null);
                    return;
                case 6:
                    GuildProgressDialog guildProgressDialog12 = GuildRoleListFragment.this.loadingDialog;
                    if (guildProgressDialog12 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                    } else {
                        guildProgressDialog6 = guildProgressDialog12;
                    }
                    guildProgressDialog6.c();
                    return;
                case 7:
                    GuildProgressDialog guildProgressDialog13 = GuildRoleListFragment.this.loadingDialog;
                    if (guildProgressDialog13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("loadingDialog");
                    } else {
                        guildProgressDialog6 = guildProgressDialog13;
                    }
                    guildProgressDialog6.c();
                    return;
                case 8:
                    FragmentActivity activity = GuildRoleListFragment.this.getActivity();
                    if (activity != null) {
                        activity.finish();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/fragments/GuildRoleListFragment$k", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$b;", "Lri1/a;", "error", "Lcom/tencent/mobileqq/guild/rolegroup/model/puller/GuildMemberPuller$PullStep;", "step", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/j;", "listModel", "", "totalMemberNum", "", "h1", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class k implements GuildMemberPuller.b {
        k() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.model.puller.GuildMemberPuller.b
        public void h1(@NotNull ri1.a error, @NotNull GuildMemberPuller.PullStep step, @Nullable RoleToMemberListModel listModel, int totalMemberNum) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(step, "step");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("Guild.rg.RoleGroupListFragment", 2, "pull member result: " + error + ", " + step + ", " + listModel);
            }
        }
    }

    private final c Nh() {
        return new c();
    }

    private final RecyclerView.OnScrollListener Oh() {
        return new d();
    }

    private final GuildDefaultThemeNavBarCommon.a Ph() {
        return new e();
    }

    private final RoleGroupListViewModel.ShowState Qh() {
        RoleGroupListViewModel roleGroupListViewModel = this.roleGroupViewModel;
        if (roleGroupListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel = null;
        }
        RoleGroupListViewModel.ShowState value = roleGroupListViewModel.h2().getValue();
        if (value == null) {
            value = RoleGroupListViewModel.ShowState.NORMAL;
        }
        Intrinsics.checkNotNullExpressionValue(value, "roleGroupViewModel.liveS\u2026value ?: ShowState.NORMAL");
        return value;
    }

    private final void Rh() {
        this.adapter = new w(RoleGroupListViewModel.ShowState.NORMAL, new p(new GuildRoleListFragment$initUi$1(this), new GuildRoleListFragment$initUi$2(this)));
        View findViewById = getContentView().findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.list)");
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = (OverScrollRecyclerViewWithHeaderFooter) findViewById;
        this.recyclerView = overScrollRecyclerViewWithHeaderFooter;
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        overScrollRecyclerViewWithHeaderFooter.setLayoutManager(new LinearLayoutManager(getActivity()));
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        RecyclerView.ItemAnimator itemAnimator = overScrollRecyclerViewWithHeaderFooter2.getItemAnimator();
        Intrinsics.checkNotNull(itemAnimator);
        this.defaultItemAnimator = itemAnimator;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter3 = this.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter3 = null;
        }
        overScrollRecyclerViewWithHeaderFooter3.setItemAnimator(null);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter4 = this.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter4 = null;
        }
        w wVar = this.adapter;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            wVar = null;
        }
        overScrollRecyclerViewWithHeaderFooter4.setAdapter(wVar);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter5 = this.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter5 = null;
        }
        q.b(overScrollRecyclerViewWithHeaderFooter5, ViewUtils.dpToPx(16.0f), 0, 2, null);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter6 = this.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter6 = null;
        }
        overScrollRecyclerViewWithHeaderFooter6.addOnScrollListener(Oh());
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.loadingDialog = new GuildProgressDialog(requireActivity, 0L, 2, null);
        MovableTouchHelper movableTouchHelper = MovableTouchHelper.f232805a;
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter7 = this.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter7 = null;
        }
        this.touchHelper = movableTouchHelper.b(overScrollRecyclerViewWithHeaderFooter7, Nh());
        View titleBarView = getTitleBarView();
        Intrinsics.checkNotNull(titleBarView, "null cannot be cast to non-null type com.tencent.mobileqq.guild.widget.GuildDefaultThemeNavBarCommon");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = (GuildDefaultThemeNavBarCommon) titleBarView;
        this.titleBar = guildDefaultThemeNavBarCommon2;
        if (guildDefaultThemeNavBarCommon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            guildDefaultThemeNavBarCommon = guildDefaultThemeNavBarCommon2;
        }
        guildDefaultThemeNavBarCommon.setOnItemSelectListener(Ph());
        hi();
    }

    @JvmStatic
    @NotNull
    public static final Intent Sh(@NotNull String str) {
        return INSTANCE.a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(r item, View v3) {
        if (item instanceof RoleItem) {
            if (!o.c("fastClickGuard")) {
                Vh((RoleItem) item);
                return;
            }
            return;
        }
        if (item instanceof CreateRoleItem) {
            if (!o.c("fastClickGuard")) {
                ai();
                return;
            }
            return;
        }
        if (item instanceof RoleEveryoneItem) {
            if (!o.c("fastClickGuard")) {
                bi(((RoleEveryoneItem) item).getRole().getId());
            }
        } else if (item instanceof LevelRoleItem) {
            if (!o.c("fastClickGuard")) {
                Zh(v3);
            }
        } else if (item instanceof LevelRoleTipItem) {
            if (!o.c("fastClickGuard")) {
                Yh();
            }
        } else if ((item instanceof RoleVisitorItem) && !o.c("fastClickGuard")) {
            di(((RoleVisitorItem) item).getRole().getId());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean Uh(r ignore, int position) {
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter = this.recyclerView;
        RecyclerView.ItemAnimator itemAnimator = null;
        if (overScrollRecyclerViewWithHeaderFooter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter = null;
        }
        RecyclerView.ViewHolder findViewHolderForAdapterPosition = overScrollRecyclerViewWithHeaderFooter.findViewHolderForAdapterPosition(position);
        if (findViewHolderForAdapterPosition == null) {
            return false;
        }
        w wVar = this.adapter;
        if (wVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            wVar = null;
        }
        if (!wVar.i0(findViewHolderForAdapterPosition.getAdapterPosition())) {
            return false;
        }
        ItemTouchHelper itemTouchHelper = this.touchHelper;
        if (itemTouchHelper == null) {
            Intrinsics.throwUninitializedPropertyAccessException("touchHelper");
            itemTouchHelper = null;
        }
        itemTouchHelper.startDrag(findViewHolderForAdapterPosition);
        OverScrollRecyclerViewWithHeaderFooter overScrollRecyclerViewWithHeaderFooter2 = this.recyclerView;
        if (overScrollRecyclerViewWithHeaderFooter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            overScrollRecyclerViewWithHeaderFooter2 = null;
        }
        RecyclerView.ItemAnimator itemAnimator2 = this.defaultItemAnimator;
        if (itemAnimator2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("defaultItemAnimator");
        } else {
            itemAnimator = itemAnimator2;
        }
        overScrollRecyclerViewWithHeaderFooter2.setItemAnimator(itemAnimator);
        return true;
    }

    private final void Vh(RoleItem item) {
        this.role = item.getRole();
        if (b.f232470b[Qh().ordinal()] == 1) {
            ci();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(RoleGroupListViewModel.ShowState showState) {
        int i3 = b.f232470b[showState.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                gi();
                return;
            }
            return;
        }
        hi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Xh(cf1.b event) {
        if (event.f30775b != 0) {
            SecurityTipHelperKt.G(getContext(), event, null, 4, null);
        } else {
            QQToast.makeText(getContext(), 2, event.f30774a, 1).show();
        }
    }

    private final void Yh() {
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        GuildLevelRoleUtils.a(requireActivity, this.guildId, 3);
    }

    private final void Zh(View v3) {
        fi(this, v3, "em_sgrp_role_set_levelrole", null, 4, null);
        GuildLevelRoleViewAndSelectFragment.Companion companion = GuildLevelRoleViewAndSelectFragment.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        String str = this.guildId;
        String string = getString(R.string.f154741fm);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild_role_list_level_role)");
        companion.c(requireContext, str, string, PageLayoutType.VIEW_LEVEL_ROLES_ENTRANCE);
    }

    private final void ai() {
        RoleGroupListViewModel roleGroupListViewModel = this.roleGroupViewModel;
        if (roleGroupListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel = null;
        }
        if (!roleGroupListViewModel.W1()) {
            QQToast.makeText(getContext(), 1, getString(R.string.f154791fr), 1).show();
        } else {
            GuildRoleDetailFragment.Ci(getActivity(), this.guildId, 0, "1", 0, 0, 0);
        }
    }

    private final void bi(String roleId) {
        GuildMemberOrVisitorRoleFragment.Uh(getActivity(), this.guildId, roleId, 1);
    }

    private final void ci() {
        String str;
        String str2;
        RoleGroupModel roleGroupModel = this.role;
        RoleGroupModel roleGroupModel2 = null;
        String str3 = null;
        RoleGroupModel roleGroupModel3 = null;
        String str4 = null;
        RoleGroupModel roleGroupModel4 = null;
        if (roleGroupModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("role");
            roleGroupModel = null;
        }
        if (roleGroupModel.v()) {
            FragmentActivity activity = getActivity();
            String str5 = this.guildId;
            RoleGroupModel roleGroupModel5 = this.role;
            if (roleGroupModel5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel5 = null;
            }
            int color = roleGroupModel5.getColor();
            RoleGroupModel roleGroupModel6 = this.role;
            if (roleGroupModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel6 = null;
            }
            IGProGuildRoleInfo lvRole = roleGroupModel6.getLvRole();
            if (lvRole != null) {
                str3 = lvRole.getDisplayTagName();
            }
            GuildCreatorRoleFragment.Jh(activity, str5, color, str3);
            return;
        }
        RoleGroupModel roleGroupModel7 = this.role;
        if (roleGroupModel7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("role");
            roleGroupModel7 = null;
        }
        if (roleGroupModel7.s()) {
            FragmentActivity activity2 = getActivity();
            String str6 = this.guildId;
            RoleGroupModel roleGroupModel8 = this.role;
            if (roleGroupModel8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel8 = null;
            }
            int color2 = roleGroupModel8.getColor();
            RoleGroupModel roleGroupModel9 = this.role;
            if (roleGroupModel9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel9 = null;
            }
            IGProGuildRoleInfo lvRole2 = roleGroupModel9.getLvRole();
            if (lvRole2 != null) {
                str2 = lvRole2.getDisplayTagName();
            } else {
                str2 = null;
            }
            RoleGroupModel roleGroupModel10 = this.role;
            if (roleGroupModel10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
            } else {
                roleGroupModel3 = roleGroupModel10;
            }
            GuildAdminRoleFragment.Uh(activity2, str6, color2, str2, roleGroupModel3.getName());
            return;
        }
        RoleGroupModel roleGroupModel11 = this.role;
        if (roleGroupModel11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("role");
            roleGroupModel11 = null;
        }
        if (roleGroupModel11.t()) {
            GuildCategoryAdminRoleFragment.Companion companion = GuildCategoryAdminRoleFragment.INSTANCE;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            String str7 = this.guildId;
            RoleGroupModel roleGroupModel12 = this.role;
            if (roleGroupModel12 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel12 = null;
            }
            int color3 = roleGroupModel12.getColor();
            RoleGroupModel roleGroupModel13 = this.role;
            if (roleGroupModel13 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel13 = null;
            }
            IGProGuildRoleInfo lvRole3 = roleGroupModel13.getLvRole();
            if (lvRole3 != null) {
                str4 = lvRole3.getDisplayTagName();
            }
            if (str4 == null) {
                str4 = "";
            }
            companion.a(requireContext, str7, color3, str4);
            return;
        }
        RoleGroupModel roleGroupModel14 = this.role;
        if (roleGroupModel14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("role");
            roleGroupModel14 = null;
        }
        if (roleGroupModel14.u()) {
            FragmentActivity activity3 = getActivity();
            String str8 = this.guildId;
            RoleGroupModel roleGroupModel15 = this.role;
            if (roleGroupModel15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel15 = null;
            }
            int color4 = roleGroupModel15.getColor();
            RoleGroupModel roleGroupModel16 = this.role;
            if (roleGroupModel16 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
                roleGroupModel16 = null;
            }
            IGProGuildRoleInfo lvRole4 = roleGroupModel16.getLvRole();
            if (lvRole4 != null) {
                str = lvRole4.getDisplayTagName();
            } else {
                str = null;
            }
            RoleGroupModel roleGroupModel17 = this.role;
            if (roleGroupModel17 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("role");
            } else {
                roleGroupModel4 = roleGroupModel17;
            }
            GuildChannelAdminRoleFragment.Lh(activity3, str8, color4, str, roleGroupModel4.getName());
            return;
        }
        FragmentActivity activity4 = getActivity();
        String str9 = this.guildId;
        RoleGroupModel roleGroupModel18 = this.role;
        if (roleGroupModel18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("role");
            roleGroupModel18 = null;
        }
        String id5 = roleGroupModel18.getId();
        RoleGroupModel roleGroupModel19 = this.role;
        if (roleGroupModel19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("role");
        } else {
            roleGroupModel2 = roleGroupModel19;
        }
        GuildRoleDetailFragment.Ci(activity4, str9, 2, id5, 0, 0, roleGroupModel2.getColor());
    }

    private final void di(String roleId) {
        GuildMemberOrVisitorRoleFragment.Uh(getActivity(), this.guildId, roleId, 6);
    }

    private final void ei(View v3, String id5, HashMap<String, Object> param) {
        VideoReport.setElementId(v3, id5);
        VideoReport.setElementClickPolicy(v3, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(v3, ExposurePolicy.REPORT_ALL);
        VideoReport.reportEvent("clck", id5, param);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void fi(GuildRoleListFragment guildRoleListFragment, View view, String str, HashMap hashMap, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 4) != 0) {
                hashMap = null;
            }
            guildRoleListFragment.ei(view, str, hashMap);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: reportDTClick");
    }

    private final View getContentView() {
        View mContentView = this.P;
        Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
        return mContentView;
    }

    private final void gi() {
        setTitle("\u8eab\u4efd\u7ec4\u6392\u5e8f");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.titleBar;
        w wVar = null;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.setRightDrawable(0);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.titleBar;
        if (guildDefaultThemeNavBarCommon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon2 = null;
        }
        guildDefaultThemeNavBarCommon2.setRightText("\u5b8c\u6210");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon3 = this.titleBar;
        if (guildDefaultThemeNavBarCommon3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon3 = null;
        }
        guildDefaultThemeNavBarCommon3.c(true);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon4 = this.titleBar;
        if (guildDefaultThemeNavBarCommon4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon4 = null;
        }
        guildDefaultThemeNavBarCommon4.setLeftText("\u53d6\u6d88");
        w wVar2 = this.adapter;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            wVar = wVar2;
        }
        wVar.n0(RoleGroupListViewModel.ShowState.SORTABLE);
    }

    private final void hi() {
        setTitle("\u8eab\u4efd\u7ec4");
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon = this.titleBar;
        w wVar = null;
        if (guildDefaultThemeNavBarCommon == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon = null;
        }
        guildDefaultThemeNavBarCommon.setRightDrawable(R.drawable.guild_channel_sort_icon_black);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon2 = this.titleBar;
        if (guildDefaultThemeNavBarCommon2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon2 = null;
        }
        guildDefaultThemeNavBarCommon2.setRightText((String) null);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon3 = this.titleBar;
        if (guildDefaultThemeNavBarCommon3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon3 = null;
        }
        guildDefaultThemeNavBarCommon3.setLeftText((String) null);
        GuildDefaultThemeNavBarCommon guildDefaultThemeNavBarCommon4 = this.titleBar;
        if (guildDefaultThemeNavBarCommon4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            guildDefaultThemeNavBarCommon4 = null;
        }
        guildDefaultThemeNavBarCommon4.setLeftBackVisible(0);
        w wVar2 = this.adapter;
        if (wVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        } else {
            wVar = wVar2;
        }
        wVar.n0(RoleGroupListViewModel.ShowState.NORMAL);
    }

    private final void initDtReport() {
        View view;
        HashMap hashMap = new HashMap();
        com.tencent.mobileqq.guild.data.w.a(hashMap);
        View contentView = getContentView();
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        String str = this.guildId;
        Object parent = contentView.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            contentView = view;
        }
        VideoReport.addToDetectionWhitelist(requireActivity);
        VideoReport.setPageId(contentView, "pg_sgrp_role_set");
        ((IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class)).setGuildPageParams(contentView, str, hashMap);
        ImageView imageView = this.G;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementId(imageView, "em_sgrp_role_order_button");
        VideoReport.setElementExposePolicy(imageView, exposurePolicy);
        VideoReport.setElementClickPolicy(imageView, clickPolicy);
    }

    private final void initViewModel() {
        RoleGroupListViewModel roleGroupListViewModel = (RoleGroupListViewModel) ef1.c.INSTANCE.c(this, RoleGroupListViewModel.class, new Function0<RoleGroupListViewModel>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleListFragment$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RoleGroupListViewModel invoke() {
                String str;
                str = GuildRoleListFragment.this.guildId;
                return new RoleGroupListViewModel(str, s.a());
            }
        });
        this.roleGroupViewModel = roleGroupListViewModel;
        RoleGroupListViewModel roleGroupListViewModel2 = null;
        if (roleGroupListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel = null;
        }
        LiveData<List<r>> f26 = roleGroupListViewModel.f2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        f26.observe(viewLifecycleOwner, new f());
        RoleGroupListViewModel roleGroupListViewModel3 = this.roleGroupViewModel;
        if (roleGroupListViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel3 = null;
        }
        cn<cf1.b> toastEvent = roleGroupListViewModel3.getToastEvent();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        toastEvent.observe(viewLifecycleOwner2, new g());
        RoleGroupListViewModel roleGroupListViewModel4 = this.roleGroupViewModel;
        if (roleGroupListViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel4 = null;
        }
        LiveData<String> e26 = roleGroupListViewModel4.e2();
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        e26.observe(viewLifecycleOwner3, new h());
        RoleGroupListViewModel roleGroupListViewModel5 = this.roleGroupViewModel;
        if (roleGroupListViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel5 = null;
        }
        LiveData<RoleGroupListViewModel.ShowState> h26 = roleGroupListViewModel5.h2();
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "viewLifecycleOwner");
        h26.observe(viewLifecycleOwner4, new i());
        RoleGroupListViewModel roleGroupListViewModel6 = this.roleGroupViewModel;
        if (roleGroupListViewModel6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
        } else {
            roleGroupListViewModel2 = roleGroupListViewModel6;
        }
        LiveData<RoleGroupListViewModel.RunningState> g26 = roleGroupListViewModel2.g2();
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "viewLifecycleOwner");
        g26.observe(viewLifecycleOwner5, new j());
        this.memberPuller = new GuildMemberPuller(this.guildId, "", new WeakReference(this.pullResultListener));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Bundle requireArguments = requireArguments();
        Intrinsics.checkNotNullExpressionValue(requireArguments, "requireArguments()");
        Serializable serializable = requireArguments.getSerializable("PARAM_FRAGMENT");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleListFragment.Param");
        Param param = (Param) serializable;
        this.params = param;
        if (param == null) {
            Intrinsics.throwUninitializedPropertyAccessException("params");
            param = null;
        }
        this.guildId = param.getGuildId();
        Rh();
        initViewModel();
        initDtReport();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.es_;
    }

    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        RoleGroupListViewModel roleGroupListViewModel = this.roleGroupViewModel;
        RoleGroupListViewModel roleGroupListViewModel2 = null;
        if (roleGroupListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel = null;
        }
        if (roleGroupListViewModel.h2().getValue() == RoleGroupListViewModel.ShowState.SORTABLE) {
            RoleGroupListViewModel roleGroupListViewModel3 = this.roleGroupViewModel;
            if (roleGroupListViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            } else {
                roleGroupListViewModel2 = roleGroupListViewModel3;
            }
            roleGroupListViewModel2.o2(RoleGroupListViewModel.ShowState.NORMAL);
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        RoleGroupListViewModel roleGroupListViewModel = this.roleGroupViewModel;
        if (roleGroupListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("roleGroupViewModel");
            roleGroupListViewModel = null;
        }
        roleGroupListViewModel.l2(this.guildId);
    }
}
