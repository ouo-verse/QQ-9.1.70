package com.tencent.mobileqq.troopmanage.component;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.pluginsdk.PluginStatic;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.jointype.TroopJoinTypeFragment;
import com.tencent.mobileqq.troop.jointype.event.TroopManageAutoApprovalEvent;
import com.tencent.mobileqq.troop.troopmanager.api.ITroopManagerComponentApi;
import com.tencent.mobileqq.troopmanage.activity.TroopSetJoinTypeActivity;
import com.tencent.mobileqq.troopmanage.event.TroopManageAuthEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\u0006\u0010\u001d\u001a\u00020\u001c\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0016R$\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/AddGroupSettingComponent;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", DownloadInfo.spKey_Config, "", "M", "Landroid/view/View$OnClickListener;", "E", "G", "", "url", "O", "", "isAutoApprovalOpen", "P", "Lcom/tencent/mobileqq/widget/listitem/Group;", "I", "g", "Lcom/tencent/mobileqq/widget/listitem/x;", "autoApproveConfig", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class AddGroupSettingComponent extends bv {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> autoApproveConfig;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddGroupSettingComponent(@NotNull QBaseActivity activity, @NotNull QUIListItemAdapter adapter, @NotNull LifecycleOwner lifecycleOwner, @NotNull TroopManageViewModel viewModel, @NotNull String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        }
    }

    private final View.OnClickListener E() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddGroupSettingComponent.F(AddGroupSettingComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(AddGroupSettingComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.g().e()) {
            Intent intent = new Intent();
            intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, this$0.b().getString(R.string.i7o));
            intent.putExtra("troop_uin", this$0.g().j());
            intent.putExtra(PluginStatic.PARAM_PLUGIN_GESTURELOCK, false);
            intent.putExtra(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, "1");
            if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("106087", true)) {
                QPublicFragmentActivity.startForResult(this$0.b(), intent, (Class<? extends QPublicBaseFragment>) TroopJoinTypeFragment.class, 19);
            } else {
                QPublicFragmentActivity.startForResult(this$0.b(), intent, (Class<? extends QPublicBaseFragment>) TroopSetJoinTypeActivity.class, 19);
            }
            bv.l(this$0, "em_group_join_way", null, 2, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final View.OnClickListener G() {
        return new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AddGroupSettingComponent.H(AddGroupSettingComponent.this, view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(AddGroupSettingComponent this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.P(this$0.g().h().isAutoApprovalOpen());
        String O = this$0.O(this$0.g().a());
        Intent intent = new Intent(this$0.b(), (Class<?>) QQBrowserActivity.class);
        intent.putExtra(AppConstants.LeftViewText.LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.ujq));
        intent.putExtra("url", O);
        this$0.b().startActivity(intent);
        bv.l(this$0, "em_group_auto_review", null, 2, null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J(AddGroupSettingComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_join_way", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AddGroupSettingComponent this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_auto_review", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void M(final com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> config) {
        MutableLiveData<TroopManageAuthEvent> g26 = h().g2();
        LifecycleOwner e16 = e();
        final Function1<TroopManageAuthEvent, Unit> function1 = new Function1<TroopManageAuthEvent, Unit>(config, this) { // from class: com.tencent.mobileqq.troopmanage.component.AddGroupSettingComponent$registerAuthTxtObserver$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> $config;
            final /* synthetic */ AddGroupSettingComponent this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$config = config;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) config, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageAuthEvent troopManageAuthEvent) {
                invoke2(troopManageAuthEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageAuthEvent troopManageAuthEvent) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) troopManageAuthEvent);
                } else {
                    this.$config.O().h(troopManageAuthEvent.getTroopAuth());
                    this.this$0.c().l0(this.$config);
                }
            }
        };
        g26.observe(e16, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddGroupSettingComponent.N(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final String O(String url) {
        String str;
        String str2;
        String replace$default;
        String replace$default2;
        String str3;
        String replace$default3;
        String replace$default4;
        String replace$default5;
        String replace$default6;
        String replace$default7;
        String replace$default8;
        String replace$default9;
        String replace$default10;
        TroopInfoData i3 = g().i();
        if (i3.bOwner) {
            str = "0";
        } else if (i3.bAdmin) {
            str = "1";
        } else {
            str = "2";
        }
        String str4 = str;
        String str5 = i3.troopUin;
        if (str5 == null) {
            str2 = "";
        } else {
            str2 = str5;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(url, "$GCODE$", str2, false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$CLIENTVER$", "android" + AppSetting.f99551k, false, 4, (Object) null);
        String b16 = g().b();
        if (b16 == null) {
            str3 = "";
        } else {
            str3 = b16;
        }
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "$UIN$", str3, false, 4, (Object) null);
        replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "$LANG$", "zh_CN", false, 4, (Object) null);
        replace$default5 = StringsKt__StringsJVMKt.replace$default(replace$default4, "$GROUPAPPID$", "0", false, 4, (Object) null);
        replace$default6 = StringsKt__StringsJVMKt.replace$default(replace$default5, "$ROLE$", str4, false, 4, (Object) null);
        replace$default7 = StringsKt__StringsJVMKt.replace$default(replace$default6, "$ENTERSOURCE$", "1", false, 4, (Object) null);
        String str6 = i3.troopUin;
        if (str6 == null) {
            str6 = "";
        }
        replace$default8 = StringsKt__StringsJVMKt.replace$default(replace$default7, "$GUIN$", str6, false, 4, (Object) null);
        replace$default9 = StringsKt__StringsJVMKt.replace$default(replace$default8, "$UNREADNUM$", "0", false, 4, (Object) null);
        if (!TextUtils.isEmpty(i3.newTroopName)) {
            String str7 = i3.newTroopName;
            Intrinsics.checkNotNullExpressionValue(str7, "mTroopInfoData.newTroopName");
            replace$default10 = StringsKt__StringsJVMKt.replace$default(replace$default9, "$GNAME$", str7, false, 4, (Object) null);
            return replace$default10;
        }
        return replace$default9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P(boolean isAutoApprovalOpen) {
        String str;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> xVar = this.autoApproveConfig;
        if (xVar == null) {
            return;
        }
        x.c.g O = xVar.O();
        if (isAutoApprovalOpen) {
            str = b().getString(R.string.f172828uj4);
            Intrinsics.checkNotNullExpressionValue(str, "activity.getString(R.str\u2026.qqstr_troopman_3304d756)");
        } else {
            str = "\u672a\u5f00\u542f";
        }
        O.h(str);
        c().l0(xVar);
    }

    @NotNull
    public Group I() {
        String str;
        ArrayList arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Group) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = new com.tencent.mobileqq.widget.listitem.a[2];
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> u16 = bv.u(this, R.string.z87, R.string.z85, null, null, 12, null);
        u16.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.a
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AddGroupSettingComponent.J(AddGroupSettingComponent.this, view);
            }
        });
        boolean e16 = g().e();
        u16.r(!e16);
        x.c.g O = u16.O();
        if (e16) {
            str = b().getString(R.string.z85);
            Intrinsics.checkNotNullExpressionValue(str, "{\n                    ac\u2026nd_msg)\n                }");
        } else {
            str = g().i().troopAuthen;
            if (str == null) {
                str = "";
            } else {
                Intrinsics.checkNotNullExpressionValue(str, "getTroopManageArgument()\u2026nfoData.troopAuthen ?: \"\"");
            }
        }
        O.h(str);
        M(u16);
        u16.x(E());
        Unit unit = Unit.INSTANCE;
        aVarArr[0] = u16;
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> v3 = bv.v(this, R.string.f170506z84, "", null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.b
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                AddGroupSettingComponent.K(AddGroupSettingComponent.this, view);
            }
        });
        this.autoApproveConfig = v3;
        P(g().h().isAutoApprovalOpen());
        v3.x(G());
        MutableLiveData<TroopManageAutoApprovalEvent> O1 = h().O1();
        LifecycleOwner e17 = e();
        final Function1<TroopManageAutoApprovalEvent, Unit> function1 = new Function1<TroopManageAutoApprovalEvent, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.AddGroupSettingComponent$getComponentGroup$configList$2$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AddGroupSettingComponent.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopManageAutoApprovalEvent troopManageAutoApprovalEvent) {
                invoke2(troopManageAutoApprovalEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopManageAutoApprovalEvent troopManageAutoApprovalEvent) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) troopManageAutoApprovalEvent);
                } else if (Intrinsics.areEqual(troopManageAutoApprovalEvent.getGroupId(), AddGroupSettingComponent.this.g().j())) {
                    AddGroupSettingComponent.this.P(troopManageAutoApprovalEvent.isAutoApprovalOpen());
                }
            }
        };
        O1.observe(e17, new Observer() { // from class: com.tencent.mobileqq.troopmanage.component.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AddGroupSettingComponent.L(Function1.this, obj);
            }
        });
        aVarArr[1] = v3;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(aVarArr);
        com.tencent.mobileqq.widget.listitem.x<x.b.d, x.c.g> troopSearchWayConfig = ((ITroopManagerComponentApi) QRoute.api(ITroopManagerComponentApi.class)).getTroopSearchWayConfig(b(), c(), g().h(), h().Z1());
        if (troopSearchWayConfig != null) {
            arrayListOf.add(troopSearchWayConfig);
        }
        String string = b().getResources().getString(R.string.z86);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026manage_add_group_setting)");
        CharSequence c16 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.c(b().getResources().getString(R.string.f235467bq));
        Object[] array = arrayListOf.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr2 = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(string, c16, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr2, aVarArr2.length));
    }
}
