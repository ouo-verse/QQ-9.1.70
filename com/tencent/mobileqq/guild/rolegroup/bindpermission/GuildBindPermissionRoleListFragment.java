package com.tencent.mobileqq.guild.rolegroup.bindpermission;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment;
import com.tencent.mobileqq.guild.base.extension.q;
import com.tencent.mobileqq.guild.base.extension.r;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionActionFactory;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionRoleListFragment;
import com.tencent.mobileqq.guild.rolegroup.bindpermission.e;
import com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleGroupSelectDialog;
import com.tencent.mobileqq.guild.rolegroup.levelrole.GuildLevelRoleViewAndSelectFragment;
import com.tencent.mobileqq.guild.rolegroup.levelrole.LevelRoleViewAndSelectParam;
import com.tencent.mobileqq.guild.rolegroup.levelrole.PageLayoutType;
import com.tencent.mobileqq.guild.rolegroup.model.data.GuildRoleGroupSelectModel;
import com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData;
import com.tencent.mobileqq.guild.util.GuildDebugUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\b\u0018\u0000 >2\u00020\u00012\u00020\u0002:\u0001?B\u0007\u00a2\u0006\u0004\b<\u0010=J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u000f\u0010\t\u001a\u00020\bH\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0002J\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J&\u0010\u0019\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0014J\u001a\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\"\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00112\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0005H\u0016J\b\u0010!\u001a\u00020\u0005H\u0016J\b\u0010#\u001a\u00020\"H\u0016J\u0012\u0010$\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001b\u0010.\u001a\u00020)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00107\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00104R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:\u00a8\u0006@"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionRoleListFragment;", "Lcom/tencent/mobileqq/guild/base/QQGuildTitleBarFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "initView", "initData", "com/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionRoleListFragment$b", "Kh", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionRoleListFragment$b;", "v", "Nh", "Ph", "", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", "Lh", "", "getContentLayoutId", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "onResume", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "onBackEvent", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "T", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "mParam", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e;", "U", "Lkotlin/Lazy;", "Mh", "()Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e;", "mAdapter", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/k;", "V", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/k;", "mFetchActionViewModel", "W", "Landroid/view/View;", "mAddRoleContainer", "X", "mLvRoleContainer", "Landroid/widget/TextView;", "Y", "Landroid/widget/TextView;", "mLvRoleCount", "<init>", "()V", "Z", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildBindPermissionRoleListFragment extends QQGuildTitleBarFragment implements View.OnClickListener {

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: T, reason: from kotlin metadata */
    private GuildBindPermissionParam mParam;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy mAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    private k mFetchActionViewModel;

    /* renamed from: W, reason: from kotlin metadata */
    private View mAddRoleContainer;

    /* renamed from: X, reason: from kotlin metadata */
    private View mLvRoleContainer;

    /* renamed from: Y, reason: from kotlin metadata */
    private TextView mLvRoleCount;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionRoleListFragment$a;", "", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "fragment", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionParam;", "param", "", "b", "Landroid/content/Context;", "context", "a", "", "GUILD_BIND_PERMISSION_PARAM", "Ljava/lang/String;", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionRoleListFragment$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(@NotNull Context context, @NotNull GuildBindPermissionParam param) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtra("GUILD_BIND_PERMISSION_PARAM", param);
            QPublicFragmentActivity.start(context, intent, GuildBindPermissionRoleListFragment.class);
        }

        @JvmStatic
        public final void b(@NotNull QPublicBaseFragment fragment, @NotNull GuildBindPermissionParam param) {
            Intrinsics.checkNotNullParameter(fragment, "fragment");
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtra("GUILD_BIND_PERMISSION_PARAM", param);
            QPublicFragmentActivity.startForResult(fragment, intent, (Class<? extends QPublicBaseFragment>) GuildBindPermissionRoleListFragment.class, param.getRequestCode());
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/bindpermission/GuildBindPermissionRoleListFragment$b", "Lcom/tencent/mobileqq/guild/rolegroup/bindpermission/e$b;", "Landroid/view/View;", "v", "Lcom/tencent/mobileqq/guild/rolegroup/view/rolelabelpanel/RoleLabelData;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "c", "", "b", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements e.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.e.b
        @Nullable
        public String a() {
            GuildBindPermissionParam guildBindPermissionParam = GuildBindPermissionRoleListFragment.this.mParam;
            if (guildBindPermissionParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                guildBindPermissionParam = null;
            }
            return guildBindPermissionParam.getPermissionWord().getManageRoleCategoryAdminTip();
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.e.b
        @NotNull
        public String b() {
            GuildBindPermissionParam guildBindPermissionParam = GuildBindPermissionRoleListFragment.this.mParam;
            if (guildBindPermissionParam == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                guildBindPermissionParam = null;
            }
            return guildBindPermissionParam.getPermissionWord().getManageRoleSubAdminTip();
        }

        @Override // com.tencent.mobileqq.guild.rolegroup.bindpermission.e.b
        public void c(@Nullable View v3, @NotNull RoleLabelData item) {
            Intrinsics.checkNotNullParameter(item, "item");
            if (!QQGuildUIUtil.v()) {
                GuildBindPermissionParam guildBindPermissionParam = GuildBindPermissionRoleListFragment.this.mParam;
                k kVar = null;
                if (guildBindPermissionParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    guildBindPermissionParam = null;
                }
                if (!guildBindPermissionParam.getIsCreating()) {
                    k kVar2 = GuildBindPermissionRoleListFragment.this.mFetchActionViewModel;
                    if (kVar2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                    } else {
                        kVar = kVar2;
                    }
                    kVar.B2(item.getRoleId());
                    return;
                }
                k kVar3 = GuildBindPermissionRoleListFragment.this.mFetchActionViewModel;
                if (kVar3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                } else {
                    kVar = kVar3;
                }
                kVar.A2(item.getRoleId());
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c<T> implements Observer {
        public c() {
        }

        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            GuildBindPermissionRoleListFragment.this.Mh().i0(GuildBindPermissionRoleListFragment.this.Lh((List) t16));
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0006\u001a\u00020\u0003\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"T", "kotlin.jvm.PlatformType", "it", "", "onChanged", "(Ljava/lang/Object;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d<T> implements Observer {
        public d() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(T t16) {
            int intValue = ((Number) t16).intValue();
            TextView textView = GuildBindPermissionRoleListFragment.this.mLvRoleCount;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLvRoleCount");
                textView = null;
            }
            textView.setText("\u5df2\u9009" + intValue + "\u4e2a");
        }
    }

    public GuildBindPermissionRoleListFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<e>() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionRoleListFragment$mAdapter$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final e invoke() {
                GuildBindPermissionRoleListFragment.b Kh;
                Kh = GuildBindPermissionRoleListFragment.this.Kh();
                return new e(Kh);
            }
        });
        this.mAdapter = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b Kh() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RoleLabelData> Lh(List<RoleLabelData> list) {
        List emptyList;
        Pair pair;
        boolean z16;
        GuildBindPermissionParam guildBindPermissionParam = this.mParam;
        Boolean bool = null;
        if (guildBindPermissionParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam = null;
        }
        if (guildBindPermissionParam.getChannelType() == 7) {
            GuildBindPermissionParam guildBindPermissionParam2 = this.mParam;
            if (guildBindPermissionParam2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
                guildBindPermissionParam2 = null;
            }
            String guildId = guildBindPermissionParam2.getGuildId();
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            boolean contains = emptyList.contains(guildId);
            r rVar = r.f214743a;
            String str = "";
            IRuntimeService S0 = ch.S0(IGPSService.class, "");
            Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
            IGProGuildInfo guildInfo = ((IGPSService) S0).getGuildInfo(guildId);
            if (guildInfo != null) {
                bool = Boolean.valueOf(guildInfo.isMovePostSection());
            }
            if (contains) {
                pair = TuplesKt.to(Boolean.TRUE, "HardCode");
            } else if (bool == null) {
                pair = TuplesKt.to(Boolean.FALSE, "NullGuildInfo");
            } else {
                pair = TuplesKt.to(bool, "GuildInfo");
            }
            GuildDebugUtils guildDebugUtils = GuildDebugUtils.f235333a;
            String str2 = guildDebugUtils.e().get(guildId);
            if (str2 != null) {
                str = str2;
            }
            Intrinsics.checkNotNullExpressionValue(str, "newFeedSquareResults.get(guildId) ?: \"\"");
            String pair2 = pair.toString();
            if (!Intrinsics.areEqual(str, pair2)) {
                Logger logger = Logger.f235387a;
                if (QLog.isColorLevel()) {
                    logger.d().d("GUILD_DEBUG", 2, "isNewFeedSquare " + guildId + MsgSummary.STR_COLON + pair2);
                }
                guildDebugUtils.e().put(guildId, pair2);
            }
            if (((Boolean) pair.getFirst()).booleanValue()) {
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (((RoleLabelData) obj).getRoleType() == 7) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        arrayList.add(obj);
                    }
                }
                return arrayList;
            }
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final e Mh() {
        return (e) this.mAdapter.getValue();
    }

    private final void Nh(View v3) {
        int collectionSizeOrDefault;
        GuildRoleGroupSelectModel.b bVar = new GuildRoleGroupSelectModel.b();
        GuildBindPermissionParam guildBindPermissionParam = this.mParam;
        GuildBindPermissionParam guildBindPermissionParam2 = null;
        if (guildBindPermissionParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam = null;
        }
        GuildRoleGroupSelectModel.b m3 = bVar.m(guildBindPermissionParam.getRequestType().getAddRoleType());
        GuildBindPermissionParam guildBindPermissionParam3 = this.mParam;
        if (guildBindPermissionParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam3 = null;
        }
        GuildRoleGroupSelectModel.b n3 = m3.n(guildBindPermissionParam3.getGuildId());
        GuildBindPermissionParam guildBindPermissionParam4 = this.mParam;
        if (guildBindPermissionParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam4 = null;
        }
        GuildRoleGroupSelectModel.b k3 = n3.k(guildBindPermissionParam4.getChannelId());
        GuildBindPermissionParam guildBindPermissionParam5 = this.mParam;
        if (guildBindPermissionParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam5 = null;
        }
        GuildRoleGroupSelectModel.b l3 = k3.l(guildBindPermissionParam5.getChannelType());
        k kVar = this.mFetchActionViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        List<RoleLabelData> q26 = kVar.q2();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(q26, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = q26.iterator();
        while (it.hasNext()) {
            arrayList.add(((RoleLabelData) it.next()).getRoleId());
        }
        GuildRoleGroupSelectModel.b o16 = l3.o(arrayList);
        GuildBindPermissionParam guildBindPermissionParam6 = this.mParam;
        if (guildBindPermissionParam6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
        } else {
            guildBindPermissionParam2 = guildBindPermissionParam6;
        }
        GuildRoleGroupSelectDialog.Hh(getParentFragmentManager(), o16.p(!guildBindPermissionParam2.getIsCreating()).j(new GuildRoleGroupSelectDialog.a() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.g
            @Override // com.tencent.mobileqq.guild.rolegroup.fragments.GuildRoleGroupSelectDialog.a
            public final void a(List list, List list2) {
                GuildBindPermissionRoleListFragment.Oh(GuildBindPermissionRoleListFragment.this, list, list2);
            }
        }).i());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oh(GuildBindPermissionRoleListFragment this$0, List normalRoles, List lvRoles) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Logger.f235387a.d().d("Guild.rg.BindPermission.DeleteRole.ListFragment", 1, "handleCLickAddRole SelectRoleDialog finish normalRoles:" + normalRoles + " lvRoles:" + lvRoles);
        k kVar = this$0.mFetchActionViewModel;
        k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(normalRoles, "normalRoles");
        Intrinsics.checkNotNullExpressionValue(lvRoles, "lvRoles");
        kVar.D2(normalRoles, lvRoles);
        GuildBindPermissionParam guildBindPermissionParam = this$0.mParam;
        if (guildBindPermissionParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam = null;
        }
        if (!guildBindPermissionParam.getIsCreating()) {
            k kVar3 = this$0.mFetchActionViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            } else {
                kVar2 = kVar3;
            }
            kVar2.i2("bindPermissionRoleList handleCLickAddRole");
        }
    }

    private final void Ph(View v3) {
        GuildLevelRoleViewAndSelectFragment.Companion companion = GuildLevelRoleViewAndSelectFragment.INSTANCE;
        GuildBindPermissionParam guildBindPermissionParam = this.mParam;
        k kVar = null;
        if (guildBindPermissionParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam = null;
        }
        String guildId = guildBindPermissionParam.getGuildId();
        String qqStr = HardCodeUtil.qqStr(R.string.f154741fm);
        Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_role_list_level_role)");
        PageLayoutType pageLayoutType = PageLayoutType.MANAGE_AND_DELETE;
        GuildBindPermissionParam guildBindPermissionParam2 = this.mParam;
        if (guildBindPermissionParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam2 = null;
        }
        String channelId = guildBindPermissionParam2.getChannelId();
        GuildBindPermissionParam guildBindPermissionParam3 = this.mParam;
        if (guildBindPermissionParam3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam3 = null;
        }
        GuildBindPermissionActionFactory.FetchType bindPermissionType = guildBindPermissionParam3.getRequestType().getBindPermissionType();
        GuildBindPermissionParam guildBindPermissionParam4 = this.mParam;
        if (guildBindPermissionParam4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam4 = null;
        }
        boolean isCreating = guildBindPermissionParam4.getIsCreating();
        GuildBindPermissionParam guildBindPermissionParam5 = this.mParam;
        if (guildBindPermissionParam5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam5 = null;
        }
        int requestCode = guildBindPermissionParam5.getRequestCode();
        k kVar2 = this.mFetchActionViewModel;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
        } else {
            kVar = kVar2;
        }
        companion.d(this, new LevelRoleViewAndSelectParam(guildId, qqStr, pageLayoutType, channelId, bindPermissionType, isCreating, requestCode, new ArrayList(kVar.q2()), null, 256, null));
    }

    private final void initData() {
        k kVar = (k) ef1.c.INSTANCE.c(this, k.class, new Function0<k>() { // from class: com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionRoleListFragment$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final k invoke() {
                GuildBindPermissionParam guildBindPermissionParam = GuildBindPermissionRoleListFragment.this.mParam;
                GuildBindPermissionParam guildBindPermissionParam2 = null;
                if (guildBindPermissionParam == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    guildBindPermissionParam = null;
                }
                String guildId = guildBindPermissionParam.getGuildId();
                GuildBindPermissionParam guildBindPermissionParam3 = GuildBindPermissionRoleListFragment.this.mParam;
                if (guildBindPermissionParam3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    guildBindPermissionParam3 = null;
                }
                String channelId = guildBindPermissionParam3.getChannelId();
                GuildBindPermissionParam guildBindPermissionParam4 = GuildBindPermissionRoleListFragment.this.mParam;
                if (guildBindPermissionParam4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    guildBindPermissionParam4 = null;
                }
                GuildBindPermissionActionFactory.FetchType bindPermissionType = guildBindPermissionParam4.getRequestType().getBindPermissionType();
                GuildBindPermissionParam guildBindPermissionParam5 = GuildBindPermissionRoleListFragment.this.mParam;
                if (guildBindPermissionParam5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                    guildBindPermissionParam5 = null;
                }
                int channelType = guildBindPermissionParam5.getChannelType();
                GuildBindPermissionParam guildBindPermissionParam6 = GuildBindPermissionRoleListFragment.this.mParam;
                if (guildBindPermissionParam6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mParam");
                } else {
                    guildBindPermissionParam2 = guildBindPermissionParam6;
                }
                return new k(guildId, channelId, bindPermissionType, channelType, guildBindPermissionParam2.getIsCreating(), true, true);
            }
        });
        this.mFetchActionViewModel = kVar;
        GuildBindPermissionParam guildBindPermissionParam = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        LiveData<List<RoleLabelData>> s26 = kVar.s2();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        s26.observe(viewLifecycleOwner, new c());
        k kVar2 = this.mFetchActionViewModel;
        if (kVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar2 = null;
        }
        LiveData<Integer> o26 = kVar2.o2();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        o26.observe(viewLifecycleOwner2, new d());
        GuildBindPermissionParam guildBindPermissionParam2 = this.mParam;
        if (guildBindPermissionParam2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam2 = null;
        }
        if (guildBindPermissionParam2.getIsCreating()) {
            k kVar3 = this.mFetchActionViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                kVar3 = null;
            }
            GuildBindPermissionParam guildBindPermissionParam3 = this.mParam;
            if (guildBindPermissionParam3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mParam");
            } else {
                guildBindPermissionParam = guildBindPermissionParam3;
            }
            kVar3.C2(guildBindPermissionParam.getSelectRoles());
        }
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.eap);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.list)");
        RecyclerView recyclerView = (RecyclerView) findViewById;
        recyclerView.setAdapter(Mh());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        View view2 = null;
        q.b(recyclerView, ViewUtils.dpToPx(16.0f), 0, 2, null);
        GuildBindPermissionParam guildBindPermissionParam = this.mParam;
        if (guildBindPermissionParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam = null;
        }
        setTitle(guildBindPermissionParam.getPermissionWord().getManageRoleTitleStr());
        View findViewById2 = view.findViewById(R.id.vwq);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.guild_add_role_container)");
        this.mAddRoleContainer = findViewById2;
        View findViewById3 = view.findViewById(R.id.wli);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.guild_level_role_container)");
        this.mLvRoleContainer = findViewById3;
        View findViewById4 = view.findViewById(R.id.wlj);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.guild_level_role_count)");
        this.mLvRoleCount = (TextView) findViewById4;
        View view3 = this.mAddRoleContainer;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAddRoleContainer");
            view3 = null;
        }
        view3.setOnClickListener(this);
        View view4 = this.mLvRoleContainer;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLvRoleContainer");
        } else {
            view2 = view4;
        }
        view2.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildTitleBarFragment, com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        Serializable serializable = requireArguments().getSerializable("GUILD_BIND_PERMISSION_PARAM");
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.guild.rolegroup.bindpermission.GuildBindPermissionParam");
        this.mParam = (GuildBindPermissionParam) serializable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.esz;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005a, code lost:
    
        r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r5);
     */
    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        List mutableList;
        Object serializableExtra;
        List<RoleLabelData> mutableList2;
        super.onActivityResult(requestCode, resultCode, data);
        Logger.f235387a.d().d("Guild.rg.BindPermission.DeleteRole.ListFragment", 1, "onActivityResult requestCode:" + requestCode + " resultCode:" + resultCode);
        GuildBindPermissionParam guildBindPermissionParam = this.mParam;
        k kVar = null;
        if (guildBindPermissionParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam = null;
        }
        if (requestCode == guildBindPermissionParam.getRequestCode() && resultCode == -1 && data != null) {
            k kVar2 = this.mFetchActionViewModel;
            if (kVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
                kVar2 = null;
            }
            List<RoleLabelData> value = kVar2.s2().getValue();
            if (value == null || mutableList == null || (serializableExtra = data.getSerializableExtra("SELECTED_LEVEL_ROLES_CACHE_DATA")) == null) {
                return;
            }
            List list = mutableList;
            CollectionsKt__MutableCollectionsKt.addAll(list, (RoleLabelData[]) serializableExtra);
            k kVar3 = this.mFetchActionViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            } else {
                kVar = kVar3;
            }
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
            kVar.C2(mutableList2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [com.tencent.mobileqq.guild.rolegroup.view.rolelabelpanel.RoleLabelData[], java.io.Serializable] */
    @Override // com.tencent.mobileqq.guild.base.QQGuildCustomTitleBarFragment, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        k kVar = this.mFetchActionViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        ?? m26 = kVar.m2();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.rg.BindPermission.DeleteRole.ListFragment", 2, "closePageWhenCreating roles:" + m26.length);
        }
        Intent intent = new Intent();
        intent.putExtra("SELECTED_USERS_CACHE_DATA", (Serializable) m26);
        requireActivity().setResult(-1, intent);
        return super.onBackEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (!o.c("fastClickGuard")) {
            View view = this.mAddRoleContainer;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAddRoleContainer");
                view = null;
            }
            if (Intrinsics.areEqual(v3, view)) {
                Nh(v3);
            } else {
                View view3 = this.mLvRoleContainer;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLvRoleContainer");
                } else {
                    view2 = view3;
                }
                if (Intrinsics.areEqual(v3, view2)) {
                    Ph(v3);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        k kVar = this.mFetchActionViewModel;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        kVar.onDestroy();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        k kVar = this.mFetchActionViewModel;
        k kVar2 = null;
        if (kVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            kVar = null;
        }
        kVar.onResume();
        GuildBindPermissionParam guildBindPermissionParam = this.mParam;
        if (guildBindPermissionParam == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mParam");
            guildBindPermissionParam = null;
        }
        if (!guildBindPermissionParam.getIsCreating()) {
            k kVar3 = this.mFetchActionViewModel;
            if (kVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFetchActionViewModel");
            } else {
                kVar2 = kVar3;
            }
            kVar2.i2("bindPermissionRoleList onResume");
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initData();
    }
}
