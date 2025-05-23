package com.tencent.mobileqq.troopmanage.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.troopmanage.ITroopManageApi;
import com.tencent.mobileqq.troopmanage.TroopSubManageIntelligentManageFragment;
import com.tencent.mobileqq.troopmanage.component.MemberManageComponent;
import com.tencent.mobileqq.troopmanage.component.ap;
import com.tencent.mobileqq.troopmanage.component.u;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.troopmanage.subfragment.TroopSubManageInformationFragment;
import com.tencent.mobileqq.troopmanage.subfragment.TroopSubManagePersonalFragment;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.a;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J0\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0011H\u0016J \u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\u0010\u001e\u001a\u0004\u0018\u00010\u000eH\u0016\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/impl/TroopManageApiImpl;", "Lcom/tencent/mobileqq/troopmanage/ITroopManageApi;", "()V", "getDataManageComponent", "Lcom/tencent/mobileqq/widget/listitem/Group;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", "adapter", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "viewModel", "Landroidx/lifecycle/ViewModel;", "dtReportPgId", "", "getMemberManageComponent", "getTroopSubManageInformationFragmentClz", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "openIntelligentManageFragment", "", "Landroid/app/Activity;", "intent", "Landroid/content/Intent;", "requestCode", "", "openTroopSubManageFeatureFragment", "context", "Landroid/content/Context;", "preLoadIntelligentManageItem", "troopUin", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes35.dex */
public final class TroopManageApiImpl implements ITroopManageApi {
    @Override // com.tencent.mobileqq.troopmanage.ITroopManageApi
    public Group getDataManageComponent(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, ViewModel viewModel, String dtReportPgId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        TroopManageViewModel troopManageViewModel = viewModel instanceof TroopManageViewModel ? (TroopManageViewModel) viewModel : null;
        if (troopManageViewModel == null) {
            return new Group(new a[0]);
        }
        return new u(activity, adapter, lifecycleOwner, troopManageViewModel, dtReportPgId).C();
    }

    @Override // com.tencent.mobileqq.troopmanage.ITroopManageApi
    public Group getMemberManageComponent(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, ViewModel viewModel, String dtReportPgId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        TroopManageViewModel troopManageViewModel = viewModel instanceof TroopManageViewModel ? (TroopManageViewModel) viewModel : null;
        if (troopManageViewModel == null) {
            return new Group(new a[0]);
        }
        return new MemberManageComponent(activity, adapter, lifecycleOwner, troopManageViewModel, dtReportPgId).Q();
    }

    @Override // com.tencent.mobileqq.troopmanage.ITroopManageApi
    public Class<? extends QPublicBaseFragment> getTroopSubManageInformationFragmentClz() {
        return TroopSubManageInformationFragment.class;
    }

    @Override // com.tencent.mobileqq.troopmanage.ITroopManageApi
    public void openIntelligentManageFragment(Activity activity, Intent intent, int requestCode) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QPublicFragmentActivity.startForResult(activity, intent, (Class<? extends QPublicBaseFragment>) TroopSubManageIntelligentManageFragment.class, requestCode);
    }

    @Override // com.tencent.mobileqq.troopmanage.ITroopManageApi
    public void openTroopSubManageFeatureFragment(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        QPublicFragmentActivity.start(context, intent, TroopSubManagePersonalFragment.class);
    }

    @Override // com.tencent.mobileqq.troopmanage.ITroopManageApi
    public void preLoadIntelligentManageItem(String troopUin) {
        ap.f303070a.c(troopUin);
    }
}
