package com.tencent.mobileqq.zplan.minixwconnected;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.minixwconnected.view.MiniHomeNeighborAdapter;
import com.tencent.mobileqq.zplan.minixwconnected.view.ZPlanMinihomeNeighborFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqnt.aio.utils.ViewUtils;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.ZootopiaTransparentActivity;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.QQToastUtil;
import fi3.bj;
import fi3.bk;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000bH\u0002J$\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0018\u0010,\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedNeighborFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "initView", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "Lx45/g;", "sh", "initDtReport", "Landroid/view/View;", "view", "vh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/LayoutInflater;", "Landroidx/recyclerview/widget/RecyclerView;", "D", "Landroidx/recyclerview/widget/RecyclerView;", "panelRecyclerView", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/ZPlanMinihomeNeighborFloatingView;", "E", "Lcom/tencent/mobileqq/zplan/minixwconnected/view/ZPlanMinihomeNeighborFloatingView;", "qusHalfScreenFloatingView", "Lfi3/bj;", UserInfo.SEX_FEMALE, "Lfi3/bj;", "panelBinding", "Lfi3/bk;", "G", "Lfi3/bk;", "containerLayoutBinding", "<init>", "()V", "H", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanMiniHomeConnectedNeighborFragment extends QPublicBaseFragment {

    /* renamed from: H, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private LayoutInflater inflater;

    /* renamed from: D, reason: from kotlin metadata */
    private RecyclerView panelRecyclerView;

    /* renamed from: E, reason: from kotlin metadata */
    private ZPlanMinihomeNeighborFloatingView qusHalfScreenFloatingView;

    /* renamed from: F, reason: from kotlin metadata */
    private bj panelBinding;

    /* renamed from: G, reason: from kotlin metadata */
    private bk containerLayoutBinding;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedNeighborFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "Landroid/os/Bundle;", "bundle", "", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedNeighborFragment$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(Activity activity, int requestCode, Bundle bundle) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            activity.overridePendingTransition(0, 0);
            ZootopiaTransparentActivity.INSTANCE.b(activity, ZPlanMiniHomeConnectedNeighborFragment.class, requestCode, new ZootopiaSource(Source.None, "", null, 4, null), bundle);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/minixwconnected/ZPlanMiniHomeConnectedNeighborFragment$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MAX_HEIGHT, "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        /* renamed from: createContentView */
        public View getF57419d() {
            bk bkVar = ZPlanMiniHomeConnectedNeighborFragment.this.containerLayoutBinding;
            if (bkVar != null) {
                return bkVar.getRoot();
            }
            return null;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int maxHeight() {
            return (int) (ViewUtils.f352270a.d() * 0.73d);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    private final void initDtReport() {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.addToDetectionWhitelist(getActivity());
        bj bjVar = this.panelBinding;
        VideoReport.setPageId(bjVar != null ? bjVar.getRoot() : null, "pg_zplan_neighbour");
        bj bjVar2 = this.panelBinding;
        VideoReport.setPageParams(bjVar2 != null ? bjVar2.getRoot() : null, new PageParams(hashMap));
        bj bjVar3 = this.panelBinding;
        VideoReport.setPageReportPolicy(bjVar3 != null ? bjVar3.getRoot() : null, PageReportPolicy.REPORT_ALL);
    }

    private final void initView() {
        bk bkVar;
        ImageView imageView;
        LayoutInflater layoutInflater = this.inflater;
        bj g16 = layoutInflater != null ? bj.g(layoutInflater) : null;
        this.panelBinding = g16;
        Intrinsics.checkNotNull(g16);
        ZPlanMinihomeNeighborFloatingView zPlanMinihomeNeighborFloatingView = g16.f399109b;
        Intrinsics.checkNotNullExpressionValue(zPlanMinihomeNeighborFloatingView, "panelBinding!!.qusFloatingHalfScreen");
        this.qusHalfScreenFloatingView = zPlanMinihomeNeighborFloatingView;
        LayoutInflater layoutInflater2 = this.inflater;
        if (layoutInflater2 != null) {
            bj bjVar = this.panelBinding;
            bkVar = bk.g(layoutInflater2, bjVar != null ? bjVar.getRoot() : null, false);
        } else {
            bkVar = null;
        }
        this.containerLayoutBinding = bkVar;
        RecyclerView recyclerView = bkVar != null ? bkVar.f399112c : null;
        this.panelRecyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        }
        ZPlanMinihomeNeighborFloatingView zPlanMinihomeNeighborFloatingView2 = this.qusHalfScreenFloatingView;
        if (zPlanMinihomeNeighborFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            zPlanMinihomeNeighborFloatingView2 = null;
        }
        zPlanMinihomeNeighborFloatingView2.setQUSDragFloatController(new b());
        ZPlanMinihomeNeighborFloatingView zPlanMinihomeNeighborFloatingView3 = this.qusHalfScreenFloatingView;
        if (zPlanMinihomeNeighborFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            zPlanMinihomeNeighborFloatingView3 = null;
        }
        zPlanMinihomeNeighborFloatingView3.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.zplan.minixwconnected.x
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                ZPlanMiniHomeConnectedNeighborFragment.th(ZPlanMiniHomeConnectedNeighborFragment.this);
            }
        });
        FragmentActivity activity = getActivity();
        ZootopiaActivity zootopiaActivity = activity instanceof ZootopiaActivity ? (ZootopiaActivity) activity : null;
        if (zootopiaActivity != null) {
            zootopiaActivity.I2();
        }
        bk bkVar2 = this.containerLayoutBinding;
        if (bkVar2 == null || (imageView = bkVar2.f399111b) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZPlanMiniHomeConnectedNeighborFragment.uh(ZPlanMiniHomeConnectedNeighborFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void th(ZPlanMiniHomeConnectedNeighborFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(ZPlanMiniHomeConnectedNeighborFragment this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        this$0.vh(it);
        FragmentActivity activity = this$0.getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private final void vh(View view) {
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        VideoReport.setElementId(view, "em_zplan_neighbour_close");
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.reportEvent("clck", view, hashMap);
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ZPlanMinihomeNeighborFloatingView zPlanMinihomeNeighborFloatingView = this.qusHalfScreenFloatingView;
        if (zPlanMinihomeNeighborFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            zPlanMinihomeNeighborFloatingView = null;
        }
        zPlanMinihomeNeighborFloatingView.t();
        return true;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ZPlanMinihomeNeighborFloatingView zPlanMinihomeNeighborFloatingView = this.qusHalfScreenFloatingView;
        if (zPlanMinihomeNeighborFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("qusHalfScreenFloatingView");
            zPlanMinihomeNeighborFloatingView = null;
        }
        zPlanMinihomeNeighborFloatingView.t();
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this.inflater = inflater;
        this.panelBinding = bj.g(inflater);
        initView();
        initDtReport();
        bj bjVar = this.panelBinding;
        Intrinsics.checkNotNull(bjVar);
        RelativeLayout root = bjVar.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "panelBinding!!.root");
        return root;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToastUtil.showQQToastInUiThread(1, "\u7f51\u7edc\u5f02\u5e38\uff0c\u8bf7\u68c0\u67e5\u540e\u91cd\u8bd5\u3002");
            return;
        }
        MutableStateFlow<x45.g[]> sh5 = sh(LifecycleOwnerKt.getLifecycleScope(this));
        MiniHomeNeighborAdapter miniHomeNeighborAdapter = new MiniHomeNeighborAdapter(sh5, LifecycleOwnerKt.getLifecycleScope(this), new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.zplan.minixwconnected.ZPlanMiniHomeConnectedNeighborFragment$onViewCreated$adapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke(l3.longValue());
                return Unit.INSTANCE;
            }

            public final void invoke(long j3) {
                Intent intent = new Intent();
                intent.putExtra("uin", j3);
                FragmentActivity activity = ZPlanMiniHomeConnectedNeighborFragment.this.getActivity();
                if (activity != null) {
                    activity.setResult(-1, intent);
                }
                FragmentActivity activity2 = ZPlanMiniHomeConnectedNeighborFragment.this.getActivity();
                if (activity2 != null) {
                    activity2.finish();
                }
            }
        });
        RecyclerView recyclerView = this.panelRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(miniHomeNeighborAdapter);
        }
        CorountineFunKt.e(LifecycleOwnerKt.getLifecycleScope(this), "zplan_ZPlanMiniHomeConnectedNeighborFragment_\u66f4\u65b0\u90bb\u5c45\u9762\u677f", null, null, null, new ZPlanMiniHomeConnectedNeighborFragment$onViewCreated$1(sh5, miniHomeNeighborAdapter, null), 14, null);
    }

    private final MutableStateFlow<x45.g[]> sh(CoroutineScope scope) {
        MutableStateFlow<x45.g[]> MutableStateFlow = StateFlowKt.MutableStateFlow(new x45.g[0]);
        CorountineFunKt.e(scope, "zplan_requestGetNeighbor_\u62c9\u53d6\u90bb\u5c45", null, null, null, new ZPlanMiniHomeConnectedNeighborFragment$generateSource$1(MutableStateFlow, null), 14, null);
        return MutableStateFlow;
    }
}
