package com.tencent.mobileqq.troopmanage.component;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcard.api.ITroopInfoActivityApi;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.troopmanage.subfragment.TroopSubManageAppFragment;
import com.tencent.mobileqq.troopmanage.subfragment.TroopSubManageInformationFragment;
import com.tencent.mobileqq.troopmanage.subfragment.TroopSubManagePersonalFragment;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/u;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "", "I", "Lcom/tencent/mobileqq/widget/listitem/Group;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class u extends bv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void D(u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_info_manage", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.I();
        bv.l(this$0, "em_group_info_manage", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QPublicFragmentActivity.startForResult(this$0.b(), this$0.f(), (Class<? extends QPublicBaseFragment>) TroopSubManageInformationFragment.class, 0);
        bv.l(this$0, "em_group_info_set", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QPublicFragmentActivity.startForResult(this$0.b(), this$0.f(), (Class<? extends QPublicBaseFragment>) TroopSubManageAppFragment.class, 0);
        bv.l(this$0, "em_group_application_manage", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H(u this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QPublicFragmentActivity.startForResult(this$0.b(), this$0.f(), (Class<? extends QPublicBaseFragment>) TroopSubManagePersonalFragment.class, 0);
        bv.l(this$0, "em_group_personality_manage", null, 2, null);
    }

    private final void I() {
        Bundle c16 = com.tencent.mobileqq.troop.utils.aq.c(g().j(), 3, g().i().troopLat, g().i().troopLon, g().i().cityId, g().i().troopLocation);
        Intrinsics.checkNotNullExpressionValue(c16, "getTroopProfileExtra(\n  \u2026a.troopLocation\n        )");
        c16.putInt(AppConstants.Key.TROOP_INFO_TROOP_TYPE_EX, g().i().troopTypeExt);
        c16.putString(AppConstants.LeftViewText.LEFTVIEWTEXT, b().getString(R.string.i7o));
        c16.putInt(AppConstants.Key.TROOP_INFO_TROOP_AUTH_SUBMIT_TIME, 0);
        c16.putInt(AppConstants.Key.TROOP_INFO_REPORT_FROM, 4);
        c16.putInt("PARAM_EXIT_ANIMATION", 2);
        ((ITroopInfoActivityApi) QRoute.api(ITroopInfoActivityApi.class)).openTroopProfileForResult(b(), c16, 4);
    }

    public Group C() {
        ArrayList arrayList = new ArrayList();
        com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.f132443f, "", null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.p
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                u.D(u.this, view);
            }
        });
        v3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.q
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.E(u.this, view);
            }
        });
        arrayList.add(v3);
        com.tencent.mobileqq.widget.listitem.x u16 = bv.u(this, R.string.f132413c, R.string.z8d, null, null, 12, null);
        u16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.r
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.F(u.this, view);
            }
        });
        arrayList.add(u16);
        if (i() || h().k2() || wt2.a.f446500a.a(g().h()) || ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("9155_troop_manage_app_entrance", false)) {
            com.tencent.mobileqq.widget.listitem.x v16 = bv.v(this, R.string.f132393a, "", null, null, 12, null);
            v16.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.s
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    u.G(u.this, view);
                }
            });
            arrayList.add(v16);
        }
        com.tencent.mobileqq.widget.listitem.x u17 = bv.u(this, R.string.f132423d, R.string.f132433e, null, null, 12, null);
        u17.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.t
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u.H(u.this, view);
            }
        });
        arrayList.add(u17);
        String string = b().getResources().getString(R.string.f132403b);
        Intrinsics.checkNotNullExpressionValue(string, "activity.resources.getSt\u2026troop_manage_base_manage)");
        Object[] array = arrayList.toArray(new com.tencent.mobileqq.widget.listitem.a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        com.tencent.mobileqq.widget.listitem.a[] aVarArr = (com.tencent.mobileqq.widget.listitem.a[]) array;
        return new Group(string, (com.tencent.mobileqq.widget.listitem.a[]) Arrays.copyOf(aVarArr, aVarArr.length));
    }
}
