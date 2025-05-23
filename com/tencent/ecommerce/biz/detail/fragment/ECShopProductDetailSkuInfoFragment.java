package com.tencent.ecommerce.biz.detail.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ktx.ISoftKeyBoardStateListenerRegistry;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECBasePtsView;
import com.tencent.ecommerce.base.ui.ECBasePtsViewData;
import com.tencent.ecommerce.base.ui.ECBaseViewController;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.component.ECBaseRecyclerView;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.detail.repo.shop.data.ECShopProductDetailBuyFloatPageInfo;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.ECShopDetailSkuInfoViewModel;
import com.tencent.ecommerce.biz.detail.viewmodel.shop.SkuInfoType;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.ecommerce.biz.util.e;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qqmini.sdk.request.GetAdInfoRequest;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.json.JSONObject;
import ug0.a;

@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\u0018\u0000 p2\u00020\u0001:\u0001qB\u0007\u00a2\u0006\u0004\bn\u0010oJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0006H\u0016J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\u0006H\u0016J\b\u0010\u000f\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0010J\b\u0010\u0015\u001a\u00020\fH\u0002J.\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00172\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001c\u001a\u00020\fH\u0002J\b\u0010\u001d\u001a\u00020\fH\u0002J\b\u0010\u001e\u001a\u00020\fH\u0002J\b\u0010\u001f\u001a\u00020\fH\u0002J\b\u0010!\u001a\u00020 H\u0002R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u001b\u0010,\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010$\u001a\u0004\b*\u0010+R\u0016\u0010/\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bI\u0010JR\u0014\u0010M\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b.\u0010LR\u0016\u0010O\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010LR\u0016\u0010Q\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bP\u0010LR\u0016\u0010S\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bR\u0010LR\u0016\u0010U\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bT\u0010LR\u0016\u0010W\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010LR\u0016\u0010Y\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bX\u0010LR\u0016\u0010[\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010LR\u0016\u0010]\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010LR\u0016\u0010_\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b^\u0010LR\u0016\u0010b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010.R\"\u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010fR\u0016\u0010i\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bh\u0010.R\u0016\u0010k\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bj\u0010.R\u0016\u0010m\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bl\u0010a\u00a8\u0006r"}, d2 = {"Lcom/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailSkuInfoFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "getContentLayoutId", "", "getBusinessDescription", "", "Bh", "Eh", "Dh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "onBackPressed", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initUI", "initArguments", "key", "", "", "map", RemoteHandleConst.PARAM_DEFAULT_VALUE, "ki", "oi", "ni", "ri", "qi", "Lcom/tencent/pts/core/lite/IPTSLiteEventListener;", "pi", "Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopDetailSkuInfoViewModel;", "P", "Lkotlin/Lazy;", "mi", "()Lcom/tencent/ecommerce/biz/detail/viewmodel/shop/ECShopDetailSkuInfoViewModel;", "viewModel", "Lkotlinx/coroutines/CoroutineScope;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, WidgetCacheLunarData.JI, "()Lkotlinx/coroutines/CoroutineScope;", "lifecycleScope", BdhLogUtil.LogTag.Tag_Req, "Z", "hasChangedRecyclerViewPadding", "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/component/ECBaseRecyclerView;", "chooseSkuRecyclerView", "Lbh0/b;", "T", "Lbh0/b;", "chooseSkuRecyclerViewAdapter", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "U", "Lcom/tencent/ecommerce/base/ui/ECBasePtsView;", "shopBuyButton", "Landroid/view/ViewGroup;", "V", "Landroid/view/ViewGroup;", "shopBuyButtonContainer", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "W", "Lcom/tencent/ecommerce/base/ui/ECBaseViewController;", "shopBuyButtonController", "Lcom/tencent/ecommerce/base/ktx/ISoftKeyBoardStateListenerRegistry;", "X", "Lcom/tencent/ecommerce/base/ktx/ISoftKeyBoardStateListenerRegistry;", "keyboardListener", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "Y", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "Ljava/lang/String;", "shopBuyButtonPageName", "a0", "adClickId", "b0", "spuId", "c0", "token", "d0", "shopId", "e0", "skuId", "f0", WadlProxyConsts.CHANNEL, "g0", "contentId", "h0", GetAdInfoRequest.SOURCE_FROM, "i0", "activeId", "j0", "I", "activeType", "k0", "hasCouponButton", "l0", "Ljava/util/Map;", "extUserDataMap", "m0", "isFromLive", "n0", "isFloatMode", "o0", "floatMarginTop", "<init>", "()V", "p0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopProductDetailSkuInfoFragment extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy lifecycleScope;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean hasChangedRecyclerViewPadding;

    /* renamed from: S, reason: from kotlin metadata */
    private ECBaseRecyclerView chooseSkuRecyclerView;

    /* renamed from: T, reason: from kotlin metadata */
    private bh0.b chooseSkuRecyclerViewAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private ECBasePtsView shopBuyButton;

    /* renamed from: V, reason: from kotlin metadata */
    private ViewGroup shopBuyButtonContainer;

    /* renamed from: W, reason: from kotlin metadata */
    private ECBaseViewController shopBuyButtonController;

    /* renamed from: X, reason: from kotlin metadata */
    private ISoftKeyBoardStateListenerRegistry keyboardListener;

    /* renamed from: Y, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: Z, reason: from kotlin metadata */
    private final String shopBuyButtonPageName;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private String adClickId;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private String spuId;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private String token;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private String shopId;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private String skuId;

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    private String channel;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    private String contentId;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    private String sourceFrom;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    private String activeId;

    /* renamed from: j0, reason: collision with root package name and from kotlin metadata */
    private int activeType;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private boolean hasCouponButton;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private Map<Object, ? extends Object> extUserDataMap;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private boolean isFromLive;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private boolean isFloatMode;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private int floatMarginTop;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailSkuInfoFragment$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            String str;
            Bundle arguments = ECShopProductDetailSkuInfoFragment.this.getArguments();
            if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
                str = "";
            }
            if (str.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                IECSchemeCallback b16 = a.b(str);
                if (b16 != null) {
                    b16.onCallbackFinished(jSONObject);
                }
                cg0.a.b("ECShopProductDetailSkuInfoFragment", "onPageClose real do callback json=" + jSONObject);
            }
            FragmentActivity activity = ECShopProductDetailSkuInfoFragment.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/detail/fragment/ECShopProductDetailSkuInfoFragment$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"Lorg/json/JSONObject;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lorg/json/JSONObject;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e<T> implements Observer<JSONObject> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(JSONObject jSONObject) {
            JSONObject optJSONObject = jSONObject.optJSONObject("active_info");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            ECShopProductDetailSkuInfoFragment.this.activeId = optJSONObject.optString("active_id", "");
            ECShopProductDetailSkuInfoFragment.this.activeType = optJSONObject.optInt("active_type", 0);
            JSONObject optJSONObject2 = jSONObject.optJSONObject("product");
            if (optJSONObject2 == null) {
                optJSONObject2 = new JSONObject();
            }
            ECShopProductDetailSkuInfoFragment.this.hasCouponButton = optJSONObject2.optBoolean("has_coupon_button", false);
            com.tencent.ecommerce.biz.detail.utils.d.f102466a.b("qstore_prd_detail_pg_sku_select_exp", ECShopProductDetailSkuInfoFragment.this.spuId, ECShopProductDetailSkuInfoFragment.this.contentId, ECShopProductDetailSkuInfoFragment.this.sourceFrom, ECShopProductDetailSkuInfoFragment.this.activeId, ECShopProductDetailSkuInfoFragment.this.activeType, com.tencent.ecommerce.biz.shophome.util.a.f104379a.b(jSONObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f<T> implements Observer<Boolean> {
        f() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            ECShopProductDetailSkuInfoFragment.Th(ECShopProductDetailSkuInfoFragment.this).E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "a", "(Ljava/lang/Boolean;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g<T> implements Observer<Boolean> {

        /* renamed from: d, reason: collision with root package name */
        public static final g f102249d = new g();

        g() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(Boolean bool) {
            if (bool.booleanValue()) {
                i.e(i.f101155b, R.string.wte, null, 0, 6, null);
            }
        }
    }

    public ECShopProductDetailSkuInfoFragment() {
        Lazy lazy;
        Function0<ViewModelProvider.Factory> function0 = new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return new com.tencent.ecommerce.biz.detail.viewmodel.shop.a(ECShopProductDetailSkuInfoFragment.this.getArguments());
            }
        };
        final Function0<Fragment> function02 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECShopDetailSkuInfoViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$$special$$inlined$viewModels$2
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
        }, function0);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<CoroutineScope>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$lifecycleScope$2
            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return CoroutineScopeKt.MainScope();
            }
        });
        this.lifecycleScope = lazy;
        this.shopBuyButtonPageName = "qshop_detail_big_button";
        this.adClickId = "";
        this.spuId = "";
        this.token = "";
        this.shopId = "";
        this.skuId = "";
        this.channel = "0";
        this.contentId = "";
        this.sourceFrom = "";
        this.activeId = "";
        this.extUserDataMap = new LinkedHashMap();
    }

    public static final /* synthetic */ ECBaseRecyclerView Ph(ECShopProductDetailSkuInfoFragment eCShopProductDetailSkuInfoFragment) {
        ECBaseRecyclerView eCBaseRecyclerView = eCShopProductDetailSkuInfoFragment.chooseSkuRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chooseSkuRecyclerView");
        }
        return eCBaseRecyclerView;
    }

    public static final /* synthetic */ bh0.b Qh(ECShopProductDetailSkuInfoFragment eCShopProductDetailSkuInfoFragment) {
        bh0.b bVar = eCShopProductDetailSkuInfoFragment.chooseSkuRecyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chooseSkuRecyclerViewAdapter");
        }
        return bVar;
    }

    public static final /* synthetic */ ECFloatGestureLayout Th(ECShopProductDetailSkuInfoFragment eCShopProductDetailSkuInfoFragment) {
        ECFloatGestureLayout eCFloatGestureLayout = eCShopProductDetailSkuInfoFragment.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        return eCFloatGestureLayout;
    }

    public static final /* synthetic */ ECBaseViewController Xh(ECShopProductDetailSkuInfoFragment eCShopProductDetailSkuInfoFragment) {
        ECBaseViewController eCBaseViewController = eCShopProductDetailSkuInfoFragment.shopBuyButtonController;
        if (eCBaseViewController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBuyButtonController");
        }
        return eCBaseViewController;
    }

    private final void initArguments() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String string;
        Bundle arguments = getArguments();
        String str6 = "";
        if (arguments == null || (str = arguments.getString("qz_gdt", "")) == null) {
            str = "";
        }
        this.adClickId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (str2 = arguments2.getString("shop_id", "")) == null) {
            str2 = "";
        }
        this.shopId = str2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (str3 = arguments3.getString("spu_id", "")) == null) {
            str3 = "";
        }
        this.spuId = str3;
        Bundle arguments4 = getArguments();
        if (arguments4 == null || (str4 = arguments4.getString("sku_id", "")) == null) {
            str4 = "";
        }
        this.skuId = str4;
        Bundle arguments5 = getArguments();
        if (arguments5 == null || (str5 = arguments5.getString(WadlProxyConsts.CHANNEL, "")) == null) {
            str5 = "";
        }
        this.channel = str5;
        Bundle arguments6 = getArguments();
        if (arguments6 != null && (string = arguments6.getString("token", "")) != null) {
            str6 = string;
        }
        this.token = str6;
        Map<Object, ? extends Object> extUserDataMap = com.tencent.ecommerce.base.ktx.a.a(requireArguments(), "ext_userdata").getExtUserDataMap();
        this.extUserDataMap = extUserDataMap;
        this.isFromLive = Intrinsics.areEqual(li(this, "is_from_live", extUserDataMap, null, 4, null), "1");
        this.isFloatMode = Intrinsics.areEqual(li(this, "half", this.extUserDataMap, null, 4, null), "1");
        this.contentId = li(this, "content_id", this.extUserDataMap, null, 4, null);
        this.sourceFrom = li(this, "source_from", this.extUserDataMap, null, 4, null);
        String valueOf = String.valueOf(this.extUserDataMap.get(LayoutAttrDefine.MARGIN_TOP));
        try {
            this.floatMarginTop = Integer.parseInt(valueOf);
        } catch (Exception e16) {
            cg0.a.a("ECShopProductDetailSkuInfoFragment", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "parse floatMarginTop error, floatMarginTopString = " + valueOf + ", error = " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope ji() {
        return (CoroutineScope) this.lifecycleScope.getValue();
    }

    private final String ki(String key, Map<Object, ? extends Object> map, String defaultValue) {
        Intent intent;
        FragmentActivity activity = getActivity();
        String stringExtra = (activity == null || (intent = activity.getIntent()) == null) ? null : intent.getStringExtra(key);
        if (stringExtra != null) {
            return stringExtra;
        }
        if (!map.containsKey(key) || !(map.get(key) instanceof String)) {
            return defaultValue;
        }
        Object obj = map.get(key);
        if (obj != null) {
            return (String) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECShopDetailSkuInfoViewModel mi() {
        return (ECShopDetailSkuInfoViewModel) this.viewModel.getValue();
    }

    private final void ni() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("scroll_to_top", false);
        bundle.putBoolean("disallow_pulling", true);
        if (this.isFromLive && this.isFloatMode) {
            bundle.putInt("scroll_margin_top", this.floatMarginTop);
            bundle.putBoolean("mask_view_trans", true);
            bundle.putBoolean("margin_top_ignore_bottom_bar", false);
        } else {
            bundle.putInt("scroll_margin_top", com.tencent.ecommerce.biz.util.e.c(90.0f));
        }
        ECFloatGestureLayout eCFloatGestureLayout = new ECFloatGestureLayout(requireContext(), bundle);
        this.floatGestureLayout = eCFloatGestureLayout;
        eCFloatGestureLayout.setFloatEventListener(new b());
        ECFloatGestureLayout eCFloatGestureLayout2 = this.floatGestureLayout;
        if (eCFloatGestureLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout2.setContentScrollListener(new c());
        ECFloatGestureLayout eCFloatGestureLayout3 = this.floatGestureLayout;
        if (eCFloatGestureLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout3.C(this, -1, R.id.nxm);
    }

    private final void oi() {
        SoftKeyboardStateHelper softKeyboardStateHelper = new SoftKeyboardStateHelper(requireActivity().findViewById(android.R.id.content), false, 2, null);
        d dVar = new d();
        softKeyboardStateHelper.a(dVar);
        this.keyboardListener = new com.tencent.ecommerce.base.ktx.i(softKeyboardStateHelper, dVar);
    }

    private final IPTSLiteEventListener pi() {
        return new ECShopProductDetailSkuInfoFragment$initShopBuyEventListener$1(this);
    }

    private final void qi() {
        mi().b2().observe(getViewLifecycleOwner(), new e());
        float c16 = com.tencent.ecommerce.biz.util.e.c(90.0f);
        ECDeviceUtils eCDeviceUtils = ECDeviceUtils.f104857e;
        int c17 = com.tencent.ecommerce.biz.util.e.c(c16);
        if (this.floatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        final float i3 = eCDeviceUtils.i(c17 - r2.Q(requireActivity()));
        mi().X1().observe(getViewLifecycleOwner(), new Observer<List<? extends ECBasePtsViewData>>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$registerLivedataObserver$2
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(List<ECBasePtsViewData> list) {
                ECShopProductDetailSkuInfoFragment.Qh(ECShopProductDetailSkuInfoFragment.this).setData(list);
                ECShopProductDetailSkuInfoFragment.Ph(ECShopProductDetailSkuInfoFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$registerLivedataObserver$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        boolean z16;
                        z16 = ECShopProductDetailSkuInfoFragment.this.hasChangedRecyclerViewPadding;
                        if (z16) {
                            return;
                        }
                        ECShopProductDetailSkuInfoFragment.this.hasChangedRecyclerViewPadding = true;
                        ECShopProductDetailSkuInfoFragment.Ph(ECShopProductDetailSkuInfoFragment.this).setPadding(0, 0, 0, e.e(i3) + e.e(60.0f));
                    }
                });
            }
        });
        mi().Z1().observe(getViewLifecycleOwner(), new f());
        mi().g2().observe(getViewLifecycleOwner(), new Observer<Boolean>() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$registerLivedataObserver$4
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(Boolean bool) {
                boolean z16;
                String str;
                JSONObject infoData;
                JSONObject infoData2;
                ECShopProductDetailBuyFloatPageInfo floatSkuInfoData = ECShopProductDetailSkuInfoFragment.this.mi().getFloatSkuInfoData();
                String str2 = null;
                String optString = (floatSkuInfoData == null || (infoData2 = floatSkuInfoData.getInfoData()) == null) ? null : infoData2.optString("float_text", "");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("soldout", bool.booleanValue());
                jSONObject.put("is_activity_soldout", ECShopProductDetailSkuInfoFragment.this.mi().get_isActiveSoldOutStatus());
                z16 = ECShopProductDetailSkuInfoFragment.this.hasCouponButton;
                jSONObject.put("has_coupon_button", z16);
                if (ECShopProductDetailSkuInfoFragment.this.mi().getType() == SkuInfoType.SAMPLE) {
                    jSONObject.put("is_sample", "1");
                }
                ECShopProductDetailBuyFloatPageInfo floatSkuInfoData2 = ECShopProductDetailSkuInfoFragment.this.mi().getFloatSkuInfoData();
                if (floatSkuInfoData2 != null && (infoData = floatSkuInfoData2.getInfoData()) != null) {
                    str2 = infoData.optString("float_text", "");
                }
                jSONObject.put("float_text", str2);
                String jSONObject2 = jSONObject.toString();
                str = ECShopProductDetailSkuInfoFragment.this.shopBuyButtonPageName;
                ECShopProductDetailSkuInfoFragment.Xh(ECShopProductDetailSkuInfoFragment.this).h(ECShopProductDetailSkuInfoFragment.this.requireContext(), new ECBasePtsViewData(null, str, jSONObject2, null, 9, null));
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                ECShopProductDetailSkuInfoFragment.Ph(ECShopProductDetailSkuInfoFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.detail.fragment.ECShopProductDetailSkuInfoFragment$registerLivedataObserver$4.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ECShopProductDetailSkuInfoFragment.Ph(ECShopProductDetailSkuInfoFragment.this).setPadding(0, 0, 0, e.e(i3) + e.e(60.0f) + e.e(40.0f));
                    }
                });
            }
        });
        mi().f2().observe(getViewLifecycleOwner(), g.f102249d);
    }

    private final void ri() {
        mi().i2();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Bh() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return false;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECShopProductDetailSkuInfoFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cre;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
        if (eCFloatGestureLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
        }
        eCFloatGestureLayout.E();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initArguments();
        oi();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CoroutineScopeKt.cancel$default(ji(), null, 1, null);
        mi().destroy();
        ISoftKeyBoardStateListenerRegistry iSoftKeyBoardStateListenerRegistry = this.keyboardListener;
        if (iSoftKeyBoardStateListenerRegistry == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardListener");
        }
        iSoftKeyBoardStateListenerRegistry.unregister();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ni();
        initUI(view);
        ri();
        qi();
    }

    public final void initUI(View rootView) {
        Map<String, ? extends IPTSLiteEventListener> mapOf;
        this.chooseSkuRecyclerView = (ECBaseRecyclerView) rootView.findViewById(R.id.nxn);
        this.shopBuyButton = (ECBasePtsView) rootView.findViewById(R.id.nxl);
        this.shopBuyButtonContainer = (ViewGroup) rootView.findViewById(R.id.nxm);
        Context requireContext = requireContext();
        ECBasePtsView eCBasePtsView = this.shopBuyButton;
        if (eCBasePtsView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shopBuyButton");
        }
        ECBaseViewController eCBaseViewController = new ECBaseViewController(requireContext, eCBasePtsView);
        this.shopBuyButtonController = eCBaseViewController;
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("jumpToOrderPage", pi()));
        eCBaseViewController.i(mapOf);
        this.chooseSkuRecyclerViewAdapter = new bh0.b(requireContext(), mi());
        ECBaseRecyclerView eCBaseRecyclerView = this.chooseSkuRecyclerView;
        if (eCBaseRecyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chooseSkuRecyclerView");
        }
        eCBaseRecyclerView.setItemAnimator(null);
        eCBaseRecyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        bh0.b bVar = this.chooseSkuRecyclerViewAdapter;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("chooseSkuRecyclerViewAdapter");
        }
        eCBaseRecyclerView.setAdapter(bVar);
    }

    static /* synthetic */ String li(ECShopProductDetailSkuInfoFragment eCShopProductDetailSkuInfoFragment, String str, Map map, String str2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str2 = "";
        }
        return eCShopProductDetailSkuInfoFragment.ki(str, map, str2);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/base/ktx/ActivityKt$setOnSoftKeyboardStateListener$listener$1", "Lcom/tencent/ecommerce/base/ui/SoftKeyboardStateHelper$SoftKeyboardStateListener;", "", "keyboardHeightInPx", "", "onSoftKeyboardOpened", "onSoftKeyboardClosed", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements SoftKeyboardStateHelper.SoftKeyboardStateListener {
        public d() {
        }

        @Override // com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardClosed() {
            ECShopProductDetailSkuInfoFragment.this.mi().h2();
        }

        @Override // com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper.SoftKeyboardStateListener
        public void onSoftKeyboardOpened(int keyboardHeightInPx) {
        }
    }
}
