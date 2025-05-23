package com.tenpay.bank.quick;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.base.FragmentAnimation;
import com.tencent.mobileqq.base.QWalletBaseFragment;
import com.tencent.mobileqq.qwallet.pb.BindBank$GetBankInfoRsp;
import com.tencent.mobileqq.qwallet.pb.BindBank$ProtoFile;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.bank.BankConstants;
import com.tenpay.bank.quick.BankItemData;
import com.tenpay.bank.quick.type.BankTypeDialogFragment;
import com.tenpay.face.FaceVerifyBean;
import com.tenpay.face.QWalletFaceProxyFragment;
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
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J \u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\fH\u0002J\u0010\u0010$\u001a\u00020 2\u0006\u0010%\u001a\u00020&H\u0002J\u0006\u0010'\u001a\u00020 J\u0006\u0010(\u001a\u00020 J\u0014\u0010)\u001a\u00020 2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020 0+R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001c\u00a8\u0006-"}, d2 = {"Lcom/tenpay/bank/quick/BindBankQuickVC;", "", "fragment", "Lcom/tencent/mobileqq/base/QWalletBaseFragment;", "contentView", "Landroid/view/View;", "(Lcom/tencent/mobileqq/base/QWalletBaseFragment;Landroid/view/View;)V", "bankItemAdapter", "Lcom/tenpay/bank/quick/BankItemAdapter;", "bankRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "currentHeight", "", "itemListLayout", "Landroid/widget/LinearLayout;", "protoList", "Ljava/util/ArrayList;", "Lcom/tenpay/bank/quick/BankItemData$Proto;", "Lkotlin/collections/ArrayList;", "selectAllBtn", "Landroid/widget/TextView;", "subTitleText", "titleBtn", "titleLayout", "titleText", "viewModel", "Lcom/tenpay/bank/quick/BindBankQuickViewModel;", "getViewModel", "()Lcom/tenpay/bank/quick/BindBankQuickViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "animateHeightChange", "", "view", "startHeight", "targetHeight", "itemClickListener", "bankItemData", "Lcom/tenpay/bank/quick/BankItemData;", "setQuickLayoutHide", "setQuickLayoutShow", "setTitleOnClickListener", "onClickListener", "Lkotlin/Function0;", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BindBankQuickVC {

    @NotNull
    private static final String TAG = "BindBankIQuickVC";

    @NotNull
    private final BankItemAdapter bankItemAdapter;

    @NotNull
    private final RecyclerView bankRecyclerView;
    private int currentHeight;

    @NotNull
    private final QWalletBaseFragment fragment;

    @NotNull
    private final LinearLayout itemListLayout;

    @NotNull
    private final ArrayList<BankItemData.Proto> protoList;

    @NotNull
    private final TextView selectAllBtn;

    @NotNull
    private final TextView subTitleText;

    @NotNull
    private final View titleBtn;

    @NotNull
    private final View titleLayout;

    @NotNull
    private final TextView titleText;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public BindBankQuickVC(@NotNull final QWalletBaseFragment fragment, @NotNull View contentView) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.fragment = fragment;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(BindBankQuickViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.bank.quick.BindBankQuickVC$special$$inlined$activityViewModels$default$1
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.bank.quick.BindBankQuickVC$special$$inlined$activityViewModels$default$2
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
        View findViewById = contentView.findViewById(R.id.t7k);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026d.bind_bank_title_layout)");
        this.titleLayout = findViewById;
        View findViewById2 = contentView.findViewById(R.id.t7j);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.bind_bank_title_btn)");
        this.titleBtn = findViewById2;
        View findViewById3 = contentView.findViewById(R.id.t7l);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById\u2026.id.bind_bank_title_text)");
        this.titleText = (TextView) findViewById3;
        View findViewById4 = contentView.findViewById(R.id.t7f);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById\u2026bind_bank_sub_title_text)");
        this.subTitleText = (TextView) findViewById4;
        View findViewById5 = contentView.findViewById(R.id.t79);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById\u2026nd_bank_item_list_layout)");
        this.itemListLayout = (LinearLayout) findViewById5;
        View findViewById6 = contentView.findViewById(R.id.t7d);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById\u2026.bind_bank_recycler_view)");
        RecyclerView recyclerView = (RecyclerView) findViewById6;
        this.bankRecyclerView = recyclerView;
        View findViewById7 = contentView.findViewById(R.id.t7e);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById\u2026.id.bind_bank_select_all)");
        TextView textView = (TextView) findViewById7;
        this.selectAllBtn = textView;
        BankItemAdapter bankItemAdapter = new BankItemAdapter(new BindBankQuickVC$bankItemAdapter$1(this));
        this.bankItemAdapter = bankItemAdapter;
        this.protoList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragment.getContext());
        linearLayoutManager.setOrientation(1);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(bankItemAdapter);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.quick.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindBankQuickVC._init_$lambda$2(BindBankQuickVC.this, view);
            }
        });
        MutableLiveData<List<BankItemData>> bankItemLiveData = getViewModel().getBankItemLiveData();
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        final Function1<List<? extends BankItemData>, Unit> function1 = new Function1<List<? extends BankItemData>, Unit>() { // from class: com.tenpay.bank.quick.BindBankQuickVC.3
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
                BindBankQuickVC.this.bankItemAdapter.submitList(list);
                BindBankQuickVC.this.selectAllBtn.setText("\u5168\u90e8" + list.size() + "\u5bb6\u94f6\u884c >");
            }
        };
        bankItemLiveData.observe(viewLifecycleOwner, new Observer() { // from class: com.tenpay.bank.quick.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BindBankQuickVC._init_$lambda$3(Function1.this, obj);
            }
        });
        MutableLiveData<BindBank$GetBankInfoRsp> bankPanelLiveData = getViewModel().getBankPanelLiveData();
        LifecycleOwner viewLifecycleOwner2 = fragment.getViewLifecycleOwner();
        final Function1<BindBank$GetBankInfoRsp, Unit> function12 = new Function1<BindBank$GetBankInfoRsp, Unit>() { // from class: com.tenpay.bank.quick.BindBankQuickVC.4
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
                BindBankQuickVC.this.titleText.setText(bindBank$GetBankInfoRsp.title.get());
                BindBankQuickVC.this.subTitleText.setText(bindBank$GetBankInfoRsp.sub_title.get());
                BindBankQuickVC.this.protoList.clear();
                List<BindBank$ProtoFile> list = bindBank$GetBankInfoRsp.proto_file.get();
                Intrinsics.checkNotNullExpressionValue(list, "it.proto_file.get()");
                BindBankQuickVC bindBankQuickVC = BindBankQuickVC.this;
                for (BindBank$ProtoFile bindBank$ProtoFile : list) {
                    ArrayList arrayList = bindBankQuickVC.protoList;
                    String str = bindBank$ProtoFile.name.get();
                    Intrinsics.checkNotNullExpressionValue(str, "protoFile.name.get()");
                    String str2 = bindBank$ProtoFile.url.get();
                    Intrinsics.checkNotNullExpressionValue(str2, "protoFile.url.get()");
                    String str3 = bindBank$ProtoFile.version.get();
                    Intrinsics.checkNotNullExpressionValue(str3, "protoFile.version.get()");
                    arrayList.add(new BankItemData.Proto(str, str2, str3));
                }
                int i3 = bindBank$GetBankInfoRsp.min_bank_count.get();
                int size = bindBank$GetBankInfoRsp.bank.get().size();
                if (size == 0) {
                    BindBankQuickVC.this.titleLayout.setVisibility(8);
                    BindBankQuickVC.this.itemListLayout.setVisibility(8);
                    return;
                }
                BindBankQuickVC.this.titleLayout.setVisibility(0);
                BindBankQuickVC.this.itemListLayout.setVisibility(0);
                BindBankQuickVC.this.bankItemAdapter.setMaxItemSize(i3);
                if (i3 >= size) {
                    BindBankQuickVC.this.selectAllBtn.setVisibility(8);
                } else {
                    BindBankQuickVC.this.selectAllBtn.setVisibility(0);
                }
            }
        };
        bankPanelLiveData.observe(viewLifecycleOwner2, new Observer() { // from class: com.tenpay.bank.quick.e
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BindBankQuickVC._init_$lambda$4(Function1.this, obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(BindBankQuickVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.qwallet.utils.a.a(this$0.fragment, R.id.cks, new SelectBankFragment(), BankConstants.SELECT_BANK_FRAGMENT_TAG, FragmentAnimation.DEFAULT);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$3(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$4(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void animateHeightChange(final View view, int startHeight, int targetHeight) {
        ValueAnimator ofInt = ValueAnimator.ofInt(startHeight, targetHeight);
        QLog.d(TAG, 1, "start = " + startHeight + " target = " + targetHeight);
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.tenpay.bank.quick.f
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BindBankQuickVC.animateHeightChange$lambda$6(view, valueAnimator);
            }
        });
        ofInt.setDuration(250L);
        ofInt.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void animateHeightChange$lambda$6(View view, ValueAnimator valueAnimator) {
        Intrinsics.checkNotNullParameter(view, "$view");
        QLog.d(TAG, 1, "addUpdateListener value = " + valueAnimator.getAnimatedValue());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Object animatedValue = valueAnimator.getAnimatedValue();
        Intrinsics.checkNotNull(animatedValue, "null cannot be cast to non-null type kotlin.Int");
        layoutParams.height = ((Integer) animatedValue).intValue();
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BindBankQuickViewModel getViewModel() {
        return (BindBankQuickViewModel) this.viewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void itemClickListener(final BankItemData bankItemData) {
        FragmentActivity activity = this.fragment.getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        BankTypeDialogFragment bankTypeDialogFragment = new BankTypeDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("bank_item_data", bankItemData);
        bundle.putParcelableArrayList("bank_proto_list", this.protoList);
        bankTypeDialogFragment.setArguments(bundle);
        FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        bankTypeDialogFragment.show(supportFragmentManager, "qwallet_bank_type_dialog_fragment");
        FragmentKt.setFragmentResultListener(bankTypeDialogFragment, BankTypeDialogFragment.BANK_TYPE_RESULT, new Function2<String, Bundle, Unit>() { // from class: com.tenpay.bank.quick.BindBankQuickVC$itemClickListener$1
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

            /* JADX WARN: Code restructure failed: missing block: B:7:0x0069, code lost:
            
                r4 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList((java.util.Collection) r4);
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(@NotNull String requestKey, @NotNull Bundle bundle2) {
                BindBankQuickViewModel viewModel;
                BindBankQuickViewModel viewModel2;
                String str;
                BindBankQuickViewModel viewModel3;
                List<BankItemData.Proto> arrayList;
                QWalletBaseFragment qWalletBaseFragment;
                BindBankQuickViewModel viewModel4;
                Intrinsics.checkNotNullParameter(requestKey, "requestKey");
                Intrinsics.checkNotNullParameter(bundle2, "bundle");
                QLog.d("BindBankIQuickVC", 1, "onActivityResult: " + requestKey + " " + bundle2);
                BankItemData.CardType cardType = (BankItemData.CardType) bundle2.getParcelable("card_type_data");
                viewModel = BindBankQuickVC.this.getViewModel();
                viewModel.setBankId(bankItemData.getBankId());
                viewModel2 = BindBankQuickVC.this.getViewModel();
                if (cardType == null || (str = cardType.getBankType()) == null) {
                    str = "";
                }
                viewModel2.setBankType(str);
                viewModel3 = BindBankQuickVC.this.getViewModel();
                ArrayList parcelableArrayList = bundle2.getParcelableArrayList(BankTypeDialogFragment.KEY_OUT_ALL_PROTO_LIST);
                if (parcelableArrayList == null || arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                viewModel3.setProtoList(arrayList);
                qWalletBaseFragment = BindBankQuickVC.this.fragment;
                qWalletBaseFragment.showLoading();
                viewModel4 = BindBankQuickVC.this.getViewModel();
                final BindBankQuickVC bindBankQuickVC = BindBankQuickVC.this;
                viewModel4.requestVerifyFaceKey(new Function3<Boolean, String, String, Unit>() { // from class: com.tenpay.bank.quick.BindBankQuickVC$itemClickListener$1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, String str2, String str3) {
                        invoke(bool.booleanValue(), str2, str3);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16, @NotNull String tokenId, @NotNull String channelInfo) {
                        QWalletBaseFragment qWalletBaseFragment2;
                        QWalletBaseFragment qWalletBaseFragment3;
                        BindBankQuickViewModel viewModel5;
                        Intrinsics.checkNotNullParameter(tokenId, "tokenId");
                        Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
                        qWalletBaseFragment2 = BindBankQuickVC.this.fragment;
                        qWalletBaseFragment2.dismissLoading();
                        if (z16) {
                            qWalletBaseFragment3 = BindBankQuickVC.this.fragment;
                            FragmentActivity activity2 = qWalletBaseFragment3.getActivity();
                            boolean z17 = false;
                            if (activity2 != null && !activity2.isFinishing()) {
                                z17 = true;
                            }
                            if (z17) {
                                QWalletFaceProxyFragment.INSTANCE.start(activity2, new FaceVerifyBean(tokenId, channelInfo, "", "", "", null, 32, null), 101);
                                viewModel5 = BindBankQuickVC.this.getViewModel();
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
    public static final void setTitleOnClickListener$lambda$5(Function0 onClickListener, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        onClickListener.invoke();
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void setQuickLayoutHide() {
        this.titleBtn.setVisibility(0);
        this.currentHeight = this.itemListLayout.getMeasuredHeight();
        this.itemListLayout.setVisibility(4);
        animateHeightChange(this.itemListLayout, this.currentHeight, 0);
    }

    public final void setQuickLayoutShow() {
        this.titleBtn.setVisibility(4);
        this.itemListLayout.setVisibility(0);
        animateHeightChange(this.itemListLayout, 0, this.currentHeight);
    }

    public final void setTitleOnClickListener(@NotNull final Function0<Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.titleLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.quick.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindBankQuickVC.setTitleOnClickListener$lambda$5(Function0.this, view);
            }
        });
    }
}
