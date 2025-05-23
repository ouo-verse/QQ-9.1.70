package com.tencent.ecommerce.biz.shophome.fragment;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.eventbus.EventObserver;
import com.tencent.ecommerce.base.eventbus.LifecycleEventBus;
import com.tencent.ecommerce.base.eventbus.ThreadMode;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeFragment;
import com.tencent.ecommerce.biz.shophome.model.ECOrderByTabInfo;
import com.tencent.ecommerce.biz.shophome.model.ECShopProductInfo;
import com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductCardCallback;
import com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductListRecyclerViewAdapter;
import com.tencent.ecommerce.biz.shophome.ui.component.ECShopSortBarComponent;
import com.tencent.ecommerce.biz.shophome.util.ECShopReportParams;
import com.tencent.ecommerce.biz.shophome.viewmodel.a;
import com.tencent.ecommerce.biz.showwindow.viewmodel.ECGlobalShowWindowViewModel;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.json.JSONObject;
import ri0.ECAddProductToWindowEvent;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 z*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003:\u0001{B\u0007\u00a2\u0006\u0004\bx\u0010yJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0006H\u0016J\b\u0010\u0016\u001a\u00020\u0006H\u0016J\b\u0010\u0017\u001a\u00020\u0006H\u0016J\b\u0010\u0018\u001a\u00020\u0006H&J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\tH&J\u000f\u0010\u001b\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0006H&R\"\u0010%\u001a\u00020\u001e8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\"\u00105\u001a\u00020.8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010=\u001a\u0002068\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010D\u001a\u00020>8\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\b\u0002\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010J\u001a\u00028\u00008\u0004@\u0004X\u0084.\u00a2\u0006\u0012\n\u0004\bE\u0010F\u001a\u0004\bG\u0010\u001c\"\u0004\bH\u0010IR\"\u0010Q\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR\"\u0010U\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010L\u001a\u0004\bS\u0010N\"\u0004\bT\u0010PR\"\u0010\\\u001a\u00020\u000f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\"\u0010`\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010L\u001a\u0004\b^\u0010N\"\u0004\b_\u0010PR\"\u0010d\u001a\u00020\u00118\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\ba\u0010L\u001a\u0004\bb\u0010N\"\u0004\bc\u0010PR$\u0010l\u001a\u0004\u0018\u00010e8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010g\u001a\u0004\bh\u0010i\"\u0004\bj\u0010kR\u001b\u0010r\u001a\u00020m8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bn\u0010o\u001a\u0004\bp\u0010qR\u001a\u0010w\u001a\b\u0012\u0004\u0012\u00020t0s8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bu\u0010v\u00a8\u0006|"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListBaseFragment;", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "T", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "product", "", "Nh", "Oh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "getContentLayoutId", "", "getBusinessDescription", "Yh", "bi", "Zh", "ai", "di", "initArguments", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "ci", "()Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "gi", "Landroid/view/ViewGroup;", "P", "Landroid/view/ViewGroup;", "getRootContainer", "()Landroid/view/ViewGroup;", "li", "(Landroid/view/ViewGroup;)V", "rootContainer", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "Uh", "()Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "setProductList", "(Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;)V", "productList", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter;", "Vh", "()Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter;", "setProductListAdapter", "(Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductListRecyclerViewAdapter;)V", "productListAdapter", "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent;", "Wh", "()Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent;", "setSortBarComponent", "(Lcom/tencent/ecommerce/biz/shophome/ui/component/ECShopSortBarComponent;)V", "sortBarComponent", "Lcom/tencent/ecommerce/biz/shophome/ui/component/c;", "Lcom/tencent/ecommerce/biz/shophome/ui/component/c;", "Sh", "()Lcom/tencent/ecommerce/biz/shophome/ui/component/c;", "setDiscountInfoComponent", "(Lcom/tencent/ecommerce/biz/shophome/ui/component/c;)V", "discountInfoComponent", "U", "Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "Xh", "setViewModel", "(Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;)V", "viewModel", "V", "Ljava/lang/String;", "ei", "()Ljava/lang/String;", "ki", "(Ljava/lang/String;)V", "isDistributorStr", "W", "fi", "mi", "isSelectStr", "X", "I", "getSource", "()I", "ni", "(I)V", "source", "Y", "Ph", "hi", "couponId", "Z", "Rh", WidgetCacheLunarData.JI, "deliverProductCallbackId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "a0", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Qh", "()Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "ii", "(Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;)V", "deliverProductCallback", "Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "b0", "Lkotlin/Lazy;", "Th", "()Lcom/tencent/ecommerce/biz/showwindow/viewmodel/ECGlobalShowWindowViewModel;", "globalShowWindowViewModel", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "Lri0/a;", "c0", "Lcom/tencent/ecommerce/base/eventbus/EventObserver;", "addProductEventObserve", "<init>", "()V", "d0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECShopHomeProductListBaseFragment<T extends a> extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    protected ViewGroup rootContainer;

    /* renamed from: Q, reason: from kotlin metadata */
    protected ECBaseRecyclerView productList;

    /* renamed from: R, reason: from kotlin metadata */
    protected ECShopHomeProductListRecyclerViewAdapter productListAdapter;

    /* renamed from: S, reason: from kotlin metadata */
    protected ECShopSortBarComponent sortBarComponent;

    /* renamed from: T, reason: from kotlin metadata */
    protected com.tencent.ecommerce.biz.shophome.ui.component.c discountInfoComponent;

    /* renamed from: U, reason: from kotlin metadata */
    protected T viewModel;

    /* renamed from: X, reason: from kotlin metadata */
    private int source;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private IECSchemeCallback deliverProductCallback;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private final Lazy globalShowWindowViewModel;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final EventObserver<ECAddProductToWindowEvent> addProductEventObserve;

    /* renamed from: V, reason: from kotlin metadata */
    private String isDistributorStr = "0";

    /* renamed from: W, reason: from kotlin metadata */
    private String isSelectStr = "0";

    /* renamed from: Y, reason: from kotlin metadata */
    private String couponId = "";

    /* renamed from: Z, reason: from kotlin metadata */
    private String deliverProductCallbackId = "";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\b\b\u0000\u0010\u0001*\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "T", "Lri0/a;", "event", "", "a", "(Lri0/a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    static final class b<T> implements EventObserver<ECAddProductToWindowEvent> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.eventbus.EventObserver
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onEvent(ECAddProductToWindowEvent eCAddProductToWindowEvent) {
            if (eCAddProductToWindowEvent.isAdded) {
                ECShopHomeProductListBaseFragment.this.Vh().M0(eCAddProductToWindowEvent.saasProductId);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/shophome/fragment/ECShopHomeProductListBaseFragment$c", "Lcom/tencent/ecommerce/biz/shophome/ui/adapter/ECShopHomeProductCardCallback;", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "product", "", "onAddProductToDeliver", "onAddProductToWindow", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECShopHomeProductCardCallback {
        c() {
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductCardCallback
        public void onAddProductToDeliver(ECShopProductInfo product) {
            ECShopHomeProductListBaseFragment.this.Nh(product);
        }

        @Override // com.tencent.ecommerce.biz.shophome.ui.adapter.ECShopHomeProductCardCallback
        public void onAddProductToWindow(ECShopProductInfo product) {
            ECShopHomeProductListBaseFragment.this.Oh(product);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "T", "Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d<T> implements Observer<JSONObject> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(JSONObject jSONObject) {
            JSONObject optJSONObject = jSONObject.optJSONObject("discount_info");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            if (optJSONObject.length() > 0) {
                ECShopHomeProductListBaseFragment.this.Sh().c(jSONObject.toString());
                ECShopHomeProductListBaseFragment.this.Sh().setComponentViewVisibility(0);
            } else {
                ECShopHomeProductListBaseFragment.this.Sh().setComponentViewVisibility(8);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "T", "", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<List<? extends ECOrderByTabInfo>> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECOrderByTabInfo> list) {
            if (!list.isEmpty()) {
                ECShopHomeProductListBaseFragment.this.Wh().i(list);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "T", "Lcom/tencent/ecommerce/biz/shophome/model/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lcom/tencent/ecommerce/biz/shophome/model/a;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<ECOrderByTabInfo> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECOrderByTabInfo eCOrderByTabInfo) {
            ECShopHomeProductListBaseFragment.this.Wh().h(eCOrderByTabInfo);
            ECShopHomeProductListBaseFragment.this.Vh().F0(eCOrderByTabInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0007\u001a\u00020\u0006\"\b\b\u0000\u0010\u0001*\u00020\u00002\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003 \u0004*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "T", "", "Lcom/tencent/ecommerce/biz/shophome/model/c;", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<List<? extends ECShopProductInfo>> {
        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECShopProductInfo> list) {
            ECShopHomeProductListRecyclerViewAdapter Vh = ECShopHomeProductListBaseFragment.this.Vh();
            Boolean value = ECShopHomeProductListBaseFragment.this.Xh().g2().getValue();
            if (value == null) {
                value = Boolean.FALSE;
            }
            Vh.J0(list, value.booleanValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0006\u001a\u00020\u0005\"\b\b\u0000\u0010\u0001*\u00020\u00002\u000e\u0010\u0004\u001a\n \u0003*\u0004\u0018\u00010\u00020\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/viewmodel/a;", "T", "", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h<T> implements Observer<Boolean> {
        h() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
                boolean c16 = companion.c(ECShopHomeProductListBaseFragment.this.getIsSelectStr());
                boolean a16 = companion.a(ECShopHomeProductListBaseFragment.this.getIsDistributorStr());
                if (!c16 && !a16) {
                    RecyclerView.LayoutManager layoutManager = ECShopHomeProductListBaseFragment.this.Uh().getLayoutManager();
                    if (layoutManager != null) {
                        ((StaggeredGridLayoutManager) layoutManager).scrollToPositionWithOffset(0, 0);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.StaggeredGridLayoutManager");
                    }
                } else {
                    RecyclerView.LayoutManager layoutManager2 = ECShopHomeProductListBaseFragment.this.Uh().getLayoutManager();
                    if (layoutManager2 != null) {
                        ((LinearLayoutManager) layoutManager2).scrollToPositionWithOffset(0, 0);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
                    }
                }
                ECShopHomeProductListBaseFragment.this.Xh().n2(false);
            }
        }
    }

    public ECShopHomeProductListBaseFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.globalShowWindowViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECGlobalShowWindowViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.shophome.fragment.ECShopHomeProductListBaseFragment$$special$$inlined$viewModels$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = ((ViewModelStoreOwner) Function0.this.invoke()).getViewModelStore();
                Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "ownerProducer().viewModelStore");
                return viewModelStore;
            }
        }, null);
        this.addProductEventObserve = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Nh(ECShopProductInfo product) {
        JSONObject jSONObject;
        i.f101155b.d(requireActivity().getResources().getString(R.string.wf6), ECToastIcon.ICON_SUCCESS, 0);
        cg0.a.b("ECShopHomeProductListBaseFragment", "[handleAddBtnClick] name = " + product.name);
        JSONObject dataJson = product.getDataJson();
        if (dataJson == null || (jSONObject = dataJson.optJSONObject("active_info")) == null) {
            jSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("active_id", "");
        int optInt = jSONObject.optInt("active_type", 0);
        com.tencent.ecommerce.biz.shophome.util.a aVar = com.tencent.ecommerce.biz.shophome.util.a.f104379a;
        ECShopReportParams c16 = aVar.c(getArguments());
        aVar.g(c16.role, c16.shopId, c16.source, product.id, optString, optInt);
        com.tencent.ecommerce.biz.shophome.util.b bVar = com.tencent.ecommerce.biz.shophome.util.b.f104380a;
        FragmentActivity requireActivity = requireActivity();
        Bundle arguments = getArguments();
        JSONObject dataJson2 = product.getDataJson();
        if (dataJson2 == null) {
            dataJson2 = new JSONObject();
        }
        bVar.b(requireActivity, arguments, dataJson2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Oh(ECShopProductInfo product) {
        JSONObject dataJson = product.getDataJson();
        if (dataJson == null) {
            dataJson = new JSONObject();
        }
        JSONObject jSONObject = dataJson;
        if (jSONObject.length() <= 0) {
            return;
        }
        cg0.a.b("ECShopHomeProductListBaseFragment", "[addProductToWindow] name = " + product.name);
        JSONObject optJSONObject = jSONObject.optJSONObject("product_id_info");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        Th().N1(requireContext(), optJSONObject.optString("sub_type", ""), optJSONObject.optString("id", ""), String.valueOf(optJSONObject.optInt("type", 0)), jSONObject);
    }

    private final ECGlobalShowWindowViewModel Th() {
        return (ECGlobalShowWindowViewModel) this.globalShowWindowViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Ph, reason: from getter */
    public final String getCouponId() {
        return this.couponId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Qh, reason: from getter */
    public final IECSchemeCallback getDeliverProductCallback() {
        return this.deliverProductCallback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: Rh, reason: from getter */
    public final String getDeliverProductCallbackId() {
        return this.deliverProductCallbackId;
    }

    protected final com.tencent.ecommerce.biz.shophome.ui.component.c Sh() {
        com.tencent.ecommerce.biz.shophome.ui.component.c cVar = this.discountInfoComponent;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountInfoComponent");
        }
        return cVar;
    }

    protected final ECBaseRecyclerView Uh() {
        ECBaseRecyclerView eCBaseRecyclerView = this.productList;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productList");
        }
        return eCBaseRecyclerView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ECShopHomeProductListRecyclerViewAdapter Vh() {
        ECShopHomeProductListRecyclerViewAdapter eCShopHomeProductListRecyclerViewAdapter = this.productListAdapter;
        if (eCShopHomeProductListRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
        }
        return eCShopHomeProductListRecyclerViewAdapter;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ECShopSortBarComponent Wh() {
        ECShopSortBarComponent eCShopSortBarComponent = this.sortBarComponent;
        if (eCShopSortBarComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortBarComponent");
        }
        return eCShopSortBarComponent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final T Xh() {
        T t16 = this.viewModel;
        if (t16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        return t16;
    }

    public void Zh() {
        this.discountInfoComponent = new com.tencent.ecommerce.biz.shophome.ui.component.c(requireActivity());
        ViewGroup viewGroup = this.rootContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        com.tencent.ecommerce.biz.shophome.ui.component.c cVar = this.discountInfoComponent;
        if (cVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("discountInfoComponent");
        }
        viewGroup.addView(cVar.getComponentView());
    }

    public void ai() {
        ECShopHomeFragment.Companion companion = ECShopHomeFragment.INSTANCE;
        boolean a16 = companion.a(this.isDistributorStr);
        boolean c16 = companion.c(this.isSelectStr);
        ECBaseRecyclerView eCBaseRecyclerView = new ECBaseRecyclerView(requireContext());
        this.productList = eCBaseRecyclerView;
        eCBaseRecyclerView.setOverScrollMode(2);
        ECBaseRecyclerView eCBaseRecyclerView2 = this.productList;
        if (eCBaseRecyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productList");
        }
        eCBaseRecyclerView2.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.productListAdapter = new ECShopHomeProductListRecyclerViewAdapter(requireActivity(), getArguments(), new c());
        if (!a16 && !c16) {
            ECBaseRecyclerView eCBaseRecyclerView3 = this.productList;
            if (eCBaseRecyclerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            eCBaseRecyclerView3.setLayoutManager(new StaggeredGridLayoutManager(2, 1));
            ECBaseRecyclerView eCBaseRecyclerView4 = this.productList;
            if (eCBaseRecyclerView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            ECShopHomeProductListRecyclerViewAdapter eCShopHomeProductListRecyclerViewAdapter = this.productListAdapter;
            if (eCShopHomeProductListRecyclerViewAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
            }
            eCBaseRecyclerView4.setAdapter(eCShopHomeProductListRecyclerViewAdapter);
            ECBaseRecyclerView eCBaseRecyclerView5 = this.productList;
            if (eCBaseRecyclerView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            eCBaseRecyclerView5.setPadding((int) getResources().getDimension(R.dimen.f101218), 0, (int) getResources().getDimension(R.dimen.f101319), 0);
            ECBaseRecyclerView eCBaseRecyclerView6 = this.productList;
            if (eCBaseRecyclerView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            eCBaseRecyclerView6.setItemAnimator(null);
            ViewGroup viewGroup = this.rootContainer;
            if (viewGroup == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            }
            ECBaseRecyclerView eCBaseRecyclerView7 = this.productList;
            if (eCBaseRecyclerView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            viewGroup.addView(eCBaseRecyclerView7);
        } else {
            ECBaseRecyclerView eCBaseRecyclerView8 = this.productList;
            if (eCBaseRecyclerView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            eCBaseRecyclerView8.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
            ECBaseRecyclerView eCBaseRecyclerView9 = this.productList;
            if (eCBaseRecyclerView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            ECShopHomeProductListRecyclerViewAdapter eCShopHomeProductListRecyclerViewAdapter2 = this.productListAdapter;
            if (eCShopHomeProductListRecyclerViewAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
            }
            eCBaseRecyclerView9.setAdapter(eCShopHomeProductListRecyclerViewAdapter2);
            ECBaseRecyclerView eCBaseRecyclerView10 = this.productList;
            if (eCBaseRecyclerView10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            eCBaseRecyclerView10.setItemAnimator(null);
            ViewGroup viewGroup2 = this.rootContainer;
            if (viewGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
            }
            ECBaseRecyclerView eCBaseRecyclerView11 = this.productList;
            if (eCBaseRecyclerView11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("productList");
            }
            viewGroup2.addView(eCBaseRecyclerView11);
        }
        ECBaseRecyclerView eCBaseRecyclerView12 = this.productList;
        if (eCBaseRecyclerView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productList");
        }
        eCBaseRecyclerView12.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6471n));
        ECShopHomeProductListRecyclerViewAdapter eCShopHomeProductListRecyclerViewAdapter3 = this.productListAdapter;
        if (eCShopHomeProductListRecyclerViewAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
        }
        ECShopSortBarComponent eCShopSortBarComponent = this.sortBarComponent;
        if (eCShopSortBarComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortBarComponent");
        }
        eCShopHomeProductListRecyclerViewAdapter3.F0(eCShopSortBarComponent.getSelectedOrderByTabInfo());
    }

    public void bi() {
        this.sortBarComponent = new ECShopSortBarComponent(requireContext(), getArguments(), ECOrderByTabInfo.INSTANCE.a(), null, 8, null);
        ViewGroup viewGroup = this.rootContainer;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rootContainer");
        }
        ECShopSortBarComponent eCShopSortBarComponent = this.sortBarComponent;
        if (eCShopSortBarComponent == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sortBarComponent");
        }
        viewGroup.addView(eCShopSortBarComponent.getComponentView());
    }

    public abstract T ci();

    public void di() {
        T ci5 = ci();
        this.viewModel = ci5;
        if (ci5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        ci5.Z1().observe(getViewLifecycleOwner(), new d());
        T t16 = this.viewModel;
        if (t16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        t16.Q1().observe(getViewLifecycleOwner(), new e());
        T t17 = this.viewModel;
        if (t17 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        t17.P1().observe(getViewLifecycleOwner(), new f());
        T t18 = this.viewModel;
        if (t18 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        t18.S1().observe(getViewLifecycleOwner(), new g());
        com.tencent.ecommerce.base.ktx.f fVar = com.tencent.ecommerce.base.ktx.f.f100751a;
        T t19 = this.viewModel;
        if (t19 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fVar.a(t19.S1());
        T t26 = this.viewModel;
        if (t26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        t26.X1().observe(getViewLifecycleOwner(), new h());
        T t27 = this.viewModel;
        if (t27 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        }
        fVar.a(t27.X1());
        LifecycleEventBus.f100688b.d(ThreadMode.ORIGIN, ECAddProductToWindowEvent.class, this.addProductEventObserve);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: ei, reason: from getter */
    public final String getIsDistributorStr() {
        return this.isDistributorStr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: fi, reason: from getter */
    public final String getIsSelectStr() {
        return this.isSelectStr;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopHomeProductListBaseFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        throw new IllegalArgumentException("\u5b50\u7c7b\u9700\u8981\u91cd\u5199\u8be5\u65b9\u6cd5, \u6307\u5b9a\u7279\u5b9a\u7684layout\u5e03\u5c40\u6587\u4ef6");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int getSource() {
        return this.source;
    }

    public abstract void gi();

    /* JADX INFO: Access modifiers changed from: protected */
    public final void hi(String str) {
        this.couponId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ii(IECSchemeCallback iECSchemeCallback) {
        this.deliverProductCallback = iECSchemeCallback;
    }

    public abstract void initArguments();

    public abstract void initUI(View rootView);

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ji(String str) {
        this.deliverProductCallbackId = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ki(String str) {
        this.isDistributorStr = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void li(ViewGroup viewGroup) {
        this.rootContainer = viewGroup;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void mi(String str) {
        this.isSelectStr = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void ni(int i3) {
        this.source = i3;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        ECShopHomeProductListRecyclerViewAdapter eCShopHomeProductListRecyclerViewAdapter = this.productListAdapter;
        if (eCShopHomeProductListRecyclerViewAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("productListAdapter");
        }
        eCShopHomeProductListRecyclerViewAdapter.t0();
        LifecycleEventBus.f100688b.e(this.addProductEventObserve);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initArguments();
        initUI(view);
        Yh();
        bi();
        Zh();
        ai();
        di();
        gi();
    }

    public void Yh() {
    }
}
