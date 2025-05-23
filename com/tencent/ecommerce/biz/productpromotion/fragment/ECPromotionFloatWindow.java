package com.tencent.ecommerce.biz.productpromotion.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECFloatGestureLayout;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.productpromotion.viewmodel.ECPromotionViewModel;
import com.tencent.ecommerce.biz.util.ECDeviceUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import yj0.ECPromoteItem;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/ecommerce/biz/productpromotion/fragment/ECPromotionFloatWindow;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "", "Th", "Sh", "Rh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackPressed", "", "getBusinessDescription", "Eh", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "P", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout;", "floatGestureLayout", "Landroid/widget/LinearLayout;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Landroid/widget/LinearLayout;", "promotionListContainer", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "recycleView", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateCenterView", "Lcom/tencent/ecommerce/biz/productpromotion/fragment/a;", "T", "Lcom/tencent/ecommerce/biz/productpromotion/fragment/a;", "promotionListAdapter", "U", "Ljava/lang/String;", "promotionProductCallbackId", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "V", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "promotionProductCallback", "Lcom/tencent/ecommerce/biz/productpromotion/viewmodel/ECPromotionViewModel;", "W", "Lkotlin/Lazy;", "Qh", "()Lcom/tencent/ecommerce/biz/productpromotion/viewmodel/ECPromotionViewModel;", "viewModel", "<init>", "()V", "X", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECPromotionFloatWindow extends ECBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    private ECFloatGestureLayout floatGestureLayout;

    /* renamed from: Q, reason: from kotlin metadata */
    private LinearLayout promotionListContainer;

    /* renamed from: R, reason: from kotlin metadata */
    private RecyclerView recycleView;

    /* renamed from: S, reason: from kotlin metadata */
    private ECStateCenterView stateCenterView;

    /* renamed from: T, reason: from kotlin metadata */
    private a promotionListAdapter;

    /* renamed from: U, reason: from kotlin metadata */
    private String promotionProductCallbackId = "";

    /* renamed from: V, reason: from kotlin metadata */
    private IECSchemeCallback promotionProductCallback;

    /* renamed from: W, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/ecommerce/biz/productpromotion/fragment/ECPromotionFloatWindow$b", "Lcom/tencent/ecommerce/base/ui/c;", "", "isFromTop", "", "deltaY", "type", "", "onPageClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b extends com.tencent.ecommerce.base.ui.c {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.c, com.tencent.ecommerce.base.ui.ECFloatGestureLayout.FloatEventListener
        public void onPageClose(boolean isFromTop, int deltaY, int type) {
            FragmentActivity activity = ECPromotionFloatWindow.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\u0014\u0010\u0005\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/productpromotion/fragment/ECPromotionFloatWindow$c", "Lcom/tencent/ecommerce/base/ui/ECFloatGestureLayout$ContentScrollListener;", "", "getPositionState", "()I", "positionState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements ECFloatGestureLayout.ContentScrollListener {
        c() {
        }

        @Override // com.tencent.ecommerce.base.ui.ECFloatGestureLayout.ContentScrollListener
        public int getPositionState() {
            return 1;
        }
    }

    public ECPromotionFloatWindow() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ECPromotionViewModel>() { // from class: com.tencent.ecommerce.biz.productpromotion.fragment.ECPromotionFloatWindow$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ECPromotionViewModel invoke() {
                return (ECPromotionViewModel) new ViewModelProvider(ECPromotionFloatWindow.this).get(ECPromotionViewModel.class);
            }
        });
        this.viewModel = lazy;
    }

    public static final /* synthetic */ a Lh(ECPromotionFloatWindow eCPromotionFloatWindow) {
        a aVar = eCPromotionFloatWindow.promotionListAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promotionListAdapter");
        }
        return aVar;
    }

    public static final /* synthetic */ LinearLayout Mh(ECPromotionFloatWindow eCPromotionFloatWindow) {
        LinearLayout linearLayout = eCPromotionFloatWindow.promotionListContainer;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promotionListContainer");
        }
        return linearLayout;
    }

    public static final /* synthetic */ ECStateCenterView Oh(ECPromotionFloatWindow eCPromotionFloatWindow) {
        ECStateCenterView eCStateCenterView = eCPromotionFloatWindow.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        return eCStateCenterView;
    }

    private final ECPromotionViewModel Qh() {
        return (ECPromotionViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Rh() {
        Bundle bundle = new Bundle();
        int i3 = 0;
        bundle.putBoolean("scroll_to_top", false);
        bundle.putInt("container_color", ECSkin.INSTANCE.getColor(R.color.f6491p));
        if (Qh().O1().getValue() != null) {
            ArrayList<ECPromoteItem> value = Qh().O1().getValue();
            Intrinsics.checkNotNull(value);
            i3 = value.size();
        }
        bundle.putInt("scroll_margin_top", (int) (ECDeviceUtils.f104857e.i(r1.d()) - ((i3 * 56) + 91)));
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
        eCFloatGestureLayout3.C(this, -1, -1);
    }

    private final void Sh() {
        Qh().O1().observe(getViewLifecycleOwner(), new ECPromotionFloatWindow$initObserve$1(this));
    }

    private final void Th() {
        yh().setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.f7153h));
        LinearLayout linearLayout = (LinearLayout) yh().findViewById(R.id.o7t);
        this.promotionListContainer = linearLayout;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promotionListContainer");
        }
        linearLayout.setBackgroundColor(ECSkin.INSTANCE.getColor(R.color.f6491p));
        ECStateCenterView eCStateCenterView = (ECStateCenterView) yh().findViewById(R.id.o7v);
        this.stateCenterView = eCStateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        IStateCenterView.a.c(eCStateCenterView, null, 1, null);
        this.promotionListAdapter = new a(requireContext(), requireActivity(), this.promotionProductCallback);
        RecyclerView recyclerView = (RecyclerView) yh().findViewById(R.id.o7u);
        this.recycleView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recycleView");
        }
        a aVar = this.promotionListAdapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("promotionListAdapter");
        }
        recyclerView.setAdapter(aVar);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECSourceListFloatWindow";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.ctc;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        ECFloatGestureLayout eCFloatGestureLayout = this.floatGestureLayout;
        if (eCFloatGestureLayout != null) {
            if (eCFloatGestureLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("floatGestureLayout");
            }
            eCFloatGestureLayout.E();
            return true;
        }
        ECStateCenterView eCStateCenterView = this.stateCenterView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateCenterView");
        }
        eCStateCenterView.setVisibility(8);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            return true;
        }
        activity.finish();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        String str;
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity == null || (intent = activity.getIntent()) == null || (str = intent.getStringExtra("scheme_callback_id")) == null) {
            str = "";
        }
        this.promotionProductCallbackId = str;
        this.promotionProductCallback = ug0.a.b(str);
        cg0.a.b("ECSourceListFloatWindow", "[onCreate] init arguments, product promotion callbackId = " + this.promotionProductCallbackId);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Th();
        Sh();
        Qh().N1(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
    }
}
