package com.tencent.ecommerce.biz.aftersale.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.report.service.m;
import com.tencent.ecommerce.base.rmonitor.service.ECRMonitorManager;
import com.tencent.ecommerce.base.ui.ECFormRowItem;
import com.tencent.ecommerce.base.ui.ECSelectionListDialog;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.d;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.aftersale.viewmodel.ECAfterSaleApplyViewModel;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.util.s;
import com.tencent.ecommerce.repo.aftersale.apply.ApplyType;
import com.tencent.ecommerce.repo.aftersale.apply.OptionValue;
import com.tencent.ecommerce.repo.aftersale.apply.PageType;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyEntryItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ECAfterSaleApplyExtraItem;
import com.tencent.ecommerce.repo.aftersale.apply.item.ItemType;
import com.tencent.ecommerce.repo.aftersale.apply.item.e;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.out.webPlugins.MiniAppPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 l2\u00020\u00012\u00020\u0002:\u0001mB\u0007\u00a2\u0006\u0004\bj\u0010kJ\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\f\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0005H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\b\u0010\u0017\u001a\u00020\u0005H\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0007H\u0002J\b\u0010\u001b\u001a\u00020\u0005H\u0002J\u0010\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\nH\u0002J\b\u0010\u001e\u001a\u00020\u0005H\u0002J\u0012\u0010 \u001a\u00020\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0012H\u0002J\b\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\u0005H\u0002J\b\u0010#\u001a\u00020\u0005H\u0002J\u0016\u0010'\u001a\u00020\u00052\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010(\u001a\u00020\u0005H\u0002J\u0010\u0010+\u001a\u00020\u00052\u0006\u0010*\u001a\u00020)H\u0002J\u0018\u00100\u001a\u00020\u00052\u0006\u0010-\u001a\u00020,2\u0006\u0010/\u001a\u00020.H\u0002J\b\u00101\u001a\u00020\u0005H\u0002R\u0016\u00104\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u00103R\u0016\u0010<\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b;\u00103R\u0016\u0010>\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u00103R\u0016\u0010@\u001a\u00020\u00128\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u00103R\u001b\u0010F\u001a\u00020A8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010\\R\u001b\u0010b\u001a\u00020^8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b_\u0010C\u001a\u0004\b`\u0010aR\u0014\u0010f\u001a\u00020c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020\u00128BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\bg\u0010h\u00a8\u0006n"}, d2 = {"Lcom/tencent/ecommerce/biz/aftersale/ui/fragment/ECAfterSaleApplyFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View$OnClickListener;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Bh", "Dh", "Eh", "v", NodeProps.ON_CLICK, "", "getContentLayoutId", "", "getBusinessDescription", "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "initArguments", "ne", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ii", "isSuccess", "si", "ki", "failMsg", "mi", "ni", WidgetCacheLunarData.JI, "ti", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "mediaList", "oi", "qi", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/b;", "entryItem", "li", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/e;", "optionItem", "Lcom/tencent/ecommerce/biz/aftersale/ui/viewholder/apply/d;", "optionHolder", "pi", "ri", "P", "Ljava/lang/String;", "orderID", "Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;", "pageType", BdhLogUtil.LogTag.Tag_Req, "skuID", ExifInterface.LATITUDE_SOUTH, "processID", "T", WadlProxyConsts.CHANNEL, "U", "afterSaleID", "Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel;", "V", "Lkotlin/Lazy;", "hi", "()Lcom/tencent/ecommerce/biz/aftersale/viewmodel/ECAfterSaleApplyViewModel;", "viewModel", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "W", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Landroidx/recyclerview/widget/RecyclerView;", "X", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Ljh0/a;", "Y", "Ljh0/a;", "listAdapter", "Z", "Landroid/view/View;", "submitArea", "Landroid/widget/Button;", "a0", "Landroid/widget/Button;", "submitButton", "Lcom/tencent/ecommerce/base/ui/d;", "b0", "Lcom/tencent/ecommerce/base/ui/d;", "loadingDialog", "Landroid/os/Handler;", "c0", "gi", "()Landroid/os/Handler;", "uiHandler", "Lcom/tencent/ecommerce/base/report/service/k;", "d0", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTime", "getLogTag", "()Ljava/lang/String;", "logTag", "<init>", "()V", "e0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAfterSaleApplyFragment extends ECBaseFragment implements View.OnClickListener {

    /* renamed from: P, reason: from kotlin metadata */
    private String orderID;

    /* renamed from: Q, reason: from kotlin metadata */
    private PageType pageType;

    /* renamed from: R, reason: from kotlin metadata */
    private String skuID;

    /* renamed from: S, reason: from kotlin metadata */
    private String processID;

    /* renamed from: T, reason: from kotlin metadata */
    private String channel;

    /* renamed from: U, reason: from kotlin metadata */
    private String afterSaleID;

    /* renamed from: V, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: W, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: X, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: Y, reason: from kotlin metadata */
    private jh0.a listAdapter;

    /* renamed from: Z, reason: from kotlin metadata */
    private View submitArea;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Button submitButton;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.base.ui.d loadingDialog;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final Lazy uiHandler;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private final k showPageCostTime;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/aftersale/ui/fragment/ECAfterSaleApplyFragment$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 1 || newState == 2) {
                ECAfterSaleApplyFragment.this.ii();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0001 \u0002*\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"", "Lcom/tencent/ecommerce/repo/aftersale/apply/item/d;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<List<? extends com.tencent.ecommerce.repo.aftersale.apply.item.d>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<? extends com.tencent.ecommerce.repo.aftersale.apply.item.d> list) {
            cg0.a.b(ECAfterSaleApplyFragment.this.getLogTag(), "LiveDataChange applyItemListLiveData onChange, size:" + list.size());
            ECAfterSaleApplyFragment.Lh(ECAfterSaleApplyFragment.this).setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<String> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(String str) {
            cg0.a.b(ECAfterSaleApplyFragment.this.getLogTag(), "LiveDataChange pageTitleLiveData onChange, value:" + str);
            ECAfterSaleApplyFragment.this.setTitle(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/repo/aftersale/apply/PageType;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<PageType> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(PageType pageType) {
            cg0.a.b(ECAfterSaleApplyFragment.this.getLogTag(), "LiveDataChange targetPageTypeLiveData onChange, value:" + pageType);
            ECAfterSaleApplyFragment.this.pageType = pageType;
            int i3 = a.f101305b[ECAfterSaleApplyFragment.Oh(ECAfterSaleApplyFragment.this).ordinal()];
            if (i3 == 1 || i3 == 2) {
                ECAfterSaleApplyFragment.Qh(ECAfterSaleApplyFragment.this).setVisibility(8);
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                ECAfterSaleApplyFragment.Qh(ECAfterSaleApplyFragment.this).setVisibility(0);
            }
        }
    }

    public ECAfterSaleApplyFragment() {
        Lazy lazy;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECAfterSaleApplyViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).get_viewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$uiHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.uiHandler = lazy;
        this.showPageCostTime = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_AFTER_SALE_APPLY);
    }

    public static final /* synthetic */ jh0.a Lh(ECAfterSaleApplyFragment eCAfterSaleApplyFragment) {
        jh0.a aVar = eCAfterSaleApplyFragment.listAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ PageType Oh(ECAfterSaleApplyFragment eCAfterSaleApplyFragment) {
        PageType pageType = eCAfterSaleApplyFragment.pageType;
        if (pageType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageType");
        }
        return pageType;
    }

    public static final /* synthetic */ ECStateCenterView Ph(ECAfterSaleApplyFragment eCAfterSaleApplyFragment) {
        ECStateCenterView eCStateCenterView = eCAfterSaleApplyFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    public static final /* synthetic */ View Qh(ECAfterSaleApplyFragment eCAfterSaleApplyFragment) {
        View view = eCAfterSaleApplyFragment.submitArea;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitArea");
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getLogTag() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("ECAfterSaleApplyFragment_");
        PageType pageType = this.pageType;
        if (pageType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageType");
        }
        sb5.append(pageType);
        return sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Handler gi() {
        return (Handler) this.uiHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECAfterSaleApplyViewModel hi() {
        return (ECAfterSaleApplyViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ii() {
        View currentFocus;
        FragmentActivity activity = getActivity();
        if (activity == null || (currentFocus = activity.getCurrentFocus()) == null) {
            return;
        }
        cg0.a.b(getLogTag(), "hideSoftInputFromWindow");
        FragmentActivity activity2 = getActivity();
        Object systemService = activity2 != null ? activity2.getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD) : null;
        if (systemService != null) {
            ((InputMethodManager) systemService).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    private final void initArguments() {
        Intent intent;
        FragmentActivity activity = getActivity();
        Bundle bundle = null;
        Intent intent2 = activity != null ? activity.getIntent() : null;
        if (intent2 != null) {
            this.pageType = PageType.INSTANCE.a(s.a(intent2.getStringExtra(MiniAppPlugin.ATTR_PAGE_TYPE), 0));
            String stringExtra = intent2.getStringExtra("order_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.orderID = stringExtra;
            String stringExtra2 = intent2.getStringExtra("after_sales_id");
            if (stringExtra2 == null) {
                stringExtra2 = "";
            }
            this.afterSaleID = stringExtra2;
            String stringExtra3 = intent2.getStringExtra("sku_id");
            if (stringExtra3 == null) {
                stringExtra3 = "";
            }
            this.skuID = stringExtra3;
            String stringExtra4 = intent2.getStringExtra(CrashHianalyticsData.PROCESS_ID);
            if (stringExtra4 == null) {
                stringExtra4 = "";
            }
            this.processID = stringExtra4;
            String stringExtra5 = intent2.getStringExtra(WadlProxyConsts.CHANNEL);
            this.channel = stringExtra5 != null ? stringExtra5 : "";
        }
        String logTag = getLogTag();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("initArguments, intent.extras:");
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            bundle = intent.getExtras();
        }
        sb5.append(String.valueOf(bundle));
        cg0.a.b(logTag, sb5.toString());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ji() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mqqapi://ecommerce/open?src_type=internal&version=1&target=38&order_id=");
        String str = this.orderID;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderID");
        }
        sb5.append(str);
        sb5.append("&sku_id=");
        String str2 = this.skuID;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skuID");
        }
        sb5.append(str2);
        sb5.append("&channel=");
        String str3 = this.channel;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.CHANNEL);
        }
        sb5.append(str3);
        ECScheme.g(sb5.toString(), null, 2, null);
    }

    private final void ki() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECAfterSaleApplyFragment$observeUiState$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void li(ECAfterSaleApplyEntryItem entryItem) {
        cg0.a.b(getLogTag(), "onEntryClick entryItem: " + entryItem);
        int i3 = a.f101304a[entryItem.getApplyType().ordinal()];
        if (i3 == 1) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("mqqapi://ecommerce/open?target=36&channel=2&page_type=");
            sb5.append(PageType.PAGE_TYPE_REFUND_ONLY.value);
            sb5.append("&order_id=");
            String str = this.orderID;
            if (str == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderID");
            }
            sb5.append(str);
            sb5.append("&sku_id=");
            String str2 = this.skuID;
            if (str2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("skuID");
            }
            sb5.append(str2);
            sb5.append("&channel=");
            String str3 = this.channel;
            if (str3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.CHANNEL);
            }
            sb5.append(str3);
            ECScheme.g(sb5.toString(), null, 2, null);
            ih0.b bVar = ih0.b.f407641a;
            ApplyType applyType = ApplyType.APPLY_TYPE_REFUND_ONLY;
            String str4 = this.orderID;
            if (str4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("orderID");
            }
            bVar.b(applyType, str4);
            return;
        }
        if (i3 != 2) {
            cg0.a.a(getLogTag(), "onEntryClick", "wrong click! entryItem: " + entryItem);
            return;
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
        StringBuilder sb6 = new StringBuilder();
        sb6.append("mqqapi://ecommerce/open?target=36&channel=2&page_type=");
        sb6.append(PageType.PAGE_TYPE_RETURN_REFUND.value);
        sb6.append("&order_id=");
        String str5 = this.orderID;
        if (str5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderID");
        }
        sb6.append(str5);
        sb6.append("&sku_id=");
        String str6 = this.skuID;
        if (str6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skuID");
        }
        sb6.append(str6);
        sb6.append("&channel=");
        String str7 = this.channel;
        if (str7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(WadlProxyConsts.CHANNEL);
        }
        sb6.append(str7);
        ECScheme.g(sb6.toString(), null, 2, null);
        ih0.b bVar2 = ih0.b.f407641a;
        ApplyType applyType2 = ApplyType.APPLY_TYPE_RETURN_REFUND;
        String str8 = this.orderID;
        if (str8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderID");
        }
        bVar2.b(applyType2, str8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi(String failMsg) {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setFailedState(failMsg != null ? failMsg : "");
        si(failMsg != null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ne() {
        ECAfterSaleApplyViewModel hi5 = hi();
        PageType pageType = this.pageType;
        if (pageType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageType");
        }
        String str = this.orderID;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderID");
        }
        String str2 = this.skuID;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skuID");
        }
        String str3 = this.afterSaleID;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("afterSaleID");
        }
        hi5.U1(pageType, str, str2, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ni() {
        ECStateCenterView eCStateCenterView = this.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setSucceededState();
        ih0.b bVar = ih0.b.f407641a;
        PageType pageType = this.pageType;
        if (pageType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageType");
        }
        String str = this.orderID;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderID");
        }
        bVar.c(pageType, str);
        si(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void oi(List<ECMediaInfo> mediaList) {
        cg0.a.b("ECAfterSaleApplyFragment", "onMediaChange mediaList:" + mediaList);
        hi().X1(mediaList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void pi(final com.tencent.ecommerce.repo.aftersale.apply.item.e optionItem, final com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.d optionHolder) {
        cg0.a.b(getLogTag(), "onOptionClick optionItem: " + optionItem);
        if (optionItem.getOptionInfo().getIsDisable() || optionItem.getOptionInfo().d().isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<OptionValue> it = optionItem.getOptionInfo().d().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getText());
        }
        String str = "\u9009\u62e9" + optionItem.getOptionInfo().getKeyText();
        OptionValue selectedOption = optionItem.getOptionInfo().getSelectedOption();
        new ECSelectionListDialog(str, arrayList, selectedOption != null ? selectedOption.getText() : null).uh(getChildFragmentManager(), new Function1<ECSelectionListDialog.SelectionListDialogResult, Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$onOptionClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECSelectionListDialog.SelectionListDialogResult selectionListDialogResult) {
                invoke2(selectionListDialogResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECSelectionListDialog.SelectionListDialogResult selectionListDialogResult) {
                ECAfterSaleApplyViewModel hi5;
                if (Intrinsics.areEqual(selectionListDialogResult, ECSelectionListDialog.SelectionListDialogResult.Cancel.f101115d)) {
                    cg0.a.b(ECAfterSaleApplyFragment.this.getLogTag(), "onOptionClick result Cancel");
                    return;
                }
                if (selectionListDialogResult instanceof ECSelectionListDialog.SelectionListDialogResult.SelectedResult) {
                    cg0.a.b(ECAfterSaleApplyFragment.this.getLogTag(), "onOptionClick result selectedIndex: " + selectionListDialogResult + ".selectedIndex");
                    optionItem.getOptionInfo().g(optionItem.getOptionInfo().d().get(((ECSelectionListDialog.SelectionListDialogResult.SelectedResult) selectionListDialogResult).selectedIndex));
                    ECFormRowItem formRowItem = optionHolder.getFormRowItem();
                    OptionValue selectedOption2 = optionItem.getOptionInfo().getSelectedOption();
                    formRowItem.setRightText(selectedOption2 != null ? selectedOption2.getText() : null);
                    TextView rightTextView = optionHolder.getFormRowItem().getRightTextView();
                    if (rightTextView != null) {
                        rightTextView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6942x));
                    }
                    if (optionItem.getItemType() == ItemType.TYPE_OPTION_ITEM) {
                        hi5 = ECAfterSaleApplyFragment.this.hi();
                        hi5.a2(optionItem);
                    }
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00c9 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void qi() {
        boolean z16;
        boolean isBlank;
        List<com.tencent.ecommerce.repo.aftersale.apply.item.d> value = hi().Q1().getValue();
        if (value != null) {
            ArrayList<com.tencent.ecommerce.repo.aftersale.apply.item.e> arrayList = new ArrayList();
            for (Object obj : value) {
                if (obj instanceof com.tencent.ecommerce.repo.aftersale.apply.item.e) {
                    arrayList.add(obj);
                }
            }
            for (com.tencent.ecommerce.repo.aftersale.apply.item.e eVar : arrayList) {
                if (eVar.getOptionInfo().getSelectedOption() == null && eVar.getOptionInfo().getDefaultValue() == null) {
                    i.f101155b.d("\u8bf7\u9009\u62e9" + eVar.getOptionInfo().getKeyText(), ECToastIcon.ICON_DEFAULT, 0);
                    return;
                }
            }
        }
        List<com.tencent.ecommerce.repo.aftersale.apply.item.d> value2 = hi().Q1().getValue();
        if (value2 != null) {
            ArrayList<ECAfterSaleApplyExtraItem> arrayList2 = new ArrayList();
            for (Object obj2 : value2) {
                if (obj2 instanceof ECAfterSaleApplyExtraItem) {
                    arrayList2.add(obj2);
                }
            }
            for (ECAfterSaleApplyExtraItem eCAfterSaleApplyExtraItem : arrayList2) {
                if (eCAfterSaleApplyExtraItem.getIsRequired()) {
                    String extraText = eCAfterSaleApplyExtraItem.getExtraText();
                    if (extraText != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(extraText);
                        if (!isBlank) {
                            z16 = false;
                            if (!z16) {
                                i.f101155b.d(getString(R.string.wfn), ECToastIcon.ICON_DEFAULT, 0);
                                return;
                            } else if (eCAfterSaleApplyExtraItem.c().isEmpty()) {
                                i.f101155b.d(getString(R.string.wfy), ECToastIcon.ICON_DEFAULT, 0);
                                return;
                            }
                        }
                    }
                    z16 = true;
                    if (!z16) {
                    }
                }
            }
        }
        ECAfterSaleApplyViewModel hi5 = hi();
        PageType pageType = this.pageType;
        if (pageType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageType");
        }
        String str = this.orderID;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("orderID");
        }
        String str2 = this.skuID;
        if (str2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("skuID");
        }
        String str3 = this.afterSaleID;
        if (str3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("afterSaleID");
        }
        String str4 = this.processID;
        if (str4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("processID");
        }
        hi5.Z1(pageType, str, str2, str3, str4);
    }

    private final void ri() {
        hi().Q1().observe(getViewLifecycleOwner(), new c());
        hi().R1().observe(getViewLifecycleOwner(), new d());
        hi().S1().observe(getViewLifecycleOwner(), new e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void si(boolean isSuccess) {
        Map<Object, ? extends Object> d16 = new m().c(isSuccess ? 2 : 3).d();
        this.showPageCostTime.b(d16);
        cg0.a.b("ECAfterSaleApplyFragment", "[reportShowPageCostWhenGetNetworkData] params = " + d16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ti() {
        gi().postDelayed(new Runnable() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$showSubmitLoading$1
            /* JADX WARN: Code restructure failed: missing block: B:3:0x0008, code lost:
            
                r0 = r5.this$0.loadingDialog;
             */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void run() {
                d dVar;
                d dVar2;
                dVar = ECAfterSaleApplyFragment.this.loadingDialog;
                if (dVar != null && dVar2 != null) {
                    dVar2.show();
                }
                ECAfterSaleApplyFragment eCAfterSaleApplyFragment = ECAfterSaleApplyFragment.this;
                d dVar3 = new d(ECAfterSaleApplyFragment.this.requireContext(), ECAfterSaleApplyFragment.this.getString(R.string.wfl));
                dVar3.show();
                Unit unit = Unit.INSTANCE;
                eCAfterSaleApplyFragment.loadingDialog = dVar3;
            }
        }, 200L);
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
        return "ECAfterSaleApplyFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Integer valueOf = v3 != null ? Integer.valueOf(v3.getId()) : null;
        if (valueOf != null && valueOf.intValue() == R.id.obb) {
            qi();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        gi().removeCallbacksAndMessages(null);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        ECRMonitorManager.f100953c.b("EC_STAGE_AFTER_SALE_PAGE_APPLY");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ECRMonitorManager.f100953c.c("EC_STAGE_AFTER_SALE_PAGE_APPLY");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initUI(view);
        ri();
        ne();
        ki();
    }

    private final void initUI(View rootView) {
        ECStateCenterView eCStateCenterView = (ECStateCenterView) rootView.findViewById(R.id.f163103ob2);
        this.stateView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$initUI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ECAfterSaleApplyFragment.this.ne();
            }
        });
        this.submitArea = rootView.findViewById(R.id.ob_);
        Button button = (Button) rootView.findViewById(R.id.obb);
        this.submitButton = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitButton");
        }
        button.setOnClickListener(this);
        jh0.a aVar = new jh0.a(requireActivity());
        this.listAdapter = aVar;
        aVar.l0(new Function1<ECAfterSaleApplyEntryItem, Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$initUI$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ECAfterSaleApplyEntryItem eCAfterSaleApplyEntryItem) {
                invoke2(eCAfterSaleApplyEntryItem);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ECAfterSaleApplyEntryItem eCAfterSaleApplyEntryItem) {
                ECAfterSaleApplyFragment.this.li(eCAfterSaleApplyEntryItem);
            }
        });
        jh0.a aVar2 = this.listAdapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        aVar2.n0(new Function2<com.tencent.ecommerce.repo.aftersale.apply.item.e, com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.d, Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$initUI$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(e eVar, com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.d dVar) {
                invoke2(eVar, dVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e eVar, com.tencent.ecommerce.biz.aftersale.ui.viewholder.apply.d dVar) {
                ECAfterSaleApplyFragment.this.pi(eVar, dVar);
            }
        });
        jh0.a aVar3 = this.listAdapter;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        aVar3.m0(new Function1<List<? extends ECMediaInfo>, Unit>() { // from class: com.tencent.ecommerce.biz.aftersale.ui.fragment.ECAfterSaleApplyFragment$initUI$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ECMediaInfo> list) {
                invoke2((List<ECMediaInfo>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ECMediaInfo> list) {
                ECAfterSaleApplyFragment.this.oi(list);
            }
        });
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.o8n);
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        jh0.a aVar4 = this.listAdapter;
        if (aVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listAdapter");
        }
        recyclerView.setAdapter(aVar4);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.addOnScrollListener(new b());
    }
}
