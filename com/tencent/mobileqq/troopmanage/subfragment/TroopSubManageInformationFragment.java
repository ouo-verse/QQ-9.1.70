package com.tencent.mobileqq.troopmanage.subfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troopmanage.component.bs;
import com.tencent.mobileqq.troopmanage.component.bv;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.troopmanage.repo.h;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 !2\u00020\u0001:\u0001\"B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J&\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/subfragment/TroopSubManageInformationFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sh", "rh", "ph", "contentView", "qh", "", "th", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getContentLayoutId", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "D", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "<init>", "()V", "E", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSubManageInformationFragment extends QIphoneTitleBarFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private QUIListItemAdapter adapter;

    /* renamed from: D, reason: from kotlin metadata */
    private TroopManageViewModel viewModel;

    private final void ph() {
        QUIListItemAdapter qUIListItemAdapter;
        TroopManageViewModel troopManageViewModel = this.viewModel;
        if (troopManageViewModel == null || (qUIListItemAdapter = this.adapter) == null) {
            return;
        }
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        qUIListItemAdapter.t0(new bs(qBaseActivity, qUIListItemAdapter, viewLifecycleOwner, troopManageViewModel, "pg_group_info_set").x());
    }

    private final void qh(View contentView) {
        try {
            VideoReport.addToDetectionWhitelist(getQBaseActivity());
            VideoReport.setPageId(contentView, "pg_group_leader_game_data_show");
            VideoReport.setPageParams(contentView, new PageParams(bv.INSTANCE.a(this.viewModel)));
            VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_ALL);
        } catch (Exception e16) {
            QLog.e("IphoneTitleBarFragment", 1, "reportDtOnCreate e: " + e16);
        }
    }

    private final void sh(View rootView) {
        rh(rootView);
        ph();
    }

    private final boolean th() {
        Bundle arguments = getArguments();
        return arguments != null && arguments.getInt("from", -1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g0t;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        TroopManageViewModel troopManageViewModel;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("troop_uin") : null;
        h hVar = h.f303236a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = (TroopManageViewModel) hVar.c(string, requireActivity).get(TroopManageViewModel.class);
        if (!th() || getArguments() == null || (troopManageViewModel = this.viewModel) == null) {
            return;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null) {
            arguments2 = new Bundle();
        }
        troopManageViewModel.L1(arguments2);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        TroopManageViewModel troopManageViewModel;
        SimpleEventBus.getInstance().unRegisterReceiver(this.viewModel);
        if (th() && (troopManageViewModel = this.viewModel) != null) {
            troopManageViewModel.M1();
        }
        super.onDestroy();
    }

    private final void rh(View rootView) {
        View findViewById = rootView.findViewById(R.id.f102545y7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026oop_manage_recycler_view)");
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter;
        ((QUISettingsRecyclerView) findViewById).setAdapter(qUIListItemAdapter);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setTitle(getString(R.string.f132413c));
        setLeftViewName(R.string.z8i);
        View mContentView = ((QIphoneTitleBarFragment) this).mContentView;
        if (mContentView != null) {
            Intrinsics.checkNotNullExpressionValue(mContentView, "mContentView");
            sh(mContentView);
            View mContentView2 = ((QIphoneTitleBarFragment) this).mContentView;
            Intrinsics.checkNotNullExpressionValue(mContentView2, "mContentView");
            qh(mContentView2);
        }
        SimpleEventBus.getInstance().registerReceiver(this.viewModel);
    }
}
