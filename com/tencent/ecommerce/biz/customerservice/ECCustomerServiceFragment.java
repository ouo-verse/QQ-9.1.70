package com.tencent.ecommerce.biz.customerservice;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;
import yi0.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0003J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u00020\u00178BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010%\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010\"R\u0016\u0010'\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010\"\u00a8\u0006,"}, d2 = {"Lcom/tencent/ecommerce/biz/customerservice/ECCustomerServiceFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "initArguments", "Landroid/view/View;", "view", "initViews", "Sh", "", "getContentLayoutId", "", "getBusinessDescription", "", "Dh", "Eh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onActivityCreated", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "P", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Lcom/tencent/ecommerce/biz/customerservice/ECCustomerServiceViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Rh", "()Lcom/tencent/ecommerce/biz/customerservice/ECCustomerServiceViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;", "scene", ExifInterface.LATITUDE_SOUTH, "Ljava/lang/String;", "shopId", "T", "spuId", "U", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "<init>", "()V", "V", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCustomerServiceFragment extends ECBaseFragment {

    /* renamed from: V, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: Q */
    private final Lazy viewModel;

    /* renamed from: R */
    private CustomerServiceScene scene;

    /* renamed from: S */
    private String shopId;

    /* renamed from: T, reason: from kotlin metadata */
    private String spuId;

    /* renamed from: U, reason: from kotlin metadata */
    private String com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J4\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0006R\u0014\u0010\f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0011\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/customerservice/ECCustomerServiceFragment$a;", "", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/customerservice/CustomerServiceScene;", "scene", "", "shopId", "spuId", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "", "a", "BUNDLE_KEY_ENTRANCE_SCENE", "Ljava/lang/String;", "BUNDLE_KEY_ORDER_ID", "BUNDLE_KEY_SHOP_ID", "BUNDLE_KEY_SPU_ID", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Context context, CustomerServiceScene scene, String shopId, String spuId, String r122) {
            Bundle bundle = new Bundle();
            bundle.putString("scene", String.valueOf(scene.ordinal()));
            bundle.putString("shop_id", shopId);
            bundle.putString("spu_id", spuId);
            bundle.putString("order_id", r122);
            a.q(context, ECCustomerServiceFragment.class, bundle, 0, null, 24, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "kotlin.jvm.PlatformType", "url", "", "a", "(Ljava/lang/String;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<String> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a */
        public final void onChanged(String str) {
            Map map;
            cg0.a.b("ECCustomServiceFragment", "load url in webView: url: " + str);
            Map<String, String> O1 = ECCustomerServiceFragment.this.Rh().O1();
            O1.put("from_customer_service", "1");
            String str2 = "mqqwebview://" + Uri.encode(str);
            map = MapsKt__MapsKt.toMap(O1);
            ECScheme.e(str2, map);
            ECCustomerServiceFragment.this.finish();
        }
    }

    public ECCustomerServiceFragment() {
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment$$special$$inlined$viewModels$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return Fragment.this;
            }
        };
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECCustomerServiceViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment$$special$$inlined$viewModels$2
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
        this.scene = CustomerServiceScene.UNKNOWN;
        this.shopId = "";
        this.spuId = "";
        this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String = "";
    }

    public static final /* synthetic */ ECStateCenterView Ph(ECCustomerServiceFragment eCCustomerServiceFragment) {
        ECStateCenterView eCStateCenterView = eCCustomerServiceFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    public final ECCustomerServiceViewModel Rh() {
        return (ECCustomerServiceViewModel) this.viewModel.getValue();
    }

    private final void Sh() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECCustomerServiceFragment$initObservers$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
        Rh().Q1().observe(getViewLifecycleOwner(), new b());
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toIntOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initArguments() {
        int ordinal;
        Integer intOrNull;
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("scene");
            if (string != null && intOrNull != null) {
                ordinal = intOrNull.intValue();
            } else {
                ordinal = CustomerServiceScene.UNKNOWN.ordinal();
            }
            this.scene = CustomerServiceScene.values()[ordinal];
            String string2 = arguments.getString("shop_id");
            if (string2 == null) {
                string2 = "";
            }
            this.shopId = string2;
            String string3 = arguments.getString("spu_id");
            if (string3 == null) {
                string3 = "";
            }
            this.spuId = string3;
            String string4 = arguments.getString("order_id");
            this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String = string4 != null ? string4 : "";
            cg0.a.b("ECCustomServiceFragment", "enter page from " + this.scene.name());
        }
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
        return "ECCustomServiceFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cqm;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r26) {
        super.onActivityCreated(r26);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.overridePendingTransition(0, 0);
        }
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initArguments();
        initViews(view);
        Sh();
        Rh().R1(this.scene, this.shopId, this.spuId, this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String);
    }

    private final void initViews(View view) {
        ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.f163103ob2);
        this.stateView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.customerservice.ECCustomerServiceFragment$initViews$1
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
                CustomerServiceScene customerServiceScene;
                String str;
                String str2;
                String str3;
                ECCustomerServiceViewModel Rh = ECCustomerServiceFragment.this.Rh();
                customerServiceScene = ECCustomerServiceFragment.this.scene;
                str = ECCustomerServiceFragment.this.shopId;
                str2 = ECCustomerServiceFragment.this.spuId;
                str3 = ECCustomerServiceFragment.this.com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID java.lang.String;
                Rh.R1(customerServiceScene, str, str2, str3);
            }
        });
    }
}
