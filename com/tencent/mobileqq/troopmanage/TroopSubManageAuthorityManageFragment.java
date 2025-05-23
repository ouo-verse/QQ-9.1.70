package com.tencent.mobileqq.troopmanage;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troopmanage.component.MemberPermissionsComponent;
import com.tencent.mobileqq.troopmanage.component.bv;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.troopmanage.repo.h;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.widget.listitem.QUISettingsRecyclerView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J&\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0014R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/TroopSubManageAuthorityManageFragment;", "Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "sh", "rh", "ph", "contentView", "qh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "doOnCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getContentLayoutId", "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "D", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSubManageAuthorityManageFragment extends QIphoneTitleBarFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private QUIListItemAdapter adapter;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private TroopManageViewModel viewModel;

    public TroopSubManageAuthorityManageFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

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
        arrayList.add(new MemberPermissionsComponent(qBaseActivity, qUIListItemAdapter, viewLifecycleOwner, troopManageViewModel, "pg_group_fuction_permission").E());
        Object[] array = arrayList.toArray(new Group[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        Group[] groupArr = (Group[]) array;
        qUIListItemAdapter.t0((Group[]) Arrays.copyOf(groupArr, groupArr.length));
    }

    private final void qh(View contentView) {
        try {
            VideoReport.addToDetectionWhitelist(getQBaseActivity());
            VideoReport.setPageId(contentView, "pg_group_fuction_permission");
            VideoReport.setPageParams(contentView, new PageParams(bv.INSTANCE.a(this.viewModel)));
            VideoReport.setPageReportPolicy(contentView, PageReportPolicy.REPORT_ALL);
        } catch (Exception e16) {
            QLog.e("IphoneTitleBarFragment", 1, "reportDtOnCreate e: " + e16);
        }
    }

    private final void rh(View rootView) {
        View findViewById = rootView.findViewById(R.id.f102545y7);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026oop_manage_recycler_view)");
        QUIListItemAdapter qUIListItemAdapter = new QUIListItemAdapter(null, false, false, 7, null);
        this.adapter = qUIListItemAdapter;
        ((QUISettingsRecyclerView) findViewById).setAdapter(qUIListItemAdapter);
    }

    private final void sh(View rootView) {
        rh(rootView);
        ph();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.fragment.QIphoneTitleBarFragment
    public void doOnCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, inflater, container, savedInstanceState);
            return;
        }
        super.doOnCreateView(inflater, container, savedInstanceState);
        setTitle(getString(R.string.z9p));
        setLeftViewName(R.string.a1o);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str = arguments.getString("troop_uin");
        } else {
            str = null;
        }
        h hVar = h.f303236a;
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        this.viewModel = (TroopManageViewModel) hVar.c(str, requireActivity).get(TroopManageViewModel.class);
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return R.layout.g0t;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            SimpleEventBus.getInstance().unRegisterReceiver(this.viewModel);
            super.onDestroy();
        }
    }
}
