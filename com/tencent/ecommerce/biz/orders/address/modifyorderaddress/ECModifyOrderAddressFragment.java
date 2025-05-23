package com.tencent.ecommerce.biz.orders.address.modifyorderaddress;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.ecommerce.base.fragment.ECBaseFragment;
import com.tencent.ecommerce.base.list.ListRepository;
import com.tencent.ecommerce.base.list.ListViewModel;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$1;
import com.tencent.ecommerce.base.list.ListViewModelLazyKt$listViewModels$2;
import com.tencent.ecommerce.base.list.d;
import com.tencent.ecommerce.base.list.f;
import com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView;
import com.tencent.ecommerce.base.ui.stateview.ECStateCenterView;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.orders.address.c;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\n*\u00019\u0018\u0000 G2\u00020\u0001:\u0001HB\u0007\u00a2\u0006\u0004\bE\u0010FJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\u000fH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0012\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\u001a\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0014\u0010<\u001a\u0002098\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b:\u0010;R-\u0010D\u001a\u0014\u0012\u0004\u0012\u00020>\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020?0=8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010C\u00a8\u0006I"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/ECModifyOrderAddressFragment;", "Lcom/tencent/ecommerce/base/fragment/ECBaseFragment;", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "initViews", "Vh", "", "isEnable", "Wh", "initArguments", "Uh", "Sh", "", "getContentLayoutId", "", "getBusinessDescription", "Bh", "Dh", "Eh", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "P", "Ljava/lang/String;", "token", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Landroid/widget/TextView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/widget/TextView;", "originAddressOwnerTv", ExifInterface.LATITUDE_SOUTH, "originAddressTv", "T", "submitModificationTv", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "U", "Lcom/tencent/ecommerce/base/ui/stateview/ECStateCenterView;", "stateView", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "V", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView;", "refreshLayout", "Landroidx/recyclerview/widget/RecyclerView;", "W", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/a;", "X", "Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/a;", "adapter", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "Y", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "exclusiveAddress", "com/tencent/ecommerce/biz/orders/address/modifyorderaddress/ECModifyOrderAddressFragment$dataSource$1", "Z", "Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/ECModifyOrderAddressFragment$dataSource$1;", "dataSource", "Lcom/tencent/ecommerce/base/list/ListViewModel;", "Lcom/tencent/ecommerce/base/list/f;", "", "a0", "Lkotlin/Lazy;", "Th", "()Lcom/tencent/ecommerce/base/list/ListViewModel;", "listViewModel", "<init>", "()V", "b0", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECModifyOrderAddressFragment extends ECBaseFragment {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: P, reason: from kotlin metadata */
    private String token = "";

    /* renamed from: Q, reason: from kotlin metadata */
    private String orderId = "";

    /* renamed from: R, reason: from kotlin metadata */
    private TextView originAddressOwnerTv;

    /* renamed from: S, reason: from kotlin metadata */
    private TextView originAddressTv;

    /* renamed from: T, reason: from kotlin metadata */
    private TextView submitModificationTv;

    /* renamed from: U, reason: from kotlin metadata */
    private ECStateCenterView stateView;

    /* renamed from: V, reason: from kotlin metadata */
    private ECommercePullRefreshView refreshLayout;

    /* renamed from: W, reason: from kotlin metadata */
    private RecyclerView recyclerView;

    /* renamed from: X, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: Y, reason: from kotlin metadata */
    private ECAddress exclusiveAddress;

    /* renamed from: Z, reason: from kotlin metadata */
    private final ECModifyOrderAddressFragment$dataSource$1 dataSource;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private final Lazy listViewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u000e\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/modifyorderaddress/ECModifyOrderAddressFragment$a;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "", "token", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "originalAddress", "", "a", "BUNDLE_KEY_ORDER_ID", "Ljava/lang/String;", "BUNDLE_KEY_ORIGINAL_ADDRESS", "BUNDLE_KEY_RESULT_ADDRESS", "BUNDLE_KEY_TOKEN", "TAG", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final void a(Activity activity, int requestCode, String token, String orderId, ECAddress originalAddress) {
            Bundle bundle = new Bundle();
            bundle.putString("bundle_key_token", token);
            bundle.putString("bundle_key_order_id", orderId);
            bundle.putParcelable("bundle_key_original_address", originalAddress);
            yi0.a.q(activity, ECModifyOrderAddressFragment.class, bundle, requestCode, null, 16, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void b(Companion companion, Activity activity, int i3, String str, String str2, ECAddress eCAddress, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                str = "";
            }
            companion.a(activity, i3, str, str2, eCAddress);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECModifyOrderAddressFragment.this.Vh();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public ECModifyOrderAddressFragment() {
        ECModifyOrderAddressFragment$dataSource$1 eCModifyOrderAddressFragment$dataSource$1 = new ECModifyOrderAddressFragment$dataSource$1(this);
        this.dataSource = eCModifyOrderAddressFragment$dataSource$1;
        this.listViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ListViewModel.class), new ListViewModelLazyKt$listViewModels$1(this), new ListViewModelLazyKt$listViewModels$2(new d(new ListRepository(eCModifyOrderAddressFragment$dataSource$1, null, null, 6, null))));
    }

    public static final /* synthetic */ a Lh(ECModifyOrderAddressFragment eCModifyOrderAddressFragment) {
        a aVar = eCModifyOrderAddressFragment.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return aVar;
    }

    public static final /* synthetic */ ECommercePullRefreshView Oh(ECModifyOrderAddressFragment eCModifyOrderAddressFragment) {
        ECommercePullRefreshView eCommercePullRefreshView = eCModifyOrderAddressFragment.refreshLayout;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        return eCommercePullRefreshView;
    }

    public static final /* synthetic */ ECStateCenterView Ph(ECModifyOrderAddressFragment eCModifyOrderAddressFragment) {
        ECStateCenterView eCStateCenterView = eCModifyOrderAddressFragment.stateView;
        if (eCStateCenterView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateView");
        }
        return eCStateCenterView;
    }

    private final void Sh() {
        Th().X1(f.INSTANCE.a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ListViewModel<f, ECAddress, byte[]> Th() {
        return (ListViewModel) this.listViewModel.getValue();
    }

    private final void Uh() {
        a aVar = new a();
        aVar.o0(new Function1<Integer, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment$initRecyclerView$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                ECModifyOrderAddressFragment.this.Wh(true);
            }
        });
        Unit unit = Unit.INSTANCE;
        this.adapter = aVar;
        RecyclerView recyclerView = this.recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        }
        a aVar2 = this.adapter;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(aVar2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        ECAddress l06 = aVar.l0();
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Intent intent = new Intent();
            intent.putExtra("bundle_key_token", this.token);
            intent.putExtra("bundle_key_order_id", this.orderId);
            intent.putExtra("bundle_key_result_address", l06);
            Unit unit = Unit.INSTANCE;
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Wh(boolean isEnable) {
        TextView textView = this.submitModificationTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitModificationTv");
        }
        textView.setClickable(isEnable);
        textView.setEnabled(isEnable);
        textView.setAlpha(isEnable ? 1.0f : 0.5f);
    }

    private final void initArguments() {
        String string;
        String string2;
        ECAddress eCAddress;
        Bundle arguments = getArguments();
        if (arguments == null || (string = arguments.getString("bundle_key_token")) == null) {
            return;
        }
        this.token = string;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || (string2 = arguments2.getString("bundle_key_order_id")) == null) {
            return;
        }
        this.orderId = string2;
        Bundle arguments3 = getArguments();
        if (arguments3 == null || (eCAddress = (ECAddress) arguments3.getParcelable("bundle_key_original_address")) == null) {
            return;
        }
        TextView textView = this.originAddressOwnerTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originAddressOwnerTv");
        }
        textView.setText(getString(R.string.wo6, eCAddress.consignee, eCAddress.phoneNumber));
        TextView textView2 = this.originAddressTv;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originAddressTv");
        }
        textView2.setText(com.tencent.ecommerce.biz.orders.address.b.a(eCAddress));
        this.exclusiveAddress = eCAddress;
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
        return "ECModifyOrderAddressFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.cs9;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setTitle(R.string.f169617wo1);
        initViews(view);
        Uh();
        initArguments();
        Sh();
    }

    private final void initViews(View rootView) {
        this.originAddressOwnerTv = (TextView) rootView.findViewById(R.id.o5u);
        this.originAddressTv = (TextView) rootView.findViewById(R.id.o5w);
        this.stateView = (ECStateCenterView) rootView.findViewById(R.id.oaz);
        ECommercePullRefreshView eCommercePullRefreshView = (ECommercePullRefreshView) rootView.findViewById(R.id.o__);
        this.refreshLayout = eCommercePullRefreshView;
        if (eCommercePullRefreshView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        eCommercePullRefreshView.setEnableRefresh(false);
        ECommercePullRefreshView eCommercePullRefreshView2 = this.refreshLayout;
        if (eCommercePullRefreshView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        eCommercePullRefreshView2.setHideFooterIfNoMore(true);
        ECommercePullRefreshView eCommercePullRefreshView3 = this.refreshLayout;
        if (eCommercePullRefreshView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("refreshLayout");
        }
        eCommercePullRefreshView3.setOnRefreshStateListener(new b());
        RecyclerView recyclerView = (RecyclerView) rootView.findViewById(R.id.o8m);
        recyclerView.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        Unit unit = Unit.INSTANCE;
        this.recyclerView = recyclerView;
        ((TextView) rootView.findViewById(R.id.nph)).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment$initViews$3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                EventCollector.getInstance().onViewClickedBefore(view);
                c.e(4, null, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.modifyorderaddress.ECModifyOrderAddressFragment$initViews$3.1
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
                        cg0.a.b("ECModifyOrderAddressFragment", "add address: " + eCAddress);
                        if (eCAddress != null) {
                            ECModifyOrderAddressFragment.this.Th().X1(f.INSTANCE.a());
                        }
                    }
                });
                EventCollector.getInstance().onViewClicked(view);
            }
        });
        this.submitModificationTv = (TextView) rootView.findViewById(R.id.obk);
        Wh(false);
        TextView textView = this.submitModificationTv;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("submitModificationTv");
        }
        textView.setOnClickListener(new c());
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new ECModifyOrderAddressFragment$initViews$$inlined$launchAndRepeatWithViewLifecycle$1(this, Lifecycle.State.STARTED, null, this), 3, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/orders/address/modifyorderaddress/ECModifyOrderAddressFragment$b", "Lcom/tencent/ecommerce/base/ui/refreshview/ECommercePullRefreshView$OnRefreshStateListener;", "", "tag", "", "onRefreshBegin", "onLoadMoreBegin", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements ECommercePullRefreshView.OnRefreshStateListener {
        b() {
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshBegin(int tag) {
            ECModifyOrderAddressFragment.this.Th().a2(f.INSTANCE.a());
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onRefreshFinished(boolean z16, int i3) {
            ECommercePullRefreshView.OnRefreshStateListener.a.a(this, z16, i3);
        }

        @Override // com.tencent.ecommerce.base.ui.refreshview.ECommercePullRefreshView.OnRefreshStateListener
        public void onLoadMoreBegin() {
        }
    }
}
