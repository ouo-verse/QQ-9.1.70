package com.tenpay.fingerpay;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.midas.api.APMidasPayAPI;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqmini.sdk.browser.BrowserPlugin;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tenpay.ErrorCode;
import com.tenpay.api.MyKeyboardWindow;
import com.tenpay.impl.ApiFingerImpl;
import com.tenpay.proxy.QUIProxy;
import com.tenpay.sdk.Cgi;
import com.tenpay.sdk.activity.NetBaseActivity;
import com.tenpay.sdk.activity.ResetPassBridgeActivity;
import com.tenpay.sdk.util.QWSoterConstans;
import com.tenpay.sdk.view.OnPasswdInputListener;
import com.tenpay.sdk.view.SixPasswdDialogEditText;
import com.tenpay.util.Utils;
import cooperation.qwallet.plugin.FakeUrl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u001c\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u0018\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u00020\u00152\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u00152\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J&\u0010,\u001a\u0004\u0018\u00010(2\u0006\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u0001002\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0018\u00101\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0010\u00102\u001a\u00020\u00152\u0006\u00103\u001a\u00020\u001bH\u0002J\b\u00104\u001a\u00020\u0015H\u0016J\b\u00105\u001a\u00020\u0015H\u0016J\u001c\u00106\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u00107\u001a\u00020\u00152\u0006\u00108\u001a\u00020(2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u00069"}, d2 = {"Lcom/tenpay/fingerpay/FingerPaySettingAuthFragment;", "Lcom/tenpay/sdk/activity/NetBaseActivity;", "Landroid/view/View$OnClickListener;", "()V", "keyboardWindow", "Lcom/tenpay/api/MyKeyboardWindow;", "normalPasswdEdit", "Landroid/widget/EditText;", "passNextBtn", "Landroid/widget/Button;", "settingViewModel", "Lcom/tenpay/fingerpay/FingerPaySettingViewModel;", "getSettingViewModel", "()Lcom/tenpay/fingerpay/FingerPaySettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "sixPasswdEdit", "Lcom/tenpay/sdk/view/SixPasswdDialogEditText;", "title", "Landroid/widget/TextView;", "fingerPayOpenRequest", "", "getPasswd", "", "getSpecialErrorCode", "", "isStatusBarImmersive", "", "onBackEvent", "onBlError", BrowserPlugin.KEY_REQUEST_URL, "data", "Lorg/json/JSONObject;", "onBlHandleFakeurl", "fakeInfo", "Lcooperation/qwallet/plugin/FakeUrl$FakeInfo;", "bntIndex", "", NodeProps.ON_CLICK, "v", "Landroid/view/View;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", ParseCommon.CONTAINER, "Landroid/view/ViewGroup;", "onNetDlgokClick", "onOpenFingerPayFinish", "success", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onSuccess", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "view", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class FingerPaySettingAuthFragment extends NetBaseActivity implements View.OnClickListener {
    private MyKeyboardWindow keyboardWindow;
    private EditText normalPasswdEdit;
    private Button passNextBtn;

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy settingViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(FingerPaySettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.tenpay.fingerpay.FingerPaySettingAuthFragment$special$$inlined$activityViewModels$default$1
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
    }, new Function0<ViewModelProvider.Factory>() { // from class: com.tenpay.fingerpay.FingerPaySettingAuthFragment$special$$inlined$activityViewModels$default$2
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
    private SixPasswdDialogEditText sixPasswdEdit;
    private TextView title;

    private final void fingerPayOpenRequest() {
        httpRequest(Cgi.URI_Soter_FINGER_PAY_OPEN, getSettingViewModel().getOpenRequestData(getPasswd()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [android.widget.EditText] */
    private final String getPasswd() {
        int i3;
        boolean z16;
        int i16;
        boolean z17;
        EditText editText = this.normalPasswdEdit;
        SixPasswdDialogEditText sixPasswdDialogEditText = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
            editText = null;
        }
        if (editText.getVisibility() == 0) {
            ?? r06 = this.normalPasswdEdit;
            if (r06 == 0) {
                Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
            } else {
                sixPasswdDialogEditText = r06;
            }
            String obj = sixPasswdDialogEditText.getText().toString();
            int length = obj.length() - 1;
            int i17 = 0;
            boolean z18 = false;
            while (i17 <= length) {
                if (!z18) {
                    i16 = i17;
                } else {
                    i16 = length;
                }
                if (Intrinsics.compare((int) obj.charAt(i16), 32) <= 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (!z18) {
                    if (!z17) {
                        z18 = true;
                    } else {
                        i17++;
                    }
                } else {
                    if (!z17) {
                        break;
                    }
                    length--;
                }
            }
            return obj.subSequence(i17, length + 1).toString();
        }
        SixPasswdDialogEditText sixPasswdDialogEditText2 = this.sixPasswdEdit;
        if (sixPasswdDialogEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
        } else {
            sixPasswdDialogEditText = sixPasswdDialogEditText2;
        }
        String inputText = sixPasswdDialogEditText.getInputText();
        if (inputText != null) {
            int length2 = inputText.length() - 1;
            int i18 = 0;
            boolean z19 = false;
            while (i18 <= length2) {
                if (!z19) {
                    i3 = i18;
                } else {
                    i3 = length2;
                }
                if (Intrinsics.compare((int) inputText.charAt(i3), 32) <= 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z19) {
                    if (!z16) {
                        z19 = true;
                    } else {
                        i18++;
                    }
                } else {
                    if (!z16) {
                        break;
                    }
                    length2--;
                }
            }
            String obj2 = inputText.subSequence(i18, length2 + 1).toString();
            if (obj2 != null) {
                return obj2;
            }
        }
        return "";
    }

    private final FingerPaySettingViewModel getSettingViewModel() {
        return (FingerPaySettingViewModel) this.settingViewModel.getValue();
    }

    private final void onOpenFingerPayFinish(boolean success) {
        QLog.i(((NetBaseActivity) this).TAG, 1, "onOpenFingerPayFinish success=" + success);
        if (success) {
            getSettingViewModel().openSoterPay();
            showOkTips(QWSoterConstans.getNameByBusiType(getSettingViewModel().getIntentBusiType()) + "\u652f\u4ed8\u5df2\u5f00\u542f", null);
            getSettingViewModel().saveOpenSuccessResult();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$3(final FingerPaySettingAuthFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.mHandler == null) {
            return;
        }
        SixPasswdDialogEditText sixPasswdDialogEditText = this$0.sixPasswdEdit;
        if (sixPasswdDialogEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            sixPasswdDialogEditText = null;
        }
        sixPasswdDialogEditText.post(new Runnable() { // from class: com.tenpay.fingerpay.a
            @Override // java.lang.Runnable
            public final void run() {
                FingerPaySettingAuthFragment.onViewCreated$lambda$3$lambda$2(FingerPaySettingAuthFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
    
        if (r0 == null) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void onViewCreated$lambda$3$lambda$2(FingerPaySettingAuthFragment this$0) {
        String str;
        int i3;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SixPasswdDialogEditText sixPasswdDialogEditText = this$0.sixPasswdEdit;
        Button button = null;
        if (sixPasswdDialogEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            sixPasswdDialogEditText = null;
        }
        String inputText = sixPasswdDialogEditText.getInputText();
        if (inputText != null) {
            int length = inputText.length() - 1;
            int i16 = 0;
            boolean z17 = false;
            while (i16 <= length) {
                if (!z17) {
                    i3 = i16;
                } else {
                    i3 = length;
                }
                if (Intrinsics.compare((int) inputText.charAt(i3), 32) <= 0) {
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
            str = inputText.subSequence(i16, length + 1).toString();
        }
        str = "";
        Button button2 = this$0.passNextBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
        } else {
            button = button2;
        }
        if (str.length() > 5) {
            if (!button.isEnabled()) {
                button.setClickable(true);
                button.setEnabled(true);
                button.performClick();
                return;
            }
            return;
        }
        if (button.isEnabled()) {
            button.setClickable(false);
            button.setEnabled(false);
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    @NotNull
    protected List<String> getSpecialErrorCode() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ErrorCode.ERR_PASSWORD_BALANCE_PAY);
        return arrayList;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment
    protected boolean isStatusBarImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        List<Fragment> fragments = getParentFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "parentFragmentManager.fragments");
        if (fragments.size() <= 1) {
            return false;
        }
        String str = ((NetBaseActivity) this).TAG;
        QLog.i(str, 1, "back from " + str);
        getParentFragmentManager().popBackStack((String) null, 1);
        return true;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onBlError(@Nullable String requestUrl, @Nullable JSONObject data) {
        String str;
        super.onBlError(requestUrl, data);
        SixPasswdDialogEditText sixPasswdDialogEditText = null;
        if (data != null) {
            str = data.optString("retcode");
        } else {
            str = null;
        }
        if (str == null) {
            return;
        }
        if (Intrinsics.areEqual(ErrorCode.ERR_PASSWORD_BALANCE_PAY, str)) {
            SixPasswdDialogEditText sixPasswdDialogEditText2 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            } else {
                sixPasswdDialogEditText = sixPasswdDialogEditText2;
            }
            sixPasswdDialogEditText.setInputText("");
            QUIProxy.createCustomDialog(getContext(), 230, null, data.optString("retmsg"), getString(R.string.e5j), null, null, new DialogInterface.OnClickListener() { // from class: com.tenpay.fingerpay.b
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    dialogInterface.dismiss();
                }
            });
            return;
        }
        if (Intrinsics.areEqual(Cgi.URI_Soter_FINGER_PAY_OPEN, requestUrl)) {
            try {
                VACDReportUtil.a(APMidasPayAPI.PAY_CHANNEL_QQWALLET, "fingerprint.open.result", null, null, Integer.parseInt(str), data.optString("retmsg"));
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            new ApiFingerImpl().closeFingerPay(getContext(), com.tencent.mobileqq.base.a.c());
            SixPasswdDialogEditText sixPasswdDialogEditText3 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            } else {
                sixPasswdDialogEditText = sixPasswdDialogEditText3;
            }
            sixPasswdDialogEditText.setInputText("");
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, cooperation.qwallet.plugin.FakeUrl.FakeListener
    public boolean onBlHandleFakeurl(@NotNull FakeUrl.FakeInfo fakeInfo, int bntIndex) {
        Intrinsics.checkNotNullParameter(fakeInfo, "fakeInfo");
        if (bntIndex == 0) {
            return false;
        }
        super.onBlHandleFakeurl(fakeInfo, bntIndex);
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        MyKeyboardWindow myKeyboardWindow = null;
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.f8w) {
            fingerPayOpenRequest();
        } else if (num != null && num.intValue() == R.id.cja) {
            Intent intent = new Intent();
            intent.putExtra("forget_pass", true);
            intent.putExtra("pass_flag", this.mPassFlag);
            launchFragment(intent, ResetPassBridgeActivity.class);
        } else if (num != null && num.intValue() == R.id.ivTitleBtnLeft) {
            doOnBackPressed();
        } else if (num != null && num.intValue() == R.id.iwz) {
            MyKeyboardWindow myKeyboardWindow2 = this.keyboardWindow;
            if (myKeyboardWindow2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyboardWindow");
            } else {
                myKeyboardWindow = myKeyboardWindow2;
            }
            myKeyboardWindow.setVisibility(0);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        if (window != null) {
            window.addFlags(8192);
        }
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.fy_, container, false);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity
    public void onNetDlgokClick(@NotNull String requestUrl, @NotNull JSONObject data) {
        Intrinsics.checkNotNullParameter(requestUrl, "requestUrl");
        Intrinsics.checkNotNullParameter(data, "data");
        super.onNetDlgokClick(requestUrl, data);
        String optString = data.optString("retmsg");
        if (Intrinsics.areEqual(Cgi.URI_Soter_FINGER_PAY_OPEN, requestUrl)) {
            SixPasswdDialogEditText sixPasswdDialogEditText = this.sixPasswdEdit;
            SixPasswdDialogEditText sixPasswdDialogEditText2 = null;
            if (sixPasswdDialogEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
                sixPasswdDialogEditText = null;
            }
            sixPasswdDialogEditText.setInputText("");
            SixPasswdDialogEditText sixPasswdDialogEditText3 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            } else {
                sixPasswdDialogEditText2 = sixPasswdDialogEditText3;
            }
            sixPasswdDialogEditText2.requestFocus();
        }
        if (28027203 == data.optInt("retcode")) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(Cgi.RETURN_MSG_JSON_ERROR_KEY, optString);
            } catch (JSONException e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
            }
            setRetCodeAndGetBundle(ErrorCode.ERR_ACCOUNT_DONGJIE).putString(Cgi.RETURN_MSG_KEY, jSONObject.toString());
            finish();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        onOpenFingerPayFinish(false);
        super.onPause();
    }

    @Override // com.tencent.mobileqq.base.QWalletBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        QUIImmersiveHelper.s(getActivity(), true, true);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.paynet.Net.NetListener
    public void onSuccess(@Nullable String requestUrl, @Nullable JSONObject data) {
        super.onSuccess(requestUrl, data);
        if (Intrinsics.areEqual(requestUrl, Cgi.URI_Soter_FINGER_PAY_OPEN)) {
            onOpenFingerPayFinish(true);
            doOnBackPressed();
        }
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    @Override // com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.base.QWalletBaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.ivTitleBtnLeft).setOnClickListener(this);
        view.findViewById(R.id.cja).setOnClickListener(this);
        View findViewById = view.findViewById(R.id.fai);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.normal_passwd_edt)");
        EditText editText = (EditText) findViewById;
        this.normalPasswdEdit = editText;
        TextView textView = null;
        if (editText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
            editText = null;
        }
        editText.setLongClickable(false);
        EditText editText2 = this.normalPasswdEdit;
        if (editText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
            editText2 = null;
        }
        editText2.addTextChangedListener(new TextWatcher() { // from class: com.tenpay.fingerpay.FingerPaySettingAuthFragment$onViewCreated$1
            @Override // android.text.TextWatcher
            public void afterTextChanged(@NotNull Editable s16) {
                EditText editText3;
                Button button;
                Button button2;
                Button button3;
                Button button4;
                Button button5;
                int i3;
                boolean z16;
                Intrinsics.checkNotNullParameter(s16, "s");
                editText3 = FingerPaySettingAuthFragment.this.normalPasswdEdit;
                Button button6 = null;
                if (editText3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
                    editText3 = null;
                }
                String obj = editText3.getText().toString();
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
                if (obj.subSequence(i16, length + 1).toString().length() > 5) {
                    button4 = FingerPaySettingAuthFragment.this.passNextBtn;
                    if (button4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
                        button4 = null;
                    }
                    button4.setClickable(true);
                    button5 = FingerPaySettingAuthFragment.this.passNextBtn;
                    if (button5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
                    } else {
                        button6 = button5;
                    }
                    button6.setEnabled(true);
                    return;
                }
                button = FingerPaySettingAuthFragment.this.passNextBtn;
                if (button == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
                    button = null;
                }
                if (button.isEnabled()) {
                    button3 = FingerPaySettingAuthFragment.this.passNextBtn;
                    if (button3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
                        button3 = null;
                    }
                    button3.setClickable(false);
                }
                button2 = FingerPaySettingAuthFragment.this.passNextBtn;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
                } else {
                    button6 = button2;
                }
                button6.setEnabled(false);
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@NotNull CharSequence s16, int start, int count, int after) {
                Intrinsics.checkNotNullParameter(s16, "s");
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@NotNull CharSequence s16, int start, int before, int count) {
                Intrinsics.checkNotNullParameter(s16, "s");
            }
        });
        View findViewById2 = view.findViewById(R.id.iwz);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.six_passwd_edt)");
        SixPasswdDialogEditText sixPasswdDialogEditText = (SixPasswdDialogEditText) findViewById2;
        this.sixPasswdEdit = sixPasswdDialogEditText;
        if (sixPasswdDialogEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            sixPasswdDialogEditText = null;
        }
        sixPasswdDialogEditText.setLongClickable(false);
        SixPasswdDialogEditText sixPasswdDialogEditText2 = this.sixPasswdEdit;
        if (sixPasswdDialogEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            sixPasswdDialogEditText2 = null;
        }
        sixPasswdDialogEditText2.setOnPasswdInputListener(new OnPasswdInputListener() { // from class: com.tenpay.fingerpay.c
            @Override // com.tenpay.sdk.view.OnPasswdInputListener
            public final void onTextChange() {
                FingerPaySettingAuthFragment.onViewCreated$lambda$3(FingerPaySettingAuthFragment.this);
            }
        });
        SixPasswdDialogEditText sixPasswdDialogEditText3 = this.sixPasswdEdit;
        if (sixPasswdDialogEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            sixPasswdDialogEditText3 = null;
        }
        sixPasswdDialogEditText3.setOnClickListener(this);
        View findViewById3 = view.findViewById(R.id.f8w);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.next_btn)");
        Button button = (Button) findViewById3;
        this.passNextBtn = button;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
            button = null;
        }
        button.setOnClickListener(this);
        Button button2 = this.passNextBtn;
        if (button2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
            button2 = null;
        }
        button2.setEnabled(false);
        View findViewById4 = view.findViewById(R.id.je9);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.tenpay_num_keyboard)");
        MyKeyboardWindow myKeyboardWindow = (MyKeyboardWindow) findViewById4;
        this.keyboardWindow = myKeyboardWindow;
        if (myKeyboardWindow == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardWindow");
            myKeyboardWindow = null;
        }
        SixPasswdDialogEditText sixPasswdDialogEditText4 = this.sixPasswdEdit;
        if (sixPasswdDialogEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
            sixPasswdDialogEditText4 = null;
        }
        myKeyboardWindow.setInputEditText(sixPasswdDialogEditText4);
        MyKeyboardWindow myKeyboardWindow2 = this.keyboardWindow;
        if (myKeyboardWindow2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyboardWindow");
            myKeyboardWindow2 = null;
        }
        myKeyboardWindow2.setXMode(0);
        Integer passFlag = getSettingViewModel().getPassFlag();
        if (passFlag != null && 2 == passFlag.intValue()) {
            MyKeyboardWindow myKeyboardWindow3 = this.keyboardWindow;
            if (myKeyboardWindow3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyboardWindow");
                myKeyboardWindow3 = null;
            }
            myKeyboardWindow3.setVisibility(0);
            EditText editText3 = this.normalPasswdEdit;
            if (editText3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
                editText3 = null;
            }
            editText3.setVisibility(8);
            SixPasswdDialogEditText sixPasswdDialogEditText5 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
                sixPasswdDialogEditText5 = null;
            }
            sixPasswdDialogEditText5.setVisibility(0);
            SixPasswdDialogEditText sixPasswdDialogEditText6 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
                sixPasswdDialogEditText6 = null;
            }
            sixPasswdDialogEditText6.setInputText("");
            SixPasswdDialogEditText sixPasswdDialogEditText7 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
                sixPasswdDialogEditText7 = null;
            }
            sixPasswdDialogEditText7.requestFocus();
            SixPasswdDialogEditText sixPasswdDialogEditText8 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
                sixPasswdDialogEditText8 = null;
            }
            sixPasswdDialogEditText8.performClick();
            Button button3 = this.passNextBtn;
            if (button3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("passNextBtn");
                button3 = null;
            }
            button3.setVisibility(8);
        } else {
            MyKeyboardWindow myKeyboardWindow4 = this.keyboardWindow;
            if (myKeyboardWindow4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("keyboardWindow");
                myKeyboardWindow4 = null;
            }
            myKeyboardWindow4.setVisibility(8);
            EditText editText4 = this.normalPasswdEdit;
            if (editText4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
                editText4 = null;
            }
            editText4.setVisibility(0);
            SixPasswdDialogEditText sixPasswdDialogEditText9 = this.sixPasswdEdit;
            if (sixPasswdDialogEditText9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sixPasswdEdit");
                sixPasswdDialogEditText9 = null;
            }
            sixPasswdDialogEditText9.setVisibility(8);
            EditText editText5 = this.normalPasswdEdit;
            if (editText5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
                editText5 = null;
            }
            editText5.setText("");
            EditText editText6 = this.normalPasswdEdit;
            if (editText6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
                editText6 = null;
            }
            editText6.requestFocus();
            Handler handler = this.mHandler;
            EditText editText7 = this.normalPasswdEdit;
            if (editText7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("normalPasswdEdit");
                editText7 = null;
            }
            Utils.touchEditText(handler, editText7);
        }
        View findViewById5 = view.findViewById(R.id.ivTitleName);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.ivTitleName)");
        TextView textView2 = (TextView) findViewById5;
        this.title = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
        } else {
            textView = textView2;
        }
        textView.setText(R.string.ect);
        QLog.i(((NetBaseActivity) this).TAG, 1, "mPassFlag=" + getSettingViewModel().getPassFlag());
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
