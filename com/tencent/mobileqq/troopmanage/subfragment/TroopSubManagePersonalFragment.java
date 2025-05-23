package com.tencent.mobileqq.troopmanage.subfragment;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.troop.activity.TroopNickRuleFragment;
import com.tencent.mobileqq.troopmanage.ITroopManageApi;
import com.tencent.mobileqq.troopmanage.component.FeatureConfigList;
import com.tencent.mobileqq.troopmanage.component.PrettyTroopConfigList;
import com.tencent.mobileqq.troopmanage.component.TroopNickRuleConfig;
import com.tencent.mobileqq.troopmanage.component.bv;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.troopmanage.repo.b;
import com.tencent.mobileqq.troopmanage.repo.h;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.mobileqq.widget.listitem.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J&\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\"\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/subfragment/TroopSubManagePersonalFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sh", "rh", "ph", "contentView", "qh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getContentLayoutId", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "D", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class TroopSubManagePersonalFragment extends QIphoneTitleBarFragment {

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
        ArrayList arrayList = new ArrayList();
        QBaseActivity qBaseActivity = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
        FeatureConfigList featureConfigList = new FeatureConfigList(qBaseActivity, qUIListItemAdapter, viewLifecycleOwner, troopManageViewModel, "pg_group_fuction_set");
        QBaseActivity qBaseActivity2 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity2, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "viewLifecycleOwner");
        arrayList.addAll(new PrettyTroopConfigList(qBaseActivity2, qUIListItemAdapter, viewLifecycleOwner2, troopManageViewModel, "pg_group_personality_manage").B().a());
        QBaseActivity qBaseActivity3 = getQBaseActivity();
        Intrinsics.checkNotNullExpressionValue(qBaseActivity3, "qBaseActivity");
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "viewLifecycleOwner");
        arrayList.addAll(new TroopNickRuleConfig(qBaseActivity3, qUIListItemAdapter, viewLifecycleOwner3, troopManageViewModel, "pg_group_personality_manage").C().a());
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(featureConfigList.H());
        Object[] array = arrayList.toArray(new a[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        a[] aVarArr = (a[]) array;
        arrayList2.add(new Group((a[]) Arrays.copyOf(aVarArr, aVarArr.length)));
        Object[] array2 = arrayList2.toArray(new Group[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array2;
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
    }

    private final void qh(View contentView) {
        try {
            VideoReport.addToDetectionWhitelist(getQBaseActivity());
            VideoReport.setPageId(contentView, "pg_group_personality_manage");
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
        setTitle(getString(R.string.f132423d));
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.g0t;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        TroopManageViewModel troopManageViewModel;
        String str;
        String string;
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != 26 || data == null || resultCode != -1 || (troopManageViewModel = this.viewModel) == null) {
            return;
        }
        b m3 = troopManageViewModel.X1().m();
        TroopInfo h16 = m3.h();
        if (data.getStringExtra(TroopNickRuleFragment.R) != null) {
            str = data.getStringExtra(TroopNickRuleFragment.R);
        } else {
            str = "";
        }
        h16.groupCardPrefixIntro = str;
        if (data.getStringArrayListExtra(TroopNickRuleFragment.S) != null) {
            m3.h().groupCardPrefix = data.getStringArrayListExtra(TroopNickRuleFragment.S);
        }
        if (TextUtils.isEmpty(m3.h().groupCardPrefixIntro) && m3.h().groupCardPrefix.isEmpty()) {
            string = getQBaseActivity().getString(R.string.eqt);
        } else {
            string = getQBaseActivity().getString(R.string.f180883c_);
        }
        Intrinsics.checkNotNullExpressionValue(string, "if (TextUtils.isEmpty(tr\u2026                        }");
        troopManageViewModel.h2().postValue(string);
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
        Bundle arguments2 = getArguments();
        if (arguments2 == null || !arguments2.getBoolean(ITroopManageApi.KEY_IS_FROM_FLAME_GRAY_TIPS, false) || (troopManageViewModel = this.viewModel) == null) {
            return;
        }
        troopManageViewModel.L1(arguments2);
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
