package com.tencent.mobileqq.troopmanage.subfragment;

import android.content.Intent;
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
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.troopmanage.component.TroopFeedConfig;
import com.tencent.mobileqq.troopmanage.component.bt;
import com.tencent.mobileqq.troopmanage.component.bv;
import com.tencent.mobileqq.troopmanage.event.TroopManageTroopFeedEvent;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.troopmanage.repo.b;
import com.tencent.mobileqq.troopmanage.repo.h;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import cooperation.qzone.QzoneIPCModule;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b!\u0010\"J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J&\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014J\"\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/subfragment/TroopSubManageAppFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sh", "rh", "ph", "contentView", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getContentLayoutId", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "D", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSubManageAppFragment extends QIphoneTitleBarFragment {

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
        QBaseActivity qBaseActivity2 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(new Group[]{new bt(qBaseActivity, qUIListItemAdapter, viewLifecycleOwner, troopManageViewModel, "pg_group_application_manage").x(), new TroopFeedConfig(qBaseActivity2, qUIListItemAdapter, viewLifecycleOwner2, troopManageViewModel, "pg_group_application_manage").D()}, 2));
    }

    private final void qh(View contentView) {
        try {
            VideoReport.addToDetectionWhitelist(getQBaseActivity());
            VideoReport.setPageId(contentView, "pg_group_application_manage");
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.f132393a));
        setLeftViewName(R.string.z8i);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("troop_uin") : null;
        h hVar = h.f303236a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = (TroopManageViewModel) hVar.c(string, requireActivity).get(TroopManageViewModel.class);
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g0t;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TroopManageViewModel troopManageViewModel;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 27 || data == null || resultCode != -1 || (troopManageViewModel = this.viewModel) == null) {
            return;
        }
        b m3 = troopManageViewModel.X1().m();
        m3.i().troopFeedTalkPermission = data.getIntExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_PERMISSION, -1);
        m3.i().troopFeedSwitch = data.getBooleanExtra(ITroopUtilsApi.TROOP_MANAGE_GUILD_FEED_SWITCH, true);
        troopManageViewModel.f2().postValue(new TroopManageTroopFeedEvent(m3.i().troopFeedSwitch, m3.i().troopFeedTalkPermission));
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SimpleEventBus.getInstance().unRegisterReceiver(this.viewModel);
        super.onDestroy();
    }

    private final void rh(View rootView) {
        View findViewById = rootView.findViewById(R.id.f102545y7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026oop_manage_recycler_view)");
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter;
        ((QUISettingsRecyclerView) findViewById).setAdapter(qUIListItemAdapter);
    }
}
