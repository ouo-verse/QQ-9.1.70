package com.tencent.ecommerce.biz.orders.address;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.list.IStateCenterView;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.orders.address.ECAddressListAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\u00020\u00012\u00020\u0002:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u000f\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0012\u0010\u0010\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u0014\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u001a\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001f\u001a\u00020\nH\u0016J\b\u0010 \u001a\u00020\nH\u0016J\b\u0010!\u001a\u00020\nH\u0016R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&R\u0014\u0010+\u001a\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddressManagerFragment;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressSupportFloatLayoutFragment;", "Landroid/view/View$OnClickListener;", "Landroid/view/View;", "view", "", "initView", "initArguments", "Xh", "Yh", "", "networkSuccess", "Zh", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "address", "Th", "ai", "selectedAddress", "Uh", "", "getBusinessDescription", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "Landroid/content/Context;", "context", "onAttach", "v", NodeProps.ON_CLICK, "onBackPressed", "Eh", "Dh", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressManagerViewModel;", "P", "Lkotlin/Lazy;", "Wh", "()Lcom/tencent/ecommerce/biz/orders/address/ECAddressManagerViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter;", "adapter", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Lcom/tencent/ecommerce/base/report/service/k;", "T", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTimeReporter", "<init>", "()V", "U", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressManagerFragment extends ECAddressSupportFloatLayoutFragment implements View.OnClickListener {

    /* renamed from: R, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: S, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: P, reason: from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECAddressManagerViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.address.ECAddressManagerFragment$$special$$inlined$activityViewModels$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.orders.address.ECAddressManagerFragment$$special$$inlined$activityViewModels$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
            ViewModelProvider.Factory defaultViewModelProviderFactory = requireActivity.getDefaultViewModelProviderFactory();
            Intrinsics.checkExpressionValueIsNotNull(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
            return defaultViewModelProviderFactory;
        }
    });

    /* renamed from: Q, reason: from kotlin metadata */
    private final ECAddressListAdapter adapter = new ECAddressListAdapter();

    /* renamed from: T, reason: from kotlin metadata */
    private final k showPageCostTimeReporter = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_ADDRESS_MANAGER);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "it", "", "a", "(Lcom/tencent/ecommerce/biz/orders/address/ECAddress;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c<T> implements Observer<ECAddress> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ECAddress eCAddress) {
            ECAddressManagerFragment.this.Th(eCAddress);
        }
    }

    public static final /* synthetic */ RecyclerView Ph(ECAddressManagerFragment eCAddressManagerFragment) {
        RecyclerView recyclerView = eCAddressManagerFragment.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        return recyclerView;
    }

    public static final /* synthetic */ ECStateCenterView Qh(ECAddressManagerFragment eCAddressManagerFragment) {
        ECStateCenterView eCStateCenterView = eCAddressManagerFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(ECAddress address) {
        String str;
        JSONObject jSONObject;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        IECSchemeCallback b16 = ug0.a.b(str);
        if (b16 != null) {
            JSONObject jSONObject2 = new JSONObject();
            if (address == null || (jSONObject = com.tencent.ecommerce.biz.orders.address.b.d(address)) == null) {
                jSONObject = new JSONObject();
            }
            jSONObject2.put("callbackAddress", jSONObject);
            Unit unit = Unit.INSTANCE;
            b16.onCallbackFinished(jSONObject2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECAddressManagerViewModel Wh() {
        return (ECAddressManagerViewModel) this.viewModel.getValue();
    }

    private final void Xh() {
        Lh(yh().findViewById(R.id.npt), 581.0f, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECAddressManagerFragment$initFloatLayout$1
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
                ECAddressManagerFragment.Vh(ECAddressManagerFragment.this, null, 1, null);
            }
        });
    }

    private final void Yh() {
        Wh().P1();
        Wh().Q1().observe(getViewLifecycleOwner(), new b());
        Wh().S1().observe(getViewLifecycleOwner(), new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Zh(boolean networkSuccess) {
        k.c(this.showPageCostTimeReporter, networkSuccess ? 2 : 3, null, 2, null);
    }

    private final void ai(ECAddress address) {
        JSONObject jSONObject;
        Intent intent = new Intent();
        if (address == null || (jSONObject = com.tencent.ecommerce.biz.orders.address.b.d(address)) == null) {
            jSONObject = new JSONObject();
        }
        intent.putExtra("selectedAddress", jSONObject.toString());
        requireActivity().setResult(-1, intent);
    }

    private final void initArguments() {
        String string;
        Bundle arguments = getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.getString("is_trans_activity") : null, "1")) {
            Xh();
        }
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string = arguments2.getString("addressId")) == null) {
            return;
        }
        Wh().X1(Long.parseLong(string));
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Dh() {
        return !Intrinsics.areEqual(getArguments() != null ? r0.getString("is_trans_activity") : null, "1");
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public boolean Eh() {
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.api.IECBaseFragment
    /* renamed from: getBusinessDescription */
    public String getTAG() {
        return "ECAddressManagerFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.coo;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        super.onAttach(context);
        getEnterTransition();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        int id5 = v3.getId();
        if (id5 == R.id.npf) {
            com.tencent.ecommerce.biz.orders.address.c.e(3, null, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECAddressManagerFragment$onClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                    invoke2(eCAddress);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECAddress eCAddress) {
                    ECAddressManagerViewModel Wh;
                    if (eCAddress != null) {
                        Wh = ECAddressManagerFragment.this.Wh();
                        Wh.O1(eCAddress);
                    }
                }
            });
        } else if (id5 == R.id.ntf) {
            Vh(this, null, 1, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        initArguments();
        Yh();
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        Vh(this, null, 1, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Uh(ECAddress selectedAddress) {
        if (selectedAddress == null) {
            selectedAddress = Wh().S1().getValue();
        }
        ai(selectedAddress);
        requireActivity().finish();
        Bundle arguments = getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.getString("is_trans_activity") : null, "1")) {
            requireActivity().overridePendingTransition(0, 0);
        }
    }

    private final void initView(View view) {
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.nps);
        this.recyclerView = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView.setOverScrollMode(2);
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView2.setAdapter(this.adapter);
        this.adapter.l0(new ECAddressManagerFragment$initView$1(this));
        RecyclerView recyclerView3 = this.recyclerView;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        recyclerView3.setLayoutManager(new LinearLayoutManager(requireContext()));
        ((Button) view.findViewById(R.id.npf)).setOnClickListener(this);
        ((ImageView) view.findViewById(R.id.ntf)).setOnClickListener(this);
        ECStateCenterView eCStateCenterView = (ECStateCenterView) view.findViewById(R.id.oay);
        eCStateCenterView.setRetryListener(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.ECAddressManagerFragment$initView$$inlined$apply$lambda$1
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
                ECAddressManagerViewModel Wh;
                Wh = ECAddressManagerFragment.this.Wh();
                Wh.P1();
            }
        });
        Unit unit = Unit.INSTANCE;
        this.stateView = eCStateCenterView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressListAdapter$a;", "it", "", "a", "(Ljava/util/List;)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b<T> implements Observer<List<? extends ECAddressListAdapter.ECAddressItemData>> {
        b() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(List<ECAddressListAdapter.ECAddressItemData> list) {
            int i3 = 0;
            if (list == null) {
                IStateCenterView.a.b(ECAddressManagerFragment.Qh(ECAddressManagerFragment.this), null, 1, null);
                ECAddressManagerFragment.Qh(ECAddressManagerFragment.this).setVisibility(0);
                ECAddressManagerFragment.Ph(ECAddressManagerFragment.this).setVisibility(8);
                ECAddressManagerFragment.this.Zh(false);
                return;
            }
            if (list.isEmpty()) {
                IStateCenterView.a.a(ECAddressManagerFragment.Qh(ECAddressManagerFragment.this), ECAddressManagerFragment.this.getResources().getString(R.string.wuo), null, 0, 6, null);
                ECAddressManagerFragment.Qh(ECAddressManagerFragment.this).setVisibility(0);
                ECAddressManagerFragment.Ph(ECAddressManagerFragment.this).setVisibility(8);
                ECAddressManagerFragment.this.Zh(true);
                return;
            }
            ECAddressManagerFragment.Qh(ECAddressManagerFragment.this).setVisibility(8);
            ECAddressManagerFragment.Ph(ECAddressManagerFragment.this).setVisibility(0);
            ECAddressManagerFragment.this.adapter.setData(list);
            Iterator<ECAddressListAdapter.ECAddressItemData> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i3 = -1;
                    break;
                } else if (it.next().getIsSelected()) {
                    break;
                } else {
                    i3++;
                }
            }
            ECAddressManagerFragment.Ph(ECAddressManagerFragment.this).scrollToPosition(i3);
            ECAddressManagerFragment.this.Zh(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void Vh(ECAddressManagerFragment eCAddressManagerFragment, ECAddress eCAddress, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            eCAddress = null;
        }
        eCAddressManagerFragment.Uh(eCAddress);
    }
}
