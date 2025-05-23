package com.tencent.ecommerce.biz.orders.address.picker;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.d;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ecommerce.base.report.service.ECShowPageCostTimeScene;
import com.tencent.ecommerce.base.report.service.k;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.orders.address.ECAddressSupportFloatLayoutFragment;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictAddressInfo;
import com.tencent.ecommerce.biz.orders.address.picker.model.DistrictType;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerInitIntent;
import com.tencent.ecommerce.biz.orders.address.picker.model.ECAddressPickerState;
import com.tencent.ecommerce.biz.orders.address.picker.model.b;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u0002:;B\u0007\u00a2\u0006\u0004\b8\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0016\u0010\f\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0015H\u0016R\u001a\u0010\u001d\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\f\n\u0004\b\u0019\u0010\u001a\u0012\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0014\u00107\u001a\u0002048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerFragment;", "Lcom/tencent/ecommerce/biz/orders/address/ECAddressSupportFloatLayoutFragment;", "Landroid/view/View;", "view", "", "initView", "Wh", "initArguments", "Vh", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/a;", "list", "Th", "finishActivity", "", "getContentLayoutId", "", "getBusinessDescription", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "Eh", "Dh", "onBackPressed", "P", "I", "getOffscreenPageLimit$annotations", "()V", "offscreenPageLimit", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerViewModel;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Lkotlin/Lazy;", "Uh", "()Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerViewModel;", "viewModel", "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerFragment$a;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerFragment$a;", "adapter", "Lcom/google/android/material/tabs/d;", ExifInterface.LATITUDE_SOUTH, "Lcom/google/android/material/tabs/d;", "tabLayoutMediator", "Landroidx/viewpager2/widget/ViewPager2;", "T", "Landroidx/viewpager2/widget/ViewPager2;", "viewPager", "Lcom/google/android/material/tabs/TabLayout;", "U", "Lcom/google/android/material/tabs/TabLayout;", "tabLayout", "Lcom/tencent/ecommerce/base/report/service/k;", "V", "Lcom/tencent/ecommerce/base/report/service/k;", "showPageCostTimeReporter", "<init>", "W", "a", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECAddressPickerFragment extends ECAddressSupportFloatLayoutFragment {

    /* renamed from: R, reason: from kotlin metadata */
    private a adapter;

    /* renamed from: S, reason: from kotlin metadata */
    private com.google.android.material.tabs.d tabLayoutMediator;

    /* renamed from: T, reason: from kotlin metadata */
    private ViewPager2 viewPager;

    /* renamed from: U, reason: from kotlin metadata */
    private TabLayout tabLayout;

    /* renamed from: P, reason: from kotlin metadata */
    private final int offscreenPageLimit = 4;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ECAddressPickerViewModel.class), new Function0<ViewModelStore>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerFragment$$special$$inlined$activityViewModels$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkExpressionValueIsNotNull(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
            Intrinsics.checkExpressionValueIsNotNull(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerFragment$$special$$inlined$activityViewModels$2
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

    /* renamed from: V, reason: from kotlin metadata */
    private final k showPageCostTimeReporter = new k(ECShowPageCostTimeScene.SHOW_COST_TIME_SCENE_ADDRESS_PICKER);

    /* JADX INFO: Access modifiers changed from: private */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0002R\u001a\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerFragment$a;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "", "getItemCount", "position", "Landroidx/fragment/app/Fragment;", "createFragment", WidgetCacheConstellationData.NUM, "", "i0", "", "Lcom/tencent/ecommerce/biz/orders/address/picker/model/DistrictType;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "addressInfoList", "fragment", "<init>", "(Landroidx/fragment/app/Fragment;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a extends FragmentStateAdapter {

        /* renamed from: m, reason: collision with root package name and from kotlin metadata */
        private final List<DistrictType> addressInfoList;

        public a(Fragment fragment) {
            super(fragment);
            this.addressInfoList = new ArrayList();
        }

        @Override // androidx.viewpager2.adapter.FragmentStateAdapter
        public Fragment createFragment(int position) {
            return new ECAddressItemFragment(this.addressInfoList.get(position));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.addressInfoList.size();
        }

        public final void i0(int num) {
            this.addressInfoList.clear();
            DistrictType districtType = DistrictType.Nation;
            for (int i3 = 0; i3 < num; i3++) {
                this.addressInfoList.add(districtType);
                districtType = b.a(districtType);
            }
            notifyDataSetChanged();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "position", "", "a", "(Lcom/google/android/material/tabs/TabLayout$g;I)V"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements d.b {
        d() {
        }

        @Override // com.google.android.material.tabs.d.b
        public final void a(TabLayout.g gVar, int i3) {
            List<String> emptyList;
            String string;
            gVar.f34288i.setBackground(null);
            ECTabItemView eCTabItemView = new ECTabItemView(gVar.f34288i.getContext());
            ECAddressPickerState value = ECAddressPickerFragment.this.Uh().P1().getValue();
            if (value == null || (emptyList = value.b()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
            }
            if (emptyList.size() > i3) {
                string = emptyList.get(i3);
            } else {
                string = ECAddressPickerFragment.this.getString(R.string.wse);
            }
            eCTabItemView.setTitle(string);
            Unit unit = Unit.INSTANCE;
            gVar.p(eCTabItemView);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements View.OnClickListener {
        e() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ECAddressPickerState value = ECAddressPickerFragment.this.Uh().P1().getValue();
            List<DistrictAddressInfo> c16 = value != null ? value.c() : null;
            if (c16 != null && c16.size() > 1) {
                ECAddressPickerFragment.this.Th(c16);
            }
            ECAddressPickerFragment.this.finishActivity();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static final /* synthetic */ a Oh(ECAddressPickerFragment eCAddressPickerFragment) {
        a aVar = eCAddressPickerFragment.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        return aVar;
    }

    public static final /* synthetic */ TabLayout Qh(ECAddressPickerFragment eCAddressPickerFragment) {
        TabLayout tabLayout = eCAddressPickerFragment.tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        return tabLayout;
    }

    public static final /* synthetic */ ViewPager2 Sh(ECAddressPickerFragment eCAddressPickerFragment) {
        ViewPager2 viewPager2 = eCAddressPickerFragment.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        return viewPager2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Th(List<DistrictAddressInfo> list) {
        String str;
        Bundle arguments = getArguments();
        if (arguments == null || (str = arguments.getString("scheme_callback_id")) == null) {
            str = "";
        }
        IECSchemeCallback b16 = ug0.a.b(str);
        JSONObject jSONObject = new JSONObject();
        for (DistrictAddressInfo districtAddressInfo : list) {
            jSONObject.put(districtAddressInfo.type.name(), districtAddressInfo.name);
        }
        if (b16 != null) {
            b16.onCallbackFinished(jSONObject);
        }
        finishActivity();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ECAddressPickerViewModel Uh() {
        return (ECAddressPickerViewModel) this.viewModel.getValue();
    }

    private final void Vh() {
        Lh(yh().findViewById(R.id.npk), 598.0f, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerFragment$initFloatLayout$1
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
                ECAddressPickerFragment.this.finishActivity();
            }
        });
    }

    private final void Wh() {
        Uh().P1().observe(getViewLifecycleOwner(), new Observer<ECAddressPickerState>() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerFragment$initObserver$1
            @Override // androidx.lifecycle.Observer
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public final void onChanged(final ECAddressPickerState eCAddressPickerState) {
                k kVar;
                if (eCAddressPickerState.getIsFinishSelected()) {
                    ECAddressPickerFragment.this.Th(eCAddressPickerState.c());
                    return;
                }
                ECAddressPickerFragment.Qh(ECAddressPickerFragment.this).setVisibility(eCAddressPickerState.c().isEmpty() ^ true ? 0 : 8);
                ECAddressPickerFragment.Sh(ECAddressPickerFragment.this).post(new Runnable() { // from class: com.tencent.ecommerce.biz.orders.address.picker.ECAddressPickerFragment$initObserver$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        ECAddressPickerFragment.Oh(ECAddressPickerFragment.this).i0(eCAddressPickerState.a().size());
                        ECAddressPickerFragment.Sh(ECAddressPickerFragment.this).setCurrentItem(eCAddressPickerState.a().size() - 1);
                    }
                });
                kVar = ECAddressPickerFragment.this.showPageCostTimeReporter;
                k.c(kVar, eCAddressPickerState.a().isEmpty() ? 3 : 2, null, 2, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void finishActivity() {
        requireActivity().finish();
        Bundle arguments = getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.getString("is_trans_activity") : null, "1")) {
            requireActivity().overridePendingTransition(0, 0);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00bd, code lost:
    
        if (r2 != false) goto L55;
     */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void initArguments() {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean isBlank;
        boolean isBlank2;
        boolean isBlank3;
        boolean isBlank4;
        Bundle arguments = getArguments();
        if (Intrinsics.areEqual(arguments != null ? arguments.getString("is_trans_activity") : null, "1")) {
            Vh();
        }
        ArrayList arrayList = new ArrayList();
        Bundle arguments2 = getArguments();
        String string = arguments2 != null ? arguments2.getString("Province") : null;
        boolean z19 = false;
        if (string != null) {
            isBlank4 = StringsKt__StringsJVMKt.isBlank(string);
            if (!isBlank4) {
                z16 = false;
                if (!z16) {
                    Uh().O1(new ECAddressPickerInitIntent(arrayList));
                    return;
                }
                arrayList.add(string);
                Bundle arguments3 = getArguments();
                String string2 = arguments3 != null ? arguments3.getString("City") : null;
                if (string2 != null) {
                    isBlank3 = StringsKt__StringsJVMKt.isBlank(string2);
                    if (!isBlank3) {
                        z17 = false;
                        if (!z17) {
                            Uh().O1(new ECAddressPickerInitIntent(arrayList));
                            return;
                        }
                        arrayList.add(string2);
                        Bundle arguments4 = getArguments();
                        String string3 = arguments4 != null ? arguments4.getString("District") : null;
                        if (string3 != null) {
                            isBlank2 = StringsKt__StringsJVMKt.isBlank(string3);
                            if (!isBlank2) {
                                z18 = false;
                                if (!z18) {
                                    Uh().O1(new ECAddressPickerInitIntent(arrayList));
                                    return;
                                }
                                arrayList.add(string3);
                                Bundle arguments5 = getArguments();
                                String string4 = arguments5 != null ? arguments5.getString("Street") : null;
                                if (string4 != null) {
                                    isBlank = StringsKt__StringsJVMKt.isBlank(string4);
                                }
                                z19 = true;
                                if (!z19) {
                                    arrayList.add(string4);
                                }
                                Uh().O1(new ECAddressPickerInitIntent(arrayList));
                                return;
                            }
                        }
                        z18 = true;
                        if (!z18) {
                        }
                    }
                }
                z17 = true;
                if (!z17) {
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
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
        return "ECAddressPickerFragment";
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment
    public int getContentLayoutId() {
        return R.layout.coq;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, com.tencent.ecommerce.base.ui.api.IECFragmentApi
    public boolean onBackPressed() {
        finishActivity();
        return true;
    }

    @Override // com.tencent.ecommerce.base.fragment.ECBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView(view);
        Wh();
        initArguments();
    }

    private final void initView(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.ntg);
        this.viewPager = (ViewPager2) view.findViewById(R.id.f163076o60);
        TabLayout tabLayout = (TabLayout) view.findViewById(R.id.obw);
        this.tabLayout = tabLayout;
        if (tabLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        tabLayout.f(new c());
        this.adapter = new a(this);
        ViewPager2 viewPager2 = this.viewPager;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        a aVar = this.adapter;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        viewPager2.setAdapter(aVar);
        ViewPager2 viewPager22 = this.viewPager;
        if (viewPager22 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager22.setOffscreenPageLimit(this.offscreenPageLimit);
        ViewPager2 viewPager23 = this.viewPager;
        if (viewPager23 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager23.setUserInputEnabled(false);
        TabLayout tabLayout2 = this.tabLayout;
        if (tabLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tabLayout");
        }
        ViewPager2 viewPager24 = this.viewPager;
        if (viewPager24 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        com.google.android.material.tabs.d dVar = new com.google.android.material.tabs.d(tabLayout2, viewPager24, true, false, new d());
        dVar.a();
        Unit unit = Unit.INSTANCE;
        this.tabLayoutMediator = dVar;
        imageView.setOnClickListener(new e());
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/ecommerce/biz/orders/address/picker/ECAddressPickerFragment$c", "Lcom/google/android/material/tabs/TabLayout$d;", "Lcom/google/android/material/tabs/TabLayout$g;", "tab", "", "onTabSelected", "onTabUnselected", "onTabReselected", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements TabLayout.d {
        c() {
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabSelected(TabLayout.g tab) {
            View e16 = tab.e();
            if (!(e16 instanceof ECTabItemView)) {
                e16 = null;
            }
            ECTabItemView eCTabItemView = (ECTabItemView) e16;
            if (eCTabItemView != null) {
                eCTabItemView.setSelected();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabUnselected(TabLayout.g tab) {
            View e16 = tab.e();
            if (!(e16 instanceof ECTabItemView)) {
                e16 = null;
            }
            ECTabItemView eCTabItemView = (ECTabItemView) e16;
            if (eCTabItemView != null) {
                eCTabItemView.a();
            }
        }

        @Override // com.google.android.material.tabs.TabLayout.c
        public void onTabReselected(TabLayout.g tab) {
        }
    }
}
