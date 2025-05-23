package com.tencent.mobileqq.guild.rolegroup.fragments.roledetail;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildCommonViewMemberFragment;
import com.tencent.mobileqq.guild.rolegroup.fragments.memberlist.GuildRoleMemberParamData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ux1.g;
import wx1.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J&\u0010\u0010\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\b\u0010\u0013\u001a\u00020\u0002H\u0016R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/GuildCategoryAdminRoleFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "", "initData", "Kh", "Hh", "Lwx1/a$a;", "uiData", "Nh", "Lh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", "", "getContentLayoutId", "onResume", "", "T", "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/c;", "U", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/c;", "groupViewModel", "<init>", "()V", "V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildCategoryAdminRoleFragment extends QQGuildTitleBarFragment {

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private String guildId;

    /* renamed from: U, reason: from kotlin metadata */
    private com.tencent.mobileqq.guild.rolegroup.viewmodel.c groupViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004R\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/fragments/roledetail/GuildCategoryAdminRoleFragment$a;", "", "Landroid/content/Context;", "context", "", "gId", "", "color", "displayTagName", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildCategoryAdminRoleFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull Context context, @NotNull String gId, int color, @NotNull String displayTagName) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(gId, "gId");
            Intrinsics.checkNotNullParameter(displayTagName, "displayTagName");
            Intent intent = new Intent();
            intent.putExtras(BundleKt.bundleOf(TuplesKt.to("extra_guild_id", gId), TuplesKt.to("extra_role_color", Integer.valueOf(color)), TuplesKt.to("extra_role_display_tag_name", displayTagName)));
            QPublicFragmentActivity.b.b(context, intent, QPublicFragmentActivity.class, GuildCategoryAdminRoleFragment.class);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f232520a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildCategoryAdminRoleFragment f232521b;

        public b(ViewModelStoreOwner viewModelStoreOwner, GuildCategoryAdminRoleFragment guildCategoryAdminRoleFragment) {
            this.f232520a = viewModelStoreOwner;
            this.f232521b = guildCategoryAdminRoleFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f232521b.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.rolegroup.viewmodel.c(str), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/base/mvvm/SingleViewModelProvider$Companion$factory$1", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements ViewModelProvider.Factory {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ViewModelStoreOwner f232522a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ GuildCategoryAdminRoleFragment f232523b;

        public c(ViewModelStoreOwner viewModelStoreOwner, GuildCategoryAdminRoleFragment guildCategoryAdminRoleFragment) {
            this.f232522a = viewModelStoreOwner;
            this.f232523b = guildCategoryAdminRoleFragment;
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            long m1963markNowz9LOYto = TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto();
            String str = this.f232523b.guildId;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("guildId");
                str = null;
            }
            TimedValue timedValue = new TimedValue(new com.tencent.mobileqq.guild.rolegroup.viewmodel.h(str, 7), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(m1963markNowz9LOYto), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + com.tencent.mobileqq.guild.base.extension.m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    private final void Hh() {
        RecyclerView recyclerView = (RecyclerView) this.P.findViewById(R.id.eoq);
        final wx1.a aVar = new wx1.a(new a.d() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.l
            @Override // wx1.a.d
            public final void a(a.ChannelGroupUIData channelGroupUIData) {
                GuildCategoryAdminRoleFragment.Ih(GuildCategoryAdminRoleFragment.this, channelGroupUIData);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        com.tencent.mobileqq.guild.rolegroup.viewmodel.c cVar = null;
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(aVar);
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new b(this, this)).get(com.tencent.mobileqq.guild.rolegroup.viewmodel.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        com.tencent.mobileqq.guild.rolegroup.viewmodel.c cVar2 = (com.tencent.mobileqq.guild.rolegroup.viewmodel.c) viewModel;
        this.groupViewModel = cVar2;
        if (cVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupViewModel");
            cVar2 = null;
        }
        LiveData<List<a.ChannelGroupUIData>> O1 = cVar2.O1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends a.ChannelGroupUIData>, Unit> function1 = new Function1<List<? extends a.ChannelGroupUIData>, Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildCategoryAdminRoleFragment$initChannelGroupList$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends a.ChannelGroupUIData> list) {
                invoke2((List<a.ChannelGroupUIData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<a.ChannelGroupUIData> list) {
                wx1.a aVar2 = wx1.a.this;
                Intrinsics.checkNotNullExpressionValue(list, "list");
                aVar2.setData(list);
            }
        };
        O1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCategoryAdminRoleFragment.Jh(Function1.this, obj);
            }
        });
        com.tencent.mobileqq.guild.rolegroup.viewmodel.c cVar3 = this.groupViewModel;
        if (cVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groupViewModel");
        } else {
            cVar = cVar3;
        }
        cVar.P1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(GuildCategoryAdminRoleFragment this$0, a.ChannelGroupUIData uiData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(uiData, "uiData");
        this$0.Nh(uiData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Jh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Kh() {
        int i3;
        String qqStr;
        this.E.setText(HardCodeUtil.qqStr(R.string.f141460gq));
        Bundle arguments = getArguments();
        if (arguments != null) {
            i3 = arguments.getInt("extra_role_color");
        } else {
            i3 = -1;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (qqStr = arguments2.getString("extra_role_display_tag_name")) == null) {
            qqStr = HardCodeUtil.qqStr(R.string.f154371em);
        }
        TextView textView = (TextView) this.P.findViewById(R.id.yjr);
        textView.setText(R.string.f140890f7);
        textView.setVisibility(0);
        this.P.findViewById(R.id.f778945l).setBackgroundColor(i3);
        ((TextView) this.P.findViewById(R.id.f779045m)).setText(qqStr);
        ((ImageView) this.P.findViewById(R.id.vtd)).setImageTintList(ColorStateList.valueOf(i3));
        ((TextView) this.P.findViewById(R.id.vti)).setText(ch.t(i3));
    }

    private final void Lh() {
        RecyclerView recyclerView = (RecyclerView) this.P.findViewById(R.id.f239007o);
        final ux1.g gVar = new ux1.g();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        recyclerView.setItemAnimator(null);
        recyclerView.setAdapter(gVar);
        c.Companion companion = ef1.c.INSTANCE;
        ViewModel viewModel = new ViewModelProvider(this, new c(this, this)).get(com.tencent.mobileqq.guild.rolegroup.viewmodel.h.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026k(this) })[T::class.java]");
        com.tencent.mobileqq.guild.rolegroup.viewmodel.h hVar = (com.tencent.mobileqq.guild.rolegroup.viewmodel.h) viewModel;
        MutableLiveData<List<g.b>> U1 = hVar.U1();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<g.b>, Unit> function1 = new Function1<List<g.b>, Unit>() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.GuildCategoryAdminRoleFragment$initPermissionList$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<g.b> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<g.b> list) {
                ux1.g.this.setData(list);
            }
        };
        U1.observe(viewLifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.fragments.roledetail.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildCategoryAdminRoleFragment.Mh(Function1.this, obj);
            }
        });
        hVar.R1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Nh(a.ChannelGroupUIData uiData) {
        FragmentActivity requireActivity = requireActivity();
        String str = this.guildId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildId");
            str = null;
        }
        GuildCommonViewMemberFragment.ki(requireActivity, new GuildRoleMemberParamData(str, HardCodeUtil.qqStr(R.string.f141460gq), 2, 4).setCategoryId(String.valueOf(uiData.getId())).setSubTitleStr(uiData.getName()).setRoleGroupId("7").setMaxCountCanSelect(uiData.getMaxCnt()).setOpenPageSlideType(2).setActivityRequestCode(2001).setNextAddPageTitle(ch.i().getString(R.string.f1488410o)));
    }

    private final void initData() {
        String str;
        boolean z16;
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("extra_guild_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            Logger logger = Logger.f235387a;
            Logger.b bVar = new Logger.b();
            String str2 = "initData guildId is Empty " + getArguments();
            if (str2 instanceof String) {
                bVar.a().add(str2);
            }
            Iterator<T> it = bVar.a().iterator();
            while (it.hasNext()) {
                Logger.f235387a.d().e("Guild.rg.GuildGroupAdminDetailFragment", 1, (String) it.next(), null);
            }
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        initData();
        Kh();
        Hh();
        Lh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.ehm;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        com.tencent.mobileqq.guild.rolegroup.viewmodel.c cVar = this.groupViewModel;
        if (cVar != null) {
            if (cVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("groupViewModel");
                cVar = null;
            }
            cVar.P1();
        }
    }
}
