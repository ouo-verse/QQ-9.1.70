package com.tencent.mobileqq.zplan.newfriend.ui.activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.activitymodule.GestureActivityModule;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.newfriend.api.impl.NewFriendServiceImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zplan.api.IZPlanFriendApi;
import com.tencent.mobileqq.zplan.newfriend.ui.adapter.ZPlanNewFriendListAdapter;
import com.tencent.widget.SwipListView;
import org.json.JSONObject;

/* loaded from: classes21.dex */
public class ZPlanNewFriendFragment extends QIphoneTitleBarFragment {
    private ZPlanNewFriendListAdapter C;
    private QBaseActivity D;

    private void initView() {
        View view = ((QIphoneTitleBarFragment) this).mContentView;
        if (view != null && this.D != null) {
            SwipListView swipListView = (SwipListView) view.findViewById(R.id.j9u);
            View findViewById = ((QIphoneTitleBarFragment) this).mContentView.findViewById(R.id.f_a);
            setTitle(getString(R.string.oon));
            QBaseActivity qBaseActivity = this.D;
            this.C = new ZPlanNewFriendListAdapter(qBaseActivity, (AppInterface) qBaseActivity.getAppRuntime(), swipListView, findViewById, null, GestureActivityModule.getFlingHandler(this.D), 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
        super.doOnCreateView(layoutInflater, viewGroup, bundle);
        initView();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i96;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.D = getQBaseActivity();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        QBaseActivity qBaseActivity = this.D;
        if (qBaseActivity != null && ((AppInterface) qBaseActivity.getAppRuntime()) != null) {
            ((NewFriendServiceImpl) this.D.getAppRuntime().getRuntimeService(INewFriendService.class, "")).markSystemMsgReaded();
        }
        ZPlanNewFriendListAdapter zPlanNewFriendListAdapter = this.C;
        if (zPlanNewFriendListAdapter != null) {
            zPlanNewFriendListAdapter.onDestroy();
        }
        ((IZPlanFriendApi) QRoute.api(IZPlanFriendApi.class)).notifyNewFriendDialogClose(new JSONObject());
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }
}
