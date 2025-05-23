package com.tenpay.bank.input;

import android.content.DialogInterface;
import android.content.Intent;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.api.IQWalletUnitedConfigApi;
import com.tencent.mobileqq.qwallet.utils.k;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tenpay.bank.BindBankMainFragment;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.activity.TenpayPluginSelectBankActivity;
import com.tenpay.sdk.net.NetParams;
import com.tenpay.sdk.view.ClearableEditText;
import com.tenpay.sdk.view.TenpayEditText;
import com.tenpay.sdk.view.TenpayNumberEditText;
import com.tenpay.sdk.view.ValidDateEdit;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qk2.BindCardTipConfig;
import x05.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000}\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n*\u0001\u000f\u0018\u0000 @2\u00020\u0001:\u0001@B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001a\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020%H\u0002J\u0010\u0010+\u001a\u00020'2\u0006\u0010,\u001a\u00020'H\u0002J\u0006\u0010-\u001a\u00020#J\u0010\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020%H\u0002J\u0010\u00100\u001a\u00020)2\u0006\u00101\u001a\u00020'H\u0002J\u000e\u00102\u001a\u00020#2\u0006\u00103\u001a\u000204J\u0014\u00105\u001a\u00020#2\f\u00106\u001a\b\u0012\u0004\u0012\u00020#07J\u001e\u00108\u001a\u00020#2\n\b\u0002\u00109\u001a\u0004\u0018\u00010'2\b\b\u0002\u0010:\u001a\u00020)H\u0002J\u0006\u0010;\u001a\u00020#J\b\u0010<\u001a\u00020#H\u0002J\b\u0010=\u001a\u00020#H\u0002J\b\u0010>\u001a\u00020#H\u0002J\b\u0010?\u001a\u00020)H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u000fX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006A"}, d2 = {"Lcom/tenpay/bank/input/BindBankInputVC;", "", "fragment", "Lcom/tenpay/bank/BindBankMainFragment;", "contentView", "Landroid/view/View;", "(Lcom/tenpay/bank/BindBankMainFragment;Landroid/view/View;)V", "bankCardContent", "Lcom/tenpay/sdk/view/TenpayNumberEditText;", "bankCvvContent", "Lcom/tenpay/sdk/view/TenpayEditText;", "bankCvvRoot", "bankNextBtn", "Landroid/widget/Button;", "bankNextEnableWatcher", "com/tenpay/bank/input/BindBankInputVC$bankNextEnableWatcher$1", "Lcom/tenpay/bank/input/BindBankInputVC$bankNextEnableWatcher$1;", "bankPhoneBtn", "bankPhoneContent", "Lcom/tenpay/sdk/view/ClearableEditText;", "bankPhoneRoot", "bankThruContent", "Lcom/tenpay/sdk/view/ValidDateEdit;", "bankThruRoot", "bankTypeContent", "Landroid/widget/TextView;", "bankTypeRoot", "bindBankInputFrom", "inputViewModel", "Lcom/tenpay/bank/input/BindBankInputViewModel;", "getInputViewModel", "()Lcom/tenpay/bank/input/BindBankInputViewModel;", "inputViewModel$delegate", "Lkotlin/Lazy;", "afterSelectBankInfo", "", "mbank", "Lorg/json/JSONObject;", "bankCardInput", "", "checkBankData", "", "bankData", "getMaskTrueName", "trueName", "hideInputForm", "initInputBankInfo", "bank", "isMobileNumber", "phoneNum", "onActivityResult", "data", "Landroid/content/Intent;", "setBankCardOnClickListener", "onClickListener", "Lkotlin/Function0;", "setTypeData", "content", NodeProps.VISIBLE, "showInputForm", "showPhoneTipsDialog", "showPrivacyDialog", "showSelectBankDialog", "validatePageOne", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BindBankInputVC {

    @NotNull
    private static final String TAG = "BindBankInputVC";

    @NotNull
    private final TenpayNumberEditText bankCardContent;

    @NotNull
    private final TenpayEditText bankCvvContent;

    @NotNull
    private final View bankCvvRoot;

    @NotNull
    private final Button bankNextBtn;

    @NotNull
    private final BindBankInputVC$bankNextEnableWatcher$1 bankNextEnableWatcher;

    @NotNull
    private final Button bankPhoneBtn;

    @NotNull
    private final ClearableEditText bankPhoneContent;

    @NotNull
    private final View bankPhoneRoot;

    @NotNull
    private final ValidDateEdit bankThruContent;

    @NotNull
    private final View bankThruRoot;

    @NotNull
    private final TextView bankTypeContent;

    @NotNull
    private final View bankTypeRoot;

    @NotNull
    private final View bindBankInputFrom;

    @NotNull
    private final BindBankMainFragment fragment;

    /* renamed from: inputViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [com.tenpay.bank.input.BindBankInputVC$bankNextEnableWatcher$1, android.text.TextWatcher] */
    public BindBankInputVC(@NotNull final BindBankMainFragment fragment, @NotNull View contentView) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        this.fragment = fragment;
        this.inputViewModel = FragmentViewModelLazyKt.createViewModelLazy(fragment, Reflection.getOrCreateKotlinClass(BindBankInputViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.bank.input.BindBankInputVC$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ViewModelStore invoke() {
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                ViewModelStore viewModelStore = requireActivity.get_viewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.bank.input.BindBankInputVC$special$$inlined$activityViewModels$default$2
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
        View findViewById = contentView.findViewById(R.id.t78);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById\u2026.id.bind_bank_input_form)");
        this.bindBankInputFrom = findViewById;
        View findViewById2 = contentView.findViewById(R.id.t6z);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById\u2026d.bind_bank_card_content)");
        TenpayNumberEditText tenpayNumberEditText = (TenpayNumberEditText) findViewById2;
        this.bankCardContent = tenpayNumberEditText;
        View findViewById3 = contentView.findViewById(R.id.t7n);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById(R.id.bind_bank_type_root)");
        this.bankTypeRoot = findViewById3;
        View findViewById4 = contentView.findViewById(R.id.t7m);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "contentView.findViewById\u2026d.bind_bank_type_content)");
        TextView textView = (TextView) findViewById4;
        this.bankTypeContent = textView;
        View findViewById5 = contentView.findViewById(R.id.t7h);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "contentView.findViewById(R.id.bind_bank_thru_root)");
        this.bankThruRoot = findViewById5;
        View findViewById6 = contentView.findViewById(R.id.t7g);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "contentView.findViewById\u2026d.bind_bank_thru_content)");
        ValidDateEdit validDateEdit = (ValidDateEdit) findViewById6;
        this.bankThruContent = validDateEdit;
        View findViewById7 = contentView.findViewById(R.id.f164605t73);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "contentView.findViewById(R.id.bind_bank_cvv_root)");
        this.bankCvvRoot = findViewById7;
        View findViewById8 = contentView.findViewById(R.id.f164604t72);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "contentView.findViewById\u2026id.bind_bank_cvv_content)");
        TenpayEditText tenpayEditText = (TenpayEditText) findViewById8;
        this.bankCvvContent = tenpayEditText;
        View findViewById9 = contentView.findViewById(R.id.t7b);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "contentView.findViewById\u2026.id.bind_bank_phone_root)");
        this.bankPhoneRoot = findViewById9;
        View findViewById10 = contentView.findViewById(R.id.t7a);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "contentView.findViewById\u2026.bind_bank_phone_content)");
        ClearableEditText clearableEditText = (ClearableEditText) findViewById10;
        this.bankPhoneContent = clearableEditText;
        View findViewById11 = contentView.findViewById(R.id.t7_);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "contentView.findViewById(R.id.bind_bank_phone_btn)");
        Button button = (Button) findViewById11;
        this.bankPhoneBtn = button;
        View findViewById12 = contentView.findViewById(R.id.a9b);
        Intrinsics.checkNotNullExpressionValue(findViewById12, "contentView.findViewById(R.id.bin_confirm)");
        Button button2 = (Button) findViewById12;
        this.bankNextBtn = button2;
        ?? r65 = new TextWatcher() { // from class: com.tenpay.bank.input.BindBankInputVC$bankNextEnableWatcher$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s16) {
                Button button3;
                boolean validatePageOne;
                button3 = BindBankInputVC.this.bankNextBtn;
                validatePageOne = BindBankInputVC.this.validatePageOne();
                button3.setEnabled(validatePageOne);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            }
        };
        this.bankNextEnableWatcher = r65;
        tenpayNumberEditText.setHint("\u8bf7\u8f93\u5165" + getMaskTrueName(getInputViewModel().getMTrueName()) + "\u672c\u4eba\u7684\u94f6\u884c\u5361\u53f7");
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.input.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindBankInputVC._init_$lambda$0(BindBankInputVC.this, view);
            }
        });
        findViewById3.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.input.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindBankInputVC._init_$lambda$1(BindBankInputVC.this, view);
            }
        });
        button.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.input.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindBankInputVC._init_$lambda$2(BindBankInputVC.this, view);
            }
        });
        tenpayNumberEditText.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.bank.input.BindBankInputVC.4
            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable s16) {
                String bankCardInput = BindBankInputVC.this.bankCardContent.getData();
                BindBankInputVC.this.bankCardContent.setFilters(new InputFilter[]{new InputFilter.LengthFilter(31)});
                if (bankCardInput.length() < 10) {
                    return;
                }
                BindBankInputVC bindBankInputVC = BindBankInputVC.this;
                BindBankInputVC.setTypeData$default(bindBankInputVC, bindBankInputVC.fragment.getString(R.string.f171358ec3), false, 2, null);
                BindBankInputViewModel inputViewModel = BindBankInputVC.this.getInputViewModel();
                Intrinsics.checkNotNullExpressionValue(bankCardInput, "bankCardInput");
                BindBankInputVC.this.afterSelectBankInfo(inputViewModel.findBankData(bankCardInput), bankCardInput);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence s16, int start, int count, int after) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence s16, int start, int before, int count) {
            }
        });
        tenpayNumberEditText.addTextChangedListener(r65);
        textView.addTextChangedListener(r65);
        validDateEdit.addTextChangedListener(r65);
        tenpayEditText.addTextChangedListener(r65);
        clearableEditText.addTextChangedListener(r65);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$0(BindBankInputVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getInputViewModel().setPhoneNum(this$0.bankPhoneContent.getText().toString());
        this$0.getInputViewModel().setCvvContent(this$0.bankCvvContent.getText().toString());
        this$0.getInputViewModel().setThruContent(this$0.bankThruContent.getText().toString());
        this$0.getInputViewModel().setBankCardId(this$0.bankCardContent.getData());
        if (this$0.validatePageOne()) {
            this$0.showPrivacyDialog();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$1(BindBankInputVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showSelectBankDialog();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(BindBankInputVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.showPhoneTipsDialog();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void afterSelectBankInfo(JSONObject mbank, String bankCardInput) {
        getInputViewModel().setCurrentBankData(mbank);
        if (mbank == null) {
            setTypeData$default(this, this.fragment.getString(R.string.f171358ec3), false, 2, null);
            this.bankNextBtn.setEnabled(false);
            return;
        }
        String optString = mbank.optString("name");
        setTypeData$default(this, optString, false, 2, null);
        if (mbank.optInt("disabled") > 0) {
            setTypeData$default(this, optString + "(\u4e0d\u652f\u6301\u8be5\u64cd\u4f5c)", false, 2, null);
            checkBankData(mbank);
            return;
        }
        this.bankPhoneRoot.setVisibility(0);
        int length = bankCardInput.length();
        String optString2 = mbank.optString("type");
        if (Intrinsics.areEqual(NetParams.DEBIT_FAST, optString2) || Intrinsics.areEqual(NetParams.CREDIT_FAST, optString2)) {
            String optString3 = mbank.optString("card_tail");
            String substring = bankCardInput.substring(length - 5, length - 1);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            if (Intrinsics.areEqual(optString3, substring)) {
                QUIProxy.createCustomDialog(this.fragment.getContext(), 230, null, this.fragment.getString(R.string.e1c), this.fragment.getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.bank.input.d
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        BindBankInputVC.afterSelectBankInfo$lambda$6(dialogInterface, i3);
                    }
                });
                return;
            }
        }
        initInputBankInfo(mbank);
    }

    private final boolean checkBankData(JSONObject bankData) {
        int optInt = bankData.optInt("disabled");
        String optString = bankData.optString("disable_comment");
        if (optInt <= 0) {
            return true;
        }
        if (!TextUtils.isEmpty(optString)) {
            QQToast.makeText(MobileQQ.sMobileQQ, 0, optString, 0).show();
        } else {
            String str = "\u8be5\u573a\u666f\u4e0b\u6b64\u94f6\u884c\u5361\u4e0d\u53ef\u7528";
            if (optInt != 1) {
                if (optInt != 2) {
                    if (optInt != 3) {
                        if (optInt == 5) {
                            str = "\u94f6\u884c\u7cfb\u7edf\u7ef4\u62a4\u4e2d";
                        }
                    } else {
                        str = "\u5546\u6237\u6682\u4e0d\u652f\u6301\u8be5\u94f6\u884c";
                    }
                } else {
                    str = "\u5e73\u53f0\u6682\u4e0d\u652f\u6301\u8be5\u94f6\u884c";
                }
            }
            QQToast.makeText(MobileQQ.sMobileQQ, 0, str, 0).show();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BindBankInputViewModel getInputViewModel() {
        return (BindBankInputViewModel) this.inputViewModel.getValue();
    }

    private final String getMaskTrueName(String trueName) {
        if (trueName.length() <= 1) {
            return trueName;
        }
        String substring = trueName.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
        return "*" + substring;
    }

    private final boolean initInputBankInfo(JSONObject bank) {
        int i3;
        setTypeData$default(this, bank.optString("name"), false, 2, null);
        if (!Intrinsics.areEqual(NetParams.DEBIT_UNBIND, bank.optString("type")) && !Intrinsics.areEqual(NetParams.DEBIT_FAST, bank.optString("type"))) {
            int optInt = bank.optInt("needcvv");
            int optInt2 = bank.optInt("needthru");
            View view = this.bankCvvRoot;
            int i16 = 8;
            if (optInt != 0) {
                i3 = 0;
            } else {
                this.bankCvvContent.setText("");
                i3 = 8;
            }
            view.setVisibility(i3);
            View view2 = this.bankThruRoot;
            if (optInt2 != 0) {
                i16 = 0;
            } else {
                this.bankThruContent.setText("");
            }
            view2.setVisibility(i16);
        }
        return false;
    }

    private final boolean isMobileNumber(String phoneNum) {
        boolean startsWith$default;
        if (!TextUtils.isEmpty(phoneNum) && phoneNum.length() == 11) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(phoneNum, "1", false, 2, null);
            return startsWith$default;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBankCardOnClickListener$lambda$3(Function0 onClickListener, BindBankInputVC this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        onClickListener.invoke();
        this$0.bankCardContent.requestFocus();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBankCardOnClickListener$lambda$4(Function0 onClickListener, View view, boolean z16) {
        Intrinsics.checkNotNullParameter(onClickListener, "$onClickListener");
        if (z16) {
            onClickListener.invoke();
        }
    }

    private final void setTypeData(String content, boolean visible) {
        if (!visible) {
            this.bankTypeRoot.setVisibility(8);
            return;
        }
        this.bankTypeRoot.setVisibility(0);
        if (content != null) {
            this.bankTypeContent.setText(content);
        }
    }

    static /* synthetic */ void setTypeData$default(BindBankInputVC bindBankInputVC, String str, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        bindBankInputVC.setTypeData(str, z16);
    }

    private final void showPhoneTipsDialog() {
        String str;
        String string = this.fragment.getString(R.string.f171355ec0);
        Intrinsics.checkNotNullExpressionValue(string, "fragment.getString(com.t\u2026ng.qb_tenpay_phone_alert)");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[1];
        JSONObject currentBankData = getInputViewModel().getCurrentBankData();
        if (currentBankData != null) {
            str = currentBankData.optString("tel_number");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String format = String.format(string, Arrays.copyOf(objArr, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        QUIProxy.createCustomDialog(this.fragment.getContext(), 230, null, format, this.fragment.getString(R.string.e3_), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.bank.input.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindBankInputVC.showPhoneTipsDialog$lambda$12(dialogInterface, i3);
            }
        });
    }

    private final void showPrivacyDialog() {
        BindCardTipConfig.Alert alert = ((BindCardTipConfig) ((IQWalletUnitedConfigApi) QRoute.api(IQWalletUnitedConfigApi.class)).getConfig(IQWalletUnitedConfigApi.QWALLET_BIND_BANK_TIP_CONFIG, new BindCardTipConfig(null, 1, 0 == true ? 1 : 0))).getAlert();
        String retMsg = alert.getRetMsg();
        String title = alert.getTitle();
        String rButton = alert.getRButton();
        String lButton = alert.getLButton();
        QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(this.fragment.getActivity(), 230, R.layout.fy6, title, x05.c.d(retMsg, new c.InterfaceC11524c() { // from class: com.tenpay.bank.input.h
            @Override // x05.c.InterfaceC11524c
            public final void onClickUrl(String str) {
                BindBankInputVC.showPrivacyDialog$lambda$8(BindBankInputVC.this, str);
            }
        }), lButton, rButton, new DialogInterface.OnClickListener() { // from class: com.tenpay.bank.input.i
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindBankInputVC.showPrivacyDialog$lambda$9(BindBankInputVC.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tenpay.bank.input.j
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                BindBankInputVC.showPrivacyDialog$lambda$10(dialogInterface, i3);
            }
        });
        createCustomDialogUrlWithoutAutoLink.getBtnight().setTextColor(-1);
        createCustomDialogUrlWithoutAutoLink.setCancelable(false);
        createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
        Window window = createCustomDialogUrlWithoutAutoLink.getWindow();
        if (window != null) {
            window.setGravity(80);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        createCustomDialogUrlWithoutAutoLink.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPrivacyDialog$lambda$8(BindBankInputVC this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        k.c(this$0.fragment.getActivity(), str, false, false, null, 28, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPrivacyDialog$lambda$9(BindBankInputVC this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.fragment.handleNamedUserNextStep();
    }

    private final void showSelectBankDialog() {
        if (getInputViewModel().getBankData() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("bank_data", String.valueOf(getInputViewModel().getBankData()));
        JSONObject currentBankData = getInputViewModel().getCurrentBankData();
        if (currentBankData != null) {
            intent.putExtra("bank_name", currentBankData.optString("sname"));
            intent.putExtra("index", !Intrinsics.areEqual(NetParams.DEBIT_UNBIND, currentBankData.optString("type")) ? 1 : 0);
        }
        this.fragment.launchFragmentForResult(intent, TenpayPluginSelectBankActivity.class, 202);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean validatePageOne() {
        int coerceAtLeast;
        boolean z16;
        int length = this.bankCardContent.getData().length();
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(getInputViewModel().getBinLength(), 13);
        if (length < coerceAtLeast || getInputViewModel().getCurrentBankData() == null) {
            return false;
        }
        if (this.bankThruRoot.getVisibility() == 0) {
            Editable text = this.bankThruContent.getText();
            Intrinsics.checkNotNullExpressionValue(text, "bankThruContent.text");
            if (text.length() == 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                return false;
            }
        }
        if ((this.bankCvvRoot.getVisibility() == 0 && this.bankCvvContent.getText().toString().length() < 3) || !isMobileNumber(this.bankPhoneContent.getText().toString())) {
            return false;
        }
        return true;
    }

    public final void hideInputForm() {
        this.bindBankInputFrom.setVisibility(8);
    }

    public final void onActivityResult(@NotNull Intent data) {
        Intrinsics.checkNotNullParameter(data, "data");
        String stringExtra = data.getStringExtra("bank");
        if (stringExtra != null) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                String data2 = this.bankCardContent.getData();
                Intrinsics.checkNotNullExpressionValue(data2, "bankCardContent.data");
                afterSelectBankInfo(jSONObject, data2);
            } catch (Exception e16) {
                QLog.e(TAG, 1, "", e16);
            }
        }
    }

    public final void setBankCardOnClickListener(@NotNull final Function0<Unit> onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, "onClickListener");
        this.bankCardContent.setOnClickListener(new View.OnClickListener() { // from class: com.tenpay.bank.input.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BindBankInputVC.setBankCardOnClickListener$lambda$3(Function0.this, this, view);
            }
        });
        this.bankCardContent.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: com.tenpay.bank.input.b
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view, boolean z16) {
                BindBankInputVC.setBankCardOnClickListener$lambda$4(Function0.this, view, z16);
            }
        });
    }

    public final void showInputForm() {
        this.bindBankInputFrom.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void afterSelectBankInfo$lambda$6(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPhoneTipsDialog$lambda$12(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showPrivacyDialog$lambda$10(DialogInterface dialogInterface, int i3) {
    }
}
