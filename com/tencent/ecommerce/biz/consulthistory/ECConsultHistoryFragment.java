package com.tencent.ecommerce.biz.consulthistory;

import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.report.service.m;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import uj0.ECConsultHistory;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 12\u00020\u0001:\u00012B\u0007\u00a2\u0006\u0004\b/\u00100J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\tH\u0016J\b\u0010\u0011\u001a\u00020\tH\u0016J\b\u0010\u0012\u001a\u00020\tH\u0016J\u001a\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\tH\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\b\u0010\u001a\u001a\u00020\u0006H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u000e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010$R$\u0010*\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010.\u001a\u00020+8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00063"}, d2 = {"Lcom/tencent/ecommerce/biz/consulthistory/ECConsultHistoryFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Ljava/util/ArrayList;", "Luj0/a;", "Lkotlin/collections/ArrayList;", "newData", "", "Ph", "Rh", "", "isSuccess", "Qh", "", "getContentLayoutId", "", "getBusinessDescription", "Bh", "Eh", "Dh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onBackPressed", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Landroidx/recyclerview/widget/RecyclerView;", "P", "Landroidx/recyclerview/widget/RecyclerView;", "consultHistoryList", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", BdhLogUtil.LogTag.Tag_Req, "Ljava/lang/String;", "afterSalesId", ExifInterface.LATITUDE_SOUTH, "processId", "T", "Ljava/util/ArrayList;", "dataList", "Lcom/tencent/ecommerce/base/report/service/k;", "U", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "<init>", "()V", "V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECConsultHistoryFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private RecyclerView consultHistoryList;

    /* renamed from: Q, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: R, reason: from kotlin metadata */
    private String afterSalesId;

    /* renamed from: S, reason: from kotlin metadata */
    private String processId;

    /* renamed from: T, reason: from kotlin metadata */
    private final ArrayList<ECConsultHistory> dataList = new ArrayList<>();

    /* renamed from: U, reason: from kotlin metadata */
    private final k showPageCostTime = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_CONSULT_HISTORY);

    public static final /* synthetic */ RecyclerView Mh(ECConsultHistoryFragment eCConsultHistoryFragment) {
        RecyclerView recyclerView = eCConsultHistoryFragment.consultHistoryList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consultHistoryList");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ECStateCenterView Nh(ECConsultHistoryFragment eCConsultHistoryFragment) {
        ECStateCenterView eCStateCenterView = eCConsultHistoryFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ph(ArrayList<ECConsultHistory> newData) {
        this.dataList.clear();
        this.dataList.addAll(newData);
        RecyclerView recyclerView = this.consultHistoryList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consultHistoryList");
        }
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Qh(boolean isSuccess) {
        Map<Object, ? extends Object> d16 = new m().c(isSuccess ? 2 : 3).d();
        this.showPageCostTime.b(d16);
        cg0.a.b("ECConsultHistoryFragment", "[reportShowPageCostWhenGetNetworkData] params = " + d16);
    }

    private final void Rh() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
        String str = this.afterSalesId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("afterSalesId");
        }
        com.tencent.ecommerce.base.network.service.a.b("trpc.ecom.after_sales_svr.AfterSales", "/trpc.ecom.after_sales_svr.AfterSales/GetAfterSalesHistoryRecords", new b(str), new c(), new ECConsultHistoryFragment$requestData$1(this));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECConsultHistoryFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cps;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        if (eCStateCenterView.getVisibility() == 0) {
            ECStateCenterView eCStateCenterView2 = this.stateView;
            if (eCStateCenterView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("stateView");
            }
            eCStateCenterView2.setSucceededState();
            return true;
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("EC_STAGE_CONSULT_HISTORY_PAGE");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("EC_STAGE_CONSULT_HISTORY_PAGE");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        String str;
        String string;
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString("after_sales_id")) == null) {
            str = "";
        }
        this.afterSalesId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(CrashHianalyticsData.PROCESS_ID)) != null) {
            str2 = string;
        }
        this.processId = str2;
        this.consultHistoryList = (RecyclerView) view.findViewById(R.id.nue);
        this.stateView = (ECStateCenterView) view.findViewById(R.id.nuf);
        RecyclerView recyclerView = this.consultHistoryList;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consultHistoryList");
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        RecyclerView recyclerView2 = this.consultHistoryList;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("consultHistoryList");
        }
        recyclerView2.setAdapter(new a(this.dataList));
        setTitle(R.string.wij);
        Rh();
    }
}
