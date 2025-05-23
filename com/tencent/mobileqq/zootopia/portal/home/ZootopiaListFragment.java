package com.tencent.mobileqq.zootopia.portal.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.common.app.AppInterface;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mvvm.h;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManager;
import com.tencent.mobileqq.zootopia.download.ui.ZootopiaDownloadManagerFragment;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.portal.detail.events.ZootopiaDetailFragmentCloseEvent;
import com.tencent.mobileqq.zootopia.portal.home.model.ZootopiaListViewModel;
import com.tencent.mobileqq.zootopia.portal.home.model.f;
import com.tencent.mobileqq.zootopia.portal.home.model.m;
import com.tencent.mobileqq.zootopia.portal.home.view.ZootopiaListMapListView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richmediabrowser.utils.ScreenUtils;
import com.tencent.sqshow.activity.ZplanHostActivity;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.data.ZootopiaMapSimpleInfo;
import com.tencent.sqshow.zootopia.samestyle.ZPlanTemplate;
import com.tencent.sqshow.zootopia.view.pull2refresh.RecyclerViewWithHeaderFooterFix;
import com.tencent.sqshow.zootopia.view.pull2refresh.ZootopiaPullRefreshLayout;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import fi3.bd;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.Constants;
import mqq.app.MobileQQ;
import vc3.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a2\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 L2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\b\u0012\u0004\u0012\u00020\u00060\u0005:\u0001MB\u0007\u00a2\u0006\u0004\bJ\u0010KJ\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\u001c\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u0012\u0010\u001a\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J&\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\"\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u001f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010#\u001a\u00020\t2\u0006\u0010!\u001a\u00020\u001fH\u0016J\b\u0010$\u001a\u00020\u0010H\u0014J\b\u0010%\u001a\u00020\tH\u0016J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010'\u001a\u00020\tH\u0016J\u0010\u0010*\u001a\u00020\t2\u0006\u0010)\u001a\u00020(H\u0016J\b\u0010+\u001a\u00020\tH\u0016J\b\u0010,\u001a\u00020\u0015H\u0016J\u0012\u0010.\u001a\u00020\t2\b\u0010-\u001a\u0004\u0018\u00010\u0006H\u0016J\u0016\u00101\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000600\u0018\u00010/H\u0016R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001b\u0010I\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\bG\u0010H\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/zootopia/portal/home/ZootopiaListFragment;", "Lcom/tencent/sqshow/fragment/ZootopiaBaseFragment;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mobileqq/zootopia/portal/home/a;", "Lcom/tencent/mobileqq/zootopia/portal/home/b;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "Lfi3/bd;", "binding", "", "Qh", "Kh", "refresh", "Lcom/tencent/sqshow/zootopia/data/ZootopiaMapSimpleInfo;", "data", "", "", "", "Nh", "Lzb3/e;", "detailParams", "", FavEmoConstant.ROAMING_TYPE_PANEL, "Ph", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, NodeProps.ON_CLICK, "getSubSource", "onResume", "r6", com.tencent.bugly.common.constants.Constants.EMULATOR_INFO, "Lcom/tencent/sqshow/zootopia/samestyle/ZPlanTemplate;", "sameStyleInfo", "ze", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onBackPressedEvent", "event", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Lcom/tencent/common/app/AppInterface;", "N", "Lcom/tencent/common/app/AppInterface;", "app", "Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel;", "P", "Lcom/tencent/mobileqq/zootopia/portal/home/model/ZootopiaListViewModel;", "mViewModel", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lfi3/bd;", "Lid3/d;", BdhLogUtil.LogTag.Tag_Req, "Lid3/d;", "dtReportHelper", "Lcom/tencent/mobileqq/zootopia/utils/e;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/zootopia/utils/e;", "fastClickUtils", "Loa4/a;", "T", "Lkotlin/Lazy;", "Oh", "()Loa4/a;", "mapResViewModel", "<init>", "()V", "U", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaListFragment extends ZootopiaBaseFragment implements View.OnClickListener, a, b, SimpleEventReceiver<SimpleBaseEvent> {

    /* renamed from: N, reason: from kotlin metadata */
    private AppInterface app;

    /* renamed from: P, reason: from kotlin metadata */
    private ZootopiaListViewModel mViewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private bd binding;

    /* renamed from: R, reason: from kotlin metadata */
    private final id3.d dtReportHelper = new id3.d(null, 1, null);

    /* renamed from: S, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.utils.e fastClickUtils = new com.tencent.mobileqq.zootopia.utils.e();

    /* renamed from: T, reason: from kotlin metadata */
    private final Lazy mapResViewModel;

    public ZootopiaListFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<oa4.a>() { // from class: com.tencent.mobileqq.zootopia.portal.home.ZootopiaListFragment$mapResViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final oa4.a invoke() {
                ViewModel viewModel = h.a(ZootopiaListFragment.this.requireActivity()).get(oa4.a.class);
                Intrinsics.checkNotNullExpressionValue(viewModel, "ofViewModelProvider(requ\u2026ResViewModel::class.java)");
                return (oa4.a) viewModel;
            }
        });
        this.mapResViewModel = lazy;
    }

    private final void Kh(final bd binding) {
        SimpleEventBus.getInstance().registerReceiver(this);
        m mVar = new m(Oh(), Ch());
        Context context = getContext();
        com.tencent.mobileqq.zootopia.portal.home.model.d dVar = null;
        ZootopiaListViewModel zootopiaListViewModel = null;
        if (context != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "viewLifecycleOwner");
            ZootopiaListViewModel zootopiaListViewModel2 = this.mViewModel;
            if (zootopiaListViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            } else {
                zootopiaListViewModel = zootopiaListViewModel2;
            }
            dVar = mVar.l(viewLifecycleOwner, zootopiaListViewModel, binding, context);
        }
        if (dVar != null) {
            dVar.I(this);
        }
        if (dVar != null) {
            dVar.J(this);
        }
        Oh().N1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaListFragment.Lh(bd.this, (Integer) obj);
            }
        });
        Oh().Q1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.zootopia.portal.home.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ZootopiaListFragment.Mh(bd.this, (Integer) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Lh(bd binding, Integer count) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullExpressionValue(count, "count");
        if (count.intValue() > 0) {
            binding.f399065e.setText(String.valueOf(count));
            binding.f399065e.setVisibility(0);
        } else {
            binding.f399065e.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Mh(bd binding, Integer downloadingCount) {
        Intrinsics.checkNotNullParameter(binding, "$binding");
        Intrinsics.checkNotNullExpressionValue(downloadingCount, "downloadingCount");
        if (downloadingCount.intValue() > 0) {
            binding.f399067g.setVisibility(8);
            binding.f399068h.setVisibility(0);
        } else {
            binding.f399068h.setVisibility(8);
            binding.f399067g.setVisibility(0);
        }
    }

    private final oa4.a Oh() {
        return (oa4.a) this.mapResViewModel.getValue();
    }

    private final void Ph(zb3.e detailParams, boolean needDownload) {
        ZootopiaListMapListView zootopiaListMapListView;
        com.tencent.mobileqq.zootopia.portal.home.model.a d16;
        bd bdVar = this.binding;
        if (bdVar != null && (zootopiaListMapListView = bdVar.f399071k) != null && (d16 = zootopiaListMapListView.d()) != null) {
            d16.reset();
        }
        vc3.d.f441387a.a(detailParams.getItemView().t());
        Bundle bundle = new Bundle();
        bundle.putSerializable("ZOOTOPIA_MAP_INFO", detailParams.getInfo());
        bundle.putSerializable("detail_config", new ZootopiaDetailFragment.Config(0, false, false, needDownload, null, null, true, null, 183, null));
        bundle.putSerializable(ZootopiaSource.KEY_FRAGMENT_SOURCE, ZootopiaSource.INSTANCE.e(Ch()));
        IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        iEntryApi.startDetailFragment(requireContext, Ch(), bundle);
    }

    private final void Qh(bd binding) {
        AppInterface appInterface = this.app;
        if (appInterface == null) {
            return;
        }
        ViewModel viewModel = new ViewModelProvider(this, new f(appInterface, Ch())).get(ZootopiaListViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this, \u2026istViewModel::class.java]");
        ZootopiaListViewModel zootopiaListViewModel = (ZootopiaListViewModel) viewModel;
        this.mViewModel = zootopiaListViewModel;
        ZootopiaListMapListView zootopiaListMapListView = binding.f399071k;
        if (zootopiaListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            zootopiaListViewModel = null;
        }
        zootopiaListMapListView.setViewModel(zootopiaListViewModel);
        binding.f399063c.getBtnNetworkError().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.portal.home.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ZootopiaListFragment.Rh(ZootopiaListFragment.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(ZootopiaListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZootopiaListViewModel zootopiaListViewModel = this$0.mViewModel;
        if (zootopiaListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            zootopiaListViewModel = null;
        }
        zootopiaListViewModel.refresh();
    }

    private final void refresh() {
        ZootopiaListViewModel zootopiaListViewModel = this.mViewModel;
        if (zootopiaListViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mViewModel");
            zootopiaListViewModel = null;
        }
        zootopiaListViewModel.refresh();
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.b
    public void G3() {
        if (this.fastClickUtils.a()) {
            return;
        }
        ZplanHostActivity.Companion companion = ZplanHostActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ZplanHostActivity.Companion.c(companion, requireContext, com.tencent.sqshow.zootopia.samestyle.a.class, new Bundle(), 0, 8, null);
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayList = new ArrayList<>();
        arrayList.add(ZootopiaDetailFragmentCloseEvent.class);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment
    public String getSubSource() {
        return ZootopiaSource.SUB_SOURCE_MAP_LIST;
    }

    @Override // com.tencent.mobileqq.zootopia.api.b
    public boolean onBackPressedEvent() {
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ImageView imageView;
        ImageView imageView2;
        Intrinsics.checkNotNullParameter(view, "view");
        int id5 = view.getId();
        if (id5 != R.id.r47) {
            switch (id5) {
                case R.id.r5f /* 1997015568 */:
                    onBackPressedEvent();
                    return;
                case R.id.r5g /* 1997015569 */:
                case R.id.r5h /* 1997015570 */:
                    break;
                default:
                    return;
            }
        }
        bd bdVar = this.binding;
        if (bdVar != null && (imageView2 = bdVar.f399067g) != null) {
            this.dtReportHelper.c("clck", imageView2, new LinkedHashMap());
        }
        bd bdVar2 = this.binding;
        if (bdVar2 != null && (imageView = bdVar2.f399068h) != null) {
            this.dtReportHelper.c("clck", imageView, new LinkedHashMap());
        }
        ZootopiaActivity.Companion companion = ZootopiaActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ZootopiaActivity.Companion.c(companion, requireContext, ZootopiaDownloadManagerFragment.class, Ch(), null, false, 24, null);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        this.app = waitAppRuntime instanceof AppInterface ? (AppInterface) waitAppRuntime : null;
        com.tencent.mobileqq.zootopia.helper.d.f328319a.i(1);
        try {
            URLDrawable.getDrawable("https://downv6.qq.com/shadow_qqcamera/zplan/zplan_template_loading.gif").startDownload();
        } catch (IllegalArgumentException unused) {
            QLog.i("ZPlanHomeFragment", 1, "URLDrawable preload fail");
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int statusBarHeight;
        LinearLayout linearLayout;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        this.binding = bd.g(inflater, container, false);
        LiuHaiUtils.initLiuHaiProperty(getActivity());
        if (LiuHaiUtils.isLiuHaiUseValid()) {
            statusBarHeight = LiuHaiUtils.getNotchInScreenHeight(getActivity());
        } else {
            statusBarHeight = ImmersiveUtils.getStatusBarHeight(getActivity());
        }
        bd bdVar = this.binding;
        if (bdVar != null && (linearLayout = bdVar.f399072l) != null) {
            linearLayout.setPadding(0, statusBarHeight, 0, 0);
        }
        bd bdVar2 = this.binding;
        if (bdVar2 != null) {
            return bdVar2.getRoot();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent event) {
        bd bdVar;
        ZootopiaListMapListView zootopiaListMapListView;
        com.tencent.mobileqq.zootopia.portal.home.model.a d16;
        ZootopiaListMapListView zootopiaListMapListView2;
        ZootopiaPullRefreshLayout e16;
        RecyclerViewWithHeaderFooterFix recyclerViewWithHeaderFooterFix = null;
        ZootopiaDetailFragmentCloseEvent zootopiaDetailFragmentCloseEvent = event instanceof ZootopiaDetailFragmentCloseEvent ? (ZootopiaDetailFragmentCloseEvent) event : null;
        if (zootopiaDetailFragmentCloseEvent == null || !zootopiaDetailFragmentCloseEvent.getFromBack() || (bdVar = this.binding) == null || (zootopiaListMapListView = bdVar.f399071k) == null || (d16 = zootopiaListMapListView.d()) == null) {
            return;
        }
        bd bdVar2 = this.binding;
        if (bdVar2 != null && (zootopiaListMapListView2 = bdVar2.f399071k) != null && (e16 = zootopiaListMapListView2.e()) != null) {
            recyclerViewWithHeaderFooterFix = e16.E();
        }
        d16.c(recyclerViewWithHeaderFooterFix);
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ZootopiaDownloadManager.f327992a.T0();
        if (ImmersiveUtils.couldSetStatusTextColor()) {
            ImmersiveUtils.setStatusTextColor(true, requireActivity().getWindow());
        }
        ApngImage.resumeAll();
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        int screenWidth = ScreenUtils.getScreenWidth(getContext()) - ViewUtils.dpToPx(32.0f);
        bd bdVar = this.binding;
        if (bdVar != null) {
            g gVar = g.f441394a;
            Context context = getContext();
            ImageView imageView = bdVar.f399068h;
            Intrinsics.checkNotNullExpressionValue(imageView, "it.zplanHomeDownloadDynamic");
            gVar.c(context, "ZootopiaHomeDownload", imageView);
            bdVar.f399073m.setLayoutParams(new LinearLayout.LayoutParams(screenWidth, (int) (screenWidth * 1.28d)));
            bdVar.f399070j.setVisibility(0);
            bdVar.f399066f.setOnClickListener(this);
            bdVar.f399067g.setOnClickListener(this);
            bdVar.f399068h.setOnClickListener(this);
            bdVar.f399065e.setOnClickListener(this);
            Qh(bdVar);
            Kh(bdVar);
        }
        refresh();
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.a
    public void r6(zb3.e detailParams) {
        Intrinsics.checkNotNullParameter(detailParams, "detailParams");
        id3.d.h(this.dtReportHelper, detailParams.getItemView(), "em_zplan_playground_gallery_infocard_info", Nh(detailParams.getInfo()), false, false, null, 56, null);
        this.dtReportHelper.c("clck", detailParams.getItemView(), Nh(detailParams.getInfo()));
        Ph(detailParams, false);
    }

    @Override // com.tencent.mobileqq.zootopia.portal.home.b
    public void ze(ZPlanTemplate sameStyleInfo) {
        Intent intent;
        Bundle extras;
        Intrinsics.checkNotNullParameter(sameStyleInfo, "sameStyleInfo");
        if (this.fastClickUtils.a()) {
            return;
        }
        ZplanHostActivity.Companion companion = ZplanHostActivity.INSTANCE;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        Bundle bundle = new Bundle();
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null && (extras = intent.getExtras()) != null) {
            bundle.putAll(extras);
        }
        bundle.putSerializable("template", sameStyleInfo);
        bundle.putInt("biz", 1);
        bundle.putSerializable(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, Dh());
        Unit unit = Unit.INSTANCE;
        ZplanHostActivity.Companion.c(companion, requireContext, com.tencent.sqshow.zootopia.samestyle.a.class, bundle, 0, 8, null);
    }

    private final Map<String, Object> Nh(ZootopiaMapSimpleInfo data) {
        Map<String, Object> mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair("zplan_map_id", Integer.valueOf(data.getMapID())), new Pair("zplan_module_id", "em_zplan_playground_gallery_infocard"));
        return mutableMapOf;
    }

    @Override // com.tencent.sqshow.fragment.ZootopiaBaseFragment, com.tencent.sqshow.fragment.ZPlanPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        this.binding = null;
        super.onDestroy();
    }
}
