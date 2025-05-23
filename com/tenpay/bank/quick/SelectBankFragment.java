package com.tenpay.bank.quick;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetBankInfoRsp;
import com.tencent.mobileqq.qwallet.pb.BindBank$ProtoFile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.bank.BankConstants;
import com.tenpay.bank.quick.BankItemData;
import com.tenpay.bank.quick.type.BankTypeDialogFragment;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.face.QWalletFaceProxyFragment;
import com.tenpay.sdk.activity.NetBaseActivity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e\u00a8\u0006!"}, d2 = {"Lcom/tenpay/bank/quick/SelectBankFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "()V", "bankItemAdapter", "Lcom/tenpay/bank/quick/BankItemAdapter;", "bankRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "protoList", "Ljava/util/ArrayList;", "Lcom/tenpay/bank/quick/BankItemData$Proto;", "Lkotlin/collections/ArrayList;", "viewModel", "Lcom/tenpay/bank/quick/BindBankQuickViewModel;", "getViewModel", "()Lcom/tenpay/bank/quick/BindBankQuickViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "isStatusBarImmersive", "", "itemClickListener", "", "bankItemData", "Lcom/tenpay/bank/quick/BankItemData;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class SelectBankFragment extends NetBaseActivity {
    private BankItemAdapter bankItemAdapter;
    private RecyclerView bankRecyclerView;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BindBankQuickViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.bank.quick.SelectBankFragment$special$$inlined$activityViewModels$default$1
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelStore invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            ViewModelStore viewModelStore = requireActivity.getViewModelStore();
            Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
            return viewModelStore;
        }
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.bank.quick.SelectBankFragment$special$$inlined$activityViewModels$default$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        @NotNull
        public final ViewModelProvider.Factory invoke() {
            FragmentActivity requireActivity = Fragment.this.requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            return requireActivity.getDefaultViewModelProviderFactory();
        }
    });

    @NotNull
    private final ArrayList<BankItemData.Proto> protoList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void itemClickListener(final BankItemData bankItemData) {
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        BankTypeDialogFragment bankTypeDialogFragment = new BankTypeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("bank_item_data", bankItemData);
        bundle.putParcelableArrayList("bank_proto_list", this.protoList);
        bankTypeDialogFragment.setArguments(bundle);
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        bankTypeDialogFragment.show(supportFragmentManager, BankConstants.QWALLET_BANK_TYPE_FRAGMENT_TAG);
        FragmentKt.setFragmentResultListener(bankTypeDialogFragment, BankTypeDialogFragment.BANK_TYPE_RESULT, new Function2<String, Bundle, Unit>() { // from class: com.tenpay.bank.quick.SelectBankFragment$itemClickListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Bundle bundle2) {
                invoke2(str, bundle2);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:7:0x006c, code lost:
            
                r5 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r5);
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull String requestKey, @NotNull Bundle bundle2) {
                String str;
                BindBankQuickViewModel viewModel;
                BindBankQuickViewModel viewModel2;
                String str2;
                BindBankQuickViewModel viewModel3;
                List<BankItemData.Proto> arrayList;
                BindBankQuickViewModel viewModel4;
                Intrinsics.checkNotNullParameter(requestKey, "requestKey");
                Intrinsics.checkNotNullParameter(bundle2, "bundle");
                str = ((NetBaseActivity) ((NetBaseActivity) SelectBankFragment.this)).TAG;
                QLog.d(str, 1, "onActivityResult: " + requestKey + " " + bundle2);
                BankItemData.CardType cardType = (BankItemData.CardType) bundle2.getParcelable("card_type_data");
                viewModel = SelectBankFragment.this.getViewModel();
                viewModel.setBankId(bankItemData.getBankId());
                viewModel2 = SelectBankFragment.this.getViewModel();
                if (cardType == null || (str2 = cardType.getBankType()) == null) {
                    str2 = "";
                }
                viewModel2.setBankType(str2);
                viewModel3 = SelectBankFragment.this.getViewModel();
                ArrayList parcelableArrayList = bundle2.getParcelableArrayList(BankTypeDialogFragment.KEY_OUT_ALL_PROTO_LIST);
                if (parcelableArrayList == null || arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                viewModel3.setProtoList(arrayList);
                SelectBankFragment.this.showLoading();
                viewModel4 = SelectBankFragment.this.getViewModel();
                final SelectBankFragment selectBankFragment = SelectBankFragment.this;
                viewModel4.requestVerifyFaceKey(new Function3<Boolean, String, String, Unit>() { // from class: com.tenpay.bank.quick.SelectBankFragment$itemClickListener$1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str3, String str4) {
                        invoke(bool.booleanValue(), str3, str4);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull String tokenId, @NotNull String channelInfo) {
                        BindBankQuickViewModel viewModel5;
                        Intrinsics.checkNotNullParameter(tokenId, "tokenId");
                        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
                        SelectBankFragment.this.dismissLoading();
                        if (z16) {
                            FragmentActivity activity2 = SelectBankFragment.this.getActivity();
                            boolean z17 = false;
                            if (activity2 != null && !activity2.isFinishing()) {
                                z17 = true;
                            }
                            if (z17) {
                                QWalletFaceProxyFragment.INSTANCE.start(activity2, new FaceVerifyBean(tokenId, channelInfo, "", "", "", null, 32, null), 101);
                                viewModel5 = SelectBankFragment.this.getViewModel();
                                BindBankQuickViewModel.reportTo644$default(viewModel5, "qqwallet.bk_noinputcard.bankxyfc.click", null, null, null, 14, null);
                            }
                        }
                    }
                });
            }
        });
        BindBankQuickViewModel.reportTo644$default(getViewModel(), "qqwallet.bk_noinputcard.bankxyfc.show", null, null, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.f168975hi4, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = view.findViewById(R.id.t7d);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.bind_bank_recycler_view)");
        this.bankRecyclerView = (RecyclerView) findViewById;
        this.bankItemAdapter = new BankItemAdapter(new SelectBankFragment$onViewCreated$1(this));
        RecyclerView recyclerView = this.bankRecyclerView;
        BankItemAdapter bankItemAdapter = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankRecyclerView");
            recyclerView = null;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        BankItemAdapter bankItemAdapter2 = this.bankItemAdapter;
        if (bankItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bankItemAdapter");
        } else {
            bankItemAdapter = bankItemAdapter2;
        }
        recyclerView.setAdapter(bankItemAdapter);
        MutableLiveData<List<BankItemData>> bankItemLiveData = getViewModel().getBankItemLiveData();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        final Function1<List<? extends BankItemData>, Unit> function1 = new Function1<List<? extends BankItemData>, Unit>() { // from class: com.tenpay.bank.quick.SelectBankFragment$onViewCreated$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends BankItemData> list) {
                invoke2((List<BankItemData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<BankItemData> list) {
                BankItemAdapter bankItemAdapter3;
                bankItemAdapter3 = SelectBankFragment.this.bankItemAdapter;
                if (bankItemAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bankItemAdapter");
                    bankItemAdapter3 = null;
                }
                bankItemAdapter3.submitList(list);
            }
        };
        bankItemLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tenpay.bank.quick.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectBankFragment.onViewCreated$lambda$2(Function1.this, obj);
            }
        });
        MutableLiveData<BindBank$GetBankInfoRsp> bankPanelLiveData = getViewModel().getBankPanelLiveData();
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        final Function1<BindBank$GetBankInfoRsp, Unit> function12 = new Function1<BindBank$GetBankInfoRsp, Unit>() { // from class: com.tenpay.bank.quick.SelectBankFragment$onViewCreated$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BindBank$GetBankInfoRsp bindBank$GetBankInfoRsp) {
                invoke2(bindBank$GetBankInfoRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BindBank$GetBankInfoRsp bindBank$GetBankInfoRsp) {
                ArrayList arrayList;
                ArrayList arrayList2;
                arrayList = SelectBankFragment.this.protoList;
                arrayList.clear();
                List<BindBank$ProtoFile> list = bindBank$GetBankInfoRsp.proto_file.get();
                Intrinsics.checkNotNullExpressionValue(list, "it.proto_file.get()");
                SelectBankFragment selectBankFragment = SelectBankFragment.this;
                for (BindBank$ProtoFile bindBank$ProtoFile : list) {
                    arrayList2 = selectBankFragment.protoList;
                    String str = bindBank$ProtoFile.name.get();
                    Intrinsics.checkNotNullExpressionValue(str, "protoFile.name.get()");
                    String str2 = bindBank$ProtoFile.url.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "protoFile.url.get()");
                    String str3 = bindBank$ProtoFile.version.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "protoFile.version.get()");
                    arrayList2.add(new BankItemData.Proto(str, str2, str3));
                }
            }
        };
        bankPanelLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.tenpay.bank.quick.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SelectBankFragment.onViewCreated$lambda$3(Function1.this, obj);
            }
        });
        BindBankQuickViewModel.reportTo644$default(getViewModel(), "qqwallet.bk_noinputcard.bankaddlist.show", null, null, null, 14, null);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BindBankQuickViewModel getViewModel() {
        return (BindBankQuickViewModel) this.viewModel.getValue();
    }
}
