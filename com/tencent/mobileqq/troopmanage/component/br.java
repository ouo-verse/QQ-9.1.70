package com.tencent.mobileqq.troopmanage.component;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/br;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/Group;", "y", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;)V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class br extends bv {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(br this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QRoute.createNavigator(this$0.b(), RouterConstants.UI_ROUTE_BROWSER).withString("url", "https://qinfo.clt.qq.com/qun-honor-setting-v2/index.html?_wv=4&_bid=125&gc=" + this$0.g().j() + "&type=102&grayscale=1&qunlevelgray=false").request();
    }

    public Group y() {
        com.tencent.mobileqq.troop.widget.l lVar = new com.tencent.mobileqq.troop.widget.l(View.inflate(b(), R.layout.hzi, null));
        lVar.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.bq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                br.z(br.this, view);
            }
        });
        return new Group(lVar);
    }
}
