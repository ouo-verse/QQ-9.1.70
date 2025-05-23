package com.tenpay.sdk.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.gamematrix.gmcg.webrtc.WebRTCSDK;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tenpay.QwLog;
import com.tenpay.api.TTSUtil;
import com.tenpay.sdk.view.ClearableEditText;
import java.math.BigDecimal;

/* compiled from: P */
/* loaded from: classes27.dex */
public class QrcodeSettingActivity extends NetBaseActivity implements View.OnClickListener, ClearableEditText.OnTextChangedListener {
    public static int MAX_ACCOUNT_LIMIT_FEN = 3000000;
    public static int REQUEST_CODE = 101;
    public static int RESULT_CODE = 102;
    private Button mAmountCommitBtn;
    private ClearableEditText mAmountText;
    private ImageButton mCloseSettingBtn;
    private ClearableEditText mDescribeText;
    private OnButtonClickListener mListner;
    private long mMaxAccount = 0;
    private LinearLayout mSetAmountLayout;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface OnButtonClickListener {
        void onCancel();

        void onConfirm(String str, String str2);
    }

    private void hideSoftKeyboard(View view) {
        InputMethodManager inputMethodManager;
        if (view != null && getContext() != null && (inputMethodManager = (InputMethodManager) getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD)) != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void init(View view) {
        this.mSetAmountLayout = (LinearLayout) view.findViewById(R.id.jer);
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.jdk);
        this.mCloseSettingBtn = imageButton;
        imageButton.setOnClickListener(this);
        Button button = (Button) view.findViewById(R.id.f164310rs);
        this.mAmountCommitBtn = button;
        button.setOnClickListener(this);
        this.mAmountCommitBtn.setEnabled(false);
        ClearableEditText clearableEditText = (ClearableEditText) view.findViewById(R.id.f164308rq);
        this.mAmountText = clearableEditText;
        clearableEditText.setOnTextChangedListener(this);
        ClearableEditText clearableEditText2 = (ClearableEditText) view.findViewById(R.id.f164307rp);
        this.mDescribeText = clearableEditText2;
        TTSUtil.setViewContentDescription(clearableEditText2, "\u6536\u6b3e\u8bf4\u660e\uff08\u53ef\u9009\u586b\uff09\u7f16\u8f91\u6846");
        this.mDescribeText.setOnTextChangedListener(this);
        long longExtra = getIntent().getLongExtra("amount", MAX_ACCOUNT_LIMIT_FEN);
        this.mMaxAccount = longExtra;
        long j3 = longExtra / 100;
        int length = String.valueOf(j3).length() + 3;
        if (length > 0) {
            this.mAmountText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(length)});
        }
        String format = String.format(getContext().getString(R.string.ees), Long.valueOf(j3));
        this.mAmountText.setHint(format);
        TTSUtil.setViewContentDescription(this.mAmountText, format + "\u7f16\u8f91\u6846");
        showSoftKeyboard();
        ol2.b.g(view.findViewById(R.id.f164311rt));
        ol2.b.g(this.mAmountText);
    }

    private void showSoftKeyboard() {
        if (getContext() == null) {
            return;
        }
        this.mAmountText.requestFocus();
        this.mAmountText.sendAccessibilityEvent(8);
        new Handler().postDelayed(new Runnable() { // from class: com.tenpay.sdk.activity.QrcodeSettingActivity.1
            @Override // java.lang.Runnable
            public void run() {
                InputMethodManager inputMethodManager = (InputMethodManager) QrcodeSettingActivity.this.getContext().getSystemService(WebRTCSDK.PRIVILEGE_INPUT_METHOD);
                if (inputMethodManager != null) {
                    inputMethodManager.toggleSoftInput(0, 2);
                }
            }
        }, 150L);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    public /* bridge */ /* synthetic */ ViewModel getViewModel(ViewModelStoreOwner viewModelStoreOwner, String str, @NonNull Class cls) {
        return ne0.a.a(this, viewModelStoreOwner, str, cls);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.jdk) {
            Intent intent = new Intent();
            intent.putExtra("isCancel", true);
            setResult(-1, intent);
            finish();
        } else if (id5 == R.id.f164310rs) {
            String obj = this.mAmountText.getText().toString();
            String obj2 = this.mDescribeText.getText().toString();
            Intent intent2 = new Intent();
            intent2.putExtra("amount", obj);
            intent2.putExtra("desc", obj2);
            intent2.putExtra("isCancel", false);
            setResult(-1, intent2);
            finish();
        }
        hideSoftKeyboard(this.mAmountText);
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(@NonNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.f168590ag4, viewGroup, false);
        ol2.b.a(inflate, 22, true);
        init(inflate);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @Deprecated
    public /* bridge */ /* synthetic */ void onPartTimeCostReport(String str, String str2, long j3) {
        ne0.a.e(this, str, str2, j3);
    }

    @Override // com.tenpay.sdk.view.ClearableEditText.OnTextChangedListener
    public void onTextChanged() {
        String obj = this.mAmountText.getText().toString();
        if (!TextUtils.isEmpty(obj) && !obj.startsWith(".") && !obj.endsWith(".")) {
            this.mAmountText.sendAccessibilityEvent(16);
            try {
                double doubleValue = new BigDecimal(obj).doubleValue();
                QwLog.i("input amount" + doubleValue);
                QwLog.i("mMaxAmount(\u5206)" + this.mMaxAccount);
                double d16 = 100.0d * doubleValue;
                long j3 = this.mMaxAccount;
                if (d16 > j3 && j3 > 0) {
                    String format = String.format("%6.2f", Float.valueOf(((float) j3) / 100.0f));
                    QwLog.i("more than max =" + format);
                    this.mAmountText.setText(format);
                    this.mAmountText.setSelection(format.length());
                    return;
                }
                if (doubleValue == 0.0d) {
                    this.mAmountCommitBtn.setEnabled(false);
                    return;
                }
                int length = obj.length();
                int indexOf = obj.indexOf(".");
                if (indexOf != -1 && (length - indexOf) - 1 > 2) {
                    this.mAmountCommitBtn.setEnabled(false);
                    return;
                } else {
                    this.mAmountCommitBtn.setEnabled(true);
                    return;
                }
            } catch (Exception e16) {
                QLog.e(((NetBaseActivity) this).TAG, 1, "", e16);
                return;
            }
        }
        this.mAmountCommitBtn.setEnabled(false);
    }

    @Override // com.tenpay.sdk.activity.NetBaseActivity, com.tenpay.sdk.activity.TenpayUtilActivity, com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public /* bridge */ /* synthetic */ void onUserLeaveHint() {
        com.tencent.biz.richframework.compat.f.m(this);
    }

    public void setMaxAmount(long j3) {
        this.mMaxAccount = j3;
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
