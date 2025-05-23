package com.tenpay.bank.input;

import android.content.Context;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tenpay.QwLog;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.NetBaseActivity;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import qk2.BindCardTipConfig;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00010B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u000e\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0015J\b\u0010\u001c\u001a\u00020\u001aH\u0014J\u001a\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0010\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u0018H\u0016J&\u0010#\u001a\u0004\u0018\u00010\u00182\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020\u0013H\u0016J\u001c\u0010+\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00152\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010,\u001a\u00020\u0013H\u0016J\u0018\u0010-\u001a\u00020\u00132\u0006\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020\u0013H\u0002J\b\u0010/\u001a\u00020\u0013H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Lcom/tenpay/bank/input/BankInputVerifyActivity;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "inputViewModel", "Lcom/tenpay/bank/input/BindBankInputViewModel;", "getInputViewModel", "()Lcom/tenpay/bank/input/BindBankInputViewModel;", "inputViewModel$delegate", "Lkotlin/Lazy;", "mPhoneNumEt", "Landroid/widget/EditText;", "mTimer", "Landroid/os/CountDownTimer;", "mVerifyBtn", "Landroid/widget/Button;", "mVerifyCodeEt", "mVerifySendBtn", "checkMsgCodeFromServer", "", "code", "", "initView", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/view/View;", "isMobileNumber", "", "pnum", "isStatusBarImmersive", "onBlError", BrowserPlugin.KEY_REQUEST_URL, "data", "Lorg/json/JSONObject;", NodeProps.ON_CLICK, "v", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onError", "onResume", "onSuccess", "startSendMsgToServer", "startTimer", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class BankInputVerifyActivity extends NetBaseActivity implements View.OnClickListener {

    @NotNull
    public static final String INTENT_KEY_TOKEN = "token";

    @NotNull
    public static final String PHONE_INPUT_RESULT = "bind_bank_phone_input_result";

    /* renamed from: inputViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy inputViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(BindBankInputViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.bank.input.BankInputVerifyActivity$special$$inlined$activityViewModels$default$1
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
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.bank.input.BankInputVerifyActivity$special$$inlined$activityViewModels$default$2
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
    private EditText mPhoneNumEt;

    @Nullable
    private CountDownTimer mTimer;
    private Button mVerifyBtn;
    private EditText mVerifyCodeEt;
    private Button mVerifySendBtn;

    private final void checkMsgCodeFromServer(String code) {
        HashMap<String, String> createItgVerifyRequest = getInputViewModel().createItgVerifyRequest(code);
        BindCardTipConfig.INSTANCE.a(createItgVerifyRequest);
        httpRequest(Cgi.URI_CFT_USER_BIND, createItgVerifyRequest);
    }

    private final BindBankInputViewModel getInputViewModel() {
        return (BindBankInputViewModel) this.inputViewModel.getValue();
    }

    private final void initView(View rootView) {
        ((TextView) rootView.findViewById(R.id.ivTitleBtnLeft)).setOnClickListener(this);
        View findViewById = rootView.findViewById(R.id.a7r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.et_phone_num)");
        this.mPhoneNumEt = (EditText) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f166959jf0);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.tenpay_verify_code)");
        this.mVerifyCodeEt = (EditText) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.f166961jf2);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.tenpay_verify_resend)");
        this.mVerifySendBtn = (Button) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.jez);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.tenpay_verify_btn)");
        Button button = (Button) findViewById4;
        this.mVerifyBtn = button;
        EditText editText = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerifyBtn");
            button = null;
        }
        button.setOnClickListener(this);
        Button button2 = this.mVerifySendBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
            button2 = null;
        }
        button2.setOnClickListener(this);
        EditText editText2 = this.mVerifyCodeEt;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerifyCodeEt");
            editText2 = null;
        }
        editText2.addTextChangedListener(new x05.b() { // from class: com.tenpay.bank.input.BankInputVerifyActivity$initView$1
            @Override // x05.b, android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s16) {
                Button button3;
                Button button4;
                Button button5;
                int i3;
                boolean z16;
                Intrinsics.checkNotNullParameter(s16, "s");
                String obj = s16.toString();
                int length = obj.length() - 1;
                int i16 = 0;
                boolean z17 = false;
                while (i16 <= length) {
                    if (!z17) {
                        i3 = i16;
                    } else {
                        i3 = length;
                    }
                    if (Intrinsics.compare((int) obj.charAt(i3), 32) <= 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z17) {
                        if (!z16) {
                            z17 = true;
                        } else {
                            i16++;
                        }
                    } else if (!z16) {
                        break;
                    } else {
                        length--;
                    }
                }
                int length2 = obj.subSequence(i16, length + 1).toString().length();
                Button button6 = null;
                if (length2 >= 6) {
                    button5 = BankInputVerifyActivity.this.mVerifyBtn;
                    if (button5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVerifyBtn");
                    } else {
                        button6 = button5;
                    }
                    button6.setEnabled(true);
                    return;
                }
                button3 = BankInputVerifyActivity.this.mVerifyBtn;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVerifyBtn");
                    button3 = null;
                }
                if (button3.isEnabled()) {
                    button4 = BankInputVerifyActivity.this.mVerifyBtn;
                    if (button4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVerifyBtn");
                    } else {
                        button6 = button4;
                    }
                    button6.setEnabled(false);
                }
            }
        });
        EditText editText3 = this.mPhoneNumEt;
        if (editText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumEt");
            editText3 = null;
        }
        editText3.setHint(getInputViewModel().getPhoneNum());
        EditText editText4 = this.mPhoneNumEt;
        if (editText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumEt");
            editText4 = null;
        }
        editText4.setFocusable(false);
        EditText editText5 = this.mPhoneNumEt;
        if (editText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumEt");
            editText5 = null;
        }
        editText5.setFocusableInTouchMode(false);
        EditText editText6 = this.mPhoneNumEt;
        if (editText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumEt");
            editText6 = null;
        }
        editText6.setCursorVisible(false);
        EditText editText7 = this.mPhoneNumEt;
        if (editText7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumEt");
            editText7 = null;
        }
        editText7.setEnabled(false);
        Button button3 = this.mVerifySendBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
            button3 = null;
        }
        button3.setEnabled(true);
        startTimer();
        EditText editText8 = this.mVerifyCodeEt;
        if (editText8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerifyCodeEt");
        } else {
            editText = editText8;
        }
        editText.requestFocus();
    }

    private final void startSendMsgToServer() {
        QwLog.i("\u8001\u7528\u6237\u7ed1\u5361-\u8bf7\u6c42\u9a8c\u8bc1\u7801");
        httpRequest(Cgi.URI_CFT_USER_AUTHEN, getInputViewModel().createItgAuthenRequest());
        EditText editText = this.mVerifyCodeEt;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mVerifyCodeEt");
            editText = null;
        }
        editText.requestFocus();
    }

    private final void startTimer() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = new CountDownTimer() { // from class: com.tenpay.bank.input.BankInputVerifyActivity$startTimer$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(60000L, 1000L);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                EditText editText;
                Button button;
                Button button2;
                Button button3;
                Button button4;
                QwLog.i("time finished...");
                BankInputVerifyActivity bankInputVerifyActivity = BankInputVerifyActivity.this;
                editText = bankInputVerifyActivity.mPhoneNumEt;
                Button button5 = null;
                if (editText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mPhoneNumEt");
                    editText = null;
                }
                if (bankInputVerifyActivity.isMobileNumber(editText.getText().toString())) {
                    button3 = BankInputVerifyActivity.this.mVerifySendBtn;
                    if (button3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
                        button3 = null;
                    }
                    button3.setEnabled(true);
                    button4 = BankInputVerifyActivity.this.mVerifySendBtn;
                    if (button4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
                    } else {
                        button5 = button4;
                    }
                    button5.setText("\u91cd\u65b0\u83b7\u53d6");
                    return;
                }
                button = BankInputVerifyActivity.this.mVerifySendBtn;
                if (button == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
                    button = null;
                }
                button.setEnabled(false);
                button2 = BankInputVerifyActivity.this.mVerifySendBtn;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
                } else {
                    button5 = button2;
                }
                button5.setText("\u83b7\u53d6\u9a8c\u8bc1\u7801");
            }

            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                Button button;
                Button button2;
                QwLog.i("time: " + millisUntilFinished);
                button = BankInputVerifyActivity.this.mVerifySendBtn;
                Button button3 = null;
                if (button == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
                    button = null;
                }
                button.setEnabled(false);
                button2 = BankInputVerifyActivity.this.mVerifySendBtn;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mVerifySendBtn");
                } else {
                    button3 = button2;
                }
                button3.setText("\u5df2\u53d1\u9001 (" + (millisUntilFinished / 1000) + ")");
            }
        };
        countDownTimer2.start();
        this.mTimer = countDownTimer2;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    public final boolean isMobileNumber(@NotNull String pnum) {
        boolean startsWith$default;
        Intrinsics.checkNotNullParameter(pnum, "pnum");
        if (!TextUtils.isEmpty(pnum) && pnum.length() == 11) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(pnum, "1", false, 2, null);
            return startsWith$default;
        }
        return false;
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@NotNull String requestUrl, @Nullable JSONObject data) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        super.onBlError(requestUrl, data);
        String str3 = "";
        String str4 = null;
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CFT_USER_BIND)) {
            BindBankInputViewModel inputViewModel = getInputViewModel();
            if (data != null) {
                str = data.optString("retcode");
            } else {
                str = null;
            }
            if (str == null) {
                str = "";
            }
            if (data != null) {
                str2 = data.optString("retmsg");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                str2 = "";
            }
            inputViewModel.reportTo644("qqwallet.bk_inputcard.result.show", "2", str, str2);
        }
        Context applicationContext = getApplicationContext();
        if (data != null) {
            str4 = data.optString("retmsg");
        }
        if (str4 != null) {
            str3 = str4;
        }
        QQToast.makeText(applicationContext, str3, 0).show();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        int i3;
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (v3.getId() == R.id.jez) {
            EditText editText = this.mVerifyCodeEt;
            if (editText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mVerifyCodeEt");
                editText = null;
            }
            String obj = editText.getText().toString();
            int length = obj.length() - 1;
            int i16 = 0;
            boolean z17 = false;
            while (i16 <= length) {
                if (!z17) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) obj.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z17) {
                    if (!z16) {
                        z17 = true;
                    } else {
                        i16++;
                    }
                } else if (!z16) {
                    break;
                } else {
                    length--;
                }
            }
            checkMsgCodeFromServer(obj.subSequence(i16, length + 1).toString());
        } else if (v3.getId() == R.id.ivTitleBtnLeft) {
            doOnBackPressed();
        } else if (v3.getId() == R.id.f166961jf2) {
            startSendMsgToServer();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View rootView = inflater.inflate(R.layout.f168973hi2, container, false);
        Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
        initView(rootView);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, rootView);
        return rootView;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        CountDownTimer countDownTimer = this.mTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        super.onDestroy();
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onError(@Nullable String requestUrl, @Nullable JSONObject data) {
        String str;
        super.onError(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CFT_USER_BIND)) {
            BindBankInputViewModel inputViewModel = getInputViewModel();
            String str2 = null;
            if (data != null) {
                str = data.optString("retcode");
            } else {
                str = null;
            }
            String str3 = "";
            if (str == null) {
                str = "";
            }
            if (data != null) {
                str2 = data.optString("retmsg");
            }
            if (str2 != null) {
                str3 = str2;
            }
            inputViewModel.reportTo644("qqwallet.bk_inputcard.result.show", "2", str, str3);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        BindBankInputViewModel.reportTo644$default(getInputViewModel(), "qqwallet.bk_inputcard.mobileverification.show", null, null, null, 14, null);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@NotNull String requestUrl, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        super.onSuccess(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_CFT_USER_AUTHEN)) {
            getInputViewModel().setBindCardPreObj(data);
            startTimer();
        } else if (Intrinsics.areEqual(requestUrl, Cgi.URI_CFT_USER_BIND)) {
            Bundle bundle = new Bundle();
            bundle.putString("bind_serial", data.optString("bind_serial"));
            bundle.putString("token", data.optString("token"));
            FragmentKt.setFragmentResult(this, PHONE_INPUT_RESULT, bundle);
            BindBankInputViewModel.reportTo644$default(getInputViewModel(), "qqwallet.bk_inputcard.result.show", "1", null, null, 12, null);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public /* bridge */ /* synthetic */ boolean useArgusLifecycle() {
        return ne0.a.f(this);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(String str, @NonNull Class cls) {
        return ne0.a.c(this, str, cls);
    }
}
